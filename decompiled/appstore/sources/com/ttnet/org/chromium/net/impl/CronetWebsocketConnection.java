package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.w;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("cronet")
public final class CronetWebsocketConnection extends w {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f18668t = "CronetWebsocketConnection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w.b f18670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f18671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f18672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f18675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f18677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f18679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f18680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map f18681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map f18682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f18683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f18684p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CronetUrlRequestContext f18685q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Object f18686r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AtomicInteger f18687s;

    public interface Natives {
        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addGetParam(long r10, CronetWebsocketConnection r11, String r12, String r13);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addHeader(long r10, CronetWebsocketConnection r11, String r12, String r13);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addUrl(long r10, CronetWebsocketConnection r11, String r12);

        long createWebsocketConnectionAdapter(CronetWebsocketConnection r10, long r11);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void destroy(long r10, CronetWebsocketConnection r11);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void sendBinary(long r10, CronetWebsocketConnection r11, ByteBuffer r12);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void sendText(long r10, CronetWebsocketConnection r11, String r12);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void startWithFrontier(long r10, CronetWebsocketConnection r11, int r12, String r13, long r14, int r15, long r16, String r17, int r18, String r19, boolean r110);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void startWithWSChannel(long r10, CronetWebsocketConnection r11, boolean r12);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void stop(long r10, CronetWebsocketConnection r11);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CronetWebsocketConnection f18690c;

        public a(CronetWebsocketConnection r10, int r11, String r12) {
            this.f18690c = r10;
            this.f18688a = r11;
            this.f18689b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetWebsocketConnection.g(this.f18690c).b(this.f18690c, this.f18688a, this.f18689b);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetWebsocketConnection.h(), "Exception in callback: ", new Object[]{e});
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f18693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CronetWebsocketConnection f18694d;

        public b(CronetWebsocketConnection r10, int r11, String r12, String r13) {
            this.f18694d = r10;
            this.f18691a = r11;
            this.f18692b = r12;
            this.f18693c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetWebsocketConnection.g(this.f18694d).a(this.f18694d, this.f18691a, this.f18692b, this.f18693c);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetWebsocketConnection.h(), "Exception in callback: ", new Object[]{e});
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f18695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f18696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CronetWebsocketConnection f18697c;

        public c(CronetWebsocketConnection r10, ByteBuffer r11, int r12) {
            this.f18697c = r10;
            this.f18695a = r11;
            this.f18696b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetWebsocketConnection.g(this.f18697c).d(this.f18697c, this.f18695a, this.f18696b);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetWebsocketConnection.h(), "Exception in callback: ", new Object[]{e});
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetWebsocketConnection f18699b;

        public d(CronetWebsocketConnection r10, String r11) {
            this.f18699b = r10;
            this.f18698a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetWebsocketConnection.g(this.f18699b).c(this.f18699b, this.f18698a);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetWebsocketConnection.h(), "Exception in callback: ", new Object[]{e});
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f18701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f18702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f18703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CronetWebsocketConnection f18704e;

