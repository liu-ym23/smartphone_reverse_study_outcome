package f6;

import android.os.SystemClock;
import com.bytedance.retrofit2.ExpandCallback;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class a implements Interceptor, IMetricsCollect, IRequestInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.retrofit2.g f19488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile SsCall f19489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g6.b f19490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f19491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f19492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f19493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f19494g;

    public a(com.bytedance.retrofit2.g r10) {
        this.f19488a = r10;
    }

    public void a() {
        this.f19491d = true;
        if (this.f19489b == null) goto L6;
        this.f19489b.cancel();
        return;
    }

    public final SsCall b(ExpandCallback r10, g6.b r11) {
        return this.f19488a.f8026a.get().newSsCall(r11);
    }

    public final g6.c c(SsCall r10, RetrofitMetrics r11) {
        if (r11 == null) goto L5;
        r11.f7913t = SystemClock.uptimeMillis();
    L5:
        return r10.execute();
    }

    public boolean d() {
        return this.f19491d;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        if ((this.f19489b instanceof IMetricsCollect) == false) goto L6;
        ((IMetricsCollect) this.f19489b).doCollect();
        return;
    }

    public synchronized boolean e() {
        monitor-enter(this);
        boolean r10 = this.f19493f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public f f(g6.c r10, RetrofitMetrics r11) {
        if (r10 == null) goto L25;
        TypedInput r12 = r10.a();
        int r13 = r10.e();
        if (r13 < 200) goto L23;
        if (r13 >= 300) goto L23;
        if (r13 == 204) goto L21;
        if (r13 == 205) goto L21;
        if (r11 == null) goto L15;
        r11.f7915v = SystemClock.uptimeMillis();
    L15:
        Object r14 = this.f19488a.g(r12);
        if (r11 == null) goto L19;
        r11.f7916w = SystemClock.uptimeMillis();
    L19:
        return f.g(r14, r10);
    L21:
        return f.g(null, r10);
    L23:
        return f.c(r12, r10);
    L25:
        throw new IOException("SsResponse is null");
    }

    public g6.b g() {
        return this.f19490c;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        if ((this.f19489b instanceof IRequestInfo) == false) goto L7;
        ((IRequestInfo) this.f19489b).getRequestInfo();
        return null;
    L7:
        return null;
    }

    public synchronized void h() {
        monitor-enter(this);
        this.f19493f = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public f intercept(Interceptor.Chain r10) {
        RetrofitMetrics r11 = r10.metrics();
        if (r11 == null) goto L5;
        r11.f7902i = System.currentTimeMillis();
    L5:
        long r12 = SystemClock.uptimeMillis();
        this.f19490c = r10.request();
        monitor-enter(this);
    L56:
        th = move-exception;
        throw th;
    L8:
        if (this.f19493f == true) goto L59;
        this.f19493f = true;     // Catch: Throwable -> L56
        monitor-exit(this);     // Catch: Throwable -> L56
        Throwable r13 = this.f19492e;
        if (r13 != null) goto L14;
        this.f19490c.N(r11);
        if (this.f19488a.f8038m == null) goto L24;
        if (r11 == null) goto L23;
        r11.f7917x.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r12));
    L23:
        g6.c r14 = this.f19488a.f8038m.getCacheResponse(this.f19490c);
    L25:
        if (r14 == null) goto L63;
    L52:
        long r15 = SystemClock.uptimeMillis();
        f r16 = f(r14, r11);
        if (r11 == null) goto L55;
        r11.f7918y.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r15));
    L55:
        return r16;
    L63:
        this.f19489b = b(null, this.f19490c);     // Catch: Throwable -> L30 Throwable -> L32
        if (this.f19494g <= 0) goto L35;
        this.f19489b.setThrottleNetSpeed(this.f19494g);     // Catch: Throwable -> L30 Throwable -> L32
    L35:
        if (this.f19491d == false) goto L37;
        this.f19489b.cancel();
    L37:
        if (r11 == null) goto L39;
        r11.f7917x.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r12));
    L39:
        r14 = c(this.f19489b, r11);
        ICacheServer r17 = this.f19488a.f8038m;
        if (r17 == null) goto L52;
        g6.c r18 = r17.putCacheResponse(this.f19490c, r14);
        if (r18 == null) goto L52;
        r14 = r18;
    L32:
        e = move-exception;
        this.f19492e = e;
        throw e;
    L30:
        th = move-exception;
        this.f19492e = th;
        if ((th instanceof Exception) == false) goto L49;
        throw th;
    L49:
        throw new Exception(th);
    L24:
        r14 = null;
        goto L25
    L14:
        if ((r13 instanceof IOException) == false) goto L18;
        throw ((IOException) r13);
    L18:
        throw new Exception(this.f19492e);
    L59:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L56
    }
}
