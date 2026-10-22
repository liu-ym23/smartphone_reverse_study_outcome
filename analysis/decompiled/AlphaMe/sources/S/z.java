package S;

import b3.InterfaceC0380i;
import com.stepos.policy.sdk.T;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class z extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f1785a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1786b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ M f1787c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(M m4, Continuation continuation) {
        super(2, continuation);
        this.f1787c = m4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        z zVar = new z(this.f1787c, continuation);
        zVar.f1786b = obj;
        return zVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((z) create((InterfaceC0380i) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f1785a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC0380i interfaceC0380i = (InterfaceC0380i) this.f1786b;
            M m4 = this.f1787c;
            N n4 = (N) m4.f1732g.a();
            if (!(n4 instanceof C0097c)) {
                m4.f1734i.d(new C0109o(n4));
            }
            y yVar = new y(new T(m4.f1732g, new v(n4, null), 2), 0);
            this.f1785a = 1;
            Object objCollect = yVar.collect(interfaceC0380i, this);
            if (objCollect != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objCollect = Unit.INSTANCE;
            }
            if (objCollect == coroutine_suspended) {
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
