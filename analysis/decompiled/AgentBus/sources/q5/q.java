package q5;

import b0.g2;
import ia.f1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class q {
    public final Object A;
    public final ConcurrentHashMap B;
    public final u4.k C;
    public volatile String D;
    public volatile String E;

    /* renamed from: a, reason: collision with root package name */
    public final d5.l f8747a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f8748b;

    /* renamed from: c, reason: collision with root package name */
    public final h5.g f8749c;

    /* renamed from: d, reason: collision with root package name */
    public final h5.b f8750d;

    /* renamed from: e, reason: collision with root package name */
    public final i5.u f8751e;

    /* renamed from: f, reason: collision with root package name */
    public final long f8752f;

    /* renamed from: g, reason: collision with root package name */
    public final long f8753g;

    /* renamed from: h, reason: collision with root package name */
    public final k5.a f8754h;

    /* renamed from: i, reason: collision with root package name */
    public final k5.t f8755i;

    /* renamed from: j, reason: collision with root package name */
    public final u4.l f8756j;

    /* renamed from: k, reason: collision with root package name */
    public final k5.q f8757k;

    /* renamed from: l, reason: collision with root package name */
    public final p7.k f8758l;

    /* renamed from: m, reason: collision with root package name */
    public final a6.u f8759m;

    /* renamed from: n, reason: collision with root package name */
    public final List f8760n;

    /* renamed from: o, reason: collision with root package name */
    public final t f8761o;

    /* renamed from: p, reason: collision with root package name */
    public final i5.l f8762p;

    /* renamed from: q, reason: collision with root package name */
    public final i5.f f8763q;

    /* renamed from: r, reason: collision with root package name */
    public final i5.l f8764r;

    /* renamed from: s, reason: collision with root package name */
    public final nb.f f8765s;

    /* renamed from: t, reason: collision with root package name */
    public final p5.c f8766t;

    /* renamed from: u, reason: collision with root package name */
    public final long f8767u;

    /* renamed from: v, reason: collision with root package name */
    public final u4.h f8768v;

    /* renamed from: w, reason: collision with root package name */
    public final q6.b f8769w;

    /* renamed from: x, reason: collision with root package name */
    public final na.d f8770x;

    /* renamed from: y, reason: collision with root package name */
    public final na.d f8771y;

    /* renamed from: z, reason: collision with root package name */
    public final t f8772z;

    public q(d5.l lVar, c cVar, a3.b bVar, h5.g gVar, h5.b bVar2, i5.u uVar, long j2, long j4, k5.a aVar, k5.g gVar2, u4.l lVar2, a7.d dVar, a5.a aVar2, a6.u uVar2, ArrayList arrayList, t tVar, i5.l lVar3, i5.f fVar, i5.l lVar4, nb.f fVar2, p5.c cVar2, long j10, u4.h hVar, q6.b bVar3) {
        q7.k.e(lVar, "pool");
        q7.k.e(cVar, "router");
        q7.k.e(bVar, "capabilityRegistry");
        q7.k.e(gVar, "invocationMapper");
        q7.k.e(bVar2, "idempotencyStore");
        q7.k.e(uVar, "offlineQueue");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar2, "logger");
        q7.k.e(dVar, "internalBus");
        this.f8747a = lVar;
        this.f8748b = cVar;
        this.f8749c = gVar;
        this.f8750d = bVar2;
        this.f8751e = uVar;
        this.f8752f = j2;
        this.f8753g = j4;
        this.f8754h = aVar;
        this.f8755i = gVar2;
        this.f8756j = lVar2;
        this.f8757k = dVar;
        this.f8758l = aVar2;
        this.f8759m = uVar2;
        this.f8760n = arrayList;
        this.f8761o = tVar;
        this.f8762p = lVar3;
        this.f8763q = fVar;
        this.f8764r = lVar4;
        this.f8765s = fVar2;
        this.f8766t = cVar2;
        this.f8767u = j10;
        this.f8768v = hVar;
        this.f8769w = bVar3;
        this.f8770x = ia.d0.b(f1.plus(ia.d0.c(), aVar.f5617b));
        this.f8771y = ia.d0.b(f1.plus(ia.d0.c(), aVar.f5616a));
        this.f8772z = new t(0);
        this.A = new Object();
        this.B = new ConcurrentHashMap();
        this.C = new u4.k(gVar2);
        this.E = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(q5.q r5, d5.e r6, i7.c r7) {
        /*
            boolean r0 = r7 instanceof q5.g
            if (r0 == 0) goto L13
            r0 = r7
            q5.g r0 = (q5.g) r0
            int r1 = r0.f8686j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8686j = r1
            goto L18
        L13:
            q5.g r0 = new q5.g
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f8684h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8686j
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            d5.e r6 = r0.f8683g
            q5.q r5 = r0.f8682f
            w7.e0.N(r7)     // Catch: java.lang.Throwable -> L2b
            goto L62
        L2b:
            r7 = move-exception
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            w7.e0.N(r7)
            la.j r7 = r6.a()     // Catch: java.lang.Throwable -> L2b
            la.g r2 = new la.g     // Catch: java.lang.Throwable -> L2b
            r4 = 6
            r2.<init>(r4, r5, r6)     // Catch: java.lang.Throwable -> L2b
            r0.f8682f = r5     // Catch: java.lang.Throwable -> L2b
            r0.f8683g = r6     // Catch: java.lang.Throwable -> L2b
            r0.f8686j = r3     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r5 = r7.x(r2, r0)     // Catch: java.lang.Throwable -> L2b
            if (r5 != r1) goto L62
            return r1
        L4f:
            k5.t r5 = r5.f8755i
            java.lang.String r6 = r6.getId()
            java.lang.String r0 = "collect failed for "
            java.lang.String r6 = a1.a.w(r0, r6)
            k5.g r5 = (k5.g) r5
            java.lang.String r0 = "Dispatcher"
            r5.a(r0, r6, r7)
        L62:
            c7.r r5 = c7.r.f1986a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.q.a(q5.q, d5.e, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(d5.e r11, q5.q r12, g7.d r13) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.q.b(d5.e, q5.q, g7.d):java.lang.Object");
    }

    public static String g(c5.b bVar) {
        Object obj;
        Map mapG = bVar.g();
        Object obj2 = mapG != null ? mapG.get("sessionKey") : null;
        String str = obj2 instanceof String ? (String) obj2 : null;
        if (str != null) {
            return str;
        }
        Map mapG2 = bVar.g();
        Object obj3 = mapG2 != null ? mapG2.get("payload") : null;
        Map map = obj3 instanceof Map ? (Map) obj3 : null;
        if (map == null || (obj = map.get("sessionKey")) == null || !(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    public static String k(c5.b bVar) {
        Map mapG = bVar.g();
        Object obj = mapG != null ? mapG.get("sessionId") : null;
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            return str;
        }
        Map mapG2 = bVar.g();
        Object obj2 = mapG2 != null ? mapG2.get("payload") : null;
        Map map = obj2 instanceof Map ? (Map) obj2 : null;
        Object obj3 = map != null ? map.get("sessionId") : null;
        if (obj3 instanceof String) {
            return (String) obj3;
        }
        return null;
    }

    public final d5.e c() {
        d5.e eVarC;
        String str = this.D;
        if (str == null || (eVarC = this.f8747a.c(str)) == null || eVarC.f() != d5.m.CHANNEL) {
            return null;
        }
        return eVarC;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010e  */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(u4.b r30, c5.b r31, u4.p r32) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1017
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.q.d(u4.b, c5.b, u4.p):void");
    }

    public final d e(d5.e eVar) {
        ka.g gVarB = a.a.b(256, 6, null);
        return new d(eVar, gVarB, ia.d0.r(this.f8770x, this.f8754h.f5616a, ia.c0.f4929i, new g2(gVarB, eVar, this, null, 6)));
    }

    /* JADX WARN: Path cross not found for [B:36:0x00fc, B:37:0x00fe], limit reached: 81 */
    /* JADX WARN: Path cross not found for [B:36:0x00fc, B:43:0x010f], limit reached: 81 */
    /* JADX WARN: Path cross not found for [B:36:0x00fc, B:49:0x0120], limit reached: 81 */
    /* JADX WARN: Path cross not found for [B:59:0x0157, B:60:0x0159], limit reached: 81 */
    /* JADX WARN: Path cross not found for [B:66:0x0177, B:59:0x0157], limit reached: 81 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b9 -> B:57:0x0149). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00dd -> B:57:0x0149). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x013f -> B:56:0x0144). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(c5.b r23, java.util.List r24, i7.c r25) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.q.f(c5.b, java.util.List, i7.c):java.lang.Object");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final java.lang.Object h(c5.b r22, d5.e r23, d5.e r24, long r25, boolean r27, i7.c r28) {
        /*
            Method dump skipped, instructions count: 1750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.q.h(c5.b, d5.e, d5.e, long, boolean, i7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x02c6, code lost:
    
        if (r1.b(r2, r3, r51, r5, null, r7, r8) != r11) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0386, code lost:
    
        if (r1.b(r2, r3, r51, r5, null, r7, r8) != r11) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03c8, code lost:
    
        if (r0.i(r1, r8) != r11) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x04fd, code lost:
    
        if (r0.i(r1, r8) != r11) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x059f, code lost:
    
        if (r0.i(r1, r8) != r11) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0601, code lost:
    
        if (r0.K(r2, r8) == r11) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0674, code lost:
    
        if (r0.i(r1, r8) != r11) goto L278;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:134:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x07ef  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0807  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0881  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x0a24  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0afd  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0b03  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0b12  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x0b34  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x0c08  */
    /* JADX WARN: Removed duplicated region for block: B:561:0x0c26  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0c44  */
    /* JADX WARN: Removed duplicated region for block: B:577:0x0c91  */
    /* JADX WARN: Removed duplicated region for block: B:617:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:618:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:619:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:620:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:623:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x027e  */
    /* JADX WARN: Type inference failed for: r2v10, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v11, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v143 */
    /* JADX WARN: Type inference failed for: r2v144 */
    /* JADX WARN: Type inference failed for: r2v145 */
    /* JADX WARN: Type inference failed for: r2v148 */
    /* JADX WARN: Type inference failed for: r2v149 */
    /* JADX WARN: Type inference failed for: r2v152 */
    /* JADX WARN: Type inference failed for: r2v153 */
    /* JADX WARN: Type inference failed for: r2v156 */
    /* JADX WARN: Type inference failed for: r2v157 */
    /* JADX WARN: Type inference failed for: r2v158 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v38, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v41, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v46, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v51, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v52, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v57, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v58, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v61, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v8, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r2v9, types: [q5.q] */
    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(c5.b r51, d5.e r52, i7.c r53) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 3414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.q.i(c5.b, d5.e, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(c5.b r24, i7.c r25) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.q.j(c5.b, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(c5.b r15, d5.e r16, java.lang.String r17, java.lang.String r18, boolean r19, i7.c r20) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.q.l(c5.b, d5.e, java.lang.String, java.lang.String, boolean, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0070 -> B:23:0x0074). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(c5.b r11, d5.e r12, i7.c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof q5.p
            if (r0 == 0) goto L13
            r0 = r13
            q5.p r0 = (q5.p) r0
            int r1 = r0.f8746m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8746m = r1
            goto L18
        L13:
            q5.p r0 = new q5.p
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f8744k
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8746m
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            s5.d r10 = r0.f8743j
            java.util.Iterator r11 = r0.f8742i
            c5.b r12 = r0.f8741h
            d5.e r2 = r0.f8740g
            q5.q r4 = r0.f8739f
            w7.e0.N(r13)
            r9 = r2
            r2 = r10
            r10 = r4
            r4 = r0
            r0 = r9
            goto L74
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            w7.e0.N(r13)
            java.util.List r13 = r10.f8760n
            java.util.Iterator r13 = r13.iterator()
            r9 = r12
            r12 = r11
            r11 = r13
            r13 = r9
        L4b:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto La5
            java.lang.Object r2 = r11.next()
            s5.d r2 = (s5.d) r2
            boolean r4 = r2.a(r12, r13)
            if (r4 == 0) goto L4b
            r0.f8739f = r10
            r0.f8740g = r13
            r0.f8741h = r12
            r0.f8742i = r11
            r0.f8743j = r2
            r0.f8746m = r3
            java.lang.Object r4 = r2.b(r12, r13, r0)
            if (r4 != r1) goto L70
            return r1
        L70:
            r9 = r0
            r0 = r13
            r13 = r4
            r4 = r9
        L74:
            s5.c r13 = (s5.c) r13
            s5.b r5 = s5.b.f9498a
            boolean r5 = q7.k.a(r13, r5)
            if (r5 != 0) goto La2
            s5.a r11 = s5.a.f9497a
            boolean r11 = q7.k.a(r13, r11)
            if (r11 == 0) goto L9c
            k5.t r3 = r10.f8755i
            java.lang.String r10 = r2.getId()
            java.lang.String r11 = "drop by preprocessor="
            java.lang.String r5 = r11.concat(r10)
            r7 = 4
            r8 = 0
            java.lang.String r4 = "Dispatcher"
            r6 = 0
            k5.s.info$default(r3, r4, r5, r6, r7, r8)
            r10 = 0
            return r10
        L9c:
            a4.u r10 = new a4.u
            r10.<init>()
            throw r10
        La2:
            r13 = r0
            r0 = r4
            goto L4b
        La5:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.q.m(c5.b, d5.e, i7.c):java.lang.Object");
    }
}
