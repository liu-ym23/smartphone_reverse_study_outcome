package com.ttnet.org.chromium.net.impl;

import android.os.ConditionVariable;
import android.os.Process;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.PowerMonitor;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.a0;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.ttnet.org.chromium.net.v;
import com.ttnet.org.chromium.net.w;
import java.io.File;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("cronet")
@UsedByReflection("CronetEngine.java")
@VisibleForTesting
public class CronetUrlRequestContext extends CronetEngineBase {
    public static final String I = "CronetUrlRequestContext";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final HashSet f18626J = null;
    public double[] A;
    public double[] B;
    public TTAppInfoProvider C;
    public v D;
    public com.ttnet.org.chromium.net.u E;
    public boolean F;
    public volatile ConditionVariable G;
    public final String H;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConditionVariable f18628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f18629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Thread f18631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f18632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f18633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f18634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f18635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f18636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f18638m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ObserverList f18639n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ObserverList f18640o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map f18641p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Object f18642q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f18643r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f18644s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f18645t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f18646u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String[] f18647v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f18648w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f18649x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public double[] f18650y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public double[] f18651z;

    public interface Natives {
        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void addClientOpaqueData(long r10, CronetUrlRequestContext r11, String[] r12, byte[] r13, byte[] r14);

        void addPkp(long r10, String r11, byte[][] r12, boolean r13, long r14);

