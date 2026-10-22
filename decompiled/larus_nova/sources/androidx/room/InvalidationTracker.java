package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ss.android.lark.widget.span.InlineCodeInfo;
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

/* JADX INFO: loaded from: classes3.dex */
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
    private final ObservedTableTracker mObservedTableTracker;
    final SafeIterableMap<Observer, ObserverWrapper> mObserverMap;
    AtomicBoolean mPendingRefresh;
    Runnable mRefreshRunnable;
    private final Object mSyncTriggersLock;
    final HashMap<String, Integer> mTableIdLookup;
    final String[] mTableNames;
    private Map<String, Set<String>> mViewTables;

    public static class ObservedTableTracker {
        static final int ADD = 1;
        static final int NO_OP = 0;
        static final int REMOVE = 2;
        boolean mNeedsSync;
        final long[] mTableObservers;
        final int[] mTriggerStateChanges;
        final boolean[] mTriggerStates;

        public int[] getTablesToSync() {
            monitor-enter(this);
        L26:
            th = move-exception;
            throw th;
        L4:
            if (this.mNeedsSync == true) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L26
            return null;
        L8:
            int r100 = this.mTableObservers.length;     // Catch: Throwable -> L26
            int r101 = 0;
        L9:
            if (r101 >= r100) goto L23;
            int r102 = 1;
            if (this.mTableObservers[r101] <= 0) goto L13;
            boolean r103 = true;
        L14:
            boolean[] r104 = this.mTriggerStates;     // Catch: Throwable -> L26
            if (r103 == r104[r101]) goto L21;
            int[] r105 = this.mTriggerStateChanges;     // Catch: Throwable -> L26
            if (r103 == true) goto L20;
            r102 = 2;
        L20:
            r105[r101] = r102;     // Catch: Throwable -> L26
        L22:
            r104[r101] = r103;     // Catch: Throwable -> L26
            r101 = r101 + 1;     // Catch: Throwable -> L26
            goto L9
        L21:
            this.mTriggerStateChanges[r101] = 0;     // Catch: Throwable -> L26
            goto L22
        L13:
            r103 = false;
            goto L14
        L23:
            this.mNeedsSync = false;     // Catch: Throwable -> L26
            int[] r106 = (int[]) this.mTriggerStateChanges.clone();     // Catch: Throwable -> L26
            monitor-exit(this);     // Catch: Throwable -> L26
            return r106;
        }

        public void resetTriggerState() {
            monitor-enter(this);
            Arrays.fill(this.mTriggerStates, false);     // Catch: Throwable -> L6
            this.mNeedsSync = true;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public ObservedTableTracker(int r100) {
            long[] r101 = new long[r100];
            this.mTableObservers = r101;
            boolean[] r102 = new boolean[r100];
            this.mTriggerStates = r102;
            this.mTriggerStateChanges = new int[r100];
            Arrays.fill(r101, 0);
            Arrays.fill(r102, false);
        }

        public boolean onAdded(int... r110) {
            monitor-enter(this);
            int r100 = r110.length;     // Catch: Throwable -> L11
            int r101 = 0;
            boolean r102 = false;
        L4:
            if (r101 >= r100) goto L9;
            int r103 = r110[r101];     // Catch: Throwable -> L11
            long[] r104 = this.mTableObservers;     // Catch: Throwable -> L11
            long r105 = r104[r103];     // Catch: Throwable -> L11
            r104[r103] = 1 + r105;     // Catch: Throwable -> L11
            if (r105 != 0) goto L8;
            r102 = true;
            this.mNeedsSync = true;     // Catch: Throwable -> L11
        L8:
            r101 = r101 + 1;     // Catch: Throwable -> L11
            goto L4
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r102;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean onRemoved(int... r110) {
            monitor-enter(this);
            int r100 = r110.length;     // Catch: Throwable -> L11
            int r101 = 0;
            boolean r102 = false;
        L4:
            if (r101 >= r100) goto L9;
            int r103 = r110[r101];     // Catch: Throwable -> L11
            long[] r104 = this.mTableObservers;     // Catch: Throwable -> L11
            long r105 = r104[r103];     // Catch: Throwable -> L11
            r104[r103] = r105 - 1;     // Catch: Throwable -> L11
            if (r105 != 1) goto L8;
            r102 = true;
            this.mNeedsSync = true;     // Catch: Throwable -> L11
        L8:
            r101 = r101 + 1;     // Catch: Throwable -> L11
            goto L4
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r102;
        L11:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static abstract class Observer {
        final String[] mTables;

        public boolean isRemote() {
            return false;
        }

        public abstract void onInvalidated(Set<String> r100);

        public Observer(String[] r100) {
            this.mTables = (String[]) Arrays.copyOf(r100, r100.length);
        }

        public Observer(String r100, String... r101) {
            String[] r102 = (String[]) Arrays.copyOf(r101, r101.length + 1);
            this.mTables = r102;
            r102[r101.length] = r100;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ObserverWrapper {
        final Observer mObserver;
        private final Set<String> mSingleTableSet;
        final int[] mTableIds;
        private final String[] mTableNames;

        public void notifyByTableInvalidStatus(Set<Integer> r100) {
            int r101 = this.mTableIds.length;
            Set<String> r102 = null;
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L13;
            if (r100.contains(Integer.valueOf(this.mTableIds[r103])) == false) goto L12;
            if (r101 != 1) goto L9;
            r102 = this.mSingleTableSet;
            goto L12
        L9:
            if (r102 != null) goto L11;
            r102 = new HashSet(r101);
        L11:
            r102.add(this.mTableNames[r103]);
        L12:
            r103 = r103 + 1;
            goto L3
        L13:
            if (r102 == null) goto L20;
            this.mObserver.onInvalidated(r102);
            return;
        }

        public void notifyByTableNames(String[] r110) {
            Set<String> r100 = null;
            if (this.mTableNames.length != 1) goto L10;
            int r101 = r110.length;
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L22;
            if (r110[r102].equalsIgnoreCase(this.mTableNames[0]) == true) goto L8;
            r102 = r102 + 1;
            goto L5
        L8:
            r100 = this.mSingleTableSet;
        L22:
            if (r100 == null) goto L31;
            this.mObserver.onInvalidated(r100);
            return;
        L31:
            return;
        L10:
            HashSet r103 = new HashSet();
            int r104 = r110.length;
            int r105 = 0;
        L11:
            if (r105 >= r104) goto L20;
            String r106 = r110[r105];
            String[] r107 = this.mTableNames;
            int r108 = r107.length;
            int r109 = 0;
        L13:
            if (r109 >= r108) goto L18;
            String r111 = r107[r109];
            if (r111.equalsIgnoreCase(r106) == true) goto L16;
            r109 = r109 + 1;
            goto L13
        L16:
            r103.add(r111);
        L18:
            r105 = r105 + 1;
            goto L11
        L20:
            if (r103.size() <= 0) goto L22;
            r100 = r103;
            goto L22
        }

        public ObserverWrapper(Observer r100, int[] r101, String[] r102) {
            this.mObserver = r100;
            this.mTableIds = r101;
            this.mTableNames = r102;
            if (r101.length != 1) goto L5;
            HashSet r103 = new HashSet();
            r103.add(r102[0]);
            this.mSingleTableSet = Collections.unmodifiableSet(r103);
            return;
        L5:
            this.mSingleTableSet = null;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class WeakObserver extends Observer {
        final WeakReference<Observer> mDelegateRef;
        final InvalidationTracker mTracker;

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(Set<String> r100) {
            Observer r101 = this.mDelegateRef.get();
            if (r101 != null) goto L5;
            this.mTracker.removeObserver(this);
            return;
        L5:
            r101.onInvalidated(r100);
        }

        public WeakObserver(InvalidationTracker r100, Observer r101) {
            super(r101.mTables);
            this.mTracker = r100;
            this.mDelegateRef = new WeakReference(r101);
        }
    }

    public void onAutoCloseCallback() {
        monitor-enter(this);
        this.mInitialized = false;     // Catch: Throwable -> L7
        this.mObservedTableTracker.resetTriggerState();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static {
        TRIGGERS = new String[]{"UPDATE", "DELETE", "INSERT"};
    }

    public boolean ensureInitialization() {
        if (this.mDatabase.isOpen() == true) goto L6;
        return false;
    L6:
        if (this.mInitialized == true) goto L9;
        this.mDatabase.getOpenHelper().getWritableDatabase();
    L9:
        if (this.mInitialized == true) goto L11;
        return false;
    L11:
        return true;
    }

    public void refreshVersionsAsync() {
        if (this.mPendingRefresh.compareAndSet(false, true) == false) goto L9;
        AutoCloser r100 = this.mAutoCloser;
        if (r100 == null) goto L7;
        r100.incrementCountAndEnsureDbIsOpen();
    L7:
        this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
        return;
    }

    public void refreshVersionsSync() {
        AutoCloser r100 = this.mAutoCloser;
        if (r100 == null) goto L5;
        r100.incrementCountAndEnsureDbIsOpen();
    L5:
        syncTriggers();
        this.mRefreshRunnable.run();
    }

    public void stopMultiInstanceInvalidation() {
        MultiInstanceInvalidationClient r100 = this.mMultiInstanceInvalidationClient;
        if (r100 == null) goto L6;
        r100.stop();
        this.mMultiInstanceInvalidationClient = null;
        return;
    }

    public void syncTriggers() {
        if (this.mDatabase.isOpen() == true) goto L5;
        return;
    L5:
        syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
    }

    private static void beginTransactionInternal(SupportSQLiteDatabase r100) {
        if (r100.isWriteAheadLoggingEnabled() == false) goto L5;
        r100.beginTransactionNonExclusive();
        return;
    L5:
        r100.beginTransaction();
    }

    private String[] resolveViews(String[] r100) {
        HashSet r101 = new HashSet();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        String r104 = r100[r103];
        String r105 = r104.toLowerCase(Locale.US);
        if (this.mViewTables.containsKey(r105) == false) goto L7;
        r101.addAll(this.mViewTables.get(r105));
    L8:
        r103 = r103 + 1;
        goto L3
    L7:
        r101.add(r104);
        goto L8
    L10:
        return (String[]) r101.toArray(new String[r101.size()]);
    }

    private String[] validateAndResolveTableNames(String[] r100) {
        String[] r101 = resolveViews(r100);
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        String r104 = r101[r103];
        if (this.mTableIdLookup.containsKey(r104.toLowerCase(Locale.US)) == false) goto L8;
        r103 = r103 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name ".concat(r104));
    L9:
        return r101;
    }

    public void addObserver(Observer r100) {
        String[] r101 = resolveViews(r100.mTables);
        int[] r102 = new int[r101.length];
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        Integer r105 = this.mTableIdLookup.get(r101[r104].toLowerCase(Locale.US));
        if (r105 == null) goto L8;
        r102[r104] = r105.intValue();
        r104 = r104 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("There is no table with name " + r101[r104]);
    L9:
        ObserverWrapper r106 = new ObserverWrapper(r100, r102, r101);
        SafeIterableMap<Observer, ObserverWrapper> r107 = this.mObserverMap;
        monitor-enter(r107);
        ObserverWrapper r108 = this.mObserverMap.putIfAbsent(r100, r106);     // Catch: Throwable -> L18
        monitor-exit(r107);     // Catch: Throwable -> L18
        if (r108 == null) goto L15;
        return;
    L15:
        if (this.mObservedTableTracker.onAdded(r102) == false) goto L26;
        syncTriggers();
        return;
    L26:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public void addWeakObserver(Observer r100) {
        addObserver(new WeakObserver(this, r100));
    }

    public void internalInit(SupportSQLiteDatabase r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mInitialized == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        r100.execSQL("PRAGMA temp_store = MEMORY;");     // Catch: Throwable -> L10
        r100.execSQL("PRAGMA recursive_triggers='ON';");     // Catch: Throwable -> L10
        r100.execSQL(CREATE_TRACKING_TABLE_SQL);     // Catch: Throwable -> L10
        syncTriggers(r100);     // Catch: Throwable -> L10
        this.mCleanupStatement = r100.compileStatement(RESET_UPDATED_TABLES_SQL);     // Catch: Throwable -> L10
        this.mInitialized = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public void notifyObserversByTableNames(String... r100) {
        SafeIterableMap<Observer, ObserverWrapper> r101 = this.mObserverMap;
        monitor-enter(r101);
        Iterator<Map.Entry<Observer, ObserverWrapper>> r102 = this.mObserverMap.iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<Observer, ObserverWrapper> r103 = r102.next();     // Catch: Throwable -> L12
        if (r103.getKey().isRemote() == true) goto L6;
        r103.getValue().notifyByTableNames(r100);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void removeObserver(Observer r100) {
        SafeIterableMap<Observer, ObserverWrapper> r101 = this.mObserverMap;
        monitor-enter(r101);
        ObserverWrapper r102 = this.mObserverMap.remove(r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.mObservedTableTracker.onRemoved(r102.mTableIds) == false) goto L17;
        syncTriggers();
        return;
    L17:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void setAutoCloser(AutoCloser r100) {
        this.mAutoCloser = r100;
        r100.setAutoCloseCallback(new e0(this));
    }

    public void syncTriggers(SupportSQLiteDatabase r100) {
        if (r100.inTransaction() == false) goto L44;
        return;
    L44:
        Lock r101 = this.mDatabase.getCloseLock();     // Catch: Throwable -> L39
        r101.lock();     // Catch: Throwable -> L39
        Object r102 = this.mSyncTriggersLock;     // Catch: Throwable -> L35
        monitor-enter(r102);     // Catch: Throwable -> L35
        int[] r103 = this.mObservedTableTracker.getTablesToSync();     // Catch: Throwable -> L32
        if (r103 != null) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L32
        r101.unlock();     // Catch: Throwable -> L39 Throwable -> L39
        return;
    L13:
        int r104 = r103.length;     // Catch: Throwable -> L32
        beginTransactionInternal(r100);     // Catch: Throwable -> L32
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L24;
        int r106 = r103[r105];     // Catch: Throwable -> L29
        if (r106 != 1) goto L19;
        startTrackingTable(r100, r105);     // Catch: Throwable -> L29
    L23:
        r105 = r105 + 1;     // Catch: Throwable -> L29
        goto L15
    L19:
        if (r106 != 2) goto L23;
        stopTrackingTable(r100, r105);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r100.endTransaction();     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L24:
        r100.setTransactionSuccessful();     // Catch: Throwable -> L29
        r100.endTransaction();     // Catch: Throwable -> L32
        monitor-exit(r102);     // Catch: Throwable -> L32
        r101.unlock();     // Catch: Throwable -> L39 Throwable -> L39
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r101.unlock();     // Catch: Throwable -> L39 Throwable -> L39
        throw th;     // Catch: Throwable -> L39 Throwable -> L39
    }

    public InvalidationTracker(RoomDatabase r100, String... r101) {
        this(r100, new HashMap(), Collections.emptyMap(), r101);
    }

    private void startTrackingTable(SupportSQLiteDatabase r100, int r110) {
        r100.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + r110 + ", 0)");
        String r101 = this.mTableNames[r110];
        StringBuilder r102 = new StringBuilder();
        String[] r103 = TRIGGERS;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        String r106 = r103[r105];
        r102.setLength(0);
        r102.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
        appendTriggerName(r102, r101, r106);
        r102.append(" AFTER ");
        r102.append(r106);
        r102.append(" ON `");
        r102.append(r101);
        r102.append("` BEGIN UPDATE ");
        r102.append(UPDATE_TABLE_NAME);
        r102.append(" SET ");
        r102.append(INVALIDATED_COLUMN_NAME);
        r102.append(" = 1");
        r102.append(" WHERE ");
        r102.append(TABLE_ID_COLUMN_NAME);
        r102.append(" = ");
        r102.append(r110);
        r102.append(" AND ");
        r102.append(INVALIDATED_COLUMN_NAME);
        r102.append(" = 0");
        r102.append("; END");
        r100.execSQL(r102.toString());
        r105 = r105 + 1;
        goto L3
    }

    private void stopTrackingTable(SupportSQLiteDatabase r100, int r101) {
        String r102 = this.mTableNames[r101];
        StringBuilder r103 = new StringBuilder();
        String[] r104 = TRIGGERS;
        int r105 = r104.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        String r107 = r104[r106];
        r103.setLength(0);
        r103.append("DROP TRIGGER IF EXISTS ");
        appendTriggerName(r103, r102, r107);
        r100.execSQL(r103.toString());
        r106 = r106 + 1;
        goto L3
    }

    public <T> LiveData<T> createLiveData(String[] r100, Callable<T> r101) {
        return createLiveData(r100, false, r101);
    }

    private static void appendTriggerName(StringBuilder r100, String r101, String r102) {
        r100.append(InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER);
        r100.append("room_table_modification_trigger_");
        r100.append(r101);
        r100.append("_");
        r100.append(r102);
        r100.append(InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER);
    }

    public <T> LiveData<T> createLiveData(String[] r100, boolean r101, Callable<T> r102) {
        return this.mInvalidationLiveDataContainer.create(validateAndResolveTableNames(r100), r101, r102);
    }

    public void startMultiInstanceInvalidation(Context r100, String r101, Intent r110) {
        this.mMultiInstanceInvalidationClient = new MultiInstanceInvalidationClient(r100, r101, r110, this, this.mDatabase.getQueryExecutor());
    }

    public InvalidationTracker(RoomDatabase r100, Map<String, String> r101, Map<String, Set<String>> r102, String... r103) {
        this.mAutoCloser = null;
        int r104 = 0;
        this.mPendingRefresh = new AtomicBoolean(false);
        this.mInitialized = false;
        this.mObserverMap = new SafeIterableMap();
        this.mSyncTriggersLock = new Object();
        this.mRefreshRunnable = new AnonymousClass1(this);
        this.mDatabase = r100;
        this.mObservedTableTracker = new ObservedTableTracker(r103.length);
        this.mTableIdLookup = new HashMap();
        this.mViewTables = r102;
        this.mInvalidationLiveDataContainer = new InvalidationLiveDataContainer(r100);
        int r105 = r103.length;
        this.mTableNames = new String[r105];
    L3:
        if (r104 >= r105) goto L9;
        String r106 = r103[r104];
        Locale r107 = Locale.US;
        String r108 = r106.toLowerCase(r107);
        this.mTableIdLookup.put(r108, Integer.valueOf(r104));
        String r109 = r101.get(r103[r104]);
        if (r109 == null) goto L7;
        this.mTableNames[r104] = r109.toLowerCase(r107);
    L8:
        r104 = r104 + 1;
        goto L3
    L7:
        this.mTableNames[r104] = r108;
        goto L8
    L9:
        Iterator<Map.Entry<String, String>> r110 = r101.entrySet().iterator();
    L11:
        if (r110.hasNext() == false) goto L15;
        Map.Entry<String, String> r111 = r110.next();
        String r112 = r111.getValue();
        Locale r113 = Locale.US;
        String r114 = r112.toLowerCase(r113);
        if (this.mTableIdLookup.containsKey(r114) == false) goto L11;
        String r115 = r111.getKey().toLowerCase(r113);
        HashMap<String, Integer> r116 = this.mTableIdLookup;
        r116.put(r115, r116.get(r114));
        goto L11
    }
}
