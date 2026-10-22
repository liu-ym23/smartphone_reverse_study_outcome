package net.sqlcipher.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import j1.InterfaceC4756c;
import j1.InterfaceC4759f;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.database.SQLiteDebug;

/* loaded from: classes5.dex */
public class SQLiteDatabase extends SQLiteClosable implements InterfaceC4756c {
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static final String KEY_ENCODING = "UTF-8";
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final String MEMORY = ":memory:";
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "4.5.4";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private int mCacheFullWarnings;
    Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    long mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private static int sQueryLogTimeInMillis = 0;

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    public interface LibraryLoader {
        void loadLibraries(String... strArr);
    }

    public enum SQLiteDatabaseTransactionType {
        Deferred,
        Immediate,
        Exclusive
    }

    public static class SyncUpdateInfo {
        String deletedTable;
        String foreignKey;
        String masterTable;

        public SyncUpdateInfo(String str, String str2, String str3) {
            this.masterTable = str;
            this.deletedTable = str2;
            this.foreignKey = str3;
        }
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i10) {
        this(str, cursorFactory, i10, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, (SQLiteDatabaseHook) null);
    }

    private void beginTransactionWithListenerInternal(SQLiteTransactionListener sQLiteTransactionListener, SQLiteDatabaseTransactionType sQLiteDatabaseTransactionType) {
        lockForced();
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        try {
            if (this.mLock.getHoldCount() > 1) {
                if (this.mInnerTransactionIsSuccessful) {
                    throw new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                }
                return;
            }
            if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Exclusive) {
                execSQL("BEGIN EXCLUSIVE;");
            } else if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Immediate) {
                execSQL("BEGIN IMMEDIATE;");
            } else {
                if (sQLiteDatabaseTransactionType != SQLiteDatabaseTransactionType.Deferred) {
                    throw new IllegalArgumentException(String.format("%s is an unsupported transaction type", sQLiteDatabaseTransactionType));
                }
                execSQL("BEGIN DEFERRED;");
            }
            this.mTransactionListener = sQLiteTransactionListener;
            this.mTransactionIsSuccessful = true;
            this.mInnerTransactionIsSuccessful = false;
            if (sQLiteTransactionListener != null) {
                try {
                    sQLiteTransactionListener.onBegin();
                } catch (RuntimeException e10) {
                    execSQL("ROLLBACK;");
                    throw e10;
                }
            }
        } catch (Throwable th) {
            unlockForced();
            throw th;
        }
    }

    private void checkLockHoldTime() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = jElapsedRealtime - this.mLockAcquiredWallTime;
        if ((j10 >= 2000 || Log.isLoggable(TAG, 2) || jElapsedRealtime - this.mLastLockMessageTime >= 20000) && j10 > 300) {
            if (((int) ((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000)) > 100 || j10 > 2000) {
                this.mLastLockMessageTime = jElapsedRealtime;
                boolean z10 = SQLiteDebug.DEBUG_SQL_STATEMENTS;
            }
        }
    }

    private void closeClosable() {
        deallocCachedSqlStatements();
        Iterator<Map.Entry<SQLiteClosable, Object>> it = this.mPrograms.entrySet().iterator();
        while (it.hasNext()) {
            SQLiteClosable key = it.next().getKey();
            if (key != null) {
                key.onAllReferencesReleasedFromContainer();
            }
        }
    }

    private boolean containsNull(char[] cArr) {
        if (cArr != null && cArr.length > 0) {
            for (char c10 : cArr) {
                if (c10 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, String str) {
        return openDatabase(":memory:", str == null ? null : str.toCharArray(), cursorFactory, CREATE_IF_NECESSARY);
    }

    private native void dbclose();

    private native void dbopen(String str, int i10);

    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            try {
                Iterator<SQLiteCompiledSql> it = this.mCompiledQueries.values().iterator();
                while (it.hasNext()) {
                    it.next().releaseSqlStatement();
                }
                this.mCompiledQueries.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

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

    public static byte[] getBytes(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        ByteBuffer byteBufferEncode = Charset.forName("UTF-8").encode(CharBuffer.wrap(cArr));
        byte[] bArr = new byte[byteBufferEncode.limit()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    public static char[] getChars(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        CharBuffer charBufferDecode = Charset.forName("UTF-8").decode(ByteBuffer.wrap(bArr));
        char[] cArr = new char[charBufferDecode.limit()];
        charBufferDecode.get(cArr);
        return cArr;
    }

    public static ArrayList<SQLiteDebug.DbStats> getDbStats() throws Throwable {
        String str;
        int i10;
        ArrayList<SQLiteDebug.DbStats> arrayList = new ArrayList<>();
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            SQLiteDatabase next = it.next();
            if (next != null && next.isOpen()) {
                int iNative_getDbLookaside = next.native_getDbLookaside();
                String path = next.getPath();
                int iLastIndexOf = path.lastIndexOf("/");
                String strSubstring = path.substring(iLastIndexOf != -1 ? iLastIndexOf + 1 : 0);
                ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(next);
                if (attachedDbs != null) {
                    int i11 = 0;
                    while (i11 < attachedDbs.size()) {
                        Pair<String, String> pair = attachedDbs.get(i11);
                        long pragmaVal = getPragmaVal(next, ((String) pair.first) + ".page_count;");
                        if (i11 == 0) {
                            i10 = iNative_getDbLookaside;
                            str = strSubstring;
                        } else {
                            String string = "  (attached) " + ((String) pair.first);
                            if (((String) pair.second).trim().length() > 0) {
                                int iLastIndexOf2 = ((String) pair.second).lastIndexOf("/");
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(string);
                                sb2.append(" : ");
                                sb2.append(((String) pair.second).substring(iLastIndexOf2 != -1 ? iLastIndexOf2 + 1 : 0));
                                string = sb2.toString();
                            }
                            str = string;
                            i10 = 0;
                        }
                        if (pragmaVal > 0) {
                            arrayList.add(new SQLiteDebug.DbStats(str, pragmaVal, next.getPageSize(), i10));
                        }
                        i11++;
                        iNative_getDbLookaside = i10;
                    }
                }
            }
        }
        return arrayList;
    }

    private String getPathForLogs() {
        String str = this.mPathForLogs;
        if (str != null) {
            return str;
        }
        String str2 = this.mPath;
        if (str2 == null) {
            return null;
        }
        if (str2.indexOf(64) == -1) {
            this.mPathForLogs = this.mPath;
        } else {
            this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        }
        return this.mPathForLogs;
    }

    private static long getPragmaVal(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        if (!sQLiteDatabase.isOpen()) {
            return 0L;
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            SQLiteStatement sQLiteStatement2 = new SQLiteStatement(sQLiteDatabase, "PRAGMA " + str);
            try {
                long jSimpleQueryForLong = sQLiteStatement2.simpleQueryForLong();
                sQLiteStatement2.close();
                return jSimpleQueryForLong;
            } catch (Throwable th) {
                th = th;
                sQLiteStatement = sQLiteStatement2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private Pair<Boolean, String> getResultFromPragma(String str) {
        Pair<Boolean, String> pair = new Pair<>(Boolean.FALSE, "");
        Cursor cursorRawQuery = rawQuery(str, new Object[0]);
        if (cursorRawQuery == null) {
            return pair;
        }
        if (cursorRawQuery.moveToFirst()) {
            pair = new Pair<>(Boolean.TRUE, cursorRawQuery.getString(0));
        }
        cursorRawQuery.close();
        return pair;
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void key(byte[] bArr) throws SQLException;

    private void keyDatabase(SQLiteDatabaseHook sQLiteDatabaseHook, Runnable runnable) {
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.preKey(this);
        }
        if (runnable != null) {
            runnable.run();
        }
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.postKey(this);
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            this.mTimeOpened = getTime();
        }
        Cursor cursorRawQuery = rawQuery("select count(*) from sqlite_master;", new String[0]);
        if (cursorRawQuery != null) {
            cursorRawQuery.moveToFirst();
            cursorRawQuery.getInt(0);
            cursorRawQuery.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void key_mutf8(char[] cArr) throws SQLException;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b A[Catch: IOException -> 0x0092, TRY_LEAVE, TryCatch #2 {IOException -> 0x0092, blocks: (B:46:0x0086, B:48:0x008b), top: B:56:0x0086 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void loadICUData(android.content.Context r5, java.io.File r6) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "icu"
            r0.<init>(r6, r1)
            java.io.File r6 = new java.io.File
            java.lang.String r1 = "icudt46l.dat"
            r6.<init>(r0, r1)
            r1 = 0
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1d
            if (r2 != 0) goto L20
            r0.mkdirs()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1d
            goto L20
        L19:
            r5 = move-exception
            r6 = r1
            goto L84
        L1d:
            r5 = move-exception
            r0 = r1
            goto L75
        L20:
            boolean r0 = r6.exists()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1d
            if (r0 != 0) goto L5e
            java.util.zip.ZipInputStream r0 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1d
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1d
            java.lang.String r2 = "icudt46l.zip"
            java.io.InputStream r5 = r5.open(r2)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1d
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1d
            r0.getNextEntry()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5c
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5c
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5c
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L52
        L41:
            int r2 = r0.read(r1)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L52
            if (r2 <= 0) goto L57
            r3 = 0
            r5.write(r1, r3, r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L52
            goto L41
        L4c:
            r6 = move-exception
            r1 = r6
            r6 = r5
            r5 = r1
        L50:
            r1 = r0
            goto L84
        L52:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
            goto L75
        L57:
            r1 = r0
            goto L5f
        L59:
            r5 = move-exception
            r6 = r1
            goto L50
        L5c:
            r5 = move-exception
            goto L75
        L5e:
            r5 = r1
        L5f:
            if (r1 == 0) goto L64
            r1.close()     // Catch: java.io.IOException -> L6d
        L64:
            if (r5 == 0) goto L74
            r5.flush()     // Catch: java.io.IOException -> L6d
            r5.close()     // Catch: java.io.IOException -> L6d
            return
        L6d:
            r5 = move-exception
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>(r5)
            throw r6
        L74:
            return
        L75:
            boolean r2 = r6.exists()     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L7e
            r6.delete()     // Catch: java.lang.Throwable -> L59
        L7e:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L59
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L59
            throw r6     // Catch: java.lang.Throwable -> L59
        L84:
            if (r1 == 0) goto L89
            r1.close()     // Catch: java.io.IOException -> L92
        L89:
            if (r6 == 0) goto L99
            r6.flush()     // Catch: java.io.IOException -> L92
            r6.close()     // Catch: java.io.IOException -> L92
            goto L99
        L92:
            r5 = move-exception
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>(r5)
            throw r6
        L99:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.loadICUData(android.content.Context, java.io.File):void");
    }

    public static synchronized void loadLibs(Context context) {
        loadLibs(context, context.getFilesDir());
    }

    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        }
    }

    private native int native_getDbLookaside();

    private native void native_rawExecSQL(String str);

    private native int native_status(int i10, boolean z10);

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i10) {
        return openDatabase(str, str2, cursorFactory, i10, (SQLiteDatabaseHook) null);
    }

    private void openDatabaseInternal(char[] cArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        openDatabaseInternal(getBytes(cArr), sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openOrCreateDatabase(file, str, cursorFactory, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    private native void rekey(byte[] bArr) throws SQLException;

    public static native int releaseMemory();

    public static native void setICURoot(String str);

    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            checkLockHoldTime();
        }
        this.mLock.unlock();
    }

    private boolean yieldIfContendedHelper(boolean z10, long j10) throws InterruptedException {
        if (this.mLock.getQueueLength() == 0) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
        endTransaction();
        if (z10 && isDbLockedByCurrentThread()) {
            throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
        }
        if (j10 > 0) {
            while (j10 > 0) {
                try {
                    Thread.sleep(j10 < 1000 ? j10 : 1000L);
                } catch (InterruptedException unused) {
                    Thread.interrupted();
                }
                j10 -= 1000;
                if (this.mLock.getQueueLength() == 0) {
                    break;
                }
            }
        }
        beginTransactionWithListener(sQLiteTransactionListener);
        return true;
    }

    public void addSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.put(sQLiteClosable, null);
        } finally {
            unlock();
        }
    }

    public void addToCompiledQueries(String str, SQLiteCompiledSql sQLiteCompiledSql) {
        if (this.mMaxSqlCacheSize == 0) {
            boolean z10 = SQLiteDebug.DEBUG_SQL_STATEMENTS;
            return;
        }
        synchronized (this.mCompiledQueries) {
            try {
                if (this.mCompiledQueries.get(str) != null) {
                    return;
                }
                if (this.mCompiledQueries.size() == this.mMaxSqlCacheSize) {
                    this.mCacheFullWarnings++;
                } else {
                    this.mCompiledQueries.put(str, sQLiteCompiledSql);
                    boolean z11 = SQLiteDebug.DEBUG_SQL_STATEMENTS;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j1.InterfaceC4756c
    public void beginTransaction() {
        beginTransactionWithListener((SQLiteTransactionListener) null);
    }

    @Override // j1.InterfaceC4756c
    public void beginTransactionNonExclusive() {
        beginTransactionWithListenerInternal(null, SQLiteDatabaseTransactionType.Immediate);
    }

    @Override // j1.InterfaceC4756c
    public /* bridge */ /* synthetic */ void beginTransactionReadOnly() {
        super.beginTransactionReadOnly();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Exclusive);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Immediate);
    }

    @Override // j1.InterfaceC4756c
    public /* bridge */ /* synthetic */ void beginTransactionWithListenerReadOnly(android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        super.beginTransactionWithListenerReadOnly(sQLiteTransactionListener);
    }

    public void changePassword(String str) throws SQLException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        if (str != null) {
            byte[] bytes = getBytes(str.toCharArray());
            rekey(bytes);
            Arrays.fill(bytes, (byte) 0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (isOpen()) {
            lock();
            try {
                closeClosable();
                onAllReferencesReleased();
            } finally {
                unlock();
            }
        }
    }

    public int delete(String str, String str2, String[] strArr) {
        return delete(str, str2, (Object[]) strArr);
    }

    @Override // j1.InterfaceC4756c
    public void disableWriteAheadLogging() {
        if (inTransaction()) {
            throw new IllegalStateException("Write Ahead Logging cannot be disabled while in a transaction");
        }
        rawExecSQL("PRAGMA journal_mode = DELETE;");
    }

    @Override // j1.InterfaceC4756c
    public boolean enableWriteAheadLogging() {
        if (inTransaction()) {
            throw new IllegalStateException("Write Ahead Logging cannot be enabled while in a transaction");
        }
        ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(this);
        if ((attachedDbs != null && attachedDbs.size() > 1) || isReadOnly() || getPath().equals(":memory:")) {
            return false;
        }
        rawExecSQL("PRAGMA journal_mode = WAL;");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0044 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #2 {all -> 0x0017, blocks: (B:7:0x000f, B:9:0x0014, B:13:0x001b, B:18:0x002a, B:20:0x002e, B:22:0x0032, B:25:0x0038, B:29:0x0040, B:31:0x0044, B:33:0x004a, B:36:0x0052, B:27:0x003c, B:12:0x0019), top: B:49:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // j1.InterfaceC4756c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void endTransaction() {
        /*
            r4 = this;
            boolean r0 = r4.isOpen()
            if (r0 == 0) goto L61
            java.util.concurrent.locks.ReentrantLock r0 = r4.mLock
            boolean r0 = r0.isHeldByCurrentThread()
            if (r0 == 0) goto L59
            r0 = 0
            boolean r1 = r4.mInnerTransactionIsSuccessful     // Catch: java.lang.Throwable -> L17
            r2 = 0
            if (r1 == 0) goto L19
            r4.mInnerTransactionIsSuccessful = r2     // Catch: java.lang.Throwable -> L17
            goto L1b
        L17:
            r1 = move-exception
            goto L53
        L19:
            r4.mTransactionIsSuccessful = r2     // Catch: java.lang.Throwable -> L17
        L1b:
            java.util.concurrent.locks.ReentrantLock r1 = r4.mLock     // Catch: java.lang.Throwable -> L17
            int r1 = r1.getHoldCount()     // Catch: java.lang.Throwable -> L17
            r3 = 1
            if (r1 == r3) goto L2a
        L24:
            r4.mTransactionListener = r0
            r4.unlockForced()
            return
        L2a:
            net.sqlcipher.database.SQLiteTransactionListener r1 = r4.mTransactionListener     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L3f
            boolean r3 = r4.mTransactionIsSuccessful     // Catch: java.lang.Throwable -> L17 java.lang.RuntimeException -> L36
            if (r3 == 0) goto L38
            r1.onCommit()     // Catch: java.lang.Throwable -> L17 java.lang.RuntimeException -> L36
            goto L3f
        L36:
            r1 = move-exception
            goto L3c
        L38:
            r1.onRollback()     // Catch: java.lang.Throwable -> L17 java.lang.RuntimeException -> L36
            goto L3f
        L3c:
            r4.mTransactionIsSuccessful = r2     // Catch: java.lang.Throwable -> L17
            goto L40
        L3f:
            r1 = r0
        L40:
            boolean r2 = r4.mTransactionIsSuccessful     // Catch: java.lang.Throwable -> L17
            if (r2 == 0) goto L4a
            java.lang.String r1 = "COMMIT;"
            r4.execSQL(r1)     // Catch: java.lang.Throwable -> L17
            goto L24
        L4a:
            java.lang.String r2 = "ROLLBACK;"
            r4.execSQL(r2)     // Catch: java.lang.Throwable -> L17 android.database.SQLException -> L24
            if (r1 != 0) goto L52
            goto L24
        L52:
            throw r1     // Catch: java.lang.Throwable -> L17 android.database.SQLException -> L24
        L53:
            r4.mTransactionListener = r0
            r4.unlockForced()
            throw r1
        L59:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "no transaction pending"
            r4.<init>(r0)
            throw r4
        L61:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "database not open"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.endTransaction():void");
    }

    @Override // j1.InterfaceC4756c
    public /* bridge */ /* synthetic */ void execPerConnectionSQL(String str, @SuppressLint({"ArrayReturn"}) Object[] objArr) {
        super.execPerConnectionSQL(str, objArr);
    }

    @Override // j1.InterfaceC4756c
    public void execSQL(String str) throws SQLException {
        SystemClock.uptimeMillis();
        lock();
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                native_execSQL(str);
            } catch (SQLiteDatabaseCorruptException e10) {
                onCorruption();
                throw e10;
            }
        } finally {
            unlock();
        }
    }

    public void finalize() {
        if (isOpen()) {
            closeClosable();
            onAllReferencesReleased();
        }
    }

    @Override // j1.InterfaceC4756c
    public List<Pair<String, String>> getAttachedDbs() {
        return getAttachedDbs(this);
    }

    public SQLiteCompiledSql getCompiledStatementForSql(String str) {
        synchronized (this.mCompiledQueries) {
            try {
                if (this.mMaxSqlCacheSize == 0) {
                    boolean z10 = SQLiteDebug.DEBUG_SQL_STATEMENTS;
                    return null;
                }
                SQLiteCompiledSql sQLiteCompiledSql = this.mCompiledQueries.get(str);
                boolean z11 = sQLiteCompiledSql != null;
                if (z11) {
                    this.mNumCacheHits++;
                } else {
                    this.mNumCacheMisses++;
                }
                boolean z12 = SQLiteDebug.DEBUG_SQL_STATEMENTS;
                return sQLiteCompiledSql;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized int getMaxSqlCacheSize() {
        return this.mMaxSqlCacheSize;
    }

    public long getMaximumSize() throws Throwable {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            sQLiteStatement = new SQLiteStatement(this, "PRAGMA max_page_count;");
            try {
                long jSimpleQueryForLong = sQLiteStatement.simpleQueryForLong() * getPageSize();
                sQLiteStatement.close();
                unlock();
                return jSimpleQueryForLong;
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        } catch (Throwable th3) {
            sQLiteStatement = null;
            th = th3;
        }
    }

    public long getPageSize() throws Throwable {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            sQLiteStatement = new SQLiteStatement(this, "PRAGMA page_size;");
            try {
                long jSimpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
                unlock();
                return jSimpleQueryForLong;
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        } catch (Throwable th3) {
            sQLiteStatement = null;
            th = th3;
        }
    }

    @Override // j1.InterfaceC4756c
    public final String getPath() {
        return this.mPath;
    }

    public SQLiteQueryStats getQueryStats(String str, Object[] objArr) throws SQLException {
        try {
            execSQL(String.format("CREATE TABLE tempstat AS %s", str), objArr);
            Cursor cursorRawQuery = rawQuery("SELECT sum(payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (cursorRawQuery == null) {
                return new SQLiteQueryStats(0L, 0L);
            }
            cursorRawQuery.moveToFirst();
            long j10 = cursorRawQuery.getLong(0);
            cursorRawQuery.close();
            Cursor cursorRawQuery2 = rawQuery("SELECT max(mx_payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (cursorRawQuery2 == null) {
                return new SQLiteQueryStats(j10, 0L);
            }
            cursorRawQuery2.moveToFirst();
            long j11 = cursorRawQuery2.getLong(0);
            cursorRawQuery2.close();
            execSQL("DROP TABLE tempstat;");
            return new SQLiteQueryStats(j10, j11);
        } catch (SQLiteException e10) {
            execSQL("DROP TABLE IF EXISTS tempstat;");
            throw e10;
        }
    }

    public Map<String, String> getSyncedTables() {
        HashMap map;
        synchronized (this.mSyncUpdateInfo) {
            try {
                map = new HashMap();
                for (String str : this.mSyncUpdateInfo.keySet()) {
                    String str2 = this.mSyncUpdateInfo.get(str).deletedTable;
                    if (str2 != null) {
                        map.put(str, str2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    public int getVersion() throws Throwable {
        SQLiteStatement sQLiteStatement;
        Throwable th;
        lock();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            sQLiteStatement = new SQLiteStatement(this, "PRAGMA user_version;");
            try {
                int iSimpleQueryForLong = (int) sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
                unlock();
                return iSimpleQueryForLong;
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        } catch (Throwable th3) {
            sQLiteStatement = null;
            th = th3;
        }
    }

    @Override // j1.InterfaceC4756c
    public boolean inTransaction() {
        return this.mLock.getHoldCount() > 0;
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLException unused) {
            return -1L;
        }
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    public long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i10) {
        Set<Map.Entry<String, Object>> setValueSet;
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        StringBuilder sb2 = new StringBuilder(152);
        sb2.append("INSERT");
        sb2.append(CONFLICT_VALUES[i10]);
        sb2.append(" INTO ");
        sb2.append(str);
        StringBuilder sb3 = new StringBuilder(40);
        int i11 = 0;
        SQLiteStatement sQLiteStatementCompileStatement = null;
        if (contentValues == null || contentValues.size() <= 0) {
            sb2.append("(" + str2 + ") ");
            sb3.append("NULL");
            setValueSet = null;
        } else {
            setValueSet = contentValues.valueSet();
            Iterator<Map.Entry<String, Object>> it = setValueSet.iterator();
            sb2.append('(');
            boolean z10 = false;
            while (it.hasNext()) {
                if (z10) {
                    sb2.append(", ");
                    sb3.append(", ");
                }
                sb2.append(it.next().getKey());
                sb3.append('?');
                z10 = true;
            }
            sb2.append(')');
        }
        sb2.append(" VALUES(");
        sb2.append((CharSequence) sb3);
        sb2.append(");");
        lock();
        try {
            try {
                sQLiteStatementCompileStatement = compileStatement(sb2.toString());
                if (setValueSet != null) {
                    int size = setValueSet.size();
                    Iterator<Map.Entry<String, Object>> it2 = setValueSet.iterator();
                    while (i11 < size) {
                        i11++;
                        DatabaseUtils.bindObjectToProgram(sQLiteStatementCompileStatement, i11, it2.next().getValue());
                    }
                }
                sQLiteStatementCompileStatement.execute();
                long jLastInsertRow = lastChangeCount() > 0 ? lastInsertRow() : -1L;
                sQLiteStatementCompileStatement.close();
                unlock();
                return jLastInsertRow;
            } catch (SQLiteDatabaseCorruptException e10) {
                onCorruption();
                throw e10;
            }
        } catch (Throwable th) {
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
            unlock();
            throw th;
        }
    }

    public boolean isDatabaseIntegrityOk() {
        Pair<Boolean, String> resultFromPragma = getResultFromPragma("PRAGMA integrity_check;");
        return ((Boolean) resultFromPragma.first).booleanValue() ? ((String) resultFromPragma.second).equals("ok") : ((Boolean) resultFromPragma.first).booleanValue();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        return !this.mLock.isHeldByCurrentThread() && this.mLock.isLocked();
    }

    @Override // j1.InterfaceC4756c
    public /* bridge */ /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return super.isExecPerConnectionSQLSupported();
    }

    public boolean isInCompiledSqlCache(String str) {
        boolean zContainsKey;
        synchronized (this.mCompiledQueries) {
            zContainsKey = this.mCompiledQueries.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // j1.InterfaceC4756c
    public boolean isOpen() {
        return this.mNativeHandle != 0;
    }

    public boolean isReadOnly() {
        return (this.mFlags & 1) == 1;
    }

    @Override // j1.InterfaceC4756c
    public boolean isWriteAheadLoggingEnabled() {
        Pair<Boolean, String> resultFromPragma = getResultFromPragma("PRAGMA journal_mode;");
        return ((Boolean) resultFromPragma.first).booleanValue() ? ((String) resultFromPragma.second).equals("wal") : ((Boolean) resultFromPragma.first).booleanValue();
    }

    public native int lastChangeCount();

    public native long lastInsertRow();

    public void lock() {
        if (this.mLockingEnabled) {
            this.mLock.lock();
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            }
        }
    }

    public void markTableSyncable(String str, String str2) {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        markTableSyncable(str, StepOSRecipientEmailHistory._ID, str, str2);
    }

    public native void native_execSQL(String str) throws SQLException;

    public native void native_setLocale(String str, int i10);

    public boolean needUpgrade(int i10) {
        return i10 > getVersion();
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    public void onAllReferencesReleased() {
        if (isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            dbclose();
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
        }
    }

    public void onCorruption() {
        this.mErrorHandler.onCorruption(this);
    }

    public void purgeFromCompiledSqlCache(String str) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(str);
        }
    }

    public Cursor query(boolean z10, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(null, z10, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z10, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (isOpen()) {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z10, str, strArr, str2, str3, str4, str5, str6), strArr2, findEditTable(str));
        }
        throw new IllegalStateException("database not open");
    }

    public void rawExecSQL(String str) {
        SystemClock.uptimeMillis();
        lock();
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                native_rawExecSQL(str);
            } catch (SQLiteDatabaseCorruptException e10) {
                onCorruption();
                throw e10;
            }
        } finally {
            unlock();
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return rawQueryWithFactory(null, str, strArr, null);
    }

    /* JADX WARN: Finally extract failed */
    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        long jCurrentTimeMillis = this.mSlowQueryThreshold != -1 ? System.currentTimeMillis() : 0L;
        SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2);
        if (cursorFactory == null) {
            try {
                cursorFactory = this.mFactory;
            } catch (Throwable th) {
                if (this.mSlowQueryThreshold != -1) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (jCurrentTimeMillis2 >= this.mSlowQueryThreshold) {
                        Log.v(TAG, "query (" + jCurrentTimeMillis2 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is -1");
                    }
                }
                throw th;
            }
        }
        Cursor cursorQuery = sQLiteDirectCursorDriver.query(cursorFactory, strArr);
        if (this.mSlowQueryThreshold != -1) {
            int count = cursorQuery != null ? cursorQuery.getCount() : -1;
            long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (jCurrentTimeMillis3 >= this.mSlowQueryThreshold) {
                Log.v(TAG, "query (" + jCurrentTimeMillis3 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is " + count);
            }
        }
        return new CrossProcessCursorWrapper(cursorQuery);
    }

    public void removeSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.remove(sQLiteClosable);
        } finally {
            unlock();
        }
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 5);
        } catch (SQLException unused) {
            return -1L;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    public void resetCompiledSqlCache() {
        deallocCachedSqlStatements();
    }

    public void rowUpdated(String str, long j10) throws SQLException {
        SyncUpdateInfo syncUpdateInfo;
        synchronized (this.mSyncUpdateInfo) {
            syncUpdateInfo = this.mSyncUpdateInfo.get(str);
        }
        if (syncUpdateInfo != null) {
            execSQL("UPDATE " + syncUpdateInfo.masterTable + " SET _sync_dirty=1 WHERE _id=(SELECT " + syncUpdateInfo.foreignKey + " FROM " + str + " WHERE _id=" + j10 + ")");
        }
    }

    public void setForeignKeyConstraintsEnabled(boolean z10) throws SQLException {
        if (inTransaction()) {
            throw new IllegalStateException("Foreign key constraints may not be changed while in a transaction");
        }
        execSQL(String.format("PRAGMA foreign_keys = %s;", z10 ? "ON" : "OFF"));
    }

    public void setLocale(Locale locale) {
        lock();
        try {
            native_setLocale(locale.toString(), this.mFlags);
        } finally {
            unlock();
        }
    }

    public void setLockingEnabled(boolean z10) {
        this.mLockingEnabled = z10;
    }

    public synchronized void setMaxSqlCacheSize(int i10) {
        if (i10 > 250 || i10 < 0) {
            throw new IllegalStateException("expected value between 0 and 250");
        }
        if (i10 < this.mMaxSqlCacheSize) {
            throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
        }
        this.mMaxSqlCacheSize = i10;
    }

    public long setMaximumSize(long j10) throws Throwable {
        lock();
        SQLiteStatement sQLiteStatement = null;
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            long pageSize = getPageSize();
            long j11 = j10 / pageSize;
            if (j10 % pageSize != 0) {
                j11++;
            }
            SQLiteStatement sQLiteStatement2 = new SQLiteStatement(this, "PRAGMA max_page_count = " + j11);
            try {
                long jSimpleQueryForLong = sQLiteStatement2.simpleQueryForLong() * pageSize;
                sQLiteStatement2.close();
                unlock();
                return jSimpleQueryForLong;
            } catch (Throwable th) {
                th = th;
                sQLiteStatement = sQLiteStatement2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void setPageSize(long j10) throws SQLException {
        execSQL("PRAGMA page_size = " + j10);
    }

    @Override // j1.InterfaceC4756c
    public void setTransactionSuccessful() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        if (!this.mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        }
        if (this.mInnerTransactionIsSuccessful) {
            throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
        }
        this.mInnerTransactionIsSuccessful = true;
    }

    public void setVersion(int i10) throws SQLException {
        execSQL("PRAGMA user_version = " + i10);
    }

    public int status(int i10, boolean z10) {
        return native_status(i10, z10);
    }

    public void unlock() {
        if (this.mLockingEnabled) {
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                checkLockHoldTime();
            }
            this.mLock.unlock();
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    public int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i10) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sb2 = new StringBuilder(120);
        sb2.append("UPDATE ");
        sb2.append(CONFLICT_VALUES[i10]);
        sb2.append(str);
        sb2.append(" SET ");
        Set<Map.Entry<String, Object>> setValueSet = contentValues.valueSet();
        Iterator<Map.Entry<String, Object>> it = setValueSet.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().getKey());
            sb2.append("=?");
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(" WHERE ");
            sb2.append(str2);
        }
        lock();
        AutoCloseable autoCloseable = null;
        try {
            try {
                try {
                    if (!isOpen()) {
                        throw new IllegalStateException("database not open");
                    }
                    SQLiteStatement sQLiteStatementCompileStatement = compileStatement(sb2.toString());
                    int size = setValueSet.size();
                    Iterator<Map.Entry<String, Object>> it2 = setValueSet.iterator();
                    int i11 = 1;
                    for (int i12 = 0; i12 < size; i12++) {
                        DatabaseUtils.bindObjectToProgram(sQLiteStatementCompileStatement, i11, it2.next().getValue());
                        i11++;
                    }
                    if (strArr != null) {
                        for (String str3 : strArr) {
                            sQLiteStatementCompileStatement.bindString(i11, str3);
                            i11++;
                        }
                    }
                    sQLiteStatementCompileStatement.execute();
                    int iLastChangeCount = lastChangeCount();
                    sQLiteStatementCompileStatement.close();
                    unlock();
                    return iLastChangeCount;
                } catch (SQLiteDatabaseCorruptException e10) {
                    onCorruption();
                    throw e10;
                }
            } catch (SQLException e11) {
                throw e11;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable.close();
            }
            unlock();
            throw th;
        }
    }

    @Deprecated
    public boolean yieldIfContended() {
        if (isOpen()) {
            return yieldIfContendedHelper(false, -1L);
        }
        return false;
    }

    public boolean yieldIfContendedSafely() {
        if (isOpen()) {
            return yieldIfContendedHelper(true, -1L);
        }
        return false;
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, char[] cArr) {
        return openDatabase(":memory:", cArr, cursorFactory, CREATE_IF_NECESSARY);
    }

    private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase sQLiteDatabase) {
        if (!sQLiteDatabase.isOpen()) {
            return null;
        }
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("pragma database_list;", (String[]) null);
        while (cursorRawQuery.moveToNext()) {
            arrayList.add(new Pair<>(cursorRawQuery.getString(1), cursorRawQuery.getString(2)));
        }
        cursorRawQuery.close();
        return arrayList;
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i10) {
        return openDatabase(str, cArr, cursorFactory, i10, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openOrCreateDatabase(file == null ? null : file.getPath(), str, cursorFactory, sQLiteDatabaseHook, databaseErrorHandler);
    }

    @Override // j1.InterfaceC4756c
    public void beginTransactionWithListener(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListener(new SQLiteTransactionListener() { // from class: net.sqlcipher.database.SQLiteDatabase.4
            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onBegin() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onCommit() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onRollback() {
                sQLiteTransactionListener.onRollback();
            }
        });
    }

    public void beginTransactionWithListenerNonExclusive(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerNonExclusive(new SQLiteTransactionListener() { // from class: net.sqlcipher.database.SQLiteDatabase.5
            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onBegin() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onCommit() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onRollback() {
                sQLiteTransactionListener.onRollback();
            }
        });
    }

    @Override // j1.InterfaceC4756c
    public SQLiteStatement compileStatement(String str) throws SQLException {
        lock();
        try {
            if (isOpen()) {
                return new SQLiteStatement(this, str);
            }
            throw new IllegalStateException("database not open");
        } finally {
            unlock();
        }
    }

    public int delete(String str, String str2, Object[] objArr) {
        String str3;
        lock();
        AutoCloseable autoCloseable = null;
        try {
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("DELETE FROM ");
                sb2.append(str);
                if (TextUtils.isEmpty(str2)) {
                    str3 = "";
                } else {
                    str3 = " WHERE " + str2;
                }
                sb2.append(str3);
                SQLiteStatement sQLiteStatementCompileStatement = compileStatement(sb2.toString());
                if (objArr != null) {
                    int length = objArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        int i11 = i10 + 1;
                        DatabaseUtils.bindObjectToProgram(sQLiteStatementCompileStatement, i11, objArr[i10]);
                        i10 = i11;
                    }
                }
                sQLiteStatementCompileStatement.execute();
                int iLastChangeCount = lastChangeCount();
                sQLiteStatementCompileStatement.close();
                unlock();
                return iLastChangeCount;
            } catch (SQLiteDatabaseCorruptException e10) {
                onCorruption();
                throw e10;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                autoCloseable.close();
            }
            unlock();
            throw th;
        }
    }

    public long insert(String str, int i10, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, null, contentValues, i10);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, null);
    }

    /* JADX WARN: Finally extract failed */
    public Cursor rawQuery(String str, Object[] objArr) {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
        long jCurrentTimeMillis = this.mSlowQueryThreshold != -1 ? System.currentTimeMillis() : 0L;
        SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, null);
        try {
            Cursor cursorQuery = sQLiteDirectCursorDriver.query(this.mFactory, objArr);
            if (this.mSlowQueryThreshold != -1) {
                int count = cursorQuery != null ? cursorQuery.getCount() : -1;
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (jCurrentTimeMillis2 >= this.mSlowQueryThreshold) {
                    Log.v(TAG, "query (" + jCurrentTimeMillis2 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is " + count);
                }
            }
            return new CrossProcessCursorWrapper(cursorQuery);
        } catch (Throwable th) {
            if (this.mSlowQueryThreshold != -1) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (jCurrentTimeMillis3 >= this.mSlowQueryThreshold) {
                    Log.v(TAG, "query (" + jCurrentTimeMillis3 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is -1");
                }
            }
            throw th;
        }
    }

    public int update(String str, int i10, ContentValues contentValues, String str2, Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        String[] strArr = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            strArr[i11] = objArr[i11].toString();
        }
        return updateWithOnConflict(str, contentValues, str2, strArr, i10);
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i10, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i10, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, sQLiteDatabaseHook);
    }

    public static synchronized void loadLibs(Context context, File file) {
        loadLibs(context, file, new LibraryLoader() { // from class: net.sqlcipher.database.SQLiteDatabase.1
            @Override // net.sqlcipher.database.SQLiteDatabase.LibraryLoader
            public void loadLibraries(String... strArr) {
                for (String str : strArr) {
                    System.loadLibrary(str);
                }
            }
        });
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i10, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, i10, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    private void openDatabaseInternal(final byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        dbopen(this.mPath, this.mFlags);
        try {
            try {
                keyDatabase(sQLiteDatabaseHook, new Runnable() { // from class: net.sqlcipher.database.SQLiteDatabase.2
                    @Override // java.lang.Runnable
                    public void run() throws SQLException {
                        byte[] bArr2 = bArr;
                        if (bArr2 == null || bArr2.length <= 0) {
                            return;
                        }
                        SQLiteDatabase.this.key(bArr2);
                    }
                });
            } catch (RuntimeException e10) {
                final char[] chars = getChars(bArr);
                if (containsNull(chars)) {
                    keyDatabase(sQLiteDatabaseHook, new Runnable() { // from class: net.sqlcipher.database.SQLiteDatabase.3
                        @Override // java.lang.Runnable
                        public void run() throws SQLException {
                            if (bArr != null) {
                                SQLiteDatabase.this.key_mutf8(chars);
                            }
                        }
                    });
                    if (bArr != null && bArr.length > 0) {
                        rekey(bArr);
                    }
                    if (chars == null || chars.length <= 0) {
                        return;
                    }
                    Arrays.fill(chars, (char) 0);
                    return;
                }
                throw e10;
            }
        } catch (Throwable th) {
            if (1 != 0) {
                dbclose();
                if (SQLiteDebug.DEBUG_SQL_CACHE) {
                    this.mTimeClosed = getTime();
                }
            }
            throw th;
        }
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, CREATE_IF_NECESSARY, sQLiteDatabaseHook);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public boolean yieldIfContendedSafely(long j10) {
        if (isOpen()) {
            return yieldIfContendedHelper(true, j10);
        }
        return false;
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i10, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, i10, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public void markTableSyncable(String str, String str2, String str3) {
        if (isOpen()) {
            markTableSyncable(str, str2, str3, null);
            return;
        }
        throw new SQLiteException("database not open");
    }

    @Override // j1.InterfaceC4756c
    public android.database.Cursor query(String str) {
        return rawQuery(str, (String[]) null);
    }

    public SQLiteDatabase(String str, byte[] bArr, CursorFactory cursorFactory, int i10, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i10, (DatabaseErrorHandler) null);
        openDatabaseInternal(bArr, sQLiteDatabaseHook);
    }

    public static synchronized void loadLibs(Context context, LibraryLoader libraryLoader) {
        loadLibs(context, context.getFilesDir(), libraryLoader);
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i10, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, i10, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, CREATE_IF_NECESSARY, sQLiteDatabaseHook);
    }

    @Override // j1.InterfaceC4756c
    public android.database.Cursor query(String str, Object[] objArr) {
        return rawQuery(str, objArr);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i10, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, getBytes(cArr), cursorFactory, i10, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cArr, cursorFactory, CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public void changePassword(char[] cArr) throws SQLException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        }
        if (cArr != null) {
            byte[] bytes = getBytes(cArr);
            rekey(bytes);
            Arrays.fill(bytes, (byte) 0);
        }
    }

    @Override // j1.InterfaceC4756c
    public android.database.Cursor query(InterfaceC4759f interfaceC4759f) {
        return query(interfaceC4759f, (CancellationSignal) null);
    }

    private SQLiteDatabase(String str, CursorFactory cursorFactory, int i10, DatabaseErrorHandler databaseErrorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0L;
        this.mLockAcquiredThreadTime = 0L;
        this.mLastLockMessageTime = 0L;
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0L;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = 250;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (str != null) {
            this.mFlags = i10;
            this.mPath = str;
            this.mSlowQueryThreshold = -1;
            this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            this.mFactory = cursorFactory;
            this.mPrograms = new WeakHashMap<>();
            this.mErrorHandler = databaseErrorHandler;
            return;
        }
        throw new IllegalArgumentException("path should not be null");
    }

    public static synchronized void loadLibs(Context context, File file, LibraryLoader libraryLoader) {
        libraryLoader.loadLibraries("sqlcipher");
    }

    private void markTableSyncable(String str, String str2, String str3, String str4) {
        lock();
        try {
            native_execSQL("SELECT _sync_dirty FROM " + str3 + " LIMIT 0");
            native_execSQL("SELECT " + str2 + " FROM " + str + " LIMIT 0");
            unlock();
            SyncUpdateInfo syncUpdateInfo = new SyncUpdateInfo(str3, str4, str2);
            synchronized (this.mSyncUpdateInfo) {
                this.mSyncUpdateInfo.put(str, syncUpdateInfo);
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, bArr, cursorFactory, CREATE_IF_NECESSARY, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public android.database.Cursor query(InterfaceC4759f interfaceC4759f, CancellationSignal cancellationSignal) {
        String strB = interfaceC4759f.getQuery();
        Object[] objArr = new Object[interfaceC4759f.a()];
        SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, strB, null);
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this, strB, 0, objArr);
        interfaceC4759f.c(sQLiteQuery);
        return new CrossProcessCursorWrapper(new SQLiteCursor(this, sQLiteDirectCursorDriver, null, sQLiteQuery));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static net.sqlcipher.database.SQLiteDatabase openDatabase(java.lang.String r2, byte[] r3, net.sqlcipher.database.SQLiteDatabase.CursorFactory r4, int r5, net.sqlcipher.database.SQLiteDatabaseHook r6, net.sqlcipher.DatabaseErrorHandler r7) {
        /*
            if (r7 == 0) goto L3
            goto L8
        L3:
            net.sqlcipher.DefaultDatabaseErrorHandler r7 = new net.sqlcipher.DefaultDatabaseErrorHandler
            r7.<init>()
        L8:
            r0 = 0
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L12
            r1.<init>(r2, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L12
            r1.openDatabaseInternal(r3, r6)     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L13
            goto L1e
        L12:
            r1 = r0
        L13:
            r7.onCorruption(r1)
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase
            r1.<init>(r2, r4, r5, r7)
            r1.openDatabaseInternal(r3, r6)
        L1e:
            boolean r3 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_STATEMENTS
            if (r3 == 0) goto L25
            r1.enableSqlTracing(r2)
        L25:
            boolean r3 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_TIME
            if (r3 == 0) goto L2c
            r1.enableSqlProfiling(r2)
        L2c:
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r2 = net.sqlcipher.database.SQLiteDatabase.sActiveDatabases
            monitor-enter(r2)
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r3 = net.sqlcipher.database.SQLiteDatabase.sActiveDatabases     // Catch: java.lang.Throwable -> L36
            r3.put(r1, r0)     // Catch: java.lang.Throwable -> L36
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            return r1
        L36:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.openDatabase(java.lang.String, byte[], net.sqlcipher.database.SQLiteDatabase$CursorFactory, int, net.sqlcipher.database.SQLiteDatabaseHook, net.sqlcipher.DatabaseErrorHandler):net.sqlcipher.database.SQLiteDatabase");
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, bArr, cursorFactory, CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file, str, cursorFactory, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory) {
        return openDatabase(str, str2, cursorFactory, CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory) {
        return openDatabase(str, cArr, cursorFactory, CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null);
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        if (objArr != null) {
            SystemClock.uptimeMillis();
            lock();
            AutoCloseable autoCloseable = null;
            try {
                try {
                    if (isOpen()) {
                        SQLiteStatement sQLiteStatementCompileStatement = compileStatement(str);
                        int length = objArr.length;
                        int i10 = 0;
                        while (i10 < length) {
                            int i11 = i10 + 1;
                            DatabaseUtils.bindObjectToProgram(sQLiteStatementCompileStatement, i11, objArr[i10]);
                            i10 = i11;
                        }
                        sQLiteStatementCompileStatement.execute();
                        sQLiteStatementCompileStatement.close();
                        unlock();
                        return;
                    }
                    throw new IllegalStateException("database not open");
                } catch (SQLiteDatabaseCorruptException e10) {
                    onCorruption();
                    throw e10;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    autoCloseable.close();
                }
                unlock();
                throw th;
            }
        }
        throw new IllegalArgumentException("Empty bindArgs");
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory) {
        return openDatabase(str, bArr, cursorFactory, CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public Cursor rawQuery(String str, String[] strArr, int i10, int i11) {
        CursorWrapper cursorWrapper = (CursorWrapper) rawQueryWithFactory(null, str, strArr, null);
        ((SQLiteCursor) cursorWrapper.getWrappedCursor()).setLoadStyle(i10, i11);
        return cursorWrapper;
    }
}
