package androidx.lifecycle;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class Q extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f3899a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S f3900b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3901c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(S s4, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f3900b = s4;
        this.f3901c = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Q(this.f3900b, this.f3901c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((Q) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f3899a;
        S s4 = this.f3900b;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            C0314k c0314k = s4.f3902a;
            this.f3899a = 1;
            if (c0314k.i(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        s4.f3902a.g(this.f3901c);
        return Unit.INSTANCE;
    }
}
