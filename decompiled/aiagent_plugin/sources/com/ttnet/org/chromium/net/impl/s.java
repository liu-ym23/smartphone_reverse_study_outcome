package com.ttnet.org.chromium.net.impl;

import android.net.TrafficStats;
import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ttnet.org.chromium.net.aj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: JavaUrlRequest.java */
/* JADX INFO: loaded from: classes4.dex */
final class s extends af {
    private static final String TAG = "s";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f38177a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f38178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f38179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, String> f38180e;
    private final List<String> f;
    private final AtomicInteger g;
    private final AtomicBoolean h;
    private final boolean i;
    private String j;
    private VersionSafeCallbacks.f k;
    private Executor l;
    private volatile int m;
    private String n;
    private ReadableByteChannel o;
    private ah p;
    private String q;
    private HttpURLConnection r;
    private b s;
    private final int t;
    private final h u;

    /* JADX INFO: compiled from: JavaUrlRequest.java */
    private final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ boolean f38207d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final VersionSafeCallbacks.g f38208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f38209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Executor f38210c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ s f38211e;

        static {
            f38207d = true;
        }

        static /* synthetic */ void a(a r0) {
            r0.b();
        }

        a(s r3, com.ttnet.org.chromium.net.ai.b r4, Executor r5) {
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
            this.f38211e = r3;
            this.f38208a = new VersionSafeCallbacks.g(r4);
            if (s.s(r3) == false) goto L5;
            this.f38209b = r6;
            this.f38210c = null;
            return;
        L5:
            this.f38209b = new t.b(r6);
            this.f38210c = r6;
        }

