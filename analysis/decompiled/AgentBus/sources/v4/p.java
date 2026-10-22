package v4;

import android.content.pm.PackageManager;
import com.stepos.agentbus.config.AgentBusConfig;
import ia.d0;
import ia.s;
import k5.t;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: r, reason: collision with root package name */
    public static final v7.d f10486r = new v7.d(3, 3, 1);

    /* renamed from: a, reason: collision with root package name */
    public final AgentBusConfig f10487a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.l f10488b;

    /* renamed from: c, reason: collision with root package name */
    public final a3.b f10489c;

    /* renamed from: d, reason: collision with root package name */
    public final c5.c f10490d;

    /* renamed from: e, reason: collision with root package name */
    public final s9.d f10491e;

    /* renamed from: f, reason: collision with root package name */
    public final k5.a f10492f;

    /* renamed from: g, reason: collision with root package name */
    public final t f10493g;

    /* renamed from: h, reason: collision with root package name */
    public final k5.q f10494h;

    /* renamed from: i, reason: collision with root package name */
    public final na.d f10495i;

    /* renamed from: j, reason: collision with root package name */
    public final i5.f f10496j;

    /* renamed from: k, reason: collision with root package name */
    public final p5.q f10497k;

    /* renamed from: l, reason: collision with root package name */
    public final q6.b f10498l;

    /* renamed from: m, reason: collision with root package name */
    public final a7.d f10499m;

    /* renamed from: n, reason: collision with root package name */
    public final PackageManager f10500n;

    /* renamed from: o, reason: collision with root package name */
    public c6.h f10501o;

    /* renamed from: p, reason: collision with root package name */
    public final s f10502p;

    /* renamed from: q, reason: collision with root package name */
    public final ra.d f10503q;

    public p(AgentBusConfig agentBusConfig, d5.l lVar, a3.b bVar, c5.d dVar, s9.d dVar2, k5.a aVar, k5.g gVar, a7.d dVar3, na.d dVar4, i5.f fVar, p5.q qVar, q6.b bVar2, a7.d dVar5, PackageManager packageManager) {
        q7.k.e(agentBusConfig, "config");
        q7.k.e(lVar, "pool");
        q7.k.e(bVar, "capabilityRegistry");
        q7.k.e(dVar, "codec");
        q7.k.e(dVar2, "validator");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        q7.k.e(dVar3, "internalBus");
        q7.k.e(dVar5, "authenticator");
        this.f10487a = agentBusConfig;
        this.f10488b = lVar;
        this.f10489c = bVar;
        this.f10490d = dVar;
        this.f10491e = dVar2;
        this.f10492f = aVar;
        this.f10493g = gVar;
        this.f10494h = dVar3;
        this.f10495i = dVar4;
        this.f10496j = fVar;
        this.f10497k = qVar;
        this.f10498l = bVar2;
        this.f10499m = dVar5;
        this.f10500n = packageManager;
        this.f10502p = d0.a();
        this.f10503q = new ra.d();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:224|(1:226)|334|227|228|(6:231|232|233|237|222|(6:238|(1:268)(9:(1:242)(1:243)|244|(1:246)(1:247)|(1:249)(1:251)|250|252|(3:254|(1:262)(1:261)|263)(1:264)|265|(1:267))|269|(6:280|282|332|283|284|(5:287|288|292|(1:294)|295))(9:271|(1:273)(1:274)|275|(2:277|(1:279)(0))(1:281)|282|332|283|284|(0))|53|312)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x03b0, code lost:
    
        if (r1.e(r0) == r4) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x047d, code lost:
    
        if (r1.b(r2, r5, "missing peer credentials", r3) == r4) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x04d7, code lost:
    
        if (r1.b(r2, r5, r0, r3) == r4) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x051f, code lost:
    
        if (r1.b(r2, r5, "packageName mismatch for peer uid", r3) == r4) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x059f, code lost:
    
        if (r1.b(r2, r5, r6, r3) == r4) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x06be, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x06bf, code lost:
    
        r15 = r21;
        r22 = r2;
        r2 = r1;
        r22 = r12;
        r12 = r11;
        r11 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x06ca, code lost:
    
        w7.e0.n(r0);
        r2 = r22;
        r1 = r2;
        r14 = r11;
        r11 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x099d, code lost:
    
        if (r2.e(r0) == r15) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01fd, code lost:
    
        if (r2.e(r1) == r4) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:94:0x02a8, B:95:0x02aa], limit reached: 318 */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x082c  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x08f6  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x090c  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0632 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Type inference failed for: r0v58, types: [ra.b] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:231:0x06a9 -> B:232:0x06b3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(v4.p r43, c6.l r44, i7.c r45) {
        /*
            Method dump skipped, instructions count: 2502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.p.a(v4.p, c6.l, i7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
    
        if (r12.b(r11, r1) == r2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ba, code lost:
    
        if (r12.e(r11) == r2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
    
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(c6.l r12, java.lang.String r13, java.lang.String r14, i7.c r15) {
        /*
            r11 = this;
            java.lang.String r0 = "auth denied: "
            boolean r1 = r15 instanceof v4.n
            if (r1 == 0) goto L15
            r1 = r15
            v4.n r1 = (v4.n) r1
            int r2 = r1.f10481j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f10481j = r2
            goto L1a
        L15:
            v4.n r1 = new v4.n
            r1.<init>(r11, r15)
        L1a:
            java.lang.Object r15 = r1.f10479h
            h7.a r2 = h7.a.f4212f
            int r3 = r1.f10481j
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L3f
            if (r3 == r5) goto L35
            if (r3 != r4) goto L2d
            w7.e0.N(r15)     // Catch: java.lang.Throwable -> Lbd
            goto Lc1
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            java.lang.String r14 = r1.f10478g
            c6.l r12 = r1.f10477f
            w7.e0.N(r15)     // Catch: java.lang.Throwable -> L3d
            goto L9f
        L3d:
            r11 = move-exception
            goto L9c
        L3f:
            w7.e0.N(r15)
            c5.b r15 = new c5.b
            c7.j r3 = new c7.j
            java.lang.String r6 = "type"
            java.lang.String r7 = "hello-error"
            r3.<init>(r6, r7)
            c7.j r6 = new c7.j
            java.lang.String r8 = "id"
            r6.<init>(r8, r13)
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            c7.j r8 = new c7.j
            java.lang.String r9 = "ok"
            r8.<init>(r9, r13)
            c7.j r13 = new c7.j
            java.lang.String r9 = "code"
            java.lang.String r10 = "STEPCLAW_AUTH_DENIED"
            r13.<init>(r9, r10)
            c7.j r9 = new c7.j
            java.lang.String r10 = "message"
            r9.<init>(r10, r14)
            c7.j[] r13 = new c7.j[]{r13, r9}
            java.util.Map r13 = d7.e0.U(r13)
            c7.j r9 = new c7.j
            java.lang.String r10 = "error"
            r9.<init>(r10, r13)
            c7.j[] r13 = new c7.j[]{r3, r6, r8, r9}
            java.util.Map r13 = d7.e0.U(r13)
            r15.<init>(r7, r13)
            c5.c r11 = r11.f10490d     // Catch: java.lang.Throwable -> L3d
            c5.d r11 = (c5.d) r11     // Catch: java.lang.Throwable -> L3d
            java.lang.String r11 = r11.b(r15)     // Catch: java.lang.Throwable -> L3d
            r1.f10477f = r12     // Catch: java.lang.Throwable -> L3d
            r1.f10478g = r14     // Catch: java.lang.Throwable -> L3d
            r1.f10481j = r5     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r11 = r12.b(r11, r1)     // Catch: java.lang.Throwable -> L3d
            if (r11 != r2) goto L9f
            goto Lbc
        L9c:
            w7.e0.n(r11)
        L9f:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbd
            r11.<init>(r0)     // Catch: java.lang.Throwable -> Lbd
            r11.append(r14)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> Lbd
            c6.a r11 = ib.c.G(r11)     // Catch: java.lang.Throwable -> Lbd
            r13 = 0
            r1.f10477f = r13     // Catch: java.lang.Throwable -> Lbd
            r1.f10478g = r13     // Catch: java.lang.Throwable -> Lbd
            r1.f10481j = r4     // Catch: java.lang.Throwable -> Lbd
            c7.r r11 = r12.e(r11)     // Catch: java.lang.Throwable -> Lbd
            if (r11 != r2) goto Lc1
        Lbc:
            return r2
        Lbd:
            r11 = move-exception
            w7.e0.n(r11)
        Lc1:
            c7.r r11 = c7.r.f1986a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.p.b(c6.l, java.lang.String, java.lang.String, i7.c):java.lang.Object");
    }
}
