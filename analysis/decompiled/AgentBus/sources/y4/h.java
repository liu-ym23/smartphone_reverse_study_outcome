package y4;

import android.content.Context;
import com.stepos.agentbus.config.EnvProvider;
import ia.b0;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11567a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f11568b;

    /* renamed from: c, reason: collision with root package name */
    public final k5.t f11569c;

    /* renamed from: d, reason: collision with root package name */
    public final k5.q f11570d;

    /* renamed from: e, reason: collision with root package name */
    public final l5.b f11571e;

    /* renamed from: f, reason: collision with root package name */
    public final EnvProvider f11572f;

    /* renamed from: g, reason: collision with root package name */
    public final q5.t f11573g;

    /* renamed from: h, reason: collision with root package name */
    public final z5.c f11574h;

    /* renamed from: i, reason: collision with root package name */
    public final String f11575i;

    /* renamed from: j, reason: collision with root package name */
    public final c7.o f11576j;

    /* renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap f11577k;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f11578l;

    public h(Context context, na.d dVar, k5.g gVar, a7.d dVar2, l5.b bVar, EnvProvider envProvider, q5.t tVar, z5.c cVar, String str) {
        q7.k.e(context, "context");
        q7.k.e(dVar, "scope");
        q7.k.e(gVar, "logger");
        q7.k.e(dVar2, "internalBus");
        q7.k.e(bVar, "cloudAccountTokenProvider");
        q7.k.e(envProvider, "envProvider");
        this.f11567a = context;
        this.f11568b = dVar;
        this.f11569c = gVar;
        this.f11570d = dVar2;
        this.f11571e = bVar;
        this.f11572f = envProvider;
        this.f11573g = tVar;
        this.f11574h = cVar;
        this.f11575i = str;
        this.f11576j = s7.a.H(new b(this, 0));
        this.f11577k = new ConcurrentHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final y4.f d(y4.h r17, com.stepos.agentbus.config.OpenClawCloudUpstream r18, java.lang.String r19, boolean r20, boolean r21) {
        /*
            r17.getClass()
            boolean r0 = ga.k.t0(r19)
            r1 = 0
            if (r0 != 0) goto Ld
            r0 = r19
            goto Le
        Ld:
            r0 = r1
        Le:
            if (r0 != 0) goto L13
        L10:
            r6 = r1
            goto L8f
        L13:
            r2 = 47
            r3 = 6
            r4 = 0
            int r2 = ga.k.q0(r0, r2, r4, r3)
            java.lang.String r3 = "substring(...)"
            if (r2 < 0) goto L27
            java.lang.String r5 = r0.substring(r4, r2)
            q7.k.d(r5, r3)
            goto L28
        L27:
            r5 = r0
        L28:
            if (r2 < 0) goto L33
            java.lang.String r0 = r0.substring(r2)
            q7.k.d(r0, r3)
        L31:
            r15 = r0
            goto L36
        L33:
            java.lang.String r0 = ""
            goto L31
        L36:
            java.lang.String r0 = ":"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            r2 = 2
            java.util.List r0 = ga.k.D0(r5, r0, r2)
            int r3 = r0.size()
            if (r3 != r2) goto L48
            goto L49
        L48:
            r0 = r1
        L49:
            if (r0 != 0) goto L4c
            goto L10
        L4c:
            r2 = 1
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Integer r2 = ga.r.i0(r2)
            if (r2 == 0) goto L10
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r18.getTlsRequired()
            o4.z1 r0 = o4.a.g(r0, r2, r3)
            java.lang.String r7 = r0.f7717a
            java.lang.String r8 = r0.f7718b
            java.lang.String r9 = r0.f7719c
            int r10 = r0.f7720d
            boolean r11 = r0.f7721e
            java.lang.String r13 = r0.f7723g
            java.lang.String r0 = "stableId"
            q7.k.e(r7, r0)
            java.lang.String r0 = "name"
            q7.k.e(r8, r0)
            java.lang.String r0 = "host"
            q7.k.e(r9, r0)
            o4.z1 r6 = new o4.z1
            r12 = 0
            r14 = 0
            r16 = 1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L8f:
            if (r6 != 0) goto L92
            return r1
        L92:
            y4.f r0 = new y4.f
            boolean r2 = r18.getTlsRequired()
            if (r2 != 0) goto La3
            boolean r2 = r6.f7721e
            if (r2 != 0) goto La3
            r12 = r20
        La0:
            r2 = r21
            goto Lb1
        La3:
            o4.v2 r7 = new o4.v2
            java.lang.String r10 = r6.f7717a
            r11 = 1
            r8 = 0
            r9 = 0
            r12 = r20
            r7.<init>(r8, r9, r10, r11, r12)
            r1 = r7
            goto La0
        Lb1:
            r0.<init>(r6, r1, r12, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.h.d(y4.h, com.stepos.agentbus.config.OpenClawCloudUpstream, java.lang.String, boolean, boolean):y4.f");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final o4.w a(com.stepos.agentbus.config.OpenClawCloudUpstream r3) {
        /*
            r2 = this;
            java.lang.String r3 = r3.getMtlsClientCertAlias()
            if (r3 == 0) goto L10
            boolean r0 = ga.k.t0(r3)
            if (r0 != 0) goto Ld
            goto Le
        Ld:
            r3 = 0
        Le:
            if (r3 != 0) goto L12
        L10:
            java.lang.String r3 = "agentbus_cloud_mtls_attestation"
        L12:
            java.util.concurrent.ConcurrentHashMap r0 = r2.f11577k
            java.lang.Object r1 = r0.get(r3)
            if (r1 != 0) goto L29
            o4.w r1 = new o4.w
            android.content.Context r2 = r2.f11567a
            r1.<init>(r2, r3)
            java.lang.Object r2 = r0.putIfAbsent(r3, r1)
            if (r2 != 0) goto L28
            goto L29
        L28:
            r1 = r2
        L29:
            o4.w r1 = (o4.w) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.h.a(com.stepos.agentbus.config.OpenClawCloudUpstream):o4.w");
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final o4.b3 b(java.lang.String r25, d5.t r26, o4.t1 r27, c5.c r28, k5.a r29, d5.l r30, f5.b r31, long r32) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.h.b(java.lang.String, d5.t, o4.t1, c5.c, k5.a, d5.l, f5.b, long):o4.b3");
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(com.stepos.agentbus.config.OpenClawCloudUpstream r25) {
        /*
            Method dump skipped, instructions count: 995
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.h.c(com.stepos.agentbus.config.OpenClawCloudUpstream):void");
    }
}
