package androidx.compose.material;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SliderKt$Slider$2$drag$1$1", f = "Slider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SliderKt$Slider$2$drag$1$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
    /* synthetic */ float F$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$Slider$2$drag$1$1(State<? extends Function1<? super Float, Unit>> r100, Continuation<? super SliderKt$Slider$2$drag$1$1> r101) {
        this.$gestureEndAction = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Float r101, Continuation<? super Unit> r102) {
        return invoke(r100, r101.floatValue(), r102);
    }

    public final Object invoke(CoroutineScope r100, float r101, Continuation<? super Unit> r102) {
        SliderKt$Slider$2$drag$1$1 r103 = new SliderKt$Slider$2$drag$1$1(this.$gestureEndAction, r102);
        r103.F$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        float r101 = this.F$0;
        this.$gestureEndAction.getValue().invoke(Boxing.boxFloat(r101));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