        public e(CronetWebsocketConnection r10, String r11, long r12, long r13, boolean r14) {
            this.f18704e = r10;
            this.f18700a = r11;
            this.f18701b = r12;
            this.f18702c = r13;
            this.f18703d = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetWebsocketConnection.g(this.f18704e).e(this.f18704e, this.f18700a, this.f18701b, this.f18702c, this.f18703d);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetWebsocketConnection.h(), "Exception in callback: ", new Object[]{e});
        }
    }

    static {
    }

    public CronetWebsocketConnection(CronetUrlRequestContext r10, w.b r11, Executor r12, List r13, int r14, String r15, long r16, int r17, long r18, String r19, int r110, String r111, Map r112, Map r113, boolean r20) {
        this.f18684p = true;
        this.f18686r = new Object();
        this.f18687s = new AtomicInteger(-1);
        this.f18685q = r10;
        this.f18670b = r11;
        this.f18671c = r12;
        this.f18672d = r13;
        this.f18673e = r14;
        this.f18674f = r15;
        this.f18675g = r16;
        this.f18676h = r17;
        this.f18677i = r18;
        this.f18678j = r19;
        this.f18679k = r110;
        this.f18680l = r111;
        this.f18681m = r112;
        this.f18682n = r113;
        this.f18683o = r20;
    }

    public static /* synthetic */ w.b g(CronetWebsocketConnection r10) {
        return r10.f18670b;
    }

    public static /* synthetic */ String h() {
        return f18668t;
    }

    @CalledByNative
    private void onConnectionError(int r10, String r11, String r12) {
        StringBuilder r13 = new StringBuilder();
        r13.append("onConnectionError: ");
        r13.append(r12);
        this.f18687s.set(r10);
        j(new b(this, r10, r11, r12));
    }

    @CalledByNative
    private void onConnectionStateChanged(int r10, String r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append("onConnectionStateChanged: state = ");
        r12.append(r10);
        r12.append(", url = ");
        r12.append(r11);
        this.f18687s.set(r10);
        j(new a(this, r10, r11));
    }

    @CalledByNative
    private void onFeedbackLog(String r10) {
        j(new d(this, r10));
    }

    @CalledByNative
    private void onMessageReceived(ByteBuffer r10, int r11) {
        j(new c(this, i(r10), r11));
    }

    @CalledByNative
    private void onTrafficChanged(String r10, long r11, long r13, boolean r15) {
        j(new e(this, r10, r11, r13, r15));
    }

    @Override // com.ttnet.org.chromium.net.w
    public void a(ByteBuffer r10) {
        Object r11 = this.f18686r;
        monitor-enter(r11);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18669a != 0) goto L10;
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L10:
        h.b().sendBinary(this.f18669a, this, r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
    }

    @Override // com.ttnet.org.chromium.net.w
    public void b(String r10) {
        Object r11 = this.f18686r;
        monitor-enter(r11);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18669a != 0) goto L10;
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L10:
        h.b().sendText(this.f18669a, this, r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
    }

    @Override // com.ttnet.org.chromium.net.w
    public void c() {
        Object r10 = this.f18686r;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18669a != 0) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        h.b().destroy(this.f18669a, this);     // Catch: Throwable -> L8
        this.f18669a = 0;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    }

    @Override // com.ttnet.org.chromium.net.w
    public boolean d() {
        if (this.f18687s.get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ttnet.org.chromium.net.w
    public void e() {
        Object r15 = this.f18686r;
        monitor-enter(r15);
    L30:
        th = th;
    L35:
        monitor-exit(r15);     // Catch: Throwable -> L30
        throw th;
    L7:
        th = th;
        goto L35
    L5:
        if (this.f18669a != 0) goto L9;
        this.f18669a = h.b().createWebsocketConnectionAdapter(this, this.f18685q.Y());     // Catch: Throwable -> L7
    L9:
        Iterator r10 = this.f18672d.iterator();     // Catch: Throwable -> L7
    L11:
        if (r10.hasNext() == false) goto L13;
        String r11 = (String) r10.next();     // Catch: Throwable -> L7
        h.b().addUrl(this.f18669a, this, r11);     // Catch: Throwable -> L7
        goto L11
    L13:
        Map r12 = this.f18681m;     // Catch: Throwable -> L7
        if (r12 == null) goto L19;
        Iterator r13 = r12.entrySet().iterator();     // Catch: Throwable -> L7
    L17:
        if (r13.hasNext() == false) goto L19;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L7
        h.b().addGetParam(this.f18669a, this, (String) r14.getKey(), (String) r14.getValue());     // Catch: Throwable -> L7
    L19:
        Map r16 = this.f18682n;     // Catch: Throwable -> L7
        if (r16 == null) goto L26;
        Iterator r17 = r16.entrySet().iterator();     // Catch: Throwable -> L7
    L23:
        if (r17.hasNext() == false) goto L26;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L7
        h.b().addHeader(this.f18669a, this, (String) r18.getKey(), (String) r18.getValue());     // Catch: Throwable -> L7
    L26:
        if (this.f18684p == false) goto L32;
        h.b().startWithFrontier(this.f18669a, this, this.f18673e, this.f18674f, this.f18675g, this.f18676h, this.f18677i, this.f18678j, this.f18679k, this.f18680l, this.f18683o);     // Catch: Throwable -> L30
    L33:
        monitor-exit(r15);     // Catch: Throwable -> L30
        return;
    L32:
        h.b().startWithWSChannel(this.f18669a, this, this.f18683o);     // Catch: Throwable -> L30
        goto L33
    }

    @Override // com.ttnet.org.chromium.net.w
    public void f() {
        Object r10 = this.f18686r;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18669a != 0) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        h.b().stop(this.f18669a, this);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    }

    public final ByteBuffer i(ByteBuffer r10) {
        ByteBuffer r11 = ByteBuffer.allocate(r10.capacity());
        r10.rewind();
        r11.put(r10);
        r11.flip();
        return r11;
    }

    public final void j(Runnable r10) {
        this.f18671c.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a(f18668t, "Exception posting task to executor", new Object[]{e});
    }

    public CronetWebsocketConnection(CronetUrlRequestContext r10, w.b r11, Executor r12, List r13, Map r14, Map r15, boolean r16) {
        this.f18684p = true;
        this.f18686r = new Object();
        this.f18687s = new AtomicInteger(-1);
        this.f18685q = r10;
        this.f18670b = r11;
        this.f18671c = r12;
        this.f18672d = r13;
        this.f18681m = r14;
        this.f18682n = r15;
        this.f18683o = r16;
        this.f18684p = false;
    }
}
