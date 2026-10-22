package androidx.compose.ui.util;

import U7.a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0001\u001a)\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\b\u001a)\u0010\f\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0012H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0012H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0012H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0086\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0001H\u0086\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0012H\u0086\b\u001a\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0011\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\b¨\u0006\u001a"}, d2 = {"lerp", "", "start", "stop", "fraction", "", "", "fastMinOf", "a", "b", "c", "d", "fastMaxOf", "fastCoerceIn", "minimumValue", "maximumValue", "fastCoerceAtLeast", "fastCoerceAtMost", "", "fastIsFinite", "", "fastCbrt", "x", "normalizedAngleSin", "normalizedDegrees", "normalizedAngleCos", "ui-util"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MathHelpersKt {
    public static final float fastCbrt(float f) {
        float fIntBitsToFloat = Float.intBitsToFloat(((int) ((Float.floatToRawIntBits(f) & 8589934591L) / 3)) + 709952852);
        float f7 = fIntBitsToFloat - ((fIntBitsToFloat - (f / (fIntBitsToFloat * fIntBitsToFloat))) * 0.33333334f);
        return f7 - ((f7 - (f / (f7 * f7))) * 0.33333334f);
    }

    public static final double fastCoerceAtLeast(double d, double d6) {
        return d < d6 ? d6 : d;
    }

    public static final double fastCoerceAtMost(double d, double d6) {
        return d > d6 ? d6 : d;
    }

    public static final double fastCoerceIn(double d, double d6, double d10) {
        if (d < d6) {
            d = d6;
        }
        return d > d10 ? d10 : d;
    }

    public static final boolean fastIsFinite(float f) {
        return (Float.floatToRawIntBits(f) & Integer.MAX_VALUE) < 2139095040;
    }

    public static final float fastMaxOf(float f, float f7, float f9, float f10) {
        return Math.max(f, Math.max(f7, Math.max(f9, f10)));
    }

    public static final float fastMinOf(float f, float f7, float f9, float f10) {
        return Math.min(f, Math.min(f7, Math.min(f9, f10)));
    }

    public static final float lerp(float f, float f7, float f9) {
        return (f9 * f7) + ((1 - f9) * f);
    }

    public static final float normalizedAngleCos(float f) {
        float fFloor = (f + 0.25f) - ((float) Math.floor(0.5f + r3));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f7 = 1.0f - fAbs;
        return ((fFloor * 8.0f) * f7) / (1.25f - (fAbs * f7));
    }

    public static final float normalizedAngleSin(float f) {
        float fFloor = f - ((float) Math.floor(0.5f + f));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f7 = 1.0f - fAbs;
        return ((fFloor * 8.0f) * f7) / (1.25f - (fAbs * f7));
    }

    public static final float fastCoerceAtLeast(float f, float f7) {
        return f < f7 ? f7 : f;
    }

    public static final float fastCoerceAtMost(float f, float f7) {
        return f > f7 ? f7 : f;
    }

    public static final float fastCoerceIn(float f, float f7, float f9) {
        if (f < f7) {
            f = f7;
        }
        return f > f9 ? f9 : f;
    }

    public static final boolean fastIsFinite(double d) {
        return (Double.doubleToRawLongBits(d) & Long.MAX_VALUE) < 9218868437227405312L;
    }

    public static final long lerp(long j5, long j6, float f) {
        return a.V((j6 - j5) * f) + j5;
    }

    public static final int fastCoerceAtLeast(int i, int i6) {
        return i < i6 ? i6 : i;
    }

    public static final int fastCoerceAtMost(int i, int i6) {
        return i > i6 ? i6 : i;
    }

    public static final int fastCoerceIn(int i, int i6, int i10) {
        if (i < i6) {
            i = i6;
        }
        return i > i10 ? i10 : i;
    }

    public static final int lerp(int i, int i6, float f) {
        return i + ((int) Math.round((i6 - i) * f));
    }

    public static final long fastCoerceAtLeast(long j5, long j6) {
        return j5 < j6 ? j6 : j5;
    }

    public static final long fastCoerceAtMost(long j5, long j6) {
        return j5 > j6 ? j6 : j5;
    }

    public static final long fastCoerceIn(long j5, long j6, long j10) {
        if (j5 < j6) {
            j5 = j6;
        }
        return j5 > j10 ? j10 : j5;
    }
}
