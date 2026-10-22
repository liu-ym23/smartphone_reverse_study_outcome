package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventType;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class n extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static tc0.b f71524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f71525b = null;

    static {
        f71525b = new n();
    }

    public static boolean E() {
        return ((Boolean) vm2.e.f556065v.getValue(null, vm2.e.f556037a[20])).booleanValue();
    }

    public static boolean F() {
        ((Boolean) vm2.e.f556066w.getValue(null, vm2.e.f556037a[21])).booleanValue();
        return true;
    }

    @JvmStatic
    public static final MultiLinkEventModule p() {
        return q(Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
    }

    public static void I() {
        MultiLinkEventModule r100 = p();
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        JSONObject r101 = new JSONObject();
        f71525b.l(r101);
        BaseMonitor.add(r101, "link_mode", hd0.c.f().f484576g);
        B(r100, "start_rtc", r101);
    }

    public n() {
    }

    public static void o(long r100) {
        MultiLinkEventModule r101 = p();
        Intrinsics.checkNotNullParameter(r101, "eventModule");
        JSONObject r102 = new JSONObject();
        f71525b.l(r102);
        BaseMonitor.add(r102, "msg_id", r100);
        A(r101, "admin_audience_join", r102);
    }

    @JvmStatic
    public static final MultiLinkEventModule q(Integer r100) {
        com.bytedance.live.datacontext.m<IRoom> r101 = m.i().getRoom();
        if (r101 == null) goto L7;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L7;
        boolean r103 = r102.isLiveTypeAudio();
    L8:
        if (r100 != null) goto L11;
    L13:
        if (r100 != null) goto L16;
    L18:
        if (r100 != null) goto L21;
    L23:
        if (r100 != null) goto L26;
    L28:
        if (r100 == null) goto L37;
        if (r100.intValue() != 16) goto L37;
        if (r103 != true) goto L42;
        return MultiLinkEventModule.MULTI_AUDIO;
    L42:
        return MultiLinkEventModule.BIG_PARTY;
    L37:
        return MultiLinkEventModule.common;
    L26:
        if (r100.intValue() != 9) goto L28;
        return MultiLinkEventModule.KTV;
    L21:
        if (r100.intValue() != 12) goto L23;
    L39:
        return MultiLinkEventModule.BIG_PARTY;
    L16:
        if (r100.intValue() != 8) goto L18;
    L11:
        if (r100.intValue() != 5) goto L13;
        return MultiLinkEventModule.MULTI_AUDIO;
    L7:
        r103 = false;
        goto L8
    }

    public static void r(long r100) {
        MultiLinkEventModule r101 = p();
        Intrinsics.checkNotNullParameter(r101, "eventModule");
        JSONObject r102 = new JSONObject();
        f71525b.l(r102);
        y(r101, "prepare_apply", r100, r102);
    }

    public static boolean t(String r100) {
        return ((List) vm2.e.f556064u.getValue(null, vm2.e.f556037a[19])).contains(r100);
    }

    public final void l(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r100, "extra");
        BaseMonitor.add(r100, "room_id", rd0.b.b());
        BaseMonitor.add(r100, "anchor_id", rd0.b.a());
        com.bytedance.live.datacontext.m<IRoom> r101 = m.i().getRoom();
        if (r101 == null) goto L9;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L9;
        LiveMode r103 = r102.getStreamType();
        if (r103 == null) goto L9;
    L10:
        BaseMonitor.add(r100, "room_scene", r103.ordinal());
        int r104 = 1;
        if (nd0.e.b() != true) goto L13;
        r104 = 2;
    L13:
        BaseMonitor.add(r100, "role_type", r104);
        Intrinsics.checkNotNullParameter(r100, "extra");
        tc0.b r105 = f71524a;
        if (r105 == null) goto L27;
        BaseMonitor.add(r100, "channel_id", String.valueOf(r105.getChannelId()));
        BaseMonitor.add(r100, "rtc_owner_user_id", r105.u());
        BaseMonitor.add(r100, "rtc_current_user_id", nd0.e.a());
        if (r105.zi() == false) goto L19;
        long r106 = 1;
    L20:
        BaseMonitor.add(r100, "is_client_mixstream", r106);
        BaseMonitor.add(r100, "rtc_extra_info", r105.getRtcExtInfo());
        v1 r107 = r105.getMultiRtcInfo();
        if (r107 == null) goto L24;
        String r108 = r107.toString();
        if (r108 == null) goto L24;
    L25:
        BaseMonitor.add(r100, "rtc_multi_extra_info", r108);
        return;
    L24:
        r108 = "";
        goto L25
    L19:
        r106 = 0;
        goto L20
    L27:
        return;
    L9:
        r103 = LiveMode.UNDEFINED;
        goto L10
    }

    public static void G(long r100, String r101) {
        MultiLinkEventModule r102 = p();
        Intrinsics.checkNotNullParameter(r102, "eventModule");
        JSONObject r103 = new JSONObject();
        f71525b.l(r103);
        int r104 = (int) r100;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        C(r102, "rtc_error", r104, r101, r103);
    }

    public static void H(String r100, long r101) {
        MultiLinkEventModule r102 = p();
        Intrinsics.checkNotNullParameter(r100, "linkmicId");
        Intrinsics.checkNotNullParameter(r102, "eventModule");
        JSONObject r103 = new JSONObject();
        f71525b.l(r103);
        BaseMonitor.add(r103, "guest_linkmic_id", r100);
        if (r101 <= 0) goto L5;
        i97.a r104 = i97.a.f488802a;
        BaseMonitor.add(r103, "duration", System.currentTimeMillis() - r101);
    L5:
        D(r102, "first_remote_audio_of_uid", r103);
    }

    public static void J(long r100, String r101) {
        MultiLinkEventModule r102 = p();
        Intrinsics.checkNotNullParameter(r102, "eventModule");
        JSONObject r103 = new JSONObject();
        f71525b.l(r103);
        int r104 = (int) r100;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        C(r102, "rtc_connect_failure", r104, r101, r103);
    }

    public static void m(String r100, long r101) {
        MultiLinkEventModule r102 = p();
        Intrinsics.checkNotNullParameter(r100, "toUserIdString");
        Intrinsics.checkNotNullParameter(r102, "eventModule");
        JSONObject r103 = new JSONObject();
        f71525b.l(r103);
        BaseMonitor.add(r103, com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        y(r102, "prepare_apply_permit", r101, r103);
    }

    public static void s(Throwable r100, long r101) {
        MultiLinkEventModule r102 = p();
        Intrinsics.checkNotNullParameter(r102, "eventModule");
        JSONObject r103 = new JSONObject();
        f71525b.l(r103);
        x(r102, "prepare_apply", r100, r101, r103);
    }

    public static void A(MultiLinkEventModule r100, String r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r110, "businessApiName");
        Intrinsics.checkNotNullParameter(r111, "extra");
        if (t(r110) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r111, "business_api_name", r110);
        F();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r102, "metric");
        Intrinsics.checkNotNullParameter(r103, "map");
        Intrinsics.checkNotNullParameter(r111, "jsonObject");
        Map<String, String> r112 = JsonUtil.jsonObjectToMap(r111);
        Intrinsics.checkNotNullParameter(r112, "value");
        Iterator<Map.Entry<String, String>> r113 = r112.entrySet().iterator();
    L7:
        if (r113.hasNext() == false) goto L9;
        Map.Entry<String, String> r114 = r113.next();
        r103.put(r114.getKey(), r114.getValue());
        goto L7
    L9:
        String r104 = r100.getName();
        Intrinsics.checkNotNullParameter(r104, "eventModuleString");
        String r105 = MultiLinkEventType.SDK_CALLBACK.getName();
        Intrinsics.checkNotNullParameter(r105, "eventTypeString");
        cy0.e.f465759a.getClass();
        cy0.j r115 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r106 = com.bytedance.android.scope.m.b(r115).b(n97.a.class);
        Intrinsics.checkNotNull(r106);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r106)).g("ttlive_audience_interactive_bussiness", r104, r105, r101, r102, r103);
    }

    public static void B(MultiLinkEventModule r100, String r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r110, "sdkApiName");
        Intrinsics.checkNotNullParameter(r111, "extra");
        if (t(r110) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r111, "sdk_api_name", r110);
        F();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r102, "metric");
        Intrinsics.checkNotNullParameter(r103, "map");
        Intrinsics.checkNotNullParameter(r111, "jsonObject");
        Map<String, String> r112 = JsonUtil.jsonObjectToMap(r111);
        Intrinsics.checkNotNullParameter(r112, "value");
        Iterator<Map.Entry<String, String>> r113 = r112.entrySet().iterator();
    L7:
        if (r113.hasNext() == false) goto L9;
        Map.Entry<String, String> r114 = r113.next();
        r103.put(r114.getKey(), r114.getValue());
        goto L7
    L9:
        String r104 = r100.getName();
        Intrinsics.checkNotNullParameter(r104, "eventModuleString");
        String r105 = MultiLinkEventType.SDK_INTERFACE_CALL.getName();
        Intrinsics.checkNotNullParameter(r105, "eventTypeString");
        cy0.e.f465759a.getClass();
        cy0.j r115 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r106 = com.bytedance.android.scope.m.b(r115).b(n97.a.class);
        Intrinsics.checkNotNull(r106);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r106)).g("ttlive_interact_sdk_api_call", r104, r105, r101, r102, r103);
    }

    public static void D(MultiLinkEventModule r100, String r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r110, "sdkCallbackName");
        Intrinsics.checkNotNullParameter(r111, "extra");
        if (t(r110) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r111, "sdk_callback_name", r110);
        F();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r102, "metric");
        Intrinsics.checkNotNullParameter(r103, "map");
        Intrinsics.checkNotNullParameter(r111, "jsonObject");
        Map<String, String> r112 = JsonUtil.jsonObjectToMap(r111);
        Intrinsics.checkNotNullParameter(r112, "value");
        Iterator<Map.Entry<String, String>> r113 = r112.entrySet().iterator();
    L7:
        if (r113.hasNext() == false) goto L9;
        Map.Entry<String, String> r114 = r113.next();
        r103.put(r114.getKey(), r114.getValue());
        goto L7
    L9:
        String r104 = r100.getName();
        Intrinsics.checkNotNullParameter(r104, "eventModuleString");
        String r105 = MultiLinkEventType.SDK_CALLBACK.getName();
        Intrinsics.checkNotNullParameter(r105, "eventTypeString");
        cy0.e.f465759a.getClass();
        cy0.j r115 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r106 = com.bytedance.android.scope.m.b(r115).b(n97.a.class);
        Intrinsics.checkNotNull(r106);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r106)).g("ttlive_interact_sdk_callback", r104, r105, r101, r102, r103);
    }

    public static void n(String r100, Throwable r101, long r102) {
        MultiLinkEventModule r103 = p();
        Intrinsics.checkNotNullParameter(r100, "toUserIdString");
        Intrinsics.checkNotNullParameter(r103, "eventModule");
        JSONObject r104 = new JSONObject();
        f71525b.l(r104);
        BaseMonitor.add(r104, com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100);
        x(r103, "prepare_apply_permit", r101, r102, r104);
    }

    public static void u(int r100, long r101, String r102) {
        MultiLinkEventModule r103 = p();
        Intrinsics.checkNotNullParameter(r103, "eventModule");
        JSONObject r104 = new JSONObject();
        BaseMonitor.add(r104, "duration", r101);
        if (r102 != null) goto L5;
        String r105 = "";
    L6:
        BaseMonitor.add(r104, "join_channel_type", r105);
        int r106 = r100 + 10;
        if (vm2.g.a() == false) goto L9;
        r106 = r106 + 100;
    L9:
        if (r102 == null) goto L20;
        int r107 = 1;
        if (r102.length() <= 0) goto L13;
        boolean r108 = true;
    L14:
        if (r108 != true) goto L20;
        if (Intrinsics.areEqual(r102, e1.REPLY_ACTION_APPLY) == true) goto L19;
        r107 = 2;
    L19:
        r106 = r106 + (r107 * 1000);
        goto L20
    L13:
        r108 = false;
    L20:
        f71525b.getClass();
        z(r103, "interaction_mode_anchor_connection_success", r106, r104);
        return;
    L5:
        r105 = r102;
        goto L6
    }

    public static void v(int r100, long r101, String r102) {
        MultiLinkEventModule r103 = p();
        Intrinsics.checkNotNullParameter(r103, "eventModule");
        JSONObject r104 = new JSONObject();
        BaseMonitor.add(r104, "duration", r101);
        if (r102 != null) goto L5;
        String r105 = "";
    L6:
        BaseMonitor.add(r104, "join_channel_type", r105);
        if (r102 == null) goto L18;
        int r106 = 1;
        if (r102.length() <= 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 != true) goto L18;
        if (Intrinsics.areEqual(r102, e1.REPLY_ACTION_APPLY) == true) goto L17;
        r106 = 2;
    L17:
        r100 = r100 + (r106 * 1000);
        goto L18
    L11:
        r107 = false;
    L18:
        f71525b.getClass();
        z(r103, "interaction_mode_audience_connection_success", r100, r104);
        return;
    L5:
        r105 = r102;
        goto L6
    }

    public static void K(String r100, int r101, Throwable r102, long r110) {
        MultiLinkEventModule r103 = q(Integer.valueOf(r101));
        Intrinsics.checkNotNullParameter(r100, "supportedScene");
        Intrinsics.checkNotNullParameter(r103, "eventModule");
        JSONObject r104 = new JSONObject();
        f71525b.l(r104);
        BaseMonitor.add(r104, "supported_scene", r100);
        BaseMonitor.add(r104, "request_scene", r101);
        x(r103, "init/v2", r102, r110, r104);
    }

    public static void y(MultiLinkEventModule r100, String r101, long r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r101, "apiPath");
        Intrinsics.checkNotNullParameter(r111, "extra");
        w(r100, r101, 0, "", r110, r111);
    }

    public static void z(MultiLinkEventModule r110, String r111, int r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r110, "eventModule");
        Intrinsics.checkNotNullParameter(r111, "businessApiName");
        Intrinsics.checkNotNullParameter("", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        Intrinsics.checkNotNullParameter(r113, "extra");
        if (t(r111) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r113, "business_api_name", r111);
        F();
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "extra");
        Intrinsics.checkNotNullParameter(r101, "metric");
        Intrinsics.checkNotNullParameter(r102, "map");
        Intrinsics.checkNotNullParameter(r113, "jsonObject");
        Map<String, String> r114 = JsonUtil.jsonObjectToMap(r113);
        Intrinsics.checkNotNullParameter(r114, "value");
        Iterator<Map.Entry<String, String>> r115 = r114.entrySet().iterator();
    L7:
        if (r115.hasNext() == false) goto L9;
        Map.Entry<String, String> r116 = r115.next();
        r102.put(r116.getKey(), r116.getValue());
        goto L7
    L9:
        String r103 = r110.getName();
        Intrinsics.checkNotNullParameter(r103, "eventModuleString");
        String r104 = MultiLinkEventType.BUSSINESS_API_CALL.getName();
        Intrinsics.checkNotNullParameter(r104, "eventTypeString");
        r101.put("status_code", String.valueOf(r112));
        r102.put("status_code", String.valueOf(r112));
        Intrinsics.checkNotNullParameter("", "string");
        r102.put("status_message", "");
        cy0.e.f465759a.getClass();
        cy0.j r117 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r118 = com.bytedance.android.scope.m.b(r117).b(n97.a.class);
        Intrinsics.checkNotNull(r118);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r118)).g("ttlive_audience_interactive_bussiness", r103, r104, r100, r101, r102);
    }

    public static void C(MultiLinkEventModule r100, String r101, int r110, String r111, JSONObject r112) {
        if (t(r101) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r112, "sdk_callback_name", r101);
        F();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "extra");
        Intrinsics.checkNotNullParameter(r103, "metric");
        Intrinsics.checkNotNullParameter(r104, "map");
        Intrinsics.checkNotNullParameter(r112, "jsonObject");
        Map<String, String> r105 = JsonUtil.jsonObjectToMap(r112);
        Intrinsics.checkNotNullParameter(r105, "value");
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        Map.Entry<String, String> r113 = r106.next();
        r104.put(r113.getKey(), r113.getValue());
        goto L7
    L9:
        String r107 = r100.getName();
        Intrinsics.checkNotNullParameter(r107, "eventModuleString");
        String r108 = MultiLinkEventType.SDK_CALLBACK.getName();
        Intrinsics.checkNotNullParameter(r108, "eventTypeString");
        r103.put("status_code", String.valueOf(r110));
        r104.put("status_code", String.valueOf(r110));
        Intrinsics.checkNotNullParameter(r111, "string");
        r104.put("status_message", r111);
        cy0.e.f465759a.getClass();
        cy0.j r109 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r114 = com.bytedance.android.scope.m.b(r109).b(n97.a.class);
        Intrinsics.checkNotNull(r114);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r114)).g("ttlive_interact_sdk_callback", r107, r108, r102, r103, r104);
    }

    public static void x(MultiLinkEventModule r100, String r101, Throwable r110, long r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r100, "eventModule");
        Intrinsics.checkNotNullParameter(r101, "apiPath");
        Intrinsics.checkNotNullParameter(r112, "extra");
        if (t(r101) == false) goto L6;
        return;
    L6:
        if ((r110 instanceof ApiServerException) == false) goto L12;
        ApiServerException r113 = (ApiServerException) r110;
        int r102 = r113.getErrorCode();
        String r114 = r113.getErrorMsg();
        if (r114 != null) goto L10;
        r114 = "";
    L10:
        w(r100, r101, r102, r114, r111, r112);
        return;
    L12:
        if (E() == true) goto L14;
        return;
    L14:
        w(r100, r101, 1, String.valueOf(r110), r111, r112);
    }

    public static void w(MultiLinkEventModule r100, String r101, int r102, String r110, long r111, JSONObject r112) {
        if (t(r101) == false) goto L5;
        return;
    L5:
        BaseMonitor.add(r112, "duration", r111);
        BaseMonitor.add(r112, "server_api_name", r101);
        F();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter(r104, "metric");
        Intrinsics.checkNotNullParameter(r105, "map");
        Intrinsics.checkNotNullParameter(r112, "jsonObject");
        Map<String, String> r106 = JsonUtil.jsonObjectToMap(r112);
        Intrinsics.checkNotNullParameter(r106, "value");
        Iterator<Map.Entry<String, String>> r107 = r106.entrySet().iterator();
    L7:
        if (r107.hasNext() == false) goto L9;
        Map.Entry<String, String> r113 = r107.next();
        r105.put(r113.getKey(), r113.getValue());
        goto L7
    L9:
        String r108 = r100.getName();
        Intrinsics.checkNotNullParameter(r108, "eventModuleString");
        String r109 = MultiLinkEventType.SERVER_API_CALL.getName();
        Intrinsics.checkNotNullParameter(r109, "eventTypeString");
        r104.put("status_code", String.valueOf(r102));
        r105.put("status_code", String.valueOf(r102));
        Intrinsics.checkNotNullParameter(r110, "string");
        r105.put("status_message", r110);
        cy0.e.f465759a.getClass();
        cy0.j r114 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r115 = com.bytedance.android.scope.m.b(r114).b(n97.a.class);
        Intrinsics.checkNotNull(r115);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r115)).g("ttlive_audience_interactive_api_call", r108, r109, r103, r104, r105);
    }
}
