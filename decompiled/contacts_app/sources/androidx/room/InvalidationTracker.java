package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";
    static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = null;
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    AutoCloser mAutoCloser;
    volatile SupportSQLiteStatement mCleanupStatement;
    final RoomDatabase mDatabase;
    private volatile boolean mInitialized;
    private final InvalidationLiveDataContainer mInvalidationLiveDataContainer;
    private MultiInstanceInvalidationClient mMultiInstanceInvalidationClient;
    private ObservedTableTracker mObservedTableTracker;
    final SafeIterableMap<Observer, ObserverWrapper> mObserverMap;
    AtomicBoolean mPendingRefresh;
    Runnable mRefreshRunnable;
    final HashMap<String, Integer> mTableIdLookup;
    final String[] mTableNames;
    private Map<String, Set<String>> mViewTables;

    static class ObservedTableTracker {
        static final int ADD = 1;
        static final int NO_OP = 0;
        static final int REMOVE = 2;
        boolean mNeedsSync;
        boolean mPendingSync;
        final long[] mTableObservers;
        final int[] mTriggerStateChanges;
        final boolean[] mTriggerStates;

        ObservedTableTracker(int tableCount) {
            long[] r0 = new long[tableCount];
            this.mTableObservers = r0;
            boolean[] r1 = new boolean[tableCount];
            this.mTriggerStates = r1;
            this.mTriggerStateChanges = new int[tableCount];
            Arrays.fill(r0, 0);
            Arrays.fill(r1, false);
        }

        boolean onAdded(int... tableIds) {
            monitor-enter(this);
            int r0 = tableIds.length;     // Catch: Throwable -> L11
            int r1 = 0;
            boolean r2 = false;
        L4:
            if (r1 >= r0) goto L9;
            int r3 = tableIds[r1];     // Catch: Throwable -> L11
            long[] r4 = this.mTableObservers;     // Catch: Throwable -> L11
            long r5 = r4[r3];     // Catch: Throwable -> L11
            r4[r3] = 1 + r5;     // Catch: Throwable -> L11
            if (r5 != 0) goto L8;
            r2 = true;
            this.mNeedsSync = true;     // Catch: Throwable -> L11
        L8:
            r1 = r1 + 1;     // Catch: Throwable -> L11
            goto L4
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r2;
        L11:
            th = move-exception;
            throw th;
        }

        boolean onRemoved(int... tableIds) {
            monitor-enter(this);
            int r0 = tableIds.length;     // Catch: Throwable -> L11
            int r1 = 0;
            boolean r2 = false;
        L4:
            if (r1 >= r0) goto L9;
            int r3 = tableIds[r1];     // Catch: Throwable -> L11
            long[] r4 = this.mTableObservers;     // Catch: Throwable -> L11
            long r5 = r4[r3];     // Catch: Throwable -> L11
            r4[r3] = r5 - 1;     // Catch: Throwable -> L11
            if (r5 != 1) goto L8;
            r2 = true;
            this.mNeedsSync = true;     // Catch: Throwable -> L11
        L8:
            r1 = r1 + 1;     // Catch: Throwable -> L11
            goto L4
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r2;
        L11:
            th = move-exception;
            throw th;
        }

        void resetTriggerState() {
            monitor-enter(this);
            Arrays.fill(this.mTriggerStates, false);     // Catch: Throwable -> L6
            this.mNeedsSync = true;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        int[] getTablesToSync() {
            monitor-enter(this);
        L30:
            th = move-exception;
            throw th;
        L4:
            if (this.mNeedsSync == true) goto L6;
        L27:
            monitor-exit(this);     // Catch: Throwable -> L30
            return null;
        L6:
            if (this.mPendingSync == true) goto L27;
            int r0 = this.mTableObservers.length;     // Catch: Throwable -> L30
            int r2 = 0;
        L9:
            int r3 = 1;
            if (r2 >= r0) goto L24;
            if (this.mTableObservers[r2] <= 0) goto L14;
            boolean r4 = true;
        L15:
            boolean[] r5 = this.mTriggerStates;     // Catch: Throwable -> L30
            if (r4 == r5[r2]) goto L22;
            int[] r6 = this.mTriggerStateChanges;     // Catch: Throwable -> L30
            if (r4 == true) goto L21;
            r3 = 2;
        L21:
            r6[r2] = r3;     // Catch: Throwable -> L30
        L23:
            r5[r2] = r4;     // Catch: Throwable -> L30
            r2 = r2 + 1;     // Catch: Throwable -> L30
            goto L9
        L22:
            this.mTriggerStateChanges[r2] = 0;     // Catch: Throwable -> L30
            goto L23
        L14:
            r4 = false;
            goto L15
        L24:
            this.mPendingSync = true;     // Catch: Throwable -> L30
            this.mNeedsSync = false;     // Catch: Throwable -> L30
            int[] r1 = this.mTriggerStateChanges;     // Catch: Throwable -> L30
            monitor-exit(this);     // Catch: Throwable -> L30
            return r1;
        }

        void onSyncCompleted() {
            monitor-enter(this);
            this.mPendingSync = false;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class Observer {
        final String[] mTables;

        boolean isRemote() {
            return false;
        }

        public abstract void onInvalidated(Set<String> tables);

        protected Observer(String firstTable, String... rest) {
            String[] r0 = (String[]) Arrays.copyOf(rest, rest.length + 1);
            this.mTables = r0;
            r0[rest.length] = firstTable;
        }

        public Observer(String[] tables) {
            this.mTables = (String[]) Arrays.copyOf(tables, tables.length);
        }
    }

    static class ObserverWrapper {
        final Observer mObserver;
        private final Set<String> mSingleTableSet;
        final int[] mTableIds;
        private final String[] mTableNames;

        ObserverWrapper(Observer observer, int[] tableIds, String[] tableNames) {
            this.mObserver = observer;
            this.mTableIds = tableIds;
            this.mTableNames = tableNames;
            if (tableIds.length != 1) goto L5;
            HashSet r1 = new HashSet();
            r1.add(tableNames[0]);
            this.mSingleTableSet = Collections.unmodifiableSet(r1);
            return;
        L5:
            this.mSingleTableSet = null;
        }

        void notifyByTableInvalidStatus(Set<Integer> invalidatedTablesIds) {
            int r0 = this.mTableIds.length;
            Set<String> r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L13;
            if (invalidatedTablesIds.contains(Integer.valueOf(this.mTableIds[r2])) == false) goto L12;
            if (r0 != 1) goto L9;
            r1 = this.mSingleTableSet;
            goto L12
        L9:
            if (r1 != null) goto L11;
            r1 = new HashSet(r0);
        L11:
            r1.add(this.mTableNames[r2]);
        L12:
            r2 = r2 + 1;
            goto L3
        L13:
            if (r1 == null) goto L20;
            this.mObserver.onInvalidated(r1);
            return;
        }

        void notifyByTableNames(String[] tables) {
            Set<String> r3 = null;
            if (this.mTableNames.length != 1) goto L10;
            int r0 = tables.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L22;
            if (tables[r1].equalsIgnoreCase(this.mTableNames[0]) == true) goto L8;
            r1 = r1 + 1;
            goto L5
        L8:
            r3 = this.mSingleTableSet;
        L22:
            if (r3 == null) goto L31;
            this.mObserver.onInvalidated(r3);
            return;
        L31:
            return;
        L10:
            HashSet r2 = new HashSet();
            int r4 = tables.length;
            int r5 = 0;
        L11:
            if (r5 >= r4) goto L20;
            String r6 = tables[r5];
            String[] r7 = this.mTableNames;
            int r8 = r7.length;
            int r9 = 0;
        L13:
            if (r9 >= r8) goto L18;
            String r10 = r7[r9];
            if (r10.equalsIgnoreCase(r6) == true) goto L16;
            r9 = r9 + 1;
            goto L13
        L16:
            r2.add(r10);
        L18:
            r5 = r5 + 1;
            goto L11
        L20:
            if (r2.size() <= 0) goto L22;
            r3 = r2;
            goto L22
        }
    }

    static class WeakObserver extends Observer {
        final WeakReference<Observer> mDelegateRef;
        final InvalidationTracker mTracker;

        WeakObserver(InvalidationTracker tracker, Observer delegate) {
            super(delegate.mTables);
            this.mTracker = tracker;
            this.mDelegateRef = new WeakReference(delegate);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(Set<String> tables) {
            Observer r0 = this.mDelegateRef.get();
            if (r0 != null) goto L5;
            this.mTracker.removeObserver(this);
            return;
        L5:
            r0.onInvalidated(tables);
        }
    }

    static {
        TRIGGERS = new String[]{"UPDATE", HttpMethodContrants.DELETE, "INSERT"};
    }

    public InvalidationTracker(RoomDatabase database, String... tableNames) {
        this(database, new HashMap(), Collections.emptyMap(), tableNames);
    }

    public InvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        this.mAutoCloser = null;
        int r1 = 0;
        this.mPendingRefresh = new AtomicBoolean(false);
        this.mInitialized = false;
        this.mObserverMap = new SafeIterableMap();
        this.mRefreshRunnable = new AnonymousClass1(this);
        this.mDatabase = database;
        this.mObservedTableTracker = new ObservedTableTracker(tableNames.length);
        this.mTableIdLookup = new HashMap();
        this.mViewTables = viewTables;
        this.mInvalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        int r4 = tableNames.length;
        this.mTableNames = new String[r4];
    L3:
        if (r1 >= r4) goto L9;
        String r6 = tableNames[r1].toLowerCase(Locale.US);
        this.mTableIdLookup.put(r6, Integer.valueOf(r1));
        String r0 = shadowTablesMap.get(tableNames[r1]);
        if (r0 == null) goto L7;
        this.mTableNames[r1] = r0.toLowerCase(Locale.US);
    L8:
        r1 = r1 + 1;
        goto L3
    L7:
        this.mTableNames[r1] = r6;
        goto L8
    L9:
        Iterator<Map.Entry<String, String>> r5 = shadowTablesMap.entrySet().iterator();
    L11:
        if (r5.hasNext() == false) goto L15;
        Map.Entry<String, String> r7 = r5.next();
        String r8 = r7.getValue().toLowerCase(Locale.US);
        if (this.mTableIdLookup.containsKey(r8) == false) goto L11;
        String r9 = r7.getKey().toLowerCase(Locale.US);
        HashMap<String, Integer> r10 = this.mTableIdLookup;
        r10.put(r9, r10.get(r8));
        goto L11
    }

    void setAutoCloser(AutoCloser autoCloser) {
        this.mAutoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new InvalidationTracker$$ExternalSyntheticLambda0(this));
    }

    void internalInit(SupportSQLiteDatabase database) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mInitialized == false) goto L8;
        Log.e("ROOM", "Invalidation tracker is initialized twice :/.");     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L8:
        database.execSQL("PRAGMA temp_store = MEMORY;");     // Catch: Throwable -> L11
        database.execSQL("PRAGMA recursive_triggers='ON';");     // Catch: Throwable -> L11
        database.execSQL(CREATE_TRACKING_TABLE_SQL);     // Catch: Throwable -> L11
        syncTriggers(database);     // Catch: Throwable -> L11
        this.mCleanupStatement = database.compileStatement(RESET_UPDATED_TABLES_SQL);     // Catch: Throwable -> L11
        this.mInitialized = true;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    void onAutoCloseCallback() {
        monitor-enter(this);
        this.mInitialized = false;     // Catch: Throwable -> L7
        this.mObservedTableTracker.resetTriggerState();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void startMultiInstanceInvalidation(Context context, String name) {
        this.mMultiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, this, this.mDatabase.getQueryExecutor());
    }

    void stopMultiInstanceInvalidation() {
        MultiInstanceInvalidationClient r0 = this.mMultiInstanceInvalidationClient;
        if (r0 == null) goto L6;
        r0.stop();
        this.mMultiInstanceInvalidationClient = null;
        return;
    }

    private static void appendTriggerName(StringBuilder builder, String tableName, String triggerType) {
        builder.append("`").append("room_table_modification_trigger_").append(tableName).append("_").append(triggerType).append("`");
    }

    private void stopTrackingTable(SupportSQLiteDatabase writableDb, int tableId) {
        String r6 = this.mTableNames[tableId];
        StringBuilder r8 = new StringBuilder();
        String[] r0 = TRIGGERS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        String r4 = r0[r3];
        r8.setLength(0);
        r8.append("DROP TRIGGER IF EXISTS ");
        appendTriggerName(r8, r6, r4);
        writableDb.execSQL(r8.toString());
        r3 = r3 + 1;
        goto L3
    }

    private void startTrackingTable(SupportSQLiteDatabase writableDb, int tableId) {
        writableDb.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + tableId + ", 0)");
        String r8 = this.mTableNames[tableId];
        StringBuilder r0 = new StringBuilder();
        String[] r1 = TRIGGERS;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        String r5 = r1[r4];
        r0.setLength(0);
        r0.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
        appendTriggerName(r0, r8, r5);
        r0.append(" AFTER ").append(r5).append(" ON `").append(r8).append("` BEGIN UPDATE ").append(UPDATE_TABLE_NAME).append(" SET ").append(INVALIDATED_COLUMN_NAME).append(" = 1").append(" WHERE ").append(TABLE_ID_COLUMN_NAME).append(" = ").append(tableId).append(" AND ").append(INVALIDATED_COLUMN_NAME).append(" = 0").append("; END");
        writableDb.execSQL(r0.toString());
        r4 = r4 + 1;
        goto L3
    }

    public void addObserver(Observer observer) {
        String[] r0 = resolveViews(observer.mTables);
        int[] r1 = new int[r0.length];
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        Integer r4 = this.mTableIdLookup.get(r0[r3].toLowerCase(Locale.US));
        if (r4 == null) goto L8;
        r1[r3] = r4.intValue();
        r3 = r3 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name " + r0[r3]);
    L9:
        ObserverWrapper r5 = new ObserverWrapper(observer, r1, r0);
        SafeIterableMap<Observer, ObserverWrapper> r6 = this.mObserverMap;
        monitor-enter(r6);
        ObserverWrapper r8 = this.mObserverMap.putIfAbsent(observer, r5);     // Catch: Throwable -> L18
        monitor-exit(r6);     // Catch: Throwable -> L18
        if (r8 == null) goto L15;
        return;
    L15:
        if (this.mObservedTableTracker.onAdded(r1) == false) goto L26;
        syncTriggers();
        return;
    L26:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private String[] validateAndResolveTableNames(String[] tableNames) {
        String[] r6 = resolveViews(tableNames);
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        String r2 = r6[r1];
        if (this.mTableIdLookup.containsKey(r2.toLowerCase(Locale.US)) == false) goto L8;
        r1 = r1 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name " + r2);
    L9:
        return r6;
    }

    private String[] resolveViews(String[] names) {
        HashSet r0 = new HashSet();
        int r1 = names.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        String r3 = names[r2];
        String r4 = r3.toLowerCase(Locale.US);
        if (this.mViewTables.containsKey(r4) == false) goto L7;
        r0.addAll(this.mViewTables.get(r4));
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        r0.add(r3);
        goto L8
    L10:
        return (String[]) r0.toArray(new String[r0.size()]);
    }

    private static void beginTransactionInternal(SupportSQLiteDatabase database) {
        if (database.isWriteAheadLoggingEnabled() == false) goto L5;
        database.beginTransactionNonExclusive();
        return;
    L5:
        database.beginTransaction();
    }

    public void addWeakObserver(Observer observer) {
        addObserver(new WeakObserver(this, observer));
    }

    public void removeObserver(final Observer observer) {
        SafeIterableMap<Observer, ObserverWrapper> r0 = this.mObserverMap;
        monitor-enter(r0);
        ObserverWrapper r3 = this.mObserverMap.remove(observer);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (r3 != null) goto L8;
        return;
    L8:
        if (this.mObservedTableTracker.onRemoved(r3.mTableIds) == false) goto L17;
        syncTriggers();
        return;
    L17:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    boolean ensureInitialization() {
        if (this.mDatabase.isOpen() == true) goto L6;
        return false;
    L6:
        if (this.mInitialized == true) goto L9;
        this.mDatabase.getOpenHelper().getWritableDatabase();
    L9:
        if (this.mInitialized == true) goto L12;
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    L12:
        return true;
    }

    public void refreshVersionsAsync() {
        if (this.mPendingRefresh.compareAndSet(false, true) == false) goto L9;
        AutoCloser r0 = this.mAutoCloser;
        if (r0 == null) goto L7;
        r0.incrementCountAndEnsureDbIsOpen();
    L7:
        this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
        return;
    }

    public void refreshVersionsSync() {
        AutoCloser r0 = this.mAutoCloser;
        if (r0 == null) goto L5;
        r0.incrementCountAndEnsureDbIsOpen();
    L5:
        syncTriggers();
        this.mRefreshRunnable.run();
    }

    public void notifyObserversByTableNames(String... tables) {
        SafeIterableMap<Observer, ObserverWrapper> r0 = this.mObserverMap;
        monitor-enter(r0);
        Iterator<Map.Entry<Observer, ObserverWrapper>> r3 = this.mObserverMap.iterator();     // Catch: Throwable -> L12
    L6:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<Observer, ObserverWrapper> r1 = r3.next();     // Catch: Throwable -> L12
        if (r1.getKey().isRemote() == true) goto L6;
        r1.getValue().notifyByTableNames(tables);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void syncTriggers(SupportSQLiteDatabase database) {
        if (database.inTransaction() == false) goto L38;
        return;
    L38:
        Lock r0 = this.mDatabase.getCloseLock();     // Catch: Throwable -> L31
        r0.lock();     // Catch: Throwable -> L31
        int[] r1 = this.mObservedTableTracker.getTablesToSync();     // Catch: Throwable -> L28
        if (r1 == null) goto L8;
        int r2 = r1.length;     // Catch: Throwable -> L28
        beginTransactionInternal(database);     // Catch: Throwable -> L28
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L21;
        int r4 = r1[r3];     // Catch: Throwable -> L25
        if (r4 != 1) goto L16;
        startTrackingTable(database, r3);     // Catch: Throwable -> L25
    L20:
        r3 = r3 + 1;     // Catch: Throwable -> L25
        goto L12
    L16:
        if (r4 != 2) goto L20;
        stopTrackingTable(database, r3);     // Catch: Throwable -> L25
        goto L20
    L25:
        th = move-exception;
        database.endTransaction();     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L21:
        database.setTransactionSuccessful();     // Catch: Throwable -> L25
        database.endTransaction();     // Catch: Throwable -> L28
        this.mObservedTableTracker.onSyncCompleted();     // Catch: Throwable -> L28
        r0.unlock();     // Catch: Throwable -> L31 Throwable -> L31
        goto L38
    L8:
        r0.unlock();     // Catch: Throwable -> L31 Throwable -> L31
        return;
    L28:
        th = move-exception;
        r0.unlock();     // Catch: Throwable -> L31 Throwable -> L31
        throw th;     // Catch: Throwable -> L31 Throwable -> L31
    L31:
        e = move-exception;
        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
    }

    void syncTriggers() {
        if (this.mDatabase.isOpen() == true) goto L5;
        return;
    L5:
        syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
    }

    @Deprecated
    public <T> LiveData<T> createLiveData(String[] tableNames, Callable<T> computeFunction) {
        return createLiveData(tableNames, false, computeFunction);
    }

    public <T> LiveData<T> createLiveData(String[] tableNames, boolean inTransaction, Callable<T> computeFunction) {
        return this.mInvalidationLiveDataContainer.create(validateAndResolveTableNames(tableNames), inTransaction, computeFunction);
    }
}
