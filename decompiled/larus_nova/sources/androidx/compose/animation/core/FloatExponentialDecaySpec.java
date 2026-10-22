package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/core/FloatExponentialDecaySpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "frictionMultiplier", "", "absVelocityThreshold", "<init>", "(FF)V", "getAbsVelocityThreshold", "()F", "friction", "getValueFromNanos", "playTimeNanos", "", "initialValue", "initialVelocity", "getVelocityFromNanos", "getDurationNanos", "getTargetValue", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatExponentialDecaySpec implements FloatDecayAnimationSpec {
    public static final int $stable = 0;
    private final float absVelocityThreshold;
    private final float friction;

    public FloatExponentialDecaySpec() {
        float r100 = 0.0f;
        this(r100, r100, 3, null);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public FloatExponentialDecaySpec(float r100, float r101) {
        this.absVelocityThreshold = Math.max(1.0E-7f, Math.abs(r101));
        this.friction = Math.max(1.0E-4f, r100) * (-4.2f);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float r100, float r101) {
        return ((long) ((((float) Math.log(getAbsVelocityThreshold() / Math.abs(r101))) * 1000.0f) / this.friction)) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float r100, float r101) {
        if (Math.abs(r101) > getAbsVelocityThreshold()) goto L5;
        return r100;
    L5:
        double r102 = Math.log(Math.abs(getAbsVelocityThreshold() / r101));
        float r103 = this.friction;
        return (r100 - (r101 / r103)) + ((r101 / r103) * ((float) Math.exp((((double) r103) * ((r102 / ((double) r103)) * ((double) 1000))) / ((double) 1000.0f))));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(long r100, float r101, float r102) {
        float r103 = this.friction;
        return (r101 - (r102 / r103)) + ((r102 / r103) * ((float) Math.exp((r103 * (r100 / 1000000)) / 1000.0f)));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(long r100, float r101, float r102) {
        return r102 * ((float) Math.exp(((r100 / 1000000) / 1000.0f) * this.friction));
    }

    public /* synthetic */ FloatExponentialDecaySpec(float r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 1.0f;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0.1f;
    L8:
        this(r100, r101);
    }
}
