package S;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* renamed from: S.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0098d extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f1738a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1739b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f1740c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0098d(List list, Continuation continuation) {
        super(2, continuation);
        this.f1740c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0098d c0098d = new C0098d(this.f1740c, continuation);
        c0098d.f1739b = obj;
        return c0098d;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0098d) create((E) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f1738a;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            E e4 = (E) this.f1739b;
            y1.f fVar = AbstractC0102h.f1753a;
            this.f1738a = 1;
            if (y1.f.d(fVar, this.f1740c, e4, this) == coroutine_suspended) {
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
