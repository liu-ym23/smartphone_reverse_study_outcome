package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes4.dex */
public final class CronetUrlRequest extends af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37966a = true;
    private final int A;
    private final h B;
    private CronetUploadDataStream C;
    private ah D;
    private int E;
    private com.ttnet.org.chromium.net.e F;
    private k G;
    private boolean H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private String f37967J;
    private int K;
    private String L;
    private int M;
    private int N;
    private int O;
    private int P;
    private long Q;
    private int R;
    private String S;
    private String T;
    private long U;
    private long V;
    private int W;
    private String X;
    private long Y;
    private long Z;
    private long aa;
    private long ab;
    private long ac;
    private long ad;
    private b ae;
    private Runnable af;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f37968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f37969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37970e;
    private boolean f;
    private boolean g;
    private final Object h;
    private final CronetUrlRequestContext i;
    private final Executor j;
    private final List<String> k;
    private final VersionSafeCallbacks.g l;
    private final String m;
    private final int n;
    private final int o;
    private String p;
    private final HeadersList q;
    private final Collection<Object> r;
    private final boolean s;
    private final boolean t;
    private final boolean u;
    private final int v;
    private final boolean w;
    private final int x;
    private final VersionSafeCallbacks.e y;
    private final long z;

    static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        HeadersList() {
        }
    }

    interface a {
        long a(CronetUrlRequest r1, long r2, String r4, int r5, int r6, boolean r7, boolean r8, boolean r9, int r10, boolean r11, int r12, int r13, long r14);

        void a(long r1, CronetUrlRequest r3);

        void a(long r1, CronetUrlRequest r3, int r4);

        void a(long r1, CronetUrlRequest r3, int r4, int r5, int r6);

        void a(long r1, CronetUrlRequest r3, long r4);

        void a(long r1, CronetUrlRequest r3, VersionSafeCallbacks.UrlRequestStatusListener r4);

        void a(long r1, CronetUrlRequest r3, boolean r4);

        boolean a(long r1, CronetUrlRequest r3, String r4);

        boolean a(long r1, CronetUrlRequest r3, String r4, String r5);

        boolean a(long r1, CronetUrlRequest r3, ByteBuffer r4, int r5, int r6);

        void b(long r1, CronetUrlRequest r3);

        void b(long r1, CronetUrlRequest r3, int r4);

        void b(long r1, CronetUrlRequest r3, String r4, String r5);

        void c(long r1, CronetUrlRequest r3);

        void c(long r1, CronetUrlRequest r3, String r4, String r5);

        void d(long r1, CronetUrlRequest r3);

        void e(long r1, CronetUrlRequest r3);
    }

    private final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ByteBuffer f37988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CronetUrlRequest f37989b;

        private b(CronetUrlRequest r1) {
            this.f37989b = r1;
        }

        /* synthetic */ b(CronetUrlRequest r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37989b.f();
            ByteBuffer r0 = this.f37988a;
            this.f37988a = null;
            Object r1 = CronetUrlRequest.a(this.f37989b);     // Catch: Exception -> L16
            monitor-enter(r1);     // Catch: Exception -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L6:
            if (CronetUrlRequest.b(this.f37989b) == false) goto L9;
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L9:
            CronetUrlRequest.a(this.f37989b, true);     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            VersionSafeCallbacks.g r2 = CronetUrlRequest.d(this.f37989b);     // Catch: Exception -> L16
            CronetUrlRequest r3 = this.f37989b;     // Catch: Exception -> L16
            r2.a(r3, CronetUrlRequest.c(r3), r0);     // Catch: Exception -> L16
            return;
        L16:
            e = move-exception;
            CronetUrlRequest.a(this.f37989b, e);
        }
    }

    static {
    }

    private static int i(int r2) {
        if (r2 != 0) goto L5;
        return 1;
    L5:
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L8;
        return 3;
    L8:
        if (r2 == 4) goto L10;
        return 4;
    L10:
        return 5;
    L14:
        return 2;
    }

    private static int j(int r1) {
        int r0 = 1;
        if (r1 == 1) goto L8;
        r0 = 2;
        if (r1 == 2) goto L8;
        return 0;
    L8:
        return r0;
    }

    static /* synthetic */ Object a(CronetUrlRequest r0) {
        return r0.h;
    }

    static /* synthetic */ void a(CronetUrlRequest r0, int r1) {
        r0.k(r1);
    }

    static /* synthetic */ void a(CronetUrlRequest r0, Exception r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean a(CronetUrlRequest r0, boolean r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ boolean b(CronetUrlRequest r0) {
        return r0.j();
    }

    static /* synthetic */ boolean b(CronetUrlRequest r0, boolean r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ ah c(CronetUrlRequest r0) {
        return r0.D;
    }

    static /* synthetic */ VersionSafeCallbacks.g d(CronetUrlRequest r0) {
        return r0.l;
    }

    static /* synthetic */ CronetUploadDataStream e(CronetUrlRequest r0) {
        return r0.C;
    }

    static /* synthetic */ long f(CronetUrlRequest r2) {
        return r2.f37969d;
    }

    static /* synthetic */ void g(CronetUrlRequest r0) {
        r0.i();
    }

    static /* synthetic */ void h(CronetUrlRequest r0) {
        r0.m();
    }

    static /* synthetic */ com.ttnet.org.chromium.net.e i(CronetUrlRequest r0) {
        return r0.F;
    }

    static /* synthetic */ VersionSafeCallbacks.e j(CronetUrlRequest r0) {
        return r0.y;
    }

    CronetUrlRequest(CronetUrlRequestContext r10, String r11, int r12, com.ttnet.org.chromium.net.ai.b r13, Executor r14, Collection<Object> r15, boolean r16, boolean r17, boolean r18, boolean r19, int r20, boolean r21, int r22, com.ttnet.org.chromium.net.w.a r23, int r24, long r25) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r14, Executor.class, "com.obric.aiagent.plugin");
        Collection<Object> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r15, Collection.class, "com.obric.aiagent.plugin");
        this.h = new Object();
        ArrayList r6 = new ArrayList();
        this.k = r6;
        this.q = new HeadersList();
        this.Y = 0;
        this.Z = -1;
        this.aa = -1;
        this.ab = -1;
        this.ac = -1;
        this.ad = -1;
        Objects.requireNonNull(r11, "URL is required");
        Objects.requireNonNull(r13, "Listener is required");
        Objects.requireNonNull(r4, "Executor is required");
        this.f37968c = r18;
        this.i = r10;
        this.A = r10.n();
        this.B = r10.o();
        this.m = r11;
        r6.add(r11);
        this.n = i(r12);
        this.l = new VersionSafeCallbacks.g(r13);
        this.j = r4;
        this.r = r5;
        this.s = r16;
        this.t = r17;
        this.u = r19;
        this.v = r20;
        this.w = r21;
        this.x = r22;
        if (r23 == null) goto L5;
        VersionSafeCallbacks.e r1 = new VersionSafeCallbacks.e(r23);
    L6:
        this.y = r1;
        this.o = j(r24);
        this.z = r25;
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void b(String r2) {
        k();
        Objects.requireNonNull(r2, "Method is required.");
        this.p = r2;
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void c(String r2, String r3) {
        k();
        Objects.requireNonNull(r2, "Invalid header name.");
        Objects.requireNonNull(r3, "Invalid header value.");
        this.q.add(new AbstractMap.SimpleImmutableEntry(r2, r3));
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void a(com.ttnet.org.chromium.net.ag r3, Executor r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r3, "Invalid UploadDataProvider.");
        if (this.p != null) goto L5;
        this.p = "POST";
    L5:
        this.C = new CronetUploadDataStream(r3, r5, this);
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void d(int r1) {
        this.M = r1;
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void e(int r1) {
        this.N = r1;
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void f(int r1) {
        this.O = r1;
    }

    @Override // com.ttnet.org.chromium.net.impl.af
    public void g(int r1) {
        this.P = r1;
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(long r9) {
        Object r0 = this.h;
        monitor-enter(r0);
        this.Q = r9;     // Catch: Throwable -> L9
        if (this.f37969d == 0) goto L7;
        n.a().a(this.f37969d, this, r9);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(int r2) {
        this.R = r2 | this.R;
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void b(String r8, String r9) {
        Object r0 = this.h;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f37969d != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        n.a().b(this.f37969d, this, r8, r9);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void d() {
        Object r0 = this.h;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f37969d != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        n.a().e(this.f37969d, this);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void c() {
        o.a(this.f37967J);
        Object r0 = this.h;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f37969d != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        n.a().c(this.f37969d, this);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void b(int r1) {
        this.K = r1;
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void b(long r1) {
        this.U = r1;
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void c(long r1) {
        this.V = r1;
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void c(int r1) {
        this.W = r1;
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(String r1) {
        this.X = r1;
    }

    private String[] addSecurityFactor(String r6, String[] r7) {
        HashMap r0 = new HashMap();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0.put(r7[r2].toLowerCase(Locale.US), r7[r2 + 1]);
        r2 = r2 + 2;
        goto L4
    L6:
        Map<String, String> r5 = this.i.a(r6, r0);
        if (r5 != null) goto L10;
        return null;
    L10:
        String[] r8 = new String[r5.size() * 2];
        Iterator<Map.Entry<String, String>> r9 = r5.entrySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8[r1] = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.aiagent.plugin");
        r8[r1 + 1] = (String) ZeusTransformUtils.preCheckCast(r10.getValue(), String.class, "com.obric.aiagent.plugin");
        r1 = r1 + 2;
        goto L12
    L14:
        return r8;
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(String r1, String r2) {
        this.S = r1;
        this.T = r2;
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(String r2, Throwable r3) {
        a(new e(r2, r3));
    }

    private void g() {
        this.Y++;
        long r0 = System.nanoTime();
        this.aa = r0;
        if (this.Z != (-1)) goto L5;
        this.Z = r0;
    L5:
        long r2 = this.ab;
        if (r2 != (-1)) goto L8;
        return;
    L8:
        if (this.ad != (-1)) goto L10;
        this.ad = 0;
    L10:
        this.ad += r0 - r2;
    }

    private void h() {
        if (this.aa == (-1)) goto L9;
        long r0 = System.nanoTime();
        this.ab = r0;
        if (this.ac != (-1)) goto L7;
        this.ac = 0;
    L7:
        this.ac += r0 - this.aa;
        this.aa = -1;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest$a] */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest$a] */
    /* JADX WARN: Type inference failed for: r0v35, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest$a] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest] */
    /* JADX WARN: Type inference failed for: r8v7 */
    @Override // com.ttnet.org.chromium.net.ai
    public void a() {
        Object r14 = this.h;
        monitor-enter(r14);
        k();     // Catch: Throwable -> L76
    L90:
    L86:
        final ?? r8 = this;
        r8.f37969d = n.a().a(this, this.i.t(), this.m, this.n, this.K, this.s, this.t, this.u, this.v, this.w, this.x, this.o, this.z);     // Catch: RuntimeException -> L63 Throwable -> L80
        r8.i.r();     // Catch: RuntimeException -> L63 Throwable -> L80
        if (r8.p != null) goto L14;
    L18:
        Iterator<Map.Entry<String, String>> r7 = r8.q.iterator();     // Catch: RuntimeException -> L63 Throwable -> L80
        boolean r13 = false;
    L20:
        if (r7.hasNext() == false) goto L36;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L63 Throwable -> L80
        if (((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase(DownloadHelper.CONTENT_TYPE) == false) goto L27;
        if (((String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L27;
        r13 = true;
    L27:
        if (((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase("Tt-Map-Key") == false) goto L32;
        if (((String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L32;
        r8.f37967J = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: RuntimeException -> L63 Throwable -> L80
    L32:
        if (n.a().a(r8.f37969d, this, (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin")) == true) goto L20;
        throw new IllegalArgumentException("Invalid header " + ((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin")) + "=" + ((String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin")));     // Catch: RuntimeException -> L63 Throwable -> L80
    L36:
        n.a().a(r8.f37969d, this, r8.M, r8.N, r8.O);     // Catch: RuntimeException -> L63 Throwable -> L80
        ?? r1 = n.a();     // Catch: RuntimeException -> L63 Throwable -> L80
        long r2 = r8.f37969d;     // Catch: RuntimeException -> L63 Throwable -> L80
        r1.a(r2, r8, r8.P);     // Catch: RuntimeException -> L63 Throwable -> L80
        ?? r3 = r2;
        if (r8.Q <= 0) goto L39;
        a r4 = n.a();     // Catch: RuntimeException -> L63 Throwable -> L80
        r4.a(r8.f37969d, this, r8.Q);     // Catch: RuntimeException -> L63 Throwable -> L80
        r3 = r4;
    L39:
        ?? r5 = r3;
        if (r8.R <= 0) goto L42;
        ?? r6 = n.a();     // Catch: RuntimeException -> L63 Throwable -> L80
        long r9 = r8.f37969d;     // Catch: RuntimeException -> L63 Throwable -> L80
        r6.b(r9, r8, r8.R);     // Catch: RuntimeException -> L63 Throwable -> L80
        r5 = r9;
    L42:
        ?? r10 = r5;
        if (r8.S == null) goto L47;
        r10 = r5;
        if (r8.T == null) goto L47;
        a r11 = n.a();     // Catch: RuntimeException -> L63 Throwable -> L80
        r11.c(r8.f37969d, this, r8.S, r8.T);     // Catch: RuntimeException -> L63 Throwable -> L80
        r10 = r11;
    L47:
        CronetUploadDataStream r12 = r8.C;     // Catch: RuntimeException -> L63 Throwable -> L80
        if (r12 == null) goto L60;
        if (r13 == false) goto L58;
        r8.f37970e = true;     // Catch: RuntimeException -> L54 Throwable -> L80
        r12.a(new AnonymousClass1(r8));     // Catch: RuntimeException -> L54 Throwable -> L80
        monitor-exit(r14);     // Catch: Throwable -> L80
        return;
    L58:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");     // Catch: RuntimeException -> L54 Throwable -> L80
    L54:
        e = e;
    L74:
        r8.k(r10);     // Catch: Throwable -> L80
        throw e;     // Catch: Throwable -> L80
    L60:
        r8.f37970e = true;     // Catch: Throwable -> L80
        i();     // Catch: Throwable -> L80
        monitor-exit(r14);     // Catch: Throwable -> L80
        return;
    L14:
        if (n.a().a(r8.f37969d, r8, r8.p) == true) goto L18;
        throw new IllegalArgumentException("Invalid http method " + r8.p);     // Catch: RuntimeException -> L63 Throwable -> L80
    L63:
        e = e;
        r8 = r8;
    L73:
        r10 = 1;
    L65:
        e = e;
        r10 = 1;
        r8 = this;
    L69:
        e = e;
        r8 = this;
    L67:
        th = th;
        Object r17 = r14;
    L78:
        monitor-exit(r17);     // Catch: Throwable -> L80
        throw th;
    L71:
        e = e;
        r8 = this;
    L76:
        th = th;
        r17 = r14;
    L80:
        th = th;
        goto L78
    }

    private void i() {
        String r0 = this.f37967J;
        if (r0 == null) goto L5;
        o.a(r0, this);
    L5:
        n.a().a(this.f37969d, this);
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void b() {
        Object r0 = this.h;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f == false) goto L14;
        this.f = false;     // Catch: Throwable -> L15
        if (j() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L10:
        n.a().b(this.f37969d, this);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L14:
        throw new IllegalStateException("No redirect to follow.");     // Catch: Throwable -> L15
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void a(ByteBuffer r9) {
        x.b(r9);
        x.a(r9);
        Object r0 = this.h;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L17;
        this.g = false;     // Catch: Throwable -> L18
        if (j() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L10:
        g();     // Catch: Throwable -> L18
        if (n.a().a(this.f37969d, this, r9, r9.position(), r9.limit()) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L14:
        this.g = true;     // Catch: Throwable -> L18
        h();     // Catch: Throwable -> L18
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L18
    L17:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L18
    }

    @Override // com.ttnet.org.chromium.net.ai
    public void e() {
        Object r0 = this.h;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (j() == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.f37970e == false) goto L12;
        k(2);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    private boolean j() {
        if (this.f37970e == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f37969d != 0) goto L7;
        return true;
    }

    public void a(com.ttnet.org.chromium.net.ai.c r6) {
        final VersionSafeCallbacks.UrlRequestStatusListener r0 = new VersionSafeCallbacks.UrlRequestStatusListener(r6);
        Object r7 = this.h;
        monitor-enter(r7);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f37969d == 0) goto L9;
        n.a().a(this.f37969d, this, r0);     // Catch: Throwable -> L12
        monitor-exit(r7);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(r7);     // Catch: Throwable -> L12
        a(new AnonymousClass2(this, r0));
    }

    private void a(Runnable r4) {
        this.j.execute((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Exception posting task to executor", new Object[]{e});
        a(new e("Exception posting task to executor", e));
    }

    static long a(Map<String, List<String>> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        long r2 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        Iterator r8 = r7.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L18;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        r2 = r2 + ((long) r4.length());
    L12:
        if (r0.getValue() == null) goto L7;
        Iterator r1 = ((List) ZeusTransformUtils.preCheckCast(r0.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r1.hasNext() == false) goto L7;
        r2 = r2 + ((long) ((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin")).length());
        goto L16
    L18:
        return r2;
    }

    static long a(HeadersList r7) {
        long r0 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, String>> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L12;
        r0 = r0 + ((long) r3.length());
    L12:
        if (((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")) == null) goto L7;
        r0 = r0 + ((long) ((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")).length());
        goto L7
    L14:
        return r0;
    }

    private ah a(int r12, String r13, String[] r14, boolean r15, String r16, String r17, long r18) {
        HeadersList r4 = new HeadersList();
        int r1 = 0;
    L4:
        if (r1 >= r14.length) goto L7;
        r4.add(new AbstractMap.SimpleImmutableEntry(r14[r1], r14[r1 + 1]));
        r1 = r1 + 2;
        goto L4
    L7:
        return new ah(new ArrayList(this.k), r12, r13, r4, r15, r16, r17, r18);
    }

    private void k() {
        Object r0 = this.h;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f37970e == true) goto L11;
        if (j() == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L11:
        throw new IllegalStateException("Request is already started.");     // Catch: Throwable -> L12
    }

    private void k(int r8) {
        boolean r1 = true;
        if (f37966a == false) goto L5;
    L10:
        this.E = r8;
        if (this.f37969d != 0) goto L13;
        return;
    L13:
        this.i.s();
        a r0 = n.a();
        long r2 = this.f37969d;
        if (r8 == 2) goto L17;
        r1 = false;
    L17:
        r0.a(r2, this, r1);
        this.f37969d = 0;
        return;
    L5:
        if (this.F == null) goto L10;
        if (r8 == 1) goto L10;
        throw new AssertionError();
    }

    private void a(Exception r5) {
        com.ttnet.org.chromium.net.impl.b r0 = new com.ttnet.org.chromium.net.impl.b("Exception received from UrlRequest.Callback", r5);
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Exception in CalledByNative method", new Object[]{r5});
        a(r0);
    }

    void a(Throwable r5) {
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Exception in upload method", new Object[]{r5});
        Object r6 = this.h;
        monitor-enter(r6);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f37969d != 0) goto L8;
        monitor-exit(r6);     // Catch: Throwable -> L11
        return;
    L8:
        n.a().d(this.f37969d, this);     // Catch: Throwable -> L11
        monitor-exit(r6);     // Catch: Throwable -> L11
    }

    private void a(com.ttnet.org.chromium.net.e r3) {
        Object r0 = this.h;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (j() == false) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L9:
        if (f37966a == false) goto L11;
    L15:
        this.F = r3;     // Catch: Throwable -> L18
        k(1);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L11:
        if (this.F == null) goto L15;
        throw new AssertionError();     // Catch: Throwable -> L18
    }

    private void onRedirectReceived(final String r12, int r13, String r14, String[] r15, boolean r16, String r17, String r18, long r19, final String r21) {
        final ah r0 = a(r13, r14, r15, r16, r17, r18, r19);
        this.D = r0;
        this.k.add(r12);
        a(new AnonymousClass3(this, r0, r12, r21));
    }

    private void onResponseStarted(int r1, String r2, String[] r3, boolean r4, String r5, String r6, long r7, final String r9) {
        this.D = a(r1, r2, r3, r4, r5, r6, r7);
        a(new AnonymousClass4(this, r9));
    }

    private void onReadCompleted(ByteBuffer r2, int r3, int r4, int r5, long r6) {
        this.D.a(r6);
        AnonymousClass1 r7 = null;
        if (r2.position() == r4) goto L5;
    L12:
        a(new e("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r2.limit() != r5) goto L12;
        if (this.ae != null) goto L10;
        this.ae = new b(this, r7);
    L10:
        r2.position(r4 + r3);
        this.ae.f37988a = r2;
        h();
        a(this.ae);
    }

    private void onSucceeded(long r2) {
        this.D.a(r2);
        o.a(this.f37967J);
        Runnable r3 = new AnonymousClass5(this);
        h();
        a(r3);
    }

    private void onError(int r2, int r3, int r4, String r5, long r6) {
        ah r0 = this.D;
        if (r0 == null) goto L5;
        r0.a(r6);
    L5:
        o.a(this.f37967J);
        if (r2 != 10) goto L8;
    L11:
        a(new y("Exception in CronetUrlRequest: " + r5, r2, r3, r4));
        return;
    L8:
        if (r2 == 3) goto L11;
        a(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r5, l(r2), r3));
    }

    private void onCanceled() {
        o.a(this.f37967J);
        Runnable r0 = new AnonymousClass6(this);
        h();
        a(r0);
    }

    private void onStatus(final VersionSafeCallbacks.UrlRequestStatusListener r2, final int r3) {
        a(new AnonymousClass7(this, r2, r3));
    }

    private void onMetricsCollected(long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, boolean r78, long r79, long r81, String r83, long r84, long r86, String r88, String r89, String r90, String r91, boolean r92, boolean r93, int r94, boolean r95, boolean r96) {
        Object r1 = this.h;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.G != null) goto L10;
        k r2 = new k(r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r79, r81, r83, r84, r86, r88, r89, this.U, this.V, this.W, this.X, r92, r93, r94);     // Catch: Throwable -> L11
        this.G = r2;     // Catch: Throwable -> L11
        r2.a(r91);     // Catch: Throwable -> L11
        this.L = r90;     // Catch: Throwable -> L11
        this.H = r95;     // Catch: Throwable -> L11
        this.I = r96;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L11
    }

    private void onNativeAdapterDestroyed() {
        Object r0 = this.h;
        monitor-enter(r0);
        Runnable r1 = this.af;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        r1.run();     // Catch: Throwable -> L18
    L8:
        if (this.F != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L18
        Runnable r2 = new AnonymousClass8(this);
        h();     // Catch: RejectedExecutionException -> L15
        this.j.execute(r2);     // Catch: RejectedExecutionException -> L15
        return;
    L15:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Exception posting task to executor", new Object[]{e});
        return;
    L18:
        th = move-exception;
        throw th;
    }

    void f() {
        if (this.f37968c == false) goto L5;
        return;
    L5:
        if (this.i.a(Thread.currentThread()) == true) goto L8;
        return;
    L8:
        throw new com.ttnet.org.chromium.net.l();
    }

    private int l(int r3) {
        switch(r3) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L7;
            case 11: goto L5;
            default: goto L3;
        };
    L3:
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Unknown error code: " + r3, new Object[0]);
        return r3;
    L5:
        return 11;
    L7:
        return 10;
    L9:
        return 9;
    L11:
        return 8;
    L13:
        return 7;
    L15:
        return 6;
    L17:
        return 5;
    L19:
        return 4;
    L21:
        return 3;
    L23:
        return 2;
    L25:
        return 1;
    }

    private h.c l() {
        boolean r1 = f37966a;
        if (r1 == false) goto L5;
    L9:
        if (r1 == false) goto L11;
    L15:
        ah r2 = this.D;
        boolean r3 = false;
        if (r2 == null) goto L18;
        Map<String, List<String>> r4 = r2.d();
        String r5 = this.D.h();
        String r15 = r5;
        int r12 = this.D.a();
        r3 = this.D.g();
    L19:
        long r6 = this.G.q().longValue();
        if (r3 == true) goto L22;
    L24:
        long r7 = a(this.q);
        long r9 = Math.max(0, r6 - r7);
    L25:
        long r8 = this.G.J().longValue();
        if (r3 == true) goto L28;
    L30:
        long r10 = a(r4);
        long r13 = Math.max(0, r8 - r10);
    L32:
        if (this.G.a() != null) goto L34;
    L36:
        Duration r11 = Duration.ofSeconds(0);
    L37:
        Duration r16 = r11;
        if (this.G.a() != null) goto L40;
    L42:
        Duration r14 = Duration.ofSeconds(0);
    L44:
        return new h.c(r7, r9, r10, r13, r12, r16, r14, r15, this.H, this.I);
    L40:
        if (this.G.m() == null) goto L42;
        r14 = Duration.ofMillis(this.G.m().getTime() - this.G.a().getTime());
        goto L44
    L34:
        if (this.G.l() == null) goto L36;
        r11 = Duration.ofMillis(this.G.l().getTime() - this.G.a().getTime());
        goto L37
    L28:
        if (r8 != 0) goto L30;
        r10 = 0;
        r13 = 0;
        goto L32
    L22:
        if (r6 != 0) goto L24;
        r7 = 0;
        r9 = 0;
        goto L25
    L18:
        r4 = Collections.emptyMap();
        r12 = 0;
        r15 = "";
        goto L19
    L11:
        if (this.q != null) goto L15;
        throw new AssertionError();
    L5:
        if (this.G != null) goto L9;
        throw new AssertionError();
    }

    private void m() {
        if (this.G != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L19;
    L10:
        this.G.a(this.Y, this.Z, this.ab, this.ac, this.ad);
        final z r0 = new z(this.m, this.r, this.G, this.E, this.D, this.F);
        this.i.a(r0);
        VersionSafeCallbacks.e r3 = this.y;
        if (r3 == null) goto L22;
        r3.a().execute(new AnonymousClass9(this, r0));     // Catch: RejectedExecutionException -> L14
        return;
    L14:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Exception posting task to executor", new Object[]{e});
        return;
    L22:
        return;
    L19:
        this.B.a(this.A, l());     // Catch: RuntimeException -> L8
    L8:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Error while trying to log CronetTrafficInfo: ", new Object[]{e});
        goto L10
    }
}
