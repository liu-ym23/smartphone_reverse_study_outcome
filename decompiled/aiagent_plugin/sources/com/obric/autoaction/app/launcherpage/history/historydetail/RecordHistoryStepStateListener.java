package com.obric.autoaction.app.launcherpage.history.historydetail;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.model.EventTaskExecutionDetailRecord;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: RecordHistoryStepStateListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RecordHistoryStepStateListener implements IAutoActionAgentEventListener {
    public static final a Companion = null;
    private static final String TAG = "RecordHistoryStepStateListener";
    private IAutoActionAgentEventListener.OperatingAppInfo sOperatingApp;

    /* JADX INFO: compiled from: RecordHistoryStepStateListener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: RecordHistoryStepStateListener.kt */
    @f(b = "RecordHistoryStepStateListener.kt", c = {139}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.history.historydetail.RecordHistoryStepStateListener$record$5")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f23850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f23851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f23852e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;
        final /* synthetic */ String h;
        final /* synthetic */ RecordHistoryStepStateListener i;

        b(String r3, long r4, String r6, String r7, String r8, int r9, String r10, RecordHistoryStepStateListener r11, d<? super b> r12) {
            d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
            this.f23849b = r3;
            this.f23850c = r4;
            this.f23851d = r6;
            this.f23852e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            super(2, r13);
        }

        /* JADX INFO: renamed from: lambda$G2awalcBpqOH1-oDgEetQKSmZQE, reason: not valid java name */
        public static /* synthetic */ String m517lambda$G2awalcBpqOH1oDgEetQKSmZQE(String r0, List r1) {
            return a(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$OgZRF9yxr0Z3oKil-VCh4NsJMEA, reason: not valid java name */
        public static /* synthetic */ String m518lambda$OgZRF9yxr0Z3oKilVCh4NsJMEA(String r0, RecordHistoryStepStateListener r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ String lambda$TSCTBy1AHGpnjVdkhxTSbCXHQmA(String r0) {
            return b(r0);
        }

        public static /* synthetic */ String lambda$shUlOOF92O6hWuVe0IQdObnKy30(String r0) {
            return a(r0);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r13, d<?> r14) {
            d r11 = (d) ZeusTransformUtils.wrapperContextForParams(r14, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f23849b, this.f23850c, this.f23851d, this.f23852e, this.f, this.g, this.h, this.i, r11), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r21) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f23848a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            o.a(r21);
            Object r3 = r21;
        L13:
            final List r4 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        L15:
            Loog r5 = Loog.INSTANCE;
            final String r6 = this.h;
            d.h.a.a<String> r7 = new $$Lambda$RecordHistoryStepStateListener$b$G2awalcBpqOH1oDgEetQKSmZQE(r6, r4);
            final String r0 = this.h;
            r5.ep(RecordHistoryStepStateListener.TAG, r7, new $$Lambda$RecordHistoryStepStateListener$b$TSCTBy1AHGpnjVdkhxTSbCXHQmA(r0));
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r21);
            Loog r8 = Loog.INSTANCE;
            final String r9 = this.h;
            final RecordHistoryStepStateListener r10 = this.i;
            d.h.a.a<String> r11 = new $$Lambda$RecordHistoryStepStateListener$b$OgZRF9yxr0Z3oKilVCh4NsJMEA(r9, r10);
            final String r12 = this.h;
            r8.ip(RecordHistoryStepStateListener.TAG, r11, new $$Lambda$RecordHistoryStepStateListener$b$shUlOOF92O6hWuVe0IQdObnKy30(r12));
            IEventTaskRecordApi r13 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L14;
            List<EventTaskExecutionDetailRecord> r14 = p.a(new EventTaskExecutionDetailRecord(0, this.f23849b, this.f23850c, this.f23851d, this.f23852e, this.f, this.g, null, 1, null));
            d<? super List<EventTaskExecutionDetailRecord>> r15 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23848a = 1;
            r3 = r13.addExecutionDetailRecords(r14, r15);
            if (r3 != r1) goto L13;
            return r1;
        L14:
            r4 = null;
            goto L15
        }

        private static final String a(String r1, RecordHistoryStepStateListener r2) {
            return r1 + "----- onBizStatusChanged, appInfo: " + r2.getSOperatingApp();
        }

        private static final String a(String r1) {
            return r1 + "----- onBizStatusChanged";
        }

        private static final String a(String r2, List r3) {
            return r2 + " result: " + ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        private static final String b(String r1) {
            return r1 + " result";
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ String lambda$61k1Z6acVC1VmHcVyQIY5DSGmCw(IAutoActionAgentEventListener.OperatingAppInfo r0) {
        return onOperatingAppChanged$lambda$0(r0);
    }

    public static /* synthetic */ String lambda$6ONACkJlKsQt7diJfu4KHdrvfRc(BizStatus r0, BizStatus r1, int r2, Bundle r3, RecordHistoryStepStateListener r4) {
        return onBizStatusChanged$lambda$2(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ String lambda$AD28rijWwzZO4gTM9FIiad2p5Hw(String r0, Integer r1, int r2, long r3) {
        return record$lambda$6(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$BQJzh9MZvZW5DirN-Y8BsIkWXrI, reason: not valid java name */
    public static /* synthetic */ String m515lambda$BQJzh9MZvZW5DirNY8BsIkWXrI(BizStatus r0, BizStatus r1, int r2) {
        return onBizStatusChanged$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$Hprqvts1i5Umh2YzCxP5KSVVCQw() {
        return onOperatingAppChanged$lambda$1();
    }

    public static /* synthetic */ String lambda$QCDOIOrXPR4QrRm3Rv6rkzLIAeM(Integer r0, String r1, String r2, int r3, long r4, String r6) {
        return record$lambda$5(r0, r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ String lambda$Zgy1BI4kTa1tVZJpEoL5ZXKFHMg(Integer r0, int r1, long r2) {
        return record$lambda$8(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$pFcfmbm2DzwoAA9wPA4Jgi-Welw, reason: not valid java name */
    public static /* synthetic */ String m516lambda$pFcfmbm2DzwoAA9wPA4JgiWelw(Integer r0, String r1, String r2, int r3, long r4, String r6) {
        return record$lambda$7(r0, r1, r2, r3, r4, r6);
    }

    private static final String onOperatingAppChanged$lambda$1() {
        return "onOperatingAppChanged";
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2, IAutoActionAgentEventListener.AgentStepExecInfo r3) {
        d.h.b.o.e(r1, "sessionInfo");
        d.h.b.o.e(r2, "stepInfo");
        d.h.b.o.e(r3, "execInfo");
    }

    public RecordHistoryStepStateListener() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, QueueStatus r2) {
        IAutoActionAgentEventListener.DefaultImpls.onQueueStatusChanged(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onSessionEnqueued(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onUIOperationHangup(IAutoActionAgentEventListener.SessionInfo r1) {
        IAutoActionAgentEventListener.DefaultImpls.onUIOperationHangup(this, r1);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return IAutoActionAgentEventListener.DefaultImpls.order(this);
    }

    public final IAutoActionAgentEventListener.OperatingAppInfo getSOperatingApp() {
        return this.sOperatingApp;
    }

    public final void setSOperatingApp(IAutoActionAgentEventListener.OperatingAppInfo r1) {
        this.sOperatingApp = r1;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r13, IAutoActionAgentEventListener.AgentStepInfo r14) {
        d.h.b.o.e(r13, "sessionInfo");
        d.h.b.o.e(r14, "stepInfo");
        IAutoActionAgentEventListener.DefaultImpls.onAgentStep(this, r13, r14);
        Bundle r0 = r14.getExtras();
        if (r0 == null) goto L5;
        String r1 = r0.getString("robots_msg");
    L6:
        String r4 = r1;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L16;
        record(r13.getTask().getTaskMode(), r13.getSessionId(), r4, 65536, r14.getCreationTimeMillis(), "robots");
    L16:
        if (r14.isLastStep() == false) goto L18;
        return;
    L18:
        record(r13.getTask().getTaskMode(), r13.getSessionId(), r14.getThought(), r14.getActionType(), r14.getCreationTimeMillis(), "auto");
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r14.getThought(), r5.getString(ZeusTransformUtils.mapRes(R.string.obric_history_thought_waiting, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_history_thought_waiting"))) == false) goto L26;
        AssistantAbilityHelper.MemorySettingConfig r6 = AssistantAbilityHelper.INSTANCE.queryMemorySettingConfig(r5);
        if (r6.getOUseMemory() == true) goto L23;
        return;
    L23:
        if (r6.getPersonalInfoMemory() == false) goto L28;
        Integer r7 = r13.getTask().getTaskMode();
        String r8 = r13.getSessionId();
        String r9 = r5.getString(ZeusTransformUtils.mapRes(R.string.history_querying_local_memory, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_querying_local_memory"));
        d.h.b.o.c(r9, "getString(...)");
        record(r7, r8, r9, r14.getActionType(), r14.getCreationTimeMillis(), "auto");
        return;
    L28:
        return;
    L26:
        return;
    L9:
        if (d.o.o.d(r2) == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private static final String onOperatingAppChanged$lambda$0(IAutoActionAgentEventListener.OperatingAppInfo r2) {
        return "onOperatingAppChanged: " + r2;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r4, final IAutoActionAgentEventListener.OperatingAppInfo r5) {
        d.h.b.o.e(r4, "sessionInfo");
        Loog.INSTANCE.ip(TAG, new $$Lambda$RecordHistoryStepStateListener$61k1Z6acVC1VmHcVyQIY5DSGmCw(r5), $$Lambda$RecordHistoryStepStateListener$Hprqvts1i5Umh2YzCxP5KSVVCQw.INSTANCE);
        this.sOperatingApp = r5;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r9, final BizStatus r10, final BizStatus r11, final int r12, BizStatus.StatusChangedReasonStruct r13, final Bundle r14) {
        d.h.b.o.e(r9, "sessionInfo");
        d.h.b.o.e(r10, "oldStatus");
        d.h.b.o.e(r11, "status");
        d.h.b.o.e(r13, "reasonDetails");
        Loog.INSTANCE.ip(TAG, new $$Lambda$RecordHistoryStepStateListener$6ONACkJlKsQt7diJfu4KHdrvfRc(r10, r11, r12, r14, this), new $$Lambda$RecordHistoryStepStateListener$BQJzh9MZvZW5DirNY8BsIkWXrI(r10, r11, r12));
        if (r12 != 1201) goto L5;
        String r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.history_user_addition_clicked, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_user_addition_clicked"));
    L13:
        String r3 = r15;
    L14:
        if (r3 == null) goto L17;
        record(r9.getTask().getTaskMode(), r9.getSessionId(), r3, r12, AOSystemTools.INSTANCE.nowTimeMillis(), "user!!!");
    L17:
        if (r11 != BizStatus.TERMINATED) goto L20;
        Loog.INSTANCE.i(TAG, "onBizStatusChanged: clear sOperatingApp");
        this.sOperatingApp = null;
        return;
    L20:
        return;
    L5:
        if (r12 == 1203) goto L11;
        switch(r12) {
            case 1401: goto L10;
            case 1402: goto L9;
            case 1403: goto L8;
            default: goto L7;
        };
    L7:
        r3 = null;
        goto L14
    L8:
        r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.history_user_addition, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_user_addition"));
        goto L13
    L9:
        r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.history_user_operation, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_user_operation"));
        goto L13
    L10:
        r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.history_user_clarify, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_user_clarify"));
        goto L13
    L11:
        r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.history_user_takeover_clicked, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_user_takeover_clicked"));
        goto L13
    }

    private static final String onBizStatusChanged$lambda$2(BizStatus r2, BizStatus r3, int r4, Bundle r5, RecordHistoryStepStateListener r6) {
        return "onBizStatusChanged: " + r2 + " -> " + r3 + ", reason: " + r4 + ", extras: " + r5 + ", sOperatingApp: " + r6.sOperatingApp;
    }

    private static final String onBizStatusChanged$lambda$3(BizStatus r2, BizStatus r3, int r4) {
        return "onBizStatusChanged: " + r2 + " -> " + r3 + ", reason: " + r4;
    }

    private final void record(final Integer r17, final String r18, final String r19, final int r20, final long r21, final String r23) {
        Loog.INSTANCE.ip(TAG, new $$Lambda$RecordHistoryStepStateListener$QCDOIOrXPR4QrRm3Rv6rkzLIAeM(r17, r18, r19, r20, r21, r23), new $$Lambda$RecordHistoryStepStateListener$AD28rijWwzZO4gTM9FIiad2p5Hw(r18, r17, r20, r21));
        if (r17 != null) goto L6;
    L7:
        Loog.INSTANCE.ip(TAG, new $$Lambda$RecordHistoryStepStateListener$pFcfmbm2DzwoAA9wPA4JgiWelw(r17, r18, r19, r20, r21, r23), new $$Lambda$RecordHistoryStepStateListener$Zgy1BI4kTa1tVZJpEoL5ZXKFHMg(r17, r20, r21));
        return;
    L6:
        if (r17.intValue() != 0) goto L7;
        IAutoActionAgentEventListener.OperatingAppInfo r0 = this.sOperatingApp;
        if (r0 == null) goto L13;
        String r1 = r0.getPackageName();
        if (r1 == null) goto L13;
    L14:
        String r4 = r1;
        IAutoActionAgentEventListener.OperatingAppInfo r2 = this.sOperatingApp;
        if (r2 == null) goto L20;
        CharSequence r3 = r2.getAppLabel();
        if (r3 == null) goto L20;
        String r5 = r3.toString();
        if (r5 == null) goto L20;
    L21:
        String r6 = r5;
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r18, r21, r4, r6, r19, r20, r23, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L20:
        r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.history_default_app_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_default_app_name"));
        d.h.b.o.c(r5, "getString(...)");
    L13:
        r1 = "com.larus.nova";
        goto L14
    }

    private static final String record$lambda$5(Integer r2, String r3, String r4, int r5, long r6, String r8) {
        return "record: " + r2 + ", " + r3 + ", " + r4 + ", " + r5 + ", " + r6 + ", " + r8;
    }

    private static final String record$lambda$6(String r2, Integer r3, int r4, long r5) {
        return "record: " + r2 + ", taskMode=" + r3 + ", type=" + r4 + ", time=" + r5;
    }

    private static final String record$lambda$7(Integer r2, String r3, String r4, int r5, long r6, String r8) {
        return "record: " + r2 + ", " + r3 + ", " + r4 + ", " + r5 + ", " + r6 + ", " + r8 + ", not standard task mode";
    }

    private static final String record$lambda$8(Integer r2, int r3, long r4) {
        return "record: taskMode=" + r2 + ", type=" + r3 + ", time=" + r4 + ", not standard task mode";
    }
}
