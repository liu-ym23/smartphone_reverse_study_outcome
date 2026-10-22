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

/* JADX INFO: compiled from: AOPlatformToolsInterface.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface AOPlatformToolsInterface {
    IAutoActionAbilityApi abilities();

    IAutoActionAccountApi account();

    IAutoActionCollectingApi collecting();

    IComputerControlApi computerControl();

    IAutoActionDisplayApi display();

    IAutoActionInputApi input();

    IAutoActionLocationApi location();

    IAutoActionPackagesApi packages();

    IAutoActionPermissionApi permission();

    IAutoActionPlatformStrategyApi platformStrategy();

    IAutoActionRegistryApi registry();

    IAutoActionSecurityApi security();

    IAutoActionSpecialApi special();

    IAutoActionSystemApi system();

    IAutoActionTasksApi tasks();

    IAutoActionTrackingApi tracking();

    IAutoActionUIApi ui();
}
