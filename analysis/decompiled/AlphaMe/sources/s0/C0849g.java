package s0;

import androidx.work.CoroutineWorker;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: s0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0849g extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f14197a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineWorker f14198b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0849g(CoroutineWorker coroutineWorker, Continuation continuation) {
        super(2, continuation);
        this.f14198b = coroutineWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0849g(this.f14198b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0849g) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f14197a;
        CoroutineWorker coroutineWorker = this.f14198b;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                this.f14197a = 1;
                obj = coroutineWorker.doWork(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            coroutineWorker.getFuture().j((r) obj);
        } catch (Throwable th) {
            coroutineWorker.getFuture().k(th);
        }
        return Unit.INSTANCE;
    }
}
