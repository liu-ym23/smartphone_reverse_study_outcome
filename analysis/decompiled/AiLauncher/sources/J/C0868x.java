package J;

import D.C0761b0;
import J.C0868x;
import J.W;
import J.d0;
import K.AbstractC0889l;
import K.C0874b0;
import K.C0890m;
import K.E0;
import K.InterfaceC0872a0;
import U.C1038t;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.g;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.List;
import java.util.Objects;

/* renamed from: J.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0868x {

    /* renamed from: b, reason: collision with root package name */
    public androidx.camera.core.m f3672b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.camera.core.m f3673c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.camera.core.m f3674d;

    /* renamed from: e, reason: collision with root package name */
    public W.a f3675e;

    /* renamed from: f, reason: collision with root package name */
    public c f3676f;

    /* renamed from: a, reason: collision with root package name */
    public X f3671a = null;

    /* renamed from: g, reason: collision with root package name */
    public J f3677g = null;

    /* renamed from: J.x$a */
    public class a extends AbstractC0889l {
        public a() {
        }

        public static /* synthetic */ void f(a aVar) {
            X x10 = C0868x.this.f3671a;
            if (x10 != null) {
                x10.p();
            }
        }

        public static /* synthetic */ void g(a aVar, int i10) {
            X x10 = C0868x.this.f3671a;
            if (x10 != null) {
                x10.o(i10);
            }
        }

        @Override // K.AbstractC0889l
        public void d(int i10, final int i11) {
            N.a.d().execute(new Runnable() { // from class: J.v
                @Override // java.lang.Runnable
                public final void run() {
                    C0868x.a.g(this.f3668a, i11);
                }
            });
        }

        @Override // K.AbstractC0889l
        public void e(int i10) {
            N.a.d().execute(new Runnable() { // from class: J.w
                @Override // java.lang.Runnable
                public final void run() {
                    C0868x.a.f(this.f3670a);
                }
            });
        }
    }

    /* renamed from: J.x$b */
    public class b implements O.c<Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ X f3679a;

        public b(X x10) {
            this.f3679a = x10;
        }

        @Override // O.c
        public void b(Throwable th) {
            M.n.b();
            if (this.f3679a == C0868x.this.f3671a) {
                C0761b0.o("CaptureNode", "request aborted, id=" + C0868x.this.f3671a.e());
                if (C0868x.this.f3677g != null) {
                    C0868x.this.f3677g.i();
                }
                C0868x.this.f3671a = null;
            }
        }

        @Override // O.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r12) {
        }
    }

    /* renamed from: J.x$c */
    public static abstract class c {

        /* renamed from: b, reason: collision with root package name */
        public AbstractC0889l f3682b;

        /* renamed from: c, reason: collision with root package name */
        public DeferrableSurface f3683c;

        /* renamed from: d, reason: collision with root package name */
        public DeferrableSurface f3684d;

        /* renamed from: a, reason: collision with root package name */
        public AbstractC0889l f3681a = new a();

        /* renamed from: e, reason: collision with root package name */
        public DeferrableSurface f3685e = null;

        /* renamed from: J.x$c$a */
        public class a extends AbstractC0889l {
            public a() {
            }
        }

        public static c n(Size size, int i10, List<Integer> list, boolean z10, D.X x10, K k10) {
            return new C0847b(size, i10, list, z10, x10, k10, new C1038t(), new C1038t());
        }

        public AbstractC0889l a() {
            return this.f3681a;
        }

        public abstract C1038t<d0.a> b();

        public abstract D.X c();

        public abstract int d();

        public abstract List<Integer> e();

        public abstract K f();

        public DeferrableSurface g() {
            return this.f3685e;
        }

        public abstract C1038t<X> h();

        public AbstractC0889l i() {
            return this.f3682b;
        }

        public DeferrableSurface j() {
            return this.f3684d;
        }

        public abstract Size k();

        public DeferrableSurface l() {
            DeferrableSurface deferrableSurface = this.f3683c;
            Objects.requireNonNull(deferrableSurface);
            return deferrableSurface;
        }

        public abstract boolean m();

        public void o(AbstractC0889l abstractC0889l) {
            this.f3681a = abstractC0889l;
        }

        public void p(Surface surface, Size size, int i10) {
            this.f3685e = new C0874b0(surface, size, i10);
        }

        public void q(AbstractC0889l abstractC0889l) {
            this.f3682b = abstractC0889l;
        }

        public void r(Surface surface) {
            B0.h.i(this.f3684d == null, "The secondary surface is already set.");
            this.f3684d = new C0874b0(surface, k(), d());
        }

        public void s(Surface surface) {
            B0.h.i(this.f3683c == null, "The surface is already set.");
            this.f3683c = new C0874b0(surface, k(), d());
        }
    }

    public static /* synthetic */ void a(C0868x c0868x, InterfaceC0872a0 interfaceC0872a0) {
        c0868x.getClass();
        try {
            androidx.camera.core.i iVarD = interfaceC0872a0.d();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("OnImageAvailableListener: mCurrentRequest ID = ");
            X x10 = c0868x.f3671a;
            sb2.append(x10 == null ? null : Integer.valueOf(x10.e()));
            sb2.append(", image.isNull = ");
            sb2.append(iVarD == null);
            C0761b0.a("CaptureNode", sb2.toString());
            if (iVarD != null) {
                c0868x.k(iVarD);
                return;
            }
            X x11 = c0868x.f3671a;
            if (x11 != null) {
                c0868x.p(d0.a.c(x11.e(), new ImageCaptureException(2, "Failed to acquire latest image", null)));
            }
        } catch (IllegalStateException e10) {
            X x12 = c0868x.f3671a;
            if (x12 != null) {
                c0868x.p(d0.a.c(x12.e(), new ImageCaptureException(2, "Failed to acquire latest image", e10)));
            }
        }
    }

    public static /* synthetic */ void b(C0868x c0868x, X x10) {
        c0868x.l(x10);
        c0868x.f3677g.h(x10);
    }

    public static /* synthetic */ void d(androidx.camera.core.m mVar) {
        if (mVar != null) {
            mVar.j();
        }
    }

    public static /* synthetic */ void e(C0868x c0868x, InterfaceC0872a0 interfaceC0872a0) {
        c0868x.getClass();
        try {
            androidx.camera.core.i iVarD = interfaceC0872a0.d();
            if (iVarD != null) {
                c0868x.m(iVarD);
            }
        } catch (IllegalStateException e10) {
            C0761b0.d("CaptureNode", "Failed to acquire latest image of postview", e10);
        }
    }

    public static /* synthetic */ void f(androidx.camera.core.m mVar) {
        if (mVar != null) {
            mVar.j();
        }
    }

    public static InterfaceC0872a0 h(D.X x10, int i10, int i11, int i12) {
        return x10 != null ? x10.a(i10, i11, i12, 4, 0L) : D.Y.a(i10, i11, i12, 4);
    }

    public int i() {
        M.n.b();
        B0.h.i(this.f3672b != null, "The ImageReader is not initialized.");
        return this.f3672b.i();
    }

    public final void j(androidx.camera.core.i iVar) {
        X x10;
        X x11;
        M.n.b();
        W.a aVar = this.f3675e;
        Objects.requireNonNull(aVar);
        aVar.a().accept(W.b.c(this.f3671a, iVar));
        X x12 = this.f3671a;
        c cVar = this.f3676f;
        boolean z10 = cVar != null && cVar.e().size() > 1;
        if (z10 && (x11 = this.f3671a) != null) {
            x11.k().t(iVar.getFormat(), true);
        }
        if (!z10 || ((x10 = this.f3671a) != null && x10.k().r())) {
            this.f3671a = null;
        }
        x12.s();
    }

    public void k(androidx.camera.core.i iVar) {
        M.n.b();
        if (this.f3671a == null) {
            C0761b0.o("CaptureNode", "Discarding ImageProxy which was inadvertently acquired: " + iVar);
            iVar.close();
            return;
        }
        E0 e0E = iVar.Z0().e();
        if (((Integer) e0E.d(this.f3671a.j())) != null) {
            j(iVar);
            return;
        }
        C0761b0.o("CaptureNode", "Discarding ImageProxy which was acquired for another request, mCurrentRequest id = " + this.f3671a.e() + ", ImageProxy tagBundle keys = " + e0E.e());
        iVar.close();
    }

    public void l(X x10) {
        M.n.b();
        B0.h.i(x10.i().size() == 1, "only one capture stage is supported.");
        B0.h.i(i() > 0, "Too many acquire images. Close image to be able to process next.");
        this.f3671a = x10;
        O.f.b(x10.a(), new b(x10), N.a.a());
    }

    public final void m(androidx.camera.core.i iVar) {
        if (this.f3671a == null) {
            C0761b0.o("CaptureNode", "Postview image is closed due to request completed or aborted");
            iVar.close();
        } else {
            W.a aVar = this.f3675e;
            Objects.requireNonNull(aVar);
            aVar.d().accept(W.b.c(this.f3671a, iVar));
        }
    }

    public void n() {
        M.n.b();
        c cVar = this.f3676f;
        Objects.requireNonNull(cVar);
        androidx.camera.core.m mVar = this.f3672b;
        Objects.requireNonNull(mVar);
        o(cVar, mVar, this.f3673c, this.f3674d);
    }

    public final void o(c cVar, final androidx.camera.core.m mVar, final androidx.camera.core.m mVar2, final androidx.camera.core.m mVar3) {
        cVar.l().d();
        cVar.l().k().a(new Runnable() { // from class: J.s
            @Override // java.lang.Runnable
            public final void run() {
                mVar.j();
            }
        }, N.a.d());
        if (cVar.g() != null) {
            cVar.g().d();
            cVar.g().k().a(new Runnable() { // from class: J.t
                @Override // java.lang.Runnable
                public final void run() {
                    C0868x.f(mVar3);
                }
            }, N.a.d());
        }
        if (cVar.e().size() <= 1 || cVar.j() == null) {
            return;
        }
        cVar.j().d();
        cVar.j().k().a(new Runnable() { // from class: J.u
            @Override // java.lang.Runnable
            public final void run() {
                C0868x.d(mVar2);
            }
        }, N.a.d());
    }

    public void p(d0.a aVar) {
        M.n.b();
        X x10 = this.f3671a;
        if (x10 == null || x10.e() != aVar.b()) {
            return;
        }
        this.f3671a.n(aVar.a());
    }

    public final void q(InterfaceC0872a0 interfaceC0872a0) {
        interfaceC0872a0.b(new InterfaceC0872a0.a() { // from class: J.n
            @Override // K.InterfaceC0872a0.a
            public final void a(InterfaceC0872a0 interfaceC0872a02) {
                C0868x.a(this.f3658a, interfaceC0872a02);
            }
        }, N.a.d());
    }

    public void r(g.a aVar) {
        M.n.b();
        B0.h.i(this.f3672b != null, "The ImageReader is not initialized.");
        this.f3672b.k(aVar);
    }

    public W.a s(c cVar) {
        B0.a<X> aVar;
        InterfaceC0872a0 interfaceC0872a0;
        androidx.camera.core.j jVar;
        androidx.camera.core.j jVar2;
        B0.h.i(this.f3676f == null && this.f3672b == null, "CaptureNode does not support recreation yet.");
        this.f3676f = cVar;
        Size sizeK = cVar.k();
        int iD = cVar.d();
        boolean zM = cVar.m();
        AbstractC0889l aVar2 = new a();
        boolean z10 = cVar.e().size() > 1;
        AbstractC0889l abstractC0889lB = null;
        if (zM || cVar.c() != null) {
            J j10 = new J(h(cVar.c(), sizeK.getWidth(), sizeK.getHeight(), iD));
            this.f3677g = j10;
            aVar = new B0.a() { // from class: J.p
                @Override // B0.a
                public final void accept(Object obj) {
                    C0868x.b(this.f3662a, (X) obj);
                }
            };
            interfaceC0872a0 = j10;
            jVar = null;
        } else {
            if (z10) {
                androidx.camera.core.j jVar3 = new androidx.camera.core.j(sizeK.getWidth(), sizeK.getHeight(), 256, 4);
                AbstractC0889l abstractC0889lB2 = C0890m.b(aVar2, jVar3.m());
                jVar = new androidx.camera.core.j(sizeK.getWidth(), sizeK.getHeight(), 32, 4);
                AbstractC0889l[] abstractC0889lArr = {aVar2, jVar.m()};
                aVar2 = abstractC0889lB2;
                abstractC0889lB = C0890m.b(abstractC0889lArr);
                jVar2 = jVar3;
            } else {
                androidx.camera.core.j jVar4 = new androidx.camera.core.j(sizeK.getWidth(), sizeK.getHeight(), iD, 4);
                aVar2 = C0890m.b(aVar2, jVar4.m());
                jVar2 = jVar4;
                jVar = null;
            }
            aVar = new B0.a() { // from class: J.o
                @Override // B0.a
                public final void accept(Object obj) {
                    this.f3661a.l((X) obj);
                }
            };
            interfaceC0872a0 = jVar2;
        }
        cVar.o(aVar2);
        if (z10 && abstractC0889lB != null) {
            cVar.q(abstractC0889lB);
        }
        Surface surface = interfaceC0872a0.getSurface();
        Objects.requireNonNull(surface);
        cVar.s(surface);
        this.f3672b = new androidx.camera.core.m(interfaceC0872a0);
        q(interfaceC0872a0);
        K kF = cVar.f();
        if (kF != null) {
            InterfaceC0872a0 interfaceC0872a0H = h(cVar.c(), kF.c().getWidth(), kF.c().getHeight(), kF.b());
            interfaceC0872a0H.b(new InterfaceC0872a0.a() { // from class: J.q
                @Override // K.InterfaceC0872a0.a
                public final void a(InterfaceC0872a0 interfaceC0872a02) {
                    C0868x.e(this.f3663a, interfaceC0872a02);
                }
            }, N.a.d());
            this.f3674d = new androidx.camera.core.m(interfaceC0872a0H);
            cVar.p(interfaceC0872a0H.getSurface(), kF.c(), kF.b());
        }
        if (z10 && jVar != null) {
            cVar.r(jVar.getSurface());
            this.f3673c = new androidx.camera.core.m(jVar);
            q(jVar);
        }
        cVar.h().a(aVar);
        cVar.b().a(new B0.a() { // from class: J.r
            @Override // B0.a
            public final void accept(Object obj) {
                this.f3664a.p((d0.a) obj);
            }
        });
        W.a aVarE = W.a.e(cVar.d(), cVar.e());
        this.f3675e = aVarE;
        return aVarE;
    }
}
