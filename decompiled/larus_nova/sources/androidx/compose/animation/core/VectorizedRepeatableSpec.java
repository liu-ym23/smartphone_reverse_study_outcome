package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB)\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000eJ\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J-\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ%\u0010 \u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/animation/core/VectorizedRepeatableSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "iterations", "", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "<init>", "(ILandroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ILandroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "durationNanos", "", "getDurationNanos$animation_core", "()J", "initialOffsetNanos", "repetitionPlayTimeNanos", "playTimeNanos", "repetitionStartVelocity", "start", "startVelocity", "end", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "initialValue", "targetValue", "initialVelocity", "getVelocityFromNanos", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorizedRepeatableSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    private final VectorizedDurationBasedAnimationSpec<V> animation;
    private final long durationNanos;
    private final long initialOffsetNanos;
    private final int iterations;
    private final RepeatMode repeatMode;

    public /* synthetic */ VectorizedRepeatableSpec(int r100, VectorizedDurationBasedAnimationSpec r101, RepeatMode r102, long r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ AnimationVector getEndVelocity(AnimationVector r100, AnimationVector r101, AnimationVector r102) {
        return VectorizedAnimationSpec.CC.$default$getEndVelocity(this, r100, r101, r102);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    public final long getDurationNanos$animation_core() {
        return this.durationNanos;
    }

    private final long repetitionPlayTimeNanos(long r110) {
        long r100 = this.initialOffsetNanos;
        if ((r110 + r100) > 0) goto L5;
        return 0;
    L5:
        long r111 = r110 + r100;
        long r101 = Math.min(r111 / this.durationNanos, ((long) this.iterations) - 1);
        if (this.repeatMode == RepeatMode.Restart) goto L12;
        if ((r101 % ((long) 2)) == 0) goto L12;
        return ((r101 + 1) * this.durationNanos) - r111;
    L12:
        return r111 - (r101 * this.durationNanos);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the constructor that accepts start offset.")
    public /* synthetic */ VectorizedRepeatableSpec(int r110, VectorizedDurationBasedAnimationSpec r111, RepeatMode r112) {
        this(r110, r111, r112, StartOffset.m174constructorimpl$default(0, 0, 2, null), null);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(V r100, V r101, V r102) {
        return (((long) this.iterations) * this.durationNanos) - this.initialOffsetNanos;
    }

    private VectorizedRepeatableSpec(int r100, VectorizedDurationBasedAnimationSpec<V> r101, RepeatMode r102, long r103) {
        this.iterations = r100;
        this.animation = r101;
        this.repeatMode = r102;
        if (r100 < 1) goto L7;
        this.durationNanos = ((long) (r101.getDelayMillis() + r101.getDurationMillis())) * 1000000;
        this.initialOffsetNanos = r103 * 1000000;
        return;
    L7:
        throw new IllegalArgumentException("Iterations count can't be less than 1");
    }

    private final V repetitionStartVelocity(long r100, V r110, V r111, V r112) {
        long r101 = this.initialOffsetNanos;
        long r102 = r100 + r101;
        long r103 = this.durationNanos;
        if (r102 <= r103) goto L6;
        return (V) getVelocityFromNanos(r103 - r101, r110, r111, r112);
    L6:
        return r111;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long r110, V r111, V r112, V r113) {
        return this.animation.getValueFromNanos(repetitionPlayTimeNanos(r110), r111, r112, repetitionStartVelocity(r110, r111, r113, r112));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long r110, V r111, V r112, V r113) {
        return this.animation.getVelocityFromNanos(repetitionPlayTimeNanos(r110), r111, r112, repetitionStartVelocity(r110, r111, r113, r112));
    }

    public /* synthetic */ VectorizedRepeatableSpec(int r100, VectorizedDurationBasedAnimationSpec r101, RepeatMode r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = RepeatMode.Restart;
    L5:
        this(r100, r101, r102);
    }

    public /* synthetic */ VectorizedRepeatableSpec(int r100, VectorizedDurationBasedAnimationSpec r101, RepeatMode r110, long r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        r110 = RepeatMode.Restart;
    L5:
        RepeatMode r102 = r110;
        if ((r112 & 8) == 0) goto L8;
        r111 = StartOffset.m174constructorimpl$default(0, 0, 2, null);
    L8:
        this(r100, r101, r102, r111, null);
    }
}
