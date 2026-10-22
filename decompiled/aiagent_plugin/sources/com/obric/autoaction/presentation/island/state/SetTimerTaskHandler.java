package com.obric.autoaction.presentation.island.state;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.CommonExpandedTemplate;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.island.IslandApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: SetTimerTaskHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SetTimerTaskHandler extends a {
    private final Context appContext;

    public static /* synthetic */ x lambda$JHChbwqO9YbBGK0t0spd1swmN4E(SetTimerTaskHandler r0, IAutoAgentWidgetStateListener.TimerTask r1) {
        return onSetTimerTask$lambda$2$lambda$0(r0, r1);
    }

    public static /* synthetic */ x lambda$kqD2gMvxmh8WMrVGni6ErBLIsWw(IslandWidget r0) {
        return onSetTimerTask$lambda$2$lambda$1(r0);
    }

    public SetTimerTaskHandler() {
        this.appContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onSetTimerTask(WidgetState.SetTimerTask r28) {
        o.e(r28, "state");
        final IAutoAgentWidgetStateListener.TimerTask r1 = r28.getTimerTask();
        if (r1 != null) goto L5;
        return;
    L5:
        com.obric.autoaction.presentation.island.template.a r2 = com.obric.autoaction.presentation.island.template.a.f25101a;
        if (r1.isRepeatTask() == false) goto L8;
        String r3 = "svg:island_expand_repeat";
    L9:
        String r5 = this.appContext.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_task_created, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_task_created"));
        o.c(r5, "getString(...)");
        final IslandWidget r11 = CommonExpandedTemplate.create$default(r2.a(r3, "svg:right_arrow", r5, r1.getAction(), true), null, 1, null);
        r11.setOnCardClickCallback(new $$Lambda$SetTimerTaskHandler$JHChbwqO9YbBGK0t0spd1swmN4E(this, r1));
        r11.addOnViewClickCallback("btn_default", new $$Lambda$SetTimerTaskHandler$kqD2gMvxmh8WMrVGni6ErBLIsWw(r11));
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L13;
        r0.createSession(new IslandSession(null, r11, null, null, 5000L, 0, LiveCardType.OAUTO, null, null, null, 1, null, 0, 7085, null), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        return;
    L8:
        r3 = "svg:island_expand_timing";
        goto L9
    }

    private static final x onSetTimerTask$lambda$2$lambda$0(SetTimerTaskHandler r3, IAutoAgentWidgetStateListener.TimerTask r4) {
        IAutoActionPresentationApi r0 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.openTaskListPage(r3.appContext, r4.getId(), "click_dynamic_island");
    L6:
        return x.f38692a;
    }

    private static final x onSetTimerTask$lambda$2$lambda$1(IslandWidget r0) {
        d.h.a.a<x> r1 = r0.getOnCardClickCallback();
        if (r1 == null) goto L6;
        r1.invoke();
    L6:
        return x.f38692a;
    }
}
