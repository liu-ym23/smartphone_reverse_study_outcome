package u0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;

/* loaded from: classes.dex */
public final class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public Canvas f9869a = b.f9888a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f9870b;

    /* renamed from: c, reason: collision with root package name */
    public Rect f9871c;

    @Override // u0.l
    public final void a(f fVar) {
        Canvas canvas = this.f9869a;
        if (!(fVar instanceof f)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(fVar.f9903a, Region.Op.INTERSECT);
    }

    @Override // u0.l
    public final void b(float f10, float f11, float f12, float f13, float f14, float f15, h4.s sVar) {
        this.f9869a.drawRoundRect(f10, f11, f12, f13, f14, f15, (Paint) sVar.f4155g);
    }

    @Override // u0.l
    public final void c(float f10, float f11) {
        this.f9869a.scale(f10, f11);
    }

    @Override // u0.l
    public final void d(long j2, long j4, h4.s sVar) {
        this.f9869a.drawLine(Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), (Paint) sVar.f4155g);
    }

    @Override // u0.l
    public final void e(float f10, float f11, float f12, float f13, int i2) {
        this.f9869a.clipRect(f10, f11, f12, f13, i2 == 0 ? Region.Op.DIFFERENCE : Region.Op.INTERSECT);
    }

    @Override // u0.l
    public final void f(float f10, float f11) {
        this.f9869a.translate(f10, f11);
    }

    @Override // u0.l
    public final void g() {
        this.f9869a.restore();
    }

    @Override // u0.l
    public final void h() {
        this.f9869a.save();
    }

    @Override // u0.l
    public final void i() {
        this.f9869a.disableZ();
    }

    @Override // u0.l
    public final void j(float f10, float f11, float f12, float f13, float f14, float f15, h4.s sVar) {
        this.f9869a.drawArc(f10, f11, f12, f13, f14, f15, false, (Paint) sVar.f4155g);
    }

    @Override // u0.l
    public final void k(f fVar, h4.s sVar) {
        Canvas canvas = this.f9869a;
        if (!(fVar instanceof f)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(fVar.f9903a, (Paint) sVar.f4155g);
    }

    @Override // u0.l
    public final void l(float f10, float f11, float f12, float f13, h4.s sVar) {
        this.f9869a.drawRect(f10, f11, f12, f13, (Paint) sVar.f4155g);
    }

    @Override // u0.l
    public final void m() {
        this.f9869a.enableZ();
    }

    @Override // u0.l
    public final void n(d dVar, long j2, long j4, h4.s sVar) {
        if (this.f9870b == null) {
            this.f9870b = new Rect();
            this.f9871c = new Rect();
        }
        Canvas canvas = this.f9869a;
        if (dVar == null) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
        }
        Bitmap bitmap = dVar.f9894a;
        Rect rect = this.f9870b;
        q7.k.b(rect);
        int i2 = (int) 0;
        rect.left = i2;
        int i10 = (int) 0;
        rect.top = i10;
        rect.right = ((int) (j2 >> 32)) + i2;
        rect.bottom = ((int) (j2 & 4294967295L)) + i10;
        Rect rect2 = this.f9871c;
        q7.k.b(rect2);
        rect2.left = i2;
        rect2.top = i10;
        rect2.right = i2 + ((int) (j4 >> 32));
        rect2.bottom = i10 + ((int) (j4 & 4294967295L));
        canvas.drawBitmap(bitmap, rect, rect2, (Paint) sVar.f4155g);
    }

    @Override // u0.l
    public final void o(float f10, long j2, h4.s sVar) {
        this.f9869a.drawCircle(Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), f10, (Paint) sVar.f4155g);
    }
}
