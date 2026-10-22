package i5;

import ab.w;
import android.content.Context;
import b0.a2;
import b0.d0;
import com.google.crypto.tink.shaded.protobuf.b0;
import com.google.protobuf.x0;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import com.stepos.cloud.securedata.SdkException;
import com.stepos.cloud.securedata.http.SecureDataHttpClient;
import d7.e0;
import f4.c2;
import f4.q1;
import f4.r1;
import f4.z0;
import i1.a1;
import i1.f0;
import i1.k1;
import i1.t1;
import i1.u1;
import j1.y;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import k.a0;
import m.x;
import m4.i0;
import v9.v;
import v9.z;

/* loaded from: classes.dex */
public final class l implements la.j, e4.a, b0.c, m5.p, ab.d {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4686f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4687g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4688h;

    /* renamed from: i, reason: collision with root package name */
    public Object f4689i;

    public /* synthetic */ l(int i2, boolean z4) {
        this.f4686f = i2;
    }

    public static String G(String str, Map map) {
        return map.isEmpty() ? str : a1.a.x(str, "#", d7.r.U0(d7.r.j1(map.entrySet(), new i0(2)), ",", null, null, new c6.d(29), 30));
    }

    public static final l J(t3.f fVar, z3.b bVar) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream) fVar.f9713b;
        try {
            z0 z0VarZ = z0.z(byteArrayInputStream, com.google.crypto.tink.shaded.protobuf.n.a());
            byteArrayInputStream.close();
            if (z0VarZ.x().size() == 0) {
                throw new GeneralSecurityException("empty keyset");
            }
            try {
                r1 r1VarD = r1.D(bVar.b(z0VarZ.x().j(), bArr), com.google.crypto.tink.shaded.protobuf.n.a());
                if (r1VarD.y() > 0) {
                    return w(r1VarD);
                }
                throw new GeneralSecurityException("empty keyset");
            } catch (b0 unused) {
                throw new GeneralSecurityException("invalid keyset, corrupted key material");
            }
        } catch (Throwable th) {
            byteArrayInputStream.close();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String L(org.json.JSONArray r9, java.lang.String r10, p7.k r11) {
        /*
            int r0 = r9.length()
            r1 = 0
            r2 = r1
        L6:
            r3 = 0
            if (r2 >= r0) goto L84
            org.json.JSONObject r4 = r9.optJSONObject(r2)
            if (r4 != 0) goto L11
            goto L81
        L11:
            java.lang.String r5 = "connected"
            boolean r5 = r4.optBoolean(r5, r1)
            if (r5 == 0) goto L81
            java.lang.String r5 = "paired"
            r6 = 1
            boolean r5 = r4.optBoolean(r5, r6)
            if (r5 == 0) goto L81
            java.lang.String r5 = "commands"
            org.json.JSONArray r5 = r4.optJSONArray(r5)
            if (r5 != 0) goto L2b
            goto L81
        L2b:
            int r6 = r5.length()
            r7 = r1
        L30:
            if (r7 >= r6) goto L81
            java.lang.String r8 = r5.optString(r7)
            boolean r8 = q7.k.a(r8, r10)
            if (r8 == 0) goto L7e
            java.lang.String r5 = "platform"
            java.lang.String r6 = ""
            java.lang.String r5 = r4.optString(r5, r6)
            java.lang.String r6 = "optString(...)"
            q7.k.d(r5, r6)
            java.lang.CharSequence r5 = ga.k.N0(r5)
            java.lang.String r5 = r5.toString()
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r6)
            java.lang.String r6 = "toLowerCase(...)"
            q7.k.d(r5, r6)
            if (r11 == 0) goto L6a
            java.lang.Object r5 = r11.invoke(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L81
        L6a:
            java.lang.String r5 = "nodeId"
            java.lang.String r4 = r4.optString(r5)
            q7.k.b(r4)
            int r5 = r4.length()
            if (r5 <= 0) goto L7a
            r3 = r4
        L7a:
            if (r3 != 0) goto L7d
            goto L81
        L7d:
            return r3
        L7e:
            int r7 = r7 + 1
            goto L30
        L81:
            int r2 = r2 + 1
            goto L6
        L84:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.l.L(org.json.JSONArray, java.lang.String, p7.k):java.lang.String");
    }

    public static final l w(r1 r1Var) throws GeneralSecurityException {
        if (r1Var.y() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        ArrayList arrayList = new ArrayList(r1Var.y());
        for (q1 q1Var : r1Var.z()) {
            q1Var.getClass();
            try {
                try {
                    t3.b bVarA = a4.j.f182b.a(a4.p.u(q1Var.z().A(), q1Var.z().B(), q1Var.z().z(), q1Var.B(), q1Var.B() == c2.RAW ? null : Integer.valueOf(q1Var.A())));
                    int iOrdinal = q1Var.C().ordinal();
                    if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
                        throw new GeneralSecurityException("Unknown key status");
                    }
                    arrayList.add(new t3.h(bVarA));
                } catch (GeneralSecurityException unused) {
                    arrayList.add(null);
                }
            } catch (GeneralSecurityException e10) {
                throw new a4.u("Creating a protokey serialization failed", e10);
            }
        }
        return new l(r1Var, Collections.unmodifiableList(arrayList));
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object A(java.lang.Class r17) throws java.security.GeneralSecurityException {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.l.A(java.lang.Class):java.lang.Object");
    }

    public List B(byte[] bArr) {
        List list = (List) ((ConcurrentMap) this.f4687g).get(new t3.l(bArr));
        return list != null ? list : Collections.EMPTY_LIST;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object C(c5.b r11, i7.c r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof b6.c
            if (r0 == 0) goto L14
            r0 = r12
            b6.c r0 = (b6.c) r0
            int r1 = r0.f1543j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f1543j = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            b6.c r0 = new b6.c
            r0.<init>(r10, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r7.f1541h
            h7.a r0 = h7.a.f4212f
            int r1 = r7.f1543j
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 == r2) goto L34
            if (r1 != r9) goto L2c
            w7.e0.N(r12)
            return r12
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            c5.b r11 = r7.f1540g
            i5.l r10 = r7.f1539f
            w7.e0.N(r12)
            goto L77
        L3c:
            w7.e0.N(r12)
            java.lang.Object r12 = r10.f4688h
            u4.l r12 = (u4.l) r12
            d5.e r12 = r12.a()
            if (r12 == 0) goto L76
            java.lang.Object r1 = r10.f4689i
            u4.k r1 = (u4.k) r1
            if (r1 == 0) goto L76
            java.lang.String r3 = r11.d()
            java.lang.String r4 = "task_rpc:"
            java.lang.String r3 = a1.a.w(r4, r3)
            java.lang.Object r4 = r10.f4688h
            u4.l r4 = (u4.l) r4
            java.lang.Object r4 = r4.f10092c
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            r7.f1539f = r10
            r7.f1540g = r11
            r7.f1543j = r2
            r6 = 0
            r8 = 48
            r4 = r11
            r2 = r12
            java.lang.Object r11 = u4.k.c(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L74
            goto L88
        L74:
            r11 = r4
            goto L77
        L76:
            r4 = r11
        L77:
            java.lang.Object r10 = r10.f4687g
            b6.a r10 = (b6.a) r10
            r12 = 0
            r7.f1539f = r12
            r7.f1540g = r12
            r7.f1543j = r9
            java.lang.Object r10 = r10.f(r11, r7)
            if (r10 != r0) goto L89
        L88:
            return r0
        L89:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.l.C(c5.b, i7.c):java.lang.Object");
    }

    public void D(String str, Map map, long j2) {
        q7.k.e(str, "name");
        q7.k.e(map, "tags");
        m5.k kVar = (m5.k) ((ConcurrentHashMap) this.f4689i).computeIfAbsent(G(str, map), new g5.a(new c6.d(this), 5));
        synchronized (kVar.f6427g) {
            try {
                long[] jArr = kVar.f6421a;
                int i2 = kVar.f6422b;
                jArr[i2] = j2;
                kVar.f6422b = (i2 + 1) % 2048;
                int i10 = kVar.f6423c;
                if (i10 < 2048) {
                    kVar.f6423c = i10 + 1;
                }
                kVar.f6424d += j2;
                if (j2 < kVar.f6425e) {
                    kVar.f6425e = j2;
                }
                if (j2 > kVar.f6426f) {
                    kVar.f6426f = j2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean F() {
        return !(((t1) ((a7.d) this.f4687g).f411g).isEmpty() && ((t1) ((a7.d) this.f4689i).f411g).isEmpty() && ((t1) ((a7.d) this.f4688h).f411g).isEmpty());
    }

    public void H() {
        k1 k1Var = ((f0) this.f4687g).f4464r;
        if (k1Var != null) {
            ((y) k1Var).s();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object K(java.lang.String r10, i7.c r11) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.l.K(java.lang.String, i7.c):java.lang.Object");
    }

    public void N(Object obj) {
        long jB = j0.i.b();
        if (jB == j0.k.f5089a) {
            this.f4689i = obj;
            return;
        }
        synchronized (this.f4688h) {
            j0.j jVar = (j0.j) ((AtomicReference) this.f4687g).get();
            int iA = jVar.a(jB);
            if (iA < 0) {
                ((AtomicReference) this.f4687g).set(jVar.b(jB, obj));
            } else {
                jVar.f5088c[iA] = obj;
            }
        }
    }

    public void O(int i2) throws InvalidAlgorithmParameterException {
        if (i2 != 16 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i2 * 8)));
        }
        this.f4687g = Integer.valueOf(i2);
    }

    public m5.q P() {
        Iterator it;
        long j2;
        m5.l lVar;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f4687g;
        LinkedHashMap linkedHashMap = new LinkedHashMap(e0.S(concurrentHashMap.size()));
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            linkedHashMap.put(entry.getKey(), Long.valueOf(((AtomicLong) entry.getValue()).get()));
        }
        ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) this.f4688h;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(e0.S(concurrentHashMap2.size()));
        for (Map.Entry entry2 : concurrentHashMap2.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), Long.valueOf(((AtomicLong) entry2.getValue()).get()));
        }
        ConcurrentHashMap concurrentHashMap3 = (ConcurrentHashMap) this.f4689i;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(e0.S(concurrentHashMap3.size()));
        Iterator it2 = concurrentHashMap3.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it2.next();
            Object key = entry3.getKey();
            m5.k kVar = (m5.k) entry3.getValue();
            synchronized (kVar.f6427g) {
                int i2 = kVar.f6423c;
                if (i2 == 0) {
                    lVar = new m5.l(0L, 0L, 0L, 0L, 0L, 0L, 0L);
                    it = it2;
                    j2 = jCurrentTimeMillis;
                } else {
                    long[] jArrCopyOf = Arrays.copyOf(kVar.f6421a, i2);
                    q7.k.d(jArrCopyOf, "copyOf(...)");
                    if (jArrCopyOf.length > 1) {
                        Arrays.sort(jArrCopyOf);
                    }
                    int i10 = kVar.f6423c;
                    long j4 = i10;
                    long j10 = kVar.f6424d;
                    long j11 = kVar.f6425e;
                    it = it2;
                    j2 = jCurrentTimeMillis;
                    long j12 = kVar.f6426f;
                    double d6 = i10;
                    int i11 = (int) (d6 * 0.5d);
                    int i12 = i10 - 1;
                    if (i11 > i12) {
                        i11 = i12;
                    }
                    long j13 = jArrCopyOf[i11];
                    int i13 = (int) (d6 * 0.9d);
                    if (i13 > i12) {
                        i13 = i12;
                    }
                    long j14 = jArrCopyOf[i13];
                    int i14 = (int) (0.99d * d6);
                    if (i14 <= i12) {
                        i12 = i14;
                    }
                    lVar = new m5.l(j4, j10, j11, j12, j13, j14, jArrCopyOf[i12]);
                }
            }
            linkedHashMap3.put(key, lVar);
            it2 = it;
            jCurrentTimeMillis = j2;
        }
        return new m5.q(jCurrentTimeMillis, linkedHashMap, linkedHashMap2, linkedHashMap3);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v9.z0 Q(l8.i r8, t8.a r9, boolean r10) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f4687g
            a3.b r0 = (a3.b) r0
            java.lang.Object r1 = r0.f162f
            r8.a r1 = (r8.a) r1
            java.lang.String r2 = "arrayType"
            q7.k.e(r8, r2)
            boolean r9 = r9.f9775d
            l8.b0 r2 = r8.f5871b
            boolean r3 = r2 instanceof l8.z
            r4 = 0
            if (r3 == 0) goto L1a
            r3 = r2
            l8.z r3 = (l8.z) r3
            goto L1b
        L1a:
            r3 = r4
        L1b:
            if (r3 == 0) goto L35
            java.lang.Class r3 = r3.f5888a
            java.lang.Class r5 = java.lang.Void.TYPE
            boolean r5 = q7.k.a(r3, r5)
            if (r5 == 0) goto L28
            goto L35
        L28:
            java.lang.String r3 = r3.getName()
            m9.c r3 = m9.c.b(r3)
            c8.j r3 = r3.d()
            goto L36
        L35:
            r3 = r4
        L36:
            r8.d r5 = new r8.d
            r6 = 1
            r5.<init>(r0, r8, r6)
            r8 = 2
            if (r3 == 0) goto L70
            f8.z r7 = r1.f9016o
            c8.h r7 = r7.n()
            v9.z r7 = r7.q(r3)
            g8.k r10 = new g8.k
            g8.j r0 = r7.getAnnotations()
            g8.j[] r8 = new g8.j[r8]
            r1 = 0
            r8[r1] = r0
            r8[r6] = r5
            r10.<init>(r8)
            v9.v r7 = n7.m.F(r7, r10)
            java.lang.String r8 = "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType"
            q7.k.c(r7, r8)
            v9.z r7 = (v9.z) r7
            if (r9 == 0) goto L67
            return r7
        L67:
            v9.z r8 = r7.I0(r6)
            v9.z0 r7 = v9.d.j(r7, r8)
            return r7
        L70:
            r0 = 6
            t8.a r8 = n7.b.x(r8, r9, r4, r0)
            v9.v r7 = r7.R(r2, r8)
            r8 = 3
            if (r9 == 0) goto L8a
            if (r10 == 0) goto L7f
            r6 = r8
        L7f:
            f8.z r8 = r1.f9016o
            c8.h r8 = r8.n()
            v9.z r7 = r8.g(r6, r7, r5)
            return r7
        L8a:
            f8.z r9 = r1.f9016o
            c8.h r9 = r9.n()
            v9.z r9 = r9.g(r6, r7, r5)
            f8.z r10 = r1.f9016o
            c8.h r10 = r10.n()
            v9.z r7 = r10.g(r8, r7, r5)
            v9.z r7 = r7.I0(r6)
            v9.z0 r7 = v9.d.j(r9, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.l.Q(l8.i, t8.a, boolean):v9.z0");
    }

    public v R(v8.d dVar, t8.a aVar) {
        z zVarU;
        r8.a aVar2 = (r8.a) ((a3.b) this.f4687g).f162f;
        if (dVar instanceof l8.z) {
            Class cls = ((l8.z) dVar).f5888a;
            c8.j jVarD = q7.k.a(cls, Void.TYPE) ? null : m9.c.b(cls.getName()).d();
            return jVarD != null ? aVar2.f9016o.n().s(jVarD) : aVar2.f9016o.n().w();
        }
        boolean z4 = false;
        if (!(dVar instanceof l8.q)) {
            if (dVar instanceof l8.i) {
                return Q((l8.i) dVar, aVar, false);
            }
            if (dVar instanceof l8.e0) {
                l8.b0 b0VarC = ((l8.e0) dVar).c();
                return b0VarC != null ? R(b0VarC, aVar) : aVar2.f9016o.n().m();
            }
            if (dVar == null) {
                return aVar2.f9016o.n().m();
            }
            throw new UnsupportedOperationException("Unsupported type: " + dVar);
        }
        l8.q qVar = (l8.q) dVar;
        if (!aVar.f9775d && aVar.f9772a != 1) {
            z4 = true;
        }
        Type type = qVar.f5880a;
        boolean zD = qVar.d();
        x9.h hVar = x9.h.f11302h;
        if (!zD && !z4) {
            z zVarU2 = u(qVar, aVar, null);
            return zVarU2 != null ? zVarU2 : x9.i.c(hVar, type.toString());
        }
        z zVarU3 = u(qVar, aVar.b(3), null);
        if (zVarU3 != null && (zVarU = u(qVar, aVar.b(2), zVarU3)) != null) {
            return zD ? new t8.f(zVarU3, zVarU) : v9.d.j(zVarU3, zVarU);
        }
        return x9.i.c(hVar, type.toString());
    }

    public void S() {
        a0 a0Var = (a0) this.f4687g;
        String str = (String) this.f4688h;
        List list = (List) a0Var.j(str);
        if (list != null) {
            list.remove((a2) this.f4689i);
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        a0Var.l(str, list);
    }

    @Override // b0.c
    public void a(int i2, Object obj) {
        ((f0) this.f4689i).u(i2, (f0) obj);
    }

    @Override // ab.d
    public void b(eb.i iVar, IOException iOException) {
        SecureDataHttpClient secureDataHttpClient = (SecureDataHttpClient) this.f4687g;
        w wVar = (w) this.f4688h;
        SecureDataHttpClient.access$logError(secureDataHttpClient, "<-- HTTP FAILED " + wVar.f662b + " " + wVar.f661a, iOException);
        ((ia.m) this.f4689i).resumeWith(w7.e0.n(new SdkException("Network request failed", iOException)));
    }

    @Override // b0.c
    public void c(Object obj) {
        ((ArrayList) this.f4688h).add(this.f4689i);
        this.f4689i = obj;
    }

    @Override // b0.c
    public void d() {
        f0 f0Var = (f0) this.f4689i;
        a1 a1Var = f0Var.H;
        if (!f0Var.B()) {
            f1.a.a("onReuse is only expected on attached node");
        }
        f0Var.f4469w = false;
        if (f0Var.P) {
            f0Var.P = false;
        } else {
            n0.l lVar = (u1) f0Var.H.f4403i;
            for (n0.l lVar2 = lVar; lVar2 != null; lVar2 = lVar2.f6801j) {
                if (lVar2.f6810s) {
                    lVar2.g0();
                }
            }
            for (n0.l lVar3 = lVar; lVar3 != null; lVar3 = lVar3.f6801j) {
                if (lVar3.f6810s) {
                    lVar3.i0();
                }
            }
            while (lVar != null) {
                if (lVar.f6810s) {
                    lVar.c0();
                }
                lVar = lVar.f6801j;
            }
        }
        int i2 = f0Var.f4453g;
        f0Var.f4453g = p1.j.f8308a.addAndGet(1);
        k1 k1Var = f0Var.f4464r;
        if (k1Var != null) {
            y yVar = (y) k1Var;
            yVar.getLayoutNodes().f(i2);
            yVar.getLayoutNodes().g(f0Var.f4453g, f0Var);
        }
        for (n0.l lVar4 = (n0.l) a1Var.f4404j; lVar4 != null; lVar4 = lVar4.f6802k) {
            lVar4.b0();
        }
        a1Var.j();
        if (a1Var.h(8)) {
            f0Var.z();
        }
        f0.N(f0Var);
        k1 k1Var2 = f0Var.f4464r;
        if (k1Var2 != null) {
            y yVar2 = (y) k1Var2;
            o0.b bVar = yVar2.J;
            if (bVar != null) {
                y yVar3 = bVar.f7174c;
                a7.d dVar = bVar.f7172a;
                k.u uVar = bVar.f7178g;
                if (uVar.e(i2)) {
                    dVar.w(yVar3, i2, false);
                }
                p1.i iVarQ = f0Var.q();
                if (iVarQ != null && iVarQ.f8304f.b(p1.s.f8360q)) {
                    uVar.a(f0Var.f4453g);
                    dVar.w(yVar3, f0Var.f4453g, true);
                }
            }
            yVar2.getRectManager().g(f0Var, true);
        }
    }

    @Override // b0.c
    public /* bridge */ /* synthetic */ void e(int i2, Object obj) {
    }

    @Override // b0.c
    public void f(int i2, int i10, int i11) {
        f0 f0Var = (f0) this.f4689i;
        q6.b bVar = f0Var.f4460n;
        if (i2 == i10) {
            return;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i2 > i10 ? i2 + i12 : i2;
            int i14 = i2 > i10 ? i10 + i12 : (i10 + i11) - 2;
            d0.e eVar = (d0.e) bVar.f8788h;
            a8.c cVar = (a8.c) bVar.f8787g;
            Object objJ = eVar.j(i13);
            cVar.c();
            ((d0.e) bVar.f8788h).a(i14, (f0) objJ);
            cVar.c();
        }
        f0Var.H();
        f0Var.A();
        f0Var.x();
    }

    @Override // b0.c
    public void g(int i2, int i10) {
        f0 f0Var = (f0) this.f4689i;
        q6.b bVar = f0Var.f4460n;
        if (i10 < 0) {
            f1.a.a("count (" + i10 + ") must be greater than 0");
        }
        int i11 = (i10 + i2) - 1;
        if (i2 > i11) {
            return;
        }
        while (true) {
            f0Var.E((f0) ((d0.e) bVar.f8788h).f2749f[i11]);
            Object objJ = ((d0.e) bVar.f8788h).j(i11);
            ((a8.c) bVar.f8787g).c();
            if (i11 == i2) {
                return;
            } else {
                i11--;
            }
        }
    }

    @Override // b0.c
    public Object getCurrent() {
        return this.f4689i;
    }

    @Override // e4.a
    public byte[] i(int i2, byte[] bArr) throws GeneralSecurityException {
        byte[] bArrR;
        if (i2 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        if (!x.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        Cipher cipher = (Cipher) h4.m.f4149b.f4151a.a("AES/ECB/NoPadding");
        cipher.init(1, (SecretKeySpec) this.f4687g);
        int iMax = Math.max(1, (int) Math.ceil(bArr.length / 16.0d));
        if (iMax * 16 == bArr.length) {
            bArrR = w7.e0.Q((iMax - 1) * 16, 0, 16, bArr, (byte[]) this.f4688h);
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, (iMax - 1) * 16, bArr.length);
            if (bArrCopyOfRange.length >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
            bArrCopyOf[bArrCopyOfRange.length] = -128;
            bArrR = w7.e0.R(bArrCopyOf, (byte[]) this.f4689i);
        }
        byte[] bArrDoFinal = new byte[16];
        for (int i10 = 0; i10 < iMax - 1; i10++) {
            bArrDoFinal = cipher.doFinal(w7.e0.Q(0, i10 * 16, 16, bArrDoFinal, bArr));
        }
        return Arrays.copyOf(cipher.doFinal(w7.e0.R(bArrR, bArrDoFinal)), i2);
    }

    @Override // b0.c
    public void j() {
        this.f4689i = ((ArrayList) this.f4688h).remove(r0.size() - 1);
    }

    public void k(f0 f0Var, i1.s sVar) {
        a7.d dVar = (a7.d) this.f4687g;
        a7.d dVar2 = (a7.d) this.f4688h;
        a7.d dVar3 = (a7.d) this.f4689i;
        int iOrdinal = sVar.ordinal();
        if (iOrdinal == 0) {
            dVar.h(f0Var);
            dVar3.h(f0Var);
            return;
        }
        if (iOrdinal == 1) {
            dVar2.h(f0Var);
            dVar3.h(f0Var);
            return;
        }
        if (iOrdinal == 2) {
            if (f0Var.f4458l != null) {
                dVar3.h(f0Var);
                return;
            } else {
                dVar.h(f0Var);
                return;
            }
        }
        if (iOrdinal != 3) {
            throw new a4.u();
        }
        if (f0Var.f4458l != null) {
            dVar3.h(f0Var);
        } else {
            dVar2.h(f0Var);
        }
    }

    @Override // ab.d
    public void l(eb.i iVar, ab.z zVar) {
        int i2 = zVar.f687i;
        SecureDataHttpClient secureDataHttpClient = (SecureDataHttpClient) this.f4687g;
        w wVar = (w) this.f4688h;
        ia.m mVar = (ia.m) this.f4689i;
        try {
            ab.b0 b0Var = zVar.f690l;
            String strE = b0Var != null ? b0Var.e() : null;
            if (strE == null) {
                strE = "";
            }
            secureDataHttpClient.a(wVar, i2, strE);
            if (zVar.b()) {
                mVar.resumeWith(strE);
                zVar.close();
                return;
            }
            mVar.resumeWith(w7.e0.n(new SdkException("HTTP " + i2 + ": " + strE, null, 2, null)));
            zVar.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                n7.b.d(zVar, th);
                throw th2;
            }
        }
    }

    public b4.a m() throws GeneralSecurityException {
        a7.d dVar;
        i4.a aVarA;
        b4.g gVar = (b4.g) this.f4687g;
        if (gVar == null || (dVar = (a7.d) this.f4688h) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (gVar.f1508b != ((i4.a) dVar.f411g).f4640a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        b4.f fVar = gVar.f1510d;
        b4.f fVar2 = b4.f.f1496f;
        if (fVar != fVar2 && ((Integer) this.f4689i) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar == fVar2 && ((Integer) this.f4689i) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar == fVar2) {
            aVarA = i4.a.a(new byte[0]);
        } else if (fVar == b4.f.f1495e || fVar == b4.f.f1494d) {
            aVarA = i4.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f4689i).intValue()).array());
        } else {
            if (fVar != b4.f.f1493c) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + ((b4.g) this.f4687g).f1510d);
            }
            aVarA = i4.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f4689i).intValue()).array());
        }
        return new b4.a((b4.g) this.f4687g, aVarA);
    }

    public b4.g n() throws GeneralSecurityException {
        Integer num = (Integer) this.f4687g;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        }
        if (((Integer) this.f4688h) == null) {
            throw new GeneralSecurityException("tag size not set");
        }
        if (((b4.f) this.f4689i) != null) {
            return new b4.g(num.intValue(), ((Integer) this.f4688h).intValue(), (b4.f) this.f4689i);
        }
        throw new GeneralSecurityException("variant not set");
    }

    public b4.l o() throws GeneralSecurityException {
        a7.d dVar;
        i4.a aVarA;
        b4.m mVar = (b4.m) this.f4687g;
        if (mVar == null || (dVar = (a7.d) this.f4688h) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (mVar.f1518b != ((i4.a) dVar.f411g).f4640a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        b4.f fVar = mVar.f1520d;
        b4.f fVar2 = b4.f.f1505o;
        if (fVar != fVar2 && ((Integer) this.f4689i) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar == fVar2 && ((Integer) this.f4689i) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar == fVar2) {
            aVarA = i4.a.a(new byte[0]);
        } else if (fVar == b4.f.f1504n || fVar == b4.f.f1503m) {
            aVarA = i4.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f4689i).intValue()).array());
        } else {
            if (fVar != b4.f.f1502l) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: " + ((b4.m) this.f4687g).f1520d);
            }
            aVarA = i4.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f4689i).intValue()).array());
        }
        return new b4.l((b4.m) this.f4687g, aVarA);
    }

    public u3.e p() throws GeneralSecurityException {
        a7.d dVar;
        u3.g gVar = (u3.g) this.f4687g;
        if (gVar == null || (dVar = (a7.d) this.f4688h) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (gVar.f10024b != ((i4.a) dVar.f411g).f4640a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        u3.f fVar = gVar.f10027e;
        u3.f fVar2 = u3.f.f10009e;
        if (fVar != fVar2 && ((Integer) this.f4689i) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar == fVar2 && ((Integer) this.f4689i) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar == fVar2) {
            i4.a.a(new byte[0]);
        } else if (fVar == u3.f.f10008d) {
            i4.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f4689i).intValue()).array());
        } else {
            if (fVar != u3.f.f10007c) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + ((u3.g) this.f4687g).f10027e);
            }
            i4.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f4689i).intValue()).array());
        }
        return new u3.e();
    }

    public u3.i q() throws GeneralSecurityException {
        a7.d dVar;
        u3.j jVar = (u3.j) this.f4687g;
        if (jVar == null || (dVar = (a7.d) this.f4688h) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (jVar.f10032b != ((i4.a) dVar.f411g).f4640a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        u3.f fVar = jVar.f10035e;
        u3.f fVar2 = u3.f.f10012h;
        if (fVar != fVar2 && ((Integer) this.f4689i) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar == fVar2 && ((Integer) this.f4689i) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar == fVar2) {
            i4.a.a(new byte[0]);
        } else if (fVar == u3.f.f10011g) {
            i4.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f4689i).intValue()).array());
        } else {
            if (fVar != u3.f.f10010f) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: " + ((u3.j) this.f4687g).f10035e);
            }
            i4.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f4689i).intValue()).array());
        }
        return new u3.i();
    }

    public u3.l r() throws GeneralSecurityException {
        a7.d dVar;
        u3.m mVar = (u3.m) this.f4687g;
        if (mVar == null || (dVar = (a7.d) this.f4688h) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (mVar.f10040b != ((i4.a) dVar.f411g).f4640a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        u3.f fVar = mVar.f10041c;
        u3.f fVar2 = u3.f.f10015k;
        if (fVar != fVar2 && ((Integer) this.f4689i) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (fVar == fVar2 && ((Integer) this.f4689i) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (fVar == fVar2) {
            i4.a.a(new byte[0]);
        } else if (fVar == u3.f.f10014j) {
            i4.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(((Integer) this.f4689i).intValue()).array());
        } else {
            if (fVar != u3.f.f10013i) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + ((u3.m) this.f4687g).f10041c);
            }
            i4.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(((Integer) this.f4689i).intValue()).array());
        }
        return new u3.l();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object s(java.lang.String r18, java.lang.String r19, i7.c r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.l.s(java.lang.String, java.lang.String, i7.c):java.lang.Object");
    }

    public void t() {
        ((ArrayList) this.f4688h).clear();
        this.f4689i = this.f4687g;
        f0 f0Var = (f0) this.f4687g;
        q6.b bVar = f0Var.f4460n;
        d0.e eVar = (d0.e) bVar.f8788h;
        int i2 = eVar.f2751h;
        while (true) {
            i2--;
            if (-1 >= i2) {
                eVar.g();
                ((a8.c) bVar.f8787g).c();
                return;
            }
            f0Var.E((f0) eVar.f2749f[i2]);
        }
    }

    public String toString() {
        switch (this.f4686f) {
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                return t3.p.a((r1) this.f4687g).toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ef  */
    /* JADX WARN: Type inference failed for: r13v20, types: [c7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [v9.z] */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r1v13, types: [v9.p0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v9.z u(l8.q r24, t8.a r25, v9.z r26) {
        /*
            Method dump skipped, instructions count: 1028
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.l.u(l8.q, t8.a, v9.z):v9.z");
    }

    public void v(String str, Map map, long j2) {
        q7.k.e(str, "name");
        q7.k.e(map, "tags");
        ((AtomicLong) ((ConcurrentHashMap) this.f4687g).computeIfAbsent(G(str, map), new g5.a(new c6.d(27), 4))).addAndGet(j2);
    }

    @Override // la.j
    public Object x(la.k kVar, g7.d dVar) {
        Object objX = ((la.j) this.f4687g).x(new d5.k(kVar, (d5.m) this.f4688h, (p7.k) this.f4689i, 0), dVar);
        return objX == h7.a.f4212f ? objX : c7.r.f1986a;
    }

    public void y(String str, Map map, long j2) {
        q7.k.e(str, "name");
        q7.k.e(map, "tags");
        ((AtomicLong) ((ConcurrentHashMap) this.f4688h).computeIfAbsent(G(str, map), new g5.a(new c6.d(26), 3))).set(j2);
    }

    public Object z() {
        long jB = j0.i.b();
        if (jB == j0.k.f5089a) {
            return this.f4689i;
        }
        j0.j jVar = (j0.j) ((AtomicReference) this.f4687g).get();
        int iA = jVar.a(jB);
        if (iA >= 0) {
            return jVar.f5088c[iA];
        }
        return null;
    }

    public /* synthetic */ l(Object obj, Object obj2, Object obj3, int i2) {
        this.f4686f = i2;
        this.f4687g = obj;
        this.f4688h = obj2;
        this.f4689i = obj3;
    }

    public l(o4.t1 t1Var, k5.t tVar) {
        this.f4686f = 20;
        q7.k.e(tVar, "logger");
        this.f4687g = t1Var;
        this.f4688h = tVar;
        this.f4689i = new ConcurrentHashMap();
    }

    public l(b6.a aVar, u4.l lVar, k5.g gVar) {
        this.f4686f = 7;
        this.f4687g = aVar;
        this.f4688h = lVar;
        this.f4689i = gVar != null ? new u4.k(gVar) : null;
    }

    public l(q6.b bVar, a5.f fVar, k5.g gVar) {
        this.f4686f = 2;
        q7.k.e(gVar, "logger");
        this.f4687g = bVar;
        this.f4688h = fVar;
        this.f4689i = gVar;
    }

    public l(Context context, k5.g gVar, v4.a aVar) {
        this.f4686f = 24;
        q7.k.e(context, "context");
        q7.k.e(gVar, "logger");
        this.f4687g = gVar;
        this.f4688h = aVar;
        this.f4689i = s7.a.H(new d0(14));
    }

    public l(x8.d dVar, k8.b bVar) {
        this.f4686f = 17;
        this.f4687g = dVar;
        this.f4688h = bVar;
        this.f4689i = new ConcurrentHashMap();
    }

    public l(v4.a aVar, k5.g gVar) {
        this.f4686f = 1;
        a5.d dVar = new a5.d();
        q7.k.e(gVar, "logger");
        this.f4687g = aVar;
        this.f4688h = gVar;
        this.f4689i = dVar;
    }

    public l(OfflineQueueDatabase_Impl offlineQueueDatabase_Impl) {
        this.f4686f = 0;
        this.f4687g = offlineQueueDatabase_Impl;
        this.f4688h = new c(offlineQueueDatabase_Impl, 1);
        this.f4689i = new d(offlineQueueDatabase_Impl, 3);
    }

    public l(v7.d dVar, Method[] methodArr, Method method) {
        this.f4686f = 3;
        q7.k.e(dVar, "argumentRange");
        this.f4687g = dVar;
        this.f4688h = methodArr;
        this.f4689i = method;
    }

    public l(a3.b bVar, r8.f fVar) {
        this.f4686f = 25;
        q7.k.e(fVar, "typeParameterResolver");
        this.f4687g = bVar;
        this.f4688h = fVar;
        this.f4689i = new nb.f(new h4.n(24, false));
    }

    public l(byte[] bArr) throws GeneralSecurityException {
        this.f4686f = 11;
        h4.z.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f4687g = secretKeySpec;
        if (x.a(1)) {
            Cipher cipher = (Cipher) h4.m.f4149b.f4151a.a("AES/ECB/NoPadding");
            cipher.init(1, secretKeySpec);
            byte[] bArrN = a.a.n(cipher.doFinal(new byte[16]));
            this.f4688h = bArrN;
            this.f4689i = a.a.n(bArrN);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public l(f8.h hVar, List list, l lVar) {
        this.f4686f = 10;
        q7.k.e(hVar, "classifierDescriptor");
        q7.k.e(list, "arguments");
        this.f4687g = hVar;
        this.f4688h = list;
        this.f4689i = lVar;
    }

    public l(int i2) {
        this.f4686f = i2;
        switch (i2) {
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                this.f4687g = new AtomicReference(j0.i.f5085b);
                this.f4688h = new Object();
                break;
            case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                this.f4687g = new ConcurrentHashMap();
                this.f4688h = new ConcurrentHashMap();
                this.f4689i = new ConcurrentHashMap();
                break;
            case 29:
                this.f4687g = new HashMap();
                this.f4688h = new HashMap();
                break;
            default:
                this.f4687g = new a7.d(11);
                this.f4688h = new a7.d(11);
                this.f4689i = new a7.d(11);
                break;
        }
    }

    public l(f0 f0Var) {
        this.f4686f = 13;
        this.f4687g = f0Var;
        this.f4688h = new ArrayList();
        this.f4689i = f0Var;
    }

    public l(ConcurrentMap concurrentMap, t3.k kVar, d4.a aVar, Class cls) {
        this.f4686f = 23;
        this.f4687g = concurrentMap;
        this.f4688h = kVar;
        this.f4689i = aVar;
    }

    public l(r1 r1Var, List list) {
        this.f4686f = 22;
        this.f4687g = r1Var;
        this.f4688h = list;
        this.f4689i = d4.a.f2836b;
    }
}
