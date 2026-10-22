package com.obric.autogui.net.sse;

import android.content.Context;
import com.bytedance.retrofit2.ak;
import com.bytedance.retrofit2.e.i;
import com.bytedance.retrofit2.q;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: SSENet.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "SSENet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0735a f29139a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f29140c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ISSEApi f29141d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ArrayList<com.bytedance.retrofit2.b.b> f29142e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.net.ttnet.a f29143b;

    /* JADX INFO: renamed from: com.obric.autogui.net.sse.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SSENet.kt */
    public static final class C0735a {
        public /* synthetic */ C0735a(h r1) {
            this();
        }

        private C0735a() {
        }
    }

    /* JADX INFO: compiled from: SSENet.kt */
    public static final class b implements com.obric.autogui.tools.api.net.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f29144a = null;

        static {
            f29144a = new b();
        }

        private b() {
        }

        @Override // com.obric.autogui.tools.api.net.a.b
        public void a() {
            Loog.INSTANCE.w(a.TAG, " - [SSE-Streaming] calling `cancel()` on a dummy SSE operator.");
        }
    }

    /* JADX INFO: compiled from: SSENet.kt */
    private final class c implements com.obric.autogui.tools.api.net.a.InterfaceC0861a<com.obric.autogui.tools.api.net.a.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f29145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.tools.api.net.a.b f29146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Throwable f29147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f29148d;

        public c(a r3, com.obric.autogui.tools.api.net.a.b r4, Throwable r5) {
            com.obric.autogui.tools.api.net.a.b r6 = (com.obric.autogui.tools.api.net.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.tools.api.net.a.b.class, "com.obric.aiagent.plugin");
            this.f29145a = r3;
            this.f29146b = r6;
            this.f29147c = r5;
            if (r5 != null) goto L5;
            boolean r7 = true;
        L6:
            this.f29148d = r7;
            return;
        L5:
            r7 = false;
            goto L6
        }

        public /* synthetic */ c(a r2, com.obric.autogui.tools.api.net.a.b r3, Throwable r4, int r5, h r6) {
            com.obric.autogui.tools.api.net.a.b r7 = (com.obric.autogui.tools.api.net.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.tools.api.net.a.b.class, "com.obric.aiagent.plugin");
            if ((r5 & 1) == 0) goto L6;
            r7 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            this(r2, r7, r4);
        }

        @Override // com.obric.autogui.tools.api.net.a.InterfaceC0861a
        public /* synthetic */ com.obric.autogui.tools.api.net.a.b c() {
            return b();
        }

        @Override // com.obric.autogui.tools.api.net.a.InterfaceC0861a
        public boolean a() {
            return this.f29148d;
        }

        public com.obric.autogui.tools.api.net.a.b b() {
            return this.f29146b;
        }

        @Override // com.obric.autogui.tools.api.net.a.InterfaceC0861a
        public com.obric.autogui.tools.api.net.b a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            if (this.f29147c == null) goto L7;
            return (com.obric.autogui.tools.api.net.b) ZeusTransformUtils.preCheckCast(this.f29145a.a().b().a(r4, this.f29147c), com.obric.autogui.tools.api.net.b.class, "com.obric.aiagent.plugin");
        L7:
            throw new UnsupportedOperationException("analyseException() is not supported for a successful response.");
        }
    }

    /* JADX INFO: compiled from: SSENet.kt */
    public static final class d<T> implements com.obric.autogui.tools.api.net.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.e<T> f29149a;

        public d(com.bytedance.retrofit2.e<T> r3) {
            com.bytedance.retrofit2.e<T> r4 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
            o.e(r4, "call");
            this.f29149a = r4;
        }

        @Override // com.obric.autogui.tools.api.net.a.b
        public void a() {
            if (this.f29149a.c() == true) goto L6;
            Loog.INSTANCE.d(a.TAG, " - [SSE-Streaming] cancelReceiving");
            this.f29149a.b();
            return;
        }
    }

    /* JADX INFO: compiled from: SSENet.kt */
    @f(b = "SSENet.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.net.sse.SSENet$startSse$2")
    static final class e extends l implements m<am, d.c.d<? super c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.retrofit2.e<i> f29151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f29152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f29153d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f29154e;
        final /* synthetic */ com.obric.autogui.tools.api.net.a.a f;

        /* JADX INFO: renamed from: com.obric.autogui.net.sse.a$e$1, reason: invalid class name */
        /* JADX INFO: compiled from: SSENet.kt */
        @f(b = "SSENet.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.net.sse.SSENet$startSse$2$1")
        static final class AnonymousClass1 extends l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f29155a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f29156b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Context f29157c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.bytedance.retrofit2.e<i> f29158d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ ak<i> f29159e;
            final /* synthetic */ com.obric.autogui.tools.api.net.a.a f;

            AnonymousClass1(a r3, Context r4, com.bytedance.retrofit2.e<i> r5, ak<i> r6, com.obric.autogui.tools.api.net.a.a r7, d.c.d<? super AnonymousClass1> r8) {
                Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
                com.bytedance.retrofit2.e<i> r10 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
                com.obric.autogui.tools.api.net.a.a r11 = (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin");
                d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29156b = r3;
                this.f29157c = ZeusTransformUtils.wrapperContext(r9, "com.obric.aiagent.plugin");
                this.f29158d = r10;
                this.f29159e = r6;
                this.f = r11;
                super(1, r12);
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r10) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f29156b, this.f29157c, this.f29158d, this.f29159e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f29155a != 0) goto L7;
                d.o.a(r4);
                a r5 = this.f29156b;
                Context r0 = this.f29157c;
                com.bytedance.retrofit2.e<i> r1 = this.f29158d;
                ak<i> r2 = this.f29159e;
                o.a(r2);
                a.a(r5, r0, r1, r2, this.f);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        e(com.bytedance.retrofit2.e<i> r3, a r4, boolean r5, Context r6, com.obric.autogui.tools.api.net.a.a r7, d.c.d<? super e> r8) {
            com.bytedance.retrofit2.e<i> r9 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            com.obric.autogui.tools.api.net.a.a r11 = (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29151b = r9;
            this.f29152c = r4;
            this.f29153d = r5;
            this.f29154e = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
            this.f = r11;
            super(2, r12);
        }

        public final Object a(am r3, d.c.d<? super c> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f29151b, this.f29152c, this.f29153d, this.f29154e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super c> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f29150a != 0) goto L18;
            d.o.a(r10);
            ak<i> r4 = this.f29151b.a();     // Catch: Throwable -> L14
            if (this.f29153d == false) goto L9;
            com.obric.autogui.net.ttnet.a.f29160a.a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f29152c, this.f29154e, this.f29151b, r4, this.f, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        L13:
            return new c(this.f29152c, (com.obric.autogui.tools.api.net.a.b) ZeusTransformUtils.preCheckCast(new d(this.f29151b), com.obric.autogui.tools.api.net.a.b.class, "com.obric.aiagent.plugin"), null, 2, null);
        L9:
            a r11 = this.f29152c;
            Context r0 = this.f29154e;
            com.bytedance.retrofit2.e<i> r1 = this.f29151b;
            o.a(r4);
            c r12 = a.a(r11, r0, r1, r4, this.f);
            if (r12.a() == true) goto L13;
            return r12;
        L14:
            th = move-exception;
            Loog.INSTANCE.e(a.TAG, " - [SSE] error during sse execution.");
            this.f29151b.b();
            return new c(this.f29152c, null, th, 1, null);
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public a(com.obric.autogui.net.ttnet.a r2) {
        o.e(r2, "client");
        this.f29143b = r2;
    }

    public static final /* synthetic */ c a(a r2, Context r3, com.bytedance.retrofit2.e r4, ak r5, com.obric.autogui.tools.api.net.a.a r6) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin"), r5, (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin"));
    }

    public final com.obric.autogui.net.ttnet.a a() {
        return this.f29143b;
    }

    static {
        f29139a = new C0735a(null);
        String r0 = com.obric.aiagent.product.a.a.f18769a.c();
        f29140c = r0;
        f29141d = (ISSEApi) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.b(r0).a(ISSEApi.class), ISSEApi.class, "com.obric.aiagent.plugin");
        ArrayList<com.bytedance.retrofit2.b.b> r1 = new ArrayList();
        r1.add(new com.bytedance.retrofit2.b.b("Connection", "keep-alive"));
        r1.add(new com.bytedance.retrofit2.b.b("Accept", "text/event-stream"));
        r1.add(new com.bytedance.retrofit2.b.b(DownloadHelper.CONTENT_TYPE, "application/json"));
        f29142e = r1;
    }

    public final Object a(Context r15, String r16, Object r17, boolean r18, com.obric.autogui.tools.api.net.a.a r19, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<com.obric.autogui.tools.api.net.a.b>> r20) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.tools.api.net.a.a r7 = (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.wrapperContextForParams(r19, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin");
        d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<com.obric.autogui.tools.api.net.a.b>> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        ArrayList<com.bytedance.retrofit2.b.b> r0 = a(f29142e);
        Class<?> r5 = null;
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L8;
        Loog r4 = Loog.INSTANCE;
        StringBuilder r10 = new StringBuilder().append("post sse, path: ").append(r16).append(", requestHeader: ").append(r0).append(", bodyType=");
        if (r17 == null) goto L7;
        r5 = r17.getClass();
    L7:
        r4.i(TAG, r10.append(r5).toString());
        Loog.INSTANCE.d(TAG, "post sse, body: " + r17);
    L12:
        ISSEApi r9 = f29141d;
        List<com.bytedance.retrofit2.b.b> r11 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        com.bytedance.ttnet.d.d r12 = new com.bytedance.ttnet.d.d();
        r12.f8189c = 15000;
        r12.f8190d = 50000;
        r12.f8191e = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        x r1 = x.f38692a;
        return a(r6, r9.doPostSSE(r16, null, r17, r11, r12), r18, r7, r8);
    L8:
        Loog r13 = Loog.INSTANCE;
        StringBuilder r14 = new StringBuilder().append("post sse, path: ").append(r16).append(", bodyType=");
        if (r17 == null) goto L11;
        r5 = r17.getClass();
    L11:
        r13.i(TAG, r14.append(r5).toString());
        goto L12
    }

    private final ArrayList<com.bytedance.retrofit2.b.b> a(ArrayList<com.bytedance.retrofit2.b.b> r1) {
        return com.obric.autogui.net.ttnet.c.f29240a.a(r1);
    }

    private final Object a(Context r10, com.bytedance.retrofit2.e<i> r11, boolean r12, com.obric.autogui.tools.api.net.a.a r13, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<com.obric.autogui.tools.api.net.a.b>> r14) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.retrofit2.e r3 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r11, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.tools.api.net.a.a r7 = (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a(com.obric.autogui.net.ttnet.a.f29160a.a().getCoroutineScope().a(), (m) ZeusTransformUtils.preCheckCast(new e(r3, this, r12, r6, r7, null), m.class, "com.obric.aiagent.plugin"), r15);
    }

    private final c a(Context r11, com.bytedance.retrofit2.e<i> r12, ak<i> r13, com.obric.autogui.tools.api.net.a.a r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.retrofit2.e<i> r16 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.tools.api.net.a.a r17 = (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.wrapperContextForParams(r14, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin");
        InputStream r1 = null;
        i r3 = (i) ZeusTransformUtils.preCheckCast(r13.f(), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r3 == null) goto L6;
        r1 = r3.e_();     // Catch: Throwable -> L11
    L6:
        if (r1 != null) goto L9;
        Loog.INSTANCE.e(TAG, "- [execute-sse] cannot fetch InputStream from response.");     // Catch: Throwable -> L11
        com.obric.autogui.net.ttnet.a.c r18 = new com.obric.autogui.net.ttnet.a.c("SSEInputStreamNull");     // Catch: Throwable -> L11
        r17.a((com.obric.autogui.tools.api.net.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.a.a.c(com.obric.autogui.tools.api.net.c.f31483b, (Throwable) ZeusTransformUtils.preCheckCast(r18, Throwable.class, "com.obric.aiagent.plugin")), com.obric.autogui.tools.api.net.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
        return new c(this, null, (Throwable) ZeusTransformUtils.preCheckCast(r18, Throwable.class, "com.obric.aiagent.plugin"), 1, null);
    L9:
        a(r16, r13, r1, r17);     // Catch: Throwable -> L11
    L17:
        return new c(this, (com.obric.autogui.tools.api.net.a.b) ZeusTransformUtils.preCheckCast(b.f29144a, com.obric.autogui.tools.api.net.a.b.class, "com.obric.aiagent.plugin"), null, 2, null);
    L11:
        th = move-exception;
        com.obric.autogui.net.ttnet.a.a.b r19 = this.f29143b.b().a(r15, th);
        Loog.INSTANCE.e(TAG, "- [execute-sse] exception thrown during SSE reading (e=" + r19.getType() + ").");
        r17.a((com.obric.autogui.tools.api.net.b) ZeusTransformUtils.preCheckCast(r19, com.obric.autogui.tools.api.net.b.class, "com.obric.aiagent.plugin"));
        if (0 == 0) goto L15;
        r1.close();
    L15:
        r16.b();
        goto L17
    }

    private final void a(com.bytedance.retrofit2.e<i> r9, ak<i> r10, InputStream r11, com.obric.autogui.tools.api.net.a.a r12) {
        com.bytedance.retrofit2.e r8 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r9, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
        com.obric.autogui.tools.api.net.a.a r13 = (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin");
        ByteArrayOutputStream r14 = new ByteArrayOutputStream();
        byte[] r2 = new byte[4096];
        r13.a();
    L3:
        int r4 = r11.read(r2, 0, 4096);
        if (r4 <= 0) goto L9;
        r14.write(r2, 0, r4);
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L8;
        Loog.INSTANCE.d(TAG, "read sse stream, readLength=" + r4);
    L8:
        String r3 = r14.toString();
        o.c(r3, "toString(...)");
        r13.a(r3);
    L9:
        if (r4 != 0) goto L11;
        Loog.INSTANCE.w(TAG, "read sse stream, read a 0-length buffer!");
    L11:
        if (r4 >= 0) goto L3;
        if (ZeusTransformUtils.instanceOf(r8, q.class) == false) goto L15;
        ((q) ZeusTransformUtils.preCheckCast(r8, q.class, "com.obric.aiagent.plugin")).f();
        Object r15 = r10.b().f();
        o.a(r15, "null cannot be cast to non-null type com.bytedance.ttnet.http.HttpRequestInfo");
        com.bytedance.ttnet.d.b r16 = (com.bytedance.ttnet.d.b) ZeusTransformUtils.preCheckCast(r15, com.bytedance.ttnet.d.b.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, "Request log: " + r16.f8134J);
        Loog.INSTANCE.d(TAG, "Total time: " + r16.u);
        Loog.INSTANCE.d(TAG, "Retrofit log: " + r16.K.get("retrofit"));
    L15:
        String r17 = com.obric.autogui.net.ttnet.e.f29244a.a(r10.b().c());
        if (r17 == null) goto L18;
        r13.c(r17);
    L18:
        r13.b(r17);
    }
}
