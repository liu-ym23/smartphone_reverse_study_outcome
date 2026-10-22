package com.obric.autogui.platforms.obric;

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
import d.l;

/* JADX INFO: compiled from: ObricPlatformTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements AOPlatformToolsInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.platforms.tools.input.b f30059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.platforms.obric.d.a f30060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f30061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.platforms.tools.d.a f30062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.platforms.obric.a.a f30063e;
    private final com.obric.autogui.platforms.tools.b.a f;
    private final com.obric.autogui.platforms.obric.b.b g;
    private final com.obric.autogui.platforms.tools.e.b h;
    private final com.obric.autogui.platforms.obric.c.a i;
    private final com.obric.autogui.platforms.obric.e.a j;
    private final com.obric.autogui.platforms.tools.display.b k;
    private final com.obric.autogui.platforms.tools.packages.b l;
    private final com.obric.autogui.platforms.obric.f.a m;
    private final com.obric.autogui.platforms.tools.c.b n;
    private final c o;
    private final StandardComputerControlApiImpl p;

    public b() {
        this.f30059a = new com.obric.autogui.platforms.tools.input.b();
        this.f30060b = new com.obric.autogui.platforms.obric.d.a();
        this.f30061c = new e();
        this.f30062d = new com.obric.autogui.platforms.tools.d.a();
        this.f30063e = new com.obric.autogui.platforms.obric.a.a();
        this.f = new com.obric.autogui.platforms.tools.b.a();
        this.g = new com.obric.autogui.platforms.obric.b.b();
        this.h = new com.obric.autogui.platforms.tools.e.b();
        this.i = new com.obric.autogui.platforms.obric.c.a();
        this.j = new com.obric.autogui.platforms.obric.e.a();
        this.k = new com.obric.autogui.platforms.tools.display.b();
        this.l = new com.obric.autogui.platforms.tools.packages.b();
        this.m = new com.obric.autogui.platforms.obric.f.a();
        this.n = new com.obric.autogui.platforms.tools.c.b();
        this.o = new c();
        this.p = new StandardComputerControlApiImpl();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionAbilityApi abilities() {
        return (IAutoActionAbilityApi) ZeusTransformUtils.preCheckCast(this.f30063e, IAutoActionAbilityApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionRegistryApi registry() {
        return (IAutoActionRegistryApi) ZeusTransformUtils.preCheckCast(this.f30062d, IAutoActionRegistryApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionAccountApi account() {
        return (IAutoActionAccountApi) ZeusTransformUtils.preCheckCast(this.f, IAutoActionAccountApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionInputApi input() {
        return (IAutoActionInputApi) ZeusTransformUtils.preCheckCast(this.f30059a, IAutoActionInputApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionSecurityApi security() {
        return (IAutoActionSecurityApi) ZeusTransformUtils.preCheckCast(this.f30060b, IAutoActionSecurityApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionPermissionApi permission() {
        return (IAutoActionPermissionApi) ZeusTransformUtils.preCheckCast(this.f30061c, IAutoActionPermissionApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionLocationApi location() {
        return (IAutoActionLocationApi) ZeusTransformUtils.preCheckCast(this.g, IAutoActionLocationApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionPlatformStrategyApi platformStrategy() {
        return (IAutoActionPlatformStrategyApi) ZeusTransformUtils.preCheckCast(this.i, IAutoActionPlatformStrategyApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionUIApi ui() {
        return (IAutoActionUIApi) ZeusTransformUtils.preCheckCast(this.h, IAutoActionUIApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionPackagesApi packages() {
        return (IAutoActionPackagesApi) ZeusTransformUtils.preCheckCast(this.l, IAutoActionPackagesApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionSystemApi system() {
        return (IAutoActionSystemApi) ZeusTransformUtils.preCheckCast(this.j, IAutoActionSystemApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionDisplayApi display() {
        return (IAutoActionDisplayApi) ZeusTransformUtils.preCheckCast(this.k, IAutoActionDisplayApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionTasksApi tasks() {
        throw new l("An operation is not implemented: Not yet implemented");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionTrackingApi tracking() {
        return (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(this.m, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionCollectingApi collecting() {
        return (IAutoActionCollectingApi) ZeusTransformUtils.preCheckCast(this.n, IAutoActionCollectingApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionSpecialApi special() {
        return (IAutoActionSpecialApi) ZeusTransformUtils.preCheckCast(this.o, IAutoActionSpecialApi.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IComputerControlApi computerControl() {
        return (IComputerControlApi) ZeusTransformUtils.preCheckCast(this.p, IComputerControlApi.class, "com.obric.aiagent.plugin");
    }
}
