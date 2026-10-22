package com.obric.autoaction.presentation.widget;

import com.obric.autoaction.presentation.doubao.AssistRemoteCardUpdateImpl;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: AutoAgentWidgetStateDispatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements IAutoAgentWidgetStateListener {
    private static final String TAG = "AutoAgentWidgetStateDispatch";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f25155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WidgetState f25156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f25157c;

    static {
        f25155a = new b();
    }

    private final void a(Set<? extends IAutoAgentWidgetStateListener> r2) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
    }

    private static final String b() {
        return "triggerListeners error";
    }

    /* JADX INFO: renamed from: lambda$0H_m0LTaZMpf-jGE_2WcfzHe99E, reason: not valid java name */
    public static /* synthetic */ x m640lambda$0H_m0LTaZMpfjGE_2WcfzHe99E(WidgetState.Prepared r0, IAutoAgentWidgetStateListener r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$9KAA9FoH1IqA2d1Tzc2eSWpUdW8(WidgetState.Terminated r0, IAutoAgentWidgetStateListener r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$9Zy1Jz22C-P0xAT09AkI_oH5EFA, reason: not valid java name */
    public static /* synthetic */ x m641lambda$9Zy1Jz22CP0xAT09AkI_oH5EFA(WidgetState r0, WidgetState r1, IAutoAgentWidgetStateListener r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$HDlohl3V0bafCqHHRq0JeFx09Rc(WidgetState.Queue r0, IAutoAgentWidgetStateListener r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$LupDrF_ZnLusEeYleaXh7t8q9jc(WidgetState.Preparing r0, IAutoAgentWidgetStateListener r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$N6aKv9n10we1-chJPzX2YHW5Duo, reason: not valid java name */
    public static /* synthetic */ x m642lambda$N6aKv9n10we1chJPzX2YHW5Duo(WidgetState.LastStep r0, IAutoAgentWidgetStateListener r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$Oxc_tZ2SuVFDOgY9XQIutYSCcUE(WidgetState r0, WidgetState r1, IAutoAgentWidgetStateListener r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$fwgbO8_hH1_8P1ae_LSxouNx_g4(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ x lambda$jIg_mLJLkds7cjbtOmbDBDvRa9A(WidgetState.SetTimerTask r0, IAutoAgentWidgetStateListener r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$lm90AandnWaKndlIH30DfZ0Z8Fg(WidgetState.UserInterrupt r0, IAutoAgentWidgetStateListener r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$md2xARgwJqiaBmaV-SpBfgdTMr0, reason: not valid java name */
    public static /* synthetic */ x m643lambda$md2xARgwJqiaBmaVSpBfgdTMr0(WidgetState.Clarify r0, IAutoAgentWidgetStateListener r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$sVdfrkQ5AYr-di_Su3zl3yqaO68, reason: not valid java name */
    public static /* synthetic */ String m644lambda$sVdfrkQ5AYrdi_Su3zl3yqaO68() {
        return b();
    }

    public static /* synthetic */ x lambda$xMvF19UT0aDqjYF1tzgV1ixx8yU(WidgetState.Operating r0, IAutoAgentWidgetStateListener r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$xZ_O8zVnJ9egFpHSggoM2cpR7uQ(WidgetState.CallUser r0, IAutoAgentWidgetStateListener r1) {
        return a(r0, r1);
    }

    private b() {
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPreparing(final WidgetState.Preparing r5) {
        o.e(r5, "state");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d(TAG, "onPreparing: sessionInfo=" + r5.getSessionInfo());
    L6:
        f25157c = false;
        onStateWillChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        a(new $$Lambda$b$LupDrF_ZnLusEeYleaXh7t8q9jc(r5));
        onStateChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        Loog.INSTANCE.d(TAG, "onPreparing: sessionId=" + r5.getSessionInfo().getSessionId() + ", key=" + r5.getSessionInfo().getSessionKey());
        goto L6
    }

    private static final x a(WidgetState.Preparing r2, IAutoAgentWidgetStateListener r3) {
        IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        f25156b = null;
        r4.onPreparing(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onQueue(final WidgetState.Queue r6) {
        o.e(r6, "state");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d(TAG, "onQueue: sessionInfo=" + r6.getSessionInfo() + ' ' + r6.getQueueStatus());
    L6:
        onStateWillChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r6, WidgetState.class, "com.obric.aiagent.plugin"));
        a(new $$Lambda$b$HDlohl3V0bafCqHHRq0JeFx09Rc(r6));
        onStateChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r6, WidgetState.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        Loog.INSTANCE.d(TAG, "onQueue: sessionId=" + r6.getSessionInfo().getSessionId() + ", key=" + r6.getSessionInfo().getSessionKey() + ' ' + r6.getQueueStatus());
        goto L6
    }

    private static final x a(WidgetState.Queue r2, IAutoAgentWidgetStateListener r3) {
        IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onQueue(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPrepared(final WidgetState.Prepared r5) {
        o.e(r5, "state");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d(TAG, "onPrepared: sessionInfo=" + r5.getSessionInfo());
    L6:
        onStateWillChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        a(new $$Lambda$b$0H_m0LTaZMpfjGE_2WcfzHe99E(r5));
        onStateChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        Loog.INSTANCE.d(TAG, "onPrepared: sessionId=" + r5.getSessionInfo().getSessionId() + ", key=" + r5.getSessionInfo().getSessionKey());
        goto L6
    }

    private static final x a(WidgetState.Prepared r2, IAutoAgentWidgetStateListener r3) {
        IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onPrepared(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onTerminate(final WidgetState.Terminated r5) {
        o.e(r5, "state");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d(TAG, "onTerminate: sessionInfo=" + r5.getSessionInfo());
    L6:
        onStateWillChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        a(new $$Lambda$b$9KAA9FoH1IqA2d1Tzc2eSWpUdW8(r5));
        onStateChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        Loog.INSTANCE.d(TAG, "onTerminate: sessionId=" + r5.getSessionInfo().getSessionId() + ", key=" + r5.getSessionInfo().getSessionKey());
        goto L6
    }

    private static final x a(WidgetState.Terminated r2, IAutoAgentWidgetStateListener r3) {
        IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onTerminate(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onOperating(final WidgetState.Operating r5) {
        o.e(r5, "state");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d(TAG, "onOperating: sessionInfo=" + r5.getSessionInfo() + ", step=" + r5.getStepInfo() + " app=" + r5.getOperatingApp());
    L7:
        if (a() == false) goto L9;
        return;
    L9:
        onStateWillChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        a(new $$Lambda$b$xMvF19UT0aDqjYF1tzgV1ixx8yU(r5));
        onStateChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        Loog.INSTANCE.d(TAG, "onOperating:");
        goto L7
    }

    private static final x a(WidgetState.Operating r2, IAutoAgentWidgetStateListener r3) {
        IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onOperating(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onLastStep(final WidgetState.LastStep r15) {
        o.e(r15, "state");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L9;
        Loog r0 = Loog.INSTANCE;
        StringBuilder r3 = new StringBuilder().append("onLastStep: step=").append(r15.getStepInfo()).append("  ");
        Set r4 = ServiceManager.get().getServices(IAutoAgentWidgetStateListener.class);
        o.c(r4, "getServices(...)");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r6.add(aa.b(((IAutoAgentWidgetStateListener) ZeusTransformUtils.preCheckCast(r7.next(), IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin")).getClass()).b());
        goto L6
    L8:
        r0.d(TAG, r3.append(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null)).toString());
    L10:
        f25157c = true;
        onStateWillChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r15, WidgetState.class, "com.obric.aiagent.plugin"));
        a(new $$Lambda$b$N6aKv9n10we1chJPzX2YHW5Duo(r15));
        onStateChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r15, WidgetState.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        Loog.INSTANCE.d(TAG, "onLastStep: lastStep=" + r15.getStepInfo().isLastStep() + ", action=" + r15.getStepInfo().getActionProtocolType() + ", success=" + r15.getStepInfo().isSuccess());
        goto L10
    }

    private static final x a(WidgetState.LastStep r2, IAutoAgentWidgetStateListener r3) {
        IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onLastStep(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onUserInterrupt(final WidgetState.UserInterrupt r5) {
        o.e(r5, "state");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d(TAG, "onUserInterrupt: sessionInfo=" + r5.getSessionInfo());
    L7:
        if (a() == false) goto L9;
        return;
    L9:
        onStateWillChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        a(new $$Lambda$b$lm90AandnWaKndlIH30DfZ0Z8Fg(r5));
        onStateChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        Loog.INSTANCE.d(TAG, "onUserInterrupt: sessionId=" + r5.getSessionInfo().getSessionId() + ", key=" + r5.getSessionInfo().getSessionKey());
        goto L7
    }

    private static final x a(WidgetState.UserInterrupt r2, IAutoAgentWidgetStateListener r3) {
        IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onUserInterrupt(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onCallUser(final WidgetState.CallUser r4) {
        o.e(r4, "state");
        Loog.INSTANCE.d(TAG, "onCallUser");
        if (a() == false) goto L5;
        return;
    L5:
        onStateWillChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r4, WidgetState.class, "com.obric.aiagent.plugin"));
        a(new $$Lambda$b$xZ_O8zVnJ9egFpHSggoM2cpR7uQ(r4));
        onStateChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r4, WidgetState.class, "com.obric.aiagent.plugin"));
    }

    private static final x a(WidgetState.CallUser r2, IAutoAgentWidgetStateListener r3) {
        IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onCallUser(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onClarify(final WidgetState.Clarify r4) {
        o.e(r4, "state");
        Loog.INSTANCE.d(TAG, "onClarify");
        if (a() == false) goto L5;
        return;
    L5:
        onStateWillChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r4, WidgetState.class, "com.obric.aiagent.plugin"));
        a(new $$Lambda$b$md2xARgwJqiaBmaVSpBfgdTMr0(r4));
        onStateChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r4, WidgetState.class, "com.obric.aiagent.plugin"));
    }

    private static final x a(WidgetState.Clarify r2, IAutoAgentWidgetStateListener r3) {
        IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onClarify(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onSetTimerTask(final WidgetState.SetTimerTask r5) {
        o.e(r5, "state");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d(TAG, "onSetTimerTask: sessionInfo=" + r5.getSessionInfo());
    L6:
        onStateWillChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        a(new $$Lambda$b$jIg_mLJLkds7cjbtOmbDBDvRa9A(r5));
        onStateChange(f25156b, (WidgetState) ZeusTransformUtils.preCheckCast(r5, WidgetState.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        Loog.INSTANCE.d(TAG, "onSetTimerTask: sessionId=" + r5.getSessionInfo().getSessionId() + ", key=" + r5.getSessionInfo().getSessionKey());
        goto L6
    }

    private static final x a(WidgetState.SetTimerTask r2, IAutoAgentWidgetStateListener r3) {
        IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$triggerListeners");
        r4.onSetTimerTask(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateChange(final WidgetState r2, final WidgetState r3) {
        o.e(r3, "state");
        IAutoAgentWidgetStateListener.DefaultImpls.onStateChange(this, r2, r3);
        a(new $$Lambda$b$Oxc_tZ2SuVFDOgY9XQIutYSCcUE(r2, r3));
        f25156b = r3;
    }

    private static final x a(WidgetState r2, WidgetState r3, IAutoAgentWidgetStateListener r4) {
        IAutoAgentWidgetStateListener r5 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r4, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r5, "$this$triggerListeners");
        r5.onStateChange(r2, r3);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateWillChange(final WidgetState r2, final WidgetState r3) {
        o.e(r3, "state");
        IAutoAgentWidgetStateListener.DefaultImpls.onStateWillChange(this, r2, r3);
        a(new $$Lambda$b$9Zy1Jz22CP0xAT09AkI_oH5EFA(r2, r3));
    }

    private static final x b(WidgetState r2, WidgetState r3, IAutoAgentWidgetStateListener r4) {
        IAutoAgentWidgetStateListener r5 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r4, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        o.e(r5, "$this$triggerListeners");
        r5.onStateWillChange(r2, r3);
        return x.f38692a;
    }

    private final boolean a() {
        if (f25157c == false) goto L5;
        Loog.INSTANCE.d(TAG, "reach last step , skip this event");
        return true;
    L5:
        return false;
    }

    private final void a(d.h.a.b<? super IAutoAgentWidgetStateListener, x> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        Set<? extends IAutoAgentWidgetStateListener> r0 = ServiceManager.get().getServices(IAutoAgentWidgetStateListener.class);
        o.a(r0);
        a(r0);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        IAutoAgentWidgetStateListener r1 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.preCheckCast(r5.next(), IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        b r2 = f25155a;     // Catch: Exception -> L10
        o.a(r1);     // Catch: Exception -> L10
        if (r2.a(r1) == true) goto L4;
        r7.invoke(r1);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Loog.INSTANCE.ep(TAG, new $$Lambda$b$fwgbO8_hH1_8P1ae_LSxouNx_g4(e), $$Lambda$b$sVdfrkQ5AYrdi_Su3zl3yqaO68.INSTANCE);
        goto L4
    }

    private static final String a(Exception r2) {
        return "triggerListeners error " + r2.getMessage();
    }

    private final boolean a(IAutoAgentWidgetStateListener r4) {
        IAutoAgentWidgetStateListener r3 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r4, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.SessionInfo r5 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getOngoingSessionInfo().a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        AutoOperateTask r6 = r5.getTask();
        if (r6 == null) goto L9;
        if (r6.isOmni() != true) goto L9;
        boolean r7 = true;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autoaction.presentation.island.state.a.class) == false) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r7 == false) goto L21;
        if (r8 == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, AssistRemoteCardUpdateImpl.class) == true) goto L16;
        r8 = false;
    L9:
        r7 = false;
        goto L11
    }
}
