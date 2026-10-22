package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J%\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001d\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/animation/core/VectorizedFloatDecaySpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "floatDecaySpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "<init>", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)V", "getFloatDecaySpec", "()Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "targetVector", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "getValueFromNanos", "playTimeNanos", "", "initialValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getVelocityFromNanos", "getTargetValue", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class VectorizedFloatDecaySpec<V extends AnimationVector> implements VectorizedDecayAnimationSpec<V> {
    private final float absVelocityThreshold;
    private final FloatDecayAnimationSpec floatDecaySpec;
    private V targetVector;
    private V valueVector;
    private V velocityVector;

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public final FloatDecayAnimationSpec getFloatDecaySpec() {
        return this.floatDecaySpec;
    }

    public VectorizedFloatDecaySpec(FloatDecayAnimationSpec r100) {
        this.floatDecaySpec = r100;
        this.absVelocityThreshold = r100.getAbsVelocityThreshold();
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public long getDurationNanos(V r100, V r101) {
        if (this.velocityVector != null) goto L5;
        this.velocityVector = (V) AnimationVectorsKt.newInstance(r100);
    L5:
        V r102 = this.velocityVector;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        r102 = null;
    L8:
        int r103 = r102.getSize$animation_core();
        long r104 = 0;
        int r105 = 0;
    L9:
        if (r105 >= r103) goto L11;
        r104 = Math.max(r104, this.floatDecaySpec.getDurationNanos(r100.get$animation_core(r105), r101.get$animation_core(r105)));
        r105 = r105 + 1;
        goto L9
    L11:
        return r104;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public V getTargetValue(V r100, V r110) {
        if (this.targetVector != null) goto L5;
        this.targetVector = (V) AnimationVectorsKt.newInstance(r100);
    L5:
        V r101 = this.targetVector;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("targetVector");
        r101 = null;
    L8:
        int r102 = r101.getSize$animation_core();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        V r104 = this.targetVector;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("targetVector");
        r104 = null;
    L13:
        r104.set$animation_core(r103, this.floatDecaySpec.getTargetValue(r100.get$animation_core(r103), r110.get$animation_core(r103)));
        r103 = r103 + 1;
        goto L9
    L14:
        V r105 = this.targetVector;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("targetVector");
        return null;
    L18:
        return r105;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public V getValueFromNanos(long r100, V r110, V r111) {
        if (this.valueVector != null) goto L5;
        this.valueVector = (V) AnimationVectorsKt.newInstance(r110);
    L5:
        V r101 = this.valueVector;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        r101 = null;
    L8:
        int r102 = r101.getSize$animation_core();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        V r104 = this.valueVector;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        r104 = null;
    L13:
        r104.set$animation_core(r103, this.floatDecaySpec.getValueFromNanos(r100, r110.get$animation_core(r103), r111.get$animation_core(r103)));
        r103 = r103 + 1;
        goto L9
    L14:
        V r105 = this.valueVector;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    L18:
        return r105;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public V getVelocityFromNanos(long r100, V r110, V r111) {
        if (this.velocityVector != null) goto L5;
        this.velocityVector = (V) AnimationVectorsKt.newInstance(r110);
    L5:
        V r101 = this.velocityVector;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        r101 = null;
    L8:
        int r102 = r101.getSize$animation_core();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        V r104 = this.velocityVector;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        r104 = null;
    L13:
        r104.set$animation_core(r103, this.floatDecaySpec.getVelocityFromNanos(r100, r110.get$animation_core(r103), r111.get$animation_core(r103)));
        r103 = r103 + 1;
        goto L9
    L14:
        V r105 = this.velocityVector;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    L18:
        return r105;
    }
}
