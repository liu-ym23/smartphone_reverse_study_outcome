package m2;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.stepos.alphame.utils.Property;
import kotlin.internal.ProgressionUtilKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final l f13583a = new l(100);

    /* renamed from: b, reason: collision with root package name */
    public static final Paint f13584b;

    static {
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setAntiAlias(true);
        f13584b = paint;
    }

    public static final Path a(float f4, float f5, float f6, float f7, float f8, float f9, boolean z4) {
        Path path = new Path();
        k kVar = new k(f4, f5, f6, f7, f8, f9, z4);
        l lVar = f13583a;
        Path path2 = (Path) lVar.get(kVar);
        if (path2 != null) {
            path.addPath(path2);
            return path;
        }
        lVar.put(kVar, path);
        float f10 = f6 - f4;
        float f11 = f7 - f5;
        if (f10 <= Property.DEFAULT_FLOAT_VALUE || f11 <= Property.DEFAULT_FLOAT_VALUE) {
            path.addRect(f4, f5, f6, f7, Path.Direction.CW);
            return new Path(path);
        }
        if (z4 && f9 > b(f10, f11, f8)) {
            path.addRoundRect(f4, f5, f6, f7, f9, f9, Path.Direction.CW);
            return new Path(path);
        }
        float f12 = (f4 + f6) / 2.0f;
        float f13 = (f5 + f7) / 2.0f;
        j jVar = new j();
        float[] fArr = new float[14];
        jVar.f13575a = fArr;
        fArr[0] = 0.0f;
        fArr[1] = (f8 * f9) + f9;
        fArr[2] = 0.0f;
        double d4 = f9;
        fArr[3] = (float) (((-Math.tan(0.2617993877991494d)) * d4) + d4);
        double dCos = Math.cos(0.7853981633974483d) * d4;
        double dTan = Math.tan(0.24434609527920614d) * Math.cos(0.7853981633974483d) * d4;
        fArr[4] = (float) ((-(dTan + dCos)) + d4);
        fArr[5] = (float) ((-(dCos - dTan)) + d4);
        double d5 = -f9;
        fArr[6] = (float) ((Math.cos(0.7853981633974483d) * d5) + d4);
        fArr[7] = (float) ((Math.sin(0.7853981633974483d) * d5) + d4);
        fArr[8] = fArr[5];
        fArr[9] = fArr[4];
        fArr[10] = fArr[3];
        fArr[11] = fArr[2];
        fArr[12] = fArr[1];
        fArr[13] = fArr[0];
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, 13, 2);
        if (progressionLastElement >= 0) {
            int i4 = 0;
            while (true) {
                fArr[i4] = fArr[i4] + f4;
                int i5 = i4 + 1;
                fArr[i5] = fArr[i5] + f5;
                if (i4 == progressionLastElement) {
                    break;
                }
                i4 += 2;
            }
        }
        float[] fArr2 = jVar.f13575a;
        path.moveTo(fArr2[0], fArr2[1]);
        jVar.a(path);
        Matrix matrix = new Matrix();
        float f14 = -f12;
        float f15 = -f13;
        matrix.postTranslate(f14, f15);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f12, f13);
        matrix.mapPoints(jVar.f13575a);
        jVar.b();
        float[] fArr3 = jVar.f13575a;
        path.lineTo(fArr3[0], fArr3[1]);
        jVar.a(path);
        jVar.b();
        matrix.reset();
        matrix.postTranslate(f14, f15);
        matrix.postScale(1.0f, -1.0f);
        matrix.postTranslate(f12, f13);
        matrix.mapPoints(jVar.f13575a);
        float[] fArr4 = jVar.f13575a;
        path.lineTo(fArr4[0], fArr4[1]);
        jVar.a(path);
        matrix.reset();
        matrix.postTranslate(f14, f15);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate(f12, f13);
        matrix.mapPoints(jVar.f13575a);
        jVar.b();
        float[] fArr5 = jVar.f13575a;
        path.lineTo(fArr5[0], fArr5[1]);
        jVar.a(path);
        path.close();
        return new Path(path);
    }

    public static float b(float f4, float f5, float f6) {
        float fMin = Math.min(f4, f5);
        return RangesKt.coerceAtMost(fMin, (fMin / 2.0f) / (f6 + 1.0f));
    }
}
