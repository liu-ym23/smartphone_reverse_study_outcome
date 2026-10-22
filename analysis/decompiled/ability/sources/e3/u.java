package e3;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import d3.C1376a;

/* loaded from: classes3.dex */
public final class u extends y {
    public final w c;
    public final float d;
    public final float e;

    public u(w wVar, float f, float f7) {
        this.c = wVar;
        this.d = f;
        this.e = f7;
    }

    @Override // e3.y
    public final void a(Matrix matrix, C1376a c1376a, int i, Canvas canvas) {
        w wVar = this.c;
        float f = wVar.c;
        float f7 = this.e;
        float f9 = wVar.b;
        float f10 = this.d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f7, f9 - f10), 0.0f);
        Matrix matrix2 = this.f4375a;
        matrix2.set(matrix);
        matrix2.preTranslate(f10, f7);
        matrix2.preRotate(b());
        c1376a.getClass();
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int i6 = c1376a.f;
        int[] iArr = C1376a.i;
        iArr[0] = i6;
        iArr[1] = c1376a.e;
        iArr[2] = c1376a.d;
        Paint paint = c1376a.c;
        float f11 = rectF.left;
        paint.setShader(new LinearGradient(f11, rectF.top, f11, rectF.bottom, iArr, C1376a.f4287j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        w wVar = this.c;
        return (float) Math.toDegrees(Math.atan((wVar.c - this.e) / (wVar.b - this.d)));
    }
}
