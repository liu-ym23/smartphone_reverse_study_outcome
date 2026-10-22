package kotlinx.coroutines.flow.internal;

import com.stepos.core.common.log.c;
import gc.k;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import lb.n;
import qb.b;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T> {
    public final d collectContext;
    public final int collectContextSize;
    public final FlowCollector<T> collector;
    private b<? super n> completion_;
    private d lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(FlowCollector<? super T> flowCollector, d dVar) {
        super(NoOpContinuation.INSTANCE, EmptyCoroutineContext.f10057a);
        this.collector = flowCollector;
        this.collectContext = dVar;
        this.collectContextSize = ((Number) dVar.fold(0, new c(2))).intValue();
    }

    private final void checkContext(d dVar, d dVar2, T t8) {
        if (dVar2 instanceof DownstreamExceptionContext) {
            exceptionTransparencyViolated((DownstreamExceptionContext) dVar2, t8);
        }
        SafeCollector_commonKt.checkContext(this, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int collectContextSize$lambda$0(int i10, d.a aVar) {
        return i10 + 1;
    }

    private final void exceptionTransparencyViolated(DownstreamExceptionContext downstreamExceptionContext, Object obj) {
        throw new IllegalStateException(k.Z("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + downstreamExceptionContext.f10113e + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t8, b<? super n> frame) {
        try {
            Object objEmit = emit(frame, (b<? super n>) t8);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (objEmit == coroutineSingletons) {
                g.f(frame, "frame");
            }
            return objEmit == coroutineSingletons ? objEmit : n.f10413a;
        } catch (Throwable th) {
            this.lastEmissionContext = new DownstreamExceptionContext(th, frame.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, rb.b
    public rb.b getCallerFrame() {
        b<? super n> bVar = this.completion_;
        if (bVar instanceof rb.b) {
            return (rb.b) bVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, qb.b
    public d getContext() {
        d dVar = this.lastEmissionContext;
        return dVar == null ? EmptyCoroutineContext.f10057a : dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        Throwable thB = Result.b(obj);
        if (thB != null) {
            this.lastEmissionContext = new DownstreamExceptionContext(thB, getContext());
        }
        b<? super n> bVar = this.completion_;
        if (bVar != null) {
            bVar.resumeWith(obj);
        }
        return CoroutineSingletons.f10059a;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(b<? super n> bVar, T t8) {
        d context = bVar.getContext();
        JobKt.ensureActive(context);
        d dVar = this.lastEmissionContext;
        if (dVar != context) {
            checkContext(context, dVar, t8);
            this.lastEmissionContext = context;
        }
        this.completion_ = bVar;
        q qVar = SafeCollectorKt.emitFun;
        FlowCollector<T> flowCollector = this.collector;
        g.d(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object objInvoke = qVar.invoke(flowCollector, t8, this);
        if (!g.b(objInvoke, CoroutineSingletons.f10059a)) {
            this.completion_ = null;
        }
        return objInvoke;
    }
}
