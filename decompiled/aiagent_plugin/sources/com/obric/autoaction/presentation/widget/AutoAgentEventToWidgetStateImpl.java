package com.obric.autoaction.presentation.widget;

import android.content.Context;
import android.os.Bundle;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.a.d;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.eventkit.task.model.TimerTaskAction;
import com.obric.eventkit.task.model.TimerTaskV2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AutoAgentEventToWidgetStateImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoAgentEventToWidgetStateImpl implements IAutoActionAgentEventListener, IAutoAgentWidgetStateListener {
    public static final a Companion = null;
    private static final f<List<String>> positiveBtnWords$delegate = null;
    private final /* synthetic */ com.obric.autoaction.presentation.widget.b $$delegate_0;
    private BizStatus currentBizStatus;
    private IAutoActionAgentEventListener.AgentStepInfo currentStep;
    private QueueStatus lastQueueStatus;
    private IAutoActionAgentEventListener.OperatingAppInfo operatingApp;

    /* JADX INFO: compiled from: AutoAgentEventToWidgetStateImpl.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.autoaction.presentation.widget.AutoAgentEventToWidgetStateImpl$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class C0602a<T> implements Comparator {
            public C0602a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r2, T r3) {
                return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Boolean.valueOf(((IAutoAgentWidgetStateListener.ClarifyOptions) ZeusTransformUtils.preCheckCast(r2, IAutoAgentWidgetStateListener.ClarifyOptions.class, "com.obric.aiagent.plugin")).getHighLight()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Boolean.valueOf(((IAutoAgentWidgetStateListener.ClarifyOptions) ZeusTransformUtils.preCheckCast(r3, IAutoAgentWidgetStateListener.ClarifyOptions.class, "com.obric.aiagent.plugin")).getHighLight()), Comparable.class, "com.obric.aiagent.plugin"));
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        private final List<String> a() {
            return (List) ZeusTransformUtils.preCheckCast(AutoAgentEventToWidgetStateImpl.access$getPositiveBtnWords$delegate$cp().b(), List.class, "com.obric.aiagent.plugin");
        }

        public final List<IAutoAgentWidgetStateListener.ClarifyOptions> a(IAutoActionAgentEventListener.AgentStepInfo r11) {
            o.e(r11, "<this>");
            Bundle r0 = r11.getExtras();
            List<Boolean> r1 = null;
            if (r0 == null) goto L71;
            String[] r2 = r0.getStringArray("clarify_options");
            if (r2 == null) goto L71;
            List r3 = i.g(r2);
            if (r3 == null) goto L71;
            int r4 = 0;
            if (r3.size() != 2) goto L11;
            boolean r5 = true;
        L12:
            if (r5 == true) goto L15;
            r3 = null;
        L15:
            if (r3 == null) goto L71;
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r8 = r6.iterator();
        L18:
            if (r8.hasNext() == false) goto L32;
            Object r9 = r8.next();
            String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
            o.a(r10);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L22;
            boolean r12 = true;
        L23:
            if (r12 == true) goto L25;
        L29:
            boolean r13 = false;
        L30:
            if (r13 == false) goto L18;
            r7.add(r9);
            goto L18
        L25:
            if (r10.length() < 1) goto L29;
            if (r10.length() > 5) goto L29;
            r13 = true;
            goto L30
        L22:
            r12 = false;
            goto L23
        L32:
            List r14 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
            if (r14.size() != 2) goto L35;
            boolean r15 = true;
        L36:
            if (r15 == true) goto L39;
            r14 = null;
        L39:
            if (r14 == null) goto L71;
            Bundle r16 = r11.getExtras();
            if (r16 == null) goto L46;
            boolean[] r17 = r16.getBooleanArray("clarify_positiveness");
            if (r17 == null) goto L46;
            r1 = i.b(r17);
        L46:
            if (r1 != null) goto L48;
        L58:
            boolean r18 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.aiagent.plugin")).isEmpty();
            Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
            Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r19, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r20 = r19.iterator();
        L60:
            if (r20.hasNext() == false) goto L70;
            String r21 = (String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.aiagent.plugin");
            o.a(r21);
            if (r18 == false) goto L64;
        L67:
            boolean r22 = true;
        L68:
            r110.add(new IAutoAgentWidgetStateListener.ClarifyOptions(r21, r22));
            goto L60
        L64:
            if (AutoAgentEventToWidgetStateImpl.Companion.a().contains(r21) == true) goto L67;
            r22 = false;
            goto L68
        L70:
            return p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0602a(), Comparator.class, "com.obric.aiagent.plugin"));
        L48:
            if (r1.size() != r14.size()) goto L58;
            Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
            Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r111, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r113 = r111.iterator();
        L51:
            if (r113.hasNext() == false) goto L57;
            Object r23 = r113.next();
            int r24 = r4 + 1;
            if (r4 >= 0) goto L55;
            p.c();
        L55:
            String r25 = (String) ZeusTransformUtils.preCheckCast(r23, String.class, "com.obric.aiagent.plugin");
            o.a(r25);
            r112.add(new IAutoAgentWidgetStateListener.ClarifyOptions(r25, ((Boolean) ZeusTransformUtils.preCheckCast(r1.get(r4), Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));
            r4 = r24;
            goto L51
        L57:
            return (List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.aiagent.plugin");
        L35:
            r15 = false;
            goto L36
        L11:
            r5 = false;
        L71:
            return null;
        }

        public final IAutoAgentWidgetStateListener.ClarifyType b(IAutoActionAgentEventListener.AgentStepInfo r1) {
            o.e(r1, "<this>");
            Bundle r0 = r1.getExtras();
            if (r0 == null) goto L9;
            String r2 = r0.getString("clarify_type");
            if (r2 == null) goto L9;
            IAutoAgentWidgetStateListener.ClarifyType r3 = IAutoAgentWidgetStateListener.ClarifyType.valueOf(r2);
            if (r3 == null) goto L9;
            return r3;
        L9:
            return IAutoAgentWidgetStateListener.ClarifyType.NORMAL;
        }

        public final IAutoAgentWidgetStateListener.ClarifyBlackListParams c(IAutoActionAgentEventListener.AgentStepInfo r2) {
            o.e(r2, "<this>");
            Bundle r1 = r2.getExtras();
            if (r1 == null) goto L7;
            String r3 = r1.getString("clarify_blacklist_params");
            if (r3 == null) goto L7;
            return (IAutoAgentWidgetStateListener.ClarifyBlackListParams) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r3, IAutoAgentWidgetStateListener.ClarifyBlackListParams.class), IAutoAgentWidgetStateListener.ClarifyBlackListParams.class, "com.obric.aiagent.plugin");
        L7:
            return null;
        }
    }

    /* JADX INFO: compiled from: AutoAgentEventToWidgetStateImpl.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25122a = null;

        static {
            int[] r0 = new int[BizStatus.values().length];
            r0[BizStatus.TERMINATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[BizStatus.OPERATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[BizStatus.PREPARING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[BizStatus.USER_INTERRUPTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f25122a = r0;
        }
    }

    public static /* synthetic */ List lambda$U2xKovkuZ6Cfj1OkjM7igP7yTq8() {
        return positiveBtnWords_delegate$lambda$1();
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onCallUser(WidgetState.CallUser r2) {
        o.e(r2, "state");
        this.$$delegate_0.onCallUser(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onClarify(WidgetState.Clarify r2) {
        o.e(r2, "state");
        this.$$delegate_0.onClarify(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onLastStep(WidgetState.LastStep r2) {
        o.e(r2, "state");
        this.$$delegate_0.onLastStep(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onOperating(WidgetState.Operating r2) {
        o.e(r2, "state");
        this.$$delegate_0.onOperating(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPrepared(WidgetState.Prepared r2) {
        o.e(r2, "state");
        this.$$delegate_0.onPrepared(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onPreparing(WidgetState.Preparing r2) {
        o.e(r2, "state");
        this.$$delegate_0.onPreparing(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onQueue(WidgetState.Queue r2) {
        o.e(r2, "state");
        this.$$delegate_0.onQueue(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onSetTimerTask(WidgetState.SetTimerTask r2) {
        o.e(r2, "state");
        this.$$delegate_0.onSetTimerTask(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateChange(WidgetState r2, WidgetState r3) {
        o.e(r3, "state");
        this.$$delegate_0.onStateChange(r2, r3);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onStateWillChange(WidgetState r2, WidgetState r3) {
        o.e(r3, "state");
        this.$$delegate_0.onStateWillChange(r2, r3);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onTerminate(WidgetState.Terminated r2) {
        o.e(r2, "state");
        this.$$delegate_0.onTerminate(r2);
    }

    @Override // com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener
    public void onUserInterrupt(WidgetState.UserInterrupt r2) {
        o.e(r2, "state");
        this.$$delegate_0.onUserInterrupt(r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return Integer.MAX_VALUE;
    }

    public AutoAgentEventToWidgetStateImpl() {
        this.$$delegate_0 = com.obric.autoaction.presentation.widget.b.f25155a;
    }

    public static final /* synthetic */ f access$getPositiveBtnWords$delegate$cp() {
        return positiveBtnWords$delegate;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onSessionEnqueued(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onUIOperationHangup(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onUIOperationHangup(this, r1);
    }

    static {
        Companion = new a(null);
        positiveBtnWords$delegate = g.a($$Lambda$AutoAgentEventToWidgetStateImpl$U2xKovkuZ6Cfj1OkjM7igP7yTq8.INSTANCE);
    }

    private static final List positiveBtnWords_delegate$lambda$1() {
        String[] r0 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getStringArray(ZeusTransformUtils.mapRes(R.array.obric_widget_positive_btn_words, "array", "obric_widget_positive_btn_words"));
        o.c(r0, "getStringArray(...)");
        return i.g((Object[]) ZeusTransformUtils.preCheckCast(r0, Object[].class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, BizStatus r2, BizStatus r3, int r4, BizStatus.StatusChangedReasonStruct r5, Bundle r6) {
        o.e(r1, "sessionInfo");
        o.e(r2, "oldStatus");
        o.e(r3, "status");
        o.e(r5, "reasonDetails");
        this.currentBizStatus = r3;
        int r7 = b.f25122a[r3.ordinal()];
        if (r7 != 1) goto L5;
        onTerminate(new WidgetState.Terminated(r1));
        return;
    L5:
        if (r7 == 2) goto L14;
        if (r7 != 3) goto L9;
        this.lastQueueStatus = null;
        this.operatingApp = null;
        this.currentStep = null;
        onPreparing(new WidgetState.Preparing(r1));
        return;
    L9:
        if (r7 != 4) goto L34;
        onUserInterrupt(new WidgetState.UserInterrupt(r1, this.operatingApp));
        return;
    L34:
        return;
    L14:
        if (r2 != BizStatus.PAUSED) goto L21;
        if (this.operatingApp != null) goto L21;
        if (r4 != 1401) goto L21;
        onOperating(new WidgetState.Operating(r1, this.operatingApp, null, r4));
        return;
    L21:
        if (r2 != BizStatus.PREPARING) goto L23;
    L26:
        onPrepared(new WidgetState.Prepared(r1));
        return;
    L23:
        if (this.operatingApp == null) goto L26;
        onOperating(new WidgetState.Operating(r1, this.operatingApp, null, r4));
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(IAutoActionAgentEventListener.SessionInfo r2, QueueStatus r3) {
        o.e(r2, "sessionInfo");
        o.e(r3, "queueStatus");
        IAutoActionAgentEventListener.DefaultImpls.onQueueStatusChanged(this, r2, r3);
        if (this.lastQueueStatus == null) goto L5;
    L6:
        onQueue(new WidgetState.Queue(r2, r3));
    L7:
        this.lastQueueStatus = r3;
        return;
    L5:
        if (r3.isQueueCompleted() == true) goto L7;
        goto L6
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r9, IAutoActionAgentEventListener.AgentStepInfo r10) {
        o.e(r9, "sessionInfo");
        o.e(r10, "stepInfo");
        IAutoActionAgentEventListener.DefaultImpls.onAgentStep(this, r9, r10);
        this.currentStep = r10;
        if (r10.isLastStep() == false) goto L26;
        int r1 = 1;
        if (r10.isSuccess() == false) goto L7;
        int r0 = 0;
    L11:
        Bundle r2 = r10.getExtras();
        if (r2 == null) goto L14;
        boolean r3 = r2.getBoolean("model_success");
    L16:
        if (r0 == 0) goto L21;
        if (r0 == 2) goto L20;
        r1 = 3;
    L19:
        int r7 = r1;
    L24:
        onLastStep(new WidgetState.LastStep(r9, r10, this.operatingApp, isPureTimerTask(r9), r7));
        return;
    L20:
        r7 = 2;
        goto L24
    L21:
        if (r3 == true) goto L19;
        r1 = 4;
        goto L19
    L14:
        r3 = true;
        goto L16
    L7:
        Bundle r4 = r10.getExtras();
        if (r4 == null) goto L10;
        r0 = r4.getInt("term_reason_type");
        goto L11
    L10:
        r0 = 1;
        goto L11
    L26:
        int r5 = r10.getActionType();
        if (r5 != d.b.f27243b.getIdentifier()) goto L32;
        if (this.operatingApp == null) goto L49;
        onOperating(new WidgetState.Operating(r9, this.operatingApp, r10, com.obric.autogui.session.state.a.h.b.f31241a.a()));
        return;
    L49:
        return;
    L32:
        if (r5 != d.b.f27244c.getIdentifier()) goto L39;
        Bundle r6 = r10.getExtras();
        if (r6 == null) goto L36;
        String r8 = r6.getString("action_for_user");
    L37:
        onCallUser(new WidgetState.CallUser(r9, r10, r8));
        return;
    L36:
        r8 = null;
        goto L37
    L39:
        if (r5 != d.b.f27245d.getIdentifier()) goto L42;
        a r11 = Companion;
        onClarify(new WidgetState.Clarify(r9, r10, r11.a(r10), r11.b(r10), r11.c(r10)));
        return;
    L42:
        if (r5 != d.b.f27246e.getIdentifier()) goto L44;
        return;
    L44:
        if (r5 == d.b.f.getIdentifier()) goto L46;
        return;
    L46:
        if (this.operatingApp == null) goto L55;
        onOperating(new WidgetState.Operating(r9, this.operatingApp, r10, com.obric.autogui.session.state.a.h.b.f31241a.a()));
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r10, IAutoActionAgentEventListener.AgentStepInfo r11, IAutoActionAgentEventListener.AgentStepExecInfo r12) {
        o.e(r10, "sessionInfo");
        o.e(r11, "stepInfo");
        o.e(r12, "execInfo");
        if (r11.getActionType() != 4) goto L35;
        Object r13 = r12.getPayload();
        Object r0 = null;
        if (ZeusTransformUtils.instanceOf(r13, TimerTaskV2.class) == false) goto L7;
        TimerTaskV2 r14 = (TimerTaskV2) ZeusTransformUtils.preCheckCast(r13, TimerTaskV2.class, "com.obric.aiagent.plugin");
    L8:
        if (r14 == null) goto L36;
        n.a r15 = n.f38560a;     // Catch: Throwable -> L11
        Object r16 = n.f((TimerTaskAction) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r14.getAction(), TimerTaskAction.class), TimerTaskAction.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
    L14:
        if (n.b(r16) == true) goto L17;
        r0 = r16;
    L17:
        TimerTaskAction r17 = (TimerTaskAction) ZeusTransformUtils.preCheckCast(r0, TimerTaskAction.class, "com.obric.aiagent.plugin");
        String r3 = r14.getId();
        String r4 = r14.getCronExpr();
        if (r17 == null) goto L23;
        String r18 = r17.getQuery();
        if (r18 == null) goto L23;
        String r5 = r18;
    L24:
        Map<String, String> r19 = r14.getExt();
        if (r19 == null) goto L30;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r19.get("timeCondition"), String.class, "com.obric.aiagent.plugin");
        if (r110 == null) goto L30;
        String r6 = r110;
    L31:
        onSetTimerTask(new WidgetState.SetTimerTask(r10, new IAutoAgentWidgetStateListener.TimerTask(r3, r4, r5, r6, r14.isRepeat())));
        return;
    L30:
        r6 = "";
    L23:
        r5 = "";
    L11:
        th = move-exception;
        n.a r2 = n.f38560a;
        r16 = n.f(d.o.a(th));
        goto L14
    L36:
        return;
    L7:
        r14 = null;
        goto L8
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r4, IAutoActionAgentEventListener.OperatingAppInfo r5) {
        o.e(r4, "sessionInfo");
        if (this.operatingApp == null) goto L10;
        if (r5 == null) goto L6;
        String r0 = r5.getPackageName();
    L8:
        if (o.a(r0, "com.android.permissioncontroller") == false) goto L10;
        return;
    L6:
        r0 = null;
    L10:
        this.operatingApp = r5;
        if (this.currentBizStatus == BizStatus.OPERATING) goto L13;
        return;
    L13:
        IAutoActionAgentEventListener.AgentStepInfo r6 = this.currentStep;
        boolean r1 = true;
        if (r6 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == true) goto L30;
        IAutoActionAgentEventListener.AgentStepInfo r8 = this.currentStep;
        if (r8 != null) goto L23;
    L25:
        r1 = false;
    L26:
        if (r1 == true) goto L31;
        onOperating(new WidgetState.Operating(r4, this.operatingApp, this.currentStep, com.obric.autogui.session.state.a.h.b.f31241a.a()));
        return;
    L31:
        return;
    L23:
        if (r8.getActionType() != 3) goto L25;
    L30:
        return;
    L16:
        if (r6.getActionType() != 2) goto L18;
        r7 = true;
        goto L19
    }

    private final boolean isPureTimerTask(IAutoActionAgentEventListener.SessionInfo r3) {
        Object r2 = r3.getTask().getInternalExtras().get("_set_timer_task_success");
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L5;
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin");
    L6:
        boolean r5 = o.a(r4, true);
        boolean r6 = r3.getNoActionStep();
        if (r5 == false) goto L10;
        if (r6 == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r4 = null;
        goto L6
    }
}
