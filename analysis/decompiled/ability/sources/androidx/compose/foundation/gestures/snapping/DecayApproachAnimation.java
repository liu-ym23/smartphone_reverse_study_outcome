package androidx.compose.foundation.gestures.snapping;

import H7.c;
import S7.k;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/DecayApproachAnimation;", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "decayAnimationSpec", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "Landroidx/compose/foundation/gestures/ScrollScope;", "scope", TypedValues.CycleType.S_WAVE_OFFSET, "velocity", "Lkotlin/Function1;", "LC7/r;", "onAnimationStep", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "approachAnimation", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLS7/k;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DecayApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {
    private final DecayAnimationSpec<Float> decayAnimationSpec;

    public DecayApproachAnimation(DecayAnimationSpec<Float> decayAnimationSpec) {
        this.decayAnimationSpec = decayAnimationSpec;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Float f, Float f7, k kVar, c cVar) {
        return approachAnimation(scrollScope, f.floatValue(), f7.floatValue(), kVar, (c<? super AnimationResult<Float, AnimationVector1D>>) cVar);
    }

    public Object approachAnimation(ScrollScope scrollScope, float f, float f7, k kVar, c<? super AnimationResult<Float, AnimationVector1D>> cVar) {
        Object objAnimateDecay = SnapFlingBehaviorKt.animateDecay(scrollScope, f, AnimationStateKt.AnimationState$default(0.0f, f7, 0L, 0L, false, 28, null), this.decayAnimationSpec, kVar, cVar);
        return objAnimateDecay == CoroutineSingletons.f4909a ? objAnimateDecay : (AnimationResult) objAnimateDecay;
    }
}
