package com.bytedance.ai.applet.douyinAuth;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.grantingV2.McpGrantingManager;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.utils.l;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import p4.n;

/* JADX INFO: loaded from: classes43.dex */
public final class DouyinGeneralAuthHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DouyinGeneralAuthHelper f34616a = null;

    public static final class a implements Function2<Boolean, String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<e> f34617a;

        public a(j r100) {
            this.f34617a = r100;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Boolean r100, String r101) {
            boolean r102 = r100.booleanValue();
            String r103 = r101;
            if (this.f34617a.isActive() == false) goto L10;
            i<e> r104 = this.f34617a;
            Result.Companion r105 = Result.Companion;
            if (r103 == null) goto L8;
            r102 = false;
        L8:
            r104.resumeWith(Result.m9449constructorimpl(new e(r102, r103)));
        L10:
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function2<GrantingAction, String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<d> f34618a;

        public b(j r100) {
            this.f34618a = r100;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(GrantingAction r100, String r101) {
            GrantingAction r102 = r100;
            String r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "userAction");
            if (this.f34618a.isActive() == false) goto L6;
            i<d> r104 = this.f34618a;
            Result.Companion r105 = Result.Companion;
            r104.resumeWith(Result.m9449constructorimpl(new d(r102, r103)));
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
        f34616a = new DouyinGeneralAuthHelper();
    }

    public DouyinGeneralAuthHelper() {
    }

    public final Object b(String r210, Continuation<? super c> r211) {
        String r100 = r210;
        if ((r211 instanceof DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1) == false) goto L7;
        DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1 r101 = (DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        String r107 = null;
        if (r105 == 0) goto L19;
        if (r105 != 1) goto L18;
        int r108 = r101.I$0;
        String r109 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14 TimeoutCancellationException -> L16
        int r110 = r108;
        r100 = r109;
    L122:
        Result r111 = (Result) r103;     // Catch: Exception -> L26 TimeoutCancellationException -> L119
    L32:
        if (r111 == null) goto L37;
        Object r112 = r111.m9458unboximpl();
        if (Result.m9455isFailureimpl(r112) == false) goto L36;
        r112 = null;
    L36:
        n r113 = (n) r112;
    L38:
        if (r110 == 0) goto L40;
        AppletAuthTaskMonitor.a r114 = new AppletAuthTaskMonitor.a("timeout", "applet.requestDouyinGeneralAuth.callback", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.TIMEOUT, "getAwemeCommonLoginInfo timeout", null, null, null, 480);
    L101:
        if (r113 == null) goto L112;
        String r115 = r113.f();
        if (r115 == null) goto L112;
        String r116 = StringsKt.trim(r115).toString();
        if (r116 == null) goto L112;
        if (r116.length() > 0) goto L110;
        r106 = false;
    L110:
        if (r106 == false) goto L112;
        r107 = r116;
    L112:
        if (r107 != null) goto L114;
        if (r110 != 0) goto L118;
        g.f37637a.w("DouyinGeneralAuthHelper", "fetchDouyinGeneralAuthSubtitle no valid server subtitle, use fallback, appId=" + r100);
    L118:
        return new c("授权豆包获取你抖音账号下收藏的歌曲、本地生活服务、生活缴费及抖音支付等信息，用以向你提供更便捷的服务。", r114);
    L114:
        return new c(r107, r114);
    L40:
        if (r111 != null) goto L42;
    L44:
        boolean r117 = false;
    L45:
        if (r117 == false) goto L51;
        AppletAuthTaskMonitor.ErrorCode r118 = AppletAuthTaskMonitor.ErrorCode.API_FAILED;
        Throwable r119 = Result.m9452exceptionOrNullimpl(r111.m9458unboximpl());
        if (r119 == null) goto L49;
        String r120 = r119.getMessage();
    L50:
        r114 = new AppletAuthTaskMonitor.a("failed", "applet.requestDouyinGeneralAuth.callback", "aweme_auth_prepare", r118, r120, null, null, null, 480);
        goto L101
    L49:
        r120 = null;
        goto L50
    L51:
        if (r113 == null) goto L87;
        String r121 = r113.e();
        if (r121 == null) goto L87;
        f34616a.getClass();
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L57
        Object r123 = Result.m9449constructorimpl(com.bytedance.ai.applet.login.a.a(r121));     // Catch: Throwable -> L57
    L60:
        if (Result.m9455isFailureimpl(r123) == false) goto L62;
        r123 = null;
    L62:
        com.bytedance.ai.applet.login.c r124 = (com.bytedance.ai.applet.login.c) r123;
        if (r124 == null) goto L65;
        String r125 = r124.f34740d;
    L66:
        if (r125 != null) goto L68;
    L71:
        boolean r126 = true;
    L72:
        if (r126 == true) goto L84;
        if (r124 == null) goto L75;
        String r127 = r124.f34742f;
    L76:
        if (r127 != null) goto L78;
    L81:
        boolean r128 = true;
    L82:
        if (r128 == true) goto L84;
        boolean r129 = true;
    L85:
        if (r129 == true) goto L87;
        boolean r130 = true;
    L88:
        if (r130 == false) goto L90;
        r114 = new AppletAuthTaskMonitor.a("failed", "applet.requestDouyinGeneralAuth.callback", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "invalid aweme authLink", null, null, null, 480);
        goto L101
    L90:
        if (r113 == null) goto L100;
        String r131 = r113.e();
        if (r131 != null) goto L94;
    L97:
        boolean r132 = true;
    L98:
        if (r132 == false) goto L100;
        r114 = new AppletAuthTaskMonitor.a("failed", "applet.requestDouyinGeneralAuth.callback", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "invalid aweme authLink", null, null, null, 480);
        goto L101
    L94:
        if (StringsKt.isBlank(r131) == true) goto L97;
        r132 = false;
    L100:
        r114 = null;
        goto L101
    L78:
        if (StringsKt.isBlank(r127) == true) goto L81;
        r128 = false;
        goto L82
    L75:
        r127 = null;
    L84:
        r129 = false;
        goto L85
    L68:
        if (StringsKt.isBlank(r125) == true) goto L71;
        r126 = false;
        goto L72
    L65:
        r125 = null;
    L57:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L87:
        r130 = false;
        goto L88
    L42:
        if (Result.m9455isFailureimpl(r111.m9458unboximpl()) != true) goto L44;
        r117 = true;
        goto L45
    L37:
        r113 = null;
        goto L38
    L31:
        g.f37637a.w("DouyinGeneralAuthHelper", "fetchDouyinGeneralAuthSubtitle timeout after 1000ms, use fallback, appId=" + r100);
        r111 = null;
        r110 = 1;
    L26:
        e = e;
    L30:
        g.f37637a.w("DouyinGeneralAuthHelper", "fetchDouyinGeneralAuthSubtitle failed, use fallback, appId=" + r100, e);
        Result.Companion r134 = Result.Companion;
        r111 = Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(e)));
        goto L32
    L16:
        r100 = r109;
    L14:
        e = e;
        r110 = r108;
        r100 = r109;
        goto L30
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r103);
        DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$result$1 r135 = new DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$result$1(r100, null);     // Catch: Exception -> L28 TimeoutCancellationException -> L119
        r101.L$0 = r100;     // Catch: Exception -> L28 TimeoutCancellationException -> L119
        r101.I$0 = 0;     // Catch: Exception -> L28 TimeoutCancellationException -> L119
        r101.label = 1;     // Catch: Exception -> L28 TimeoutCancellationException -> L119
        r103 = TimeoutKt.b(1000, r135, r101);     // Catch: Exception -> L28 TimeoutCancellationException -> L119
        if (r103 != r104) goto L23;
        return r104;
    L23:
        r110 = 0;
    L28:
        e = e;
        r110 = 0;
    L7:
        r101 = new DouyinGeneralAuthHelper$fetchDouyinGeneralAuthPrepareResult$1(this, r211);
        goto L8
    }

    public static Object a(String r100, String r101, String r102, Continuation r103) {
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r104 = AppletRuntimeManager.f36749d;
        if (r104 == null) goto L5;
        g.f37637a.i("DouyinGeneralAuthHelper", "checkAppletFirstPartyAuthStatus authSource=".concat(r102));
        j r105 = new j(IntrinsicsKt.intercepted(r103), 1);
        r105.C();
        r104.n(r100, r101, new a(r105));
        Object r106 = r105.B();
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L9:
        return r106;
    L5:
        return new e(false, "aiAbility is null");
    }

    public final Object c(u2.c r210, u2.d r211, com.bytedance.ai.applet.login.c r212, AppletAuthTaskMonitor.Session r213, Continuation<? super Unit> r214) {
        u2.c r100 = r210;
        AppletAuthTaskMonitor.Session r110 = r213;
        if ((r214 instanceof DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1) == false) goto L7;
        DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1 r101 = (DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1) r214;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1 r103 = r101;
        Object r104 = r103.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r106 = (String) r103.L$2;
        AppletAuthTaskMonitor.Session r107 = (AppletAuthTaskMonitor.Session) r103.L$1;
        u2.c r108 = (u2.c) r103.L$0;
        ResultKt.throwOnFailure(r104);
        String r112 = r106;
        r110 = r107;
        r100 = r108;
    L53:
        d r109 = (d) r104;
        g.f37637a.i("DouyinGeneralAuthHelper", "requestAppletFirstPartyAuth callback msgID=" + r112 + ", userAction=" + r109.f34623a + ", errorMsg=" + r109.f34624b);
        String r113 = r109.f34624b;
        if (r113 == null) goto L57;
        if (r110 == null) goto L57;
        r110.d(new AppletAuthTaskMonitor.a("failed", "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_request", AppletAuthTaskMonitor.ErrorCode.API_FAILED, r113, null, null, null, 480));
    L57:
        McpGrantingManager r114 = McpGrantingManager.f34644a;
        GrantingAction r115 = r109.f34623a;
        r114.getClass();
        McpGrantingManager.i(r100, r115);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r212 != null) goto L21;
        g.f37637a.e("DouyinGeneralAuthHelper", "handleFirstPartyLoginAgree: authLinkData is null.");
        if (r110 == null) goto L19;
        r110.d(new AppletAuthTaskMonitor.a("failed", "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "authLinkData is null", null, null, null, 480));
    L19:
        McpGrantingManager r116 = McpGrantingManager.f34644a;
        GrantingAction r117 = GrantingAction.DISMISSED;
        r116.getClass();
        McpGrantingManager.i(r100, r117);
        return Unit.INSTANCE;
    L21:
        String r118 = r212.f34740d;
        String r119 = r212.f34742f;
        boolean r120 = false;
        if (r118 != null) goto L24;
    L27:
        boolean r121 = true;
    L28:
        if (r121 == true) goto L59;
        if (r119 != null) goto L31;
    L32:
        r120 = true;
    L33:
        if (r120 == true) goto L59;
        u2.b r122 = r100.f548391f;
        r112 = r122.f548379a;
        HashMap<String, Object> r123 = r122.f548385g;
        HashMap r124 = new HashMap();
        if (r123 == null) goto L38;
        r124.putAll(r123);
    L38:
        r124.put("current_page", "chat");
        r124.put("source", "doubao_apps_auth_request");
        r124.put("app_key", r100.f548386a);
        r124.put("app_name", r100.f548387b);
        String r125 = r100.f548387b;
        l r126 = l.f37675a;
        String r127 = l.e(r126, "larus_appEntry_dyAuth_popup_title_cn");
        if (r127 != null) goto L41;
        r127 = "需绑定抖音账号";
    L41:
        String r128 = r127;
        String r129 = r211.d();
        if (r129 != null) goto L44;
        r129 = "";
    L44:
        String r215 = r129;
        String r130 = l.e(r126, "larus_appEntry_dyAuth_popup_btn_confirm_cn");
        if (r130 != null) goto L47;
        r130 = "立即绑定抖音";
    L47:
        String r216 = r130;
        String r131 = l.e(r126, "larus_appEntry_dyAuth_popup_btn_cancel_cn");
        if (r131 != null) goto L50;
        r131 = "以后再说";
    L50:
        u2.i r132 = new u2.i(null, null, r125, r128, r215, r216, r131);
        r103.L$0 = r100;
        r103.L$1 = r110;
        r103.L$2 = r112;
        r103.label = 1;
        r104 = d(r118, r119, r124, r132, "chat", null, r213, r103);
        if (r104 != r111) goto L53;
        return r111;
    L31:
        if (StringsKt.isBlank(r119) == false) goto L33;
    L59:
        g.f37637a.e("DouyinGeneralAuthHelper", "handleFirstPartyLoginAgree: authLink format error");
        if (r110 == null) goto L62;
        r110.d(new AppletAuthTaskMonitor.a("failed", "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "authLink format error", null, null, null, 480));
    L62:
        McpGrantingManager r133 = McpGrantingManager.f34644a;
        GrantingAction r134 = GrantingAction.DISMISSED;
        r133.getClass();
        McpGrantingManager.i(r100, r134);
        return Unit.INSTANCE;
    L24:
        if (StringsKt.isBlank(r118) == true) goto L27;
        r121 = false;
    L7:
        r101 = new DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1(this, r214);
        goto L8
    }

    public final Object e(AppletApplication r210, String r211, String r212, ContainerType r213, AppletAuthTaskMonitor.Session r214, Continuation<? super d> r215) {
        if ((r215 instanceof DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1) == false) goto L7;
        DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1 r100 = (DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1) r215;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1 r102 = r100;
        Object r103 = r102.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        ResultKt.throwOnFailure(r103);
    L61:
        return r103;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Map<String, ? extends Object> r105 = (HashMap) r102.L$5;
        String r106 = (String) r102.L$4;
        AppletAuthTaskMonitor.Session r107 = (AppletAuthTaskMonitor.Session) r102.L$3;
        ContainerType r108 = (ContainerType) r102.L$2;
        String r109 = (String) r102.L$1;
        String r111 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L44:
        c r112 = (c) r103;
        Map<String, ? extends Object> r113 = r105;
        String r114 = r106;
        String r115 = r111;
        String r216 = r109;
        ContainerType r116 = r108;
        String r117 = r216;
    L45:
        AppletAuthTaskMonitor.a r118 = r112.f34622b;
        if (r118 == null) goto L49;
        if (r107 == null) goto L49;
        r107.d(r118);
    L49:
        l r119 = l.f37675a;
        String r120 = l.e(r119, "larus_appEntry_dyAuth_popup_title_cn");
        if (r120 != null) goto L52;
        r120 = "需绑定抖音账号";
    L52:
        String r121 = r120;
        String r122 = r112.f34621a;
        String r123 = l.e(r119, "larus_appEntry_dyAuth_popup_btn_confirm_cn");
        if (r123 != null) goto L55;
        r123 = "立即绑定抖音";
    L55:
        String r124 = r123;
        String r125 = l.e(r119, "larus_appEntry_dyAuth_popup_btn_cancel_cn");
        if (r125 != null) goto L58;
        r125 = "以后再说";
    L58:
        u2.i r126 = new u2.i(null, null, r114, r121, r122, r124, r125);
        String r127 = com.bytedance.ai.applet.douyinAuth.a.a(r115);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.L$3 = null;
        r102.L$4 = null;
        r102.L$5 = null;
        r102.L$6 = null;
        r102.label = 4;
        r103 = d("aw730v27vx2bu2qw", r127, r113, r126, r117, r116, r107, r102);
        if (r103 != r110) goto L61;
        return r110;
    L18:
        r105 = (HashMap) r102.L$6;
        r106 = (String) r102.L$5;
        AppletAuthTaskMonitor.Session r128 = (AppletAuthTaskMonitor.Session) r102.L$4;
        r116 = (ContainerType) r102.L$3;
        String r129 = (String) r102.L$2;
        String r130 = (String) r102.L$1;
        AppletApplication r131 = (AppletApplication) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L35:
        r112 = (c) r103;
        if (r112 == null) goto L40;
        r113 = r105;
        r114 = r106;
        r107 = r128;
        r117 = r129;
        r115 = r130;
    L40:
        String r132 = r131.getAppId();
        r102.L$0 = r130;
        r102.L$1 = r129;
        r102.L$2 = r116;
        r102.L$3 = r128;
        r102.L$4 = r106;
        r102.L$5 = r105;
        r102.L$6 = null;
        r102.label = 3;
        r103 = b(r132, r102);
        if (r103 != r110) goto L43;
        return r110;
    L43:
        r107 = r128;
        r108 = r116;
        r109 = r129;
        r111 = r130;
        goto L44
    L19:
        AppletAuthTaskMonitor.Session r133 = (AppletAuthTaskMonitor.Session) r102.L$4;
        ContainerType r134 = (ContainerType) r102.L$3;
        r129 = (String) r102.L$2;
        r130 = (String) r102.L$1;
        r131 = (AppletApplication) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L24:
        AppMeta r135 = (AppMeta) r103;
        if (r135 == null) goto L28;
        String r136 = r135.getAppName();
        if (r136 == null) goto L28;
    L29:
        Map<String, ? extends Object> r137 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("app_key", r131.getAppId()), TuplesKt.to("app_name", r136)});
        if (r133 == null) goto L39;
        DouyinGeneralAuthHelper$requestDouyinGeneralAuth$prepareResult$1 r138 = new DouyinGeneralAuthHelper$requestDouyinGeneralAuth$prepareResult$1(r131, null);
        r102.L$0 = r131;
        r102.L$1 = r130;
        r102.L$2 = r129;
        r102.L$3 = r134;
        r102.L$4 = r133;
        r102.L$5 = r136;
        r102.L$6 = r137;
        r102.label = 2;
        Object r139 = r133.f(r138, r102);
        if (r139 != r110) goto L34;
        return r110;
    L34:
        r116 = r134;
        r106 = r136;
        r103 = r139;
        r128 = r133;
        r105 = r137;
        goto L35
    L39:
        r128 = r133;
        r116 = r134;
        r105 = r137;
        r106 = r136;
    L28:
        r136 = r131.j().f36894a;
        goto L29
    L20:
        ResultKt.throwOnFailure(r103);
        r102.L$0 = r210;
        r102.L$1 = r211;
        r102.L$2 = r212;
        r102.L$3 = r213;
        r102.L$4 = r214;
        r102.label = 1;
        Object r140 = r210.k(r102);
        if (r140 != r110) goto L23;
        return r110;
    L23:
        r131 = r210;
        r133 = r214;
        r130 = r211;
        r103 = r140;
        r129 = r212;
        r134 = r213;
    L7:
        r100 = new DouyinGeneralAuthHelper$requestDouyinGeneralAuth$1(this, r215);
        goto L8
    }

    public final Object d(String r110, String r111, Map<String, ? extends Object> r112, u2.i r210, String r211, ContainerType r212, AppletAuthTaskMonitor.Session r213, Continuation<? super d> r214) {
        if ((r214 instanceof DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1) == false) goto L7;
        DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1 r100 = (DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        g2.b r105 = (g2.b) r100.L$5;
        AppletAuthTaskMonitor.Session r106 = (AppletAuthTaskMonitor.Session) r100.L$4;
        u2.i r107 = (u2.i) r100.L$3;
        Map r108 = (Map) r100.L$2;
        String r109 = (String) r100.L$1;
        String r113 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14
    L41:
        d r114 = (d) r102;     // Catch: Throwable -> L14
        if (r106 == null) goto L44;
        r106.c();
    L44:
        return r114;
    L14:
        th = th;
    L47:
        if (r106 == null) goto L49;
        r106.c();
    L49:
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        g.f37637a.d("DouyinGeneralAuthHelper", "requestAppletFirstPartyAuth: authSource: " + r211 + ", containerType: " + r212);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r115 = AppletRuntimeManager.f36749d;
        if (r115 != null) goto L23;
        return new d(GrantingAction.DISMISSED, "aiAbility is null");
    L23:
        if (Intrinsics.areEqual(r211, "detail") == true) goto L25;
    L27:
        boolean r116 = false;
    L28:
        if (r213 == null) goto L50;
        r213.b();
    L50:
        r100.L$0 = r110;     // Catch: Throwable -> L45
        r100.L$1 = r111;     // Catch: Throwable -> L45
        r100.L$2 = r112;     // Catch: Throwable -> L45
        r100.L$3 = r210;     // Catch: Throwable -> L45
        r100.L$4 = r213;     // Catch: Throwable -> L45
        r100.L$5 = r115;     // Catch: Throwable -> L45
        r100.Z$0 = r116;     // Catch: Throwable -> L45
        r100.label = 1;     // Catch: Throwable -> L45
        j r117 = new j(IntrinsicsKt.intercepted(r100), 1);     // Catch: Throwable -> L45
        r117.C();     // Catch: Throwable -> L45
        if (r116 == false) goto L34;
        boolean r118 = true;
    L35:
        r115.Q(r110, r111, r118, r112, r210, new b(r117));     // Catch: Throwable -> L45
        r102 = r117.B();     // Catch: Throwable -> L45
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        DebugProbesKt.probeCoroutineSuspended(r100);     // Catch: Throwable -> L45
    L38:
        if (r102 != r103) goto L40;
        return r103;
    L40:
        r106 = r213;
        goto L41
    L34:
        r118 = false;
    L45:
        th = th;
        r106 = r213;
        goto L47
    L25:
        if (r212 != ContainerType.PAGE) goto L27;
        r116 = true;
    L7:
        r100 = new DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1(this, r214);
        goto L8
    }
}
