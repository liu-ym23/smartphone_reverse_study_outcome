package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB!\b\u0017\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J-\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ-\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ-\u0010 \u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ%\u0010!\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/animation/core/VectorizedInfiniteRepeatableSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "<init>", "(Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "isInfinite", "", "()Z", "durationNanos", "", "getDurationNanos$animation_core", "()J", "initialOffsetNanos", "repetitionPlayTimeNanos", "playTimeNanos", "repetitionStartVelocity", "start", "startVelocity", "end", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "initialValue", "targetValue", "initialVelocity", "getVelocityFromNanos", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorizedInfiniteRepeatableSpec<V extends AnimationVector> implements VectorizedAnimationSpec<V> {
    public static final int $stable = 8;
    private final VectorizedDurationBasedAnimationSpec<V> animation;
    private final long durationNanos;
    private final long initialOffsetNanos;
    private final RepeatMode repeatMode;

    public /* synthetic */ VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec r100, RepeatMode r101, long r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(V r100, V r101, V r102) {
        return Long.MAX_VALUE;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ AnimationVector getEndVelocity(AnimationVector r100, AnimationVector r101, AnimationVector r102) {
        return VectorizedAnimationSpec.CC.$default$getEndVelocity(this, r100, r101, r102);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        return true;
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
        long r101 = this.durationNanos;
        long r102 = r111 / r101;
        if (this.repeatMode != RepeatMode.Restart) goto L8;
    L12:
        Long.signum(r102);
        return r111 - (r102 * r101);
    L8:
        if ((r102 % ((long) 2)) == 0) goto L12;
        return ((r102 + 1) * r101) - r111;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the constructor that accepts start offset.")
    public /* synthetic */ VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec r110, RepeatMode r111) {
        this(r110, r111, StartOffset.m174constructorimpl$default(0, 0, 2, null), null);
    }

    private VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec<V> r100, RepeatMode r101, long r102) {
        this.animation = r100;
        this.repeatMode = r101;
        this.durationNanos = ((long) (r100.getDelayMillis() + r100.getDurationMillis())) * 1000000;
        this.initialOffsetNanos = r102 * 1000000;
    }

    public /* synthetic */ VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec r100, RepeatMode r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = RepeatMode.Restart;
    L5:
        this(r100, r101);
    }

    private final V repetitionStartVelocity(long r110, V r111, V r112, V r113) {
        long r100 = this.initialOffsetNanos;
        long r101 = r110 + r100;
        long r102 = this.durationNanos;
        if (r101 <= r102) goto L6;
        return this.animation.getVelocityFromNanos(r102 - r100, r111, r113, r112);
    L6:
        return r112;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long r110, V r111, V r112, V r113) {
        return this.animation.getValueFromNanos(repetitionPlayTimeNanos(r110), r111, r112, repetitionStartVelocity(r110, r111, r113, r112));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long r110, V r111, V r112, V r113) {
        return this.animation.getVelocityFromNanos(repetitionPlayTimeNanos(r110), r111, r112, repetitionStartVelocity(r110, r111, r113, r112));
    }

    public /* synthetic */ VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec r100, RepeatMode r101, long r102, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 2) == 0) goto L5;
        r101 = RepeatMode.Restart;
    L5:
        RepeatMode r103 = r101;
        if ((r110 & 4) == 0) goto L8;
        r102 = StartOffset.m174constructorimpl$default(0, 0, 2, null);
    L8:
        this(r100, r103, r102, null);
    }
}
