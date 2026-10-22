package com.bytedance.android.live.room.report;

import am2.x;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class ReportTracer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f100240a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/report/ReportTracer$CallFunction;", "", "reportWithUserProfileEvent", "report", "reportWithReportAnchorEvent", "screenShotReport", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CallFunction extends Enum<CallFunction> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CallFunction[] f100241a = null;
        public static final CallFunction report = null;
        public static final CallFunction reportWithReportAnchorEvent = null;
        public static final CallFunction reportWithUserProfileEvent = null;
        public static final CallFunction screenShotReport = null;

        static {
            CallFunction r100 = new CallFunction("reportWithUserProfileEvent", 0);
            reportWithUserProfileEvent = r100;
            CallFunction r101 = new CallFunction("report", 1);
            report = r101;
            CallFunction r102 = new CallFunction("reportWithReportAnchorEvent", 2);
            reportWithReportAnchorEvent = r102;
            CallFunction r103 = new CallFunction("screenShotReport", 3);
            screenShotReport = r103;
            f100241a = new CallFunction[]{r100, r101, r102, r103};
        }

        public static CallFunction valueOf(String r100) {
            return (CallFunction) r27.a.a(CallFunction.class, r100);
        }

        public static CallFunction[] values() {
            return (CallFunction[]) f100241a.clone();
        }

        public CallFunction(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b!\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/room/report/ReportTracer$EventName;", "", "call_start", "call_end", "call_function", "params_check", "result", "failed_reason", "generate_report_params", "report_full_link", "direct_report_anchor", "get_report_object", "report_object", "report_DHXT_link", "report_DHXT_pk", "report_pk_liveroomid", "report_anchor_report_type", "report_anchor_request_page", "report_anchor_report_scene", "report_anchor_for_anchor", "report_anchor_for_audience", "generate_report_anchor_url_builder", "generate_report_anchor_dialog", "report_anchor_dialog_show", "report_anchor_url", PlayerResolution.SWITCH_REASON.SWITCH_TO_PORTRAIT, "on_report_configuration_changed", "generate_report_comment_url", "open_report_comment_page", "open_report_hotsoon_page", "set_room_mute", "open_report_user_page", "generate_screen_shot_report_url", "open_screen_shot_report_page", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventName extends Enum<EventName> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventName[] f100242a = null;
        public static final EventName call_end = null;
        public static final EventName call_function = null;
        public static final EventName call_start = null;
        public static final EventName direct_report_anchor = null;
        public static final EventName failed_reason = null;
        public static final EventName generate_report_anchor_dialog = null;
        public static final EventName generate_report_anchor_url_builder = null;
        public static final EventName generate_report_comment_url = null;
        public static final EventName generate_report_params = null;
        public static final EventName generate_screen_shot_report_url = null;
        public static final EventName get_report_object = null;
        public static final EventName on_report_configuration_changed = null;
        public static final EventName open_report_comment_page = null;
        public static final EventName open_report_hotsoon_page = null;
        public static final EventName open_report_user_page = null;
        public static final EventName open_screen_shot_report_page = null;
        public static final EventName params_check = null;
        public static final EventName report_DHXT_link = null;
        public static final EventName report_DHXT_pk = null;
        public static final EventName report_anchor_dialog_show = null;
        public static final EventName report_anchor_for_anchor = null;
        public static final EventName report_anchor_for_audience = null;
        public static final EventName report_anchor_report_scene = null;
        public static final EventName report_anchor_report_type = null;
        public static final EventName report_anchor_request_page = null;
        public static final EventName report_anchor_url = null;
        public static final EventName report_full_link = null;
        public static final EventName report_object = null;
        public static final EventName report_pk_liveroomid = null;
        public static final EventName result = null;
        public static final EventName set_room_mute = null;
        public static final EventName switch_to_portrait = null;

        static {
            EventName r100 = new EventName("call_start", 0);
            call_start = r100;
            EventName r101 = new EventName("call_end", 1);
            call_end = r101;
            EventName r102 = new EventName("call_function", 2);
            call_function = r102;
            EventName r103 = new EventName("params_check", 3);
            params_check = r103;
            EventName r104 = new EventName("result", 4);
            result = r104;
            EventName r105 = new EventName("failed_reason", 5);
            failed_reason = r105;
            EventName r106 = new EventName("generate_report_params", 6);
            generate_report_params = r106;
            EventName r107 = new EventName("report_full_link", 7);
            report_full_link = r107;
            EventName r108 = new EventName("direct_report_anchor", 8);
            direct_report_anchor = r108;
            EventName r109 = new EventName("get_report_object", 9);
            get_report_object = r109;
            EventName r110 = new EventName("report_object", 10);
            report_object = r110;
            EventName r111 = new EventName("report_DHXT_link", 11);
            report_DHXT_link = r111;
            EventName r112 = new EventName("report_DHXT_pk", 12);
            report_DHXT_pk = r112;
            EventName r113 = new EventName("report_pk_liveroomid", 13);
            report_pk_liveroomid = r113;
            EventName r114 = new EventName("report_anchor_report_type", 14);
            report_anchor_report_type = r114;
            EventName r115 = new EventName("report_anchor_request_page", 15);
            report_anchor_request_page = r115;
            EventName r116 = new EventName("report_anchor_report_scene", 16);
            report_anchor_report_scene = r116;
            EventName r117 = new EventName("report_anchor_for_anchor", 17);
            report_anchor_for_anchor = r117;
            EventName r118 = new EventName("report_anchor_for_audience", 18);
            report_anchor_for_audience = r118;
            EventName r119 = new EventName("generate_report_anchor_url_builder", 19);
            generate_report_anchor_url_builder = r119;
            EventName r120 = new EventName("generate_report_anchor_dialog", 20);
            generate_report_anchor_dialog = r120;
            EventName r121 = new EventName("report_anchor_dialog_show", 21);
            report_anchor_dialog_show = r121;
            EventName r122 = new EventName("report_anchor_url", 22);
            report_anchor_url = r122;
            EventName r123 = new EventName(PlayerResolution.SWITCH_REASON.SWITCH_TO_PORTRAIT, 23);
            switch_to_portrait = r123;
            EventName r124 = new EventName("on_report_configuration_changed", 24);
            on_report_configuration_changed = r124;
            EventName r125 = new EventName("generate_report_comment_url", 25);
            generate_report_comment_url = r125;
            EventName r126 = new EventName("open_report_comment_page", 26);
            open_report_comment_page = r126;
            EventName r127 = new EventName("open_report_hotsoon_page", 27);
            open_report_hotsoon_page = r127;
            EventName r128 = new EventName("set_room_mute", 28);
            set_room_mute = r128;
            EventName r129 = new EventName("open_report_user_page", 29);
            open_report_user_page = r129;
            EventName r130 = new EventName("generate_screen_shot_report_url", 30);
            generate_screen_shot_report_url = r130;
            EventName r131 = new EventName("open_screen_shot_report_page", 31);
            open_screen_shot_report_page = r131;
            f100242a = new EventName[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131};
        }

        public static EventName valueOf(String r100) {
            return (EventName) r27.a.a(EventName.class, r100);
        }

        public static EventName[] values() {
            return (EventName[]) f100242a.clone();
        }

        public EventName(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static void g() {
        d(EventName.result, "1");
        b(EventName.call_end);
        e();
    }

    public static void e() {
        u.l().sendLog("livesdk_experience_link_report", f100240a, new Object[0]);
        Map<String, String> r100 = f100240a;
        Room r101 = ((IRoomService) k.n(IRoomService.class)).getCurrentRoomFromRoomContext();
        int r102 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r103 = com.bytedance.android.live.core.monitor.trace.e.b.a("livesdk_experience_link_report", "live_report");
        r103.f65012c = "webcast_client_community";
        com.bytedance.android.livesdk.user.f r104 = ((IUserService) k.n(IUserService.class)).user();
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.n();
    L6:
        r103.f65016g = r106;
        if (r101 == null) goto L9;
        String r107 = r101.getOwnerUserIdString();
    L10:
        r103.f65015f = r107;
        if (r101 == null) goto L13;
        String r108 = r101.getIdStr();
    L14:
        r103.f65014e = r108;
        com.bytedance.android.livesdk.user.f r109 = ((IUserService) k.n(IUserService.class)).user();
        if (r109 == null) goto L17;
        r105 = r109.n();
    L17:
        r103.f65010a = r105;
        com.bytedance.android.live.core.monitor.trace.e r110 = r103.a();
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L20
        BaseMonitor.add(r111, "message", String.valueOf(r100));     // Catch: Exception -> L20
        com.bytedance.android.live.core.monitor.trace.c.b(r110, r111);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        ALogger.e("livesdk_experience_link_report", "IllegalArgumentException error: " + e.toString());
        return;
    L13:
        r108 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    static {
    }

    public static void b(EventName r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        d(r100, String.valueOf(System.currentTimeMillis()));
    }

    public static void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        d(EventName.result, "0");
        d(EventName.failed_reason, r100);
        b(EventName.call_end);
        e();
    }

    public static void c(EventName r100, CallFunction r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "value");
        d(r100, r101.name());
    }

    public static void d(EventName r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "value");
        Map<String, String> r102 = f100240a;
        if (r102 == null) goto L6;
        String r103 = r102.put(r100.name(), r101);
        return;
    }

    public static void h(ReportConstant$BusinessSource r100, IBaseUser r101, IRoom r102) {
        Intrinsics.checkNotNullParameter(r100, "businessSource");
        Map<String, String> r103 = f100240a;
        if (r103 == null) goto L5;
        ((LinkedHashMap) r103).clear();
    L5:
        String r104 = null;
        f100240a = null;
        LinkedHashMap r105 = new LinkedHashMap();
        f100240a = r105;
        String r106 = (String) r105.put("business_source", r100.getBusinessType());
        Map<String, String> r107 = f100240a;
        if (r107 == null) goto L16;
        IUserService r108 = (IUserService) k.f(IUserService.class);
        if (r108 == null) goto L14;
        com.bytedance.android.livesdk.user.f r109 = r108.user();
        if (r109 == null) goto L14;
        IUser r110 = r109.b();
        if (r110 == null) goto L14;
        String r111 = r110.getIdString();
    L15:
        String r112 = r107.put("current_user_id", String.valueOf(r111));
    L14:
        r111 = null;
    L16:
        Map<String, String> r113 = f100240a;
        if (r113 == null) goto L27;
        IUserService r114 = (IUserService) k.f(IUserService.class);
        if (r114 == null) goto L25;
        com.bytedance.android.livesdk.user.f r115 = r114.user();
        if (r115 == null) goto L25;
        IUser r116 = r115.b();
        if (r116 == null) goto L25;
        Intrinsics.checkNotNullParameter(r116, "$this$secUidExt");
        String r117 = r116.getCastSecUid();
    L26:
        String r118 = r113.put("sec_current_user_id", String.valueOf(r117));
    L25:
        r117 = null;
    L27:
        Map<String, String> r119 = f100240a;
        if (r119 == null) goto L33;
        if (r101 == null) goto L31;
        String r120 = r101.getIdString();
    L32:
        String r121 = r119.put("target_user_id", String.valueOf(r120));
        goto L33
    L31:
        r120 = null;
    L33:
        Map<String, String> r122 = f100240a;
        if (r122 == null) goto L39;
        if (r101 == null) goto L37;
        Intrinsics.checkNotNullParameter(r101, "$this$secUidExt");
        String r123 = r101.getCastSecUid();
    L38:
        String r124 = r122.put("sec_target_user_id", String.valueOf(r123));
        goto L39
    L37:
        r123 = null;
    L39:
        Map<String, String> r125 = f100240a;
        if (r125 == null) goto L45;
        if (r102 == null) goto L43;
        Long r126 = Long.valueOf(r102.getId());
    L44:
        String r127 = r125.put("room_id", String.valueOf(r126));
        goto L45
    L43:
        r126 = null;
    L45:
        Map<String, String> r128 = f100240a;
        if (r128 == null) goto L51;
        if (r102 == null) goto L49;
        String r129 = r102.getOwnerUserIdString();
    L50:
        String r130 = r128.put("anchor_id", String.valueOf(r129));
        goto L51
    L49:
        r129 = null;
    L51:
        Map<String, String> r131 = f100240a;
        if (r131 == null) goto L58;
        if (r102 == null) goto L57;
        IBaseUser r132 = r102.getOwner();
        if (r132 == null) goto L57;
        Intrinsics.checkNotNullParameter(r132, "$this$secUidExt");
        r104 = r132.getCastSecUid();
    L57:
        String r133 = r131.put("sec_anchor_id", String.valueOf(r104));
    L58:
        Map<String, String> r134 = f100240a;
        if (r134 == null) goto L65;
        o r135 = u.l().c(x.class);
        o r136 = u.l().c(Room.class);
        if (r135 == null) goto L63;
        r135.a(r134);
    L63:
        if (r136 == null) goto L65;
        r136.a(r134);
    L65:
        b(EventName.call_start);
    }

    public static void a(String r100, String r101, String r102, zg1.u r103) {
        Map<String, String> r104 = f100240a;
        if (r104 == null) goto L5;
        String r105 = r104.put("from_source", String.valueOf(r100));
    L5:
        Map<String, String> r106 = f100240a;
        if (r106 == null) goto L8;
        String r107 = r106.put("report_source", String.valueOf(r101));
    L8:
        Map<String, String> r108 = f100240a;
        if (r108 == null) goto L11;
        String r109 = r108.put("report_type_for_log", String.valueOf(r102));
    L11:
        if (r103 == null) goto L25;
        Map<String, String> r110 = f100240a;
        if (r110 == null) goto L15;
        String r111 = r110.put("comment_msgId", String.valueOf(r103.a()));
    L15:
        Map<String, String> r112 = f100240a;
        if (r112 == null) goto L18;
        String r113 = r112.put(com.bytedance.android.ec.core.event.a.KEY_COMMENT_TYPE, String.valueOf(r103.getType()));
    L18:
        Map<String, String> r114 = f100240a;
        if (r114 == null) goto L26;
        String r115 = r103.b();
        if (r115 != null) goto L23;
        r115 = "";
    L23:
        String r116 = r114.put("reported_comment", r115);
        return;
    L26:
        return;
    }
}
