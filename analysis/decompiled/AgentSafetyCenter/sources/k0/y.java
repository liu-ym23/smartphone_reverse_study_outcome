package k0;

import android.os.Trace;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y implements u {

    /* renamed from: c, reason: collision with root package name */
    public final v f7116c;

    /* renamed from: f, reason: collision with root package name */
    public final p5.m f7117f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference f7118g = new AtomicReference(null);

    /* renamed from: h, reason: collision with root package name */
    public final Object f7119h = new Object();
    public final p.i0 i;

    /* renamed from: j, reason: collision with root package name */
    public final f2 f7120j;

    /* renamed from: k, reason: collision with root package name */
    public final p.f0 f7121k;

    /* renamed from: l, reason: collision with root package name */
    public final p.g0 f7122l;

    /* renamed from: m, reason: collision with root package name */
    public final p.g0 f7123m;

    /* renamed from: n, reason: collision with root package name */
    public final p.f0 f7124n;

    /* renamed from: o, reason: collision with root package name */
    public final l0.a f7125o;

    /* renamed from: p, reason: collision with root package name */
    public final l0.a f7126p;

    /* renamed from: q, reason: collision with root package name */
    public final p.f0 f7127q;

    /* renamed from: r, reason: collision with root package name */
    public p.f0 f7128r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7129s;

    /* renamed from: t, reason: collision with root package name */
    public y f7130t;

    /* renamed from: u, reason: collision with root package name */
    public int f7131u;

    /* renamed from: v, reason: collision with root package name */
    public final a2.i f7132v;

    /* renamed from: w, reason: collision with root package name */
    public final s0.i f7133w;

    /* renamed from: x, reason: collision with root package name */
    public final s f7134x;

    /* renamed from: y, reason: collision with root package name */
    public int f7135y;

    public y(v vVar, p5.m mVar) {
        this.f7116c = vVar;
        this.f7117f = mVar;
        p.g0 g0Var = new p.g0();
        p.i0 i0Var = new p.i0();
        i0Var.f9578c = g0Var;
        i0Var.f9579f = g0Var;
        VarHandle.storeStoreFence();
        this.i = i0Var;
        f2 f2Var = new f2();
        if (vVar.c()) {
            f2Var.f6909o = new p.u();
        }
        if (vVar.e()) {
            f2Var.b();
        }
        this.f7120j = f2Var;
        this.f7121k = h5.t.t();
        this.f7122l = new p.g0();
        this.f7123m = new p.g0();
        this.f7124n = h5.t.t();
        l0.a aVar = new l0.a();
        this.f7125o = aVar;
        l0.a aVar2 = new l0.a();
        this.f7126p = aVar2;
        this.f7127q = h5.t.t();
        this.f7128r = h5.t.t();
        a2.i iVar = new a2.i(14);
        iVar.f49f = vVar;
        VarHandle.storeStoreFence();
        this.f7132v = iVar;
        this.f7133w = new s0.i();
        s sVar = new s();
        sVar.f7033a = mVar;
        sVar.f7034b = vVar;
        sVar.f7035c = f2Var;
        sVar.f7036d = i0Var;
        sVar.f7037e = aVar;
        sVar.f7038f = aVar2;
        sVar.f7039g = iVar;
        sVar.f7040h = this;
        sVar.i = new ArrayList();
        sVar.f7045n = new r0();
        sVar.f7050s = new ArrayList();
        sVar.f7051t = new r0();
        sVar.f7052u = s0.g.f11181h;
        sVar.f7055x = new r0();
        sVar.f7057z = -1;
        int i = 0;
        sVar.C = vVar.e() || vVar.c();
        q qVar = new q(i);
        qVar.f7023b = sVar;
        VarHandle.storeStoreFence();
        sVar.D = qVar;
        sVar.E = new ArrayList();
        e2 e2VarC = f2Var.c();
        e2VarC.c();
        sVar.G = e2VarC;
        f2 f2Var2 = new f2();
        if (vVar.e()) {
            f2Var2.b();
        }
        if (vVar.c()) {
            f2Var2.f6909o = new p.u();
        }
        sVar.H = f2Var2;
        i2 i2VarD = f2Var2.d();
        i2VarD.e(true);
        sVar.I = i2VarD;
        l0.b bVar = new l0.b();
        bVar.f7658a = sVar;
        bVar.f7659b = aVar;
        bVar.f7661d = new r0();
        bVar.f7662e = true;
        bVar.f7665h = new ArrayList();
        bVar.i = -1;
        bVar.f7666j = -1;
        bVar.f7667k = -1;
        VarHandle.storeStoreFence();
        sVar.M = bVar;
        e2 e2VarC2 = sVar.H.c();
        try {
            b bVarA = e2VarC2.a(0);
            e2VarC2.c();
            sVar.N = bVarA;
            sVar.O = new l0.c();
            v0.b bVar2 = new v0.b();
            bVar2.f14318c = sVar;
            VarHandle.storeStoreFence();
            sVar.Q = bVar2;
            nb.g gVarI = vVar.i();
            nb.g gVarA = sVar.A();
            sVar.R = gVarI.plus(gVarA == null ? nb.h.f8811c : gVarA);
            VarHandle.storeStoreFence();
            vVar.m(sVar);
            this.f7134x = sVar;
            int i3 = j.f6961a;
        } catch (Throwable th) {
            e2VarC2.c();
            throw th;
        }
    }

    public final void A(xb.p pVar) {
        boolean zI = i();
        p();
        v vVar = this.f7116c;
        if (!zI) {
            vVar.a(this, pVar);
            return;
        }
        s sVar = this.f7134x;
        sVar.f7057z = 100;
        sVar.f7056y = true;
        vVar.a(this, pVar);
        sVar.u();
    }

    public final void a() {
        this.f7118g.set(null);
        this.f7125o.f7656c.P();
        this.f7126p.f7656c.P();
        p.i0 i0Var = this.i;
        if (i0Var.f9578c.g()) {
            return;
        }
        s0.i iVar = this.f7133w;
        try {
            iVar.e(i0Var, this.f7134x.A());
            iVar.b();
        } finally {
            iVar.a();
        }
    }

    public final void b(Object obj, boolean z10) {
        Object objG = this.f7121k.g(obj);
        if (objG == null) {
            return;
        }
        boolean z11 = objG instanceof p.g0;
        p.g0 g0Var = this.f7122l;
        p.g0 g0Var2 = this.f7123m;
        p.f0 f0Var = this.f7127q;
        if (!z11) {
            v1 v1Var = (v1) objG;
            if (h5.t.M(f0Var, obj, v1Var) || v1Var.b(obj) == t0.f7068c) {
                return;
            }
            if (v1Var.f7094g == null || z10) {
                g0Var.a(v1Var);
                return;
            } else {
                g0Var2.a(v1Var);
                return;
            }
        }
        p.g0 g0Var3 = (p.g0) objG;
        Object[] objArr = g0Var3.f9561b;
        long[] jArr = g0Var3.f9560a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128) {
                        v1 v1Var2 = (v1) objArr[(i << 3) + i10];
                        if (!h5.t.M(f0Var, obj, v1Var2) && v1Var2.b(obj) != t0.f7068c) {
                            if (v1Var2.f7094g == null || z10) {
                                g0Var.a(v1Var2);
                            } else {
                                g0Var2.a(v1Var2);
                            }
                        }
                    }
                    j10 >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0183 A[EDGE_INSN: B:73:0x0183->B:224:0x0122 BREAK  A[LOOP:13: B:63:0x0151->B:74:0x0185]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.Set r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.y.c(java.util.Set, boolean):void");
    }

    public final void d() {
        synchronized (this.f7119h) {
            try {
                e(this.f7125o);
                n();
            } catch (Throwable th) {
                try {
                    if (!this.i.f9578c.g()) {
                        s0.i iVar = this.f7133w;
                        try {
                            iVar.e(this.i, this.f7134x.A());
                            iVar.b();
                            iVar.a();
                        } catch (Throwable th2) {
                            iVar.a();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    a();
                    throw th3;
                }
            }
        }
    }

    public final void e(l0.a aVar) throws Throwable {
        s0.i iVar;
        long[] jArr;
        int i;
        long[] jArr2;
        s0.i iVar2;
        long j10;
        char c9;
        long j11;
        int i3;
        boolean zG;
        int i10;
        l0.a aVar2 = this.f7126p;
        s sVar = this.f7134x;
        v0.b bVarA = sVar.A();
        s0.i iVar3 = this.f7133w;
        iVar3.e(this.i, bVarA);
        try {
            if (aVar.f7656c.R()) {
                try {
                    if (aVar2.f7656c.R()) {
                        iVar3.b();
                    }
                    return;
                } finally {
                }
            }
            try {
                Trace.beginSection("Compose:applyChanges");
                try {
                    p5.m mVar = this.f7117f;
                    i2 i2VarD = this.f7120j.d();
                    int i11 = 0;
                    try {
                        aVar.P(mVar, i2VarD, iVar3, sVar.A());
                        i2VarD.e(true);
                        mVar.l();
                        Trace.endSection();
                        iVar3.c();
                        m0.e eVar = iVar3.f11190g;
                        if (eVar.f8160g != 0) {
                            Trace.beginSection("Compose:sideeffects");
                            try {
                                Object[] objArr = eVar.f8158c;
                                int i12 = eVar.f8160g;
                                for (int i13 = 0; i13 < i12; i13++) {
                                    ((xb.a) objArr[i13]).invoke();
                                }
                                eVar.g();
                                Trace.endSection();
                            } finally {
                                Trace.endSection();
                            }
                        }
                        if (this.f7129s) {
                            Trace.beginSection("Compose:unobserve");
                            try {
                                this.f7129s = false;
                                p.f0 f0Var = this.f7121k;
                                long[] jArr3 = f0Var.f9552a;
                                int length = jArr3.length - 2;
                                if (length >= 0) {
                                    int i14 = 0;
                                    while (true) {
                                        long j12 = jArr3[i14];
                                        char c10 = 7;
                                        long j13 = -9187201950435737472L;
                                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i15 = 8;
                                            int i16 = 8 - ((~(i14 - length)) >>> 31);
                                            int i17 = i11;
                                            while (i17 < i16) {
                                                if ((j12 & 255) < 128) {
                                                    c9 = c10;
                                                    int i18 = (i14 << 3) + i17;
                                                    j11 = j13;
                                                    Object obj = f0Var.f9553b[i18];
                                                    Object obj2 = f0Var.f9554c[i18];
                                                    if (obj2 instanceof p.g0) {
                                                        p.g0 g0Var = (p.g0) obj2;
                                                        Object[] objArr2 = g0Var.f9561b;
                                                        long[] jArr4 = g0Var.f9560a;
                                                        int i19 = i15;
                                                        int length2 = jArr4.length - 2;
                                                        if (length2 >= 0) {
                                                            jArr2 = jArr3;
                                                            iVar2 = iVar3;
                                                            int i20 = 0;
                                                            while (true) {
                                                                try {
                                                                    long j14 = jArr4[i20];
                                                                    j10 = j12;
                                                                    if ((((~j14) << c9) & j14 & j11) != j11) {
                                                                        int i21 = 8 - ((~(i20 - length2)) >>> 31);
                                                                        int i22 = 0;
                                                                        while (i22 < i21) {
                                                                            if ((j14 & 255) < 128) {
                                                                                i10 = i17;
                                                                                int i23 = (i20 << 3) + i22;
                                                                                if (!((v1) objArr2[i23]).a()) {
                                                                                    g0Var.l(i23);
                                                                                }
                                                                            } else {
                                                                                i10 = i17;
                                                                            }
                                                                            j14 >>= i19;
                                                                            i22++;
                                                                            i17 = i10;
                                                                        }
                                                                        i = i17;
                                                                        if (i21 != i19) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        i = i17;
                                                                    }
                                                                    if (i20 == length2) {
                                                                        break;
                                                                    }
                                                                    i20++;
                                                                    j12 = j10;
                                                                    i17 = i;
                                                                    i19 = 8;
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    throw th;
                                                                }
                                                            }
                                                        } else {
                                                            i = i17;
                                                            jArr2 = jArr3;
                                                            iVar2 = iVar3;
                                                            j10 = j12;
                                                        }
                                                        zG = g0Var.g();
                                                    } else {
                                                        i = i17;
                                                        jArr2 = jArr3;
                                                        iVar2 = iVar3;
                                                        j10 = j12;
                                                        obj2.getClass();
                                                        zG = !((v1) obj2).a();
                                                    }
                                                    if (zG) {
                                                        f0Var.l(i18);
                                                    }
                                                    i3 = 8;
                                                } else {
                                                    i = i17;
                                                    jArr2 = jArr3;
                                                    iVar2 = iVar3;
                                                    j10 = j12;
                                                    c9 = c10;
                                                    j11 = j13;
                                                    i3 = i15;
                                                }
                                                j12 = j10 >> i3;
                                                i15 = i3;
                                                c10 = c9;
                                                j13 = j11;
                                                iVar3 = iVar2;
                                                jArr3 = jArr2;
                                                i17 = i + 1;
                                            }
                                            jArr = jArr3;
                                            iVar = iVar3;
                                            if (i16 != i15) {
                                                break;
                                            }
                                        } else {
                                            jArr = jArr3;
                                            iVar = iVar3;
                                        }
                                        if (i14 == length) {
                                            break;
                                        }
                                        i14++;
                                        iVar3 = iVar;
                                        jArr3 = jArr;
                                        i11 = 0;
                                    }
                                } else {
                                    iVar = iVar3;
                                }
                                h();
                                Trace.endSection();
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else {
                            iVar = iVar3;
                        }
                        try {
                            if (aVar2.f7656c.R()) {
                                iVar.b();
                            }
                        } finally {
                            iVar.a();
                        }
                    } catch (Throwable th3) {
                        try {
                            i2VarD.e(false);
                            throw th3;
                        } catch (Throwable th4) {
                            th = th4;
                            Trace.endSection();
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                try {
                    if (aVar2.f7656c.R()) {
                        iVar3.b();
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public final void f() {
        synchronized (this.f7119h) {
            try {
                if (this.f7126p.f7656c.S()) {
                    e(this.f7126p);
                }
            } catch (Throwable th) {
                try {
                    if (!this.i.f9578c.g()) {
                        s0.i iVar = this.f7133w;
                        try {
                            iVar.e(this.i, this.f7134x.A());
                            iVar.b();
                            iVar.a();
                        } catch (Throwable th2) {
                            iVar.a();
                            throw th2;
                        }
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    public final void g() {
        s0.i iVar;
        synchronized (this.f7119h) {
            try {
                this.f7134x.f7053v = null;
                if (!this.i.f9578c.g()) {
                    iVar = this.f7133w;
                    try {
                        iVar.e(this.i, this.f7134x.A());
                        iVar.b();
                        iVar.a();
                    } finally {
                    }
                }
            } catch (Throwable th) {
                try {
                    if (!this.i.f9578c.g()) {
                        iVar = this.f7133w;
                        try {
                            iVar.e(this.i, this.f7134x.A());
                            iVar.b();
                            iVar.a();
                        } finally {
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    a();
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.y.h():void");
    }

    public final boolean i() {
        boolean z10;
        synchronized (this.f7119h) {
            z10 = true;
            if (this.f7135y != 1) {
                z10 = false;
            }
            if (z10) {
                this.f7135y = 0;
            }
        }
        return z10;
    }

    public final void j(xb.p pVar) {
        try {
            synchronized (this.f7119h) {
                m();
                p.f0 f0Var = this.f7128r;
                this.f7128r = h5.t.t();
                try {
                    s sVar = this.f7134x;
                    if (!sVar.f7037e.f7656c.R()) {
                        t.c("Expected applyChanges() to have been called");
                    }
                    sVar.P = null;
                    try {
                        sVar.o(f0Var, pVar);
                    } finally {
                        sVar.P = null;
                    }
                } catch (Throwable th) {
                    this.f7128r = f0Var;
                    throw th;
                }
            }
        } catch (Throwable th2) {
            try {
                if (!this.i.f9578c.g()) {
                    s0.i iVar = this.f7133w;
                    try {
                        iVar.e(this.i, this.f7134x.A());
                        iVar.b();
                        iVar.a();
                    } catch (Throwable th3) {
                        iVar.a();
                        throw th3;
                    }
                }
                throw th2;
            } catch (Throwable th4) {
                a();
                throw th4;
            }
        }
    }

    public final void k() {
        synchronized (this.f7119h) {
            try {
                int i = 1;
                boolean z10 = this.f7120j.f6901f > 0;
                if (z10 || !this.i.f9578c.g()) {
                    Trace.beginSection("Compose:deactivate");
                    try {
                        s0.i iVar = this.f7133w;
                        try {
                            iVar.e(this.i, this.f7134x.A());
                            if (z10) {
                                i2 i2VarD = this.f7120j.d();
                                try {
                                    s0.i iVar2 = this.f7133w;
                                    int i3 = i2VarD.f6956t;
                                    j9.i iVar3 = new j9.i(i);
                                    iVar3.f6671f = iVar2;
                                    iVar3.f6672g = i2VarD;
                                    VarHandle.storeStoreFence();
                                    i2VarD.n(i3, iVar3);
                                    i2VarD.e(true);
                                    this.f7117f.l();
                                    iVar.c();
                                } catch (Throwable th) {
                                    i2VarD.e(false);
                                    throw th;
                                }
                            }
                            iVar.b();
                            iVar.a();
                        } catch (Throwable th2) {
                            iVar.a();
                            throw th2;
                        }
                    } finally {
                        Trace.endSection();
                    }
                }
                this.f7121k.a();
                this.f7124n.a();
                this.f7128r.a();
                this.f7125o.f7656c.P();
                this.f7126p.f7656c.P();
                s sVar = this.f7134x;
                sVar.E.clear();
                sVar.f7050s.clear();
                sVar.f7037e.f7656c.P();
                sVar.f7053v = null;
                this.f7135y = 1;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void l() {
        synchronized (this.f7119h) {
            try {
                if (this.f7134x.F) {
                    q1.b("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (this.f7135y != 3) {
                    this.f7135y = 3;
                    int i = j.f6961a;
                    l0.a aVar = this.f7134x.L;
                    if (aVar != null) {
                        e(aVar);
                    }
                    boolean z10 = this.f7120j.f6901f > 0;
                    if (z10 || !this.i.f9578c.g()) {
                        s0.i iVar = this.f7133w;
                        try {
                            iVar.e(this.i, this.f7134x.A());
                            if (z10) {
                                i2 i2VarD = this.f7120j.d();
                                try {
                                    t.g(i2VarD, this.f7133w);
                                    i2VarD.e(true);
                                    this.f7117f.r();
                                    this.f7117f.l();
                                    iVar.c();
                                } catch (Throwable th) {
                                    i2VarD.e(false);
                                    throw th;
                                }
                            }
                            iVar.b();
                            iVar.a();
                        } catch (Throwable th2) {
                            iVar.a();
                            throw th2;
                        }
                    }
                    s sVar = this.f7134x;
                    sVar.getClass();
                    Trace.beginSection("Compose:Composer.dispose");
                    try {
                        sVar.f7034b.p(sVar);
                        sVar.E.clear();
                        sVar.f7050s.clear();
                        sVar.f7037e.f7656c.P();
                        sVar.f7053v = null;
                        sVar.f7033a.r();
                        Trace.endSection();
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        this.f7116c.q(this);
    }

    public final void m() {
        Object obj = z.f7151a;
        AtomicReference atomicReference = this.f7118g;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            if (andSet.equals(obj)) {
                t.d("pending composition has not been applied");
                throw new androidx.fragment.app.d();
            }
            if (andSet instanceof Set) {
                c((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                t.d("corrupt pendingModifications drain: " + atomicReference);
                throw new androidx.fragment.app.d();
            }
            for (Set set : (Set[]) andSet) {
                c(set, true);
            }
        }
    }

    public final void n() {
        AtomicReference atomicReference = this.f7118g;
        Object andSet = atomicReference.getAndSet(null);
        if (yb.k.a(andSet, z.f7151a)) {
            return;
        }
        if (andSet instanceof Set) {
            c((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set set : (Set[]) andSet) {
                c(set, false);
            }
            return;
        }
        if (andSet == null) {
            t.d("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new androidx.fragment.app.d();
        }
        t.d("corrupt pendingModifications drain: " + atomicReference);
        throw new androidx.fragment.app.d();
    }

    public final void o() {
        kb.u uVar = kb.u.f7406c;
        AtomicReference atomicReference = this.f7118g;
        Object andSet = atomicReference.getAndSet(uVar);
        if (yb.k.a(andSet, z.f7151a) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            c((Set) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            t.d("corrupt pendingModifications drain: " + atomicReference);
            throw new androidx.fragment.app.d();
        }
        for (Set set : (Set[]) andSet) {
            c(set, false);
        }
    }

    public final void p() {
        int i = this.f7135y;
        if (i == 0) {
            return;
        }
        q1.b(i != 1 ? i != 2 ? i != 3 ? "" : "The composition is disposed" : "A previous pausable composition for this composition was cancelled. This composition must be disposed." : "The composition should be activated before setting content.");
    }

    public final void q(ArrayList arrayList) {
        p.i0 i0Var = this.i;
        s sVar = this.f7134x;
        if (arrayList.size() > 0) {
            ((b1) ((jb.g) arrayList.get(0)).f6759c).getClass();
            throw null;
        }
        try {
            sVar.getClass();
            try {
                sVar.C(arrayList);
                sVar.i();
            } catch (Throwable th) {
                sVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                if (!i0Var.f9578c.g()) {
                    s0.i iVar = this.f7133w;
                    try {
                        iVar.e(i0Var, sVar.A());
                        iVar.b();
                        iVar.a();
                    } catch (Throwable th3) {
                        iVar.a();
                        throw th3;
                    }
                }
                throw th2;
            } catch (Throwable th4) {
                a();
                throw th4;
            }
        }
    }

    public final t0 r(v1 v1Var, Object obj) {
        y yVar;
        int i = v1Var.f7089b;
        if ((i & 2) != 0) {
            v1Var.f7089b = i | 4;
        }
        b bVar = v1Var.f7090c;
        if (bVar == null || !bVar.a()) {
            return t0.f7068c;
        }
        if (this.f7120j.e(bVar)) {
            if (v1Var.f7091d == null) {
                return t0.f7068c;
            }
            t0 t0VarT = t(v1Var, bVar, obj);
            if (t0VarT != t0.f7068c) {
                this.f7132v.x();
            }
            return t0VarT;
        }
        synchronized (this.f7119h) {
            yVar = this.f7130t;
        }
        if (yVar != null) {
            s sVar = yVar.f7134x;
            if (sVar.F && sVar.d0(v1Var, obj)) {
                return t0.f7071h;
            }
        }
        return t0.f7068c;
    }

    public final void s() {
        y yVar;
        synchronized (this.f7119h) {
            try {
                for (Object obj : this.f7120j.f6902g) {
                    v1 v1Var = obj instanceof v1 ? (v1) obj : null;
                    if (v1Var != null && (yVar = v1Var.f7088a) != null) {
                        yVar.r(v1Var, null);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d0 A[Catch: all -> 0x0040, EDGE_INSN: B:81:0x00d0->B:66:0x00d0 BREAK  A[LOOP:0: B:48:0x0087->B:62:0x00c8], EDGE_INSN: B:82:0x00d0->B:66:0x00d0 BREAK  A[LOOP:0: B:48:0x0087->B:62:0x00c8], TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:4:0x000b, B:6:0x0010, B:8:0x0018, B:10:0x001f, B:14:0x0029, B:16:0x002f, B:13:0x0024, B:25:0x0045, B:27:0x004b, B:32:0x0056, B:36:0x005c, B:37:0x0065, B:40:0x006b, B:41:0x0071, B:43:0x0077, B:45:0x007b, B:48:0x0087, B:50:0x0097, B:52:0x00a3, B:54:0x00ad, B:58:0x00bc, B:62:0x00c8, B:63:0x00cb, B:66:0x00d0), top: B:79:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k0.t0 t(k0.v1 r21, k0.b r22, java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.y.t(k0.v1, k0.b, java.lang.Object):k0.t0");
    }

    public final void u(Object obj) {
        Object objG = this.f7121k.g(obj);
        if (objG == null) {
            return;
        }
        boolean z10 = objG instanceof p.g0;
        p.f0 f0Var = this.f7127q;
        if (!z10) {
            v1 v1Var = (v1) objG;
            if (v1Var.b(obj) == t0.f7071h) {
                h5.t.l(f0Var, obj, v1Var);
                return;
            }
            return;
        }
        p.g0 g0Var = (p.g0) objG;
        Object[] objArr = g0Var.f9561b;
        long[] jArr = g0Var.f9560a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128) {
                        v1 v1Var2 = (v1) objArr[(i << 3) + i10];
                        if (v1Var2.b(obj) == t0.f7071h) {
                            h5.t.l(f0Var, obj, v1Var2);
                        }
                    }
                    j10 >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(java.util.Set r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof m0.h
            p.f0 r3 = r0.f7124n
            p.f0 r0 = r0.f7121k
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L5e
            m0.h r1 = (m0.h) r1
            p.g0 r1 = r1.f8171c
            java.lang.Object[] r2 = r1.f9561b
            long[] r1 = r1.f9560a
            int r6 = r1.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L7b
            r7 = r4
        L1c:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L59
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r4
        L36:
            if (r12 >= r10) goto L57
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L53
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r2[r13]
            boolean r14 = r0.c(r13)
            if (r14 != 0) goto L52
            boolean r13 = r3.c(r13)
            if (r13 == 0) goto L53
        L52:
            return r5
        L53:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L36
        L57:
            if (r10 != r11) goto L7b
        L59:
            if (r7 == r6) goto L7b
            int r7 = r7 + 1
            goto L1c
        L5e:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L64:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L7b
            java.lang.Object r2 = r1.next()
            boolean r6 = r0.c(r2)
            if (r6 != 0) goto L7a
            boolean r2 = r3.c(r2)
            if (r2 == 0) goto L64
        L7a:
            return r5
        L7b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.y.v(java.util.Set):boolean");
    }

    public final boolean w() {
        boolean zS;
        synchronized (this.f7119h) {
            m();
            try {
                p.f0 f0Var = this.f7128r;
                this.f7128r = h5.t.t();
                try {
                    s sVar = this.f7134x;
                    l0.k0 k0Var = sVar.f7037e.f7656c;
                    if (!k0Var.R()) {
                        t.c("Expected applyChanges() to have been called");
                    }
                    if (f0Var.f9556e > 0 || !sVar.f7050s.isEmpty()) {
                        sVar.P = null;
                        try {
                            sVar.o(f0Var, null);
                            sVar.P = null;
                            zS = k0Var.S();
                        } catch (Throwable th) {
                            sVar.P = null;
                            throw th;
                        }
                    } else {
                        zS = false;
                    }
                    if (!zS) {
                        n();
                    }
                } catch (Throwable th2) {
                    this.f7128r = f0Var;
                    throw th2;
                }
            } catch (Throwable th3) {
                try {
                    if (!this.i.f9578c.g()) {
                        s0.i iVar = this.f7133w;
                        try {
                            iVar.e(this.i, this.f7134x.A());
                            iVar.b();
                            iVar.a();
                        } catch (Throwable th4) {
                            iVar.a();
                            throw th4;
                        }
                    }
                    throw th3;
                } catch (Throwable th5) {
                    a();
                    throw th5;
                }
            }
        }
        return zS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.Set[]] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object[]] */
    public final void x(m0.h hVar) {
        Object obj;
        m0.h hVar2;
        do {
            obj = this.f7118g.get();
            if (obj == null || obj.equals(z.f7151a)) {
                hVar2 = hVar;
            } else if (obj instanceof Set) {
                hVar2 = new Set[]{obj, hVar};
            } else {
                if (!(obj instanceof Object[])) {
                    ad.o.m(this.f7118g, "corrupt pendingModifications: ");
                    return;
                }
                Set[] setArr = (Set[]) obj;
                int length = setArr.length;
                ?? CopyOf = Arrays.copyOf(setArr, length + 1);
                CopyOf[length] = hVar;
                hVar2 = CopyOf;
            }
        } while (!this.f7118g.compareAndSet(obj, hVar2));
        if (obj == null) {
            synchronized (this.f7119h) {
                n();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.y.y(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.f7119h
            monitor-enter(r0)
            r14.u(r15)     // Catch: java.lang.Throwable -> L4f
            p.f0 r1 = r14.f7124n     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r15 = r1.g(r15)     // Catch: java.lang.Throwable -> L4f
            if (r15 == 0) goto L61
            boolean r1 = r15 instanceof p.g0     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L5c
            p.g0 r15 = (p.g0) r15     // Catch: java.lang.Throwable -> L4f
            java.lang.Object[] r1 = r15.f9561b     // Catch: java.lang.Throwable -> L4f
            long[] r15 = r15.f9560a     // Catch: java.lang.Throwable -> L4f
            int r2 = r15.length     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + (-2)
            if (r2 < 0) goto L61
            r3 = 0
            r4 = r3
        L1f:
            r5 = r15[r4]     // Catch: java.lang.Throwable -> L4f
            long r7 = ~r5     // Catch: java.lang.Throwable -> L4f
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r2
            int r7 = ~r7     // Catch: java.lang.Throwable -> L4f
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L39:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]     // Catch: java.lang.Throwable -> L4f
            k0.i0 r10 = (k0.i0) r10     // Catch: java.lang.Throwable -> L4f
            r14.u(r10)     // Catch: java.lang.Throwable -> L4f
            goto L51
        L4f:
            r14 = move-exception
            goto L63
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L39
        L55:
            if (r7 != r8) goto L61
        L57:
            if (r4 == r2) goto L61
            int r4 = r4 + 1
            goto L1f
        L5c:
            k0.i0 r15 = (k0.i0) r15     // Catch: java.lang.Throwable -> L4f
            r14.u(r15)     // Catch: java.lang.Throwable -> L4f
        L61:
            monitor-exit(r0)
            return
        L63:
            monitor-exit(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.y.z(java.lang.Object):void");
    }
}
