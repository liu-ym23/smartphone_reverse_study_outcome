package androidx.compose.animation;

import androidx.compose.ui.unit.Density;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/animation/FlingCalculator;", "", "friction", "", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(FLandroidx/compose/ui/unit/Density;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "magicPhysicalCoefficient", "computeDeceleration", "getSplineDeceleration", "", "velocity", "flingDuration", "", "flingDistance", "flingInfo", "Landroidx/compose/animation/FlingCalculator$FlingInfo;", "FlingInfo", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlingCalculator {
    public static final int $stable = 0;
    private final Density density;
    private final float friction;
    private final float magicPhysicalCoefficient;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Landroidx/compose/animation/FlingCalculator$FlingInfo;", "", "initialVelocity", "", "distance", "duration", "", "<init>", "(FFJ)V", "getInitialVelocity", "()F", "getDistance", "getDuration", "()J", "position", "time", "velocity", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FlingInfo {
        public static final int $stable = 0;
        private final float distance;
        private final long duration;
        private final float initialVelocity;

        public static /* synthetic */ FlingInfo copy$default(FlingInfo r100, float r101, float r102, long r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.initialVelocity;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.distance;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.duration;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final float component1() {
            return this.initialVelocity;
        }

        public final float component2() {
            return this.distance;
        }

        public final long component3() {
            return this.duration;
        }

        public final FlingInfo copy(float r100, float r101, long r102) {
            return new FlingInfo(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof FlingInfo) == true) goto L8;
            return false;
        L8:
            FlingInfo r101 = (FlingInfo) r100;
            if (Float.compare(this.initialVelocity, r101.initialVelocity) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.distance, r101.distance) == 0) goto L15;
            return false;
        L15:
            if (this.duration == r101.duration) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = ((Float.floatToIntBits(this.initialVelocity) * 31) + Float.floatToIntBits(this.distance)) * 31;
            long r101 = this.duration;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public String toString() {
            return "FlingInfo(initialVelocity=" + this.initialVelocity + ", distance=" + this.distance + ", duration=" + this.duration + ')';
        }

        public final float getDistance() {
            return this.distance;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final float getInitialVelocity() {
            return this.initialVelocity;
        }

        public final float position(long r100) {
            long r101 = this.duration;
            if (r101 <= 0) goto L5;
            float r102 = r100 / r101;
        L7:
            return (this.distance * Math.signum(this.initialVelocity)) * AndroidFlingSpline.INSTANCE.flingPosition(r102).getDistanceCoefficient();
        L5:
            r102 = 1.0f;
            goto L7
        }

        public final float velocity(long r100) {
            long r101 = this.duration;
            if (r101 <= 0) goto L5;
            float r102 = r100 / r101;
        L7:
            return (((AndroidFlingSpline.INSTANCE.flingPosition(r102).getVelocityCoefficient() * Math.signum(this.initialVelocity)) * this.distance) / this.duration) * 1000.0f;
        L5:
            r102 = 1.0f;
            goto L7
        }

        public FlingInfo(float r100, float r101, long r102) {
            this.initialVelocity = r100;
            this.distance = r101;
            this.duration = r102;
        }
    }

    public final Density getDensity() {
        return this.density;
    }

    private final float computeDeceleration(Density r100) {
        return FlingCalculatorKt.access$computeDeceleration(0.84f, r100.getDensity());
    }

    private final double getSplineDeceleration(float r100) {
        return AndroidFlingSpline.INSTANCE.deceleration(r100, this.friction * this.magicPhysicalCoefficient);
    }

    public final float flingDistance(float r100) {
        double r101 = getSplineDeceleration(r100);
        double r102 = ((double) FlingCalculatorKt.access$getDecelerationRate$p()) - 1.0d;
        return (float) (((double) (this.friction * this.magicPhysicalCoefficient)) * Math.exp((((double) FlingCalculatorKt.access$getDecelerationRate$p()) / r102) * r101));
    }

    public final long flingDuration(float r100) {
        return (long) (Math.exp(getSplineDeceleration(r100) / (((double) FlingCalculatorKt.access$getDecelerationRate$p()) - 1.0d)) * 1000.0d);
    }

    public final FlingInfo flingInfo(float r110) {
        double r100 = getSplineDeceleration(r110);
        double r101 = ((double) FlingCalculatorKt.access$getDecelerationRate$p()) - 1.0d;
        return new FlingInfo(r110, (float) (((double) (this.friction * this.magicPhysicalCoefficient)) * Math.exp((((double) FlingCalculatorKt.access$getDecelerationRate$p()) / r101) * r100)), (long) (Math.exp(r100 / r101) * 1000.0d));
    }

    public FlingCalculator(float r100, Density r101) {
        this.friction = r100;
        this.density = r101;
        this.magicPhysicalCoefficient = computeDeceleration(r101);
    }
}
