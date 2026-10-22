package androidx.room;

import D7.N;
import P3.d;
import S7.k;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.t;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.builders.SetBuilder;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.C1732y;
import p9.m;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 Z2\u00020\u0001:\u0001ZBo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u001b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010#\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0004\u0012\u00020\u00180 2\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\tH\u0000¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b'\u0010%J\u0010\u0010+\u001a\u00020\u000fH\u0080@¢\u0006\u0004\b)\u0010*J@\u00102\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0-H\u0080@¢\u0006\u0004\b0\u00101J/\u00105\u001a\u00020\u000f2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0-2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0-H\u0000¢\u0006\u0004\b3\u00104J\u000f\u00108\u001a\u00020\u000fH\u0000¢\u0006\u0004\b6\u00107J%\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\tH\u0002¢\u0006\u0004\b9\u0010:J \u0010=\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b=\u0010>J \u0010?\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b?\u0010>J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0082@¢\u0006\u0004\b@\u0010*J\u001e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u0014\u001a\u00020;H\u0082@¢\u0006\u0004\bA\u0010BR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010CR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010DR&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010DR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010ER&\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010FR \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010DR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u00060Pj\u0002`Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR(\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000b0-8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006["}, d2 = {"Landroidx/room/TriggerBasedInvalidationTracker;", "", "Landroidx/room/RoomDatabase;", "database", "", "", "shadowTablesMap", "", "viewTables", "", "tableNames", "", "useTempTable", "Lkotlin/Function1;", "", "LC7/r;", "onInvalidatedTablesIds", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;ZLS7/k;)V", "Landroidx/sqlite/SQLiteConnection;", "connection", "configureConnection", "(Landroidx/sqlite/SQLiteConnection;)V", "resolvedTableNames", "", "tableIds", "emitInitialState", "Lp9/c;", "createFlow$room_runtime", "([Ljava/lang/String;[IZ)Lp9/c;", "createFlow", "names", "Lkotlin/Pair;", "validateTableNames$room_runtime", "([Ljava/lang/String;)Lkotlin/Pair;", "validateTableNames", "onObserverAdded$room_runtime", "([I)Z", "onObserverAdded", "onObserverRemoved$room_runtime", "onObserverRemoved", "syncTriggers$room_runtime", "(LH7/c;)Ljava/lang/Object;", "syncTriggers", "tables", "Lkotlin/Function0;", "onRefreshScheduled", "onRefreshCompleted", "refreshInvalidation$room_runtime", "([Ljava/lang/String;LS7/a;LS7/a;LH7/c;)Ljava/lang/Object;", "refreshInvalidation", "refreshInvalidationAsync$room_runtime", "(LS7/a;LS7/a;)V", "refreshInvalidationAsync", "resetSync$room_runtime", "()V", "resetSync", "resolveViews", "([Ljava/lang/String;)[Ljava/lang/String;", "Landroidx/room/PooledConnection;", "tableId", "startTrackingTable", "(Landroidx/room/PooledConnection;ILH7/c;)Ljava/lang/Object;", "stopTrackingTable", "notifyInvalidation", "checkInvalidatedTables", "(Landroidx/room/PooledConnection;LH7/c;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Ljava/util/Map;", "Z", "LS7/k;", "tableIdLookup", "tablesNames", "[Ljava/lang/String;", "Landroidx/room/ObservedTableStates;", "observedTableStates", "Landroidx/room/ObservedTableStates;", "Landroidx/room/ObservedTableVersions;", "observedTableVersions", "Landroidx/room/ObservedTableVersions;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onAllowRefresh", "LS7/a;", "getOnAllowRefresh$room_runtime", "()LS7/a;", "setOnAllowRefresh$room_runtime", "(LS7/a;)V", "Companion", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TriggerBasedInvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String DROP_TRACKING_TABLE_SQL = "DROP TABLE IF EXISTS room_table_modification_log";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    private static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    private static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private final RoomDatabase database;
    private final ObservedTableStates observedTableStates;
    private final ObservedTableVersions observedTableVersions;
    private S7.a onAllowRefresh;
    private final k onInvalidatedTablesIds;
    private final AtomicBoolean pendingRefresh;
    private final Map<String, String> shadowTablesMap;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final boolean useTempTable;
    private final Map<String, Set<String>> viewTables;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] TRIGGERS = {"INSERT", "UPDATE", "DELETE"};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/TriggerBasedInvalidationTracker$Companion;", "", AppAgent.CONSTRUCT, "()V", "TRIGGERS", "", "", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "TABLE_ID_COLUMN_NAME", "INVALIDATED_COLUMN_NAME", "CREATE_TRACKING_TABLE_SQL", "DROP_TRACKING_TABLE_SQL", "SELECT_UPDATED_TABLES_SQL", "RESET_UPDATED_TABLES_SQL", "getTriggerName", "tableName", "triggerType", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getTriggerName(String tableName, String triggerType) {
            return "room_table_modification_trigger_" + tableName + '_' + triggerType;
        }

        private Companion() {
        }
    }

    @J7.c(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {444, 452}, m = "checkInvalidatedTables")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.checkInvalidatedTables(null, this);
        }
    }

    @J7.c(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {TypedValues.CycleType.TYPE_PATH_ROTATE}, m = "notifyInvalidation")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07881 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C07881(H7.c<? super C07881> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.notifyInvalidation(this);
        }
    }

    @J7.c(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {327, 332}, m = "startTrackingTable")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$startTrackingTable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07891 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C07891(H7.c<? super C07891> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.startTrackingTable(null, 0, this);
        }
    }

    @J7.c(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {346}, m = "stopTrackingTable")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07901 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C07901(H7.c<? super C07901> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TriggerBasedInvalidationTracker.this.stopTrackingTable(null, 0, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerBasedInvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, ? extends Set<String>> viewTables, String[] tableNames, boolean z10, k onInvalidatedTablesIds) {
        String lowerCase;
        kotlin.jvm.internal.k.f(database, "database");
        kotlin.jvm.internal.k.f(shadowTablesMap, "shadowTablesMap");
        kotlin.jvm.internal.k.f(viewTables, "viewTables");
        kotlin.jvm.internal.k.f(tableNames, "tableNames");
        kotlin.jvm.internal.k.f(onInvalidatedTablesIds, "onInvalidatedTablesIds");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.useTempTable = z10;
        this.onInvalidatedTablesIds = onInvalidatedTablesIds;
        this.pendingRefresh = new AtomicBoolean(false);
        this.onAllowRefresh = new d(17);
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            String str = tableNames[i];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            kotlin.jvm.internal.k.e(lowerCase2, "toLowerCase(...)");
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i));
            String str2 = this.shadowTablesMap.get(tableNames[i]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i] = lowerCase2;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = value.toLowerCase(locale2);
            kotlin.jvm.internal.k.e(lowerCase3, "toLowerCase(...)");
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String lowerCase4 = entry.getKey().toLowerCase(locale2);
                kotlin.jvm.internal.k.e(lowerCase4, "toLowerCase(...)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase4, kotlin.collections.a.N(lowerCase3, map));
            }
        }
        this.observedTableStates = new ObservedTableStates(this.tablesNames.length);
        this.observedTableVersions = new ObservedTableVersions(this.tablesNames.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkInvalidatedTables(androidx.room.PooledConnection r5, H7.c<? super java.util.Set<java.lang.Integer>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.room.TriggerBasedInvalidationTracker.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = (androidx.room.TriggerBasedInvalidationTracker.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r5 = r0.L$0
            java.util.Set r5 = (java.util.Set) r5
            kotlin.b.b(r4)
            return r5
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            java.lang.Object r5 = r0.L$0
            androidx.room.PooledConnection r5 = (androidx.room.PooledConnection) r5
            kotlin.b.b(r4)
            goto L55
        L3e:
            kotlin.b.b(r4)
            androidx.compose.ui.text.d r4 = new androidx.compose.ui.text.d
            r1 = 10
            r4.<init>(r1)
            r0.L$0 = r5
            r0.label = r3
            java.lang.String r1 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r4 = r5.usePrepared(r1, r4, r0)
            if (r4 != r6) goto L55
            goto L6c
        L55:
            java.util.Set r4 = (java.util.Set) r4
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L6d
            r0.L$0 = r4
            r0.label = r2
            java.lang.String r1 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r5 = androidx.room.TransactorKt.execSQL(r5, r1, r0)
            if (r5 != r6) goto L6d
        L6c:
            return r6
        L6d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.checkInvalidatedTables(androidx.room.PooledConnection, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set checkInvalidatedTables$lambda$14(SQLiteStatement statement) {
        kotlin.jvm.internal.k.f(statement, "statement");
        SetBuilder setBuilder = new SetBuilder();
        while (statement.step()) {
            setBuilder.add(Integer.valueOf((int) statement.getLong(0)));
        }
        return N.m(setBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object notifyInvalidation(H7.c<? super java.util.Set<java.lang.Integer>> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.room.TriggerBasedInvalidationTracker.C07881
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = (androidx.room.TriggerBasedInvalidationTracker.C07881) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            androidx.room.concurrent.CloseBarrier r0 = (androidx.room.concurrent.CloseBarrier) r0
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L2b
            goto L80
        L2b:
            r8 = move-exception
            goto L99
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            kotlin.b.b(r9)
            androidx.room.RoomDatabase r9 = r8.database
            androidx.room.concurrent.CloseBarrier r9 = r9.getCloseBarrier()
            boolean r2 = r9.block$room_runtime()
            if (r2 == 0) goto L9d
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.pendingRefresh     // Catch: java.lang.Throwable -> L53
            r4 = 0
            boolean r2 = r2.compareAndSet(r3, r4)     // Catch: java.lang.Throwable -> L53
            if (r2 != 0) goto L56
            kotlin.collections.EmptySet r8 = kotlin.collections.EmptySet.f4895a     // Catch: java.lang.Throwable -> L53
            r9.unblock$room_runtime()
            return r8
        L53:
            r8 = move-exception
            r0 = r9
            goto L99
        L56:
            S7.a r2 = r8.onAllowRefresh     // Catch: java.lang.Throwable -> L53
            java.lang.Object r2 = r2.invoke()     // Catch: java.lang.Throwable -> L53
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L53
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L53
            if (r2 != 0) goto L6a
            kotlin.collections.EmptySet r8 = kotlin.collections.EmptySet.f4895a     // Catch: java.lang.Throwable -> L53
            r9.unblock$room_runtime()
            return r8
        L6a:
            androidx.room.RoomDatabase r2 = r8.database     // Catch: java.lang.Throwable -> L53
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1     // Catch: java.lang.Throwable -> L53
            r6 = 0
            r5.<init>(r8, r6)     // Catch: java.lang.Throwable -> L53
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L53
            r0.label = r3     // Catch: java.lang.Throwable -> L53
            java.lang.Object r0 = r2.useConnection(r4, r5, r0)     // Catch: java.lang.Throwable -> L53
            if (r0 != r1) goto L7d
            return r1
        L7d:
            r7 = r0
            r0 = r9
            r9 = r7
        L80:
            java.util.Set r9 = (java.util.Set) r9     // Catch: java.lang.Throwable -> L2b
            r1 = r9
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L2b
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L2b
            if (r1 != 0) goto L95
            androidx.room.ObservedTableVersions r1 = r8.observedTableVersions     // Catch: java.lang.Throwable -> L2b
            r1.increment(r9)     // Catch: java.lang.Throwable -> L2b
            S7.k r8 = r8.onInvalidatedTablesIds     // Catch: java.lang.Throwable -> L2b
            r8.invoke(r9)     // Catch: java.lang.Throwable -> L2b
        L95:
            r0.unblock$room_runtime()
            return r9
        L99:
            r0.unblock$room_runtime()
            throw r8
        L9d:
            kotlin.collections.EmptySet r8 = kotlin.collections.EmptySet.f4895a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.notifyInvalidation(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAllowRefresh$lambda$0() {
        return true;
    }

    public static /* synthetic */ Object refreshInvalidation$room_runtime$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, String[] strArr, S7.a aVar, S7.a aVar2, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            aVar = new d(20);
        }
        if ((i & 4) != 0) {
            aVar2 = new d(21);
        }
        return triggerBasedInvalidationTracker.refreshInvalidation$room_runtime(strArr, aVar, aVar2, cVar);
    }

    public static /* synthetic */ void refreshInvalidationAsync$room_runtime$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, S7.a aVar, S7.a aVar2, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = new d(18);
        }
        if ((i & 2) != 0) {
            aVar2 = new d(19);
        }
        triggerBasedInvalidationTracker.refreshInvalidationAsync$room_runtime(aVar, aVar2);
    }

    private final String[] resolveViews(String[] names) {
        SetBuilder setBuilder = new SetBuilder();
        for (String str : names) {
            Map<String, Set<String>> map = this.viewTables;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
            Set<String> set = map.get(lowerCase);
            if (set != null) {
                setBuilder.addAll(set);
            } else {
                setBuilder.add(str);
            }
        }
        return (String[]) N.m(setBuilder).toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
    
        if (androidx.room.TransactorKt.execSQL(r1, r3, r4) == r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00cd, code lost:
    
        if (androidx.room.TransactorKt.execSQL(r11, r3, r4) == r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cf, code lost:
    
        return r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00cd -> B:28:0x00d0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object startTrackingTable(androidx.room.PooledConnection r18, int r19, H7.c<? super C7.r> r20) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.startTrackingTable(androidx.room.PooledConnection, int, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0074 -> B:19:0x0077). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object stopTrackingTable(androidx.room.PooledConnection r9, int r10, H7.c<? super C7.r> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.room.TriggerBasedInvalidationTracker.C07901
            if (r0 == 0) goto L13
            r0 = r11
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = (androidx.room.TriggerBasedInvalidationTracker.C07901) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$2
            java.lang.String[] r10 = (java.lang.String[]) r10
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.L$0
            androidx.room.PooledConnection r4 = (androidx.room.PooledConnection) r4
            kotlin.b.b(r11)
            r11 = r10
            r10 = r4
            goto L77
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L41:
            kotlin.b.b(r11)
            java.lang.String[] r8 = r8.tablesNames
            r8 = r8[r10]
            java.lang.String[] r10 = androidx.room.TriggerBasedInvalidationTracker.TRIGGERS
            int r11 = r10.length
            r2 = 0
            r7 = r2
            r2 = r8
            r8 = r11
            r11 = r10
            r10 = r9
            r9 = r7
        L52:
            if (r9 >= r8) goto L79
            r4 = r11[r9]
            androidx.room.TriggerBasedInvalidationTracker$Companion r5 = androidx.room.TriggerBasedInvalidationTracker.INSTANCE
            java.lang.String r4 = androidx.room.TriggerBasedInvalidationTracker.Companion.access$getTriggerName(r5, r2, r4)
            java.lang.String r5 = "DROP TRIGGER IF EXISTS `"
            r6 = 96
            java.lang.String r4 = androidx.compose.foundation.b.m(r6, r5, r4)
            r0.L$0 = r10
            r0.L$1 = r2
            r0.L$2 = r11
            r0.I$0 = r9
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r4 = androidx.room.TransactorKt.execSQL(r10, r4, r0)
            if (r4 != r1) goto L77
            return r1
        L77:
            int r9 = r9 + r3
            goto L52
        L79:
            C7.r r8 = C7.r.f317a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.stopTrackingTable(androidx.room.PooledConnection, int, H7.c):java.lang.Object");
    }

    public final void configureConnection(SQLiteConnection connection) {
        kotlin.jvm.internal.k.f(connection, "connection");
        SQLiteStatement sQLiteStatementPrepare = connection.prepare("PRAGMA query_only");
        try {
            sQLiteStatementPrepare.step();
            boolean z10 = sQLiteStatementPrepare.getBoolean(0);
            com.stepos.ability.task.executor.e.s(sQLiteStatementPrepare, null);
            if (z10) {
                return;
            }
            SQLite.execSQL(connection, "PRAGMA temp_store = MEMORY");
            SQLite.execSQL(connection, "PRAGMA recursive_triggers = 1");
            SQLite.execSQL(connection, DROP_TRACKING_TABLE_SQL);
            if (this.useTempTable) {
                SQLite.execSQL(connection, CREATE_TRACKING_TABLE_SQL);
            } else {
                SQLite.execSQL(connection, t.c0(CREATE_TRACKING_TABLE_SQL, "TEMP", ""));
            }
            this.observedTableStates.forceNeedSync$room_runtime();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                com.stepos.ability.task.executor.e.s(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    public final p9.c createFlow$room_runtime(String[] resolvedTableNames, int[] tableIds, boolean emitInitialState) {
        kotlin.jvm.internal.k.f(resolvedTableNames, "resolvedTableNames");
        kotlin.jvm.internal.k.f(tableIds, "tableIds");
        return new m(new TriggerBasedInvalidationTracker$createFlow$1(this, tableIds, emitInitialState, resolvedTableNames, null));
    }

    /* renamed from: getOnAllowRefresh$room_runtime, reason: from getter */
    public final S7.a getOnAllowRefresh() {
        return this.onAllowRefresh;
    }

    public final boolean onObserverAdded$room_runtime(int[] tableIds) {
        kotlin.jvm.internal.k.f(tableIds, "tableIds");
        return this.observedTableStates.onObserverAdded$room_runtime(tableIds);
    }

    public final boolean onObserverRemoved$room_runtime(int[] tableIds) {
        kotlin.jvm.internal.k.f(tableIds, "tableIds");
        return this.observedTableStates.onObserverRemoved$room_runtime(tableIds);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshInvalidation$room_runtime(java.lang.String[] r5, S7.a r6, S7.a r7, H7.c<? super java.lang.Boolean> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            int[] r4 = (int[]) r4
            java.lang.Object r5 = r0.L$0
            r7 = r5
            S7.a r7 = (S7.a) r7
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L30
            goto L56
        L30:
            r4 = move-exception
            goto L88
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.b.b(r8)
            kotlin.Pair r5 = r4.validateTableNames$room_runtime(r5)
            java.lang.Object r5 = r5.b
            int[] r5 = (int[]) r5
            r6.invoke()
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L30
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L30
            r0.label = r3     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = r4.notifyInvalidation(r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r1) goto L55
            return r1
        L55:
            r4 = r5
        L56:
            java.util.Set r8 = (java.util.Set) r8     // Catch: java.lang.Throwable -> L30
            int r5 = r4.length     // Catch: java.lang.Throwable -> L30
            r6 = 0
            if (r5 != 0) goto L5e
            r5 = r3
            goto L5f
        L5e:
            r5 = r6
        L5f:
            if (r5 != 0) goto L78
            int r5 = r4.length     // Catch: java.lang.Throwable -> L30
            r0 = r6
        L63:
            if (r0 >= r5) goto L76
            r1 = r4[r0]     // Catch: java.lang.Throwable -> L30
            java.lang.Integer r2 = new java.lang.Integer     // Catch: java.lang.Throwable -> L30
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L30
            boolean r1 = r8.contains(r2)     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L73
            goto L80
        L73:
            int r0 = r0 + 1
            goto L63
        L76:
            r3 = r6
            goto L80
        L78:
            java.util.Collection r8 = (java.util.Collection) r8     // Catch: java.lang.Throwable -> L30
            boolean r4 = r8.isEmpty()     // Catch: java.lang.Throwable -> L30
            if (r4 != 0) goto L76
        L80:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L30
            r7.invoke()
            return r4
        L88:
            r7.invoke()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.refreshInvalidation$room_runtime(java.lang.String[], S7.a, S7.a, H7.c):java.lang.Object");
    }

    public final void refreshInvalidationAsync$room_runtime(S7.a onRefreshScheduled, S7.a onRefreshCompleted) {
        kotlin.jvm.internal.k.f(onRefreshScheduled, "onRefreshScheduled");
        kotlin.jvm.internal.k.f(onRefreshCompleted, "onRefreshCompleted");
        if (this.pendingRefresh.compareAndSet(false, true)) {
            onRefreshScheduled.invoke();
            AbstractC1683A.n(this.database.getCoroutineScope(), new C1732y("Room Invalidation Tracker Refresh"), new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this, onRefreshCompleted, null), 2);
        }
    }

    public final void resetSync$room_runtime() {
        this.observedTableStates.resetTriggerState$room_runtime();
    }

    public final void setOnAllowRefresh$room_runtime(S7.a aVar) {
        kotlin.jvm.internal.k.f(aVar, "<set-?>");
        this.onAllowRefresh = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object syncTriggers$room_runtime(H7.c<? super C7.r> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            androidx.room.concurrent.CloseBarrier r7 = (androidx.room.concurrent.CloseBarrier) r7
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L2b
            goto L59
        L2b:
            r8 = move-exception
            goto L61
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.b.b(r8)
            androidx.room.RoomDatabase r8 = r7.database
            androidx.room.concurrent.CloseBarrier r8 = r8.getCloseBarrier()
            boolean r2 = r8.block$room_runtime()
            if (r2 == 0) goto L65
            androidx.room.RoomDatabase r2 = r7.database     // Catch: java.lang.Throwable -> L5d
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1 r4 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1     // Catch: java.lang.Throwable -> L5d
            r5 = 0
            r4.<init>(r7, r5)     // Catch: java.lang.Throwable -> L5d
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L5d
            r0.label = r3     // Catch: java.lang.Throwable -> L5d
            r7 = 0
            java.lang.Object r7 = r2.useConnection(r7, r4, r0)     // Catch: java.lang.Throwable -> L5d
            if (r7 != r1) goto L58
            return r1
        L58:
            r7 = r8
        L59:
            r7.unblock$room_runtime()
            goto L65
        L5d:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L61:
            r7.unblock$room_runtime()
            throw r8
        L65:
            C7.r r7 = C7.r.f317a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.syncTriggers$room_runtime(H7.c):java.lang.Object");
    }

    public final Pair<String[], int[]> validateTableNames$room_runtime(String[] names) {
        kotlin.jvm.internal.k.f(names, "names");
        String[] strArrResolveViews = resolveViews(names);
        int length = strArrResolveViews.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            String str = strArrResolveViews[i];
            Map<String, Integer> map = this.tableIdLookup;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name ".concat(str));
            }
            iArr[i] = num.intValue();
        }
        return new Pair<>(strArrResolveViews, iArr);
    }
}
