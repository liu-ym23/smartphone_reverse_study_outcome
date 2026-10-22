package com.stepos.agentframework.adapter.bff;

import C7.r;
import J7.c;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1702U;
import m9.C1703V;
import m9.C1704W;
import m9.InterfaceC1733z;
import m9.c0;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffHeartbeatManager;", "", "Lkotlin/Function0;", "LC7/r;", "onSendHeartbeat", "onRemoveNullCallbacks", AppAgent.CONSTRUCT, "(LS7/a;LS7/a;)V", "", "intervalMs", "updateInterval", "(J)V", "scheduleNext", "()V", "stop", "LS7/a;", "Lm9/c0;", "heartJob", "Lm9/c0;", "heartTimeout", "J", "Lm9/U;", "heartPool", "Lm9/U;", "Companion", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BffHeartbeatManager {
    private static final long MIN_HEART_TIMEOUT = 10000;
    private c0 heartJob;
    private final AbstractC1702U heartPool;
    private long heartTimeout;
    private final S7.a onRemoveNullCallbacks;
    private final S7.a onSendHeartbeat;

    @c(c = "com.stepos.agentframework.adapter.bff.BffHeartbeatManager$scheduleNext$1", f = "BffHeartbeatManager.kt", l = {42}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.bff.BffHeartbeatManager$scheduleNext$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = BffHeartbeatManager.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                BffHeartbeatManager.this.onRemoveNullCallbacks.invoke();
                long j5 = BffHeartbeatManager.this.heartTimeout;
                this.L$0 = interfaceC1733z;
                this.label = 1;
                if (kotlinx.coroutines.a.f(j5, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            if (AbstractC1683A.l(interfaceC1733z)) {
                BffHeartbeatManager.this.onSendHeartbeat.invoke();
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public BffHeartbeatManager(S7.a onSendHeartbeat, S7.a onRemoveNullCallbacks) {
        k.f(onSendHeartbeat, "onSendHeartbeat");
        k.f(onRemoveNullCallbacks, "onRemoveNullCallbacks");
        this.onSendHeartbeat = onSendHeartbeat;
        this.onRemoveNullCallbacks = onRemoveNullCallbacks;
        this.heartTimeout = MIN_HEART_TIMEOUT;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        k.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.heartPool = new C1703V(executorServiceNewSingleThreadExecutor);
    }

    public final void scheduleNext() {
        c0 c0Var = this.heartJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.heartJob = AbstractC1683A.n(C1704W.f5321a, this.heartPool, new AnonymousClass1(null), 2);
    }

    public final void stop() {
        c0 c0Var = this.heartJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.heartJob = null;
    }

    public final void updateInterval(long intervalMs) {
        if (intervalMs < MIN_HEART_TIMEOUT) {
            this.heartTimeout = MIN_HEART_TIMEOUT;
        } else {
            this.heartTimeout = intervalMs;
        }
    }
}
