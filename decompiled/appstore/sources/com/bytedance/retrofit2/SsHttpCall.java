package com.bytedance.retrofit2;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class SsHttpCall implements Call, IMetricsCollect, IRequestInfo {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static IHttpCallThrottleControl f7920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static IHttpCallReqLevelControl f7921i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f7923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f7924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g6.b f7925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f7926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f6.a f7927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f7928g;

    public interface IHttpCallReqLevelControl {
        int getRequestLevel(String r10);

        boolean isReqLevelControllerEnable();

        boolean maybeAddP1AsyncRequest(Executor r10, Runnable r11);

        void notifyRequestBack(int r10);

        void p1WaitP0Done();
    }

    public interface IHttpCallThrottleControl {
        int getDelayTimeByApp(String r10);

        int getDispatchDelayTime(String r10, String r11);

        boolean isAppDelayHandleEnable();

        boolean isDispatchDelayEnabled();
    }

    public class a implements SsRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RetrofitMetrics f7929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExpandCallback f7930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Callback f7931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SsHttpCall f7932d;

        public a(SsHttpCall r10, RetrofitMetrics r11, ExpandCallback r12, Callback r13) {
            this.f7932d = r10;
            this.f7929a = r11;
            this.f7930b = r12;
            this.f7931c = r13;
        }

        public final void a(Throwable r10) {
            this.f7931c.onFailure(this.f7932d, r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        public final void b(f6.f r10) {
            this.f7931c.onResponse(this.f7932d, r10);     // Catch: Throwable -> L6
            ExpandCallback r11 = this.f7930b;     // Catch: Throwable -> L6
            if (r11 == null) goto L11;
            r11.onAsyncResponse(this.f7932d, r10);     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public int getRequestDelayTime() {
            int r10 = 0;
            if (SsHttpCall.i() != null) goto L5;
        L24:
            this.f7929a.f7909p = r10;
            return r10;
        L5:
            if (SsHttpCall.i().isAppDelayHandleEnable() == false) goto L12;
            if (SsHttpCall.c(this.f7932d) == null) goto L24;
            if (TextUtils.isEmpty(SsHttpCall.c(this.f7932d).z()) == true) goto L24;
            r10 = SsHttpCall.i().getDelayTimeByApp(SsHttpCall.c(this.f7932d).z());
            goto L24
        L12:
            if (SsHttpCall.i().isDispatchDelayEnabled() == false) goto L24;
            if (SsHttpCall.c(this.f7932d) == null) goto L24;
            List r11 = SsHttpCall.c(this.f7932d).E("x-tt-request-tag");
            if (r11 != null) goto L18;
        L22:
            String r12 = "";
        L23:
            r10 = SsHttpCall.i().getDispatchDelayTime(SsHttpCall.c(this.f7932d).D(), r12);
            goto L24
        L18:
            if (r11.size() < 1) goto L22;
            if (TextUtils.isEmpty(((g6.a) r11.get(0)).b()) == true) goto L22;
            r12 = ((g6.a) r11.get(0)).b();
            goto L23
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public boolean isStreaming() {
            return SsHttpCall.f(this.f7932d).f8033h;
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public int priority() {
            return SsHttpCall.f(this.f7932d).f8030e;
        }

        @Override // java.lang.Runnable
        public void run() {
        L7:
            th = move-exception;
            a(th);
            return;
        L3:
            if (SsHttpCall.a(this.f7932d) != null) goto L17;
            if (SsHttpCall.c(this.f7932d) != null) goto L9;
            RetrofitMetrics r10 = this.f7929a;     // Catch: Throwable -> L7
            r10.f7911r = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
            SsHttpCall r11 = this.f7932d;     // Catch: Throwable -> L7
            SsHttpCall.d(r11, SsHttpCall.f(r11).f(this.f7930b, SsHttpCall.e(this.f7932d)));     // Catch: Throwable -> L7
            RetrofitMetrics r12 = this.f7929a;     // Catch: Throwable -> L7
            r12.f7912s = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        L9:
            f6.f r13 = this.f7932d.k();     // Catch: Throwable -> L7
            if (SsHttpCall.g() != null) goto L12;
        L14:
            b(r13);
            return;
        L12:
            if (SsHttpCall.g().isReqLevelControllerEnable() == false) goto L14;
            SsHttpCall.g().notifyRequestBack(SsHttpCall.h(this.f7932d));     // Catch: Throwable -> L7
            goto L14
        L17:
            throw SsHttpCall.a(this.f7932d);     // Catch: Throwable -> L7
        }
    }

    public class b implements SsRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandCallback f7933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f7934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f7935c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SsHttpCall f7936d;

        public b(SsHttpCall r10, ExpandCallback r11, Executor r12, Runnable r13) {
            this.f7936d = r10;
            this.f7933a = r11;
            this.f7934b = r12;
            this.f7935c = r13;
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public int getRequestDelayTime() {
            return 0;
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public boolean isStreaming() {
            return SsHttpCall.f(this.f7936d).f8033h;
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public int priority() {
            return SsHttpCall.f(this.f7936d).f8030e;
        }

        @Override // java.lang.Runnable
        public void run() {
        L6:
            th = move-exception;
            SsHttpCall.b(this.f7936d, th);
        L8:
            this.f7934b.execute(this.f7935c);
            return;
        L3:
            if (SsHttpCall.c(this.f7936d) != null) goto L8;
            RetrofitMetrics r10 = SsHttpCall.f(this.f7936d).b();     // Catch: Throwable -> L6
            r10.f7911r = SystemClock.uptimeMillis();     // Catch: Throwable -> L6
            SsHttpCall r11 = this.f7936d;     // Catch: Throwable -> L6
            SsHttpCall.d(r11, SsHttpCall.f(r11).f(this.f7933a, SsHttpCall.e(this.f7936d)));     // Catch: Throwable -> L6
            r10.f7912s = SystemClock.uptimeMillis();     // Catch: Throwable -> L6
            goto L8
        }
    }

    public SsHttpCall(g r10, Object[] r11) {
        this.f7922a = -1;
        this.f7923b = r10;
        this.f7924c = r11;
        this.f7927f = new f6.a(r10);
    }

    public static /* synthetic */ Throwable a(SsHttpCall r10) {
        return r10.f7926e;
    }

    public static /* synthetic */ Throwable b(SsHttpCall r10, Throwable r11) {
        r10.f7926e = r11;
        return r11;
    }

    public static /* synthetic */ g6.b c(SsHttpCall r10) {
        return r10.f7925d;
    }

    public static /* synthetic */ g6.b d(SsHttpCall r10, g6.b r11) {
        r10.f7925d = r11;
        return r11;
    }

    public static /* synthetic */ Object[] e(SsHttpCall r10) {
        return r10.f7924c;
    }

    public static /* synthetic */ g f(SsHttpCall r10) {
        return r10.f7923b;
    }

    public static /* synthetic */ IHttpCallReqLevelControl g() {
        return f7921i;
    }

    public static /* synthetic */ int h(SsHttpCall r10) {
        return r10.f7922a;
    }

    public static /* synthetic */ IHttpCallThrottleControl i() {
        return f7920h;
    }

    public static void l(IHttpCallThrottleControl r10) {
        f7920h = r10;
    }

    @Override // com.bytedance.retrofit2.Call
    public void cancel() {
        f6.a r10 = this.f7927f;
        if (r10 == null) goto L6;
        r10.a();
        return;
    }

    @Override // com.bytedance.retrofit2.Call
    public /* bridge */ /* synthetic */ Call clone() {
        return j();
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        f6.a r10 = this.f7927f;
        if (r10 == null) goto L6;
        r10.doCollect();
        return;
    }

    @Override // com.bytedance.retrofit2.Call
    public void enqueue(Callback r10) {
        RetrofitMetrics r11 = this.f7923b.b();
        r11.f7907n = SystemClock.uptimeMillis();
        this.f7928g = System.currentTimeMillis();
        if (r10 == null) goto L49;
        f6.a r12 = this.f7927f;
        if (r12 != null) goto L7;
    L11:
        Executor r13 = this.f7923b.f8029d;
        if ((r10 instanceof ExpandCallback) == false) goto L14;
        ExpandCallback r14 = (ExpandCallback) r10;
    L15:
        a r15 = new a(this, r11, r14, r10);
        this.f7925d = this.f7923b.f(null, this.f7924c);     // Catch: IOException -> L18
    L20:
        IHttpCallReqLevelControl r16 = f7921i;
        if (r16 != null) goto L23;
    L37:
        IHttpCallThrottleControl r17 = f7920h;
        if (r17 != null) goto L40;
    L46:
        r13.execute(r15);
        return;
    L40:
        if (r17.isAppDelayHandleEnable() == true) goto L44;
        if (f7920h.isDispatchDelayEnabled() == false) goto L46;
    L44:
        if (this.f7922a != (-1)) goto L46;
        r13.execute(new b(this, r14, r13, r15));
        return;
    L23:
        if (r16.isReqLevelControllerEnable() == false) goto L37;
        g6.b r18 = this.f7925d;
        if (r18 == null) goto L37;
        if (TextUtils.isEmpty(r18.z()) == true) goto L37;
        int r19 = f7921i.getRequestLevel(this.f7925d.z());
        this.f7922a = r19;
        if (r19 != 2) goto L33;
        cancel();
        r10.onFailure(this, new IOException("Canceled by Requset Controller"));
        return;
    L33:
        if (r19 != 1) goto L37;
        if (f7921i.maybeAddP1AsyncRequest(r13, r15) == false) goto L37;
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L14:
        r14 = null;
        goto L15
    L7:
        if (r12.e() == false) goto L11;
        throw new IllegalStateException("Already executed.");
    L49:
        throw new NullPointerException("callback == null");
    }

    @Override // com.bytedance.retrofit2.Call
    public f6.f execute() {
        RetrofitMetrics r10 = this.f7923b.b();
        r10.f7908o = SystemClock.uptimeMillis();
        this.f7928g = System.currentTimeMillis();
        r10.f7911r = SystemClock.uptimeMillis();
        this.f7925d = this.f7923b.f(null, this.f7924c);
        r10.f7912s = SystemClock.uptimeMillis();
        IHttpCallReqLevelControl r11 = f7921i;
        if (r11 != null) goto L5;
    L16:
        IHttpCallThrottleControl r12 = f7920h;
        if (r12 != null) goto L19;
    L41:
        f6.f r13 = k();
        IHttpCallReqLevelControl r14 = f7921i;
        if (r14 != null) goto L44;
    L46:
        return r13;
    L44:
        if (r14.isReqLevelControllerEnable() == false) goto L46;
        f7921i.notifyRequestBack(this.f7922a);
        goto L46
    L19:
        if (this.f7922a != (-1)) goto L41;
        int r15 = 0;
        if (r12.isAppDelayHandleEnable() == false) goto L28;
        g6.b r16 = this.f7925d;
        if (r16 != null) goto L25;
    L40:
        long r17 = r15;
        r10.f7909p = r17;
        Thread.sleep(r17);
        goto L41
    L25:
        if (TextUtils.isEmpty(r16.z()) == true) goto L40;
        r15 = f7920h.getDelayTimeByApp(this.f7925d.z());
        goto L40
    L28:
        if (f7920h.isDispatchDelayEnabled() == false) goto L40;
        g6.b r18 = this.f7925d;
        if (r18 == null) goto L40;
        List r19 = r18.E("x-tt-request-tag");
        if (r19 != null) goto L34;
    L38:
        String r20 = "";
    L39:
        r15 = f7920h.getDispatchDelayTime(this.f7925d.D(), r20);
        goto L40
    L34:
        if (r19.size() < 1) goto L38;
        if (TextUtils.isEmpty(((g6.a) r19.get(0)).b()) == true) goto L38;
        r20 = ((g6.a) r19.get(0)).b();
        goto L39
    L5:
        if (r11.isReqLevelControllerEnable() == false) goto L16;
        g6.b r21 = this.f7925d;
        if (r21 == null) goto L16;
        if (TextUtils.isEmpty(r21.z()) == true) goto L16;
        int r22 = f7921i.getRequestLevel(this.f7925d.z());
        this.f7922a = r22;
        if (r22 == 2) goto L14;
        if (r22 != 1) goto L16;
        f7921i.p1WaitP0Done();
        goto L16
    L14:
        cancel();
        throw new IOException("Canceled by Requset Controller");
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        f6.a r10 = this.f7927f;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getRequestInfo();
    }

    @Override // com.bytedance.retrofit2.Call
    public boolean isCanceled() {
        f6.a r10 = this.f7927f;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.d() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.retrofit2.Call
    public synchronized boolean isExecuted() {
        monitor-enter(this);
        f6.a r10 = this.f7927f;     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        if (r10.e() == false) goto L10;
        boolean r11 = true;
    L11:
        monitor-exit(this);
        return r11;
    L10:
        r11 = false;
    L8:
        th = move-exception;
        throw th;
    }

    public SsHttpCall j() {
        return new SsHttpCall(this.f7923b, this.f7924c);
    }

    public f6.f k() {
        RetrofitMetrics r10 = this.f7923b.b();
        r10.f7910q = SystemClock.uptimeMillis();
        LinkedList r11 = new LinkedList();
        r11.addAll(this.f7923b.f8028c);
        r11.add(this.f7927f);
        r10.f7900g = this.f7928g;
        r10.f7901h = System.currentTimeMillis();
        this.f7925d.N(r10);
        f6.f r12 = new com.bytedance.retrofit2.intercept.a(r11, 0, this.f7925d, this, r10).proceed(this.f7925d);
        r12.f(r10);
        return r12;
    }

    @Override // com.bytedance.retrofit2.Call
    public g6.b request() {
        f6.a r10 = this.f7927f;
        if (r10 == null) goto L8;
        g6.b r11 = r10.g();
        if (r11 == null) goto L8;
        return r11;
    L8:
        if (this.f7925d != null) goto L19;
        RetrofitMetrics r12 = this.f7923b.b();     // Catch: IOException -> L11 RuntimeException -> L13
        r12.f7911r = SystemClock.uptimeMillis();     // Catch: IOException -> L11 RuntimeException -> L13
        this.f7925d = this.f7923b.f(null, this.f7924c);     // Catch: IOException -> L11 RuntimeException -> L13
        r12.f7912s = SystemClock.uptimeMillis();     // Catch: IOException -> L11 RuntimeException -> L13
    L11:
        e = move-exception;
        throw new RuntimeException("Unable to create request.", e);
    L13:
        e = move-exception;
        throw e;
    L19:
        return this.f7925d;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m7clone() {
        return j();
    }
}
