package com.stepos.ability.sdk.client;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.bean.GuiAgentConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ability/sdk/client/r;", "Lcom/stepos/ability/bean/GuiAgentConfig;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ability/sdk/client/r;)Lcom/stepos/ability/bean/GuiAgentConfig;", "sdk_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class s {
    public static final GuiAgentConfig a(GuiTaskConfig guiTaskConfig) {
        kotlin.jvm.internal.p.i(guiTaskConfig, "<this>");
        return new GuiAgentConfig(guiTaskConfig.getSurface(), guiTaskConfig.getGuiTaskType(), guiTaskConfig.getStartMode(), null, guiTaskConfig.getModelName(), false, null, 104, null);
    }
}
