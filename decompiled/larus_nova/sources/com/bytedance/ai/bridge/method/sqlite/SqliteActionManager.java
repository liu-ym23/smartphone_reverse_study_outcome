package com.bytedance.ai.bridge.method.sqlite;

import android.content.Context;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
public final class SqliteActionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SqliteActionManager f35891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, DBOperation> f35892b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/sqlite/SqliteActionManager$ActionType;", "", WikiFolderPushPlugin.OPT, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOperation", "()Ljava/lang/String;", "OPEN", "CLOSE", "DELETE", "EXEC", "RUN", ConfirmNextAction.ACTION_TYPE_QUERY, "TRANSACTION_BEGIN", "TRANSACTION_END", "TRANSACTION_ROLLBACK", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType CLOSE = null;
        public static final ActionType DELETE = null;
        public static final ActionType EXEC = null;
        public static final ActionType OPEN = null;
        public static final ActionType QUERY = null;
        public static final ActionType RUN = null;
        public static final ActionType TRANSACTION_BEGIN = null;
        public static final ActionType TRANSACTION_END = null;
        public static final ActionType TRANSACTION_ROLLBACK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionType[] f35893a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f35894b = null;
        private final String operation;

        public static EnumEntries<ActionType> getEntries() {
            return f35894b;
        }

        static {
            ActionType r100 = new ActionType("OPEN", 0, "openDb");
            OPEN = r100;
            ActionType r101 = new ActionType("CLOSE", 1, "closeDb");
            CLOSE = r101;
            ActionType r102 = new ActionType("DELETE", 2, "deleteDb");
            DELETE = r102;
            ActionType r103 = new ActionType("EXEC", 3, "execSQL");
            EXEC = r103;
            ActionType r104 = new ActionType("RUN", 4, "runSQL");
            RUN = r104;
            ActionType r105 = new ActionType(ConfirmNextAction.ACTION_TYPE_QUERY, 5, "query");
            QUERY = r105;
            ActionType r110 = new ActionType("TRANSACTION_BEGIN", 6, "beginTransaction");
            TRANSACTION_BEGIN = r110;
            ActionType r111 = new ActionType("TRANSACTION_END", 7, "endTransaction");
            TRANSACTION_END = r111;
            ActionType r112 = new ActionType("TRANSACTION_ROLLBACK", 8, "rollbackInTransaction");
            TRANSACTION_ROLLBACK = r112;
            ActionType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
            f35893a = r113;
            f35894b = EnumEntriesKt.enumEntries(r113);
        }

        public static ActionType[] values() {
            return (ActionType[]) f35893a.clone();
        }

        public final String getOperation() {
            return this.operation;
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) r27.a.a(ActionType.class, r100);
        }

        public ActionType(String r100, int r101, String r102) {
            super(r100, r101);
            this.operation = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35895a = null;

        static {
            int[] r100 = new int[ActionType.values().length];
            r100[ActionType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r100[ActionType.CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r100[ActionType.DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r100[ActionType.EXEC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[ActionType.RUN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r100[ActionType.QUERY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[ActionType.TRANSACTION_BEGIN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[ActionType.TRANSACTION_END.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[ActionType.TRANSACTION_ROLLBACK.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f35895a = r100;
        }
    }

    public SqliteActionManager() {
    }

    static {
        f35891a = new SqliteActionManager();
        f35892b = new ConcurrentHashMap();
    }

    public static void a(Context r110, String r111, AbsExecuteSqliteActionMethodIDL.a r112, final f3.h r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "parentFolder");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r113, "callback");
        ActionType[] r100 = ActionType.values();     // Catch: IllegalArgumentException -> L86
        int r114 = r100.length;     // Catch: IllegalArgumentException -> L86
        int r115 = 0;
    L4:
        if (r115 >= r114) goto L85;
        ActionType r116 = r100[r115];     // Catch: IllegalArgumentException -> L86
        if (Intrinsics.areEqual(r116.getOperation(), r112.getAction()) == true) goto L7;
        r115 = r115 + 1;
        goto L4
    L7:
        String r101 = r111 + '-' + r112.getDbName();
        switch(a.f35895a[r116.ordinal()]) {
            case 1: goto L78;
            case 2: goto L74;
            case 3: goto L70;
            case 4: goto L57;
            case 5: goto L40;
            case 6: goto L23;
            case 7: goto L19;
            case 8: goto L15;
            case 9: goto L11;
            default: goto L10;
        };
    L11:
        final DBOperation r102 = f35892b.get(r101);
        if (r102 != null) goto L14;
        String r103 = "Database(" + r101 + ") is not open yet.";
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r103);
        f3.h.a.a(r113, r103, null, null, 14);
        return;
    L14:
        Intrinsics.checkNotNullParameter(r113, "callback");
        r102.e(r113, new f(r102, r113));
        return;
    L15:
        final DBOperation r104 = f35892b.get(r101);
        if (r104 != null) goto L18;
        String r105 = "Database(" + r101 + ") is not open yet.";
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r105);
        f3.h.a.a(r113, r105, null, null, 14);
        return;
    L18:
        Intrinsics.checkNotNullParameter(r113, "callback");
        r104.e(r113, new c(r104, r113));
        return;
    L19:
        final DBOperation r106 = f35892b.get(r101);
        if (r106 != null) goto L22;
        String r107 = "Database(" + r101 + ") is not open yet.";
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r107);
        f3.h.a.a(r113, r107, null, null, 14);
        return;
    L22:
        Intrinsics.checkNotNullParameter(r113, "callback");
        r106.e(r113, new b(r106, r113));
        return;
    L23:
        final DBOperation r108 = f35892b.get(r101);
        if (r108 != null) goto L26;
        String r109 = "Database(" + r101 + ") is not open yet.";
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r109);
        f3.h.a.a(r113, r109, null, null, 14);
        return;
    L26:
        Map<String, Object> r117 = r112.getActionParams();
        if (r117 == null) goto L39;
        Object r118 = r117.get("sql");
        if ((r118 instanceof String) == false) goto L31;
        final String r119 = (String) r118;
    L32:
        if (r119 == null) goto L38;
        Object r120 = r117.get("args");
        if ((r120 instanceof ArrayList) == false) goto L36;
        final ArrayList r121 = (ArrayList) r120;
    L37:
        Intrinsics.checkNotNullParameter(r119, "sql");
        Intrinsics.checkNotNullParameter(r113, "callback");
        r108.e(r113, new e(r108, r119, r113, r121));
        return;
    L36:
        r121 = null;
        goto L37
    L38:
        String r122 = "invalid sql: " + r101;
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r122);
        f3.h.a.a(r113, r122, null, null, 14);
        return;
    L31:
        r119 = null;
        goto L32
    L39:
        String r123 = "action params is null: " + r101;
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r123);
        f3.h.a.a(r113, r123, null, null, 14);
        return;
    L40:
        final DBOperation r124 = f35892b.get(r101);
        if (r124 != null) goto L43;
        String r125 = "Database(" + r101 + ") is not open yet.";
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r125);
        f3.h.a.a(r113, r125, null, null, 14);
        return;
    L43:
        Map<String, Object> r126 = r112.getActionParams();
        if (r126 == null) goto L56;
        Object r127 = r126.get("sql");
        if ((r127 instanceof String) == false) goto L48;
        final String r128 = (String) r127;
    L49:
        if (r128 == null) goto L55;
        Object r129 = r126.get("args");
        if ((r129 instanceof ArrayList) == false) goto L53;
        final ArrayList r130 = (ArrayList) r129;
    L54:
        Intrinsics.checkNotNullParameter(r128, "sql");
        Intrinsics.checkNotNullParameter(r113, "callback");
        r124.e(r113, new g(r124, r128, r113, r130));
        return;
    L53:
        r130 = null;
        goto L54
    L55:
        String r131 = "invalid sql: " + r101;
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r131);
        f3.h.a.a(r113, r131, null, null, 14);
        return;
    L48:
        r128 = null;
        goto L49
    L56:
        String r132 = "action params is null: " + r101;
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r132);
        f3.h.a.a(r113, r132, null, null, 14);
        return;
    L57:
        final DBOperation r133 = f35892b.get(r101);
        if (r133 != null) goto L60;
        String r134 = "Database(" + r101 + ") is not open yet.";
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r134);
        f3.h.a.a(r113, r134, null, null, 14);
        return;
    L60:
        Map<String, Object> r135 = r112.getActionParams();
        if (r135 == null) goto L69;
        Object r136 = r135.get("sql");
        if ((r136 instanceof String) == false) goto L65;
        final String r137 = (String) r136;
    L66:
        if (r137 == null) goto L68;
        Intrinsics.checkNotNullParameter(r137, "rawSql");
        Intrinsics.checkNotNullParameter(r113, "callback");
        r133.e(r113, new com.bytedance.ai.bridge.method.sqlite.a(r137, r113, r133));
        return;
    L68:
        String r138 = "invalid sql: " + r101;
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r138);
        f3.h.a.a(r113, r138, null, null, 14);
        return;
    L65:
        r137 = null;
        goto L66
    L69:
        String r139 = "action params is null: " + r101;
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r139);
        f3.h.a.a(r113, r139, null, null, 14);
        return;
    L70:
        DBOperation r140 = new DBOperation(r110, r112.getDbName());
        DBOperation r141 = f35892b.putIfAbsent(r101, r140);
        if (r141 == null) goto L73;
        j r142 = new j(r113, r101);
        Intrinsics.checkNotNullParameter(r111, "parentFolder");
        Intrinsics.checkNotNullParameter(r142, "callback");
        BuildersKt.launch$default((CoroutineScope) r141.f35887e.getValue(), null, null, new DBOperation$deleteDatabase$1(r141, r111, r142, null), 3, null);
        return;
    L73:
        k r143 = new k(r113, r101);
        Intrinsics.checkNotNullParameter(r111, "parentFolder");
        Intrinsics.checkNotNullParameter(r143, "callback");
        BuildersKt.launch$default((CoroutineScope) r140.f35887e.getValue(), null, null, new DBOperation$deleteDatabase$1(r140, r111, r143, null), 3, null);
        return;
    L74:
        DBOperation r144 = f35892b.get(r101);
        if (r144 != null) goto L77;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.b.class, "<this>");
        r113.b((ResultModel) k3.c.a(AbsExecuteSqliteActionMethodIDL.b.class), "");
        return;
    L77:
        i r145 = new i(r113, r101);
        Intrinsics.checkNotNullParameter(r145, "callback");
        BuildersKt.launch$default((CoroutineScope) r144.f35887e.getValue(), null, null, new DBOperation$closeDatabase$1(r144, r145, null), 3, null);
        return;
    L78:
        DBOperation r146 = new DBOperation(r110, r112.getDbName());
        if (f35892b.putIfAbsent(r101, r146) == null) goto L81;
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.b.class, "<this>");
        r113.b((ResultModel) k3.c.a(AbsExecuteSqliteActionMethodIDL.b.class), "");
        return;
    L81:
        Intrinsics.checkNotNullParameter(r111, "parentFolder");
        Intrinsics.checkNotNullParameter(r113, "callback");
        BuildersKt.launch$default((CoroutineScope) r146.f35887e.getValue(), null, null, new DBOperation$openDatabase$1(r146, r113, r111, null), 3, null);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    L85:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: IllegalArgumentException -> L86
    L86:
        String r147 = "invalid action: " + r112.getAction();
        com.bytedance.ai.utils.g.f37637a.e("ExecuteSqliteActionMethod", r147);
        f3.h.a.a(r113, r147, null, null, 14);
    }
}
