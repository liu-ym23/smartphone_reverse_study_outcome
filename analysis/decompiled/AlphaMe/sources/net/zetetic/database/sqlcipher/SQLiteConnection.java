package net.zetetic.database.sqlcipher;

import B0.g;
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.LruCache;
import android.util.Printer;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import net.zetetic.database.CursorWindow;
import net.zetetic.database.DatabaseUtils;
import net.zetetic.database.Logger;
import net.zetetic.database.sqlcipher.SQLiteDebug;
import s.AbstractC0831a;

/* loaded from: classes2.dex */
public final class SQLiteConnection implements CancellationSignal.OnCancelListener {
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

    public static final class Operation {
        private static final int MAX_TRACE_METHOD_NAME_LEN = 256;
        public ArrayList<Object> mBindArgs;
        public int mCookie;
        public long mEndTime;
        public Exception mException;
        public boolean mFinished;
        public String mKind;
        public String mSql;
        public long mStartTime;
        public long mStartWallTime;

        private Operation() {
        }

        public /* synthetic */ Operation(int i4) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getFormattedStartTime() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(this.mStartWallTime));
        }

        private String getStatus() {
            return !this.mFinished ? "running" : this.mException != null ? "failed" : "succeeded";
        }

        private String getTraceMethodName() {
            String str = this.mKind + AwarenessDataItem.PERMISSION_SPLITTER + this.mSql;
            return str.length() > 256 ? str.substring(0, 256) : str;
        }

        public void describe(StringBuilder sb, boolean z4) {
            ArrayList<Object> arrayList;
            sb.append(this.mKind);
            if (this.mFinished) {
                sb.append(" took ");
                sb.append(this.mEndTime - this.mStartTime);
                sb.append("ms");
            } else {
                sb.append(" started ");
                sb.append(System.currentTimeMillis() - this.mStartWallTime);
                sb.append("ms ago");
            }
            sb.append(" - ");
            sb.append(getStatus());
            if (this.mSql != null) {
                sb.append(", sql=\"");
                sb.append(SQLiteConnection.trimSqlForDisplay(this.mSql));
                sb.append("\"");
            }
            if (z4 && (arrayList = this.mBindArgs) != null && arrayList.size() != 0) {
                sb.append(", bindArgs=[");
                int size = this.mBindArgs.size();
                for (int i4 = 0; i4 < size; i4++) {
                    Object obj = this.mBindArgs.get(i4);
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    if (obj == null) {
                        sb.append("null");
                    } else if (obj instanceof byte[]) {
                        sb.append("<byte[]>");
                    } else if (obj instanceof String) {
                        sb.append("\"");
                        sb.append((String) obj);
                        sb.append("\"");
                    } else {
                        sb.append(obj);
                    }
                }
                sb.append("]");
            }
            if (this.mException != null) {
                sb.append(", exception=\"");
                sb.append(this.mException.getMessage());
                sb.append("\"");
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

        public /* synthetic */ OperationLog(int i4) {
            this();
        }

        private boolean endOperationDeferLogLocked(int i4) {
            Operation operationLocked = getOperationLocked(i4);
            if (operationLocked != null) {
                operationLocked.mEndTime = SystemClock.uptimeMillis();
                operationLocked.mFinished = true;
            }
            return false;
        }

        private Operation getOperationLocked(int i4) {
            Operation operation = this.mOperations[i4 & 255];
            if (operation.mCookie == i4) {
                return operation;
            }
            return null;
        }

        private void logOperationLocked(int i4, String str) {
            Operation operationLocked = getOperationLocked(i4);
            StringBuilder sb = new StringBuilder();
            operationLocked.describe(sb, false);
            if (str != null) {
                sb.append(", ");
                sb.append(str);
            }
            Logger.d(SQLiteConnection.TAG, sb.toString());
        }

        private int newOperationCookieLocked(int i4) {
            int i5 = this.mGeneration;
            this.mGeneration = i5 + 1;
            return (i5 << 8) | i4;
        }

        public int beginOperation(String str, String str2, Object[] objArr) {
            int iNewOperationCookieLocked;
            synchronized (this.mOperations) {
                try {
                    int i4 = (this.mIndex + 1) % 20;
                    Operation operation = this.mOperations[i4];
                    int i5 = 0;
                    if (operation == null) {
                        operation = new Operation(i5);
                        this.mOperations[i4] = operation;
                    } else {
                        operation.mFinished = false;
                        operation.mException = null;
                        ArrayList<Object> arrayList = operation.mBindArgs;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                    operation.mStartWallTime = System.currentTimeMillis();
                    operation.mStartTime = SystemClock.uptimeMillis();
                    operation.mKind = str;
                    operation.mSql = str2;
                    if (objArr != null) {
                        ArrayList<Object> arrayList2 = operation.mBindArgs;
                        if (arrayList2 == null) {
                            operation.mBindArgs = new ArrayList<>();
                        } else {
                            arrayList2.clear();
                        }
                        while (i5 < objArr.length) {
                            Object obj = objArr[i5];
                            if (obj == null || !(obj instanceof byte[])) {
                                operation.mBindArgs.add(obj);
                            } else {
                                operation.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
                            }
                            i5++;
                        }
                    }
                    iNewOperationCookieLocked = newOperationCookieLocked(i4);
                    operation.mCookie = iNewOperationCookieLocked;
                    this.mIndex = i4;
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
                    StringBuilder sb = new StringBuilder();
                    operation.describe(sb, false);
                    return sb.toString();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void dump(Printer printer, boolean z4) {
            synchronized (this.mOperations) {
                try {
                    printer.println("  Most recently executed operations:");
                    int i4 = this.mIndex;
                    Operation operation = this.mOperations[i4];
                    if (operation != null) {
                        int i5 = 0;
                        do {
                            StringBuilder sb = new StringBuilder();
                            sb.append("    ");
                            sb.append(i5);
                            sb.append(": [");
                            sb.append(operation.getFormattedStartTime());
                            sb.append("] ");
                            operation.describe(sb, z4);
                            printer.println(sb.toString());
                            i4 = i4 > 0 ? i4 - 1 : 19;
                            i5++;
                            operation = this.mOperations[i4];
                            if (operation == null) {
                                break;
                            }
                        } while (i5 < 20);
                    } else {
                        printer.println("    <none>");
                    }
                } finally {
                }
            }
        }

        public void endOperation(int i4) {
            synchronized (this.mOperations) {
                try {
                    if (endOperationDeferLogLocked(i4)) {
                        logOperationLocked(i4, null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean endOperationDeferLog(int i4) {
            boolean zEndOperationDeferLogLocked;
            synchronized (this.mOperations) {
                zEndOperationDeferLogLocked = endOperationDeferLogLocked(i4);
            }
            return zEndOperationDeferLogLocked;
        }

        public void failOperation(int i4, Exception exc) {
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i4);
                    if (operationLocked != null) {
                        operationLocked.mException = exc;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void logOperation(int i4, String str) {
            synchronized (this.mOperations) {
                logOperationLocked(i4, str);
            }
        }

        private OperationLog() {
            this.mOperations = new Operation[20];
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

        public /* synthetic */ PreparedStatement(int i4) {
            this();
        }
    }

    public final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        public PreparedStatementCache(int i4) {
            super(i4);
        }

        public void dump(Printer printer) {
            printer.println("  Prepared statement cache:");
            Map<String, PreparedStatement> mapSnapshot = snapshot();
            if (mapSnapshot.isEmpty()) {
                printer.println("    <none>");
                return;
            }
            int i4 = 0;
            for (Map.Entry<String, PreparedStatement> entry : mapSnapshot.entrySet()) {
                PreparedStatement value = entry.getValue();
                if (value.mInCache) {
                    String key = entry.getKey();
                    StringBuilder sbT = g.t("    ", i4, ": statementPtr=0x");
                    sbT.append(Long.toHexString(value.mStatementPtr));
                    sbT.append(", numParameters=");
                    sbT.append(value.mNumParameters);
                    sbT.append(", type=");
                    sbT.append(value.mType);
                    sbT.append(", readOnly=");
                    sbT.append(value.mReadOnly);
                    sbT.append(", sql=\"");
                    sbT.append(SQLiteConnection.trimSqlForDisplay(key));
                    sbT.append("\"");
                    printer.println(sbT.toString());
                }
                i4++;
            }
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean z4, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            preparedStatement.mInCache = false;
            if (preparedStatement.mInUse) {
                return;
            }
            SQLiteConnection.this.finalizePreparedStatement(preparedStatement);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i4, boolean z4) {
        CloseGuard closeGuard = CloseGuard.get();
        this.mCloseGuard = closeGuard;
        this.mRecentOperations = new OperationLog(0 == true ? 1 : 0);
        this.mPool = sQLiteConnectionPool;
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        this.mConfiguration = sQLiteDatabaseConfiguration2;
        this.mConnectionId = i4;
        this.mIsPrimaryConnection = z4;
        this.mIsReadOnlyConnection = (sQLiteDatabaseConfiguration.openFlags & 1) != 0;
        this.mPreparedStatementCache = new PreparedStatementCache(sQLiteDatabaseConfiguration2.maxSqlCacheSize);
        closeGuard.open("close");
    }

    private PreparedStatement acquirePreparedStatement(String str) {
        boolean z4;
        PreparedStatement preparedStatementObtainPreparedStatement = this.mPreparedStatementCache.get(str);
        if (preparedStatementObtainPreparedStatement == null) {
            z4 = false;
        } else {
            if (!preparedStatementObtainPreparedStatement.mInUse) {
                return preparedStatementObtainPreparedStatement;
            }
            z4 = true;
        }
        long jNativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
        try {
            int iNativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, jNativePrepareStatement);
            int sqlStatementType = DatabaseUtils.getSqlStatementType(str);
            preparedStatementObtainPreparedStatement = obtainPreparedStatement(str, jNativePrepareStatement, iNativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, jNativePrepareStatement));
            if (!z4 && isCacheable(sqlStatementType)) {
                this.mPreparedStatementCache.put(str, preparedStatementObtainPreparedStatement);
                preparedStatementObtainPreparedStatement.mInCache = true;
            }
            preparedStatementObtainPreparedStatement.mInUse = true;
            return preparedStatementObtainPreparedStatement;
        } catch (RuntimeException e4) {
            if (preparedStatementObtainPreparedStatement == null || !preparedStatementObtainPreparedStatement.mInCache) {
                nativeFinalizeStatement(this.mConnectionPtr, jNativePrepareStatement);
            }
            throw e4;
        }
    }

    private void applyBlockGuardPolicy(PreparedStatement preparedStatement) {
    }

    private void attachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
            int i4 = this.mCancellationSignalAttachCount + 1;
            this.mCancellationSignalAttachCount = i4;
            if (i4 == 1) {
                nativeResetCancel(this.mConnectionPtr, true);
                cancellationSignal.setOnCancelListener(this);
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
        long j4 = preparedStatement.mStatementPtr;
        for (int i4 = 0; i4 < length; i4++) {
            Object obj = objArr[i4];
            int typeOfObject = DatabaseUtils.getTypeOfObject(obj);
            if (typeOfObject == 0) {
                nativeBindNull(this.mConnectionPtr, j4, i4 + 1);
            } else if (typeOfObject == 1) {
                nativeBindLong(this.mConnectionPtr, j4, i4 + 1, ((Number) obj).longValue());
            } else if (typeOfObject == 2) {
                nativeBindDouble(this.mConnectionPtr, j4, i4 + 1, ((Number) obj).doubleValue());
            } else if (typeOfObject == 4) {
                nativeBindBlob(this.mConnectionPtr, j4, i4 + 1, (byte[]) obj);
            } else if (obj instanceof Boolean) {
                nativeBindLong(this.mConnectionPtr, j4, i4 + 1, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else {
                nativeBindString(this.mConnectionPtr, j4, i4 + 1, obj.toString());
            }
        }
    }

    private static String canonicalizeSyncMode(String str) {
        return str.equals("0") ? "OFF" : str.equals("1") ? "NORMAL" : str.equals("2") ? "FULL" : str;
    }

    private void detachCancellationSignal(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            int i4 = this.mCancellationSignalAttachCount - 1;
            this.mCancellationSignalAttachCount = i4;
            if (i4 == 0) {
                cancellationSignal.setOnCancelListener(null);
                nativeResetCancel(this.mConnectionPtr, false);
            }
        }
    }

    private void dispose(boolean z4) {
        CloseGuard closeGuard = this.mCloseGuard;
        if (closeGuard != null) {
            if (z4) {
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

    private SQLiteDebug.DbStats getMainDbStatsUnsafe(int i4, long j4, long j5) {
        String strD = this.mConfiguration.path;
        if (!this.mIsPrimaryConnection) {
            strD = AbstractC0831a.d(g.v(strD, " ("), this.mConnectionId, ")");
        }
        return new SQLiteDebug.DbStats(strD, j4, j5, i4, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
    }

    public static boolean hasCodec() {
        return nativeHasCodec();
    }

    private static boolean isCacheable(int i4) {
        return i4 == 2 || i4 == 1;
    }

    private static native void nativeBindBlob(long j4, long j5, int i4, byte[] bArr);

    private static native void nativeBindDouble(long j4, long j5, int i4, double d4);

    private static native void nativeBindLong(long j4, long j5, int i4, long j6);

    private static native void nativeBindNull(long j4, long j5, int i4);

    private static native void nativeBindString(long j4, long j5, int i4, String str);

    private static native void nativeCancel(long j4);

    private static native void nativeClose(long j4);

    private static native void nativeExecute(long j4, long j5);

    private static native int nativeExecuteForBlobFileDescriptor(long j4, long j5);

    private static native int nativeExecuteForChangedRowCount(long j4, long j5);

    private static native long nativeExecuteForCursorWindow(long j4, long j5, long j6, int i4, int i5, boolean z4);

    private static native long nativeExecuteForLastInsertedRowId(long j4, long j5);

    private static native long nativeExecuteForLong(long j4, long j5);

    private static native String nativeExecuteForString(long j4, long j5);

    private static native void nativeExecuteRaw(long j4, long j5);

    private static native void nativeFinalizeStatement(long j4, long j5);

    private static native int nativeGetColumnCount(long j4, long j5);

    private static native String nativeGetColumnName(long j4, long j5, int i4);

    private static native int nativeGetDbLookaside(long j4);

    private static native int nativeGetParameterCount(long j4, long j5);

    private static native boolean nativeHasCodec();

    private static native boolean nativeIsReadOnly(long j4, long j5);

    private static native int nativeKey(long j4, byte[] bArr);

    private static native long nativeOpen(String str, int i4, String str2, boolean z4, boolean z5);

    private static native long nativePrepareStatement(long j4, String str);

    private static native int nativeReKey(long j4, byte[] bArr);

    private static native void nativeRegisterCustomFunction(long j4, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterLocalizedCollators(long j4, String str);

    private static native void nativeResetCancel(long j4, boolean z4);

    private static native void nativeResetStatementAndClearBindings(long j4, long j5);

    private PreparedStatement obtainPreparedStatement(String str, long j4, int i4, int i5, boolean z4) {
        PreparedStatement preparedStatement = this.mPreparedStatementPool;
        int i6 = 0;
        if (preparedStatement != null) {
            this.mPreparedStatementPool = preparedStatement.mPoolNext;
            preparedStatement.mPoolNext = null;
            preparedStatement.mInCache = false;
        } else {
            preparedStatement = new PreparedStatement(i6);
        }
        preparedStatement.mSql = str;
        preparedStatement.mStatementPtr = j4;
        preparedStatement.mNumParameters = i4;
        preparedStatement.mType = i5;
        preparedStatement.mReadOnly = z4;
        return preparedStatement;
    }

    public static SQLiteConnection open(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i4, boolean z4) {
        SQLiteConnection sQLiteConnection = new SQLiteConnection(sQLiteConnectionPool, sQLiteDatabaseConfiguration, i4, z4);
        try {
            sQLiteConnection.open();
            return sQLiteConnection;
        } catch (SQLiteException e4) {
            sQLiteConnection.dispose(false);
            throw e4;
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
            executeForLong(AbstractC0351g.n("PRAGMA wal_autocheckpoint=", wALAutoCheckpoint), null, null);
        }
    }

    private void setForeignKeyModeFromConfiguration() {
        if (this.mIsReadOnlyConnection) {
            return;
        }
        long j4 = this.mConfiguration.foreignKeyConstraintsEnabled ? 1L : 0L;
        if (executeForLong("PRAGMA foreign_keys", null, null) != j4) {
            execute(AbstractC0351g.n("PRAGMA foreign_keys=", j4), null, null);
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
        } catch (SQLiteDatabaseLockedException unused) {
        }
        StringBuilder sb = new StringBuilder("Could not change the database journal mode of '");
        AbstractC0351g.C(sb, this.mConfiguration.label, "' from '", strExecuteForString, "' to '");
        sb.append(str);
        sb.append("' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        Logger.w(TAG, sb.toString());
    }

    private void setJournalSizeLimit() {
        if (this.mConfiguration.isInMemoryDb() || this.mIsReadOnlyConnection) {
            return;
        }
        long journalSizeLimit = SQLiteGlobal.getJournalSizeLimit();
        if (executeForLong("PRAGMA journal_size_limit", null, null) != journalSizeLimit) {
            executeForLong(AbstractC0351g.n("PRAGMA journal_size_limit=", journalSizeLimit), null, null);
        }
    }

    private void setLocaleFromConfiguration() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfiguration;
        if ((sQLiteDatabaseConfiguration.openFlags & 16) != 0) {
            return;
        }
        String string = sQLiteDatabaseConfiguration.locale.toString();
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
        } catch (RuntimeException e4) {
            throw new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + string + "'.", e4);
        }
    }

    private void setPageSize() {
        if (this.mConfiguration.isInMemoryDb() || this.mIsReadOnlyConnection || SQLiteDatabase.hasCodec()) {
            return;
        }
        long defaultPageSize = SQLiteGlobal.getDefaultPageSize();
        if (executeForLong("PRAGMA page_size", null, null) != defaultPageSize) {
            execute(AbstractC0351g.n("PRAGMA page_size=", defaultPageSize), null, null);
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
        return str.replaceAll("[\\s]*\\n+[\\s]*", AwarenessDataItem.PERMISSION_SPLITTER);
    }

    public void changePassword(byte[] bArr) {
        int iNativeReKey = nativeReKey(this.mConnectionPtr, bArr);
        Logger.i(TAG, "Database rekey operation returned:" + iNativeReKey);
        if (iNativeReKey != 0) {
            throw new SQLiteException(AbstractC0351g.m("Failed to rekey database, result code:", iNativeReKey));
        }
    }

    public void close() {
        dispose(false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:38|3)|(2:40|4)|8|32|9|(11:12|36|13|34|14|15|20|(1:22)|23|24|10)|42|25|28|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0043 A[Catch: all -> 0x0081, SQLiteException -> 0x00ca, TRY_LEAVE, TryCatch #0 {all -> 0x0081, blocks: (B:9:0x002e, B:10:0x003d, B:12:0x0043, B:13:0x004c, B:14:0x0064, B:20:0x0088, B:22:0x009f, B:23:0x00b3), top: B:32:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009f A[Catch: all -> 0x0081, SQLiteException -> 0x00ca, TryCatch #0 {all -> 0x0081, blocks: (B:9:0x002e, B:10:0x003d, B:12:0x0043, B:13:0x004c, B:14:0x0064, B:20:0x0088, B:22:0x009f, B:23:0x00b3), top: B:32:0x002e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void collectDbStats(java.util.ArrayList<net.zetetic.database.sqlcipher.SQLiteDebug.DbStats> r26) {
        /*
            r25 = this;
            r0 = r25
            r9 = r26
            java.lang.String r10 = "PRAGMA "
            long r1 = r0.mConnectionPtr
            int r2 = nativeGetDbLookaside(r1)
            r11 = 0
            r12 = 0
            java.lang.String r1 = "PRAGMA page_count;"
            long r3 = r0.executeForLong(r1, r11, r11)     // Catch: android.database.sqlite.SQLiteException -> L1c
            java.lang.String r1 = "PRAGMA page_size;"
            long r5 = r0.executeForLong(r1, r11, r11)     // Catch: android.database.sqlite.SQLiteException -> L1d
            goto L1e
        L1c:
            r3 = r12
        L1d:
            r5 = r12
        L1e:
            r1 = r25
            net.zetetic.database.sqlcipher.SQLiteDebug$DbStats r1 = r1.getMainDbStatsUnsafe(r2, r3, r5)
            r9.add(r1)
            net.zetetic.database.CursorWindow r14 = new net.zetetic.database.CursorWindow
            java.lang.String r1 = "collectDbStats"
            r14.<init>(r1)
            java.lang.String r2 = "PRAGMA database_list;"
            r7 = 0
            r8 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r1 = r25
            r4 = r14
            r1.executeForCursorWindow(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            r1 = 1
            r2 = r1
        L3d:
            int r3 = r14.getNumRows()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            if (r2 >= r3) goto Lca
            java.lang.String r3 = r14.getString(r2, r1)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            r4 = 2
            java.lang.String r4 = r14.getString(r2, r4)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            r5.<init>()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            r5.append(r10)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            r5.append(r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            java.lang.String r6 = ".page_count;"
            r5.append(r6)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            long r5 = r0.executeForLong(r5, r11, r11)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L83
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            r7.<init>()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            r7.append(r10)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            r7.append(r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            java.lang.String r8 = ".page_size;"
            r7.append(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            long r7 = r0.executeForLong(r7, r11, r11)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            r17 = r5
            r19 = r7
            goto L88
        L81:
            r0 = move-exception
            goto Lce
        L83:
            r5 = r12
        L84:
            r17 = r5
            r19 = r12
        L88:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            r5.<init>()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            java.lang.String r6 = "  (attached) "
            r5.append(r6)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            r5.append(r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            boolean r5 = r4.isEmpty()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            if (r5 != 0) goto Lb3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            r5.<init>()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            r5.append(r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            java.lang.String r3 = ": "
            r5.append(r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            r5.append(r4)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
        Lb3:
            r16 = r3
            net.zetetic.database.sqlcipher.SQLiteDebug$DbStats r3 = new net.zetetic.database.sqlcipher.SQLiteDebug$DbStats     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            r23 = 0
            r24 = 0
            r21 = 0
            r22 = 0
            r15 = r3
            r15.<init>(r16, r17, r19, r21, r22, r23, r24)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            r9.add(r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> Lca
            int r2 = r2 + 1
            goto L3d
        Lca:
            r14.close()
            goto Ld2
        Lce:
            r14.close()
            throw r0
        Ld2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zetetic.database.sqlcipher.SQLiteConnection.collectDbStats(java.util.ArrayList):void");
    }

    public void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> arrayList) {
        arrayList.add(getMainDbStatsUnsafe(0, 0L, 0L));
    }

    public String describeCurrentOperationUnsafe() {
        return this.mRecentOperations.describeCurrentOperation();
    }

    public void dump(Printer printer, boolean z4) {
        dumpUnsafe(printer, z4);
    }

    public void dumpUnsafe(Printer printer, boolean z4) {
        printer.println("Connection #" + this.mConnectionId + AwarenessDataItem.USERID_SPLITTER);
        if (z4) {
            printer.println("  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
        }
        printer.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
        printer.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
        this.mRecentOperations.dump(printer, z4);
        if (z4) {
            this.mPreparedStatementCache.dump(printer);
        }
    }

    public void enableLocalizedCollators() {
        if (nativeHasCodec()) {
            setLocaleFromConfiguration();
        }
    }

    public void execute(String str, Object[] objArr, CancellationSignal cancellationSignal) {
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
                    attachCancellationSignal(cancellationSignal);
                    try {
                        nativeExecute(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                    } finally {
                        detachCancellationSignal(cancellationSignal);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } catch (RuntimeException e4) {
                this.mRecentOperations.failOperation(iBeginOperation, e4);
                throw e4;
            }
        } finally {
            this.mRecentOperations.endOperation(iBeginOperation);
        }
    }

    public ParcelFileDescriptor executeForBlobFileDescriptor(String str, Object[] objArr, CancellationSignal cancellationSignal) {
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
                    attachCancellationSignal(cancellationSignal);
                    try {
                        int iNativeExecuteForBlobFileDescriptor = nativeExecuteForBlobFileDescriptor(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                        return iNativeExecuteForBlobFileDescriptor >= 0 ? ParcelFileDescriptor.adoptFd(iNativeExecuteForBlobFileDescriptor) : null;
                    } finally {
                        detachCancellationSignal(cancellationSignal);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } finally {
                this.mRecentOperations.endOperation(iBeginOperation);
            }
        } catch (RuntimeException e4) {
            this.mRecentOperations.failOperation(iBeginOperation, e4);
            throw e4;
        }
    }

    public int executeForChangedRowCount(String str, Object[] objArr, CancellationSignal cancellationSignal) {
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
                    attachCancellationSignal(cancellationSignal);
                    try {
                        int iNativeExecuteForChangedRowCount = nativeExecuteForChangedRowCount(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                        if (this.mRecentOperations.endOperationDeferLog(iBeginOperation)) {
                            this.mRecentOperations.logOperation(iBeginOperation, AbstractC0351g.m("changedRows=", iNativeExecuteForChangedRowCount));
                        }
                        return iNativeExecuteForChangedRowCount;
                    } finally {
                        detachCancellationSignal(cancellationSignal);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } catch (RuntimeException e4) {
                this.mRecentOperations.failOperation(iBeginOperation, e4);
                throw e4;
            }
        } catch (Throwable th) {
            if (this.mRecentOperations.endOperationDeferLog(iBeginOperation)) {
                this.mRecentOperations.logOperation(iBeginOperation, AbstractC0351g.m("changedRows=", 0));
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    public int executeForCursorWindow(String str, Object[] objArr, CursorWindow cursorWindow, int i4, int i5, boolean z4, CancellationSignal cancellationSignal) {
        String str2;
        int i6;
        ?? r4;
        int i7;
        int i8;
        PreparedStatement preparedStatement;
        int i9;
        int numRows;
        String str3 = ", countedRows=";
        String str4 = ", filledRows=";
        String str5 = ", actualPos=";
        String str6 = "', startPos=";
        ?? r8 = "window='";
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (cursorWindow == null) {
            throw new IllegalArgumentException("window must not be null.");
        }
        cursorWindow.acquireReference();
        try {
            OperationLog operationLog = this.mRecentOperations;
            ?? r5 = "executeForCursorWindow";
            int iBeginOperation = operationLog.beginOperation("executeForCursorWindow", str, objArr);
            try {
                try {
                    PreparedStatement preparedStatementAcquirePreparedStatement = acquirePreparedStatement(str);
                    try {
                        throwIfStatementForbidden(preparedStatementAcquirePreparedStatement);
                        bindArguments(preparedStatementAcquirePreparedStatement, objArr);
                        applyBlockGuardPolicy(preparedStatementAcquirePreparedStatement);
                        attachCancellationSignal(cancellationSignal);
                        try {
                            try {
                                try {
                                    preparedStatement = preparedStatementAcquirePreparedStatement;
                                    str3 = "window='";
                                    try {
                                        long jNativeExecuteForCursorWindow = nativeExecuteForCursorWindow(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr, cursorWindow.mWindowPtr, i4, i5, z4);
                                        i8 = (int) (jNativeExecuteForCursorWindow >> 32);
                                        i9 = (int) jNativeExecuteForCursorWindow;
                                        try {
                                            numRows = cursorWindow.getNumRows();
                                            try {
                                                cursorWindow.setStartPosition(i8);
                                                try {
                                                    detachCancellationSignal(cancellationSignal);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    iBeginOperation = iBeginOperation;
                                                    try {
                                                        releasePreparedStatement(preparedStatement);
                                                        throw th;
                                                    } catch (RuntimeException e4) {
                                                        e = e4;
                                                        this.mRecentOperations.failOperation(iBeginOperation, e);
                                                        throw e;
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                iBeginOperation = iBeginOperation;
                                                try {
                                                    detachCancellationSignal(cancellationSignal);
                                                    throw th;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    releasePreparedStatement(preparedStatement);
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            iBeginOperation = iBeginOperation;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        iBeginOperation = iBeginOperation;
                                        detachCancellationSignal(cancellationSignal);
                                        throw th;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    iBeginOperation = iBeginOperation;
                                    preparedStatement = preparedStatementAcquirePreparedStatement;
                                    detachCancellationSignal(cancellationSignal);
                                    throw th;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            preparedStatement = preparedStatementAcquirePreparedStatement;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        preparedStatement = preparedStatementAcquirePreparedStatement;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    i8 = -1;
                    r4 = operationLog;
                    i7 = r5;
                    i6 = r8;
                }
            } catch (RuntimeException e5) {
                e = e5;
            } catch (Throwable th11) {
                th = th11;
                str2 = "', startPos=";
                str6 = ", actualPos=";
                str5 = ", filledRows=";
                str4 = ", countedRows=";
                str3 = "window='";
                i6 = i4;
                r4 = -1;
                i7 = -1;
                i8 = -1;
            }
            try {
                releasePreparedStatement(preparedStatement);
                if (this.mRecentOperations.endOperationDeferLog(iBeginOperation)) {
                    this.mRecentOperations.logOperation(iBeginOperation, str3 + cursorWindow + "', startPos=" + i4 + ", actualPos=" + i8 + ", filledRows=" + numRows + ", countedRows=" + i9);
                }
                return i9;
            } catch (RuntimeException e6) {
                e = e6;
                iBeginOperation = iBeginOperation;
                this.mRecentOperations.failOperation(iBeginOperation, e);
                throw e;
            } catch (Throwable th12) {
                th = th12;
                i6 = i4;
                iBeginOperation = iBeginOperation;
                str4 = ", countedRows=";
                str2 = "', startPos=";
                str6 = ", actualPos=";
                str5 = ", filledRows=";
                r4 = i9;
                i7 = numRows;
                if (this.mRecentOperations.endOperationDeferLog(iBeginOperation)) {
                    this.mRecentOperations.logOperation(iBeginOperation, str3 + cursorWindow + str2 + i6 + str6 + i8 + str5 + i7 + str4 + r4);
                }
                throw th;
            }
        } finally {
            cursorWindow.releaseReference();
        }
    }

    public long executeForLastInsertedRowId(String str, Object[] objArr, CancellationSignal cancellationSignal) {
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
                    attachCancellationSignal(cancellationSignal);
                    try {
                        return nativeExecuteForLastInsertedRowId(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                    } finally {
                        detachCancellationSignal(cancellationSignal);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } catch (RuntimeException e4) {
                this.mRecentOperations.failOperation(iBeginOperation, e4);
                throw e4;
            }
        } finally {
            this.mRecentOperations.endOperation(iBeginOperation);
        }
    }

    public long executeForLong(String str, Object[] objArr, CancellationSignal cancellationSignal) {
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
                    attachCancellationSignal(cancellationSignal);
                    try {
                        return nativeExecuteForLong(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                    } finally {
                        detachCancellationSignal(cancellationSignal);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } catch (RuntimeException e4) {
                this.mRecentOperations.failOperation(iBeginOperation, e4);
                throw e4;
            }
        } finally {
            this.mRecentOperations.endOperation(iBeginOperation);
        }
    }

    public String executeForString(String str, Object[] objArr, CancellationSignal cancellationSignal) {
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
                    attachCancellationSignal(cancellationSignal);
                    try {
                        return nativeExecuteForString(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                    } finally {
                        detachCancellationSignal(cancellationSignal);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } catch (RuntimeException e4) {
                this.mRecentOperations.failOperation(iBeginOperation, e4);
                throw e4;
            }
        } finally {
            this.mRecentOperations.endOperation(iBeginOperation);
        }
    }

    public void executeRaw(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        int iBeginOperation = this.mRecentOperations.beginOperation("executeRaw", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementAcquirePreparedStatement = acquirePreparedStatement(str);
                try {
                    throwIfStatementForbidden(preparedStatementAcquirePreparedStatement);
                    bindArguments(preparedStatementAcquirePreparedStatement, objArr);
                    applyBlockGuardPolicy(preparedStatementAcquirePreparedStatement);
                    attachCancellationSignal(cancellationSignal);
                    try {
                        nativeExecuteRaw(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr);
                    } finally {
                        detachCancellationSignal(cancellationSignal);
                    }
                } finally {
                    releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                }
            } finally {
                if (this.mRecentOperations.endOperationDeferLog(iBeginOperation)) {
                    this.mRecentOperations.logOperation(iBeginOperation, "");
                }
            }
        } catch (RuntimeException e4) {
            this.mRecentOperations.failOperation(iBeginOperation, e4);
            throw e4;
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

    public int getConnectionId() {
        return this.mConnectionId;
    }

    public boolean isPreparedStatementInCache(String str) {
        return this.mPreparedStatementCache.get(str) != null;
    }

    public boolean isPrimaryConnection() {
        return this.mIsPrimaryConnection;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
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
                            for (int i4 = 0; i4 < iNativeGetColumnCount; i4++) {
                                sQLiteStatementInfo.columnNames[i4] = nativeGetColumnName(this.mConnectionPtr, preparedStatementAcquirePreparedStatement.mStatementPtr, i4);
                            }
                        }
                    } catch (Throwable th) {
                        releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                        throw th;
                    }
                }
                releasePreparedStatement(preparedStatementAcquirePreparedStatement);
                this.mRecentOperations.endOperation(iBeginOperation);
            } catch (RuntimeException e4) {
                this.mRecentOperations.failOperation(iBeginOperation, e4);
                throw e4;
            }
        } catch (Throwable th2) {
            this.mRecentOperations.endOperation(iBeginOperation);
            throw th2;
        }
    }

    public void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        this.mOnlyAllowReadOnlyOperations = false;
        int size = sQLiteDatabaseConfiguration.customFunctions.size();
        for (int i4 = 0; i4 < size; i4++) {
            SQLiteCustomFunction sQLiteCustomFunction = sQLiteDatabaseConfiguration.customFunctions.get(i4);
            if (!this.mConfiguration.customFunctions.contains(sQLiteCustomFunction)) {
                nativeRegisterCustomFunction(this.mConnectionPtr, sQLiteCustomFunction);
            }
        }
        boolean z4 = sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.mConfiguration;
        boolean z5 = z4 != sQLiteDatabaseConfiguration2.foreignKeyConstraintsEnabled;
        boolean z6 = ((sQLiteDatabaseConfiguration.openFlags ^ sQLiteDatabaseConfiguration2.openFlags) & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0;
        boolean z7 = !sQLiteDatabaseConfiguration.locale.equals(sQLiteDatabaseConfiguration2.locale);
        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
        if (z5) {
            setForeignKeyModeFromConfiguration();
        }
        if (z6) {
            setWalModeFromConfiguration();
        }
        if (z7) {
            setLocaleFromConfiguration();
        }
    }

    public void setOnlyAllowReadOnlyOperations(boolean z4) {
        this.mOnlyAllowReadOnlyOperations = z4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SQLiteConnection: ");
        sb.append(this.mConfiguration.path);
        sb.append(" (");
        return AbstractC0831a.d(sb, this.mConnectionId, ")");
    }

    private void open() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfiguration;
        this.mConnectionPtr = nativeOpen(sQLiteDatabaseConfiguration.path, sQLiteDatabaseConfiguration.openFlags, sQLiteDatabaseConfiguration.label, SQLiteDebug.DEBUG_SQL_STATEMENTS, SQLiteDebug.DEBUG_SQL_TIME);
        SQLiteDatabaseHook sQLiteDatabaseHook = this.mConfiguration.databaseHook;
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.preKey(this);
        }
        byte[] bArr = this.mConfiguration.password;
        if (bArr != null && bArr.length > 0) {
            Logger.i(TAG, "Database keying operation returned:" + nativeKey(this.mConnectionPtr, bArr));
        }
        SQLiteDatabaseHook sQLiteDatabaseHook2 = this.mConfiguration.databaseHook;
        if (sQLiteDatabaseHook2 != null) {
            sQLiteDatabaseHook2.postKey(this);
        }
        byte[] bArr2 = this.mConfiguration.password;
        if (bArr2 != null && bArr2.length > 0) {
            executeForLong("SELECT COUNT(*) FROM sqlite_schema;", null, null);
        }
        setPageSize();
        setForeignKeyModeFromConfiguration();
        setJournalSizeLimit();
        setAutoCheckpointInterval();
        setWalModeFromConfiguration();
        if (!nativeHasCodec()) {
            setLocaleFromConfiguration();
        }
        int size = this.mConfiguration.customFunctions.size();
        for (int i4 = 0; i4 < size; i4++) {
            nativeRegisterCustomFunction(this.mConnectionPtr, this.mConfiguration.customFunctions.get(i4));
        }
    }
}
