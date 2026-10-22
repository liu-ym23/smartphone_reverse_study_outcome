package com.bytedance.android.live.profit.taskcenter.panel.trace;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.livesdk.revenue.service.room.b;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.kmp.util.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l01.d;
import org.json.JSONObject;
import r27.a;
import vh6.c;

/* JADX INFO: loaded from: classes47.dex */
public final class LiveTaskPanelTraceMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f89052a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/profit/taskcenter/panel/trace/LiveTaskPanelTraceMonitor$EventName;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "TTLIVE_TASK_PANEL_MANAGE", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventName extends Enum<EventName> {
        public static final EventName TTLIVE_TASK_PANEL_MANAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventName[] f89053a = null;
        private final String eventName;

        static {
            EventName r100 = new EventName();
            TTLIVE_TASK_PANEL_MANAGE = r100;
            f89053a = new EventName[]{r100};
        }

        public static EventName valueOf(String r100) {
            return (EventName) a.a(EventName.class, r100);
        }

        public static EventName[] values() {
            return (EventName[]) f89053a.clone();
        }

        public EventName() {
            super("TTLIVE_TASK_PANEL_MANAGE", 0);
            this.eventName = "ttlive_task_panel_manage";
        }

        public final String getEventName() {
            return this.eventName;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/taskcenter/panel/trace/LiveTaskPanelTraceMonitor$Step;", "", "", "step", "Ljava/lang/String;", "getStep", "()Ljava/lang/String;", "HANDLE_POPUP_SCHEMA", "CHECK_FREQUENCY_DAILY", "CHECK_FREQUENCY_LIFETIME", "CREATE_PANEL_INFO", "OBSERVE_PANEL_STATE", "PANEL_SHOW_HYBRID_SUCCESS", "PANEL_SHOW_HYBRID_FAIL", "TASK_PANEL_MANAGER_RESET", "HYBRID_DISMISS", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Step extends Enum<Step> {
        public static final Step CHECK_FREQUENCY_DAILY = null;
        public static final Step CHECK_FREQUENCY_LIFETIME = null;
        public static final Step CREATE_PANEL_INFO = null;
        public static final Step HANDLE_POPUP_SCHEMA = null;
        public static final Step HYBRID_DISMISS = null;
        public static final Step OBSERVE_PANEL_STATE = null;
        public static final Step PANEL_SHOW_HYBRID_FAIL = null;
        public static final Step PANEL_SHOW_HYBRID_SUCCESS = null;
        public static final Step TASK_PANEL_MANAGER_RESET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Step[] f89054a = null;
        private final String step;

        public static Step valueOf(String r100) {
            return (Step) a.a(Step.class, r100);
        }

        public static Step[] values() {
            return (Step[]) f89054a.clone();
        }

        static {
            Step r100 = new Step("HANDLE_POPUP_SCHEMA", 0, "handle_popup_schema");
            HANDLE_POPUP_SCHEMA = r100;
            Step r101 = new Step("CHECK_FREQUENCY_DAILY", 1, "check_frequency_daily");
            CHECK_FREQUENCY_DAILY = r101;
            Step r102 = new Step("CHECK_FREQUENCY_LIFETIME", 2, "check_frequency_lifetime");
            CHECK_FREQUENCY_LIFETIME = r102;
            Step r103 = new Step("CREATE_PANEL_INFO", 3, "create_panel_info");
            CREATE_PANEL_INFO = r103;
            Step r104 = new Step("OBSERVE_PANEL_STATE", 4, "observe_panel_state");
            OBSERVE_PANEL_STATE = r104;
            Step r105 = new Step("PANEL_SHOW_HYBRID_SUCCESS", 5, "panel_show_hybrid_success");
            PANEL_SHOW_HYBRID_SUCCESS = r105;
            Step r106 = new Step("PANEL_SHOW_HYBRID_FAIL", 6, "panel_show_hybrid_fail");
            PANEL_SHOW_HYBRID_FAIL = r106;
            Step r107 = new Step("TASK_PANEL_MANAGER_RESET", 7, "task_panel_manager_reset");
            TASK_PANEL_MANAGER_RESET = r107;
            Step r108 = new Step("HYBRID_DISMISS", 8, "hybrid_dismiss");
            HYBRID_DISMISS = r108;
            f89054a = new Step[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        }

        public final String getStep() {
            return this.step;
        }

        public Step(String r100, int r101, String r102) {
            super(r100, r101);
            this.step = r102;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public static void a(String r110, String r111, Map r112) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "step");
        Intrinsics.checkNotNullParameter(r112, "extra");
        LinkedHashMap r100 = new LinkedHashMap();
        b r101 = (b) c.b(b.class);
        d r102 = (d) f.a(d.class);
        LinkedHashMap r103 = new LinkedHashMap();
        IRoom r104 = r101.getRoom();
        String r105 = "0";
        if (r104 == null) goto L6;
        String r106 = r104.getOwnerUserIdString();
        if (r106 == null) goto L6;
    L7:
        r103.put("anchor_id", r106);
        r103.put("user_id", r102.getCurrentUserId());
        IRoom r107 = r101.getRoom();
        if (r107 == null) goto L13;
        String r108 = String.valueOf(r107.getId());
        if (r108 == null) goto L13;
        r105 = r108;
    L13:
        r103.put("room_id", r105);
        r103.putAll(r100);
        LinkedHashMap r109 = new LinkedHashMap();
        LinkedHashMap r113 = new LinkedHashMap();
        r113.put("consume_time", Long.valueOf(e.b()));
        String r114 = (String) r109.get(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID);
        if (r114 == null) goto L16;
        r113.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r114);
    L16:
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "step");
        Intrinsics.checkNotNullParameter(r103, "traceMetaData");
        Intrinsics.checkNotNullParameter(r113, "traceIndexData");
        j01.e r115 = new j01.e(r110, "task_center");
        JSONObject r116 = new JSONObject();
        JSONObject r117 = new JSONObject();
        JSONObject r118 = new JSONObject();
        Intrinsics.checkNotNullParameter(r115, "metaBuilder");
        Intrinsics.checkNotNullParameter(r117, "category");
        Intrinsics.checkNotNullParameter(r118, "metric");
        Intrinsics.checkNotNullParameter(r116, "extra");
        String r119 = (String) r103.get("anchor_id");
        if (r119 == null) goto L19;
        r115.a(r119);
    L19:
        String r120 = (String) r103.get("user_id");
        if (r120 == null) goto L22;
        r115.i(r120);
    L22:
        String r121 = (String) r103.get("room_id");
        if (r121 == null) goto L25;
        r115.e(r121);
    L25:
        String r122 = (String) r103.get(BindCardPayConfirmConstants.Key.TRACE_ID);
        if (r122 == null) goto L28;
        r115.h(r122);
    L28:
        String r123 = (String) r103.get("log_id");
        if (r123 == null) goto L31;
        r115.c(r123);
    L31:
        r115.b(r113);
        r115.d(ProductId.TASK_CENTER);
        r115.g(r111);
        Intrinsics.checkNotNullParameter(r116, "json");
        Iterator r124 = r112.entrySet().iterator();
    L33:
        if (r124.hasNext() == false) goto L45;
        Map.Entry r125 = (Map.Entry) r124.next();
        String r126 = (String) r125.getKey();
        ?? r127 = r125.getValue();
        if ((r127 instanceof Map) == true) goto L37;
        ?? r128 = 0;
    L38:
        Map r129 = (Map) r128;
        if (r129 == null) goto L44;
        r127 = new JSONObject();
        Iterator r130 = r129.entrySet().iterator();
    L42:
        if (r130.hasNext() == false) goto L44;
        Map.Entry r131 = (Map.Entry) r130.next();
        Object r132 = r131.getKey();
        Object r133 = r131.getValue();
        j01.d.b(r127, String.valueOf(r132), r133);
    L44:
        Intrinsics.checkNotNullParameter(r126, "key");
        Intrinsics.checkNotNullParameter(r127, "value");
        j01.d.b(r116, r126, r127);
        goto L33
    L37:
        r128 = r127;
        goto L38
    L45:
        ((j01.b) f.a(j01.b.class)).R4(r115.f496788a, r117, r118, r116);
        return;
    L6:
        r106 = "0";
        goto L7
    }
}
