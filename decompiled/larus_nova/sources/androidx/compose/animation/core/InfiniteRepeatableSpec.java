package androidx.compose.animation.core;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB!\b\u0017\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u000bJ,\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\b\b\u0001\u0010\u0015*\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00150\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Landroidx/compose/animation/core/InfiniteRepeatableSpec;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationSpec;", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "<init>", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "getAnimation", "()Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "getRepeatMode", "()Landroidx/compose/animation/core/RepeatMode;", "getInitialStartOffset-Rmkjzm4", "()J", "J", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "equals", "", "other", "", "hashCode", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InfiniteRepeatableSpec<T> implements AnimationSpec<T> {
    public static final int $stable = 8;
    private final DurationBasedAnimationSpec<T> animation;
    private final long initialStartOffset;
    private final RepeatMode repeatMode;

    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec r100, RepeatMode r101, long r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public int hashCode() {
        return (((this.animation.hashCode() * 31) + this.repeatMode.hashCode()) * 31) + StartOffset.m179hashCodeimpl(this.initialStartOffset);
    }

    public final DurationBasedAnimationSpec<T> getAnimation() {
        return this.animation;
    }

    /* JADX INFO: renamed from: getInitialStartOffset-Rmkjzm4, reason: not valid java name */
    public final long m156getInitialStartOffsetRmkjzm4() {
        return this.initialStartOffset;
    }

    public final RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof InfiniteRepeatableSpec) == false) goto L12;
        InfiniteRepeatableSpec r101 = (InfiniteRepeatableSpec) r100;
        if (Intrinsics.areEqual(r101.animation, this.animation) == true) goto L7;
        return false;
    L7:
        if (r101.repeatMode == this.repeatMode) goto L9;
        return false;
    L9:
        if (StartOffset.m176equalsimpl0(r101.initialStartOffset, this.initialStartOffset) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public <V extends AnimationVector> VectorizedAnimationSpec<V> vectorize(TwoWayConverter<T, V> r100) {
        return new VectorizedInfiniteRepeatableSpec(this.animation.vectorize(r100), this.repeatMode, this.initialStartOffset, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This constructor has been deprecated")
    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec r110, RepeatMode r111) {
        this(r110, r111, StartOffset.m174constructorimpl$default(0, 0, 2, null), null);
    }

    private InfiniteRepeatableSpec(DurationBasedAnimationSpec<T> r100, RepeatMode r101, long r102) {
        this.animation = r100;
        this.repeatMode = r101;
        this.initialStartOffset = r102;
    }

    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec r100, RepeatMode r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = RepeatMode.Restart;
    L5:
        this(r100, r101);
    }

    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec r100, RepeatMode r101, long r102, int r110, DefaultConstructorMarker r111) {
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
