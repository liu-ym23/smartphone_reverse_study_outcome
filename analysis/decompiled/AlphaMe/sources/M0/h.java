package M0;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.v;
import com.airbnb.lottie.z;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class h extends b {

    /* renamed from: A, reason: collision with root package name */
    public H0.j f1415A;

    /* renamed from: v, reason: collision with root package name */
    public final RectF f1416v;

    /* renamed from: w, reason: collision with root package name */
    public final Paint f1417w;

    /* renamed from: x, reason: collision with root package name */
    public final float[] f1418x;

    /* renamed from: y, reason: collision with root package name */
    public final Path f1419y;

    /* renamed from: z, reason: collision with root package name */
    public final e f1420z;

    public h(v vVar, e eVar) {
        super(vVar, eVar);
        this.f1416v = new RectF();
        Paint paint = new Paint();
        this.f1417w = paint;
        this.f1418x = new float[8];
        this.f1419y = new Path();
        this.f1420z = eVar;
        paint.setAlpha(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(eVar.f1404l);
    }

    @Override // M0.b, J0.f
    public final void f(Object obj, Q0.b bVar) {
        super.f(obj, bVar);
        if (obj == z.f4607t) {
            if (bVar == null) {
                this.f1415A = null;
            } else {
                this.f1415A = new H0.j(bVar);
            }
        }
    }

    @Override // M0.b, G0.e
    public final void h(RectF rectF, Matrix matrix) {
        super.h(rectF, matrix);
        RectF rectF2 = this.f1416v;
        e eVar = this.f1420z;
        rectF2.set(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, eVar.f1402j, eVar.f1403k);
        this.f1373l.mapRect(rectF2);
        rectF.set(rectF2);
    }

    @Override // M0.b
    public final void k(Canvas canvas, Matrix matrix, int i4) {
        e eVar = this.f1420z;
        int iAlpha = Color.alpha(eVar.f1404l);
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((((iAlpha / 255.0f) * ((Integer) ((H0.b) this.f1381t.f13801f).e()).intValue()) / 100.0f) * (i4 / 255.0f) * 255.0f);
        Paint paint = this.f1417w;
        paint.setAlpha(iIntValue);
        H0.j jVar = this.f1415A;
        if (jVar != null) {
            paint.setColorFilter((ColorFilter) jVar.e());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f1418x;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            float f4 = eVar.f1402j;
            fArr[2] = f4;
            fArr[3] = 0.0f;
            fArr[4] = f4;
            float f5 = eVar.f1403k;
            fArr[5] = f5;
            fArr[6] = 0.0f;
            fArr[7] = f5;
            matrix.mapPoints(fArr);
            Path path = this.f1419y;
            path.reset();
            path.moveTo(fArr[0], fArr[1]);
            path.lineTo(fArr[2], fArr[3]);
            path.lineTo(fArr[4], fArr[5]);
            path.lineTo(fArr[6], fArr[7]);
            path.lineTo(fArr[0], fArr[1]);
            path.close();
            canvas.drawPath(path, paint);
        }
    }
}
