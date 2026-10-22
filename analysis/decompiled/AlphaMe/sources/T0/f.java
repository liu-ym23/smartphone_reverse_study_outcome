package T0;

import Z2.F;
import g3.C0580d;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class f extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public C0580d f1814a;

    /* renamed from: b, reason: collision with root package name */
    public h f1815b;

    /* renamed from: c, reason: collision with root package name */
    public int f1816c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f1817d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, Continuation continuation) {
        super(2, continuation);
        this.f1817d = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new f(this.f1817d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((f) create((F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        h hVar;
        C0580d c0580d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f1816c;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            h hVar2 = this.f1817d;
            C0580d c0580d2 = hVar2.f1827b;
            this.f1814a = c0580d2;
            this.f1815b = hVar2;
            this.f1816c = 1;
            if (c0580d2.d(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            hVar = hVar2;
            c0580d = c0580d2;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = this.f1815b;
            c0580d = this.f1814a;
            ResultKt.throwOnFailure(obj);
        }
        try {
            hVar.f1828c.d();
            Unit unit = Unit.INSTANCE;
            c0580d.e(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            c0580d.e(null);
            throw th;
        }
    }
}
