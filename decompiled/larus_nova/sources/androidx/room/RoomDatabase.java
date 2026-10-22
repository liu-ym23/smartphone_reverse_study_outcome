package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
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

/* JADX INFO: loaded from: classes3.dex */
public abstract class RoomDatabase {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    private AutoCloser mAutoCloser;
    protected Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> mAutoMigrationSpecs;
    private final Map<String, Object> mBackingFieldMap;
    protected List<Callback> mCallbacks;
    private final ReentrantReadWriteLock mCloseLock;
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
        private List<AutoMigrationSpec> mAutoMigrationSpecs;
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
        private Intent mMultiInstanceInvalidationIntent;
        private final String mName;
        private PrepackagedDatabaseCallback mPrepackagedDatabaseCallback;
        private QueryCallback mQueryCallback;
        private Executor mQueryCallbackExecutor;
        private Executor mQueryExecutor;
        private boolean mRequireMigration;
        private Executor mTransactionExecutor;
        private List<Object> mTypeConverters;

        public Builder<T> allowMainThreadQueries() {
            this.mAllowMainThreadQueries = true;
            return this;
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

        public T build() {
            if (this.mContext == null) goto L77;
            if (this.mDatabaseClass == null) goto L75;
            Executor r100 = this.mQueryExecutor;
            if (r100 == null) goto L9;
        L11:
            if (r100 != null) goto L13;
        L15:
            if (r100 != null) goto L19;
            Executor r101 = this.mTransactionExecutor;
            if (r101 == null) goto L19;
            this.mQueryExecutor = r101;
        L19:
            Set<Integer> r102 = this.mMigrationStartAndEndVersions;
            if (r102 != null) goto L22;
        L31:
            SupportSQLiteOpenHelper.Factory r103 = this.mFactory;
            if (r103 != null) goto L34;
            r103 = new FrameworkSQLiteOpenHelperFactory();
        L34:
            long r104 = this.mAutoCloseTimeout;
            if (r104 > 0) goto L37;
        L41:
            String r105 = this.mCopyFromAssetPath;
            if (r105 != null) goto L48;
            if (this.mCopyFromFile != null) goto L48;
            if (this.mCopyFromInputStream != null) goto L48;
        L64:
            QueryCallback r106 = this.mQueryCallback;
            if (r106 == null) goto L67;
            SupportSQLiteOpenHelper.Factory r107 = new QueryInterceptorOpenHelperFactory(r103, r106, this.mQueryCallbackExecutor);
        L68:
            Context r108 = this.mContext;
            DatabaseConfiguration r109 = new DatabaseConfiguration(r108, this.mName, r107, this.mMigrationContainer, this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.resolve(r108), this.mQueryExecutor, this.mTransactionExecutor, this.mMultiInstanceInvalidationIntent, this.mRequireMigration, this.mAllowDestructiveMigrationOnDowngrade, this.mMigrationsNotRequiredFrom, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, this.mPrepackagedDatabaseCallback, this.mTypeConverters, this.mAutoMigrationSpecs);
            T r110 = (T) Room.getGeneratedImplementation(this.mDatabaseClass, RoomDatabase.DB_IMPL_SUFFIX);
            r110.init(r109);
            return r110;
        L67:
            r107 = r103;
        L48:
            if (this.mName == null) goto L73;
            int r111 = 0;
            if (r105 != null) goto L52;
            int r112 = 0;
        L53:
            File r113 = this.mCopyFromFile;
            if (r113 != null) goto L56;
            int r114 = 0;
        L57:
            int r115 = r112 + r114;
            Callable<InputStream> r116 = this.mCopyFromInputStream;
            if (r116 == null) goto L62;
            r111 = 1;
        L62:
            if ((r115 + r111) != 1) goto L71;
            r103 = new SQLiteCopyOpenHelperFactory(r105, r113, r116, r103);
            goto L64
        L71:
            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
        L56:
            r114 = 1;
            goto L57
        L52:
            r112 = 1;
            goto L53
        L73:
            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
        L37:
            if (this.mName == null) goto L40;
            r103 = new AutoClosingRoomOpenHelperFactory(r103, new AutoCloser(r104, this.mAutoCloseTimeUnit, this.mTransactionExecutor));
            goto L41
        L40:
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
        L22:
            if (this.mMigrationsNotRequiredFrom == null) goto L31;
            Iterator<Integer> r117 = r102.iterator();
        L25:
            if (r117.hasNext() == false) goto L31;
            Integer r118 = r117.next();
            if (this.mMigrationsNotRequiredFrom.contains(r118) == false) goto L25;
            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + r118);
        L13:
            if (this.mTransactionExecutor != null) goto L15;
            this.mTransactionExecutor = r100;
            goto L19
        L9:
            if (this.mTransactionExecutor != null) goto L11;
            Executor r119 = ArchTaskExecutor.getIOThreadExecutor();
            this.mTransactionExecutor = r119;
            this.mQueryExecutor = r119;
            goto L19
        L75:
            throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
        L77:
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            if (this.mName == null) goto L5;
            Intent r100 = new Intent(this.mContext, MultiInstanceInvalidationService.class);
        L6:
            this.mMultiInstanceInvalidationIntent = r100;
            return this;
        L5:
            r100 = null;
            goto L6
        }

