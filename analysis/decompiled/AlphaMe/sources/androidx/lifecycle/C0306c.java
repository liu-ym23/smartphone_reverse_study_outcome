package androidx.lifecycle;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0306c extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f3915a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3916b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0307d f3917c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0306c(C0307d c0307d, Continuation continuation) {
        super(2, continuation);
        this.f3917c = c0307d;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0306c c0306c = new C0306c(this.f3917c, continuation);
        c0306c.f3916b = obj;
        return c0306c;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0306c) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f3915a;
        C0307d c0307d = this.f3917c;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            S s4 = new S(c0307d.f3919a, ((Z2.F) this.f3916b).e());
            Function2 function2 = c0307d.f3920b;
            this.f3915a = 1;
            if (function2.invoke(s4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        c0307d.f3923e.invoke();
        return Unit.INSTANCE;
    }
}
