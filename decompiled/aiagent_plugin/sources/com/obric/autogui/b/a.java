package com.obric.autogui.b;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.session.state.e;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.o;
import d.x;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: AgentEventListeners.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements IAutoActionAgentEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AOThreadingTools.SingleThreadCoroutineScopeWrapper f28929b = null;

    /* JADX INFO: renamed from: com.obric.autogui.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentEventListeners.kt */
    @f(b = "AgentEventListeners.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.tasks.AgentEventListeners$onOperationTargetChanged$1")
    static final class C0723a extends l implements d.h.a.b<d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f28931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f28932c;

        C0723a(String r3, String r4, d<? super C0723a> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f28931b = r3;
            this.f28932c = r4;
            super(1, r6);
        }

        public final Object a(d<? super x> r3) {
            return ((C0723a) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C0723a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0723a(this.f28931b, this.f28932c, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f28930a != 0) goto L12;
            o.a(r3);
            e.f31397a.a(this.f28931b, this.f28932c);     // Catch: Throwable -> L7
        L10:
            return x.f38692a;
        L7:
            th = move-exception;
            Loog.INSTANCE.e("AgentEventListeners", "operation target dispatch error: " + th.getMessage(), th);
            goto L10
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AgentEventListeners.kt */
    @f(b = "AgentEventListeners.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.tasks.AgentEventListeners$triggerListeners$1")
    static final class b extends l implements d.h.a.b<d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<IAutoActionAgentEventListener, x> f28934b;

        /* JADX INFO: renamed from: com.obric.autogui.b.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class C0724a<T> implements Comparator {
            public C0724a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r2, T r3) {
                return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r3, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin")).order()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r2, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin")).order()), Comparable.class, "com.obric.aiagent.plugin"));
            }
        }

        b(d.h.a.b<? super IAutoActionAgentEventListener, x> r3, d<? super b> r4) {
            d.h.a.b<IAutoActionAgentEventListener, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f28934b = r5;
            super(1, r6);
        }

        public final Object a(d<? super x> r3) {
            return ((b) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f28934b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f28933a != 0) goto L15;
            o.a(r6);
            Set r7 = ServiceManager.get().getServices(IAutoActionAgentEventListener.class);
            d.h.b.o.b(r7, "ServiceManager.get().getServices(T::class.java)");
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0724a(), Comparator.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
            d.h.a.b<IAutoActionAgentEventListener, x> r5 = this.f28934b;
            Iterator r9 = r8.iterator();
        L6:
            if (r9.hasNext() == false) goto L13;
            r5.invoke((IAutoActionAgentEventListener) ZeusTransformUtils.preCheckCast(r9.next(), IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Loog.INSTANCE.e("AgentEventListeners", "triggerListeners error " + th.getMessage(), th);
            goto L6
        L13:
            return x.f38692a;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: lambda$392bl7W_I-maWWwMLjhOjDgkvks, reason: not valid java name */
    public static /* synthetic */ x m795lambda$392bl7W_ImaWWwMLjhOjDgkvks(IAutoActionAgentEventListener.SessionInfo r0, IAutoActionAgentEventListener.OperatingAppInfo r1, IAutoActionAgentEventListener r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$Vc3zxDCOTfRRIAja2w8PWz9HvD4(IAutoActionAgentEventListener.SessionInfo r0, IAutoActionAgentEventListener.AgentStepInfo r1, IAutoActionAgentEventListener.AgentStepExecInfo r2, IAutoActionAgentEventListener r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$XAYGwMnLfcBFd6c5QG2fupYfFwk(IAutoActionAgentEventListener.SessionInfo r0, IAutoActionAgentEventListener r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ x lambda$mV1GEKh_AByBggPUkf0VIem2wKA(IAutoActionAgentEventListener.SessionInfo r0, IAutoActionAgentEventListener.AgentStepInfo r1, IAutoActionAgentEventListener r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$o6LyZKMYnXGjGsFkgDUm9cYzPFI(IAutoActionAgentEventListener.SessionInfo r0, BizStatus r1, BizStatus r2, int r3, BizStatus.StatusChangedReasonStruct r4, Bundle r5, IAutoActionAgentEventListener r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: lambda$oZSabLcsm69FqAM-xVIChGfyP-Q, reason: not valid java name */
    public static /* synthetic */ x m796lambda$oZSabLcsm69FqAMxVIChGfyPQ(IAutoActionAgentEventListener.SessionInfo r0, QueueStatus r1, IAutoActionAgentEventListener r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$sJsDDcgV_JN5rVCPjbajoDqcPUc(IAutoActionAgentEventListener.SessionInfo r0, IAutoActionAgentEventListener r1) {
        return a(r0, r1);
    }

    private a() {
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public int order() {
        return IAutoActionAgentEventListener.DefaultImpls.order(this);
    }

    static {
        f28928a = new a();
        f28929b = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "ao-agent-th-event-trigger", false, 2, null);
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onSessionEnqueued(final IAutoActionAgentEventListener.SessionInfo r2) {
        d.h.b.o.e(r2, "sessionInfo");
        a(new $$Lambda$a$sJsDDcgV_JN5rVCPjbajoDqcPUc(r2));
    }

    private static final x a(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener r3) {
        IAutoActionAgentEventListener r4 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "$this$triggerListeners");
        r4.onSessionEnqueued(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onAgentStep(final IAutoActionAgentEventListener.SessionInfo r2, final IAutoActionAgentEventListener.AgentStepInfo r3) {
        d.h.b.o.e(r2, "sessionInfo");
        d.h.b.o.e(r3, "stepInfo");
        a(new $$Lambda$a$mV1GEKh_AByBggPUkf0VIem2wKA(r2, r3));
    }

    private static final x a(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener.AgentStepInfo r3, IAutoActionAgentEventListener r4) {
        IAutoActionAgentEventListener r5 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r4, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "$this$triggerListeners");
        r5.onAgentStep(r2, r3);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void afterAgentStep(final IAutoActionAgentEventListener.SessionInfo r2, final IAutoActionAgentEventListener.AgentStepInfo r3, final IAutoActionAgentEventListener.AgentStepExecInfo r4) {
        d.h.b.o.e(r2, "sessionInfo");
        d.h.b.o.e(r3, "stepInfo");
        d.h.b.o.e(r4, "execInfo");
        a(new $$Lambda$a$Vc3zxDCOTfRRIAja2w8PWz9HvD4(r2, r3, r4));
    }

    private static final x a(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener.AgentStepInfo r3, IAutoActionAgentEventListener.AgentStepExecInfo r4, IAutoActionAgentEventListener r5) {
        IAutoActionAgentEventListener r6 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r5, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "$this$triggerListeners");
        r6.afterAgentStep(r2, r3, r4);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(final IAutoActionAgentEventListener.SessionInfo r9, final BizStatus r10, final BizStatus r11, final int r12, final BizStatus.StatusChangedReasonStruct r13, final Bundle r14) {
        d.h.b.o.e(r9, "sessionInfo");
        d.h.b.o.e(r10, "oldStatus");
        d.h.b.o.e(r11, "status");
        d.h.b.o.e(r13, "reasonDetails");
        a(new $$Lambda$a$o6LyZKMYnXGjGsFkgDUm9cYzPFI(r9, r10, r11, r12, r13, r14));
    }

    private static final x a(IAutoActionAgentEventListener.SessionInfo r7, BizStatus r8, BizStatus r9, int r10, BizStatus.StatusChangedReasonStruct r11, Bundle r12, IAutoActionAgentEventListener r13) {
        IAutoActionAgentEventListener r0 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r13, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "$this$triggerListeners");
        r0.onBizStatusChanged(r7, r8, r9, r10, r11, r12);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onQueueStatusChanged(final IAutoActionAgentEventListener.SessionInfo r2, final QueueStatus r3) {
        d.h.b.o.e(r2, "sessionInfo");
        d.h.b.o.e(r3, "queueStatus");
        a(new $$Lambda$a$oZSabLcsm69FqAMxVIChGfyPQ(r2, r3));
    }

    private static final x a(IAutoActionAgentEventListener.SessionInfo r2, QueueStatus r3, IAutoActionAgentEventListener r4) {
        IAutoActionAgentEventListener r5 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r4, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "$this$triggerListeners");
        r5.onQueueStatusChanged(r2, r3);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onOperatingAppChanged(final IAutoActionAgentEventListener.SessionInfo r2, final IAutoActionAgentEventListener.OperatingAppInfo r3) {
        d.h.b.o.e(r2, "sessionInfo");
        a(new $$Lambda$a$392bl7W_ImaWWwMLjhOjDgkvks(r2, r3));
    }

    private static final x a(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener.OperatingAppInfo r3, IAutoActionAgentEventListener r4) {
        IAutoActionAgentEventListener r5 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r4, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "$this$triggerListeners");
        r5.onOperatingAppChanged(r2, r3);
        return x.f38692a;
    }

    public final void a(String r3, String r4) {
        d.h.b.o.e(r3, "sessionKey");
        f28929b.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0723a(r3, r4, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final AOThreadingTools.LaunchedJob a(d.h.a.b<? super IAutoActionAgentEventListener, x> r4) {
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        return f28929b.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r3, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onUIOperationHangup(final IAutoActionAgentEventListener.SessionInfo r2) {
        d.h.b.o.e(r2, "sessionInfo");
        a(new $$Lambda$a$XAYGwMnLfcBFd6c5QG2fupYfFwk(r2));
    }

    private static final x b(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener r3) {
        IAutoActionAgentEventListener r4 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r3, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "$this$triggerListeners");
        r4.onUIOperationHangup(r2);
        return x.f38692a;
    }
}
