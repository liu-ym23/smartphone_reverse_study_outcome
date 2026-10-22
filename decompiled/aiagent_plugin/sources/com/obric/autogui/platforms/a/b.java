package com.obric.autogui.platforms.a;

import com.obric.autogui.common.api.abilities.IAutoActionAbilityApi;
import com.obric.autogui.common.api.platform.AOPlatformToolsInterface;
import com.obric.autogui.common.api.platform.account.IAutoActionAccountApi;
import com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi;
import com.obric.autogui.common.api.platform.device.IAutoActionRegistryApi;
import com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi;
import com.obric.autogui.common.api.platform.input.IAutoActionInputApi;
import com.obric.autogui.common.api.platform.packages.IAutoActionPackagesApi;
import com.obric.autogui.common.api.platform.screen.capture.IAutoActionCollectingApi;
import com.obric.autogui.common.api.platform.security.IAutoActionPermissionApi;
import com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi;
import com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi;
import com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi;
import com.obric.autogui.common.api.platform.system.IAutoActionLocationApi;
import com.obric.autogui.common.api.platform.system.IAutoActionSystemApi;
import com.obric.autogui.common.api.platform.tasks.IAutoActionTasksApi;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.platform.ui.IAutoActionUIApi;
import com.obric.autogui.platforms.tools.computercontrol.StandardComputerControlApiImpl;
import com.obric.autogui.platforms.tools.security.e;
import com.obric.autogui.platforms.tools.special.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.j;
import d.l;

