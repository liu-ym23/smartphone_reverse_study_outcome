package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline;", "", "<init>", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "flingPosition", "Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "time", "", "flingPosition-LfoxSSI", "(F)J", "deceleration", "", "velocity", "friction", "FlingResult", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidFlingSpline {
    public static final AndroidFlingSpline INSTANCE = null;
    private static final int NbSamples = 100;
    private static final float[] SplinePositions = null;
    private static final float[] SplineTimes = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "", "packedValue", "", "constructor-impl", "(J)J", "distanceCoefficient", "", "getDistanceCoefficient-impl", "(J)F", "velocityCoefficient", "getVelocityCoefficient-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class FlingResult {
        private final long packedValue;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ FlingResult m602boximpl(long r100) {
            return new FlingResult(r100);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m603constructorimpl(long r100) {
            return r100;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m604equalsimpl(long r100, Object r101) {
            if ((r101 instanceof FlingResult) == true) goto L6;
            return false;
        L6:
            if (r100 == ((FlingResult) r101).m610unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m605equalsimpl0(long r100, long r101) {
            if (r100 != r101) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m608hashCodeimpl(long r100) {
            return (int) (r100 ^ (r100 >>> 32));
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m609toStringimpl(long r100) {
            return "FlingResult(packedValue=" + r100 + ')';
        }

        public boolean equals(Object r100) {
            return m604equalsimpl(this.packedValue, r100);
        }

        public int hashCode() {
            return m608hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m609toStringimpl(this.packedValue);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m610unboximpl() {
            return this.packedValue;
        }

        private /* synthetic */ FlingResult(long r100) {
            this.packedValue = r100;
        }

        /* JADX INFO: renamed from: getDistanceCoefficient-impl, reason: not valid java name */
        public static final float m606getDistanceCoefficientimpl(long r100) {
            return Float.intBitsToFloat((int) (r100 >> 32));
        }

        /* JADX INFO: renamed from: getVelocityCoefficient-impl, reason: not valid java name */
        public static final float m607getVelocityCoefficientimpl(long r100) {
            return Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
        }
    }

    private AndroidFlingSpline() {
    }

    static {
        INSTANCE = new AndroidFlingSpline();
        SplinePositions = new float[101];
        SplineTimes = new float[101];
        float r100 = 0.0f;
        float r101 = 0.0f;
        int r102 = 0;
    L4:
        if (r102 >= 100) goto L21;
        float r103 = r102 / 100;
        float r104 = 1.0f;
    L6:
        float r105 = ((r104 - r100) / 2.0f) + r100;
        float r110 = 1.0f - r105;
        float r106 = (r105 * 3.0f) * r110;
        float r111 = (r105 * r105) * r105;
        float r112 = (((r110 * 0.175f) + (r105 * 0.35000002f)) * r106) + r111;
        if (Math.abs(r112 - r103) < 1.0E-5d) goto L12;
        if (r112 > r103) goto L10;
        r100 = r105;
        goto L6
    L10:
        r104 = r105;
        goto L6
    L12:
        float r107 = 0.5f;
        SplinePositions[r102] = (r106 * ((r110 * 0.5f) + r105)) + r111;
        float r108 = 1.0f;
    L13:
        float r109 = ((r108 - r101) / 2.0f) + r101;
        float r113 = 1.0f - r109;
        float r114 = (r109 * 3.0f) * r113;
        float r115 = (r109 * r109) * r109;
        float r116 = (((r113 * r107) + r109) * r114) + r115;
        if (Math.abs(r116 - r103) < 1.0E-5d) goto L20;
        if (r116 <= r103) goto L18;
        r108 = r109;
    L19:
        r107 = 0.5f;
        goto L13
    L18:
        r101 = r109;
        goto L19
    L20:
        SplineTimes[r102] = (r114 * ((r113 * 0.175f) + (r109 * 0.35000002f))) + r115;
        r102 = r102 + 1;
        goto L4
    L21:
        SplineTimes[100] = 1.0f;
        SplinePositions[100] = 1.0f;
    }

    /* JADX INFO: renamed from: flingPosition-LfoxSSI, reason: not valid java name */
    public final long m601flingPositionLfoxSSI(float r100) {
        float r101 = 100;
        int r102 = (int) (r101 * r100);
        if (r102 >= 100) goto L5;
        float r103 = r102 / r101;
        int r104 = r102 + 1;
        float r105 = r104 / r101;
        float[] r106 = SplinePositions;
        float r107 = r106[r102];
        float r108 = (r106[r104] - r107) / (r105 - r103);
        float r109 = r107 + ((r100 - r103) * r108);
    L6:
        long r110 = Float.floatToRawIntBits(r109);
        return FlingResult.m603constructorimpl((((long) Float.floatToRawIntBits(r108)) & BodyPartID.bodyIdMax) | (r110 << 32));
    L5:
        r109 = 1.0f;
        r108 = 0.0f;
        goto L6
    }

    public final double deceleration(float r100, float r101) {
        return Math.log(((double) (Math.abs(r100) * 0.35f)) / ((double) r101));
    }
}
