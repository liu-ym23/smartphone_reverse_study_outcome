package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Process;
import android.util.Pair;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes4.dex */
public class CronetUrlRequestContext extends d {
    private static final HashSet<String> L = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f37990a = "CronetUrlRequestContext";
    private double[] A;
    private double[] B;
    private TTAppInfoProvider C;
    private com.ttnet.org.chromium.net.aa D;
    private com.ttnet.org.chromium.net.z E;
    private boolean F;
    private final Object G;
    private TTThreadConfigInfoProvider.b H;
    private Map<TTThreadConfigInfoProvider.c, Integer> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private Map<TTThreadConfigInfoProvider.c, TTThreadConfigInfoProvider.a> f37991J;
    private final ConditionVariable K;
    private final String M;
    private long N;
    private final int O;
    private final boolean P;
    private final h Q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f37992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConditionVariable f37993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f37994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f37995e;
    private Thread f;
    private final boolean g;
    private final Object h;
    private final Object i;
    private int j;
    private int k;
    private int l;
    private int m;
    private final com.ttnet.org.chromium.base.m<VersionSafeCallbacks.c> n;
    private final com.ttnet.org.chromium.base.m<VersionSafeCallbacks.d> o;
    private final Map<com.ttnet.org.chromium.net.w.a, VersionSafeCallbacks.e> p;
    private final Object q;
    private int r;
    private int s;
    private int t;
    private int u;
    private String[] v;
    private int[] w;
    private int[] x;
    private double[] y;
    private double[] z;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetUrlRequestContext$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f38012a = null;

