package androidx.compose.foundation.layout;

import androidx.appfunctions.metadata.a;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline;", "", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "deceleration", "", "velocity", "", "friction", "flingPosition", "Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "time", "flingPosition-LfoxSSI", "(F)J", "FlingResult", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AndroidFlingSpline {
    private static final int NbSamples = 100;
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();
    private static final float[] SplinePositions = new float[101];
    private static final float[] SplineTimes = new float[101];

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "", "packedValue", "", "constructor-impl", "(J)J", "distanceCoefficient", "", "getDistanceCoefficient-impl", "(J)F", "velocityCoefficient", "getVelocityCoefficient-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FlingResult {
        private final long packedValue;

        private /* synthetic */ FlingResult(long j5) {
            this.packedValue = j5;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ FlingResult m571boximpl(long j5) {
            return new FlingResult(j5);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static long m572constructorimpl(long j5) {
            return j5;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m573equalsimpl(long j5, Object obj) {
            return (obj instanceof FlingResult) && j5 == ((FlingResult) obj).getPackedValue();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m574equalsimpl0(long j5, long j6) {
            return j5 == j6;
        }

        /* renamed from: getDistanceCoefficient-impl, reason: not valid java name */
        public static final float m575getDistanceCoefficientimpl(long j5) {
            return Float.intBitsToFloat((int) (j5 >> 32));
        }

        /* renamed from: getVelocityCoefficient-impl, reason: not valid java name */
        public static final float m576getVelocityCoefficientimpl(long j5) {
            return Float.intBitsToFloat((int) (j5 & 4294967295L));
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m577hashCodeimpl(long j5) {
            return Long.hashCode(j5);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m578toStringimpl(long j5) {
            return "FlingResult(packedValue=" + j5 + ')';
        }

        public boolean equals(Object obj) {
            return m573equalsimpl(this.packedValue, obj);
        }

        public int hashCode() {
            return m577hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m578toStringimpl(this.packedValue);
        }

        /* renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ long getPackedValue() {
            return this.packedValue;
        }
    }

    static {
        float f;
        float f7;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17 = 0.0f;
        int i = 0;
        float f18 = 0.0f;
        while (true) {
            float f19 = 1.0f;
            if (i >= 100) {
                SplineTimes[100] = 1.0f;
                SplinePositions[100] = 1.0f;
                return;
            }
            float f20 = i / 100;
            float f21 = 1.0f;
            while (true) {
                f = ((f21 - f17) / 2.0f) + f17;
                f7 = f19 - f;
                f9 = f * 3.0f * f7;
                f10 = f * f * f;
                float fA = a.a(f, 0.35000002f, f7 * 0.175f, f9) + f10;
                f11 = f19;
                f12 = f20;
                if (Math.abs(fA - f20) < 1.0E-5d) {
                    break;
                }
                if (fA > f12) {
                    f21 = f;
                } else {
                    f17 = f;
                }
                f19 = f11;
                f20 = f12;
            }
            SplinePositions[i] = (((f7 * 0.5f) + f) * f9) + f10;
            float f22 = f11;
            while (true) {
                f13 = ((f22 - f18) / 2.0f) + f18;
                f14 = f11 - f13;
                f15 = f13 * 3.0f * f14;
                f16 = f13 * f13 * f13;
                float fA2 = a.a(f14, 0.5f, f13, f15) + f16;
                if (Math.abs(fA2 - f12) >= 1.0E-5d) {
                    if (fA2 > f12) {
                        f22 = f13;
                    } else {
                        f18 = f13;
                    }
                }
            }
            SplineTimes[i] = (((f13 * 0.35000002f) + (f14 * 0.175f)) * f15) + f16;
            i++;
        }
    }

    private AndroidFlingSpline() {
    }

    public final double deceleration(float velocity, float friction) {
        return Math.log((Math.abs(velocity) * 0.35f) / friction);
    }

    /* renamed from: flingPosition-LfoxSSI, reason: not valid java name */
    public final long m570flingPositionLfoxSSI(float time) {
        float fB;
        float f;
        float f7 = 100;
        int i = (int) (f7 * time);
        if (i < 100) {
            float f9 = i / f7;
            int i6 = i + 1;
            float f10 = i6 / f7;
            float[] fArr = SplinePositions;
            float f11 = fArr[i];
            f = (fArr[i6] - f11) / (f10 - f9);
            fB = B7.a.b(time, f9, f, f11);
        } else {
            fB = 1.0f;
            f = 0.0f;
        }
        return FlingResult.m572constructorimpl((Float.floatToRawIntBits(fB) << 32) | (Float.floatToRawIntBits(f) & 4294967295L));
    }
}
