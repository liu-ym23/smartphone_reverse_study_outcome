package androidx.lifecycle;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0305b extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f3913a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0307d f3914b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0305b(C0307d c0307d, Continuation continuation) {
        super(2, continuation);
        this.f3914b = c0307d;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C0305b(this.f3914b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0305b) create((Z2.F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f3913a;
        C0307d c0307d = this.f3914b;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            long j4 = c0307d.f3921c;
            this.f3913a = 1;
            if (Z2.M.a(j4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (c0307d.f3919a.f3891c <= 0) {
            Z2.o0 o0Var = c0307d.f3924f;
            if (o0Var != null) {
                o0Var.b(null);
            }
            c0307d.f3924f = null;
        }
        return Unit.INSTANCE;
    }
}
