package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB)\b\u0016\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\fJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0017J.\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001aJ.\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/compose/animation/core/VectorizedSpringSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "dampingRatio", "", "stiffness", "anims", "Landroidx/compose/animation/core/Animations;", "<init>", "(FFLandroidx/compose/animation/core/Animations;)V", "visibilityThreshold", "(FFLandroidx/compose/animation/core/AnimationVector;)V", "getDampingRatio", "()F", "getStiffness", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "isInfinite", "", "()Z", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorizedSpringSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    private final /* synthetic */ VectorizedFloatAnimationSpec<V> $$delegate_0;
    private final float dampingRatio;
    private final float stiffness;

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(V r100, V r101, V r102) {
        return this.$$delegate_0.getDurationNanos(r100, r101, r102);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getEndVelocity(V r100, V r101, V r102) {
        return (V) this.$$delegate_0.getEndVelocity(r100, r101, r102);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long r100, V r101, V r110, V r111) {
        return (V) this.$$delegate_0.getValueFromNanos(r100, r101, r110, r111);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long r100, V r101, V r110, V r111) {
        return (V) this.$$delegate_0.getVelocityFromNanos(r100, r101, r110, r111);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        VectorizedFloatAnimationSpec<V> r100 = this.$$delegate_0;
        r100.getClass();
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(r100);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    private VectorizedSpringSpec(float r100, float r101, Animations r102) {
        this.$$delegate_0 = new VectorizedFloatAnimationSpec(r102);
        this.dampingRatio = r100;
        this.stiffness = r101;
    }

    public VectorizedSpringSpec(float r100, float r101, V r102) {
        this(r100, r101, VectorizedAnimationSpecKt.access$createSpringAnimations(r102, r100, r101));
    }

    public /* synthetic */ VectorizedSpringSpec(float r100, float r101, AnimationVector r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 1.0f;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 1500.0f;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
