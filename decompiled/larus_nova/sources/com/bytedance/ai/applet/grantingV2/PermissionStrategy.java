package com.bytedance.ai.applet.grantingV2;

import android.content.Context;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public final class PermissionStrategy implements i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f34652d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2.f f34653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u2.k f34654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34655c;

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
        return this.f34654b;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.f c() {
        return this.f34653a;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final StrategyType g() {
        return StrategyType.PERMISSION;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Pair<u2.a, String> b(u2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        String r101 = this.f34653a.c();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return j(r100, r101, null);
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c h(f r100) {
        Pair<u2.a, String> r101 = j(r100.f34682c, "granted_without_system", null);
        u2.a r102 = r101.getFirst();
        String r103 = r101.getSecond();
        if (this.f34653a.f() == false) goto L5;
        FlowResult r104 = FlowResult.STOP_FLOW;
    L6:
        FlowResult r105 = r104;
        u2.f r106 = this.f34653a;
        if (r103 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == false) goto L16;
        r103 = this.f34653a.e();
    L16:
        return new c(r105, null, null, r102, u2.f.a(r106, "granted_without_system", r103, 7));
    L9:
        if (r103.length() == 0) goto L12;
        r107 = false;
        goto L13
    L5:
        r104 = FlowResult.CONTINUE_NEXT;
        goto L6
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.a i(u2.c r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        String r101 = this.f34653a.c();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = this.f34654b.b();
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
        u2.f r107 = this.f34653a;
        if (r110 == false) goto L9;
        r101 = "granted_by_history";
    L9:
        if (r104 != null) goto L11;
    L14:
        boolean r111 = true;
    L15:
        if (r111 == false) goto L18;
        r104 = this.f34653a.e();
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
    public final Object f(final f r110, Continuation<? super Unit> r111) {
        String r112 = this.f34654b.c();
        if (r112 != null) goto L5;
    L8:
        boolean r113 = true;
    L10:
        if (r113 == false) goto L16;
        com.bytedance.ai.utils.g.f37637a.e("PermissionStrategyV2", "requestConfirmation: scopeName empty.");
        AppletAuthTaskMonitor.Session r114 = r110.f34688i;
        if (r114 == null) goto L15;
        r114.d(new AppletAuthTaskMonitor.a("failed", "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "permission_context_check", AppletAuthTaskMonitor.ErrorCode.INVALID_PARAM, "scopeName empty", null, null, null, 480));
    L15:
        return Unit.INSTANCE;
    L16:
        int r115 = com.bytedance.ai.applet.permission.h.f34952a;
        String r116 = com.bytedance.ai.applet.permission.h.b(this.f34654b.c());
        if (r116 != null) goto L23;
        com.bytedance.ai.utils.g.f37637a.e("PermissionStrategyV2", "requestConfirmation: can not find " + this.f34654b.c() + "'s native permission'");
        AppletAuthTaskMonitor.Session r117 = r110.f34688i;
        if (r117 == null) goto L22;
        r117.d(new AppletAuthTaskMonitor.a("failed", "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "permission_context_check", AppletAuthTaskMonitor.ErrorCode.INVALID_PARAM, "native permission not found for " + this.f34654b.c(), null, null, null, 480));
    L22:
        return Unit.INSTANCE;
    L23:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r100 = AppletRuntimeManager.f36749d;
        if (r100 != null) goto L30;
        com.bytedance.ai.utils.g.f37637a.e("PermissionStrategyV2", "requestConfirmation: aiAbility null.");
        AppletAuthTaskMonitor.Session r118 = r110.f34688i;
        if (r118 == null) goto L29;
        r118.d(new AppletAuthTaskMonitor.a("failed", "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "permission_context_check", AppletAuthTaskMonitor.ErrorCode.CONTEXT_MISSING, "aiAbility is null", null, null, null, 480));
    L29:
        return Unit.INSTANCE;
    L30:
        AppletAuthTaskMonitor.Session r101 = r110.f34688i;
        if (r101 == null) goto L33;
        r101.b();
    L33:
        WeakReference<Context> r102 = r110.f34685f;
        if (r102 == null) goto L36;
        Context r103 = r102.get();
    L37:
        r100.y(r103, r116, new w(r110));
        return Unit.INSTANCE;
    L36:
        r103 = null;
        goto L37
    L5:
        if (StringsKt.isBlank(r112) == true) goto L8;
        r113 = false;
        goto L10
    }

    public PermissionStrategy(u2.f r100, u2.k r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "relatedData");
        this.f34653a = r100;
        this.f34654b = r101;
        this.f34655c = r102;
    }

    public final Pair<u2.a, String> j(u2.c r110, String r111, String r210) {
        com.bytedance.ai.applet.grantingV2.b r100 = g.a(r111, this.f34655c);
        if (r100 != null) goto L57;
        String r101 = this.f34654b.b();
        if (r101 != null) goto L9;
        r101 = "未知的权限描述信息";
    L9:
        switch(r111.hashCode()) {
            case -682587753: goto L48;
            case 280295099: goto L40;
            case 664583344: goto L37;
            case 854280074: goto L29;
            case 1085547216: goto L21;
            case 1100137118: goto L18;
            case 1234912329: goto L15;
            case 2084348283: goto L12;
            default: goto L55;
        };
    L55:
        com.bytedance.ai.utils.g.f37637a.w("PermissionStrategyV2", "calculateCardUIState unknown status: ".concat(r111));
        com.bytedance.ai.applet.grantingV2.b r102 = new com.bytedance.ai.applet.grantingV2.b("状态异常，请重试", false);
    L56:
        r100 = r102;
        goto L57
    L12:
        if (r111.equals("refused_by_history") == false) goto L55;
    L24:
        if (r210 != null) goto L26;
        String r103 = "已拒绝" + r110.f548387b + "获取";
    L27:
        r102 = new com.bytedance.ai.applet.grantingV2.b(r103, false);
        goto L56
    L26:
        r103 = r210;
        goto L27
    L15:
        if (r111.equals("granted_stopped") == false) goto L55;
    L43:
        if (r210 != null) goto L45;
        String r104 = "已允许" + r110.f548387b + "获取";
    L46:
        r102 = new com.bytedance.ai.applet.grantingV2.b(r104, false);
        goto L56
    L45:
        r104 = r210;
        goto L46
    L18:
        if (r111.equals("revoked") == false) goto L55;
    L51:
        if (r210 == null) goto L54;
        r101 = r210;
    L54:
        r102 = new com.bytedance.ai.applet.grantingV2.b(r101, true);
        goto L56
    L21:
        if (r111.equals("refused") == true) goto L24;
    L29:
        if (r111.equals("granted_without_system") == false) goto L55;
        if (r210 != null) goto L34;
        String r105 = "已允许" + r110.f548387b + "获取，但还需开启系统权限";
    L35:
        r102 = new com.bytedance.ai.applet.grantingV2.b(r105, false);
        goto L56
    L34:
        r105 = r210;
        goto L35
    L37:
        if (r111.equals("granted_by_history") == true) goto L43;
    L40:
        if (r111.equals("granted") == true) goto L43;
    L48:
        if (r111.equals(AiBotPollingAuthResult.STATUS_PENDING) == true) goto L51;
    L57:
        if (r210 == null) goto L59;
    L61:
        String r106 = null;
    L62:
        u2.b r107 = r110.f548391f;
        b r108 = new b();
        String r109 = r110.f548388c;
        String r112 = r110.f548387b;
        int r113 = com.bytedance.ai.applet.permission.h.f34952a;
        String r114 = com.bytedance.ai.applet.permission.h.a(this.f34654b.c());
        String r115 = r100.f34671a;
        boolean r116 = r100.f34672b;
        com.bytedance.ai.utils.l r117 = com.bytedance.ai.utils.l.f37675a;
        String r118 = com.bytedance.ai.utils.l.e(r117, "larus_appEntry_chatCard_btn_continue");
        if (r118 != null) goto L65;
        r118 = "允许";
    L65:
        String r119 = r118;
        String r120 = com.bytedance.ai.utils.l.e(r117, "larus_appEntry_chatCard_btn_reject");
        if (r120 != null) goto L69;
        r120 = "拒绝";
    L69:
        return new Pair(new u2.a(r107, r108, r109, r112, r114, r115, r116, r119, r120, false, false), r106);
    L59:
        if (Intrinsics.areEqual(r100.f34671a, this.f34654b.b()) == true) goto L61;
        Lazy r121 = com.bytedance.ai.applet.base.gson.e.f34515a;
        r106 = com.bytedance.ai.applet.base.gson.e.c(u2.k.a(this.f34654b, r100.f34671a));
        goto L62
    }

    public final Object k(String r100, String r101, Continuation<? super GrantStatus> r102) {
        if ((r102 instanceof PermissionStrategy$fetchPermissionDetail$1) == false) goto L7;
        PermissionStrategy$fetchPermissionDetail$1 r103 = (PermissionStrategy$fetchPermissionDetail$1) r102;
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
        return (GrantStatus) r105;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r108 = Dispatchers.getIO();     // Catch: Exception -> L13
        PermissionStrategy$fetchPermissionDetail$2 r109 = new PermissionStrategy$fetchPermissionDetail$2(r100, r101, null);     // Catch: Exception -> L13
        r103.label = 1;     // Catch: Exception -> L13
        r105 = BuildersKt.withContext(r108, r109, r103);     // Catch: Exception -> L13
        if (r105 != r106) goto L21;
        return r106;
    L13:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("PermissionStrategyV2", "fetchPermissionDetail failed: " + e.getMessage(), e);
        return GrantStatus.PENDING;
    L7:
        r103 = new PermissionStrategy$fetchPermissionDetail$1(this, r102);
        goto L8
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object d(f r210, boolean r211, boolean r212, Continuation<? super com.bytedance.ai.applet.grantingV2.a> r213) {
        boolean r100 = r211;
        if ((r213 instanceof PermissionStrategy$onGrantingIntent$1) == false) goto L7;
        PermissionStrategy$onGrantingIntent$1 r101 = (PermissionStrategy$onGrantingIntent$1) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        PermissionStrategy$onGrantingIntent$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        ResultKt.throwOnFailure(r104);
    L106:
        return r104;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r107 = r103.Z$1;
        r100 = r103.Z$0;
        String r108 = (String) r103.L$2;
        u2.c r109 = (u2.c) r103.L$1;
        f r110 = (f) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L34:
        GrantStatus r111 = (GrantStatus) r104;
    L29:
        f r214 = r110;
        boolean r112 = r107;
        GrantStatus r113 = r111;
        String r114 = r108;
        u2.c r115 = r109;
        boolean r116 = r100;
        if (r113 == null) goto L51;
        Intrinsics.checkNotNullParameter(r113, "<this>");
        int r117 = u2.g.a.f548392a[r113.ordinal()];
        if (r117 != 1) goto L40;
        String r118 = AiBotPollingAuthResult.STATUS_PENDING;
    L52:
        com.bytedance.ai.utils.g r119 = com.bytedance.ai.utils.g.f37637a;
        r119.i("PermissionStrategyV2", "onGrantingIntent: serverStatus=" + r118 + ", granted=" + r116 + ", isHistory=" + r112 + ", required=" + this.f34653a.f());
        if (Intrinsics.areEqual(r118, "granted") == false) goto L86;
        String r120 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.f37675a, "larus_appEntry_chatCard_toast_agreedPolicy");
        if (r120 != null) goto L57;
        r120 = "你此前已完成授权";
    L57:
        String r215 = r120;
        Pair<u2.a, String> r121 = j(r115, "granted", null);
        u2.a r216 = r121.getFirst();
        String r122 = r121.getSecond();
        if (r116 == false) goto L75;
        if (r112 == false) goto L70;
        FlowResult r123 = FlowResult.STOP_FLOW;
        u2.f r124 = this.f34653a;
        if (r122 != null) goto L63;
    L66:
        boolean r125 = true;
    L67:
        if (r125 == false) goto L109;
        r122 = this.f34653a.e();
    L109:
        return new com.bytedance.ai.applet.grantingV2.a(r123, "SUCCESS", r215, r216, u2.f.a(r124, "granted_by_history", r122, 7));
    L63:
        if (r122.length() == 0) goto L66;
        r125 = false;
        goto L67
    L70:
        u2.a r126 = r214.f34687h;
        if (r126 == null) goto L73;
        u2.a r217 = u2.a.a(r126, true, false, 1535);
    L110:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, "SUCCESS", r215, r217, null);
    L73:
        r217 = null;
        goto L110
    L75:
        FlowResult r127 = FlowResult.STOP_FLOW;
        u2.f r128 = this.f34653a;
        if (r122 != null) goto L78;
    L81:
        boolean r129 = true;
    L82:
        if (r129 == false) goto L85;
        r122 = this.f34653a.e();
    L85:
        return new com.bytedance.ai.applet.grantingV2.a(r127, "WARNING", r215, r216, u2.f.a(r128, "refused", r122, 7));
    L78:
        if (r122.length() == 0) goto L81;
        r129 = false;
        goto L82
    L86:
        if (r118 == null) goto L107;
        int r130 = r118.hashCode();
        if (r130 == (-682587753)) goto L101;
        if (r130 == 1085547216) goto L98;
        if (r130 != 1100137118) goto L107;
        if (r118.equals("revoked") == false) goto L107;
    L103:
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.label = 3;
        r104 = l(r214, r115, r114, r116, r112, r103);
        if (r104 != r105) goto L106;
        return r105;
    L98:
        if (r118.equals("refused") == true) goto L103;
    L101:
        if (r118.equals(AiBotPollingAuthResult.STATUS_PENDING) == true) goto L103;
    L107:
        r119.e("PermissionStrategyV2", "Unknown server status: " + r118);
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.STOP_FLOW, "FAILURE", "状态异常，请稍后重试", r214.f34687h, null);
    L40:
        if (r117 != 2) goto L42;
        r118 = "granted";
        goto L52
    L42:
        if (r117 != 3) goto L44;
        r118 = "refused";
        goto L52
    L44:
        if (r117 != 4) goto L47;
        r118 = "revoked";
        goto L52
    L47:
        throw new NoWhenBranchMatchedException();
    L51:
        r118 = null;
        goto L52
    L17:
        r107 = r103.Z$1;
        r100 = r103.Z$0;
        r108 = (String) r103.L$2;
        r109 = (u2.c) r103.L$1;
        r110 = (f) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L28:
        r111 = (GrantStatus) r104;
        goto L29
    L18:
        ResultKt.throwOnFailure(r104);
        r109 = r210.f34682c;
        String r131 = this.f34654b.c();
        if (r131 != null) goto L22;
        com.bytedance.ai.utils.g.f37637a.e("PermissionStrategyV2", "onGrantingIntent scopeName is null");
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.STOP_FLOW, null, null, null, null);
    L22:
        AppletAuthTaskMonitor.Session r132 = r210.f34688i;
        if (r132 == null) goto L30;
        PermissionStrategy$onGrantingIntent$permissionDetail$1 r133 = new PermissionStrategy$onGrantingIntent$permissionDetail$1(this, r109, r131, null);
        r103.L$0 = r210;
        r103.L$1 = r109;
        r103.L$2 = r131;
        r103.Z$0 = r100;
        r103.Z$1 = r212;
        r103.label = 1;
        Object r134 = r132.f(r133, r103);
        if (r134 != r105) goto L27;
        return r105;
    L27:
        r110 = r210;
        r107 = r212;
        r108 = r131;
        r104 = r134;
        goto L28
    L30:
        String r135 = r109.f548386a;
        r103.L$0 = r210;
        r103.L$1 = r109;
        r103.L$2 = r131;
        r103.Z$0 = r100;
        r103.Z$1 = r212;
        r103.label = 2;
        Object r136 = k(r135, r131, r103);
        if (r136 != r105) goto L33;
        return r105;
    L33:
        r110 = r210;
        r107 = r212;
        r108 = r131;
        r104 = r136;
    L7:
        r101 = new PermissionStrategy$onGrantingIntent$1(this, r213);
        goto L8
    }

    public final Object m(String r100, String r101, GrantStatus r102, Continuation<? super Boolean> r110) {
        if ((r110 instanceof PermissionStrategy$postPermissionDetail$1) == false) goto L7;
        PermissionStrategy$postPermissionDetail$1 r103 = (PermissionStrategy$postPermissionDetail$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L16;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L13
    L21:
        boolean r107 = ((Boolean) r111).booleanValue();     // Catch: Exception -> L13
    L25:
        return Boxing.boxBoolean(r107);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r111);
        com.bytedance.ai.utils.g.f37637a.i("PermissionStrategyV2", "postPermissionDetail " + r100 + ' ' + r101);
        CoroutineDispatcher r112 = Dispatchers.getIO();     // Catch: Exception -> L13
        PermissionStrategy$postPermissionDetail$2 r108 = new PermissionStrategy$postPermissionDetail$2(r100, r101, r102, null);     // Catch: Exception -> L13
        r103.label = 1;     // Catch: Exception -> L13
        r111 = BuildersKt.withContext(r112, r108, r103);     // Catch: Exception -> L13
        if (r111 != r105) goto L21;
        return r105;
    L13:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("PermissionStrategyV2", "postPermissionDetail failed: " + e.getMessage(), e);
        r107 = false;
    L7:
        r103 = new PermissionStrategy$postPermissionDetail$1(this, r110);
        goto L8
    }

    public final Object l(f r210, u2.c r211, String r212, boolean r213, boolean r310, Continuation r311) {
        boolean r100 = r310;
        if ((r311 instanceof PermissionStrategy$handlePendingOrRefusedStatus$1) == false) goto L7;
        PermissionStrategy$handlePendingOrRefusedStatus$1 r101 = (PermissionStrategy$handlePendingOrRefusedStatus$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        PermissionStrategy$handlePendingOrRefusedStatus$1 r110 = r101;
        Object r103 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        u2.a r105 = null;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        boolean r106 = r110.Z$0;
        u2.c r107 = (u2.c) r110.L$1;
        f r108 = (f) r110.L$0;
        ResultKt.throwOnFailure(r103);
        r100 = r106;
    L56:
        boolean r109 = ((Boolean) r103).booleanValue();
    L57:
        if (r109 == true) goto L64;
        FlowResult r214 = FlowResult.STOP_FLOW;
        u2.a r112 = r108.f34687h;
        if (r112 == null) goto L61;
        u2.a r215 = u2.a.a(r112, false, false, 511);
    L63:
        return new com.bytedance.ai.applet.grantingV2.a(r214, "FAILURE", "网络异常，请稍后重试", r215, null);
    L61:
        r215 = null;
        goto L63
    L64:
        String r113 = "refused";
        Pair<u2.a, String> r114 = j(r107, "refused", null);
        u2.a r115 = r114.getFirst();
        String r116 = r114.getSecond();
        if (this.f34653a.f() == false) goto L67;
        FlowResult r117 = FlowResult.STOP_FLOW;
    L68:
        FlowResult r118 = r117;
        u2.f r119 = this.f34653a;
        if (r100 == false) goto L71;
        r113 = "refused_by_history";
    L71:
        if (r116 != null) goto L73;
    L76:
        boolean r120 = true;
    L77:
        if (r120 == false) goto L80;
        r116 = this.f34653a.e();
    L80:
        return new com.bytedance.ai.applet.grantingV2.a(r118, null, null, r115, u2.f.a(r119, r113, r116, 7));
    L73:
        if (r116.length() == 0) goto L76;
        r120 = false;
        goto L77
    L67:
        r117 = FlowResult.CONTINUE_NEXT;
        goto L68
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        boolean r121 = r110.Z$0;
        r107 = (u2.c) r110.L$1;
        r108 = (f) r110.L$0;
        ResultKt.throwOnFailure(r103);
        r100 = r121;
    L51:
        r109 = ((Boolean) r103).booleanValue();
        goto L57
    L18:
        f r122 = (f) r110.L$0;
        ResultKt.throwOnFailure(r103);
    L33:
        boolean r123 = ((Boolean) r103).booleanValue();
    L34:
        if (r123 == true) goto L40;
        FlowResult r124 = FlowResult.STOP_FLOW;
        u2.a r125 = r122.f34687h;
        if (r125 == null) goto L39;
        r105 = u2.a.a(r125, false, false, 511);
    L39:
        return new com.bytedance.ai.applet.grantingV2.a(r124, "FAILURE", "网络异常，请稍后重试", r105, null);
    L40:
        u2.a r126 = r122.f34687h;
        if (r126 == null) goto L44;
        r105 = u2.a.a(r126, true, false, 1535);
    L44:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, null, null, r105, null);
    L19:
        r122 = (f) r110.L$0;
        ResultKt.throwOnFailure(r103);
    L28:
        r123 = ((Boolean) r103).booleanValue();
        r105 = null;
        goto L34
    L20:
        ResultKt.throwOnFailure(r103);
        if (r213 == false) goto L45;
        GrantStatus r127 = GrantStatus.GRANTED;
        AppletAuthTaskMonitor.Session r128 = r210.f34688i;
        if (r128 == null) goto L29;
        PermissionStrategy$handlePendingOrRefusedStatus$postResult$1 r129 = new PermissionStrategy$handlePendingOrRefusedStatus$postResult$1(this, r211, r212, r127, null);
        r110.L$0 = r210;
        r110.label = 1;
        r103 = r128.f(r129, r110);
        if (r103 != r111) goto L27;
        return r111;
    L27:
        r122 = r210;
        goto L28
    L29:
        String r130 = r211.f548386a;
        r110.L$0 = r210;
        r110.label = 2;
        r103 = m(r130, r212, r127, r110);
        if (r103 != r111) goto L32;
        return r111;
    L32:
        r122 = r210;
        goto L33
    L45:
        GrantStatus r131 = GrantStatus.DENIED;
        AppletAuthTaskMonitor.Session r132 = r210.f34688i;
        if (r132 == null) goto L52;
        PermissionStrategy$handlePendingOrRefusedStatus$postResult$2 r133 = new PermissionStrategy$handlePendingOrRefusedStatus$postResult$2(this, r211, r212, r131, null);
        r110.L$0 = r210;
        r110.L$1 = r211;
        r110.Z$0 = r100;
        r110.label = 3;
        r103 = r132.f(r133, r110);
        if (r103 != r111) goto L50;
        return r111;
    L50:
        r108 = r210;
        r107 = r211;
        goto L51
    L52:
        String r134 = r211.f548386a;
        r110.L$0 = r210;
        r110.L$1 = r211;
        r110.Z$0 = r100;
        r110.label = 4;
        r103 = m(r134, r212, r131, r110);
        if (r103 != r111) goto L55;
        return r111;
    L55:
        r108 = r210;
        r107 = r211;
    L7:
        r101 = new PermissionStrategy$handlePendingOrRefusedStatus$1(this, r311);
        goto L8
    }
}
