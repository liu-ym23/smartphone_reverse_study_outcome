package eb;

import ab.x;
import b0.c2;
import d7.r;
import d7.s;
import d7.z;
import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import k.b0;
import k.h0;
import o4.z2;
import q5.t;

/* loaded from: classes.dex */
public final class p implements va.b {

    /* renamed from: a, reason: collision with root package name */
    public int f3318a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3319b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3320c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3321d;

    /* renamed from: e, reason: collision with root package name */
    public Object f3322e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f3323f;

    public p(xa.c cVar, ya.i iVar, g3.e eVar, ua.d dVar) {
        q7.k.e(dVar, "descriptor");
        this.f3319b = cVar;
        this.f3320c = iVar;
        this.f3321d = eVar;
        this.f3318a = -1;
        xa.f fVar = cVar.f11332a;
        this.f3322e = fVar;
        this.f3323f = fVar.f11341d ? null : new ya.e(dVar);
    }

    @Override // va.b
    public p a(ua.d dVar) {
        q7.k.e(dVar, "descriptor");
        xa.c cVar = (xa.c) this.f3319b;
        ya.i iVarH = ya.f.h(dVar, cVar);
        g3.e eVar = (g3.e) this.f3321d;
        x xVar = (x) eVar.f3803c;
        int i2 = xVar.f668b + 1;
        xVar.f668b = i2;
        Object[] objArr = (Object[]) xVar.f669c;
        if (i2 == objArr.length) {
            int i10 = i2 * 2;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i10);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            xVar.f669c = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf((int[]) xVar.f670d, i10);
            q7.k.d(iArrCopyOf, "copyOf(...)");
            xVar.f670d = iArrCopyOf;
        }
        ((Object[]) xVar.f669c)[i2] = dVar;
        eVar.f(iVarH.f11746f);
        if (eVar.p() != 4) {
            int iOrdinal = iVarH.ordinal();
            return (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) ? new p(cVar, iVarH, eVar, dVar) : (((ya.i) this.f3320c) == iVarH && cVar.f11332a.f11341d) ? this : new p(cVar, iVarH, eVar, dVar);
        }
        g3.e.m(eVar, "Unexpected leading comma", 0, 6);
        throw null;
    }

    @Override // va.b
    public long b() {
        return ((g3.e) this.f3321d).g();
    }

    @Override // va.b
    public Object c(sa.a aVar) {
        q7.k.e(aVar, "deserializer");
        try {
            return aVar.deserialize(this);
        } catch (sa.b e10) {
            String message = e10.getMessage();
            q7.k.b(message);
            if (ga.k.k0(message, "at path", false)) {
                throw e10;
            }
            throw new sa.b(e10.f9630f, e10.getMessage() + " at path: " + ((x) ((g3.e) this.f3321d).f3803c).d(), e10);
        }
    }

    @Override // va.b
    public boolean d() {
        ya.e eVar = (ya.e) this.f3323f;
        if (!(eVar != null ? eVar.f11735b : false)) {
            g3.e eVar2 = (g3.e) this.f3321d;
            int iQ = eVar2.q(eVar2.r());
            String str = (String) eVar2.f3806f;
            int length = str.length() - iQ;
            boolean z4 = false;
            if (length >= 4 && iQ != -1) {
                int i2 = 0;
                while (true) {
                    if (i2 < 4) {
                        if ("null".charAt(i2) != str.charAt(iQ + i2)) {
                            break;
                        }
                        i2++;
                    } else if (length <= 4 || ya.f.c(str.charAt(iQ + 4)) != 0) {
                        z4 = true;
                        eVar2.f3802b = iQ + 4;
                    }
                }
            }
            if (!z4) {
                return true;
            }
        }
        return false;
    }

    @Override // va.b
    public int e() {
        g3.e eVar = (g3.e) this.f3321d;
        long jG = eVar.g();
        int i2 = (int) jG;
        if (jG == i2) {
            return i2;
        }
        g3.e.m(eVar, "Failed to parse int for input '" + jG + '\'', 0, 6);
        throw null;
    }

    @Override // va.b
    public String f() {
        g3.e eVar = (g3.e) this.f3321d;
        return ((xa.f) this.f3322e).f11340c ? eVar.j() : eVar.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    public int g(ua.d dVar) throws Throwable {
        int i2;
        char c10;
        ?? r92;
        Object objC;
        xa.c cVar = (xa.c) this.f3319b;
        g3.e eVar = (g3.e) this.f3321d;
        x xVar = (x) eVar.f3803c;
        String str = (String) eVar.f3806f;
        q7.k.e(dVar, "descriptor");
        ya.i iVar = (ya.i) this.f3320c;
        int iOrdinal = iVar.ordinal();
        Throwable th = null;
        char c11 = ':';
        int i10 = 0;
        zS = false;
        boolean zS = false;
        byte b10 = 1;
        int i11 = -1;
        if (iOrdinal == 0) {
            ya.e eVar2 = (ya.e) this.f3323f;
            xa.f fVar = (xa.f) this.f3322e;
            boolean zS2 = eVar.s();
            while (true) {
                Throwable th2 = th;
                if (eVar.c()) {
                    boolean z4 = fVar.f11340c;
                    byte b11 = b10;
                    String strJ = z4 ? eVar.j() : eVar.d();
                    eVar.f(c11);
                    q7.k.e(dVar, "<this>");
                    q7.k.e(cVar, "json");
                    q7.k.e(strJ, "name");
                    ya.f.g(dVar, cVar);
                    int iA = dVar.a(strJ);
                    if (iA == -3 && cVar.f11332a.f11344g) {
                        t tVar = cVar.f11334c;
                        c2 c2Var = new c2(3, dVar, cVar);
                        tVar.getClass();
                        tVar.getClass();
                        q7.k.e(dVar, "descriptor");
                        Map map = (Map) tVar.f8775a.get(dVar);
                        i2 = i11;
                        ya.g gVar = ya.f.f11736a;
                        Object obj = map != null ? map.get(gVar) : null;
                        Object obj2 = obj != null ? obj : null;
                        if (obj2 != null) {
                            objC = obj2;
                        } else {
                            objC = c2Var.c();
                            ConcurrentHashMap concurrentHashMap = tVar.f8775a;
                            Object obj3 = concurrentHashMap.get(dVar);
                            Object obj4 = obj3;
                            if (obj3 == null) {
                                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(2);
                                concurrentHashMap.put(dVar, concurrentHashMap2);
                                obj4 = concurrentHashMap2;
                            }
                            ((Map) obj4).put(gVar, objC);
                        }
                        Integer num = (Integer) ((Map) objC).get(strJ);
                        iA = num != null ? num.intValue() : -3;
                    } else {
                        i2 = i11;
                    }
                    if (iA != -3) {
                        if (eVar2 != null) {
                            wa.b bVar = eVar2.f11734a;
                            if (iA < 64) {
                                bVar.f10963c |= 1 << iA;
                            } else {
                                int i12 = (iA >>> 6) - 1;
                                long[] jArr = bVar.f10964d;
                                jArr[i12] = (1 << (iA & 63)) | jArr[i12];
                            }
                        }
                        i11 = iA;
                    } else {
                        if (!ya.f.d(dVar, cVar)) {
                            int i13 = xVar.f668b;
                            int[] iArr = (int[]) xVar.f670d;
                            if (iArr[i13] == -2) {
                                iArr[i13] = i2;
                                xVar.f668b = i13 - 1;
                            }
                            int i14 = xVar.f668b;
                            int i15 = i2;
                            if (i14 != i15) {
                                xVar.f668b = i14 + i15;
                            }
                            int iV0 = ga.k.v0(6, str.subSequence(0, eVar.f3802b).toString(), strJ);
                            StringBuilder sbO = a1.a.o("Encountered an unknown key '", strJ, "' at offset ", iV0, " at path: ");
                            sbO.append(xVar.d());
                            sbO.append("\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.\nJSON input: ");
                            sbO.append((Object) ya.f.f(str, iV0));
                            throw new ya.d(sbO.toString(), 0);
                        }
                        ArrayList arrayList = new ArrayList();
                        byte bP = eVar.p();
                        if (bP == 8 || bP == 6) {
                            while (true) {
                                byte bP2 = eVar.p();
                                b10 = b11;
                                if (bP2 == b10) {
                                    if (z4) {
                                        eVar.i();
                                    } else {
                                        eVar.d();
                                    }
                                    b11 = b10;
                                } else {
                                    c10 = 6;
                                    if (bP2 == 8 || bP2 == 6) {
                                        r92 = false;
                                        arrayList.add(Byte.valueOf(bP2));
                                    } else {
                                        if (bP2 == 9) {
                                            if (((Number) r.W0(arrayList)).byteValue() != 8) {
                                                throw ya.f.a(eVar.f3802b, str, "found ] instead of } at path: " + xVar);
                                            }
                                            if (arrayList.isEmpty()) {
                                                throw new NoSuchElementException("List is empty.");
                                            }
                                            arrayList.remove(s.t0(arrayList));
                                        } else if (bP2 == 7) {
                                            if (((Number) r.W0(arrayList)).byteValue() != 6) {
                                                throw ya.f.a(eVar.f3802b, str, "found } instead of ] at path: " + xVar);
                                            }
                                            if (arrayList.isEmpty()) {
                                                throw new NoSuchElementException("List is empty.");
                                            }
                                            arrayList.remove(s.t0(arrayList));
                                        } else if (bP2 == 10) {
                                            g3.e.m(eVar, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, 6);
                                            throw th2;
                                        }
                                        r92 = false;
                                        c10 = 6;
                                    }
                                    eVar.e();
                                    if (arrayList.size() == 0) {
                                        break;
                                    }
                                    b11 = b10;
                                }
                            }
                        } else {
                            eVar.i();
                            b10 = b11;
                            r92 = false;
                            c10 = 6;
                        }
                        zS2 = eVar.s();
                        i10 = r92;
                        th = th2;
                        c11 = ':';
                        i11 = -1;
                    }
                } else {
                    int i16 = i10;
                    if (zS2) {
                        ya.f.e(eVar, "object");
                        throw th2;
                    }
                    if (eVar2 != null) {
                        wa.b bVar2 = eVar2.f11734a;
                        z2 z2Var = bVar2.f10962b;
                        ua.d dVar2 = bVar2.f10961a;
                        int iC = dVar2.c();
                        while (true) {
                            long j2 = bVar2.f10963c;
                            if (j2 != -1) {
                                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j2);
                                bVar2.f10963c |= 1 << iNumberOfTrailingZeros;
                                if (((Boolean) z2Var.invoke(dVar2, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue()) {
                                    i11 = iNumberOfTrailingZeros;
                                    break;
                                }
                            } else if (iC > 64) {
                                long[] jArr2 = bVar2.f10964d;
                                int length = jArr2.length;
                                int i17 = i16;
                                loop3: while (i17 < length) {
                                    int i18 = i17 + 1;
                                    int i19 = i18 * 64;
                                    long j4 = jArr2[i17];
                                    while (j4 != -1) {
                                        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(~j4);
                                        j4 |= 1 << iNumberOfTrailingZeros2;
                                        int i20 = iNumberOfTrailingZeros2 + i19;
                                        if (((Boolean) z2Var.invoke(dVar2, Integer.valueOf(i20))).booleanValue()) {
                                            jArr2[i17] = j4;
                                            i11 = i20;
                                            break loop3;
                                        }
                                    }
                                    jArr2[i17] = j4;
                                    i17 = i18;
                                }
                            }
                        }
                    } else {
                        i11 = -1;
                    }
                }
            }
        } else if (iOrdinal != 2) {
            boolean zS3 = eVar.s();
            if (eVar.c()) {
                int i21 = this.f3318a;
                if (i21 != -1 && !zS3) {
                    g3.e.m(eVar, "Expected end of the array or comma", 0, 6);
                    throw null;
                }
                i11 = i21 + 1;
                this.f3318a = i11;
            } else if (zS3) {
                ya.f.e(eVar, "array");
                throw null;
            }
        } else {
            int i22 = this.f3318a;
            boolean z10 = i22 % 2 != 0;
            if (!z10) {
                eVar.f(':');
            } else if (i22 != -1) {
                zS = eVar.s();
            }
            if (eVar.c()) {
                if (z10) {
                    if (this.f3318a == -1) {
                        int i23 = eVar.f3802b;
                        if (zS) {
                            g3.e.m(eVar, "Unexpected leading comma", i23, 4);
                            throw null;
                        }
                    } else {
                        int i24 = eVar.f3802b;
                        if (!zS) {
                            g3.e.m(eVar, "Expected comma after the key-value pair", i24, 4);
                            throw null;
                        }
                    }
                }
                i11 = this.f3318a + 1;
                this.f3318a = i11;
            } else if (zS) {
                ya.f.e(eVar, "object");
                throw null;
            }
        }
        if (iVar != ya.i.f11742j) {
            ((int[]) xVar.f670d)[xVar.f668b] = i11;
        }
        return i11;
    }

    public int h(ua.d dVar, int i2) {
        q7.k.e(dVar, "descriptor");
        return e();
    }

    public long i(ua.d dVar, int i2) {
        q7.k.e(dVar, "descriptor");
        return b();
    }

    public Object j(ua.d dVar, int i2, sa.a aVar, Object obj) {
        q7.k.e(dVar, "descriptor");
        if (aVar.a().g() || d()) {
            return c(aVar);
        }
        return null;
    }

    public String k(ua.d dVar, int i2) {
        q7.k.e(dVar, "descriptor");
        return f();
    }

    public void l(ua.d dVar) {
        xa.c cVar = (xa.c) this.f3319b;
        g3.e eVar = (g3.e) this.f3321d;
        q7.k.e(dVar, "descriptor");
        if (dVar.c() == 0 && ya.f.d(dVar, cVar)) {
            while (g(dVar) != -1) {
            }
        }
        if (eVar.s()) {
            ya.f.e(eVar, "");
            throw null;
        }
        eVar.f(((ya.i) this.f3320c).f11747g);
        x xVar = (x) eVar.f3803c;
        int i2 = xVar.f668b;
        int[] iArr = (int[]) xVar.f670d;
        if (iArr[i2] == -2) {
            iArr[i2] = -1;
            xVar.f668b = i2 - 1;
        }
        int i10 = xVar.f668b;
        if (i10 != -1) {
            xVar.f668b = i10 - 1;
        }
    }

    public boolean m() {
        return this.f3318a < ((List) this.f3321d).size() || !((ArrayList) this.f3323f).isEmpty();
    }

    public p(ab.a aVar, a7.d dVar, i iVar) {
        List listL;
        q7.k.e(dVar, "routeDatabase");
        this.f3319b = aVar;
        this.f3320c = dVar;
        z zVar = z.f2978f;
        this.f3321d = zVar;
        this.f3322e = zVar;
        this.f3323f = new ArrayList();
        ab.p pVar = aVar.f493h;
        q7.k.e(pVar, "url");
        URI uriG = pVar.g();
        if (uriG.getHost() == null) {
            listL = bb.b.l(Proxy.NO_PROXY);
        } else {
            List<Proxy> listSelect = aVar.f492g.select(uriG);
            if (listSelect != null && !listSelect.isEmpty()) {
                listL = bb.b.x(listSelect);
            } else {
                listL = bb.b.l(Proxy.NO_PROXY);
            }
        }
        this.f3321d = listL;
        this.f3318a = 0;
    }

    public p() {
        this.f3319b = new g1.h[32];
        this.f3320c = new float[32];
        this.f3321d = new byte[32];
        int i2 = h0.f5493a;
        this.f3322e = new b0();
        this.f3323f = new b0();
    }
}
