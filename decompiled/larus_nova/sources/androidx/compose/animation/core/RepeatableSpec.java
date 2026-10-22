package androidx.compose.animation.core;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB)\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\rJ,\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\b\b\u0001\u0010\u0019*\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00190\u001cH\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Landroidx/compose/animation/core/RepeatableSpec;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/FiniteAnimationSpec;", "iterations", "", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "<init>", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "getIterations", "()I", "getAnimation", "()Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "getRepeatMode", "()Landroidx/compose/animation/core/RepeatMode;", "getInitialStartOffset-Rmkjzm4", "()J", "J", "vectorize", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "equals", "", "other", "", "hashCode", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RepeatableSpec<T> implements FiniteAnimationSpec<T> {
    public static final int $stable = 0;
    private final DurationBasedAnimationSpec<T> animation;
    private final long initialStartOffset;
    private final int iterations;
    private final RepeatMode repeatMode;

    public /* synthetic */ RepeatableSpec(int r100, DurationBasedAnimationSpec r101, RepeatMode r102, long r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public int hashCode() {
        return (((((this.iterations * 31) + this.animation.hashCode()) * 31) + this.repeatMode.hashCode()) * 31) + StartOffset.m179hashCodeimpl(this.initialStartOffset);
    }

    public final DurationBasedAnimationSpec<T> getAnimation() {
        return this.animation;
    }

    /* JADX INFO: renamed from: getInitialStartOffset-Rmkjzm4, reason: not valid java name */
    public final long m169getInitialStartOffsetRmkjzm4() {
        return this.initialStartOffset;
    }

    public final int getIterations() {
        return this.iterations;
    }

    public final RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof RepeatableSpec) == false) goto L14;
        RepeatableSpec r101 = (RepeatableSpec) r100;
        if (r101.iterations == this.iterations) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r101.animation, this.animation) == true) goto L9;
        return false;
    L9:
        if (r101.repeatMode == this.repeatMode) goto L11;
        return false;
    L11:
        if (StartOffset.m176equalsimpl0(r101.initialStartOffset, this.initialStartOffset) == false) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public <V extends AnimationVector> VectorizedFiniteAnimationSpec<V> vectorize(TwoWayConverter<T, V> r100) {
        return new VectorizedRepeatableSpec(this.iterations, this.animation.vectorize(r100), this.repeatMode, this.initialStartOffset, null);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter r100) {
        return vectorize(r100);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This constructor has been deprecated")
    public /* synthetic */ RepeatableSpec(int r110, DurationBasedAnimationSpec r111, RepeatMode r112) {
        this(r110, r111, r112, StartOffset.m174constructorimpl$default(0, 0, 2, null), null);
    }

    private RepeatableSpec(int r100, DurationBasedAnimationSpec<T> r101, RepeatMode r102, long r103) {
        this.iterations = r100;
        this.animation = r101;
        this.repeatMode = r102;
        this.initialStartOffset = r103;
    }

    public /* synthetic */ RepeatableSpec(int r100, DurationBasedAnimationSpec r101, RepeatMode r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = RepeatMode.Restart;
    L5:
        this(r100, r101, r102);
    }

    public /* synthetic */ RepeatableSpec(int r100, DurationBasedAnimationSpec r101, RepeatMode r110, long r111, int r112, DefaultConstructorMarker r113) {
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