        static {
            int[] r0 = new int[TTThreadConfigInfoProvider.a.values().length];
            f38012a = r0;
            r0[TTThreadConfigInfoProvider.a.f37875b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f38012a[TTThreadConfigInfoProvider.a.f37876c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f38012a[TTThreadConfigInfoProvider.a.f37877d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    interface a {
        int a(int r1);

        long a(long r1);

        long a(String r1, String r2, boolean r3, String r4, boolean r5, boolean r6, boolean r7, int r8, long r9, String r11, long r12, boolean r14, boolean r15, int r16);

        void a(long r1, int r3, boolean r4, boolean r5, String r6, String r7, String r8, boolean r9, String r10, String r11, byte[][] r12, TTThreadConfigInfoProvider.ThreadConfigInfo[] r13, boolean r14, boolean r15, boolean r16, String r17, TTAppInfoProvider.AppInfo r18, long r19, boolean r21, boolean r22, boolean r23, TTSamplingSettingProvider.TTSlaSamplingSetting r24, boolean r25, String r26);

        void a(long r1, CronetUrlRequestContext r3);

        void a(long r1, CronetUrlRequestContext r3, int r4);

        void a(long r1, CronetUrlRequestContext r3, long r4);

        void a(long r1, CronetUrlRequestContext r3, long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18);

        void a(long r1, CronetUrlRequestContext r3, TTSamplingSettingProvider.TTSlaSamplingSetting r4);

        void a(long r1, CronetUrlRequestContext r3, URLDispatch r4, String r5, boolean r6);

        void a(long r1, CronetUrlRequestContext r3, String r4);

        void a(long r1, CronetUrlRequestContext r3, String r4, int r5, String r6);

        void a(long r1, CronetUrlRequestContext r3, String r4, int r5, String r6, String r7);

        void a(long r1, CronetUrlRequestContext r3, String r4, String r5);

        void a(long r1, CronetUrlRequestContext r3, String r4, String r5, String r6, String r7, String r8, String r9);

        void a(long r1, CronetUrlRequestContext r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14);

        void a(long r1, CronetUrlRequestContext r3, boolean r4);

        void a(long r1, CronetUrlRequestContext r3, boolean r4, String r5, String r6, String r7, boolean r8, String r9);

        void a(long r1, CronetUrlRequestContext r3, String[] r4, int r5);

        void a(long r1, CronetUrlRequestContext r3, String[] r4, int r5, int r6);

        void a(long r1, CronetUrlRequestContext r3, String[] r4, int r5, long r6);

        void a(long r1, CronetUrlRequestContext r3, String[] r4, byte[] r5, byte[] r6, long r7, long r9);

        void a(long r1, String r3, int r4, int r5);

        void a(long r1, String r3, byte[][] r4, boolean r5, long r6);

        void a(long r1, String[] r3, byte[] r4, byte[] r5);

        long[] a();

        void b(long r1);

        void b(long r1, CronetUrlRequestContext r3);

        void b(long r1, CronetUrlRequestContext r3, String r4);

        void b(long r1, CronetUrlRequestContext r3, boolean r4);

        void c(long r1, CronetUrlRequestContext r3);

        void c(long r1, CronetUrlRequestContext r3, String r4);

        void d(long r1, CronetUrlRequestContext r3, String r4);

        boolean d(long r1, CronetUrlRequestContext r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.d, com.ttnet.org.chromium.net.h, com.ttnet.org.chromium.net.d
    public /* synthetic */ com.ttnet.org.chromium.net.ai.a a(String r3, com.ttnet.org.chromium.net.ai.b r4, Executor r5) {
        return super.b(r3, r4, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ boolean a(CronetUrlRequestContext r0) {
        return r0.F;
    }

    static /* synthetic */ Object b(CronetUrlRequestContext r0) {
        return r0.f37992b;
    }

    static /* synthetic */ long c(CronetUrlRequestContext r2) {
        return r2.f37995e;
    }

    static {
        L = new HashSet();
    }

    int n() {
        return this.O;
    }

    h o() {
        return this.Q;
    }

    public CronetUrlRequestContext(CronetEngineBuilderImpl r10) {
        Object r0 = new Object();
        this.f37992b = r0;
        this.f37993c = new ConditionVariable(false);
        this.f37994d = new AtomicInteger(0);
        this.h = new Object();
        this.i = new Object();
        this.j = 0;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        com.ttnet.org.chromium.base.m<VersionSafeCallbacks.c> r3 = new com.ttnet.org.chromium.base.m();
        this.n = r3;
        com.ttnet.org.chromium.base.m<VersionSafeCallbacks.d> r4 = new com.ttnet.org.chromium.base.m();
        this.o = r4;
        this.p = new HashMap();
        this.q = new Object();
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.y = new double[]{-1.0d, -1.0d};
        this.z = new double[]{-1.0d, -1.0d};
        this.A = new double[]{-1.0d, -1.0d};
        this.B = new double[]{-1.0d, -1.0d};
        Object r1 = new Object();
        this.G = r1;
        this.I = new HashMap();
        this.f37991J = new HashMap();
        this.K = new ConditionVariable();
        this.N = -1;
        this.O = hashCode();
        r3.a();
        r4.a();
        this.g = r10.Y();
        CronetLibraryLoader.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r10);
        m.b().a(x());
        if (r10.R() != 1) goto L16;
        String r5 = r10.e();
        this.M = r5;
        HashSet<String> r6 = L;
        monitor-enter(r6);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r6.add(r5) == false) goto L11;
        monitor-exit(r6);     // Catch: Throwable -> L14
    L17:
        this.C = r10.n();
        this.D = r10.o();
        this.E = r10.p();
        this.F = r10.k();
        monitor-enter(r1);
        this.H = r10.K();     // Catch: Throwable -> L40
        monitor-exit(r1);     // Catch: Throwable -> L40
        monitor-enter(r0);
        long r7 = m.b().a(a(r10));     // Catch: Throwable -> L37
        this.f37995e = r7;     // Catch: Throwable -> L37
        if (r7 == 0) goto L36;
        boolean r2 = m.b().d(this.f37995e, this);     // Catch: Throwable -> L37
        this.P = r2;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        if (r2 == false) goto L28;
        this.Q = i.a();
    L47:
        this.Q.a(n(), new h.a(r10), u(), p());     // Catch: RuntimeException -> L31
    L33:
        CronetLibraryLoader.a(new AnonymousClass1(this));
        return;
    L31:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(f37990a, "Error while trying to log CronetEngine creation: ", new Object[]{e});
        goto L33
    L28:
        this.Q = i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), p());
        goto L47
    L36:
        throw new NullPointerException("Context Adapter creation failed.");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    L40:
        th = move-exception;
        throw th;
    L11:
        throw new IllegalStateException("Disk cache storage path already in use");     // Catch: Throwable -> L14
    L16:
        this.M = null;
        goto L17
    }

    static h.b p() {
        if (com.ttnet.org.chromium.net.d.class.getClassLoader().equals(CronetUrlRequest.class.getClassLoader()) == false) goto L6;
        return h.b.f38131b;
    L6:
        return h.b.f38132c;
    }

    public static long a(CronetEngineBuilderImpl r37) {
        String r2 = "";
        File r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r37.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir();     // Catch: Throwable -> L40
        if (r3 == null) goto L6;
        r2 = r3.getAbsolutePath();     // Catch: Throwable -> L40
    L6:
        String r9 = r2;
        long r35 = m.b().a(r37.d(), r37.e(), r37.g(), r37.h(), r37.i(), r37.O(), r37.P(), r37.R(), r37.Q(), r37.W(), r37.X(), r37.Y(), r37.V(), r37.e(0));
        if (r35 == 0) goto L39;
        Iterator<CronetEngineBuilderImpl.c> r4 = r37.T().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        CronetEngineBuilderImpl.c r5 = (CronetEngineBuilderImpl.c) ZeusTransformUtils.preCheckCast(r4.next(), CronetEngineBuilderImpl.c.class, "com.obric.aiagent.plugin");
        m.b().a(r35, r5.f37934a, r5.f37935b, r5.f37936c);
        goto L10
    L12:
        Iterator<CronetEngineBuilderImpl.b> r6 = r37.U().iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        CronetEngineBuilderImpl.b r7 = (CronetEngineBuilderImpl.b) ZeusTransformUtils.preCheckCast(r6.next(), CronetEngineBuilderImpl.b.class, "com.obric.aiagent.plugin");
        m.b().a(r35, r7.f37930a, r7.f37931b, r7.f37932c, r7.f37933d.getTime());
        goto L14
    L16:
        ArrayList<byte[]> r8 = r37.r();
        if (r8 != null) goto L19;
    L21:
        byte[][] r15 = null;
    L22:
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r10 = r37.J();
        if (r10 != null) goto L25;
    L27:
        TTThreadConfigInfoProvider.ThreadConfigInfo[] r16 = null;
    L28:
        m.b().a(r35, r37.A(), r37.j(), r37.m(), r9, r37.v(), r37.q(), r37.x(), r37.t(), r37.u(), r15, r16, r37.y(), r37.B(), r37.C(), r37.D(), r37.E(), r37.I(), r37.F(), r37.G(), r37.H(), r37.L(), r37.M(), r37.N());
        Map<String[], Pair<byte[], byte[]>> r11 = r37.s();
        if (r11 != null) goto L31;
    L36:
        m.b().b(r37.z());
        return r35;
    L31:
        if (r11.isEmpty() == true) goto L36;
        Iterator<Map.Entry<String[], Pair<byte[], byte[]>>> r12 = r11.entrySet().iterator();
    L34:
        if (r12.hasNext() == false) goto L36;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        m.b().a(r35, (String[]) ZeusTransformUtils.preCheckCast(r13.getKey(), String[].class, "com.obric.aiagent.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r13.getValue(), Pair.class, "com.obric.aiagent.plugin")).first, byte[].class, "com.obric.aiagent.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r13.getValue(), Pair.class, "com.obric.aiagent.plugin")).second, byte[].class, "com.obric.aiagent.plugin"));
        goto L34
    L25:
        if (r10.isEmpty() == true) goto L27;
        r16 = (TTThreadConfigInfoProvider.ThreadConfigInfo[]) ZeusTransformUtils.preCheckCast(r10.toArray(new TTThreadConfigInfoProvider.ThreadConfigInfo[r10.size()]), TTThreadConfigInfoProvider.ThreadConfigInfo[].class, "com.obric.aiagent.plugin");
        goto L28
    L19:
        if (r8.isEmpty() == true) goto L21;
        r15 = (byte[][]) ZeusTransformUtils.preCheckCast(r8.toArray(new byte[r8.size()][]), byte[][].class, "com.obric.aiagent.plugin");
        goto L22
    L39:
        throw new IllegalArgumentException("Experimental options parsing failed.");
    }

    @Override // com.ttnet.org.chromium.net.impl.d
    public af a(String r22, com.ttnet.org.chromium.net.ai.b r23, Executor r24, int r25, Collection<Object> r26, boolean r27, boolean r28, boolean r29, boolean r30, int r31, boolean r32, int r33, com.ttnet.org.chromium.net.w.a r34, int r35, long r36) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r24, Executor.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r26, Collection.class, "com.obric.aiagent.plugin");
        if (r36 != (-1)) goto L5;
        long r17 = this.N;
    L6:
        Object r15 = this.f37992b;
        monitor-enter(r15);
        v();     // Catch: Throwable -> L13
        CronetUrlRequest r19 = new CronetUrlRequest(this, r22, r25, r23, r6, r7, r27, r28, r29, r30, r31, r32, r33, r34, r35, r17);     // Catch: Throwable -> L17
        monitor-exit(r15);     // Catch: Throwable -> L17
        return r19;
    L13:
        th = th;
    L15:
        monitor-exit(r15);     // Catch: Throwable -> L17
        throw th;
    L17:
        th = th;
        goto L15
    L5:
        r17 = r36;
        goto L6
    }

