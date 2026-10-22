package c3;

import a3.t;
import b3.AbstractC0375d;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes2.dex */
public final class e extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f4478a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4479b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0375d f4480c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AbstractC0375d abstractC0375d, Continuation continuation) {
        super(2, continuation);
        this.f4480c = abstractC0375d;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        e eVar = new e(this.f4480c, continuation);
        eVar.f4479b = obj;
        return eVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((e) create((t) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f4478a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            t tVar = (t) this.f4479b;
            this.f4478a = 1;
            if (this.f4480c.a(tVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
