package com.bytedance.safetyguard.lxc.internal.e.e;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.n;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.q;
import okhttp3.u;
import okhttp3.z;

/* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e implements com.bytedance.safetyguard.lxc.internal.e.e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10812a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f10813d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z f10815c;

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    static final class b extends p implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ okhttp3.e f10816a;

        b(okhttp3.e r3) {
            this.f10816a = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
            super(1);
        }

        public final void a(Throwable r1) {
            this.f10816a.c();
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
    public static final class c implements okhttp3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<i> f10817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f10818b;

        c(n<? super i> r3, e r4) {
            this.f10817a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
            this.f10818b = r4;
        }

        @Override // okhttp3.f
        public void a(okhttp3.e r3, IOException r4) {
            o.e((okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin"), "call");
            o.e(r4, "e");
            n<i> r2 = this.f10817a;
            d.n.a r5 = d.n.f38560a;
            r2.resumeWith(d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"))));
        }

        @Override // okhttp3.f
        public void a(okhttp3.e r21, ad r22) {
            o.e((okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r21, okhttp3.e.class, "com.obric.aiagent.plugin"), "call");
            o.e(r22, "response");
            e r2 = this.f10818b;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L42
            c r5 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
            Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r22, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
            ad r0 = (ad) ZeusTransformUtils.preCheckCast(r6, ad.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
            ae r7 = r0.g();     // Catch: Throwable -> L35
            if (r7 == null) goto L12;
            if (r7.c() <= e.a(r2)) goto L12;
            throw new f();     // Catch: Throwable -> L35
        L12:
            if (r7 == null) goto L27;
            InputStream r8 = r7.e();     // Catch: Throwable -> L35
            if (r8 == null) goto L27;
            Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
            byte[] r3 = d.a((InputStream) ZeusTransformUtils.preCheckCast(r9, InputStream.class, "com.obric.aiagent.plugin"), e.a(r2));     // Catch: Throwable -> L20
            d.f.c.a(r9, null);     // Catch: Throwable -> L35
            if (r3 == null) goto L27;
        L28:
            int r10 = r0.d();     // Catch: Throwable -> L35
            String r11 = r0.c();     // Catch: Throwable -> L35
            Map<String, List<String>> r1 = r0.f().e();     // Catch: Throwable -> L35
            Map r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r1.size())), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L35
        L30:
            if (r13.hasNext() == false) goto L32;
            Object r14 = r13.next();     // Catch: Throwable -> L35
            r12.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r14, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r14, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));     // Catch: Throwable -> L35
            goto L30
        L32:
            i r15 = new i(r10, r11, r12, r3);     // Catch: Throwable -> L35
            d.f.c.a(r6, null);     // Catch: Throwable -> L42
            Object r16 = d.n.f(r15);     // Catch: Throwable -> L42
        L44:
            this.f10817a.resumeWith(r16);
            return;
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            d.f.c.a(r9, th);     // Catch: Throwable -> L35
            throw th;     // Catch: Throwable -> L35
        L27:
            r3 = new byte[0];     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            throw th;     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            d.f.c.a(r6, th);     // Catch: Throwable -> L42
            throw th;     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            d.n.a r17 = d.n.f38560a;
            r16 = d.n.f(d.o.a(th));
            goto L44
        }
    }

    public e(int r2, z r3) {
        o.e(r3, "client");
        this.f10814b = r2;
        this.f10815c = r3;
    }

    public static final /* synthetic */ int a(e r0) {
        return r0.f10814b;
    }

    public e(int r4, int r5, int r6, com.bytedance.safetyguard.lxc.internal.b.a r7) {
        com.bytedance.safetyguard.lxc.internal.b.a r8 = (com.bytedance.safetyguard.lxc.internal.b.a) ZeusTransformUtils.wrapperContextForParams(r7, com.bytedance.safetyguard.lxc.internal.b.a.class, "com.obric.aiagent.plugin");
        o.e(r8, "dnsResolver");
        this(r4, new z.a().a((q) ZeusTransformUtils.preCheckCast(new g(r8), q.class, "com.obric.aiagent.plugin")).a(Proxy.NO_PROXY).a(r5, TimeUnit.MILLISECONDS).b(r6, TimeUnit.MILLISECONDS).b(false).c(false).E());
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.e.b
    public Object a(h r13, d.c.d<? super i> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (o.a(r13.e(), Proxy.NO_PROXY) == false) goto L31;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r13.c().entrySet(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L5:
        ac r3 = null;
        if (r0.hasNext() == false) goto L10;
        Object r2 = r0.next();
        if (d.o.o.a((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"), DownloadHelper.CONTENT_TYPE, true) == false) goto L5;
    L11:
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L16;
        okhttp3.x r7 = okhttp3.x.f40220a.b(r4);
    L18:
        if (r13.d().length != 0) goto L20;
        boolean r5 = true;
    L22:
        if ((!r5) == false) goto L24;
    L25:
        r3 = ac.a.a(ac.g, r13.d(), r7, 0, 0, 6, null);
    L26:
        okhttp3.e r16 = this.f10815c.a(new ab.a().a(r13.b()).a(u.f40205a.a(r13.c())).a(r13.a(), r3).b());
        kotlinx.coroutines.o r6 = new kotlinx.coroutines.o(d.c.a.b.a(r15), 1);
        r6.e();
        n r8 = (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.aiagent.plugin");
        r8.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r16), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r16.a((okhttp3.f) ZeusTransformUtils.preCheckCast(new c(r8, this), okhttp3.f.class, "com.obric.aiagent.plugin"));
        Object r12 = r6.h();
        if (r12 != d.c.a.b.a()) goto L29;
        d.c.b.a.h.c(r15);
    L29:
        return r12;
    L24:
        if (f10813d.contains(r13.a()) == false) goto L26;
    L20:
        r5 = false;
    L16:
        r7 = null;
        goto L18
    L10:
        r2 = null;
        goto L11
    L31:
        throw new IOException("Sidecar forwarder only supports direct connections");
    }

    static {
        f10812a = new a(null);
        f10813d = ax.a(new String[]{"POST", "PUT", "PATCH", "PROPPATCH", "REPORT"});
    }
}
