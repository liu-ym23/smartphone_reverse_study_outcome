package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.log.ALogger;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class LotteryTraceMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<String, String> f88034a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b$\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryTraceMonitor$EventName;", "", "lottery_init_im", "lottery_init_api", "lottery_init_api_success", "lottery_init_api_fail", "lottery_init_api_backend", "lottery_action_change", "lottery_state_change", "lottery_countdown_time", "lottery_start_draw", "lottery_old_draw_interaction", "lottery_old_draw_interaction_success", "lottery_draw_compensate_start", "lottery_draw_compensate_timeend", "lottery_draw_compensate_request", "lottery_draw_compensate_message", "lottery_update_curcandidatestate", "lottery_draw_compensate_request_success", "lottery_draw_compensate_request_fail", "lottery_anchor_draw_refresh", "lottery_draw_finish", "lottery_local_participated", "lottery_draw_finish_open_scheme", "lottery_draw_finish_1", "lottery_draw_finish_2", "lottery_is_terminalState", "lottery_lottery_state_null", "lottery_draw_open_schema", "lottery_draw_open_cancel_last", "lottery_old_draw_interaction_error", "lottery_draw_open_error_1", "lottery_draw_open_error_2", "lottery_draw_open_error_3", "lottery_draw_open_schema_final", "lottery_candidate_success_msg", "lottery_draw_result_msg", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventName extends Enum<EventName> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventName[] f88035a = null;
        public static final EventName lottery_action_change = null;
        public static final EventName lottery_anchor_draw_refresh = null;
        public static final EventName lottery_candidate_success_msg = null;
        public static final EventName lottery_countdown_time = null;
        public static final EventName lottery_draw_compensate_message = null;
        public static final EventName lottery_draw_compensate_request = null;
        public static final EventName lottery_draw_compensate_request_fail = null;
        public static final EventName lottery_draw_compensate_request_success = null;
        public static final EventName lottery_draw_compensate_start = null;
        public static final EventName lottery_draw_compensate_timeend = null;
        public static final EventName lottery_draw_finish = null;
        public static final EventName lottery_draw_finish_1 = null;
        public static final EventName lottery_draw_finish_2 = null;
        public static final EventName lottery_draw_finish_open_scheme = null;
        public static final EventName lottery_draw_open_cancel_last = null;
        public static final EventName lottery_draw_open_error_1 = null;
        public static final EventName lottery_draw_open_error_2 = null;
        public static final EventName lottery_draw_open_error_3 = null;
        public static final EventName lottery_draw_open_schema = null;
        public static final EventName lottery_draw_open_schema_final = null;
        public static final EventName lottery_draw_result_msg = null;
        public static final EventName lottery_init_api = null;
        public static final EventName lottery_init_api_backend = null;
        public static final EventName lottery_init_api_fail = null;
        public static final EventName lottery_init_api_success = null;
        public static final EventName lottery_init_im = null;
        public static final EventName lottery_is_terminalState = null;
        public static final EventName lottery_local_participated = null;
        public static final EventName lottery_lottery_state_null = null;
        public static final EventName lottery_old_draw_interaction = null;
        public static final EventName lottery_old_draw_interaction_error = null;
        public static final EventName lottery_old_draw_interaction_success = null;
        public static final EventName lottery_start_draw = null;
        public static final EventName lottery_state_change = null;
        public static final EventName lottery_update_curcandidatestate = null;

        static {
            EventName r100 = new EventName("lottery_init_im", 0);
            lottery_init_im = r100;
            EventName r101 = new EventName("lottery_init_api", 1);
            lottery_init_api = r101;
            EventName r102 = new EventName("lottery_init_api_success", 2);
            lottery_init_api_success = r102;
            EventName r103 = new EventName("lottery_init_api_fail", 3);
            lottery_init_api_fail = r103;
            EventName r104 = new EventName("lottery_init_api_backend", 4);
            lottery_init_api_backend = r104;
            EventName r105 = new EventName("lottery_action_change", 5);
            lottery_action_change = r105;
            EventName r106 = new EventName("lottery_state_change", 6);
            lottery_state_change = r106;
            EventName r107 = new EventName("lottery_countdown_time", 7);
            lottery_countdown_time = r107;
            EventName r108 = new EventName("lottery_start_draw", 8);
            lottery_start_draw = r108;
            EventName r109 = new EventName("lottery_old_draw_interaction", 9);
            lottery_old_draw_interaction = r109;
            EventName r110 = new EventName("lottery_old_draw_interaction_success", 10);
            lottery_old_draw_interaction_success = r110;
            EventName r111 = new EventName("lottery_draw_compensate_start", 11);
            lottery_draw_compensate_start = r111;
            EventName r112 = new EventName("lottery_draw_compensate_timeend", 12);
            lottery_draw_compensate_timeend = r112;
            EventName r113 = new EventName("lottery_draw_compensate_request", 13);
            lottery_draw_compensate_request = r113;
            EventName r114 = new EventName("lottery_draw_compensate_message", 14);
            lottery_draw_compensate_message = r114;
            EventName r115 = new EventName("lottery_update_curcandidatestate", 15);
            lottery_update_curcandidatestate = r115;
            EventName r116 = new EventName("lottery_draw_compensate_request_success", 16);
            lottery_draw_compensate_request_success = r116;
            EventName r117 = new EventName("lottery_draw_compensate_request_fail", 17);
            lottery_draw_compensate_request_fail = r117;
            EventName r118 = new EventName("lottery_anchor_draw_refresh", 18);
            lottery_anchor_draw_refresh = r118;
            EventName r119 = new EventName("lottery_draw_finish", 19);
            lottery_draw_finish = r119;
            EventName r120 = new EventName("lottery_local_participated", 20);
            lottery_local_participated = r120;
            EventName r121 = new EventName("lottery_draw_finish_open_scheme", 21);
            lottery_draw_finish_open_scheme = r121;
            EventName r122 = new EventName("lottery_draw_finish_1", 22);
            lottery_draw_finish_1 = r122;
            EventName r123 = new EventName("lottery_draw_finish_2", 23);
            lottery_draw_finish_2 = r123;
            EventName r124 = new EventName("lottery_is_terminalState", 24);
            lottery_is_terminalState = r124;
            EventName r125 = new EventName("lottery_lottery_state_null", 25);
            lottery_lottery_state_null = r125;
            EventName r126 = new EventName("lottery_draw_open_schema", 26);
            lottery_draw_open_schema = r126;
            EventName r127 = new EventName("lottery_draw_open_cancel_last", 27);
            lottery_draw_open_cancel_last = r127;
            EventName r128 = new EventName("lottery_old_draw_interaction_error", 28);
            lottery_old_draw_interaction_error = r128;
            EventName r129 = new EventName("lottery_draw_open_error_1", 29);
            lottery_draw_open_error_1 = r129;
            EventName r130 = new EventName("lottery_draw_open_error_2", 30);
            lottery_draw_open_error_2 = r130;
            EventName r131 = new EventName("lottery_draw_open_error_3", 31);
            lottery_draw_open_error_3 = r131;
            EventName r132 = new EventName("lottery_draw_open_schema_final", 32);
            lottery_draw_open_schema_final = r132;
            EventName r133 = new EventName("lottery_candidate_success_msg", 33);
            lottery_candidate_success_msg = r133;
            EventName r134 = new EventName("lottery_draw_result_msg", 34);
            lottery_draw_result_msg = r134;
            f88035a = new EventName[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134};
        }

        public static EventName valueOf(String r100) {
            return (EventName) r27.a.a(EventName.class, r100);
        }

        public static EventName[] values() {
            return (EventName[]) f88035a.clone();
        }

        public EventName(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f88034a = new LinkedHashMap();
    }

    public static void a(EventName r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        LinkedHashMap<String, String> r102 = f88034a;
        if (r102 == null) goto L8;
        String r103 = r100.name();
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        String r104 = r102.put(r103, r101);
    L8:
        r100.name();
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        LinkedHashMap<String, String> r102 = f88034a;
        if (r102 == null) goto L8;
        String r103 = r100 + System.currentTimeMillis();
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        String r104 = r102.put(r103, r101);
    L8:
        System.currentTimeMillis();
    }

    public static void c(JSONObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
    L7:
        e = move-exception;
        ALogger.e("LotteryTraceMonitor", e);
        return;
    L4:
        if (r100.has(r101) == true) goto L12;
        r100.put(r101, r102);     // Catch: Exception -> L7
        return;
    }
}
