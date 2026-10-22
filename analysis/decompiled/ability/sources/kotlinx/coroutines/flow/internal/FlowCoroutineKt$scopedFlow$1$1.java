package kotlinx.coroutines.flow.internal;

import C7.r;
import S7.n;
import S7.o;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", l = {47}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f5240a;
    public /* synthetic */ Object b;
    public final /* synthetic */ o c;
    public final /* synthetic */ p9.d d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowCoroutineKt$scopedFlow$1$1(o oVar, p9.d dVar, H7.c cVar) {
        super(2, cVar);
        this.c = oVar;
        this.d = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.c, this.d, cVar);
        flowCoroutineKt$scopedFlow$1$1.b = obj;
        return flowCoroutineKt$scopedFlow$1$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((FlowCoroutineKt$scopedFlow$1$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f5240a;
        if (i == 0) {
            kotlin.b.b(obj);
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.b;
            this.f5240a = 1;
            if (this.c.invoke(interfaceC1733z, this.d, this) == coroutineSingletons) {
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
}
