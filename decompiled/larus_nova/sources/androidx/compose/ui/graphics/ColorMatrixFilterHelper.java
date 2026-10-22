package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrixFilterHelper;", "", "<init>", "()V", "getColorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "colorFilter", "Landroid/graphics/ColorMatrixColorFilter;", "getColorMatrix-8unuwjk", "(Landroid/graphics/ColorMatrixColorFilter;)[F", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ColorMatrixFilterHelper {
    public static final ColorMatrixFilterHelper INSTANCE = null;

    static {
        INSTANCE = new ColorMatrixFilterHelper();
    }

    private ColorMatrixFilterHelper() {
    }

    /* JADX INFO: renamed from: getColorMatrix-8unuwjk, reason: not valid java name */
    public final float[] m4906getColorMatrix8unuwjk(android.graphics.ColorMatrixColorFilter r100) {
        android.graphics.ColorMatrix r101 = new android.graphics.ColorMatrix();
        r100.getColorMatrix(r101);
        return ColorMatrix.m4883constructorimpl(r101.getArray());
    }
}
