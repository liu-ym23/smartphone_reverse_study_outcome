package Cc;

import Cc.i;
import Ec.d;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* loaded from: classes5.dex */
public class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final RectF f1958a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final Paint f1959b;

    /* renamed from: c, reason: collision with root package name */
    public Canvas f1960c;

    /* renamed from: d, reason: collision with root package name */
    public c f1961d;

    /* renamed from: e, reason: collision with root package name */
    public j f1962e;

    /* renamed from: f, reason: collision with root package name */
    public e f1963f;

    /* renamed from: g, reason: collision with root package name */
    public Ec.a f1964g;

    public a() {
        Paint paint = new Paint(1);
        this.f1959b = paint;
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setStrokeJoin(Paint.Join.MITER);
    }

    @Override // Cc.f
    public e a() {
        return this.f1963f;
    }

    @Override // Cc.f
    public void b(char[] cArr, int i10, int i11, int i12, int i13) {
        e eVar = this.f1963f;
        if (eVar != null) {
            this.f1959b.setTypeface(eVar.g());
            this.f1959b.setTextSize(this.f1963f.e());
        }
        this.f1960c.drawText(cArr, i10, i11, i12, i13, this.f1959b);
    }

    @Override // Cc.f
    public Ec.a c() {
        Ec.a aVarJ = this.f1964g.j();
        this.f1964g = aVarJ;
        return aVarJ;
    }

    @Override // Cc.f
    public void d(c cVar) {
        this.f1961d = cVar;
        this.f1959b.setColor(cVar.b());
    }

    @Override // Cc.f
    public void e(double d10, double d11) {
        this.f1964g.k(d10, d11);
    }

    @Override // Cc.f
    public void f(Ec.a aVar) {
        if (this.f1960c != aVar.f()) {
            throw new IllegalStateException("Supplied transform has different Canvas attached");
        }
        this.f1964g = aVar.i();
    }

    @Override // Cc.f
    public void g(i iVar) {
    }

    @Override // Cc.f
    public void h(d.a aVar) {
        this.f1959b.setStyle(Paint.Style.STROKE);
        Canvas canvas = this.f1960c;
        float f10 = aVar.f2513a;
        float f11 = aVar.f2514b;
        canvas.drawRect(f10, f11, f10 + aVar.f2515c, f11 + aVar.f2516d, this.f1959b);
    }

    @Override // Cc.f
    public j i() {
        if (this.f1962e == null) {
            this.f1962e = new b(this.f1959b.getStrokeWidth(), 0, 0, this.f1959b.getStrokeMiter());
        }
        return this.f1962e;
    }

    @Override // Cc.f
    public void j(d.a aVar) {
        this.f1959b.setStyle(Paint.Style.FILL);
        Canvas canvas = this.f1960c;
        float f10 = aVar.f2513a;
        float f11 = aVar.f2514b;
        canvas.drawRect(f10, f11, f10 + aVar.f2515c, f11 + aVar.f2516d, this.f1959b);
    }

    @Override // Cc.f
    public c k() {
        if (this.f1961d == null) {
            this.f1961d = new c(this.f1959b.getColor());
        }
        return this.f1961d;
    }

    @Override // Cc.f
    public void l(double d10, double d11) {
        this.f1964g.p((float) d10, (float) d11);
    }

    @Override // Cc.f
    public void m(i.a aVar, Object obj) {
    }

    @Override // Cc.f
    public void n(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f1959b.setStyle(Paint.Style.FILL);
        this.f1958a.set(i10, i11, i10 + i12, i11 + i13);
        this.f1960c.drawArc(this.f1958a, i14, i15, false, this.f1959b);
    }

    @Override // Cc.f
    public void o(double d10) {
        this.f1960c.rotate((float) Math.toDegrees(d10));
    }

    @Override // Cc.f
    public void p(double d10, double d11, double d12) {
        this.f1960c.rotate((float) Math.toDegrees(d10), (float) d11, (float) d12);
    }

    @Override // Cc.f
    public i q() {
        return null;
    }

    @Override // Cc.f
    public void r(Ec.e eVar) {
        this.f1959b.setStyle(Paint.Style.STROKE);
        RectF rectF = this.f1958a;
        float f10 = eVar.f2517a;
        float f11 = eVar.f2518b;
        rectF.set(f10, f11, eVar.f2519c + f10, eVar.f2520d + f11);
        this.f1960c.drawRoundRect(this.f1958a, eVar.f2521e, eVar.f2522f, this.f1959b);
    }

    @Override // Cc.f
    public void s(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f1959b.setStyle(Paint.Style.STROKE);
        this.f1958a.set(i10, i11, i10 + i12, i11 + i13);
        this.f1960c.drawArc(this.f1958a, i14, i15, false, this.f1959b);
    }

    @Override // Cc.f
    public void t(Ec.b bVar) {
        this.f1959b.setStyle(Paint.Style.STROKE);
        this.f1960c.drawLine((float) bVar.f2507a, (float) bVar.f2508b, (float) bVar.f2509c, (float) bVar.f2510d, this.f1959b);
    }

    @Override // Cc.f
    public void u(e eVar) {
        this.f1963f = eVar;
    }

    @Override // Cc.f
    public void v(j jVar) {
        this.f1962e = jVar;
        this.f1959b.setStrokeWidth(jVar.a());
    }

    public void w(Canvas canvas) {
        this.f1960c = canvas;
        this.f1964g = Ec.a.d(canvas);
    }
}