    public String q() {
        return "Cronet/" + ImplVersion.a();
    }

    private h.d u() {
        return new h.d(q().split("/")[1].split("@")[0]);
    }

    public void stopNetLogCompleted() {
        this.K.open();
    }

    @Override // com.ttnet.org.chromium.net.impl.d
    public com.ttnet.org.chromium.net.ae a(com.ttnet.org.chromium.net.ae.b r11, Executor r12, List<String> r13, Map<String, String> r14, Map<String, String> r15, boolean r16) {
        return new CronetWebsocketConnection(this, r11, (Executor) ZeusTransformUtils.wrapperContextForParams(r12, Executor.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin"), r16);
    }

    @Override // com.ttnet.org.chromium.net.impl.d
    public com.ttnet.org.chromium.net.ae a(com.ttnet.org.chromium.net.ae.b r20, Executor r21, List<String> r22, int r23, String r24, long r25, int r27, long r28, String r30, int r31, String r32, Map<String, String> r33, Map<String, String> r34, boolean r35) {
        return new CronetWebsocketConnection(this, r20, (Executor) ZeusTransformUtils.wrapperContextForParams(r21, Executor.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin"), r23, r24, r25, r27, r28, r30, r31, r32, (Map) ZeusTransformUtils.wrapperContextForParams(r33, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.aiagent.plugin"), r35);
    }

    @Override // com.ttnet.org.chromium.net.impl.d
    public com.ttnet.org.chromium.net.ac a(com.ttnet.org.chromium.net.ac.b r12, Executor r13, int r14, List<String> r15, int r16, int r17, int r18) {
        return new TTCronetNetExpRequest(this, (com.ttnet.org.chromium.net.ac.b) ZeusTransformUtils.wrapperContextForParams(r12, com.ttnet.org.chromium.net.ac.b.class, "com.obric.aiagent.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r13, Executor.class, "com.obric.aiagent.plugin"), r14, (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin"), r16, r17, r18);
    }

    @Override // com.ttnet.org.chromium.net.d
    public com.ttnet.org.chromium.net.ab a() {
        return new TTCronetMpaService(this);
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(String r13, String r14, String r15, String r16, String r17, String r18) {
        Object r11 = this.f37992b;
        monitor-enter(r11);
        m.b().a(this.f37995e, this, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(boolean r5) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().a(this.f37995e, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public Map<String, String> a(String r10, int r11, boolean r12) {
        URLDispatch r7 = new URLDispatch(r10);
        Object r8 = this.f37992b;
        monitor-enter(r8);
        v();     // Catch: Throwable -> L8
        m.b().a(this.f37995e, this, r7, r10, r12);     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        r7.a(r11);
        HashMap r9 = new HashMap();
        r9.put("final_url", r7.b());
        r9.put("epoch", r7.c());
        r9.put("etag", r7.d());
        r9.put("ttnet_origin_host", r7.e());
        return r9;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void b(boolean r5) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().b(this.f37995e, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(String[] r14, byte[] r15, byte[] r16, long r17, long r19) {
        Object r12 = this.f37992b;
        monitor-enter(r12);
        m.b().a(this.f37995e, this, r14, r15, r16, r17, r19);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void c() {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().b(this.f37995e, this);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(String r5) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().a(this.f37995e, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void b(String r5) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().b(this.f37995e, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(String r9, int r10, Map<String, String> r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        Object r0 = this.f37992b;
        monitor-enter(r0);
        v();     // Catch: Throwable -> L7
        m.b().a(this.f37995e, this, r9, r10, a(r12));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void c(String r5) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        v();     // Catch: Throwable -> L7
        m.b().c(this.f37995e, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(TTSamplingSettingProvider.TTSlaSamplingSetting r5) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        v();     // Catch: Throwable -> L7
        m.b().a(this.f37995e, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public double a(int r2) {
        i(r2);
        Object r0 = this.h;
        monitor-enter(r0);
        double r1 = this.y[r2];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public double b(int r2) {
        i(r2);
        Object r0 = this.h;
        monitor-enter(r0);
        double r1 = this.z[r2];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public double c(int r2) {
        i(r2);
        Object r0 = this.h;
        monitor-enter(r0);
        double r1 = this.y[r2];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public double d(int r2) {
        i(r2);
        Object r0 = this.h;
        monitor-enter(r0);
        double r1 = this.B[r2];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public int e() {
        Object r0 = this.q;
        monitor-enter(r0);
        int r1 = this.r;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public int f() {
        Object r0 = this.q;
        monitor-enter(r0);
        int r1 = this.s;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public int g() {
        Object r0 = this.q;
        monitor-enter(r0);
        int r1 = this.t;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public int h() {
        Object r0 = this.q;
        monitor-enter(r0);
        int r1 = this.u;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void i(int r3) {
        if (this.g == false) goto L12;
        if (r3 != 0) goto L6;
        return;
    L6:
        if (r3 != 1) goto L9;
        return;
    L9:
        throw new IllegalStateException("Error protocol: " + r3);
    L12:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    Map<String, String> a(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        com.ttnet.org.chromium.net.z r2 = this.E;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a(r3, r5);
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
        Map<String, String> r5 = a(r6, r0);
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

    String onRequestInterceptorToStart(String r6, String[] r7, String[] r8) {
        if (this.E != null) goto L6;
        return null;
    L6:
        HashMap r0 = new HashMap();
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r2 >= r7.length) goto L10;
        r0.put(r7[r2].toLowerCase(Locale.US), r7[r2 + 1]);
        r2 = r2 + 2;
        goto L8
    L10:
        ArrayList r9 = new ArrayList();
    L12:
        if (r1 >= r8.length) goto L15;
        r9.add(r8[r1]);
        r1 = r1 + 1;
        goto L12
    L15:
        return this.E.a(r6, r0, r9);
    }

    String onRequestInterceptorJava(String r6, String[] r7) {
        if (this.E != null) goto L6;
        return null;
    L6:
        HashMap r0 = new HashMap();
        if (r7 == null) goto L13;
        int r1 = 0;
    L9:
        int r2 = r1 + 1;
        if (r2 >= r7.length) goto L13;
        r0.put(r7[r1].toLowerCase(Locale.US), r7[r2]);
        r1 = r1 + 2;
    L13:
        return this.E.b(r6, r0);
    }

    String onResponseInterceptorToStart(String r7, String[] r8, int r9) {
        if (this.E != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L8:
        if (r1 >= r8.length) goto L10;
        r0.add(new AbstractMap.SimpleImmutableEntry(r8[r1].toLowerCase(Locale.US), r8[r1 + 1]));
        r1 = r1 + 2;
        goto L8
    L10:
        TreeMap r10 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        ArrayList r4 = new ArrayList();
        if (r10.containsKey(r3.getKey()) == false) goto L16;
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r10.get(r3.getKey()), Collection.class, "com.obric.aiagent.plugin"));
    L16:
        r4.add((String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin"));
        r10.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), Collections.unmodifiableList(r4));
        goto L12
    L18:
        return this.E.a(r7, r10, r9);
    }

    @Override // com.ttnet.org.chromium.net.h
    public int b() {
        if (this.g == false) goto L13;
        Object r0 = this.h;
        monitor-enter(r0);
        int r1 = this.j;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.h
    public int k() {
        if (this.g == false) goto L16;
        Object r0 = this.h;
        monitor-enter(r0);
        int r2 = this.k;     // Catch: Throwable -> L12
        if (r2 != (-1)) goto L10;
        r2 = -1;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.h
    public int l() {
        if (this.g == false) goto L16;
        Object r0 = this.h;
        monitor-enter(r0);
        int r2 = this.l;     // Catch: Throwable -> L12
        if (r2 != (-1)) goto L10;
        r2 = -1;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.h
    public int m() {
        if (this.g == false) goto L16;
        Object r0 = this.h;
        monitor-enter(r0);
        int r2 = this.m;     // Catch: Throwable -> L12
        if (r2 != (-1)) goto L10;
        r2 = -1;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.d
    public URLConnection a(URL r2, Proxy r3, boolean r4) {
        if (r3.type() != Proxy.Type.DIRECT) goto L14;
        String r5 = r2.getProtocol();
        if ("http".equals(r5) == true) goto L12;
        if ("https".equals(r5) == true) goto L12;
        throw new UnsupportedOperationException("Unexpected protocol:" + r5);
    L12:
        return new CronetHttpURLConnection(r2, this, r4);
    L14:
        throw new UnsupportedOperationException();
    }

    void r() {
        this.f37994d.incrementAndGet();
    }

    void s() {
        this.f37994d.decrementAndGet();
    }

    public long t() {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        v();     // Catch: Throwable -> L7
        long r1 = this.f37995e;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void v() {
        if (w() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Engine is shut down.");
    }

    private boolean w() {
        if (this.f37995e == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int x() {
        String r2 = f37990a;
        if (com.ttnet.org.chromium.base.j.a(r2, 2) == false) goto L6;
        return -2;
    L6:
        if (com.ttnet.org.chromium.base.j.a(r2, 3) == false) goto L10;
        return -1;
    L10:
        return 3;
    }

    private void initNetworkThread() {
        this.f = Thread.currentThread();
        this.f37993c.open();
        Thread.currentThread().setName("ChromiumNet" + Process.getThreadPriority(0));
        com.ttnet.org.chromium.net.z r3 = this.E;
        if (r3 == null) goto L6;
        r3.c();
        return;
    }

    private void onEffectiveConnectionTypeChanged(int r2) {
        Object r0 = this.h;
        monitor-enter(r0);
        this.j = r2;     // Catch: Throwable -> L9
        com.ttnet.org.chromium.net.z r1 = this.E;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.a(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onRTTOrThroughputEstimatesComputed(int r2, int r3, int r4) {
        Object r0 = this.h;
        monitor-enter(r0);
        this.k = r2;     // Catch: Throwable -> L9
        this.l = r3;     // Catch: Throwable -> L9
        this.m = r4;     // Catch: Throwable -> L9
        com.ttnet.org.chromium.net.z r1 = this.E;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.a(r2, r3, r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(long r11) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        v();     // Catch: Throwable -> L7
        com.ttnet.org.chromium.base.j.e(f37990a, "Set alog func addr: " + r11, new Object[0]);     // Catch: Throwable -> L7
        m.b().a(this.f37995e, this, r11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public Map<String, int[]> d() {
        if (this.g == false) goto L20;
        HashMap r0 = new HashMap();
        Object r1 = this.h;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.v != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r0;
    L10:
        int r3 = 0;
    L11:
        String[] r4 = this.v;     // Catch: Throwable -> L16
        if (r3 >= r4.length) goto L14;
        r0.put(r4[r3], new int[]{this.w[r3], this.x[r3]});     // Catch: Throwable -> L16
        r3 = r3 + 1;     // Catch: Throwable -> L16
        goto L11
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r0;
    L20:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    private void onGroupRTTOrThroughputEstimatesComputed(String[] r2, int[] r3, int[] r4) {
        Object r0 = this.h;
        monitor-enter(r0);
        this.v = r2;     // Catch: Throwable -> L7
        this.w = r3;     // Catch: Throwable -> L7
        this.x = r4;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onContextInitCompleted(long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, String r68, String r69) {
        aa.f38081e = r68;
        aa.f = r69;
        this.f37993c.open();
        com.ttnet.org.chromium.net.z r2 = this.E;
        if (r2 == null) goto L6;
        r2.a(r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66);
        return;
    }

    private void onThreadIdChanged(int[] r9) {
        Object r0 = this.G;
        monitor-enter(r0);
        int r1 = 0;
    L29:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (r1 >= (r9.length - 1)) goto L24;
        TTThreadConfigInfoProvider.c r2 = TTThreadConfigInfoProvider.c.values()[r9[r1]];     // Catch: Throwable -> L26
        int r4 = r9[r1 + 1];     // Catch: Throwable -> L26
        this.I.put(r2, Integer.valueOf(r4));     // Catch: Throwable -> L26
        if (this.f37991J.containsKey(r2) == true) goto L11;
    L23:
        r1 = r1 + 2;     // Catch: Throwable -> L26
        goto L29
    L11:
        if (this.H == null) goto L23;
        int r3 = AnonymousClass6.f38012a[((TTThreadConfigInfoProvider.a) ZeusTransformUtils.preCheckCast(this.f37991J.get(r2), TTThreadConfigInfoProvider.a.class, "com.obric.aiagent.plugin")).ordinal()];     // Catch: Throwable -> L26
        if (r3 != 1) goto L16;
        this.H.bindBigCore(r4);     // Catch: Throwable -> L26
        goto L23
    L16:
        if (r3 != 2) goto L18;
        this.H.bindLittleCore(r4);     // Catch: Throwable -> L26
        goto L23
    L18:
        if (r3 != 3) goto L23;
        this.H.resetCoreBind(r4);     // Catch: Throwable -> L26
        goto L23
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L26
    }

    private void onNQLChanged(int r2) {
        Object r0 = this.q;
        monitor-enter(r0);
        this.r = r2;     // Catch: Throwable -> L9
        com.ttnet.org.chromium.net.z r1 = this.E;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.c(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onNetworkQualityRttAndThroughputNotified(int r2, int r3, int r4) {
        Object r0 = this.q;
        monitor-enter(r0);
        this.s = r2;     // Catch: Throwable -> L9
        this.t = r3;     // Catch: Throwable -> L9
        this.u = r4;     // Catch: Throwable -> L9
        com.ttnet.org.chromium.net.z r1 = this.E;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.b(r2, r3, r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onPacketLossComputed(int r12, double r13, double r15, double r17, double r19) {
        Object r10 = this.h;
        monitor-enter(r10);
        if (r12 != 0) goto L6;
    L10:
        this.y[r12] = r13;     // Catch: Throwable -> L15
        this.z[r12] = r15;     // Catch: Throwable -> L15
        this.A[r12] = r17;     // Catch: Throwable -> L15
        this.B[r12] = r19;     // Catch: Throwable -> L15
        com.ttnet.org.chromium.net.z r0 = this.E;     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        r0.a(r12, r13, r15, r17, r19);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L6:
        if (r12 == 1) goto L10;
        com.ttnet.org.chromium.base.j.e(f37990a, "Error protocol from native. Protocol: " + r12, new Object[0]);     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void onNetworkQualityTypeChangedV3(int r1) {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    private void onUrlDispatchComplete(final URLDispatch r1, String r2, String r3, String r4, String r5) {
        r1.setResult(r2, r3, r4, r5);
        r1.a(new AnonymousClass2(this, r1));
    }

    private TTAppInfoProvider.AppInfo onGetAppInfo() {
        TTAppInfoProvider r0 = this.C;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    private void onSendAppMonitorEvent(String r1, String r2) {
        com.ttnet.org.chromium.net.aa r0 = this.D;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    private void onTNCConfigChanged(String r1, String r2, String r3) {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    private void onTNCRequestSucceeded(boolean r1, boolean r2, int r3) {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    private void onTTNetDetectInfoChanged(String r1) {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    private void onTTDnsResolveResult(String r12, String r13, int r14, int r15, int r16, String[] r17, String r18) {
        com.ttnet.org.chromium.base.j.b(f37990a, " onTTDnsResolveResult, uuid: " + r12 + " host: " + r13 + " ret: " + r14 + " ips: " + r17.length, new Object[0]);
        ArrayList r9 = new ArrayList(r17.length);
        Collections.addAll(r9, r17);
        com.ttnet.org.chromium.net.z r3 = this.E;
        if (r3 == null) goto L6;
        r3.a(r12, r13, r14, r15, r16, r9, r18);
        return;
    }

    private void onColdStartFinish() {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    private void onClientIPChanged(String r1) {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    private void onTLBDecompressFail() {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    private void onPublicIPsChanged(String[] r4, String[] r5) {
        if (this.E == null) goto L6;
        ArrayList r0 = new ArrayList(r4.length);
        ArrayList r1 = new ArrayList(r5.length);
        Collections.addAll(r0, r4);
        Collections.addAll(r1, r5);
        this.E.a(r0, r1);
        return;
    }

    private void onStoreIdcChanged(String r8, String r9, String r10, String r11, String r12, String r13) {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.a(r8, r9, r10, r11, r12, r13);
        return;
    }

    private void onDropReasonChanged(boolean r3, int[] r4) {
        if (this.E == null) goto L9;
        List<Integer> r0 = new ArrayList();
        if (r4 == null) goto L7;
        r0 = (List) ZeusTransformUtils.preCheckCast(Arrays.stream(r4).boxed().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    L7:
        this.E.a(r3, r0);
        return;
    }

    private void handleApiResult(boolean r37, String r38, String r39, String r40, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, boolean r61, long r62, long r64, String r66, String r67, String r68, int r69, int r70, String r71) {
        com.ttnet.org.chromium.net.aa r0 = this.D;
        if (r0 == null) goto L6;
        r0.a(r37, r38, r39, r40, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r62, r64, r66, r67, r68, r69, r70, r71);
        return;
    }

    private boolean handleApiSample(String r1, String r2) {
        com.ttnet.org.chromium.net.aa r0 = this.D;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.b(r1, r2);
    }

    private void onTNCUpdateFailed(String[] r1, String r2) {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    private void onWiFiToCellStateChanged(int r1, int r2) {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    private void onMultiNetworkStateChanged(int r1, int r2) {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    private void onUserSpecifiedNetworkEnabled(boolean r1) {
        com.ttnet.org.chromium.net.z r0 = this.E;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(String[] r9, int r10, int r11) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().a(this.f37995e, this, r9, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(String r10, int r11, String r12, Map<String, String> r13) {
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().a(this.f37995e, this, r10, r11, r12, a(r14));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private String a(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        String r6 = "";
        if (r4 == null) goto L12;
        Iterator r7 = r4.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin");
        if (r2.isEmpty() == true) goto L6;
        if (r3.isEmpty() == true) goto L6;
        r6 = r2 + ":" + r3 + "\r\n" + r6;
    L12:
        return r6;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(boolean r13, String r14, String r15, String r16, boolean r17, String r18) {
        Object r11 = this.f37992b;
        monitor-enter(r11);
        m.b().a(this.f37995e, this, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void e(int r4) {
        Object r0 = this.G;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.H != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.c r5 = TTThreadConfigInfoProvider.c.values()[r4];     // Catch: Throwable -> L16
        if (this.I.containsKey(r5) == false) goto L13;
        this.H.bindBigCore(((Integer) ZeusTransformUtils.preCheckCast(this.I.get(r5), Integer.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        this.f37991J.put(r5, TTThreadConfigInfoProvider.a.f37875b);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.h
    public void f(int r4) {
        Object r0 = this.G;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.H != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.c r5 = TTThreadConfigInfoProvider.c.values()[r4];     // Catch: Throwable -> L16
        if (this.I.containsKey(r5) == false) goto L13;
        this.H.bindLittleCore(((Integer) ZeusTransformUtils.preCheckCast(this.I.get(r5), Integer.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        this.f37991J.put(r5, TTThreadConfigInfoProvider.a.f37876c);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.h
    public void g(int r4) {
        Object r0 = this.G;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.H != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.c r5 = TTThreadConfigInfoProvider.c.values()[r4];     // Catch: Throwable -> L16
        if (this.I.containsKey(r5) == false) goto L13;
        this.H.resetCoreBind(((Integer) ZeusTransformUtils.preCheckCast(this.I.get(r5), Integer.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        this.f37991J.put(r5, TTThreadConfigInfoProvider.a.f37877d);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        Object r15 = this.f37992b;
        monitor-enter(r15);
        m.b().a(this.f37995e, this, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);     // Catch: Throwable -> L13
        monitor-exit(r15);     // Catch: Throwable -> L13
        return;
    L9:
        th = th;
    L11:
        monitor-exit(r15);     // Catch: Throwable -> L13
        throw th;
    L13:
        th = th;
        goto L11
    }

    @Override // com.ttnet.org.chromium.net.h
    public List<Long> i() {
        ArrayList r0 = new ArrayList();
        Object r6 = this.f37992b;
        monitor-enter(r6);
        long[] r1 = m.b().a();     // Catch: Throwable -> L9
        int r2 = r1.length;     // Catch: Throwable -> L9
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        r0.add(Long.valueOf(r1[r3]));     // Catch: Throwable -> L9
        r3 = r3 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r6);     // Catch: Throwable -> L9
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void h(int r5) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().a(this.f37995e, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void j() {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().c(this.f37995e, this);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void d(String r5) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().d(this.f37995e, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37) {
        Object r15 = this.f37992b;
        monitor-enter(r15);
        v();     // Catch: Throwable -> L9
        m.b().a(this.f37995e, this, r23, r25, r27, r29, r31, r33, r35, r37);     // Catch: Throwable -> L13
        monitor-exit(r15);     // Catch: Throwable -> L13
        return;
    L9:
        th = th;
    L11:
        monitor-exit(r15);     // Catch: Throwable -> L13
        throw th;
    L13:
        th = th;
        goto L11
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(String r8, String r9) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        m.b().a(this.f37995e, this, r8, r9);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(String[] r10, int r11, long r12) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        v();     // Catch: Throwable -> L7
        m.b().a(this.f37995e, this, r10, r11, r12);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.h
    public void a(String[] r8, int r9) {
        Object r0 = this.f37992b;
        monitor-enter(r0);
        v();     // Catch: Throwable -> L7
        m.b().a(this.f37995e, this, r8, r9);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onRttObservation(final int r12, final long r13, final int r15) {
        Object r0 = this.h;
        monitor-enter(r0);
        Iterator<VersionSafeCallbacks.c> r1 = this.n.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        final VersionSafeCallbacks.c r2 = (VersionSafeCallbacks.c) ZeusTransformUtils.preCheckCast(r1.next(), VersionSafeCallbacks.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Runnable r10 = new AnonymousClass3(this, r2, r12, r13, r15);     // Catch: Throwable -> L10
        a(r2.a(), r10);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onThroughputObservation(final int r12, final long r13, final int r15) {
        Object r0 = this.h;
        monitor-enter(r0);
        Iterator<VersionSafeCallbacks.d> r1 = this.o.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        final VersionSafeCallbacks.d r2 = (VersionSafeCallbacks.d) ZeusTransformUtils.preCheckCast(r1.next(), VersionSafeCallbacks.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Runnable r10 = new AnonymousClass4(this, r2, r12, r13, r15);     // Catch: Throwable -> L10
        a(r2.a(), r10);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void a(final com.ttnet.org.chromium.net.w r5) {
        Object r0 = this.i;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.p.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        ArrayList r1 = new ArrayList(this.p.values());     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        final VersionSafeCallbacks.e r3 = (VersionSafeCallbacks.e) ZeusTransformUtils.preCheckCast(r2.next(), VersionSafeCallbacks.e.class, "com.obric.aiagent.plugin");
        Runnable r4 = new AnonymousClass5(this, r3, r5);
        a(r3.a(), r4);
        goto L12
    }

    private static void a(Executor r2, Runnable r3) {
        ((Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.aiagent.plugin")).execute((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(f37990a, "Exception posting task to executor", new Object[]{e});
    }

    public boolean a(Thread r1) {
        if (r1 != this.f) goto L5;
        return true;
    L5:
        return false;
    }
}
