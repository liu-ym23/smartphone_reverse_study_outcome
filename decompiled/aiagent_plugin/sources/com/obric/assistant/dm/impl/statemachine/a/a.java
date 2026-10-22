package com.obric.assistant.dm.impl.statemachine.a;

import com.obric.agent.trace.IIntentTraceService;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent;
import com.obric.assistant.dm.api.statemachine.core.ComplexTaskState;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.o;
import d.s;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ComplexTaskStateMachine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.assistant.dm.api.statemachine.core.d<ComplexTaskState, ComplexTaskEvent> {
    private static final String TAG = "ComplexTaskStateMachine";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0488a f22498b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ca f22499c;

    /* JADX INFO: renamed from: com.obric.assistant.dm.impl.statemachine.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ComplexTaskStateMachine.kt */
    public static final class C0488a {
        public /* synthetic */ C0488a(h r1) {
            this();
        }

        private C0488a() {
        }
    }

    /* JADX INFO: compiled from: ComplexTaskStateMachine.kt */
    @f(b = "ComplexTaskStateMachine.kt", c = {827, 832}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.ComplexTaskStateMachine$forceCompleteTask$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f22502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TaskId f22503d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f22504e;
        final /* synthetic */ String f;

        b(TaskId r3, a r4, String r5, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22503d = r3;
            this.f22504e = r4;
            this.f = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22503d, this.f22504e, this.f, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22502c;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r13);
        L27:
            this.f22504e.a((ComplexTaskEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.TaskCompleted(this.f22503d, null, 2, null), ComplexTaskEvent.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            z.f r2 = (z.f) ZeusTransformUtils.preCheckCast(this.f22501b, z.f.class, "com.obric.aiagent.plugin");
            z.f r6 = (z.f) ZeusTransformUtils.preCheckCast(this.f22500a, z.f.class, "com.obric.aiagent.plugin");
            o.a(r13);
        L22:
            T r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");
        L24:
            r2.f38504a = r14;
            this.f22504e.a((ComplexTaskEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.InterruptTask(this.f22503d, ao.a(new d.m[]{s.a("stop_reason", this.f), s.a("running_action", r6.f38504a)})), ComplexTaskEvent.class, "com.obric.aiagent.plugin"));
            d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22500a = null;
            this.f22501b = null;
            this.f22502c = 2;
            if (ax.a(100, r15) != r0) goto L27;
            return r0;
        L10:
            o.a(r13);
            TaskInfo r16 = com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(this.f22503d);
            r2 = new z.f();
            r2.f38504a = "NoAction";
            if (r16 == null) goto L15;
            IMMessage r17 = r16.getMessage();
            if (r17 == null) goto L15;
            String r18 = r17.getMessageId();
        L16:
            IIntentTraceService r7 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L23;
            String r19 = String.valueOf(r18);
            this.f22500a = r2;
            this.f22501b = r2;
            this.f22502c = 1;
            r13 = r7.getRunningAction(r19, this);
            if (r13 != r0) goto L21;
            return r0;
        L21:
            r6 = r2;
            goto L22
        L23:
            r6 = r2;
            r14 = 0;
        L15:
            r18 = null;
            goto L16
        }
    }

    /* JADX INFO: compiled from: ComplexTaskStateMachine.kt */
    @f(b = "ComplexTaskStateMachine.kt", c = {810}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.core.ComplexTaskStateMachine$startTimeout$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f22506b;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22506b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f22506b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0030 -> B:12:0x0033). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22505a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L13:
            if (com.obric.assistant.dm.impl.statemachine.a.c.f22509a.b() == false) goto L16;
        L17:
            a.a(this.f22506b);
            return x.f38692a;
        L16:
            if (ZeusTransformUtils.instanceOf(this.f22506b.a(), ComplexTaskState.Queueing.class) == false) goto L17;
        L9:
            long r3 = com.obric.assistant.dm.api.statemachine.core.a.f22459a.a();
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22505a = 1;
            if (ax.a(r3, r7) != r0) goto L13;
            return r0;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            goto L9
        }
    }

    static {
        f22498b = new C0488a(null);
    }

    /* JADX INFO: renamed from: lambda$7R_sIhyP-OQYxmKt1gESDSQVC1Q, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m409lambda$7R_sIhyPOQYxmKt1gESDSQVC1Q(ComplexTaskState r0, ComplexTaskEvent r1) {
        return g(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$7U1nGvXhNiM_BQebNXllKh8T1ew(ComplexTaskState r0, ComplexTaskEvent r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$7boIX0XkXZzN15Ss9toNjiYqwc0(ComplexTaskState r0, ComplexTaskEvent r1) {
        return K(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8BrC-5mQep_OUAk0QoRyK5eRuAE, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m410lambda$8BrC5mQep_OUAk0QoRyK5eRuAE(ComplexTaskState r0, ComplexTaskEvent r1) {
        return F(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$8IjeHyzQZwDEkN_jbYWJuxhQM0c(ComplexTaskState r0, ComplexTaskEvent r1) {
        return w(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$8LOdxMq8fo29CNCV_eZKJUJa8KE(ComplexTaskState r0, ComplexTaskEvent r1) {
        return r(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8Prj29RHxic7Kbx-uZPymT8K2QQ, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m411lambda$8Prj29RHxic7KbxuZPymT8K2QQ(ComplexTaskState r0, ComplexTaskEvent r1) {
        return n(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$A1gx_CgmyS6txknJ2LX366vWfV4(ComplexTaskState r0, ComplexTaskEvent r1) {
        return j(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$CiWOnVQkJNPwpK5RTxx9bqOiyA8(ComplexTaskState r0, ComplexTaskEvent r1) {
        return M(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$DkVcyq8IsCTLXt8weBHZhk-A-i0, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m412lambda$DkVcyq8IsCTLXt8weBHZhkAi0(ComplexTaskState r0, ComplexTaskEvent r1) {
        return P(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$G3CtxAo5cqTfOkThJO3IHfGRZfU(ComplexTaskState r0, ComplexTaskEvent r1) {
        return k(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$GNtzb4nY5ZZZGjnZUOXOJQsu6Ow(ComplexTaskState r0, ComplexTaskEvent r1) {
        return C(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$G_Fl_jXP8vYHiHtaMEad2uoK63k(ComplexTaskState r0, ComplexTaskEvent r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$HU4r3cZ95Fgjz6fozFvszEgu-So, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m413lambda$HU4r3cZ95Fgjz6fozFvszEguSo(ComplexTaskState r0, ComplexTaskEvent r1) {
        return L(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$L1wrnpkw7TqgykaZ_LiAwO0U6zI(ComplexTaskState r0, ComplexTaskEvent r1) {
        return D(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$O0kdz68Uudb8EH1-IT345BsDecE, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m414lambda$O0kdz68Uudb8EH1IT345BsDecE(ComplexTaskState r0, ComplexTaskEvent r1) {
        return p(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$OONuRZC2Zn0D66fU1PYnlSmLM6k(ComplexTaskState r0, ComplexTaskEvent r1) {
        return B(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$P_8oHJWCU0MKVCNUYabRD7q-Irs, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m415lambda$P_8oHJWCU0MKVCNUYabRD7qIrs(ComplexTaskState r0, ComplexTaskEvent r1) {
        return H(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$RuEpOZOlbsP7MdtL8xv1nlkuSng(ComplexTaskState r0, ComplexTaskEvent r1) {
        return o(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$SQ_ci7EgJ00OB8nlkRnOJuyDfpI(ComplexTaskState r0, ComplexTaskEvent r1) {
        return h(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$TtoTjX1TQ7CniZJk4kwkdmSEDEg(ComplexTaskState r0, ComplexTaskEvent r1) {
        return m(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$VtJC2EqwZYsk_GZrBnPQdpaq_9Y(ComplexTaskState r0, ComplexTaskEvent r1) {
        return A(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$VvCWK04o-onBZ1Z9GWGyz0Bb-go, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m416lambda$VvCWK04oonBZ1Z9GWGyz0Bbgo(ComplexTaskState r0, ComplexTaskEvent r1) {
        return J(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$WMGFonoqbIYQ70IQ5yR8PFByjQQ(ComplexTaskState r0, ComplexTaskEvent r1) {
        return u(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$XBHqMbOp-vB6bcCaubU5Lx8wDF4, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m417lambda$XBHqMbOpvB6bcCaubU5Lx8wDF4(ComplexTaskState r0, ComplexTaskEvent r1) {
        return N(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$YXZGQN4seX0QEMvXaczpobDhqb4(ComplexTaskState r0, ComplexTaskEvent r1) {
        return i(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ZVVNv0y_TkvPjY-kknwV7OkJiVg, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m418lambda$ZVVNv0y_TkvPjYkknwV7OkJiVg(ComplexTaskState r0, ComplexTaskEvent r1) {
        return l(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$_3WenwtsDUuF8D0Tzr0ml0IH8FY(ComplexTaskState r0, ComplexTaskEvent r1) {
        return I(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$agH6txcLOMBlNMd0Tj6ciHdL40U(ComplexTaskState r0, ComplexTaskEvent r1) {
        return q(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$eTe0gEkqhfjcieMZ1Z1zWbT3p1M(ComplexTaskState r0, ComplexTaskEvent r1) {
        return O(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$h0YxMuZeH5cr0hA49DFL5MWrHeg(ComplexTaskState r0, ComplexTaskEvent r1) {
        return f(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ilNVBf8cGZDGn7IVIS_wRDBK-xU, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m419lambda$ilNVBf8cGZDGn7IVIS_wRDBKxU(ComplexTaskState r0, ComplexTaskEvent r1) {
        return s(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$joaqjQyiB5ROMtKLSg0uw0ybdw8(ComplexTaskState r0, ComplexTaskEvent r1) {
        return z(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$ktoAv8Twg2v6XhJn8iLfOJTsdmw(ComplexTaskState r0, ComplexTaskEvent r1) {
        return E(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$l2cVs-plpvg3j19giLDjC_QEu9w, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m420lambda$l2cVsplpvg3j19giLDjC_QEu9w(ComplexTaskState r0, ComplexTaskEvent r1) {
        return e(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$mLaEHPYUjDptSu1TbhYvn3h_f3U(ComplexTaskState r0, ComplexTaskEvent r1) {
        return t(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$nic-t0f9RfD_5OPl-c-s9EpfPak, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m421lambda$nict0f9RfD_5OPlcs9EpfPak(ComplexTaskState r0, ComplexTaskEvent r1) {
        return y(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$o6X0Ls9hS6mCe5--wL5h5gh21HU, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m422lambda$o6X0Ls9hS6mCe5wL5h5gh21HU(ComplexTaskState r0, ComplexTaskEvent r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$qbl4uk5-4sYR7ZaCv8u3-mFrXrg, reason: not valid java name */
    public static /* synthetic */ ComplexTaskState m423lambda$qbl4uk54sYR7ZaCv8u3mFrXrg(ComplexTaskState r0, ComplexTaskEvent r1) {
        return v(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$rOubgFrpF7wkLo9oHT1LQ5WUWDU(ComplexTaskState r0, ComplexTaskEvent r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$teKrE680pOUh4rzZcg3lsGQDes8(ComplexTaskState r0, ComplexTaskEvent r1) {
        return x(r0, r1);
    }

    public static /* synthetic */ ComplexTaskState lambda$z_zV5NLsOl10RAK9DLvX0_TV8yc(ComplexTaskState r0, ComplexTaskEvent r1) {
        return G(r0, r1);
    }

    public final boolean a(TaskId r1, TaskInfo r2) {
        d.h.b.o.e(r1, DBDefinition.TASK_ID);
        d.h.b.o.e(r2, "taskInfo");
        return true;
    }

    public static final /* synthetic */ void a(a r0) {
        r0.g();
    }

    @Override // com.obric.assistant.dm.api.statemachine.core.d
    public /* synthetic */ boolean a(DMEvent r3) {
        return a((ComplexTaskEvent) ZeusTransformUtils.preCheckCast(r3, ComplexTaskEvent.class, "com.obric.aiagent.plugin"));
    }

    public a(TaskId r9, String r10, TaskInfo r11) {
        d.h.b.o.e(r9, DBDefinition.TASK_ID);
        d.h.b.o.e(r10, "name");
        d.h.b.o.e(r11, "taskInfo");
        super((State) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(r9, r11, 0, null, 12, null), State.class, "com.obric.aiagent.plugin"), r10);
        e();
    }

    private final void e() {
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Idle.class, ComplexTaskState.Thinking.class, ComplexTaskEvent.StartTask.class, $$Lambda$a$G_Fl_jXP8vYHiHtaMEad2uoK63k.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Idle.class, ComplexTaskState.Clarify.class, ComplexTaskEvent.TriggerComplexClarify.class, $$Lambda$a$o6X0Ls9hS6mCe5wL5h5gh21HU.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Idle.class, ComplexTaskState.Queueing.class, ComplexTaskEvent.TriggerComplexQueueing.class, $$Lambda$a$rOubgFrpF7wkLo9oHT1LQ5WUWDU.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Idle.class, ComplexTaskState.Thinking.class, ComplexTaskEvent.ContinueThinking.class, $$Lambda$a$7U1nGvXhNiM_BQebNXllKh8T1ew.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Queueing.class, ComplexTaskState.Thinking.class, ComplexTaskEvent.ContinueThinking.class, $$Lambda$a$l2cVsplpvg3j19giLDjC_QEu9w.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Queueing.class, ComplexTaskState.Clarify.class, ComplexTaskEvent.TriggerComplexClarify.class, $$Lambda$a$h0YxMuZeH5cr0hA49DFL5MWrHeg.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Thinking.class, ComplexTaskState.Clarify.class, ComplexTaskEvent.TriggerComplexClarify.class, $$Lambda$a$7R_sIhyPOQYxmKt1gESDSQVC1Q.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Thinking.class, ComplexTaskState.TakingOver.class, ComplexTaskEvent.TriggerComplexTakingOver.class, $$Lambda$a$SQ_ci7EgJ00OB8nlkRnOJuyDfpI.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.CallUser.class, ComplexTaskState.TakingOver.class, ComplexTaskEvent.TriggerComplexTakingOver.class, $$Lambda$a$YXZGQN4seX0QEMvXaczpobDhqb4.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Clarify.class, ComplexTaskState.TakingOver.class, ComplexTaskEvent.TriggerComplexTakingOver.class, $$Lambda$a$A1gx_CgmyS6txknJ2LX366vWfV4.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Clarify.class, ComplexTaskState.ClarifyAck.class, ComplexTaskEvent.RecieveComplexClarify.class, $$Lambda$a$G3CtxAo5cqTfOkThJO3IHfGRZfU.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Clarify.class, ComplexTaskState.Thinking.class, ComplexTaskEvent.ContinueThinking.class, $$Lambda$a$ZVVNv0y_TkvPjYkknwV7OkJiVg.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.TakingOver.class, ComplexTaskState.Thinking.class, ComplexTaskEvent.ContinueThinking.class, $$Lambda$a$TtoTjX1TQ7CniZJk4kwkdmSEDEg.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.TakingOver.class, ComplexTaskState.Clarify.class, ComplexTaskEvent.TriggerComplexClarify.class, $$Lambda$a$8Prj29RHxic7KbxuZPymT8K2QQ.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Clarify.class, ComplexTaskState.TakingOver.class, ComplexTaskEvent.TriggerComplexTakingOver.class, $$Lambda$a$RuEpOZOlbsP7MdtL8xv1nlkuSng.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.ClarifyAck.class, ComplexTaskState.Thinking.class, ComplexTaskEvent.ContinueThinking.class, $$Lambda$a$O0kdz68Uudb8EH1IT345BsDecE.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.ClarifyAck.class, ComplexTaskState.Clarify.class, ComplexTaskEvent.TriggerComplexClarify.class, $$Lambda$a$agH6txcLOMBlNMd0Tj6ciHdL40U.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.ClarifyAck.class, ComplexTaskState.CallUser.class, ComplexTaskEvent.TriggerComplexCalluser.class, $$Lambda$a$8LOdxMq8fo29CNCV_eZKJUJa8KE.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.ClarifyAck.class, ComplexTaskState.TakingOver.class, ComplexTaskEvent.TriggerComplexTakingOver.class, $$Lambda$a$ilNVBf8cGZDGn7IVIS_wRDBKxU.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Thinking.class, ComplexTaskState.ThinkingCompleted.class, ComplexTaskEvent.ThinkingCompleted.class, $$Lambda$a$mLaEHPYUjDptSu1TbhYvn3h_f3U.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.ThinkingCompleted.class, ComplexTaskState.Idle.class, ComplexTaskEvent.TaskCompleted.class, $$Lambda$a$WMGFonoqbIYQ70IQ5yR8PFByjQQ.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.ThinkingCompleted.class, ComplexTaskState.TTS.class, ComplexTaskEvent.PlayTTS.class, $$Lambda$a$qbl4uk54sYR7ZaCv8u3mFrXrg.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.TTS.class, ComplexTaskState.Idle.class, ComplexTaskEvent.TaskCompleted.class, $$Lambda$a$8IjeHyzQZwDEkN_jbYWJuxhQM0c.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Idle.class, ComplexTaskState.Terminated.class, ComplexTaskEvent.InterruptTask.class, $$Lambda$a$teKrE680pOUh4rzZcg3lsGQDes8.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Idle.class, ComplexTaskState.Idle.class, ComplexTaskEvent.TaskCompleted.class, $$Lambda$a$nict0f9RfD_5OPlcs9EpfPak.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.TTS.class, ComplexTaskState.Terminated.class, ComplexTaskEvent.InterruptTask.class, $$Lambda$a$joaqjQyiB5ROMtKLSg0uw0ybdw8.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Queueing.class, ComplexTaskState.Terminated.class, ComplexTaskEvent.InterruptTask.class, $$Lambda$a$VtJC2EqwZYsk_GZrBnPQdpaq_9Y.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Thinking.class, ComplexTaskState.Terminated.class, ComplexTaskEvent.InterruptTask.class, $$Lambda$a$OONuRZC2Zn0D66fU1PYnlSmLM6k.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Thinking.class, ComplexTaskState.CallUser.class, ComplexTaskEvent.TriggerComplexCalluser.class, $$Lambda$a$GNtzb4nY5ZZZGjnZUOXOJQsu6Ow.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.CallUser.class, ComplexTaskState.Thinking.class, ComplexTaskEvent.ContinueThinking.class, $$Lambda$a$L1wrnpkw7TqgykaZ_LiAwO0U6zI.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.CallUser.class, ComplexTaskState.Terminated.class, ComplexTaskEvent.InterruptTask.class, $$Lambda$a$ktoAv8Twg2v6XhJn8iLfOJTsdmw.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.CallUser.class, ComplexTaskState.Idle.class, ComplexTaskEvent.TaskCompleted.class, $$Lambda$a$8BrC5mQep_OUAk0QoRyK5eRuAE.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Clarify.class, ComplexTaskState.Terminated.class, ComplexTaskEvent.InterruptTask.class, $$Lambda$a$z_zV5NLsOl10RAK9DLvX0_TV8yc.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.TakingOver.class, ComplexTaskState.Terminated.class, ComplexTaskEvent.InterruptTask.class, $$Lambda$a$P_8oHJWCU0MKVCNUYabRD7qIrs.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.ClarifyAck.class, ComplexTaskState.Terminated.class, ComplexTaskEvent.InterruptTask.class, $$Lambda$a$_3WenwtsDUuF8D0Tzr0ml0IH8FY.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.ThinkingCompleted.class, ComplexTaskState.Terminated.class, ComplexTaskEvent.InterruptTask.class, $$Lambda$a$VvCWK04oonBZ1Z9GWGyz0Bbgo.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Thinking.class, ComplexTaskState.Idle.class, ComplexTaskEvent.TaskCompleted.class, $$Lambda$a$7boIX0XkXZzN15Ss9toNjiYqwc0.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Queueing.class, ComplexTaskState.Idle.class, ComplexTaskEvent.TaskCompleted.class, $$Lambda$a$HU4r3cZ95Fgjz6fozFvszEguSo.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Clarify.class, ComplexTaskState.Idle.class, ComplexTaskEvent.TaskCompleted.class, $$Lambda$a$CiWOnVQkJNPwpK5RTxx9bqOiyA8.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.ClarifyAck.class, ComplexTaskState.Idle.class, ComplexTaskEvent.TaskCompleted.class, $$Lambda$a$XBHqMbOpvB6bcCaubU5Lx8wDF4.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.ThinkingCompleted.class, ComplexTaskState.Idle.class, ComplexTaskEvent.TaskCompleted.class, $$Lambda$a$eTe0gEkqhfjcieMZ1Z1zWbT3p1M.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
        a((com.obric.assistant.dm.api.statemachine.core.f) ZeusTransformUtils.preCheckCast(new com.obric.assistant.dm.api.statemachine.core.c(ComplexTaskState.Terminated.class, ComplexTaskState.Idle.class, ComplexTaskEvent.TaskCompleted.class, $$Lambda$a$DkVcyq8IsCTLXt8weBHZhkAi0.INSTANCE, null, 16, null), com.obric.assistant.dm.api.statemachine.core.f.class, "com.obric.aiagent.plugin"));
    }

    private static final ComplexTaskState a(ComplexTaskState r10, ComplexTaskEvent r11) {
        d.h.b.o.e(r10, "currentState");
        d.h.b.o.e(r11, "event");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Thinking(((ComplexTaskEvent.StartTask) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.StartTask.class, "com.obric.aiagent.plugin")).getTaskId(), r10.getTaskInfo(), 0, ao.a(r10.getExtra(), ((ComplexTaskEvent.StartTask) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.StartTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState b(ComplexTaskState r10, ComplexTaskEvent r11) {
        d.h.b.o.e(r10, "currentState");
        d.h.b.o.e(r11, "event");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Clarify(((ComplexTaskEvent.TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.TriggerComplexClarify.class, "com.obric.aiagent.plugin")).getTaskId(), r10.getTaskInfo(), 0, ao.a(r10.getExtra(), ((ComplexTaskEvent.TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.TriggerComplexClarify.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState c(ComplexTaskState r10, ComplexTaskEvent r11) {
        d.h.b.o.e(r10, "currentState");
        d.h.b.o.e(r11, "event");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Queueing(((ComplexTaskEvent.TriggerComplexQueueing) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.TriggerComplexQueueing.class, "com.obric.aiagent.plugin")).getTaskId(), r10.getTaskInfo(), 0, ao.a(r10.getExtra(), ((ComplexTaskEvent.TriggerComplexQueueing) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.TriggerComplexQueueing.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState d(ComplexTaskState r10, ComplexTaskEvent r11) {
        d.h.b.o.e(r10, "currentState");
        d.h.b.o.e(r11, "event");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Thinking(((ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin")).getTaskId(), r10.getTaskInfo(), 0, ao.a(r10.getExtra(), ((ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState e(ComplexTaskState r10, ComplexTaskEvent r11) {
        d.h.b.o.e(r10, "currentState");
        d.h.b.o.e(r11, "event");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Thinking(((ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin")).getTaskId(), r10.getTaskInfo(), 0, ao.a(r10.getExtra(), ((ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState f(ComplexTaskState r10, ComplexTaskEvent r11) {
        d.h.b.o.e(r10, "currentState");
        d.h.b.o.e(r11, "event");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Clarify(((ComplexTaskEvent.TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.TriggerComplexClarify.class, "com.obric.aiagent.plugin")).getTaskId(), r10.getTaskInfo(), 0, ao.a(r10.getExtra(), ((ComplexTaskEvent.TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.TriggerComplexClarify.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState g(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.TriggerComplexClarify r0 = (ComplexTaskEvent.TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexClarify.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Thinking r1 = (ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Clarify(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexClarify.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState h(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskState.Thinking r0 = (ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.TakingOver(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getExtra(), r10.getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState i(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskState.CallUser r0 = (ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.TakingOver(((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getExtra(), r10.getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState j(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskState.Clarify r0 = (ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.TakingOver(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getExtra(), r10.getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState k(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.RecieveComplexClarify r0 = (ComplexTaskEvent.RecieveComplexClarify) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.RecieveComplexClarify.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Clarify r1 = (ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.ClarifyAck(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.RecieveComplexClarify) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.RecieveComplexClarify.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState l(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.ContinueThinking r0 = (ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Clarify r1 = (ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Thinking(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState m(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.ContinueThinking r0 = (ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin");
        ComplexTaskState.TakingOver r1 = (ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Thinking(((ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState n(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.TriggerComplexClarify r0 = (ComplexTaskEvent.TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexClarify.class, "com.obric.aiagent.plugin");
        ComplexTaskState.TakingOver r1 = (ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Clarify(((ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexClarify.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState o(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.TriggerComplexTakingOver r0 = (ComplexTaskEvent.TriggerComplexTakingOver) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexTakingOver.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Clarify r1 = (ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.TakingOver(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TriggerComplexTakingOver) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexTakingOver.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState p(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.ContinueThinking r0 = (ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin");
        ComplexTaskState.ClarifyAck r1 = (ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Thinking(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState q(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.TriggerComplexClarify r0 = (ComplexTaskEvent.TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexClarify.class, "com.obric.aiagent.plugin");
        ComplexTaskState.ClarifyAck r1 = (ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Clarify(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TriggerComplexClarify) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexClarify.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState r(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.TriggerComplexCalluser r0 = (ComplexTaskEvent.TriggerComplexCalluser) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexCalluser.class, "com.obric.aiagent.plugin");
        ComplexTaskState.ClarifyAck r1 = (ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.CallUser(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TriggerComplexCalluser) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexCalluser.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState s(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.TriggerComplexTakingOver r0 = (ComplexTaskEvent.TriggerComplexTakingOver) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexTakingOver.class, "com.obric.aiagent.plugin");
        ComplexTaskState.ClarifyAck r1 = (ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.TakingOver(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TriggerComplexTakingOver) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexTakingOver.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState t(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.ThinkingCompleted r0 = (ComplexTaskEvent.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.ThinkingCompleted.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Thinking r1 = (ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.ThinkingCompleted(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState u(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.TaskCompleted r0 = (ComplexTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin");
        ComplexTaskState.ThinkingCompleted r1 = (ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState v(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.PlayTTS r0 = (ComplexTaskEvent.PlayTTS) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.PlayTTS.class, "com.obric.aiagent.plugin");
        ComplexTaskState.ThinkingCompleted r1 = (ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.TTS(((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.PlayTTS) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.PlayTTS.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState w(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.TaskCompleted r0 = (ComplexTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin");
        ComplexTaskState.TTS r1 = (ComplexTaskState.TTS) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TTS.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(((ComplexTaskState.TTS) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TTS.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.TTS) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TTS.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.TTS) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TTS.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState x(ComplexTaskState r10, ComplexTaskEvent r11) {
        d.h.b.o.e(r10, "currentState");
        d.h.b.o.e(r11, "event");
        ComplexTaskEvent.InterruptTask r0 = (ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Idle r2 = (ComplexTaskState.Idle) ZeusTransformUtils.preCheckCast(r10, ComplexTaskState.Idle.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Terminated(r0.getTaskId(), ((ComplexTaskState.Idle) ZeusTransformUtils.preCheckCast(r10, ComplexTaskState.Idle.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Idle) ZeusTransformUtils.preCheckCast(r10, ComplexTaskState.Idle.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState y(ComplexTaskState r10, ComplexTaskEvent r11) {
        d.h.b.o.e(r10, "currentState");
        d.h.b.o.e(r11, "event");
        ComplexTaskEvent.TaskCompleted r0 = (ComplexTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Idle r2 = (ComplexTaskState.Idle) ZeusTransformUtils.preCheckCast(r10, ComplexTaskState.Idle.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(r0.getTaskId(), ((ComplexTaskState.Idle) ZeusTransformUtils.preCheckCast(r10, ComplexTaskState.Idle.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Idle) ZeusTransformUtils.preCheckCast(r10, ComplexTaskState.Idle.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r11, ComplexTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState z(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.InterruptTask r0 = (ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin");
        ComplexTaskState.TTS r1 = (ComplexTaskState.TTS) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TTS.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Terminated(((ComplexTaskState.TTS) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TTS.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.TTS) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TTS.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.TTS) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TTS.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState A(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.InterruptTask r0 = (ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Queueing r1 = (ComplexTaskState.Queueing) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Queueing.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Terminated(((ComplexTaskState.Queueing) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Queueing.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Queueing) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Queueing.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Queueing) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Queueing.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState B(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.InterruptTask r0 = (ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Thinking r1 = (ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Terminated(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState C(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.TriggerComplexCalluser r0 = (ComplexTaskEvent.TriggerComplexCalluser) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexCalluser.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Thinking r1 = (ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.CallUser(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TriggerComplexCalluser) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TriggerComplexCalluser.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState D(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.ContinueThinking r0 = (ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin");
        ComplexTaskState.CallUser r1 = (ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Thinking(((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.ContinueThinking) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.ContinueThinking.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState E(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.InterruptTask r0 = (ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin");
        ComplexTaskState.CallUser r1 = (ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Terminated(((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState F(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.TaskCompleted r0 = (ComplexTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin");
        ComplexTaskState.CallUser r1 = (ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.CallUser) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.CallUser.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.TaskCompleted) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.TaskCompleted.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState G(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.InterruptTask r0 = (ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin");
        ComplexTaskState.Clarify r1 = (ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Terminated(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState H(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.InterruptTask r0 = (ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin");
        ComplexTaskState.TakingOver r1 = (ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Terminated(((ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.TakingOver) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.TakingOver.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState I(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.InterruptTask r0 = (ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin");
        ComplexTaskState.ClarifyAck r1 = (ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Terminated(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState J(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskEvent.InterruptTask r0 = (ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin");
        ComplexTaskState.ThinkingCompleted r1 = (ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Terminated(((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getExtra(), ((ComplexTaskEvent.InterruptTask) ZeusTransformUtils.preCheckCast(r10, ComplexTaskEvent.InterruptTask.class, "com.obric.aiagent.plugin")).getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState K(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskState.Thinking r0 = (ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Thinking) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Thinking.class, "com.obric.aiagent.plugin")).getExtra(), r10.getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState L(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskState.Queueing r0 = (ComplexTaskState.Queueing) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Queueing.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(((ComplexTaskState.Queueing) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Queueing.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Queueing) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Queueing.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Queueing) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Queueing.class, "com.obric.aiagent.plugin")).getExtra(), r10.getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState M(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskState.Clarify r0 = (ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin")).getExtra(), r10.getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState N(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskState.ClarifyAck r0 = (ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.ClarifyAck) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ClarifyAck.class, "com.obric.aiagent.plugin")).getExtra(), r10.getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState O(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskState.ThinkingCompleted r0 = (ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.ThinkingCompleted) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.ThinkingCompleted.class, "com.obric.aiagent.plugin")).getExtra(), r10.getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    private static final ComplexTaskState P(ComplexTaskState r9, ComplexTaskEvent r10) {
        d.h.b.o.e(r9, "currentState");
        d.h.b.o.e(r10, "event");
        ComplexTaskState.Terminated r0 = (ComplexTaskState.Terminated) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Terminated.class, "com.obric.aiagent.plugin");
        return (ComplexTaskState) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(((ComplexTaskState.Terminated) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Terminated.class, "com.obric.aiagent.plugin")).getTaskId(), ((ComplexTaskState.Terminated) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Terminated.class, "com.obric.aiagent.plugin")).getTaskInfo(), 0, ao.a(((ComplexTaskState.Terminated) ZeusTransformUtils.preCheckCast(r9, ComplexTaskState.Terminated.class, "com.obric.aiagent.plugin")).getExtra(), r10.getExtra()), 4, null), ComplexTaskState.class, "com.obric.aiagent.plugin");
    }

    public boolean a(ComplexTaskEvent r4) {
        d.h.b.o.e(r4, "event");
        boolean r5 = super.a((DMEvent) ZeusTransformUtils.preCheckCast(r4, DMEvent.class, "com.obric.aiagent.plugin"));
        ca r0 = this.f22499c;
        if (r0 == null) goto L6;
        ca.a.a(r0, null, 1, null);
    L6:
        if (c() == true) goto L8;
        f();
    L8:
        return r5;
    }

    public final boolean c() {
        return ((ComplexTaskState) ZeusTransformUtils.preCheckCast(a(), ComplexTaskState.class, "com.obric.aiagent.plugin")).isCompletedOrCanceled();
    }

    private final void f() {
        ca r0 = this.f22499c;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.f22499c = i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void a(TaskId r10, String r11) {
        d.h.b.o.e(r10, DBDefinition.TASK_ID);
        d.h.b.o.e(r11, "stopReason");
        i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r10, this, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void g() {
        TaskId r0 = d();
        if (r0 == null) goto L6;
        a(r0, "omni_task_client_timeout");
        return;
    }

    public final TaskId d() {
        return ((ComplexTaskState) ZeusTransformUtils.preCheckCast(a(), ComplexTaskState.class, "com.obric.aiagent.plugin")).getTaskId();
    }
}