/* JADX INFO: compiled from: AbstractStandardPlatformTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements AOPlatformToolsInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f29952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f29953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f29954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f29955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f29956e;
    private final f f;
    private final f g;
    private final f h;
    private final f i;
    private final f j;
    private final f k;
    private final f l;
    private final f m;
    private final f n;
    private final f o;
    private final f p;

    /* JADX INFO: renamed from: lambda$0rRFTsa8r-hLF_uxtqGCBoJ_2Ew, reason: not valid java name */
    public static /* synthetic */ IAutoActionTrackingApi m842lambda$0rRFTsa8rhLF_uxtqGCBoJ_2Ew(b r0) {
        return m(r0);
    }

    public static /* synthetic */ IAutoActionPackagesApi lambda$4YljnAdfC6T5uiWUCAA7gFvU0OM(b r0) {
        return l(r0);
    }

    /* JADX INFO: renamed from: lambda$4duxiFwTHOXEIrMcN5-ZpKq_IYI, reason: not valid java name */
    public static /* synthetic */ IAutoActionLocationApi m843lambda$4duxiFwTHOXEIrMcN5ZpKq_IYI(b r0) {
        return g(r0);
    }

    /* JADX INFO: renamed from: lambda$6ItWvjtGyQp-5GTVgkys-De5e5I, reason: not valid java name */
    public static /* synthetic */ IAutoActionAccountApi m844lambda$6ItWvjtGyQp5GTVgkysDe5e5I(b r0) {
        return f(r0);
    }

    public static /* synthetic */ IAutoActionCollectingApi lambda$8MQlDT1ZyjZMCB2t_Sq5Sv669vo(b r0) {
        return n(r0);
    }

    /* JADX INFO: renamed from: lambda$DYrnpx-xp28oXV-G_RjSPbC6NCY, reason: not valid java name */
    public static /* synthetic */ IAutoActionSpecialApi m845lambda$DYrnpxxp28oXVG_RjSPbC6NCY(b r0) {
        return o(r0);
    }

    public static /* synthetic */ IComputerControlApi lambda$M70P1xI9xjkSdlTVMr_1ldDSdRM(b r0) {
        return p(r0);
    }

    /* JADX INFO: renamed from: lambda$NX2xcw2KzMgJ_KEDDkUA7Aw-sxQ, reason: not valid java name */
    public static /* synthetic */ IAutoActionSecurityApi m846lambda$NX2xcw2KzMgJ_KEDDkUA7AwsxQ(b r0) {
        return b(r0);
    }

    public static /* synthetic */ IAutoActionDisplayApi lambda$PxmsOr86Ls3yRvx77hgwWx0RoLc(b r0) {
        return k(r0);
    }

    /* JADX INFO: renamed from: lambda$ULaIm7Sd1nU-45_R75y1Xo13bzo, reason: not valid java name */
    public static /* synthetic */ IAutoActionRegistryApi m847lambda$ULaIm7Sd1nU45_R75y1Xo13bzo(b r0) {
        return d(r0);
    }

    /* JADX INFO: renamed from: lambda$ZKTuAwBgsyzcPMrG5KIyO-Q4s1g, reason: not valid java name */
    public static /* synthetic */ IAutoActionSystemApi m848lambda$ZKTuAwBgsyzcPMrG5KIyOQ4s1g(b r0) {
        return j(r0);
    }

    public static /* synthetic */ IAutoActionPermissionApi lambda$fTSHSNuMUTkz_7TymJGO0imaH5I(b r0) {
        return c(r0);
    }

    public static /* synthetic */ IAutoActionPlatformStrategyApi lambda$haw9ZWk10ChOjVH5rRp0rUvnOGw(b r0) {
        return i(r0);
    }

    /* JADX INFO: renamed from: lambda$l-pU4tVLnQSLd0zatxd21RLG9CE, reason: not valid java name */
    public static /* synthetic */ IAutoActionUIApi m849lambda$lpU4tVLnQSLd0zatxd21RLG9CE(b r0) {
        return h(r0);
    }

    public static /* synthetic */ IAutoActionInputApi lambda$phoElHv3ifzqHkVV_5iv8UHfeYo(b r0) {
        return a(r0);
    }

    public static /* synthetic */ IAutoActionAbilityApi lambda$xqFAy16LUvbZqmIsRGGKk9F8axQ(b r0) {
        return e(r0);
    }

    public b() {
        this.f29952a = g.a(j.f38507c, new $$Lambda$b$phoElHv3ifzqHkVV_5iv8UHfeYo(this));
        this.f29953b = g.a(j.f38507c, new $$Lambda$b$NX2xcw2KzMgJ_KEDDkUA7AwsxQ(this));
        this.f29954c = g.a(j.f38507c, new $$Lambda$b$fTSHSNuMUTkz_7TymJGO0imaH5I(this));
        this.f29955d = g.a(j.f38507c, new $$Lambda$b$ULaIm7Sd1nU45_R75y1Xo13bzo(this));
        this.f29956e = g.a(j.f38507c, new $$Lambda$b$xqFAy16LUvbZqmIsRGGKk9F8axQ(this));
        this.f = g.a(j.f38507c, new $$Lambda$b$6ItWvjtGyQp5GTVgkysDe5e5I(this));
        this.g = g.a(j.f38507c, new $$Lambda$b$4duxiFwTHOXEIrMcN5ZpKq_IYI(this));
        this.h = g.a(j.f38507c, new $$Lambda$b$lpU4tVLnQSLd0zatxd21RLG9CE(this));
        this.i = g.a(j.f38507c, new $$Lambda$b$haw9ZWk10ChOjVH5rRp0rUvnOGw(this));
        this.j = g.a(j.f38507c, new $$Lambda$b$ZKTuAwBgsyzcPMrG5KIyOQ4s1g(this));
        this.k = g.a(j.f38507c, new $$Lambda$b$PxmsOr86Ls3yRvx77hgwWx0RoLc(this));
        this.l = g.a(j.f38507c, new $$Lambda$b$4YljnAdfC6T5uiWUCAA7gFvU0OM(this));
        this.m = g.a(j.f38507c, new $$Lambda$b$0rRFTsa8rhLF_uxtqGCBoJ_2Ew(this));
        this.n = g.a(j.f38507c, new $$Lambda$b$8MQlDT1ZyjZMCB2t_Sq5Sv669vo(this));
        this.o = g.a(j.f38507c, new $$Lambda$b$DYrnpxxp28oXVG_RjSPbC6NCY(this));
        this.p = g.a(j.f38507c, new $$Lambda$b$M70P1xI9xjkSdlTVMr_1ldDSdRM(this));
    }

    private static final IAutoActionInputApi a(b r0) {
        return r0.d();
    }

    private final IAutoActionInputApi r() {
        return (IAutoActionInputApi) ZeusTransformUtils.preCheckCast(this.f29952a.b(), IAutoActionInputApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionSecurityApi b(b r0) {
        return r0.e();
    }

    private final IAutoActionSecurityApi s() {
        return (IAutoActionSecurityApi) ZeusTransformUtils.preCheckCast(this.f29953b.b(), IAutoActionSecurityApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionPermissionApi c(b r0) {
        return r0.f();
    }

    private final IAutoActionPermissionApi t() {
        return (IAutoActionPermissionApi) ZeusTransformUtils.preCheckCast(this.f29954c.b(), IAutoActionPermissionApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionRegistryApi d(b r0) {
        return r0.b();
    }

    private final IAutoActionRegistryApi u() {
        return (IAutoActionRegistryApi) ZeusTransformUtils.preCheckCast(this.f29955d.b(), IAutoActionRegistryApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionAbilityApi e(b r0) {
        return r0.a();
    }

    private final IAutoActionAbilityApi v() {
        return (IAutoActionAbilityApi) ZeusTransformUtils.preCheckCast(this.f29956e.b(), IAutoActionAbilityApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionAccountApi f(b r0) {
        return r0.c();
    }

    private final IAutoActionAccountApi w() {
        return (IAutoActionAccountApi) ZeusTransformUtils.preCheckCast(this.f.b(), IAutoActionAccountApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionLocationApi g(b r0) {
        return r0.g();
    }

    private final IAutoActionLocationApi x() {
        return (IAutoActionLocationApi) ZeusTransformUtils.preCheckCast(this.g.b(), IAutoActionLocationApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionUIApi h(b r0) {
        return r0.i();
    }

    private final IAutoActionUIApi y() {
        return (IAutoActionUIApi) ZeusTransformUtils.preCheckCast(this.h.b(), IAutoActionUIApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionPlatformStrategyApi i(b r0) {
        return r0.h();
    }

    private final IAutoActionPlatformStrategyApi z() {
        return (IAutoActionPlatformStrategyApi) ZeusTransformUtils.preCheckCast(this.i.b(), IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin");
    }

    private final IAutoActionSystemApi A() {
        return (IAutoActionSystemApi) ZeusTransformUtils.preCheckCast(this.j.b(), IAutoActionSystemApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionSystemApi j(b r0) {
        return r0.k();
    }

    private final IAutoActionDisplayApi B() {
        return (IAutoActionDisplayApi) ZeusTransformUtils.preCheckCast(this.k.b(), IAutoActionDisplayApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionDisplayApi k(b r0) {
        return r0.l();
    }

    private final IAutoActionPackagesApi C() {
        return (IAutoActionPackagesApi) ZeusTransformUtils.preCheckCast(this.l.b(), IAutoActionPackagesApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionPackagesApi l(b r0) {
        return r0.j();
    }

    private final IAutoActionTrackingApi D() {
        return (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(this.m.b(), IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionTrackingApi m(b r0) {
        return r0.n();
    }

    private final IAutoActionCollectingApi E() {
        return (IAutoActionCollectingApi) ZeusTransformUtils.preCheckCast(this.n.b(), IAutoActionCollectingApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionCollectingApi n(b r0) {
        return r0.o();
    }

    private final IAutoActionSpecialApi F() {
        return (IAutoActionSpecialApi) ZeusTransformUtils.preCheckCast(this.o.b(), IAutoActionSpecialApi.class, "com.obric.aiagent.plugin");
    }

    private static final IAutoActionSpecialApi o(b r0) {
        return r0.p();
    }

    private final IComputerControlApi G() {
        return (IComputerControlApi) ZeusTransformUtils.preCheckCast(this.p.b(), IComputerControlApi.class, "com.obric.aiagent.plugin");
    }

    private static final IComputerControlApi p(b r0) {
        return r0.q();
    }

    public IAutoActionAbilityApi a() {
        return (IAutoActionAbilityApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.a.a(), IAutoActionAbilityApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionRegistryApi b() {
        return (IAutoActionRegistryApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.d.a(), IAutoActionRegistryApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionAccountApi c() {
        return (IAutoActionAccountApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.b.a(), IAutoActionAccountApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionInputApi d() {
        return (IAutoActionInputApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.input.b(), IAutoActionInputApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionSecurityApi e() {
        return (IAutoActionSecurityApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.security.f(), IAutoActionSecurityApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionPermissionApi f() {
        return (IAutoActionPermissionApi) ZeusTransformUtils.preCheckCast(new e(), IAutoActionPermissionApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionLocationApi g() {
        return (IAutoActionLocationApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.location.b(), IAutoActionLocationApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionPlatformStrategyApi h() {
        return (IAutoActionPlatformStrategyApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.platstrategy.b(), IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionUIApi i() {
        return (IAutoActionUIApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.e.b(), IAutoActionUIApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionPackagesApi j() {
        return (IAutoActionPackagesApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.packages.b(), IAutoActionPackagesApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionSystemApi k() {
        return (IAutoActionSystemApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.e.a(), IAutoActionSystemApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionDisplayApi l() {
        return (IAutoActionDisplayApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.display.b(), IAutoActionDisplayApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionTasksApi m() {
        throw new l("An operation is not implemented: Not yet implemented");
    }

    public IAutoActionTrackingApi n() {
        return (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.f.a(), IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionCollectingApi o() {
        return (IAutoActionCollectingApi) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.tools.c.b(), IAutoActionCollectingApi.class, "com.obric.aiagent.plugin");
    }

    public IAutoActionSpecialApi p() {
        return (IAutoActionSpecialApi) ZeusTransformUtils.preCheckCast(new c(), IAutoActionSpecialApi.class, "com.obric.aiagent.plugin");
    }

    public IComputerControlApi q() {
        return (IComputerControlApi) ZeusTransformUtils.preCheckCast(new StandardComputerControlApiImpl(), IComputerControlApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionAbilityApi abilities() {
        return v();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionRegistryApi registry() {
        return u();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionAccountApi account() {
        return w();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionInputApi input() {
        return r();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionSecurityApi security() {
        return s();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionPermissionApi permission() {
        return t();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionLocationApi location() {
        return x();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionPlatformStrategyApi platformStrategy() {
        return z();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionUIApi ui() {
        return y();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionPackagesApi packages() {
        return C();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionSystemApi system() {
        return A();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionDisplayApi display() {
        return B();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionTasksApi tasks() {
        return m();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionTrackingApi tracking() {
        return D();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionCollectingApi collecting() {
        return E();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionSpecialApi special() {
        return F();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IComputerControlApi computerControl() {
        return G();
    }
}
