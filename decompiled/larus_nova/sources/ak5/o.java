package ak5;

import android.os.SystemClock;
import com.bytedance.ee.bear.thread.BearExecutors;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lr5.f f4040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interceptor f4042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public okhttp3.h f4044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4045f;

    public final lr5.f b() {
        monitor-enter(this);
        lr5.f r100 = this.f4040a;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return r100;
    L7:
        a();     // Catch: Throwable -> L10
        lr5.f r101 = this.f4040a;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public final void a() {
        lr5.b.c();
        lr5.f r100 = this.f4040a;
        if (r100 != null) goto L5;
        r100 = lr5.b.b();
    L5:
        lr5.a r101 = r100.b();
        Dispatcher r102 = new Dispatcher(BearExecutors.d());
        r102.setMaxRequestsPerHost(this.f4045f);
        r101.f510400a.dispatcher(r102);
        okhttp3.h r103 = this.f4044e;
        if (r103 == null) goto L8;
        r101.f510400a.cookieJar(r103);
    L8:
        Interceptor r104 = this.f4042c;
        if (r104 == null) goto L11;
        r101.f510400a.addInterceptor(r104);
    L11:
        long r105 = this.f4041b;
        if (r105 <= 10000) goto L14;
        TimeUnit r106 = TimeUnit.MILLISECONDS;
        r101.f510400a.connectTimeout(r105, r106);
        long r107 = this.f4041b;
        r101.f510400a.readTimeout(r107, r106);
        long r108 = this.f4041b;
        r101.f510400a.writeTimeout(r108, r106);
    L14:
        monitor-enter(this);
        this.f4040a = r101.a();     // Catch: Throwable -> L18
        this.f4043d = SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        this.f4040a.dispatcher().setIdleCallback(new n(this));     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public o(int r100) {
        this.f4045f = r100;
    }
}
