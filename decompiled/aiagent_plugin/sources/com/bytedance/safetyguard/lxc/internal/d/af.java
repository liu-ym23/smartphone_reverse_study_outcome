package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.bytedance.safetyguard.lxc.api.SidecarAuthHandler;
import com.bytedance.safetyguard.lxc.api.SidecarAuthRequest;
import com.bytedance.safetyguard.lxc.api.SidecarAuthResponse;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: SidecarAuthProxyStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class af implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ag f10135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f10136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SidecarAuthHandler f10137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final am f10138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final s f10139e;
    private final t f;
    private final d.h.a.b<Integer, d.x> g;
    private final AtomicBoolean h;
    private final k i;
    private final AtomicBoolean j;
    private final AtomicReference<ca> k;

    /* JADX INFO: compiled from: SidecarAuthProxyStream.kt */
    @d.c.b.a.f(b = "SidecarAuthProxyStream.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.proxy.SidecarAuthProxyStream$onPeerHalfClose$1")
    static final class a extends d.c.b.a.l implements d.h.a.b<d.c.d<? super SidecarAuthResponse>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10140a;

        a(d.c.d<? super a> r3) {
            super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(d.c.d<? super SidecarAuthResponse> r3) {
            return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super SidecarAuthResponse> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f10140a != 0) goto L7;
            d.o.a(r4);
            Map r0 = ao.a(d.s.a(DownloadHelper.CONTENT_TYPE, "text/plain; charset=utf-8"));
            Charset r1 = StandardCharsets.UTF_8;
            d.h.b.o.c(r1, "UTF_8");
            byte[] r2 = "Incomplete SIDECAR_AUTH HTTP request\n".getBytes(r1);
            d.h.b.o.c(r2, "getBytes(...)");
            return new SidecarAuthResponse(400, "Bad Request", r0, r2);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SidecarAuthProxyStream.kt */
    @d.c.b.a.f(b = "SidecarAuthProxyStream.kt", c = {146}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.proxy.SidecarAuthProxyStream$startResponse$job$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<d.c.d<? super SidecarAuthResponse>, Object> f10142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ af f10143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f10144d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f10145e;

        b(d.h.a.b<? super d.c.d<? super SidecarAuthResponse>, ? extends Object> r3, af r4, long r5, d.c.d<? super b> r7) {
            d.h.a.b<d.c.d<? super SidecarAuthResponse>, Object> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10142b = r6;
            this.f10143c = r4;
            this.f10144d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            b r11 = new b(this.f10142b, this.f10143c, this.f10144d, r7);
            r11.f10145e = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10141a;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            am r2 = (am) ZeusTransformUtils.preCheckCast(this.f10145e, am.class, "com.obric.aiagent.plugin");
            d.o.a(r9);     // Catch: Throwable -> L8
        L17:
            SidecarAuthResponse r10 = (SidecarAuthResponse) ZeusTransformUtils.preCheckCast(r9, SidecarAuthResponse.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
            if (af.d(this.f10143c).get() == false) goto L22;
            d.x r11 = d.x.f38692a;     // Catch: Throwable -> L8
            af.e(this.f10143c).compareAndSet(r2.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), null);
            return r11;
        L22:
            af.a(this.f10143c, r10, this.f10144d);     // Catch: Throwable -> L8
            af.e(this.f10143c).compareAndSet(r2.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), null);
            return d.x.f38692a;
        L8:
            Throwable th = th;
        L27:
            af.e(this.f10143c).compareAndSet(r2.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), null);
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r9);
            am r12 = (am) ZeusTransformUtils.preCheckCast(this.f10145e, am.class, "com.obric.aiagent.plugin");
            d.h.a.b<d.c.d<? super SidecarAuthResponse>, Object> r3 = this.f10142b;     // Catch: Throwable -> L25
            this.f10145e = r12;     // Catch: Throwable -> L25
            this.f10141a = 1;     // Catch: Throwable -> L25
            Object r4 = r3.invoke(this);     // Catch: Throwable -> L25
            if (r4 != r0) goto L16;
            return r0;
        L16:
            r2 = r12;
            r9 = r4;
        L25:
            th = move-exception;
            r2 = r12;
            th = th;
            goto L27
        }
    }

    /* JADX INFO: compiled from: SidecarAuthProxyStream.kt */
    @d.c.b.a.f(b = "SidecarAuthProxyStream.kt", c = {89}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.proxy.SidecarAuthProxyStream$write$1")
    static final class c extends d.c.b.a.l implements d.h.a.b<d.c.d<? super SidecarAuthResponse>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ af f10147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SidecarAuthRequest f10148c;

        c(af r3, SidecarAuthRequest r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10147b = r3;
            this.f10148c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super SidecarAuthResponse> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f10147b, this.f10148c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super SidecarAuthResponse> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10146a;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            d.o.a(r6);     // Catch: Throwable -> L7 CancellationException -> L9
        L17:
        L24:
            return (SidecarAuthResponse) ZeusTransformUtils.preCheckCast(r6, SidecarAuthResponse.class, "com.obric.aiagent.plugin");
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r6);
            SidecarAuthHandler r7 = af.a(this.f10147b);     // Catch: Throwable -> L7 CancellationException -> L9
            SidecarAuthRequest r2 = this.f10148c;     // Catch: Throwable -> L7 CancellationException -> L9
            d.c.d<? super SidecarAuthResponse> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
            this.f10146a = 1;     // Catch: Throwable -> L7 CancellationException -> L9
            r6 = r7.handle(r2, r4);     // Catch: Throwable -> L7 CancellationException -> L9
            if (r6 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            throw e;
        L7:
            th = move-exception;
            af.b(this.f10147b).a("SidecarAuthProxyStream", "component=sidecar_auth_stream event=handler_failed outcome=failed streamId=" + this.f10147b.getContext().a(), th);
            af.c(this.f10147b).a(ProxySessionErrorCode.SIDECAR_ERROR, th.getMessage());
            Map r3 = ao.a(d.s.a(DownloadHelper.CONTENT_TYPE, "text/plain; charset=utf-8"));
            Charset r5 = StandardCharsets.UTF_8;
            d.h.b.o.c(r5, "UTF_8");
            byte[] r8 = "SIDECAR_AUTH handler failed\n".getBytes(r5);
            d.h.b.o.c(r8, "getBytes(...)");
            return new SidecarAuthResponse(500, "Internal Server Error", r3, r8);
        }
    }

    /* JADX INFO: compiled from: SidecarAuthProxyStream.kt */
    @d.c.b.a.f(b = "SidecarAuthProxyStream.kt", c = {}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.proxy.SidecarAuthProxyStream$write$request$1")
    static final class d extends d.c.b.a.l implements d.h.a.b<d.c.d<? super SidecarAuthResponse>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SidecarAuthResponse f10150b;

        d(SidecarAuthResponse r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10150b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super SidecarAuthResponse> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f10150b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super SidecarAuthResponse> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f10149a != 0) goto L7;
            d.o.a(r2);
            return this.f10150b;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public af(ag r3, x r4, SidecarAuthHandler r5, am r6, s r7, t r8, d.h.a.b<? super Integer, d.x> r9) {
        SidecarAuthHandler r10 = (SidecarAuthHandler) ZeusTransformUtils.wrapperContextForParams(r5, SidecarAuthHandler.class, "com.obric.aiagent.plugin");
        am r11 = (am) ZeusTransformUtils.wrapperContextForParams(r6, am.class, "com.obric.aiagent.plugin");
        s r12 = (s) ZeusTransformUtils.wrapperContextForParams(r7, s.class, "com.obric.aiagent.plugin");
        d.h.a.b<Integer, d.x> r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r4, "writer");
        d.h.b.o.e(r10, "handler");
        d.h.b.o.e(r11, "responseScope");
        d.h.b.o.e(r12, "logger");
        d.h.b.o.e(r8, "stats");
        d.h.b.o.e(r13, "onClosed");
        this.f10135a = r3;
        this.f10136b = r4;
        this.f10137c = r10;
        this.f10138d = r11;
        this.f10139e = r12;
        this.f = r8;
        this.g = r13;
        boolean r14 = false;
        this.h = new AtomicBoolean(false);
        if (ZeusTransformUtils.instanceOf(r10, com.bytedance.safetyguard.lxc.internal.e.b.i.class) == false) goto L5;
        com.bytedance.safetyguard.lxc.internal.e.b.i r15 = (com.bytedance.safetyguard.lxc.internal.e.b.i) ZeusTransformUtils.preCheckCast(r10, com.bytedance.safetyguard.lxc.internal.e.b.i.class, "com.obric.aiagent.plugin");
    L6:
        if (r15 == null) goto L8;
        int r16 = r15.a();
    L9:
        this.i = new k(0, r16, 1, null);
        this.j = new AtomicBoolean(false);
        this.k = new AtomicReference(null);
        if (getContext().b() != com.bytedance.safetyguard.lxc.internal.c.c.f9817e) goto L12;
        r14 = true;
    L12:
        if (r14 == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L8:
        r16 = 1048576;
        goto L9
    L5:
        r15 = null;
        goto L6
    }

    public static final /* synthetic */ SidecarAuthHandler a(af r0) {
        return r0.f10137c;
    }

    public static final /* synthetic */ void a(af r0, SidecarAuthResponse r1, long r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ s b(af r0) {
        return r0.f10139e;
    }

    public static final /* synthetic */ t c(af r0) {
        return r0.f;
    }

    public static final /* synthetic */ AtomicBoolean d(af r0) {
        return r0.h;
    }

    public static final /* synthetic */ AtomicReference e(af r0) {
        return r0.k;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.w
    public ag getContext() {
        return this.f10135a;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.w
    public void a(byte[] r8) {
        d.h.b.o.e(r8, "payload");
        c();
        if (getContext().d() == false) goto L7;
        this.f.a(ProxySessionErrorCode.MALFORMED_FRAME, "DATA after peer HALF_CLOSE: streamId=" + getContext().a());
        b((Throwable) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.c.k("DATA after peer HALF_CLOSE: " + getContext().a(), null, 2, null), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        if (this.j.get() == false) goto L10;
        this.f10139e.a("SidecarAuthProxyStream", "component=sidecar_auth_stream event=data_after_response outcome=ignored streamId=" + getContext().a() + " requestBytes=" + r8.length);
        return;
    L10:
        getContext().a(r8.length);
        this.f.a(r8.length);
        SidecarAuthRequest r0 = this.i.a(r8);     // Catch: com.bytedance.safetyguard.lxc.internal.c.k -> L17
        getContext().b(r8.length);
        this.f10136b.a(getContext().a(), r8.length);
        if (r0 != null) goto L15;
        return;
    L15:
        a((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this, r0, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L17:
        e = move-exception;
        this.f.a(ProxySessionErrorCode.SIDECAR_ERROR, e.getMessage());
        getContext().b(r8.length);
        this.f10136b.a(getContext().a(), r8.length);
        this.f10139e.a("SidecarAuthProxyStream", "component=sidecar_auth_stream event=request_rejected outcome=parser_rejected streamId=" + getContext().a() + " exceptionClass=" + e.getClass().getSimpleName());
        String r9 = e.getMessage();
        boolean r1 = false;
        if (r9 != null) goto L21;
    L23:
        if (r1 == false) goto L25;
        SidecarAuthResponse r10 = com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.d();
    L26:
        a((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r10, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L25:
        r10 = com.bytedance.safetyguard.lxc.internal.e.b.k.f10703a.a(400);
        goto L26
    L21:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("exceed", CharSequence.class, "com.obric.aiagent.plugin"), true) != true) goto L23;
        r1 = true;
        goto L23
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.w
    public void a() {
        if (this.h.get() == false) goto L6;
        return;
    L6:
        if (getContext().d() == false) goto L8;
        return;
    L8:
        getContext().b(true);
        if (this.j.get() == false) goto L12;
        b();
        return;
    L12:
        this.f10139e.a("SidecarAuthProxyStream", "component=sidecar_auth_stream event=incomplete_request outcome=rejected streamId=" + getContext().a());
        a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.safetyguard.lxc.internal.d.w
    public void a(int r1) {
        getContext().d(r1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.h.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        ca r0 = (ca) ZeusTransformUtils.preCheckCast(this.k.getAndSet(null), ca.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L8;
        ca.a.a(r0, null, 1, null);
    L8:
        getContext().f();
        this.f10139e.a("SidecarAuthProxyStream", "component=sidecar_auth_stream event=stream_closed outcome=success streamId=" + getContext().a());
        this.g.invoke(Integer.valueOf(getContext().a()));
    }

    private final void a(d.h.a.b<? super d.c.d<? super SidecarAuthResponse>, ? extends Object> r16) {
        d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (this.j.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        long r3 = System.nanoTime();
        ca r0 = kotlinx.coroutines.i.a(this.f10138d, null, kotlinx.coroutines.ao.f38852b, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r1, this, r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
        if (this.k.compareAndSet(null, r0) == true) goto L8;
    L12:
        ca.a.a(r0, null, 1, null);
        return;
    L8:
        if (this.h.get() == true) goto L12;
        r0.s_();
    }

    private final void a(SidecarAuthResponse r5, long r6) {
        a(r5);     // Catch: Throwable -> L5 CancellationException -> L11
        this.f10139e.a("SidecarAuthProxyStream", "component=sidecar_auth_stream event=response_finished outcome=success streamId=" + getContext().a() + " httpStatus=" + r5.getStatusCode() + " responseBytes=" + r5.getBody().length + " durationMs=" + d.l.n.a((System.nanoTime() - r6) / 1000000, 0));     // Catch: Throwable -> L5 CancellationException -> L11
    L15:
        return;
    L11:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        if (this.h.get() == false) goto L9;
        return;
    L9:
        a(th);
        this.f10139e.b("SidecarAuthProxyStream", "component=sidecar_auth_stream event=response_write_failed outcome=failed streamId=" + getContext().a(), th);
        b(th);
    }

    private final void a(SidecarAuthResponse r11) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r11.getHeaders());
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put(DownloadUtils.CONTENT_LENGTH, String.valueOf(r11.getBody().length));
        r0.putIfAbsent("Connection", "close");
        StringBuilder r1 = new StringBuilder();
        r1.append("HTTP/1.1 ");
        r1.append(r11.getStatusCode());
        r1.append(' ');
        r1.append(r11.getReason());
        r1.append("\r\n");
        Iterator r2 = ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.aiagent.plugin");
        r1.append(r5);
        r1.append(": ");
        r1.append(r6);
        r1.append("\r\n");
        goto L4
    L6:
        r1.append("\r\n");
        String r3 = r1.toString();
        d.h.b.o.c(r3, "toString(...)");
        Charset r7 = StandardCharsets.ISO_8859_1;
        d.h.b.o.c(r7, "ISO_8859_1");
        byte[] r8 = r3.getBytes(r7);
        d.h.b.o.c(r8, "getBytes(...)");
        byte[] r12 = d.a.i.a(r8, r11.getBody());
        int r9 = 0;
    L8:
        if (r9 >= r12.length) goto L10;
        int r10 = Math.min(32768, r12.length - r9) + r9;
        byte[] r13 = d.a.i.a(r12, r9, r10);
        getContext().c(r13.length);
        this.f.b(r13.length);
        this.f10136b.a(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.g, getContext().a(), 0, r13, 4, null));
        r9 = r10;
        goto L8
    L10:
        this.f10136b.a(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.h, getContext().a(), 0, null, 12, null));
        getContext().a(true);
        b();
    }

    private final void a(Throwable r7) {
        if (ZeusTransformUtils.instanceOf(r7, com.bytedance.safetyguard.lxc.internal.c.k.class) == false) goto L11;
        String r0 = r7.getMessage();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L11;
        this.f.a(ProxySessionErrorCode.PENDING_BYTES_EXCEEDED, r7.getMessage());
        return;
    L7:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Pending", CharSequence.class, "com.obric.aiagent.plugin"), true) != true) goto L9;
        r1 = true;
    L11:
        this.f.a(ProxySessionErrorCode.SIDECAR_ERROR, r7.getMessage());
    }

    private final void b() {
        if (getContext().g() == true) goto L6;
        return;
    L6:
        if (this.h.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        getContext().f();
        this.f10139e.a("SidecarAuthProxyStream", "component=sidecar_auth_stream event=stream_closed outcome=success streamId=" + getContext().a());
        this.g.invoke(Integer.valueOf(getContext().a()));
    }

    private final void b(Throwable r9) {
        if (this.h.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        String r1 = null;
        ca r0 = (ca) ZeusTransformUtils.preCheckCast(this.k.getAndSet(null), ca.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L8;
        ca.a.a(r0, null, 1, null);
    L8:
        getContext().f();
        s r2 = this.f10139e;
        StringBuilder r3 = new StringBuilder().append("component=sidecar_auth_stream event=stream_reset outcome=failed streamId=").append(getContext().a()).append(" exceptionClass=");
        if (r9 == null) goto L13;
        Class<?> r10 = r9.getClass();
        if (r10 == null) goto L13;
        r1 = r10.getSimpleName();
    L13:
        if (r1 != null) goto L15;
        r1 = OProtocolTextEffectTextView.EffectNameNone;
    L15:
        r2.a("SidecarAuthProxyStream", r3.append(r1).toString());
        this.f10136b.a(getContext().a());
        this.g.invoke(Integer.valueOf(getContext().a()));
        this.f10136b.f(new com.bytedance.safetyguard.lxc.internal.c.f(com.bytedance.safetyguard.lxc.internal.c.h.j, getContext().a(), 0, null, 12, null));
    }

    private final void c() {
        if (this.h.get() == true) goto L8;
        if (getContext().e() == true) goto L8;
        return;
    L8:
        throw new com.bytedance.safetyguard.lxc.internal.c.k("Stream is closed: " + getContext().a(), null, 2, null);
    }
}
