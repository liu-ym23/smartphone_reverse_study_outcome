package com.bytedance.ai.applet.grantingV2;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public final class PrivacyStrategy implements i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f34656d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2.f f34657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u2.j f34658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34659c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object a() {
        return this.f34658b;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.f c() {
        return this.f34657a;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final StrategyType g() {
        return StrategyType.PRIVACY;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Pair<u2.a, String> b(u2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        String r101 = this.f34657a.c();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return j(this, r100, r101);
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c h(f r100) {
        Pair r101 = j(this, r100.f34682c, "refused");
        u2.a r102 = (u2.a) r101.getFirst();
        String r103 = (String) r101.getSecond();
        FlowResult r104 = FlowResult.STOP_FLOW;
        u2.f r105 = this.f34657a;
        if (r103 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L12;
        r103 = this.f34657a.e();
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
        String r101 = this.f34657a.c();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return (u2.a) j(this, r100, r101).getFirst();
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c e(f r100, boolean r110) {
        String r101 = "granted";
        Pair r102 = j(this, r100.f34682c, "granted");
        u2.a r103 = (u2.a) r102.getFirst();
        String r104 = (String) r102.getSecond();
        if (r110 == false) goto L5;
        FlowResult r105 = FlowResult.STOP_FLOW;
    L6:
        FlowResult r106 = r105;
        u2.f r107 = this.f34657a;
        if (r110 == false) goto L9;
        r101 = "granted_by_history";
    L9:
        if (r104 != null) goto L11;
    L14:
        boolean r111 = true;
    L15:
        if (r111 == false) goto L18;
        r104 = this.f34657a.e();
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
        u2.j r104 = this.f34658b;
        AppletAuthTaskMonitor.Session r105 = r100.f34688i;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "appMeta");
        Intrinsics.checkNotNullParameter(r104, "relatedData");
        LoginProcessor.f(r103, r104, null, "chat", r105);
        return Unit.INSTANCE;
    }

    public PrivacyStrategy(u2.f r100, u2.j r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "relatedData");
        this.f34657a = r100;
        this.f34658b = r101;
        this.f34659c = r102;
    }

    public static Pair j(PrivacyStrategy r110, u2.c r111, String r112) {
        b r100 = g.a(r112, r110.f34659c);
        if (r100 == null) goto L6;
    L51:
        u2.b r101 = r111.f548391f;
        y r102 = new y();
        String r103 = r111.f548388c;
        String r104 = r111.f548387b;
        com.bytedance.ai.utils.l r105 = com.bytedance.ai.utils.l.f37675a;
        String r113 = com.bytedance.ai.utils.l.e(r105, "larus_appEntry_chatCard_title_useApp");
        if (r113 == null) goto L59;
        Object[] r114 = new Object[2];
        String r115 = com.bytedance.ai.utils.l.e(r105, "larus_LarkIM_Common_Doubao_Brandname");
        if (r115 != null) goto L56;
        r115 = "豆包";
    L56:
        r114[0] = r115;
        r114[1] = r111.f548387b;
        String r106 = String.format(r113, Arrays.copyOf(r114, 2));
        if (r106 == null) goto L59;
        String r116 = r106;
    L60:
        String r117 = r100.f34671a;
        boolean r118 = r100.f34672b;
        String r107 = com.bytedance.ai.utils.l.e(r105, "larus_appEntry_chatCard_btn_continue");
        if (r107 != null) goto L63;
        r107 = "允许";
    L63:
        String r119 = r107;
        String r108 = com.bytedance.ai.utils.l.e(r105, "larus_appEntry_chatCard_btn_reject");
        if (r108 != null) goto L67;
        r108 = "拒绝";
    L67:
        return new Pair(new u2.a(r101, r102, r103, r104, r116, r117, r118, r119, r108, false, false), null);
    L59:
        r116 = "在豆包内使用" + r111.f548387b;
        goto L60
    L6:
        switch(r112.hashCode()) {
            case -682587753: goto L41;
            case 280295099: goto L31;
            case 664583344: goto L28;
            case 1085547216: goto L18;
            case 1100137118: goto L15;
            case 1234912329: goto L12;
            case 2084348283: goto L9;
            default: goto L49;
        };
    L49:
        com.bytedance.ai.utils.g.f37637a.w("PrivacyStrategyV2", "calculateCardUIState unknown status: ".concat(r112));
        b r109 = new b("状态异常，请重试", false);
    L50:
        r100 = r109;
        goto L51
    L9:
        if (r112.equals("refused_by_history") == false) goto L49;
    L20:
        String r120 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_desc_rejectPolicy");
        if (r120 == null) goto L25;
        String r121 = String.format(r120, Arrays.copyOf(new Object[]{r111.f548387b}, 1));
        if (r121 == null) goto L25;
    L26:
        r109 = new b(r121, false);
    L25:
        r121 = "已拒绝" + r111.f548387b + "的隐私协议";
        goto L26
    L12:
        if (r112.equals("granted_stopped") == false) goto L49;
    L33:
        String r122 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_desc_policyAgreed");
        if (r122 == null) goto L38;
        String r123 = String.format(r122, Arrays.copyOf(new Object[]{r111.f548387b}, 1));
        if (r123 == null) goto L38;
    L39:
        r109 = new b(r123, false);
    L38:
        r123 = "已同意" + r111.f548387b + "的隐私协议";
        goto L39
    L15:
        if (r112.equals("revoked") == false) goto L49;
    L43:
        String r124 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_desc_agreePolicy");
        if (r124 == null) goto L47;
        String r125 = String.format(r124, Arrays.copyOf(new Object[]{r111.f548387b}, 1));
        if (r125 == null) goto L47;
    L48:
        r109 = new b(r125, true);
    L47:
        r125 = "需同意" + r111.f548387b + "的隐私协议";
        goto L48
    L18:
        if (r112.equals("refused") == true) goto L20;
    L28:
        if (r112.equals("granted_by_history") == true) goto L33;
    L31:
        if (r112.equals("granted") == true) goto L33;
    L41:
        if (r112.equals(AiBotPollingAuthResult.STATUS_PENDING) == true) goto L43;
        goto L43
    }

    public final Object k(String r100, String r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof PrivacyStrategy$fetchWhetherAgree$1) == false) goto L7;
        PrivacyStrategy$fetchWhetherAgree$1 r103 = (PrivacyStrategy$fetchWhetherAgree$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L17;
        if (r107 != 1) goto L16;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L13
    L21:
        boolean r108 = ((Boolean) r105).booleanValue();     // Catch: Exception -> L13
    L25:
        return Boxing.boxBoolean(r108);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r109 = Dispatchers.getIO();     // Catch: Exception -> L13
        PrivacyStrategy$fetchWhetherAgree$2 r110 = new PrivacyStrategy$fetchWhetherAgree$2(r100, r101, null);     // Catch: Exception -> L13
        r103.label = 1;     // Catch: Exception -> L13
        r105 = BuildersKt.withContext(r109, r110, r103);     // Catch: Exception -> L13
        if (r105 != r106) goto L21;
        return r106;
    L13:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("PrivacyStrategyV2", "fetchWhetherAgree failed: " + e.getMessage(), e);
        r108 = false;
    L7:
        r103 = new PrivacyStrategy$fetchWhetherAgree$1(this, r102);
        goto L8
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object d(f r210, boolean r211, boolean r212, Continuation<? super com.bytedance.ai.applet.grantingV2.a> r213) {
        f r100 = r210;
        boolean r101 = r211;
        boolean r102 = r212;
        if ((r213 instanceof PrivacyStrategy$onGrantingIntent$1) == false) goto L7;
        PrivacyStrategy$onGrantingIntent$1 r103 = (PrivacyStrategy$onGrantingIntent$1) r213;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        u2.a r109 = null;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        boolean r110 = r103.Z$1;
        r101 = r103.Z$0;
        u2.c r111 = (u2.c) r103.L$1;
        f r112 = (f) r103.L$0;
        ResultKt.throwOnFailure(r105);
        r102 = r110;
        r100 = r112;
        Object r113 = r105;
        u2.c r114 = r111;
    L25:
        boolean r115 = ((Boolean) r113).booleanValue();
    L27:
        if (r115 == false) goto L29;
        String r116 = "granted";
    L30:
        com.bytedance.ai.utils.g.f37637a.i("PrivacyStrategyV2", "onGrantingIntent: serverStatus=" + r116 + ", granted=" + r101 + ", isHistory=" + r102 + ", required=" + this.f34657a.f());
        String r117 = "refused";
        if (Intrinsics.areEqual(r116, "granted") == false) goto L66;
        String r118 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_toast_agreedPolicy");
        if (r118 != null) goto L35;
        r118 = "你此前已完成授权";
    L35:
        String r119 = r118;
        Pair r120 = j(this, r114, "granted");
        u2.a r121 = (u2.a) r120.getFirst();
        String r122 = (String) r120.getSecond();
        if (r101 == false) goto L56;
        if (r102 == false) goto L47;
        FlowResult r123 = FlowResult.STOP_FLOW;
        u2.f r124 = this.f34657a;
        if (r122 != null) goto L41;
    L44:
        if (r108 == false) goto L46;
        r122 = this.f34657a.e();
    L46:
        com.bytedance.ai.applet.grantingV2.a r125 = new com.bytedance.ai.applet.grantingV2.a(r123, "SUCCESS", r119, r121, u2.f.a(r124, "granted_by_history", r122, 7));
    L65:
        return r125;
    L41:
        if (r122.length() == 0) goto L44;
        r108 = false;
        goto L44
    L47:
        FlowResult r126 = FlowResult.CONTINUE_NEXT;
        u2.f r127 = this.f34657a;
        if (r122 != null) goto L50;
    L53:
        if (r108 == false) goto L55;
        r122 = this.f34657a.e();
    L55:
        r125 = new com.bytedance.ai.applet.grantingV2.a(r126, "SUCCESS", r119, r121, u2.f.a(r127, "granted", r122, 7));
        goto L65
    L50:
        if (r122.length() == 0) goto L53;
        r108 = false;
        goto L53
    L56:
        FlowResult r128 = FlowResult.STOP_FLOW;
        u2.f r129 = this.f34657a;
        if (r122 != null) goto L59;
    L62:
        if (r108 == false) goto L64;
        r122 = this.f34657a.e();
    L64:
        r125 = new com.bytedance.ai.applet.grantingV2.a(r128, "WARNING", r119, r121, u2.f.a(r129, "refused", r122, 7));
        goto L65
    L59:
        if (r122.length() == 0) goto L62;
        r108 = false;
        goto L62
    L66:
        if (r101 == false) goto L71;
        u2.a r130 = r100.f34687h;
        if (r130 == null) goto L83;
        r109 = u2.a.a(r130, true, false, 1535);
    L83:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, null, null, r109, null);
    L71:
        Pair r131 = j(this, r114, "refused");
        u2.a r132 = (u2.a) r131.getFirst();
        String r133 = (String) r131.getSecond();
        FlowResult r134 = FlowResult.STOP_FLOW;
        u2.f r135 = this.f34657a;
        if (r102 == false) goto L74;
        r117 = "refused_by_history";
    L74:
        if (r133 != null) goto L76;
    L79:
        if (r108 == false) goto L82;
        r133 = this.f34657a.e();
    L82:
        return new com.bytedance.ai.applet.grantingV2.a(r134, null, null, r132, u2.f.a(r135, r117, r133, 7));
    L76:
        if (r133.length() == 0) goto L79;
        r108 = false;
        goto L79
    L29:
        r116 = AiBotPollingAuthResult.STATUS_PENDING;
        goto L30
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r136 = r103.Z$1;
        r101 = r103.Z$0;
        u2.c r137 = (u2.c) r103.L$1;
        f r138 = (f) r103.L$0;
        ResultKt.throwOnFailure(r105);
        r102 = r136;
        r100 = r138;
        Object r139 = r105;
        r114 = r137;
    L21:
        r115 = ((Boolean) r139).booleanValue();
        goto L27
    L16:
        ResultKt.throwOnFailure(r105);
        r114 = r100.f34682c;
        AppletAuthTaskMonitor.Session r140 = r100.f34688i;
        if (r140 == null) goto L22;
        PrivacyStrategy$onGrantingIntent$hasAgreed$1 r141 = new PrivacyStrategy$onGrantingIntent$hasAgreed$1(this, r114, null);
        r103.L$0 = r100;
        r103.L$1 = r114;
        r103.Z$0 = r101;
        r103.Z$1 = r102;
        r103.label = 1;
        r139 = r140.f(r141, r103);
        if (r139 != r106) goto L21;
        return r106;
    L22:
        String r142 = r114.f548386a;
        String r143 = r114.f548389d;
        r103.L$0 = r100;
        r103.L$1 = r114;
        r103.Z$0 = r101;
        r103.Z$1 = r102;
        r103.label = 2;
        r113 = k(r142, r143, r103);
        if (r113 != r106) goto L25;
        return r106;
    L7:
        r103 = new PrivacyStrategy$onGrantingIntent$1(this, r213);
        goto L8
    }
}
