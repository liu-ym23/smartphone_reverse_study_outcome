package c3;

import Z2.I;
import b3.InterfaceC0380i;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public final class o extends ContinuationImpl implements InterfaceC0380i {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0380i f4508a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f4509b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4510c;

    /* renamed from: d, reason: collision with root package name */
    public CoroutineContext f4511d;

    /* renamed from: e, reason: collision with root package name */
    public Continuation f4512e;

    public o(InterfaceC0380i interfaceC0380i, CoroutineContext coroutineContext) {
        super(l.f4503a, EmptyCoroutineContext.INSTANCE);
        this.f4508a = interfaceC0380i;
        this.f4509b = coroutineContext;
        this.f4510c = ((Number) coroutineContext.fold(0, n.f4507a)).intValue();
    }

    public final Object a(Continuation continuation, Object obj) {
        CoroutineContext coroutineContext = continuation.get$context();
        I.j(coroutineContext);
        CoroutineContext coroutineContext2 = this.f4511d;
        if (coroutineContext2 != coroutineContext) {
            if (coroutineContext2 instanceof j) {
                throw new IllegalStateException(StringsKt.trimIndent("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((j) coroutineContext2).f4501a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) coroutineContext.fold(0, new r(this))).intValue() != this.f4510c) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f4509b + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.f4511d = coroutineContext;
        }
        this.f4512e = continuation;
        Function3 function3 = q.f4514a;
        InterfaceC0380i interfaceC0380i = this.f4508a;
        Intrinsics.checkNotNull(interfaceC0380i, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = function3.invoke(interfaceC0380i, obj, this);
        if (!Intrinsics.areEqual(objInvoke, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
            this.f4512e = null;
        }
        return objInvoke;
    }

    @Override // b3.InterfaceC0380i
    public final Object emit(Object obj, Continuation continuation) {
        try {
            Object objA = a(continuation, obj);
            if (objA == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
        } catch (Throwable th) {
            this.f4511d = new j(continuation.get$context(), th);
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f4512e;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public final CoroutineContext get$context() {
        CoroutineContext coroutineContext = this.f4511d;
        return coroutineContext == null ? EmptyCoroutineContext.INSTANCE : coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable thM25exceptionOrNullimpl = Result.m25exceptionOrNullimpl(obj);
        if (thM25exceptionOrNullimpl != null) {
            this.f4511d = new j(get$context(), thM25exceptionOrNullimpl);
        }
        Continuation continuation = this.f4512e;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
