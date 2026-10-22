package com.bytedance.ai.applet.grantingV2;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes43.dex */
public final class QSMusicLoginStrategy implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2.f f34660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u2.l f34661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34662c;

    public static final class a {
    }

    public static final class b implements u2.h {
        public b() {
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object a() {
        return this.f34661b;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.f c() {
        return this.f34660a;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final StrategyType g() {
        return StrategyType.QS_MUSIC_LOGIN;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Pair<u2.a, String> b(u2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        String r101 = this.f34660a.c();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return k(r100, r101, null);
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c h(f r100) {
        Pair<u2.a, String> r101 = k(r100.f34682c, "refused", null);
        u2.a r102 = r101.getFirst();
        String r103 = r101.getSecond();
        FlowResult r104 = FlowResult.STOP_FLOW;
        u2.f r105 = this.f34660a;
        if (r103 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L12;
        r103 = this.f34660a.e();
    L12:
        return new c(r104, null, null, r102, u2.f.a(r105, "refused", r103, 7));
    L5:
        if (r103.length() == 0) goto L8;
        r106 = false;
        goto L9
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.a i(u2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        String r101 = this.f34660a.c();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = this.f34661b.f();
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        return k(r100, r101, r102).getFirst();
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c e(f r100, boolean r110) {
        String r101 = "granted";
        Pair<u2.a, String> r102 = k(r100.f34682c, "granted", null);
        u2.a r103 = r102.getFirst();
        String r104 = r102.getSecond();
        if (r110 == false) goto L5;
        FlowResult r105 = FlowResult.STOP_FLOW;
    L6:
        FlowResult r106 = r105;
        u2.f r107 = this.f34660a;
        if (r110 == false) goto L9;
        r101 = "granted_by_history";
    L9:
        if (r104 != null) goto L11;
    L14:
        boolean r111 = true;
    L15:
        if (r111 == false) goto L18;
        r104 = this.f34660a.e();
    L18:
        return new c(r106, null, null, r103, u2.f.a(r107, r101, r104, 7));
    L11:
        if (r104.length() == 0) goto L14;
        r111 = false;
        goto L15
    L5:
        r105 = FlowResult.CONTINUE_NEXT;
        goto L6
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object f(f r210, Continuation<? super Unit> r211) {
        int r100 = com.bytedance.ai.applet.login.r.f34788a;
        final u2.c r101 = r210.f34682c;
        u2.l r102 = this.f34661b;
        final AppletAuthTaskMonitor.Session r103 = r210.f34688i;
        Intrinsics.checkNotNullParameter(r101, "appMeta");
        Intrinsics.checkNotNullParameter(r102, "relatedData");
        String r104 = r102.b();
        boolean r105 = false;
        if (r104 != null) goto L5;
    L8:
        boolean r106 = true;
    L10:
        if (r106 == false) goto L14;
        com.bytedance.ai.utils.g.f37637a.e("QSMusicLoginProcessor", "handleAgree: authLink empty.");
        if (r103 == null) goto L49;
        r103.d(new AppletAuthTaskMonitor.a("failed", "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "authLink empty", null, null, null, 480));
    L49:
        return Unit.INSTANCE;
    L14:
        int r107 = com.bytedance.ai.applet.login.a.f34736a;
        com.bytedance.ai.applet.login.c r108 = com.bytedance.ai.applet.login.a.a(r102.b());
        String r109 = r108.f34740d;
        String r110 = r108.f34742f;
        String r111 = r108.f34739c;
        if (r109 != null) goto L17;
    L20:
        boolean r112 = true;
    L21:
        if (r112 == true) goto L45;
        if (r110 != null) goto L24;
    L27:
        boolean r113 = true;
    L28:
        if (r113 == true) goto L45;
        if (r111 != null) goto L31;
    L32:
        r105 = true;
    L33:
        if (r105 == true) goto L45;
        u2.b r114 = r101.f548391f;
        final String r115 = r114.f548379a;
        HashMap<String, Object> r116 = r114.f548385g;
        HashMap r117 = new HashMap();
        if (r116 == null) goto L38;
        r117.putAll(r116);
    L38:
        r117.put("current_page", "chat");
        r117.put("source", "doubao_apps_auth_request");
        r117.put("app_key", r101.f548386a);
        r117.put("app_name", r101.f548387b);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r118 = AppletRuntimeManager.f36749d;
        if (r118 != null) goto L42;
        if (r103 == null) goto L49;
        r103.d(new AppletAuthTaskMonitor.a("failed", "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_request", AppletAuthTaskMonitor.ErrorCode.CONTEXT_MISSING, "aiAbility is null", null, null, null, 480));
        goto L49
    L42:
        if (r103 == null) goto L44;
        r103.b();
    L44:
        r118.H(new com.bytedance.ai.applet.login.i(r109, r110, r111, r117), new com.bytedance.ai.applet.login.q(r103, r115, r101));
        goto L49
    L31:
        if (StringsKt.isBlank(r111) == false) goto L33;
    L24:
        if (StringsKt.isBlank(r110) == true) goto L27;
        r113 = false;
    L45:
        com.bytedance.ai.utils.g.f37637a.e("QSMusicLoginProcessor", "handleAgree: authLink format error");
        if (r103 == null) goto L49;
        r103.d(new AppletAuthTaskMonitor.a("failed", "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "authLink format error", null, null, null, 480));
        goto L49
    L17:
        if (StringsKt.isBlank(r109) == true) goto L20;
        r112 = false;
        goto L21
    L5:
        if (StringsKt.isBlank(r104) == true) goto L8;
        r106 = false;
        goto L10
    }

    public QSMusicLoginStrategy(u2.f r100, u2.l r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "relatedData");
        this.f34660a = r100;
        this.f34661b = r101;
        this.f34662c = r102;
    }

    public static final Object j(QSMusicLoginStrategy r100, String r101, Continuation r102) {
        r100.getClass();
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r103 = AppletRuntimeManager.f36749d;
        if (r103 != null) goto L5;
        com.bytedance.ai.utils.g.f37637a.e("QSMusicLoginStrategyV2", "fetchQSMusicLoginStatus failed: aiAbility is null");
        return Boxing.boxBoolean(false);
    L5:
        kotlinx.coroutines.j r104 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r104.C();
        b0 r105 = new b0(r104);
        com.bytedance.ai.utils.g.f37637a.i("QSMusicLoginStrategyV2", "fetchQSMusicLoginStatus for " + r101 + "...");
        r103.c(r105);
        r104.i(new a0(r101));
        Object r106 = r104.B();
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r102);
        return r106;
    L10:
        return r106;
    }

    public final Pair<u2.a, String> k(u2.c r110, String r111, String r210) {
        com.bytedance.ai.applet.grantingV2.b r100 = g.a(r111, this.f34662c);
        if (r100 == null) goto L6;
    L55:
        if (r210 == null) goto L57;
    L59:
        String r101 = null;
    L60:
        u2.b r102 = r110.f548391f;
        b r103 = new b();
        String r104 = r110.f548388c;
        String r105 = r110.f548387b;
        String r106 = this.f34661b.g();
        if (r106 != null) goto L63;
        String r112 = "在豆包内使用" + r110.f548387b;
    L64:
        String r113 = r100.f34671a;
        boolean r114 = r100.f34672b;
        String r107 = this.f34661b.c();
        if (r107 != null) goto L67;
        r107 = "登录";
    L67:
        String r115 = r107;
        String r108 = this.f34661b.d();
        if (r108 != null) goto L71;
        r108 = "不登录";
    L71:
        return new Pair(new u2.a(r102, r103, r104, r105, r112, r113, r114, r115, r108, false, false), r101);
    L63:
        r112 = r106;
        goto L64
    L57:
        if (Intrinsics.areEqual(r100.f34671a, this.f34661b.f()) == true) goto L59;
        Lazy r109 = com.bytedance.ai.applet.base.gson.e.f34515a;
        r101 = com.bytedance.ai.applet.base.gson.e.c(u2.l.a(this.f34661b, null, null, r100.f34671a, null, null, null, 251));
        goto L60
    L6:
        switch(r111.hashCode()) {
            case -682587753: goto L44;
            case 280295099: goto L31;
            case 664583344: goto L28;
            case 1085547216: goto L18;
            case 1100137118: goto L15;
            case 1234912329: goto L12;
            case 2084348283: goto L9;
            default: goto L53;
        };
    L53:
        com.bytedance.ai.utils.g.f37637a.w("QSMusicLoginStrategyV2", "calculateCardUIState unknown status: ".concat(r111));
        com.bytedance.ai.applet.grantingV2.b r116 = new com.bytedance.ai.applet.grantingV2.b("状态异常，请重试", false);
    L54:
        r100 = r116;
        goto L55
    L9:
        if (r111.equals("refused_by_history") == false) goto L53;
    L21:
        if (r210 != null) goto L25;
        String r117 = this.f34661b.e();
        if (r117 != null) goto L26;
        r117 = "已拒绝登录汽水音乐";
    L26:
        r116 = new com.bytedance.ai.applet.grantingV2.b(r117, false);
        goto L54
    L25:
        r117 = r210;
        goto L26
    L12:
        if (r111.equals("granted_stopped") == false) goto L53;
    L34:
        if (r210 != null) goto L41;
        String r118 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_desc_loggedIn");
        if (r118 == null) goto L40;
        String r119 = String.format(r118, Arrays.copyOf(new Object[]{r110.f548387b}, 1));
        if (r119 == null) goto L40;
    L42:
        r116 = new com.bytedance.ai.applet.grantingV2.b(r119, false);
    L40:
        r119 = "已登录" + r110.f548387b;
        goto L42
    L41:
        r119 = r210;
        goto L42
    L15:
        if (r111.equals("revoked") == false) goto L53;
    L47:
        if (r210 != null) goto L51;
        String r120 = this.f34661b.f();
        if (r120 != null) goto L52;
        r120 = "登录后获取更优质的音乐体验";
    L52:
        r116 = new com.bytedance.ai.applet.grantingV2.b(r120, true);
        goto L54
    L51:
        r120 = r210;
        goto L52
    L18:
        if (r111.equals("refused") == true) goto L21;
    L28:
        if (r111.equals("granted_by_history") == true) goto L34;
    L31:
        if (r111.equals("granted") == true) goto L34;
    L44:
        if (r111.equals(AiBotPollingAuthResult.STATUS_PENDING) == true) goto L47;
        goto L53
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object d(f r110, boolean r210, boolean r211, Continuation<? super com.bytedance.ai.applet.grantingV2.a> r212) {
        f r100 = r110;
        if ((r212 instanceof QSMusicLoginStrategy$onGrantingIntent$1) == false) goto L7;
        QSMusicLoginStrategy$onGrantingIntent$1 r101 = (QSMusicLoginStrategy$onGrantingIntent$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        u2.a r107 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        boolean r108 = r101.Z$1;
        boolean r109 = r101.Z$0;
        u2.c r111 = (u2.c) r101.L$1;
        f r112 = (f) r101.L$0;
        ResultKt.throwOnFailure(r103);
        boolean r113 = r108;
        r100 = r112;
    L18:
        Boolean r114 = (Boolean) r103;
        if (r114 == null) goto L21;
        boolean r115 = r114.booleanValue();
    L23:
        if (r115 == false) goto L25;
        String r116 = "granted";
    L26:
        com.bytedance.ai.utils.g.f37637a.i("QSMusicLoginStrategyV2", "onGrantingIntent: serverStatus=" + r116 + ", granted=" + r109 + ", isHistory=" + r113 + ", required=" + this.f34660a.f());
        String r117 = "refused";
        if (Intrinsics.areEqual(r116, "granted") == false) goto L62;
        String r118 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_toast_loggedIn");
        if (r118 != null) goto L31;
        r118 = "你此前已完成登录";
    L31:
        String r119 = r118;
        Pair<u2.a, String> r120 = k(r111, "granted", null);
        u2.a r121 = r120.getFirst();
        String r122 = r120.getSecond();
        if (r109 == false) goto L52;
        if (r113 == false) goto L43;
        FlowResult r123 = FlowResult.STOP_FLOW;
        u2.f r124 = this.f34660a;
        if (r122 != null) goto L37;
    L40:
        if (r106 == false) goto L42;
        r122 = this.f34660a.e();
    L42:
        com.bytedance.ai.applet.grantingV2.a r125 = new com.bytedance.ai.applet.grantingV2.a(r123, "SUCCESS", r119, r121, u2.f.a(r124, "granted_by_history", r122, 7));
    L61:
        return r125;
    L37:
        if (r122.length() == 0) goto L40;
        r106 = false;
        goto L40
    L43:
        FlowResult r126 = FlowResult.CONTINUE_NEXT;
        u2.f r127 = this.f34660a;
        if (r122 != null) goto L46;
    L49:
        if (r106 == false) goto L51;
        r122 = this.f34660a.e();
    L51:
        r125 = new com.bytedance.ai.applet.grantingV2.a(r126, "SUCCESS", r119, r121, u2.f.a(r127, "granted", r122, 7));
        goto L61
    L46:
        if (r122.length() == 0) goto L49;
        r106 = false;
        goto L49
    L52:
        FlowResult r128 = FlowResult.STOP_FLOW;
        u2.f r129 = this.f34660a;
        if (r122 != null) goto L55;
    L58:
        if (r106 == false) goto L60;
        r122 = this.f34660a.e();
    L60:
        r125 = new com.bytedance.ai.applet.grantingV2.a(r128, "WARNING", r119, r121, u2.f.a(r129, "refused", r122, 7));
        goto L61
    L55:
        if (r122.length() == 0) goto L58;
        r106 = false;
        goto L58
    L62:
        if (r109 == false) goto L67;
        u2.a r130 = r100.f34687h;
        if (r130 == null) goto L79;
        r107 = u2.a.a(r130, true, false, 1535);
    L79:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, null, null, r107, null);
    L67:
        Pair<u2.a, String> r131 = k(r111, "refused", null);
        u2.a r132 = r131.getFirst();
        String r133 = r131.getSecond();
        FlowResult r134 = FlowResult.STOP_FLOW;
        u2.f r135 = this.f34660a;
        if (r113 == false) goto L70;
        r117 = "refused_by_history";
    L70:
        if (r133 != null) goto L72;
    L75:
        if (r106 == false) goto L78;
        r133 = this.f34660a.e();
    L78:
        return new com.bytedance.ai.applet.grantingV2.a(r134, null, null, r132, u2.f.a(r135, r117, r133, 7));
    L72:
        if (r133.length() == 0) goto L75;
        r106 = false;
        goto L75
    L25:
        r116 = AiBotPollingAuthResult.STATUS_PENDING;
        goto L26
    L21:
        r115 = false;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r111 = r100.f34682c;
        QSMusicLoginStrategy$onGrantingIntent$hasLogin$1 r136 = new QSMusicLoginStrategy$onGrantingIntent$hasLogin$1(r100, this, r111, null);
        r101.L$0 = r100;
        r101.L$1 = r111;
        r101.Z$0 = r210;
        r113 = r211;
        r101.Z$1 = r113;
        r101.label = 1;
        r103 = TimeoutKt.c(1000, r136, r101);
        if (r103 != r104) goto L17;
        return r104;
    L17:
        r109 = r210;
    L7:
        r101 = new QSMusicLoginStrategy$onGrantingIntent$1(this, r212);
        goto L8
    }
}