        void addQuicHint(long r10, String r11, int r12, int r13);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void clearClientOpaqueData(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void configureNetworkQualityEstimatorForTesting(long r10, CronetUrlRequestContext r11, boolean r12, boolean r13, boolean r14);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void controlHttpDNSConfig(long r10, CronetUrlRequestContext r11, boolean r12, boolean r13, boolean r14);

        long createRequestContextAdapter(long r10);

        long createRequestContextConfig(String r10, String r11, boolean r12, String r13, boolean r14, boolean r15, boolean r16, int r17, long r18, String r19, long r110, boolean r111, boolean r112, boolean r113, boolean r114, String r115, int r116);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void destroy(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void dnsLookup(long r10, CronetUrlRequestContext r11, DnsQuery r12);

        void enableBoeProxy(long r10, boolean r11);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void enableTTBizHttpDns(long r10, CronetUrlRequestContext r11, boolean r12, String r13, String r14, String r15, boolean r16, String r17);

        byte[] getHistogramDeltas();

        long[] getOpaqueFuncAddress();

        void initALogFuncAddr(long r10);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void initRequestContextOnInitThread(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void notifySwitchToMultiNetwork(long r10, CronetUrlRequestContext r11, boolean r12);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void notifyTNCConfigUpdated(long r10, CronetUrlRequestContext r11, String r12, String r13, String r14, String r15, String r16, String r17);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void preconnectUrl(long r10, CronetUrlRequestContext r11, String r12, int r13);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void provideRTTObservations(long r10, CronetUrlRequestContext r11, boolean r12);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void provideThroughputObservations(long r10, CronetUrlRequestContext r11, boolean r12);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void removeClientOpaqueData(long r10, CronetUrlRequestContext r11, String r12);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void reportNetDiagnosisUserLog(long r10, CronetUrlRequestContext r11, String r12);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void setAlogFuncAddr(long r10, CronetUrlRequestContext r11, long r12);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void setAppStartUpState(long r10, CronetUrlRequestContext r11, int r12);

        void setBypassBOEJSON(long r10, String r11);

        void setClientOpaqueData(long r10, String[] r11, byte[] r12, byte[] r13);

        void setGetDomainDefaultJSON(long r10, String r11);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void setHostResolverRules(long r10, CronetUrlRequestContext r11, String r12);

        int setMinLogLevel(int r10);

        void setOpaqueData(long r10, byte[][] r11);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void setProxy(long r10, CronetUrlRequestContext r11, String r12);

        void setProxyConfig(long r10, String r11);

        void setStoreIdcRuleJSON(long r10, String r11);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void startNetLogToDisk(long r10, CronetUrlRequestContext r11, String r12, boolean r13, int r14);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        boolean startNetLogToFile(long r10, CronetUrlRequestContext r11, String r12, boolean r13);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void stopNetLog(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void tiggerWiFiToCellularByThirdParty(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void triggerGetDomain(long r10, CronetUrlRequestContext r11, boolean r12);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void tryStartNetDetect(long r10, CronetUrlRequestContext r11, String[] r12, int r13, int r14);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void ttDnsResolve(long r10, CronetUrlRequestContext r11, String r12, int r13, String r14);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void ttUrlDispatch(long r10, CronetUrlRequestContext r11, URLDispatch r12, String r13);

        @NativeClassQualifiedName("CronetURLRequestContextAdapter")
        void updateStoreRegionFromServer(long r10, CronetUrlRequestContext r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequestContext f18652a;

        public a(CronetUrlRequestContext r10) {
            this.f18652a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.b();
            PowerMonitor.m(CronetUrlRequestContext.S(this.f18652a));
            PowerMonitor.j();
            Object r10 = CronetUrlRequestContext.T(this.f18652a);
            monitor-enter(r10);
            com.ttnet.org.chromium.net.impl.e.b().initRequestContextOnInitThread(CronetUrlRequestContext.U(this.f18652a), this.f18652a);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DnsQuery f18653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequestContext f18654b;

        public b(CronetUrlRequestContext r10, DnsQuery r11) {
            this.f18654b = r10;
            this.f18653a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18653a.a();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ URLDispatch f18655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequestContext f18656b;

        public c(CronetUrlRequestContext r10, URLDispatch r11) {
            this.f18656b = r10;
            this.f18655a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18655a.a();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f18658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f18659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequestContext f18660d;

        public d(CronetUrlRequestContext r10, VersionSafeCallbacks.c r11, int r12, long r13, int r14) {
            this.f18660d = r10;
            this.f18657a = r12;
            this.f18658b = r13;
            this.f18659c = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f18662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f18663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequestContext f18664d;

        public e(CronetUrlRequestContext r10, VersionSafeCallbacks.d r11, int r12, long r13, int r14) {
            this.f18664d = r10;
            this.f18661a = r12;
            this.f18662b = r13;
            this.f18663c = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VersionSafeCallbacks.e f18665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ttnet.org.chromium.net.t f18666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CronetUrlRequestContext f18667c;

        public f(CronetUrlRequestContext r10, VersionSafeCallbacks.e r11, com.ttnet.org.chromium.net.t r12) {
            this.f18667c = r10;
            this.f18665a = r11;
            this.f18666b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18665a.onRequestFinished(this.f18666b);
        }
    }

    static {
        f18626J = new HashSet();
    }

    @UsedByReflection("CronetEngine.java")
    public CronetUrlRequestContext(CronetEngineBuilderImpl r10) {
        Object r11 = new Object();
        this.f18627b = r11;
        this.f18628c = new ConditionVariable(false);
        this.f18629d = new AtomicInteger(0);
        this.f18633h = new Object();
        this.f18634i = new Object();
        this.f18635j = 0;
        this.f18636k = -1;
        this.f18637l = -1;
        this.f18638m = -1;
        this.f18639n = new ObserverList();
        this.f18640o = new ObserverList();
        this.f18641p = new HashMap();
        this.f18642q = new Object();
        this.f18644s = -1;
        this.f18645t = -1;
        this.f18646u = -1;
        this.f18650y = new double[]{-1.0d, -1.0d};
        this.f18651z = new double[]{-1.0d, -1.0d};
        this.A = new double[]{-1.0d, -1.0d};
        this.B = new double[]{-1.0d, -1.0d};
        this.f18632g = r10.l0();
        CronetLibraryLoader.a(r10.T(), r10);
        com.ttnet.org.chromium.net.impl.e.b().setMinLogLevel(X());
        if (r10.g0() != 1) goto L16;
        String r12 = r10.E0();
        this.H = r12;
        HashSet r13 = f18626J;
        monitor-enter(r13);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (r13.add(r12) == false) goto L13;
        monitor-exit(r13);     // Catch: Throwable -> L10
    L17:
        this.C = r10.P();
        this.D = r10.Q();
        this.E = r10.X();
        this.F = r10.Z();
        monitor-enter(r11);
        long r14 = com.ttnet.org.chromium.net.impl.e.b().createRequestContextAdapter(W(r10));     // Catch: Throwable -> L24
        this.f18630e = r14;     // Catch: Throwable -> L24
        if (r14 == 0) goto L27;
        monitor-exit(r11);     // Catch: Throwable -> L24
        CronetLibraryLoader.e(new a(this));
        return;
    L27:
        throw new NullPointerException("Context Adapter creation failed.");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Disk cache storage path already in use");     // Catch: Throwable -> L10
    L16:
        this.H = null;
        goto L17
    }

    public static /* synthetic */ boolean S(CronetUrlRequestContext r10) {
        return r10.F;
    }

    public static /* synthetic */ Object T(CronetUrlRequestContext r10) {
        return r10.f18627b;
    }

    public static /* synthetic */ long U(CronetUrlRequestContext r10) {
        return r10.f18630e;
    }

    public static long W(CronetEngineBuilderImpl r27) {
        String r10 = "";
        File r11 = r27.T().getFilesDir();     // Catch: Throwable -> L41
        if (r11 == null) goto L6;
        r10 = r11.getAbsolutePath();     // Catch: Throwable -> L41
    L6:
        Natives r12 = com.ttnet.org.chromium.net.impl.e.b();
        String r13 = r27.d0();
        String r14 = r27.E0();
        boolean r15 = r27.o0();
        String r16 = r27.V();
        boolean r17 = r27.e0();
        boolean r18 = r27.D();
        boolean r19 = r27.E();
        int r20 = r27.g0();
        long r110 = r27.f0();
        String r111 = r27.O();
        long r112 = r27.k0();
        boolean r113 = r27.l0();
        boolean r114 = r27.m0();
        boolean r115 = r27.h0();
        boolean r116 = r27.G0();
        long r21 = r12.createRequestContextConfig(r13, r14, r15, r16, r17, r18, r19, r20, r110, r111, r112, r113, r114, r115, r116, r10, r27.F0(0));
        Iterator r22 = r27.p0().iterator();
    L8:
        if (r22.hasNext() == false) goto L10;
        CronetEngineBuilderImpl.a r23 = (CronetEngineBuilderImpl.a) r22.next();
        com.ttnet.org.chromium.net.impl.e.b().addQuicHint(r21, r23.f18547a, r23.f18548b, r23.f18549c);
        goto L8
    L10:
        Iterator r24 = r27.n0().iterator();
        if (r24.hasNext() == true) goto L39;
        String r25 = r27.Y();
        if (r25 == null) goto L15;
        com.ttnet.org.chromium.net.impl.e.b().setGetDomainDefaultJSON(r21, r25);
    L15:
        ArrayList r26 = r27.a0();
        if (r26 != null) goto L18;
    L20:
        Map r28 = r27.S();
        if (r28 != null) goto L23;
    L28:
        String r29 = r27.R();
        if (r29 == null) goto L31;
        com.ttnet.org.chromium.net.impl.e.b().setBypassBOEJSON(r21, r29);
    L31:
        String r30 = r27.c0();
        if (r30 == null) goto L34;
        com.ttnet.org.chromium.net.impl.e.b().setStoreIdcRuleJSON(r21, r30);
    L34:
        String r31 = r27.b0();
        if (r31 == null) goto L37;
        com.ttnet.org.chromium.net.impl.e.b().setProxyConfig(r21, r31);
    L37:
        boolean r32 = r27.C();
        com.ttnet.org.chromium.net.impl.e.b().enableBoeProxy(r21, r32);
        long r33 = r27.A();
        com.ttnet.org.chromium.net.impl.e.b().initALogFuncAddr(r33);
        return r21;
    L23:
        if (r28.isEmpty() == true) goto L28;
        Iterator r34 = r28.entrySet().iterator();
    L26:
        if (r34.hasNext() == false) goto L28;
        Map.Entry r35 = (Map.Entry) r34.next();
        com.ttnet.org.chromium.net.impl.e.b().setClientOpaqueData(r21, (String[]) r35.getKey(), (byte[]) ((Pair) r35.getValue()).first, (byte[]) ((Pair) r35.getValue()).second);
        goto L26
    L18:
        if (r26.isEmpty() == true) goto L20;
        com.ttnet.org.chromium.net.impl.e.b().setOpaqueData(r21, (byte[][]) r26.toArray(new byte[r26.size()][]));
        goto L20
    L39:
        androidx.appcompat.widget.p.a(r24.next());
        com.ttnet.org.chromium.net.impl.e.b();
        throw null;
    }

    public static void h0(Executor r10, Runnable r11) {
        r10.execute(r11);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a(I, "Exception posting task to executor", new Object[]{e});
    }

    @CalledByNative
    private void handleApiResult(boolean r37, String r38, String r39, String r40, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, boolean r61, long r62, long r64, String r66, String r67, String r68, int r69, int r70, String r71) {
        v r10 = this.D;
        if (r10 == null) goto L6;
        r10.a(r37, r38, r39, r40, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r62, r64, r66, r67, r68, r69, r70, r71);
        return;
    }

    @CalledByNative
    private void initNetworkThread() {
        this.f18631f = Thread.currentThread();
        Thread.currentThread().setName("ChromiumNet" + Process.getThreadPriority(0));
        com.ttnet.org.chromium.net.u r10 = this.E;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @CalledByNative
    private void onClientIPChanged(String r10) {
        com.ttnet.org.chromium.net.u r11 = this.E;
        if (r11 == null) goto L6;
        r11.b(r10);
        return;
    }

    @CalledByNative
    private void onColdStartFinish() {
        com.ttnet.org.chromium.net.u r10 = this.E;
        if (r10 == null) goto L6;
        r10.c();
        return;
    }

    @CalledByNative
    private void onContextInitCompleted(long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74) {
        this.f18628c.open();
        com.ttnet.org.chromium.net.u r10 = this.E;
        if (r10 == null) goto L6;
        r10.d(r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74);
        return;
    }

    @CalledByNative
    private void onDnsLookupComplete(DnsQuery r10, int r11, String[] r12) {
        r10.d(r11, r12);
        r10.c(new b(this, r10));
    }

    @CalledByNative
    private void onEffectiveConnectionTypeChanged(int r10) {
        Object r11 = this.f18633h;
        monitor-enter(r11);
        this.f18635j = r10;     // Catch: Throwable -> L7
        com.ttnet.org.chromium.net.u r12 = this.E;     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        r12.f(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private TTAppInfoProvider.AppInfo onGetAppInfo() {
        TTAppInfoProvider r10 = this.C;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.a();
    }

    @CalledByNative
    private void onMultiNetworkStateChanged(int r10, int r11) {
        com.ttnet.org.chromium.net.u r12 = this.E;
        if (r12 == null) goto L6;
        r12.g(r10, r11);
        return;
    }

    @CalledByNative
    private void onNQLChanged(int r10) {
        Object r11 = this.f18642q;
        monitor-enter(r11);
        this.f18643r = r10;     // Catch: Throwable -> L7
        com.ttnet.org.chromium.net.u r12 = this.E;     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        r12.h(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onNetworkQualityRttAndThroughputNotified(int r10, int r11, int r12) {
        Object r13 = this.f18642q;
        monitor-enter(r13);
        this.f18644s = r10;     // Catch: Throwable -> L7
        this.f18645t = r11;     // Catch: Throwable -> L7
        this.f18646u = r12;     // Catch: Throwable -> L7
        com.ttnet.org.chromium.net.u r14 = this.E;     // Catch: Throwable -> L7
        if (r14 == null) goto L9;
        r14.i(r10, r11, r12);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onPacketLossComputed(int r12, double r13, double r15, double r17, double r19) {
        Object r10 = this.f18633h;
        monitor-enter(r10);
        if (r12 != 0) goto L6;
    L12:
        this.f18650y[r12] = r13;     // Catch: Throwable -> L10
        this.f18651z[r12] = r15;     // Catch: Throwable -> L10
        this.A[r12] = r17;     // Catch: Throwable -> L10
        this.B[r12] = r19;     // Catch: Throwable -> L10
        com.ttnet.org.chromium.net.u r11 = this.E;     // Catch: Throwable -> L10
        if (r11 == null) goto L15;
        r11.j(r12, r13, r15, r17, r19);     // Catch: Throwable -> L10
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L6:
        if (r12 == 1) goto L12;
        com.ttnet.org.chromium.base.j.a(I, "Error protocol from native. Protocol: " + r12, new Object[0]);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onPublicIPsChanged(String[] r10, String[] r11) {
        if (this.E == null) goto L6;
        ArrayList r12 = new ArrayList(r10.length);
        ArrayList r13 = new ArrayList(r11.length);
        Collections.addAll(r12, r10);
        Collections.addAll(r13, r11);
        this.E.k(r12, r13);
        return;
    }

    @CalledByNative
    private void onRTTOrThroughputEstimatesComputed(int r10, int r11, int r12, String[] r13, int[] r14, int[] r15) {
        Object r16 = this.f18633h;
        monitor-enter(r16);
        this.f18636k = r10;     // Catch: Throwable -> L7
        this.f18637l = r11;     // Catch: Throwable -> L7
        this.f18638m = r12;     // Catch: Throwable -> L7
        this.f18647v = r13;     // Catch: Throwable -> L7
        this.f18648w = r14;     // Catch: Throwable -> L7
        this.f18649x = r15;     // Catch: Throwable -> L7
        com.ttnet.org.chromium.net.u r17 = this.E;     // Catch: Throwable -> L7
        if (r17 == null) goto L9;
        r17.l(r10, r11, r12);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r16);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onRttObservation(int r10, long r11, int r13) {
        Object r12 = this.f18633h;
        monitor-enter(r12);
        Iterator r14 = this.f18639n.iterator();     // Catch: Throwable -> L8
        if (r14.hasNext() == true) goto L10;
        monitor-exit(r12);     // Catch: Throwable -> L8
        return;
    L10:
        androidx.appcompat.widget.p.a(r14.next());     // Catch: Throwable -> L8
        new d(this, null, r10, r11, r13);     // Catch: Throwable -> L8
        throw null;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onSendAppMonitorEvent(String r10, String r11) {
        v r12 = this.D;
        if (r12 == null) goto L6;
        r12.b(r10, r11);
        return;
    }

    @CalledByNative
    private void onServerConfigUpdated(String r10, String r11, String r12) {
        com.ttnet.org.chromium.net.u r13 = this.E;
        if (r13 == null) goto L6;
        r13.m(r10, r11, r12);
        return;
    }

    @CalledByNative
    private void onStoreIdcChanged(String r10, String r11, String r12) {
        com.ttnet.org.chromium.net.u r13 = this.E;
        if (r13 == null) goto L6;
        r13.n(r10, r11, r12);
        return;
    }

    @CalledByNative
    private void onTNCUpdateFailed(String[] r10, String r11) {
        com.ttnet.org.chromium.net.u r12 = this.E;
        if (r12 == null) goto L6;
        r12.o(r10, r11);
        return;
    }

    @CalledByNative
    private void onTTDnsResolveResult(String r12, String r13, int r14, int r15, int r16, String[] r17, String r18) {
        StringBuilder r10 = new StringBuilder();
        r10.append(" onTTDnsResolveResult, uuid: ");
        r10.append(r12);
        r10.append(" host: ");
        r10.append(r13);
        r10.append(" ret: ");
        r10.append(r14);
        r10.append(" ips: ");
        r10.append(r17.length);
        ArrayList r11 = new ArrayList(r17.length);
        Collections.addAll(r11, r17);
        com.ttnet.org.chromium.net.u r19 = this.E;
        if (r19 == null) goto L6;
        r19.p(r12, r13, r14, r15, r16, r11, r18);
        return;
    }

    @CalledByNative
    private void onTTNetDetectInfoChanged(String r10) {
        com.ttnet.org.chromium.net.u r11 = this.E;
        if (r11 == null) goto L6;
        r11.q(r10);
        return;
    }

    @CalledByNative
    private void onThroughputObservation(int r10, long r11, int r13) {
        Object r12 = this.f18633h;
        monitor-enter(r12);
        Iterator r14 = this.f18640o.iterator();     // Catch: Throwable -> L8
        if (r14.hasNext() == true) goto L10;
        monitor-exit(r12);     // Catch: Throwable -> L8
        return;
    L10:
        androidx.appcompat.widget.p.a(r14.next());     // Catch: Throwable -> L8
        new e(this, null, r10, r11, r13);     // Catch: Throwable -> L8
        throw null;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onUrlDispatchComplete(URLDispatch r10, String r11, String r12, String r13) {
        r10.f(r11, r12, r13);
        r10.e(new c(this, r10));
    }

    @Override // com.ttnet.org.chromium.net.f
    public void A(String r10, int r11) {
        Object r12 = this.f18627b;
        monitor-enter(r12);
        V();     // Catch: Throwable -> L7
        com.ttnet.org.chromium.net.impl.e.b().preconnectUrl(this.f18630e, this, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void B(String r10) {
        Object r11 = this.f18627b;
        monitor-enter(r11);
        com.ttnet.org.chromium.net.impl.e.b().removeClientOpaqueData(this.f18630e, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void C(String r10) {
        Object r11 = this.f18627b;
        monitor-enter(r11);
        com.ttnet.org.chromium.net.impl.e.b().reportNetDiagnosisUserLog(this.f18630e, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void D(long r11) {
        Object r10 = this.f18627b;
        monitor-enter(r10);
        V();     // Catch: Throwable -> L7
        com.ttnet.org.chromium.base.j.a(I, "Set alog func addr: " + r11, new Object[0]);     // Catch: Throwable -> L7
        com.ttnet.org.chromium.net.impl.e.b().setAlogFuncAddr(this.f18630e, this, r11);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void E(int r10) {
        Object r11 = this.f18627b;
        monitor-enter(r11);
        com.ttnet.org.chromium.net.impl.e.b().setAppStartUpState(this.f18630e, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void F(String r10) {
        Object r11 = this.f18627b;
        monitor-enter(r11);
        V();     // Catch: Throwable -> L7
        com.ttnet.org.chromium.net.impl.e.b().setHostResolverRules(this.f18630e, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void G(String r10) {
        Object r11 = this.f18627b;
        monitor-enter(r11);
        com.ttnet.org.chromium.net.impl.e.b().setProxy(this.f18630e, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void H() {
        Object r10 = this.f18627b;
        monitor-enter(r10);
        com.ttnet.org.chromium.net.impl.e.b().tiggerWiFiToCellularByThirdParty(this.f18630e, this);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void I(boolean r10) {
        Object r11 = this.f18627b;
        monitor-enter(r11);
        com.ttnet.org.chromium.net.impl.e.b().triggerGetDomain(this.f18630e, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void J(String[] r10, int r11, int r12) {
        Object r13 = this.f18627b;
        monitor-enter(r13);
        com.ttnet.org.chromium.net.impl.e.b().tryStartNetDetect(this.f18630e, this, r10, r11, r12);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void K(String r10, int r11, String r12) {
        Object r13 = this.f18627b;
        monitor-enter(r13);
        com.ttnet.org.chromium.net.impl.e.b().ttDnsResolve(this.f18630e, this, r10, r11, r12);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public Map L(String r10) {
        URLDispatch r11 = new URLDispatch(r10);
        Object r12 = this.f18627b;
        monitor-enter(r12);
        V();     // Catch: Throwable -> L8
        com.ttnet.org.chromium.net.impl.e.b().ttUrlDispatch(this.f18630e, this, r11, r10);     // Catch: Throwable -> L8
        monitor-exit(r12);     // Catch: Throwable -> L8
        r11.g();
        HashMap r13 = new HashMap();
        r13.put("final_url", r11.d());
        r13.put("epoch", r11.b());
        r13.put("etag", r11.c());
        return r13;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void M(String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        Object r13 = this.f18627b;
        monitor-enter(r13);
        com.ttnet.org.chromium.net.impl.e.b().updateStoreRegionFromServer(this.f18630e, this, r15, r16, r17, r18, r19, r20, r21, r22);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTNetDiagnosisRequest N(TTNetDiagnosisRequest.Callback r10, Executor r11, int r12, List r13, int r14, int r15) {
        return new TTCronetNetExpRequest(this, r10, r11, r12, r13, r14, r15);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase O(String r19, a0.b r20, Executor r21, int r22, Collection r23, boolean r24, boolean r25, boolean r26, boolean r27, int r28, boolean r29, int r30, com.ttnet.org.chromium.net.t.a r31) {
        Object r15 = this.f18627b;
        monitor-enter(r15);
        V();     // Catch: Throwable -> L11
        CronetUrlRequest r16 = new CronetUrlRequest(this, r19, r22, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31);     // Catch: Throwable -> L9
        monitor-exit(r15);     // Catch: Throwable -> L9
        return r16;
    L11:
        th = th;
    L13:
        monitor-exit(r15);     // Catch: Throwable -> L9
        throw th;
    L9:
        th = th;
        goto L13
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public w P(w.b r20, Executor r21, List r22, int r23, String r24, long r25, int r27, long r28, String r30, int r31, String r32, Map r33, Map r34, boolean r35) {
        return new CronetWebsocketConnection(this, r20, r21, r22, r23, r24, r25, r27, r28, r30, r31, r32, r33, r34, r35);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public w Q(w.b r10, Executor r11, List r12, Map r13, Map r14, boolean r15) {
        return new CronetWebsocketConnection(this, r10, r11, r12, r13, r14, r15);
    }

    public final void V() {
        if (b0() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Engine is shut down.");
    }

    public final int X() {
        String r10 = I;
        if (com.ttnet.org.chromium.base.j.f(r10, 2) == false) goto L6;
        return -2;
    L6:
        if (com.ttnet.org.chromium.base.j.f(r10, 3) == false) goto L9;
        return -1;
    L9:
        return 3;
    }

    public long Y() {
        Object r10 = this.f18627b;
        monitor-enter(r10);
        V();     // Catch: Throwable -> L7
        long r11 = this.f18630e;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final void Z(int r10) {
        if (this.f18632g == false) goto L12;
        if (r10 != 0) goto L6;
        return;
    L6:
        if (r10 != 1) goto L9;
        return;
    L9:
        throw new IllegalStateException("Error protocol: " + r10);
    L12:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public boolean a0() {
        Object r10 = this.f18634i;
        monitor-enter(r10);
        boolean r11 = !this.f18641p.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean b0() {
        if (this.f18630e == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ttnet.org.chromium.net.c
    public /* bridge */ /* synthetic */ a0.a c(String r10, a0.b r11, Executor r12) {
        return super.R(r10, r11, r12);
    }

    public boolean c0(Thread r10) {
        if (r10 != this.f18631f) goto L5;
        return true;
    L5:
        return false;
    }

    public Map d0(String r10, Map r11) {
        com.ttnet.org.chromium.net.u r12 = this.E;
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.a(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.c
    public URLConnection e(URL r10) {
        return g0(r10, Proxy.NO_PROXY);
    }

    public void e0() {
        this.f18629d.decrementAndGet();
    }

    @Override // com.ttnet.org.chromium.net.f
    public void f(String[] r10, byte[] r11, byte[] r12) {
        Object r13 = this.f18627b;
        monitor-enter(r13);
        com.ttnet.org.chromium.net.impl.e.b().addClientOpaqueData(this.f18630e, this, r10, r11, r12);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void f0() {
        this.f18629d.incrementAndGet();
    }

    @Override // com.ttnet.org.chromium.net.f
    public void g(com.ttnet.org.chromium.net.t.a r10) {
        Object r11 = this.f18634i;
        monitor-enter(r11);
        this.f18641p.put(r10, new VersionSafeCallbacks.e(r10));     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public URLConnection g0(URL r10, Proxy r11) {
        if (r11.type() != Proxy.Type.DIRECT) goto L14;
        String r12 = r10.getProtocol();
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r12) == true) goto L12;
        if ("https".equals(r12) == true) goto L12;
        throw new UnsupportedOperationException("Unexpected protocol:" + r12);
    L12:
        return new CronetHttpURLConnection(r10, this);
    L14:
        throw new UnsupportedOperationException();
    }

    @Override // com.ttnet.org.chromium.net.f
    public void h() {
        Object r10 = this.f18627b;
        monitor-enter(r10);
        com.ttnet.org.chromium.net.impl.e.b().clearClientOpaqueData(this.f18630e, this);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public List i(String r10) {
        DnsQuery r11 = new DnsQuery(r10);
        Object r12 = this.f18627b;
        monitor-enter(r12);
        V();     // Catch: Throwable -> L8
        com.ttnet.org.chromium.net.impl.e.b().dnsLookup(this.f18630e, this, r11);     // Catch: Throwable -> L8
        monitor-exit(r12);     // Catch: Throwable -> L8
        r11.e();
        return r11.b();
    L8:
        th = move-exception;
        throw th;
    }

    public void i0(com.ttnet.org.chromium.net.t r10) {
        Object r11 = this.f18634i;
        monitor-enter(r11);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18641p.isEmpty() == false) goto L10;
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L10:
        ArrayList r12 = new ArrayList(this.f18641p.values());     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        Iterator r13 = r12.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        VersionSafeCallbacks.e r14 = (VersionSafeCallbacks.e) r13.next();
        f r15 = new f(this, r14, r10);
        h0(r14.getExecutor(), r15);
        goto L14
    }

    @Override // com.ttnet.org.chromium.net.f
    public void j(boolean r13, String r14, String r15, String r16, boolean r17, String r18) {
        Object r11 = this.f18627b;
        monitor-enter(r11);
        com.ttnet.org.chromium.net.impl.e.b().enableTTBizHttpDns(this.f18630e, this, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public double k(int r10) {
        Z(r10);
        Object r11 = this.f18633h;
        monitor-enter(r11);
        double r12 = this.f18650y[r10];     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public double l(int r10) {
        Z(r10);
        Object r11 = this.f18633h;
        monitor-enter(r11);
        double r12 = this.B[r10];     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int m() {
        if (this.f18632g == false) goto L16;
        Object r10 = this.f18633h;
        monitor-enter(r10);
        int r11 = this.f18638m;     // Catch: Throwable -> L12
        if (r11 != (-1)) goto L10;
        r11 = -1;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r11;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.f
    public int n() {
        if (this.f18632g == false) goto L13;
        Object r10 = this.f18633h;
        monitor-enter(r10);
        int r11 = this.f18635j;     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.f
    public int o() {
        Object r10 = this.f18642q;
        monitor-enter(r10);
        int r11 = this.f18644s;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int p() {
        Object r10 = this.f18642q;
        monitor-enter(r10);
        int r11 = this.f18646u;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int q() {
        Object r10 = this.f18642q;
        monitor-enter(r10);
        int r11 = this.f18645t;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public Map r() {
        if (this.f18632g == false) goto L21;
        HashMap r10 = new HashMap();
        Object r11 = this.f18633h;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f18647v != null) goto L12;
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r10;
    L12:
        int r12 = 0;
    L13:
        String[] r13 = this.f18647v;     // Catch: Throwable -> L10
        if (r12 >= r13.length) goto L16;
        int[] r14 = {this.f18648w[r12], this.f18649x[r12]};     // Catch: Throwable -> L10
        r10.put(r13[r12], r14);     // Catch: Throwable -> L10
        r12 = r12 + 1;     // Catch: Throwable -> L10
        goto L13
    L16:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r10;
    L21:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.f
    public void registerEventListener(com.ttnet.org.chromium.net.u r10) {
        this.E = r10;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int s() {
        if (this.f18632g == false) goto L16;
        Object r10 = this.f18633h;
        monitor-enter(r10);
        int r11 = this.f18636k;     // Catch: Throwable -> L12
        if (r11 != (-1)) goto L10;
        r11 = -1;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r11;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @CalledByNative
    public void stopNetLogCompleted() {
        this.G.open();
    }

    @Override // com.ttnet.org.chromium.net.f
    public int t() {
        Object r10 = this.f18642q;
        monitor-enter(r10);
        int r11 = this.f18643r;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public List u() {
        ArrayList r10 = new ArrayList();
        Object r11 = this.f18627b;
        monitor-enter(r11);
        long[] r12 = com.ttnet.org.chromium.net.impl.e.b().getOpaqueFuncAddress();     // Catch: Throwable -> L7
        int r13 = r12.length;     // Catch: Throwable -> L7
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L9;
        r10.add(Long.valueOf(r12[r14]));     // Catch: Throwable -> L7
        r14 = r14 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int v() {
        if (this.f18632g == false) goto L16;
        Object r10 = this.f18633h;
        monitor-enter(r10);
        int r11 = this.f18637l;     // Catch: Throwable -> L12
        if (r11 != (-1)) goto L10;
        r11 = -1;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r11;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.f
    public double w(int r10) {
        Z(r10);
        Object r11 = this.f18633h;
        monitor-enter(r11);
        double r12 = this.f18650y[r10];     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public double x(int r10) {
        Z(r10);
        Object r11 = this.f18633h;
        monitor-enter(r11);
        double r12 = this.f18651z[r10];     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void y(boolean r10) {
        Object r11 = this.f18627b;
        monitor-enter(r11);
        com.ttnet.org.chromium.net.impl.e.b().notifySwitchToMultiNetwork(this.f18630e, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void z(String r13, String r14, String r15, String r16, String r17, String r18) {
        Object r11 = this.f18627b;
        monitor-enter(r11);
        com.ttnet.org.chromium.net.impl.e.b().notifyTNCConfigUpdated(this.f18630e, this, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
