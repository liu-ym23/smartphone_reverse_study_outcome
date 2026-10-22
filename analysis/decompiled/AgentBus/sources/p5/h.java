package p5;

import b0.d0;
import fi.iki.elonen.NanoHTTPD;
import i5.u;
import ia.f1;
import ia.w1;
import k5.t;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final d5.l f8454a;

    /* renamed from: b, reason: collision with root package name */
    public final u f8455b;

    /* renamed from: c, reason: collision with root package name */
    public final k5.q f8456c;

    /* renamed from: d, reason: collision with root package name */
    public final t f8457d;

    /* renamed from: e, reason: collision with root package name */
    public final long f8458e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8459f;

    /* renamed from: g, reason: collision with root package name */
    public final String f8460g;

    /* renamed from: h, reason: collision with root package name */
    public final d5.m f8461h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f8462i;

    /* renamed from: j, reason: collision with root package name */
    public final d5.t f8463j;

    /* renamed from: k, reason: collision with root package name */
    public final long f8464k;

    /* renamed from: l, reason: collision with root package name */
    public final p7.a f8465l;

    /* renamed from: m, reason: collision with root package name */
    public final na.d f8466m;

    /* renamed from: n, reason: collision with root package name */
    public final ra.d f8467n;

    /* renamed from: o, reason: collision with root package name */
    public w1 f8468o;

    public h(d5.l lVar, u uVar, a7.d dVar, k5.a aVar, k5.g gVar, String str, d5.m mVar, d5.t tVar, int i2) {
        boolean z4 = (i2 & 512) == 0;
        tVar = (i2 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 ? null : tVar;
        long j2 = (i2 & 2048) != 0 ? 0L : 120000L;
        d0 d0Var = new d0(12);
        q7.k.e(lVar, "pool");
        q7.k.e(uVar, "offlineQueue");
        q7.k.e(dVar, "internalBus");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        q7.k.e(mVar, "triggerRole");
        this.f8454a = lVar;
        this.f8455b = uVar;
        this.f8456c = dVar;
        this.f8457d = gVar;
        this.f8458e = 3000L;
        this.f8459f = 20;
        this.f8460g = str;
        this.f8461h = mVar;
        this.f8462i = z4;
        this.f8463j = tVar;
        this.f8464k = j2;
        this.f8465l = d0Var;
        this.f8466m = ia.d0.b(f1.plus(ia.d0.c(), aVar.f5617b));
        this.f8467n = new ra.d();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(1:207)|149|150|188|151|(1:227)(4:154|155|161|(7:163|164|(0)|167|211|62|(0)(0))(5:168|(2:170|(1:228))|(1:174)|148|221))) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:96|190|97|98|205|99|(1:225)(8:102|103|203|110|(5:112|113|194|114|115)(1:120)|209|94|(8:125|(2:127|128)|129|(1:166)|167|211|62|(0)(0))(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x030e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x030f, code lost:
    
        r2 = r1;
        r1 = r11;
        r11 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0443, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0444, code lost:
    
        r7 = r4;
        r4 = r1;
        r1 = r2;
        r2 = r7;
        r7 = r5;
        r12 = r8;
        r14 = r10;
        r5 = r11;
        r11 = r13;
        r13 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0325 A[Catch: all -> 0x036e, TRY_LEAVE, TryCatch #8 {all -> 0x036e, blocks: (B:110:0x0321, B:112:0x0325), top: B:203:0x0321 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x045b A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #7 {all -> 0x004d, blocks: (B:161:0x0457, B:163:0x045b, B:168:0x047b, B:170:0x04a9, B:160:0x0453, B:14:0x0047, B:24:0x007b), top: B:202:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x047b A[Catch: all -> 0x004d, TRY_ENTER, TryCatch #7 {all -> 0x004d, blocks: (B:161:0x0457, B:163:0x045b, B:168:0x047b, B:170:0x04a9, B:160:0x0453, B:14:0x0047, B:24:0x007b), top: B:202:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0267 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #5 {all -> 0x00ca, blocks: (B:78:0x0240, B:82:0x0263, B:84:0x0267, B:90:0x02b9, B:92:0x02bd, B:130:0x039e, B:131:0x03a2, B:133:0x03a8, B:137:0x03bd, B:139:0x03c1, B:141:0x03ef, B:32:0x00c1), top: B:198:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02d3 A[Catch: all -> 0x037f, TRY_LEAVE, TryCatch #11 {all -> 0x037f, blocks: (B:94:0x02cd, B:96:0x02d3), top: B:209:0x02cd }] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [g7.d, p5.f] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27, types: [ra.b] */
    /* JADX WARN: Type inference failed for: r2v3, types: [ra.b] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0361 -> B:209:0x02cd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x0373 -> B:209:0x02cd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:179:0x04de -> B:183:0x0501). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:181:0x04fe -> B:183:0x0501). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(p5.h r25, java.util.List r26, i7.c r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.h.a(p5.h, java.util.List, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(i5.p r7, i7.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof p5.g
            if (r0 == 0) goto L13
            r0 = r8
            p5.g r0 = (p5.g) r0
            int r1 = r0.f8453j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8453j = r1
            goto L18
        L13:
            p5.g r0 = new p5.g
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f8451h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8453j
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            i5.p r7 = r0.f8450g
            p5.h r6 = r0.f8449f
            w7.e0.N(r8)
            goto L5e
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            w7.e0.N(r8)
            c5.b r8 = r7.f4696b
            java.lang.String r8 = r8.b()
            if (r8 == 0) goto L69
            int r2 = r8.length()
            if (r2 != 0) goto L46
            goto L69
        L46:
            r0.f8449f = r6
            r0.f8450g = r7
            r0.f8453j = r4
            i5.u r2 = r6.f8455b
            k5.a r4 = r2.f4724d
            ia.x r4 = r4.f5619d
            i5.q r5 = new i5.q
            r5.<init>(r8, r2, r3)
            java.lang.Object r8 = ia.d0.B(r4, r5, r0)
            if (r8 != r1) goto L5e
            return r1
        L5e:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L69
            java.lang.String r6 = "tombstoned"
            return r6
        L69:
            c5.b r8 = r7.f4696b
            long r0 = r7.f4697c
            java.lang.String r7 = r8.d()
            java.lang.String r8 = "chat.send"
            boolean r7 = q7.k.a(r7, r8)
            if (r7 == 0) goto Lb4
            long r7 = r6.f8464k
            r4 = 0
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 <= 0) goto Lb4
            int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r7 <= 0) goto Lb4
            p7.a r7 = r6.f8465l
            java.lang.Object r7 = r7.c()
            java.lang.Number r7 = (java.lang.Number) r7
            long r7 = r7.longValue()
            long r7 = r7 - r0
            long r0 = r6.f8464k
            int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r6 <= 0) goto Lb4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = "chat.send over-age "
            r6.<init>(r2)
            r6.append(r7)
            java.lang.String r7 = "ms>"
            r6.append(r7)
            r6.append(r0)
            java.lang.String r7 = "ms"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            return r6
        Lb4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.h.b(i5.p, i7.c):java.lang.Object");
    }
}
