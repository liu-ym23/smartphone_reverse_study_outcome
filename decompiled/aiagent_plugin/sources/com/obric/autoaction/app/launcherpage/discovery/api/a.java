package com.obric.autoaction.app.launcherpage.discovery.api;

import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.e.i;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.autoaction.app.launcherpage.discovery.a.e;
import com.obric.autoaction.app.launcherpage.discovery.a.k;
import com.obric.autoaction.app.launcherpage.discovery.a.p;
import com.obric.autogui.common.api.app.HostAppInfo;
import com.obric.autogui.common.api.app.foundation.IAutoActionFoundationApi;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.l;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.s;
import d.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: DiscoveryRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0525a f23638a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f23639d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ArrayList<com.bytedance.retrofit2.b.b> f23640e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f23641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f23642c;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.discovery.api.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiscoveryRepository.kt */
    public static final class C0525a {
        public /* synthetic */ C0525a(h r1) {
            this();
        }

        private C0525a() {
        }
    }

    /* JADX INFO: compiled from: DiscoveryRepository.kt */
    @d.c.b.a.f(b = "DiscoveryRepository.kt", c = {51}, d = "fetchServerData", e = "com.obric.autoaction.app.launcherpage.discovery.api.DiscoveryRepository")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f23643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f23644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f23645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f23646d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f23647e;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23646d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23645c = r3;
            this.f23647e |= Integer.MIN_VALUE;
            return a.a(this.f23646d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DiscoveryRepository.kt */
    @d.c.b.a.f(b = "DiscoveryRepository.kt", c = {102}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.discovery.api.DiscoveryRepository$getInstructionGroups$2")
    static final class c extends l implements m<am, d.c.d<? super d.m<? extends Boolean, ? extends List<? extends com.obric.autoaction.app.launcherpage.discovery.a.b>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f23649b;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.discovery.api.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DiscoveryRepository.kt */
        public /* synthetic */ class C0526a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f23650a = null;

            static {
                int[] r0 = new int[p.values().length];
                r0[p.f23634b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[p.f23635c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f23650a = r0;
            }
        }

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23649b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.m<Boolean, ? extends List<? extends com.obric.autoaction.app.launcherpage.discovery.a.b>>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23649b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.m<? extends Boolean, ? extends List<? extends com.obric.autoaction.app.launcherpage.discovery.a.b>>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            String r0 = "";
            Object r1 = d.c.a.b.a();
            int r2 = this.f23648a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            o.a(r13);
        L11:
            d.m r14 = (d.m) ZeusTransformUtils.preCheckCast(r13, d.m.class, "com.obric.aiagent.plugin");
            boolean r3 = ((Boolean) ZeusTransformUtils.preCheckCast(r14.c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            String r15 = (String) ZeusTransformUtils.preCheckCast(r14.d(), String.class, "com.obric.aiagent.plugin");
            if (r3 == false) goto L14;
            com.obric.autoaction.app.launcherpage.discovery.a.l r12 = (com.obric.autoaction.app.launcherpage.discovery.a.l) ZeusTransformUtils.preCheckCast(a.a(this.f23649b).fromJson(r15, com.obric.autoaction.app.launcherpage.discovery.a.l.class), com.obric.autoaction.app.launcherpage.discovery.a.l.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L51
            if (r12 == null) goto L19;
            List<k> r16 = r12.a();
            if (r16 == null) goto L19;
        L20:
            Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
            Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r19 = r17.iterator();
        L22:
            if (r19.hasNext() == false) goto L50;
            k r4 = (k) ZeusTransformUtils.preCheckCast(r19.next(), k.class, "com.obric.aiagent.plugin");
            String r5 = r4.a();
            if (r5 == null) goto L26;
            com.obric.autoaction.app.launcherpage.discovery.a.b.d r7 = new com.obric.autoaction.app.launcherpage.discovery.a.b.d(r5);
        L27:
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(d.a.p.b(r7), Collection.class, "com.obric.aiagent.plugin");
            List<e> r8 = r4.b();
            if (r8 != null) goto L30;
            r8 = d.a.p.b();
        L30:
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r11 = r9.iterator();
        L32:
            if (r11.hasNext() == false) goto L48;
            e r20 = (e) ZeusTransformUtils.preCheckCast(r11.next(), e.class, "com.obric.aiagent.plugin");
            p r21 = p.f23633a.a(r20.b());
            com.obric.autoaction.app.launcherpage.discovery.util.b r110 = com.obric.autoaction.app.launcherpage.discovery.util.b.f23658a;
            String r111 = r20.c();
            if (r111 != null) goto L36;
            r111 = "";
        L36:
            com.obric.autoaction.app.launcherpage.discovery.util.c r112 = r110.a(r111);
            if (r21 != null) goto L39;
            int r22 = -1;
        L40:
            if (r22 != 1) goto L42;
            com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b r23 = (com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.discovery.a.b.c(false, r20, r112), com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b.class, "com.obric.aiagent.plugin");
        L46:
            if (r23 == null) goto L32;
            r10.add(r23);
            goto L32
        L42:
            if (r22 == 2) goto L44;
            r23 = null;
            goto L46
        L44:
            r23 = (com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.discovery.a.b.a(false, r20, r112), com.obric.autoaction.app.launcherpage.discovery.a.b.AbstractC0524b.class, "com.obric.aiagent.plugin");
            goto L46
        L39:
            r22 = C0526a.f23650a[r21.ordinal()];
            goto L40
        L48:
            d.a.p.a(r18, (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.c(r6, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"));
            goto L22
        L26:
            r7 = null;
            goto L27
        L50:
            return s.a(d.c.b.a.b.a(true), (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin"));
        L19:
            r16 = d.a.p.b();
        L51:
            e = move-exception;
            Loog.INSTANCE.e("DiscoveryRepository", "parse instruction groups error, " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            com.obric.event.task.base.report.h r24 = com.obric.event.task.base.report.h.f32778a;
            if (r15 == null) goto L56;
            r0 = r15;
        L56:
            r24.a(r0, e);
            return s.a(d.c.b.a.b.a(false), d.a.p.b());
        L14:
            return s.a(d.c.b.a.b.a(false), d.a.p.b());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r13);
            a r113 = this.f23649b;
            d.c.d r25 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23648a = 1;
            r13 = a.a(r113, r25);
            if (r13 != r1) goto L11;
            return r1;
        }
    }

    private static final String e() {
        return "fetchInstructionGroups request success";
    }

    private static final String f() {
        return "fetchInstructionGroups request failed";
    }

    private static final String g() {
        return "fetchInstructionGroups request error";
    }

    public static /* synthetic */ String lambda$DJM2vO_2GaqfMwfwJL9QCO_bqLI() {
        return f();
    }

    public static /* synthetic */ DiscoveryApi lambda$HVAqE6oY0gapV0RalJ3lUHERGLg() {
        return c();
    }

    public static /* synthetic */ Gson lambda$chmW3dmLCN25qXHpu_uMCYmBcaU() {
        return d();
    }

    public static /* synthetic */ String lambda$h2ctq9alCshf9p0VDEf6vWLCIP4() {
        return e();
    }

    public static /* synthetic */ String lambda$niziIt2m9FUQU9zK9GWi5jdX8us(com.obric.autoaction.app.launcherpage.discovery.a.c r0) {
        return b(r0);
    }

    public static /* synthetic */ String lambda$njoX9akcx8eOHP9saRrDbwVumvs(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$v3YEQ5qfKTCZ4ov_9GMpso3R2Sg(com.obric.autoaction.app.launcherpage.discovery.a.c r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$wcXInqiptCoEHHk-QJbxXAU1n9A, reason: not valid java name */
    public static /* synthetic */ String m495lambda$wcXInqiptCoEHHkQJbxXAU1n9A() {
        return g();
    }

    public a() {
        this.f23641b = g.a($$Lambda$a$HVAqE6oY0gapV0RalJ3lUHERGLg.INSTANCE);
        this.f23642c = g.a($$Lambda$a$chmW3dmLCN25qXHpu_uMCYmBcaU.INSTANCE);
    }

    public static final /* synthetic */ Gson a(a r0) {
        return r0.b();
    }

    public static final /* synthetic */ Object a(a r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f23638a = new C0525a(null);
        f23639d = com.obric.aiagent.product.a.a.f18769a.c();
        ArrayList<com.bytedance.retrofit2.b.b> r0 = new ArrayList();
        r0.add(new com.bytedance.retrofit2.b.b(DownloadHelper.CONTENT_TYPE, "application/json"));
        f23640e = r0;
    }

    private final DiscoveryApi a() {
        Object r2 = this.f23641b.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (DiscoveryApi) ZeusTransformUtils.preCheckCast(r2, DiscoveryApi.class, "com.obric.aiagent.plugin");
    }

    private static final DiscoveryApi c() {
        return (DiscoveryApi) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.b(f23639d).a(DiscoveryApi.class), DiscoveryApi.class, "com.obric.aiagent.plugin");
    }

    private final Gson b() {
        return (Gson) ZeusTransformUtils.preCheckCast(this.f23642c.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson d() {
        return new GsonBuilder().create();
    }

    private final Object b(d.c.d<? super d.m<Boolean, String>> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.aiagent.plugin");
        if ((r0.f23647e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f23647e -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f23645c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f23647e;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        int r13 = r0.f23644b;
        long r4 = r0.f23643a;
        o.a(r16);     // Catch: Exception -> L14
    L28:
        final com.obric.autoaction.app.launcherpage.discovery.a.c r17 = (com.obric.autoaction.app.launcherpage.discovery.a.c) ZeusTransformUtils.preCheckCast(r16, com.obric.autoaction.app.launcherpage.discovery.a.c.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        if (r17 == null) goto L36;
        Integer r1 = r17.a();     // Catch: Exception -> L14
        if (r1 == null) goto L36;
        if (r1.intValue() != 0) goto L36;
        boolean r5 = true;
    L37:
        if (r5 == false) goto L45;
        Loog.INSTANCE.ip("DiscoveryRepository", new $$Lambda$a$v3YEQ5qfKTCZ4ov_9GMpso3R2Sg(r17), $$Lambda$a$h2ctq9alCshf9p0VDEf6vWLCIP4.INSTANCE);     // Catch: Exception -> L14
        Boolean r6 = d.c.b.a.b.a(true);     // Catch: Exception -> L14
        if (r17 == null) goto L43;
        com.obric.autoaction.app.launcherpage.discovery.a.d r18 = r17.c();     // Catch: Exception -> L14
        if (r18 == null) goto L43;
        String r19 = r18.a();     // Catch: Exception -> L14
    L44:
        d.m r110 = s.a(r6, r19);     // Catch: Exception -> L14
    L64:
        long r7 = r4;
    L94:
        long r8 = System.currentTimeMillis();
        com.obric.event.task.base.report.h r9 = com.obric.event.task.base.report.h.f32778a;
        if (r13 == 0) goto L97;
        boolean r10 = true;
    L98:
        r9.a(r7, r8, r10);
        return r110;
    L97:
        r10 = false;
    L43:
        r19 = null;
        goto L44
    L45:
        Loog.INSTANCE.ep("DiscoveryRepository", new $$Lambda$a$niziIt2m9FUQU9zK9GWi5jdX8us(r17), $$Lambda$a$DJM2vO_2GaqfMwfwJL9QCO_bqLI.INSTANCE);     // Catch: Exception -> L14
        com.obric.event.task.base.report.h r111 = com.obric.event.task.base.report.h.f32778a;     // Catch: Exception -> L14
        if (r17 == null) goto L51;
        Integer r11 = r17.a();     // Catch: Exception -> L14
        if (r11 == null) goto L51;
        int r12 = r11.intValue();     // Catch: Exception -> L14
    L52:
        String r20 = "";
        if (r17 == null) goto L56;
        String r112 = r17.b();     // Catch: Exception -> L14
        if (r112 == null) goto L56;
    L57:
        if (r17 == null) goto L62;
        String r113 = r17.d();     // Catch: Exception -> L14
        if (r113 == null) goto L62;
        r20 = r113;
    L62:
        r111.a(r12, r112, r20);     // Catch: Exception -> L14
        r110 = s.a(d.c.b.a.b.a(false), null);     // Catch: Exception -> L14
        r13 = 1;
    L56:
        r112 = "";
    L51:
        r12 = -1;
    L36:
        r5 = false;
    L14:
        e = e;
    L67:
        Loog.INSTANCE.ep("DiscoveryRepository", new $$Lambda$a$njoX9akcx8eOHP9saRrDbwVumvs(e), $$Lambda$a$wcXInqiptCoEHHkQJbxXAU1n9A.INSTANCE);
        if (ZeusTransformUtils.instanceOf(e, com.bytedance.retrofit2.o.class) == false) goto L86;
        Integer r114 = d.c.b.a.b.a(((com.bytedance.retrofit2.o) ZeusTransformUtils.preCheckCast(e, com.bytedance.retrofit2.o.class, "com.obric.aiagent.plugin")).a());
        ak<?> r21 = ((com.bytedance.retrofit2.o) ZeusTransformUtils.preCheckCast(e, com.bytedance.retrofit2.o.class, "com.obric.aiagent.plugin")).b();
        if (r21 == null) goto L83;
        i r22 = r21.g();
        if (r22 == null) goto L83;
        String r23 = r22.toString();
        if (r23 == null) goto L83;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L78;
        boolean r24 = true;
    L79:
        if (r24 == true) goto L82;
        r23 = null;
    L82:
        if (r23 == null) goto L83;
    L84:
        d.m r115 = new d.m(r114, r23);
    L93:
        com.obric.event.task.base.report.h.f32778a.a(((Number) ZeusTransformUtils.preCheckCast(r115.c(), Number.class, "com.obric.aiagent.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r115.d(), String.class, "com.obric.aiagent.plugin"));
        r110 = s.a(d.c.b.a.b.a(false), null);
        r7 = r4;
        r13 = 1;
        goto L94
    L78:
        r24 = false;
    L83:
        r23 = e.getMessage();
        goto L84
    L86:
        if (ZeusTransformUtils.instanceOf(e, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L90;
        d.m r116 = new d.m(d.c.b.a.b.a(((com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(e, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin")).c()), "network_error: " + e.getMessage());
    L88:
        r115 = r116;
        goto L93
    L90:
        if (ZeusTransformUtils.instanceOf(e, IOException.class) == false) goto L92;
        r116 = new d.m(d.c.b.a.b.a(1000), "network_error: " + e.getMessage());
        goto L88
    L92:
        r116 = new d.m(d.c.b.a.b.a(-1), e.getMessage());
        goto L88
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        o.a(r16);
        com.obric.event.task.base.report.h.f32778a.a();
        long r25 = System.currentTimeMillis();
        ArrayList<com.bytedance.retrofit2.b.b> r117 = com.obric.autogui.net.ttnet.c.f29240a.a(f23640e);     // Catch: Exception -> L65
        IAutoActionFoundationApi r26 = (IAutoActionFoundationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionFoundationApi.class), IAutoActionFoundationApi.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L65
        if (r26 == null) goto L24;
        HostAppInfo r27 = r26.getHostAppInfo();     // Catch: Exception -> L65
        if (r27 == null) goto L24;
        d.c.b.a.b.a(r117.add(new com.bytedance.retrofit2.b.b("oauto-version-code", String.valueOf(r27.getVersionCode()))));     // Catch: Exception -> L65
    L24:
        DiscoveryApi r118 = a();     // Catch: Exception -> L65
        List<com.bytedance.retrofit2.b.b> r119 = (List) ZeusTransformUtils.preCheckCast(r117, List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L65
        r0.f23643a = r25;     // Catch: Exception -> L65
        r0.f23644b = 0;     // Catch: Exception -> L65
        r0.f23647e = 1;     // Catch: Exception -> L65
        r16 = r118.getDiscoveryData(r119, "2", r0);     // Catch: Exception -> L65
        if (r16 != r2) goto L27;
        return r2;
    L27:
        r13 = 0;
        r4 = r25;
    L65:
        e = e;
        r4 = r25;
    L7:
        r0 = new b(this, r15);
        goto L8
    }

    private static final String a(com.obric.autoaction.app.launcherpage.discovery.a.c r2) {
        return "fetchInstructionGroups request success, logId=" + r2.d() + "， data=" + r2;
    }

    private static final String b(com.obric.autoaction.app.launcherpage.discovery.a.c r3) {
        StringBuilder r0 = new StringBuilder().append("fetchInstructionGroups request failed, code=");
        String r1 = null;
        if (r3 == null) goto L5;
        Integer r2 = r3.a();
    L6:
        StringBuilder r4 = r0.append(r2).append(", msg=");
        if (r3 == null) goto L9;
        String r5 = r3.b();
    L10:
        StringBuilder r6 = r4.append(r5).append(", logId=");
        if (r3 == null) goto L14;
        r1 = r3.d();
    L14:
        return r6.append(r1).toString();
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private static final String a(Exception r2) {
        return "fetchInstructionGroups request error, " + r2.getMessage();
    }

    public final Object a(d.c.d<? super d.m<Boolean, ? extends List<? extends com.obric.autoaction.app.launcherpage.discovery.a.b>>> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new c(this, null), m.class, "com.obric.aiagent.plugin"), r6);
    }
}
