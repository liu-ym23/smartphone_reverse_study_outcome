package com.bytedance.ai.applet.grantingV2;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class LoginStrategy implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2.f f34641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u2.j f34642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34643c;

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
        return this.f34642b;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.f c() {
        return this.f34641a;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final StrategyType g() {
        return StrategyType.LOGIN;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Pair<u2.a, String> b(u2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        String r101 = this.f34641a.c();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return j(r100, r101, null);
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c h(f r100) {
        Pair<u2.a, String> r101 = j(r100.f34682c, "refused", null);
        u2.a r102 = r101.getFirst();
        String r103 = r101.getSecond();
        FlowResult r104 = FlowResult.STOP_FLOW;
        u2.f r105 = this.f34641a;
        if (r103 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L12;
        r103 = this.f34641a.e();
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
        String r101 = this.f34641a.c();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = this.f34642b.b();
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        return j(r100, r101, r102).getFirst();
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c e(f r100, boolean r110) {
        String r101 = "granted";
        Pair<u2.a, String> r102 = j(r100.f34682c, "granted", null);
        u2.a r103 = r102.getFirst();
        String r104 = r102.getSecond();
        if (r110 == false) goto L5;
        FlowResult r105 = FlowResult.STOP_FLOW;
    L6:
        FlowResult r106 = r105;
        u2.f r107 = this.f34641a;
        if (r110 == false) goto L9;
        r101 = "granted_by_history";
    L9:
        if (r104 != null) goto L11;
    L14:
        boolean r111 = true;
    L15:
        if (r111 == false) goto L18;
        r104 = this.f34641a.e();
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
    public final Object f(f r100, Continuation<? super Unit> r101) {
        LoginProcessor r102 = LoginProcessor.f34725a;
        u2.c r103 = r100.f34682c;
        u2.j r104 = this.f34642b;
        AppletAuthTaskMonitor.Session r105 = r100.f34688i;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "appMeta");
        Intrinsics.checkNotNullParameter(r104, "relatedData");
        LoginProcessor.e(r103, r104, null, "chat", r105);
        return Unit.INSTANCE;
    }

    public LoginStrategy(u2.f r100, u2.j r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "relatedData");
        this.f34641a = r100;
        this.f34642b = r101;
        this.f34643c = r102;
    }

    public final Pair<u2.a, String> j(u2.c r210, String r211, String r212) {
        com.bytedance.ai.applet.grantingV2.b r100 = g.a(r211, this.f34643c);
        String r101 = null;
        if (r100 == null) goto L6;
    L61:
        if (r212 == null) goto L63;
    L65:
        u2.b r102 = r210.f548391f;
        b r103 = new b();
        String r110 = r210.f548388c;
        String r111 = r210.f548387b;
        com.bytedance.ai.utils.l r104 = com.bytedance.ai.utils.l.f37675a;
        String r112 = com.bytedance.ai.utils.l.e(r104, "larus_appEntry_chatCard_title_useApp");
        if (r112 == null) goto L73;
        Object[] r113 = new Object[2];
        String r114 = com.bytedance.ai.utils.l.e(r104, "larus_LarkIM_Common_Doubao_Brandname");
        if (r114 != null) goto L70;
        r114 = "豆包";
    L70:
        r113[0] = r114;
        r113[1] = r210.f548387b;
        String r105 = String.format(r112, Arrays.copyOf(r113, 2));
        if (r105 == null) goto L73;
        String r115 = r105;
    L74:
        String r116 = r100.f34671a;
        boolean r117 = r100.f34672b;
        String r106 = com.bytedance.ai.utils.l.e(r104, "larus_appEntry_chatCard_btn_logIn");
        if (r106 != null) goto L77;
        r106 = "登录";
    L77:
        String r107 = com.bytedance.ai.utils.l.e(r104, "larus_appEntry_chatCard_btn_notNow");
        if (r107 != null) goto L81;
        r107 = "暂不登录";
    L81:
        return new Pair(new u2.a(r102, r103, r110, r111, r115, r116, r117, r106, r107, false, false), r101);
    L73:
        r115 = "在豆包内使用" + r210.f548387b;
        goto L74
    L63:
        if (Intrinsics.areEqual(r100.f34671a, this.f34642b.b()) == true) goto L65;
        Lazy r108 = com.bytedance.ai.applet.base.gson.e.f34515a;
        r101 = com.bytedance.ai.applet.base.gson.e.c(u2.j.a(this.f34642b, null, null, null, null, r100.f34671a, 111));
        goto L65
    L6:
        switch(r211.hashCode()) {
            case -682587753: goto L47;
            case 280295099: goto L34;
            case 664583344: goto L31;
            case 1085547216: goto L18;
            case 1100137118: goto L15;
            case 1234912329: goto L12;
            case 2084348283: goto L9;
            default: goto L59;
        };
    L59:
        com.bytedance.ai.utils.g.f37637a.w("LoginStrategyV2", "calculateCardUIState unknown status: ".concat(r211));
        com.bytedance.ai.applet.grantingV2.b r109 = new com.bytedance.ai.applet.grantingV2.b("状态异常，请重试", false);
    L60:
        r100 = r109;
        goto L61
    L9:
        if (r211.equals("refused_by_history") == false) goto L59;
    L21:
        if (r212 != null) goto L28;
        String r118 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_desc_rejectLogin");
        if (r118 == null) goto L25;
        String r119 = String.format(r118, Arrays.copyOf(new Object[]{r210.f548387b}, 1));
    L26:
        if (r119 != null) goto L29;
        r119 = "已拒绝登录" + r210.f548387b;
    L29:
        r109 = new com.bytedance.ai.applet.grantingV2.b(r119, false);
        goto L60
    L25:
        r119 = null;
        goto L26
    L28:
        r119 = r212;
        goto L29
    L12:
        if (r211.equals("granted_stopped") == false) goto L59;
    L37:
        if (r212 != null) goto L44;
        String r120 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_desc_loggedIn");
        if (r120 == null) goto L41;
        String r121 = String.format(r120, Arrays.copyOf(new Object[]{r210.f548387b}, 1));
    L42:
        if (r121 != null) goto L45;
        r121 = "已登录" + r210.f548387b;
    L45:
        r109 = new com.bytedance.ai.applet.grantingV2.b(r121, false);
        goto L60
    L41:
        r121 = null;
        goto L42
    L44:
        r121 = r212;
        goto L45
    L15:
        if (r211.equals("revoked") == false) goto L59;
    L50:
        if (r212 != null) goto L57;
        String r122 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_desc_logIn");
        if (r122 == null) goto L54;
        String r123 = String.format(r122, Arrays.copyOf(new Object[]{r210.f548387b}, 1));
    L55:
        if (r123 != null) goto L58;
        r123 = "需登录" + r210.f548387b + "后才可以继续使用";
    L58:
        r109 = new com.bytedance.ai.applet.grantingV2.b(r123, true);
        goto L60
    L54:
        r123 = null;
        goto L55
    L57:
        r123 = r212;
        goto L58
    L18:
        if (r211.equals("refused") == true) goto L21;
    L31:
        if (r211.equals("granted_by_history") == true) goto L37;
    L34:
        if (r211.equals("granted") == true) goto L37;
    L47:
        if (r211.equals(AiBotPollingAuthResult.STATUS_PENDING) == true) goto L50;
        goto L59
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object d(f r210, boolean r211, boolean r212, Continuation<? super com.bytedance.ai.applet.grantingV2.a> r213) {
        f r100 = r210;
        if ((r213 instanceof LoginStrategy$onGrantingIntent$1) == false) goto L7;
        LoginStrategy$onGrantingIntent$1 r101 = (LoginStrategy$onGrantingIntent$1) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        boolean r107 = r101.Z$1;
        boolean r108 = r101.Z$0;
        u2.c r109 = (u2.c) r101.L$1;
        f r110 = (f) r101.L$0;
        ResultKt.throwOnFailure(r103);
        boolean r111 = r107;
        r100 = r110;
        Object r112 = r103;
        boolean r113 = r108;
    L18:
        if (((Boolean) r112).booleanValue() == false) goto L20;
        String r114 = "granted";
    L21:
        com.bytedance.ai.utils.g.f37637a.i("LoginStrategyV2", "onGrantingIntent: serverStatus=" + r114 + ", granted=" + r113 + ", isHistory=" + r111 + ", required=" + this.f34641a.f());
        String r115 = "refused";
        u2.a r116 = null;
        if (Intrinsics.areEqual(r114, "granted") == false) goto L54;
        String r117 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_toast_loggedIn");
        if (r117 != null) goto L26;
        r117 = "你此前已完成登录";
    L26:
        String r118 = r117;
        Pair<u2.a, String> r119 = j(r109, "granted", null);
        u2.a r214 = r119.getFirst();
        String r120 = r119.getSecond();
        if (r113 == false) goto L45;
        if (r111 == false) goto L37;
        FlowResult r121 = FlowResult.STOP_FLOW;
        u2.f r122 = this.f34641a;
        if (r120 != null) goto L32;
    L33:
        r106 = true;
    L34:
        if (r106 == false) goto L36;
        r120 = this.f34641a.e();
    L36:
        com.bytedance.ai.applet.grantingV2.a r123 = new com.bytedance.ai.applet.grantingV2.a(r121, "SUCCESS", r118, r214, u2.f.a(r122, "granted_by_history", r120, 7));
    L53:
        return r123;
    L32:
        if (r120.length() != 0) goto L34;
    L37:
        FlowResult r124 = FlowResult.CONTINUE_NEXT;
        u2.f r125 = this.f34641a;
        if (r120 != null) goto L40;
    L41:
        r106 = true;
    L42:
        if (r106 == false) goto L44;
        r120 = this.f34641a.e();
    L44:
        r123 = new com.bytedance.ai.applet.grantingV2.a(r124, null, null, r214, u2.f.a(r125, "granted", r120, 7));
        goto L53
    L40:
        if (r120.length() != 0) goto L42;
    L45:
        FlowResult r126 = FlowResult.STOP_FLOW;
        u2.f r127 = this.f34641a;
        if (r120 != null) goto L48;
    L49:
        r106 = true;
    L50:
        if (r106 == false) goto L52;
        r120 = this.f34641a.e();
    L52:
        r123 = new com.bytedance.ai.applet.grantingV2.a(r126, "WARNING", r118, r214, u2.f.a(r127, "refused", r120, 7));
        goto L53
    L48:
        if (r120.length() != 0) goto L50;
    L54:
        if (r113 == false) goto L59;
        u2.a r128 = r100.f34687h;
        if (r128 == null) goto L70;
        r116 = u2.a.a(r128, true, false, 1535);
    L70:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, null, null, r116, null);
    L59:
        Pair<u2.a, String> r129 = j(r109, "refused", null);
        u2.a r130 = r129.getFirst();
        String r131 = r129.getSecond();
        FlowResult r132 = FlowResult.STOP_FLOW;
        u2.f r133 = this.f34641a;
        if (r111 == false) goto L62;
        r115 = "refused_by_history";
    L62:
        if (r131 != null) goto L64;
    L65:
        r106 = true;
    L66:
        if (r106 == false) goto L69;
        r131 = this.f34641a.e();
    L69:
        return new com.bytedance.ai.applet.grantingV2.a(r132, null, null, r130, u2.f.a(r133, r115, r131, 7));
    L64:
        if (r131.length() != 0) goto L66;
    L20:
        r114 = AiBotPollingAuthResult.STATUS_PENDING;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r109 = r100.f34682c;
        String r134 = r109.f548386a;
        r101.L$0 = r100;
        r101.L$1 = r109;
        r113 = r211;
        r101.Z$0 = r113;
        r111 = r212;
        r101.Z$1 = r111;
        r101.label = 1;
        r112 = Boxing.boxBoolean(false);
        if (r112 != r104) goto L18;
        return r104;
    L7:
        r101 = new LoginStrategy$onGrantingIntent$1(this, r213);
        goto L8
    }
}
