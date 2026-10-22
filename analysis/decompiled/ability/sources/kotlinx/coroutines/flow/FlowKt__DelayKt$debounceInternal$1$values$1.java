package kotlinx.coroutines.flow;

import C7.r;
import S7.n;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import o9.InterfaceC1786l;

@J7.c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", l = {ComposerKt.providerMapsKey}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lo9/l;", "", "LC7/r;", "<anonymous>", "(Lo9/l;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class FlowKt__DelayKt$debounceInternal$1$values$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f5202a;
    public /* synthetic */ Object b;
    public final /* synthetic */ p9.c c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$values$1(p9.c cVar, H7.c cVar2) {
        super(2, cVar2);
        this.c = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        FlowKt__DelayKt$debounceInternal$1$values$1 flowKt__DelayKt$debounceInternal$1$values$1 = new FlowKt__DelayKt$debounceInternal$1$values$1(this.c, cVar);
        flowKt__DelayKt$debounceInternal$1$values$1.b = obj;
        return flowKt__DelayKt$debounceInternal$1$values$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((FlowKt__DelayKt$debounceInternal$1$values$1) create((InterfaceC1786l) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f5202a;
        if (i == 0) {
            kotlin.b.b(obj);
            e eVar = new e((InterfaceC1786l) this.b);
            this.f5202a = 1;
            if (this.c.collect(eVar, this) == coroutineSingletons) {
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
