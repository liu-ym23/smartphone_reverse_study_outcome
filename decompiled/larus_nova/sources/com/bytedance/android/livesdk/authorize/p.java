package com.bytedance.android.livesdk.authorize;

import am2.x;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.log.filter.k0;
import com.bytedance.android.livesdkapi.auth.INewAuthReport;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class p implements INewAuthReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f104219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f104220b = null;

    public p() {
    }

    static {
        f104220b = new p();
        f104219a = BdpAppEventConstant.NO;
    }

    public static void a(HashMap r100) {
        Room r101 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        String r102 = "";
        if (r101 == null) goto L11;
        r100.put("anchor_id", r101.getOwnerUserIdString());
        String r103 = r101.getIdStr();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r100.put("room_id", r103);
        r100.put("request_id", r101.getRequestId());
        String r104 = r101.getLog_pb();
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        r100.put("log_pb", r104);
    L11:
        com.bytedance.android.livesdk.log.filter.o r105 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        if (r105 == null) goto L21;
        String r106 = r105.getMap().get("enter_from_merge");
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        r100.put("enter_from_merge", r106);
        String r107 = r105.getMap().get("enter_method");
        if (r107 == null) goto L20;
        r102 = r107;
    L20:
        r100.put("enter_method", r102);
    L21:
        r100.put("action_type", "click");
        if (((od1.a) jc1.k.n(od1.a.class)).hostIsLogin() == false) goto L24;
        String r108 = "unlogged";
    L25:
        r100.put("user_type", r108);
        return;
    L24:
        r108 = "unauthorized";
        goto L25
    }

    public static void h(boolean r100) {
        HashMap r101 = new HashMap();
        a(r101);
        if (r100 == false) goto L5;
        String r102 = "confirm";
    L6:
        r101.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r102);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_coupon_authorization_guide_click", r101, new Object[0]);
        return;
    L5:
        r102 = "cancel";
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.auth.INewAuthReport
    public final void setOnClickLogin(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = BdpAppEventConstant.YES;
    L5:
        f104219a = r101;
        return;
    L4:
        r101 = BdpAppEventConstant.NO;
        goto L5
    }

    public static void b(String r100, Map r101) {
        Room r102 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        String r103 = "";
        if (r102 == null) goto L23;
        String r104 = r102.getLog_pb();
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        r101.put("log_pb", r104);
        String r105 = r102.getRequestId();
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        r101.put("request_id", r105);
        String r106 = r102.getOwnerUserIdString();
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r101.put("anchor_id", r106);
        String r107 = r102.getIdStr();
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        r101.put("room_id", r107);
        LinkedHashMap r108 = new LinkedHashMap();
        com.bytedance.android.livesdk.log.filter.o r109 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        if (r109 == null) goto L19;
        r109.a(r108);
    L19:
        String r110 = (String) r108.get("action_type");
        if (r110 != null) goto L22;
        r110 = "";
    L22:
        r101.put("action_type", r110);
    L23:
        com.bytedance.android.livesdk.log.filter.o r111 = null;
        RoomContext r112 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r112 == null) goto L30;
        com.bytedance.live.datacontext.i<Boolean> r113 = r112.isAnchor();
        if (r113 == null) goto L30;
        if (r113.getValue().booleanValue() != true) goto L30;
        String r114 = "anchor";
    L31:
        r101.put("user_type", r114);
        com.bytedance.android.livesdk.log.filter.o r115 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        if (r115 == null) goto L37;
        Map<String, String> r116 = r115.getMap();
        if (r116 == null) goto L37;
        String r117 = r116.get("enter_from_merge");
        if (r117 == null) goto L37;
    L39:
        if (r115 == null) goto L44;
        Map<String, String> r118 = r115.getMap();
        if (r118 == null) goto L44;
        String r119 = r118.get("enter_method");
        if (r119 == null) goto L44;
    L45:
        r101.put("enter_from_merge", r117);
        r101.put("enter_method", r119);
        r101.put("is_h5", "no_h5");
        CharSequence r120 = (CharSequence) ((LinkedHashMap) r101).get("source");
        if (r120 != null) goto L48;
    L51:
        boolean r121 = true;
    L52:
        if (r121 == false) goto L66;
        com.bytedance.android.livesdk.log.filter.o r122 = com.bytedance.android.livesdk.log.u.l().c(com.bytedance.android.livesdk.user.k.class);
        if ((r122 instanceof k0) == false) goto L57;
        r111 = r122;
    L57:
        k0 r123 = (k0) r111;
        if (r123 == null) goto L65;
        com.bytedance.android.livesdk.user.l r124 = r123.f153301c;
        if (r124 == null) goto L65;
        String r125 = r124.f158679d;
        if (r125 == null) goto L65;
        r103 = r125;
    L65:
        r101.put("source", r103);
    L66:
        r101.put("is_skip_confirm", "0");
        com.bytedance.android.livesdk.log.u.l().sendLog(r100, r101, new Object[]{com.bytedance.android.livesdk.user.k.class});
        return;
    L48:
        if (r120.length() == 0) goto L51;
        r121 = false;
    L44:
        r119 = "";
    L37:
        r117 = "";
    L30:
        r114 = SourceType.DEFAULT;
        goto L31
    }

    public static void d(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        LinkedHashMap r102 = new LinkedHashMap();
        if (r100 == false) goto L5;
        String r103 = "mix";
    L6:
        r102.put("is_oneclick_login", r103);
        r102.put("source", r101);
        b("livesdk_aweme_authorization_integrate_pop_show", r102);
        return;
    L5:
        r103 = BdpAppEventConstant.NO;
        goto L6
    }

    public static void f(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "popupType");
        HashMap r102 = new HashMap();
        a(r102);
        String r103 = "1";
        r102.put("is_skip_confirm", "1");
        r102.put("popup_type", r100);
        if (r101 == true) goto L6;
        r103 = "0";
    L6:
        r102.put("is_coupon", r103);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_aweme_authorization_guide_show", r102, new Object[0]);
    }

    public static void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonType");
        Intrinsics.checkNotNullParameter(r101, "source");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("is_oneclick_login", BdpAppEventConstant.YES);
        r102.put("source", r101);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r100);
        b("livesdk_aweme_authorization_integrate_license_pop_click", r102);
    }

    @Override // com.bytedance.android.livesdkapi.auth.INewAuthReport
    public final void logAuthDialogShow(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        d(r100, r101);
    }

    public static void c(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "buttonType");
        Intrinsics.checkNotNullParameter(r102, "source");
        LinkedHashMap r103 = new LinkedHashMap();
        if (r100 == false) goto L5;
        String r104 = BdpAppEventConstant.YES;
    L6:
        r103.put("is_oneclick_login", r104);
        r103.put("source", r102);
        r103.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r101);
        int r105 = a.f104200a;
        r103.put("auth_host_app", a.a(LiveResUtil.getContext()));
        b("livesdk_aweme_authorization_integrate_pop_click", r103);
        return;
    L5:
        r104 = BdpAppEventConstant.NO;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.auth.INewAuthReport
    public final void logAuthDialogClick(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "buttonType");
        Intrinsics.checkNotNullParameter(r102, "source");
        c(r100, r101, r102);
    }

    public static void e(boolean r100, boolean r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "popupType");
        HashMap r104 = new HashMap();
        a(r104);
        if (r100 == false) goto L5;
        String r105 = "authorization";
    L6:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r105);
        String r106 = "1";
        r104.put("is_skip_confirm", "1");
        if (r101 == false) goto L9;
        Object r107 = "1";
    L10:
        r104.put("is_selected_agreement", r107);
        r104.put("popup_type", r102);
        if (r103 == true) goto L14;
        r106 = "0";
    L14:
        r104.put("is_coupon", r106);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_aweme_authorization_guide_click", r104, new Object[0]);
        return;
    L9:
        r107 = "0";
        goto L10
    L5:
        r105 = "cancel";
        goto L6
    }
}
