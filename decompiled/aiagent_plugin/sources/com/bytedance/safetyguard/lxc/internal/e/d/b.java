package com.bytedance.safetyguard.lxc.internal.e.d;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.safetyguard.lxc.api.SidecarAuthHandler;
import com.bytedance.safetyguard.lxc.api.SidecarAuthRequest;
import com.bytedance.safetyguard.lxc.api.SidecarAuthResponse;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecarConfig;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.i;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.n;
import d.o.k;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SidecarRequestDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements SidecarAuthHandler {
    private static final String TAG = "SidecarRequestDispatcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10752a = null;
    private static final k g = null;
    private static final Set<String> h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SafetyGuardSidecarConfig f10753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.e.g.b f10754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.e.d.d f10755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.a<Long> f10756e;
    private final com.bytedance.safetyguard.lxc.internal.a.e f;

    /* JADX INFO: compiled from: SidecarRequestDispatcher.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.d.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SidecarRequestDispatcher.kt */
        static final class C0239a extends p implements d.h.a.b<Byte, CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0239a f10757a = null;

            static {
                f10757a = new C0239a();
            }

            C0239a() {
                super(1);
            }

            public final CharSequence a(byte r3) {
                String r2 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
                o.c(r2, "format(...)");
                return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ CharSequence invoke(Byte r3) {
                return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).byteValue());
            }
        }

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.d.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SidecarRequestDispatcher.kt */
        static final class C0240b extends p implements d.h.a.b<Byte, CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0240b f10758a = null;

            static {
                f10758a = new C0240b();
            }

            C0240b() {
                super(1);
            }

            public final CharSequence a(byte r3) {
                String r2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
                o.c(r2, "format(...)");
                return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ CharSequence invoke(Byte r3) {
                return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).byteValue());
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ String a(a r0, byte[] r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ boolean a(a r0, String r1, String r2) {
            return r0.b(r1, r2);
        }

        public static final /* synthetic */ String b(a r0, String r1, String r2) {
            return r0.a(r1, r2);
        }

        public final String a(String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18) {
            o.e(r11, "version");
            o.e(r12, "method");
            o.e(r13, "targetHost");
            o.e(r14, "pathAndQuery");
            o.e(r15, "bodySha");
            o.e(r16, DBHelper.COL_TIME);
            o.e(r17, DownloadHelper.IDENTITY);
            o.e(r18, "authHeader");
            return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new String[]{r11, r12, r13, r14, r15, r16, r17, r18}), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
        }

        private final String a(byte[] r10) {
            byte[] r0 = MessageDigest.getInstance("SHA-256").digest(r10);
            o.a(r0);
            return i.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(C0240b.f10758a, d.h.a.b.class, "com.obric.aiagent.plugin"), 30, null);
        }

        private final String a(String r13, String r14) {
            Mac r0 = Mac.getInstance("HmacSHA256");
            Charset r2 = StandardCharsets.UTF_8;
            o.c(r2, "UTF_8");
            byte[] r15 = r13.getBytes(r2);
            o.c(r15, "getBytes(...)");
            r0.init((Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r15, "HmacSHA256"), Key.class, "com.obric.aiagent.plugin"));
            Charset r12 = StandardCharsets.UTF_8;
            o.c(r12, "UTF_8");
            byte[] r16 = r14.getBytes(r12);
            o.c(r16, "getBytes(...)");
            byte[] r3 = r0.doFinal(r16);
            o.c(r3, "doFinal(...)");
            return i.a(r3, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(C0239a.f10757a, d.h.a.b.class, "com.obric.aiagent.plugin"), 30, null);
        }

        private final boolean b(String r3, String r4) {
            Charset r2 = StandardCharsets.UTF_8;
            o.c(r2, "UTF_8");
            byte[] r5 = r3.getBytes(r2);
            o.c(r5, "getBytes(...)");
            Charset r1 = StandardCharsets.UTF_8;
            o.c(r1, "UTF_8");
            byte[] r6 = r4.getBytes(r1);
            o.c(r6, "getBytes(...)");
            return MessageDigest.isEqual(r5, r6);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.d.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SidecarRequestDispatcher.kt */
    private static final class C0241b extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.e.d.a f10761c;

        public final int a() {
            return this.f10759a;
        }

        public final String b() {
            return this.f10760b;
        }

        public final com.bytedance.safetyguard.lxc.internal.e.d.a c() {
            return this.f10761c;
        }

        public C0241b(int r2, String r3, com.bytedance.safetyguard.lxc.internal.e.d.a r4) {
            o.e(r3, "messageName");
            o.e(r4, "reason");
            super(r3);
            this.f10759a = r2;
            this.f10760b = r3;
            this.f10761c = r4;
        }

        public final SidecarAuthResponse d() {
            if (o.a(this.f10760b, "sidecar_session_invalid") == false) goto L6;
            return com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.c();
        L6:
            return com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.a(this.f10759a);
        }
    }

    /* JADX INFO: compiled from: SidecarRequestDispatcher.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10762a = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.e.f.a.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.e.f.a.f10830b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[com.bytedance.safetyguard.lxc.internal.e.f.a.f10831c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10762a = r0;
        }
    }

    /* JADX INFO: compiled from: SidecarRequestDispatcher.kt */
    static final class d extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f10763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SidecarAuthRequest f10764b;

        d(b r1, SidecarAuthRequest r2) {
            this.f10763a = r1;
            this.f10764b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar_dispatch event=request_rejected outcome=internal_error method=" + b.a(this.f10763a, this.f10764b.getMethod()) + " pathRef=" + b.a(this.f10763a).a(b.b(this.f10763a, this.f10764b.getPathAndQuery())) + " requestBytes=" + this.f10764b.getBody().length + " headerCount=" + this.f10764b.getHeaders().size();
        }
    }

    /* JADX INFO: compiled from: SidecarRequestDispatcher.kt */
    static final class e extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0241b f10765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f10766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SidecarAuthRequest f10767c;

        e(C0241b r1, b r2, SidecarAuthRequest r3) {
            this.f10765a = r1;
            this.f10766b = r2;
            this.f10767c = r3;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sidecar_dispatch event=request_rejected outcome=rejected reason=" + this.f10765a.c().name() + " httpStatus=" + this.f10765a.a() + " messageName=" + this.f10765a.b() + " method=" + b.a(this.f10766b, this.f10767c.getMethod()) + " pathRef=" + b.a(this.f10766b).a(b.b(this.f10766b, this.f10767c.getPathAndQuery())) + " requestBytes=" + this.f10767c.getBody().length + " headerCount=" + this.f10767c.getHeaders().size();
        }
    }

    public b(SafetyGuardSidecarConfig r3, com.bytedance.safetyguard.lxc.internal.e.g.b r4, com.bytedance.safetyguard.lxc.internal.e.d.d r5, d.h.a.a<Long> r6, com.bytedance.safetyguard.lxc.internal.a.e r7) {
        com.bytedance.safetyguard.lxc.internal.e.d.d r8 = (com.bytedance.safetyguard.lxc.internal.e.d.d) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.safetyguard.lxc.internal.e.d.d.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r10 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        o.e(r3, "config");
        o.e(r4, "sessionStore");
        o.e(r8, "handler");
        o.e(r9, "nowMillis");
        o.e(r10, "logger");
        this.f10753b = r3;
        this.f10754c = r4;
        this.f10755d = r8;
        this.f10756e = r9;
        this.f = r10;
    }

    public static final /* synthetic */ com.bytedance.safetyguard.lxc.internal.a.e a(b r0) {
        return r0.f;
    }

    public static final /* synthetic */ String a(b r0, String r1) {
        return r0.d(r1);
    }

    public static final /* synthetic */ String b(b r0, String r1) {
        return r0.c(r1);
    }

    @Override // com.bytedance.safetyguard.lxc.api.SidecarAuthHandler
    public Object handle(SidecarAuthRequest r4, d.c.d<? super SidecarAuthResponse> r5) {
        d.c.d<? super SidecarAuthResponse> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.d.c r7 = a(r4);     // Catch: Throwable -> L6 C0241b -> L9 CancellationException -> L12
    L5:
        return this.f10755d.a(r7, r6);
    L9:
        e = move-exception;
        a(r4, e);
        return e.d();
    L12:
        e = move-exception;
        throw e;
    L6:
        th = move-exception;
        com.bytedance.safetyguard.lxc.internal.a.c.a(th);
        this.f.b(TAG, th, (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this, r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.g();
    }

    private final com.bytedance.safetyguard.lxc.internal.e.d.c a(SidecarAuthRequest r19) {
        String r4 = a(r19, "x-lark-proxy-version");
        if (o.a(r4, "v1") == false) goto L68;
        String r2 = a(a(r19, "x-lark-proxy-target"));
        String r12 = a(r19, "x-lark-proxy-identity");
        Long r3 = d.o.o.e(a(r19, "x-lark-proxy-timestamp"));
        if (r3 == null) goto L66;
        long r5 = r3.longValue();
        long r9 = 1000;
        long r7 = ((Number) ZeusTransformUtils.preCheckCast(this.f10756e.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() / r9;
        long r14 = this.f10753b.getTimestampDriftMillis() / r9;
        if (r5 >= (r7 - r14)) goto L9;
    L64:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10750d, 0, null, 6, null);
        throw new d.d();
    L9:
        if (r5 > (r7 + r14)) goto L64;
        String r8 = a(r19, "x-lark-body-sha256");
        a r6 = f10752a;
        if (a.a(r6, r8, a.a(r6, r19.getBody())) == false) goto L62;
        String r15 = a(r19, "x-lark-proxy-auth-header");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(h, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L15;
    L17:
        Iterator r11 = r10.iterator();
    L19:
        if (r11.hasNext() == false) goto L16;
        if (d.o.o.a((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin"), r15, true) == false) goto L19;
        boolean r13 = false;
    L23:
        if (r13 == true) goto L60;
        String r16 = a(r19, "x-lark-proxy-signature");
        String r17 = b(r19.getPathAndQuery());
        String r18 = f10752a.a(r4, r19.getMethod(), r2, r17, r8, String.valueOf(r5), r12, r15);
        List<com.bytedance.safetyguard.lxc.internal.e.g.a> r20 = this.f10754c.b();
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L26:
        if (r21.hasNext() == false) goto L30;
        Object r22 = r21.next();
        com.bytedance.safetyguard.lxc.internal.e.g.a r23 = (com.bytedance.safetyguard.lxc.internal.e.g.a) ZeusTransformUtils.preCheckCast(r22, com.bytedance.safetyguard.lxc.internal.e.g.a.class, "com.obric.aiagent.plugin");
        a r24 = f10752a;
        if (a.a(r24, r16, a.b(r24, r23.e(), r18)) == false) goto L26;
    L31:
        com.bytedance.safetyguard.lxc.internal.e.g.a r25 = (com.bytedance.safetyguard.lxc.internal.e.g.a) ZeusTransformUtils.preCheckCast(r22, com.bytedance.safetyguard.lxc.internal.e.g.a.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L34;
        com.bytedance.safetyguard.lxc.internal.e.f.a r110 = com.bytedance.safetyguard.lxc.internal.e.f.a.f10829a.a(r12);
        if (r110 != null) goto L42;
        a(com.bytedance.safetyguard.lxc.internal.e.d.a.i, 401, "identity_not_supported");
        throw new d.d();
    L42:
        if (r25.f().contains(r2) == true) goto L44;
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.j, 403, null, 4, null);
        throw new d.d();
    L44:
        if (a(r25.d(), r2, r110, r15) == false) goto L54;
        String r26 = r19.getMethod();
        String r111 = r25.a();
        String r112 = r25.b();
        String r0 = r25.c();
        if (r110 != com.bytedance.safetyguard.lxc.internal.e.f.a.f10830b) goto L48;
        boolean r113 = true;
    L49:
        if (r113 == false) goto L51;
        String r114 = r0;
    L53:
        return new com.bytedance.safetyguard.lxc.internal.e.d.c(r26, r17, r2, r15, r111, r110, r112, r114, r19.getBody(), r19.getHeaders());
    L51:
        r114 = null;
        goto L53
    L48:
        r113 = false;
        goto L49
    L54:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.k, 403, null, 4, null);
        throw new d.d();
    L34:
        if (r20.isEmpty() == false) goto L36;
        com.bytedance.safetyguard.lxc.internal.e.d.a r1 = com.bytedance.safetyguard.lxc.internal.e.d.a.h;
    L37:
        a(r1, 401, "sidecar_session_invalid");
        throw new d.d();
    L36:
        r1 = com.bytedance.safetyguard.lxc.internal.e.d.a.g;
        goto L37
    L30:
        r22 = null;
        goto L31
    L60:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f, 0, null, 6, null);
        throw new d.d();
    L16:
        r13 = true;
        goto L23
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L17;
    L62:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10751e, 0, null, 6, null);
        throw new d.d();
    L66:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10750d, 0, null, 6, null);
        throw new d.d();
    L68:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10748b, 0, null, 6, null);
        throw new d.d();
    }

    private final boolean a(SidecarBrand r2, String r3, com.bytedance.safetyguard.lxc.internal.e.f.a r4, String r5) {
        if (o.a(r3, r2.getOpenApiHost()) == false) goto L6;
        return d.o.o.a(r5, "Authorization", true);
    L6:
        if (o.a(r3, r2.getMcpHost()) == false) goto L15;
        int r1 = c.f10762a[r4.ordinal()];
        if (r1 == 1) goto L19;
        if (r1 != 2) goto L13;
        return d.o.o.a(r5, "X-Lark-MCP-TAT", true);
    L13:
        throw new d.k();
    L19:
        return d.o.o.a(r5, "X-Lark-MCP-UAT", true);
    L15:
        return false;
    }

    private final String a(SidecarAuthRequest r7, String r8) {
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.getHeaders().get(r8), String.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L5;
    L10:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10747a, 0, null, 6, null);
        throw new d.d();
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r9 = null;
    L8:
        if (r9 == null) goto L10;
        return r9;
    }

    private final String a(String r8) {
        boolean r3 = false;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), '@', false, 2, null) == false) goto L5;
    L52:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10749c, 0, null, 6, null);
        throw new d.d();
    L5:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), '?', false, 2, null) == true) goto L52;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), '#', false, 2, null) == true) goto L52;
        if (d.o.o.b(r8, "https://", true) == false) goto L45;
        n.a r0 = n.f38560a;     // Catch: Throwable -> L12
        b r1 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Object r9 = n.f(new URI(r8));     // Catch: Throwable -> L12
    L15:
        if (n.c(r9) != null) goto L42;
        URI r10 = (URI) ZeusTransformUtils.preCheckCast(r9, URI.class, "com.obric.aiagent.plugin");
        if (r10.getUserInfo() == null) goto L19;
    L40:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10749c, 0, null, 6, null);
        throw new d.d();
    L19:
        if (r10.getPort() != (-1)) goto L40;
        if (r10.getRawQuery() != null) goto L40;
        if (r10.getRawFragment() != null) goto L40;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.getRawPath(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L27;
    L28:
        r3 = true;
    L29:
        if (r3 == false) goto L31;
    L35:
        r8 = r10.getHost();
        if (r8 != null) goto L49;
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10749c, 0, null, 6, null);
        throw new d.d();
    L49:
        return com.bytedance.safetyguard.lxc.internal.e.g.b.f10839a.a(r8);
    L31:
        if (o.a(r10.getRawPath(), "/") == true) goto L35;
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10749c, 0, null, 6, null);
        throw new d.d();
    L27:
        if (r2.length() != 0) goto L29;
    L42:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10749c, 0, null, 6, null);
        throw new d.d();
    L12:
        th = move-exception;
        n.a r4 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L15
    L45:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == false) goto L47;
    L50:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.f10749c, 0, null, 6, null);
        throw new d.d();
    L47:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), ':', false, 2, null) == true) goto L50;
        goto L50
    }

    private final String b(String r9) {
        boolean r1 = false;
        if (d.o.o.b(r9, "/", false, 2, null) == true) goto L5;
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.l, 400, null, 4, null);
        throw new d.d();
    L5:
        if (d.o.o.b(r9, "//", false, 2, null) == true) goto L23;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        int r2 = 0;
    L8:
        if (r2 >= r0.length()) goto L19;
        char r3 = r0.charAt(r2);
        if (r3 >= ' ') goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L17;
        r2 = r2 + 1;
        goto L8
    L17:
        r1 = true;
        goto L19
    L12:
        if (r3 == 127) goto L15;
        r4 = false;
    L19:
        if (r1 == true) goto L21;
        return r9;
    L21:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.l, 400, null, 4, null);
        throw new d.d();
    L23:
        a(this, com.bytedance.safetyguard.lxc.internal.e.d.a.l, 400, null, 4, null);
        throw new d.d();
    }

    static /* synthetic */ Void a(b r0, com.bytedance.safetyguard.lxc.internal.e.d.a r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 401;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = "sidecar_request_rejected";
    L9:
        return r0.a(r1, r2, r3);
    }

    private final Void a(com.bytedance.safetyguard.lxc.internal.e.d.a r1, int r2, String r3) {
        throw new C0241b(r2, r3, r1);
    }

    private final void a(SidecarAuthRequest r3, C0241b r4) {
        this.f.a(TAG, (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r4, this, r3), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final String c(String r3) {
        return d.o.o.a(d.o.o.a(r3, '?', null, 2, null), '#', null, 2, null);
    }

    private final String d(String r3) {
        if (g.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L9;
        return "UNKNOWN";
    L9:
        return r3;
    }

    static {
        f10752a = new a(null);
        g = new k("[A-Z]{1,16}");
        h = ax.a(new String[]{"Authorization", "X-Lark-MCP-UAT", "X-Lark-MCP-TAT"});
    }
}
