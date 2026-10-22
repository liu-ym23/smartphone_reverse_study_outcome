package p7;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class m extends m7.n {

    /* renamed from: a, reason: collision with root package name */
    public static final m f9880a = new m();

    private m() {
    }

    public static m7.g a(u7.a aVar, u7.b bVar) {
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 5) {
            return new m7.l(aVar.W());
        }
        if (iOrdinal == 6) {
            o7.j jVar = new o7.j(aVar.W());
            m7.l lVar = new m7.l();
            lVar.f8267c = jVar;
            return lVar;
        }
        if (iOrdinal == 7) {
            Boolean boolValueOf = Boolean.valueOf(aVar.O());
            m7.l lVar2 = new m7.l();
            lVar2.f8267c = boolValueOf;
            return lVar2;
        }
        if (iOrdinal == 8) {
            aVar.U();
            return m7.i.f8265c;
        }
        g5.f.r(bVar, "Unexpected token: ");
        return null;
    }

    @Override // m7.n
    public final Object read(u7.a aVar) {
        m7.g fVar;
        m7.g fVar2;
        if (aVar instanceof o) {
            o oVar = (o) aVar;
            u7.b bVarY = oVar.Y();
            if (bVarY == u7.b.i || bVarY == u7.b.f14163f || bVarY == u7.b.f14165h || bVarY == u7.b.f14170n) {
                ad.o.f("Unexpected ", bVarY, " when reading a JsonElement.");
                return null;
            }
            m7.g gVar = (m7.g) oVar.l0();
            oVar.e0();
            return gVar;
        }
        u7.b bVarY2 = aVar.Y();
        int iOrdinal = bVarY2.ordinal();
        if (iOrdinal == 0) {
            aVar.d();
            fVar = new m7.f();
        } else if (iOrdinal != 2) {
            fVar = null;
        } else {
            aVar.e();
            fVar = new m7.j();
        }
        if (fVar == null) {
            return a(aVar, bVarY2);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.H()) {
                String strS = fVar instanceof m7.j ? aVar.S() : null;
                u7.b bVarY3 = aVar.Y();
                int iOrdinal2 = bVarY3.ordinal();
                if (iOrdinal2 == 0) {
                    aVar.d();
                    fVar2 = new m7.f();
                } else if (iOrdinal2 != 2) {
                    fVar2 = null;
                } else {
                    aVar.e();
                    fVar2 = new m7.j();
                }
                boolean z10 = fVar2 != null;
                if (fVar2 == null) {
                    fVar2 = a(aVar, bVarY3);
                }
                if (fVar instanceof m7.f) {
                    ((m7.f) fVar).k(fVar2);
                } else {
                    ((m7.j) fVar).j(strS, fVar2);
                }
                if (z10) {
                    arrayDeque.addLast(fVar);
                    fVar = fVar2;
                }
            } else {
                if (fVar instanceof m7.f) {
                    aVar.n();
                } else {
                    aVar.o();
                }
                if (arrayDeque.isEmpty()) {
                    return fVar;
                }
                fVar = (m7.g) arrayDeque.removeLast();
            }
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, m7.g gVar) {
        if (gVar == null || (gVar instanceof m7.i)) {
            cVar.C();
            return;
        }
        if (gVar instanceof m7.l) {
            m7.l lVarF = gVar.f();
            Serializable serializable = lVarF.f8267c;
            if (serializable instanceof Number) {
                cVar.R(lVarF.h());
                return;
            } else if (serializable instanceof Boolean) {
                cVar.T(lVarF.b());
                return;
            } else {
                cVar.S(lVarF.i());
                return;
            }
        }
        if (gVar instanceof m7.f) {
            cVar.e();
            ArrayList arrayList = gVar.d().f8264c;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                write(cVar, (m7.g) obj);
            }
            cVar.n();
            return;
        }
        if (!(gVar instanceof m7.j)) {
            g5.f.f(gVar.getClass(), "Couldn't write ");
            return;
        }
        cVar.g();
        Iterator it = ((o7.l) gVar.e().f8266c.entrySet()).iterator();
        while (((o7.k) it).hasNext()) {
            o7.m mVarB = ((o7.k) it).b();
            cVar.r((String) mVarB.getKey());
            write(cVar, (m7.g) mVarB.getValue());
        }
        cVar.o();
    }
}