        public Builder<T> addAutoMigrationSpec(AutoMigrationSpec r100) {
            if (this.mAutoMigrationSpecs != null) goto L5;
            this.mAutoMigrationSpecs = new ArrayList();
        L5:
            this.mAutoMigrationSpecs.add(r100);
            return this;
        }

        public Builder<T> addCallback(Callback r100) {
            if (this.mCallbacks != null) goto L5;
            this.mCallbacks = new ArrayList();
        L5:
            this.mCallbacks.add(r100);
            return this;
        }

        public Builder<T> addMigrations(Migration... r100) {
            if (this.mMigrationStartAndEndVersions != null) goto L5;
            this.mMigrationStartAndEndVersions = new HashSet();
        L5:
            int r101 = r100.length;
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L8;
            Migration r103 = r100[r102];
            this.mMigrationStartAndEndVersions.add(Integer.valueOf(r103.startVersion));
            this.mMigrationStartAndEndVersions.add(Integer.valueOf(r103.endVersion));
            r102 = r102 + 1;
            goto L6
        L8:
            this.mMigrationContainer.addMigrations(r100);
            return this;
        }

        public Builder<T> addTypeConverter(Object r100) {
            if (this.mTypeConverters != null) goto L5;
            this.mTypeConverters = new ArrayList();
        L5:
            this.mTypeConverters.add(r100);
            return this;
        }

        public Builder<T> createFromAsset(String r100) {
            this.mCopyFromAssetPath = r100;
            return this;
        }

        public Builder<T> createFromFile(File r100) {
            this.mCopyFromFile = r100;
            return this;
        }

        public Builder<T> createFromInputStream(Callable<InputStream> r100) {
            this.mCopyFromInputStream = r100;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int... r100) {
            if (this.mMigrationsNotRequiredFrom != null) goto L5;
            this.mMigrationsNotRequiredFrom = new HashSet(r100.length);
        L5:
            int r101 = r100.length;
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L8;
            int r103 = r100[r102];
            this.mMigrationsNotRequiredFrom.add(Integer.valueOf(r103));
            r102 = r102 + 1;
            goto L6
        L8:
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory r100) {
            this.mFactory = r100;
            return this;
        }

        public Builder<T> setJournalMode(JournalMode r100) {
            this.mJournalMode = r100;
            return this;
        }

        public Builder<T> setMultiInstanceInvalidationServiceIntent(Intent r100) {
            if (this.mName != null) goto L6;
            r100 = null;
        L6:
            this.mMultiInstanceInvalidationIntent = r100;
            return this;
        }

