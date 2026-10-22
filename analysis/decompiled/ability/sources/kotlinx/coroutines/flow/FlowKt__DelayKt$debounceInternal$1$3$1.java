package kotlinx.coroutines.flow;

import C7.r;
import S7.k;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;

@J7.c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", l = {226}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f5200a;
    public final /* synthetic */ p9.d b;
    public final /* synthetic */ Ref$ObjectRef c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$3$1(H7.c cVar, Ref$ObjectRef ref$ObjectRef, p9.d dVar) {
        super(1, cVar);
        this.b = dVar;
        this.c = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(cVar, this.c, this.b);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f5200a;
        Ref$ObjectRef ref$ObjectRef = this.c;
        if (i == 0) {
            kotlin.b.b(obj);
            a5.d dVar = q9.b.b;
            Object obj2 = ref$ObjectRef.f4920a;
            if (obj2 == dVar) {
                obj2 = null;
            }
            this.f5200a = 1;
            if (this.b.emit(obj2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        ref$ObjectRef.f4920a = null;
        return r.f317a;
    }
}
