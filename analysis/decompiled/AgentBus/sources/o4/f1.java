package o4;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7344a;

    /* renamed from: b, reason: collision with root package name */
    public final la.u0 f7345b = la.k0.c(h1.IDLE);

    /* renamed from: c, reason: collision with root package name */
    public final la.u0 f7346c = la.k0.c(null);

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f7347d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final ra.d f7348e = new ra.d();

    /* renamed from: f, reason: collision with root package name */
    public final ka.g f7349f = a.a.b(-1, 6, null);

    /* renamed from: g, reason: collision with root package name */
    public final ia.x f7350g;

    /* renamed from: h, reason: collision with root package name */
    public volatile long f7351h;

    /* renamed from: i, reason: collision with root package name */
    public volatile long f7352i;

    /* renamed from: j, reason: collision with root package name */
    public volatile int f7353j;

    /* renamed from: k, reason: collision with root package name */
    public volatile ia.w1 f7354k;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f7355l;

    /* renamed from: m, reason: collision with root package name */
    public volatile ia.w1 f7356m;

    /* renamed from: n, reason: collision with root package name */
    public volatile ab.e0 f7357n;

    /* renamed from: o, reason: collision with root package name */
    public volatile int f7358o;

    /* renamed from: p, reason: collision with root package name */
    public volatile int f7359p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f7360q;

    /* renamed from: r, reason: collision with root package name */
    public volatile boolean f7361r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ t1 f7362s;

    public f1(t1 t1Var, String str) {
        this.f7362s = t1Var;
        this.f7344a = str;
        pa.e eVar = ia.n0.f4982a;
        this.f7350g = pa.d.f8556h.T(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(o4.f1 r12, java.lang.String r13, i7.c r14) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.a(o4.f1, java.lang.String, i7.c):java.lang.Object");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:47:0x00ec
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [g7.d, o4.i0] */
    /* JADX WARN: Type inference failed for: r14v7, types: [g7.d, java.lang.Object, o4.i0] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v25, types: [o4.f1] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:153:0x03a4 -> B:160:0x03cb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:155:0x03bd -> B:157:0x03c0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008d -> B:33:0x008e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(o4.f1 r28, i7.c r29) {
        /*
            Method dump skipped, instructions count: 1010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.b(o4.f1, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r0v19, types: [i7.i, p7.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(o4.f1 r17, i7.c r18) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.c(o4.f1, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(o4.f1 r10, java.lang.String r11, java.lang.String r12, o4.l0 r13, java.lang.Long r14, i7.c r15) throws org.json.JSONException {
        /*
            boolean r0 = r15 instanceof o4.b1
            if (r0 == 0) goto L14
            r0 = r15
            o4.b1 r0 = (o4.b1) r0
            int r1 = r0.f7282h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f7282h = r1
        L12:
            r15 = r0
            goto L1a
        L14:
            o4.b1 r0 = new o4.b1
            r0.<init>(r10, r15)
            goto L12
        L1a:
            java.lang.Object r0 = r15.f7280f
            h7.a r1 = h7.a.f4212f
            int r2 = r15.f7282h
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            w7.e0.N(r0)     // Catch: java.lang.Throwable -> Laf
            goto Laf
        L2a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L32:
            w7.e0.N(r0)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r0 = "id"
            r2.put(r0, r11)
            java.lang.String r11 = "nodeId"
            r2.put(r11, r12)
            boolean r11 = r13.f7434a
            java.lang.String r12 = r13.f7435b
            java.lang.String r0 = "ok"
            r2.put(r0, r11)
            if (r12 == 0) goto L6f
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L55
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L55
            goto L5b
        L55:
            r0 = move-exception
            r11 = r0
            c7.l r11 = w7.e0.n(r11)
        L5b:
            boolean r0 = r11 instanceof c7.l
            if (r0 == 0) goto L60
            r11 = 0
        L60:
            org.json.JSONObject r11 = (org.json.JSONObject) r11
            if (r11 == 0) goto L6a
            java.lang.String r12 = "payload"
            r2.put(r12, r11)
            goto L6f
        L6a:
            java.lang.String r11 = "payloadJSON"
            r2.put(r11, r12)
        L6f:
            o4.j0 r11 = r13.f7436c
            if (r11 == 0) goto L8b
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r13 = "code"
            java.lang.String r0 = r11.f7405a
            r12.put(r13, r0)
            java.lang.String r13 = "message"
            java.lang.String r11 = r11.f7406b
            r12.put(r13, r11)
            java.lang.String r11 = "error"
            r2.put(r11, r12)
        L8b:
            if (r14 == 0) goto L9c
            long r4 = r14.longValue()
            r6 = 15000(0x3a98, double:7.411E-320)
            r8 = 1260000(0x1339e0, double:6.225227E-318)
            long r11 = nb.i.l(r4, r6, r8)
        L9a:
            r13 = r11
            goto La0
        L9c:
            r11 = 60000(0xea60, double:2.9644E-319)
            goto L9a
        La0:
            java.lang.String r11 = "node.invoke.result"
            java.lang.String r12 = r2.toString()     // Catch: java.lang.Throwable -> Laf
            r15.f7282h = r3     // Catch: java.lang.Throwable -> Laf
            java.lang.Object r10 = r10.p(r11, r12, r13, r15)     // Catch: java.lang.Throwable -> Laf
            if (r10 != r1) goto Laf
            goto Lb1
        Laf:
            c7.r r1 = c7.r.f1986a
        Lb1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.d(o4.f1, java.lang.String, java.lang.String, o4.l0, java.lang.Long, i7.c):java.lang.Object");
    }

    public static final void e(f1 f1Var, na.d dVar) {
        ia.w1 w1Var = f1Var.f7354k;
        g7.d dVar2 = null;
        if (w1Var != null) {
            ia.f1.cancel$default((ia.g1) w1Var, (CancellationException) null, 1, (Object) null);
        }
        if (!f1Var.f7355l) {
            k5.s.info$default(f1Var.f7362s.f7583k, "OpenClawGateway", a1.a.j("[", f1Var.f7344a, "] skip keepalive (edge session; ping via OkHttp pingInterval)"), null, 4, null);
            f1Var.f7354k = null;
        } else {
            k5.s.info$default(f1Var.f7362s.f7583k, "OpenClawGateway", a1.a.j("[", f1Var.f7344a, "] starting keepalive (cloudHb=true wsPing=10000ms via OkHttp)"), null, 4, null);
            pa.e eVar = ia.n0.f4982a;
            f1Var.f7354k = ia.d0.s(dVar, pa.d.f8556h, null, new b0.f2(f1Var.f7362s, f1Var, dVar2, 11), 2);
        }
    }

    public final void f() {
        ab.e0 e0Var = this.f7357n;
        if (e0Var == null) {
            return;
        }
        k5.s.info$default(this.f7362s.f7583k, "OpenClawGateway", a1.a.j("[", this.f7344a, "] closing WS for screen-off (stops OkHttp pingInterval)"), null, 4, null);
        ((nb.g) e0Var).b(1000, "screen off idle");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c1, code lost:
    
        if (r12 == r3) goto L171;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c5  */
    /* JADX WARN: Type inference failed for: r0v8, types: [i7.i, p7.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(o4.i0 r31, i7.c r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.g(o4.i0, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r8, java.lang.String r9, java.lang.String r10, long r11, i7.c r13) {
        /*
            r7 = this;
            boolean r0 = r13 instanceof o4.u0
            if (r0 == 0) goto L13
            r0 = r13
            o4.u0 r0 = (o4.u0) r0
            int r1 = r0.f7647m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7647m = r1
            goto L18
        L13:
            o4.u0 r0 = new o4.u0
            r0.<init>(r7, r13)
        L18:
            java.lang.Object r13 = r0.f7645k
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f7647m
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            long r7 = r0.f7644j
            java.lang.String r9 = r0.f7642h
            java.lang.String r10 = r0.f7641g
            o4.f1 r11 = r0.f7640f
            w7.e0.N(r13)     // Catch: ia.a2 -> L97
            goto L8c
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            long r11 = r0.f7644j
            ia.s r7 = r0.f7643i
            java.lang.String r9 = r0.f7642h
            java.lang.String r8 = r0.f7641g
            o4.f1 r10 = r0.f7640f
            w7.e0.N(r13)
            goto L6f
        L49:
            w7.e0.N(r13)
            ia.s r13 = ia.d0.a()
            java.util.concurrent.ConcurrentHashMap r2 = r7.f7347d
            r2.put(r9, r13)
            o4.t1 r2 = r7.f7362s
            r2.h()
            r0.f7640f = r7
            r0.f7641g = r8
            r0.f7642h = r9
            r0.f7643i = r13
            r0.f7644j = r11
            r0.f7647m = r4
            java.lang.Object r10 = r7.q(r10, r5, r0)
            if (r10 != r1) goto L6d
            goto L87
        L6d:
            r10 = r7
            r7 = r13
        L6f:
            o4.v0 r13 = new o4.v0     // Catch: ia.a2 -> L93
            r2 = 0
            r13.<init>(r7, r5, r2)     // Catch: ia.a2 -> L93
            r0.f7640f = r10     // Catch: ia.a2 -> L93
            r0.f7641g = r8     // Catch: ia.a2 -> L93
            r0.f7642h = r9     // Catch: ia.a2 -> L93
            r0.f7643i = r5     // Catch: ia.a2 -> L93
            r0.f7644j = r11     // Catch: ia.a2 -> L93
            r0.f7647m = r3     // Catch: ia.a2 -> L93
            java.lang.Object r13 = ia.d0.C(r11, r13, r0)     // Catch: ia.a2 -> L93
            if (r13 != r1) goto L88
        L87:
            return r1
        L88:
            r6 = r10
            r10 = r8
            r7 = r11
            r11 = r6
        L8c:
            o4.n0 r13 = (o4.n0) r13     // Catch: ia.a2 -> L97
            r12 = 0
            r11.n(r12)     // Catch: ia.a2 -> L97
            return r13
        L93:
            r6 = r10
            r10 = r8
            r7 = r11
            r11 = r6
        L97:
            java.util.concurrent.ConcurrentHashMap r12 = r11.f7347d
            r12.remove(r9)
            r11.n(r4)
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r10)
            java.lang.String r10 = " timeout after "
            r11.append(r10)
            r11.append(r7)
            java.lang.String r7 = "ms"
            r11.append(r7)
            java.lang.String r7 = r11.toString()
            r9.<init>(r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.h(java.lang.String, java.lang.String, java.lang.String, long, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r19, o4.g3 r20, i7.c r21) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.i(java.lang.String, o4.g3, i7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e3, code lost:
    
        if (r2 == r4) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0122, code lost:
    
        if (r0 == r4) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(i7.c r19) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.j(i7.c):java.lang.Object");
    }

    public final void k() {
        ConcurrentHashMap concurrentHashMap = this.f7347d;
        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            ia.f1.cancel$default((ia.g1) ((Map.Entry) it.next()).getValue(), (CancellationException) null, 1, (Object) null);
        }
        concurrentHashMap.clear();
    }

    public final void l() {
        ab.e0 e0Var = this.f7357n;
        if (e0Var != null) {
            ((nb.g) e0Var).b(1000, "reconnect");
        }
        u();
    }

    public final void m(i0 i0Var) {
        if (this.f7356m != null) {
            return;
        }
        this.f7355l = i0Var.f7392a.f7726j;
        ia.b0 b0Var = this.f7362s.f7573a;
        pa.e eVar = ia.n0.f4982a;
        this.f7356m = ia.d0.s(b0Var, pa.d.f8556h, null, new a5.b(this, i0Var, null, 21), 2);
    }

    public final void n(boolean z4) {
        this.f7353j = z4 ? this.f7353j + 1 : 0;
        if (z4 && this.f7355l && this.f7353j >= 2) {
            k5.s.warn$default(this.f7362s.f7583k, "OpenClawGateway", "[" + this.f7344a + "] " + this.f7353j + " consecutive RPC timeouts → kickReconnect", null, 4, null);
            this.f7353j = 0;
            l();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable o(long r8, i7.c r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof o4.y0
            if (r0 == 0) goto L14
            r0 = r10
            o4.y0 r0 = (o4.y0) r0
            int r1 = r0.f7699i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f7699i = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            o4.y0 r0 = new o4.y0
            r0.<init>(r7, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.f7697g
            h7.a r0 = h7.a.f4212f
            int r1 = r6.f7699i
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            o4.f1 r7 = r6.f7696f
            w7.e0.N(r10)     // Catch: java.lang.Throwable -> L2b
            goto L4b
        L2b:
            r0 = move-exception
        L2c:
            r8 = r0
            goto L55
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            w7.e0.N(r10)
            r10 = r2
            java.lang.String r2 = "heartbeat"
            r6.f7696f = r7     // Catch: java.lang.Throwable -> L52
            r6.f7699i = r10     // Catch: java.lang.Throwable -> L52
            r3 = 0
            r1 = r7
            r4 = r8
            java.lang.Object r7 = r1.p(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L4e
            if (r7 != r0) goto L4a
            return r0
        L4a:
            r7 = r1
        L4b:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L2b
            goto L59
        L4e:
            r0 = move-exception
            r8 = r0
            r7 = r1
            goto L55
        L52:
            r0 = move-exception
            r1 = r7
            goto L2c
        L55:
            c7.l r8 = w7.e0.n(r8)
        L59:
            o4.t1 r9 = r7.f7362s
            java.lang.Throwable r10 = c7.m.a(r8)
            if (r10 == 0) goto L79
            k5.t r0 = r9.f7583k
            java.lang.String r7 = r7.f7344a
            java.lang.String r9 = r10.getMessage()
            java.lang.String r10 = "["
            java.lang.String r1 = "] liveness probe failed: "
            java.lang.String r2 = a1.a.k(r10, r7, r1, r9)
            r4 = 4
            r5 = 0
            java.lang.String r1 = "OpenClawGateway"
            r3 = 0
            k5.s.warn$default(r0, r1, r2, r3, r4, r5)
        L79:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            boolean r9 = r8 instanceof c7.l
            if (r9 == 0) goto L80
            r8 = r7
        L80:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.o(long, i7.c):java.io.Serializable");
    }

    public final Object p(String str, String str2, long j2, i7.c cVar) throws JSONException {
        String string = UUID.randomUUID().toString();
        q7.k.d(string, "toString(...)");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "req");
        jSONObject.put("id", string);
        jSONObject.put("method", str);
        if (str2 != null && !ga.k.t0(str2)) {
            jSONObject.put("params", new JSONObject(str2));
        }
        String string2 = jSONObject.toString();
        q7.k.d(string2, "toString(...)");
        return h(str, string, string2, j2, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e8 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016f A[Catch: all -> 0x017b, TRY_ENTER, TryCatch #0 {all -> 0x017b, blocks: (B:29:0x00b6, B:63:0x016f, B:64:0x017a), top: B:70:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r24, o4.g3 r25, i7.c r26) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.q(java.lang.String, o4.g3, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable r(java.lang.String r9, java.lang.String r10, i7.c r11) throws org.json.JSONException {
        /*
            r8 = this;
            boolean r0 = r11 instanceof o4.d1
            if (r0 == 0) goto L14
            r0 = r11
            o4.d1 r0 = (o4.d1) r0
            int r1 = r0.f7329h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f7329h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            o4.d1 r0 = new o4.d1
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.f7327f
            h7.a r7 = h7.a.f4212f
            int r0 = r6.f7329h
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            w7.e0.N(r11)     // Catch: java.lang.Throwable -> L7f
            goto L7c
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            w7.e0.N(r11)
            r11 = 0
            if (r10 == 0) goto L51
            boolean r0 = ga.k.t0(r10)
            if (r0 == 0) goto L3e
            goto L51
        L3e:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L44
            r0.<init>(r10)     // Catch: java.lang.Throwable -> L44
            goto L49
        L44:
            r0 = move-exception
            c7.l r0 = w7.e0.n(r0)
        L49:
            boolean r2 = r0 instanceof c7.l
            if (r2 == 0) goto L4e
            goto L4f
        L4e:
            r11 = r0
        L4f:
            org.json.JSONObject r11 = (org.json.JSONObject) r11
        L51:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r2 = "event"
            r0.put(r2, r9)
            if (r11 == 0) goto L63
            java.lang.String r9 = "payload"
            r0.put(r9, r11)
            goto L6a
        L63:
            if (r10 == 0) goto L6a
            java.lang.String r9 = "payloadJSON"
            r0.put(r9, r10)
        L6a:
            java.lang.String r2 = "node.event"
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L7f
            r6.f7329h = r1     // Catch: java.lang.Throwable -> L7f
            r4 = 8000(0x1f40, double:3.9525E-320)
            r1 = r8
            java.lang.Object r8 = r1.p(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L7f
            if (r8 != r7) goto L7c
            return r7
        L7c:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L7f
            goto L85
        L7f:
            r0 = move-exception
            r8 = r0
            c7.l r8 = w7.e0.n(r8)
        L85:
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            boolean r10 = r8 instanceof c7.l
            if (r10 == 0) goto L8c
            r8 = r9
        L8c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.r(java.lang.String, java.lang.String, i7.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable s(java.lang.String r20, o4.g3 r21, i7.c r22) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.f1.s(java.lang.String, o4.g3, i7.c):java.io.Serializable");
    }

    public final void t() {
        v();
        ia.w1 w1Var = this.f7356m;
        if (w1Var != null) {
            ia.f1.cancel$default((ia.g1) w1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f7356m = null;
        this.f7355l = false;
        k();
        ab.e0 e0Var = this.f7357n;
        if (e0Var != null) {
            ((nb.g) e0Var).b(1000, "bye");
        }
        this.f7357n = null;
        this.f7345b.f(h1.IDLE);
        this.f7358o = 0;
        this.f7359p = 0;
        this.f7360q = false;
        this.f7361r = false;
        this.f7353j = 0;
        this.f7352i = 0L;
    }

    public final void u() {
        this.f7349f.u(c7.r.f1986a);
    }

    public final void v() {
        k5.s.info$default(this.f7362s.f7583k, "OpenClawGateway", a1.a.j("[", this.f7344a, "] stopping keepalive"), null, 4, null);
        ia.w1 w1Var = this.f7354k;
        if (w1Var != null) {
            ia.f1.cancel$default((ia.g1) w1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f7354k = null;
    }

    public final void w(boolean z4) {
        if (!z4) {
            t1 t1Var = this.f7362s;
            boolean z10 = t1Var.G;
            boolean z11 = t1Var.I;
            boolean zF = t1Var.f();
            if (!z10 && !z11 && !zF) {
                return;
            }
        }
        if (this.f7345b.getValue() == h1.ONLINE) {
            return;
        }
        u();
    }
}
