package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"setFrom", "", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "Landroid/graphics/Matrix;", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidMatrixConversions_androidKt {
    /* JADX INFO: renamed from: setFrom-EL8BTi8, reason: not valid java name */
    public static final void m4695setFromEL8BTi8(android.graphics.Matrix r210, float[] r211) {
        float r100 = r211[0];
        float r101 = r211[1];
        float r102 = r211[2];
        float r103 = r211[3];
        float r104 = r211[4];
        float r110 = r211[5];
        float r111 = r211[6];
        float r112 = r211[7];
        float r113 = r211[8];
        float r114 = r211[12];
        float r115 = r211[13];
        float r212 = r211[15];
        r211[0] = r100;
        r211[1] = r104;
        r211[2] = r114;
        r211[3] = r101;
        r211[4] = r110;
        r211[5] = r115;
        r211[6] = r103;
        r211[7] = r112;
        r211[8] = r212;
        r210.setValues(r211);
        r211[0] = r100;
        r211[1] = r101;
        r211[2] = r102;
        r211[3] = r103;
        r211[4] = r104;
        r211[5] = r110;
        r211[6] = r111;
        r211[7] = r112;
        r211[8] = r113;
    }

    /* JADX INFO: renamed from: setFrom-tU-YjHk, reason: not valid java name */
    public static final void m4696setFromtUYjHk(float[] r110, android.graphics.Matrix r210) {
        r210.getValues(r110);
        float r100 = r110[0];
        float r101 = r110[1];
        float r102 = r110[2];
        float r103 = r110[3];
        float r111 = r110[4];
        float r112 = r110[5];
        float r113 = r110[6];
        float r114 = r110[7];
        float r115 = r110[8];
        r110[0] = r100;
        r110[1] = r103;
        r110[2] = 0.0f;
        r110[3] = r113;
        r110[4] = r101;
        r110[5] = r111;
        r110[6] = 0.0f;
        r110[7] = r114;
        r110[8] = 0.0f;
        r110[9] = 0.0f;
        r110[10] = 1.0f;
        r110[11] = 0.0f;
        r110[12] = r102;
        r110[13] = r112;
        r110[14] = 0.0f;
        r110[15] = r115;
    }
}