        public Builder<T> setQueryExecutor(Executor r100) {
            this.mQueryExecutor = r100;
            return this;
        }

        public Builder<T> setTransactionExecutor(Executor r100) {
            this.mTransactionExecutor = r100;
            return this;
        }

        public Builder<T> createFromAsset(String r100, PrepackagedDatabaseCallback r101) {
            this.mPrepackagedDatabaseCallback = r101;
            this.mCopyFromAssetPath = r100;
            return this;
        }

        public Builder<T> createFromFile(File r100, PrepackagedDatabaseCallback r101) {
            this.mPrepackagedDatabaseCallback = r101;
            this.mCopyFromFile = r100;
            return this;
        }

        public Builder<T> createFromInputStream(Callable<InputStream> r100, PrepackagedDatabaseCallback r101) {
            this.mPrepackagedDatabaseCallback = r101;
            this.mCopyFromInputStream = r100;
            return this;
        }

        public Builder<T> setAutoCloseTimeout(long r100, TimeUnit r101) {
            if (r100 < 0) goto L7;
            this.mAutoCloseTimeout = r100;
            this.mAutoCloseTimeUnit = r101;
            return this;
        L7:
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
        }

        public Builder<T> setQueryCallback(QueryCallback r100, Executor r101) {
            this.mQueryCallback = r100;
            this.mQueryCallbackExecutor = r101;
            return this;
        }

