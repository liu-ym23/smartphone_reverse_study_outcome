package com.obric.autogui.net.ttnet;

import android.content.Context;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.capabilitykit.entity.ResultCode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.l.n;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: AOTTNetHttpClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a implements com.obric.autogui.tools.api.net.a {
    private static final String TAG = "AOTTNetHttpClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0736a f29160a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AOThreadingTools.SingleThreadCoroutineScopeWrapper f29161c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.net.ttnet.a.b f29162b;

    /* JADX INFO: renamed from: com.obric.autogui.net.ttnet.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOTTNetHttpClient.kt */
    public static final class C0736a {
        public /* synthetic */ C0736a(d.h.b.h r1) {
            this();
        }

        private C0736a() {
        }

        public final AOThreadingTools.SingleThreadCoroutineScopeWrapper a() {
            return a.c();
        }
    }

    /* JADX INFO: compiled from: AOTTNetHttpClient.kt */
    protected static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29164b;

        public b(String r1, String r2) {
            this.f29163a = r1;
            this.f29164b = r2;
        }

        public final String a() {
            return this.f29163a;
        }

        public final String b() {
            return this.f29164b;
        }
    }

    /* JADX INFO: compiled from: AOTTNetHttpClient.kt */
    private final class c<T> implements com.obric.autogui.tools.api.net.a.InterfaceC0861a<T>, com.obric.autogui.tools.api.net.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f29165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f29166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f29167c;

        public c(a r2, Throwable r3) {
            o.e(r3, "throwable");
            this.f29165a = r2;
            this.f29166b = r3;
        }

        @Override // com.obric.autogui.tools.api.net.a.InterfaceC0861a
        public boolean a() {
            return this.f29167c;
        }

        @Override // com.obric.autogui.tools.api.net.a.InterfaceC0861a
        public com.obric.autogui.tools.api.net.b a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            return (com.obric.autogui.tools.api.net.b) ZeusTransformUtils.preCheckCast(a.a(this.f29165a).a(r4, this.f29166b), com.obric.autogui.tools.api.net.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.autogui.tools.api.net.a.InterfaceC0861a
        public T c() {
            Loog.INSTANCE.w(a.TAG, "attempted to getData() on a failed response.");
            return null;
        }

        @Override // com.obric.autogui.tools.api.net.d
        public String b() {
            return a.a(this.f29165a, this.f29166b);
        }
    }

    /* JADX INFO: compiled from: AOTTNetHttpClient.kt */
    private final class d<T> implements com.obric.autogui.tools.api.net.a.InterfaceC0861a<T>, com.obric.autogui.tools.api.net.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f29168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f29169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f29170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f29171d;

        public d(a r1, T r2, String r3) {
            this.f29168a = r1;
            this.f29169b = r2;
            this.f29170c = r3;
            this.f29171d = true;
        }

        @Override // com.obric.autogui.tools.api.net.a.InterfaceC0861a
        public boolean a() {
            return this.f29171d;
        }

        @Override // com.obric.autogui.tools.api.net.a.InterfaceC0861a
        public com.obric.autogui.tools.api.net.b a(Context r2) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
            throw new UnsupportedOperationException("analyseException() is not supported for a successful response.");
        }

        @Override // com.obric.autogui.tools.api.net.a.InterfaceC0861a
        public T c() {
            return this.f29169b;
        }

        @Override // com.obric.autogui.tools.api.net.d
        public String b() {
            return this.f29170c;
        }
    }

    /* JADX INFO: compiled from: AOTTNetHttpClient.kt */
    @d.c.b.a.f(b = "AOTTNetHttpClient.kt", c = {158}, d = "execute", e = "com.obric.autogui.net.ttnet.AOTTNetHttpClient")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f29174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f29176e;
        int f;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29176e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f29175d = r8;
            this.f |= Integer.MIN_VALUE;
            return a.a(this.f29176e, null, null, null, 0, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOTTNetHttpClient.kt */
    @d.c.b.a.f(b = "AOTTNetHttpClient.kt", c = {136}, d = "invokeSuspend", e = "com.obric.autogui.net.ttnet.AOTTNetHttpClient$execute$ioJob$1")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f29178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f29179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f29180d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f29181e;
        final /* synthetic */ boolean f;
        final /* synthetic */ int g;
        final /* synthetic */ w<com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> h;

        f(a r3, Map<String, String> r4, String r5, String r6, boolean r7, int r8, w<com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r9, d.c.d<? super f> r10) {
            Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            w<com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r12 = (w) ZeusTransformUtils.wrapperContextForParams(r9, w.class, "com.obric.aiagent.plugin");
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29178b = r3;
            this.f29179c = r11;
            this.f29180d = r5;
            this.f29181e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r12;
            super(2, r13);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f29178b, this.f29179c, this.f29180d, this.f29181e, this.f, this.g, this.h, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29177a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r11);     // Catch: Throwable -> L7
        L15:
            com.obric.autogui.tools.api.net.a.InterfaceC0861a<String> r12 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.h.a(r12);
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r11);
            a r13 = this.f29178b;     // Catch: Throwable -> L7
            Map<String, String> r4 = this.f29179c;     // Catch: Throwable -> L7
            String r5 = this.f29180d;     // Catch: Throwable -> L7
            String r6 = com.obric.autogui.net.ttnet.c.f29240a.a(this.f29181e);     // Catch: Throwable -> L7
            boolean r7 = this.f;     // Catch: Throwable -> L7
            int r8 = this.g;     // Catch: Throwable -> L7
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f29177a = 1;     // Catch: Throwable -> L7
            r11 = a.b(r13, r4, r5, r6, r7, r8, r9);     // Catch: Throwable -> L7
            if (r11 != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            this.h.a(th);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: AOTTNetHttpClient.kt */
    @d.c.b.a.f(b = "AOTTNetHttpClient.kt", c = {178}, d = "executeSafely", e = "com.obric.autogui.net.ttnet.AOTTNetHttpClient")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f29183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f29184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f29185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f29186e;

        g(a r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29185d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f29184c = r8;
            this.f29186e |= Integer.MIN_VALUE;
            return a.b(this.f29185d, null, null, null, false, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOTTNetHttpClient.kt */
    @d.c.b.a.f(b = "AOTTNetHttpClient.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.net.ttnet.AOTTNetHttpClient$executeUnsafe$2")
    static final class h extends l implements m<am, d.c.d<? super b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f29188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f29189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f29190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f29191e;
        final /* synthetic */ boolean f;
        final /* synthetic */ int g;

        h(a r3, Map<String, String> r4, String r5, String r6, boolean r7, int r8, d.c.d<? super h> r9) {
            Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29188b = r3;
            this.f29189c = r10;
            this.f29190d = r5;
            this.f29191e = r6;
            this.f = r7;
            this.g = r8;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super b> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f29188b, this.f29189c, this.f29190d, this.f29191e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super b> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f29187a != 0) goto L7;
            d.o.a(r8);
            return a.a(this.f29188b, this.f29189c, this.f29190d, this.f29191e, this.f, this.g);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AOTTNetHttpClient.kt */
    @d.c.b.a.f(b = "AOTTNetHttpClient.kt", c = {ResultCode.ERROR_MEMORY_SERVICE_DISABLED}, d = "invokeSuspend", e = "com.obric.autogui.net.ttnet.AOTTNetHttpClient$postSSE$2")
    static final class i extends l implements m<am, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<com.obric.autogui.tools.api.net.a.b>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f29193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f29194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f29195d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f29196e;
        final /* synthetic */ boolean f;
        final /* synthetic */ com.obric.autogui.tools.api.net.a.a g;

        i(a r3, Context r4, String r5, Object r6, boolean r7, com.obric.autogui.tools.api.net.a.a r8, d.c.d<? super i> r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            com.obric.autogui.tools.api.net.a.a r11 = (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29193b = r3;
            this.f29194c = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
            this.f29195d = r5;
            this.f29196e = r6;
            this.f = r7;
            this.g = r11;
            super(2, r12);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<com.obric.autogui.tools.api.net.a.b>> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f29193b, this.f29194c, this.f29195d, this.f29196e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<com.obric.autogui.tools.api.net.a.b>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f29192a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            com.obric.autogui.net.sse.a r2 = new com.obric.autogui.net.sse.a(this.f29193b);
            Context r11 = this.f29194c;
            String r3 = this.f29195d;
            Object r4 = this.f29196e;
            boolean r5 = this.f;
            com.obric.autogui.tools.api.net.a.a r6 = this.g;
            d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<com.obric.autogui.tools.api.net.a.b>> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29192a = 1;
            r10 = r2.a(r11, r3, r4, r5, r6, r7);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ String lambda$F9TZs3acY2h0xQIMbAyWXVklOV0(Map r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$od0b7bXFJUKMvCQQaXDQq2e98c8(String r0) {
        return a(r0);
    }

    @Override // com.obric.autogui.tools.api.net.a
    public Object a(Context r11, String r12, Object r13, int r14, boolean r15, com.obric.autogui.tools.api.net.a.a r16, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<com.obric.autogui.tools.api.net.a.b>> r17) {
        return a(this, (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin"), r12, r13, r14, r15, (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.wrapperContextForParams(r16, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.tools.api.net.a
    public Object a(String r3, String r4, int r5, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r6) {
        return a(this, r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.tools.api.net.a
    public Object a(String r3, Map<String, String> r4, int r5, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r6) {
        return a(this, r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"), r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.tools.api.net.a
    public Object a(String r9, Map<String, String> r10, String r11, int r12, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r13) {
        return a(this, r9, (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin"), r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public Object a(Map<String, String> r10, String r11, String r12, boolean r13, int r14, d.c.d<? super b> r15) {
        return a(this, (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin"), r11, r12, r13, r14, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public a() {
        this.f29162b = new com.obric.autogui.net.ttnet.a.b();
    }

    public static final /* synthetic */ b a(a r6, Map r7, String r8, String r9, boolean r10, int r11) {
        return r6.a((Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11);
    }

    public static final /* synthetic */ com.obric.autogui.net.ttnet.a.b a(a r0) {
        return r0.f29162b;
    }

    public static final /* synthetic */ Object a(a r9, String r10, Map r11, String r12, int r13, boolean r14, d.c.d r15) {
        return r9.a(r10, (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin"), r12, r13, r14, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(a r0, Throwable r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object b(a r9, Map r10, String r11, String r12, boolean r13, int r14, d.c.d r15) {
        return r9.b((Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin"), r11, r12, r13, r14, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AOThreadingTools.SingleThreadCoroutineScopeWrapper c() {
        return f29161c;
    }

    static {
        f29160a = new C0736a(null);
        f29161c = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "ao-ttnet", false, 2, null);
    }

    public final boolean a() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("http_request.log_id.enable", false);
    }

    static /* synthetic */ Object a(a r9, String r10, Map<String, String> r11, String r12, int r13, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r14) {
        return r9.a(r10, (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin"), r12, r13, true, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ Object a(a r6, String r7, String r8, int r9, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r10) {
        return r6.a(r7, ao.a(new d.m[]{s.a(DownloadHelper.CONTENT_TYPE, "application/json"), s.a("X-Tt-Trace", "1")}), r8, r9, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final com.obric.autogui.net.ttnet.a.b b() {
        return this.f29162b;
    }

    private final Object a(String r23, Map<String, String> r24, String r25, int r26, boolean r27, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r28) {
        a r10 = this;
        String r11 = r23;
        Map<String, String> r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.aiagent.plugin");
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, e.class) == false) goto L7;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r1, e.class, "com.obric.aiagent.plugin");
        if ((r2.f & Integer.MIN_VALUE) == 0) goto L7;
        r2.f -= Integer.MIN_VALUE;
    L8:
        e r13 = r2;
        Object r3 = r13.f29175d;
        Object r14 = d.c.a.b.a();
        int r4 = r13.f;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        ca r5 = (ca) ZeusTransformUtils.preCheckCast(r13.f29174c, ca.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r13.f29173b, String.class, "com.obric.aiagent.plugin");
        a r7 = (a) ZeusTransformUtils.preCheckCast(r13.f29172a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: CancellationException -> L14
        r11 = r6;
        r10 = r7;
        String r29 = TAG;
    L30:
        return (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");
    L32:
        CancellationException e2 = e;
    L33:
        Loog.INSTANCE.w(r29, "a TTNet execution to URL=" + r11 + " is cancelled.");
        r5.a(e2);
        return new c(r10, (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));
    L14:
        e2 = e;
        r11 = r6;
        r10 = r7;
        r29 = TAG;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r3);
        Loog r8 = Loog.INSTANCE;
        StringBuilder r9 = new StringBuilder();
        if (r27 == false) goto L21;
        String r12 = CozeCloudExt.API_KEY_HTTP_POST_METHOD;
    L22:
        r8.i(TAG, r9.append(r12).append(" start, url: ").append(r11).toString());
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.autogui.net.ttnet.c.f29240a.a(r0), Iterable.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(n.c(ao.a(p.a(r15, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r17 = r15.iterator();
    L24:
        if (r17.hasNext() == false) goto L26;
        com.bytedance.retrofit2.b.b r18 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r17.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");
        d.m r19 = new d.m(r18.a(), r18.b());
        r16.put(r19.a(), r19.b());
        goto L24
    L26:
        w r20 = y.a(null, 1, null);
        am r110 = an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"));
        r29 = TAG;
        r5 = kotlinx.coroutines.i.a(r110, null, null, (m) ZeusTransformUtils.preCheckCast(new f(this, r16, r25, r23, r27, r26, r20, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        r13.f29172a = r10;     // Catch: CancellationException -> L32
        r13.f29173b = r11;     // Catch: CancellationException -> L32
        r13.f29174c = r5;     // Catch: CancellationException -> L32
        r13.f = 1;     // Catch: CancellationException -> L32
        r3 = r20.a(r13);     // Catch: CancellationException -> L32
        if (r3 != r14) goto L30;
        return r14;
    L21:
        r12 = MonitorConstants.CONNECT_TYPE_GET;
    L7:
        r2 = new e(r10, r1);
        goto L8
    }

    private final Object b(Map<String, String> r15, String r16, String r17, boolean r18, int r19, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r20) {
        boolean r9 = r18;
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L7;
        g r1 = (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.aiagent.plugin");
        if ((r1.f29186e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f29186e -= Integer.MIN_VALUE;
    L8:
        g r7 = r1;
        Object r3 = r7.f29184c;
        Object r11 = d.c.a.b.a();
        int r4 = r7.f29186e;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        boolean r5 = r7.f29183b;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r7.f29182a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L14
        r9 = r5;
    L52:
        b r8 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        Throwable r10 = null;
    L33:
        if (r8 == null) goto L35;
        String r12 = r8.a();
    L36:
        if (r12 != null) goto L46;
        if (r10 != null) goto L45;
        if (r8 == null) goto L41;
        String r13 = r8.b();
    L43:
        return new d(r6, null, r13);
    L41:
        r13 = null;
        goto L43
    L45:
        return new c(r6, r10);
    L46:
        Loog r14 = Loog.INSTANCE;
        StringBuilder r21 = new StringBuilder();
        if (r9 == false) goto L49;
        String r22 = CozeCloudExt.API_KEY_HTTP_POST_METHOD;
    L50:
        r14.i(TAG, r21.append(r22).append(" success!").toString());
        return new d(r6, r8.a(), r8.b());
    L49:
        r22 = MonitorConstants.CONNECT_TYPE_GET;
        goto L50
    L35:
        r12 = null;
    L28:
        th = th;
    L32:
        Loog.INSTANCE.e(TAG, "HTTP request failed. error: ", th);
        r10 = th;
        r8 = null;
    L14:
        th = th;
        r9 = r5;
        goto L32
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r3);
        if (r9 == false) goto L21;
        boolean r23 = true;
    L54:
        r7.f29182a = this;     // Catch: Throwable -> L30
        r7.f29183b = r9;     // Catch: Throwable -> L30
        r7.f29186e = 1;     // Catch: Throwable -> L30
        r3 = a(r2, r16, r17, r23, r19, r7);     // Catch: Throwable -> L30
        if (r3 != r11) goto L25;
        return r11;
    L25:
        r6 = this;
    L30:
        th = th;
        r6 = this;
        goto L32
    L21:
        r23 = false;
    L7:
        r1 = new g(this, r0);
        goto L8
    }

    private final String a(Throwable r3) {
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.net.ttnet.b.b.class) == false) goto L5;
        com.obric.autogui.net.ttnet.b.b r2 = (com.obric.autogui.net.ttnet.b.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.net.ttnet.b.b.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 == null) goto L12;
        Throwable r4 = r2.c();
        if (r4 == null) goto L12;
        r3 = r4;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class) == false) goto L14;
        com.bytedance.frameworks.baselib.network.http.cronet.b.c r5 = (com.bytedance.frameworks.baselib.network.http.cronet.b.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.frameworks.baselib.network.http.cronet.b.c.class, "com.obric.aiagent.plugin");
    L15:
        if (r5 != null) goto L17;
        return null;
    L17:
        com.obric.autogui.net.ttnet.e r6 = com.obric.autogui.net.ttnet.e.f29244a;
        com.bytedance.frameworks.baselib.network.http.b r7 = r5.a();
        if (r7 == null) goto L21;
        r1 = r7.N;
    L21:
        return r6.a(r1);
    L14:
        r5 = null;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    static /* synthetic */ Object a(a r13, Map<String, String> r14, String r15, String r16, boolean r17, int r18, d.c.d<? super b> r19) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        return AOThreadingTools.INSTANCE.runIn((AOThreadingTools.AOThreadLauncher) ZeusTransformUtils.preCheckCast(f29161c, AOThreadingTools.AOThreadLauncher.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new h(r13, r4, r15, r16, r17, r18, null), m.class, "com.obric.aiagent.plugin"), r0);
    }

    private final b a(Map<String, String> r6, final String r7, String r8, boolean r9, int r10) {
        final Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        com.bytedance.common.utility.g r12 = com.bytedance.article.common.network.a.a();
        Loog.INSTANCE.dp(TAG, new $$Lambda$a$F9TZs3acY2h0xQIMbAyWXVklOV0(r11));
        Loog.INSTANCE.dp(TAG, new $$Lambda$a$od0b7bXFJUKMvCQQaXDQq2e98c8(r7));
        Loog.INSTANCE.i(TAG, "execute, url: " + r8);
        if (a() == false) goto L5;
        com.bytedance.common.utility.g.a r5 = (com.bytedance.common.utility.g.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.net.ttnet.b.d(), com.bytedance.common.utility.g.a.class, "com.obric.aiagent.plugin");
    L6:
        String r1 = null;
        if (r9 == false) goto L12;
        if (r7 == null) goto L10;
        byte[] r13 = r7.getBytes(d.o.d.f38623b);
        o.c(r13, "getBytes(...)");
    L11:
        String r14 = r12.a(r8, r13, r11, r5);
    L14:
        if (ZeusTransformUtils.instanceOf(r5, com.obric.autogui.net.ttnet.b.d.class) == false) goto L16;
        com.obric.autogui.net.ttnet.b.d r15 = (com.obric.autogui.net.ttnet.b.d) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.net.ttnet.b.d.class, "com.obric.aiagent.plugin");
    L17:
        if (r15 == null) goto L20;
        r1 = r15.f29230b;
    L20:
        return new b(r14, r1);
    L16:
        r15 = null;
        goto L17
    L10:
        r13 = null;
        goto L11
    L12:
        r14 = r12.a(r8, r11, r5);
        goto L14
    L5:
        r5 = new com.bytedance.common.utility.g.a();
        goto L6
    }

    private static final String a(Map r2) {
        return "execute, requestHeaders: " + ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"));
    }

    private static final String a(String r2) {
        return "execute, bodyString: " + r2;
    }

    static /* synthetic */ Object a(a r9, String r10, Map<String, String> r11, int r12, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<String>> r13) {
        return r9.a(r10, (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin"), null, r12, false, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ Object a(a r12, Context r13, String r14, Object r15, int r16, boolean r17, com.obric.autogui.tools.api.net.a.a r18, d.c.d<? super com.obric.autogui.tools.api.net.a.InterfaceC0861a<com.obric.autogui.tools.api.net.a.b>> r19) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.tools.api.net.a.a r8 = (com.obric.autogui.tools.api.net.a.a) ZeusTransformUtils.wrapperContextForParams(r18, com.obric.autogui.tools.api.net.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a(f29161c.getCoroutineScope().a(), (m) ZeusTransformUtils.preCheckCast(new i(r12, r4, r14, r15, r17, r8, null), m.class, "com.obric.aiagent.plugin"), r0);
    }
}
