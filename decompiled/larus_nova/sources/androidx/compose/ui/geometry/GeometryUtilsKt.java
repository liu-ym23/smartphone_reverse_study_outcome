package androidx.compose.ui.geometry;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toStringAsFixed", "", "", "digits", "", "ui-geometry"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class GeometryUtilsKt {
    public static final String toStringAsFixed(float r100, int r101) {
        if (Float.isNaN(r100) == false) goto L7;
        return "NaN";
    L7:
        if (Float.isInfinite(r100) == true) goto L9;
        int r102 = Math.max(r101, 0);
        float r103 = (float) Math.pow(10.0f, r102);
        float r104 = r100 * r103;
        int r105 = (int) r104;
        if ((r104 - r105) < 0.5f) goto L16;
        r105 = r105 + 1;
    L16:
        float r106 = r105 / r103;
        if (r102 <= 0) goto L20;
        return String.valueOf(r106);
    L20:
        return String.valueOf((int) r106);
    L9:
        if (r100 >= 0.0f) goto L11;
        return "-Infinity";
    L11:
        return "Infinity";
    }
}
