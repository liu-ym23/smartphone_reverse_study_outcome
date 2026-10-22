package s0;

import androidx.work.CoroutineWorker;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: s0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0848f extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public n f14193a;

    /* renamed from: b, reason: collision with root package name */
    public int f14194b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f14195c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CoroutineWorker f14196d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0848f(n nVar, CoroutineWorker coroutineWorker, Continuation continuation) {
        super(2, continuation);
        this.f14195c = nVar;
        this.f14196d = coroutineWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0848f(this.f14195c, this.f14196d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0848f) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        n nVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f14194b;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            n nVar2 = this.f14195c;
            this.f14193a = nVar2;
            this.f14194b = 1;
            Object foregroundInfo = this.f14196d.getForegroundInfo(this);
            if (foregroundInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = foregroundInfo;
            nVar = nVar2;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            nVar = this.f14193a;
            ResultKt.throwOnFailure(obj);
        }
        nVar.f14208a.j(obj);
        return Unit.INSTANCE;
    }
}
