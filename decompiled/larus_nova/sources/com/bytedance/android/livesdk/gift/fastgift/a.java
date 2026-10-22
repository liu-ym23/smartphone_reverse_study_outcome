package com.bytedance.android.livesdk.gift.fastgift;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f126123a = 0;

    @JvmStatic
    public static final void a() {
        mz0.n r100 = new mz0.n();
        mz0.m r101 = new mz0.m();
        r101.b(LogCommon.ROOM);
        r101.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r102 = r100.f516448b;
        ArrayList r103 = (ArrayList) r102;
        r103.addAll(r101.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r104 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r105 = com.bytedance.android.scope.m.b(r104).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r105);
        ((mz0.i) ((f80.a) r105)).w3("shortcut_popup_show", r100.f516447a, r100.f516448b);
    }

    static {
    }

    @JvmStatic
    public static final void g(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonType");
        HashMap r102 = new HashMap();
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r100);
        if (r101 == false) goto L5;
        String r103 = "1";
    L6:
        r102.put("is_not_remind", r103);
        mz0.n r104 = new mz0.n();
        Map<String, String> r105 = r104.f516447a;
        Intrinsics.checkNotNullParameter(r105, "map");
        Intrinsics.checkNotNullParameter(r102, "map");
        r105.putAll(r102);
        mz0.m r106 = new mz0.m();
        r106.b(LogCommon.ROOM);
        r106.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r107 = r104.f516448b;
        ArrayList r108 = (ArrayList) r107;
        r108.addAll(r106.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r109 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r110 = com.bytedance.android.scope.m.b(r109).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r110);
        ((mz0.i) ((f80.a) r110)).w3("shortcut_popup_click", r104.f516447a, r104.f516448b);
        return;
    L5:
        r103 = "0";
        goto L6
    }

    @JvmStatic
    public static final void c(long r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "alertType");
        Intrinsics.checkNotNullParameter("convenient", "pageFrom");
        HashMap r103 = new HashMap();
        r103.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r100));
        r103.put("money", String.valueOf(r101));
        r103.put("alert_click", r102);
        r103.put("page_from", "convenient");
        mz0.n r104 = new mz0.n();
        Map<String, String> r105 = r104.f516447a;
        Intrinsics.checkNotNullParameter(r105, "map");
        Intrinsics.checkNotNullParameter(r103, "map");
        r105.putAll(r103);
        mz0.m r106 = new mz0.m();
        r106.b(LogCommon.ROOM);
        r106.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r107 = r104.f516448b;
        ArrayList r108 = (ArrayList) r107;
        r108.addAll(r106.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r109 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r110 = com.bytedance.android.scope.m.b(r109).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r110);
        ((mz0.i) ((f80.a) r110)).w3("livesdk_gift_send_alert_show", r104.f516447a, r104.f516448b);
    }

    @JvmStatic
    public static final void d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "componentType");
        Intrinsics.checkNotNullParameter(r101, "confirmType");
        Intrinsics.checkNotNullParameter(r102, "isSelect");
        HashMap r103 = new HashMap();
        r103.put("component_type", r100);
        r103.put("confirm_type", r101);
        r103.put("is_select", r102);
        mz0.n r104 = new mz0.n();
        Map<String, String> r105 = r104.f516447a;
        Intrinsics.checkNotNullParameter(r105, "map");
        Intrinsics.checkNotNullParameter(r103, "map");
        r105.putAll(r103);
        mz0.m r106 = new mz0.m();
        r106.b(LogCommon.ROOM);
        r106.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r107 = r104.f516448b;
        ArrayList r108 = (ArrayList) r107;
        r108.addAll(r106.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r109 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r110 = com.bytedance.android.scope.m.b(r109).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r110);
        ((mz0.i) ((f80.a) r110)).w3("livesdk_gift_convenient_popup_click", r104.f516447a, r104.f516448b);
    }

    @JvmStatic
    public static final void b(long r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "alertType");
        Intrinsics.checkNotNullParameter("convenient", "pageFrom");
        Intrinsics.checkNotNullParameter(r103, "clickType");
        HashMap r104 = new HashMap();
        r104.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r100));
        r104.put("money", String.valueOf(r101));
        r104.put("alert_click", r102);
        r104.put("page_from", "convenient");
        r104.put("click_type", r103);
        mz0.n r105 = new mz0.n();
        Map<String, String> r106 = r105.f516447a;
        Intrinsics.checkNotNullParameter(r106, "map");
        Intrinsics.checkNotNullParameter(r104, "map");
        r106.putAll(r104);
        mz0.m r107 = new mz0.m();
        r107.b(LogCommon.ROOM);
        r107.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r108 = r105.f516448b;
        ArrayList r109 = (ArrayList) r108;
        r109.addAll(r107.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r110 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r111 = com.bytedance.android.scope.m.b(r110).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r111);
        ((mz0.i) ((f80.a) r111)).w3("livesdk_gift_send_alert_click", r105.f516447a, r105.f516448b);
    }

    @JvmStatic
    public static final void e(boolean r100, long r101, com.bytedance.android.livesdk.gift.platform.core.model.e0 r102, int r103, my1.a r104, Map<String, String> r105, int r106, String r110) {
        HashMap r107 = new HashMap();
        if (r100 == false) goto L5;
        String r108 = "0";
    L6:
        r107.put("room_orientation", r108);
        r107.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r101));
        r107.put("click_type", String.valueOf(r103));
        if (r102 == null) goto L14;
        Map<String, String> r109 = r102.a();
        if (r109 == null) goto L14;
        Iterator<Map.Entry<String, String>> r111 = r109.entrySet().iterator();
    L12:
        if (r111.hasNext() == false) goto L14;
        Map.Entry<String, String> r112 = r111.next();
        r107.put(r112.getKey(), r112.getValue());
    L14:
        r107.put("content", "normal");
        if (r104 == null) goto L22;
        my1.b r113 = r104.f516361a;
        if (r113 == null) goto L22;
        r107.put("content", "gift_coin_task");
        String r114 = r113.rewardNum;
        if (r114 != null) goto L21;
        r114 = "";
    L21:
        r107.put("coin_reward_amt", r114);
    L22:
        if (r105 == null) goto L24;
        r107.putAll(r105);
    L24:
        r107.put("recommend_num", String.valueOf(r106));
        if (r110 != null) goto L27;
        r110 = "";
    L27:
        r107.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r110);
        r107.put("to_user_type", "anchor");
        mz0.n r115 = new mz0.n();
        Map<String, String> r116 = r115.f516447a;
        Intrinsics.checkNotNullParameter(r116, "map");
        Intrinsics.checkNotNullParameter(r107, "map");
        r116.putAll(r107);
        mz0.m r117 = new mz0.m();
        r117.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r118 = ((kr2.a) vh6.c.b(kr2.a.class)).ud();
        Intrinsics.checkNotNullParameter(r118, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r118.c("live_detail");
        Intrinsics.checkNotNullParameter("bottom_tab", EventConstant.Key.MODULE);
        r118.b("bottom_tab");
        Intrinsics.checkNotNullParameter("live", "belong");
        r118.a("live");
        Intrinsics.checkNotNullParameter("click", "type");
        r118.d("click");
        List<Object> r119 = r117.f516446a;
        ArrayList r120 = (ArrayList) r119;
        r120.add(r118.f157176a);
        List<Object> r121 = r115.f516448b;
        ArrayList r122 = (ArrayList) r121;
        r122.addAll(r117.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r123 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r124 = com.bytedance.android.scope.m.b(r123).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r124);
        ((mz0.i) ((f80.a) r124)).w3("shortcut_gift_click", r115.f516447a, r115.f516448b);
        return;
    L5:
        r108 = "1";
        goto L6
    }

    public static void f(long r100, com.bytedance.android.livesdk.gift.platform.core.model.e0 r101, my1.a r102, long r103, long r110, Map r111, int r112, String r113, int r114) {
        if ((r114 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r114 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r114 & 32) == 0) goto L12;
        r111 = null;
    L12:
        if ((r114 & 64) == 0) goto L15;
        r112 = 0;
    L15:
        if ((r114 & 128) == 0) goto L18;
        r113 = null;
    L18:
        if (r100 == 0) goto L51;
        HashMap r115 = new HashMap();
        r115.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, String.valueOf(r100));
        long r104 = 1000;
        if (r103 <= r104) goto L23;
        r115.put("enter_time", String.valueOf(System.currentTimeMillis() - r103));
    L25:
        if (r110 <= r104) goto L27;
        r115.put("first_frame_time", String.valueOf(System.currentTimeMillis() - r110));
    L28:
        if (r101 == null) goto L35;
        Map<String, String> r105 = r101.a();
        if (r105 == null) goto L35;
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();
    L33:
        if (r106.hasNext() == false) goto L35;
        Map.Entry<String, String> r107 = r106.next();
        r115.put(r107.getKey(), r107.getValue());
    L35:
        r115.put("content", "normal");
        if (r102 == null) goto L43;
        my1.b r108 = r102.f516361a;
        if (r108 == null) goto L43;
        r115.put("content", "gift_coin_task");
        String r109 = r108.rewardNum;
        if (r109 != null) goto L42;
        r109 = "";
    L42:
        r115.put("coin_reward_amt", r109);
    L43:
        if (r111 == null) goto L45;
        r115.putAll(r111);
    L45:
        r115.put("recommend_num", String.valueOf(r112));
        if (r113 != null) goto L48;
        r113 = "";
    L48:
        r115.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r113);
        r115.put("to_user_type", "anchor");
        mz0.n r116 = new mz0.n();
        Map<String, String> r117 = r116.f516447a;
        Intrinsics.checkNotNullParameter(r117, "map");
        Intrinsics.checkNotNullParameter(r115, "map");
        r117.putAll(r115);
        mz0.m r118 = new mz0.m();
        r118.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r119 = ((kr2.a) vh6.c.b(kr2.a.class)).ud();
        Intrinsics.checkNotNullParameter(r119, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r119.c("live_detail");
        Intrinsics.checkNotNullParameter("bottom_tab", EventConstant.Key.MODULE);
        r119.b("bottom_tab");
        Intrinsics.checkNotNullParameter("live", "belong");
        r119.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r119.d("other");
        ((ArrayList) r118.f516446a).add(r119.f157176a);
        ((ArrayList) r116.f516448b).addAll(r118.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r120 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r121 = com.bytedance.android.scope.m.b(r120).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r121);
        ((mz0.i) ((f80.a) r121)).w3("shortcut_gift_show", r116.f516447a, r116.f516448b);
        return;
    L27:
        r115.put("first_frame_time", "-1");
        goto L28
    L23:
        r115.put("enter_time", "-1");
        goto L25
    }
}
