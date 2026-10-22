package androidx.compose.foundation.gestures.snapping;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$FloatRef;
import m9.InterfaceC1733z;

@c(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1", f = "SnapFlingBehavior.kt", l = {142, 161}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "<anonymous>", "(Lm9/z;)Landroidx/compose/foundation/gestures/snapping/AnimationResult;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class SnapFlingBehavior$fling$result$1 extends SuspendLambda implements n {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ k $onRemainingScrollOffsetUpdate;
    final /* synthetic */ ScrollScope $this_fling;
    Object L$0;
    int label;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapFlingBehavior$fling$result$1(SnapFlingBehavior snapFlingBehavior, float f, k kVar, ScrollScope scrollScope, H7.c<? super SnapFlingBehavior$fling$result$1> cVar) {
        super(2, cVar);
        this.this$0 = snapFlingBehavior;
        this.$initialVelocity = f;
        this.$onRemainingScrollOffsetUpdate = kVar;
        this.$this_fling = scrollScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new SnapFlingBehavior$fling$result$1(this.this$0, this.$initialVelocity, this.$onRemainingScrollOffsetUpdate, this.$this_fling, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final Ref$FloatRef ref$FloatRef;
        Object objTryApproach;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            float fCalculateApproachOffset = this.this$0.snapLayoutInfoProvider.calculateApproachOffset(this.$initialVelocity, DecayAnimationSpecKt.calculateTargetValue(this.this$0.decayAnimationSpec, 0.0f, this.$initialVelocity));
            if (Float.isNaN(fCalculateApproachOffset)) {
                throw new IllegalStateException("calculateApproachOffset returned NaN. Please use a valid value.");
            }
            ref$FloatRef = new Ref$FloatRef();
            float fSignum = Math.signum(this.$initialVelocity) * Math.abs(fCalculateApproachOffset);
            ref$FloatRef.f4917a = fSignum;
            this.$onRemainingScrollOffsetUpdate.invoke(new Float(fSignum));
            SnapFlingBehavior snapFlingBehavior = this.this$0;
            ScrollScope scrollScope = this.$this_fling;
            float f = ref$FloatRef.f4917a;
            float f7 = this.$initialVelocity;
            final k kVar = this.$onRemainingScrollOffsetUpdate;
            k kVar2 = new k() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$animationState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Number) obj2).floatValue());
                    return r.f317a;
                }

                public final void invoke(float f9) {
                    Ref$FloatRef ref$FloatRef2 = ref$FloatRef;
                    float f10 = ref$FloatRef2.f4917a - f9;
                    ref$FloatRef2.f4917a = f10;
                    kVar.invoke(Float.valueOf(f10));
                }
            };
            this.L$0 = ref$FloatRef;
            this.label = 1;
            objTryApproach = snapFlingBehavior.tryApproach(scrollScope, f, f7, kVar2, this);
            if (objTryApproach != coroutineSingletons) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
        Ref$FloatRef ref$FloatRef2 = (Ref$FloatRef) this.L$0;
        b.b(obj);
        ref$FloatRef = ref$FloatRef2;
        objTryApproach = obj;
        AnimationState animationState = (AnimationState) objTryApproach;
        float fCalculateSnapOffset = this.this$0.snapLayoutInfoProvider.calculateSnapOffset(((Number) animationState.getVelocity()).floatValue());
        if (Float.isNaN(fCalculateSnapOffset)) {
            throw new IllegalStateException("calculateSnapOffset returned NaN. Please use a valid value.");
        }
        ref$FloatRef.f4917a = fCalculateSnapOffset;
        ScrollScope scrollScope2 = this.$this_fling;
        AnimationState animationStateCopy$default = AnimationStateKt.copy$default(animationState, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
        AnimationSpec animationSpec = this.this$0.snapAnimationSpec;
        final k kVar3 = this.$onRemainingScrollOffsetUpdate;
        k kVar4 = new k() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke(((Number) obj2).floatValue());
                return r.f317a;
            }

            public final void invoke(float f9) {
                Ref$FloatRef ref$FloatRef3 = ref$FloatRef;
                float f10 = ref$FloatRef3.f4917a - f9;
                ref$FloatRef3.f4917a = f10;
                kVar3.invoke(Float.valueOf(f10));
            }
        };
        this.L$0 = null;
        this.label = 2;
        Object objAnimateWithTarget = SnapFlingBehaviorKt.animateWithTarget(scrollScope2, fCalculateSnapOffset, fCalculateSnapOffset, animationStateCopy$default, animationSpec, kVar4, this);
        return objAnimateWithTarget == coroutineSingletons ? coroutineSingletons : objAnimateWithTarget;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super AnimationResult<Float, AnimationVector1D>> cVar) {
        return ((SnapFlingBehavior$fling$result$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