        public Builder(Context r100, Class<T> r101, String r102) {
            this.mAutoCloseTimeout = -1;
            this.mContext = r100;
            this.mDatabaseClass = r101;
            this.mName = r102;
            this.mJournalMode = JournalMode.AUTOMATIC;
            this.mRequireMigration = true;
            this.mMigrationContainer = new MigrationContainer();
        }
    }

    public static abstract class Callback {
        public Callback() {
        }

        public void onCreate(SupportSQLiteDatabase r100) {
        }

        public void onDestructiveMigration(SupportSQLiteDatabase r100) {
        }

        public void onOpen(SupportSQLiteDatabase r100) {
        }
    }

    public static final enum JournalMode extends Enum<JournalMode> {
        private static final /* synthetic */ JournalMode[] $VALUES = null;
        public static final JournalMode AUTOMATIC = null;
        public static final JournalMode TRUNCATE = null;
        public static final JournalMode WRITE_AHEAD_LOGGING = null;

        static {
            JournalMode r100 = new JournalMode("AUTOMATIC", 0);
            AUTOMATIC = r100;
            JournalMode r101 = new JournalMode("TRUNCATE", 1);
            TRUNCATE = r101;
            JournalMode r102 = new JournalMode("WRITE_AHEAD_LOGGING", 2);
            WRITE_AHEAD_LOGGING = r102;
            $VALUES = new JournalMode[]{r100, r101, r102};
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        private static boolean isLowRamDevice(ActivityManager r100) {
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(r100);
        }

        public static JournalMode valueOf(String r100) {
            return (JournalMode) r27.a.a(JournalMode.class, r100);
        }

        public JournalMode resolve(Context r100) {
            if (this == AUTOMATIC) goto L5;
            return this;
        L5:
            ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");
            if (r101 == null) goto L12;
            if (isLowRamDevice(r101) == true) goto L12;
            return WRITE_AHEAD_LOGGING;
        L12:
            return TRUNCATE;
        }

        private JournalMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class MigrationContainer {
        private HashMap<Integer, TreeMap<Integer, Migration>> mMigrations;

        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return Collections.unmodifiableMap(this.mMigrations);
        }

        public MigrationContainer() {
            this.mMigrations = new HashMap();
        }

        private void addMigration(Migration r100) {
            int r101 = r100.startVersion;
            int r102 = r100.endVersion;
            TreeMap<Integer, Migration> r103 = this.mMigrations.get(Integer.valueOf(r101));
            if (r103 != null) goto L5;
            r103 = new TreeMap();
            this.mMigrations.put(Integer.valueOf(r101), r103);
        L5:
            Migration r104 = r103.get(Integer.valueOf(r102));
            if (r104 == null) goto L8;
            r104.toString();
            r100.toString();
        L8:
            r103.put(Integer.valueOf(r102), r100);
        }

        public void addMigrations(List<Migration> r100) {
            Iterator<Migration> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            addMigration(r101.next());
            goto L4
        }

        public void addMigrations(Migration... r100) {
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            addMigration(r100[r102]);
            r102 = r102 + 1;
            goto L3
        }

        public List<Migration> findMigrationPath(int r100, int r101) {
            if (r100 == r101) goto L4;
            if (r101 <= r100) goto L7;
            boolean r102 = true;
        L9:
            return findUpMigrationPath(new ArrayList(), r102, r100, r101);
        L7:
            r102 = false;
            goto L9
        L4:
            return Collections.emptyList();
        }

        private List<Migration> findUpMigrationPath(List<Migration> r100, boolean r101, int r102, int r110) {
        L2:
            if (r101 == false) goto L5;
            if (r102 >= r110) goto L27;
        L6:
            TreeMap<Integer, Migration> r103 = this.mMigrations.get(Integer.valueOf(r102));
            if (r103 == null) goto L8;
            if (r101 == false) goto L11;
            Set<Integer> r104 = r103.descendingKeySet();
        L12:
            Iterator<Integer> r105 = r104.iterator();
        L13:
            boolean r106 = false;
            if (r105.hasNext() == false) goto L25;
            int r107 = r105.next().intValue();
            if (r101 == false) goto L20;
            if (r107 > r110) goto L23;
            if (r107 <= r102) goto L23;
        L19:
            r106 = true;
        L23:
            if (r106 == false) goto L13;
            r100.add(r103.get(Integer.valueOf(r107)));
            r102 = r107;
            r106 = true;
            goto L25
        L20:
            if (r107 < r110) goto L23;
            if (r107 >= r102) goto L23;
        L25:
            if (r106 == true) goto L2;
            return null;
        L11:
            r104 = r103.keySet();
            goto L12
        L8:
            return null;
        L27:
            return r100;
        L5:
            if (r102 <= r110) goto L27;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class PrepackagedDatabaseCallback {
        public PrepackagedDatabaseCallback() {
        }

        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase r100) {
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface QueryCallback {
        void onQuery(String r100, List<Object> r101);
    }

    public static /* synthetic */ Object a(RoomDatabase r100, SupportSQLiteDatabase r101) {
        return r100.lambda$beginTransaction$0(r101);
    }

    public static /* synthetic */ Object b(RoomDatabase r100, SupportSQLiteDatabase r101) {
        return r100.lambda$endTransaction$1(r101);
    }

    public abstract void clearAllTables();

    public abstract InvalidationTracker createInvalidationTracker();

    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r100);

    private void internalEndTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (inTransaction() == true) goto L6;
        this.mInvalidationTracker.refreshVersionsAsync();
        return;
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

    public void endTransaction() {
        AutoCloser r100 = this.mAutoCloser;
        if (r100 != null) goto L5;
        internalEndTransaction();
        return;
    L5:
        r100.executeRefCountingFunction(new x0(this));
    }

    public Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().inTransaction();
    }

    public boolean isOpen() {
        AutoCloser r100 = this.mAutoCloser;
        if (r100 != null) goto L5;
        SupportSQLiteDatabase r101 = this.mDatabase;
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if (r101.isOpen() == false) goto L11;
        return true;
    L5:
        return r100.isActive();
    }

    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }

    public RoomDatabase() {
        this.mCloseLock = new ReentrantReadWriteLock();
        this.mSuspendingTransactionId = new ThreadLocal();
        this.mBackingFieldMap = Collections.synchronizedMap(new HashMap());
        this.mInvalidationTracker = createInvalidationTracker();
        this.mTypeConverters = new HashMap();
        this.mAutoMigrationSpecs = new HashMap();
    }

    private void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase r100 = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(r100);
        if (r100.isWriteAheadLoggingEnabled() == false) goto L5;
        r100.beginTransactionNonExclusive();
        return;
    L5:
        r100.beginTransaction();
    }

    private static boolean isMainThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
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

    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser r100 = this.mAutoCloser;
        if (r100 != null) goto L5;
        internalBeginTransaction();
        return;
    L5:
        r100.executeRefCountingFunction(new w0(this));
    }

    public void close() {
        if (isOpen() == false) goto L10;
        ReentrantReadWriteLock.WriteLock r100 = this.mCloseLock.writeLock();
        r100.lock();
        this.mInvalidationTracker.stopMultiInstanceInvalidation();     // Catch: Throwable -> L7
        this.mOpenHelper.close();     // Catch: Throwable -> L7
        r100.unlock();
        return;
    L7:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return Collections.emptySet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return Collections.emptyMap();
    }

    public Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.mOpenHelper;
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    public ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    private /* synthetic */ Object lambda$beginTransaction$0(SupportSQLiteDatabase r100) {
        internalBeginTransaction();
        return null;
    }

    private /* synthetic */ Object lambda$endTransaction$1(SupportSQLiteDatabase r100) {
        internalEndTransaction();
        return null;
    }

    public SupportSQLiteStatement compileStatement(String r100) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().compileStatement(r100);
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r100) {
        return Collections.emptyList();
    }

    public <T> T getTypeConverter(Class<T> r100) {
        return (T) this.mTypeConverters.get(r100);
    }

    public void init(DatabaseConfiguration r110) {
        this.mOpenHelper = createOpenHelper(r110);
        Set<Class<? extends AutoMigrationSpec>> r100 = getRequiredAutoMigrationSpecs();
        BitSet r101 = new BitSet();
        Iterator<Class<? extends AutoMigrationSpec>> r102 = r100.iterator();
    L3:
        int r103 = -1;
        if (r102.hasNext() == false) goto L15;
        Class<? extends AutoMigrationSpec> r104 = r102.next();
        int r105 = r110.autoMigrationSpecs.size() - 1;
    L6:
        if (r105 < 0) goto L11;
        if (r104.isAssignableFrom(ListProtector.get(r110.autoMigrationSpecs, r105).getClass()) == true) goto L9;
        r105 = r105 - 1;
        goto L6
    L9:
        r101.set(r105);
        r103 = r105;
    L11:
        if (r103 < 0) goto L14;
        this.mAutoMigrationSpecs.put(r104, (AutoMigrationSpec) ListProtector.get(r110.autoMigrationSpecs, r103));
        goto L3
    L14:
        throw new IllegalArgumentException("A required auto migration spec (" + r104.getCanonicalName() + ") is missing in the database configuration.");
    L15:
        int r106 = r110.autoMigrationSpecs.size() - 1;
    L16:
        if (r106 < 0) goto L22;
        if (r101.get(r106) == false) goto L21;
        r106 = r106 - 1;
        goto L16
    L21:
        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
    L22:
        Iterator<Migration> r107 = getAutoMigrations(this.mAutoMigrationSpecs).iterator();
    L23:
        boolean r108 = false;
        if (r107.hasNext() == false) goto L28;
        Migration r109 = r107.next();
        if (r110.migrationContainer.getMigrations().containsKey(Integer.valueOf(r109.startVersion)) == true) goto L23;
        r110.migrationContainer.addMigrations(new Migration[]{r109});
        goto L23
    L28:
        SQLiteCopyOpenHelper r111 = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, this.mOpenHelper);
        if (r111 == null) goto L31;
        r111.setDatabaseConfiguration(r110);
    L31:
        AutoClosingRoomOpenHelper r112 = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, this.mOpenHelper);
        if (r112 == null) goto L35;
        AutoCloser r113 = r112.getAutoCloser();
        this.mAutoCloser = r113;
        this.mInvalidationTracker.setAutoCloser(r113);
    L35:
        if (r110.journalMode != JournalMode.WRITE_AHEAD_LOGGING) goto L37;
        r108 = true;
    L37:
        this.mOpenHelper.setWriteAheadLoggingEnabled(r108);
        this.mCallbacks = r110.callbacks;
        this.mQueryExecutor = r110.queryExecutor;
        this.mTransactionExecutor = new TransactionExecutor(r110.transactionExecutor);
        this.mAllowMainThreadQueries = r110.allowMainThreadQueries;
        this.mWriteAheadLoggingEnabled = r108;
        Intent r114 = r110.multiInstanceInvalidationServiceIntent;
        if (r114 == null) goto L40;
        this.mInvalidationTracker.startMultiInstanceInvalidation(r110.context, r110.name, r114);
    L40:
        Map<Class<?>, List<Class<?>>> r115 = getRequiredTypeConverters();
        BitSet r116 = new BitSet();
        Iterator<Map.Entry<Class<?>, List<Class<?>>>> r117 = r115.entrySet().iterator();
    L42:
        if (r117.hasNext() == false) goto L57;
        Map.Entry<Class<?>, List<Class<?>>> r118 = r117.next();
        Class<?> r119 = r118.getKey();
        Iterator<Class<?>> r120 = r118.getValue().iterator();
    L45:
        if (r120.hasNext() == false) goto L42;
        Class<?> r121 = r120.next();
        int r122 = r110.typeConverters.size() - 1;
    L47:
        if (r122 < 0) goto L52;
        if (r121.isAssignableFrom(ListProtector.get(r110.typeConverters, r122).getClass()) == true) goto L50;
        r122 = r122 - 1;
        goto L47
    L50:
        r116.set(r122);
    L53:
        if (r122 < 0) goto L56;
        this.mTypeConverters.put(r121, ListProtector.get(r110.typeConverters, r122));
        goto L45
    L56:
        throw new IllegalArgumentException("A required type converter (" + r121 + ") for " + r119.getCanonicalName() + " is missing in the database configuration.");
    L52:
        r122 = -1;
        goto L53
    L57:
        int r123 = r110.typeConverters.size() - 1;
    L58:
        if (r123 < 0) goto L64;
        if (r116.get(r123) == false) goto L63;
        r123 = r123 - 1;
        goto L58
    L63:
        throw new IllegalArgumentException("Unexpected type converter " + ListProtector.get(r110.typeConverters, r123) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
    }

    public void internalInitInvalidationTracker(SupportSQLiteDatabase r100) {
        this.mInvalidationTracker.internalInit(r100);
    }

    public Cursor query(SupportSQLiteQuery r100) {
        return query(r100, null);
    }

    public <V> V runInTransaction(Callable<V> r100) {
        beginTransaction();
        V r101 = r100.call();     // Catch: Throwable -> L6 Exception -> L8 RuntimeException -> L12
        setTransactionSuccessful();     // Catch: Throwable -> L6 Exception -> L8 RuntimeException -> L12
        endTransaction();
        return r101;
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

    public void runInTransaction(Runnable r100) {
        beginTransaction();
        r100.run();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T unwrapOpenHelper(Class<T> r100, SupportSQLiteOpenHelper r101) {
        if (r100.isInstance(r101) == false) goto L6;
        return r101;
    L6:
        if ((r101 instanceof DelegatingOpenHelper) == true) goto L8;
        return null;
    L8:
        return (T) unwrapOpenHelper(r100, ((DelegatingOpenHelper) r101).getDelegate());
    }

    public Cursor query(SupportSQLiteQuery r100, CancellationSignal r101) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (r101 == null) goto L7;
        return this.mOpenHelper.getWritableDatabase().query(r100, r101);
    L7:
        return this.mOpenHelper.getWritableDatabase().query(r100);
    }

    public Cursor query(String r100, Object[] r101) {
        return this.mOpenHelper.getWritableDatabase().query(new SimpleSQLiteQuery(r100, r101));
    }
}
