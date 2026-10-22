package com.bytedance.ai.applet.grantingV2;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes43.dex */
public final class FirstPartyLoginStrategy implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f34634e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2.f f34635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u2.d f34636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f34638d;

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
        return this.f34636b;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.f c() {
        return this.f34635a;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final StrategyType g() {
        return StrategyType.FIRST_PARTY_LOGIN;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Pair<u2.a, String> b(u2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        String r101 = this.f34635a.c();
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
        u2.f r105 = this.f34635a;
        if (r103 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L12;
        r103 = this.f34635a.e();
    L12:
        return new c(r104, r102, u2.f.a(r105, "refused", r103, 7));
    L5:
        if (r103.length() == 0) goto L8;
        r106 = false;
        goto L9
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.a i(u2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        String r101 = this.f34635a.c();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = this.f34636b.e();
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        return j(r100, r101, r102).getFirst();
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c e(f r100, boolean r101) {
        String r102 = "granted";
        Pair<u2.a, String> r103 = j(r100.f34682c, "granted", null);
        u2.a r104 = r103.getFirst();
        String r105 = r103.getSecond();
        if (r101 == false) goto L5;
        FlowResult r106 = FlowResult.STOP_FLOW;
    L6:
        u2.f r107 = this.f34635a;
        if (r101 == false) goto L9;
        r102 = "granted_by_history";
    L9:
        if (r105 != null) goto L11;
    L14:
        boolean r108 = true;
    L15:
        if (r108 == false) goto L18;
        r105 = this.f34635a.e();
    L18:
        return new c(r106, r104, u2.f.a(r107, r102, r105, 7));
    L11:
        if (r105.length() == 0) goto L14;
        r108 = false;
        goto L15
    L5:
        r106 = FlowResult.CONTINUE_NEXT;
        goto L6
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object f(f r100, Continuation<? super Unit> r101) {
        Object r102 = DouyinGeneralAuthHelper.f34616a.c(r100.f34682c, this.f34636b, (com.bytedance.ai.applet.login.c) this.f34638d.getValue(), r100.f34688i, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public FirstPartyLoginStrategy(u2.f r100, u2.d r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "relatedData");
        this.f34635a = r100;
        this.f34636b = r101;
        this.f34637c = r102;
        this.f34638d = LazyKt.lazy(new d(this));
    }

    public final Pair<u2.a, String> j(u2.c r210, String r211, String r212) {
        com.bytedance.ai.applet.grantingV2.b r100 = g.a(r211, this.f34637c);
        if (r100 == null) goto L6;
    L58:
        if (r212 == null) goto L60;
    L62:
        String r101 = null;
    L63:
        u2.b r102 = r210.f548391f;
        b r103 = new b();
        String r110 = r210.f548388c;
        String r111 = r210.f548387b;
        com.bytedance.ai.utils.l r104 = com.bytedance.ai.utils.l.f37675a;
        String r112 = com.bytedance.ai.utils.l.e(r104, "larus_appEntry_chatCard_title_useApp");
        if (r112 == null) goto L71;
        Object[] r113 = new Object[2];
        String r114 = com.bytedance.ai.utils.l.e(r104, "larus_LarkIM_Common_Doubao_Brandname");
        if (r114 != null) goto L68;
        r114 = "豆包";
    L68:
        r113[0] = r114;
        r113[1] = r210.f548387b;
        String r105 = String.format(r112, Arrays.copyOf(r113, 2));
        if (r105 == null) goto L71;
        String r115 = r105;
    L72:
        String r116 = r100.f34671a;
        boolean r117 = r100.f34672b;
        String r106 = com.bytedance.ai.utils.l.e(r104, "larus_appEntry_dyAuth_Card_btn_confirm_cn");
        if (r106 != null) goto L75;
        r106 = "登录";
    L75:
        String r107 = com.bytedance.ai.utils.l.e(r104, "larus_appEntry_dyAuth_Card_btn_cancel_cn");
        if (r107 != null) goto L79;
        r107 = "不登录";
    L79:
        return new Pair(new u2.a(r102, r103, r110, r111, r115, r116, r117, r106, r107, false, false), r101);
    L71:
        r115 = "在豆包内使用" + r210.f548387b;
        goto L72
    L60:
        if (Intrinsics.areEqual(r100.f34671a, this.f34636b.e()) == true) goto L62;
        Lazy r108 = com.bytedance.ai.applet.base.gson.e.f34515a;
        r101 = com.bytedance.ai.applet.base.gson.e.c(u2.d.a(this.f34636b, null, r100.f34671a, null, null, 61));
        goto L63
    L6:
        switch(r211.hashCode()) {
            case -682587753: goto L47;
            case 280295099: goto L34;
            case 664583344: goto L31;
            case 1085547216: goto L18;
            case 1100137118: goto L15;
            case 1234912329: goto L12;
            case 2084348283: goto L9;
            default: goto L56;
        };
    L56:
        com.bytedance.ai.utils.g.f37637a.w("FirstPartyLoginStrategyV2", "calculateCardUIState unknown status: ".concat(r211));
        com.bytedance.ai.applet.grantingV2.b r109 = new com.bytedance.ai.applet.grantingV2.b("状态异常，请重试", false);
    L57:
        r100 = r109;
        goto L58
    L9:
        if (r211.equals("refused_by_history") == false) goto L56;
    L21:
        if (r212 != null) goto L28;
        String r118 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_desc_rejectLogin");
        if (r118 == null) goto L27;
        String r119 = String.format(r118, Arrays.copyOf(new Object[]{r210.f548387b}, 1));
        if (r119 == null) goto L27;
    L29:
        r109 = new com.bytedance.ai.applet.grantingV2.b(r119, false);
    L27:
        r119 = "已拒绝登录" + r210.f548387b;
        goto L29
    L28:
        r119 = r212;
        goto L29
    L12:
        if (r211.equals("granted_stopped") == false) goto L56;
    L37:
        if (r212 != null) goto L44;
        String r120 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_desc_loggedIn");
        if (r120 == null) goto L43;
        String r121 = String.format(r120, Arrays.copyOf(new Object[]{r210.f548387b}, 1));
        if (r121 == null) goto L43;
    L45:
        r109 = new com.bytedance.ai.applet.grantingV2.b(r121, false);
    L43:
        r121 = "已登录" + r210.f548387b;
        goto L45
    L44:
        r121 = r212;
        goto L45
    L15:
        if (r211.equals("revoked") == false) goto L56;
    L50:
        if (r212 != null) goto L54;
        String r122 = this.f34636b.e();
        if (r122 != null) goto L55;
        r122 = "登录后继续使用";
    L55:
        r109 = new com.bytedance.ai.applet.grantingV2.b(r122, true);
        goto L57
    L54:
        r122 = r212;
        goto L55
    L18:
        if (r211.equals("refused") == true) goto L21;
    L31:
        if (r211.equals("granted_by_history") == true) goto L37;
    L34:
        if (r211.equals("granted") == true) goto L37;
    L47:
        if (r211.equals(AiBotPollingAuthResult.STATUS_PENDING) == true) goto L50;
        goto L56
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object d(f r110, boolean r210, boolean r211, Continuation<? super com.bytedance.ai.applet.grantingV2.a> r212) {
        f r100 = r110;
        if ((r212 instanceof FirstPartyLoginStrategy$onGrantingIntent$1) == false) goto L7;
        FirstPartyLoginStrategy$onGrantingIntent$1 r101 = (FirstPartyLoginStrategy$onGrantingIntent$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        boolean r107 = r101.Z$1;
        boolean r108 = r101.Z$0;
        u2.c r109 = (u2.c) r101.L$1;
        f r111 = (f) r101.L$0;
        ResultKt.throwOnFailure(r103);
        boolean r112 = r107;
        r100 = r111;
    L22:
        Boolean r113 = (Boolean) r103;
        if (r113 == null) goto L25;
        boolean r114 = r113.booleanValue();
    L27:
        if (r114 == false) goto L29;
        String r115 = "granted";
    L30:
        com.bytedance.ai.utils.g.f37637a.i("FirstPartyLoginStrategyV2", "onGrantingIntent: serverStatus=" + r115 + ", granted=" + r108 + ", isHistory=" + r112 + ", required=" + this.f34635a.f());
        String r116 = "refused";
        if (Intrinsics.areEqual(r115, "granted") == false) goto L66;
        String r117 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_toast_loggedIn");
        if (r117 != null) goto L35;
        r117 = "你此前已完成登录";
    L35:
        String r118 = r117;
        Pair<u2.a, String> r119 = j(r109, "granted", null);
        u2.a r120 = r119.getFirst();
        String r121 = r119.getSecond();
        if (r108 == false) goto L56;
        if (r112 == false) goto L47;
        FlowResult r122 = FlowResult.STOP_FLOW;
        u2.f r123 = this.f34635a;
        if (r121 != null) goto L41;
    L44:
        if (r106 == false) goto L46;
        r121 = this.f34635a.e();
    L46:
        com.bytedance.ai.applet.grantingV2.a r124 = new com.bytedance.ai.applet.grantingV2.a(r122, "SUCCESS", r118, r120, u2.f.a(r123, "granted_by_history", r121, 7));
    L65:
        return r124;
    L41:
        if (r121.length() == 0) goto L44;
        r106 = false;
        goto L44
    L47:
        FlowResult r125 = FlowResult.CONTINUE_NEXT;
        u2.f r126 = this.f34635a;
        if (r121 != null) goto L50;
    L53:
        if (r106 == false) goto L55;
        r121 = this.f34635a.e();
    L55:
        r124 = new com.bytedance.ai.applet.grantingV2.a(r125, "SUCCESS", r118, r120, u2.f.a(r126, "granted", r121, 7));
        goto L65
    L50:
        if (r121.length() == 0) goto L53;
        r106 = false;
        goto L53
    L56:
        FlowResult r127 = FlowResult.STOP_FLOW;
        u2.f r128 = this.f34635a;
        if (r121 != null) goto L59;
    L62:
        if (r106 == false) goto L64;
        r121 = this.f34635a.e();
    L64:
        r124 = new com.bytedance.ai.applet.grantingV2.a(r127, "WARNING", r118, r120, u2.f.a(r128, "refused", r121, 7));
        goto L65
    L59:
        if (r121.length() == 0) goto L62;
        r106 = false;
        goto L62
    L66:
        if (r108 == false) goto L72;
        u2.a r129 = r100.f34687h;
        if (r129 == null) goto L70;
        u2.a r130 = u2.a.a(r129, true, false, 1535);
    L84:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, r130, null);
    L70:
        r130 = null;
        goto L84
    L72:
        Pair<u2.a, String> r131 = j(r109, "refused", null);
        u2.a r132 = r131.getFirst();
        String r133 = r131.getSecond();
        FlowResult r134 = FlowResult.STOP_FLOW;
        u2.f r135 = this.f34635a;
        if (r112 == false) goto L75;
        r116 = "refused_by_history";
    L75:
        if (r133 != null) goto L77;
    L80:
        if (r106 == false) goto L83;
        r133 = this.f34635a.e();
    L83:
        return new com.bytedance.ai.applet.grantingV2.a(r134, r132, u2.f.a(r135, r116, r133, 7));
    L77:
        if (r133.length() == 0) goto L80;
        r106 = false;
        goto L80
    L29:
        r115 = AiBotPollingAuthResult.STATUS_PENDING;
        goto L30
    L25:
        r114 = false;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r109 = r100.f34682c;
        Integer r136 = this.f34636b.f();
        if (r136 == null) goto L17;
        long r137 = r136.intValue();
    L18:
        FirstPartyLoginStrategy$onGrantingIntent$hasLogin$1 r138 = new FirstPartyLoginStrategy$onGrantingIntent$hasLogin$1(r100, this, null);
        r101.L$0 = r100;
        r101.L$1 = r109;
        r101.Z$0 = r210;
        r112 = r211;
        r101.Z$1 = r112;
        r101.label = 1;
        r103 = TimeoutKt.c(r137, r138, r101);
        if (r103 != r104) goto L21;
        return r104;
    L21:
        r108 = r210;
        goto L22
    L17:
        r137 = 1000;
    L7:
        r101 = new FirstPartyLoginStrategy$onGrantingIntent$1(this, r212);
        goto L8
    }
}
