package e3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import d3.C1376a;

/* loaded from: classes3.dex */
public final class t extends y {
    public final v c;

    public t(v vVar) {
        this.c = vVar;
    }

    @Override // e3.y
    public final void a(Matrix matrix, C1376a c1376a, int i, Canvas canvas) {
        v vVar = this.c;
        float f = vVar.f;
        float f7 = vVar.g;
        RectF rectF = new RectF(vVar.b, vVar.c, vVar.d, vVar.e);
        Paint paint = c1376a.b;
        boolean z10 = f7 < 0.0f;
        Path path = c1376a.g;
        int[] iArr = C1376a.k;
        if (z10) {
            iArr[0] = 0;
            iArr[1] = c1376a.f;
            iArr[2] = c1376a.e;
            iArr[3] = c1376a.d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f, f7);
            path.close();
            float f9 = -i;
            rectF.inset(f9, f9);
            iArr[0] = 0;
            iArr[1] = c1376a.d;
            iArr[2] = c1376a.e;
            iArr[3] = c1376a.f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f10 = 1.0f - (i / fWidth);
        float[] fArr = C1376a.l;
        fArr[1] = f10;
        fArr[2] = ((1.0f - f10) / 2.0f) + f10;
        paint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, c1376a.h);
        }
        canvas.drawArc(rectF, f, f7, true, paint);
        canvas.restore();
    }
}
