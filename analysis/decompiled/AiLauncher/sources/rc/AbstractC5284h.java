package rc;

import Ec.d;
import java.util.LinkedList;

/* renamed from: rc.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5284h {

    /* renamed from: m, reason: collision with root package name */
    public static boolean f39301m = false;

    /* renamed from: a, reason: collision with root package name */
    public Cc.c f39302a;

    /* renamed from: b, reason: collision with root package name */
    public Cc.c f39303b;

    /* renamed from: c, reason: collision with root package name */
    public Cc.c f39304c;

    /* renamed from: d, reason: collision with root package name */
    public float f39305d;

    /* renamed from: e, reason: collision with root package name */
    public float f39306e;

    /* renamed from: f, reason: collision with root package name */
    public float f39307f;

    /* renamed from: g, reason: collision with root package name */
    public float f39308g;

    /* renamed from: h, reason: collision with root package name */
    public int f39309h;

    /* renamed from: i, reason: collision with root package name */
    public LinkedList<AbstractC5284h> f39310i;

    /* renamed from: j, reason: collision with root package name */
    public AbstractC5284h f39311j;

    /* renamed from: k, reason: collision with root package name */
    public AbstractC5284h f39312k;

    /* renamed from: l, reason: collision with root package name */
    public Cc.c f39313l;

    public AbstractC5284h() {
        this(null, null);
    }

    public void a(int i10, AbstractC5284h abstractC5284h) {
        this.f39310i.add(i10, abstractC5284h);
        abstractC5284h.f39311j = this;
        abstractC5284h.f39312k = this.f39312k;
    }

    public void b(AbstractC5284h abstractC5284h) {
        this.f39310i.add(abstractC5284h);
        abstractC5284h.f39311j = this;
        abstractC5284h.f39312k = this.f39312k;
    }

    public abstract void c(Cc.f fVar, float f10, float f11);

    public void d(Cc.f fVar, float f10, float f11) {
        if (f39301m) {
            e(fVar, f10, f11, true);
        }
    }

    public void e(Cc.f fVar, float f10, float f11, boolean z10) {
        if (f39301m) {
            Cc.j jVarI = fVar.i();
            if (this.f39313l != null) {
                Cc.c cVarK = fVar.k();
                fVar.d(this.f39313l);
                float f12 = this.f39306e;
                fVar.j(new d.a(f10, f11 - f12, this.f39305d, f12 + this.f39307f));
                fVar.d(cVarK);
            }
            fVar.v(new Cc.b((float) Math.abs(1.0d / fVar.c().g()), 0, 0));
            float f13 = this.f39305d;
            if (f13 < 0.0f) {
                f10 += f13;
                this.f39305d = -f13;
            }
            float f14 = this.f39306e;
            fVar.h(new d.a(f10, f11 - f14, this.f39305d, f14 + this.f39307f));
            if (z10) {
                Cc.c cVarK2 = fVar.k();
                fVar.d(Cc.c.f1976k);
                float f15 = this.f39307f;
                if (f15 > 0.0f) {
                    fVar.j(new d.a(f10, f11, this.f39305d, f15));
                    fVar.d(cVarK2);
                    fVar.h(new d.a(f10, f11, this.f39305d, this.f39307f));
                } else if (f15 < 0.0f) {
                    fVar.j(new d.a(f10, f11 + f15, this.f39305d, -f15));
                    fVar.d(cVarK2);
                    float f16 = this.f39307f;
                    fVar.h(new d.a(f10, f11 + f16, this.f39305d, -f16));
                } else {
                    fVar.d(cVarK2);
                }
            }
            fVar.v(jVarI);
        }
    }

    public void f(Cc.f fVar) {
        fVar.d(this.f39304c);
    }

    public float g() {
        return this.f39307f;
    }

    public float h() {
        return this.f39306e;
    }

    public abstract int i();

    public float j() {
        return this.f39308g;
    }

    public float k() {
        return this.f39305d;
    }

    public void l() {
        this.f39305d = -this.f39305d;
    }

    public void m(float f10) {
        this.f39307f = f10;
    }

    public void n(float f10) {
        this.f39306e = f10;
    }

    public void o(float f10) {
        this.f39308g = f10;
    }

    public void p(float f10) {
        this.f39305d = f10;
    }

    public void q(Cc.f fVar, float f10, float f11) {
        this.f39304c = fVar.k();
        Cc.c cVar = this.f39303b;
        if (cVar != null) {
            fVar.d(cVar);
            float f12 = this.f39306e;
            fVar.j(new d.a(f10, f11 - f12, this.f39305d, f12 + this.f39307f));
        }
        Cc.c cVar2 = this.f39302a;
        if (cVar2 == null) {
            fVar.d(this.f39304c);
        } else {
            fVar.d(cVar2);
        }
        d(fVar, f10, f11);
    }

    public AbstractC5284h(Cc.c cVar, Cc.c cVar2) {
        this.f39305d = 0.0f;
        this.f39306e = 0.0f;
        this.f39307f = 0.0f;
        this.f39308g = 0.0f;
        this.f39309h = -1;
        this.f39310i = new LinkedList<>();
        this.f39302a = cVar;
        this.f39303b = cVar2;
    }
}
