package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0011\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0082\bJ \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J(\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/animation/core/FloatTweenSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "duration", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "<init>", "(IILandroidx/compose/animation/core/Easing;)V", "getDuration", "()I", "getDelay", "durationNanos", "", "delayNanos", "getValueFromNanos", "", "playTimeNanos", "initialValue", "targetValue", "initialVelocity", "clampPlayTimeNanos", "getDurationNanos", "getVelocityFromNanos", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatTweenSpec implements FloatAnimationSpec {
    public static final int $stable = 0;
    private final int delay;
    private final long delayNanos;
    private final int duration;
    private final long durationNanos;
    private final Easing easing;

    public FloatTweenSpec() {
        this(0, 0, null, 7, null);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final /* synthetic */ float getEndVelocity(float r100, float r101, float r102) {
        return FloatAnimationSpec.CC.$default$getEndVelocity(this, r100, r101, r102);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter r100) {
        return FloatAnimationSpec.CC.$default$vectorize(this, r100);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final /* synthetic */ VectorizedFloatAnimationSpec vectorize(TwoWayConverter r100) {
        return FloatAnimationSpec.CC.m155$default$vectorize(this, r100);
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDuration() {
        return this.duration;
    }

    private final long clampPlayTimeNanos(long r100) {
        long r101 = r100 - this.delayNanos;
        long r102 = this.durationNanos;
        if (r101 >= 0) goto L6;
        r101 = 0;
    L6:
        if (r101 <= r102) goto L9;
        return r102;
    L9:
        return r101;
    }

    public FloatTweenSpec(int r100, int r101, Easing r102) {
        this.duration = r100;
        this.delay = r101;
        this.easing = r102;
        this.durationNanos = ((long) r100) * 1000000;
        this.delayNanos = ((long) r101) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float r100, float r101, float r102) {
        return this.delayNanos + this.durationNanos;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long r100, float r101, float r102, float r103) {
        long r104 = r100 - this.delayNanos;
        long r105 = this.durationNanos;
        if (r104 >= 0) goto L6;
        r104 = 0;
    L6:
        if (r104 <= r105) goto L9;
        r104 = r105;
    L9:
        if (this.duration != 0) goto L11;
        float r106 = 1.0f;
    L12:
        float r107 = this.easing.transform(r106);
        return (r101 * (1 - r107)) + (r102 * r107);
    L11:
        r106 = r104 / r105;
        goto L12
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long r110, float r111, float r112, float r113) {
        long r100 = r110 - this.delayNanos;
        long r101 = this.durationNanos;
        if (r100 >= 0) goto L6;
        r100 = 0;
    L6:
        if (r100 <= r101) goto L8;
        long r102 = r101;
    L10:
        if (r102 != 0) goto L13;
        return r113;
    L13:
        return (getValueFromNanos(r102, r111, r112, r113) - getValueFromNanos(r102 - 1000000, r111, r112, r113)) * 1000.0f;
    L8:
        r102 = r100;
        goto L10
    }

    public /* synthetic */ FloatTweenSpec(int r100, int r101, Easing r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 300;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = EasingKt.getFastOutSlowInEasing();
    L11:
        this(r100, r101, r102);
    }
}
