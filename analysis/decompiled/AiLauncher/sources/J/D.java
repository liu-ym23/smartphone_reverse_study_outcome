package J;

import D.AbstractC0772i;
import D.C0788z;
import J.C0868x;
import J.d0;
import U.C1042x;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import androidx.camera.core.g;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.l;
import androidx.camera.core.internal.utils.ImageUtil;
import g3.InterfaceFutureC4095a;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class D {

    /* renamed from: f, reason: collision with root package name */
    public static int f3527f;

    /* renamed from: g, reason: collision with root package name */
    public static final S.b f3528g = new S.b();

    /* renamed from: a, reason: collision with root package name */
    public final androidx.camera.core.impl.q f3529a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.camera.core.impl.l f3530b;

    /* renamed from: c, reason: collision with root package name */
    public final C0868x f3531c;

    /* renamed from: d, reason: collision with root package name */
    public final W f3532d;

    /* renamed from: e, reason: collision with root package name */
    public final C0868x.c f3533e;

    public D(androidx.camera.core.impl.q qVar, Size size, CameraCharacteristics cameraCharacteristics, AbstractC0772i abstractC0772i, boolean z10, K k10) {
        M.n.b();
        this.f3529a = qVar;
        this.f3530b = l.a.i(qVar).h();
        C0868x c0868x = new C0868x();
        this.f3531c = c0868x;
        Executor executorM0 = qVar.m0(N.a.c());
        Objects.requireNonNull(executorM0);
        W w10 = new W(executorM0, cameraCharacteristics, abstractC0772i != null ? new C1042x(abstractC0772i) : null);
        this.f3532d = w10;
        ArrayList arrayList = new ArrayList();
        if (qVar.Y() != 0) {
            arrayList.add(32);
            arrayList.add(256);
        } else {
            arrayList.add(Integer.valueOf(i()));
        }
        C0868x.c cVarN = C0868x.c.n(size, qVar.o(), arrayList, z10, qVar.l0(), k10);
        this.f3533e = cVarN;
        w10.s(c0868x.s(cVarN));
    }

    public void a() {
        M.n.b();
        this.f3531c.n();
        this.f3532d.o();
    }

    public final C0858m b(int i10, K.P p10, n0 n0Var, c0 c0Var) {
        ArrayList arrayList = new ArrayList();
        String strValueOf = String.valueOf(p10.hashCode());
        List<androidx.camera.core.impl.m> listA = p10.a();
        Objects.requireNonNull(listA);
        for (androidx.camera.core.impl.m mVar : listA) {
            l.a aVar = new l.a();
            aVar.r(this.f3530b.j());
            aVar.e(this.f3530b.f());
            aVar.a(n0Var.q());
            aVar.f(this.f3533e.l());
            if (this.f3533e.e().size() > 1 && this.f3533e.j() != null) {
                aVar.f(this.f3533e.j());
            }
            boolean zL = l();
            if (zL) {
                DeferrableSurface deferrableSurfaceG = this.f3533e.g();
                Objects.requireNonNull(deferrableSurfaceG);
                aVar.f(deferrableSurfaceG);
            }
            aVar.p(zL);
            if (ImageUtil.h(this.f3533e.d()) || ImageUtil.i(this.f3533e.d())) {
                if (f3528g.a()) {
                    aVar.d(androidx.camera.core.impl.l.f11441i, Integer.valueOf(n0Var.n()));
                }
                aVar.d(androidx.camera.core.impl.l.f11442j, Integer.valueOf(g(n0Var)));
            }
            aVar.e(mVar.a().f());
            aVar.g(strValueOf, Integer.valueOf(mVar.getId()));
            aVar.n(i10);
            aVar.c(this.f3533e.a());
            if (this.f3533e.e().size() > 1 && this.f3533e.i() != null) {
                aVar.c(this.f3533e.i());
            }
            arrayList.add(aVar.h());
        }
        return new C0858m(arrayList, c0Var);
    }

    public final K.P c() {
        K.P pH0 = this.f3529a.h0(C0788z.b());
        Objects.requireNonNull(pH0);
        return pH0;
    }

    public final X d(int i10, K.P p10, n0 n0Var, c0 c0Var, InterfaceFutureC4095a<Void> interfaceFutureC4095a) {
        return new X(p10, n0Var, c0Var, interfaceFutureC4095a, i10);
    }

    public B0.d<C0858m, X> e(n0 n0Var, c0 c0Var, InterfaceFutureC4095a<Void> interfaceFutureC4095a) {
        M.n.b();
        K.P pC = c();
        int i10 = f3527f;
        f3527f = i10 + 1;
        return new B0.d<>(b(i10, pC, n0Var, c0Var), d(i10, pC, n0Var, c0Var, interfaceFutureC4095a));
    }

    public SessionConfig.b f(Size size) {
        SessionConfig.b bVarP = SessionConfig.b.p(this.f3529a, size);
        bVarP.h(this.f3533e.l());
        if (this.f3533e.e().size() > 1 && this.f3533e.j() != null) {
            bVarP.h(this.f3533e.j());
        }
        if (this.f3533e.g() != null) {
            bVarP.u(this.f3533e.g());
        }
        return bVarP;
    }

    public int g(n0 n0Var) {
        return ((n0Var.l() != null) && M.o.g(n0Var.i(), this.f3533e.k())) ? n0Var.h() == 0 ? 100 : 95 : n0Var.k();
    }

    public int h() {
        M.n.b();
        return this.f3531c.i();
    }

    public final int i() {
        Integer num = (Integer) this.f3529a.g(androidx.camera.core.impl.q.f11472V, null);
        if (num != null) {
            return num.intValue();
        }
        Integer num2 = (Integer) this.f3529a.g(androidx.camera.core.impl.r.f11483n, null);
        if (num2 == null || num2.intValue() != 4101) {
            return (num2 == null || num2.intValue() != 32) ? 256 : 32;
        }
        return 4101;
    }

    public void j(d0.a aVar) {
        M.n.b();
        this.f3533e.b().accept(aVar);
    }

    public void k(g.a aVar) {
        M.n.b();
        this.f3531c.r(aVar);
    }

    public final boolean l() {
        return this.f3533e.g() != null;
    }

    public void m(X x10) {
        M.n.b();
        this.f3533e.h().accept(x10);
    }
}
