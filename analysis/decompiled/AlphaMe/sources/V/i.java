package V;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class i extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f1924a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1925b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f1926c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f1926c = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        i iVar = new i(this.f1926c, continuation);
        iVar.f1925b = obj;
        return iVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((i) create((h) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f1924a;
        if (i4 != 0) {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b bVar = (b) this.f1925b;
            ResultKt.throwOnFailure(obj);
            return bVar;
        }
        ResultKt.throwOnFailure(obj);
        b bVar2 = new b(MapsKt.toMutableMap(((h) this.f1925b).a()), false);
        this.f1925b = bVar2;
        this.f1924a = 1;
        return this.f1926c.invoke(bVar2, this) == coroutine_suspended ? coroutine_suspended : bVar2;
    }
}
