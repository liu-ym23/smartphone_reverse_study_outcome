package d1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements o {

    /* renamed from: a, reason: collision with root package name */
    public Canvas f2954a = b.f2958a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f2955b;

    /* renamed from: c, reason: collision with root package name */
    public Rect f2956c;

    @Override // d1.o
    public final void a(h hVar) {
        Canvas canvas = this.f2954a;
        if (hVar instanceof h) {
            canvas.clipPath(hVar.f2990a, Region.Op.INTERSECT);
        } else {
            g5.f.o("Unable to obtain android.graphics.Path");
        }
    }

    @Override // d1.o
    public final void b(float f5, float f10, float f11, float f12, f fVar) {
        this.f2954a.drawRect(f5, f10, f11, f12, (Paint) fVar.f2968b);
    }

    @Override // d1.o
    public final void c(float f5, float f10) {
        this.f2954a.scale(f5, f10);
    }

    @Override // d1.o
    public final void d(h hVar, f fVar) {
        Canvas canvas = this.f2954a;
        if (hVar instanceof h) {
            canvas.drawPath(hVar.f2990a, (Paint) fVar.f2968b);
        } else {
            g5.f.o("Unable to obtain android.graphics.Path");
        }
    }

    @Override // d1.o
    public final void f(float f5, float f10, float f11, float f12, float f13, float f14, f fVar) {
        this.f2954a.drawRoundRect(f5, f10, f11, f12, f13, f14, (Paint) fVar.f2968b);
    }

    @Override // d1.o
    public final void g(long j10, long j11, f fVar) {
        this.f2954a.drawLine(Float.intBitsToFloat((int) (j10 >> 32)), Float.intBitsToFloat((int) (j10 & 4294967295L)), Float.intBitsToFloat((int) (j11 >> 32)), Float.intBitsToFloat((int) (j11 & 4294967295L)), (Paint) fVar.f2968b);
    }

    @Override // d1.o
    public final void h(float f5, float f10, float f11, float f12, float f13, float f14, f fVar) {
        this.f2954a.drawArc(f5, f10, f11, f12, f13, f14, false, (Paint) fVar.f2968b);
    }

    @Override // d1.o
    public final void i() {
        this.f2954a.save();
    }

    @Override // d1.o
    public final void j() {
        this.f2954a.disableZ();
    }

    @Override // d1.o
    public final void k(float[] fArr) {
        if (f0.j(fArr)) {
            return;
        }
        Matrix matrix = new Matrix();
        float f5 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = fArr[3];
        float f13 = fArr[4];
        float f14 = fArr[5];
        float f15 = fArr[6];
        float f16 = fArr[7];
        float f17 = fArr[8];
        float f18 = fArr[12];
        float f19 = fArr[13];
        float f20 = fArr[15];
        fArr[0] = f5;
        fArr[1] = f13;
        fArr[2] = f18;
        fArr[3] = f10;
        fArr[4] = f14;
        fArr[5] = f19;
        fArr[6] = f12;
        fArr[7] = f16;
        fArr[8] = f20;
        matrix.setValues(fArr);
        fArr[0] = f5;
        fArr[1] = f10;
        fArr[2] = f11;
        fArr[3] = f12;
        fArr[4] = f13;
        fArr[5] = f14;
        fArr[6] = f15;
        fArr[7] = f16;
        fArr[8] = f17;
        this.f2954a.concat(matrix);
    }

    @Override // d1.o
    public final void l(c1.c cVar, f fVar) {
        this.f2954a.saveLayer(cVar.f2167a, cVar.f2168b, cVar.f2169c, cVar.f2170d, (Paint) fVar.f2968b, 31);
    }

    @Override // d1.o
    public final void m(float f5, float f10, float f11, float f12, int i) {
        this.f2954a.clipRect(f5, f10, f11, f12, i == 0 ? Region.Op.DIFFERENCE : Region.Op.INTERSECT);
    }

    @Override // d1.o
    public final void n(float f5, float f10) {
        this.f2954a.translate(f5, f10);
    }

    @Override // d1.o
    public final void o() {
        this.f2954a.restore();
    }

    @Override // d1.o
    public final void p() {
        this.f2954a.enableZ();
    }

    @Override // d1.o
    public final void q(float f5, long j10, f fVar) {
        this.f2954a.drawCircle(Float.intBitsToFloat((int) (j10 >> 32)), Float.intBitsToFloat((int) (j10 & 4294967295L)), f5, (Paint) fVar.f2968b);
    }

    @Override // d1.o
    public final void r(e eVar, long j10, long j11, long j12, f fVar) {
        if (this.f2955b == null) {
            this.f2955b = new Rect();
            this.f2956c = new Rect();
        }
        Canvas canvas = this.f2954a;
        if (!(eVar instanceof e)) {
            g5.f.o("Unable to obtain android.graphics.Bitmap");
            return;
        }
        Bitmap bitmap = eVar.f2966a;
        Rect rect = this.f2955b;
        rect.getClass();
        int i = (int) (j10 >> 32);
        rect.left = i;
        int i3 = (int) (j10 & 4294967295L);
        rect.top = i3;
        rect.right = i + ((int) (j11 >> 32));
        rect.bottom = i3 + ((int) (j11 & 4294967295L));
        Rect rect2 = this.f2956c;
        rect2.getClass();
        int i10 = (int) 0;
        rect2.left = i10;
        int i11 = (int) 0;
        rect2.top = i11;
        rect2.right = i10 + ((int) (j12 >> 32));
        rect2.bottom = i11 + ((int) (j12 & 4294967295L));
        canvas.drawBitmap(bitmap, rect, rect2, (Paint) fVar.f2968b);
    }
}
