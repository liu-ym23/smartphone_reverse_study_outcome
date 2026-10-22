package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.material3.TabIndicatorOffsetNode$measure$2", f = "TabRow.kt", l = {TypedValues.Custom.TYPE_INT}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class TabIndicatorOffsetNode$measure$2 extends SuspendLambda implements n {
    final /* synthetic */ float $currentTabWidth;
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $widthAnim;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabIndicatorOffsetNode$measure$2(Animatable<Dp, AnimationVector1D> animatable, float f, H7.c<? super TabIndicatorOffsetNode$measure$2> cVar) {
        super(2, cVar);
        this.$widthAnim = animatable;
        this.$currentTabWidth = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new TabIndicatorOffsetNode$measure$2(this.$widthAnim, this.$currentTabWidth, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            Animatable<Dp, AnimationVector1D> animatable = this.$widthAnim;
            Dp dpM6842boximpl = Dp.m6842boximpl(this.$currentTabWidth);
            AnimationSpec animationSpec = TabRowKt.TabRowIndicatorSpec;
            this.label = 1;
            if (Animatable.animateTo$default(animatable, dpM6842boximpl, animationSpec, null, null, this, 12, null) == coroutineSingletons) {
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
        return ((TabIndicatorOffsetNode$measure$2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
