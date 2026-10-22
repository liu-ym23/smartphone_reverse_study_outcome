package com.ttnet.org.chromium.net.impl;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNIAdditionalImport;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.a0;
import com.ttnet.org.chromium.net.y;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes4.dex */
@JNIAdditionalImport({VersionSafeCallbacks.class})
@JNINamespace("cronet")
@VisibleForTesting
public final class CronetUrlRequest extends UrlRequestBase {
    public com.ttnet.org.chromium.net.impl.c A;
    public String B;
    public int C;
    public String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public k f18577J;
    public Runnable K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f18582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f18583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CronetUrlRequestContext f18584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f18585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f18586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final VersionSafeCallbacks.g f18587j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f18588k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f18589l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f18590m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HeadersList f18591n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Collection f18592o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f18593p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f18594q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f18595r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f18596s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f18597t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f18598u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final VersionSafeCallbacks.e f18599v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CronetUploadDataStream f18600w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public t f18601x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f18602y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CronetException f18603z;

    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }

        public /* synthetic */ HeadersList(b r10) {
            this();
        }
    }

    public interface Natives {
        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void abortWhenUploadException(long r10, CronetUrlRequest r11);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void addRequestCookieHeader(long r10, CronetUrlRequest r11, String r12, String r13);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean addRequestHeader(long r10, CronetUrlRequest r11, String r12, String r13);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void appTimeout(long r10, CronetUrlRequest r11);

        long createRequestAdapter(CronetUrlRequest r10, long r11, String r12, int r13, int r14, boolean r15, boolean r16, boolean r17, boolean r18, int r19, boolean r110, int r111);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void destroy(long r10, CronetUrlRequest r11, boolean r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void followDeferredRedirect(long r10, CronetUrlRequest r11);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void getStatus(long r10, CronetUrlRequest r11, VersionSafeCallbacks.UrlRequestStatusListener r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean readData(long r10, CronetUrlRequest r11, ByteBuffer r12, int r13, int r14);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void removeRequestCookieHeader(long r10, CronetUrlRequest r11);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean setHttpMethod(long r10, CronetUrlRequest r11, String r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setRequestTimeout(long r10, CronetUrlRequest r11, int r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setSocketTimeout(long r10, CronetUrlRequest r11, int r12, int r13, int r14);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setThrottleNetSpeed(long r10, CronetUrlRequest r11, long r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void start(long r10, CronetUrlRequest r11);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void stopRedirect(long r10, CronetUrlRequest r11);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ttnet.org.chromium.net.t f18604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18605b;

        public a(CronetUrlRequest r10, com.ttnet.org.chromium.net.t r11) {
            this.f18605b = r10;
            this.f18604a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.w(this.f18605b).onRequestFinished(this.f18604a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18606a;

        public b(CronetUrlRequest r10) {
            this.f18606a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.C(this.f18606a).s();
            Object r10 = CronetUrlRequest.s(this.f18606a);
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (CronetUrlRequest.x(this.f18606a) == false) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            CronetUrlRequest.C(this.f18606a).n(CronetUrlRequest.D(this.f18606a));     // Catch: Throwable -> L8
            CronetUrlRequest.E(this.f18606a);     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VersionSafeCallbacks.UrlRequestStatusListener f18607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18608b;

        public c(CronetUrlRequest r10, VersionSafeCallbacks.UrlRequestStatusListener r11) {
            this.f18608b = r10;
            this.f18607a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18607a.onStatus(-1);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetException f18609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18610b;

        public d(CronetUrlRequest r10, CronetException r11) {
            this.f18610b = r10;
            this.f18609a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            VersionSafeCallbacks.g r10 = CronetUrlRequest.A(this.f18610b);     // Catch: Exception -> L4
            CronetUrlRequest r11 = this.f18610b;     // Catch: Exception -> L4
            r10.b(r11, CronetUrlRequest.z(r11), this.f18609a);     // Catch: Exception -> L4
            CronetUrlRequest.t(this.f18610b);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception in onFailed method", new Object[]{e});
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f18611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f18613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18614d;

        public e(CronetUrlRequest r10, t r11, String r12, String r13) {
            this.f18614d = r10;
            this.f18611a = r11;
            this.f18612b = r12;
            this.f18613c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18614d.F();
            Object r10 = CronetUrlRequest.s(this.f18614d);
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (CronetUrlRequest.x(this.f18614d) == false) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            CronetUrlRequest.u(this.f18614d, true);     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            CronetUrlRequest.A(this.f18614d).e(this.f18614d, this.f18611a, this.f18612b, this.f18613c);     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            CronetUrlRequest.B(this.f18614d, e);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18616b;

        public f(CronetUrlRequest r10, String r11) {
            this.f18616b = r10;
            this.f18615a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18616b.F();
            Object r10 = CronetUrlRequest.s(this.f18616b);
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (CronetUrlRequest.x(this.f18616b) == false) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            CronetUrlRequest.y(this.f18616b, true);     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            VersionSafeCallbacks.g r11 = CronetUrlRequest.A(this.f18616b);     // Catch: Exception -> L14
            CronetUrlRequest r12 = this.f18616b;     // Catch: Exception -> L14
            r11.g(r12, CronetUrlRequest.z(r12), this.f18615a);     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            CronetUrlRequest.B(this.f18616b, e);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18617a;

        public g(CronetUrlRequest r10) {
            this.f18617a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = CronetUrlRequest.s(this.f18617a);
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (CronetUrlRequest.x(this.f18617a) == false) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            CronetUrlRequest.v(this.f18617a, 0);     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            VersionSafeCallbacks.g r11 = CronetUrlRequest.A(this.f18617a);     // Catch: Exception -> L14
            CronetUrlRequest r12 = this.f18617a;     // Catch: Exception -> L14
            r11.h(r12, CronetUrlRequest.z(r12));     // Catch: Exception -> L14
            CronetUrlRequest.t(this.f18617a);     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception in onSucceeded method", new Object[]{e});
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18618a;

        public h(CronetUrlRequest r10) {
            this.f18618a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            VersionSafeCallbacks.g r10 = CronetUrlRequest.A(this.f18618a);     // Catch: Exception -> L4
            CronetUrlRequest r11 = this.f18618a;     // Catch: Exception -> L4
            r10.a(r11, CronetUrlRequest.z(r11));     // Catch: Exception -> L4
            CronetUrlRequest.t(this.f18618a);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception in onCanceled method", new Object[]{e});
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VersionSafeCallbacks.UrlRequestStatusListener f18619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f18620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18621c;

        public i(CronetUrlRequest r10, VersionSafeCallbacks.UrlRequestStatusListener r11, int r12) {
            this.f18621c = r10;
            this.f18619a = r11;
            this.f18620b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18619a.onStatus(UrlRequestBase.l(this.f18620b));
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ttnet.org.chromium.net.t f18622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18623b;

        public j(CronetUrlRequest r10, com.ttnet.org.chromium.net.t r11) {
            this.f18623b = r10;
            this.f18622a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUrlRequest.A(this.f18623b).c(this.f18623b, this.f18622a);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception in onMetricsCollected method", new Object[]{e});
        }
    }

    public final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteBuffer f18624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequest f18625b;

        public k(CronetUrlRequest r10) {
            this.f18625b = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18625b.F();
            ByteBuffer r10 = this.f18624a;
            this.f18624a = null;
            Object r11 = CronetUrlRequest.s(this.f18625b);     // Catch: Exception -> L15
            monitor-enter(r11);     // Catch: Exception -> L15
        L9:
            th = move-exception;
            throw th;     // Catch: Exception -> L15
        L6:
            if (CronetUrlRequest.x(this.f18625b) == false) goto L11;
            monitor-exit(r11);     // Catch: Throwable -> L9
            return;
        L11:
            CronetUrlRequest.y(this.f18625b, true);     // Catch: Throwable -> L9
            monitor-exit(r11);     // Catch: Throwable -> L9
            VersionSafeCallbacks.g r12 = CronetUrlRequest.A(this.f18625b);     // Catch: Exception -> L15
            CronetUrlRequest r13 = this.f18625b;     // Catch: Exception -> L15
            r12.d(r13, CronetUrlRequest.z(r13), r10);     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            CronetUrlRequest.B(this.f18625b, e);
        }

        public /* synthetic */ k(CronetUrlRequest r10, b r11) {
            this(r10);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CronetUrlRequest(CronetUrlRequestContext r10, String r11, int r12, a0.b r13, Executor r14, Collection r15, boolean r16, boolean r17, boolean r18, boolean r19, int r110, boolean r20, int r21, com.ttnet.org.chromium.net.t.a r22) {
        this.f18583f = new Object();
        ArrayList r23 = new ArrayList();
        this.f18586i = r23;
        VersionSafeCallbacks.e r24 = null;
        this.f18591n = new HeadersList(0 == true ? 1 : 0);
        if (r11 == null) goto L16;
        if (r13 == null) goto L14;
        if (r14 == null) goto L12;
        this.f18578a = r18;
        this.f18584g = r10;
        this.f18588k = r11;
        r23.add(r11);
        this.f18589l = H(r12);
        this.f18587j = new VersionSafeCallbacks.g(r13);
        this.f18585h = r14;
        this.f18592o = r15;
        this.f18593p = r16;
        this.f18594q = r17;
        this.f18595r = r19;
        this.f18596s = r110;
        this.f18597t = r20;
        this.f18598u = r21;
        if (r22 == null) goto L9;
        r24 = new VersionSafeCallbacks.e(r22);
    L9:
        this.f18599v = r24;
        return;
    L12:
        throw new NullPointerException("Executor is required");
    L14:
        throw new NullPointerException("Listener is required");
    L16:
        throw new NullPointerException("URL is required");
    }

    public static /* synthetic */ VersionSafeCallbacks.g A(CronetUrlRequest r10) {
        return r10.f18587j;
    }

    public static /* synthetic */ void B(CronetUrlRequest r10, Exception r11) {
        r10.P(r11);
    }

    public static /* synthetic */ CronetUploadDataStream C(CronetUrlRequest r10) {
        return r10.f18600w;
    }

    public static /* synthetic */ long D(CronetUrlRequest r10) {
        return r10.f18579b;
    }

    public static /* synthetic */ void E(CronetUrlRequest r10) {
        r10.T();
    }

    public static int H(int r10) {
        if (r10 != 0) goto L5;
        return 1;
    L5:
        if (r10 == 1) goto L14;
        if (r10 != 2) goto L8;
        return 3;
    L8:
        if (r10 == 4) goto L10;
        return 4;
    L10:
        return 5;
    L14:
        return 2;
    }

    @CalledByNative
    private String[] addSecurityFactor(String r10, String[] r11) {
        HashMap r12 = new HashMap();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= r11.length) goto L6;
        r12.put(r11[r14].toLowerCase(Locale.US), r11[r14 + 1]);
        r14 = r14 + 2;
        goto L4
    L6:
        Map r15 = this.f18584g.d0(r10, r12);
        if (r15 != null) goto L10;
        return null;
    L10:
        String[] r16 = new String[r15.size() * 2];
        Iterator r17 = r15.entrySet().iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        Map.Entry r18 = (Map.Entry) r17.next();
        r16[r13] = (String) r18.getKey();
        r16[r13 + 1] = (String) r18.getValue();
        r13 = r13 + 2;
        goto L12
    L14:
        return r16;
    }

    @CalledByNative
    private void onCanceled() {
        com.ttnet.org.chromium.net.impl.g.c(this.B);
        R(new h(this));
    }

    @CalledByNative
    private void onError(int r10, int r11, int r12, String r13, long r14) {
        t r15 = this.f18601x;
        if (r15 == null) goto L5;
        r15.j(r14);
    L5:
        com.ttnet.org.chromium.net.impl.g.c(this.B);
        if (r10 != 10) goto L8;
    L11:
        J(new QuicExceptionImpl("Exception in CronetUrlRequest: " + r13, r10, r11, r12));
        return;
    L8:
        if (r10 == 3) goto L11;
        J(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r13, N(r10), r11));
    }

    @CalledByNative
    private void onMetricsCollected(long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, boolean r72, long r73, long r75, long r77, String r79, long r80, long r82, String r84, String r85, String r86) {
        Object r10 = this.f18583f;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.A != null) goto L13;
        this.A = new com.ttnet.org.chromium.net.impl.c(r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r73, r75, r77, r79, r80, r82, r84, r85);     // Catch: Throwable -> L10
        this.D = r86;     // Catch: Throwable -> L10
        this.f18587j.f(r86, K());     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        com.ttnet.org.chromium.net.t r11 = K();
        R(new j(this, r11));
        this.f18584g.i0(r11);
        return;
    L13:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L10
    }

    @CalledByNative
    private void onNativeAdapterDestroyed() {
        Object r10 = this.f18583f;
        monitor-enter(r10);
        Runnable r11 = this.K;     // Catch: Throwable -> L7
        if (r11 == null) goto L10;
        r11.run();     // Catch: Throwable -> L7
    L10:
        if (this.f18603z != null) goto L13;
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer r10, int r11, int r12, int r13, long r14) {
        this.f18601x.j(r14);
        b r15 = null;
        if (r10.position() == r12) goto L5;
    L12:
        J(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r10.limit() != r13) goto L12;
        if (this.f18577J != null) goto L10;
        this.f18577J = new k(this, r15);
    L10:
        r10.position(r12 + r11);
        k r16 = this.f18577J;
        r16.f18624a = r10;
        R(r16);
    }

    @CalledByNative
    private void onRedirectReceived(String r12, int r13, String r14, String[] r15, boolean r16, String r17, String r18, long r19, String r21) {
        t r10 = S(r13, r14, r15, r16, r17, r18, r19);
        this.f18586i.add(r12);
        R(new e(this, r10, r12, r21));
    }

    @CalledByNative
    private void onResponseStarted(int r10, String r11, String[] r12, boolean r13, String r14, String r15, long r16, String r17) {
        this.f18601x = S(r10, r11, r12, r13, r14, r15, r16);
        R(new f(this, r17));
    }

    @CalledByNative
    private void onStatus(VersionSafeCallbacks.UrlRequestStatusListener r10, int r11) {
        R(new i(this, r10, r11));
    }

    @CalledByNative
    private void onSucceeded(long r10) {
        this.f18601x.j(r10);
        com.ttnet.org.chromium.net.impl.g.c(this.B);
        R(new g(this));
    }

    public static /* synthetic */ Object s(CronetUrlRequest r10) {
        return r10.f18583f;
    }

    public static /* synthetic */ void t(CronetUrlRequest r10) {
        r10.O();
    }

    public static /* synthetic */ boolean u(CronetUrlRequest r10, boolean r11) {
        r10.f18581d = r11;
        return r11;
    }

    public static /* synthetic */ void v(CronetUrlRequest r10, int r11) {
        r10.I(r11);
    }

    public static /* synthetic */ VersionSafeCallbacks.e w(CronetUrlRequest r10) {
        return r10.f18599v;
    }

    public static /* synthetic */ boolean x(CronetUrlRequest r10) {
        return r10.M();
    }

    public static /* synthetic */ boolean y(CronetUrlRequest r10, boolean r11) {
        r10.f18582e = r11;
        return r11;
    }

    public static /* synthetic */ t z(CronetUrlRequest r10) {
        return r10.f18601x;
    }

    public void F() {
        if (this.f18578a == false) goto L5;
        return;
    L5:
        if (this.f18584g.c0(Thread.currentThread()) == true) goto L8;
        return;
    L8:
        throw new InlineExecutionProhibitedException();
    }

    public final void G() {
        Object r10 = this.f18583f;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f18580c == true) goto L13;
        if (M() == true) goto L13;
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L13:
        throw new IllegalStateException("Request is already started.");     // Catch: Throwable -> L10
    }

    public final void I(int r10) {
        this.f18602y = r10;
        if (this.f18579b != 0) goto L5;
        return;
    L5:
        this.f18584g.e0();
        Natives r11 = com.ttnet.org.chromium.net.impl.f.b();
        long r12 = this.f18579b;
        if (r10 != 2) goto L8;
        boolean r13 = true;
    L9:
        r11.destroy(r12, this, r13);
        this.f18579b = 0;
        return;
    L8:
        r13 = false;
        goto L9
    }

    public final void J(CronetException r10) {
        Object r11 = this.f18583f;
        monitor-enter(r11);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (M() == false) goto L10;
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L10:
        this.f18603z = r10;     // Catch: Throwable -> L8
        I(1);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        d r12 = new d(this, r10);
        this.f18585h.execute(r12);     // Catch: RejectedExecutionException -> L15
        return;
    L15:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception posting task to executor", new Object[]{e});
    }

    public final com.ttnet.org.chromium.net.t K() {
        return new RequestFinishedInfoImpl(this.f18588k, this.f18592o, this.A, this.f18602y, this.f18601x, this.f18603z);
    }

    public void L(a0.c r10) {
        VersionSafeCallbacks.UrlRequestStatusListener r11 = new VersionSafeCallbacks.UrlRequestStatusListener(r10);
        Object r12 = this.f18583f;
        monitor-enter(r12);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f18579b == 0) goto L11;
        com.ttnet.org.chromium.net.impl.f.b().getStatus(this.f18579b, this, r11);     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L9
        R(new c(this, r11));
    }

    public final boolean M() {
        if (this.f18580c == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f18579b != 0) goto L7;
        return true;
    }

    public final int N(int r10) {
        switch(r10) {
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
        com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Unknown error code: " + r10, new Object[0]);
        return r10;
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

    public final void O() {
        com.ttnet.org.chromium.net.impl.c r10 = this.A;
        if (r10 == null) goto L13;
        RequestFinishedInfoImpl r11 = new RequestFinishedInfoImpl(this.f18588k, this.f18592o, r10, this.f18602y, this.f18601x, this.f18603z);
        this.f18584g.i0(r11);
        VersionSafeCallbacks.e r12 = this.f18599v;
        if (r12 == null) goto L14;
        r12.getExecutor().execute(new a(this, r11));     // Catch: RejectedExecutionException -> L8
        return;
    L8:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception posting task to executor", new Object[]{e});
        return;
    L14:
        return;
    }

    public final void P(Exception r10) {
        CallbackExceptionImpl r11 = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", r10);
        com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception in CalledByNative method", new Object[]{r10});
        J(r11);
    }

    public void Q(Throwable r10) {
        com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception in upload method", new Object[]{r10});
        Object r11 = this.f18583f;
        monitor-enter(r11);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18579b != 0) goto L10;
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L10:
        com.ttnet.org.chromium.net.impl.f.b().abortWhenUploadException(this.f18579b, this);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
    }

    public final void R(Runnable r10) {
        this.f18585h.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception posting task to executor", new Object[]{e});
        J(new CronetExceptionImpl("Exception posting task to executor", e));
    }

    public final t S(int r12, String r13, String[] r14, boolean r15, String r16, String r17, long r18) {
        HeadersList r10 = new HeadersList(null);
        int r11 = 0;
    L4:
        if (r11 >= r14.length) goto L7;
        r10.add(new AbstractMap.SimpleImmutableEntry(r14[r11], r14[r11 + 1]));
        r11 = r11 + 2;
        goto L4
    L7:
        return new t(new ArrayList(this.f18586i), r12, r13, r10, r15, r16, r17, r18);
    }

    public final void T() {
        String r10 = this.B;
        if (r10 == null) goto L5;
        com.ttnet.org.chromium.net.impl.g.a(r10, this);
    L5:
        com.ttnet.org.chromium.net.impl.f.b().start(this.f18579b, this);
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void a(String r10, String r11) {
        Object r12 = this.f18583f;
        monitor-enter(r12);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18579b != 0) goto L10;
        monitor-exit(r12);     // Catch: Throwable -> L8
        return;
    L10:
        com.ttnet.org.chromium.net.impl.f.b().addRequestCookieHeader(this.f18579b, this, r10, r11);     // Catch: Throwable -> L8
        monitor-exit(r12);     // Catch: Throwable -> L8
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void b() {
        Object r10 = this.f18583f;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18579b != 0) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        com.ttnet.org.chromium.net.impl.f.b().removeRequestCookieHeader(this.f18579b, this);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void c() {
        com.ttnet.org.chromium.net.impl.g.c(this.B);
        Object r10 = this.f18583f;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18579b != 0) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        com.ttnet.org.chromium.net.impl.f.b().appTimeout(this.f18579b, this);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void d() {
        Object r10 = this.f18583f;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (M() == false) goto L7;
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.f18580c == false) goto L14;
        I(2);     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void e() {
        Object r10 = this.f18583f;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f18581d == false) goto L16;
        this.f18581d = false;     // Catch: Throwable -> L10
        if (M() == false) goto L12;
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L12:
        com.ttnet.org.chromium.net.impl.f.b().followDeferredRedirect(this.f18579b, this);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L16:
        throw new IllegalStateException("No redirect to follow.");     // Catch: Throwable -> L10
    }

    @Override // com.ttnet.org.chromium.net.a0
    public String f() {
        return this.D;
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void g(ByteBuffer r10) {
        o.b(r10);
        o.a(r10);
        Object r11 = this.f18583f;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f18582e == false) goto L19;
        this.f18582e = false;     // Catch: Throwable -> L10
        if (M() == false) goto L13;
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L13:
        if (com.ttnet.org.chromium.net.impl.f.b().readData(this.f18579b, this, r10, r10.position(), r10.limit()) == false) goto L16;
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L16:
        this.f18582e = true;     // Catch: Throwable -> L10
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L10
    L19:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L10
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void h(int r10) {
        this.C = r10;
    }

    @Override // com.ttnet.org.chromium.net.a0
    public void i(long r10) {
        Object r11 = this.f18583f;
        monitor-enter(r11);
        this.I = r10;     // Catch: Throwable -> L7
        if (this.f18579b == 0) goto L9;
        com.ttnet.org.chromium.net.impl.f.b().setThrottleNetSpeed(this.f18579b, this, r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // com.ttnet.org.chromium.net.a0
    public void j() {
        Object r14 = this.f18583f;
        monitor-enter(r14);
        G();     // Catch: Throwable -> L12
        Natives r10 = com.ttnet.org.chromium.net.impl.f.b();     // Catch: Throwable -> L12 RuntimeException -> L14
        long r11 = this.f18584g.Y();     // Catch: Throwable -> L12 RuntimeException -> L14
        String r12 = this.f18588k;     // Catch: Throwable -> L12 RuntimeException -> L14
        int r13 = this.f18589l;     // Catch: Throwable -> L12 RuntimeException -> L14
        int r15 = this.C;     // Catch: Throwable -> L12 RuntimeException -> L14
        boolean r16 = this.f18593p;     // Catch: Throwable -> L12 RuntimeException -> L14
        boolean r17 = this.f18594q;     // Catch: Throwable -> L12 RuntimeException -> L14
        if (this.f18584g.a0() == false) goto L9;
    L16:
        boolean r18 = true;
    L17:
    L71:
        this.f18579b = r10.createRequestAdapter(this, r11, r12, r13, r15, r16, r17, r18, this.f18595r, this.f18596s, this.f18597t, this.f18598u);     // Catch: Throwable -> L26 RuntimeException -> L28
        this.f18584g.f0();     // Catch: Throwable -> L26 RuntimeException -> L28
        if (this.f18590m != null) goto L22;
    L30:
        Iterator<Map.Entry<String, String>> r19 = this.f18591n.iterator();     // Catch: Throwable -> L26 RuntimeException -> L28
        boolean r110 = false;
    L32:
        if (r19.hasNext() == false) goto L48;
        Map.Entry<String, String> r20 = r19.next();     // Catch: Throwable -> L26 RuntimeException -> L28
        if (r20.getKey().equalsIgnoreCase("Content-Type") == false) goto L39;
        if (r20.getValue().isEmpty() == true) goto L39;
        r110 = true;
    L39:
        if (r20.getKey().equalsIgnoreCase("Tt-Map-Key") == false) goto L44;
        if (r20.getValue().isEmpty() == true) goto L44;
        this.B = r20.getValue();     // Catch: Throwable -> L26 RuntimeException -> L28
    L44:
        if (com.ttnet.org.chromium.net.impl.f.b().addRequestHeader(this.f18579b, this, r20.getKey(), r20.getValue()) == true) goto L32;
        throw new IllegalArgumentException("Invalid header " + r20.getKey() + "=" + r20.getValue());     // Catch: Throwable -> L26 RuntimeException -> L28
    L48:
        com.ttnet.org.chromium.net.impl.f.b().setSocketTimeout(this.f18579b, this, this.E, this.F, this.G);     // Catch: Throwable -> L26 RuntimeException -> L28
        Natives r21 = com.ttnet.org.chromium.net.impl.f.b();     // Catch: Throwable -> L26 RuntimeException -> L28
        long r22 = this.f18579b;     // Catch: Throwable -> L26 RuntimeException -> L28
        r21.setRequestTimeout(r22, this, this.H);     // Catch: Throwable -> L26 RuntimeException -> L28
        ?? r23 = r22;
        if (this.I <= 0) goto L51;
        Natives r24 = com.ttnet.org.chromium.net.impl.f.b();     // Catch: Throwable -> L26 RuntimeException -> L28
        r24.setThrottleNetSpeed(this.f18579b, this, this.I);     // Catch: Throwable -> L26 RuntimeException -> L28
        r23 = r24;
    L51:
        CronetUploadDataStream r25 = this.f18600w;     // Catch: Throwable -> L26 RuntimeException -> L28
        if (r25 == null) goto L64;
        if (r110 == false) goto L62;
        this.f18580c = true;     // Catch: Throwable -> L26 RuntimeException -> L58
        r25.u(new b(this));     // Catch: Throwable -> L26 RuntimeException -> L58
        monitor-exit(r14);     // Catch: Throwable -> L26
        return;
    L62:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");     // Catch: Throwable -> L26 RuntimeException -> L58
    L58:
        e = e;
    L67:
        I(r23);     // Catch: Throwable -> L26
        throw e;     // Catch: Throwable -> L26
    L64:
        this.f18580c = true;     // Catch: Throwable -> L26
        T();     // Catch: Throwable -> L26
        monitor-exit(r14);     // Catch: Throwable -> L26
        return;
    L22:
        if (com.ttnet.org.chromium.net.impl.f.b().setHttpMethod(this.f18579b, this, this.f18590m) == true) goto L30;
        throw new IllegalArgumentException("Invalid http method " + this.f18590m);     // Catch: Throwable -> L26 RuntimeException -> L28
    L28:
        e = e;
        r23 = 1;
        goto L67
    L9:
        if (this.f18599v != null) goto L16;
        r18 = false;
    L14:
        e = e;
        r23 = 1;
    L26:
        th = th;
    L69:
        monitor-exit(r14);     // Catch: Throwable -> L26
        throw th;
    L12:
        th = th;
        goto L69
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void k(String r10, String r11) {
        G();
        if (r10 == null) goto L10;
        if (r11 == null) goto L8;
        this.f18591n.add(new AbstractMap.SimpleImmutableEntry(r10, r11));
        return;
    L8:
        throw new NullPointerException("Invalid header value.");
    L10:
        throw new NullPointerException("Invalid header name.");
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void m(String r10) {
        G();
        if (r10 == null) goto L7;
        this.f18590m = r10;
        return;
    L7:
        throw new NullPointerException("Method is required.");
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void n(int r10) {
        this.H = r10;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void o(int r10) {
        this.E = r10;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void p(int r10) {
        this.F = r10;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void q(int r10) {
        this.G = r10;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void r(y r10, Executor r11) {
        if (r10 == null) goto L9;
        if (this.f18590m != null) goto L6;
        this.f18590m = "POST";
    L6:
        this.f18600w = new CronetUploadDataStream(r10, r11, this);
        return;
    L9:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }
}
