package nb;

import android.text.Spannable;
import android.text.SpannableString;
import android.view.WindowInsetsAnimation;
import androidx.lifecycle.s0;
import com.google.protobuf.y0;
import com.stepos.cloud.securedata.SdkException;
import d5.m;
import f8.q0;
import j9.s;
import j9.t;
import j9.w;
import j9.x;
import j9.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import o4.b3;
import o8.a0;
import v9.i0;
import v9.o0;
import v9.v;
import v9.z;
import v9.z0;
import w7.e0;
import w8.n;
import x2.q;
import x2.r;
import x8.o;
import x8.p;
import z8.f0;
import z8.p0;
import z8.u0;
import z8.x0;

/* loaded from: classes.dex */
public final class f implements ab.d, la.j, a0, r9.a, x2.l, r9.e {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6946f;

    /* renamed from: g, reason: collision with root package name */
    public Object f6947g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f6948h;

    public /* synthetic */ f(int i2, Object obj, Object obj2) {
        this.f6946f = i2;
        this.f6947g = obj;
        this.f6948h = obj2;
    }

    public static /* synthetic */ Object n(f fVar, m mVar, long j2, boolean z4, p5.m mVar2, i7.c cVar, int i2) {
        if ((i2 & 8) != 0) {
            z4 = true;
        }
        boolean z10 = z4;
        if ((i2 & 16) != 0) {
            mVar2 = new p5.m(null);
        }
        return fVar.a(mVar, j2, z10, mVar2, cVar);
    }

    public static i0 q(List list) {
        return list.isEmpty() ? i0.f10558h : new i0(list);
    }

