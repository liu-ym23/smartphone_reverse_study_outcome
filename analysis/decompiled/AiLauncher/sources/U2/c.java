package U2;

import U2.k;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import java.util.ArrayList;
import w0.C5715a;

/* loaded from: classes2.dex */
public final class c extends k<f> {

    /* renamed from: f, reason: collision with root package name */
    public float f6184f;

    /* renamed from: g, reason: collision with root package name */
    public float f6185g;

    /* renamed from: h, reason: collision with root package name */
    public float f6186h;

    /* renamed from: i, reason: collision with root package name */
    public float f6187i;

    /* renamed from: j, reason: collision with root package name */
    public float f6188j;

    /* renamed from: k, reason: collision with root package name */
    public float f6189k;

    /* renamed from: l, reason: collision with root package name */
    public int f6190l;

    /* renamed from: m, reason: collision with root package name */
    public float f6191m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6192n;

    /* renamed from: o, reason: collision with root package name */
    public float f6193o;

    /* renamed from: p, reason: collision with root package name */
    public final RectF f6194p;

    /* renamed from: q, reason: collision with root package name */
    public final Pair<k<f>.b, k<f>.b> f6195q;

    public c(f fVar) {
        super(fVar);
        this.f6194p = new RectF();
        this.f6195q = new Pair<>(new k.b(), new k.b());
    }

