package com.stepos.ability.sdk.client;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.bean.TaskConfig;
import com.stepos.ability.bean.TaskUiInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ability/sdk/client/t;", "Landroid/content/Context;", "context", "Lcom/stepos/ability/bean/TaskConfig;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ability/sdk/client/t;Landroid/content/Context;)Lcom/stepos/ability/bean/TaskConfig;", "sdk_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class u {
    public static final TaskConfig a(t tVar, Context context) {
        String toolcallId;
        kotlin.jvm.internal.p.i(tVar, "<this>");
        kotlin.jvm.internal.p.i(context, "context");
        CommonConfig commonConfig = tVar.getCommonConfig();
        if (commonConfig == null || (toolcallId = commonConfig.getTaskId()) == null) {
            toolcallId = tVar.getToolcallId();
        }
        String toolcallId2 = tVar.getToolcallId();
        CommonConfig commonConfig2 = tVar.getCommonConfig();
        int priority = commonConfig2 != null ? commonConfig2.getPriority() : 2;
        CommonConfig commonConfig3 = tVar.getCommonConfig();
        String condition = commonConfig3 != null ? commonConfig3.getCondition() : null;
        CommonConfig commonConfig4 = tVar.getCommonConfig();
        TaskUiInfo taskUiInfo = commonConfig4 != null ? commonConfig4.getTaskUiInfo() : null;
        Long abilityId = tVar.getAbilityId();
        String name = tVar.getName();
        String params = tVar.getParams();
        CommonConfig commonConfig5 = tVar.getCommonConfig();
        return new TaskConfig(toolcallId, toolcallId2, null, 0, priority, condition, abilityId, name, taskUiInfo, null, params, commonConfig5 != null ? commonConfig5.getExtra() : null, context.getPackageName(), 0, 8708, null);
    }
}
