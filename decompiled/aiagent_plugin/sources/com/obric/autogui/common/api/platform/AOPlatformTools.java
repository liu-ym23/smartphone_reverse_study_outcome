package com.obric.autogui.common.api.platform;

import com.obric.autogui.common.api.abilities.IAutoActionAbilityApi;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOPlatformTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOPlatformTools implements AOPlatformToolsInterface {
    public static final AOPlatformTools INSTANCE = null;
    private final /* synthetic */ AOPlatformToolsInterface $$delegate_0;

    static {
        INSTANCE = new AOPlatformTools();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionAbilityApi abilities() {
        return this.$$delegate_0.abilities();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionAccountApi account() {
        return this.$$delegate_0.account();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionCollectingApi collecting() {
        return this.$$delegate_0.collecting();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IComputerControlApi computerControl() {
        return this.$$delegate_0.computerControl();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionDisplayApi display() {
        return this.$$delegate_0.display();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionInputApi input() {
        return this.$$delegate_0.input();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionLocationApi location() {
        return this.$$delegate_0.location();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionPackagesApi packages() {
        return this.$$delegate_0.packages();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionPermissionApi permission() {
        return this.$$delegate_0.permission();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionPlatformStrategyApi platformStrategy() {
        return this.$$delegate_0.platformStrategy();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionRegistryApi registry() {
        return this.$$delegate_0.registry();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionSecurityApi security() {
        return this.$$delegate_0.security();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionSpecialApi special() {
        return this.$$delegate_0.special();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionSystemApi system() {
        return this.$$delegate_0.system();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionTasksApi tasks() {
        return this.$$delegate_0.tasks();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionTrackingApi tracking() {
        return this.$$delegate_0.tracking();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformToolsInterface
    public IAutoActionUIApi ui() {
        return this.$$delegate_0.ui();
    }

    private AOPlatformTools() {
        this.$$delegate_0 = (AOPlatformToolsInterface) ZeusTransformUtils.preCheckCast(AOPlatformToolsKt.access$getSPlatTools$p().b(), AOPlatformToolsInterface.class, "com.obric.aiagent.plugin");
    }
}
