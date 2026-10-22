package com.obric.autogui.vdplayer.adapter.orchestrator.a.a;

import android.os.Bundle;
import com.obric.autoaction.presentation.SurfaceCardActivity;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: OperatingEventHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BizStatus f31660a;

    public static /* synthetic */ String lambda$M2RcxhyNslEZJjZN557VtgUGJvY(List r0, List r1) {
        return a(r0, r1);
    }

    public c() {
        this.f31660a = BizStatus.OPERATING;
    }

    @Override // com.obric.autogui.vdplayer.adapter.orchestrator.a.a
    public BizStatus a() {
        return this.f31660a;
    }

    @Override // com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a, com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r8, BizStatus r9, BizStatus r10, int r11, BizStatus.StatusChangedReasonStruct r12, Bundle r13) {
        o.e(r8, "sessionInfo");
        o.e(r9, "oldStatus");
        o.e(r10, "status");
        o.e(r12, "reasonDetails");
        com.obric.autogui.vdplayer.adapter.orchestrator.b.f31668a.a(r8.getSessionKey());
        switch(r12.getReason()) {
            case 1400: goto L10;
            case 1401: goto L9;
            case 1402: goto L8;
            case 1403: goto L7;
            case 1404: goto L6;
            case 1405: goto L5;
            default: goto L17;
        };
    L5:
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.f(null, false, null, null, 15, null), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.f("用户已完成了操作，现在将继续由我为用户执行任务", false, null, null, 14, null), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.f("已收到用户补充信息", false, null, null, 14, null), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.f("用户已完成了操作，现在将继续由我为用户执行任务", false, null, null, 14, null), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.f("已收到用户回复", false, null, null, 14, null), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.f(null, false, null, null, 15, null), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a, com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r6, IAutoActionAgentEventListener.AgentStepInfo r7) {
        o.e(r6, "sessionInfo");
        o.e(r7, "stepInfo");
        int r8 = r7.getActionType();
        final List<Float> r2 = null;
        if (r8 != com.obric.autogui.agents.vlm.models.a.d.b.f27243b.getIdentifier()) goto L23;
        Bundle r9 = r7.getExtras();
        if (r9 == null) goto L9;
        float[] r10 = r9.getFloatArray(SurfaceCardActivity.SWIPE_POS_KEY);
        if (r10 == null) goto L9;
        final List<Float> r11 = i.d(r10);
    L10:
        Bundle r0 = r7.getExtras();
        if (r0 == null) goto L15;
        float[] r1 = r0.getFloatArray("clicked_pos");
        if (r1 == null) goto L15;
        r2 = i.d(r1);
    L15:
        Bundle r3 = r7.getExtras();
        boolean r4 = false;
        if (r3 == null) goto L18;
        r4 = r3.getBoolean("skip_ui_operating", false);
    L18:
        if (r4 == false) goto L21;
        Loog.INSTANCE.dp(LogUtil.INSTANCE.getCLAZZ_TAG(this), new $$Lambda$c$M2RcxhyNslEZJjZN557VtgUGJvY(r11, r2));
        return;
    L21:
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.f(r7.getThought(), r7.getSupportsUserAddition(), r11, r2), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        r11 = null;
        goto L10
    L23:
        if (r8 != com.obric.autogui.agents.vlm.models.a.d.b.f.getIdentifier()) goto L27;
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.f(r7.getThought(), r7.getSupportsUserAddition(), null, null), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final String a(List r2, List r3) {
        return "skip ui operating by pre-check, swipePos:" + ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin")) + ", clickPos:" + ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }
}
