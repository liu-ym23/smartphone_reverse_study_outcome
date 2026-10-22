package androidx.lifecycle;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class A extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3862a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ B f3863b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(B b4, Continuation continuation) {
        super(2, continuation);
        this.f3863b = b4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        A a4 = new A(this.f3863b, continuation);
        a4.f3862a = obj;
        return a4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((A) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Z2.F f4 = (Z2.F) this.f3862a;
        B b4 = this.f3863b;
        if (((I) b4.f3864a).f3871d.compareTo(EnumC0327y.f3984b) >= 0) {
            b4.f3864a.a(b4);
        } else {
            Z2.o0 o0Var = (Z2.o0) f4.e().get(Z2.n0.f2230a);
            if (o0Var != null) {
                o0Var.b(null);
            }
        }
        return Unit.INSTANCE;
    }
}