        void a(t.a r3) {
            t.a r4 = (t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin");
            this.f38209b.execute(s.c(this.f38211e, r4));     // Catch: RejectedExecutionException -> L5
            return;
        L5:
            e = move-exception;
            s.a(this.f38211e, new e("Exception posting task to executor", e));
        }

        void a(final aj r2, final String r3) {
            a(new AnonymousClass1(this, r2, r3));
        }

        void a(aj r1) {
            a(new AnonymousClass2(this));
        }

        void a(final aj r2, final ByteBuffer r3) {
            a(new AnonymousClass3(this, r2, r3));
        }

        private h.c a() {
            if (f38207d == true) goto L10;
            if (s.l(this.f38211e) != null) goto L10;
            throw new AssertionError();
        L10:
            if (s.g(this.f38211e) == null) goto L12;
            Map<String, List<String>> r1 = s.g(this.f38211e).d();
            String r3 = s.g(this.f38211e).h();
            int r4 = s.g(this.f38211e).a();
            boolean r5 = s.g(this.f38211e).g();
            String r15 = r3;
            int r12 = r4;
        L14:
            if (r5 == false) goto L16;
            long r8 = 0;
            long r10 = 0;
        L17:
            if (r5 == false) goto L19;
            long r0 = 0;
            long r13 = 0;
        L24:
            return new h.c(r8, r10, r13, r0, r12, Duration.ofSeconds(0), Duration.ofSeconds(0), r15, false, false);
        L19:
            r13 = s.a(r1);
            if (r1.containsKey(DownloadUtils.CONTENT_LENGTH) == false) goto L22;
            r0 = s.c((String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r1.get(DownloadUtils.CONTENT_LENGTH), List.class, "com.obric.aiagent.plugin")).get(0), String.class, "com.obric.aiagent.plugin"));
            goto L24
        L22:
            r0 = -1;
            goto L24
        L16:
            r8 = s.b(s.l(this.f38211e));
            r10 = -1;
            goto L17
        L12:
            r1 = Collections.emptyMap();
            r5 = false;
            r12 = 0;
            r15 = "";
            goto L14
        }

        private void b() {
            if (Build.VERSION.SDK_INT < 26) goto L11;
            s.u(this.f38211e).a(s.t(this.f38211e), a());     // Catch: RuntimeException -> L6
            return;
        L6:
            e = move-exception;
            a(s.f(), "Error while trying to log CronetTrafficInfo: ", e);
            return;
        }

        void b(final aj r3) {
            s.v(this.f38211e);
            this.f38209b.execute(new AnonymousClass4(this, r3));
        }

        void c(final aj r3) {
            this.f38209b.execute(new AnonymousClass5(this, r3));
        }

        void a(final aj r2, final com.ttnet.org.chromium.net.e r3) {
            s.v(this.f38211e);
            Runnable r0 = new AnonymousClass6(this, r2, r3);
            this.f38209b.execute(r0);     // Catch: com.ttnet.org.chromium.net.l -> L5
            return;
        L5:
            Executor r1 = this.f38210c;
            if (r1 == null) goto L11;
            r1.execute(r0);
            return;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: JavaUrlRequest.java */
    private final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f38226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HttpURLConnection f38227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f38228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private WritableByteChannel f38229d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private OutputStream f38230e;

        b(s r3, Executor r4, Executor r5, HttpURLConnection r6, VersionSafeCallbacks.f r7) {
            Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
            Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
            this.f38226a = r3;
            super(r8, r9, r7);
            this.f38228c = new AtomicBoolean(false);
            this.f38227b = r6;
        }

        @Override // com.ttnet.org.chromium.net.impl.r
        public void c() {
            if (this.f38229d != null) goto L6;
            s.a(this.f38226a, 10);
            this.f38227b.setDoOutput(true);
            a(this.f38227b);
            s.a(this.f38226a, 12);
            OutputStream r0 = this.f38227b.getOutputStream();
            this.f38230e = r0;
            this.f38229d = Channels.newChannel(r0);
            return;
        }

        void d() {
            if (this.f38229d != null) goto L5;
            return;
        L5:
            if (this.f38228c.compareAndSet(false, true) == false) goto L9;
            this.f38229d.close();
            return;
        }

        @Override // com.ttnet.org.chromium.net.impl.r
        public void b() {
            d();
            s.a(this.f38226a);
        }

        @Override // com.ttnet.org.chromium.net.impl.r
        public void a(long r3) {
            if (r3 <= 0) goto L5;
            this.f38227b.setFixedLengthStreamingMode(r3);
            return;
        L5:
            this.f38227b.setChunkedStreamingMode(8192);
        }

        @Override // com.ttnet.org.chromium.net.impl.r
        public int a(ByteBuffer r3) {
            int r0 = 0;
        L4:
            if (r3.hasRemaining() == false) goto L6;
            r0 = r0 + this.f38229d.write(r3);
            goto L4
        L6:
            this.f38230e.flush();
            return r0;
        }

        @Override // com.ttnet.org.chromium.net.impl.r
        public Runnable a(t.a r3) {
            t.a r4 = (t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin");
            return s.a(this.f38226a, r4);
        }

        @Override // com.ttnet.org.chromium.net.impl.r
        public Runnable b(t.a r3) {
            t.a r4 = (t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin");
            return s.b(this.f38226a, r4);
        }

        @Override // com.ttnet.org.chromium.net.impl.r
        public void a(Throwable r1) {
            s.a(this.f38226a, r1);
        }

        @Skip({"com.obric.aiagent.okhttp"})
        public static void a(HttpURLConnection r4) {
            if (ZeusTransformUtils.instanceOf(r4, HttpURLConnection.class) == false) goto L11;
            URL r0 = ((HttpURLConnection) ZeusTransformUtils.preCheckCast(r4, HttpURLConnection.class, "com.obric.aiagent.plugin")).getURL();
            if (r0 == null) goto L11;
            String r1 = r0.getHost();
            String r2 = r0.getPath();
            if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L11;
            ILogDepend.Companion.i("AiAgentHucConnect", "huc connect drop " + r1 + r2);
            com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
            throw new IOException("[NetGuard] dropped ");
        L11:
            r4.connect();
        }
    }

    /* JADX INFO: compiled from: JavaUrlRequest.java */
    private static final class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f38231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f38232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayDeque<Runnable> f38233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f38234d;

        static /* synthetic */ ArrayDeque a(c r0) {
            return r0.f38233c;
        }

        static /* synthetic */ boolean a(c r0, boolean r1) {
            r0.f38234d = r1;
            return r1;
        }

        static /* synthetic */ boolean b(c r0) {
            return r0.f38234d;
        }

        static /* synthetic */ Runnable c(c r0) {
            return r0.f38232b;
        }

        static /* synthetic */ Executor d(c r0) {
            return r0.f38231a;
        }

        c(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            this.f38232b = new AnonymousClass1(this);
            this.f38233c = new ArrayDeque();
            this.f38231a = r4;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
            ArrayDeque<Runnable> r0 = this.f38233c;
            monitor-enter(r0);
            this.f38233c.addLast(r4);     // Catch: Throwable -> L10
            this.f38231a.execute(this.f38232b);     // Catch: RejectedExecutionException -> L7 Throwable -> L10
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L7:
            this.f38233c.removeLast();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(long r1) {
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(String r1) {
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(String r1, String r2) {
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void b(long r1) {
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void b(String r1, String r2) {
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void c(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void c(long r1) {
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void d() {
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void d(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void e(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void f(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void g(int r1) {
    }

    static /* synthetic */ int a(s r0, int r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ ah a(s r0, ah r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ b a(s r0, b r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ Runnable a(s r2, t.a r3) {
        return r2.a((t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ String a(s r0, String r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ HttpURLConnection a(s r0, HttpURLConnection r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ ReadableByteChannel a(s r2, ReadableByteChannel r3) {
        ReadableByteChannel r4 = (ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, ReadableByteChannel.class, "com.obric.aiagent.plugin");
        r2.o = r4;
        return r4;
    }

    static /* synthetic */ void a(s r0) {
        r0.h();
    }

    static /* synthetic */ void a(s r2, int r3, int r4, Runnable r5) {
        r2.a(r3, r4, (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void a(s r0, int r1, ByteBuffer r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(s r0, com.ttnet.org.chromium.net.e r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(s r0, Throwable r1) {
        r0.b(r1);
    }

    static /* synthetic */ Runnable b(s r2, t.a r3) {
        return r2.c((t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ String b(s r0) {
        return r0.n;
    }

    static /* synthetic */ String b(s r0, String r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ void b(s r0, Throwable r1) {
        r0.c(r1);
    }

    static /* synthetic */ long c(String r2) {
        return f(r2);
    }

    static /* synthetic */ Runnable c(s r2, t.a r3) {
        return r2.b((t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ List c(s r0) {
        return r0.f;
    }

    static /* synthetic */ void c(s r0, String r1) {
        r0.e(r1);
    }

    static /* synthetic */ void c(s r0, Throwable r1) {
        r0.a(r1);
    }

    static /* synthetic */ String d(s r0, String r1) {
        r0.j = r1;
        return r1;
    }

    static /* synthetic */ void d(s r0) {
        r0.j();
    }

    static /* synthetic */ String e(s r0) {
        return r0.q;
    }

    static /* synthetic */ String f() {
        return TAG;
    }

    static /* synthetic */ HttpURLConnection f(s r0) {
        return r0.r;
    }

    static /* synthetic */ ah g(s r0) {
        return r0.p;
    }

    static /* synthetic */ void h(s r0) {
        r0.i();
    }

    static /* synthetic */ a i(s r0) {
        return r0.f38177a;
    }

    static /* synthetic */ VersionSafeCallbacks.f j(s r0) {
        return r0.k;
    }

    static /* synthetic */ AtomicInteger k(s r0) {
        return r0.g;
    }

    static /* synthetic */ Map l(s r0) {
        return r0.f38180e;
    }

    static /* synthetic */ String m(s r0) {
        return r0.f38179d;
    }

    static /* synthetic */ String n(s r0) {
        return r0.j;
    }

    static /* synthetic */ Executor o(s r0) {
        return r0.l;
    }

    static /* synthetic */ Executor p(s r0) {
        return r0.f38178c;
    }

    static /* synthetic */ b q(s r0) {
        return r0.s;
    }

    static /* synthetic */ ReadableByteChannel r(s r0) {
        return r0.o;
    }

    static /* synthetic */ boolean s(s r0) {
        return r0.i;
    }

    static /* synthetic */ int t(s r0) {
        return r0.t;
    }

    static /* synthetic */ h u(s r0) {
        return r0.u;
    }

    static /* synthetic */ void v(s r0) {
        r0.l();
    }

    s(JavaCronetEngine r11, com.ttnet.org.chromium.net.ai.b r12, Executor r13, Executor r14, String r15, String r16, boolean r17, boolean r18, int r19, final boolean r20, final int r21) {
        final Executor r3 = (Executor) ZeusTransformUtils.wrapperContextForParams(r13, Executor.class, "com.obric.aiagent.plugin");
        Executor r1 = (Executor) ZeusTransformUtils.wrapperContextForParams(r14, Executor.class, "com.obric.aiagent.plugin");
        this.f38180e = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.f = new ArrayList();
        this.g = new AtomicInteger(0);
        this.h = new AtomicBoolean(false);
        this.m = -1;
        Objects.requireNonNull(r15, "URL is required");
        Objects.requireNonNull(r12, "Listener is required");
        Objects.requireNonNull(r3, "Executor is required");
        Objects.requireNonNull(r1, "userExecutor is required");
        this.i = r17;
        this.f38177a = new a(this, r12, r1);
        if (r18 == false) goto L5;
        int r4 = r19;
    L6:
        final int r5 = r4;
        this.f38178c = new c(new AnonymousClass1(this, r3, r5, r20, r21));
        this.t = r11.n();
        this.u = r11.o();
        this.n = r15;
        this.f38179d = r16;
        return;
    L5:
        r4 = TrafficStats.getThreadStatsTag();
        goto L6
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void b(String r3) {
        g();
        Objects.requireNonNull(r3, "Method is required.");
        if ("OPTIONS".equalsIgnoreCase(r3) == false) goto L5;
    L21:
        this.j = r3;
        return;
    L5:
        if ("GET".equalsIgnoreCase(r3) == true) goto L21;
        if ("HEAD".equalsIgnoreCase(r3) == true) goto L21;
        if ("POST".equalsIgnoreCase(r3) == true) goto L21;
        if ("PUT".equalsIgnoreCase(r3) == true) goto L21;
        if ("DELETE".equalsIgnoreCase(r3) == true) goto L21;
        if ("TRACE".equalsIgnoreCase(r3) == true) goto L21;
        if ("PATCH".equalsIgnoreCase(r3) == true) goto L21;
        throw new IllegalArgumentException("Invalid http method " + r3);
    }

    private void g() {
        int r3 = this.g.get();
        if (r3 != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Request is already started. State is: " + r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void c(String r3, String r4) {
        g();
        if (d(r3) == false) goto L12;
        if (r4.contains("\r\n") == true) goto L12;
        if (this.f38180e.containsKey(r3) == false) goto L9;
        this.f38180e.remove(r3);
    L9:
        this.f38180e.put(r3, r4);
        return;
    L12:
        throw new IllegalArgumentException("Invalid header " + r3 + "=" + r4);
    }

    private boolean d(String r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length()) goto L23;
        char r1 = r4.charAt(r0);
        if (r1 == ',') goto L22;
        if (r1 == '/') goto L22;
        if (r1 == '{') goto L22;
        if (r1 == '}') goto L22;
        switch(r1) {
            case 39: goto L22;
            case 40: goto L22;
            case 41: goto L22;
            default: goto L14;
        };
    L14:
        switch(r1) {
            case 58: goto L22;
            case 59: goto L22;
            case 60: goto L22;
            case 61: goto L22;
            case 62: goto L22;
            case 63: goto L22;
            case 64: goto L22;
            default: goto L15;
        };
    L15:
        switch(r1) {
            case 91: goto L22;
            case 92: goto L22;
            case 93: goto L22;
            default: goto L17;
        };
    L17:
        if (Character.isISOControl(r1) == true) goto L22;
        if (Character.isWhitespace(r1) == true) goto L22;
        r0 = r0 + 1;
    L22:
        return false;
    L23:
        return true;
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void a(com.ttnet.org.chromium.net.ag r3, Executor r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r3, "Invalid UploadDataProvider.");
        if (this.f38180e.containsKey(DownloadHelper.CONTENT_TYPE) == false) goto L13;
        g();
        if (this.j != null) goto L7;
        this.j = "POST";
    L7:
        this.k = new VersionSafeCallbacks.f(r3);
        if (this.i == false) goto L10;
        this.l = r5;
        return;
    L10:
        this.l = new t.b(r5);
        return;
    L13:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a() {
        this.m = 10;
        a(0, 1, new AnonymousClass6(this));
    }

    private void a(com.ttnet.org.chromium.net.e r2) {
        if (i(6) == false) goto L6;
        k();
        i();
        this.f38177a.a(this.p, r2);
        return;
    }

    private boolean i(int r3) {
    L2:
        int r0 = this.g.get();
        if (r0 == 0) goto L17;
        if (r0 == 6) goto L14;
        if (r0 == 7) goto L24;
        if (r0 == 8) goto L25;
        if (this.g.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L25:
        return false;
    L24:
        return false;
    L14:
        return false;
    L17:
        throw new IllegalStateException("Can't enter error state before start");
    }

    private void a(Throwable r3) {
        a(new com.ttnet.org.chromium.net.impl.b("Exception received from UrlRequest.Callback", r3));
    }

    private void b(Throwable r3) {
        a(new com.ttnet.org.chromium.net.impl.b("Exception received from UploadDataProvider", r3));
    }

    private void c(Throwable r3) {
        a(new e("System error", r3));
    }

    private void a(int r3, int r4, Runnable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        if (this.g.compareAndSet(r3, r4) == true) goto L11;
        int r2 = this.g.get();
        if (r2 != 8) goto L7;
        return;
    L7:
        if (r2 != 6) goto L10;
        return;
    L10:
        throw new IllegalStateException("Invalid state transition - expected " + r3 + " but was " + r2);
    L11:
        r6.run();
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void b() {
        a(3, 1, new AnonymousClass7(this));
    }

    private void h() {
        this.m = 13;
        this.f38178c.execute(a(new AnonymousClass8(this)));
    }

    private void i() {
        if (this.k != null) goto L5;
        return;
    L5:
        if (this.h.compareAndSet(false, true) == false) goto L14;
        this.l.execute(c(new AnonymousClass9(this)));     // Catch: RejectedExecutionException -> L8
        return;
    L8:
        e = move-exception;
        a(TAG, "Exception when closing uploadDataProvider", e);
        return;
    }

    private void e(final String r3) {
        a(1, 2, new AnonymousClass10(this, r3));
    }

    private void j() {
        this.f38178c.execute(a(new AnonymousClass11(this)));
    }

    private Runnable a(t.a r3) {
        final t.a r4 = (t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin");
        return new AnonymousClass12(this, r4);
    }

    private Runnable b(t.a r3) {
        final t.a r4 = (t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin");
        return new AnonymousClass13(this, r4);
    }

    private Runnable c(t.a r3) {
        final t.a r4 = (t.a) ZeusTransformUtils.wrapperContextForParams(r3, t.a.class, "com.obric.aiagent.plugin");
        return new AnonymousClass2(this, r4);
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(final ByteBuffer r3) {
        x.a(r3);
        x.b(r3);
        a(4, 5, new AnonymousClass3(this, r3));
    }

    private void a(int r2, ByteBuffer r3) {
        if (r2 == (-1)) goto L5;
        this.f38177a.a(this.p, r3);
        return;
    L5:
        ReadableByteChannel r4 = this.o;
        if (r4 == null) goto L9;
        r4.close();
    L9:
        if (this.g.compareAndSet(5, 7) == false) goto L13;
        k();
        this.f38177a.c(this.p);
        return;
    }

    private void k() {
        this.f38178c.execute(new AnonymousClass4(this));
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void e() {
        int r0 = this.g.getAndSet(8);
        if (r0 != 1) goto L5;
    L13:
        k();
        i();
        this.f38177a.b(this.p);
        return;
    L5:
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L13;
        if (r0 == 5) goto L13;
    }

    static long a(Map<String, List<String>> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        long r2 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        Iterator r8 = r7.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L20;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        r2 = r2 + ((long) r4.length());
    L12:
        if (r0.getValue() == null) goto L7;
        Iterator r1 = ((List) ZeusTransformUtils.preCheckCast(r0.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r1.hasNext() == false) goto L7;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        r2 = r2 + ((long) r5.length());
        goto L16
    L20:
        return r2;
    }

    static long b(Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        long r2 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        Iterator r8 = r7.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L11;
        r2 = r2 + ((long) r4.length());
    L11:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        r2 = r2 + ((long) r1.length());
        goto L7
    L14:
        return r2;
    }

    private static long f(String r2) {
        return Long.parseLong(r2);
    L4:
        return 0;
    }

    private void l() {
        this.f38178c.execute(new AnonymousClass5(this));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
