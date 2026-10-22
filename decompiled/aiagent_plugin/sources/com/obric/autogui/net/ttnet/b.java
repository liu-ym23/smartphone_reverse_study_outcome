package com.obric.autogui.net.ttnet;

import com.bytedance.retrofit2.ak;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.b.ae;
import d.h.b.h;
import d.o;
import d.x;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: AOTTNetHttpClientV2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.autogui.net.ttnet.a {
    private static final String TAG = "AO-TTNetC/V2";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f29216b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.net.ttnet.b.e f29217c;

    /* JADX INFO: compiled from: AOTTNetHttpClientV2.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.net.ttnet.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOTTNetHttpClientV2.kt */
    @f(b = "AOTTNetHttpClientV2.kt", c = {34, 94}, d = "executeUnsafe", e = "com.obric.autogui.net.ttnet.AOTTNetHttpClientV2")
    static final class C0739b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f29219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f29220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f29221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f29222e;
        int f;

        C0739b(b r3, d.c.d<? super C0739b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29222e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f29221d = r8;
            this.f |= Integer.MIN_VALUE;
            return this.f29222e.a(null, null, null, false, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOTTNetHttpClientV2.kt */
    @f(b = "AOTTNetHttpClientV2.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.net.ttnet.AOTTNetHttpClientV2$executeUnsafe$4")
    static final class c extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f29224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f29225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.bytedance.retrofit2.e<String> f29226d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f29227e;
        final /* synthetic */ w<com.obric.autogui.net.ttnet.a.b> f;

        c(boolean r3, String r4, com.bytedance.retrofit2.e<String> r5, b r6, w<com.obric.autogui.net.ttnet.a.b> r7, d.c.d<? super c> r8) {
            com.bytedance.retrofit2.e<String> r9 = (com.bytedance.retrofit2.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
            w<com.obric.autogui.net.ttnet.a.b> r10 = (w) ZeusTransformUtils.wrapperContextForParams(r7, w.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29224b = r3;
            this.f29225c = r4;
            this.f29226d = r9;
            this.f29227e = r6;
            this.f = r10;
            super(1, r11);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r10) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f29224b, this.f29225c, this.f29226d, this.f29227e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f29223a != 0) goto L42;
            o.a(r11);
            Loog r12 = Loog.INSTANCE;
            StringBuilder r1 = new StringBuilder().append('[');
            String r4 = "POST";
            if (this.f29224b == false) goto L7;
            String r3 = "POST";
        L8:
            r12.d(b.TAG, r1.append(r3).append("] executing/start=").append(this.f29225c).toString());
            ak<String> r13 = this.f29226d.a();     // Catch: Throwable -> L26
            if (IAppContext.Companion.isDebug() == false) goto L13;
        L14:
            Loog.INSTANCE.d(b.TAG, this.f29225c + " header: " + r13.d());     // Catch: Throwable -> L26
            Loog.INSTANCE.d(b.TAG, this.f29225c + " body: " + ((String) ZeusTransformUtils.preCheckCast(r13.f(), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L26
        L16:
            if (this.f29227e.a() == false) goto L18;
            String r2 = e.f29244a.a(r13.d());     // Catch: Throwable -> L26
        L19:
            com.obric.autogui.net.ttnet.a.b r7 = new com.obric.autogui.net.ttnet.a.b((String) ZeusTransformUtils.preCheckCast(r13.f(), String.class, "com.obric.aiagent.plugin"), r2);     // Catch: Throwable -> L26
            Loog r14 = Loog.INSTANCE;
            StringBuilder r5 = new StringBuilder().append('[');
            if (this.f29224b == true) goto L24;
            r4 = "GET";
        L24:
            r14.d(b.TAG, r5.append(r4).append("] executing/done=").append(this.f29225c).toString());
            this.f.a(r7);
            return x.f38692a;
        L18:
            r2 = null;
            goto L19
        L13:
            if (IAppContext.Companion.isReleaseChannel() == true) goto L16;
        L26:
            th = move-exception;
            this.f.a(th);     // Catch: Throwable -> L34
            x r15 = x.f38692a;     // Catch: Throwable -> L34
            Loog r6 = Loog.INSTANCE;
            StringBuilder r8 = new StringBuilder().append('[');
            if (this.f29224b == true) goto L32;
            r4 = "GET";
        L32:
            r6.d(b.TAG, r8.append(r4).append("] executing/done=").append(this.f29225c).toString());
            return r15;
        L34:
            th = move-exception;
            Loog r9 = Loog.INSTANCE;
            StringBuilder r10 = new StringBuilder().append('[');
            if (this.f29224b == true) goto L39;
            r4 = "GET";
        L39:
            r9.d(b.TAG, r10.append(r4).append("] executing/done=").append(this.f29225c).toString());
            throw th;
        L7:
            r3 = "GET";
            goto L8
        L42:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f29216b = new a(null);
    }

    public static /* synthetic */ String lambda$2MlBkmgIeenYbtJcDJ7IzbxUJlo(String r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$sqhqKSoR0LdL5uk3MMy_CvpJK4M(Map r0) {
        return a(r0);
    }

    public b() {
        this.f29217c = new com.obric.autogui.net.ttnet.b.e();
    }

    @Override // com.obric.autogui.net.ttnet.a
    public Object a(Map<String, String> r18, final String r19, String r20, boolean r21, int r22, d.c.d<? super com.obric.autogui.net.ttnet.a.b> r23) {
        String r8 = r20;
        boolean r9 = r21;
        final Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C0739b.class) == false) goto L7;
        C0739b r4 = (C0739b) ZeusTransformUtils.preCheckCast(r1, C0739b.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        C0739b r11 = r4;
        Object r3 = r11.f29221d;
        Object r12 = d.c.a.b.a();
        int r5 = r11.f;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 != 2) goto L18;
        boolean r6 = r11.f29220c;
        com.bytedance.retrofit2.e<String> r7 = (com.bytedance.retrofit2.e) ZeusTransformUtils.preCheckCast(r11.f29219b, com.bytedance.retrofit2.e.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r11.f29218a, String.class, "com.obric.aiagent.plugin");
        o.a(r3);     // Catch: CancellationException -> L15
        r9 = r6;
        String r24 = TAG;
    L59:
        return (com.obric.autogui.net.ttnet.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.net.ttnet.a.b.class, "com.obric.aiagent.plugin");
    L37:
        e = move-exception;
        CancellationException r13 = e;
        r8 = r10;
    L41:
        Loog r0 = Loog.INSTANCE;
        StringBuilder r14 = new StringBuilder().append('[');
        String r15 = "POST";
        if (r9 == false) goto L44;
        String r16 = "POST";
    L45:
        String r17 = r14.append(r16).append("] executing/cancelled=").append(r8).toString();
        String r25 = r24;
        r0.e(r25, r17);
        r7.b();     // Catch: Throwable -> L48
        throw r13;
    L48:
        th = move-exception;
        Loog r26 = Loog.INSTANCE;
        StringBuilder r27 = new StringBuilder().append('[');
        if (r9 == true) goto L53;
        r15 = "GET";
    L53:
        r26.e(r25, r27.append(r15).append("] while executing cancel(): ").append(th).toString(), th);
        throw r13;
    L44:
        r16 = "GET";
    L15:
        e = move-exception;
        r13 = e;
        r9 = r6;
        r8 = r10;
        r24 = TAG;
        goto L41
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        o.a(r3);
    L25:
        return r3;
    L20:
        o.a(r3);
        if (r9 == true) goto L26;
        r11.f = 1;
        r3 = super.a(r2, r19, r20, false, r22, r11);
        if (r3 != r12) goto L25;
        return r12;
    L26:
        w r110 = y.a(null, 1, null);
        if (ae.i(r2) == false) goto L29;
        Map<String, String> r28 = r2;
    L30:
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$sqhqKSoR0LdL5uk3MMy_CvpJK4M(r2));
        Loog.INSTANCE.dp(TAG, new $$Lambda$b$2MlBkmgIeenYbtJcDJ7IzbxUJlo(r19));
        Loog.INSTANCE.i(TAG, "execute/v2, url: " + r8);
        com.bytedance.retrofit2.e<String> r29 = this.f29217c.a(r28, r19, r8);
        AOThreadingTools.SingleThreadCoroutineScopeWrapper r30 = com.obric.autogui.net.ttnet.a.f29160a.a();
        r24 = TAG;
        r30.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r21, r20, r29, this, r110, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r11.f29218a = r8;     // Catch: CancellationException -> L39
        r11.f29219b = r29;     // Catch: CancellationException -> L39
        r11.f29220c = r9;     // Catch: CancellationException -> L39
        r11.f = 2;     // Catch: CancellationException -> L39
        r3 = r110.a(r11);     // Catch: CancellationException -> L39
        if (r3 != r12) goto L34;
        return r12;
    L34:
        r10 = r8;
        r7 = r29;
    L39:
        e = move-exception;
        r13 = e;
        r7 = r29;
        goto L41
    L29:
        r28 = ao.e(r2);
    L7:
        r4 = new C0739b(this, r1);
        goto L8
    }

    private static final String a(Map r2) {
        return "execute/v2, requestHeaders: " + ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"));
    }

    private static final String a(String r2) {
        return "execute/v2, bodyString: " + r2;
    }
}
