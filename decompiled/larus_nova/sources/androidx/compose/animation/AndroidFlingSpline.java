package androidx.compose.animation;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/AndroidFlingSpline;", "", "<init>", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "flingPosition", "Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "time", "", "deceleration", "", "velocity", "friction", "FlingResult", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidFlingSpline {
    public static final int $stable = 0;
    public static final AndroidFlingSpline INSTANCE = null;
    private static final int NbSamples = 100;
    private static final float[] SplinePositions = null;
    private static final float[] SplineTimes = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "", "distanceCoefficient", "", "velocityCoefficient", "<init>", "(FF)V", "getDistanceCoefficient", "()F", "getVelocityCoefficient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FlingResult {
        public static final int $stable = 0;
        private final float distanceCoefficient;
        private final float velocityCoefficient;

        public static /* synthetic */ FlingResult copy$default(FlingResult r100, float r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.distanceCoefficient;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.velocityCoefficient;
        L9:
            return r100.copy(r101, r102);
        }

        public final float component1() {
            return this.distanceCoefficient;
        }

        public final float component2() {
            return this.velocityCoefficient;
        }

        public final FlingResult copy(float r100, float r101) {
            return new FlingResult(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof FlingResult) == true) goto L8;
            return false;
        L8:
            FlingResult r101 = (FlingResult) r100;
            if (Float.compare(this.distanceCoefficient, r101.distanceCoefficient) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.velocityCoefficient, r101.velocityCoefficient) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.distanceCoefficient) * 31) + Float.floatToIntBits(this.velocityCoefficient);
        }

        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.distanceCoefficient + ", velocityCoefficient=" + this.velocityCoefficient + ')';
        }

        public final float getDistanceCoefficient() {
            return this.distanceCoefficient;
        }

        public final float getVelocityCoefficient() {
            return this.velocityCoefficient;
        }

        public FlingResult(float r100, float r101) {
            this.distanceCoefficient = r100;
            this.velocityCoefficient = r101;
        }
    }

    private AndroidFlingSpline() {
    }

    static {
        INSTANCE = new AndroidFlingSpline();
        float[] r100 = new float[101];
        SplinePositions = r100;
        float[] r101 = new float[101];
        SplineTimes = r101;
        SplineBasedDecayKt.access$computeSplineInfo(r100, r101, 100);
        $stable = 8;
    }

    public final FlingResult flingPosition(float r100) {
        float r101 = 0.0f;
        float r102 = 1.0f;
        float r103 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        float r104 = 100;
        int r105 = (int) (r104 * r103);
        if (r105 >= 100) goto L6;
        float r106 = r105 / r104;
        int r107 = r105 + 1;
        float r108 = r107 / r104;
        float[] r109 = SplinePositions;
        float r110 = r109[r105];
        float r111 = (r109[r107] - r110) / (r108 - r106);
        float r112 = ((r103 - r106) * r111) + r110;
        r101 = r111;
        r102 = r112;
    L6:
        return new FlingResult(r102, r101);
    }

    public final double deceleration(float r100, float r101) {
        return Math.log(((double) (Math.abs(r100) * 0.35f)) / ((double) r101));
    }
}
