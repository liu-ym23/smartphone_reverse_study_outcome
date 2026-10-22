package Ec;

import android.graphics.Canvas;

/* loaded from: classes5.dex */
public class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final a f2500a;

    /* renamed from: b, reason: collision with root package name */
    public final Canvas f2501b;

    /* renamed from: c, reason: collision with root package name */
    public int f2502c = -1;

    /* renamed from: d, reason: collision with root package name */
    public double f2503d = 1.0d;

    /* renamed from: e, reason: collision with root package name */
    public double f2504e = 1.0d;

    /* renamed from: f, reason: collision with root package name */
    public float f2505f;

    /* renamed from: g, reason: collision with root package name */
    public float f2506g;

    public a(a aVar, Canvas canvas) {
        this.f2500a = aVar;
        this.f2501b = canvas;
    }

    public static a d(Canvas canvas) {
        return new a(null, canvas);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        a aVar = new a(this, this.f2501b);
        aVar.n(this.f2503d, this.f2504e);
        aVar.o(this.f2505f, this.f2506g);
        aVar.f2502c = this.f2501b.save();
        return aVar;
    }

    public Canvas f() {
        return this.f2501b;
    }

    public double g() {
        return this.f2503d;
    }

    public double h() {
        return this.f2504e;
    }

    public a i() {
        int i10 = this.f2502c;
        if (i10 != -1) {
            this.f2501b.restoreToCount(i10);
            this.f2502c = -1;
        }
        a aVar = this.f2500a;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("Cannot restore root transform instance");
    }

    public a j() {
        a aVar = new a(this, this.f2501b);
        aVar.n(this.f2503d, this.f2504e);
        aVar.o(this.f2505f, this.f2506g);
        aVar.f2502c = this.f2501b.save();
        return aVar;
    }

    public void k(double d10, double d11) {
        n(d10, d11);
        this.f2501b.scale((float) d10, (float) d11);
    }

    public void n(double d10, double d11) {
        this.f2503d = d10;
        this.f2504e = d11;
    }

    public void o(float f10, float f11) {
        this.f2505f = f10;
        this.f2506g = f11;
    }

    public void p(float f10, float f11) {
        this.f2501b.translate(f10, f11);
        o(f10, f11);
    }
}
