package androidx.compose.material3;

import C7.r;
import S7.o;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.material3.SliderKt$SliderImpl$drag$1$1", f = "Slider.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "", "it", "LC7/r;", "<anonymous>", "(Lm9/z;F)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class SliderKt$SliderImpl$drag$1$1 extends SuspendLambda implements o {
    final /* synthetic */ SliderState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderImpl$drag$1$1(SliderState sliderState, H7.c<? super SliderKt$SliderImpl$drag$1$1> cVar) {
        super(3, cVar);
        this.$state = sliderState;
    }

    @Override // S7.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((InterfaceC1733z) obj, ((Number) obj2).floatValue(), (H7.c<? super r>) obj3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.b.b(obj);
        this.$state.getGestureEndAction().invoke();
        return r.f317a;
    }

    public final Object invoke(InterfaceC1733z interfaceC1733z, float f, H7.c<? super r> cVar) {
        return new SliderKt$SliderImpl$drag$1$1(this.$state, cVar).invokeSuspend(r.f317a);
    }
}
