package ed;

import ad.d0;
import ad.e0;
import ad.g0;
import androidx.lifecycle.h0;
import d1.p;
import g0.v;
import hd.a0;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import kc.t;
import o1.s;
import od.c0;
import s.h1;
import s.w;
import u1.i0;
import u1.q;
import y.y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3783a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3784b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3785c = s.d.a();

    /* renamed from: d, reason: collision with root package name */
    public Object f3786d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public Object f3787e;

    /* JADX WARN: Multi-variable type inference failed */
    public e(boolean z10, xb.a aVar) {
        this.f3783a = z10;
        this.f3784b = (yb.l) aVar;
    }

    public IOException a(boolean z10, boolean z11, IOException iOException) {
        j jVar = (j) this.f3784b;
        if (iOException != null) {
            g(iOException);
        }
        return jVar.j(this, z11, z10, iOException);
    }

    public void b(i0 i0Var, float f5, long j10) {
        f1.b bVar = i0Var.f13838c;
        float fFloatValue = ((Number) ((s.c) this.f3785c).d()).floatValue();
        if (fFloatValue > 0.0f) {
            long jC = p.c(fFloatValue, j10);
            if (!this.f3783a) {
                f1.d.s(i0Var, jC, f5, 0L, null, 124);
                return;
            }
            float fE = c1.e.e(bVar.e());
            float fC = c1.e.c(bVar.e());
            p5.m mVar = bVar.f3859f;
            long jD = mVar.D();
            mVar.y().i();
            ((p5.m) ((a1.g) mVar.f9741f).f19f).y().m(0.0f, 0.0f, fE, fC, 1);
            f1.d.s(i0Var, jC, f5, 0L, null, 124);
            mVar.y().o();
            mVar.R(jD);
        }
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [xb.a, yb.l] */
    public void c(v.j jVar, t tVar) {
        ArrayList arrayList = (ArrayList) this.f3786d;
        boolean z10 = jVar instanceof v.h;
        if (z10) {
            arrayList.add(jVar);
        } else if (jVar instanceof v.i) {
            arrayList.remove(((v.i) jVar).f14311a);
        } else if (jVar instanceof v.d) {
            arrayList.add(jVar);
        } else if (jVar instanceof v.e) {
            arrayList.remove(((v.e) jVar).f14303a);
        } else if (jVar instanceof v.b) {
            arrayList.add(jVar);
        } else if (jVar instanceof v.c) {
            arrayList.remove(((v.c) jVar).f14302a);
        } else if (!(jVar instanceof v.a)) {
            return;
        } else {
            arrayList.remove(((v.a) jVar).f14301a);
        }
        v.j jVar2 = (v.j) kb.l.D0(arrayList);
        if (yb.k.a((v.j) this.f3787e, jVar2)) {
            return;
        }
        nb.c cVar = null;
        if (jVar2 != null) {
            g0.g gVar = (g0.g) ((yb.l) this.f3784b).invoke();
            float f5 = z10 ? gVar.f4144c : jVar instanceof v.d ? gVar.f4143b : jVar instanceof v.b ? gVar.f4142a : 0.0f;
            h1 h1Var = g0.p.f4177a;
            if (!(jVar2 instanceof v.h) && ((jVar2 instanceof v.d) || (jVar2 instanceof v.b))) {
                h1Var = new h1(45, 0, w.f11153b);
            }
            kc.w.u(tVar, null, null, new v(this, f5, h1Var, null), 3);
        } else {
            v.j jVar3 = (v.j) this.f3787e;
            h1 h1Var2 = g0.p.f4177a;
            if (!(jVar3 instanceof v.h) && !(jVar3 instanceof v.d) && (jVar3 instanceof v.b)) {
                h1Var2 = new h1(150, 0, w.f11153b);
            }
            kc.w.u(tVar, null, null, new h0(this, h1Var2, cVar, 5), 3);
        }
        this.f3787e = jVar2;
    }

    public g0 d(e0 e0Var) throws IOException {
        fd.d dVar = (fd.d) this.f3786d;
        try {
            String strD = e0.d(e0Var, HttpHeaders.CONTENT_TYPE);
            long jH = dVar.h(e0Var);
            od.i0 i0VarE = dVar.e(e0Var);
            d dVar2 = new d();
            i0VarE.getClass();
            dVar2.f3782k = this;
            dVar2.f9480c = i0VarE;
            dVar2.f3778f = jH;
            dVar2.f3780h = true;
            if (jH == 0) {
                dVar2.d(null);
            }
            VarHandle.storeStoreFence();
            return new g0(strD, jH, new c0(dVar2));
        } catch (IOException e10) {
            g(e10);
            throw e10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int e(n6.a aVar, v1.t tVar, boolean z10) {
        Object[] objArr;
        int i;
        int i3;
        o1.d dVar = (o1.d) this.f3785c;
        q qVar = (q) this.f3787e;
        if (this.f3783a) {
            return 0;
        }
        try {
            this.f3783a = true;
            ma.a aVarA = ((a2.i) this.f3786d).A(aVar, tVar);
            p.n nVar = (p.n) aVarA.f8533b;
            int iH = nVar.h();
            for (int i10 = 0; i10 < iH; i10++) {
                s sVar = (s) nVar.j(i10);
                if (!sVar.f9074d && !sVar.f9078h) {
                }
                objArr = false;
                break;
            }
            objArr = true;
            int iH2 = nVar.h();
            for (int i11 = 0; i11 < iH2; i11++) {
                s sVar2 = (s) nVar.j(i11);
                if (objArr != false || o1.q.a(sVar2)) {
                    ((u1.g0) this.f3784b).y(sVar2.f9073c, (q) this.f3787e, sVar2.i, true);
                    if (!qVar.f13903c.g()) {
                        dVar.a(sVar2.f9071a, qVar, o1.q.a(sVar2));
                        qVar.clear();
                    }
                }
            }
            boolean zB = dVar.b(aVarA, z10);
            if (aVarA.f8532a) {
                i = 0;
            } else {
                int iH3 = nVar.h();
                for (int i12 = 0; i12 < iH3; i12++) {
                    s sVar3 = (s) nVar.j(i12);
                    if (!c1.b.c(o1.q.d(sVar3, true), 0L) && sVar3.b()) {
                        i = 1;
                        break;
                    }
                }
                i = 0;
            }
            int iH4 = nVar.h();
            int i13 = 0;
            while (true) {
                if (i13 >= iH4) {
                    i3 = 0;
                    break;
                }
                if (((s) nVar.j(i13)).b()) {
                    i3 = 1;
                    break;
                }
                i13++;
            }
            int i14 = (zB ? 1 : 0) | (i << 1) | (i3 << 2);
            this.f3783a = false;
            return i14;
        } catch (Throwable th) {
            this.f3783a = false;
            throw th;
        }
    }

    public d0 f(boolean z10) throws IOException {
        try {
            d0 d0VarB = ((fd.d) this.f3786d).b(z10);
            if (d0VarB == null) {
                return d0VarB;
            }
            d0VarB.f464m = this;
            return d0VarB;
        } catch (IOException e10) {
            g(e10);
            throw e10;
        }
    }

    public void g(IOException iOException) {
        this.f3783a = true;
        ((f) this.f3785c).b(iOException);
        m mVarD = ((fd.d) this.f3786d).d();
        j jVar = (j) this.f3784b;
        synchronized (mVarD) {
            try {
                if (!(iOException instanceof a0)) {
                    if (!(mVarD.f3825f != null) || (iOException instanceof hd.a)) {
                        mVarD.i = true;
                        if (mVarD.f3830l == 0) {
                            m.c(jVar.f3801c, mVarD.f3820a, iOException);
                            mVarD.f3829k++;
                        }
                    }
                } else if (((a0) iOException).f5467c == 8) {
                    int i = mVarD.f3831m + 1;
                    mVarD.f3831m = i;
                    if (i > 1) {
                        mVarD.i = true;
                        mVarD.f3829k++;
                    }
                } else if (((a0) iOException).f5467c != 9 || !jVar.f3812q) {
                    mVarD.i = true;
                    mVarD.f3829k++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void h(int i, int i3) {
        if (i < 0.0f) {
            g5.f.d(i, 41, "Index should be non-negative (");
            return;
        }
        ((k0.h1) this.f3784b).h(i);
        y yVar = (y) this.f3787e;
        if (i != yVar.f15838f) {
            yVar.f15838f = i;
            int i10 = (i / 30) * 30;
            yVar.f15837c.setValue(p5.f.O(Math.max(i10 - 100, 0), i10 + 130));
        }
        ((k0.h1) this.f3785c).h(i3);
    }
}
