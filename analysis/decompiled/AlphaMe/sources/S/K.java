package S;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class K extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f1714a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f1715b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1716c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(Function2 function2, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f1715b = function2;
        this.f1716c = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new K(this.f1715b, this.f1716c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((K) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f1714a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f1714a = 1;
            obj = this.f1715b.invoke(this.f1716c, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
