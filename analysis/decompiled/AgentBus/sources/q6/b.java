package q6;

import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.datastore.preferences.protobuf.h1;
import b0.e1;
import b0.s2;
import b9.f;
import c0.h0;
import c7.p;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import com.stepos.account.oauth.OAuthConstants;
import d0.e;
import d7.r;
import d7.t;
import f9.m0;
import i1.b0;
import i1.f0;
import i1.k;
import i1.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import k.a0;
import la.j;
import la.u0;
import n0.l;
import nb.i;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.q;
import q7.w;
import t3.o;
import v7.d;
import v9.k0;
import v9.z;
import v9.z0;
import y9.g;
import y9.h;
import y9.m;
import z8.i0;
import z8.j0;

/* loaded from: classes.dex */
public final class b implements f, h0, w9.c, k0.f, j, b6.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8786f;

    /* renamed from: g, reason: collision with root package name */
    public Object f8787g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f8788h;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f8786f = i2;
        this.f8788h = obj;
        this.f8787g = obj2;
    }

    public static String B0(String str, String str2, String str3, long j2, String str4) {
        try {
            return i6.a.a(((MessageDigest) i6.a.f4731b.get()).digest((str4 + new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date()) + str3 + j2 + str2 + 5000007L + str).getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static void C0(f0 f0Var) {
        if (f0Var.O > 0) {
            if (f0Var.I.f4495c == b0.f4412j && !f0Var.j() && !f0Var.k() && !f0Var.P && f0Var.C()) {
                l lVar = (l) f0Var.H.f4404j;
                if ((lVar.f6800i & 256) != 0) {
                    while (lVar != null) {
                        if ((lVar.f6799h & 256) != 0) {
                            k kVarE = lVar;
                            ?? eVar = 0;
                            while (kVarE != 0) {
                                if (kVarE instanceof n) {
                                    n nVar = (n) kVarE;
                                    nVar.q(i1.l.s(nVar, 256));
                                } else if ((kVarE.f6799h & 256) != 0 && (kVarE instanceof k)) {
                                    l lVar2 = kVarE.f4514u;
                                    int i2 = 0;
                                    kVarE = kVarE;
                                    eVar = eVar;
                                    while (lVar2 != null) {
                                        if ((lVar2.f6799h & 256) != 0) {
                                            i2++;
                                            eVar = eVar;
                                            if (i2 == 1) {
                                                kVarE = lVar2;
                                            } else {
                                                if (eVar == 0) {
                                                    eVar = new e(new l[16]);
                                                }
                                                if (kVarE != 0) {
                                                    eVar.b(kVarE);
                                                    kVarE = 0;
                                                }
                                                eVar.b(lVar2);
                                            }
                                        }
                                        lVar2 = lVar2.f6802k;
                                        kVarE = kVarE;
                                        eVar = eVar;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                kVarE = i1.l.e(eVar);
                            }
                        }
                        if ((lVar.f6800i & 256) == 0) {
                            break;
                        } else {
                            lVar = lVar.f6802k;
                        }
                    }
                }
            }
            f0Var.N = false;
            e eVarS = f0Var.s();
            Object[] objArr = eVarS.f2749f;
            int i10 = eVarS.f2751h;
            for (int i11 = 0; i11 < i10; i11++) {
                C0((f0) objArr[i11]);
            }
        }
    }

    public static LinkedHashMap F0(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        q7.k.d(itKeys, "keys(...)");
        for (String str : fa.l.v0(fa.l.o0(itKeys))) {
            linkedHashMap.put(str, z0(jSONObject.opt(str)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Path cross not found for [B:60:0x00ef, B:57:0x00d9], limit reached: 82 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004a -> B:18:0x004d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object w0(q6.b r7, d5.u r8, java.lang.String r9, i7.c r10) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.b.w0(q6.b, d5.u, java.lang.String, i7.c):java.lang.Object");
    }

    public static Object z0(Object obj) {
        if (obj instanceof JSONObject) {
            return F0((JSONObject) obj);
        }
        if (!(obj instanceof JSONArray)) {
            if (q7.k.a(obj, JSONObject.NULL) || obj == null) {
                return null;
            }
            return obj;
        }
        JSONArray jSONArray = (JSONArray) obj;
        d dVarN = i.N(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(t.A0(dVarN, 10));
        Iterator it = dVarN.iterator();
        while (true) {
            v7.c cVar = (v7.c) it;
            if (!cVar.f10528h) {
                return arrayList;
            }
            arrayList.add(z0(jSONArray.opt(cVar.nextInt())));
        }
    }

    @Override // w9.c
    public y9.j A(y9.j jVar, boolean z4) {
        return w9.a.withNullability((w9.c) this, jVar, z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x07a9 A[LOOP:9: B:359:0x078c->B:370:0x07a9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x07ca  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x07cf  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x09c6  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0a60  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x07af A[EDGE_INSN: B:631:0x07af->B:372:0x07af BREAK  A[LOOP:9: B:359:0x078c->B:370:0x07a9], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v91, types: [d7.z] */
    /* JADX WARN: Type inference failed for: r2v92, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v93, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p2.h A0(int r49) {
        /*
            Method dump skipped, instructions count: 3176
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.b.A0(int):p2.h");
    }

    @Override // w9.c
    public y9.j B(y9.j jVar) {
        y9.j jVarOriginal;
        q7.k.e(jVar, "<this>");
        y9.e eVarAsDefinitelyNotNullType = w9.a.asDefinitelyNotNullType(this, jVar);
        return (eVarAsDefinitelyNotNullType == null || (jVarOriginal = w9.a.original(this, eVarAsDefinitelyNotNullType)) == null) ? jVar : jVarOriginal;
    }

    @Override // w9.c
    public boolean C(z zVar) {
        return w9.a.isSingleClassifierType(this, zVar);
    }

    @Override // w9.c
    public boolean D(m mVar) {
        return w9.a.isDenotable(this, mVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object D0(c5.b r14, i7.c r15) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.b.D0(c5.b, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object E0(o4.k0 r19, i7.c r20) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.b.E0(o4.k0, i7.c):java.lang.Object");
    }

    @Override // w9.c
    public boolean F(h hVar) {
        q7.k.e(hVar, "<this>");
        y9.j jVarAsSimpleType = w9.a.asSimpleType(this, hVar);
        return (jVarAsSimpleType != null ? w9.a.asDefinitelyNotNullType(this, jVarAsSimpleType) : null) != null;
    }

    @Override // w9.c
    public Collection G(m mVar) {
        return w9.a.supertypes(this, mVar);
    }

    public Set G0(String str) {
        q7.k.e(str, OAuthConstants.FACTOR_PARAMS_PACKAGE_NAME);
        Set set = (Set) ((ConcurrentHashMap) this.f8788h).get(str);
        return set != null ? r.q1(set) : d7.b0.f2947f;
    }

    @Override // w9.c
    public k0 H(y9.j jVar) {
        return w9.a.substitutionSupertypePolicy(this, jVar);
    }

    public AutofillId H0(long j2) {
        return ((ContentCaptureSession) this.f8788h).newAutofillId(((View) this.f8787g).getAutofillId(), j2);
    }

    public l3.b I0() throws FileNotFoundException {
        File file = (File) this.f8788h;
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            return new l3.b(fileInputStream.getFD(), ((o) this.f8787g).a(fileInputStream, file.getName().getBytes(StandardCharsets.UTF_8)));
        }
        throw new FileNotFoundException("file doesn't exist: " + file.getName());
    }

    @Override // w9.c
    public y9.j J(g gVar) {
        return w9.a.upperBound(this, gVar);
    }

    public l3.c J0() throws IOException {
        File file = (File) this.f8788h;
        if (file.exists()) {
            throw new IOException("output file already exists, please use a new file: " + file.getName());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        return new l3.c(fileOutputStream.getFD(), ((o) this.f8787g).b(fileOutputStream, file.getName().getBytes(StandardCharsets.UTF_8)));
    }

    @Override // w9.c
    public Collection K(y9.j jVar) {
        return w9.a.possibleIntegerTypes(this, jVar);
    }

    public void K0(a4.m mVar) throws GeneralSecurityException {
        HashMap map = (HashMap) this.f8787g;
        a4.n nVar = new a4.n(mVar.f186a, b4.i.class);
        if (!map.containsKey(nVar)) {
            map.put(nVar, mVar);
            return;
        }
        a4.m mVar2 = (a4.m) map.get(nVar);
        if (mVar2.equals(mVar) && mVar.equals(mVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + nVar);
    }

    @Override // w9.c
    public boolean L(y9.j jVar) {
        return w9.a.isError(this, jVar);
    }

    public void L0(t3.m mVar) throws GeneralSecurityException {
        HashMap map = (HashMap) this.f8788h;
        if (mVar == null) {
            throw new NullPointerException("wrapper must be non-null");
        }
        Class clsC = mVar.c();
        if (!map.containsKey(clsC)) {
            map.put(clsC, mVar);
            return;
        }
        t3.m mVar2 = (t3.m) map.get(clsC);
        if (!mVar2.equals(mVar) || !mVar.equals(mVar2)) {
            throw new GeneralSecurityException(a1.a.g(clsC, "Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type"));
        }
    }

    public void M0(String str, i3.d dVar) {
        q7.k.e(dVar, "provider");
        k3.a aVar = (k3.a) this.f8788h;
        synchronized (aVar.f5583c) {
            if (aVar.f5584d.containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            aVar.f5584d.put(str, dVar);
        }
    }

    @Override // w9.c
    public boolean N(m mVar) {
        return w9.a.isAnyConstructor(this, mVar);
    }

    public void N0() throws NoSuchMethodException, SecurityException {
        if (!((k3.a) this.f8788h).f5588h) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        i3.a aVar = (i3.a) this.f8787g;
        if (aVar == null) {
            aVar = new i3.a(this);
        }
        this.f8787g = aVar;
        try {
            androidx.lifecycle.l.class.getDeclaredConstructor(null);
            i3.a aVar2 = (i3.a) this.f8787g;
            if (aVar2 != null) {
                aVar2.f4637a.add(androidx.lifecycle.l.class.getName());
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + androidx.lifecycle.l.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }

    @Override // w9.c
    public y9.e O(y9.j jVar) {
        return w9.a.asDefinitelyNotNullType(this, jVar);
    }

    public p O0(int i2) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z4 = false;
        while (i2 != -1) {
            i0 i0Var = (i0) ((j0) this.f8787g).f12222g.get(i2);
            String str = (String) ((z8.k0) this.f8788h).f12237g.get(i0Var.f12211i);
            z8.h0 h0Var = i0Var.f12212j;
            q7.k.b(h0Var);
            int iOrdinal = h0Var.ordinal();
            if (iOrdinal == 0) {
                linkedList2.addFirst(str);
            } else if (iOrdinal == 1) {
                linkedList.addFirst(str);
            } else if (iOrdinal == 2) {
                linkedList2.addFirst(str);
                z4 = true;
            }
            i2 = i0Var.f12210h;
        }
        return new p(linkedList, linkedList2, Boolean.valueOf(z4));
    }

    @Override // w9.c
    public y9.j P(h hVar) {
        y9.j jVarLowerBound;
        q7.k.e(hVar, "<this>");
        g gVarAsFlexibleType = w9.a.asFlexibleType(this, hVar);
        if (gVarAsFlexibleType != null && (jVarLowerBound = w9.a.lowerBound(this, gVarAsFlexibleType)) != null) {
            return jVarLowerBound;
        }
        y9.j jVarAsSimpleType = w9.a.asSimpleType(this, hVar);
        q7.k.b(jVarAsSimpleType);
        return jVarAsSimpleType;
    }

    public void P0(e1 e1Var) {
        Object objG = ((a0) this.f8787g).g(e1Var);
        if (objG != null) {
            if (!(objG instanceof k.z)) {
                throw new ClassCastException();
            }
            k.z zVar = (k.z) objG;
            Object[] objArr = zVar.f5556a;
            if (zVar.f5557b <= 0) {
                return;
            }
            q7.k.c(objArr[0], "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
            throw new ClassCastException();
        }
    }

    @Override // w9.c
    public boolean Q(z0 z0Var) {
        q7.k.e(z0Var, "<this>");
        return w9.a.isMarkedNullable(this, P(z0Var)) != w9.a.isMarkedNullable(this, l0(z0Var));
    }

    public void Q0(int i2, f9.f fVar) throws IOException {
        Iterator it = (Iterator) this.f8788h;
        while (true) {
            Map.Entry entry = (Map.Entry) this.f8787g;
            if (entry == null || ((f9.m) entry.getKey()).f3569f >= i2) {
                return;
            }
            f9.m mVar = (f9.m) ((Map.Entry) this.f8787g).getKey();
            Object value = ((Map.Entry) this.f8787g).getValue();
            f9.i iVar = f9.i.f3562c;
            m0 m0Var = mVar.f3570g;
            int i10 = mVar.f3569f;
            if (mVar.f3571h) {
                for (Object obj : (List) value) {
                    if (m0Var == m0.f3574j) {
                        fVar.x(i10, 3);
                        ((f9.a) obj).d(fVar);
                        fVar.x(i10, 4);
                    } else {
                        fVar.x(i10, m0Var.f3579g);
                        f9.i.k(fVar, m0Var, obj);
                    }
                }
            } else if (m0Var == m0.f3574j) {
                fVar.x(i10, 3);
                ((f9.a) value).d(fVar);
                fVar.x(i10, 4);
            } else {
                fVar.x(i10, m0Var.f3579g);
                f9.i.k(fVar, m0Var, value);
            }
            if (it.hasNext()) {
                this.f8787g = (Map.Entry) it.next();
            } else {
                this.f8787g = null;
            }
        }
    }

    @Override // w9.c
    public boolean R(y9.l lVar) {
        return w9.a.isStarProjection(this, lVar);
    }

    @Override // w9.c
    public int S(y9.k kVar) {
        q7.k.e(kVar, "<this>");
        if (kVar instanceof y9.j) {
            return w9.a.argumentsCount(this, (h) kVar);
        }
        if (kVar instanceof y9.a) {
            return ((y9.a) kVar).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + kVar + ", " + w.f8821a.b(kVar.getClass())).toString());
    }

    @Override // w9.c
    public boolean T(m mVar) {
        return w9.a.isIntegerLiteralTypeConstructor(this, mVar);
    }

    @Override // w9.c
    public boolean U(y9.d dVar) {
        return w9.a.isProjectionNotNull(this, dVar);
    }

    @Override // w9.c
    public y9.l V(h hVar, int i2) {
        return w9.a.getArgument(this, hVar, i2);
    }

    @Override // w9.c
    public m W(h hVar) {
        q7.k.e(hVar, "<this>");
        y9.j jVarAsSimpleType = w9.a.asSimpleType(this, hVar);
        if (jVarAsSimpleType == null) {
            jVarAsSimpleType = P(hVar);
        }
        return w9.a.typeConstructor(this, jVarAsSimpleType);
    }

    @Override // w9.c
    public y9.p X(y9.n nVar) {
        return w9.a.getVariance(this, nVar);
    }

    @Override // w9.c
    public boolean Y(y9.j jVar) {
        return w9.a.isStubType(this, jVar);
    }

    @Override // w9.c
    public h Z(y9.l lVar) {
        return w9.a.getType(this, lVar);
    }

    @Override // b6.a
    public void a() {
        u0 u0Var = (u0) this.f8787g;
        o5.i iVar = new o5.i("stopped", System.currentTimeMillis(), o5.j.UserAction);
        u0Var.getClass();
        u0Var.g(null, iVar);
    }

    @Override // b9.f
    public boolean a0(int i2) {
        return ((Boolean) O0(i2).f1984h).booleanValue();
    }

    @Override // w9.c
    public y9.c b(y9.d dVar) {
        return w9.a.typeConstructor((w9.c) this, dVar);
    }

    @Override // w9.c
    public y9.n b0(m mVar, int i2) {
        return w9.a.getParameter(this, mVar, i2);
    }

    @Override // w9.c
    public int c(h hVar) {
        return w9.a.argumentsCount(this, hVar);
    }

    @Override // w9.c
    public void c0(y9.j jVar, m mVar) {
    }

    @Override // w9.c
    public int d(m mVar) {
        return w9.a.parametersCount(this, mVar);
    }

    @Override // w9.c
    public boolean d0(y9.j jVar) {
        q7.k.e(jVar, "<this>");
        return w9.a.isClassTypeConstructor(this, w9.a.typeConstructor(this, jVar));
    }

    @Override // w9.c
    public y9.j e(h hVar) {
        return w9.a.asSimpleType(this, hVar);
    }

    @Override // w9.c
    public y9.l e0(h hVar) {
        return w9.a.asTypeArgument(this, hVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // b6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(c5.b r13, g7.d r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof m4.v0
            if (r0 == 0) goto L13
            r0 = r14
            m4.v0 r0 = (m4.v0) r0
            int r1 = r0.f6358j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6358j = r1
            goto L1a
        L13:
            m4.v0 r0 = new m4.v0
            i7.c r14 = (i7.c) r14
            r0.<init>(r12, r14)
        L1a:
            java.lang.Object r14 = r0.f6356h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f6358j
            r3 = 1
            java.lang.String r4 = ""
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            c5.b r13 = r0.f6355g
            q6.b r12 = r0.f6354f
            w7.e0.N(r14)     // Catch: java.lang.Exception -> L2f
            goto L6e
        L2f:
            r0 = move-exception
            r12 = r0
            goto Lb1
        L33:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3b:
            w7.e0.N(r14)
            java.lang.Object r14 = r12.f8788h
            v4.j r14 = (v4.j) r14
            java.util.Map r2 = r13.g()
            if (r2 == 0) goto L52
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>(r2)
            java.lang.String r2 = r5.toString()
            goto L53
        L52:
            r2 = 0
        L53:
            java.lang.String r5 = r13.d()     // Catch: java.lang.Exception -> L2f
            q7.k.b(r5)     // Catch: java.lang.Exception -> L2f
            java.lang.Long r6 = new java.lang.Long     // Catch: java.lang.Exception -> L2f
            r7 = 15000(0x3a98, double:7.411E-320)
            r6.<init>(r7)     // Catch: java.lang.Exception -> L2f
            r0.f6354f = r12     // Catch: java.lang.Exception -> L2f
            r0.f6355g = r13     // Catch: java.lang.Exception -> L2f
            r0.f6358j = r3     // Catch: java.lang.Exception -> L2f
            java.lang.Object r14 = r14.u(r5, r2, r6, r0)     // Catch: java.lang.Exception -> L2f
            if (r14 != r1) goto L6e
            return r1
        L6e:
            java.lang.String r14 = (java.lang.String) r14     // Catch: java.lang.Exception -> L2f
            java.lang.String r0 = r13.b()     // Catch: java.lang.Exception -> L2f
            if (r0 != 0) goto L77
            r0 = r4
        L77:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L2f
            r1.<init>(r14)     // Catch: java.lang.Exception -> L2f
            r12.getClass()     // Catch: java.lang.Exception -> L2f
            java.util.LinkedHashMap r12 = F0(r1)     // Catch: java.lang.Exception -> L2f
            java.lang.String r14 = "id"
            java.lang.String r1 = "payload"
            c5.b r2 = new c5.b     // Catch: java.lang.Exception -> L2f
            java.lang.String r3 = "res"
            java.lang.String r5 = "type"
            c7.j r6 = new c7.j     // Catch: java.lang.Exception -> L2f
            r6.<init>(r5, r3)     // Catch: java.lang.Exception -> L2f
            c7.j r5 = new c7.j     // Catch: java.lang.Exception -> L2f
            r5.<init>(r14, r0)     // Catch: java.lang.Exception -> L2f
            java.lang.String r14 = "ok"
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L2f
            c7.j r7 = new c7.j     // Catch: java.lang.Exception -> L2f
            r7.<init>(r14, r0)     // Catch: java.lang.Exception -> L2f
            c7.j r14 = new c7.j     // Catch: java.lang.Exception -> L2f
            r14.<init>(r1, r12)     // Catch: java.lang.Exception -> L2f
            c7.j[] r12 = new c7.j[]{r6, r5, r7, r14}     // Catch: java.lang.Exception -> L2f
            java.util.Map r12 = d7.e0.U(r12)     // Catch: java.lang.Exception -> L2f
            r2.<init>(r3, r12)     // Catch: java.lang.Exception -> L2f
            return r2
        Lb1:
            java.lang.String r13 = r13.b()
            if (r13 != 0) goto Lb9
            r5 = r4
            goto Lba
        Lb9:
            r5 = r13
        Lba:
            java.lang.String r12 = r12.getMessage()
            if (r12 != 0) goto Lc2
            java.lang.String r12 = "operatorRequest failed"
        Lc2:
            r7 = r12
            r10 = 0
            r11 = 56
            java.lang.String r6 = "STEPCLAW_TRANSPORT_ERROR"
            r8 = 0
            r9 = 0
            c5.b r12 = s9.d.n(r5, r6, r7, r8, r9, r10, r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.b.f(c5.b, g7.d):java.lang.Object");
    }

    @Override // w9.c
    public boolean f0(y9.j jVar) {
        return w9.a.isMarkedNullable(this, jVar);
    }

    @Override // w9.c
    public void g(h hVar) {
        q7.k.e(hVar, "<this>");
        g gVarAsFlexibleType = w9.a.asFlexibleType(this, hVar);
        if (gVarAsFlexibleType != null) {
            w9.a.asDynamicType(this, gVarAsFlexibleType);
        }
    }

    @Override // w9.c
    public boolean g0(m mVar) {
        return w9.a.isIntersection(this, mVar);
    }

    @Override // b9.f
    public String getString(int i2) {
        String str = (String) ((z8.k0) this.f8788h).f12237g.get(i2);
        q7.k.d(str, "strings.getString(index)");
        return str;
    }

    @Override // w9.c
    public boolean h(y9.n nVar, m mVar) {
        return w9.a.hasRecursiveBounds(this, nVar, mVar);
    }

    @Override // w9.c
    public y9.b h0(y9.d dVar) {
        return w9.a.captureStatus(this, dVar);
    }

    @Override // w9.c
    public y9.k i(y9.j jVar) {
        return w9.a.asArgumentList(this, jVar);
    }

    @Override // w9.c
    public boolean i0(m mVar, m mVar2) {
        q7.k.e(mVar, "c1");
        q7.k.e(mVar2, "c2");
        if (!(mVar instanceof v9.m0)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (!(mVar2 instanceof v9.m0)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (w9.a.areEqualTypeConstructors(this, mVar, mVar2)) {
            return true;
        }
        v9.m0 m0Var = (v9.m0) mVar;
        v9.m0 m0Var2 = (v9.m0) mVar2;
        Map map = (Map) this.f8788h;
        if (((w9.d) this.f8787g).a(m0Var, m0Var2)) {
            return true;
        }
        if (map == null) {
            return false;
        }
        v9.m0 m0Var3 = (v9.m0) map.get(m0Var);
        v9.m0 m0Var4 = (v9.m0) map.get(m0Var2);
        if (m0Var3 == null || !m0Var3.equals(m0Var2)) {
            return m0Var4 != null && m0Var4.equals(m0Var);
        }
        return true;
    }

    @Override // w9.c
    public h j(h hVar) {
        return w9.a.makeDefinitelyNotNullOrNotNull(this, hVar);
    }

    @Override // w9.c
    public boolean j0(y9.j jVar) {
        q7.k.e(jVar, "<this>");
        return w9.a.isNothingConstructor(this, W(jVar)) && !w9.a.isNullableType(this, jVar);
    }

    @Override // w9.c
    public boolean k(m mVar) {
        return w9.a.isClassTypeConstructor(this, mVar);
    }

    @Override // w9.c
    public boolean k0(m mVar) {
        return w9.a.isNothingConstructor(this, mVar);
    }

    @Override // w9.c
    public y9.p l(y9.l lVar) {
        return w9.a.getVariance(this, lVar);
    }

    @Override // w9.c
    public y9.j l0(h hVar) {
        y9.j jVarUpperBound;
        q7.k.e(hVar, "<this>");
        g gVarAsFlexibleType = w9.a.asFlexibleType(this, hVar);
        if (gVarAsFlexibleType != null && (jVarUpperBound = w9.a.upperBound(this, gVarAsFlexibleType)) != null) {
            return jVarUpperBound;
        }
        y9.j jVarAsSimpleType = w9.a.asSimpleType(this, hVar);
        q7.k.b(jVarAsSimpleType);
        return jVarAsSimpleType;
    }

    @Override // w9.c
    public y9.j m(y9.j jVar) {
        return w9.a.captureFromArguments(this, jVar, y9.b.f11723f);
    }

    @Override // w9.c
    public g m0(h hVar) {
        return w9.a.asFlexibleType(this, hVar);
    }

    @Override // w9.c
    public y9.j n(y9.e eVar) {
        return w9.a.original(this, eVar);
    }

    @Override // w9.c
    public y9.j n0(g gVar) {
        return w9.a.lowerBound(this, gVar);
    }

    @Override // w9.c
    public m o(y9.j jVar) {
        return w9.a.typeConstructor(this, jVar);
    }

    @Override // w9.c
    public boolean o0(y9.j jVar, y9.j jVar2) {
        return w9.a.identicalArguments(this, jVar, jVar2);
    }

    @Override // w9.c
    public y9.d p(y9.j jVar) {
        return w9.a.asCapturedType(this, jVar);
    }

    @Override // w9.c
    public boolean p0(h hVar) {
        return w9.a.isNotNullTypeParameter(this, hVar);
    }

    @Override // w9.c
    public h q(y9.d dVar) {
        return w9.a.lowerType(this, dVar);
    }

    @Override // w9.c
    public boolean q0(y9.j jVar) {
        return w9.a.isStubTypeForBuilderInference(this, jVar);
    }

    @Override // w9.c
    public y9.l r(y9.j jVar, int i2) {
        q7.k.e(jVar, "<this>");
        if (i2 < 0 || i2 >= w9.a.argumentsCount(this, jVar)) {
            return null;
        }
        return w9.a.getArgument(this, jVar, i2);
    }

    @Override // b9.f
    public String r0(int i2) throws IOException {
        p pVarO0 = O0(i2);
        List list = (List) pVarO0.f1982f;
        String strU0 = r.U0((List) pVarO0.f1983g, ".", null, null, null, 62);
        if (list.isEmpty()) {
            return strU0;
        }
        return r.U0(list, "/", null, null, null, 62) + '/' + strU0;
    }

    @Override // w9.c
    public h s(h hVar) {
        return w9.a.withNullability((w9.c) this, hVar, true);
    }

    @Override // k0.f
    public Object s0(k0.b bVar, Object obj) {
        return ((p7.n) this.f8788h).invoke(bVar, obj);
    }

    @Override // b6.a
    public void start() {
        u0 u0Var = (u0) this.f8787g;
        o5.g gVar = new o5.g(null);
        u0Var.getClass();
        u0Var.g(null, gVar);
    }

    @Override // w9.c
    public h t(ArrayList arrayList) {
        return w9.a.intersectTypes(this, arrayList);
    }

    @Override // w9.c
    public y9.l t0(y9.c cVar) {
        return w9.a.projection(this, cVar);
    }

    @Override // w9.c
    public h u(y9.j jVar, y9.j jVar2) {
        return w9.a.createFlexibleType(this, jVar, jVar2);
    }

    @Override // w9.c
    public boolean u0(y9.j jVar) {
        q7.k.e(jVar, "<this>");
        y9.j jVarAsSimpleType = w9.a.asSimpleType(this, jVar);
        return (jVarAsSimpleType != null ? w9.a.asCapturedType(this, jVarAsSimpleType) : null) != null;
    }

    @Override // w9.c
    public boolean v(m mVar) {
        return w9.a.isCommonFinalClassConstructor(this, mVar);
    }

    @Override // w9.c
    public y9.l v0(y9.k kVar, int i2) {
        q7.k.e(kVar, "<this>");
        if (kVar instanceof y9.j) {
            return w9.a.getArgument(this, (h) kVar, i2);
        }
        if (kVar instanceof y9.a) {
            E e10 = ((y9.a) kVar).get(i2);
            q7.k.d(e10, "get(index)");
            return (y9.l) e10;
        }
        throw new IllegalStateException(("unknown type argument list type: " + kVar + ", " + w.f8821a.b(kVar.getClass())).toString());
    }

    @Override // c0.h0
    public List w(Integer num) {
        List listW = ((h0) this.f8788h).w(null);
        s2 s2Var = (s2) this.f8787g;
        int i2 = s2Var.f1367v;
        return i2 < 0 ? listW : r.c1(ib.k.j(s2Var, num, i2, Integer.valueOf(s2Var.B(i2, s2Var.f1347b))), listW);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // la.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object x(la.k r7, g7.d r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.b.x(la.k, g7.d):java.lang.Object");
    }

    public boolean x0(long j2) {
        Object obj;
        List list = (List) ((b) this.f8787g).f8788h;
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                obj = null;
                break;
            }
            obj = list.get(i2);
            if (c1.k.a(((c1.n) obj).f1822a, j2)) {
                break;
            }
            i2++;
        }
        c1.n nVar = (c1.n) obj;
        if (nVar != null) {
            return nVar.f1829h;
        }
        return false;
    }

    @Override // w9.c
    public boolean y(y9.j jVar) {
        q7.k.e(jVar, "<this>");
        return w9.a.isIntegerLiteralTypeConstructor(this, w9.a.typeConstructor(this, jVar));
    }

    public Bundle y0(String str) {
        q7.k.e(str, "key");
        k3.a aVar = (k3.a) this.f8788h;
        if (!aVar.f5587g) {
            throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
        }
        Bundle bundle = aVar.f5586f;
        if (bundle == null) {
            return null;
        }
        Bundle bundleX = bundle.containsKey(str) ? s7.a.x(bundle, str) : null;
        bundle.remove(str);
        if (bundle.isEmpty()) {
            aVar.f5586f = null;
        }
        return bundleX;
    }

    @Override // w9.c
    public boolean z(y9.d dVar) {
        return w9.a.isOldCapturedType(this, dVar);
    }

    public b(int i2) {
        this.f8786f = i2;
        switch (i2) {
            case 1:
                this.f8787g = new HashMap();
                this.f8788h = new HashMap();
                break;
            case 3:
                this.f8788h = new a0();
                this.f8787g = new a0();
                break;
            case 12:
                this.f8788h = new e(new f0[16]);
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                this.f8788h = new p2.i(this);
                break;
            case 16:
                this.f8788h = new e(new Reference[16]);
                this.f8787g = new ReferenceQueue();
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                this.f8788h = new ConcurrentHashMap();
                this.f8787g = new ConcurrentHashMap();
                break;
            case 26:
                this.f8788h = b0.b.n(Boolean.FALSE);
                break;
            default:
                this.f8788h = b.class.getSimpleName();
                HashMap map = new HashMap();
                this.f8787g = map;
                map.put("register_status", new s6.e());
                map.put("un_register_status", new s6.h());
                map.put("push_status", new s6.d());
                map.put("sub_alias_status", new s6.f());
                map.put("sub_tags_status", new s6.g());
                map.put("notification_arrived", new s6.b());
                map.put("private", new s6.c());
                map.put(OAuthConstants.FACTOR_RESULT_MESSAGE, new h6.a());
                break;
        }
    }

    public b(b bVar, w4.a aVar, k5.g gVar) {
        this.f8786f = 28;
        q7.k.e(gVar, "logger");
        this.f8788h = bVar;
        this.f8787g = gVar;
    }

    public b(v4.a aVar, k5.g gVar) {
        this.f8786f = 18;
        q7.k.e(gVar, "logger");
        this.f8788h = aVar;
        this.f8787g = gVar;
    }

    public b(d5.l lVar, q qVar, k5.g gVar) {
        this.f8786f = 29;
        q7.k.e(lVar, "pool");
        q7.k.e(qVar, "dispatcher");
        q7.k.e(gVar, "logger");
        this.f8788h = lVar;
        this.f8787g = qVar;
    }

    public b(z8.k0 k0Var, j0 j0Var) {
        this.f8786f = 4;
        q7.k.e(k0Var, "strings");
        q7.k.e(j0Var, "qualifiedNames");
        this.f8788h = k0Var;
        this.f8787g = j0Var;
    }

    public b(HashMap map, w9.d dVar) {
        this.f8786f = 10;
        q7.k.e(dVar, "equalityAxioms");
        this.f8788h = map;
        this.f8787g = dVar;
    }

    public b(v4.j jVar) {
        this.f8786f = 25;
        this.f8788h = jVar;
        this.f8787g = la.k0.c(new o5.i("not started", System.currentTimeMillis(), o5.j.Auto));
    }

    public b(k5.g gVar) {
        this.f8786f = 2;
        q7.k.e(gVar, "logger");
        this.f8788h = gVar;
        this.f8787g = new ConcurrentHashMap();
    }

    public b(k3.a aVar, int i2) {
        this.f8786f = i2;
        switch (i2) {
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                this.f8788h = aVar;
                this.f8787g = new b(aVar, 13);
                break;
            default:
                this.f8788h = aVar;
                break;
        }
    }

    public b(a4.o oVar) {
        this.f8786f = 1;
        this.f8787g = new HashMap(oVar.f190a);
        this.f8788h = new HashMap(oVar.f191b);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Object obj) {
        this(26);
        this.f8786f = 26;
        this.f8787g = b0.b.n(obj);
        b0.b.n(obj);
    }

    public b(f9.l lVar) {
        this.f8786f = 9;
        Iterator it = ((h1) lVar.f3568f.f3563a.entrySet()).iterator();
        this.f8788h = it;
        if (it.hasNext()) {
            this.f8787g = (Map.Entry) it.next();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(j1.f0 f0Var) {
        this(15);
        this.f8786f = 15;
        this.f8787g = f0Var;
    }
}
