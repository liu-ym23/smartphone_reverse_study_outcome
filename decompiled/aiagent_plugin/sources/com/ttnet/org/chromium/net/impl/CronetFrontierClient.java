package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class CronetFrontierClient {
    private static final String TAG = "CronetFrontierClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f37938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f37939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f37941e;
    private String f;
    private String g;
    private String h;
    private int i;
    private int j;
    private Map<String, String> k;
    private e l;
    private Map<Integer, ad> m;
    private b n;
    private List<Integer> o;
    private String p;
    private String q;
    private boolean r;
    private long s;
    private final Object t;
    private AtomicInteger u;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetFrontierClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f37942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f37943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f37944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f37945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f37946e;
        private String f;
        private String g;
        private String h;
        private int i;
        private int j;
        private Map<String, String> k;
        private e l;
        private b m;
        private List<Integer> n;
        private String o;
        private String p;
        private boolean q;

        static /* synthetic */ int a(a r0) {
            return r0.f37942a;
        }

        static /* synthetic */ int b(a r0) {
            return r0.f37943b;
        }

        static /* synthetic */ String c(a r0) {
            return r0.f37944c;
        }

        static /* synthetic */ int d(a r0) {
            return r0.f37945d;
        }

        static /* synthetic */ String e(a r0) {
            return r0.f37946e;
        }

        static /* synthetic */ String f(a r0) {
            return r0.f;
        }

        static /* synthetic */ String g(a r0) {
            return r0.g;
        }

        static /* synthetic */ String h(a r0) {
            return r0.h;
        }

        static /* synthetic */ int i(a r0) {
            return r0.i;
        }

        static /* synthetic */ int j(a r0) {
            return r0.j;
        }

        static /* synthetic */ Map k(a r0) {
            return r0.k;
        }

        static /* synthetic */ e l(a r0) {
            return r0.l;
        }

        static /* synthetic */ b m(a r0) {
            return r0.m;
        }

        static /* synthetic */ List n(a r0) {
            return r0.n;
        }

        static /* synthetic */ String o(a r0) {
            return r0.o;
        }

        static /* synthetic */ String p(a r0) {
            return r0.p;
        }

        static /* synthetic */ boolean q(a r0) {
            return r0.q;
        }

        a(int r2, int r3, String r4, int r5, String r6, String r7, String r8) {
            this.l = e.f37947a;
            if (r2 <= 0) goto L19;
            if (r3 <= 0) goto L19;
            if (r5 <= 0) goto L19;
            if (TextUtils.isEmpty(r4) == true) goto L17;
            if (TextUtils.isEmpty(r6) == true) goto L17;
            if (TextUtils.isEmpty(r7) == true) goto L17;
            if (TextUtils.isEmpty(r8) == true) goto L17;
            this.f37942a = r2;
            this.f37943b = r3;
            this.f37945d = r5;
            this.f37944c = r4;
            this.f37946e = r6;
            this.f = r7;
            this.g = r8;
            return;
        L17:
            throw new IllegalArgumentException("Host, appVersion, appKey and deviceId must not be empty.");
        L19:
            throw new IllegalArgumentException("Appid, fpid and port must be set greater than 0.");
        }

        public static a a(int r9, int r10, String r11, int r12, String r13, String r14, String r15) {
            return new a(r9, r10, r11, r12, r13, r14, r15);
        }

        public a a(int r1) {
            this.i = r1;
            return this;
        }

        public a b(int r1) {
            this.j = r1;
            return this;
        }

        public a a(Map<String, String> r3) {
            this.k = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(e r1) {
            this.l = r1;
            return this;
        }

        public a a(b r3) {
            this.m = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(List<Integer> r3) {
            this.n = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(boolean r1) {
            this.q = r1;
            return this;
        }

        public a query(String r1) {
            this.o = r1;
            return this;
        }

        public a a(String r1) {
            this.p = r1;
            return this;
        }

        public CronetFrontierClient a() {
            return new CronetFrontierClient(this, null);
        }
    }

    public interface b {
        void a(int r1, String r2);

        void a(int r1, String r2, String r3);

        void a(String r1, long r2, long r4, boolean r6);
    }

    public interface c {
        void a(int r1, int r2, String r3);

        void a(int r1, long r2, String r4, Boolean r5);

        void a(int r1, String r2);

        void a(int r1, Map<String, String> r2, byte[] r3);
    }

    interface d {
        long a(CronetFrontierClient r1);

        void a(long r1, CronetFrontierClient r3);

        void a(long r1, CronetFrontierClient r3, int r4);

        void a(long r1, CronetFrontierClient r3, int r4, int r5, String r6, int r7, String r8, String r9, String r10, String r11, int r12, int r13, int r14, boolean r15, String r16, String r17);

        void a(long r1, CronetFrontierClient r3, int r4, String[] r5, ByteBuffer r6);

        void a(long r1, CronetFrontierClient r3, String r4, String r5);

        void a(long r1, CronetFrontierClient r3, boolean r4);

        void a(long r1, CronetFrontierClient r3, String[] r4, ByteBuffer r5, int r6, int r7, boolean r8);
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f37947a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f37948b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f37949c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f37950d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final e f37951e = null;
        private static final /* synthetic */ e[] g = null;
        final int f;

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(g.clone(), e[].class, "com.obric.aiagent.plugin");
        }

        static {
            e r0 = new e("UNKNOWN", 0, -1);
            f37947a = r0;
            e r1 = new e("QUIC", 1, 0);
            f37948b = r1;
            e r3 = new e("TLS", 2, 1);
            f37949c = r3;
            e r5 = new e("HTTP2", 3, 2);
            f37950d = r5;
            e r7 = new e("SPDY", 4, 3);
            f37951e = r7;
            g = new e[]{r0, r1, r3, r5, r7};
        }

        private e(String r1, int r2, int r3) {
            super(r1, r2);
            this.f = r3;
        }

        public int a() {
            return this.f;
        }
    }

    static {
    }

    /* synthetic */ CronetFrontierClient(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    private CronetFrontierClient(a r3) {
        this.l = e.f37947a;
        this.m = new ConcurrentHashMap();
        this.t = new Object();
        this.u = new AtomicInteger(0);
        this.f37937a = a.a(r3);
        this.f37938b = a.b(r3);
        this.f37939c = a.c(r3);
        this.f37940d = a.d(r3);
        this.f37941e = a.e(r3);
        this.f = a.f(r3);
        this.g = a.g(r3);
        this.h = a.h(r3);
        this.i = a.i(r3);
        this.j = a.j(r3);
        this.k = a.k(r3);
        this.l = a.l(r3);
        this.n = a.m(r3);
        this.o = a.n(r3);
        this.p = a.o(r3);
        this.q = a.p(r3);
        this.r = a.q(r3);
        c();
    }

    public void a(ad r13, ByteBuffer r14, String[] r15) {
        Object r0 = this.t;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.s != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.m.put(Integer.valueOf(r13.f38089a), r13);     // Catch: Throwable -> L11
        f.a().a(this.s, this, r15, r14, r13.f38089a, r13.f38092d.a(), r13.f38090b);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public boolean a(int r1) {
        return this.m.containsKey(Integer.valueOf(r1));
    }

    public void a(int r9, String[] r10, ByteBuffer r11) {
        Object r0 = this.t;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.s != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        f.a().a(this.s, this, r9, r10, r11);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void a() {
        Object r0 = this.t;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.s != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        f.a().a(this.s, this);     // Catch: Throwable -> L11
        this.s = 0;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void a(boolean r6) {
        Object r0 = this.t;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.s != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        f.a().a(this.s, this, r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    private void c() {
        Object r15 = this.t;
        monitor-enter(r15);
    L32:
        th = th;
    L30:
        monitor-exit(r20);     // Catch: Throwable -> L32
        throw th;
    L28:
        th = th;
        Object r20 = r15;
        goto L30
    L5:
        if (this.s != 0) goto L7;
        this.s = f.a().a(this);     // Catch: Throwable -> L28
    L7:
        Map<String, String> r1 = this.k;     // Catch: Throwable -> L28
        if (r1 == null) goto L13;
        Iterator<Map.Entry<String, String>> r7 = r1.entrySet().iterator();     // Catch: Throwable -> L28
    L11:
        if (r7.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        f.a().a(this.s, this, (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L28
    L13:
        List<Integer> r3 = this.o;     // Catch: Throwable -> L28
        if (r3 == null) goto L19;
        Iterator<Integer> r4 = r3.iterator();     // Catch: Throwable -> L28
    L17:
        if (r4.hasNext() == false) goto L19;
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4.next(), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        f.a().a(this.s, this, r5.intValue());     // Catch: Throwable -> L28
    L19:
        f.a().a(this.s, this, this.f37937a, this.f37938b, this.f37939c, this.f37940d, this.f37941e, this.f, this.g, this.h, this.i, this.j, this.l.a(), this.r, this.p, this.q);     // Catch: Throwable -> L32
        monitor-exit(r15);     // Catch: Throwable -> L32
        return;
    L26:
        th = th;
        r20 = r15;
        goto L30
    }

    private void onServiceReady(int r3, String r4) {
        ad r2 = (ad) ZeusTransformUtils.preCheckCast(this.m.get(Integer.valueOf(r3)), ad.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        r2.f38091c = true;
        r2.f38093e.a(r3, r4);
    }

    private void onReceivedMessage(int r6, String[] r7, ByteBuffer r8, int r9) {
        ad r5 = (ad) ZeusTransformUtils.preCheckCast(this.m.get(Integer.valueOf(r6)), ad.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = r7.length;
        if ((r0 % 2) == 0) goto L9;
        a(TAG, "length is not even number:" + r0);
        return;
    L9:
        HashMap r1 = new HashMap();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L17;
        if (TextUtils.isEmpty(r7[r2]) == true) goto L16;
        int r3 = r2 + 1;
        if (TextUtils.isEmpty(r7[r3]) == true) goto L16;
        r1.put(r7[r2], r7[r3]);
    L16:
        r2 = r2 + 2;
        goto L10
    L17:
        byte[] r10 = new byte[r8.capacity()];
        r8.get(r10);
        if (r9 < 0) goto L20;
        r6 = r9;
    L20:
        r5.f38093e.a(r6, r1, r10);
    }

    private void onReceivedAck(int r7, long r8, String r10, boolean r11) {
        if (r11 == false) goto L4;
        return;
    L4:
        ad r6 = (ad) ZeusTransformUtils.preCheckCast(this.m.get(Integer.valueOf(r7)), ad.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        return;
    L7:
        r6.f38093e.a(r7, r8, r10, Boolean.valueOf(r11));
    }

    private void onError(int r3, int r4, String r5) {
        ad r2 = (ad) ZeusTransformUtils.preCheckCast(this.m.get(Integer.valueOf(r3)), ad.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        r2.f38091c = false;
        r2.f38093e.a(r3, r4, r5);
    }

    private void onConnectionStateChanged(int r4, String r5) {
        b(TAG, "onConnectionStateChanged: state = " + r4 + ", url = " + r5);
        this.u.set(r4);
        this.n.a(r4, r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a(TAG, "Exception in callback: ", e);
    }

    private void onConnectionError(int r4, String r5, String r6) {
        a(TAG, "onConnectionError: " + r6);
        this.u.set(r4);
        this.n.a(r4, r5, r6);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a(TAG, "Exception in callback: ", e);
    }

    private void onTrafficChanged(String r10, long r11, long r13, boolean r15) {
        b(TAG, "OnTrafficChanged");
        this.n.a(r10, r11, r13, r15);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a(TAG, "Exception in callback: ", e);
    }

    public boolean b() {
        if (this.u.get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
