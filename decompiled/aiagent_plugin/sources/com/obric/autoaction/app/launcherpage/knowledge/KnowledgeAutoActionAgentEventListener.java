package com.obric.autoaction.app.launcherpage.knowledge;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.event.task.base.report.k;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.c.b.a.l;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bs;

/* JADX INFO: compiled from: KnowledgeAutoActionAgentEventListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KnowledgeAutoActionAgentEventListener implements IAutoActionAgentEventListener {
    public static final a Companion = null;
    private static final String TAG = "KnowledgeAutoActionAgentEventListener";
    private final boolean enableKnowledge;
    private boolean isKnowledgeFetched;
    private final f networkClient$delegate;
    private final int requestMaxTime;
    private int retryCount;
    private final long stepMillis;

    /* JADX INFO: compiled from: KnowledgeAutoActionAgentEventListener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: KnowledgeAutoActionAgentEventListener.kt */
    @d.c.b.a.f(b = "KnowledgeAutoActionAgentEventListener.kt", c = {102, 121}, d = "fetchKnowledge", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeAutoActionAgentEventListener")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f23912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f23913c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f23914d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f23915e;
        final /* synthetic */ KnowledgeAutoActionAgentEventListener f;
        int g;

        b(KnowledgeAutoActionAgentEventListener r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23915e = r3;
            this.g |= Integer.MIN_VALUE;
            return KnowledgeAutoActionAgentEventListener.access$fetchKnowledge(this.f, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: KnowledgeAutoActionAgentEventListener.kt */
    @d.c.b.a.f(b = "KnowledgeAutoActionAgentEventListener.kt", c = {ApWakeEvent.ACCELERATING_END, 149, 160, 169, 170}, d = "fetchKnowledgeWithRetry", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeAutoActionAgentEventListener")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f23917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f23918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f23919d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f23920e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ KnowledgeAutoActionAgentEventListener h;
        int i;

        c(KnowledgeAutoActionAgentEventListener r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.g = r7;
            this.i |= Integer.MIN_VALUE;
            return KnowledgeAutoActionAgentEventListener.access$fetchKnowledgeWithRetry(this.h, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: KnowledgeAutoActionAgentEventListener.kt */
    public static final class d implements com.obric.eventkit.b {

        /* JADX INFO: compiled from: KnowledgeAutoActionAgentEventListener.kt */
        @d.c.b.a.f(b = "KnowledgeAutoActionAgentEventListener.kt", c = {53}, d = "postJson", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeAutoActionAgentEventListener$networkClient$2$1")
        static final class a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f23921a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f23922b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f23923c;

            a(d r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23922b = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                this.f23921a = r7;
                this.f23923c |= Integer.MIN_VALUE;
                return this.f23922b.a(null, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        d() {
        }

        @Override // com.obric.eventkit.b
        public Object a(String r9, Map<String, String> r10, String r11, int r12, d.c.d<? super com.obric.eventkit.c> r13) {
            Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
            d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r14, a.class) == false) goto L7;
            a r15 = (a) ZeusTransformUtils.preCheckCast(r14, a.class, "com.obric.aiagent.plugin");
            if ((r15.f23923c & Integer.MIN_VALUE) == 0) goto L7;
            r15.f23923c -= Integer.MIN_VALUE;
        L8:
            a r7 = r15;
            Object r8 = r7.f23921a;
            Object r16 = d.c.a.b.a();
            int r17 = r7.f23923c;
            String r0 = "";
            if (r17 == 0) goto L14;
            if (r17 != 1) goto L13;
            o.a(r8);
        L19:
            com.obric.autogui.tools.api.net.a.InterfaceC0861a r18 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");
            if (r18 == null) goto L29;
            boolean r19 = r18.a();
            String r20 = (String) ZeusTransformUtils.preCheckCast(r18.c(), String.class, "com.obric.aiagent.plugin");
            if (r20 == null) goto L27;
            r0 = r20;
        L27:
            return new com.obric.eventkit.c(r19, r0);
        L29:
            return new com.obric.eventkit.c(false, "");
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            o.a(r8);
            com.obric.autogui.tools.api.net.a r21 = com.obric.autogui.tools.a.a.f31480a.a();
            if (r21 == null) goto L29;
            r7.f23923c = 1;
            r8 = r21.a(r9, r4, r11, r12, r7);
            if (r8 != r16) goto L19;
            return r16;
        L7:
            r15 = new a(this, r14);
            goto L8
        }
    }

    /* JADX INFO: compiled from: KnowledgeAutoActionAgentEventListener.kt */
    @d.c.b.a.f(b = "KnowledgeAutoActionAgentEventListener.kt", c = {87}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.knowledge.KnowledgeAutoActionAgentEventListener$onBizStatusChanged$3")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ KnowledgeAutoActionAgentEventListener f23925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.SessionInfo f23926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f23927d;

        e(KnowledgeAutoActionAgentEventListener r3, IAutoActionAgentEventListener.SessionInfo r4, Bundle r5, d.c.d<? super e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23925b = r3;
            this.f23926c = r4;
            this.f23927d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f23925b, this.f23926c, this.f23927d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23924a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            KnowledgeAutoActionAgentEventListener r8 = this.f23925b;
            IAutoActionAgentEventListener.SessionInfo r2 = this.f23926c;
            Bundle r3 = this.f23927d;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23924a = 1;
            if (KnowledgeAutoActionAgentEventListener.access$fetchKnowledge(r8, r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    private static final String fetchKnowledge$lambda$11$lambda$10$lambda$9$lambda$8() {
        return "fetchKnowledge skipped (existing content)";
    }

    private static final String fetchKnowledge$lambda$4() {
        return "start fetchKnowledge";
    }

    private static final String fetchKnowledgeWithRetry$lambda$17() {
        return "fetchKnowledge failed";
    }

    /* JADX INFO: renamed from: lambda$-N9JvmkIQBwKixiWxMRhQZTckQw, reason: not valid java name */
    public static /* synthetic */ String m523lambda$N9JvmkIQBwKixiWxMRhQZTckQw(KnowledgeAutoActionAgentEventListener r0) {
        return fetchKnowledgeWithRetry$lambda$13(r0);
    }

    public static /* synthetic */ String lambda$0hiBPjV1a6SkU9Dm3byyWqrfANQ(KnowledgeAutoActionAgentEventListener r0) {
        return fetchKnowledgeWithRetry$lambda$19(r0);
    }

    /* JADX INFO: renamed from: lambda$36aV-GxKotHftR0-hdZxLuEXM6E, reason: not valid java name */
    public static /* synthetic */ String m524lambda$36aVGxKotHftR0hdZxLuEXM6E(IAutoActionAgentEventListener.SessionInfo r0) {
        return fetchKnowledge$lambda$3(r0);
    }

    public static /* synthetic */ String lambda$3AYnrVuM3FdH1_fm_GmWBHeqdG0(KnowledgeAutoActionAgentEventListener r0, List r1) {
        return fetchKnowledgeWithRetry$lambda$16(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Im9-D_wjmPZYEUgoqPCr50B_yLc, reason: not valid java name */
    public static /* synthetic */ String m525lambda$Im9D_wjmPZYEUgoqPCr50B_yLc(Integer r0) {
        return fetchKnowledge$lambda$11$lambda$10$lambda$6(r0);
    }

    public static /* synthetic */ String lambda$JplhgYzEVb500tdN4VIXTmWClNg() {
        return fetchKnowledgeWithRetry$lambda$17();
    }

    public static /* synthetic */ String lambda$OqB4G7bP_pbELWluT8l3LkphCZY(KnowledgeAutoActionAgentEventListener r0, List r1) {
        return fetchKnowledgeWithRetry$lambda$14(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$UHoW8jQ9ZcRByq-7yufA8TDdk2E, reason: not valid java name */
    public static /* synthetic */ d m526lambda$UHoW8jQ9ZcRByq7yufA8TDdk2E() {
        return networkClient_delegate$lambda$0();
    }

    public static /* synthetic */ String lambda$ULRE48heDiHdu5pELzOxmWY2SLc(EventTask r0, Integer r1, String r2) {
        return fetchKnowledge$lambda$11$lambda$10$lambda$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ciXwP9uBWrAcMEFZzw4bVp-ABx4, reason: not valid java name */
    public static /* synthetic */ String m527lambda$ciXwP9uBWrAcMEFZzw4bVpABx4(KnowledgeAutoActionAgentEventListener r0, List r1) {
        return fetchKnowledgeWithRetry$lambda$18(r0, r1);
    }

    public static /* synthetic */ String lambda$dpEjInDBS0ewOtlcusi6NTriH_k(TaskKnowledge r0) {
        return fetchKnowledge$lambda$11$lambda$10$lambda$9$lambda$7(r0);
    }

    public static /* synthetic */ String lambda$dyDhJRsD97ec44gh8CphNQY4paE(KnowledgeAutoActionAgentEventListener r0, com.obric.eventkit.f r1, IAutoActionAgentEventListener.SessionInfo r2) {
        return fetchKnowledgeWithRetry$lambda$12(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$kwggLB8RjDSfaNY9CMOKE1aaJhY(BizStatus r0, int r1, KnowledgeAutoActionAgentEventListener r2) {
        return onBizStatusChanged$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$p7n6fVpIuYhW2n_fUG8_ph4cDXI() {
        return fetchKnowledge$lambda$11$lambda$10$lambda$9$lambda$8();
    }

    /* JADX INFO: renamed from: lambda$s-Y6aptYujuOBoUdBCf3ArZpISw, reason: not valid java name */
    public static /* synthetic */ String m528lambda$sY6aptYujuOBoUdBCf3ArZpISw(KnowledgeAutoActionAgentEventListener r0) {
        return fetchKnowledgeWithRetry$lambda$15(r0);
    }

    public static /* synthetic */ String lambda$vl1eMFt_wzBXoVzqLjVZXHSvMhA() {
        return fetchKnowledge$lambda$4();
    }

    /* JADX INFO: renamed from: lambda$xF484opfWbAWP_IzHrCdF-Ompyg, reason: not valid java name */
    public static /* synthetic */ String m529lambda$xF484opfWbAWP_IzHrCdFOmpyg(IAutoActionAgentEventListener.SessionInfo r0, BizStatus r1, int r2, Bundle r3, KnowledgeAutoActionAgentEventListener r4) {
        return onBizStatusChanged$lambda$1(r0, r1, r2, r3, r4);
    }

    public KnowledgeAutoActionAgentEventListener() {
        this.requestMaxTime = AutoActionConfigs.INSTANCE.getIntCfg("vlm.task.knowledge.max_request_time", 7);
        this.enableKnowledge = AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.task.knowledge.enable", true);
        this.stepMillis = AutoActionConfigs.INSTANCE.getLongCfg("vlm.task.knowledge.delay_step_millis", 5000);
        this.networkClient$delegate = g.a($$Lambda$KnowledgeAutoActionAgentEventListener$UHoW8jQ9ZcRByq7yufA8TDdk2E.INSTANCE);
    }

    public static final /* synthetic */ Object access$fetchKnowledge(KnowledgeAutoActionAgentEventListener r2, IAutoActionAgentEventListener.SessionInfo r3, Bundle r4, d.c.d r5) {
        return r2.fetchKnowledge(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$fetchKnowledgeWithRetry(KnowledgeAutoActionAgentEventListener r6, IAutoActionAgentEventListener.SessionInfo r7, EventTask r8, long r9, d.c.d r11) {
        return r6.fetchKnowledgeWithRetry(r7, r8, r9, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2, IAutoActionAgentEventListener.AgentStepExecInfo r3) {
        IAutoActionAgentEventListener.DefaultImpls.afterAgentStep(this, r1, r2, r3);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.AgentStepInfo r2) {
        IAutoActionAgentEventListener.DefaultImpls.onAgentStep(this, r1, r2);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r1, IAutoActionAgentEventListener.OperatingAppInfo r2) {
        IAutoActionAgentEventListener.DefaultImpls.onOperatingAppChanged(this, r1, r2);
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

    public final int getRequestMaxTime() {
        return this.requestMaxTime;
    }

    public final boolean getEnableKnowledge() {
        return this.enableKnowledge;
    }

    public final long getStepMillis() {
        return this.stepMillis;
    }

    private final com.obric.eventkit.b getNetworkClient() {
        return (com.obric.eventkit.b) ZeusTransformUtils.preCheckCast(this.networkClient$delegate.b(), com.obric.eventkit.b.class, "com.obric.aiagent.plugin");
    }

    private static final d networkClient_delegate$lambda$0() {
        return new d();
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(final IAutoActionAgentEventListener.SessionInfo r9, BizStatus r10, final BizStatus r11, final int r12, BizStatus.StatusChangedReasonStruct r13, final Bundle r14) {
        d.h.b.o.e(r9, "sessionInfo");
        d.h.b.o.e(r10, "oldStatus");
        d.h.b.o.e(r11, "status");
        d.h.b.o.e(r13, "reasonDetails");
        boolean r15 = false;
        if (r11 != BizStatus.IDLE) goto L6;
        this.isKnowledgeFetched = false;
    L6:
        if (i.b(new Integer[]{1401, Integer.valueOf(BizStatus.StatusChangedReason.OPERATING_RESUME_FROM_USER_ADDITION)}, Integer.valueOf(r12)) == false) goto L8;
        this.isKnowledgeFetched = true;
    L8:
        Loog.INSTANCE.ip(TAG, new $$Lambda$KnowledgeAutoActionAgentEventListener$xF484opfWbAWP_IzHrCdFOmpyg(r9, r11, r12, r14, this), new $$Lambda$KnowledgeAutoActionAgentEventListener$kwggLB8RjDSfaNY9CMOKE1aaJhY(r11, r12, this));
        if (this.enableKnowledge == true) goto L11;
        return;
    L11:
        if (r11 == BizStatus.TERMINATED) goto L13;
        return;
    L13:
        if (this.isKnowledgeFetched == false) goto L27;
        String r16 = r9.getSessionId();
        if (r16 != null) goto L17;
    L22:
        if (r15 == false) goto L28;
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new e(this, r9, r14, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L28:
        return;
    L17:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L19;
        boolean r17 = true;
    L20:
        if (r17 != true) goto L22;
        r15 = true;
        goto L22
    L19:
        r17 = false;
        goto L20
    }

    private static final String onBizStatusChanged$lambda$1(IAutoActionAgentEventListener.SessionInfo r2, BizStatus r3, int r4, Bundle r5, KnowledgeAutoActionAgentEventListener r6) {
        return "onBizStatusChanged, sessionInfo: " + r2 + ", status: " + r3 + ", reason: " + r4 + ", extras: " + r5 + ", isKnowledgeFetched: " + r6.isKnowledgeFetched + ", sessionId: " + r2.getSessionId();
    }

    private static final String onBizStatusChanged$lambda$2(BizStatus r2, int r3, KnowledgeAutoActionAgentEventListener r4) {
        return "onBizStatusChanged, status: " + r2 + ", reason: " + r3 + ", isKnowledgeFetched: " + r4.isKnowledgeFetched;
    }

    private final boolean canFetchKnowledge(EventTask r3, Integer r4, String r5) {
        if (getTaskType(r3) != 2) goto L5;
    L6:
        if (r4 != null) goto L9;
    L13:
        return false;
    L9:
        if (r4.intValue() != 0) goto L13;
        if (d.h.b.o.a(r5, "TEST_RUN") == true) goto L13;
        return true;
    L5:
        if (getTaskType(r3) != 3) goto L13;
        goto L6
    }

    private final Object fetchKnowledge(final IAutoActionAgentEventListener.SessionInfo r12, Bundle r13, d.c.d<? super x> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        b r7 = r0;
        Object r16 = r7.f23915e;
        Object r1 = d.c.a.b.a();
        int r2 = r7.g;
        boolean r5 = true;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        o.a(r16);
    L52:
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        final String r11 = (String) ZeusTransformUtils.preCheckCast(r7.f23914d, String.class, "com.obric.aiagent.plugin");
        final Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r7.f23913c, Integer.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.SessionInfo r18 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(r7.f23912b, IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        KnowledgeAutoActionAgentEventListener r3 = (KnowledgeAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r7.f23911a, KnowledgeAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        o.a(r16);
    L31:
        final EventTask r19 = (EventTask) ZeusTransformUtils.preCheckCast(r16, EventTask.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L52;
        if (r3.canFetchKnowledge(r19, r17, r11) == true) goto L37;
        Loog.INSTANCE.ip(TAG, new $$Lambda$KnowledgeAutoActionAgentEventListener$ULRE48heDiHdu5pELzOxmWY2SLc(r19, r17, r11), new $$Lambda$KnowledgeAutoActionAgentEventListener$Im9D_wjmPZYEUgoqPCr50B_yLc(r17));
        return x.f38692a;
    L37:
        final TaskKnowledge r110 = r19.getTaskKnowledge();
        if (r110 == null) goto L48;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r110.getContent(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L42;
    L45:
        if (r5 == true) goto L48;
        Loog.INSTANCE.ip(TAG, new $$Lambda$KnowledgeAutoActionAgentEventListener$dpEjInDBS0ewOtlcusi6NTriH_k(r110), $$Lambda$KnowledgeAutoActionAgentEventListener$p7n6fVpIuYhW2n_fUG8_ph4cDXI.INSTANCE);
        return x.f38692a;
    L42:
        if (r4.length() == 0) goto L45;
        r5 = false;
    L48:
        r3.retryCount = 0;
        long r111 = System.currentTimeMillis();
        r7.f23911a = null;
        r7.f23912b = null;
        r7.f23913c = null;
        r7.f23914d = null;
        r7.g = 2;
        if (r3.fetchKnowledgeWithRetry(r18, r19, r111, r7) != r1) goto L52;
        return r1;
    L16:
        o.a(r16);
        Loog.INSTANCE.ip(TAG, new $$Lambda$KnowledgeAutoActionAgentEventListener$36aVGxKotHftR0hdZxLuEXM6E(r12), $$Lambda$KnowledgeAutoActionAgentEventListener$vl1eMFt_wzBXoVzqLjVZXHSvMhA.INSTANCE);
        if (r13 == null) goto L19;
        Integer r112 = d.c.b.a.b.a(r13.getInt("term_reason_type"));
    L20:
        if (r13 == null) goto L22;
        String r113 = r13.getString("execution_mode");
    L23:
        String r6 = r12.getTask().getTimerTaskId();
        if (r6 == null) goto L52;
        IEventTaskApi r8 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L52;
        r7.f23911a = this;
        r7.f23912b = r12;
        r7.f23913c = r112;
        r7.f23914d = r113;
        r7.g = 1;
        Object r9 = r8.getEventTask(r6, r7);
        if (r9 != r1) goto L30;
        return r1;
    L30:
        r3 = this;
        r11 = r113;
        r18 = r12;
        r17 = r112;
        r16 = r9;
        goto L31
    L22:
        r113 = null;
        goto L23
    L19:
        r112 = null;
    L7:
        r0 = new b(this, r15);
        goto L8
    }

    private static final String fetchKnowledge$lambda$3(IAutoActionAgentEventListener.SessionInfo r2) {
        return "start fetchKnowledge, sessionInfo: " + r2;
    }

    private static final String fetchKnowledge$lambda$11$lambda$10$lambda$5(EventTask r2, Integer r3, String r4) {
        return "fetchKnowledge, eventTask: " + r2 + " can not fetch knowledge， termReason: " + r3 + ", executionMode: " + r4;
    }

    private static final String fetchKnowledge$lambda$11$lambda$10$lambda$6(Integer r2) {
        return "fetchKnowledge cannot proceed, termReason=" + r2;
    }

    private static final String fetchKnowledge$lambda$11$lambda$10$lambda$9$lambda$7(TaskKnowledge r2) {
        return "fetchKnowledge, content: " + r2.getContent() + " is processed, no need to fetch";
    }

    private final Object fetchKnowledgeWithRetry(IAutoActionAgentEventListener.SessionInfo r38, EventTask r39, long r40, d.c.d<? super x> r42) {
        final KnowledgeAutoActionAgentEventListener r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r42, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L7;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        if ((r4.i & Integer.MIN_VALUE) == 0) goto L7;
        r4.i -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.g;
        Object r15 = d.c.a.b.a();
        int r5 = r4.i;
        if (r5 == 0) goto L22;
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L20;
        if (r5 == 3) goto L19;
        if (r5 == 4) goto L18;
        if (r5 != 5) goto L17;
        o.a(r3);
    L125:
        return x.f38692a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        long r6 = r4.f23920e;
        EventTask r1 = (EventTask) ZeusTransformUtils.preCheckCast(r4.f23918c, EventTask.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.SessionInfo r7 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(r4.f23917b, IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        KnowledgeAutoActionAgentEventListener r8 = (KnowledgeAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r4.f23916a, KnowledgeAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        o.a(r3);
        EventTask r9 = r1;
        r0 = r8;
        long r13 = r6;
        Object r10 = r15;
        Object r11 = null;
    L121:
        r4.f23916a = r11;
        r4.f23917b = r11;
        r4.f23918c = r11;
        r4.i = 5;
        if (r0.fetchKnowledgeWithRetry(r7, r9, r13, r4) != r10) goto L125;
        return r10;
    L19:
        long r12 = r4.f23920e;
        List<com.obric.eventkit.a> r14 = (List) ZeusTransformUtils.preCheckCast(r4.f23919d, List.class, "com.obric.aiagent.plugin");
        EventTask r16 = (EventTask) ZeusTransformUtils.preCheckCast(r4.f23918c, EventTask.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.SessionInfo r17 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(r4.f23917b, IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        KnowledgeAutoActionAgentEventListener r18 = (KnowledgeAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r4.f23916a, KnowledgeAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        o.a(r3);
        long r19 = r12;
        String r35 = TAG;
        Object r20 = r3;
        KnowledgeAutoActionAgentEventListener r21 = r18;
        r10 = r15;
    L115:
        com.obric.eventkit.g r22 = (com.obric.eventkit.g) ZeusTransformUtils.preCheckCast(r20, com.obric.eventkit.g.class, "com.obric.aiagent.plugin");
        final List<com.obric.eventkit.a> r110 = r14;
        r0 = r21;
        r9 = r16;
        r13 = r19;
    L117:
        Loog.INSTANCE.wp(r35, new $$Lambda$KnowledgeAutoActionAgentEventListener$3AYnrVuM3FdH1_fm_GmWBHeqdG0(r0, r110), $$Lambda$KnowledgeAutoActionAgentEventListener$JplhgYzEVb500tdN4VIXTmWClNg.INSTANCE);
        long r23 = r0.stepMillis;
        r4.f23916a = r0;
        r4.f23917b = r17;
        r4.f23918c = r9;
        r11 = null;
        r4.f23919d = null;
        r4.f23920e = r13;
        r4.i = 4;
        if (ax.a(r23, r4) != r10) goto L120;
        return r10;
    L120:
        r7 = r17;
        goto L121
    L20:
        List<com.obric.eventkit.a> r24 = (List) ZeusTransformUtils.preCheckCast(r4.f23917b, List.class, "com.obric.aiagent.plugin");
        KnowledgeAutoActionAgentEventListener r25 = (KnowledgeAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r4.f23916a, KnowledgeAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        o.a(r3);
        Object r26 = r3;
        KnowledgeAutoActionAgentEventListener r27 = r25;
        String r28 = TAG;
    L98:
        com.obric.eventkit.g r29 = (com.obric.eventkit.g) ZeusTransformUtils.preCheckCast(r26, com.obric.eventkit.g.class, "com.obric.aiagent.plugin");
        final List<com.obric.eventkit.a> r111 = r24;
        r0 = r27;
    L100:
        Loog.INSTANCE.ip(r28, new $$Lambda$KnowledgeAutoActionAgentEventListener$OqB4G7bP_pbELWluT8l3LkphCZY(r0, r111), new $$Lambda$KnowledgeAutoActionAgentEventListener$sY6aptYujuOBoUdBCf3ArZpISw(r0));
    L132:
        return x.f38692a;
    L21:
        long r30 = r4.f;
        r13 = r4.f23920e;
        ITaskManagerApi r31 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(r4.f23919d, ITaskManagerApi.class, "com.obric.aiagent.plugin");
        EventTask r32 = (EventTask) ZeusTransformUtils.preCheckCast(r4.f23918c, EventTask.class, "com.obric.aiagent.plugin");
        IAutoActionAgentEventListener.SessionInfo r33 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(r4.f23917b, IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        KnowledgeAutoActionAgentEventListener r34 = (KnowledgeAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r4.f23916a, KnowledgeAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        o.a(r3);
        EventTask r112 = r32;
        ITaskManagerApi r36 = r31;
        r0 = r34;
    L27:
        final com.obric.eventkit.f r37 = (com.obric.eventkit.f) ZeusTransformUtils.preCheckCast(r3, com.obric.eventkit.f.class, "com.obric.aiagent.plugin");
        r9 = r112;
    L29:
        final IAutoActionAgentEventListener.SessionInfo r310 = r33;
        ITaskManagerApi r41 = r36;
        Loog.INSTANCE.ip(TAG, new $$Lambda$KnowledgeAutoActionAgentEventListener$dyDhJRsD97ec44gh8CphNQY4paE(r0, r37, r310), new $$Lambda$KnowledgeAutoActionAgentEventListener$N9JvmkIQBwKixiWxMRhQZTckQw(r0));
        if (r37 == null) goto L34;
        com.obric.eventkit.d r43 = (com.obric.eventkit.d) ZeusTransformUtils.preCheckCast(r37.b(), com.obric.eventkit.d.class, "com.obric.aiagent.plugin");
        if (r43 == null) goto L34;
        r111 = r43.a();
    L35:
        if (r111 == null) goto L39;
        com.obric.eventkit.a r44 = (com.obric.eventkit.a) ZeusTransformUtils.preCheckCast(p.l(r111), com.obric.eventkit.a.class, "com.obric.aiagent.plugin");
        if (r44 == null) goto L39;
        r44.a();
    L39:
        if (r111 == null) goto L45;
        com.obric.eventkit.a r45 = (com.obric.eventkit.a) ZeusTransformUtils.preCheckCast(p.l(r111), com.obric.eventkit.a.class, "com.obric.aiagent.plugin");
        if (r45 == null) goto L45;
        if (r45.a() != 1) goto L45;
        boolean r46 = true;
    L46:
        if (r111 == null) goto L52;
        Object r47 = p.l(r111);
        String r210 = TAG;
        com.obric.eventkit.a r48 = (com.obric.eventkit.a) ZeusTransformUtils.preCheckCast(r47, com.obric.eventkit.a.class, "com.obric.aiagent.plugin");
        if (r48 != null) goto L50;
    L53:
        boolean r49 = false;
    L54:
        if (r111 == null) goto L60;
        Object r211 = r15;
        com.obric.eventkit.a r113 = (com.obric.eventkit.a) ZeusTransformUtils.preCheckCast(p.l(r111), com.obric.eventkit.a.class, "com.obric.aiagent.plugin");
        if (r113 == null) goto L61;
        List<String> r114 = r113.b();
        if (r114 == null) goto L61;
        String r115 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L62:
        k r212 = k.f32860a;
        if (r111 == null) goto L67;
        IAutoActionAgentEventListener.SessionInfo r311 = r310;
        com.obric.eventkit.a r50 = (com.obric.eventkit.a) ZeusTransformUtils.preCheckCast(p.l(r111), com.obric.eventkit.a.class, "com.obric.aiagent.plugin");
        if (r50 == null) goto L68;
        int r51 = r50.a();
    L69:
        int r213 = r51;
        if (r37 != null) goto L72;
    L74:
        boolean r214 = false;
    L75:
        if (r37 == null) goto L77;
        String r215 = r37.c();
    L78:
        r212.a(r213, r214, r215, true, d.c.b.a.b.a(r0.retryCount), System.currentTimeMillis() - r30, System.currentTimeMillis() - r13);
        if (r37 != null) goto L81;
    L101:
        final List<com.obric.eventkit.a> r116 = r111;
        String r52 = r210;
        Object r117 = r211;
        if (r0.retryCount >= r0.requestMaxTime) goto L126;
        if (r41 == null) goto L116;
        String r53 = r9.getId();
        if (r53 != null) goto L107;
        String r54 = "";
    L108:
        int r55 = r0.getTaskType(r9);
        String r118 = r311.getSessionId();
        if (r115 != null) goto L111;
        r115 = "";
    L111:
        r4.f23916a = r0;
        IAutoActionAgentEventListener.SessionInfo r56 = r311;
        r4.f23917b = r56;
        r4.f23918c = r9;
        r4.f23919d = r116;
        r4.f23920e = r13;
        r4.i = 3;
        r10 = r117;
        r19 = r13;
        r35 = r52;
        r20 = ITaskManagerApi.b.a(r41, r54, r55, r118, r115, null, false, null, null, false, r4, 464, null);
        if (r20 != r10) goto L114;
        return r10;
    L114:
        r16 = r9;
        r17 = r56;
        r21 = r0;
        r14 = r116;
        goto L115
    L107:
        r54 = r53;
        goto L108
    L116:
        r35 = r52;
        r10 = r117;
        r17 = r311;
        r110 = r116;
        goto L117
    L126:
        k r57 = k.f32860a;
        if (r37 == null) goto L129;
        String r119 = r37.c();
    L130:
        r57.a(false, r119, true, d.c.b.a.b.a(r0.retryCount));
        Loog.INSTANCE.ep(r52, new $$Lambda$KnowledgeAutoActionAgentEventListener$ciXwP9uBWrAcMEFZzw4bVpABx4(r0, r116), new $$Lambda$KnowledgeAutoActionAgentEventListener$0hiBPjV1a6SkU9Dm3byyWqrfANQ(r0));
        goto L132
    L129:
        r119 = null;
        goto L130
    L81:
        if (r37.a() == false) goto L101;
        if (r46 == true) goto L84;
        if (r49 == false) goto L101;
    L84:
        k.f32860a.a(true, r37.c(), true, d.c.b.a.b.a(r0.retryCount));
        if (r41 == null) goto L99;
        String r58 = r9.getId();
        if (r58 != null) goto L89;
        String r59 = "";
    L90:
        int r60 = r0.getTaskType(r9);
        if (r115 != null) goto L93;
        String r61 = "";
    L94:
        Integer r120 = d.c.b.a.b.a(0);
        r4.f23916a = r0;
        r4.f23917b = r111;
        r4.f23918c = null;
        r4.f23919d = null;
        r4.i = 2;
        List<com.obric.eventkit.a> r62 = r111;
        r28 = r210;
        Object r312 = r211;
        r26 = ITaskManagerApi.b.a(r41, r59, r60, null, r61, r120, false, null, null, false, r4, 448, null);
        if (r26 != r312) goto L97;
        return r312;
    L97:
        r27 = r0;
        r24 = r62;
        goto L98
    L93:
        r61 = r115;
        goto L94
    L89:
        r59 = r58;
        goto L90
    L99:
        r28 = r210;
        goto L100
    L77:
        r215 = null;
        goto L78
    L72:
        if (r37.a() != true) goto L74;
        r214 = true;
    L68:
        r51 = -1;
        goto L69
    L67:
        r311 = r310;
    L61:
        r115 = null;
        goto L62
    L60:
        r211 = r15;
        goto L61
    L50:
        if (r48.a() != 2) goto L53;
        r49 = true;
        goto L54
    L52:
        r210 = TAG;
    L45:
        r46 = false;
    L34:
        r111 = null;
        goto L35
    L22:
        o.a(r3);
        r0.retryCount++;
        r30 = System.currentTimeMillis();
        r36 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r36 == null) goto L28;
        List<String> r63 = p.a(r38.getSessionId());
        com.obric.eventkit.b r64 = getNetworkClient();
        r4.f23916a = r0;
        r33 = r38;
        r4.f23917b = r33;
        r112 = r39;
        r4.f23918c = r112;
        r4.f23919d = r36;
        r13 = r40;
        r4.f23920e = r13;
        r4.f = r30;
        r4.i = 1;
        r3 = r36.getKnowledgeForNet(r63, r64, r4);
        if (r3 != r15) goto L27;
        return r15;
    L28:
        r33 = r38;
        r13 = r40;
        r9 = r39;
        r37 = null;
    L7:
        r4 = new c(r0, r2);
        goto L8
    }

    private static final String fetchKnowledgeWithRetry$lambda$12(KnowledgeAutoActionAgentEventListener r2, com.obric.eventkit.f r3, IAutoActionAgentEventListener.SessionInfo r4) {
        StringBuilder r5 = new StringBuilder().append("fetchKnowledgeWithRetry, attempt: ").append(r2.retryCount).append(", result: ").append(r3).append(", knowledge: ");
        if (r3 == null) goto L5;
        com.obric.eventkit.d r6 = (com.obric.eventkit.d) ZeusTransformUtils.preCheckCast(r3.b(), com.obric.eventkit.d.class, "com.obric.aiagent.plugin");
    L7:
        return r5.append(r6).append(", sessionId: ").append(r4.getSessionId()).toString();
    L5:
        r6 = null;
        goto L7
    }

    private static final String fetchKnowledgeWithRetry$lambda$13(KnowledgeAutoActionAgentEventListener r2) {
        return "fetchKnowledgeWithRetry, attempt: " + r2.retryCount;
    }

    private static final String fetchKnowledgeWithRetry$lambda$14(KnowledgeAutoActionAgentEventListener r2, List r3) {
        return "fetchKnowledge succeeded  retryCount=" + r2.retryCount + ", knowledge:" + ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    private static final String fetchKnowledgeWithRetry$lambda$15(KnowledgeAutoActionAgentEventListener r2) {
        return "fetchKnowledge succeeded retryCount=" + r2.retryCount;
    }

    private static final String fetchKnowledgeWithRetry$lambda$16(KnowledgeAutoActionAgentEventListener r2, List r3) {
        return "fetchKnowledge failed, retrying... (" + r2.retryCount + '/' + r2.requestMaxTime + "),knowledge:" + ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    private static final String fetchKnowledgeWithRetry$lambda$18(KnowledgeAutoActionAgentEventListener r2, List r3) {
        return "fetchKnowledge failed after " + r2.retryCount + " attempts, giving up, knowledge:" + ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    private static final String fetchKnowledgeWithRetry$lambda$19(KnowledgeAutoActionAgentEventListener r2) {
        return "fetchKnowledge failed after " + r2.retryCount + " attempts";
    }

    private final int getTaskType(EventTask r1) {
        if (ZeusTransformUtils.instanceOf(r1, ConditionTask.class) == false) goto L6;
        return 2;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, ShortcutTask.class) == false) goto L8;
        return 3;
    L8:
        return 0;
    }
}
