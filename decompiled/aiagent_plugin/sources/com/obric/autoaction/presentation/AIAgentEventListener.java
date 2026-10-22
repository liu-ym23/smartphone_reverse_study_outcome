package com.obric.autoaction.presentation;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: AIAgentEventListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AIAgentEventListener implements IAutoActionAgentEventListener {

    /* JADX INFO: compiled from: AIAgentEventListener.kt */
    @d.c.b.a.f(b = "AIAgentEventListener.kt", c = {81}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.AIAgentEventListener$afterAgentStep$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.SessionInfo f24734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.AgentStepInfo f24735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.AgentStepExecInfo f24736d;

        a(IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.AgentStepInfo r4, IAutoActionAgentEventListener.AgentStepExecInfo r5, d.c.d<? super a> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24734b = r3;
            this.f24735c = r4;
            this.f24736d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f24734b, this.f24735c, this.f24736d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24733a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            com.obric.autoaction.presentation.c r9 = com.obric.autoaction.presentation.c.f24841a;
            IAutoActionAgentEventListener.SessionInfo r2 = this.f24734b;
            IAutoActionAgentEventListener.AgentStepInfo r3 = this.f24735c;
            IAutoActionAgentEventListener.AgentStepExecInfo r4 = this.f24736d;
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24733a = 1;
            if (r9.a(r2, r3, r4, r5) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AIAgentEventListener.kt */
    @d.c.b.a.f(b = "AIAgentEventListener.kt", c = {53}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.AIAgentEventListener$onAgentStep$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.SessionInfo f24738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.AgentStepInfo f24739c;

        b(IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.AgentStepInfo r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24738b = r3;
            this.f24739c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24738b, this.f24739c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24737a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.autoaction.presentation.c r8 = com.obric.autoaction.presentation.c.f24841a;
            String r2 = String.valueOf(this.f24738b.getSessionId());
            IAutoActionAgentEventListener.AgentStepInfo r3 = this.f24739c;
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24737a = 1;
            if (r8.a(r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AIAgentEventListener.kt */
    @d.c.b.a.f(b = "AIAgentEventListener.kt", c = {29}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.AIAgentEventListener$onBizStatusChanged$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.SessionInfo f24741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BizStatus f24742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ BizStatus f24743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f24744e;
        final /* synthetic */ int f;

        c(IAutoActionAgentEventListener.SessionInfo r3, BizStatus r4, BizStatus r5, Bundle r6, int r7, d.c.d<? super c> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24741b = r3;
            this.f24742c = r4;
            this.f24743d = r5;
            this.f24744e = r6;
            this.f = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f24741b, this.f24742c, this.f24743d, this.f24744e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24740a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r10);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r10);
            com.obric.autoaction.presentation.c r2 = com.obric.autoaction.presentation.c.f24841a;
            IAutoActionAgentEventListener.SessionInfo r11 = this.f24741b;
            BizStatus r3 = this.f24742c;
            BizStatus r4 = this.f24743d;
            Bundle r5 = this.f24744e;
            int r6 = this.f;
            d.c.d<? super x> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24740a = 1;
            if (r2.a(r11, r3, r4, r5, r6, r7) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AIAgentEventListener.kt */
    @d.c.b.a.f(b = "AIAgentEventListener.kt", c = {64}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.AIAgentEventListener$onOperatingAppChanged$3")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IAutoActionAgentEventListener.OperatingAppInfo f24746b;

        d(IAutoActionAgentEventListener.OperatingAppInfo r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24746b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f24746b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24745a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r4);
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r4);
            IAutoActionAgentEventListener.OperatingAppInfo r5 = this.f24746b;
            if (r5 == null) goto L14;
            com.obric.autoaction.presentation.c r2 = com.obric.autoaction.presentation.c.f24841a;
            this.f24745a = 1;
            if (r2.a(r5, this) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AIAgentEventListener.kt */
    @d.c.b.a.f(b = "AIAgentEventListener.kt", c = {39}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.AIAgentEventListener$onQueueStatusChanged$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ QueueStatus f24748b;

        e(QueueStatus r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24748b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f24748b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24747a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            com.obric.autoaction.presentation.c r7 = com.obric.autoaction.presentation.c.f24841a;
            QueueStatus r2 = this.f24748b;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24747a = 1;
            if (r7.a(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$YRZDBjkJje4Uubnol4R-fQaMrWw, reason: not valid java name */
    public static /* synthetic */ String m582lambda$YRZDBjkJje4Uubnol4RfQaMrWw(IAutoActionAgentEventListener.OperatingAppInfo r0) {
        return onOperatingAppChanged$lambda$0(r0);
    }

    public static /* synthetic */ String lambda$dtPCVi_Hh1aIPKxGGKnMwWB5mno() {
        return onOperatingAppChanged$lambda$1();
    }

    private static final String onOperatingAppChanged$lambda$1() {
        return "onOperatingAppChanged";
    }

    public AIAgentEventListener() {
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

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r9, BizStatus r10, BizStatus r11, int r12, BizStatus.StatusChangedReasonStruct r13, Bundle r14) {
        d.h.b.o.e(r9, "sessionInfo");
        d.h.b.o.e(r10, "oldStatus");
        d.h.b.o.e(r11, "status");
        d.h.b.o.e(r13, "reasonDetails");
        Loog.INSTANCE.d("AIAgentEvent", "onBizStatusChanged: " + r10 + " --> " + r11 + ", " + r12);
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r9, r10, r11, r14, r12, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(IAutoActionAgentEventListener.SessionInfo r8, QueueStatus r9) {
        d.h.b.o.e(r8, "sessionInfo");
        d.h.b.o.e(r9, "queueStatus");
        Loog.INSTANCE.d("AIAgentEvent", "onQueueStatusChanged: " + r9);
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new e(r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r9, IAutoActionAgentEventListener.AgentStepInfo r10) {
        d.h.b.o.e(r9, "sessionInfo");
        d.h.b.o.e(r10, "stepInfo");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d("AIAgentEvent", "onAgentStep sessionInfo: " + r9 + " stepInfo: " + r10);
    L6:
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r9, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L5:
        Loog.INSTANCE.d("AIAgentEvent", "onAgentStep " + r9.getSessionKey() + ", stepAction: " + r10.getActionProtocolType());
        goto L6
    }

    private static final String onOperatingAppChanged$lambda$0(IAutoActionAgentEventListener.OperatingAppInfo r2) {
        return "onOperatingAppChanged: " + r2;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r8, final IAutoActionAgentEventListener.OperatingAppInfo r9) {
        d.h.b.o.e(r8, "sessionInfo");
        Loog.INSTANCE.dp("AIAgentEvent", new $$Lambda$AIAgentEventListener$YRZDBjkJje4Uubnol4RfQaMrWw(r9), $$Lambda$AIAgentEventListener$dtPCVi_Hh1aIPKxGGKnMwWB5mno.INSTANCE);
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new d(r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r9, IAutoActionAgentEventListener.AgentStepInfo r10, IAutoActionAgentEventListener.AgentStepExecInfo r11) {
        d.h.b.o.e(r9, "sessionInfo");
        d.h.b.o.e(r10, "stepInfo");
        d.h.b.o.e(r11, "execInfo");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d("AIAgentEvent", "afterAgentStep execInfo: " + r11 + " sessionInfo: " + r9 + " stepInfo: " + r10);
    L6:
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new a(r9, r10, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L5:
        Loog.INSTANCE.d("AIAgentEvent", "afterAgentStep session: " + r9.getSessionKey() + " stepAction: " + r10.getActionProtocolType());
        goto L6
    }
}
