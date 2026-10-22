package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ-\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J%\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000e\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "anims", "Landroidx/compose/animation/core/Animations;", "<init>", "(Landroidx/compose/animation/core/Animations;)V", "anim", "Landroidx/compose/animation/core/FloatAnimationSpec;", "(Landroidx/compose/animation/core/FloatAnimationSpec;)V", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "endVelocityVector", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorizedFloatAnimationSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    private final Animations anims;
    private V endVelocityVector;
    private V valueVector;
    private V velocityVector;

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    public VectorizedFloatAnimationSpec(final FloatAnimationSpec r100) {
        this(new AnonymousClass1(r100));
    }

    public VectorizedFloatAnimationSpec(Animations r100) {
        this.anims = r100;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(V r100, V r110, V r111) {
        int r101 = r100.getSize$animation_core();
        long r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102 = Math.max(r102, this.anims.get(r103).getDurationNanos(r100.get$animation_core(r103), r110.get$animation_core(r103), r111.get$animation_core(r103)));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getEndVelocity(V r110, V r111, V r112) {
        if (this.endVelocityVector != null) goto L5;
        this.endVelocityVector = (V) AnimationVectorsKt.newInstance(r112);
    L5:
        V r100 = this.endVelocityVector;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        r100 = null;
    L8:
        int r101 = r100.getSize$animation_core();
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L14;
        V r103 = this.endVelocityVector;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        r103 = null;
    L13:
        r103.set$animation_core(r102, this.anims.get(r102).getEndVelocity(r110.get$animation_core(r102), r111.get$animation_core(r102), r112.get$animation_core(r102)));
        r102 = r102 + 1;
        goto L9
    L14:
        V r113 = this.endVelocityVector;
        if (r113 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        return null;
    L18:
        return r113;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long r110, V r111, V r112, V r210) {
        if (this.valueVector != null) goto L5;
        this.valueVector = (V) AnimationVectorsKt.newInstance(r111);
    L5:
        V r100 = this.valueVector;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        r100 = null;
    L8:
        int r101 = r100.getSize$animation_core();
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L14;
        V r103 = this.valueVector;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        r103 = null;
    L13:
        r103.set$animation_core(r102, this.anims.get(r102).getValueFromNanos(r110, r111.get$animation_core(r102), r112.get$animation_core(r102), r210.get$animation_core(r102)));
        r102 = r102 + 1;
        goto L9
    L14:
        V r104 = this.valueVector;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    L18:
        return r104;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long r110, V r111, V r112, V r210) {
        if (this.velocityVector != null) goto L5;
        this.velocityVector = (V) AnimationVectorsKt.newInstance(r210);
    L5:
        V r100 = this.velocityVector;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        r100 = null;
    L8:
        int r101 = r100.getSize$animation_core();
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L14;
        V r103 = this.velocityVector;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        r103 = null;
    L13:
        r103.set$animation_core(r102, this.anims.get(r102).getVelocityFromNanos(r110, r111.get$animation_core(r102), r112.get$animation_core(r102), r210.get$animation_core(r102)));
        r102 = r102 + 1;
        goto L9
    L14:
        V r104 = this.velocityVector;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    L18:
        return r104;
    }
}
