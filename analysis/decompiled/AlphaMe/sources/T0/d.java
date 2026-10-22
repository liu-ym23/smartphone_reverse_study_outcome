package T0;

import Z2.F;
import Z2.Q;
import d3.q;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import t0.J;

/* loaded from: classes.dex */
public final class d extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1804a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f1805b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ F f1806c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ W0.a f1807d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h hVar, i iVar, F f4, W0.a aVar, Continuation continuation) {
        super(2, continuation);
        this.f1804a = hVar;
        this.f1805b = iVar;
        this.f1806c = f4;
        this.f1807d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new d(this.f1804a, this.f1805b, this.f1806c, this.f1807d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((d) create((F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        h hVar = this.f1804a;
        hVar.getClass();
        Object value = ((Result) J.M(new e(hVar, this.f1805b, null))).getValue();
        Throwable thM25exceptionOrNullimpl = Result.m25exceptionOrNullimpl(value);
        F f4 = this.f1806c;
        W0.a aVar = this.f1807d;
        if (thM25exceptionOrNullimpl == null) {
            boolean zBooleanValue = ((Boolean) value).booleanValue();
            f3.d dVar = Q.f2189a;
            J.y(f4, q.f12477a, new b(zBooleanValue, aVar, null), 2);
        } else {
            f3.d dVar2 = Q.f2189a;
            J.y(f4, q.f12477a, new c(aVar, thM25exceptionOrNullimpl, null), 2);
        }
        return Unit.INSTANCE;
    }
}
