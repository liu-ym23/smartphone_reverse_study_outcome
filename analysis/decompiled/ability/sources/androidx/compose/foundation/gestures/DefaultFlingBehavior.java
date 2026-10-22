package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.MotionDurationScale;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000b\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0096@¢\u0006\u0004\b\u000b\u0010\fR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "flingDecay", "Landroidx/compose/ui/MotionDurationScale;", "motionDurationScale", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/ui/MotionDurationScale;)V", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "performFling", "(Landroidx/compose/foundation/gestures/ScrollScope;FLH7/c;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "getFlingDecay", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "setFlingDecay", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "Landroidx/compose/ui/MotionDurationScale;", "", "lastAnimationCycleCount", "I", "getLastAnimationCycleCount", "()I", "setLastAnimationCycleCount", "(I)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;
    private DecayAnimationSpec<Float> flingDecay;
    private int lastAnimationCycleCount;
    private final MotionDurationScale motionDurationScale;

    @c(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", l = {893}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)F"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ float $initialVelocity;
        final /* synthetic */ ScrollScope $this_performFling;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DefaultFlingBehavior this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$initialVelocity = f;
            this.this$0 = defaultFlingBehavior;
            this.$this_performFling = scrollScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$initialVelocity, this.this$0, this.$this_performFling, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            float f;
            AnimationState animationState;
            Ref$FloatRef ref$FloatRef;
            DecayAnimationSpec<Float> flingDecay;
            k kVar;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                if (Math.abs(this.$initialVelocity) > 1.0f) {
                    final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                    ref$FloatRef2.f4917a = this.$initialVelocity;
                    final Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
                    AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(0.0f, this.$initialVelocity, 0L, 0L, false, 28, null);
                    try {
                        flingDecay = this.this$0.getFlingDecay();
                        final ScrollScope scrollScope = this.$this_performFling;
                        final DefaultFlingBehavior defaultFlingBehavior = this.this$0;
                        kVar = new k() { // from class: androidx.compose.foundation.gestures.DefaultFlingBehavior.performFling.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                                return r.f317a;
                            }

                            public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                float fFloatValue = animationScope.getValue().floatValue() - ref$FloatRef3.f4917a;
                                float fScrollBy = scrollScope.scrollBy(fFloatValue);
                                ref$FloatRef3.f4917a = animationScope.getValue().floatValue();
                                ref$FloatRef2.f4917a = animationScope.getVelocity().floatValue();
                                if (Math.abs(fFloatValue - fScrollBy) > 0.5f) {
                                    animationScope.cancelAnimation();
                                }
                                DefaultFlingBehavior defaultFlingBehavior2 = defaultFlingBehavior;
                                defaultFlingBehavior2.setLastAnimationCycleCount(defaultFlingBehavior2.getLastAnimationCycleCount() + 1);
                            }
                        };
                        this.L$0 = ref$FloatRef2;
                        this.L$1 = animationStateAnimationState$default;
                        this.label = 1;
                        animationState = animationStateAnimationState$default;
                        try {
                        } catch (CancellationException unused) {
                            ref$FloatRef = ref$FloatRef2;
                            ref$FloatRef.f4917a = ((Number) animationState.getVelocity()).floatValue();
                            f = ref$FloatRef.f4917a;
                            return new Float(f);
                        }
                    } catch (CancellationException unused2) {
                        animationState = animationStateAnimationState$default;
                    }
                    if (SuspendAnimationKt.animateDecay$default(animationState, flingDecay, false, kVar, this, 2, null) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    ref$FloatRef = ref$FloatRef2;
                    f = ref$FloatRef.f4917a;
                } else {
                    f = this.$initialVelocity;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                animationState = (AnimationState) this.L$1;
                ref$FloatRef = (Ref$FloatRef) this.L$0;
                try {
                    b.b(obj);
                } catch (CancellationException unused3) {
                    ref$FloatRef.f4917a = ((Number) animationState.getVelocity()).floatValue();
                    f = ref$FloatRef.f4917a;
                    return new Float(f);
                }
                f = ref$FloatRef.f4917a;
            }
            return new Float(f);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Float> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public DefaultFlingBehavior(DecayAnimationSpec<Float> decayAnimationSpec, MotionDurationScale motionDurationScale) {
        this.flingDecay = decayAnimationSpec;
        this.motionDurationScale = motionDurationScale;
    }

    public final DecayAnimationSpec<Float> getFlingDecay() {
        return this.flingDecay;
    }

    public final int getLastAnimationCycleCount() {
        return this.lastAnimationCycleCount;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object performFling(ScrollScope scrollScope, float f, H7.c<? super Float> cVar) {
        this.lastAnimationCycleCount = 0;
        return AbstractC1683A.w(this.motionDurationScale, new AnonymousClass2(f, this, scrollScope, null), cVar);
    }

    public final void setFlingDecay(DecayAnimationSpec<Float> decayAnimationSpec) {
        this.flingDecay = decayAnimationSpec;
    }

    public final void setLastAnimationCycleCount(int i) {
        this.lastAnimationCycleCount = i;
    }

    public /* synthetic */ DefaultFlingBehavior(DecayAnimationSpec decayAnimationSpec, MotionDurationScale motionDurationScale, int i, e eVar) {
        this(decayAnimationSpec, (i & 2) != 0 ? ScrollableKt.getDefaultScrollMotionDurationScale() : motionDurationScale);
    }
}
