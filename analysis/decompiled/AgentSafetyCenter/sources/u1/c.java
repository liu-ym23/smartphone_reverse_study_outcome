package u1;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.semantics.AppendedSemanticsElement;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.util.HashSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends w0.l implements w, n, v1, s1, t1.f, t1.h, q1, v, o, b1.d, b1.m, b1.o, o1, a1.a {

    /* renamed from: s, reason: collision with root package name */
    public w0.k f13733s;

    /* renamed from: t, reason: collision with root package name */
    public t1.a f13734t;

    /* renamed from: u, reason: collision with root package name */
    public HashSet f13735u;

    @Override // u1.s1
    public final void A() {
        w0.k kVar = this.f13733s;
        kVar.getClass();
        p5.i iVar = ((o1.z) kVar).f9107h;
        o1.x xVar = (o1.x) iVar.f9731f;
        o1.z zVar = (o1.z) iVar.f9733h;
        if (xVar == o1.x.f9099f) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            o1.y yVar = new o1.y(zVar, 0);
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            motionEventObtain.setSource(0);
            yVar.invoke(motionEventObtain);
            motionEventObtain.recycle();
            iVar.f9731f = o1.x.f9098c;
            zVar.f9106g = false;
            iVar.f9732g = null;
        }
    }

    public final void B0(boolean z10) {
        if (!this.f15126r) {
            r1.a.b("initializeModifier called on unattached node");
        }
        w0.k kVar = this.f13733s;
        if ((this.f15116g & 32) != 0) {
            if (kVar instanceof t1.c) {
                b bVar = new b(this, 0);
                p.a0 a0Var = ((v1.t) f.v(this)).f14574x0;
                if (a0Var.f(bVar) < 0) {
                    a0Var.a(bVar);
                }
            }
            if (kVar instanceof t1.g) {
                t1.g gVar = (t1.g) kVar;
                t1.a aVar = this.f13734t;
                if (aVar == null || !aVar.d(gVar.getKey())) {
                    t1.a aVar2 = new t1.a();
                    aVar2.f13126b = gVar;
                    this.f13734t = aVar2;
                    x1 x1Var = f.u(this).H.f13745e;
                    x1Var.getClass();
                    if (x1Var.f13973s) {
                        t1.d modifierLocalManager = ((v1.t) f.v(this)).getModifierLocalManager();
                        t1.i key = gVar.getKey();
                        modifierLocalManager.f13129b.b(this);
                        modifierLocalManager.f13130c.b(key);
                        modifierLocalManager.a();
                    }
                } else {
                    aVar.f13126b = gVar;
                    t1.d modifierLocalManager2 = ((v1.t) f.v(this)).getModifierLocalManager();
                    t1.i key2 = gVar.getKey();
                    modifierLocalManager2.f13129b.b(this);
                    modifierLocalManager2.f13130c.b(key2);
                    modifierLocalManager2.a();
                }
            }
        }
        if ((this.f15116g & 4) != 0 && !z10) {
            f.s(this, 2).O0();
        }
        if ((this.f15116g & 2) != 0) {
            x1 x1Var2 = f.u(this).H.f13745e;
            x1Var2.getClass();
            if (x1Var2.f13973s) {
                g1 g1Var = this.f15120l;
                g1Var.getClass();
                ((y) g1Var).e1(this);
                m1 m1Var = g1Var.M;
                if (m1Var != null) {
                    ((v1.h1) m1Var).c();
                }
            }
            if (!z10) {
                f.s(this, 2).O0();
                f.u(this).C();
            }
        }
        if (kVar instanceof x.o) {
            ((x.o) kVar).f15469c.f15488k = f.u(this);
        }
        if ((this.f15116g & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 && (kVar instanceof y.d)) {
            x1 x1Var3 = f.u(this).H.f13745e;
            x1Var3.getClass();
            if (x1Var3.f13973s) {
                f.u(this).C();
            }
        }
        int i = this.f15116g;
        if ((i & 16) != 0 && (kVar instanceof o1.z)) {
            ((o1.z) kVar).f9107h.f9730c = this.f15120l;
        }
        if ((i & 8) != 0) {
            ((v1.t) f.v(this)).z();
        }
    }

    public final void C0() {
        if (!this.f15126r) {
            r1.a.b("unInitializeModifier called on unattached node");
        }
        w0.k kVar = this.f13733s;
        if ((this.f15116g & 32) != 0) {
            if (kVar instanceof t1.g) {
                t1.d modifierLocalManager = ((v1.t) f.v(this)).getModifierLocalManager();
                t1.i key = ((t1.g) kVar).getKey();
                modifierLocalManager.f13131d.b(f.u(this));
                modifierLocalManager.f13132e.b(key);
                modifierLocalManager.a();
            }
            if (kVar instanceof t1.c) {
                ((t1.c) kVar).e(f.f13777a);
            }
        }
        if ((this.f15116g & 8) != 0) {
            ((v1.t) f.v(this)).z();
        }
    }

    public final void D0() {
        if (this.f15126r) {
            this.f13735u.clear();
            ((v1.t) f.v(this)).getSnapshotObserver().a(this, e.f13753f, new b(this, 1));
        }
    }

    @Override // u1.n
    public final void H() {
        f.l(this);
    }

    @Override // u1.s1
    public final void I() {
        w0.k kVar = this.f13733s;
        kVar.getClass();
        ((o1.z) kVar).f9107h.getClass();
    }

    @Override // t1.f
    public final t1.e R() {
        t1.a aVar = this.f13734t;
        return aVar != null ? aVar : t1.b.f13127b;
    }

    @Override // b1.m
    public final void U(b1.j jVar) {
        w0.k kVar = this.f13733s;
        r1.a.b("applyFocusProperties called on wrong node");
        kVar.getClass();
        throw new ClassCastException();
    }

    @Override // a1.a
    public final o2.c a() {
        return f.u(this).A;
    }

    @Override // u1.n
    public final void b(i0 i0Var) {
        w0.k kVar = this.f13733s;
        kVar.getClass();
        ((a1.f) kVar).b(i0Var);
    }

    @Override // u1.q1
    public final Object b0(o2.c cVar, Object obj) {
        w0.k kVar = this.f13733s;
        kVar.getClass();
        return ((s1.l0) kVar).h();
    }

    @Override // u1.l
    public final void c() {
        if (this.f13733s instanceof o1.z) {
            A();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r8v3, types: [xb.a, yb.l] */
    @Override // t1.f, t1.h
    public final Object d(t1.i iVar) {
        c1 c1Var;
        this.f13735u.add(iVar);
        if (!this.f15114c.f15126r) {
            r1.a.b("visitAncestors called on an unattached node");
        }
        w0.l lVar = this.f15114c.i;
        g0 g0VarU = f.u(this);
        while (g0VarU != null) {
            if ((g0VarU.H.f13746f.f15117h & 32) != 0) {
                while (lVar != null) {
                    if ((lVar.f15116g & 32) != 0) {
                        m mVarE = lVar;
                        ?? eVar = 0;
                        while (mVarE != 0) {
                            if (mVarE instanceof t1.f) {
                                t1.f fVar = (t1.f) mVarE;
                                if (fVar.R().d(iVar)) {
                                    return fVar.R().h(iVar);
                                }
                            } else if ((mVarE.f15116g & 32) != 0 && (mVarE instanceof m)) {
                                w0.l lVar2 = mVarE.f13866t;
                                int i = 0;
                                mVarE = mVarE;
                                eVar = eVar;
                                while (lVar2 != null) {
                                    if ((lVar2.f15116g & 32) != 0) {
                                        i++;
                                        eVar = eVar;
                                        if (i == 1) {
                                            mVarE = lVar2;
                                        } else {
                                            if (eVar == 0) {
                                                eVar = new m0.e(new w0.l[16]);
                                            }
                                            if (mVarE != 0) {
                                                eVar.b(mVarE);
                                                mVarE = 0;
                                            }
                                            eVar.b(lVar2);
                                        }
                                    }
                                    lVar2 = lVar2.f15118j;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                }
                                if (i == 1) {
                                }
                            }
                            mVarE = f.e(eVar);
                        }
                    }
                    lVar = lVar.i;
                }
            }
            g0VarU = g0VarU.t();
            lVar = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
        }
        return iVar.f13135a.invoke();
    }

    @Override // a1.a
    public final long e() {
        return ac.a.i0(f.s(this, 128).f11279g);
    }

    @Override // u1.w
    public final s1.g0 f(o0 o0Var, s1.e0 e0Var, long j10) {
        w0.k kVar = this.f13733s;
        kVar.getClass();
        return ((s1.r) kVar).f(o0Var, e0Var, j10);
    }

    @Override // u1.v1
    public final void f0(a2.k kVar) {
        w0.k kVar2 = this.f13733s;
        kVar2.getClass();
        AppendedSemanticsElement appendedSemanticsElement = (AppendedSemanticsElement) kVar2;
        a2.k kVar3 = new a2.k();
        kVar3.f77g = appendedSemanticsElement.f987c;
        appendedSemanticsElement.f988f.invoke(kVar3);
        kVar.getClass();
        p.f0 f0Var = kVar.f75c;
        if (kVar3.f77g) {
            kVar.f77g = true;
        }
        if (kVar3.f78h) {
            kVar.f78h = true;
        }
        p.f0 f0Var2 = kVar3.f75c;
        Object[] objArr = f0Var2.f9553b;
        Object[] objArr2 = f0Var2.f9554c;
        long[] jArr = f0Var2.f9552a;
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
                        int i11 = (i << 3) + i10;
                        Object obj = objArr[i11];
                        Object obj2 = objArr2[i11];
                        a2.x xVar = (a2.x) obj;
                        if (!f0Var.b(xVar)) {
                            f0Var.m(xVar, obj2);
                        } else if (obj2 instanceof a2.a) {
                            Object objG = f0Var.g(xVar);
                            objG.getClass();
                            a2.a aVar = (a2.a) objG;
                            String str = aVar.f29a;
                            if (str == null) {
                                str = ((a2.a) obj2).f29a;
                            }
                            jb.b bVar = aVar.f30b;
                            if (bVar == null) {
                                bVar = ((a2.a) obj2).f30b;
                            }
                            f0Var.m(xVar, new a2.a(str, bVar));
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

    @Override // a1.a
    public final o2.l getLayoutDirection() {
        return f.u(this).B;
    }

    @Override // u1.s1
    public final boolean h0() {
        w0.k kVar = this.f13733s;
        kVar.getClass();
        ((o1.z) kVar).f9107h.getClass();
        return true;
    }

    @Override // u1.o1
    public final boolean o() {
        return this.f15126r;
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // u1.s1
    public final void q(o1.j jVar, o1.k kVar, long j10) {
        boolean z10;
        boolean z11;
        boolean z12;
        w0.k kVar2 = this.f13733s;
        kVar2.getClass();
        p5.i iVar = ((o1.z) kVar2).f9107h;
        o1.z zVar = (o1.z) iVar.f9733h;
        ?? r12 = jVar.f9056a;
        int size = r12.size();
        for (int i = 0; i < size; i++) {
            o1.s sVar = (o1.s) r12.get(i);
            if (o1.q.a(sVar) || o1.q.b(sVar)) {
                z10 = false;
                break;
            }
        }
        z10 = true;
        if (!z10) {
            z11 = false;
            break;
        }
        int size2 = r12.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (((o1.s) r12.get(i3)).b()) {
                z11 = false;
                break;
            }
        }
        z11 = true;
        if (zVar.f9106g) {
            z12 = true;
        } else {
            int size3 = r12.size();
            int i10 = 0;
            while (true) {
                if (i10 < size3) {
                    o1.s sVar2 = (o1.s) r12.get(i10);
                    if (o1.q.a(sVar2) || o1.q.b(sVar2)) {
                        break;
                    } else {
                        i10++;
                    }
                } else if (z11) {
                    break;
                } else {
                    z12 = false;
                }
            }
            z12 = true;
        }
        if (((o1.x) iVar.f9731f) != o1.x.f9100g) {
            if (kVar == o1.k.f9059c && z12) {
                iVar.f9732g = jVar;
                iVar.n(jVar, !z10 || zVar.f9106g);
            }
            if (kVar == o1.k.f9060f && z10 && jVar.equals((o1.j) iVar.f9732g) && zVar.f9106g) {
                int size4 = r12.size();
                for (int i11 = 0; i11 < size4; i11++) {
                    ((o1.s) r12.get(i11)).a();
                }
            }
            if (kVar == o1.k.f9061g && !z12 && !jVar.equals((o1.j) iVar.f9732g)) {
                iVar.n(jVar, true);
            }
        }
        if (kVar == o1.k.f9061g) {
            int size5 = r12.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size5) {
                    iVar.f9731f = o1.x.f9098c;
                    ((o1.z) iVar.f9733h).f9106g = false;
                    iVar.f9732g = null;
                    break;
                } else if (!o1.q.b((o1.s) r12.get(i12))) {
                    break;
                } else {
                    i12++;
                }
            }
            if (jVar.equals((o1.j) iVar.f9732g) && z10) {
                int size6 = r12.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size6) {
                        break;
                    }
                    if (!((o1.s) r12.get(i13)).b()) {
                        i13++;
                    } else if (!zVar.f9106g) {
                        iVar.C(jVar);
                        return;
                    }
                }
                int size7 = r12.size();
                for (int i14 = 0; i14 < size7; i14++) {
                    ((o1.s) r12.get(i14)).a();
                }
            }
        }
    }

    @Override // w0.l
    public final void t0() {
        B0(true);
    }

    public final String toString() {
        return this.f13733s.toString();
    }

    @Override // w0.l
    public final void u0() {
        C0();
    }

    @Override // b1.d
    public final void w(b1.p pVar) {
        w0.k kVar = this.f13733s;
        r1.a.b("onFocusEvent called on wrong node");
        kVar.getClass();
        throw new ClassCastException();
    }

    @Override // u1.o
    public final void z(g1 g1Var) {
        w0.k kVar = this.f13733s;
        kVar.getClass();
        y.d dVar = (y.d) kVar;
        if (dVar.f15733c) {
            return;
        }
        dVar.f15733c = true;
        nb.i iVar = dVar.f15734f;
        if (iVar != null) {
            iVar.resumeWith(jb.v.f6774a);
        }
        dVar.f15734f = null;
    }

    @Override // u1.v
    public final void Z(s1.q qVar) {
    }

    @Override // u1.v
    public final void m(long j10) {
    }
}
