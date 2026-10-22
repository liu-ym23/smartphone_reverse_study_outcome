package androidx.compose.ui.geometry;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toStringAsFixed", "", "", "digits", "", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GeometryUtilsKt {
    public static final String toStringAsFixed(float f, int i) {
        if (Float.isNaN(f)) {
            return "NaN";
        }
        if (Float.isInfinite(f)) {
            return f < 0.0f ? "-Infinity" : "Infinity";
        }
        int iMax = Math.max(i, 0);
        float fPow = (float) Math.pow(10.0f, iMax);
        float f7 = f * fPow;
        int i6 = (int) f7;
        if (f7 - i6 >= 0.5f) {
            i6++;
        }
        float f9 = i6 / fPow;
        return iMax > 0 ? String.valueOf(f9) : String.valueOf((int) f9);
    }
}
