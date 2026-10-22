package c1;

import i1.f0;
import i1.h0;
import ia.b0;
import j1.y;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import n.f1;
import n.y0;
import o4.d0;
import ob.c0;
import ob.e0;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1833a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1834b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1835c = n.d.a();

    /* renamed from: d, reason: collision with root package name */
    public Object f1836d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public Object f1837e;

    /* JADX WARN: Multi-variable type inference failed */
    public o(boolean z4, p7.a aVar) {
        this.f1833a = z4;
        this.f1834b = (q7.m) aVar;
    }

    public IOException a(boolean z4, boolean z10, IOException iOException) {
        eb.i iVar = (eb.i) this.f1834b;
        if (iOException != null) {
            g(iOException);
        }
        return iVar.j(this, z10, z4, iOException);
    }

    public void b(h0 h0Var, float f10, long j2) {
        w0.b bVar = h0Var.f4489f;
        float fFloatValue = ((Number) ((n.c) this.f1835c).c()).floatValue();
        if (fFloatValue > 0.0f) {
            long jB = u0.m.b(fFloatValue, j2);
            if (!this.f1833a) {
                w0.d.H(h0Var, jB, f10, 0L, 124);
                return;
            }
            float fD = t0.e.d(bVar.d());
            float fB = t0.e.b(bVar.d());
            u5.h hVar = bVar.f10630g;
            long jB2 = hVar.b();
            hVar.a().h();
            ((u5.h) ((d0) hVar.f10129a).f7326g).a().e(0.0f, 0.0f, fD, fB, 1);
            w0.d.H(h0Var, jB, f10, 0L, 124);
            hVar.a().g();
            hVar.j(jB2);
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [p7.a, q7.m] */
    public void c(q.h hVar, b0 b0Var) {
        ArrayList arrayList = (ArrayList) this.f1836d;
        boolean z4 = hVar instanceof q.f;
        if (z4) {
            arrayList.add(hVar);
        } else if (hVar instanceof q.g) {
            arrayList.remove(((q.g) hVar).f8613a);
        } else if (hVar instanceof q.d) {
            arrayList.add(hVar);
        } else if (hVar instanceof q.e) {
            arrayList.remove(((q.e) hVar).f8612a);
        } else if (hVar instanceof q.b) {
            arrayList.add(hVar);
        } else if (hVar instanceof q.c) {
            arrayList.remove(((q.c) hVar).f8611a);
        } else if (!(hVar instanceof q.a)) {
            return;
        } else {
            arrayList.remove(((q.a) hVar).f8610a);
        }
        q.h hVar2 = (q.h) d7.r.X0(arrayList);
        if (q7.k.a((q.h) this.f1837e, hVar2)) {
            return;
        }
        g7.d dVar = null;
        if (hVar2 != null) {
            x.f fVar = (x.f) ((q7.m) this.f1834b).c();
            float f10 = z4 ? fVar.f11008c : hVar instanceof q.d ? fVar.f11007b : hVar instanceof q.b ? fVar.f11006a : 0.0f;
            f1 f1Var = x.o.f11044a;
            if (!(hVar2 instanceof q.f) && ((hVar2 instanceof q.d) || (hVar2 instanceof q.b))) {
                f1Var = new f1(45, n.u.f6737b);
            }
            ia.d0.s(b0Var, null, null, new y0(this, f10, f1Var, null), 3);
        } else {
            q.h hVar3 = (q.h) this.f1837e;
            f1 f1Var2 = x.o.f11044a;
            if (!(hVar3 instanceof q.f) && !(hVar3 instanceof q.d) && (hVar3 instanceof q.b)) {
                f1Var2 = new f1(150, n.u.f6737b);
            }
            ia.d0.s(b0Var, null, null, new p.v(this, f1Var2, dVar, 9), 3);
        }
        this.f1837e = hVar2;
    }

    public eb.l d() {
        eb.i iVar = (eb.i) this.f1834b;
        if (iVar.f3281o) {
            throw new IllegalStateException("Check failed.");
        }
        iVar.f3281o = true;
        iVar.f3276j.j();
        eb.m mVarG = ((fb.e) this.f1836d).g();
        mVarG.getClass();
        Socket socket = mVarG.f3298d;
        q7.k.b(socket);
        e0 e0Var = mVarG.f3302h;
        q7.k.b(e0Var);
        c0 c0Var = mVarG.f3303i;
        q7.k.b(c0Var);
        socket.setSoTimeout(0);
        mVarG.k();
        return new eb.l(e0Var, c0Var, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int e(q6.b bVar, y yVar, boolean z4) {
        Object[] objArr;
        int i2;
        int i10;
        b bVar2 = (b) this.f1835c;
        i1.p pVar = (i1.p) this.f1837e;
        if (this.f1833a) {
            return 0;
        }
        try {
            this.f1833a = true;
            q6.b bVarB = ((a7.d) this.f1836d).B(bVar, yVar);
            k.n nVar = (k.n) bVarB.f8788h;
            int iC = nVar.c();
            for (int i11 = 0; i11 < iC; i11++) {
                l lVar = (l) nVar.d(i11);
                if (!lVar.f1807d && !lVar.f1811h) {
                }
                objArr = false;
                break;
            }
            objArr = true;
            int iC2 = nVar.c();
            for (int i12 = 0; i12 < iC2; i12++) {
                l lVar2 = (l) nVar.d(i12);
                if (objArr != false || ib.k.l(lVar2)) {
                    ((f0) this.f1834b).t(lVar2.f1806c, (i1.p) this.f1837e, lVar2.f1812i, true);
                    if (!pVar.f4559f.g()) {
                        bVar2.a(lVar2.f1804a, pVar, ib.k.l(lVar2));
                        pVar.clear();
                    }
                }
            }
            boolean zB = bVar2.b(bVarB, z4);
            int iC3 = nVar.c();
            int i13 = 0;
            while (true) {
                if (i13 >= iC3) {
                    i2 = 0;
                    break;
                }
                l lVar3 = (l) nVar.d(i13);
                if (!t0.b.b(ib.k.G(lVar3, true), 0L) && lVar3.b()) {
                    i2 = 1;
                    break;
                }
                i13++;
            }
            int iC4 = nVar.c();
            int i14 = 0;
            while (true) {
                if (i14 >= iC4) {
                    i10 = 0;
                    break;
                }
                if (((l) nVar.d(i14)).b()) {
                    i10 = 1;
                    break;
                }
                i14++;
            }
            int i15 = (zB ? 1 : 0) | (i2 << 1) | (i10 << 2);
            this.f1833a = false;
            return i15;
        } catch (Throwable th) {
            this.f1833a = false;
            throw th;
        }
    }

    public ab.y f(boolean z4) throws IOException {
        try {
            ab.y yVarE = ((fb.e) this.f1836d).e(z4);
            if (yVarE == null) {
                return yVarE;
            }
            yVarE.f683m = this;
            return yVarE;
        } catch (IOException e10) {
            g(e10);
            throw e10;
        }
    }

    public void g(IOException iOException) {
        this.f1833a = true;
        ((eb.e) this.f1835c).c(iOException);
        eb.m mVarG = ((fb.e) this.f1836d).g();
        eb.i iVar = (eb.i) this.f1834b;
        synchronized (mVarG) {
            try {
                if (!(iOException instanceof hb.c0)) {
                    if (!(mVarG.f3301g != null) || (iOException instanceof hb.a)) {
                        mVarG.f3304j = true;
                        if (mVarG.f3307m == 0) {
                            eb.m.d(iVar.f3272f, mVarG.f3296b, iOException);
                            mVarG.f3306l++;
                        }
                    }
                } else if (((hb.c0) iOException).f4274f == 8) {
                    int i2 = mVarG.f3308n + 1;
                    mVarG.f3308n = i2;
                    if (i2 > 1) {
                        mVarG.f3304j = true;
                        mVarG.f3306l++;
                    }
                } else if (((hb.c0) iOException).f4274f != 9 || !iVar.f3286t) {
                    mVarG.f3304j = true;
                    mVarG.f3306l++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
