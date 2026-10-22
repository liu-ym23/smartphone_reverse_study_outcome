package y1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import com.stepos.alphame.utils.Property;
import x1.C0980a;

/* loaded from: classes.dex */
public final class r extends w {

    /* renamed from: c, reason: collision with root package name */
    public final t f16299c;

    public r(t tVar) {
        this.f16299c = tVar;
    }

    @Override // y1.w
    public final void a(Matrix matrix, C0980a c0980a, int i4, Canvas canvas) {
        t tVar = this.f16299c;
        float f4 = tVar.f16308f;
        float f5 = tVar.f16309g;
        RectF rectF = new RectF(tVar.f16304b, tVar.f16305c, tVar.f16306d, tVar.f16307e);
        c0980a.getClass();
        boolean z4 = f5 < Property.DEFAULT_FLOAT_VALUE;
        Path path = c0980a.f15899g;
        int[] iArr = C0980a.f15891k;
        if (z4) {
            iArr[0] = 0;
            iArr[1] = c0980a.f15898f;
            iArr[2] = c0980a.f15897e;
            iArr[3] = c0980a.f15896d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f4, f5);
            path.close();
            float f6 = -i4;
            rectF.inset(f6, f6);
            iArr[0] = 0;
            iArr[1] = c0980a.f15896d;
            iArr[2] = c0980a.f15897e;
            iArr[3] = c0980a.f15898f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= Property.DEFAULT_FLOAT_VALUE) {
            return;
        }
        float f7 = 1.0f - (i4 / fWidth);
        float[] fArr = C0980a.f15892l;
        fArr[1] = f7;
        fArr[2] = ((1.0f - f7) / 2.0f) + f7;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = c0980a.f15894b;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z4) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, c0980a.f15900h);
        }
        canvas.drawArc(rectF, f4, f5, true, paint);
        canvas.restore();
    }
}
