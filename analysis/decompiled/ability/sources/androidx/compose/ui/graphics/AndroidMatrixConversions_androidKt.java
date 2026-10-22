package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", "Landroid/graphics/Matrix;", "matrix", "LC7/r;", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "setFrom", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidMatrixConversions_androidKt {
    /* renamed from: setFrom-EL8BTi8, reason: not valid java name */
    public static final void m4007setFromEL8BTi8(android.graphics.Matrix matrix, float[] fArr) {
        float f = fArr[0];
        float f7 = fArr[1];
        float f9 = fArr[2];
        float f10 = fArr[3];
        float f11 = fArr[4];
        float f12 = fArr[5];
        float f13 = fArr[6];
        float f14 = fArr[7];
        float f15 = fArr[8];
        float f16 = fArr[12];
        float f17 = fArr[13];
        float f18 = fArr[15];
        fArr[0] = f;
        fArr[1] = f11;
        fArr[2] = f16;
        fArr[3] = f7;
        fArr[4] = f12;
        fArr[5] = f17;
        fArr[6] = f10;
        fArr[7] = f14;
        fArr[8] = f18;
        matrix.setValues(fArr);
        fArr[0] = f;
        fArr[1] = f7;
        fArr[2] = f9;
        fArr[3] = f10;
        fArr[4] = f11;
        fArr[5] = f12;
        fArr[6] = f13;
        fArr[7] = f14;
        fArr[8] = f15;
    }

    /* renamed from: setFrom-tU-YjHk, reason: not valid java name */
    public static final void m4008setFromtUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        matrix.getValues(fArr);
        float f = fArr[0];
        float f7 = fArr[1];
        float f9 = fArr[2];
        float f10 = fArr[3];
        float f11 = fArr[4];
        float f12 = fArr[5];
        float f13 = fArr[6];
        float f14 = fArr[7];
        float f15 = fArr[8];
        fArr[0] = f;
        fArr[1] = f10;
        fArr[2] = 0.0f;
        fArr[3] = f13;
        fArr[4] = f7;
        fArr[5] = f11;
        fArr[6] = 0.0f;
        fArr[7] = f14;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = f9;
        fArr[13] = f12;
        fArr[14] = 0.0f;
        fArr[15] = f15;
    }
}
