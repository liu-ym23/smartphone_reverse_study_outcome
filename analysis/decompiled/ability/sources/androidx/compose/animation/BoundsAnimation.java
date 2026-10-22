package androidx.compose.animation;

import S7.k;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@ExperimentalSharedTransitionApi
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bRW\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u00042\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\b\u0012\u0004\u0012\u00020\u00050\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R;\u00105\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010/2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010/8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0011\u00106\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0013\u0010:\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0011\u0010<\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b;\u00107¨\u0006="}, d2 = {"Landroidx/compose/animation/BoundsAnimation;", "", "Landroidx/compose/animation/SharedTransitionScope;", "transitionScope", "Landroidx/compose/animation/core/Transition;", "", "transition", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "animation", "Landroidx/compose/animation/BoundsTransform;", "boundsTransform", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/SharedTransitionScope;Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/BoundsTransform;)V", "LC7/r;", "updateAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/BoundsTransform;)V", "currentBounds", "targetBounds", "animate", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)V", "Landroidx/compose/animation/SharedTransitionScope;", "getTransitionScope", "()Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/animation/core/Transition;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "<set-?>", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "boundsTransform$delegate", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "setBoundsTransform", "(Landroidx/compose/animation/BoundsTransform;)V", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "Landroidx/compose/runtime/State;", "animationState$delegate", "getAnimationState", "()Landroidx/compose/runtime/State;", "setAnimationState", "(Landroidx/compose/runtime/State;)V", "animationState", "isRunning", "()Z", "getValue", "()Landroidx/compose/ui/geometry/Rect;", "value", "getTarget", TypedValues.AttributesType.S_TARGET, "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BoundsAnimation {
    public static final int $stable = 8;

    /* renamed from: animation$delegate, reason: from kotlin metadata */
    private final MutableState animation;
    private FiniteAnimationSpec<Rect> animationSpec = BoundsAnimationKt.DefaultBoundsAnimation;

    /* renamed from: animationState$delegate, reason: from kotlin metadata */
    private final MutableState animationState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* renamed from: boundsTransform$delegate, reason: from kotlin metadata */
    private final MutableState boundsTransform;
    private final Transition<Boolean> transition;
    private final SharedTransitionScope transitionScope;

    public BoundsAnimation(SharedTransitionScope sharedTransitionScope, Transition<Boolean> transition, Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> deferredAnimation, BoundsTransform boundsTransform) {
        this.transitionScope = sharedTransitionScope;
        this.transition = transition;
        this.animation = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(deferredAnimation, null, 2, null);
        this.boundsTransform = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundsTransform, null, 2, null);
    }

    private final BoundsTransform getBoundsTransform() {
        return (BoundsTransform) this.boundsTransform.getValue();
    }

    private final void setAnimation(Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> deferredAnimation) {
        this.animation.setValue(deferredAnimation);
    }

    private final void setBoundsTransform(BoundsTransform boundsTransform) {
        this.boundsTransform.setValue(boundsTransform);
    }

    public final void animate(final Rect currentBounds, final Rect targetBounds) {
        if (this.transitionScope.isTransitionActive()) {
            if (getAnimationState() == null) {
                this.animationSpec = getBoundsTransform().transform(currentBounds, targetBounds);
            }
            setAnimationState(getAnimation().animate(new k() { // from class: androidx.compose.animation.BoundsAnimation.animate.1
                {
                    super(1);
                }

                @Override // S7.k
                public final FiniteAnimationSpec<Rect> invoke(Transition.Segment<Boolean> segment) {
                    return BoundsAnimation.this.getAnimationSpec();
                }
            }, new k() { // from class: androidx.compose.animation.BoundsAnimation.animate.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Boolean) obj).booleanValue());
                }

                public final Rect invoke(boolean z10) {
                    return z10 == BoundsAnimation.this.getTransition().getTargetState().booleanValue() ? targetBounds : currentBounds;
                }
            }));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> getAnimation() {
        return (Transition.DeferredAnimation) this.animation.getValue();
    }

    public final FiniteAnimationSpec<Rect> getAnimationSpec() {
        return this.animationSpec;
    }

    public final State<Rect> getAnimationState() {
        return (State) this.animationState.getValue();
    }

    public final boolean getTarget() {
        return this.transition.getTargetState().booleanValue();
    }

    public final Transition<Boolean> getTransition() {
        return this.transition;
    }

    public final SharedTransitionScope getTransitionScope() {
        return this.transitionScope;
    }

    public final Rect getValue() {
        State<Rect> animationState;
        if (!this.transitionScope.isTransitionActive() || (animationState = getAnimationState()) == null) {
            return null;
        }
        return animationState.getValue();
    }

    public final boolean isRunning() {
        Transition parentTransition = this.transition;
        while (parentTransition.getParentTransition() != null) {
            parentTransition = parentTransition.getParentTransition();
            kotlin.jvm.internal.k.c(parentTransition);
        }
        return !kotlin.jvm.internal.k.b(parentTransition.getCurrentState(), parentTransition.getTargetState());
    }

    public final void setAnimationSpec(FiniteAnimationSpec<Rect> finiteAnimationSpec) {
        this.animationSpec = finiteAnimationSpec;
    }

    public final void setAnimationState(State<Rect> state) {
        this.animationState.setValue(state);
    }

    public final void updateAnimation(Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> animation, BoundsTransform boundsTransform) {
        if (!kotlin.jvm.internal.k.b(getAnimation(), animation)) {
            setAnimation(animation);
            setAnimationState(null);
            this.animationSpec = BoundsAnimationKt.DefaultBoundsAnimation;
        }
        setBoundsTransform(boundsTransform);
    }
}