    public int A(w7.d dVar) {
        int iIntValue;
        q7.k.e(dVar, "kClass");
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f6947g;
        String strD = dVar.d();
        q7.k.b(strD);
        q7.k.e(concurrentHashMap, "<this>");
        Integer num = (Integer) concurrentHashMap.get(strD);
        if (num != null) {
            return num.intValue();
        }
        synchronized (concurrentHashMap) {
            try {
                Integer numValueOf = (Integer) concurrentHashMap.get(strD);
                if (numValueOf == null) {
                    int andIncrement = ((AtomicInteger) this.f6948h).getAndIncrement();
                    numValueOf = Integer.valueOf(andIncrement);
                    concurrentHashMap.putIfAbsent(strD, Integer.valueOf(andIncrement));
                }
                iIntValue = numValueOf.intValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    public j9.g B(v vVar, z8.c cVar, b9.f fVar) {
        q7.k.e(cVar, "value");
        q7.k.e(fVar, "nameResolver");
        boolean zBooleanValue = b9.e.M.e(cVar.f12071r).booleanValue();
        z8.b bVar = cVar.f12061h;
        switch (bVar == null ? -1 : r9.b.$EnumSwitchMapping$0[bVar.ordinal()]) {
            case 1:
                byte b10 = (byte) cVar.f12062i;
                return zBooleanValue ? new y(b10) : new j9.d(b10);
            case 2:
                return new j9.e(Character.valueOf((char) cVar.f12062i));
            case 3:
                short s10 = (short) cVar.f12062i;
                return zBooleanValue ? new y(s10) : new j9.v(s10);
            case 4:
                int i2 = (int) cVar.f12062i;
                return zBooleanValue ? new y(i2) : new j9.k(i2);
            case 5:
                long j2 = cVar.f12062i;
                return zBooleanValue ? new y(j2) : new t(j2);
            case 6:
                return new j9.c(cVar.f12063j);
            case 7:
                return new j9.c(cVar.f12064k);
            case 8:
                return new j9.c(Boolean.valueOf(cVar.f12062i != 0));
            case 9:
                return new w(fVar.getString(cVar.f12065l));
            case 10:
                return new s(i.s(fVar, cVar.f12066m), cVar.f12070q);
            case 11:
                return new j9.i(i.s(fVar, cVar.f12066m), i.y(fVar, cVar.f12067n));
            case 12:
                z8.f fVar2 = cVar.f12068o;
                q7.k.d(fVar2, "value.annotation");
                return new j9.a((Object) t(fVar2, fVar));
            case 13:
                List<z8.c> list = cVar.f12069p;
                q7.k.d(list, "value.arrayElementList");
                ArrayList arrayList = new ArrayList(d7.t.A0(list, 10));
                for (z8.c cVar2 : list) {
                    z zVarE = ((f8.z) this.f6947g).n().e();
                    q7.k.d(cVar2, "it");
                    arrayList.add(B(zVarE, cVar2, fVar));
                }
                return new x(arrayList, vVar);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + cVar.f12061h + " (expected " + vVar + ')').toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e7.j C(v9.v0 r17, java.util.List r18, t8.a r19) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.f.C(v9.v0, java.util.List, t8.a):e7.j");
    }

    public i5.f D(e9.f fVar, String str) {
        q7.k.e(fVar, "name");
        String strB = fVar.b();
        q7.k.d(strB, "name.asString()");
        return new i5.f(this, new o(strB.concat(str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r9v6, types: [p7.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(d5.m r10, long r11, boolean r13, p5.m r14, i7.c r15) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.f.a(d5.m, long, boolean, p5.m, i7.c):java.lang.Object");
    }

    @Override // ab.d
    public void b(eb.i iVar, IOException iOException) {
        switch (this.f6946f) {
            case 0:
                ((g) this.f6947g).c(iOException, null);
                break;
            default:
                ((ia.m) this.f6947g).resumeWith(e0.n(new SdkException("Failed to fetch gateway time", iOException)));
                break;
        }
    }

    @Override // r9.c
    public List c(a4.e eVar, f0 f0Var) {
        q7.k.e(f0Var, "proto");
        ((q9.a) this.f6947g).getClass();
        d7.z zVar = d7.z.f2978f;
        ArrayList arrayList = new ArrayList(d7.t.A0(zVar, 10));
        Iterator<E> it = zVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((f) this.f6948h).t((z8.f) it.next(), (b9.f) eVar.f174b));
        }
        return arrayList;
    }

    @Override // r9.c
    public List d(a4.e eVar, f0 f0Var) {
        q7.k.e(f0Var, "proto");
        ((q9.a) this.f6947g).getClass();
        d7.z zVar = d7.z.f2978f;
        ArrayList arrayList = new ArrayList(d7.t.A0(zVar, 10));
        Iterator<E> it = zVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((f) this.f6948h).t((z8.f) it.next(), (b9.f) eVar.f174b));
        }
        return arrayList;
    }

    @Override // r9.a
    public Object e(a4.e eVar, f0 f0Var, v vVar) {
        q7.k.e(f0Var, "proto");
        z8.c cVar = (z8.c) e0.A(f0Var, ((q9.a) this.f6947g).f8830i);
        if (cVar == null) {
            return null;
        }
        return ((f) this.f6948h).B(vVar, cVar, (b9.f) eVar.f174b);
    }

    @Override // x2.l
    public boolean f(CharSequence charSequence, int i2, int i10, q qVar) {
        if ((qVar.f11148c & 4) > 0) {
            return true;
        }
        if (((x2.s) this.f6947g) == null) {
            this.f6947g = new x2.s(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((w4.a) this.f6948h).getClass();
        ((x2.s) this.f6947g).setSpan(new r(qVar), i2, i10, 33);
        return true;
    }

    @Override // r9.c
    public ArrayList g(u0 u0Var, b9.f fVar) {
        q7.k.e(u0Var, "proto");
        q7.k.e(fVar, "nameResolver");
        Iterable iterable = (List) u0Var.i(((q9.a) this.f6947g).f8833l);
        if (iterable == null) {
            iterable = d7.z.f2978f;
        }
        ArrayList arrayList = new ArrayList(d7.t.A0(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((f) this.f6948h).t((z8.f) it.next(), fVar));
        }
        return arrayList;
    }

    @Override // x2.l
    public Object getResult() {
        return (x2.s) this.f6947g;
    }

    @Override // r9.c
    public ArrayList h(r9.s sVar) {
        q7.k.e(sVar, "container");
        Iterable iterable = (List) sVar.f9102e.i(((q9.a) this.f6947g).f8824c);
        if (iterable == null) {
            iterable = d7.z.f2978f;
        }
        ArrayList arrayList = new ArrayList(d7.t.A0(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((f) this.f6948h).t((z8.f) it.next(), (b9.f) sVar.f174b));
        }
        return arrayList;
    }

    @Override // r9.e
    public r9.d i(e9.b bVar) {
        q7.k.e(bVar, "classId");
        k8.b bVar2 = (k8.b) this.f6947g;
        x8.d dVar = (x8.d) this.f6948h;
        q7.k.e(dVar.c().f9049c, "<this>");
        k8.c cVarH = n7.b.h(bVar2, bVar, d9.f.f3008g);
        if (cVarH == null) {
            return null;
        }
        l8.d.a(cVarH.f5652a).equals(bVar);
        return dVar.f(cVarH);
    }

    @Override // r9.c
    public List j(a4.e eVar, f9.a aVar, int i2) {
        List list;
        q9.a aVar2 = (q9.a) this.f6947g;
        q7.k.e(aVar, "proto");
        m.x.t(i2, "kind");
        if (aVar instanceof z8.k) {
            list = (List) ((z8.k) aVar).i(aVar2.f8823b);
        } else if (aVar instanceof z8.x) {
            list = (List) ((z8.x) aVar).i(aVar2.f8825d);
        } else {
            if (!(aVar instanceof f0)) {
                throw new IllegalStateException(("Unknown message: " + aVar).toString());
            }
            int iD = n.f.d(i2);
            if (iD == 1) {
                list = (List) ((f0) aVar).i(aVar2.f8826e);
            } else if (iD == 2) {
                list = (List) ((f0) aVar).i(aVar2.f8827f);
            } else {
                if (iD != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto");
                }
                list = (List) ((f0) aVar).i(aVar2.f8828g);
            }
        }
        if (list == null) {
            list = d7.z.f2978f;
        }
        ArrayList arrayList = new ArrayList(d7.t.A0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((f) this.f6948h).t((z8.f) it.next(), (b9.f) eVar.f174b));
        }
        return arrayList;
    }

    @Override // r9.c
    public List k(a4.e eVar, f9.a aVar, int i2, int i10, x0 x0Var) {
        q7.k.e(aVar, "callableProto");
        m.x.t(i2, "kind");
        Iterable iterable = (List) x0Var.i(((q9.a) this.f6947g).f8831j);
        if (iterable == null) {
            iterable = d7.z.f2978f;
        }
        ArrayList arrayList = new ArrayList(d7.t.A0(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((f) this.f6948h).t((z8.f) it.next(), (b9.f) eVar.f174b));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01aa  */
    @Override // ab.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(eb.i r19, ab.z r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.f.l(eb.i, ab.z):void");
    }

    @Override // r9.c
    public List m(a4.e eVar, z8.s sVar) {
        q7.k.e(eVar, "container");
        Iterable iterable = (List) sVar.i(((q9.a) this.f6947g).f8829h);
        if (iterable == null) {
            iterable = d7.z.f2978f;
        }
        ArrayList arrayList = new ArrayList(d7.t.A0(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((f) this.f6948h).t((z8.f) it.next(), (b9.f) eVar.f174b));
        }
        return arrayList;
    }

    @Override // r9.c
    public ArrayList o(p0 p0Var, b9.f fVar) {
        q7.k.e(p0Var, "proto");
        q7.k.e(fVar, "nameResolver");
        Iterable iterable = (List) p0Var.i(((q9.a) this.f6947g).f8832k);
        if (iterable == null) {
            iterable = d7.z.f2978f;
        }
        ArrayList arrayList = new ArrayList(d7.t.A0(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((f) this.f6948h).t((z8.f) it.next(), fVar));
        }
        return arrayList;
    }

    @Override // r9.c
    public List p(a4.e eVar, f9.a aVar, int i2) {
        q9.a aVar2 = (q9.a) this.f6947g;
        q7.k.e(aVar, "proto");
        m.x.t(i2, "kind");
        if (aVar instanceof z8.x) {
            aVar2.getClass();
        } else {
            if (!(aVar instanceof f0)) {
                throw new IllegalStateException(("Unknown message: " + aVar).toString());
            }
            int iD = n.f.d(i2);
            if (iD != 1 && iD != 2 && iD != 3) {
                throw new IllegalStateException("Unsupported callable kind with property proto for receiver annotations: ".concat(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "null" : "PROPERTY_SETTER" : "PROPERTY_GETTER" : "PROPERTY" : "FUNCTION").toString());
            }
            aVar2.getClass();
        }
        d7.z zVar = d7.z.f2978f;
        ArrayList arrayList = new ArrayList(d7.t.A0(zVar, 10));
        Iterator<E> it = zVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((f) this.f6948h).t((z8.f) it.next(), (b9.f) eVar.f174b));
        }
        return arrayList;
    }

    @Override // r9.a
    public Object r(a4.e eVar, f0 f0Var, v vVar) {
        q7.k.e(f0Var, "proto");
        return null;
    }

    public byte[] s(int i2, String str) throws IOException {
        byte[] bArr = (byte[]) this.f6948h;
        if (i2 < 0 || str.length() - i2 < 0) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        }
        if ((i2 & 1) != 0) {
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
        int i10 = i2 >>> 1;
        byte[] bArr2 = new byte[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = i11 + 1;
            byte b10 = bArr[str.charAt(i11)];
            i11 += 2;
            int i14 = bArr[str.charAt(i13)] | (b10 << 4);
            if (i14 < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            bArr2[i12] = (byte) i14;
        }
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0107  */
    /* JADX WARN: Type inference failed for: r6v0, types: [c7.j] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g8.d t(z8.f r11, b9.f r12) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.f.t(z8.f, b9.f):g8.d");
    }

    public String toString() {
        switch (this.f6946f) {
            case 1:
                return "Bounds{lower=" + ((k2.a) this.f6947g) + " upper=" + ((k2.a) this.f6948h) + "}";
            default:
                return super.toString();
        }
    }

    public boolean u(j9.g gVar, v vVar, z8.c cVar) {
        j9.g gVar2;
        z8.c cVar2;
        f8.z zVar = (f8.z) this.f6947g;
        z8.b bVar = cVar.f12061h;
        int i2 = bVar == null ? -1 : r9.b.$EnumSwitchMapping$0[bVar.ordinal()];
        if (i2 == 10) {
            f8.g gVarC = vVar.E0().c();
            f8.e eVar = gVarC instanceof f8.e ? (f8.e) gVarC : null;
            if (eVar == null) {
                return true;
            }
            e9.f fVar = c8.h.f1999e;
            return c8.h.b(eVar, c8.m.P);
        }
        if (i2 != 13) {
            return q7.k.a(gVar.a(zVar), vVar);
        }
        if (gVar instanceof j9.b) {
            Object obj = ((j9.b) gVar).f5408a;
            if (((List) obj).size() == cVar.f12069p.size()) {
                v vVarF = zVar.n().f(vVar);
                Iterable iterableS0 = d7.s.s0((Collection) obj);
                if ((iterableS0 instanceof Collection) && ((Collection) iterableS0).isEmpty()) {
                    return true;
                }
                Iterator it = iterableS0.iterator();
                do {
                    v7.c cVar3 = (v7.c) it;
                    if (!cVar3.f10528h) {
                        return true;
                    }
                    int iNextInt = cVar3.nextInt();
                    gVar2 = (j9.g) ((List) obj).get(iNextInt);
                    cVar2 = (z8.c) cVar.f12069p.get(iNextInt);
                    q7.k.d(cVar2, "value.getArrayElement(i)");
                } while (u(gVar2, vVarF, cVar2));
                return false;
            }
        }
        throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + gVar).toString());
    }

    public void v(String str, p7.k kVar) {
        LinkedHashMap linkedHashMap = ((s0) this.f6948h).f1030a;
        n nVar = new n(this, str);
        kVar.invoke(nVar);
        String str2 = (String) this.f6947g;
        ArrayList arrayList = nVar.f10918a;
        ArrayList arrayList2 = new ArrayList(d7.t.A0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) ((c7.j) it.next()).f1973f);
        }
        String strE = (String) nVar.f10919b.f1973f;
        q7.k.e(strE, "ret");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append('(');
        sb2.append(d7.r.U0(arrayList2, "", null, null, p.f11274g, 30));
        sb2.append(')');
        if (strE.length() > 1) {
            strE = a1.a.e(';', "L", strE);
        }
        sb2.append(strE);
        String string = sb2.toString();
        q7.k.e(str2, "internalName");
        q7.k.e(string, "jvmDescriptor");
        String str3 = str2 + '.' + string;
        w8.p pVar = (w8.p) nVar.f10919b.f1974g;
        ArrayList arrayList3 = new ArrayList(d7.t.A0(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add((w8.p) ((c7.j) it2.next()).f1974g);
        }
        linkedHashMap.put(str3, new w8.l(pVar, arrayList3));
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [p7.k, q7.m] */
    public Object w(Class cls) {
        q7.k.e(cls, "key");
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f6948h;
        Object obj = concurrentHashMap.get(cls);
        if (obj != null) {
            return obj;
        }
        Object objInvoke = ((q7.m) this.f6947g).invoke(cls);
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(cls, objInvoke);
        return objPutIfAbsent == null ? objInvoke : objPutIfAbsent;
    }

    @Override // la.j
    public Object x(la.k kVar, g7.d dVar) {
        switch (this.f6946f) {
            case 2:
                Object objX = ((la.j) this.f6947g).x(new la.g(5, kVar, (b3) this.f6948h, false), dVar);
                if (objX != h7.a.f4212f) {
                    break;
                }
                break;
            default:
                Object objX2 = ((la.j) this.f6947g).x(new la.g(8, kVar, (w2.d) this.f6948h, false), dVar);
                if (objX2 != h7.a.f4212f) {
                    break;
                }
                break;
        }
        return c7.r.f1986a;
    }

    public z0 y(t8.a aVar) {
        z0 z0VarG;
        z zVar = aVar.f9777f;
        return (zVar == null || (z0VarG = n7.m.G(zVar)) == null) ? (x9.f) ((c7.o) this.f6947g).getValue() : z0VarG;
    }

    public v z(q0 q0Var, t8.a aVar) {
        q7.k.e(q0Var, "typeParameter");
        q7.k.e(aVar, "typeAttr");
        return (v) ((u9.e) this.f6948h).invoke(new o0(q0Var, aVar));
    }

    public f(d5.l lVar, i5.f fVar, k5.g gVar) {
        this.f6946f = 5;
        q7.k.e(lVar, "pool");
        q7.k.e(gVar, "logger");
        this.f6947g = lVar;
        this.f6948h = fVar;
    }

    public f(h4.n nVar) {
        this.f6946f = 11;
        u9.k kVar = new u9.k("Type parameter upper bound erasure results");
        this.f6947g = s7.a.H(new t9.h(7, this));
        this.f6948h = kVar.b(new r8.c(12, this));
    }

    public f(v4.a aVar, k5.g gVar) {
        this.f6946f = 18;
        q7.k.e(gVar, "logger");
        this.f6947g = aVar;
        this.f6948h = gVar;
    }

    public f(Object obj) {
        this.f6946f = 8;
        this.f6947g = obj;
        this.f6948h = Thread.currentThread();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(p7.k kVar) {
        this.f6946f = 21;
        this.f6947g = (q7.m) kVar;
        this.f6948h = new ConcurrentHashMap();
    }

    public f(f8.z zVar, i5.f fVar, q9.a aVar) {
        this.f6946f = 6;
        q7.k.e(zVar, "module");
        q7.k.e(aVar, "protocol");
        this.f6947g = aVar;
        this.f6948h = new f(zVar, fVar);
    }

    public f(f8.z zVar, i5.f fVar) {
        this.f6946f = 7;
        q7.k.e(zVar, "module");
        q7.k.e(fVar, "notFoundClasses");
        this.f6947g = zVar;
        this.f6948h = fVar;
    }

    public f(a4.p pVar, HashMap map, HashMap map2) {
        this.f6946f = 16;
        this.f6947g = pVar;
        this.f6948h = map;
    }

    public f(Map map) {
        this.f6946f = 3;
        this.f6947g = map;
        this.f6948h = new u9.k("Java nullability annotation states").c(new c1.w(25, this));
    }

    public f(int i2) {
        this.f6946f = i2;
        int i10 = 0;
        switch (i2) {
            case 10:
                this.f6947g = new ConcurrentHashMap();
                this.f6948h = new AtomicInteger(0);
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                this.f6947g = new LinkedHashMap();
                this.f6948h = new LinkedHashMap();
                break;
            case 20:
                this.f6947g = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
                byte[] bArr = new byte[128];
                this.f6948h = bArr;
                for (int i11 = 0; i11 < bArr.length; i11++) {
                    bArr[i11] = -1;
                }
                while (true) {
                    byte[] bArr2 = (byte[]) this.f6947g;
                    if (i10 >= bArr2.length) {
                        bArr[65] = bArr[97];
                        bArr[66] = bArr[98];
                        bArr[67] = bArr[99];
                        bArr[68] = bArr[100];
                        bArr[69] = bArr[101];
                        bArr[70] = bArr[102];
                        break;
                    } else {
                        bArr[bArr2[i10]] = (byte) i10;
                        i10++;
                    }
                }
            default:
                this.f6947g = new w4.a();
                this.f6948h = new k.p(16);
                break;
        }
    }

    public f(s0 s0Var, String str) {
        this.f6946f = 13;
        q7.k.e(str, "className");
        this.f6948h = s0Var;
        this.f6947g = str;
    }

    public f(WindowInsetsAnimation.Bounds bounds) {
        this.f6946f = 1;
        this.f6947g = k2.a.c(bounds.getLowerBound());
        this.f6948h = k2.a.c(bounds.getUpperBound());
    }

    public f(a7.d dVar) {
        this.f6946f = 4;
        this.f6947g = dVar;
        this.f6948h = androidx.compose.foundation.gestures.a.f728b;
    }
}
