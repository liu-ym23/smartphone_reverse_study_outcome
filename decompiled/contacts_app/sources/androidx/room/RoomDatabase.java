package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.migration.Migration;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    private AutoCloser mAutoCloser;
    private final Map<String, Object> mBackingFieldMap;

    @Deprecated
    protected List<Callback> mCallbacks;
    private final ReentrantReadWriteLock mCloseLock;

    @Deprecated
    protected volatile SupportSQLiteDatabase mDatabase;
    private final InvalidationTracker mInvalidationTracker;
    private SupportSQLiteOpenHelper mOpenHelper;
    private Executor mQueryExecutor;
    private final ThreadLocal<Integer> mSuspendingTransactionId;
    private Executor mTransactionExecutor;
    private final Map<Class<?>, Object> mTypeConverters;
    boolean mWriteAheadLoggingEnabled;

    public static class Builder<T extends RoomDatabase> {
        private boolean mAllowDestructiveMigrationOnDowngrade;
        private boolean mAllowMainThreadQueries;
        private TimeUnit mAutoCloseTimeUnit;
        private long mAutoCloseTimeout;
        private ArrayList<Callback> mCallbacks;
        private final Context mContext;
        private String mCopyFromAssetPath;
        private File mCopyFromFile;
        private Callable<InputStream> mCopyFromInputStream;
        private final Class<T> mDatabaseClass;
        private SupportSQLiteOpenHelper.Factory mFactory;
        private JournalMode mJournalMode;
        private final MigrationContainer mMigrationContainer;
        private Set<Integer> mMigrationStartAndEndVersions;
        private Set<Integer> mMigrationsNotRequiredFrom;
        private boolean mMultiInstanceInvalidation;
        private final String mName;
        private PrepackagedDatabaseCallback mPrepackagedDatabaseCallback;
        private QueryCallback mQueryCallback;
        private Executor mQueryCallbackExecutor;
        private Executor mQueryExecutor;
        private boolean mRequireMigration;
        private Executor mTransactionExecutor;
        private List<Object> mTypeConverters;

        Builder(Context context, Class<T> klass, String name) {
            this.mAutoCloseTimeout = -1;
            this.mContext = context;
            this.mDatabaseClass = klass;
            this.mName = name;
            this.mJournalMode = JournalMode.AUTOMATIC;
            this.mRequireMigration = true;
            this.mMigrationContainer = new MigrationContainer();
        }

        public Builder<T> createFromAsset(String databaseFilePath) {
            this.mCopyFromAssetPath = databaseFilePath;
            return this;
        }

        public Builder<T> createFromAsset(String databaseFilePath, PrepackagedDatabaseCallback callback) {
            this.mPrepackagedDatabaseCallback = callback;
            this.mCopyFromAssetPath = databaseFilePath;
            return this;
        }

        public Builder<T> createFromFile(File databaseFile) {
            this.mCopyFromFile = databaseFile;
            return this;
        }

        public Builder<T> createFromFile(File databaseFile, PrepackagedDatabaseCallback callback) {
            this.mPrepackagedDatabaseCallback = callback;
            this.mCopyFromFile = databaseFile;
            return this;
        }

        public Builder<T> createFromInputStream(Callable<InputStream> inputStreamCallable) {
            this.mCopyFromInputStream = inputStreamCallable;
            return this;
        }

        public Builder<T> createFromInputStream(Callable<InputStream> inputStreamCallable, PrepackagedDatabaseCallback callback) {
            this.mPrepackagedDatabaseCallback = callback;
            this.mCopyFromInputStream = inputStreamCallable;
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory factory) {
            this.mFactory = factory;
            return this;
        }

        public Builder<T> addMigrations(Migration... migrations) {
            if (this.mMigrationStartAndEndVersions != null) goto L5;
            this.mMigrationStartAndEndVersions = new HashSet();
        L5:
            int r0 = migrations.length;
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L8;
            Migration r2 = migrations[r1];
            this.mMigrationStartAndEndVersions.add(Integer.valueOf(r2.startVersion));
            this.mMigrationStartAndEndVersions.add(Integer.valueOf(r2.endVersion));
            r1 = r1 + 1;
            goto L6
        L8:
            this.mMigrationContainer.addMigrations(migrations);
            return this;
        }

        public Builder<T> allowMainThreadQueries() {
            this.mAllowMainThreadQueries = true;
            return this;
        }

        public Builder<T> setJournalMode(JournalMode journalMode) {
            this.mJournalMode = journalMode;
            return this;
        }

        public Builder<T> setQueryExecutor(Executor executor) {
            this.mQueryExecutor = executor;
            return this;
        }

        public Builder<T> setTransactionExecutor(Executor executor) {
            this.mTransactionExecutor = executor;
            return this;
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            if (this.mName == null) goto L5;
            boolean r0 = true;
        L6:
            this.mMultiInstanceInvalidation = r0;
            return this;
        L5:
            r0 = false;
            goto L6
        }

        public Builder<T> fallbackToDestructiveMigration() {
            this.mRequireMigration = false;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.mRequireMigration = true;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int... startVersions) {
            if (this.mMigrationsNotRequiredFrom != null) goto L5;
            this.mMigrationsNotRequiredFrom = new HashSet(startVersions.length);
        L5:
            int r0 = startVersions.length;
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L8;
            int r2 = startVersions[r1];
            this.mMigrationsNotRequiredFrom.add(Integer.valueOf(r2));
            r1 = r1 + 1;
            goto L6
        L8:
            return this;
        }

        public Builder<T> addCallback(Callback callback) {
            if (this.mCallbacks != null) goto L5;
            this.mCallbacks = new ArrayList();
        L5:
            this.mCallbacks.add(callback);
            return this;
        }

        public Builder<T> setQueryCallback(QueryCallback queryCallback, Executor executor) {
            this.mQueryCallback = queryCallback;
            this.mQueryCallbackExecutor = executor;
            return this;
        }

        public Builder<T> addTypeConverter(Object typeConverter) {
            if (this.mTypeConverters != null) goto L5;
            this.mTypeConverters = new ArrayList();
        L5:
            this.mTypeConverters.add(typeConverter);
            return this;
        }

        public Builder<T> setAutoCloseTimeout(long autoCloseTimeout, TimeUnit autoCloseTimeUnit) {
            if (autoCloseTimeout < 0) goto L7;
            this.mAutoCloseTimeout = autoCloseTimeout;
            this.mAutoCloseTimeUnit = autoCloseTimeUnit;
            return this;
        L7:
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
        }

        public T build() {
            if (this.mContext == null) goto L77;
            if (this.mDatabaseClass == null) goto L75;
            Executor r1 = this.mQueryExecutor;
            if (r1 == null) goto L9;
        L11:
            if (r1 != null) goto L13;
        L15:
            if (r1 != null) goto L19;
            Executor r2 = this.mTransactionExecutor;
            if (r2 == null) goto L19;
            this.mQueryExecutor = r2;
        L19:
            Set<Integer> r3 = this.mMigrationStartAndEndVersions;
            if (r3 != null) goto L22;
        L31:
            SupportSQLiteOpenHelper.Factory r4 = this.mFactory;
            if (r4 != null) goto L35;
            r4 = new FrameworkSQLiteOpenHelperFactory();
        L35:
            if (this.mAutoCloseTimeout > 0) goto L37;
        L41:
            String r5 = this.mCopyFromAssetPath;
            if (r5 != null) goto L48;
            if (this.mCopyFromFile != null) goto L48;
            if (this.mCopyFromInputStream != null) goto L48;
        L65:
            if (this.mQueryCallback == null) goto L67;
            SupportSQLiteOpenHelper.Factory r8 = new QueryInterceptorOpenHelperFactory(r4, this.mQueryCallback, this.mQueryCallbackExecutor);
        L68:
            Context r6 = this.mContext;
            DatabaseConfiguration r7 = new DatabaseConfiguration(r6, this.mName, r8, this.mMigrationContainer, this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.resolve(r6), this.mQueryExecutor, this.mTransactionExecutor, this.mMultiInstanceInvalidation, this.mRequireMigration, this.mAllowDestructiveMigrationOnDowngrade, this.mMigrationsNotRequiredFrom, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, this.mPrepackagedDatabaseCallback, this.mTypeConverters);
            T r0 = (T) Room.getGeneratedImplementation(this.mDatabaseClass, RoomDatabase.DB_IMPL_SUFFIX);
            r0.init(r7);
            return r0;
        L67:
            r8 = r4;
        L48:
            if (this.mName == null) goto L73;
            int r9 = 0;
            if (r5 != null) goto L52;
            int r10 = 0;
        L54:
            if (this.mCopyFromFile != null) goto L56;
            int r11 = 0;
        L57:
            int r12 = r10 + r11;
            if (this.mCopyFromInputStream == null) goto L62;
            r9 = 1;
        L62:
            if ((r12 + r9) != 1) goto L71;
            r4 = new SQLiteCopyOpenHelperFactory(this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, r4);
            goto L65
        L71:
            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
        L56:
            r11 = 1;
            goto L57
        L52:
            r10 = 1;
            goto L54
        L73:
            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
        L37:
            if (this.mName == null) goto L40;
            r4 = new AutoClosingRoomOpenHelperFactory(r4, new AutoCloser(this.mAutoCloseTimeout, this.mAutoCloseTimeUnit, this.mTransactionExecutor));
            goto L41
        L40:
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
        L22:
            if (this.mMigrationsNotRequiredFrom == null) goto L31;
            Iterator<Integer> r13 = r3.iterator();
        L25:
            if (r13.hasNext() == false) goto L31;
            Integer r14 = r13.next();
            if (this.mMigrationsNotRequiredFrom.contains(r14) == false) goto L25;
            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + r14);
        L13:
            if (this.mTransactionExecutor != null) goto L15;
            this.mTransactionExecutor = r1;
            goto L19
        L9:
            if (this.mTransactionExecutor != null) goto L11;
            Executor r15 = ArchTaskExecutor.getIOThreadExecutor();
            this.mTransactionExecutor = r15;
            this.mQueryExecutor = r15;
            goto L19
        L75:
            throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
        L77:
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
    }

    public static abstract class Callback {
        public void onCreate(SupportSQLiteDatabase db) {
        }

        public void onDestructiveMigration(SupportSQLiteDatabase db) {
        }

        public void onOpen(SupportSQLiteDatabase db) {
        }

        public Callback() {
        }
    }

    public static final enum JournalMode extends Enum<JournalMode> {
        private static final /* synthetic */ JournalMode[] $VALUES = null;
        public static final JournalMode AUTOMATIC = null;
        public static final JournalMode TRUNCATE = null;
        public static final JournalMode WRITE_AHEAD_LOGGING = null;

        private JournalMode(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static JournalMode valueOf(String name) {
            return (JournalMode) Enum.valueOf(JournalMode.class, name);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        static {
            JournalMode r0 = new JournalMode("AUTOMATIC", 0);
            AUTOMATIC = r0;
            JournalMode r1 = new JournalMode("TRUNCATE", 1);
            TRUNCATE = r1;
            JournalMode r3 = new JournalMode("WRITE_AHEAD_LOGGING", 2);
            WRITE_AHEAD_LOGGING = r3;
            $VALUES = new JournalMode[]{r0, r1, r3};
        }

        JournalMode resolve(Context context) {
            if (this == AUTOMATIC) goto L5;
            return this;
        L5:
            ActivityManager r1 = (ActivityManager) context.getSystemService("activity");
            if (r1 == null) goto L12;
            if (isLowRamDevice(r1) == true) goto L12;
            return WRITE_AHEAD_LOGGING;
        L12:
            return TRUNCATE;
        }

        private static boolean isLowRamDevice(ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }
    }

    public static class MigrationContainer {
        private HashMap<Integer, TreeMap<Integer, Migration>> mMigrations;

        public MigrationContainer() {
            this.mMigrations = new HashMap();
        }

        public void addMigrations(Migration... migrations) {
            int r0 = migrations.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            addMigration(migrations[r1]);
            r1 = r1 + 1;
            goto L3
        }

        private void addMigration(Migration migration) {
            int r0 = migration.startVersion;
            int r1 = migration.endVersion;
            TreeMap<Integer, Migration> r2 = this.mMigrations.get(Integer.valueOf(r0));
            if (r2 != null) goto L5;
            r2 = new TreeMap();
            this.mMigrations.put(Integer.valueOf(r0), r2);
        L5:
            Migration r4 = r2.get(Integer.valueOf(r1));
            if (r4 == null) goto L8;
            Log.w("ROOM", "Overriding migration " + r4 + " with " + migration);
        L8:
            r2.put(Integer.valueOf(r1), migration);
        }

        public List<Migration> findMigrationPath(int start, int end) {
            if (start == end) goto L4;
            if (end <= start) goto L7;
            boolean r0 = true;
        L9:
            return findUpMigrationPath(new ArrayList(), r0, start, end);
        L7:
            r0 = false;
            goto L9
        L4:
            return Collections.emptyList();
        }

        private List<Migration> findUpMigrationPath(List<Migration> result, boolean upgrade, int start, int end) {
        L2:
            if (upgrade == false) goto L5;
            if (start >= end) goto L27;
        L6:
            TreeMap<Integer, Migration> r0 = this.mMigrations.get(Integer.valueOf(start));
            if (r0 == null) goto L8;
            if (upgrade == false) goto L11;
            Set<Integer> r2 = r0.descendingKeySet();
        L12:
            Iterator<Integer> r3 = r2.iterator();
        L13:
            boolean r4 = false;
            if (r3.hasNext() == false) goto L25;
            int r5 = r3.next().intValue();
            if (upgrade == false) goto L20;
            if (r5 > end) goto L23;
            if (r5 <= start) goto L23;
        L19:
            r4 = true;
        L23:
            if (r4 == false) goto L13;
            result.add(r0.get(Integer.valueOf(r5)));
            start = r5;
            r4 = true;
            goto L25
        L20:
            if (r5 < end) goto L23;
            if (r5 >= start) goto L23;
        L25:
            if (r4 == true) goto L2;
            return null;
        L11:
            r2 = r0.keySet();
            goto L12
        L8:
            return null;
        L27:
            return result;
        L5:
            if (start <= end) goto L27;
            goto L6
        }
    }

    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase db) {
        }

        public PrepackagedDatabaseCallback() {
        }
    }

    public interface QueryCallback {
        void onQuery(String sqlQuery, List<Object> bindArgs);
    }

    public abstract void clearAllTables();

    protected abstract InvalidationTracker createInvalidationTracker();

    protected abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config);

    Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    public <T> T getTypeConverter(Class<T> r1) {
        return (T) this.mTypeConverters.get(r1);
    }

    public RoomDatabase() {
        this.mCloseLock = new ReentrantReadWriteLock();
        this.mSuspendingTransactionId = new ThreadLocal();
        this.mBackingFieldMap = Collections.synchronizedMap(new HashMap());
        this.mInvalidationTracker = createInvalidationTracker();
        this.mTypeConverters = new HashMap();
    }

    public void init(DatabaseConfiguration configuration) {
        SupportSQLiteOpenHelper r0 = createOpenHelper(configuration);
        this.mOpenHelper = r0;
        SQLiteCopyOpenHelper r1 = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, r0);
        if (r1 == null) goto L5;
        r1.setDatabaseConfiguration(configuration);
    L5:
        AutoClosingRoomOpenHelper r2 = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, this.mOpenHelper);
        if (r2 == null) goto L9;
        AutoCloser r3 = r2.getAutoCloser();
        this.mAutoCloser = r3;
        this.mInvalidationTracker.setAutoCloser(r3);
    L9:
        if (configuration.journalMode != JournalMode.WRITE_AHEAD_LOGGING) goto L11;
        boolean r4 = true;
    L12:
        this.mOpenHelper.setWriteAheadLoggingEnabled(r4);
        this.mCallbacks = configuration.callbacks;
        this.mQueryExecutor = configuration.queryExecutor;
        this.mTransactionExecutor = new TransactionExecutor(configuration.transactionExecutor);
        this.mAllowMainThreadQueries = configuration.allowMainThreadQueries;
        this.mWriteAheadLoggingEnabled = r4;
        if (configuration.multiInstanceInvalidation == false) goto L15;
        this.mInvalidationTracker.startMultiInstanceInvalidation(configuration.context, configuration.name);
    L15:
        Map<Class<?>, List<Class<?>>> r5 = getRequiredTypeConverters();
        BitSet r6 = new BitSet();
        Iterator<Map.Entry<Class<?>, List<Class<?>>>> r7 = r5.entrySet().iterator();
    L17:
        if (r7.hasNext() == false) goto L32;
        Map.Entry<Class<?>, List<Class<?>>> r8 = r7.next();
        Class<?> r9 = r8.getKey();
        Iterator<Class<?>> r10 = r8.getValue().iterator();
    L20:
        if (r10.hasNext() == false) goto L17;
        Class<?> r11 = r10.next();
        int r12 = configuration.typeConverters.size() - 1;
    L22:
        if (r12 < 0) goto L27;
        if (r11.isAssignableFrom(configuration.typeConverters.get(r12).getClass()) == true) goto L25;
        r12 = r12 - 1;
        goto L22
    L25:
        r6.set(r12);
    L28:
        if (r12 < 0) goto L31;
        this.mTypeConverters.put(r11, configuration.typeConverters.get(r12));
        goto L20
    L31:
        throw new IllegalArgumentException("A required type converter (" + r11 + ") for " + r9.getCanonicalName() + " is missing in the database configuration.");
    L27:
        r12 = -1;
        goto L28
    L32:
        int r13 = configuration.typeConverters.size() - 1;
    L33:
        if (r13 < 0) goto L39;
        if (r6.get(r13) == false) goto L38;
        r13 = r13 - 1;
        goto L33
    L38:
        throw new IllegalArgumentException("Unexpected type converter " + configuration.typeConverters.get(r13) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
    L39:
        return;
    L11:
        r4 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T unwrapOpenHelper(Class<T> r2, SupportSQLiteOpenHelper r3) {
        if (r2.isInstance(r3) == false) goto L6;
        return r3;
    L6:
        if ((r3 instanceof DelegatingOpenHelper) == true) goto L8;
        return null;
    L8:
        return (T) unwrapOpenHelper(r2, ((DelegatingOpenHelper) r3).getDelegate());
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.mOpenHelper;
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return Collections.emptyMap();
    }

    public boolean isOpen() {
        AutoCloser r0 = this.mAutoCloser;
        if (r0 != null) goto L5;
        SupportSQLiteDatabase r1 = this.mDatabase;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.isOpen() == false) goto L11;
        return true;
    L5:
        return r0.isActive();
    }

    public void close() {
        if (isOpen() == false) goto L10;
        ReentrantReadWriteLock.WriteLock r0 = this.mCloseLock.writeLock();
        r0.lock();
        this.mInvalidationTracker.stopMultiInstanceInvalidation();     // Catch: Throwable -> L7
        this.mOpenHelper.close();     // Catch: Throwable -> L7
        r0.unlock();
        return;
    L7:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public void assertNotMainThread() {
        if (this.mAllowMainThreadQueries == false) goto L6;
        return;
    L6:
        if (isMainThread() == true) goto L9;
        return;
    L9:
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
    }

    public void assertNotSuspendingTransaction() {
        if (inTransaction() == false) goto L5;
        return;
    L5:
        if (this.mSuspendingTransactionId.get() != null) goto L8;
        return;
    L8:
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    public Cursor query(String query, Object[] args) {
        return this.mOpenHelper.getWritableDatabase().query(new SimpleSQLiteQuery(query, args));
    }

    public Cursor query(SupportSQLiteQuery query) {
        return query(query, null);
    }

    public Cursor query(SupportSQLiteQuery query, CancellationSignal signal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (signal == null) goto L7;
        return this.mOpenHelper.getWritableDatabase().query(query, signal);
    L7:
        return this.mOpenHelper.getWritableDatabase().query(query);
    }

    public SupportSQLiteStatement compileStatement(String sql) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().compileStatement(sql);
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser r0 = this.mAutoCloser;
        if (r0 != null) goto L5;
        internalBeginTransaction();
        return;
    L5:
        r0.executeRefCountingFunction(new RoomDatabase$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$beginTransaction$0$androidx-room-RoomDatabase, reason: not valid java name */
    /* synthetic */ Object m85lambda$beginTransaction$0$androidxroomRoomDatabase(SupportSQLiteDatabase r1) {
        internalBeginTransaction();
        return null;
    }

    private void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase r0 = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(r0);
        if (r0.isWriteAheadLoggingEnabled() == false) goto L5;
        r0.beginTransactionNonExclusive();
        return;
    L5:
        r0.beginTransaction();
    }

    @Deprecated
    public void endTransaction() {
        AutoCloser r0 = this.mAutoCloser;
        if (r0 != null) goto L5;
        internalEndTransaction();
        return;
    L5:
        r0.executeRefCountingFunction(new RoomDatabase$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$endTransaction$1$androidx-room-RoomDatabase, reason: not valid java name */
    /* synthetic */ Object m86lambda$endTransaction$1$androidxroomRoomDatabase(SupportSQLiteDatabase r1) {
        internalEndTransaction();
        return null;
    }

    private void internalEndTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (inTransaction() == true) goto L6;
        this.mInvalidationTracker.refreshVersionsAsync();
        return;
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }

    public void runInTransaction(Runnable body) {
        beginTransaction();
        body.run();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    public <V> V runInTransaction(Callable<V> body) {
        beginTransaction();
        V r1 = body.call();     // Catch: Throwable -> L6 Exception -> L8 RuntimeException -> L12
        setTransactionSuccessful();     // Catch: Throwable -> L6 Exception -> L8 RuntimeException -> L12
        endTransaction();
        return r1;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        SneakyThrow.reThrow(e);     // Catch: Throwable -> L6
        endTransaction();
        return null;
    }

    protected void internalInitInvalidationTracker(SupportSQLiteDatabase db) {
        this.mInvalidationTracker.internalInit(db);
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().inTransaction();
    }

    private static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
