package com.bytedance.safetyguard.lxc.internal.e.h;

import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.bytedance.safetyguard.lxc.internal.e.a.l;
import com.bytedance.safetyguard.lxc.internal.e.a.m;
import com.bytedance.safetyguard.lxc.internal.e.a.t;
import com.bytedance.safetyguard.lxc.internal.e.a.u;
import com.bytedance.safetyguard.lxc.internal.e.a.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: VaultSidecarTokenResolver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements com.bytedance.safetyguard.lxc.internal.e.h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f10849a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.e.i.b f10850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f10851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<Long> f10852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f10853e;

    /* JADX INFO: compiled from: VaultSidecarTokenResolver.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f10856c;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f10854a, r8.f10854a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f10855b, r8.f10855b) == true) goto L15;
            return false;
        L15:
            if (this.f10856c == r8.f10856c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f10854a.hashCode() * 31) + this.f10855b.hashCode()) * 31) + Long.hashCode(this.f10856c);
        }

        public String toString() {
            return "CachedTenantToken(appId=" + this.f10854a + ", token=" + this.f10855b + ", expiresAtMillis=" + this.f10856c + ')';
        }

        public a(String r2, String r3, long r4) {
            o.e(r2, "appId");
            o.e(r3, "token");
            this.f10854a = r2;
            this.f10855b = r3;
            this.f10856c = r4;
        }

        public final String a() {
            return this.f10854a;
        }

        public final String b() {
            return this.f10855b;
        }

        public final long c() {
            return this.f10856c;
        }
    }

    /* JADX INFO: compiled from: VaultSidecarTokenResolver.kt */
    private static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.h.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VaultSidecarTokenResolver.kt */
    public /* synthetic */ class C0245c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10857a = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.e.f.a.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.e.f.a.f10830b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[com.bytedance.safetyguard.lxc.internal.e.f.a.f10831c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10857a = r0;
        }
    }

    /* JADX INFO: compiled from: VaultSidecarTokenResolver.kt */
    @d.c.b.a.f(b = "VaultSidecarTokenResolver.kt", c = {22, 26, 27}, d = "resolve", e = "com.bytedance.safetyguard.lxc.internal.sidecar.token.VaultSidecarTokenResolver")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f10860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f10861d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f10862e;

        d(c r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10861d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10860c = r3;
            this.f10862e |= Integer.MIN_VALUE;
            return this.f10861d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VaultSidecarTokenResolver.kt */
    @d.c.b.a.f(b = "VaultSidecarTokenResolver.kt", c = {84}, d = "resolveTenantAccessToken", e = "com.bytedance.safetyguard.lxc.internal.sidecar.token.VaultSidecarTokenResolver")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f10865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f10866d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f10867e;

        e(c r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10866d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10865c = r3;
            this.f10867e |= Integer.MIN_VALUE;
            return c.a(this.f10866d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: VaultSidecarTokenResolver.kt */
    @d.c.b.a.f(b = "VaultSidecarTokenResolver.kt", c = {35, 44, 67}, d = "resolveUserToken", e = "com.bytedance.safetyguard.lxc.internal.sidecar.token.VaultSidecarTokenResolver")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f10871d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f10872e;
        int f;

        f(c r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10872e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10871d = r3;
            this.f |= Integer.MIN_VALUE;
            return c.a(this.f10872e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f10849a = new b(null);
    }

    public c(com.bytedance.safetyguard.lxc.internal.e.i.b r3, l r4, d.h.a.a<Long> r5) {
        com.bytedance.safetyguard.lxc.internal.e.i.b r6 = (com.bytedance.safetyguard.lxc.internal.e.i.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.safetyguard.lxc.internal.e.i.b.class, "com.obric.aiagent.plugin");
        l r7 = (l) ZeusTransformUtils.wrapperContextForParams(r4, l.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r6, "credentialStore");
        o.e(r7, "oauthClient");
        o.e(r8, "nowMillis");
        this.f10850b = r6;
        this.f10851c = r7;
        this.f10852d = r8;
    }

    public static final /* synthetic */ Object a(c r2, com.bytedance.safetyguard.lxc.internal.e.i.c r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, com.bytedance.safetyguard.lxc.internal.e.i.c r3, String r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.h.b
    public Object a(com.bytedance.safetyguard.lxc.internal.e.d.c r10, d.c.d<? super String> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r12, d.class, "com.obric.aiagent.plugin");
        if ((r0.f10862e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10862e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f10860c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10862e;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        d.o.a(r13);
    L36:
        return r13;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r13);
    L45:
        return (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");
    L17:
        r10 = (com.bytedance.safetyguard.lxc.internal.e.d.c) ZeusTransformUtils.preCheckCast(r0.f10859b, com.bytedance.safetyguard.lxc.internal.e.d.c.class, "com.obric.aiagent.plugin");
        c this = (c) ZeusTransformUtils.preCheckCast(r0.f10858a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L21:
        com.bytedance.safetyguard.lxc.internal.e.i.c r14 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r13, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L25;
        return null;
    L25:
        if (o.a(r10.g(), r14.a()) == true) goto L28;
        return null;
    L28:
        if (r14.c().getSidecarAllowedHosts$safetyguard_runtime_release().contains(r10.c()) == true) goto L30;
        return null;
    L30:
        int r4 = C0245c.f10857a[r10.f().ordinal()];
        if (r4 == 1) goto L39;
        if (r4 != 2) goto L38;
        r0.f10858a = null;
        r0.f10859b = null;
        r0.f10862e = 3;
        r13 = this.a(r14, r0);
        if (r13 != r2) goto L36;
        return r2;
    L38:
        throw new k();
    L39:
        String r15 = r10.h();
        if (r15 == null) goto L46;
        r0.f10858a = null;
        r0.f10859b = null;
        r0.f10862e = 2;
        r13 = this.a(r14, r15, r0);
        if (r13 != r2) goto L45;
        return r2;
    L46:
        return null;
    L18:
        d.o.a(r13);
        com.bytedance.safetyguard.lxc.internal.e.i.b r16 = this.f10850b;
        r0.f10858a = this;
        r0.f10859b = r10;
        r0.f10862e = 1;
        r13 = r16.a(r0);
        if (r13 != r2) goto L21;
        return r2;
    L7:
        r0 = new d(this, r12);
        goto L8
    }

    private final Object a(com.bytedance.safetyguard.lxc.internal.e.i.c r21, String r22, d.c.d<? super String> r23) {
        c r0 = this;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, f.class) == false) goto L7;
        f r5 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin");
        if ((r5.f & Integer.MIN_VALUE) == 0) goto L7;
        r5.f -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f10871d;
        Object r6 = d.c.a.b.a();
        int r7 = r5.f;
        if (r7 == 0) goto L28;
        if (r7 == 1) goto L27;
        if (r7 == 2) goto L20;
        if (r7 != 3) goto L19;
        v r1 = (v) ZeusTransformUtils.preCheckCast(r5.f10868a, v.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: CancellationException -> L16 Throwable -> L59
    L55:
        String r2 = r1.c();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L58;
        return null;
    L58:
        return r2;
        goto L60
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        com.bytedance.safetyguard.lxc.internal.e.i.d r8 = (com.bytedance.safetyguard.lxc.internal.e.i.d) ZeusTransformUtils.preCheckCast(r5.f10870c, com.bytedance.safetyguard.lxc.internal.e.i.d.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.i.c r9 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r5.f10869b, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        c r10 = (c) ZeusTransformUtils.preCheckCast(r5.f10868a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: m -> L23 CancellationException -> L25 Throwable -> L62
    L50:
        v r11 = (v) ZeusTransformUtils.preCheckCast(r4, v.class, "com.obric.aiagent.plugin");     // Catch: m -> L23 CancellationException -> L25 Throwable -> L62
        com.bytedance.safetyguard.lxc.internal.e.i.b r12 = r10.f10850b;     // Catch: CancellationException -> L16 Throwable -> L59
        com.bytedance.safetyguard.lxc.internal.e.i.d r13 = r10.a(r11, r9.a(), r8);     // Catch: CancellationException -> L16 Throwable -> L59
        r5.f10868a = r11;     // Catch: CancellationException -> L16 Throwable -> L59
        r5.f10869b = null;     // Catch: CancellationException -> L16 Throwable -> L59
        r5.f10870c = null;     // Catch: CancellationException -> L16 Throwable -> L59
        r5.f = 3;     // Catch: CancellationException -> L16 Throwable -> L59
        if (r12.a(r13, r5) != r6) goto L54;
        return r6;
    L54:
        r1 = r11;
        goto L55
        goto L63
    L27:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r5.f10870c, String.class, "com.obric.aiagent.plugin");
        r9 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r5.f10869b, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        c r15 = (c) ZeusTransformUtils.preCheckCast(r5.f10868a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        String r16 = r14;
        r0 = r15;
    L32:
        com.bytedance.safetyguard.lxc.internal.e.i.d r17 = (com.bytedance.safetyguard.lxc.internal.e.i.d) ZeusTransformUtils.preCheckCast(r4, com.bytedance.safetyguard.lxc.internal.e.i.d.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L35;
        return null;
    L35:
        long r18 = ((Number) ZeusTransformUtils.preCheckCast(r0.f10852d.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17.d(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L42;
        if (r17.f() <= r18) goto L42;
        return r17.d();
    L42:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17.e(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L44;
    L67:
        return null;
    L44:
        if (r17.g() <= r18) goto L67;
        l r19 = r0.f10851c;     // Catch: m -> L23 CancellationException -> L25 Throwable -> L62
        u r20 = new u(r9.c(), r9.a(), r9.b(), r16, r17.e(), r17.h());     // Catch: m -> L23 CancellationException -> L25 Throwable -> L62
        r5.f10868a = r0;     // Catch: m -> L23 CancellationException -> L25 Throwable -> L62
        r5.f10869b = r9;     // Catch: m -> L23 CancellationException -> L25 Throwable -> L62
        r5.f10870c = r17;     // Catch: m -> L23 CancellationException -> L25 Throwable -> L62
        r5.f = 2;     // Catch: m -> L23 CancellationException -> L25 Throwable -> L62
        r4 = r19.a(r20, r5);     // Catch: m -> L23 CancellationException -> L25 Throwable -> L62
        if (r4 != r6) goto L49;
        return r6;
    L49:
        r10 = r0;
        r8 = r17;
        goto L50
    L28:
        d.o.a(r4);
        com.bytedance.safetyguard.lxc.internal.e.i.b r24 = r0.f10850b;
        String r25 = r21.a();
        r5.f10868a = r0;
        r5.f10869b = r21;
        r5.f10870c = r22;
        r5.f = 1;
        r4 = r24.a(r25, r22, r5);
        if (r4 != r6) goto L31;
        return r6;
    L31:
        r16 = r22;
        r9 = r21;
    L16:
        e = move-exception;
        throw e;
    L23:
        e = move-exception;
        throw new com.bytedance.safetyguard.lxc.internal.e.h.a("token_refresh_failed", com.bytedance.safetyguard.lxc.internal.e.h.d.a(e, "token refresh failed"), e.b(), e.c());
    L25:
        e = move-exception;
        throw e;
    L60:
        throw new com.bytedance.safetyguard.lxc.internal.e.h.a("token_refresh_failed", "token refresh failed", null, null, 12, null);
    L63:
        throw new com.bytedance.safetyguard.lxc.internal.e.h.a("token_refresh_failed", "token refresh failed", null, null, 12, null);
    L7:
        r5 = new f(r0, r3);
        goto L8
    }

    private final Object a(com.bytedance.safetyguard.lxc.internal.e.i.c r13, d.c.d<? super String> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r15, e.class, "com.obric.aiagent.plugin");
        if ((r0.f10867e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10867e -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f10865c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10867e;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        r13 = (com.bytedance.safetyguard.lxc.internal.e.i.c) ZeusTransformUtils.preCheckCast(r0.f10864b, com.bytedance.safetyguard.lxc.internal.e.i.c.class, "com.obric.aiagent.plugin");
        c this = (c) ZeusTransformUtils.preCheckCast(r0.f10863a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r16);     // Catch: m -> L14 CancellationException -> L16 Throwable -> L42
    L37:
        t r17 = (t) ZeusTransformUtils.preCheckCast(r16, t.class, "com.obric.aiagent.plugin");     // Catch: m -> L14 CancellationException -> L16 Throwable -> L42
        this.f10853e = this.a(r17, r13.a());
        String r12 = r17.a();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L41;
        return null;
    L41:
        return r12;
        goto L43
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        d.o.a(r16);
        long r6 = ((Number) ZeusTransformUtils.preCheckCast(this.f10852d.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        a r18 = this.f10853e;
        if (r18 != null) goto L23;
    L34:
        l r19 = this.f10851c;     // Catch: m -> L14 CancellationException -> L16 Throwable -> L42
        SidecarBrand r4 = r13.c();     // Catch: m -> L14 CancellationException -> L16 Throwable -> L42
        String r7 = r13.a();     // Catch: m -> L14 CancellationException -> L16 Throwable -> L42
        String r8 = r13.b();     // Catch: m -> L14 CancellationException -> L16 Throwable -> L42
        r0.f10863a = this;     // Catch: m -> L14 CancellationException -> L16 Throwable -> L42
        r0.f10864b = r13;     // Catch: m -> L14 CancellationException -> L16 Throwable -> L42
        r0.f10867e = 1;     // Catch: m -> L14 CancellationException -> L16 Throwable -> L42
        r16 = r19.a(r4, r7, r8, r0);     // Catch: m -> L14 CancellationException -> L16 Throwable -> L42
        if (r16 != r2) goto L37;
        return r2;
    L23:
        if (o.a(r18.a(), r13.a()) == true) goto L25;
    L27:
        boolean r5 = false;
    L28:
        if (r5 == true) goto L31;
        r18 = null;
    L31:
        if (r18 == null) goto L34;
        return r18.b();
    L25:
        if (r18.c() <= (r6 + 300000)) goto L27;
        r5 = true;
    L14:
        e = move-exception;
        throw new com.bytedance.safetyguard.lxc.internal.e.h.a("tenant_token_failed", com.bytedance.safetyguard.lxc.internal.e.h.d.a(e, "tenant token refresh failed"), e.b(), e.c());
    L16:
        e = move-exception;
        throw e;
    L43:
        throw new com.bytedance.safetyguard.lxc.internal.e.h.a("tenant_token_failed", "tenant token refresh failed", null, null, 12, null);
    L7:
        r0 = new e(this, r15);
        goto L8
    }

    private final com.bytedance.safetyguard.lxc.internal.e.i.d a(v r15, String r16, com.bytedance.safetyguard.lxc.internal.e.i.d r17) {
        boolean r0 = !d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15.d(), CharSequence.class, "com.obric.aiagent.plugin"));
        String r5 = r15.a();
        String r6 = r15.b();
        String r7 = r15.c();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r15.d(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r1) == false) goto L5;
        r1 = r17.e();
    L5:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
        long r9 = r15.e();
        if (r0 == false) goto L8;
        long r2 = r15.f();
    L10:
        return new com.bytedance.safetyguard.lxc.internal.e.i.d(r16, r5, r6, r7, r8, r9, r2, r15.g());
    L8:
        r2 = r17.g();
        goto L10
    }

    private final a a(t r4, String r5) {
        return new a(r5, r4.a(), r4.b());
    }
}
