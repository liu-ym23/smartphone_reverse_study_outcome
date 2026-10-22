package com.obric.autoaction.presentation.island.state;

import android.content.Context;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IslandStateHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final boolean a(WidgetState r5) {
        o.e(r5, "<this>");
        boolean r0 = AssistantAbilityHelper.INSTANCE.queryChatPageState((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).isMainConversation();
        IAutoActionPresentationApi r1 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        IAutoActionPresentationApi.PlayerVisibility r2 = r1.getPlayerVisibility((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L7:
        if (r2 != IAutoActionPresentationApi.PlayerVisibility.Visible) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return false;
    L12:
        if (r0 == true) goto L15;
        return true;
    L15:
        if (r5.getSessionInfo().getTask().getLaunchOrigin() == 33) goto L17;
    L23:
        return false;
    L17:
        if (ZeusTransformUtils.instanceOf(r5, WidgetState.Clarify.class) == false) goto L20;
        return false;
    L20:
        if (ZeusTransformUtils.instanceOf(r5, WidgetState.CallUser.class) == true) goto L24;
        Loog.INSTANCE.e("ShoudExpandIsland", "not support state");
        goto L23
    L24:
        return true;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = null;
        goto L7
    }
}
