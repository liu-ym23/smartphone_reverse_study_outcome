package u5;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Trace;
import java.lang.invoke.VarHandle;
import k0.a2;
import k0.g1;
import k0.k1;
import k0.z;
import kc.e0;
import nc.k0;
import nc.t0;
import u1.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends h1.b implements a2 {

    /* renamed from: w, reason: collision with root package name */
    public static final t0.d f14066w = new t0.d(5);
    public pc.c i;

    /* renamed from: j, reason: collision with root package name */
    public final t0 f14067j = k0.a(c1.e.a(0));

    /* renamed from: k, reason: collision with root package name */
    public final k1 f14068k = z.v(null);

    /* renamed from: l, reason: collision with root package name */
    public final g1 f14069l = new g1(1.0f);

    /* renamed from: m, reason: collision with root package name */
    public final k1 f14070m = z.v(null);

    /* renamed from: n, reason: collision with root package name */
    public g f14071n;

    /* renamed from: o, reason: collision with root package name */
    public h1.b f14072o;

    /* renamed from: p, reason: collision with root package name */
    public xb.l f14073p;

    /* renamed from: q, reason: collision with root package name */
    public s1.j f14074q;

    /* renamed from: r, reason: collision with root package name */
    public int f14075r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f14076s;

    /* renamed from: t, reason: collision with root package name */
    public final k1 f14077t;

    /* renamed from: u, reason: collision with root package name */
    public final k1 f14078u;

    /* renamed from: v, reason: collision with root package name */
    public final k1 f14079v;

    public l(e6.i iVar, t5.g gVar) {
        c cVar = c.f14052a;
        this.f14071n = cVar;
        this.f14073p = f14066w;
        s1.j.f11260d.getClass();
        this.f14074q = s1.i.f11255c;
        this.f14075r = 1;
        this.f14077t = z.v(cVar);
        this.f14078u = z.v(iVar);
        this.f14079v = z.v(gVar);
    }

    @Override // k0.a2
    public final void a() {
        pc.c cVar = this.i;
        if (cVar != null) {
            kc.w.d(cVar, null);
        }
        this.i = null;
        Object obj = this.f14072o;
        a2 a2Var = obj instanceof a2 ? (a2) obj : null;
        if (a2Var != null) {
            a2Var.a();
        }
    }

    @Override // k0.a2
    public final void b() {
        pc.c cVar = this.i;
        if (cVar != null) {
            kc.w.d(cVar, null);
        }
        this.i = null;
        Object obj = this.f14072o;
        a2 a2Var = obj instanceof a2 ? (a2) obj : null;
        if (a2Var != null) {
            a2Var.b();
        }
    }

    @Override // k0.a2
    public final void c() {
        Trace.beginSection("AsyncImagePainter.onRemembered");
        try {
            if (this.i == null) {
                kc.k1 k1VarC = kc.w.c();
                rc.e eVar = e0.f7430a;
                pc.c cVarA = kc.w.a(ac.a.N(k1VarC, pc.n.f9978a.i));
                this.i = cVarA;
                Object obj = this.f14072o;
                nb.c cVar = null;
                a2 a2Var = obj instanceof a2 ? (a2) obj : null;
                if (a2Var != null) {
                    a2Var.c();
                }
                if (this.f14076s) {
                    e6.h hVarA = e6.i.a((e6.i) this.f14078u.getValue());
                    hVarA.f3531b = ((t5.g) this.f14079v.getValue()).f13193b;
                    hVarA.f3546r = null;
                    hVarA.a().A.getClass();
                    e6.c cVar2 = i6.c.f5803a;
                    k(new e(null));
                } else {
                    kc.w.u(cVarA, null, null, new androidx.room.e(this, cVar, 13), 3);
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // h1.b
    public final void d(float f5) {
        this.f14069l.h(f5);
    }

    @Override // h1.b
    public final void e(d1.l lVar) {
        this.f14070m.setValue(lVar);
    }

    @Override // h1.b
    public final long h() {
        h1.b bVar = (h1.b) this.f14068k.getValue();
        if (bVar != null) {
            return bVar.h();
        }
        return 9205357640488583168L;
    }

    @Override // h1.b
    public final void i(i0 i0Var) {
        f1.b bVar = i0Var.f13838c;
        c1.e eVarA = c1.e.a(bVar.e());
        t0 t0Var = this.f14067j;
        t0Var.getClass();
        t0Var.g(null, eVarA);
        h1.b bVar2 = (h1.b) this.f14068k.getValue();
        if (bVar2 != null) {
            bVar2.g(i0Var, bVar.e(), this.f14069l.g(), (d1.l) this.f14070m.getValue());
        }
    }

    public final h1.b j(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return a.a.a(new d1.e(((BitmapDrawable) drawable).getBitmap()), this.f14075r);
        }
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.getClass();
        o6.a aVar = new o6.a();
        aVar.i = drawableMutate;
        aVar.f9232j = z.v(0);
        Object obj = o6.c.f9236a;
        aVar.f9233k = z.v(c1.e.a((drawableMutate.getIntrinsicWidth() < 0 || drawableMutate.getIntrinsicHeight() < 0) ? 9205357640488583168L : a.a.e(drawableMutate.getIntrinsicWidth(), drawableMutate.getIntrinsicHeight())));
        aVar.f9234l = new jb.k(new ad.l(aVar, 17));
        if (drawableMutate.getIntrinsicWidth() < 0 || drawableMutate.getIntrinsicHeight() < 0) {
            VarHandle.storeStoreFence();
            return aVar;
        }
        drawableMutate.setBounds(0, 0, drawableMutate.getIntrinsicWidth(), drawableMutate.getIntrinsicHeight());
        VarHandle.storeStoreFence();
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(u5.g r10) {
        /*
            r9 = this;
            u5.g r0 = r9.f14071n
            xb.l r1 = r9.f14073p
            java.lang.Object r10 = r1.invoke(r10)
            u5.g r10 = (u5.g) r10
            r9.f14071n = r10
            k0.k1 r1 = r9.f14077t
            r1.setValue(r10)
            boolean r1 = r10 instanceof u5.f
            r2 = 0
            if (r1 == 0) goto L1c
            r1 = r10
            u5.f r1 = (u5.f) r1
            e6.q r1 = r1.f14057b
            goto L25
        L1c:
            boolean r1 = r10 instanceof u5.d
            if (r1 == 0) goto L85
            r1 = r10
            u5.d r1 = (u5.d) r1
            e6.e r1 = r1.f14054b
        L25:
            e6.i r3 = r1.b()
            h6.e r3 = r3.f3554h
            u5.m r4 = u5.n.f14080a
            h6.f r3 = r3.a(r4, r1)
            boolean r4 = r3 instanceof h6.b
            if (r4 == 0) goto L85
            h1.b r4 = r0.a()
            boolean r5 = r0 instanceof u5.e
            if (r5 == 0) goto L3e
            goto L3f
        L3e:
            r4 = r2
        L3f:
            h1.b r5 = r10.a()
            s1.j r6 = r9.f14074q
            h6.b r3 = (h6.b) r3
            int r3 = r3.f5393c
            boolean r7 = r1 instanceof e6.q
            r8 = 0
            if (r7 == 0) goto L57
            e6.q r1 = (e6.q) r1
            boolean r1 = r1.f3598g
            if (r1 != 0) goto L55
            goto L57
        L55:
            r1 = r8
            goto L58
        L57:
            r1 = 1
        L58:
            u5.t r7 = new u5.t
            r7.<init>()
            r7.i = r4
            r7.f14095j = r5
            r7.f14096k = r6
            r7.f14097l = r3
            r7.f14098m = r1
            k0.h1 r1 = new k0.h1
            r1.<init>(r8)
            r7.f14099n = r1
            r3 = -1
            r7.f14100o = r3
            k0.g1 r1 = new k0.g1
            r3 = 1065353216(0x3f800000, float:1.0)
            r1.<init>(r3)
            r7.f14102q = r1
            k0.k1 r1 = k0.z.v(r2)
            r7.f14103r = r1
            java.lang.invoke.VarHandle.storeStoreFence()
            goto L86
        L85:
            r7 = r2
        L86:
            if (r7 == 0) goto L89
            goto L8d
        L89:
            h1.b r7 = r10.a()
        L8d:
            r9.f14072o = r7
            k0.k1 r1 = r9.f14068k
            r1.setValue(r7)
            pc.c r9 = r9.i
            if (r9 == 0) goto Lc3
            h1.b r9 = r0.a()
            h1.b r1 = r10.a()
            if (r9 == r1) goto Lc3
            h1.b r9 = r0.a()
            boolean r0 = r9 instanceof k0.a2
            if (r0 == 0) goto Lad
            k0.a2 r9 = (k0.a2) r9
            goto Lae
        Lad:
            r9 = r2
        Lae:
            if (r9 == 0) goto Lb3
            r9.b()
        Lb3:
            h1.b r9 = r10.a()
            boolean r10 = r9 instanceof k0.a2
            if (r10 == 0) goto Lbe
            r2 = r9
            k0.a2 r2 = (k0.a2) r2
        Lbe:
            if (r2 == 0) goto Lc3
            r2.c()
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.l.k(u5.g):void");
    }
}
