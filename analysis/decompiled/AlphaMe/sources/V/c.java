package V;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class c extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f1917a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1918b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f1919c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f1919c = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        c cVar = new c(this.f1919c, continuation);
        cVar.f1918b = obj;
        return cVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((h) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f1917a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            h hVar = (h) this.f1918b;
            this.f1917a = 1;
            obj = this.f1919c.invoke(hVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        h hVar2 = (h) obj;
        ((b) hVar2).f1916b.set(true);
        return hVar2;
    }
}
