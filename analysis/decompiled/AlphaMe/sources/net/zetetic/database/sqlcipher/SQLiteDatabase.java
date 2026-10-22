package net.zetetic.database.sqlcipher;

import B0.g;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.os.Looper;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Pair;
import android.util.Printer;
import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.stepos.activeview.utils.Constants;
import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import k0.InterfaceC0674b;
import k0.i;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.DatabaseErrorHandler;
import net.zetetic.database.DatabaseUtils;
import net.zetetic.database.DefaultDatabaseErrorHandler;
import net.zetetic.database.Logger;
import net.zetetic.database.sqlcipher.SQLiteDebug;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class SQLiteDatabase extends SQLiteClosable implements InterfaceC0674b {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    public static final int CREATE_IF_NECESSARY = 268435456;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
    private static final int EVENT_DB_CORRUPT = 75004;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "SQLiteDatabase";
    private final SQLiteDatabaseConfiguration mConfigurationLocked;
    private SQLiteConnectionPool mConnectionPoolLocked;
    private final CursorFactory mCursorFactory;
    private final DatabaseErrorHandler mErrorHandler;
    private boolean mHasAttachedDbsLocked;
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private final ThreadLocal<SQLiteSession> mThreadSession = new ThreadLocal<SQLiteSession>() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.1
        @Override // java.lang.ThreadLocal
        public SQLiteSession initialValue() {
            return SQLiteDatabase.this.createSession();
        }
    };
    private final Object mLock = new Object();
    private final CloseGuard mCloseGuardLocked = CloseGuard.get();

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    public interface CustomFunction {
        void callback(String[] strArr);
    }

    private SQLiteDatabase(String str, byte[] bArr, int i4, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this.mCursorFactory = cursorFactory;
        this.mErrorHandler = databaseErrorHandler == null ? new DefaultDatabaseErrorHandler() : databaseErrorHandler;
        this.mConfigurationLocked = new SQLiteDatabaseConfiguration(str, i4, bArr, sQLiteDatabaseHook);
    }

    private void collectDbStats(ArrayList<SQLiteDebug.DbStats> arrayList) {
        synchronized (this.mLock) {
            try {
                SQLiteConnectionPool sQLiteConnectionPool = this.mConnectionPoolLocked;
                if (sQLiteConnectionPool != null) {
                    sQLiteConnectionPool.collectDbStats(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory) {
        return openDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, cursorFactory, CREATE_IF_NECESSARY);
    }

    public static boolean deleteDatabase(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file must not be null");
        }
        boolean zDelete = file.delete() | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            final String str = file.getName() + "-mj";
            File[] fileArrListFiles = parentFile.listFiles(new FileFilter() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.4
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    return file2.getName().startsWith(str);
                }
            });
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    zDelete |= file2.delete();
                }
            }
        }
        return zDelete;
    }

    private void dispose(boolean z4) {
        SQLiteConnectionPool sQLiteConnectionPool;
        synchronized (this.mLock) {
            try {
                CloseGuard closeGuard = this.mCloseGuardLocked;
                if (closeGuard != null) {
                    if (z4) {
                        closeGuard.warnIfOpen();
                    }
                    this.mCloseGuardLocked.close();
                }
                sQLiteConnectionPool = this.mConnectionPoolLocked;
                this.mConnectionPoolLocked = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z4) {
            return;
        }
        synchronized (sActiveDatabases) {
            sActiveDatabases.remove(this);
        }
        if (sQLiteConnectionPool != null) {
            sQLiteConnectionPool.close();
        }
    }

    private void dump(Printer printer, boolean z4) {
        synchronized (this.mLock) {
            try {
                if (this.mConnectionPoolLocked != null) {
                    printer.println("");
                    this.mConnectionPoolLocked.dump(printer, z4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void dumpAll(Printer printer, boolean z4) {
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            it.next().dump(printer, z4);
        }
    }

    private int executeSql(String str, Object[] objArr) throws SQLException {
        boolean z4;
        acquireReference();
        try {
            if (DatabaseUtils.getSqlStatementType(str) == 3) {
                synchronized (this.mLock) {
                    try {
                        if (this.mHasAttachedDbsLocked) {
                            z4 = false;
                        } else {
                            z4 = true;
                            this.mHasAttachedDbsLocked = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z4) {
                    disableWriteAheadLogging();
                }
            }
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, str, objArr);
            try {
                return sQLiteStatement.executeUpdateDelete();
            } finally {
                sQLiteStatement.close();
            }
        } finally {
            releaseReference();
        }
    }

    public static String findEditTable(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("Invalid tables");
        }
        int iIndexOf = str.indexOf(32);
        int iIndexOf2 = str.indexOf(44);
        return (iIndexOf <= 0 || (iIndexOf >= iIndexOf2 && iIndexOf2 >= 0)) ? iIndexOf2 > 0 ? (iIndexOf2 < iIndexOf || iIndexOf < 0) ? str.substring(0, iIndexOf2) : str : str : str.substring(0, iIndexOf);
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> arrayList = new ArrayList<>();
        synchronized (sActiveDatabases) {
            arrayList.addAll(sActiveDatabases.keySet());
        }
        return arrayList;
    }

    private static byte[] getBytes(String str) {
        return (str == null || str.length() == 0) ? new byte[0] : str.getBytes(Charset.forName(Constants.UTF_8_CODE));
    }

    public static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        ArrayList<SQLiteDebug.DbStats> arrayList = new ArrayList<>();
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            it.next().collectDbStats(arrayList);
        }
        return arrayList;
    }

    public static boolean hasCodec() {
        return SQLiteConnection.hasCodec();
    }

    private static boolean isMainThread() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null && looperMyLooper == Looper.getMainLooper();
    }

    private boolean isReadOnlyLocked() {
        return (this.mConfigurationLocked.openFlags & 1) == 1;
    }

    private void open() {
        try {
            try {
                openInner();
            } catch (SQLiteDatabaseCorruptException e4) {
                onCorruption(e4);
                openInner();
            }
        } catch (SQLiteException e5) {
            Logger.e(TAG, "Failed to open database '" + getLabel() + "'.", e5);
            close();
            throw e5;
        }
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i4) {
        return openDatabase(str, cursorFactory, i4, null);
    }

    private void openInner() {
        synchronized (this.mLock) {
            this.mConnectionPoolLocked = SQLiteConnectionPool.open(this.mConfigurationLocked);
            this.mCloseGuardLocked.open("close");
        }
        synchronized (sActiveDatabases) {
            sActiveDatabases.put(this, null);
        }
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file.getPath(), cursorFactory);
    }

    public static int releaseMemory() {
        return SQLiteGlobal.releaseMemory();
    }

    private void throwIfNotOpenLocked() {
        if (this.mConnectionPoolLocked == null) {
            throw new IllegalStateException(g.r(new StringBuilder("The database '"), this.mConfigurationLocked.label, "' is not open."));
        }
    }

    private boolean yieldIfContendedHelper(boolean z4, long j4) {
        acquireReference();
        try {
            return getThreadSession().yieldTransaction(j4, z4, null);
        } finally {
            releaseReference();
        }
    }

    public void addCustomFunction(String str, int i4, CustomFunction customFunction) {
        SQLiteCustomFunction sQLiteCustomFunction = new SQLiteCustomFunction(str, i4, customFunction);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                this.mConfigurationLocked.customFunctions.add(sQLiteCustomFunction);
                try {
                    this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                } catch (RuntimeException e4) {
                    this.mConfigurationLocked.customFunctions.remove(sQLiteCustomFunction);
                    throw e4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k0.InterfaceC0674b
    public void beginTransaction() {
        beginTransaction(null, true);
    }

    @Override // k0.InterfaceC0674b
    public void beginTransactionNonExclusive() {
        beginTransaction(null, false);
    }

    public void beginTransactionWithListener(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(new SQLiteTransactionListener() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.2
            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public void onBegin() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public void onCommit() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public void onRollback() {
                sQLiteTransactionListener.onRollback();
            }
        }, true);
    }

    public void beginTransactionWithListenerNonExclusive(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerNonExclusive(new SQLiteTransactionListener() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.3
            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public void onBegin() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public void onCommit() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public void onRollback() {
                sQLiteTransactionListener.onRollback();
            }
        });
    }

    public void changePassword(String str) {
        changePassword(getBytes(str));
    }

    public SQLiteSession createSession() {
        SQLiteConnectionPool sQLiteConnectionPool;
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            sQLiteConnectionPool = this.mConnectionPoolLocked;
        }
        return new SQLiteSession(sQLiteConnectionPool);
    }

    public int delete(String str, String str2, Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        String[] strArr = new String[length];
        for (int i4 = 0; i4 < length; i4++) {
            strArr[i4] = objArr[i4].toString();
        }
        return delete(str, str2, strArr);
    }

    public void disableWriteAheadLogging() {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                int i4 = sQLiteDatabaseConfiguration.openFlags;
                if ((i4 & ENABLE_WRITE_AHEAD_LOGGING) == 0) {
                    return;
                }
                sQLiteDatabaseConfiguration.openFlags = i4 & (-536870913);
                try {
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e4) {
                    this.mConfigurationLocked.openFlags |= ENABLE_WRITE_AHEAD_LOGGING;
                    throw e4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void enableLocalizedCollators() {
        this.mConnectionPoolLocked.enableLocalizedCollators();
    }

    public boolean enableWriteAheadLogging() {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if ((this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) != 0) {
                    return true;
                }
                if (isReadOnlyLocked()) {
                    return false;
                }
                if (this.mConfigurationLocked.isInMemoryDb()) {
                    Logger.i(TAG, "can't enable WAL for memory databases.");
                    return false;
                }
                if (this.mHasAttachedDbsLocked) {
                    if (Logger.isLoggable(TAG, 3)) {
                        Logger.d(TAG, "this database: " + this.mConfigurationLocked.label + " has attached databases. can't  enable WAL.");
                    }
                    return false;
                }
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                sQLiteDatabaseConfiguration.openFlags |= ENABLE_WRITE_AHEAD_LOGGING;
                try {
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                    return true;
                } catch (RuntimeException e4) {
                    this.mConfigurationLocked.openFlags &= -536870913;
                    throw e4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k0.InterfaceC0674b
    public void endTransaction() {
        acquireReference();
        try {
            getThreadSession().endTransaction(null);
        } finally {
            releaseReference();
        }
    }

    public void execPerConnectionSQL(@NotNull String sql, @SuppressLint({"ArrayReturn"}) @Nullable Object[] objArr) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        throw new UnsupportedOperationException();
    }

    @Override // k0.InterfaceC0674b
    public void execSQL(String str) throws SQLException {
        executeSql(str, null);
    }

    public void finalize() throws Throwable {
        try {
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    public List<Pair<String, String>> getAttachedDbs() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            try {
                Cursor cursorRawQuery = null;
                if (this.mConnectionPoolLocked == null) {
                    return null;
                }
                if (!this.mHasAttachedDbsLocked) {
                    arrayList.add(new Pair("main", this.mConfigurationLocked.path));
                    return arrayList;
                }
                acquireReference();
                try {
                    try {
                        cursorRawQuery = rawQuery("pragma database_list;", (String[]) null);
                        while (cursorRawQuery.moveToNext()) {
                            arrayList.add(new Pair(cursorRawQuery.getString(1), cursorRawQuery.getString(2)));
                        }
                        cursorRawQuery.close();
                        return arrayList;
                    } catch (Throwable th) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        throw th;
                    }
                } finally {
                    releaseReference();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String getLabel() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.label;
        }
        return str;
    }

    public long getMaximumSize() {
        return getPageSize() * DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null);
    }

    public long getPageSize() {
        return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
    }

    public final String getPath() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.path;
        }
        return str;
    }

    @Deprecated
    public Map<String, String> getSyncedTables() {
        return new HashMap(0);
    }

    public int getThreadDefaultConnectionFlags(boolean z4) {
        int i4 = z4 ? 1 : 2;
        return isMainThread() ? i4 | 4 : i4;
    }

    public SQLiteSession getThreadSession() {
        return this.mThreadSession.get();
    }

    public int getVersion() {
        return Long.valueOf(DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
    }

    @Override // k0.InterfaceC0674b
    public boolean inTransaction() {
        acquireReference();
        try {
            return getThreadSession().hasTransaction();
        } finally {
            releaseReference();
        }
    }

    public long insert(String str, int i4, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, null, contentValues, i4);
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    public long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i4) {
        Object[] objArr;
        acquireReference();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT");
            sb.append(CONFLICT_VALUES[i4]);
            sb.append(" INTO ");
            sb.append(str);
            sb.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
            int i5 = 0;
            int size = (contentValues == null || contentValues.size() <= 0) ? 0 : contentValues.size();
            if (size > 0) {
                objArr = new Object[size];
                int i6 = 0;
                for (String str3 : contentValues.keySet()) {
                    sb.append(i6 > 0 ? "," : "");
                    sb.append(str3);
                    objArr[i6] = contentValues.get(str3);
                    i6++;
                }
                sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
                sb.append(" VALUES (");
                while (i5 < size) {
                    sb.append(i5 > 0 ? ",?" : CallerData.NA);
                    i5++;
                }
            } else {
                sb.append(str2 + ") VALUES (NULL");
                objArr = null;
            }
            sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb.toString(), objArr);
            try {
                long jExecuteInsert = sQLiteStatement.executeInsert();
                releaseReference();
                return jExecuteInsert;
            } finally {
                sQLiteStatement.close();
            }
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public boolean isDatabaseIntegrityOk() {
        List<Pair<String, String>> list;
        List<Pair<String, String>> attachedDbs;
        acquireReference();
        try {
            try {
                attachedDbs = getAttachedDbs();
            } catch (SQLiteException unused) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("main", getPath()));
                list = arrayList;
            }
            if (attachedDbs == null) {
                throw new IllegalStateException("databaselist for: " + getPath() + " couldn't be retrieved. probably because the database is closed");
            }
            list = attachedDbs;
            for (int i4 = 0; i4 < list.size(); i4++) {
                Pair<String, String> pair = list.get(i4);
                SQLiteStatement sQLiteStatementCompileStatement = null;
                try {
                    sQLiteStatementCompileStatement = compileStatement("PRAGMA " + ((String) pair.first) + ".integrity_check(1);");
                    String strSimpleQueryForString = sQLiteStatementCompileStatement.simpleQueryForString();
                    if (!strSimpleQueryForString.equalsIgnoreCase("ok")) {
                        Logger.e(TAG, "PRAGMA integrity_check on " + ((String) pair.second) + " returned: " + strSimpleQueryForString);
                        sQLiteStatementCompileStatement.close();
                        return false;
                    }
                    sQLiteStatementCompileStatement.close();
                } catch (Throwable th) {
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    throw th;
                }
            }
            releaseReference();
            return true;
        } finally {
            releaseReference();
        }
    }

    public boolean isDbLockedByCurrentThread() {
        acquireReference();
        try {
            return getThreadSession().hasConnection();
        } finally {
            releaseReference();
        }
    }

    @Deprecated
    public boolean isDbLockedByOtherThreads() {
        return false;
    }

    public /* bridge */ /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return false;
    }

    public boolean isInMemoryDatabase() {
        boolean zIsInMemoryDb;
        synchronized (this.mLock) {
            zIsInMemoryDb = this.mConfigurationLocked.isInMemoryDb();
        }
        return zIsInMemoryDb;
    }

    @Override // k0.InterfaceC0674b
    public boolean isOpen() {
        boolean z4;
        synchronized (this.mLock) {
            z4 = this.mConnectionPoolLocked != null;
        }
        return z4;
    }

    public boolean isReadOnly() {
        boolean zIsReadOnlyLocked;
        synchronized (this.mLock) {
            zIsReadOnlyLocked = isReadOnlyLocked();
        }
        return zIsReadOnlyLocked;
    }

    @Override // k0.InterfaceC0674b
    public boolean isWriteAheadLoggingEnabled() {
        boolean z4;
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            z4 = (this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) != 0;
        }
        return z4;
    }

    @Deprecated
    public void markTableSyncable(String str, String str2) {
    }

    public boolean needUpgrade(int i4) {
        return i4 > getVersion();
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    public void onAllReferencesReleased() {
        dispose(false);
    }

    public void onCorruption(SQLiteException sQLiteException) {
        EventLog.writeEvent(EVENT_DB_CORRUPT, getLabel());
        this.mErrorHandler.onCorruption(this, sQLiteException);
    }

    @Override // k0.InterfaceC0674b
    public Cursor query(i iVar) {
        return query(iVar, (CancellationSignal) null);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z4, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(cursorFactory, z4, str, strArr, str2, strArr2, str3, str4, str5, str6, null);
    }

    public void rawExecSQL(String str, Object... objArr) throws SQLException {
        acquireReference();
        try {
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, str, objArr);
            try {
                sQLiteStatement.executeRaw();
            } finally {
                sQLiteStatement.close();
            }
        } finally {
            releaseReference();
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return rawQueryWithFactory(null, str, strArr, null, null);
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        return rawQueryWithFactory(cursorFactory, str, strArr, str2, null);
    }

    public void reopenReadWrite() {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (isReadOnlyLocked()) {
                    SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                    int i4 = sQLiteDatabaseConfiguration.openFlags;
                    sQLiteDatabaseConfiguration.openFlags = i4 & (-2);
                    try {
                        this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                    } catch (RuntimeException e4) {
                        this.mConfigurationLocked.openFlags = i4;
                        throw e4;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 5);
        } catch (SQLException e4) {
            Logger.e(TAG, "Error inserting", e4);
            return -1L;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    public void setForeignKeyConstraintsEnabled(boolean z4) {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                if (sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled == z4) {
                    return;
                }
                sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled = z4;
                try {
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e4) {
                    this.mConfigurationLocked.foreignKeyConstraintsEnabled = !z4;
                    throw e4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setLocale(Locale locale) {
        if (locale == null) {
            throw new IllegalArgumentException("locale must not be null.");
        }
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                Locale locale2 = sQLiteDatabaseConfiguration.locale;
                sQLiteDatabaseConfiguration.locale = locale;
                try {
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e4) {
                    this.mConfigurationLocked.locale = locale2;
                    throw e4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public void setLockingEnabled(boolean z4) {
    }

    public void setMaxSqlCacheSize(int i4) {
        if (i4 > 100 || i4 < 0) {
            throw new IllegalStateException("expected value between 0 and 100");
        }
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                int i5 = sQLiteDatabaseConfiguration.maxSqlCacheSize;
                sQLiteDatabaseConfiguration.maxSqlCacheSize = i4;
                try {
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e4) {
                    this.mConfigurationLocked.maxSqlCacheSize = i5;
                    throw e4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long setMaximumSize(long j4) {
        long pageSize = getPageSize();
        long j5 = j4 / pageSize;
        if (j4 % pageSize != 0) {
            j5++;
        }
        return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + j5, null) * pageSize;
    }

    public void setPageSize(long j4) throws SQLException {
        execSQL("PRAGMA page_size = " + j4);
    }

    @Override // k0.InterfaceC0674b
    public void setTransactionSuccessful() {
        acquireReference();
        try {
            getThreadSession().setTransactionSuccessful();
        } finally {
            releaseReference();
        }
    }

    public void setVersion(int i4) throws SQLException {
        execSQL("PRAGMA user_version = " + i4);
    }

    public String toString() {
        return "SQLiteDatabase: " + getPath();
    }

    @Override // k0.InterfaceC0674b
    public int update(String str, int i4, ContentValues contentValues, String str2, Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        String[] strArr = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            strArr[i5] = objArr[i5].toString();
        }
        return updateWithOnConflict(str, contentValues, str2, strArr, i4);
    }

    public int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i4) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        acquireReference();
        try {
            StringBuilder sb = new StringBuilder(SyslogConstants.LOG_CLOCK);
            sb.append("UPDATE ");
            sb.append(CONFLICT_VALUES[i4]);
            sb.append(str);
            sb.append(" SET ");
            int size = contentValues.size();
            int length = strArr == null ? size : strArr.length + size;
            Object[] objArr = new Object[length];
            int i5 = 0;
            for (String str3 : contentValues.keySet()) {
                sb.append(i5 > 0 ? "," : "");
                sb.append(str3);
                objArr[i5] = contentValues.get(str3);
                sb.append("=?");
                i5++;
            }
            if (strArr != null) {
                for (int i6 = size; i6 < length; i6++) {
                    objArr[i6] = strArr[i6 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb.toString(), objArr);
            try {
                int iExecuteUpdateDelete = sQLiteStatement.executeUpdateDelete();
                releaseReference();
                return iExecuteUpdateDelete;
            } finally {
                sQLiteStatement.close();
            }
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    public void validateSql(String str, CancellationSignal cancellationSignal) {
        getThreadSession().prepare(str, getThreadDefaultConnectionFlags(true), cancellationSignal, null);
    }

    @Deprecated
    public boolean yieldIfContended() {
        return yieldIfContendedHelper(false, -1L);
    }

    public boolean yieldIfContendedSafely() {
        return yieldIfContendedHelper(true, -1L);
    }

    private void beginTransaction(SQLiteTransactionListener sQLiteTransactionListener, boolean z4) {
        acquireReference();
        try {
            getThreadSession().beginTransaction(z4 ? 2 : 1, sQLiteTransactionListener, getThreadDefaultConnectionFlags(false), null);
        } finally {
            releaseReference();
        }
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i4, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, getBytes(str2), cursorFactory, i4, (DatabaseErrorHandler) null, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory) {
        return openDatabase(str, cursorFactory, CREATE_IF_NECESSARY, null);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, true);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, false);
    }

    public void changePassword(byte[] bArr) {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (isReadOnlyLocked()) {
                    throw new IllegalStateException("Can't change password for readonly databases.");
                }
                if (this.mConfigurationLocked.isInMemoryDb()) {
                    throw new IllegalStateException("Can't change password for in-memory databases.");
                }
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                byte[] bArr2 = sQLiteDatabaseConfiguration.password;
                sQLiteDatabaseConfiguration.password = bArr;
                try {
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e4) {
                    this.mConfigurationLocked.password = bArr2;
                    throw e4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k0.InterfaceC0674b
    public SQLiteStatement compileStatement(String str) throws SQLException {
        acquireReference();
        try {
            return new SQLiteStatement(this, str, null);
        } finally {
            releaseReference();
        }
    }

    @Override // k0.InterfaceC0674b
    public void execSQL(String str, Object[] objArr) throws SQLException {
        if (objArr == null) {
            throw new IllegalArgumentException("Empty bindArgs");
        }
        executeSql(str, objArr);
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLException e4) {
            Logger.e(TAG, "Error inserting", e4);
            return -1L;
        }
    }

    @Deprecated
    public void markTableSyncable(String str, String str2, String str3) {
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z4, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z4, str, strArr, str2, str3, str4, str5, str6), strArr2, findEditTable(str), cancellationSignal);
        } finally {
            releaseReference();
        }
    }

    public Cursor rawQuery(String str, Object... objArr) {
        acquireReference();
        try {
            return new SQLiteDirectCursorDriver(this, str, null, null).query(this.mCursorFactory, objArr);
        } finally {
            releaseReference();
        }
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2, CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2, cancellationSignal);
            if (cursorFactory == null) {
                cursorFactory = this.mCursorFactory;
            }
            return sQLiteDirectCursorDriver.query(cursorFactory, strArr);
        } finally {
            releaseReference();
        }
    }

    public boolean yieldIfContendedSafely(long j4) {
        return yieldIfContendedHelper(true, j4);
    }

    public static SQLiteDatabase openDatabase(String str, byte[] bArr, CursorFactory cursorFactory, int i4, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, bArr, cursorFactory, i4, (DatabaseErrorHandler) null, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler);
    }

    @Override // k0.InterfaceC0674b
    public Cursor query(String str) {
        return rawQuery(str, new Object[0]);
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i4, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, new byte[0], cursorFactory, i4, databaseErrorHandler, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(file.getAbsolutePath(), str, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler, (SQLiteDatabaseHook) null);
    }

    public Cursor query(String str, Object[] objArr) {
        return rawQuery(str, objArr);
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i4, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, getBytes(str2), cursorFactory, i4, databaseErrorHandler, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(file.getAbsolutePath(), bArr, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler, (SQLiteDatabaseHook) null);
    }

    public int delete(String str, String str2, String[] strArr) {
        String str3;
        acquireReference();
        try {
            StringBuilder sb = new StringBuilder("DELETE FROM ");
            sb.append(str);
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                str3 = " WHERE " + str2;
            }
            sb.append(str3);
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb.toString(), strArr);
            try {
                int iExecuteUpdateDelete = sQLiteStatement.executeUpdateDelete();
                releaseReference();
                return iExecuteUpdateDelete;
            } finally {
                sQLiteStatement.close();
            }
        } catch (Throwable th) {
            releaseReference();
            throw th;
        }
    }

    @Override // k0.InterfaceC0674b
    public Cursor query(i iVar, CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            String strB = iVar.b();
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, strB, "", cancellationSignal);
            SQLiteQuery sQLiteQuery = new SQLiteQuery(this, strB, cancellationSignal);
            iVar.a(sQLiteQuery);
            return new SQLiteCursor(sQLiteDirectCursorDriver, "", sQLiteQuery);
        } finally {
            releaseReference();
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    public static SQLiteDatabase openDatabase(String str, byte[] bArr, CursorFactory cursorFactory, int i4, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook) {
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(str, bArr, i4, cursorFactory, databaseErrorHandler, sQLiteDatabaseHook);
        sQLiteDatabase.open();
        return sQLiteDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, bArr, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler, (SQLiteDatabaseHook) null);
    }

    public Cursor rawQuery(String str, String[] strArr, CancellationSignal cancellationSignal) {
        return rawQueryWithFactory(null, str, strArr, null, cancellationSignal);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(file.getAbsolutePath(), str, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(file.getAbsolutePath(), bArr, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, bArr, cursorFactory, CREATE_IF_NECESSARY, databaseErrorHandler, sQLiteDatabaseHook);
    }

    public Cursor query(boolean z4, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(null, z4, str, strArr, str2, strArr2, str3, str4, str5, str6, null);
    }

    public Cursor query(boolean z4, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        return queryWithFactory(null, z4, str, strArr, str2, strArr2, str3, str4, str5, str6, cancellationSignal);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, null);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }
}
