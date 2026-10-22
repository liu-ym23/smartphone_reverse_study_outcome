package androidx.compose.runtime;

import C7.r;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3$1", f = "ProduceState.kt", l = {141}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class SnapshotStateKt__ProduceStateKt$produceState$3$1 extends SuspendLambda implements n {
    final /* synthetic */ n $producer;
    final /* synthetic */ MutableState<T> $result;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotStateKt__ProduceStateKt$produceState$3$1(n nVar, MutableState<T> mutableState, H7.c<? super SnapshotStateKt__ProduceStateKt$produceState$3$1> cVar) {
        super(2, cVar);
        this.$producer = nVar;
        this.$result = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        SnapshotStateKt__ProduceStateKt$produceState$3$1 snapshotStateKt__ProduceStateKt$produceState$3$1 = new SnapshotStateKt__ProduceStateKt$produceState$3$1(this.$producer, this.$result, cVar);
        snapshotStateKt__ProduceStateKt$produceState$3$1.L$0 = obj;
        return snapshotStateKt__ProduceStateKt$produceState$3$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
            n nVar = this.$producer;
            ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, interfaceC1733z.getCoroutineContext());
            this.label = 1;
            if (nVar.invoke(produceStateScopeImpl, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((SnapshotStateKt__ProduceStateKt$produceState$3$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
