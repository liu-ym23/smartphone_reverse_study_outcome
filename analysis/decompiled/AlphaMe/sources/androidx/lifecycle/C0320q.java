package androidx.lifecycle;

import b3.InterfaceC0379h;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: androidx.lifecycle.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0320q extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f3978a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3979b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0379h f3980c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0320q(InterfaceC0379h interfaceC0379h, Continuation continuation) {
        super(2, continuation);
        this.f3980c = interfaceC0379h;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0320q c0320q = new C0320q(this.f3980c, continuation);
        c0320q.f3979b = obj;
        return c0320q;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0320q) create((S) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f3978a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            C0319p c0319p = new C0319p((S) this.f3979b);
            this.f3978a = 1;
            if (this.f3980c.collect(c0319p, this) == coroutine_suspended) {
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
