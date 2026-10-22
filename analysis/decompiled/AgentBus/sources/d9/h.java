package d9;

import a4.u;
import c7.j;
import c9.l;
import d7.r;
import d7.s;
import d7.t;
import f9.n;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w7.e0;
import z8.b0;
import z8.f0;
import z8.i;
import z8.k;
import z8.p0;
import z8.x;
import z8.x0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final f9.h f3015a;

    static {
        f9.h hVar = new f9.h();
        hVar.a(l.f2162a);
        hVar.a(l.f2163b);
        hVar.a(l.f2164c);
        hVar.a(l.f2165d);
        hVar.a(l.f2166e);
        hVar.a(l.f2167f);
        hVar.a(l.f2168g);
        hVar.a(l.f2169h);
        hVar.a(l.f2170i);
        hVar.a(l.f2171j);
        hVar.a(l.f2172k);
        hVar.a(l.f2173l);
        hVar.a(l.f2174m);
        hVar.a(l.f2175n);
        f3015a = hVar;
    }

    public static e a(k kVar, b9.f fVar, b9.g gVar) {
        String strU0;
        q7.k.e(kVar, "proto");
        q7.k.e(fVar, "nameResolver");
        q7.k.e(gVar, "typeTable");
        n nVar = l.f2162a;
        q7.k.d(nVar, "constructorSignature");
        c9.d dVar = (c9.d) e0.A(kVar, nVar);
        String string = (dVar == null || (dVar.f2103g & 1) != 1) ? "<init>" : fVar.getString(dVar.f2104h);
        if (dVar == null || (dVar.f2103g & 2) != 2) {
            List<x0> list = kVar.f12230j;
            q7.k.d(list, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(t.A0(list, 10));
            for (x0 x0Var : list) {
                q7.k.d(x0Var, "it");
                String strE = e(a.a.n0(x0Var, gVar), fVar);
                if (strE == null) {
                    return null;
                }
                arrayList.add(strE);
            }
            strU0 = r.U0(arrayList, "", "(", ")V", null, 56);
        } else {
            strU0 = fVar.getString(dVar.f2105i);
        }
        return new e(string, strU0);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v2 java.lang.String, still in use, count: 2, list:
          (r4v2 java.lang.String) from 0x0052: IF  (r4v2 java.lang.String) == (null java.lang.String)  -> B:23:0x0054 A[HIDDEN]
          (r4v2 java.lang.String) from 0x0055: PHI (r4v3 java.lang.String) = (r4v2 java.lang.String), (r4v5 java.lang.String) binds: [B:22:0x0052, B:20:0x0043] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public static d9.d b(z8.f0 r4, b9.f r5, b9.g r6, boolean r7) {
        /*
            java.lang.String r0 = "proto"
            q7.k.e(r4, r0)
            java.lang.String r0 = "nameResolver"
            q7.k.e(r5, r0)
            java.lang.String r0 = "typeTable"
            q7.k.e(r6, r0)
            f9.n r0 = c9.l.f2165d
            java.lang.String r1 = "propertySignature"
            q7.k.d(r0, r1)
            java.lang.Object r0 = w7.e0.A(r4, r0)
            c9.f r0 = (c9.f) r0
            r1 = 0
            if (r0 != 0) goto L20
            goto L54
        L20:
            int r2 = r0.f2117g
            r3 = 1
            r2 = r2 & r3
            if (r2 != r3) goto L29
            c9.c r0 = r0.f2118h
            goto L2a
        L29:
            r0 = r1
        L2a:
            if (r0 != 0) goto L2f
            if (r7 == 0) goto L2f
            goto L54
        L2f:
            if (r0 == 0) goto L39
            int r7 = r0.f2095g
            r7 = r7 & r3
            if (r7 != r3) goto L39
            int r7 = r0.f2096h
            goto L3b
        L39:
            int r7 = r4.f12137k
        L3b:
            if (r0 == 0) goto L4a
            int r2 = r0.f2095g
            r3 = 2
            r2 = r2 & r3
            if (r2 != r3) goto L4a
            int r4 = r0.f2097i
            java.lang.String r4 = r5.getString(r4)
            goto L55
        L4a:
            z8.p0 r4 = a.a.h0(r4, r6)
            java.lang.String r4 = e(r4, r5)
            if (r4 != 0) goto L55
        L54:
            return r1
        L55:
            d9.d r6 = new d9.d
            java.lang.String r5 = r5.getString(r7)
            r6.<init>(r5, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d9.h.b(z8.f0, b9.f, b9.g, boolean):d9.d");
    }

    public static e c(x xVar, b9.f fVar, b9.g gVar) {
        String strM;
        q7.k.e(xVar, "proto");
        q7.k.e(fVar, "nameResolver");
        q7.k.e(gVar, "typeTable");
        n nVar = l.f2163b;
        q7.k.d(nVar, "methodSignature");
        c9.d dVar = (c9.d) e0.A(xVar, nVar);
        int i2 = (dVar == null || (dVar.f2103g & 1) != 1) ? xVar.f12448k : dVar.f2104h;
        if (dVar == null || (dVar.f2103g & 2) != 2) {
            List listW0 = s.w0(a.a.c0(xVar, gVar));
            List<x0> list = xVar.f12457t;
            q7.k.d(list, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(t.A0(list, 10));
            for (x0 x0Var : list) {
                q7.k.d(x0Var, "it");
                arrayList.add(a.a.n0(x0Var, gVar));
            }
            ArrayList arrayListC1 = r.c1(listW0, arrayList);
            ArrayList arrayList2 = new ArrayList(t.A0(arrayListC1, 10));
            Iterator it = arrayListC1.iterator();
            while (it.hasNext()) {
                String strE = e((p0) it.next(), fVar);
                if (strE == null) {
                    return null;
                }
                arrayList2.add(strE);
            }
            String strE2 = e(a.a.g0(xVar, gVar), fVar);
            if (strE2 == null) {
                return null;
            }
            strM = a1.a.m(new StringBuilder(), r.U0(arrayList2, "", "(", ")", null, 56), strE2);
        } else {
            strM = fVar.getString(dVar.f2105i);
        }
        return new e(fVar.getString(i2), strM);
    }

    public static final boolean d(f0 f0Var) {
        q7.k.e(f0Var, "proto");
        b9.b bVar = c.f3003a;
        Object objI = f0Var.i(l.f2166e);
        q7.k.d(objI, "proto.getExtension(JvmProtoBuf.flags)");
        return bVar.e(((Number) objI).intValue()).booleanValue();
    }

    public static String e(p0 p0Var, b9.f fVar) {
        if (p0Var.n()) {
            return b.b(fVar.r0(p0Var.f12307n));
        }
        return null;
    }

    public static final j f(String[] strArr, String[] strArr2) throws f9.r {
        q7.k.e(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.a(strArr));
        g gVarG = g(byteArrayInputStream, strArr2);
        c9.a aVar = i.P;
        aVar.getClass();
        f9.e eVar = new f9.e(byteArrayInputStream);
        f9.a aVar2 = (f9.a) aVar.a(eVar, f3015a);
        try {
            eVar.a(0);
            if (aVar2.isInitialized()) {
                return new j(gVarG, (i) aVar2);
            }
            f9.r rVar = new f9.r(new u(4).getMessage());
            rVar.f3597f = aVar2;
            throw rVar;
        } catch (f9.r e10) {
            e10.f3597f = aVar2;
            throw e10;
        }
    }

    public static g g(ByteArrayInputStream byteArrayInputStream, String[] strArr) {
        c9.k kVar = (c9.k) c9.k.f2155m.b(byteArrayInputStream, f3015a);
        q7.k.d(kVar, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new g(kVar, strArr);
    }

    public static final j h(String[] strArr, String[] strArr2) throws f9.r {
        q7.k.e(strArr, "data");
        q7.k.e(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.a(strArr));
        g gVarG = g(byteArrayInputStream, strArr2);
        c9.a aVar = b0.f12035q;
        aVar.getClass();
        f9.e eVar = new f9.e(byteArrayInputStream);
        f9.a aVar2 = (f9.a) aVar.a(eVar, f3015a);
        try {
            eVar.a(0);
            if (aVar2.isInitialized()) {
                return new j(gVarG, (b0) aVar2);
            }
            f9.r rVar = new f9.r(new u(4).getMessage());
            rVar.f3597f = aVar2;
            throw rVar;
        } catch (f9.r e10) {
            e10.f3597f = aVar2;
            throw e10;
        }
    }
}
