package com.obric.autogui.vdplayer.adapter.orchestrator;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.vdplayer.adapter.orchestrator.a.a.c;
import com.obric.autogui.vdplayer.adapter.orchestrator.a.a.e;
import com.obric.autogui.vdplayer.adapter.orchestrator.a.a.g;
import com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.am;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.b.x;

/* JADX INFO: compiled from: AgentSessionOrchestrator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements IAutoActionAgentEventListener, IAgentSessionManager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.obric.autogui.vdplayer.api.a.a f31648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.obric.autogui.vdplayer.api.a.a> f31649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w<com.obric.autogui.vdplayer.api.a.a> f31650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h<com.obric.autogui.vdplayer.api.a.a> f31651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x<com.obric.autogui.vdplayer.api.a.b> f31652e;
    private final ak<com.obric.autogui.vdplayer.api.a.b> f;
    private BizStatus g;
    private com.obric.autogui.vdplayer.adapter.orchestrator.a.a h;
    private final ConcurrentHashMap<BizStatus, com.obric.autogui.vdplayer.adapter.orchestrator.a.a> i;

    /* JADX INFO: renamed from: com.obric.autogui.vdplayer.adapter.orchestrator.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentSessionOrchestrator.kt */
    @f(b = "AgentSessionOrchestrator.kt", c = {45, 47}, d = "invokeSuspend", e = "com.obric.autogui.vdplayer.adapter.orchestrator.AgentSessionOrchestrator$actions$1")
    static final class C0868a extends l implements m<i<? super com.obric.autogui.vdplayer.api.a.a>, d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f31654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f31655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f31656d;

        C0868a(a r3, d<? super C0868a> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f31655c = r3;
            super(2, r5);
        }

        public final Object a(i<? super com.obric.autogui.vdplayer.api.a.a> r3, d<? super d.x> r4) {
            return ((C0868a) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0868a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<d.x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            C0868a r0 = new C0868a(this.f31655c, r5);
            r0.f31656d = r3;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super com.obric.autogui.vdplayer.api.a.a> r3, d<? super d.x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31654b;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.f31653a, Iterator.class, "com.obric.aiagent.plugin");
            i r3 = (i) ZeusTransformUtils.preCheckCast(this.f31656d, i.class, "com.obric.aiagent.plugin");
            o.a(r7);
        L17:
            if (r2.hasNext() == false) goto L22;
            Object r8 = r2.next();
            d.h.b.o.c(r8, "next(...)");
            com.obric.autogui.vdplayer.api.a.a r9 = (com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin");
            d<? super d.x> r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f31656d = r3;
            this.f31653a = r2;
            this.f31654b = 2;
            if (r3.emit(r9, r5) != r0) goto L17;
            return r0;
        L22:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r4 = (i) ZeusTransformUtils.preCheckCast(this.f31656d, i.class, "com.obric.aiagent.plugin");
            o.a(r7);
        L15:
            r3 = r4;
            r2 = a.b(this.f31655c).values().iterator();
            goto L17
        L10:
            o.a(r7);
            r4 = (i) ZeusTransformUtils.preCheckCast(this.f31656d, i.class, "com.obric.aiagent.plugin");
            com.obric.autogui.vdplayer.api.a.a r10 = a.a(this.f31655c);
            if (r10 == null) goto L15;
            this.f31656d = r4;
            this.f31654b = 1;
            if (r4.emit(r10, this) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$4oTGsYSlUPaIl1-T7jyIywziyg0, reason: not valid java name */
    public static /* synthetic */ d.x m921lambda$4oTGsYSlUPaIl1T7jyIywziyg0(a r0, d.h.a.b r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ d.x lambda$Pee4eyFtwVMIYFGmhgSFwqlYdWc(a r0, List r1) {
        return a(r0, r1);
    }

    public a() {
        this.f31649b = new ConcurrentHashMap();
        w<com.obric.autogui.vdplayer.api.a.a> r0 = ad.a(0, 64, null, 4, null);
        this.f31650c = r0;
        this.f31651d = j.a((h) ZeusTransformUtils.preCheckCast(r0, h.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new C0868a(this, null), m.class, "com.obric.aiagent.plugin"));
        x<com.obric.autogui.vdplayer.api.a.b> r1 = am.a(new com.obric.autogui.vdplayer.api.a.b(null, null, null, null, 14, null));
        this.f31652e = r1;
        this.f = (ak) ZeusTransformUtils.preCheckCast(r1, ak.class, "com.obric.aiagent.plugin");
        this.g = BizStatus.IDLE;
        ConcurrentHashMap<BizStatus, com.obric.autogui.vdplayer.adapter.orchestrator.a.a> r2 = new ConcurrentHashMap();
        this.i = r2;
        a((com.obric.autogui.vdplayer.adapter.orchestrator.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.adapter.orchestrator.a.a.b(), com.obric.autogui.vdplayer.adapter.orchestrator.a.a.class, "com.obric.aiagent.plugin"));
        a((com.obric.autogui.vdplayer.adapter.orchestrator.a.a) ZeusTransformUtils.preCheckCast(new c(), com.obric.autogui.vdplayer.adapter.orchestrator.a.a.class, "com.obric.aiagent.plugin"));
        a((com.obric.autogui.vdplayer.adapter.orchestrator.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.adapter.orchestrator.a.a.d(), com.obric.autogui.vdplayer.adapter.orchestrator.a.a.class, "com.obric.aiagent.plugin"));
        a((com.obric.autogui.vdplayer.adapter.orchestrator.a.a) ZeusTransformUtils.preCheckCast(new g(), com.obric.autogui.vdplayer.adapter.orchestrator.a.a.class, "com.obric.aiagent.plugin"));
        a((com.obric.autogui.vdplayer.adapter.orchestrator.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.adapter.orchestrator.a.a.f(), com.obric.autogui.vdplayer.adapter.orchestrator.a.a.class, "com.obric.aiagent.plugin"));
        a((com.obric.autogui.vdplayer.adapter.orchestrator.a.a) ZeusTransformUtils.preCheckCast(new e(), com.obric.autogui.vdplayer.adapter.orchestrator.a.a.class, "com.obric.aiagent.plugin"));
        a((com.obric.autogui.vdplayer.adapter.orchestrator.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.adapter.orchestrator.a.a.h(), com.obric.autogui.vdplayer.adapter.orchestrator.a.a.class, "com.obric.aiagent.plugin"));
        this.h = (com.obric.autogui.vdplayer.adapter.orchestrator.a.a) ZeusTransformUtils.preCheckCast(r2.get(BizStatus.IDLE), com.obric.autogui.vdplayer.adapter.orchestrator.a.a.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.obric.autogui.vdplayer.api.a.a a(a r0) {
        return r0.f31648a;
    }

    public static final /* synthetic */ ConcurrentHashMap b(a r0) {
        return r0.f31649b;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return IAutoActionAgentEventListener.DefaultImpls.order(this);
    }

    @Override // com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager.a
    public h<com.obric.autogui.vdplayer.api.a.a> a() {
        return this.f31651d;
    }

    @Override // com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager.a
    public ak<com.obric.autogui.vdplayer.api.a.b> b() {
        return this.f;
    }

    public final void a(com.obric.autogui.vdplayer.adapter.orchestrator.a.a r4) {
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a r5 = (com.obric.autogui.vdplayer.adapter.orchestrator.a.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.vdplayer.adapter.orchestrator.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "handler");
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a.class) == false) goto L5;
        ((com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a.class, "com.obric.aiagent.plugin")).a(new $$Lambda$a$Pee4eyFtwVMIYFGmhgSFwqlYdWc(this));
        ((com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a.class, "com.obric.aiagent.plugin")).b(new $$Lambda$a$4oTGsYSlUPaIl1T7jyIywziyg0(this));
    L5:
        ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.aiagent.plugin")).put(r5.a(), r5);
    }

    private static final d.x a(a r3, List r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "actions");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r3.a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        goto L4
    L7:
        return d.x.f38692a;
    }

    private static final d.x a(a r2, d.h.a.b r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "transform");
        x<com.obric.autogui.vdplayer.api.a.b> r5 = r2.f31652e;
    L3:
        com.obric.autogui.vdplayer.api.a.b r0 = r5.c();
        Object r1 = r4.invoke(r0);
        if (r5.a(r0, (com.obric.autogui.vdplayer.api.a.b) r1) == false) goto L3;
        return d.x.f38692a;
    }

    private final void a(com.obric.autogui.vdplayer.api.a.a r5) {
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.vdplayer.api.a.c.class) == false) goto L5;
        ((Map) ZeusTransformUtils.preCheckCast(this.f31649b, Map.class, "com.obric.aiagent.plugin")).put(((com.obric.autogui.vdplayer.api.a.c) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.vdplayer.api.a.c.class, "com.obric.aiagent.plugin")).a(), r5);
    L13:
        this.f31650c.a(r5);
        return;
    L5:
        this.f31648a = r5;
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(this.f31649b, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        com.obric.autogui.vdplayer.api.a.a r2 = (com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.vdplayer.api.a.c.class) == false) goto L7;
        if (((com.obric.autogui.vdplayer.api.a.c) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.vdplayer.api.a.c.class, "com.obric.aiagent.plugin")).b() != com.obric.autogui.vdplayer.api.a.d.f31702b) goto L7;
        r0.remove();
        goto L7
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r16, BizStatus r17, BizStatus r18, int r19, BizStatus.StatusChangedReasonStruct r20, Bundle r21) {
        d.h.b.o.e(r16, "sessionInfo");
        d.h.b.o.e(r17, "oldStatus");
        d.h.b.o.e(r18, "status");
        d.h.b.o.e(r20, "reasonDetails");
        x<com.obric.autogui.vdplayer.api.a.b> r1 = this.f31652e;
    L3:
        com.obric.autogui.vdplayer.api.a.b r13 = r1.c();
        if (r1.a(r13, com.obric.autogui.vdplayer.api.a.b.a((com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin"), r16, null, null, null, 14, null)) == false) goto L3;
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a r2 = (com.obric.autogui.vdplayer.adapter.orchestrator.a.a) ZeusTransformUtils.preCheckCast(this.i.get(r18), com.obric.autogui.vdplayer.adapter.orchestrator.a.a.class, "com.obric.aiagent.plugin");
        this.g = r18;
        this.h = r2;
        if (r2 == null) goto L11;
        r2.onBizStatusChanged(r16, r17, r18, r19, r20, r21);
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(IAutoActionAgentEventListener.SessionInfo r2) {
        d.h.b.o.e(r2, "sessionInfo");
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a r1 = this.h;
        if (r1 == null) goto L6;
        r1.onSessionEnqueued(r2);
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(IAutoActionAgentEventListener.SessionInfo r2, QueueStatus r3) {
        d.h.b.o.e(r2, "sessionInfo");
        d.h.b.o.e(r3, "queueStatus");
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a r1 = this.h;
        if (r1 == null) goto L6;
        r1.onQueueStatusChanged(r2, r3);
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener.AgentStepInfo r3) {
        d.h.b.o.e(r2, "sessionInfo");
        d.h.b.o.e(r3, "stepInfo");
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a r1 = this.h;
        if (r1 == null) goto L6;
        r1.onAgentStep(r2, r3);
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(IAutoActionAgentEventListener.SessionInfo r11, IAutoActionAgentEventListener.AgentStepInfo r12, IAutoActionAgentEventListener.AgentStepExecInfo r13) {
        d.h.b.o.e(r11, "sessionInfo");
        d.h.b.o.e(r12, "stepInfo");
        d.h.b.o.e(r13, "execInfo");
        if (r12.isLastStep() == false) goto L7;
        x<com.obric.autogui.vdplayer.api.a.b> r0 = this.f31652e;
    L5:
        com.obric.autogui.vdplayer.api.a.b r1 = r0.c();
        if (r0.a(r1, com.obric.autogui.vdplayer.api.a.b.a((com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin"), null, null, null, r13.getAfterStepScreenshot(), 7, null)) == false) goto L5;
    L7:
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a r10 = this.h;
        if (r10 == null) goto L13;
        r10.afterAgentStep(r11, r12, r13);
        return;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(IAutoActionAgentEventListener.SessionInfo r13, IAutoActionAgentEventListener.OperatingAppInfo r14) {
        d.h.b.o.e(r13, "sessionInfo");
        if (r14 == null) goto L5;
        String r0 = r14.getPackageName();
    L6:
        boolean r1 = d.h.b.o.a(r0, "com.android.permissioncontroller");
        x<com.obric.autogui.vdplayer.api.a.b> r2 = this.f31652e;
    L7:
        com.obric.autogui.vdplayer.api.a.b r3 = r2.c();
        com.obric.autogui.vdplayer.api.a.b r5 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L19;
        if (r5.c().isEmpty() == true) goto L15;
        if (r1 == false) goto L15;
        boolean r4 = false;
    L16:
        if (r4 == false) goto L19;
        r5 = com.obric.autogui.vdplayer.api.a.b.a(r5, null, null, p.a((Collection) ZeusTransformUtils.preCheckCast(r5.c(), Collection.class, "com.obric.aiagent.plugin"), r14), null, 11, null);
    L15:
        r4 = true;
    L19:
        if (r2.a(r3, r5) == false) goto L7;
        com.obric.autogui.vdplayer.adapter.orchestrator.a.a r12 = this.h;
        if (r12 == null) goto L26;
        r12.onOperatingAppChanged(r13, r14);
        return;
    L26:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onUIOperationHangup(IAutoActionAgentEventListener.SessionInfo r3) {
        d.h.b.o.e(r3, "sessionInfo");
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(com.obric.autogui.vdplayer.api.a.a.e.f31692a, com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
    }
}
