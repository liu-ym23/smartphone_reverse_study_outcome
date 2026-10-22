package a5;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/* loaded from: classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final i f1645a = new i(100);
    public static final Paint b;

    static {
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setAntiAlias(true);
        b = paint;
    }

    public static final Path a(float f, float f7, float f9, float f10, float f11, float f12, boolean z10) {
        Path path = new Path();
        h hVar = new h(f, f7, f9, f10, f11, f12, z10);
        i iVar = f1645a;
        Path path2 = (Path) iVar.get(hVar);
        if (path2 != null) {
            path.addPath(path2);
            return path;
        }
        iVar.put(hVar, path);
        float f13 = f9 - f;
        float f14 = f10 - f7;
        if (f13 <= 0.0f || f14 <= 0.0f) {
            path.addRect(f, f7, f9, f10, Path.Direction.CW);
            return new Path(path);
        }
        if (z10 && f12 > b(f13, f14, f11)) {
            path.addRoundRect(f, f7, f9, f10, f12, f12, Path.Direction.CW);
            return new Path(path);
        }
        float f15 = (f + f9) / 2.0f;
        float f16 = (f7 + f10) / 2.0f;
        d dVar = new d(3);
        float[] fArr = new float[14];
        dVar.b = fArr;
        fArr[0] = 0.0f;
        fArr[1] = (f11 * f12) + f12;
        fArr[2] = 0.0f;
        double d = f12;
        fArr[3] = (float) (((-Math.tan(0.2617993877991494d)) * d) + d);
        double dCos = Math.cos(0.7853981633974483d) * d;
        double dTan = Math.tan(0.24434609527920614d) * Math.cos(0.7853981633974483d) * d;
        fArr[4] = (float) ((-(dTan + dCos)) + d);
        fArr[5] = (float) ((-(dCos - dTan)) + d);
        double d6 = -f12;
        fArr[6] = (float) ((Math.cos(0.7853981633974483d) * d6) + d);
        fArr[7] = (float) B7.a.a(0.7853981633974483d, d6, d);
        fArr[8] = fArr[5];
        fArr[9] = fArr[4];
        fArr[10] = fArr[3];
        fArr[11] = fArr[2];
        fArr[12] = fArr[1];
        fArr[13] = fArr[0];
        int iD = Z6.k.D(0, 13, 2);
        if (iD >= 0) {
            int i = 0;
            while (true) {
                fArr[i] = fArr[i] + f;
                int i6 = i + 1;
                fArr[i6] = fArr[i6] + f7;
                if (i == iD) {
                    break;
                }
                i += 2;
            }
        }
        float[] fArr2 = (float[]) dVar.b;
        path.moveTo(fArr2[0], fArr2[1]);
        dVar.e(path);
        Matrix matrix = new Matrix();
        float f17 = -f15;
        float f18 = -f16;
        matrix.postTranslate(f17, f18);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f15, f16);
        matrix.mapPoints((float[]) dVar.b);
        dVar.i();
        float[] fArr3 = (float[]) dVar.b;
        path.lineTo(fArr3[0], fArr3[1]);
        dVar.e(path);
        dVar.i();
        matrix.reset();
        matrix.postTranslate(f17, f18);
        matrix.postScale(1.0f, -1.0f);
        matrix.postTranslate(f15, f16);
        matrix.mapPoints((float[]) dVar.b);
        float[] fArr4 = (float[]) dVar.b;
        path.lineTo(fArr4[0], fArr4[1]);
        dVar.e(path);
        matrix.reset();
        matrix.postTranslate(f17, f18);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f15, f16);
        matrix.mapPoints((float[]) dVar.b);
        dVar.i();
        float[] fArr5 = (float[]) dVar.b;
        path.lineTo(fArr5[0], fArr5[1]);
        dVar.e(path);
        path.close();
        return new Path(path);
    }

    public static float b(float f, float f7, float f9) {
        float fMin = Math.min(f, f7);
        float f10 = (fMin / 2.0f) / (f9 + 1.0f);
        return fMin > f10 ? f10 : fMin;
    }
}
