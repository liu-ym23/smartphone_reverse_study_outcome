package io.requery.android.database.sqlite;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Printer;
import androidx.collection.l;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;
import io.requery.android.database.sqlite.SQLiteDebug;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;
import x0.d;

/* loaded from: classes4.dex */
public final class SQLiteConnection implements d.a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final String TAG = "SQLiteConnection";
    private int mCancellationSignalAttachCount;
    private final CloseGuard mCloseGuard;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final int mConnectionId;
    private long mConnectionPtr;
    private final boolean mIsPrimaryConnection;
    private final boolean mIsReadOnlyConnection;
    private boolean mOnlyAllowReadOnlyOperations;
    private final SQLiteConnectionPool mPool;
    private final PreparedStatementCache mPreparedStatementCache;
    private PreparedStatement mPreparedStatementPool;
    private final OperationLog mRecentOperations;
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final Pattern TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");

    public static final class Operation {

        @SuppressLint({"SimpleDateFormat"})
        private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        public ArrayList<Object> mBindArgs;
        public int mCookie;
        public long mEndTime;
        public Exception mException;
        public boolean mFinished;
        public String mKind;
        public String mSql;
        public long mStartTime;

        private Operation() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getFormattedStartTime() {
            return sDateFormat.format(new Date(this.mStartTime));
        }

        private String getStatus() {
            return !this.mFinished ? "running" : this.mException != null ? "failed" : "succeeded";
        }

        public void describe(StringBuilder sb2, boolean z10) {
            ArrayList<Object> arrayList;
            sb2.append(this.mKind);
            if (this.mFinished) {
                sb2.append(" took ");
                sb2.append(this.mEndTime - this.mStartTime);
                sb2.append(Const.SP_KEY_GSM_UPLOAD_MXSIZE);
            } else {
                sb2.append(" started ");
                sb2.append(System.currentTimeMillis() - this.mStartTime);
                sb2.append("ms ago");
            }
            sb2.append(" - ");
            sb2.append(getStatus());
            if (this.mSql != null) {
                sb2.append(", sql=\"");
                sb2.append(SQLiteConnection.trimSqlForDisplay(this.mSql));
                sb2.append("\"");
            }
            if (z10 && (arrayList = this.mBindArgs) != null && arrayList.size() != 0) {
                sb2.append(", bindArgs=[");
                int size = this.mBindArgs.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj = this.mBindArgs.get(i10);
                    if (i10 != 0) {
                        sb2.append(", ");
                    }
                    if (obj == null) {
                        sb2.append("null");
                    } else if (obj instanceof byte[]) {
                        sb2.append("<byte[]>");
                    } else if (obj instanceof String) {
                        sb2.append("\"");
                        sb2.append((String) obj);
                        sb2.append("\"");
                    } else {
                        sb2.append(obj);
                    }
                }
                sb2.append("]");
            }
            if (this.mException != null) {
                sb2.append(", exception=\"");
                sb2.append(this.mException.getMessage());
                sb2.append("\"");
            }
        }
    }

    public static final class OperationLog {
        private static final int COOKIE_GENERATION_SHIFT = 8;
        private static final int COOKIE_INDEX_MASK = 255;
        private static final int MAX_RECENT_OPERATIONS = 20;
        private int mGeneration;
        private int mIndex;
        private final Operation[] mOperations;

        private OperationLog() {
            this.mOperations = new Operation[20];
        }

        private boolean endOperationDeferLogLocked(int i10) {
            Operation operationLocked = getOperationLocked(i10);
            if (operationLocked != null) {
                operationLocked.mEndTime = System.currentTimeMillis();
                operationLocked.mFinished = true;
            }
            return false;
        }

        private Operation getOperationLocked(int i10) {
            Operation operation = this.mOperations[i10 & COOKIE_INDEX_MASK];
            if (operation.mCookie == i10) {
                return operation;
            }
            return null;
        }

        private void logOperationLocked(int i10, String str) {
            Operation operationLocked = getOperationLocked(i10);
            if (operationLocked == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            operationLocked.describe(sb2, false);
            if (str != null) {
                sb2.append(", ");
                sb2.append(str);
            }
            Log.d(SQLiteConnection.TAG, sb2.toString());
        }

        private int newOperationCookieLocked(int i10) {
            int i11 = this.mGeneration;
            this.mGeneration = i11 + 1;
            return (i11 << 8) | i10;
        }

        public int beginOperation(String str, String str2, Object[] objArr) {
            int iNewOperationCookieLocked;
            synchronized (this.mOperations) {
                try {
                    int i10 = (this.mIndex + 1) % 20;
                    Operation operation = this.mOperations[i10];
                    if (operation == null) {
                        operation = new Operation();
                        this.mOperations[i10] = operation;
                    } else {
                        operation.mFinished = false;
                        operation.mException = null;
                        ArrayList<Object> arrayList = operation.mBindArgs;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                    operation.mStartTime = System.currentTimeMillis();
                    operation.mKind = str;
                    operation.mSql = str2;
                    if (objArr != null) {
                        ArrayList<Object> arrayList2 = operation.mBindArgs;
                        if (arrayList2 == null) {
                            operation.mBindArgs = new ArrayList<>();
                        } else {
                            arrayList2.clear();
                        }
                        for (Object obj : objArr) {
                            if (obj == null || !(obj instanceof byte[])) {
                                operation.mBindArgs.add(obj);
                            } else {
                                operation.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
                            }
                        }
                    }
                    iNewOperationCookieLocked = newOperationCookieLocked(i10);
                    operation.mCookie = iNewOperationCookieLocked;
                    this.mIndex = i10;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return iNewOperationCookieLocked;
        }

        public String describeCurrentOperation() {
            synchronized (this.mOperations) {
                try {
                    Operation operation = this.mOperations[this.mIndex];
                    if (operation == null || operation.mFinished) {
                        return null;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    operation.describe(sb2, false);
                    return sb2.toString();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void dump(Printer printer, boolean z10) {
            synchronized (this.mOperations) {
                try {
                    printer.println("  Most recently executed operations:");
                    int i10 = this.mIndex;
                    Operation operation = this.mOperations[i10];
                    if (operation != null) {
                        int i11 = 0;
                        do {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("    ");
                            sb2.append(i11);
                            sb2.append(": [");
                            sb2.append(operation.getFormattedStartTime());
                            sb2.append("] ");
                            operation.describe(sb2, z10);
                            printer.println(sb2.toString());
                            i10 = i10 > 0 ? i10 - 1 : 19;
                            i11++;
                            operation = this.mOperations[i10];
                            if (operation == null) {
                                break;
                            }
                        } while (i11 < 20);
                    } else {
                        printer.println("    <none>");
                    }
                } finally {
                }
            }
        }

        public void endOperation(int i10) {
            synchronized (this.mOperations) {
                try {
                    if (endOperationDeferLogLocked(i10)) {
                        logOperationLocked(i10, null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean endOperationDeferLog(int i10) {
            boolean zEndOperationDeferLogLocked;
            synchronized (this.mOperations) {
                zEndOperationDeferLogLocked = endOperationDeferLogLocked(i10);
            }
            return zEndOperationDeferLogLocked;
        }

        public void failOperation(int i10, Exception exc) {
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i10);
                    if (operationLocked != null) {
                        operationLocked.mException = exc;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void logOperation(int i10, String str) {
            synchronized (this.mOperations) {
                logOperationLocked(i10, str);
            }
        }
    }

    public static final class PreparedStatement {
        public boolean mInCache;
        public boolean mInUse;
        public int mNumParameters;
        public PreparedStatement mPoolNext;
        public boolean mReadOnly;
        public String mSql;
        public long mStatementPtr;
        public int mType;

        private PreparedStatement() {
        }
    }

    public final class PreparedStatementCache extends l<String, PreparedStatement> {
        public PreparedStatementCache(int i10) {
            super(i10);
        }

        public void dump(Printer printer) {
            printer.println("  Prepared statement cache:");
            Map<String, PreparedStatement> mapSnapshot = snapshot();
            if (mapSnapshot.isEmpty()) {
                printer.println("    <none>");
                return;
            }
            int i10 = 0;
            for (Map.Entry<String, PreparedStatement> entry : mapSnapshot.entrySet()) {
                PreparedStatement value = entry.getValue();
                if (value.mInCache) {
                    printer.println("    " + i10 + ": statementPtr=0x" + Long.toHexString(value.mStatementPtr) + ", numParameters=" + value.mNumParameters + ", type=" + value.mType + ", readOnly=" + value.mReadOnly + ", sql=\"" + SQLiteConnection.trimSqlForDisplay(entry.getKey()) + "\"");
                }
                i10++;
            }
        }

        @Override // androidx.collection.l
        public void entryRemoved(boolean z10, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            preparedStatement.mInCache = false;
            if (preparedStatement.mInUse) {
                return;
            }
            SQLiteConnection.this.finalizePreparedStatement(preparedStatement);
        }
    }

    private SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i10, boolean z10) {
        CloseGuard closeGuard = CloseGuard.get();
        this.mCloseGuard = closeGuard;
        this.mRecentOperations = new OperationLog();
        this.mPool = sQLiteConnectionPool;
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        this.mConfiguration = sQLiteDatabaseConfiguration2;
        this.mConnectionId = i10;
        this.mIsPrimaryConnection = z10;
        this.mIsReadOnlyConnection = (sQLiteDatabaseConfiguration.openFlags & 1) != 0;
        this.mPreparedStatementCache = new PreparedStatementCache(sQLiteDatabaseConfiguration2.maxSqlCacheSize);
        closeGuard.open("close");
    }

    private PreparedStatement acquirePreparedStatement(String str) {
        boolean z10;
        SQLiteConnection sQLiteConnection;
        int iNativeGetParameterCount;
        int sqlStatementType;
        PreparedStatement preparedStatementObtainPreparedStatement = this.mPreparedStatementCache.get(str);
        if (preparedStatementObtainPreparedStatement == null) {
            z10 = false;
        } else {
            if (!preparedStatementObtainPreparedStatement.mInUse) {
                return preparedStatementObtainPreparedStatement;
            }
            z10 = true;
        }
        long jNativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
        try {
            iNativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, jNativePrepareStatement);
            sqlStatementType = SQLiteStatementType.getSqlStatementType(str);
            sQLiteConnection = this;
        } catch (RuntimeException e10) {
            e = e10;
            sQLiteConnection = this;
        }
        try {
            preparedStatementObtainPreparedStatement = sQLiteConnection.obtainPreparedStatement(str, jNativePrepareStatement, iNativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, jNativePrepareStatement));
            if (!z10 && isCacheable(sqlStatementType)) {
                sQLiteConnection.mPreparedStatementCache.put(str, preparedStatementObtainPreparedStatement);
                preparedStatementObtainPreparedStatement.mInCache = true;
            }
            preparedStatementObtainPreparedStatement.mInUse = true;
            return preparedStatementObtainPreparedStatement;
        } catch (RuntimeException e11) {
            e = e11;
            RuntimeException runtimeException = e;
            if (preparedStatementObtainPreparedStatement != null && preparedStatementObtainPreparedStatement.mInCache) {
                throw runtimeException;
            }
            nativeFinalizeStatement(sQLiteConnection.mConnectionPtr, jNativePrepareStatement);
            throw runtimeException;
        }
    }

    private void applyBlockGuardPolicy(PreparedStatement preparedStatement) {
        if (!this.mConfiguration.isInMemoryDb() && SQLiteDebug.DEBUG_SQL_LOG && Looper.myLooper() == Looper.getMainLooper()) {
            if (preparedStatement.mReadOnly) {
                Log.w(TAG, "Reading from disk on main thread");
            } else {
                Log.w(TAG, "Writing to disk on main thread");
            }
        }
    }

    private void attachCancellationSignal(d dVar) {
        if (dVar != null) {
            dVar.d();
            int i10 = this.mCancellationSignalAttachCount + 1;
            this.mCancellationSignalAttachCount = i10;
            if (i10 == 1) {
                nativeResetCancel(this.mConnectionPtr, true);
                dVar.c(this);
            }
        }
    }

    private void bindArguments(PreparedStatement preparedStatement, Object[] objArr) {
        int length = objArr != null ? objArr.length : 0;
        if (length != preparedStatement.mNumParameters) {
            throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + preparedStatement.mNumParameters + " bind arguments but " + length + " were provided.");
        }
        if (length == 0) {
            return;
        }
        long j10 = preparedStatement.mStatementPtr;
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = objArr[i10];
            int typeOfObject = getTypeOfObject(obj);
            if (typeOfObject == 0) {
                nativeBindNull(this.mConnectionPtr, j10, i10 + 1);
            } else if (typeOfObject == 1) {
                nativeBindLong(this.mConnectionPtr, j10, i10 + 1, ((Number) obj).longValue());
            } else if (typeOfObject == 2) {
                nativeBindDouble(this.mConnectionPtr, j10, i10 + 1, ((Number) obj).doubleValue());
            } else if (typeOfObject == 4) {
                nativeBindBlob(this.mConnectionPtr, j10, i10 + 1, (byte[]) obj);
            } else if (obj instanceof Boolean) {
                nativeBindLong(this.mConnectionPtr, j10, i10 + 1, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else {
                nativeBindString(this.mConnectionPtr, j10, i10 + 1, obj.toString());
            }
        }
    }

    private static String canonicalizeSyncMode(String str) {
        str.getClass();
        switch (str) {
            case "0":
                return "OFF";
            case "1":
                return "NORMAL";
            case "2":
                return "FULL";
            default:
                return str;
        }
    }

    @SuppressLint({"Assert"})
    private void detachCancellationSignal(d dVar) {
        if (dVar != null) {
            int i10 = this.mCancellationSignalAttachCount - 1;
            this.mCancellationSignalAttachCount = i10;
            if (i10 == 0) {
                dVar.c(null);
                nativeResetCancel(this.mConnectionPtr, false);
            }
        }
    }

    private void dispose(boolean z10) {
        CloseGuard closeGuard = this.mCloseGuard;
        if (closeGuard != null) {
            if (z10) {
                closeGuard.warnIfOpen();
            }
            this.mCloseGuard.close();
        }
        if (this.mConnectionPtr != 0) {
            int iBeginOperation = this.mRecentOperations.beginOperation("close", null, null);
            try {
                this.mPreparedStatementCache.evictAll();
                nativeClose(this.mConnectionPtr);
                this.mConnectionPtr = 0L;
            } finally {
                this.mRecentOperations.endOperation(iBeginOperation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finalizePreparedStatement(PreparedStatement preparedStatement) {
        nativeFinalizeStatement(this.mConnectionPtr, preparedStatement.mStatementPtr);
        recyclePreparedStatement(preparedStatement);
    }

    private SQLiteDebug.DbStats getMainDbStatsUnsafe(int i10, long j10, long j11) {
        String str = this.mConfiguration.path;
        if (!this.mIsPrimaryConnection) {
            str = str + " (" + this.mConnectionId + ")";
        }
        return new SQLiteDebug.DbStats(str, j10, j11, i10, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
    }

    @TargetApi(11)
    private static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        return ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) ? 1 : 3;
    }

    public static boolean hasCodec() {
        return nativeHasCodec();
    }

    private static boolean isCacheable(int i10) {
        return i10 == 2 || i10 == 1;
    }

    private static native void nativeBindBlob(long j10, long j11, int i10, byte[] bArr);

    private static native void nativeBindDouble(long j10, long j11, int i10, double d10);

    private static native void nativeBindLong(long j10, long j11, int i10, long j12);

    private static native void nativeBindNull(long j10, long j11, int i10);

    private static native void nativeBindString(long j10, long j11, int i10, String str);

    private static native void nativeCancel(long j10);

    private static native void nativeClose(long j10);

    private static native void nativeExecute(long j10, long j11);

    private static native int nativeExecuteForBlobFileDescriptor(long j10, long j11);

    private static native int nativeExecuteForChangedRowCount(long j10, long j11);

    private static native long nativeExecuteForCursorWindow(long j10, long j11, long j12, int i10, int i11, boolean z10);

    private static native long nativeExecuteForLastInsertedRowId(long j10, long j11);

    private static native long nativeExecuteForLong(long j10, long j11);

    private static native String nativeExecuteForString(long j10, long j11);

    private static native void nativeFinalizeStatement(long j10, long j11);

    private static native int nativeGetColumnCount(long j10, long j11);

    private static native String nativeGetColumnName(long j10, long j11, int i10);

    private static native int nativeGetDbLookaside(long j10);

    private static native int nativeGetParameterCount(long j10, long j11);

    private static native boolean nativeHasCodec();

    private static native boolean nativeIsReadOnly(long j10, long j11);

    private static native void nativeLoadExtension(long j10, String str, String str2);

    private static native long nativeOpen(String str, int i10, String str2, boolean z10, boolean z11);

    private static native long nativePrepareStatement(long j10, String str);

    private static native void nativeRegisterCustomFunction(long j10, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterFunction(long j10, SQLiteFunction sQLiteFunction);

    private static native void nativeRegisterLocalizedCollators(long j10, String str);

    private static native void nativeResetCancel(long j10, boolean z10);

    private static native void nativeResetStatementAndClearBindings(long j10, long j11);

    private PreparedStatement obtainPreparedStatement(String str, long j10, int i10, int i11, boolean z10) {
        PreparedStatement preparedStatement = this.mPreparedStatementPool;
        if (preparedStatement != null) {
            this.mPreparedStatementPool = preparedStatement.mPoolNext;
            preparedStatement.mPoolNext = null;
            preparedStatement.mInCache = false;
        } else {
            preparedStatement = new PreparedStatement();
        }
        preparedStatement.mSql = str;
        preparedStatement.mStatementPtr = j10;
        preparedStatement.mNumParameters = i10;
        preparedStatement.mType = i11;
        preparedStatement.mReadOnly = z10;
        return preparedStatement;
    }

    public static SQLiteConnection open(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i10, boolean z10) {
        SQLiteConnection sQLiteConnection = new SQLiteConnection(sQLiteConnectionPool, sQLiteDatabaseConfiguration, i10, z10);
        try {
            sQLiteConnection.open();
            return sQLiteConnection;
        } catch (SQLiteException e10) {
            sQLiteConnection.dispose(false);
            throw e10;
        }
    }

    private void recyclePreparedStatement(PreparedStatement preparedStatement) {
        preparedStatement.mSql = null;
        preparedStatement.mPoolNext = this.mPreparedStatementPool;
        this.mPreparedStatementPool = preparedStatement;
    }

    private void releasePreparedStatement(PreparedStatement preparedStatement) {
        preparedStatement.mInUse = false;
        if (!preparedStatement.mInCache) {
            finalizePreparedStatement(preparedStatement);
            return;
        }
        try {
            nativeResetStatementAndClearBindings(this.mConnectionPtr, preparedStatement.mStatementPtr);
        } catch (SQLiteException unused) {
            this.mPreparedStatementCache.remove(preparedStatement.mSql);
        }
    }

    private void setAutoCheckpointInterval() {
        if (this.mConfiguration.isInMemoryDb() || this.mIsReadOnlyConnection) {
            return;
        }
        long wALAutoCheckpoint = SQLiteGlobal.getWALAutoCheckpoint();
        if (executeForLong("PRAGMA wal_autocheckpoint", null, null) != wALAutoCheckpoint) {
            executeForLong("PRAGMA wal_autocheckpoint=" + wALAutoCheckpoint, null, null);
        }
    }

    private void setForeignKeyModeFromConfiguration() {
        if (this.mIsReadOnlyConnection) {
            return;
        }
        long j10 = this.mConfiguration.foreignKeyConstraintsEnabled ? 1L : 0L;
        if (executeForLong("PRAGMA foreign_keys", null, null) != j10) {
            execute("PRAGMA foreign_keys=" + j10, null, null);
        }
    }

    private void setJournalMode(String str) {
        String strExecuteForString = executeForString("PRAGMA journal_mode", null, null);
        if (strExecuteForString.equalsIgnoreCase(str)) {
            return;
        }
        try {
            if (executeForString("PRAGMA journal_mode=" + str, null, null).equalsIgnoreCase(str)) {
                return;
            }
        } catch (SQLiteException e10) {
            if (!(e10 instanceof SQLiteDatabaseLockedException)) {
                throw e10;
            }
        }
        Log.w(TAG, "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + strExecuteForString + "' to '" + str + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
    }

    private void setJournalSizeLimit() {
        if (this.mConfiguration.isInMemoryDb() || this.mIsReadOnlyConnection) {
            return;
        }
        long journalSizeLimit = SQLiteGlobal.getJournalSizeLimit();
        if (executeForLong("PRAGMA journal_size_limit", null, null) != journalSizeLimit) {
            executeForLong("PRAGMA journal_size_limit=" + journalSizeLimit, null, null);
        }
    }

    private void setLocaleFromConfiguration() {
        String string = this.mConfiguration.locale.toString();
        nativeRegisterLocalizedCollators(this.mConnectionPtr, string);
        if (this.mIsReadOnlyConnection) {
            return;
        }
        try {
            execute("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);
            String strExecuteForString = executeForString("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null, null);
            if (strExecuteForString == null || !strExecuteForString.equals(string)) {
                execute("BEGIN", null, null);
                try {
                    execute("DELETE FROM android_metadata", null, null);
                    execute("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{string}, null);
                    execute("REINDEX LOCALIZED", null, null);
                    execute("COMMIT", null, null);
                } catch (Throwable th) {
                    execute("ROLLBACK", null, null);
                    throw th;
                }
            }
        } catch (RuntimeException unused) {
            throw new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + string + "'.");
        }
    }

    private void setPageSize() {
        if (this.mConfiguration.isInMemoryDb() || this.mIsReadOnlyConnection) {
            return;
        }
        long defaultPageSize = SQLiteGlobal.getDefaultPageSize();
        if (executeForLong("PRAGMA page_size", null, null) != defaultPageSize) {
            execute("PRAGMA page_size=" + defaultPageSize, null, null);
        }
    }

    private void setSyncMode(String str) {
        if (canonicalizeSyncMode(executeForString("PRAGMA synchronous", null, null)).equalsIgnoreCase(canonicalizeSyncMode(str))) {
            return;
        }
        execute("PRAGMA synchronous=" + str, null, null);
    }

    private void setWalModeFromConfiguration() {
        if (this.mConfiguration.isInMemoryDb() || this.mIsReadOnlyConnection) {
            return;
        }
        if ((this.mConfiguration.openFlags & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
            setJournalMode("WAL");
            setSyncMode(SQLiteGlobal.getWALSyncMode());
        } else {
            setJournalMode(SQLiteGlobal.getDefaultJournalMode());
            setSyncMode(SQLiteGlobal.getDefaultSyncMode());
        }
    }

    private void throwIfStatementForbidden(PreparedStatement preparedStatement) {
        if (this.mOnlyAllowReadOnlyOperations && !preparedStatement.mReadOnly) {
            throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String trimSqlForDisplay(String str) {
        return TRIM_SQL_PATTERN.matcher(str).replaceAll(" ");
    }

    public void close() {
        dispose(false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:41|4)|33|9|(12:12|37|13|35|14|15|16|21|(1:23)|24|25|10)|43|26|29) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0040 A[Catch: all -> 0x007d, SQLiteException -> 0x00c3, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x00c3, blocks: (B:9:0x002c, B:10:0x003a, B:12:0x0040, B:21:0x0083, B:23:0x009a, B:24:0x00ae), top: B:33:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a A[Catch: all -> 0x007d, SQLiteException -> 0x00c3, TryCatch #0 {SQLiteException -> 0x00c3, blocks: (B:9:0x002c, B:10:0x003a, B:12:0x0040, B:21:0x0083, B:23:0x009a, B:24:0x00ae), top: B:33:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void collectDbStats(java.util.ArrayList<io.requery.android.database.sqlite.SQLiteDebug.DbStats> r24) {
        /*
            r23 = this;
            r0 = r23
            r8 = r24
            java.lang.String r9 = "PRAGMA "
            long r1 = r0.mConnectionPtr
            int r1 = nativeGetDbLookaside(r1)
            r10 = 0
            r11 = 0
            java.lang.String r2 = "PRAGMA page_count;"
            long r2 = r0.executeForLong(r2, r10, r10)     // Catch: android.database.sqlite.SQLiteException -> L1c
            java.lang.String r4 = "PRAGMA page_size;"
            long r4 = r0.executeForLong(r4, r10, r10)     // Catch: android.database.sqlite.SQLiteException -> L1d
            goto L1e
        L1c:
            r2 = r11
        L1d:
            r4 = r11
        L1e:
            io.requery.android.database.sqlite.SQLiteDebug$DbStats r1 = r0.getMainDbStatsUnsafe(r1, r2, r4)
            r8.add(r1)
            io.requery.android.database.CursorWindow r3 = new io.requery.android.database.CursorWindow
            java.lang.String r0 = "collectDbStats"
            r3.<init>(r0)
            java.lang.String r1 = "PRAGMA database_list;"
            r6 = 0
            r7 = 0
            r2 = 0
            r4 = 0
            r5 = 0
            r0 = r23
            r0.executeForCursorWindow(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            r1 = 1
            r2 = r1
        L3a:
            int r4 = r3.getNumRows()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            if (r2 >= r4) goto Lc3
            java.lang.String r4 = r3.getString(r2, r1)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            r5 = 2
            java.lang.String r5 = r3.getString(r2, r5)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            r6.<init>()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            r6.append(r9)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            r6.append(r4)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            java.lang.String r7 = ".page_count;"
            r6.append(r7)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            long r6 = r0.executeForLong(r6, r10, r10)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L80
            r13.<init>()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L80
            r13.append(r9)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L80
            r13.append(r4)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L80
            java.lang.String r14 = ".page_size;"
            r13.append(r14)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L80
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L80
            long r13 = r0.executeForLong(r13, r10, r10)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L80
            r17 = r13
        L7b:
            r15 = r6
            goto L83
        L7d:
            r0 = move-exception
            goto Lc7
        L7f:
            r6 = r11
        L80:
            r17 = r11
            goto L7b
        L83:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            r6.<init>()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            java.lang.String r7 = "  (attached) "
            r6.append(r7)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            r6.append(r4)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            boolean r6 = r5.isEmpty()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            if (r6 != 0) goto Lae
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            r6.<init>()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            r6.append(r4)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            java.lang.String r4 = ": "
            r6.append(r4)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            r6.append(r5)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
        Lae:
            r14 = r4
            io.requery.android.database.sqlite.SQLiteDebug$DbStats r13 = new io.requery.android.database.sqlite.SQLiteDebug$DbStats     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            r21 = 0
            r22 = 0
            r19 = 0
            r20 = 0
            r13.<init>(r14, r15, r17, r19, r20, r21, r22)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            r8.add(r13)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> Lc3
            int r2 = r2 + 1
            goto L3a
        Lc3:
            r3.close()
            goto Lcb
        Lc7:
            r3.close()
            throw r0
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.requery.android.database.sqlite.SQLiteConnection.collectDbStats(java.util.ArrayList):void");
    }

    public void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> arrayList) {
        arrayList.add(getMainDbStatsUnsafe(0, 0L, 0L));
    }

    public String describeCurrentOperationUnsafe() {
        return this.mRecentOperations.describeCurrentOperation();
    }

    public void dump(Printer printer, boolean z10) {
        dumpUnsafe(printer, z10);
    }

    public void dumpUnsafe(Printer printer, boolean z10) {
        printer.println("Connection #" + this.mConnectionId + ServerSentEventKt.COLON);
        if (z10) {
            printer.println("  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
        }
        printer.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
        printer.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
        this.mRecentOperations.dump(printer, z10);
        if (z10) {
            this.mPreparedStatementCache.dump(printer);
        }
    }

    public void enableLocalizedCollators() {
        if (nativeHasCodec()) {
            setLocaleFromConfiguration();
        }
    }

    public void execute(String str, Object[] objArr, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        int iBeginOperation = this.mRecentOperations.beginOperation("execute", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementAcquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(preparedStatementAcquirePreparedStatement);
                    bindArguments(preparedStatementAcquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(preparedStatementAcquirePreparedStatement);
                    attachCancellationSignal(dVar);
                    try {
                        nativeExecute(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                    } finally {
                        detachCancellationSignal(dVar);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } catch (RuntimeException e10) {
                this.mRecentOperations.failOperation(iBeginOperation, e10);
                throw e10;
            }
        } finally {
            this.mRecentOperations.endOperation(iBeginOperation);
        }
    }

    public ParcelFileDescriptor executeForBlobFileDescriptor(String str, Object[] objArr, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        int iBeginOperation = this.mRecentOperations.beginOperation("executeForBlobFileDescriptor", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementAcquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(preparedStatementAcquirePreparedStatement);
                    bindArguments(preparedStatementAcquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(preparedStatementAcquirePreparedStatement);
                    attachCancellationSignal(dVar);
                    try {
                        int iNativeExecuteForBlobFileDescriptor = nativeExecuteForBlobFileDescriptor(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                        return iNativeExecuteForBlobFileDescriptor >= 0 ? ParcelFileDescriptor.adoptFd(iNativeExecuteForBlobFileDescriptor) : null;
                    } finally {
                        detachCancellationSignal(dVar);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } finally {
                this.mRecentOperations.endOperation(iBeginOperation);
            }
        } catch (RuntimeException e10) {
            this.mRecentOperations.failOperation(iBeginOperation, e10);
            throw e10;
        }
    }

    public int executeForChangedRowCount(String str, Object[] objArr, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        int iBeginOperation = this.mRecentOperations.beginOperation("executeForChangedRowCount", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementAcquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(preparedStatementAcquirePreparedStatement);
                    bindArguments(preparedStatementAcquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(preparedStatementAcquirePreparedStatement);
                    attachCancellationSignal(dVar);
                    try {
                        int iNativeExecuteForChangedRowCount = nativeExecuteForChangedRowCount(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                        if (this.mRecentOperations.endOperationDeferLog(iBeginOperation)) {
                            this.mRecentOperations.logOperation(iBeginOperation, "changedRows=" + iNativeExecuteForChangedRowCount);
                        }
                        return iNativeExecuteForChangedRowCount;
                    } finally {
                        detachCancellationSignal(dVar);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } catch (Throwable th) {
                if (this.mRecentOperations.endOperationDeferLog(iBeginOperation)) {
                    this.mRecentOperations.logOperation(iBeginOperation, "changedRows=0");
                }
                throw th;
            }
        } catch (RuntimeException e10) {
            this.mRecentOperations.failOperation(iBeginOperation, e10);
            throw e10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x015e A[Catch: all -> 0x00aa, TryCatch #4 {all -> 0x00aa, blocks: (B:6:0x001b, B:23:0x006d, B:25:0x0075, B:70:0x0156, B:72:0x015e, B:73:0x018a), top: B:88:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int executeForCursorWindow(java.lang.String r20, java.lang.Object[] r21, io.requery.android.database.CursorWindow r22, int r23, int r24, boolean r25, x0.d r26) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.requery.android.database.sqlite.SQLiteConnection.executeForCursorWindow(java.lang.String, java.lang.Object[], io.requery.android.database.CursorWindow, int, int, boolean, x0.d):int");
    }

    public long executeForLastInsertedRowId(String str, Object[] objArr, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        int iBeginOperation = this.mRecentOperations.beginOperation("executeForLastInsertedRowId", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementAcquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(preparedStatementAcquirePreparedStatement);
                    bindArguments(preparedStatementAcquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(preparedStatementAcquirePreparedStatement);
                    attachCancellationSignal(dVar);
                    try {
                        return nativeExecuteForLastInsertedRowId(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                    } finally {
                        detachCancellationSignal(dVar);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } catch (RuntimeException e10) {
                this.mRecentOperations.failOperation(iBeginOperation, e10);
                throw e10;
            }
        } finally {
            this.mRecentOperations.endOperation(iBeginOperation);
        }
    }

    public long executeForLong(String str, Object[] objArr, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        int iBeginOperation = this.mRecentOperations.beginOperation("executeForLong", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementAcquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(preparedStatementAcquirePreparedStatement);
                    bindArguments(preparedStatementAcquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(preparedStatementAcquirePreparedStatement);
                    attachCancellationSignal(dVar);
                    try {
                        return nativeExecuteForLong(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                    } finally {
                        detachCancellationSignal(dVar);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } catch (RuntimeException e10) {
                this.mRecentOperations.failOperation(iBeginOperation, e10);
                throw e10;
            }
        } finally {
            this.mRecentOperations.endOperation(iBeginOperation);
        }
    }

    public String executeForString(String str, Object[] objArr, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        int iBeginOperation = this.mRecentOperations.beginOperation("executeForString", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementAcquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(preparedStatementAcquirePreparedStatement);
                    bindArguments(preparedStatementAcquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(preparedStatementAcquirePreparedStatement);
                    attachCancellationSignal(dVar);
                    try {
                        return nativeExecuteForString(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                    } finally {
                        detachCancellationSignal(dVar);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } catch (RuntimeException e10) {
                this.mRecentOperations.failOperation(iBeginOperation, e10);
                throw e10;
            }
        } finally {
            this.mRecentOperations.endOperation(iBeginOperation);
        }
    }

    public void finalize() throws Throwable {
        try {
            SQLiteConnectionPool sQLiteConnectionPool = this.mPool;
            if (sQLiteConnectionPool != null && this.mConnectionPtr != 0) {
                sQLiteConnectionPool.onConnectionLeaked();
            }
            dispose(true);
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public boolean isPreparedStatementInCache(String str) {
        return this.mPreparedStatementCache.get(str) != null;
    }

    public boolean isPrimaryConnection() {
        return this.mIsPrimaryConnection;
    }

    @Override // x0.d.a
    public void onCancel() {
        nativeCancel(this.mConnectionPtr);
    }

    public void prepare(String str, SQLiteStatementInfo sQLiteStatementInfo) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        int iBeginOperation = this.mRecentOperations.beginOperation("prepare", str, null);
        try {
            try {
                PreparedStatement preparedStatementAcquirePreparedStatement = acquirePreparedStatement(str);
                if (sQLiteStatementInfo != null) {
                    try {
                        sQLiteStatementInfo.numParameters = preparedStatementAcquirePreparedStatement.mNumParameters;
                        sQLiteStatementInfo.readOnly = preparedStatementAcquirePreparedStatement.mReadOnly;
                        int iNativeGetColumnCount = nativeGetColumnCount(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                        if (iNativeGetColumnCount == 0) {
                            sQLiteStatementInfo.columnNames = EMPTY_STRING_ARRAY;
                        } else {
                            sQLiteStatementInfo.columnNames = new String[iNativeGetColumnCount];
                            for (int i10 = 0; i10 < iNativeGetColumnCount; i10++) {
                                sQLiteStatementInfo.columnNames[i10] = nativeGetColumnName(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr, i10);
                            }
                        }
                    } catch (Throwable th) {
                        releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                        throw th;
                    }
                }
                releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                this.mRecentOperations.endOperation(iBeginOperation);
            } catch (RuntimeException e10) {
                this.mRecentOperations.failOperation(iBeginOperation, e10);
                throw e10;
            }
        } catch (Throwable th2) {
            this.mRecentOperations.endOperation(iBeginOperation);
            throw th2;
        }
    }

    public void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        this.mOnlyAllowReadOnlyOperations = false;
        int size = sQLiteDatabaseConfiguration.customFunctions.size();
        for (int i10 = 0; i10 < size; i10++) {
            SQLiteCustomFunction sQLiteCustomFunction = sQLiteDatabaseConfiguration.customFunctions.get(i10);
            if (!this.mConfiguration.customFunctions.contains(sQLiteCustomFunction)) {
                nativeRegisterCustomFunction(this.mConnectionPtr, sQLiteCustomFunction);
            }
        }
        int size2 = sQLiteDatabaseConfiguration.functions.size();
        for (int i11 = 0; i11 < size2; i11++) {
            SQLiteFunction sQLiteFunction = sQLiteDatabaseConfiguration.functions.get(i11);
            if (!this.mConfiguration.functions.contains(sQLiteFunction)) {
                nativeRegisterFunction(this.mConnectionPtr, sQLiteFunction);
            }
        }
        boolean z10 = sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.mConfiguration;
        boolean z11 = z10 != sQLiteDatabaseConfiguration2.foreignKeyConstraintsEnabled;
        boolean z12 = ((sQLiteDatabaseConfiguration.openFlags ^ sQLiteDatabaseConfiguration2.openFlags) & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0;
        boolean zEquals = sQLiteDatabaseConfiguration.locale.equals(sQLiteDatabaseConfiguration2.locale);
        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
        if (z11) {
            setForeignKeyModeFromConfiguration();
        }
        if (z12) {
            setWalModeFromConfiguration();
        }
        if (zEquals) {
            return;
        }
        setLocaleFromConfiguration();
    }

    public void setOnlyAllowReadOnlyOperations(boolean z10) {
        this.mOnlyAllowReadOnlyOperations = z10;
    }

    public String toString() {
        return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
    }

    private void open() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfiguration;
        this.mConnectionPtr = nativeOpen(sQLiteDatabaseConfiguration.path, sQLiteDatabaseConfiguration.openFlags & (-536870913), sQLiteDatabaseConfiguration.label, SQLiteDebug.DEBUG_SQL_STATEMENTS, SQLiteDebug.DEBUG_SQL_TIME);
        setPageSize();
        setForeignKeyModeFromConfiguration();
        setJournalSizeLimit();
        setAutoCheckpointInterval();
        if (!nativeHasCodec()) {
            setWalModeFromConfiguration();
            setLocaleFromConfiguration();
        }
        int size = this.mConfiguration.customFunctions.size();
        for (int i10 = 0; i10 < size; i10++) {
            nativeRegisterCustomFunction(this.mConnectionPtr, this.mConfiguration.customFunctions.get(i10));
        }
        int size2 = this.mConfiguration.functions.size();
        for (int i11 = 0; i11 < size2; i11++) {
            nativeRegisterFunction(this.mConnectionPtr, this.mConfiguration.functions.get(i11));
        }
        for (SQLiteCustomExtension sQLiteCustomExtension : this.mConfiguration.customExtensions) {
            nativeLoadExtension(this.mConnectionPtr, sQLiteCustomExtension.path, sQLiteCustomExtension.entryPoint);
        }
    }
}
