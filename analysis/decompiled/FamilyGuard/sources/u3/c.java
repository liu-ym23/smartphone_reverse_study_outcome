package u3;

import P.e;
import V3.v;
import android.animation.ValueAnimator;
import i4.InterfaceC0761a;
import i4.InterfaceC0772l;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0772l<? super Float, v> f22869a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC0772l<? super Integer, v> f22870b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0772l<? super Integer, v> f22871c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC0761a<v> f22872d;

    /* renamed from: e, reason: collision with root package name */
    private int f22873e;

    /* renamed from: i, reason: collision with root package name */
    private int f22877i;

    /* renamed from: k, reason: collision with root package name */
    private final P.g f22879k;

    /* renamed from: l, reason: collision with root package name */
    private final P.i f22880l;

    /* renamed from: f, reason: collision with root package name */
    private float f22874f = 1.0f;

    /* renamed from: g, reason: collision with root package name */
    private int f22875g = 1;

    /* renamed from: h, reason: collision with root package name */
    private int f22876h = 1;

    /* renamed from: j, reason: collision with root package name */
    private int f22878j = 1;

    public c() {
        P.g gVar = new P.g(1.0f);
        this.f22879k = gVar;
        P.i iVar = new P.i(gVar);
        iVar.x(new P.j().f(1.0f).h(1500.0f));
        iVar.k(0.001f);
        iVar.c(new e.r() { // from class: u3.a
            @Override // P.e.r
            public final void a(P.e eVar, float f5, float f6) {
                c.q(this.f22867a, eVar, f5, f6);
            }
        });
        iVar.b(new e.q() { // from class: u3.b
            @Override // P.e.q
            public final void a(P.e eVar, boolean z5, float f5, float f6) {
                c.r(this.f22868a, eVar, z5, f5, f6);
            }
        });
        this.f22880l = iVar;
    }

    private final void l(float f5) {
        this.f22874f = f5;
        this.f22879k.b(f5);
        InterfaceC0772l<? super Float, v> interfaceC0772l = this.f22869a;
        if (interfaceC0772l != null) {
            interfaceC0772l.invoke(Float.valueOf(f5));
        }
    }

    private final void o(int i5) {
        if (this.f22877i == i5) {
            return;
        }
        this.f22877i = i5;
        InterfaceC0772l<? super Integer, v> interfaceC0772l = this.f22871c;
        if (interfaceC0772l != null) {
            interfaceC0772l.invoke(Integer.valueOf(i5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(c cVar, P.e eVar, float f5, float f6) {
        cVar.l(kotlin.ranges.l.g(f5, 0.0f, 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(c cVar, P.e eVar, boolean z5, float f5, float f6) {
        if (z5) {
            return;
        }
        cVar.l(cVar.f22876h);
        cVar.f22875g = cVar.f22876h;
        cVar.o(0);
        InterfaceC0772l<? super Integer, v> interfaceC0772l = cVar.f22870b;
        if (interfaceC0772l != null) {
            interfaceC0772l.invoke(Integer.valueOf(cVar.f22875g));
        }
    }

    public final void c() {
        if (this.f22877i == 1) {
            return;
        }
        this.f22880l.d();
        int i5 = this.f22873e;
        this.f22878j = i5 != 0 ? k.f22912a.a(i5) : this.f22874f < 0.5f ? 0 : 1;
        o(1);
    }

    public final void d() {
        p(this.f22875g, true);
    }

    public final void e() {
        this.f22880l.d();
        this.f22869a = null;
        this.f22870b = null;
        this.f22871c = null;
        this.f22872d = null;
    }

    public final float f(float f5, e eVar, boolean z5) {
        j4.k.g(eVar, "geometry");
        c();
        float fD = eVar.d(this.f22874f);
        l(kotlin.ranges.l.g(eVar.c(f5 + fD), g(), k.f22912a.b(this.f22878j, z5, this.f22873e)));
        return eVar.d(this.f22874f) - fD;
    }

    public final float g() {
        return k.f22912a.c(this.f22873e);
    }

    public final int h() {
        return this.f22873e;
    }

    public final int i() {
        return this.f22877i;
    }

    public final float j() {
        return this.f22874f;
    }

    public final int k() {
        return this.f22876h;
    }

    public final void m(float f5, float f6, boolean z5) {
        InterfaceC0761a<v> interfaceC0761a;
        if (this.f22877i != 1) {
            return;
        }
        int iD = k.f22912a.d(this.f22878j, this.f22874f, f5, f6, z5, this.f22873e);
        if (iD != 2 || (interfaceC0761a = this.f22872d) == null) {
            p(iD, true);
        } else if (interfaceC0761a != null) {
            interfaceC0761a.invoke();
        }
    }

    public final void n(int i5) {
        this.f22880l.d();
        this.f22875g = i5;
        this.f22876h = i5;
        l(i5);
        o(0);
    }

    public final void p(int i5, boolean z5) {
        this.f22880l.d();
        this.f22876h = i5;
        if (z5 && ValueAnimator.areAnimatorsEnabled()) {
            float f5 = i5;
            if (Math.abs(this.f22874f - f5) >= 0.001f) {
                this.f22879k.b(this.f22874f);
                o(2);
                this.f22880l.s(f5);
                return;
            }
        }
        n(i5);
        InterfaceC0772l<? super Integer, v> interfaceC0772l = this.f22870b;
        if (interfaceC0772l != null) {
            interfaceC0772l.invoke(Integer.valueOf(i5));
        }
    }
}
