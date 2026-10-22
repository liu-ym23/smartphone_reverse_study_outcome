package y1;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.stepos.alphame.utils.Property;
import x1.C0980a;

/* loaded from: classes.dex */
public final class s extends w {

    /* renamed from: c, reason: collision with root package name */
    public final u f16300c;

    /* renamed from: d, reason: collision with root package name */
    public final float f16301d;

    /* renamed from: e, reason: collision with root package name */
    public final float f16302e;

    public s(u uVar, float f4, float f5) {
        this.f16300c = uVar;
        this.f16301d = f4;
        this.f16302e = f5;
    }

    @Override // y1.w
    public final void a(Matrix matrix, C0980a c0980a, int i4, Canvas canvas) {
        u uVar = this.f16300c;
        float f4 = uVar.f16311c;
        float f5 = this.f16302e;
        float f6 = uVar.f16310b;
        float f7 = this.f16301d;
        RectF rectF = new RectF(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, (float) Math.hypot(f4 - f5, f6 - f7), Property.DEFAULT_FLOAT_VALUE);
        Matrix matrix2 = this.f16314a;
        matrix2.set(matrix);
        matrix2.preTranslate(f7, f5);
        matrix2.preRotate(b());
        c0980a.getClass();
        rectF.bottom += i4;
        rectF.offset(Property.DEFAULT_FLOAT_VALUE, -i4);
        int[] iArr = C0980a.f15889i;
        iArr[0] = c0980a.f15898f;
        iArr[1] = c0980a.f15897e;
        iArr[2] = c0980a.f15896d;
        Paint paint = c0980a.f15895c;
        float f8 = rectF.left;
        paint.setShader(new LinearGradient(f8, rectF.top, f8, rectF.bottom, iArr, C0980a.f15890j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        u uVar = this.f16300c;
        return (float) Math.toDegrees(Math.atan((uVar.f16311c - this.f16302e) / (uVar.f16310b - this.f16301d)));
    }
}
