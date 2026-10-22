package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/core/StartDelayVectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "vectorizedAnimationSpec", "startDelayNanos", "", "<init>", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;J)V", "getVectorizedAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "getStartDelayNanos", "()J", "isInfinite", "", "()Z", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getVelocityFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "hashCode", "", "equals", "other", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StartDelayVectorizedAnimationSpec<V extends AnimationVector> implements VectorizedAnimationSpec<V> {
    private final long startDelayNanos;
    private final VectorizedAnimationSpec<V> vectorizedAnimationSpec;

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ AnimationVector getEndVelocity(AnimationVector r100, AnimationVector r101, AnimationVector r102) {
        return VectorizedAnimationSpec.CC.$default$getEndVelocity(this, r100, r101, r102);
    }

    public int hashCode() {
        int r100 = this.vectorizedAnimationSpec.hashCode() * 31;
        long r101 = this.startDelayNanos;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        return this.vectorizedAnimationSpec.isInfinite();
    }

    public final long getStartDelayNanos() {
        return this.startDelayNanos;
    }

    public final VectorizedAnimationSpec<V> getVectorizedAnimationSpec() {
        return this.vectorizedAnimationSpec;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof StartDelayVectorizedAnimationSpec) == true) goto L5;
        return false;
    L5:
        StartDelayVectorizedAnimationSpec r101 = (StartDelayVectorizedAnimationSpec) r100;
        if (r101.startDelayNanos == this.startDelayNanos) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r101.vectorizedAnimationSpec, this.vectorizedAnimationSpec) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public StartDelayVectorizedAnimationSpec(VectorizedAnimationSpec<V> r100, long r101) {
        this.vectorizedAnimationSpec = r100;
        this.startDelayNanos = r101;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(V r100, V r101, V r102) {
        return this.vectorizedAnimationSpec.getDurationNanos(r100, r101, r102) + this.startDelayNanos;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long r110, V r111, V r112, V r113) {
        long r100 = this.startDelayNanos;
        if (r110 >= r100) goto L6;
        return r111;
    L6:
        return (V) this.vectorizedAnimationSpec.getValueFromNanos(r110 - r100, r111, r112, r113);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long r110, V r111, V r112, V r113) {
        long r100 = this.startDelayNanos;
        if (r110 >= r100) goto L6;
        return r113;
    L6:
        return (V) this.vectorizedAnimationSpec.getVelocityFromNanos(r110 - r100, r111, r112, r113);
    }
}
