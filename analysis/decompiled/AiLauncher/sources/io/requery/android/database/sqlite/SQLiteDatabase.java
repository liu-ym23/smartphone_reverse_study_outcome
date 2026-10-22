package io.requery.android.database.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import android.util.Printer;
import com.autonavi.aps.amapapi.config.Const;
import io.requery.android.database.DatabaseErrorHandler;
import io.requery.android.database.DefaultDatabaseErrorHandler;
import io.requery.android.database.sqlite.SQLiteDebug;
import j1.InterfaceC4756c;
import j1.InterfaceC4759f;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import x0.d;

@SuppressLint({"ShiftFlags"})
/* loaded from: classes4.dex */
public final class SQLiteDatabase extends SQLiteClosable implements InterfaceC4756c {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES;
    public static final int CREATE_IF_NECESSARY = 6;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
    private static final int EVENT_DB_CORRUPT = 75004;
    public static final String LIBRARY_NAME = "sqlite3x";
    public static final int MAX_SQL_CACHE_SIZE = 100;
    public static final int OPEN_CREATE = 4;
    public static final int OPEN_FULLMUTEX = 65536;
    public static final int OPEN_NOMUTEX = 32768;
    public static final int OPEN_PRIVATECACHE = 262144;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 2;
    public static final int OPEN_SHAREDCACHE = 131072;
    public static final int OPEN_URI = 64;
    private static final String TAG = "SQLiteDatabase";
    private static final WeakHashMap<SQLiteDatabase, Object> sActiveDatabases;
    private final SQLiteDatabaseConfiguration mConfigurationLocked;
    private SQLiteConnectionPool mConnectionPoolLocked;
    private final CursorFactory mCursorFactory;
    private final DatabaseErrorHandler mErrorHandler;
    private final ThreadLocal<SQLiteSession> mThreadSession = new ThreadLocal<SQLiteSession>() { // from class: io.requery.android.database.sqlite.SQLiteDatabase.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public SQLiteSession initialValue() {
            return SQLiteDatabase.this.createSession();
        }
    };
    private final Object mLock = new Object();
    private final CloseGuard mCloseGuardLocked = CloseGuard.get();

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConflictAlgorithm {
    }

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    @Deprecated
    public interface CustomFunction {
        String callback(String[] strArr);
    }

    public interface Function {
        public static final int FLAG_DETERMINISTIC = 2048;

        public interface Args {
            byte[] getBlob(int i10);

            double getDouble(int i10);

            int getInt(int i10);

            long getLong(int i10);

            String getString(int i10);
        }

        public interface Result {
            void set(double d10);

            void set(int i10);

            void set(long j10);

            void set(String str);

            void set(byte[] bArr);

            void setError(String str);

            void setNull();
        }

        void callback(Args args, Result result);
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"UniqueConstants"})
    public @interface OpenFlags {
    }

    static {
        System.loadLibrary(LIBRARY_NAME);
        sActiveDatabases = new WeakHashMap<>();
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    }

    private SQLiteDatabase(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        this.mCursorFactory = cursorFactory;
        this.mErrorHandler = databaseErrorHandler == null ? new DefaultDatabaseErrorHandler() : databaseErrorHandler;
        this.mConfigurationLocked = sQLiteDatabaseConfiguration;
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
        return openDatabase(":memory:", cursorFactory, 6);
    }

    public static boolean deleteDatabase(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file must not be null");
        }
        boolean zDelete = file.delete() | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            final String str = file.getName() + "-mj";
            for (File file2 : parentFile.listFiles(new FileFilter() { // from class: io.requery.android.database.sqlite.SQLiteDatabase.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    return file3.getName().startsWith(str);
                }
            })) {
                zDelete |= file2.delete();
            }
        }
        return zDelete;
    }

    private void dispose(boolean z10) {
        SQLiteConnectionPool sQLiteConnectionPool;
        synchronized (this.mLock) {
            try {
                CloseGuard closeGuard = this.mCloseGuardLocked;
                if (closeGuard != null) {
                    if (z10) {
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
        if (z10) {
            return;
        }
        WeakHashMap<SQLiteDatabase, Object> weakHashMap = sActiveDatabases;
        synchronized (weakHashMap) {
            weakHashMap.remove(this);
        }
        if (sQLiteConnectionPool != null) {
            sQLiteConnectionPool.close();
        }
    }

    private void dump(Printer printer, boolean z10) {
        synchronized (this.mLock) {
            try {
                if (this.mConnectionPoolLocked != null) {
                    printer.println("");
                    this.mConnectionPoolLocked.dump(printer, z10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void dumpAll(Printer printer, boolean z10) {
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            it.next().dump(printer, z10);
        }
    }

    private static void ensureFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        try {
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                Log.e(TAG, "Couldn't mkdirs " + file);
            }
            if (file.createNewFile()) {
                return;
            }
            Log.e(TAG, "Couldn't create " + file);
        } catch (IOException e10) {
            Log.e(TAG, "Couldn't ensure file " + file, e10);
        }
    }

    private int executeSql(String str, Object[] objArr) throws SQLException {
        acquireReference();
        try {
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
        WeakHashMap<SQLiteDatabase, Object> weakHashMap = sActiveDatabases;
        synchronized (weakHashMap) {
            arrayList.addAll(weakHashMap.keySet());
        }
        return arrayList;
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
            if (!this.mConfigurationLocked.isInMemoryDb()) {
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                if ((sQLiteDatabaseConfiguration.openFlags & 4) != 0) {
                    ensureFile(sQLiteDatabaseConfiguration.path);
                }
            }
            try {
                openInner();
            } catch (SQLiteDatabaseCorruptException unused) {
                onCorruption();
                openInner();
            }
        } catch (SQLiteException e10) {
            Log.e(TAG, "Failed to open database '" + getLabel() + "'.", e10);
            close();
            throw e10;
        }
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i10) {
        return openDatabase(str, cursorFactory, i10, null);
    }

    private void openInner() {
        synchronized (this.mLock) {
            this.mConnectionPoolLocked = SQLiteConnectionPool.open(this.mConfigurationLocked);
            this.mCloseGuardLocked.open("close");
        }
        WeakHashMap<SQLiteDatabase, Object> weakHashMap = sActiveDatabases;
        synchronized (weakHashMap) {
            weakHashMap.put(this, null);
        }
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file.getPath(), cursorFactory);
    }

    public static int releaseMemory() {
        return SQLiteGlobal.releaseMemory();
    }

    private void throwIfNotOpenLocked() {
        if (this.mConnectionPoolLocked != null) {
            return;
        }
        throw new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
    }

    private boolean yieldIfContendedHelper(boolean z10, long j10) {
        acquireReference();
        try {
            return getThreadSession().yieldTransaction(j10, z10, null);
        } finally {
            releaseReference();
        }
    }

    @Deprecated
    public void addCustomFunction(String str, int i10, CustomFunction customFunction) {
        SQLiteCustomFunction sQLiteCustomFunction = new SQLiteCustomFunction(str, i10, customFunction);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                this.mConfigurationLocked.customFunctions.add(sQLiteCustomFunction);
                try {
                    this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                } catch (RuntimeException e10) {
                    this.mConfigurationLocked.customFunctions.remove(sQLiteCustomFunction);
                    throw e10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addFunction(String str, int i10, Function function) {
        addFunction(str, i10, function, 0);
    }

    @Override // j1.InterfaceC4756c
    public void beginTransaction() {
        beginTransaction(null, 2);
    }

    public void beginTransactionDeferred() {
        beginTransaction(null, 0);
    }

    @Override // j1.InterfaceC4756c
    public void beginTransactionNonExclusive() {
        beginTransaction(null, 1);
    }

    @Override // j1.InterfaceC4756c
    public /* bridge */ /* synthetic */ void beginTransactionReadOnly() {
        super.beginTransactionReadOnly();
    }

    @Override // j1.InterfaceC4756c
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, 2);
    }

    public void beginTransactionWithListenerDeferred(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, 0);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransaction(sQLiteTransactionListener, 1);
    }

    @Override // j1.InterfaceC4756c
    public /* bridge */ /* synthetic */ void beginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) {
        super.beginTransactionWithListenerReadOnly(sQLiteTransactionListener);
    }

    public ParcelFileDescriptor blobFileDescriptorForQuery(String str, String[] strArr) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = compileStatement(str);
        try {
            return blobFileDescriptorForQuery(sQLiteStatementCompileStatement, strArr);
        } finally {
            sQLiteStatementCompileStatement.close();
        }
    }

    public SQLiteSession createSession() {
        SQLiteConnectionPool sQLiteConnectionPool;
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            sQLiteConnectionPool = this.mConnectionPoolLocked;
        }
        return new SQLiteSession(sQLiteConnectionPool);
    }

    public int delete(String str, String str2, String[] strArr) {
        String str3;
        acquireReference();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DELETE FROM ");
            sb2.append(str);
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                str3 = " WHERE " + str2;
            }
            sb2.append(str3);
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb2.toString(), strArr);
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

    @Override // j1.InterfaceC4756c
    public void disableWriteAheadLogging() {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                int i10 = sQLiteDatabaseConfiguration.openFlags;
                if ((i10 & ENABLE_WRITE_AHEAD_LOGGING) == 0) {
                    return;
                }
                sQLiteDatabaseConfiguration.openFlags = i10 & (-536870913);
                try {
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e10) {
                    this.mConfigurationLocked.openFlags |= ENABLE_WRITE_AHEAD_LOGGING;
                    throw e10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void enableLocalizedCollators() {
        this.mConnectionPoolLocked.enableLocalizedCollators();
    }

    @Override // j1.InterfaceC4756c
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
                    Log.i(TAG, "can't enable WAL for memory databases.");
                    return false;
                }
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                sQLiteDatabaseConfiguration.openFlags = 536870912 | sQLiteDatabaseConfiguration.openFlags;
                try {
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                    return true;
                } catch (RuntimeException e10) {
                    this.mConfigurationLocked.openFlags &= -536870913;
                    throw e10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j1.InterfaceC4756c
    public void endTransaction() {
        acquireReference();
        try {
            getThreadSession().endTransaction(null);
        } finally {
            releaseReference();
        }
    }

    @Override // j1.InterfaceC4756c
    public /* bridge */ /* synthetic */ void execPerConnectionSQL(String str, @SuppressLint({"ArrayReturn"}) Object[] objArr) {
        super.execPerConnectionSQL(str, objArr);
    }

    @Override // j1.InterfaceC4756c
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

    @Override // j1.InterfaceC4756c
    public List<Pair<String, String>> getAttachedDbs() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            try {
                Cursor cursorRawQuery = null;
                if (this.mConnectionPoolLocked == null) {
                    return null;
                }
                acquireReference();
                try {
                    try {
                        cursorRawQuery = rawQuery("pragma database_list;", null);
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
        return longForQuery("PRAGMA max_page_count;", (String[]) null) * getPageSize();
    }

    public long getPageSize() {
        return longForQuery("PRAGMA page_size;", (String[]) null);
    }

    @Override // j1.InterfaceC4756c
    public final String getPath() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.path;
        }
        return str;
    }

    public int getThreadDefaultConnectionFlags(boolean z10) {
        int i10 = z10 ? 1 : 2;
        return isMainThread() ? i10 | 4 : i10;
    }

    public SQLiteSession getThreadSession() {
        return this.mThreadSession.get();
    }

    public int getVersion() {
        return Long.valueOf(longForQuery("PRAGMA user_version;", (String[]) null)).intValue();
    }

    @Override // j1.InterfaceC4756c
    public boolean inTransaction() {
        acquireReference();
        try {
            return getThreadSession().hasTransaction();
        } finally {
            releaseReference();
        }
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLException e10) {
            Log.e(TAG, "Error inserting " + contentValues, e10);
            return -1L;
        }
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    public long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i10) {
        Object[] objArr;
        acquireReference();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("INSERT");
            sb2.append(CONFLICT_VALUES[i10]);
            sb2.append(" INTO ");
            sb2.append(str);
            sb2.append('(');
            int i11 = 0;
            int size = (contentValues == null || contentValues.size() <= 0) ? 0 : contentValues.size();
            if (size > 0) {
                objArr = new Object[size];
                int i12 = 0;
                for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                    sb2.append(i12 > 0 ? Const.STR_MART_COMMA : "");
                    sb2.append(entry.getKey());
                    objArr[i12] = entry.getValue();
                    i12++;
                }
                sb2.append(')');
                sb2.append(" VALUES (");
                while (i11 < size) {
                    sb2.append(i11 > 0 ? ",?" : "?");
                    i11++;
                }
            } else {
                sb2.append(str2 + ") VALUES (NULL");
                objArr = null;
            }
            sb2.append(')');
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb2.toString(), objArr);
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
        List<Pair<String, String>> arrayList;
        acquireReference();
        try {
            try {
                arrayList = getAttachedDbs();
            } catch (SQLiteException unused) {
                arrayList = new ArrayList<>();
                arrayList.add(new Pair<>("main", getPath()));
            }
            if (arrayList == null) {
                throw new IllegalStateException("databaselist for: " + getPath() + " couldn't be retrieved. probably because the database is closed");
            }
            for (Pair<String, String> pair : arrayList) {
                SQLiteStatement sQLiteStatementCompileStatement = null;
                try {
                    sQLiteStatementCompileStatement = compileStatement("PRAGMA " + ((String) pair.first) + ".integrity_check(1);");
                    String strSimpleQueryForString = sQLiteStatementCompileStatement.simpleQueryForString();
                    if (!strSimpleQueryForString.equalsIgnoreCase("ok")) {
                        Log.e(TAG, "PRAGMA integrity_check on " + ((String) pair.second) + " returned: " + strSimpleQueryForString);
                        sQLiteStatementCompileStatement.close();
                        releaseReference();
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
        } catch (Throwable th2) {
            releaseReference();
            throw th2;
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

    @Override // j1.InterfaceC4756c
    public /* bridge */ /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return super.isExecPerConnectionSQLSupported();
    }

    public boolean isInMemoryDatabase() {
        boolean zIsInMemoryDb;
        synchronized (this.mLock) {
            zIsInMemoryDb = this.mConfigurationLocked.isInMemoryDb();
        }
        return zIsInMemoryDb;
    }

    @Override // j1.InterfaceC4756c
    public boolean isOpen() {
        boolean z10;
        synchronized (this.mLock) {
            z10 = this.mConnectionPoolLocked != null;
        }
        return z10;
    }

    public boolean isReadOnly() {
        boolean zIsReadOnlyLocked;
        synchronized (this.mLock) {
            zIsReadOnlyLocked = isReadOnlyLocked();
        }
        return zIsReadOnlyLocked;
    }

    @Override // j1.InterfaceC4756c
    public boolean isWriteAheadLoggingEnabled() {
        boolean z10;
        synchronized (this.mLock) {
            throwIfNotOpenLocked();
            z10 = (this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) != 0;
        }
        return z10;
    }

    public long longForQuery(String str, String[] strArr) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = compileStatement(str);
        try {
            return longForQuery(sQLiteStatementCompileStatement, strArr);
        } finally {
            sQLiteStatementCompileStatement.close();
        }
    }

    public boolean needUpgrade(int i10) {
        return i10 > getVersion();
    }

    @Override // io.requery.android.database.sqlite.SQLiteClosable
    public void onAllReferencesReleased() {
        dispose(false);
    }

    public void onCorruption() {
        EventLog.writeEvent(EVENT_DB_CORRUPT, getLabel());
        this.mErrorHandler.onCorruption(this);
    }

    public Cursor query(boolean z10, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        return queryWithFactory(null, z10, str, strArr, str2, objArr, str3, str4, str5, str6, null);
    }

    public long queryNumEntries(String str) {
        return queryNumEntries(str, null, null);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z10, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        return queryWithFactory(cursorFactory, z10, str, strArr, str2, objArr, str3, str4, str5, str6, null);
    }

    public Cursor rawQuery(String str, Object[] objArr) {
        return rawQueryWithFactory(null, str, objArr, null, null);
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, Object[] objArr, String str2) {
        return rawQueryWithFactory(cursorFactory, str, objArr, str2, null);
    }

    public void reopenReadWrite() {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (isReadOnlyLocked()) {
                    SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                    int i10 = sQLiteDatabaseConfiguration.openFlags;
                    sQLiteDatabaseConfiguration.openFlags = i10 & (-2);
                    try {
                        this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                    } catch (RuntimeException e10) {
                        this.mConfigurationLocked.openFlags = i10;
                        throw e10;
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
        } catch (SQLException e10) {
            Log.e(TAG, "Error inserting " + contentValues, e10);
            return -1L;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    public void setForeignKeyConstraintsEnabled(boolean z10) {
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                if (sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled == z10) {
                    return;
                }
                sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled = z10;
                try {
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e10) {
                    this.mConfigurationLocked.foreignKeyConstraintsEnabled = !z10;
                    throw e10;
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
                } catch (RuntimeException e10) {
                    this.mConfigurationLocked.locale = locale2;
                    throw e10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setMaxSqlCacheSize(int i10) {
        if (i10 > 100 || i10 < 0) {
            throw new IllegalStateException("expected value between 0 and 100");
        }
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                int i11 = sQLiteDatabaseConfiguration.maxSqlCacheSize;
                sQLiteDatabaseConfiguration.maxSqlCacheSize = i10;
                try {
                    this.mConnectionPoolLocked.reconfigure(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e10) {
                    this.mConfigurationLocked.maxSqlCacheSize = i11;
                    throw e10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long setMaximumSize(long j10) {
        long pageSize = getPageSize();
        long j11 = j10 / pageSize;
        if (j10 % pageSize != 0) {
            j11++;
        }
        return longForQuery("PRAGMA max_page_count = " + j11, (String[]) null) * pageSize;
    }

    public void setPageSize(long j10) throws SQLException {
        execSQL("PRAGMA page_size = " + j10);
    }

    @Override // j1.InterfaceC4756c
    public void setTransactionSuccessful() {
        acquireReference();
        try {
            getThreadSession().setTransactionSuccessful();
        } finally {
            releaseReference();
        }
    }

    public void setVersion(int i10) throws SQLException {
        execSQL("PRAGMA user_version = " + i10);
    }

    public String stringForQuery(String str, String[] strArr) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = compileStatement(str);
        try {
            return stringForQuery(sQLiteStatementCompileStatement, strArr);
        } finally {
            sQLiteStatementCompileStatement.close();
        }
    }

    public String toString() {
        return "SQLiteDatabase: " + getPath();
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    public int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i10) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        acquireReference();
        try {
            StringBuilder sb2 = new StringBuilder(120);
            sb2.append("UPDATE ");
            sb2.append(CONFLICT_VALUES[i10]);
            sb2.append(str);
            sb2.append(" SET ");
            int size = contentValues.size();
            int length = strArr == null ? size : strArr.length + size;
            Object[] objArr = new Object[length];
            int i11 = 0;
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                sb2.append(i11 > 0 ? Const.STR_MART_COMMA : "");
                sb2.append(entry.getKey());
                objArr[i11] = entry.getValue();
                sb2.append("=?");
                i11++;
            }
            if (strArr != null) {
                for (int i12 = size; i12 < length; i12++) {
                    objArr[i12] = strArr[i12 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(" WHERE ");
                sb2.append(str2);
            }
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb2.toString(), objArr);
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

    public void validateSql(String str, d dVar) {
        getThreadSession().prepare(str, getThreadDefaultConnectionFlags(true), dVar, null);
    }

    public boolean yieldIfContendedSafely() {
        return yieldIfContendedHelper(true, -1L);
    }

    private void beginTransaction(SQLiteTransactionListener sQLiteTransactionListener, int i10) {
        acquireReference();
        try {
            getThreadSession().beginTransaction(i10, sQLiteTransactionListener, getThreadDefaultConnectionFlags(false), null);
        } finally {
            releaseReference();
        }
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i10, DatabaseErrorHandler databaseErrorHandler) {
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(new SQLiteDatabaseConfiguration(str, i10), cursorFactory, databaseErrorHandler);
        sQLiteDatabase.open();
        return sQLiteDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory) {
        return openDatabase(str, cursorFactory, 6, null);
    }

    public void addFunction(String str, int i10, Function function, int i11) {
        SQLiteFunction sQLiteFunction = new SQLiteFunction(str, i10, function, i11);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                this.mConfigurationLocked.functions.add(sQLiteFunction);
                try {
                    this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                } catch (RuntimeException e10) {
                    this.mConfigurationLocked.functions.remove(sQLiteFunction);
                    throw e10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j1.InterfaceC4756c
    public SQLiteStatement compileStatement(String str) throws SQLException {
        acquireReference();
        try {
            return new SQLiteStatement(this, str, null);
        } finally {
            releaseReference();
        }
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        if (objArr == null) {
            throw new IllegalArgumentException("Empty bindArgs");
        }
        executeSql(str, objArr);
    }

    public Cursor query(boolean z10, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6, d dVar) {
        return queryWithFactory(null, z10, str, strArr, str2, objArr, str3, str4, str5, str6, dVar);
    }

    public long queryNumEntries(String str, String str2) {
        return queryNumEntries(str, str2, null);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z10, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6, d dVar) {
        acquireReference();
        try {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z10, str, strArr, str2, str3, str4, str5, str6), objArr, findEditTable(str), dVar);
        } finally {
            releaseReference();
        }
    }

    public Cursor rawQuery(String str, Object[] objArr, d dVar) {
        return rawQueryWithFactory(null, str, objArr, null, dVar);
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, Object[] objArr, String str2, d dVar) {
        acquireReference();
        try {
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2, dVar);
            if (cursorFactory == null) {
                cursorFactory = this.mCursorFactory;
            }
            return sQLiteDirectCursorDriver.query(cursorFactory, objArr);
        } finally {
            releaseReference();
        }
    }

    public int update(String str, int i10, ContentValues contentValues, String str2, Object[] objArr) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        acquireReference();
        try {
            StringBuilder sb2 = new StringBuilder(120);
            sb2.append("UPDATE ");
            sb2.append(CONFLICT_VALUES[i10]);
            sb2.append(str);
            sb2.append(" SET ");
            int size = contentValues.size();
            int length = objArr == null ? size : objArr.length + size;
            Object[] objArr2 = new Object[length];
            int i11 = 0;
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                sb2.append(i11 > 0 ? Const.STR_MART_COMMA : "");
                sb2.append(entry.getKey());
                objArr2[i11] = entry.getValue();
                sb2.append("=?");
                i11++;
            }
            if (objArr != null) {
                for (int i12 = size; i12 < length; i12++) {
                    objArr2[i12] = objArr[i12 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(" WHERE ");
                sb2.append(str2);
            }
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb2.toString(), objArr2);
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

    public boolean yieldIfContendedSafely(long j10) {
        return yieldIfContendedHelper(true, j10);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cursorFactory, 6, databaseErrorHandler);
    }

    public long insert(String str, int i10, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, null, contentValues, i10);
    }

    public Cursor query(String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, objArr, str3, str4, str5, null);
    }

    public long queryNumEntries(String str, String str2, String[] strArr) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " where " + str2;
        }
        return longForQuery("select count(*) from " + str + str3, strArr);
    }

    public Cursor query(String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, objArr, str3, str4, str5, str6);
    }

    public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForBlobFileDescriptor();
    }

    private static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForLong();
    }

    public static SQLiteDatabase openDatabase(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(sQLiteDatabaseConfiguration, cursorFactory, databaseErrorHandler);
        sQLiteDatabase.open();
        return sQLiteDatabase;
    }

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        return sQLiteStatement.simpleQueryForString();
    }

    @Override // j1.InterfaceC4756c
    public Cursor query(String str) {
        return rawQueryWithFactory(null, str, null, null, null);
    }

    @Override // j1.InterfaceC4756c
    public Cursor query(String str, Object[] objArr) {
        return rawQueryWithFactory(null, str, objArr, null, null);
    }

    @Override // j1.InterfaceC4756c
    public Cursor query(InterfaceC4759f interfaceC4759f) {
        return query(interfaceC4759f, (d) null);
    }

    public Cursor query(InterfaceC4759f interfaceC4759f, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            final d dVar = new d();
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: io.requery.android.database.sqlite.SQLiteDatabase.3
                @Override // android.os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    dVar.a();
                }
            });
            return query(interfaceC4759f, dVar);
        }
        return query(interfaceC4759f, (d) null);
    }

    public int delete(String str, String str2, Object[] objArr) {
        String str3;
        acquireReference();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DELETE FROM ");
            sb2.append(str);
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                str3 = " WHERE " + str2;
            }
            sb2.append(str3);
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb2.toString(), objArr);
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

    public Cursor query(final InterfaceC4759f interfaceC4759f, d dVar) {
        return rawQueryWithFactory(new CursorFactory() { // from class: io.requery.android.database.sqlite.SQLiteDatabase.4
            @Override // io.requery.android.database.sqlite.SQLiteDatabase.CursorFactory
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                interfaceC4759f.c(sQLiteQuery);
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, interfaceC4759f.getQuery(), new String[0], null, dVar);
    }
}
