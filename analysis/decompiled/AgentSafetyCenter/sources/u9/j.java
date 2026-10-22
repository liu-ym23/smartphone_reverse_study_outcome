package u9;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final i f14273a = new i(100);

    /* renamed from: b, reason: collision with root package name */
    public static final Paint f14274b;

    static {
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setAntiAlias(true);
        f14274b = paint;
    }

    public static final Path a(float f5, float f10, float f11, float f12, float f13, float f14, boolean z10) {
        Path path = new Path();
        h hVar = new h();
        hVar.f14266a = f5;
        hVar.f14267b = f10;
        hVar.f14268c = f11;
        hVar.f14269d = f12;
        hVar.f14270e = f13;
        hVar.f14271f = f14;
        hVar.f14272g = z10;
        VarHandle.storeStoreFence();
        i iVar = f14273a;
        Path path2 = (Path) iVar.get(hVar);
        if (path2 != null) {
            path.addPath(path2);
            return path;
        }
        iVar.put(hVar, path);
        float f15 = f11 - f5;
        float f16 = f12 - f10;
        if (f15 <= 0.0f || f16 <= 0.0f) {
            path.addRect(f5, f10, f11, f12, Path.Direction.CW);
            return new Path(path);
        }
        if (z10 && f14 > b(f15, f16, f13)) {
            path.addRoundRect(f5, f10, f11, f12, f14, f14, Path.Direction.CW);
            return new Path(path);
        }
        float f17 = (f5 + f11) / 2.0f;
        float f18 = (f10 + f12) / 2.0f;
        sa.c cVar = new sa.c(8, false);
        float[] fArr = new float[14];
        cVar.f12170f = fArr;
        fArr[0] = 0.0f;
        fArr[1] = (f13 * f14) + f14;
        fArr[2] = 0.0f;
        double d7 = f14;
        fArr[3] = (float) (((-Math.tan(0.2617993877991494d)) * d7) + d7);
        double dCos = Math.cos(0.7853981633974483d) * d7;
        double dTan = Math.tan(0.24434609527920614d) * Math.cos(0.7853981633974483d) * d7;
        fArr[4] = (float) ((-(dTan + dCos)) + d7);
        fArr[5] = (float) ((-(dCos - dTan)) + d7);
        double d10 = -f14;
        fArr[6] = (float) ((Math.cos(0.7853981633974483d) * d10) + d7);
        fArr[7] = (float) ((Math.sin(0.7853981633974483d) * d10) + d7);
        fArr[8] = fArr[5];
        fArr[9] = fArr[4];
        fArr[10] = fArr[3];
        fArr[11] = fArr[2];
        fArr[12] = fArr[1];
        fArr[13] = fArr[0];
        int iR = com.stepos.statsrpk.h.r(0, 13, 2);
        if (iR >= 0) {
            int i = 0;
            while (true) {
                fArr[i] = fArr[i] + f5;
                int i3 = i + 1;
                fArr[i3] = fArr[i3] + f10;
                if (i == iR) {
                    break;
                }
                i += 2;
            }
        }
        float[] fArr2 = (float[]) cVar.f12170f;
        path.moveTo(fArr2[0], fArr2[1]);
        cVar.c(path);
        Matrix matrix = new Matrix();
        float f19 = -f17;
        float f20 = -f18;
        matrix.postTranslate(f19, f20);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f17, f18);
        matrix.mapPoints((float[]) cVar.f12170f);
        cVar.k();
        float[] fArr3 = (float[]) cVar.f12170f;
        path.lineTo(fArr3[0], fArr3[1]);
        cVar.c(path);
        cVar.k();
        matrix.reset();
        matrix.postTranslate(f19, f20);
        matrix.postScale(1.0f, -1.0f);
        matrix.postTranslate(f17, f18);
        matrix.mapPoints((float[]) cVar.f12170f);
        float[] fArr4 = (float[]) cVar.f12170f;
        path.lineTo(fArr4[0], fArr4[1]);
        cVar.c(path);
        matrix.reset();
        matrix.postTranslate(f19, f20);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f17, f18);
        matrix.mapPoints((float[]) cVar.f12170f);
        cVar.k();
        float[] fArr5 = (float[]) cVar.f12170f;
        path.lineTo(fArr5[0], fArr5[1]);
        cVar.c(path);
        path.close();
        return new Path(path);
    }

    public static float b(float f5, float f10, float f11) {
        float fMin = Math.min(f5, f10);
        float f12 = (fMin / 2.0f) / (f11 + 1.0f);
        return fMin > f12 ? f12 : fMin;
    }
}
