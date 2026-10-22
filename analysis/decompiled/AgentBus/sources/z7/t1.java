package z7;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* loaded from: classes.dex */
public class t1 extends q7.x {
    public static e0 j(q7.c cVar) {
        w7.f fVarY = cVar.y();
        return fVarY instanceof e0 ? (e0) fVarY : d.f11858g;
    }

    @Override // q7.x
    public final w7.g a(q7.h hVar) {
        e0 e0VarJ = j(hVar);
        String name = hVar.getName();
        String strA = hVar.A();
        Object obj = hVar.f8801g;
        q7.k.e(name, "name");
        q7.k.e(strA, "signature");
        return new g0(e0VarJ, name, strA, null, obj);
    }

    @Override // q7.x
    public final w7.d b(Class cls) {
        return c.a(cls);
    }

    @Override // q7.x
    public final w7.f c(Class cls, String str) {
        nb.f fVar = c.f11849a;
        q7.k.e(cls, "jClass");
        return (w7.f) c.f11850b.w(cls);
    }

    @Override // q7.x
    public final w7.j d(q7.n nVar) {
        return new k0(j(nVar), nVar.f8803i, nVar.f8804j, nVar.f8801g);
    }

    @Override // q7.x
    public final w7.q e(na.j jVar) {
        return new x0(j(jVar), jVar.f8803i, jVar.f8804j, jVar.f8801g);
    }

    @Override // q7.x
    public final w7.s f(q7.p pVar) {
        return new a1(j(pVar), pVar.f8803i, pVar.f8804j, pVar.f8801g);
    }

    @Override // q7.x
    public final String g(q7.g gVar) throws IOException {
        g0 g0VarB;
        Metadata metadata = (Metadata) gVar.getClass().getAnnotation(Metadata.class);
        g0 g0Var = null;
        if (metadata != null) {
            String[] strArrD1 = metadata.d1();
            if (strArrD1.length == 0) {
                strArrD1 = null;
            }
            if (strArrD1 != null) {
                String[] strArrD2 = metadata.d2();
                f9.h hVar = d9.h.f3015a;
                q7.k.e(strArrD2, "strings");
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(d9.a.a(strArrD1));
                f9.h hVar2 = d9.h.f3015a;
                d9.g gVarG = d9.h.g(byteArrayInputStream, strArrD2);
                f9.h hVar3 = d9.h.f3015a;
                c9.a aVar = z8.x.A;
                aVar.getClass();
                f9.e eVar = new f9.e(byteArrayInputStream);
                f9.a aVar2 = (f9.a) aVar.a(eVar, hVar3);
                try {
                    eVar.a(0);
                    if (!aVar2.isInitialized()) {
                        f9.r rVar = new f9.r(new a4.u(4).getMessage());
                        rVar.f3597f = aVar2;
                        throw rVar;
                    }
                    z8.x xVar = (z8.x) aVar2;
                    d9.f fVar = new d9.f(metadata.mv(), (metadata.xi() & 8) != 0);
                    Class<?> cls = gVar.getClass();
                    z8.v0 v0Var = xVar.f12458u;
                    q7.k.d(v0Var, "proto.typeTable");
                    g0Var = new g0(d.f11858g, (i8.l0) x1.f(cls, xVar, gVarG, new b9.g(v0Var), fVar, y7.a.f11697n));
                } catch (f9.r e10) {
                    e10.f3597f = aVar2;
                    throw e10;
                }
            }
        }
        if (g0Var == null || (g0VarB = x1.b(g0Var)) == null) {
            return super.g(gVar);
        }
        g9.g gVar2 = u1.f11967a;
        f8.t tVarF = g0VarB.B();
        StringBuilder sb2 = new StringBuilder();
        u1.a(tVarF, sb2);
        List listX0 = tVarF.x0();
        q7.k.d(listX0, "invoke.valueParameters");
        d7.r.T0(listX0, sb2, ", ", "(", ")", b.f11845r, 48);
        sb2.append(" -> ");
        v9.v vVarF = tVarF.f();
        q7.k.b(vVarF);
        sb2.append(u1.d(vVarF));
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // q7.x
    public final String h(q7.m mVar) {
        return g(mVar);
    }

    @Override // q7.x
    public final w7.u i(w7.d dVar, List list, boolean z4) {
        if (!(dVar instanceof q7.d)) {
            return n7.o.h(dVar, list, z4, Collections.EMPTY_LIST);
        }
        Class clsC = ((q7.d) dVar).c();
        nb.f fVar = c.f11849a;
        q7.k.e(clsC, "jClass");
        q7.k.e(list, "arguments");
        if (list.isEmpty()) {
            return z4 ? (w7.u) c.f11852d.w(clsC) : (w7.u) c.f11851c.w(clsC);
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) c.f11853e.w(clsC);
        c7.j jVar = new c7.j(list, Boolean.valueOf(z4));
        Object obj = concurrentHashMap.get(jVar);
        if (obj == null) {
            m1 m1VarH = n7.o.h(c.a(clsC), list, z4, d7.z.f2978f);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(jVar, m1VarH);
            obj = objPutIfAbsent == null ? m1VarH : objPutIfAbsent;
        }
        return (w7.u) obj;
    }
}
