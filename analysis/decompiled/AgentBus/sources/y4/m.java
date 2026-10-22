package y4;

import com.stepos.agentbus.config.CloudBridgeConfig;
import ia.b0;
import ia.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import o4.b3;
import o4.t1;
import o4.y2;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: v, reason: collision with root package name */
    public static final Set f11601v = d7.n.x0(new String[]{"system.run", "system.which", "stepclaw.exec"});

    /* renamed from: a, reason: collision with root package name */
    public final CloudBridgeConfig f11602a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.l f11603b;

    /* renamed from: c, reason: collision with root package name */
    public final b0 f11604c;

    /* renamed from: d, reason: collision with root package name */
    public final c5.c f11605d;

    /* renamed from: e, reason: collision with root package name */
    public final k5.a f11606e;

    /* renamed from: f, reason: collision with root package name */
    public final k5.t f11607f;

    /* renamed from: g, reason: collision with root package name */
    public final h f11608g;

    /* renamed from: h, reason: collision with root package name */
    public final f5.b f11609h;

    /* renamed from: i, reason: collision with root package name */
    public final long f11610i;

    /* renamed from: j, reason: collision with root package name */
    public final a3.b f11611j;

    /* renamed from: k, reason: collision with root package name */
    public final s5.e f11612k;

    /* renamed from: l, reason: collision with root package name */
    public final v4.a f11613l;

    /* renamed from: m, reason: collision with root package name */
    public final q6.b f11614m;

    /* renamed from: n, reason: collision with root package name */
    public final nb.f f11615n;

    /* renamed from: o, reason: collision with root package name */
    public final z5.c f11616o;

    /* renamed from: p, reason: collision with root package name */
    public final u4.l f11617p;

    /* renamed from: q, reason: collision with root package name */
    public final u4.k f11618q;

    /* renamed from: r, reason: collision with root package name */
    public t1 f11619r;

    /* renamed from: s, reason: collision with root package name */
    public b3 f11620s;

    /* renamed from: t, reason: collision with root package name */
    public h4.e f11621t;

    /* renamed from: u, reason: collision with root package name */
    public t1 f11622u;

    public m(CloudBridgeConfig cloudBridgeConfig, d5.l lVar, na.d dVar, c5.d dVar2, k5.a aVar, k5.g gVar, h hVar, f5.f fVar, long j2, a3.b bVar, s5.e eVar, v4.a aVar2, q6.b bVar2, nb.f fVar2, z5.c cVar, u4.l lVar2) {
        q7.k.e(lVar, "pool");
        q7.k.e(dVar, "scope");
        q7.k.e(dVar2, "codec");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        q7.k.e(hVar, "clientFactory");
        q7.k.e(fVar, "blobServer");
        q7.k.e(bVar, "capabilityRegistry");
        q7.k.e(eVar, "invokeInterceptor");
        this.f11602a = cloudBridgeConfig;
        this.f11603b = lVar;
        this.f11604c = dVar;
        this.f11605d = dVar2;
        this.f11606e = aVar;
        this.f11607f = gVar;
        this.f11608g = hVar;
        this.f11609h = fVar;
        this.f11610i = j2;
        this.f11611j = bVar;
        this.f11612k = eVar;
        this.f11613l = aVar2;
        this.f11614m = bVar2;
        this.f11615n = fVar2;
        this.f11616o = cVar;
        this.f11617p = lVar2;
        this.f11618q = new u4.k(gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(y4.m r22, o4.k0 r23, d5.e r24, java.lang.String r25, i7.c r26) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.m.a(y4.m, o4.k0, d5.e, java.lang.String, i7.c):java.lang.Object");
    }

    public static LinkedHashMap c(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        q7.k.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, g(jSONObject.opt(next)));
        }
        return linkedHashMap;
    }

    public static Object g(Object obj) {
        if (obj == null || obj.equals(JSONObject.NULL)) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return c((JSONObject) obj);
        }
        if (!(obj instanceof JSONArray)) {
            return obj;
        }
        JSONArray jSONArray = (JSONArray) obj;
        v7.d dVarN = nb.i.N(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(d7.t.A0(dVarN, 10));
        Iterator it = dVarN.iterator();
        while (true) {
            v7.c cVar = (v7.c) it;
            if (!cVar.f10528h) {
                return arrayList;
            }
            arrayList.add(g(jSONArray.opt(cVar.nextInt())));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r11, java.lang.String r12, i7.c r13) {
        /*
            r10 = this;
            c7.r r1 = c7.r.f1986a
            boolean r0 = r13 instanceof y4.i
            if (r0 == 0) goto L16
            r0 = r13
            y4.i r0 = (y4.i) r0
            int r2 = r0.f11581h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r0.f11581h = r2
        L14:
            r8 = r0
            goto L1c
        L16:
            y4.i r0 = new y4.i
            r0.<init>(r10, r13)
            goto L14
        L1c:
            java.lang.Object r13 = r8.f11579f
            h7.a r0 = h7.a.f4212f
            int r2 = r8.f11581h
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            w7.e0.N(r13)     // Catch: java.lang.Throwable -> L2b
            return r1
        L2b:
            r0 = move-exception
            r10 = r0
            goto L62
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            w7.e0.N(r13)
            u4.l r13 = r10.f11617p
            if (r13 != 0) goto L3e
            goto L61
        L3e:
            r2 = r3
            d5.e r3 = r13.a()
            if (r3 != 0) goto L46
            goto L61
        L46:
            u4.k r10 = r10.f11618q     // Catch: java.lang.Throwable -> L2b
            d7.a0 r4 = d7.a0.f2944f     // Catch: java.lang.Throwable -> L2b
            c5.b r5 = s9.d.p(r11, r4)     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r13 = r13.f10092c     // Catch: java.lang.Throwable -> L2b
            r6 = r13
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L2b
            r8.f11581h = r2     // Catch: java.lang.Throwable -> L2b
            r9 = 32
            r2 = r10
            r4 = r11
            r7 = r12
            java.lang.Object r10 = u4.k.c(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L2b
            if (r10 != r0) goto L61
            return r0
        L61:
            return r1
        L62:
            w7.e0.n(r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.m.b(java.lang.String, java.lang.String, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(o4.k0 r11, p7.n r12, g7.d r13) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.m.d(o4.k0, p7.n, g7.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0137  */
    /* JADX WARN: Type inference failed for: r1v9, types: [y4.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.m.e():void");
    }

    public final void f() {
        b3 b3Var = this.f11620s;
        g7.d dVar = null;
        if (b3Var != null) {
            d0.s(this.f11604c, null, null, new y2(b3Var, dVar, 2), 3);
            this.f11603b.h(b3Var.f7284a);
        }
        this.f11620s = null;
        t1 t1Var = this.f11619r;
        if (t1Var != null) {
            t1Var.E = null;
            t1Var.d("disconnect");
            t1Var.f7596x.t();
            t1Var.f7597y.t();
        }
        this.f11619r = null;
        this.f11621t = null;
        this.f11622u = null;
    }
}
