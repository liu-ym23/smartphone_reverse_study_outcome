package com.bytedance.android.livesdk.account.impl;

import am2.x;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostCoinState;
import com.bytedance.android.livehostapi.platform.TokenInfo;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.log.filter.k0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.auth.LiveAuthFailException;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes7.dex */
public final class AuthReporter implements od1.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f103001a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AuthReporter f103002b = null;

    public AuthReporter() {
    }

    static {
        f103002b = new AuthReporter();
        f103001a = LazyKt.lazy(AuthReporter$authFailInfoMap$2.INSTANCE);
    }

    @Override // od1.d
    public final void a() {
        int r100 = ve1.a.f554322a;
        IHostCoinState r101 = TTLiveSDK.hostService().coinState();
        if (r101 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r101.isEnableBindAccountAwardTask());
    L7:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L11;
        a r103 = new a();
        Intrinsics.checkNotNullParameter(r103, "callback");
        IHostCoinState r104 = TTLiveSDK.hostService().coinState();
        if (r104 == null) goto L13;
        r104.getCoinState(LiveResUtil.getContext(), r103);
        Unit r105 = Unit.INSTANCE;
        return;
    L13:
        return;
    L11:
        c(true, false, null, "");
        return;
    L5:
        r102 = null;
        goto L7
    }

    public static void d(Throwable r110) {
        o r100 = u.l().c(com.bytedance.android.livesdk.user.k.class);
        if ((r100 instanceof k0) == false) goto L36;
        k0 r101 = (k0) r100;
        com.bytedance.android.livesdk.user.l r102 = r101.f153301c;
        if (r102 == null) goto L7;
        String r103 = r102.f158679d;
    L9:
        if (Intrinsics.areEqual("silent_auth_guide", r103) == true) goto L22;
        com.bytedance.android.livesdk.user.l r104 = r101.f153301c;
        if (r104 == null) goto L13;
        String r105 = r104.f158679d;
    L15:
        if (Intrinsics.areEqual("silent_auth_guide_agreement", r105) == true) goto L22;
        com.bytedance.android.livesdk.user.l r106 = r101.f153301c;
        if (r106 == null) goto L19;
        String r107 = r106.f158679d;
    L21:
        if (Intrinsics.areEqual("silent_lite_interaction", r107) == true) goto L22;
        return;
    L19:
        r107 = null;
        goto L21
    L13:
        r105 = null;
    L22:
        HashMap r108 = new HashMap();
        r108.put("error", r110.toString());
        IAppLog r109 = BDLiveSdk.appLog();
        if (r109 != null) goto L25;
    L34:
        u.l().sendLog("livesdk_aweme_authorization_result_failed", r108, new Object[]{com.bytedance.android.livesdk.user.k.class});
        return;
    L25:
        if (r109.isTob() != true) goto L34;
        String r111 = r110.toString();
        if (StringsKt.contains$default(r111, Typography.dollar, false, 2, null) == false) goto L34;
        String r112 = (String) ListProtector.get(StringsKt.split$default(r111, new char[]{Typography.dollar}, false, 0, 6, null), 1);
        if (r112.length() <= 0) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == false) goto L34;
        r108.put("auth_host_app", r112);
        goto L34
    L31:
        r113 = false;
        goto L32
    L7:
        r103 = null;
        goto L9
    }

    @Override // od1.d
    public final void b(Throwable r100) {
        if (r100 != null) goto L7;
    L4:
        c(false, false, r100, String.valueOf(r100));
        return;
    L7:
        d(r100);     // Catch: Throwable -> L6
        goto L4
    }

    public static void c(boolean r110, boolean r210, Throwable r211, String r212) {
        HashMap r100 = new HashMap();
        Room r101 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        String r102 = "";
        if (r101 == null) goto L23;
        String r103 = r101.getLog_pb();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r100.put("log_pb", r103);
        String r104 = r101.getRequestId();
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        r100.put("request_id", r104);
        String r105 = r101.getOwnerUserIdString();
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r100.put("anchor_id", r105);
        String r106 = r101.getIdStr();
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        r100.put("room_id", r106);
        LinkedHashMap r107 = new LinkedHashMap();
        o r108 = u.l().c(x.class);
        if (r108 == null) goto L19;
        r108.a(r107);
    L19:
        String r109 = (String) r107.get("action_type");
        if (r109 != null) goto L22;
        r109 = "";
    L22:
        r100.put("action_type", r109);
    L23:
        r100.put("is_h5", "no_h5");
        if (r210 == false) goto L26;
        Object r111 = "1";
    L27:
        r100.put("is_get_coin", r111);
        if (((od1.a) jc1.k.n(od1.a.class)).hostIsLogin() == false) goto L30;
        Object r112 = "1";
    L31:
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_APP_LOGIN, r112);
        RoomContext r113 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r113 == null) goto L38;
        com.bytedance.live.datacontext.i<Boolean> r114 = r113.isAnchor();
        if (r114 == null) goto L38;
        if (r114.getValue().booleanValue() != true) goto L38;
        String r115 = "anchor";
    L39:
        r100.put("user_type", r115);
        int r116 = com.bytedance.android.livesdk.authorize.a.f104200a;
        r100.put("auth_host_app", com.bytedance.android.livesdk.authorize.a.a(LiveResUtil.getContext()));
        o r117 = u.l().c(x.class);
        if (r117 == null) goto L45;
        Map<String, String> r118 = r117.getMap();
        if (r118 == null) goto L45;
        String r119 = r118.get("enter_from_merge");
        if (r119 == null) goto L45;
    L47:
        if (r117 == null) goto L52;
        Map<String, String> r120 = r117.getMap();
        if (r120 == null) goto L52;
        String r121 = r120.get("enter_method");
        if (r121 == null) goto L52;
    L53:
        r100.put("enter_from_merge", r119);
        r100.put("enter_method", r121);
        if (r110 == false) goto L56;
        r100.put("interact_authorized_type", "1");
        r100.put("aweme_authorization_error_code", "");
    L83:
        IEnterGuideService r122 = (IEnterGuideService) jc1.k.n(IEnterGuideService.class);
        r100.put("is_oneclick_login", r122.getNewAuthReportOneClickLoginStatus());
        r122.setNewAuthReportOneClickLoginStatus(BdpAppEventConstant.NO);
        od1.a r123 = (od1.a) jc1.k.f(od1.a.class);
        if ((r123 instanceof od1.c) == false) goto L107;
        TokenInfo r124 = ((od1.c) r123).getTokenInfo();
        if (r124 == null) goto L88;
        String r125 = r124.getName();
    L89:
        if (r125 == null) goto L107;
        if (r125.length() <= 0) goto L93;
        boolean r126 = true;
    L94:
        if (r126 != true) goto L107;
        if (StringsKt.contains$default(r125, Typography.dollar, false, 2, null) == false) goto L107;
        IAppLog r127 = BDLiveSdk.appLog();
        if (r127 == null) goto L107;
        if (r127.isTob() != true) goto L107;
        String r128 = (String) ListProtector.get(StringsKt.split$default(r125, new char[]{Typography.dollar}, false, 0, 6, null), 1);
        if (r128.length() <= 0) goto L104;
        boolean r129 = true;
    L105:
        if (r129 == false) goto L107;
        r100.put("auth_host_app", r128);
        goto L107
    L104:
        r129 = false;
        goto L105
    L93:
        r126 = false;
        goto L94
    L88:
        r125 = null;
    L107:
        if (r110 == true) goto L131;
        if (r212 != null) goto L134;
    L130:
        r100.put("error_reason", r102);
        goto L131
    L134:
        String r130 = r212.substring(StringsKt.indexOf$default(r212, "---error_code:", 0, false, 6, null) + 14, StringsKt.indexOf$default(r212, "---error_msg:", 0, false, 6, null));     // Catch: Exception -> L128
        switch(r130.hashCode()) {
            case 1444: goto L125;
            case 1445: goto L122;
            case 1446: goto L119;
            case 1447: goto L116;
            case 1448: goto L113;
            default: goto L133;
        };     // Catch: Exception -> L128
    L133:
        goto L130
    L113:
        if (r130.equals(OnekeyLoginConstants.ErrorCode.ERROR_CARRIER_DISABLED) == false) goto L133;
        r102 = "no_support";
        goto L133
    L116:
        if (r130.equals(OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT) == false) goto L133;
        r102 = VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT;
        goto L133
    L119:
        if (r130.equals("-3") == false) goto L133;
        r102 = "send_fail";
        goto L133
    L122:
        if (r130.equals("-2") == false) goto L133;
        r102 = "cancel";
        goto L133
    L125:
        if (r130.equals("-1") == false) goto L133;
        r102 = "common_error";
    L128:
        e = move-exception;
        e.printStackTrace();
    L131:
        u.l().sendLog("livesdk_aweme_authorization_result", r100, new Object[]{com.bytedance.android.livesdk.user.k.class});
        return;
    L56:
        if (r211 == null) goto L58;
        String r131 = r211.getMessage();
    L59:
        if (r211 == null) goto L61;
        Throwable r132 = r211.getCause();
    L63:
        if ((r132 instanceof LiveAuthFailException) == false) goto L65;
        String r133 = ((LiveAuthFailException) r132).getAuthErrorCode();
    L70:
        if (r133 == null) goto L77;
        String r134 = (String) ((Map) f103001a.getValue()).get(r133);
        if (r134 == null) goto L75;
        r133 = r134;
    L75:
        r100.put("aweme_authorization_fail_info", r133);
    L77:
        if (Intrinsics.areEqual(r131, "user cancel") == false) goto L79;
        r100.put("interact_authorized_type", "-1");
        r100.put("aweme_authorization_error_code", "");
        goto L83
    L79:
        r100.put("interact_authorized_type", "0");
        if (r131 != null) goto L82;
        r131 = "";
    L82:
        r100.put("aweme_authorization_error_code", r131);
        goto L83
    L65:
        if (r131 == null) goto L69;
        List r135 = StringsKt.split$default(r131, new String[]{"errorCode:"}, false, 0, 6, null);
        if (r135 == null) goto L69;
        r133 = (String) CollectionsKt.lastOrNull(r135);
    L69:
        r133 = null;
        goto L70
    L61:
        r132 = null;
        goto L63
    L58:
        r131 = null;
    L52:
        r121 = "";
    L45:
        r119 = "";
    L38:
        r115 = SourceType.DEFAULT;
        goto L39
    L30:
        r112 = "0";
        goto L31
    L26:
        r111 = "0";
        goto L27
    }
}
