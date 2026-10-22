package androidx.compose.ui.util;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0001\u001a)\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\b\u001a)\u0010\f\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0012H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0012H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0012H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0086\b\u001a\u0015\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0086\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0001H\u0086\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0012H\u0086\b\u001a\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0011\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\b¨\u0006\u001a"}, d2 = {"lerp", "", "start", "stop", "fraction", "", "", "fastMinOf", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "fastMaxOf", "fastCoerceIn", "minimumValue", "maximumValue", "fastCoerceAtLeast", "fastCoerceAtMost", "", "fastIsFinite", "", "fastCbrt", "x", "normalizedAngleSin", "normalizedDegrees", "normalizedAngleCos", "ui-util"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MathHelpersKt {
    public static final double fastCoerceAtLeast(double r100, double r101) {
        if (r100 < r101) goto L5;
        return r100;
    L5:
        return r101;
    }

    public static final float fastCoerceAtLeast(float r100, float r101) {
        if (r100 < r101) goto L5;
        return r100;
    L5:
        return r101;
    }

    public static final int fastCoerceAtLeast(int r100, int r101) {
        if (r100 < r101) goto L4;
        return r100;
    L4:
        return r101;
    }

    public static final long fastCoerceAtLeast(long r100, long r101) {
        if (r100 < r101) goto L5;
        return r100;
    L5:
        return r101;
    }

    public static final double fastCoerceAtMost(double r100, double r101) {
        if (r100 > r101) goto L5;
        return r100;
    L5:
        return r101;
    }

    public static final float fastCoerceAtMost(float r100, float r101) {
        if (r100 > r101) goto L5;
        return r100;
    L5:
        return r101;
    }

    public static final int fastCoerceAtMost(int r100, int r101) {
        if (r100 > r101) goto L4;
        return r100;
    L4:
        return r101;
    }

    public static final long fastCoerceAtMost(long r100, long r101) {
        if (r100 > r101) goto L5;
        return r100;
    L5:
        return r101;
    }

    public static final double fastCoerceIn(double r100, double r101, double r102) {
        if (r100 >= r101) goto L6;
        r100 = r101;
    L6:
        if (r100 <= r102) goto L9;
        return r102;
    L9:
        return r100;
    }

    public static final float fastCoerceIn(float r100, float r101, float r102) {
        if (r100 >= r101) goto L6;
        r100 = r101;
    L6:
        if (r100 <= r102) goto L9;
        return r102;
    L9:
        return r100;
    }

    public static final int fastCoerceIn(int r100, int r101, int r102) {
        if (r100 >= r101) goto L4;
        r100 = r101;
    L4:
        if (r100 <= r102) goto L7;
        return r102;
    L7:
        return r100;
    }

    public static final long fastCoerceIn(long r100, long r101, long r102) {
        if (r100 >= r101) goto L6;
        r100 = r101;
    L6:
        if (r100 <= r102) goto L9;
        return r102;
    L9:
        return r100;
    }

    public static final float lerp(float r100, float r101, float r102) {
        return ((1 - r102) * r100) + (r102 * r101);
    }

    public static final float fastCbrt(float r100) {
        float r101 = Float.intBitsToFloat(((int) ((((long) Float.floatToRawIntBits(r100)) & 8589934591L) / ((long) 3))) + 709952852);
        float r102 = r101 - ((r101 - (r100 / (r101 * r101))) * 0.33333334f);
        return r102 - ((r102 - (r100 / (r102 * r102))) * 0.33333334f);
    }

    public static final boolean fastIsFinite(double r100) {
        if ((Double.doubleToRawLongBits(r100) & Long.MAX_VALUE) >= 9218868437227405312L) goto L5;
        return true;
    L5:
        return false;
    }

    public static final float normalizedAngleCos(float r100) {
        float r101 = r100 + 0.25f;
        float r102 = r101 - ((float) Math.floor(0.5f + r101));
        float r103 = Math.abs(r102) * 2.0f;
        float r104 = 1.0f - r103;
        return ((r102 * 8.0f) * r104) / (1.25f - (r103 * r104));
    }

    public static final float normalizedAngleSin(float r100) {
        float r101 = r100 - ((float) Math.floor(0.5f + r100));
        float r102 = Math.abs(r101) * 2.0f;
        float r103 = 1.0f - r102;
        return ((r101 * 8.0f) * r103) / (1.25f - (r102 * r103));
    }

    public static final boolean fastIsFinite(float r100) {
        if ((Float.floatToRawIntBits(r100) & Integer.MAX_VALUE) >= 2139095040) goto L5;
        return true;
    L5:
        return false;
    }

    public static final int lerp(int r100, int r101, float r102) {
        return r100 + ((int) Math.round(((double) (r101 - r100)) * ((double) r102)));
    }

    public static final long lerp(long r100, long r101, float r102) {
        return r100 + MathKt.roundToLong((r101 - r100) * ((double) r102));
    }

    public static final float fastMaxOf(float r100, float r101, float r102, float r103) {
        return Math.max(r100, Math.max(r101, Math.max(r102, r103)));
    }

    public static final float fastMinOf(float r100, float r101, float r102, float r103) {
        return Math.min(r100, Math.min(r101, Math.min(r102, r103)));
    }
}
