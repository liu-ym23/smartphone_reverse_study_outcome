package com.obric.autoaction.presentation.input;

import com.obric.autoaction.presentation.input.states.c;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AssistInputState;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.autogui.common.api.presentation.api.IAssistInputStateManager;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.common.e;
import com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.s;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AssistInputUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistInputUIState$initAssistInputUIState$1 extends IAssistantInteractionListener.Stub {

    /* JADX INFO: compiled from: AssistInputUIState.kt */
    @f(b = "AssistInputUIState.kt", c = {62}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.input.AssistInputUIState$initAssistInputUIState$1$onAssistantTakeOver$3")
    static final class a extends l implements m<am, d<? super e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24955a;

        a(d<? super a> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d<? super e> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new a((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super e> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24955a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            AutoActionAgent r6 = AutoActionAgent.INSTANCE;
            d<? super e> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f24955a = 1;
            r5 = r6.startFunction("ManualOperating", r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$-J4fLhgl1GQAMjemG_gqza5VEQk, reason: not valid java name */
    public static /* synthetic */ String m622lambda$J4fLhgl1GQAMjemG_gqza5VEQk(String r0) {
        return onReply$lambda$3(r0);
    }

    /* JADX INFO: renamed from: lambda$0DG9dFQwopfyaCNH0ip-_qOWbUo, reason: not valid java name */
    public static /* synthetic */ String m623lambda$0DG9dFQwopfyaCNH0ip_qOWbUo(int r0) {
        return onPanelHeightChanged$lambda$10(r0);
    }

    public static /* synthetic */ String lambda$WwDlMNcJuTSou2zmoGDDGhGT3ws(int r0) {
        return onPanelShow$lambda$7(r0);
    }

    public static /* synthetic */ String lambda$d53uT1ydHPkGQb0l6ZXb_xBbz0k() {
        return onPanelShow$lambda$8();
    }

    /* JADX INFO: renamed from: lambda$haXg3wJtBT8Q--StDLMQG2LFaXw, reason: not valid java name */
    public static /* synthetic */ String m624lambda$haXg3wJtBT8QStDLMQG2LFaXw(boolean r0) {
        return onAssistantTakeOver$lambda$0(r0);
    }

    public static /* synthetic */ String lambda$pjzxsqQvbLIaGBIqZ_gDInpnq7M() {
        return onReply$lambda$4();
    }

    public static /* synthetic */ String lambda$x3trw49PgL50ghMKHxHqe9ulIKg() {
        return onPanelHeightChanged$lambda$11();
    }

    public static /* synthetic */ String lambda$z1kaNbPkdG99B0i1WCIYSf7cMFU() {
        return onAssistantTakeOver$lambda$1();
    }

    private static final String onAssistantTakeOver$lambda$1() {
        return "onAssist TakeOver";
    }

    private static final String onPanelHeightChanged$lambda$11() {
        return "onPanelHeightChanged";
    }

    private static final String onPanelShow$lambda$8() {
        return "onPanelShow";
    }

    private static final String onReply$lambda$4() {
        return "onReply";
    }

    AssistInputUIState$initAssistInputUIState$1() {
    }

    @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
    public void onAssistantTakeOver() {
        final boolean r4 = AssistantAbilityHelper.INSTANCE.isChatPageInVD();
        Loog.INSTANCE.dp("AssistInputUIState", new $$Lambda$AssistInputUIState$initAssistInputUIState$1$haXg3wJtBT8QStDLMQG2LFaXw(r4), $$Lambda$AssistInputUIState$initAssistInputUIState$1$z1kaNbPkdG99B0i1WCIYSf7cMFU.INSTANCE);
        if (r4 == true) goto L5;
        return;
    L5:
        if (((GlobalUIContext) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState().c(), GlobalUIContext.class, "com.obric.aiagent.plugin")).getPlayer().getVisible() != IAutoActionPresentationApi.PlayerVisibility.Visible) goto L9;
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final String onAssistantTakeOver$lambda$0(boolean r2) {
        return "onAssist TakeOver (chatPageInVd=" + r2 + ')';
    }

    @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
    public void onAssistantDied() {
        Loog.INSTANCE.d("AssistInputUIState", "onAssist Died");
        kotlinx.coroutines.b.x<GlobalUIContext> r9 = AutoActionUIContext.INSTANCE.getState();
    L3:
        GlobalUIContext r0 = r9.c();
        GlobalUIContext r2 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r0, GlobalUIContext.class, "com.obric.aiagent.plugin");
        if (r9.a(r0, GlobalUIContext.copy$default(r2, null, null, r2.getAssistState().copy(false, null), null, 11, null)) == false) goto L3;
    }

    private static final String onReply$lambda$3(String r2) {
        return "onReply " + r2;
    }

    @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
    public void onReply(final String r11) {
        Loog.INSTANCE.dp("AssistInputUIState", new $$Lambda$AssistInputUIState$initAssistInputUIState$1$J4fLhgl1GQAMjemG_gqza5VEQk(r11), $$Lambda$AssistInputUIState$initAssistInputUIState$1$pjzxsqQvbLIaGBIqZ_gDInpnq7M.INSTANCE);
        kotlinx.coroutines.b.x<GlobalUIContext> r10 = AutoActionUIContext.INSTANCE.getState();
    L3:
        GlobalUIContext r0 = r10.c();
        GlobalUIContext r3 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r0, GlobalUIContext.class, "com.obric.aiagent.plugin");
        if (r10.a(r0, GlobalUIContext.copy$default(r3, null, null, AssistInputState.copy$default(r3.getAssistState(), false, null, 2, null), null, 11, null)) == false) goto L3;
        IAssistInputStateManager.DefaultImpls.launchStateChange$default((IAssistInputStateManager) ZeusTransformUtils.preCheckCast(c.f25027a, IAssistInputStateManager.class, "com.obric.aiagent.plugin"), IAssistInputStateManager.StateType.InputCompleted, null, ao.a(s.a("sc_inputted_text", String.valueOf(r11))), 2, null);
    }

    @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
    public void onPanelCancel() {
        Loog.INSTANCE.d("AssistInputUIState", "onPanelCancel");
        if (ZeusTransformUtils.instanceOf(((GlobalUIContext) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState().c(), GlobalUIContext.class, "com.obric.aiagent.plugin")).getWidgetState(), WidgetState.Clarify.class) == true) goto L5;
        b.f24958a.d();
    L5:
        kotlinx.coroutines.b.x<GlobalUIContext> r10 = AutoActionUIContext.INSTANCE.getState();
    L6:
        GlobalUIContext r0 = r10.c();
        GlobalUIContext r3 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r0, GlobalUIContext.class, "com.obric.aiagent.plugin");
        if (r10.a(r0, GlobalUIContext.copy$default(r3, null, null, r3.getAssistState().copy(false, null), null, 11, null)) == false) goto L6;
    }

    private static final String onPanelShow$lambda$7(int r2) {
        return "onPanelShow " + r2;
    }

    @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
    public void onPanelShow(final int r10) {
        Loog.INSTANCE.dp("AssistInputUIState", new $$Lambda$AssistInputUIState$initAssistInputUIState$1$WwDlMNcJuTSou2zmoGDDGhGT3ws(r10), $$Lambda$AssistInputUIState$initAssistInputUIState$1$d53uT1ydHPkGQb0l6ZXb_xBbz0k.INSTANCE);
        kotlinx.coroutines.b.x<GlobalUIContext> r9 = AutoActionUIContext.INSTANCE.getState();
    L3:
        GlobalUIContext r0 = r9.c();
        GlobalUIContext r2 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r0, GlobalUIContext.class, "com.obric.aiagent.plugin");
        if (r9.a(r0, GlobalUIContext.copy$default(r2, null, null, r2.getAssistState().copy(true, Integer.valueOf(r10)), null, 11, null)) == false) goto L3;
    }

    private static final String onPanelHeightChanged$lambda$10(int r2) {
        return "onPanelHeightChanged " + r2;
    }

    @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
    public void onPanelHeightChanged(final int r10) {
        Loog.INSTANCE.dp("AssistInputUIState", new $$Lambda$AssistInputUIState$initAssistInputUIState$1$0DG9dFQwopfyaCNH0ip_qOWbUo(r10), $$Lambda$AssistInputUIState$initAssistInputUIState$1$x3trw49PgL50ghMKHxHqe9ulIKg.INSTANCE);
        kotlinx.coroutines.b.x<GlobalUIContext> r9 = AutoActionUIContext.INSTANCE.getState();
    L3:
        GlobalUIContext r0 = r9.c();
        GlobalUIContext r2 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r0, GlobalUIContext.class, "com.obric.aiagent.plugin");
        if (r9.a(r0, GlobalUIContext.copy$default(r2, null, null, AssistInputState.copy$default(r2.getAssistState(), false, Integer.valueOf(r10), 1, null), null, 11, null)) == false) goto L3;
    }

    @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
    public void requestToShowInputPanel() {
        if (ZeusTransformUtils.instanceOf(((GlobalUIContext) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState().c(), GlobalUIContext.class, "com.obric.aiagent.plugin")).getWidgetState(), WidgetState.Clarify.class) == false) goto L6;
        b.a(b.f24958a, false, false, null, null, 12, null);
        return;
    }

    @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
    public void requestToShowInputPanelWithMeta(String r8) {
        d.h.b.o.e(r8, "meta");
        if (ZeusTransformUtils.instanceOf(((GlobalUIContext) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState().c(), GlobalUIContext.class, "com.obric.aiagent.plugin")).getWidgetState(), WidgetState.Clarify.class) == false) goto L6;
        b.a(b.f24958a, false, false, r8, null, 8, null);
        return;
    }
}