    @Override // U2.k
    public void a(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11) {
        float fWidth = rect.width() / f();
        float fHeight = rect.height() / e();
        S s10 = this.f6265a;
        float f11 = (((f) s10).f6227p / 2.0f) + ((f) s10).f6228q;
        canvas.translate((f11 * fWidth) + rect.left, (f11 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (((f) this.f6265a).f6229r != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f12 = -f11;
        canvas.clipRect(f12, f12, f11, f11);
        S s11 = this.f6265a;
        this.f6184f = ((f) s11).f6170a * f10;
        this.f6185g = Math.min(((f) s11).f6170a / 2, ((f) s11).a()) * f10;
        S s12 = this.f6265a;
        this.f6186h = ((f) s12).f6181l * f10;
        float f13 = (((f) s12).f6227p - ((f) s12).f6170a) / 2.0f;
        this.f6187i = f13;
        if (z10 || z11) {
            float f14 = ((1.0f - f10) * ((f) s12).f6170a) / 2.0f;
            if ((z10 && ((f) s12).f6176g == 2) || (z11 && ((f) s12).f6177h == 1)) {
                this.f6187i = f13 + f14;
            } else if ((z10 && ((f) s12).f6176g == 1) || (z11 && ((f) s12).f6177h == 2)) {
                this.f6187i = f13 - f14;
            }
        }
        if (z11 && ((f) s12).f6177h == 3) {
            this.f6193o = f10;
        } else {
            this.f6193o = 1.0f;
        }
    }

    @Override // U2.k
    public void b(Canvas canvas, Paint paint, int i10, int i11) {
    }

    @Override // U2.k
    public void c(Canvas canvas, Paint paint, k.a aVar, int i10) {
        int iA = M2.a.a(aVar.f6272c, i10);
        canvas.save();
        canvas.rotate(aVar.f6276g);
        this.f6192n = aVar.f6277h;
        float f10 = aVar.f6270a;
        float f11 = aVar.f6271b;
        int i11 = aVar.f6273d;
        m(canvas, paint, f10, f11, iA, i11, i11, aVar.f6274e, aVar.f6275f, true);
        canvas.restore();
    }

    @Override // U2.k
    public void d(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12) {
        int iA = M2.a.a(i10, i11);
        this.f6192n = false;
        m(canvas, paint, f10, f11, iA, i12, i12, 0.0f, 0.0f, false);
    }

    @Override // U2.k
    public int e() {
        return p();
    }

    @Override // U2.k
    public int f() {
        return p();
    }

    @Override // U2.k
    public void g() {
        this.f6266b.rewind();
        this.f6266b.moveTo(1.0f, 0.0f);
        for (int i10 = 0; i10 < 2; i10++) {
            this.f6266b.cubicTo(1.0f, 0.5522848f, 0.5522848f, 1.0f, 0.0f, 1.0f);
            this.f6266b.cubicTo(-0.5522848f, 1.0f, -1.0f, 0.5522848f, -1.0f, 0.0f);
            this.f6266b.cubicTo(-1.0f, -0.5522848f, -0.5522848f, -1.0f, 0.0f, -1.0f);
            this.f6266b.cubicTo(0.5522848f, -1.0f, 1.0f, -0.5522848f, 1.0f, 0.0f);
        }
        this.f6269e.reset();
        Matrix matrix = this.f6269e;
        float f10 = this.f6187i;
        matrix.setScale(f10, f10);
        this.f6266b.transform(this.f6269e);
        if (((f) this.f6265a).b(this.f6192n)) {
            this.f6268d.setPath(this.f6266b, false);
            l(this.f6268d, this.f6266b, this.f6189k);
        }
        this.f6268d.setPath(this.f6266b, false);
    }

    public final void j(Path path, k<f>.b bVar, k<f>.b bVar2) {
        float f10 = (this.f6188j / 2.0f) * 0.48f;
        k.b bVar3 = new k.b(this, bVar);
        k.b bVar4 = new k.b(this, bVar2);
        bVar3.b(f10);
        bVar4.b(-f10);
        float[] fArr = bVar3.f6278a;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float[] fArr2 = bVar4.f6278a;
        float f13 = fArr2[0];
        float f14 = fArr2[1];
        float[] fArr3 = bVar2.f6278a;
        path.cubicTo(f11, f12, f13, f14, fArr3[0], fArr3[1]);
    }

    public final void k(PathMeasure pathMeasure, Path path, Pair<k<f>.b, k<f>.b> pair, float f10, float f11, float f12, float f13) {
        float f14 = this.f6186h * f12;
        int i10 = this.f6192n ? ((f) this.f6265a).f6179j : ((f) this.f6265a).f6180k;
        float f15 = this.f6187i;
        if (f15 != this.f6191m || (pathMeasure == this.f6268d && (f14 != this.f6189k || i10 != this.f6190l))) {
            this.f6189k = f14;
            this.f6190l = i10;
            this.f6191m = f15;
            g();
        }
        path.rewind();
        float f16 = 0.0f;
        float fA = C5715a.a(f11, 0.0f, 1.0f);
        if (((f) this.f6265a).b(this.f6192n)) {
            float f17 = f13 / ((float) ((this.f6187i * 6.283185307179586d) / this.f6188j));
            f10 += f17;
            f16 = 0.0f - (f17 * 360.0f);
        }
        float f18 = f10 % 1.0f;
        float length = (pathMeasure.getLength() * f18) / 2.0f;
        float length2 = ((f18 + fA) * pathMeasure.getLength()) / 2.0f;
        pathMeasure.getSegment(length, length2, path, true);
        k.b bVar = (k.b) pair.first;
        bVar.c();
        pathMeasure.getPosTan(length, bVar.f6278a, bVar.f6279b);
        k.b bVar2 = (k.b) pair.second;
        bVar2.c();
        pathMeasure.getPosTan(length2, bVar2.f6278a, bVar2.f6279b);
        this.f6269e.reset();
        this.f6269e.setRotate(f16);
        bVar.d(f16);
        bVar2.d(f16);
        path.transform(this.f6269e);
    }

    public final void l(PathMeasure pathMeasure, Path path, float f10) {
        path.rewind();
        float length = pathMeasure.getLength();
        int iMax = Math.max(3, (int) ((length / (this.f6192n ? ((f) this.f6265a).f6179j : ((f) this.f6265a).f6180k)) / 2.0f)) * 2;
        this.f6188j = length / iMax;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < iMax; i10++) {
            k.b bVar = new k.b();
            float f11 = i10;
            pathMeasure.getPosTan(this.f6188j * f11, bVar.f6278a, bVar.f6279b);
            k.b bVar2 = new k.b();
            float f12 = this.f6188j;
            pathMeasure.getPosTan((f11 * f12) + (f12 / 2.0f), bVar2.f6278a, bVar2.f6279b);
            arrayList.add(bVar);
            bVar2.a(f10 * 2.0f);
            arrayList.add(bVar2);
        }
        arrayList.add((k.b) arrayList.get(0));
        k<f>.b bVar3 = (k.b) arrayList.get(0);
        float[] fArr = bVar3.f6278a;
        int i11 = 1;
        path.moveTo(fArr[0], fArr[1]);
        while (i11 < arrayList.size()) {
            k<f>.b bVar4 = (k.b) arrayList.get(i11);
            j(path, bVar3, bVar4);
            i11++;
            bVar3 = bVar4;
        }
    }

    public final void m(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12, float f12, float f13, boolean z10) {
        float f14 = f11 >= f10 ? f11 - f10 : (f11 + 1.0f) - f10;
        float f15 = f10 % 1.0f;
        if (f15 < 0.0f) {
            f15 += 1.0f;
        }
        if (this.f6193o < 1.0f) {
            float f16 = f15 + f14;
            if (f16 > 1.0f) {
                m(canvas, paint, f15, 1.0f, i10, i11, 0, f12, f13, z10);
                m(canvas, paint, 1.0f, f16, i10, 0, i12, f12, f13, z10);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.f6185g / this.f6187i);
        float f17 = f14 - 0.99f;
        if (f17 >= 0.0f) {
            float f18 = ((f17 * degrees) / 180.0f) / 0.01f;
            f14 += f18;
            if (!z10) {
                f15 -= f18 / 2.0f;
            }
        }
        float fD = S2.a.d(1.0f - this.f6193o, 1.0f, f15);
        float fD2 = S2.a.d(0.0f, this.f6193o, f14);
        float degrees2 = (float) Math.toDegrees(i11 / this.f6187i);
        float degrees3 = ((fD2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i12 / this.f6187i));
        float f19 = (fD * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        boolean z11 = ((f) this.f6265a).b(this.f6192n) && z10 && f12 > 0.0f;
        paint.setAntiAlias(true);
        paint.setColor(i10);
        paint.setStrokeWidth(this.f6184f);
        float f20 = this.f6185g * 2.0f;
        float f21 = degrees * 2.0f;
        if (degrees3 < f21) {
            float f22 = degrees3 / f21;
            float f23 = f19 + (degrees * f22);
            k<f>.b bVar = new k.b();
            if (z11) {
                float length = ((f23 / 360.0f) * this.f6268d.getLength()) / 2.0f;
                float f24 = this.f6186h * f12;
                float f25 = this.f6187i;
                if (f25 != this.f6191m || f24 != this.f6189k) {
                    this.f6189k = f24;
                    this.f6191m = f25;
                    g();
                }
                this.f6268d.getPosTan(length, bVar.f6278a, bVar.f6279b);
            } else {
                bVar.d(f23 + 90.0f);
                bVar.a(-this.f6187i);
            }
            paint.setStyle(Paint.Style.FILL);
            o(canvas, paint, bVar, f20, this.f6184f, f22);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(((f) this.f6265a).g() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f26 = f19 + degrees;
        float f27 = degrees3 - f21;
        ((k.b) this.f6195q.first).c();
        ((k.b) this.f6195q.second).c();
        if (z11) {
            k(this.f6268d, this.f6267c, this.f6195q, f26 / 360.0f, f27 / 360.0f, f12, f13);
            canvas.drawPath(this.f6267c, paint);
        } else {
            ((k.b) this.f6195q.first).d(f26 + 90.0f);
            ((k.b) this.f6195q.first).a(-this.f6187i);
            ((k.b) this.f6195q.second).d(f26 + f27 + 90.0f);
            ((k.b) this.f6195q.second).a(-this.f6187i);
            RectF rectF = this.f6194p;
            float f28 = this.f6187i;
            rectF.set(-f28, -f28, f28, f28);
            canvas.drawArc(this.f6194p, f26, f27, false, paint);
        }
        if (((f) this.f6265a).g() || this.f6185g <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        n(canvas, paint, (k.b) this.f6195q.first, f20, this.f6184f);
        n(canvas, paint, (k.b) this.f6195q.second, f20, this.f6184f);
    }

    public final void n(Canvas canvas, Paint paint, k<f>.b bVar, float f10, float f11) {
        o(canvas, paint, bVar, f10, f11, 1.0f);
    }

    public final void o(Canvas canvas, Paint paint, k<f>.b bVar, float f10, float f11, float f12) {
        float fMin = Math.min(f11, this.f6184f);
        float f13 = f10 / 2.0f;
        float fMin2 = Math.min(f13, (this.f6185g * fMin) / this.f6184f);
        RectF rectF = new RectF((-f10) / 2.0f, (-fMin) / 2.0f, f13, fMin / 2.0f);
        canvas.save();
        float[] fArr = bVar.f6278a;
        canvas.translate(fArr[0], fArr[1]);
        canvas.rotate(i(bVar.f6279b));
        canvas.scale(f12, f12);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    public final int p() {
        S s10 = this.f6265a;
        return ((f) s10).f6227p + (((f) s10).f6228q * 2);
    }
}
