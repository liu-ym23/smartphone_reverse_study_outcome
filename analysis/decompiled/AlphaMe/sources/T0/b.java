package T0;

import Z2.F;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class b extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1800a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ W0.a f1801b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(boolean z4, W0.a aVar, Continuation continuation) {
        super(2, continuation);
        this.f1800a = z4;
        this.f1801b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new b(this.f1800a, this.f1801b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        boolean z4 = this.f1800a;
        W0.a aVar = this.f1801b;
        if (z4) {
            aVar.onSuccess();
        } else {
            aVar.onFail(new X0.a("未知错误", 0));
        }
        return Unit.INSTANCE;
    }
}
