package S;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class v extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1776a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ N f1777b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(N n4, Continuation continuation) {
        super(2, continuation);
        this.f1777b = n4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        v vVar = new v(this.f1777b, continuation);
        vVar.f1776a = obj;
        return vVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((v) create((N) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        N n4 = (N) this.f1776a;
        N n5 = this.f1777b;
        boolean z4 = false;
        if (!(n5 instanceof C0097c) && !(n5 instanceof C0104j) && n4 == n5) {
            z4 = true;
        }
        return Boxing.boxBoolean(z4);
    }
}
