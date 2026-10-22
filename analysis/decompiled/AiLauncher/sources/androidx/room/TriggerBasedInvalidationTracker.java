package androidx.room;

import Ua.C1060i;
import Ua.CoroutineName;
import Z8.X;
import com.autonavi.aps.amapapi.config.Const;
import i1.C4159a;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import n9.C4946a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 !2\u00020\u0001:\u00018Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u001b\u0010\u001aJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J9\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070'2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000bH\u0000¢\u0006\u0004\b(\u0010)J1\u0010+\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0004\u0012\u00020$0*2\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\tH\u0000¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0000¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$H\u0000¢\u0006\u0004\b/\u0010.J\u0010\u00100\u001a\u00020\u000fH\u0080@¢\u0006\u0004\b0\u0010\u001dJ/\u00104\u001a\u00020\u000f2\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f01H\u0000¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000fH\u0000¢\u0006\u0004\b6\u00107R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R&\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010;R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u00060Nj\u0002`O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010PR(\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b018\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006Y"}, d2 = {"Landroidx/room/TriggerBasedInvalidationTracker;", "", "Landroidx/room/RoomDatabase;", "database", "", "", "shadowTablesMap", "", "viewTables", "", "tableNames", "", "useTempTable", "Lkotlin/Function1;", "", "LY8/t;", "onInvalidatedTablesIds", "<init>", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;ZLp9/l;)V", "names", "t", "([Ljava/lang/String;)[Ljava/lang/String;", "Landroidx/room/l;", "connection", "tableId", "v", "(Landroidx/room/l;ILe9/c;)Ljava/lang/Object;", "w", "n", "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroidx/room/l;Le9/c;)Ljava/lang/Object;", "Li1/b;", "l", "(Li1/b;)V", "resolvedTableNames", "", "tableIds", "emitInitialState", "LXa/b;", "m", "([Ljava/lang/String;[IZ)LXa/b;", "Lkotlin/Pair;", "y", "([Ljava/lang/String;)Lkotlin/Pair;", "p", "([I)Z", "q", "x", "Lkotlin/Function0;", "onRefreshScheduled", "onRefreshCompleted", "r", "(Lp9/a;Lp9/a;)V", "s", "()V", Const.INTENT_KEY_APIKEY, "Landroidx/room/RoomDatabase;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "c", Const.INTENT_KEY_UMID, "Z", "e", "Lp9/l;", "f", "tableIdLookup", Const.INTENT_KEY_BACKGROUND_COMMAND, "[Ljava/lang/String;", "tablesNames", "Landroidx/room/ObservedTableStates;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/room/ObservedTableStates;", "observedTableStates", "Landroidx/room/ObservedTableVersions;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroidx/room/ObservedTableVersions;", "observedTableVersions", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingRefresh", "k", "Lp9/a;", "getOnAllowRefresh$room_runtime", "()Lp9/a;", "u", "(Lp9/a;)V", "onAllowRefresh", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f14543m = {"INSERT", "UPDATE", "DELETE"};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final RoomDatabase database;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, String> shadowTablesMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Set<String>> viewTables;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final boolean useTempTable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<Set<Integer>, Y8.t> onInvalidatedTablesIds;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Integer> tableIdLookup;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final String[] tablesNames;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final ObservedTableStates observedTableStates;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final ObservedTableVersions observedTableVersions;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean pendingRefresh;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<Boolean> onAllowRefresh;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Landroidx/room/TriggerBasedInvalidationTracker$a;", "", "<init>", "()V", "", "tableName", "triggerType", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "TRIGGERS", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "Ljava/lang/String;", "TABLE_ID_COLUMN_NAME", "INVALIDATED_COLUMN_NAME", "CREATE_TRACKING_TABLE_SQL", "DROP_TRACKING_TABLE_SQL", "SELECT_UPDATED_TABLES_SQL", "RESET_UPDATED_TABLES_SQL", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String b(String tableName, String triggerType) {
            return "room_table_modification_trigger_" + tableName + '_' + triggerType;
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerBasedInvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, ? extends Set<String>> viewTables, String[] tableNames, boolean z10, InterfaceC5074l<? super Set<Integer>, Y8.t> onInvalidatedTablesIds) {
        String lowerCase;
        kotlin.jvm.internal.p.i(database, "database");
        kotlin.jvm.internal.p.i(shadowTablesMap, "shadowTablesMap");
        kotlin.jvm.internal.p.i(viewTables, "viewTables");
        kotlin.jvm.internal.p.i(tableNames, "tableNames");
        kotlin.jvm.internal.p.i(onInvalidatedTablesIds, "onInvalidatedTablesIds");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.useTempTable = z10;
        this.onInvalidatedTablesIds = onInvalidatedTablesIds;
        this.pendingRefresh = new AtomicBoolean(false);
        this.onAllowRefresh = new InterfaceC5063a() { // from class: androidx.room.F
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(TriggerBasedInvalidationTracker.o());
            }
        };
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = tableNames[i10];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            kotlin.jvm.internal.p.h(lowerCase2, "toLowerCase(...)");
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i10));
            String str2 = this.shadowTablesMap.get(tableNames[i10]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i10] = lowerCase2;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = value.toLowerCase(locale2);
            kotlin.jvm.internal.p.h(lowerCase3, "toLowerCase(...)");
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String lowerCase4 = entry.getKey().toLowerCase(locale2);
                kotlin.jvm.internal.p.h(lowerCase4, "toLowerCase(...)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase4, kotlin.collections.a.j(map, lowerCase3));
            }
        }
        this.observedTableStates = new ObservedTableStates(this.tablesNames.length);
        this.observedTableVersions = new ObservedTableVersions(this.tablesNames.length);
    }

    public static final Set k(InterfaceC4162d statement) {
        kotlin.jvm.internal.p.i(statement, "statement");
        Set setB = X.b();
        while (statement.n1()) {
            setB.add(Integer.valueOf((int) statement.getLong(0)));
        }
        return X.a(setB);
    }

    public static final boolean o() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(androidx.room.l r5, e9.InterfaceC4014c<? super java.util.Set<java.lang.Integer>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1) r0
            int r1 = r0.f14558d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14558d = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f14556b
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.f14558d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L40
            if (r1 == r3) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r5 = r0.f14555a
            java.util.Set r5 = (java.util.Set) r5
            kotlin.C4849c.b(r4)
            return r5
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            java.lang.Object r5 = r0.f14555a
            androidx.room.l r5 = (androidx.room.l) r5
            kotlin.C4849c.b(r4)
            goto L55
        L40:
            kotlin.C4849c.b(r4)
            androidx.room.E r4 = new androidx.room.E
            r4.<init>()
            r0.f14555a = r5
            r0.f14558d = r3
            java.lang.String r1 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r4 = r5.d(r1, r4, r0)
            if (r4 != r6) goto L55
            goto L6c
        L55:
            java.util.Set r4 = (java.util.Set) r4
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L6d
            r0.f14555a = r4
            r0.f14558d = r2
            java.lang.String r1 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r5 = androidx.room.D.b(r5, r1, r0)
            if (r5 != r6) goto L6d
        L6c:
            return r6
        L6d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.j(androidx.room.l, e9.c):java.lang.Object");
    }

    public final void l(InterfaceC4160b connection) throws Exception {
        kotlin.jvm.internal.p.i(connection, "connection");
        InterfaceC4162d interfaceC4162dQ1 = connection.q1("PRAGMA query_only");
        try {
            interfaceC4162dQ1.n1();
            boolean z10 = interfaceC4162dQ1.getBoolean(0);
            C4946a.a(interfaceC4162dQ1, null);
            if (z10) {
                return;
            }
            C4159a.a(connection, "PRAGMA temp_store = MEMORY");
            C4159a.a(connection, "PRAGMA recursive_triggers = 1");
            C4159a.a(connection, "DROP TABLE IF EXISTS room_table_modification_log");
            if (this.useTempTable) {
                C4159a.a(connection, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            } else {
                C4159a.a(connection, La.D.T("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", "", false, 4, null));
            }
            this.observedTableStates.h();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C4946a.a(interfaceC4162dQ1, th);
                throw th2;
            }
        }
    }

    public final Xa.b<Set<String>> m(String[] resolvedTableNames, int[] tableIds, boolean emitInitialState) {
        kotlin.jvm.internal.p.i(resolvedTableNames, "resolvedTableNames");
        kotlin.jvm.internal.p.i(tableIds, "tableIds");
        return Xa.d.B(new TriggerBasedInvalidationTracker$createFlow$1(this, tableIds, emitInitialState, resolvedTableNames, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(e9.InterfaceC4014c<? super java.util.Set<java.lang.Integer>> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1) r0
            int r1 = r0.f14579d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14579d = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f14577b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f14579d
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.f14576a
            b1.a r0 = (b1.C1442a) r0
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L2d
            goto L87
        L2d:
            r8 = move-exception
            goto La0
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.C4849c.b(r9)
            androidx.room.RoomDatabase r9 = r8.database
            b1.a r9 = r9.getCloseBarrier()
            boolean r2 = r9.a()
            if (r2 == 0) goto La4
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.pendingRefresh     // Catch: java.lang.Throwable -> L58
            r4 = 0
            boolean r2 = r2.compareAndSet(r3, r4)     // Catch: java.lang.Throwable -> L58
            if (r2 != 0) goto L5b
            java.util.Set r8 = Z8.Y.e()     // Catch: java.lang.Throwable -> L58
            r9.d()
            return r8
        L58:
            r8 = move-exception
            r0 = r9
            goto La0
        L5b:
            p9.a<java.lang.Boolean> r2 = r8.onAllowRefresh     // Catch: java.lang.Throwable -> L58
            java.lang.Object r2 = r2.invoke()     // Catch: java.lang.Throwable -> L58
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L58
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L58
            if (r2 != 0) goto L71
            java.util.Set r8 = Z8.Y.e()     // Catch: java.lang.Throwable -> L58
            r9.d()
            return r8
        L71:
            androidx.room.RoomDatabase r2 = r8.database     // Catch: java.lang.Throwable -> L58
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1     // Catch: java.lang.Throwable -> L58
            r6 = 0
            r5.<init>(r8, r6)     // Catch: java.lang.Throwable -> L58
            r0.f14576a = r9     // Catch: java.lang.Throwable -> L58
            r0.f14579d = r3     // Catch: java.lang.Throwable -> L58
            java.lang.Object r0 = r2.U(r4, r5, r0)     // Catch: java.lang.Throwable -> L58
            if (r0 != r1) goto L84
            return r1
        L84:
            r7 = r0
            r0 = r9
            r9 = r7
        L87:
            java.util.Set r9 = (java.util.Set) r9     // Catch: java.lang.Throwable -> L2d
            r1 = r9
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L2d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L2d
            if (r1 != 0) goto L9c
            androidx.room.ObservedTableVersions r1 = r8.observedTableVersions     // Catch: java.lang.Throwable -> L2d
            r1.b(r9)     // Catch: java.lang.Throwable -> L2d
            p9.l<java.util.Set<java.lang.Integer>, Y8.t> r8 = r8.onInvalidatedTablesIds     // Catch: java.lang.Throwable -> L2d
            r8.invoke(r9)     // Catch: java.lang.Throwable -> L2d
        L9c:
            r0.d()
            return r9
        La0:
            r0.d()
            throw r8
        La4:
            java.util.Set r8 = Z8.Y.e()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.n(e9.c):java.lang.Object");
    }

    public final boolean p(int[] tableIds) {
        kotlin.jvm.internal.p.i(tableIds, "tableIds");
        return this.observedTableStates.i(tableIds);
    }

    public final boolean q(int[] tableIds) {
        kotlin.jvm.internal.p.i(tableIds, "tableIds");
        return this.observedTableStates.j(tableIds);
    }

    public final void r(InterfaceC5063a<Y8.t> onRefreshScheduled, InterfaceC5063a<Y8.t> onRefreshCompleted) {
        kotlin.jvm.internal.p.i(onRefreshScheduled, "onRefreshScheduled");
        kotlin.jvm.internal.p.i(onRefreshCompleted, "onRefreshCompleted");
        if (this.pendingRefresh.compareAndSet(false, true)) {
            onRefreshScheduled.invoke();
            C1060i.d(this.database.s(), new CoroutineName("Room Invalidation Tracker Refresh"), null, new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this, onRefreshCompleted, null), 2, null);
        }
    }

    public final void s() {
        this.observedTableStates.k();
    }

    public final String[] t(String[] names) {
        Set setB = X.b();
        for (String str : names) {
            Map<String, Set<String>> map = this.viewTables;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            Set<String> set = map.get(lowerCase);
            if (set != null) {
                setB.addAll(set);
            } else {
                setB.add(str);
            }
        }
        return (String[]) X.a(setB).toArray(new String[0]);
    }

    public final void u(InterfaceC5063a<Boolean> interfaceC5063a) {
        kotlin.jvm.internal.p.i(interfaceC5063a, "<set-?>");
        this.onAllowRefresh = interfaceC5063a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0074, code lost:
    
        if (androidx.room.D.b(r13, r15, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e0, code lost:
    
        if (androidx.room.D.b(r7, r15, r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e2, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00e0 -> B:28:0x00e3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(androidx.room.l r13, int r14, e9.InterfaceC4014c<? super Y8.t> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.v(androidx.room.l, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0084 -> B:19:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(androidx.room.l r9, int r10, e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
            if (r0 == 0) goto L13
            r0 = r11
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1) r0
            int r1 = r0.f14605h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14605h = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.f14603f
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f14605h
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            int r8 = r0.f14602e
            int r9 = r0.f14601d
            java.lang.Object r10 = r0.f14600c
            java.lang.String[] r10 = (java.lang.String[]) r10
            java.lang.Object r2 = r0.f14599b
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.f14598a
            androidx.room.l r4 = (androidx.room.l) r4
            kotlin.C4849c.b(r11)
            r11 = r10
            r10 = r4
            goto L87
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            kotlin.C4849c.b(r11)
            java.lang.String[] r8 = r8.tablesNames
            r8 = r8[r10]
            java.lang.String[] r10 = androidx.room.TriggerBasedInvalidationTracker.f14543m
            int r11 = r10.length
            r2 = 0
            r7 = r2
            r2 = r8
            r8 = r11
            r11 = r10
            r10 = r9
            r9 = r7
        L54:
            if (r9 >= r8) goto L89
            r4 = r11[r9]
            androidx.room.TriggerBasedInvalidationTracker$a r5 = androidx.room.TriggerBasedInvalidationTracker.INSTANCE
            java.lang.String r4 = androidx.room.TriggerBasedInvalidationTracker.Companion.a(r5, r2, r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "DROP TRIGGER IF EXISTS `"
            r5.append(r6)
            r5.append(r4)
            r4 = 96
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r0.f14598a = r10
            r0.f14599b = r2
            r0.f14600c = r11
            r0.f14601d = r9
            r0.f14602e = r8
            r0.f14605h = r3
            java.lang.Object r4 = androidx.room.D.b(r10, r4, r0)
            if (r4 != r1) goto L87
            return r1
        L87:
            int r9 = r9 + r3
            goto L54
        L89:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.w(androidx.room.l, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1) r0
            int r1 = r0.f14609d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f14609d = r1
            goto L18
        L13:
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f14607b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f14609d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r7 = r0.f14606a
            b1.a r7 = (b1.C1442a) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L2d
            goto L5b
        L2d:
            r8 = move-exception
            goto L63
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.C4849c.b(r8)
            androidx.room.RoomDatabase r8 = r7.database
            b1.a r8 = r8.getCloseBarrier()
            boolean r2 = r8.a()
            if (r2 == 0) goto L67
            androidx.room.RoomDatabase r2 = r7.database     // Catch: java.lang.Throwable -> L5f
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1 r4 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1     // Catch: java.lang.Throwable -> L5f
            r5 = 0
            r4.<init>(r7, r5)     // Catch: java.lang.Throwable -> L5f
            r0.f14606a = r8     // Catch: java.lang.Throwable -> L5f
            r0.f14609d = r3     // Catch: java.lang.Throwable -> L5f
            r7 = 0
            java.lang.Object r7 = r2.U(r7, r4, r0)     // Catch: java.lang.Throwable -> L5f
            if (r7 != r1) goto L5a
            return r1
        L5a:
            r7 = r8
        L5b:
            r7.d()
            goto L67
        L5f:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L63:
            r7.d()
            throw r8
        L67:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.x(e9.c):java.lang.Object");
    }

    public final Pair<String[], int[]> y(String[] names) {
        kotlin.jvm.internal.p.i(names, "names");
        String[] strArrT = t(names);
        int length = strArrT.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArrT[i10];
            Map<String, Integer> map = this.tableIdLookup;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            iArr[i10] = num.intValue();
        }
        return Y8.j.a(strArrT, iArr);
    }
}
