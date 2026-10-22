package com.bytedance.safetyguard.lxc.internal.e.e;

import com.bytedance.keva.KevaImpl;
import com.bytedance.safetyguard.lxc.api.SidecarAuthResponse;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.o.k;
import java.io.IOException;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10775a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final k f10776e = null;
    private static final k f = null;
    private static final k g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.e.e.b f10778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.a.e f10779d;

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10780a = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.e.c.b.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.e.c.b.f10716a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f10780a = r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.e.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    @d.c.b.a.f(b = "LarkOpenApiForwarder.kt", c = {103}, d = "forward", e = "com.bytedance.safetyguard.lxc.internal.sidecar.forward.LarkOpenApiForwarder")
    static final class C0242c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f10784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f10785e;
        final /* synthetic */ c f;
        int g;

        C0242c(c r3, d.c.d<? super C0242c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10785e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    static final class d extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.a f10787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.d.c f10789d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.e.i f10790e;

        d(c r1, com.bytedance.safetyguard.lxc.internal.e.c.a r2, long r3, com.bytedance.safetyguard.lxc.internal.e.d.c r5, com.bytedance.safetyguard.lxc.internal.e.e.i r6) {
            this.f10786a = r1;
            this.f10787b = r2;
            this.f10788c = r3;
            this.f10789d = r5;
            this.f10790e = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            c r0 = this.f10786a;
            return c.a(r0, this.f10787b, "response_too_large", c.a(r0, this.f10788c), this.f10789d.i().length, Integer.valueOf(this.f10790e.d().length), Integer.valueOf(this.f10790e.a()), null, 64, null);
        }
    }

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    static final class e extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.a f10792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.d.c f10794d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.e.f f10795e;

        e(c r1, com.bytedance.safetyguard.lxc.internal.e.c.a r2, long r3, com.bytedance.safetyguard.lxc.internal.e.d.c r5, com.bytedance.safetyguard.lxc.internal.e.e.f r6) {
            this.f10791a = r1;
            this.f10792b = r2;
            this.f10793c = r3;
            this.f10794d = r5;
            this.f10795e = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            c r0 = this.f10791a;
            return c.a(r0, this.f10792b, "response_too_large", c.a(r0, this.f10793c), this.f10794d.i().length, null, null, this.f10795e.getClass().getName(), 32, null);
        }
    }

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    static final class f extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.a f10796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.c f10797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10798c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ IOException f10799d;

        f(com.bytedance.safetyguard.lxc.internal.e.c.a r1, com.bytedance.safetyguard.lxc.internal.e.c.c r2, c r3, IOException r4) {
            this.f10796a = r1;
            this.f10797b = r2;
            this.f10798c = r3;
            this.f10799d = r4;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return com.bytedance.safetyguard.lxc.internal.e.c.f.a(this.f10796a, this.f10797b) + c.a(this.f10798c, (Throwable) ZeusTransformUtils.preCheckCast(this.f10799d, Throwable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    static final class g extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.a f10801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.d.c f10803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Throwable f10804e;

        g(c r1, com.bytedance.safetyguard.lxc.internal.e.c.a r2, long r3, com.bytedance.safetyguard.lxc.internal.e.d.c r5, Throwable r6) {
            this.f10800a = r1;
            this.f10801b = r2;
            this.f10802c = r3;
            this.f10803d = r5;
            this.f10804e = r6;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            c r0 = this.f10800a;
            return c.a(r0, this.f10801b, "internal_error", c.a(r0, this.f10802c), this.f10803d.i().length, null, null, this.f10804e.getClass().getName(), 32, null);
        }
    }

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    static final class h extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.a f10806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f10807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.d.c f10808d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.e.i f10809e;
        final /* synthetic */ Throwable f;

        h(c r1, com.bytedance.safetyguard.lxc.internal.e.c.a r2, long r3, com.bytedance.safetyguard.lxc.internal.e.d.c r5, com.bytedance.safetyguard.lxc.internal.e.e.i r6, Throwable r7) {
            this.f10805a = r1;
            this.f10806b = r2;
            this.f10807c = r3;
            this.f10808d = r5;
            this.f10809e = r6;
            this.f = r7;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            c r0 = this.f10805a;
            return c.a(r0, this.f10806b, "diagnostic_error", c.a(r0, this.f10807c), this.f10808d.i().length, Integer.valueOf(this.f10809e.d().length), Integer.valueOf(this.f10809e.a()), this.f.getClass().getName());
        }
    }

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    static final class i extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.a f10810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.safetyguard.lxc.internal.e.c.c f10811b;

        i(com.bytedance.safetyguard.lxc.internal.e.c.a r1, com.bytedance.safetyguard.lxc.internal.e.c.c r2) {
            this.f10810a = r1;
            this.f10811b = r2;
            super(0);
        }

        public final String a() {
            return com.bytedance.safetyguard.lxc.internal.e.c.f.a(this.f10810a, this.f10811b);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    public c() {
        this(0, 0, 0, null, null, null, 63, null);
    }

    /* JADX INFO: renamed from: lambda$8C3e0ck0eiwXQ2V-M5yAS2gh9fQ, reason: not valid java name */
    public static /* synthetic */ List m44lambda$8C3e0ck0eiwXQ2VM5yAS2gh9fQ(String r0) {
        return d(r0);
    }

    public c(int r1, int r2, int r3, com.bytedance.safetyguard.lxc.internal.b.a r4, com.bytedance.safetyguard.lxc.internal.e.e.b r5, com.bytedance.safetyguard.lxc.internal.a.e r6) {
        com.bytedance.safetyguard.lxc.internal.b.a r7 = (com.bytedance.safetyguard.lxc.internal.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.safetyguard.lxc.internal.b.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.e.b r8 = (com.bytedance.safetyguard.lxc.internal.e.e.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.safetyguard.lxc.internal.e.e.b.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r9 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        o.e(r7, "dnsResolver");
        o.e(r8, "transport");
        o.e(r9, "logger");
        this.f10777b = r1;
        this.f10778c = r8;
        this.f10779d = r9;
    }

    public static final /* synthetic */ long a(c r0, long r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ String a(c r0, com.bytedance.safetyguard.lxc.internal.e.c.a r1, String r2, long r3, int r5, Integer r6, Integer r7, String r8) {
        return r0.a(r1, r2, r3, r5, r6, r7, r8);
    }

    public static final /* synthetic */ String a(c r0, Throwable r1) {
        return r0.a(r1);
    }

    public /* synthetic */ c(int r9, int r10, int r11, com.bytedance.safetyguard.lxc.internal.b.a r12, com.bytedance.safetyguard.lxc.internal.e.e.b r13, com.bytedance.safetyguard.lxc.internal.a.e r14, int r15, d.h.b.h r16) {
        com.bytedance.safetyguard.lxc.internal.b.a r0 = (com.bytedance.safetyguard.lxc.internal.b.a) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.safetyguard.lxc.internal.b.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.e.b r2 = (com.bytedance.safetyguard.lxc.internal.e.e.b) ZeusTransformUtils.wrapperContextForParams(r13, com.bytedance.safetyguard.lxc.internal.e.e.b.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.a.e r3 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.wrapperContextForParams(r14, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
        if ((r15 & 1) == 0) goto L5;
        int r4 = 33554432;
    L7:
        if ((r15 & 2) == 0) goto L9;
        int r5 = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
    L11:
        if ((r15 & 4) == 0) goto L13;
        int r6 = 30000;
    L15:
        if ((r15 & 8) == 0) goto L18;
        r0 = $$Lambda$c$8C3e0ck0eiwXQ2VM5yAS2gh9fQ.INSTANCE;
    L18:
        if ((r15 & 16) == 0) goto L21;
        r2 = (com.bytedance.safetyguard.lxc.internal.e.e.b) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.e.e(r4, r5, r6, r0), com.bytedance.safetyguard.lxc.internal.e.e.b.class, "com.obric.aiagent.plugin");
    L21:
        if ((r15 & 32) == 0) goto L23;
        r3 = (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.a.d.f9723a, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin");
    L23:
        this(r4, r5, r6, r0, r2, r3);
        return;
    L13:
        r6 = r11;
        goto L15
    L9:
        r5 = r10;
        goto L11
    L5:
        r4 = r9;
        goto L7
    }

    private static final List d(String r1) {
        o.e(r1, "it");
        throw new UnknownHostException("DNS resolution is restricted to SafetyGuardProxyService");
    }

    public final Object a(com.bytedance.safetyguard.lxc.internal.e.d.c r33, String r34, d.c.d<? super SidecarAuthResponse> r35) {
        c r1 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, C0242c.class) == false) goto L7;
        C0242c r3 = (C0242c) ZeusTransformUtils.preCheckCast(r0, C0242c.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f10785e;
        Object r4 = d.c.a.b.a();
        int r5 = r3.g;
        if (r5 == 0) goto L22;
        if (r5 != 1) goto L21;
        long r6 = r3.f10784d;
        com.bytedance.safetyguard.lxc.internal.e.c.a r7 = (com.bytedance.safetyguard.lxc.internal.e.c.a) ZeusTransformUtils.preCheckCast(r3.f10783c, com.bytedance.safetyguard.lxc.internal.e.c.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.e.d.c r8 = (com.bytedance.safetyguard.lxc.internal.e.d.c) ZeusTransformUtils.preCheckCast(r3.f10782b, com.bytedance.safetyguard.lxc.internal.e.d.c.class, "com.obric.aiagent.plugin");
        c r9 = (c) ZeusTransformUtils.preCheckCast(r3.f10781a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L14 IOException -> L16 com.bytedance.safetyguard.lxc.internal.e.e.f -> L18 CancellationException -> L59
        long r10 = r6;
        com.bytedance.safetyguard.lxc.internal.e.c.a r11 = r7;
        r1 = r9;
    L62:
        com.bytedance.safetyguard.lxc.internal.e.e.i r15 = (com.bytedance.safetyguard.lxc.internal.e.e.i) ZeusTransformUtils.preCheckCast(r2, com.bytedance.safetyguard.lxc.internal.e.e.i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35 IOException -> L37 com.bytedance.safetyguard.lxc.internal.e.e.f -> L39 CancellationException -> L59
        if (r15.d().length <= r1.f10777b) goto L33;
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(r1.f10779d, "LarkOpenApiForwarder", null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r1, r11, r10, r8, r15), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);     // Catch: Throwable -> L35 IOException -> L37 com.bytedance.safetyguard.lxc.internal.e.e.f -> L39 CancellationException -> L59
        return com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.e();
    L33:
        r1.a(r11, r8, r15, r10);     // Catch: Throwable -> L35 IOException -> L37 com.bytedance.safetyguard.lxc.internal.e.e.f -> L39 CancellationException -> L59
        return new SidecarAuthResponse(r15.a(), r15.b(), com.bytedance.safetyguard.lxc.internal.e.e.a.f10773a.a(r15.c()), r15.d());
    L39:
        e = move-exception;
        com.bytedance.safetyguard.lxc.internal.e.e.f r12 = e;
        c r13 = r1;
        com.bytedance.safetyguard.lxc.internal.e.d.c r14 = r8;
        long r16 = r10;
    L57:
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(r13.f10779d, "LarkOpenApiForwarder", null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(r13, r11, r16, r14, r12), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);
        return com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.e();
    L37:
        e = e;
        com.bytedance.safetyguard.lxc.internal.e.d.c r17 = r8;
    L53:
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(r1.f10779d, "LarkOpenApiForwarder", null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(r11, new com.bytedance.safetyguard.lxc.internal.e.c.c(com.bytedance.safetyguard.lxc.internal.e.c.b.f10720e, null, r17.i().length, 0, r1.a(r10), null, null, null, null, new com.bytedance.safetyguard.lxc.internal.e.c.g(null, null, "network_error", null, null, null)), r1, e), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);
        return com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.f();
    L35:
        th = move-exception;
        Throwable r18 = th;
        c r19 = r1;
        com.bytedance.safetyguard.lxc.internal.e.c.a r110 = r11;
        com.bytedance.safetyguard.lxc.internal.e.d.c r111 = r8;
        long r112 = r10;
    L50:
        com.bytedance.safetyguard.lxc.internal.a.c.a(r18);
        com.bytedance.safetyguard.lxc.internal.a.e.a.b(r19.f10779d, "LarkOpenApiForwarder", null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(r19, r110, r112, r111, r18), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);
        return com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.g();
    L18:
        e = move-exception;
        r12 = e;
        r14 = r8;
        r16 = r6;
        r11 = r7;
        r13 = r9;
    L16:
        e = e;
        r10 = r6;
        r17 = r8;
        r11 = r7;
        r1 = r9;
    L14:
        th = move-exception;
        r18 = th;
        r110 = r7;
        r19 = r9;
        r112 = r6;
        r111 = r8;
        goto L50
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        d.o.a(r2);
        r10 = System.nanoTime();
        r11 = new com.bytedance.safetyguard.lxc.internal.e.c.a("forwarder", "open-api-forward", r33.a(), r33.c(), com.bytedance.safetyguard.lxc.internal.e.c.f.a(r33.b()), r1.c(r33.c()), r1.f10779d.a(r33.g()), null, r1.f10779d.a(r33.e()), r1.f10779d.a(d.o.o.a(d.o.o.a(r33.b(), '?', null, 2, null), '#', null, 2, null)), null, false, 3200, null);
        String r25 = r33.a();     // Catch: Throwable -> L47 IOException -> L51 com.bytedance.safetyguard.lxc.internal.e.e.f -> L54 CancellationException -> L59
        String r26 = "https://" + r33.c() + r33.b();     // Catch: Throwable -> L47 IOException -> L51 com.bytedance.safetyguard.lxc.internal.e.e.f -> L54 CancellationException -> L59
        Map<String, String> r27 = com.bytedance.safetyguard.lxc.internal.e.e.a.f10773a.a(r33.j(), r33.d(), r34);     // Catch: Throwable -> L47 IOException -> L51 com.bytedance.safetyguard.lxc.internal.e.e.f -> L54 CancellationException -> L59
        byte[] r28 = r33.i();     // Catch: Throwable -> L47 IOException -> L51 com.bytedance.safetyguard.lxc.internal.e.e.f -> L54 CancellationException -> L59
        Proxy r20 = Proxy.NO_PROXY;     // Catch: Throwable -> L47 IOException -> L51 com.bytedance.safetyguard.lxc.internal.e.e.f -> L54 CancellationException -> L59
        o.c(r20, "NO_PROXY");     // Catch: Throwable -> L47 IOException -> L51 com.bytedance.safetyguard.lxc.internal.e.e.f -> L54 CancellationException -> L59
        com.bytedance.safetyguard.lxc.internal.e.e.h r21 = new com.bytedance.safetyguard.lxc.internal.e.e.h(r25, r26, r27, r28, r20);     // Catch: Throwable -> L47 IOException -> L51 com.bytedance.safetyguard.lxc.internal.e.e.f -> L54 CancellationException -> L59
        com.bytedance.safetyguard.lxc.internal.e.e.b r22 = r1.f10778c;     // Catch: Throwable -> L47 IOException -> L51 com.bytedance.safetyguard.lxc.internal.e.e.f -> L54 CancellationException -> L59
        r3.f10781a = r1;     // Catch: Throwable -> L47 IOException -> L51 com.bytedance.safetyguard.lxc.internal.e.e.f -> L54 CancellationException -> L59
        r17 = r33;
        r3.f10782b = r17;     // Catch: Throwable -> L41 IOException -> L43 com.bytedance.safetyguard.lxc.internal.e.e.f -> L45 CancellationException -> L59
        r3.f10783c = r11;     // Catch: Throwable -> L41 IOException -> L43 com.bytedance.safetyguard.lxc.internal.e.e.f -> L45 CancellationException -> L59
        r3.f10784d = r10;     // Catch: Throwable -> L41 IOException -> L43 com.bytedance.safetyguard.lxc.internal.e.e.f -> L45 CancellationException -> L59
        r3.g = 1;     // Catch: Throwable -> L41 IOException -> L43 com.bytedance.safetyguard.lxc.internal.e.e.f -> L45 CancellationException -> L59
        r2 = r22.a(r21, r3);     // Catch: Throwable -> L41 IOException -> L43 com.bytedance.safetyguard.lxc.internal.e.e.f -> L45 CancellationException -> L59
        if (r2 != r4) goto L28;
        return r4;
    L28:
        r8 = r17;
        goto L62
    L45:
        e = e;
    L56:
        r12 = e;
        r13 = r1;
        r16 = r10;
        r14 = r17;
    L43:
        e = e;
    L41:
        th = th;
    L49:
        r18 = th;
        r19 = r1;
        r110 = r11;
        r112 = r10;
        r111 = r17;
        goto L50
    L54:
        e = e;
        r17 = r33;
    L51:
        e = e;
        r17 = r33;
    L47:
        th = th;
        r17 = r33;
    L59:
        e = move-exception;
        throw e;
    L7:
        r3 = new C0242c(r1, r0);
        goto L8
    }

    private final void a(com.bytedance.safetyguard.lxc.internal.e.c.a r47, com.bytedance.safetyguard.lxc.internal.e.d.c r48, com.bytedance.safetyguard.lxc.internal.e.e.i r49, long r50) {
        int r10 = r49.a();     // Catch: Throwable -> L39 CancellationException -> L43
        Map<String, String> r0 = r49.c();     // Catch: Throwable -> L39 CancellationException -> L43
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r0.size())), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39 CancellationException -> L43
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L39 CancellationException -> L43
    L5:
        if (r1.hasNext() == false) goto L7;
        Object r2 = r1.next();     // Catch: Throwable -> L39 CancellationException -> L43
        r11.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), d.a.p.a((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L39 CancellationException -> L43
        goto L5
    L7:
        com.bytedance.safetyguard.lxc.internal.e.c.c r18 = com.bytedance.safetyguard.lxc.internal.e.c.f.a(r10, r11, r49.d(), r48.i().length, a(r50), a(r49), ax.b());     // Catch: Throwable -> L35 CancellationException -> L43
        com.bytedance.safetyguard.lxc.internal.e.c.g r29 = r18.j();     // Catch: Throwable -> L35 CancellationException -> L43
        if (r29 == null) goto L14;
        com.bytedance.safetyguard.lxc.internal.e.c.g r3 = com.bytedance.safetyguard.lxc.internal.e.c.g.a(r29, null, null, null, null, null, null, 55, null);     // Catch: Throwable -> L35 CancellationException -> L43
    L15:
        com.bytedance.safetyguard.lxc.internal.e.c.c r32 = com.bytedance.safetyguard.lxc.internal.e.c.c.a(r18, null, null, 0, 0, 0, null, null, null, null, r3, 511, null);     // Catch: Throwable -> L35 CancellationException -> L43
        if (r32.a() != com.bytedance.safetyguard.lxc.internal.e.c.b.f10717b) goto L26;
        int r4 = r49.a();     // Catch: Throwable -> L35 CancellationException -> L43
        boolean r6 = false;
        if (200 <= r4) goto L20;
    L22:
        if (r6 == false) goto L24;
        com.bytedance.safetyguard.lxc.internal.e.c.b r5 = com.bytedance.safetyguard.lxc.internal.e.c.b.f10719d;     // Catch: Throwable -> L35 CancellationException -> L43
    L25:
        r32 = com.bytedance.safetyguard.lxc.internal.e.c.c.a(r32, r5, null, 0, 0, 0, null, null, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);     // Catch: Throwable -> L35 CancellationException -> L43
        goto L26
    L24:
        r5 = com.bytedance.safetyguard.lxc.internal.e.c.b.f10718c;     // Catch: Throwable -> L35 CancellationException -> L43
        goto L25
    L20:
        if (r4 >= 300) goto L22;
        r6 = true;
    L26:
        com.bytedance.safetyguard.lxc.internal.e.c.c r7 = r32;
        d.h.a.a<String> r13 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new i(r47, r7), d.h.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33 CancellationException -> L43
        if (b.f10780a[r7.a().ordinal()] != 1) goto L31;
        this.f10779d.a("LarkOpenApiForwarder", r13);     // Catch: Throwable -> L33 CancellationException -> L43
    L47:
        return;
    L31:
        com.bytedance.safetyguard.lxc.internal.a.e.a.a(this.f10779d, "LarkOpenApiForwarder", null, r13, 2, null);     // Catch: Throwable -> L33 CancellationException -> L43
    L33:
        th = th;
    L41:
        Throwable r8 = th;
        com.bytedance.safetyguard.lxc.internal.a.c.a(r8);
        com.bytedance.safetyguard.lxc.internal.a.e.a.b(this.f10779d, "LarkOpenApiForwarder", null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(this, r47, r50, r48, r49, r8), d.h.a.a.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    L14:
        r3 = null;
    L35:
        th = th;
    L37:
        th = th;
    L39:
        th = th;
    L43:
        e = move-exception;
        throw e;
    }

    private final boolean a(com.bytedance.safetyguard.lxc.internal.e.e.i r7) {
        if (r7.d().length <= 65536) goto L5;
        return false;
    L5:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.c().entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Object r8 = r6.next();
        if (d.o.o.a((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r8, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"), DownloadHelper.CONTENT_TYPE, true) == false) goto L7;
    L12:
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8, Map.Entry.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L31;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getValue(), String.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L32;
        String r11 = d.o.o.a(r10, ';', null, 2, null);
        if (r11 == null) goto L33;
        String r12 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r12 == null) goto L34;
        String r13 = r12.toLowerCase(Locale.ROOT);
        o.c(r13, "toLowerCase(...)");
        if (r13 != null) goto L23;
        return false;
    L23:
        if (o.a(r13, "application/json") == true) goto L27;
        if (d.o.o.c(r13, "+json", false, 2, null) == true) goto L27;
        return false;
    L27:
        return true;
    L34:
        return false;
    L33:
        return false;
    L32:
        return false;
    L31:
        return false;
    L11:
        r8 = null;
        goto L12
    }

    static /* synthetic */ String a(c r11, com.bytedance.safetyguard.lxc.internal.e.c.a r12, String r13, long r14, int r16, Integer r17, Integer r18, String r19, int r20, Object r21) {
        if ((r20 & 32) == 0) goto L5;
        Integer r9 = null;
    L7:
        if ((r20 & 64) == 0) goto L9;
        String r10 = null;
    L11:
        return r11.a(r12, r13, r14, r16, r17, r9, r10);
    L9:
        r10 = r19;
        goto L11
    L5:
        r9 = r18;
        goto L7
    }

    private final String a(com.bytedance.safetyguard.lxc.internal.e.c.a r4, String r5, long r6, int r8, Integer r9, Integer r10, String r11) {
        StringBuilder r0 = new StringBuilder();
        r0.append("component=forwarder event=http_request_finished outcome=" + r5);
        r0.append(" operation=" + r4.b());
        r0.append(" method=" + a(r4.c()));
        r0.append(" host=" + b(r4.d()));
        String r3 = r4.e();
        if (r3 == null) goto L5;
        r0.append(" path=" + r3);
    L5:
        String r7 = r4.f();
        if (r7 == null) goto L8;
        r0.append(" brand=" + r7);
    L8:
        String r12 = r4.g();
        if (r12 == null) goto L11;
        r0.append(" appRef=" + r12);
    L11:
        String r13 = r4.i();
        if (r13 == null) goto L14;
        r0.append(" sessionRef=" + r13);
    L14:
        String r14 = r4.j();
        if (r14 == null) goto L18;
        r0.append(" pathRef=" + r14);
    L18:
        if (r10 == null) goto L20;
        r0.append(" httpStatus=" + ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue());
    L20:
        r0.append(" durationMs=" + r6);
        r0.append(" requestBytes=" + n.c(r8, 0));
        if (r9 == null) goto L23;
        r0.append(" responseBytes=" + n.c(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue(), 0));
    L23:
        if (r11 != null) goto L25;
    L30:
        String r15 = r0.toString();
        o.c(r15, "toString(...)");
        return r15;
    L25:
        if (g.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L28;
        r11 = null;
    L28:
        if (r11 == null) goto L30;
        r0.append(" exceptionClass=" + r11);
        goto L30
    }

    private final String a(Throwable r3) {
        String r2 = r3.getClass().getName();
        String r0 = null;
        if (g.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L6;
        r2 = null;
    L6:
        if (r2 == null) goto L8;
        r0 = " exceptionClass=" + r2;
    L8:
        if (r0 != null) goto L11;
        return "";
    L11:
        return r0;
    }

    private final String a(String r3) {
        if (f10776e.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L9;
        return "UNKNOWN";
    L9:
        return r3;
    }

    private final String b(String r3) {
        if (f.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L9;
        return SensitiveType.UNKNOWN;
    L9:
        return r3;
    }

    private final String c(String r2) {
        if (d.o.o.c(r2, ".feishu.cn", true) == false) goto L6;
        return "FEISHU";
    L6:
        if (d.o.o.c(r2, ".larksuite.com", true) == false) goto L8;
        return "LARKSUITE";
    L8:
        return null;
    }

    private final long a(long r3) {
        return n.a((System.nanoTime() - r3) / 1000000, 0);
    }

    static {
        f10775a = new a(null);
        f10776e = new k("[A-Z]{1,16}");
        f = new k("[A-Za-z0-9.-]{1,253}");
        g = new k("[A-Za-z0-9_.$]+");
    }
}
