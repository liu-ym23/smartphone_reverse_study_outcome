package c3;

import Z2.AbstractC0149x;
import Z2.F;
import Z2.I;
import Z2.Q;
import a3.C0160e;
import a3.s;
import b3.AbstractC0375d;
import b3.InterfaceC0380i;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes2.dex */
public final class d extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f4474a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4475b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0380i f4476c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0375d f4477d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Continuation continuation, AbstractC0375d abstractC0375d, InterfaceC0380i interfaceC0380i) {
        super(2, continuation);
        this.f4476c = interfaceC0380i;
        this.f4477d = abstractC0375d;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        d dVar = new d(continuation, this.f4477d, this.f4476c);
        dVar.f4475b = obj;
        return dVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((d) create((F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f4474a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            F f4 = (F) this.f4475b;
            AbstractC0375d abstractC0375d = this.f4477d;
            int i5 = abstractC0375d.f4396b;
            if (i5 == -3) {
                i5 = -2;
            }
            Function2 eVar = new e(abstractC0375d, null);
            C0160e c0160eA = com.stepos.statsrpk.c.a(i5, abstractC0375d.f4397c, 4);
            CoroutineContext coroutineContextA = AbstractC0149x.a(f4.e(), abstractC0375d.f4395a, true);
            f3.d dVar = Q.f2189a;
            if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
                coroutineContextA = coroutineContextA.plus(dVar);
            }
            s sVar = new s(coroutineContextA, c0160eA);
            sVar.Z(3, sVar, eVar);
            this.f4474a = 1;
            Object objI = I.i(this.f4476c, sVar, true, this);
            if (objI != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objI = Unit.INSTANCE;
            }
            if (objI == coroutine_suspended) {
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
