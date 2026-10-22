package com.obric.autoaction.presentation.island.state;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.presentation.island.template.OAutoDialogueIslandTemplate;
import com.obric.autoaction.presentation.island.template.OAutoExpandCardTemplate;
import com.obric.autoaction.presentation.island.template.TextButton;
import com.obric.autoaction.presentation.island.template.TitleWithIcon;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: CallUserStateHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CallUserStateHandler extends com.obric.autoaction.presentation.island.state.a {
    public static final a Companion = null;
    private static final int MAX_ACTION_TEXT_LENGTH = 4;

    /* JADX INFO: compiled from: CallUserStateHandler.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$-sFmVXSspodqpou2H-oO7RNURHU, reason: not valid java name */
    public static /* synthetic */ x m626lambda$sFmVXSspodqpou2HoO7RNURHU(CallUserStateHandler r0) {
        return onCallUser$lambda$3$lambda$0(r0);
    }

    public static /* synthetic */ x lambda$3EAn31YZFG7Pf0AxyaaMzAPVqck(CallUserStateHandler r0) {
        return onCallUser$lambda$3$lambda$1(r0);
    }

    public static /* synthetic */ x lambda$dWrBXNmjTOaK2LJi8QDEm4swITk(boolean r0, Intent r1) {
        return onWidgetClick$lambda$6(r0, r1);
    }

    public static /* synthetic */ x lambda$n4jfE0nWZaEycUf8p3tXBrUy7BI(CallUserStateHandler r0) {
        return onCallUser$lambda$3$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$xPEG1IzhoA0LgnPRERMsm-h2G2c, reason: not valid java name */
    public static /* synthetic */ x m627lambda$xPEG1IzhoA0LgnPRERMsmh2G2c(CallUserStateHandler r0) {
        return onCallUser$lambda$5$lambda$4(r0);
    }

    public CallUserStateHandler() {
    }

    @Override // com.obric.autogui.common.api.presentation.AutoAgentWidgetStateDefaultListener, com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onCallUser(WidgetState.CallUser r32) {
        o.e(r32, "state");
        Bundle r2 = r32.getStepInfo().getExtras();
        if (r2 == null) goto L5;
        String r3 = r2.getString("action_for_user");
    L7:
        if (r3 != null) goto L9;
    L11:
        String r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_manual_operation, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_manual_operation"));
        o.a(r7);
    L12:
        Icon r8 = new Icon(20, 20, "svg:island_stop", null, null, null, null, 120, null);
        String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_please_manual_operation, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_please_manual_operation"));
        o.c(r11, "getString(...)");
        String r19 = r3;
        TitleWithIcon r9 = new TitleWithIcon(r8, new Text(r11, 14, com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_2, "color", "oui_on_accent_text_2"), false, 2, null)));
        String r4 = r32.getSessionInfo().getTask().getUserTask();
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        OAutoExpandCardTemplate r15 = new OAutoExpandCardTemplate(r9, new Text(r4, 12, com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_3, "color", "oui_on_accent_text_3"), false, 2, null)), new Text(r32.getStepInfo().getAction(), 16, "var:ai-gradient-a3"), new TextButton("call_user_btn", new Icon(18, 18, "svg:button_hand", null, null, null, null, 120, null), new Text(r7, 14, "var:ai-gradient-a3"), null, true, 8, null), null, 16, null);
        com.obric.autoaction.presentation.island.template.a r20 = com.obric.autoaction.presentation.island.template.a.f25101a;
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_waiting_operation, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_waiting_operation"));
        o.c(r5, "getString(...)");
        IslandWidget r10 = new OAutoDialogueIslandTemplate(r15, r20.a("svg:island_stop_expand", "svg:right_arrow", r5, r32.getStepInfo().getAction(), true)).create(Boolean.valueOf(b.a((WidgetState) ZeusTransformUtils.preCheckCast(r32, WidgetState.class, "com.obric.aiagent.plugin"))));
        r10.addOnViewClickCallback("btn_default", new $$Lambda$CallUserStateHandler$sFmVXSspodqpou2HoO7RNURHU(this));
        r10.addOnViewClickCallback("call_user_btn", new $$Lambda$CallUserStateHandler$3EAn31YZFG7Pf0AxyaaMzAPVqck(this));
        r10.setOnCardClickCallback(new $$Lambda$CallUserStateHandler$n4jfE0nWZaEycUf8p3tXBrUy7BI(this));
        if (r19 != null) goto L18;
    L20:
        String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_please_operate, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_please_operate"));
        o.a(r6);
        String r13 = r6;
    L21:
        IslandWidget r12 = CommonCollapseTemplate.create$default(com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, "svg:island_stop", null, r13, null, 10, null), null, 1, null);
        r12.setOnCardClickCallback(new $$Lambda$CallUserStateHandler$xPEG1IzhoA0LgnPRERMsmh2G2c(this));
        if (b.a((WidgetState) ZeusTransformUtils.preCheckCast(r32, WidgetState.class, "com.obric.aiagent.plugin")) == false) goto L24;
        com.obric.autoaction.presentation.island.a.a().a(8, false);
    L24:
        com.obric.autoaction.presentation.island.b.a(com.obric.autoaction.presentation.island.a.a(), r12, r10, false, 4, null);
        return;
    L18:
        if (r19.length() > 4) goto L20;
        r13 = r19;
        goto L21
    L9:
        if (r3.length() > 4) goto L11;
        r7 = r3;
        goto L12
    L5:
        r3 = null;
        goto L7
    }

    private static final x onCallUser$lambda$3$lambda$0(CallUserStateHandler r1) {
        r1.onWidgetClick(true);
        return x.f38692a;
    }

    private static final x onCallUser$lambda$3$lambda$1(CallUserStateHandler r1) {
        r1.onWidgetClick(true);
        return x.f38692a;
    }

    private static final x onCallUser$lambda$3$lambda$2(CallUserStateHandler r3) {
        onWidgetClick$default(r3, false, 1, null);
        return x.f38692a;
    }

    private static final x onCallUser$lambda$5$lambda$4(CallUserStateHandler r3) {
        onWidgetClick$default(r3, false, 1, null);
        return x.f38692a;
    }

    static /* synthetic */ void onWidgetClick$default(CallUserStateHandler r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.onWidgetClick(r1);
    }

    private final void onWidgetClick(final boolean r8) {
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.presentation.island.b.a(com.obric.autoaction.presentation.island.a.a(), 8, false, 2, null);
        com.obric.autoaction.presentation.island.a.a().e();
        IAutoActionPresentationApi r0 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.openPlayer(r7, "click_dynamic_island", new $$Lambda$CallUserStateHandler$dWrBXNmjTOaK2LJi8QDEm4swITk(r8));
        return;
    }

    private static final x onWidgetClick$lambda$6(boolean r1, Intent r2) {
        o.e(r2, "$this$openPlayer");
        r2.putExtra("auto_enter_call_user", r1);
        return x.f38692a;
    }
}
