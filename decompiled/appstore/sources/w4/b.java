package w4;

import android.os.SystemClock;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.intercept.Interceptor;
import f6.f;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Interceptor {
    public b() {
    }

    public final g6.b a(g6.b r10) {
        if (r10 != null) goto L5;
        return r10;
    L5:
        if (r10.I() == false) goto L7;
        return r10;
    L7:
        return b(r10);
    }

    public final g6.b b(g6.b r10) {
        String r11 = r10.D();     // Catch: Throwable -> L5
        long r12 = SystemClock.uptimeMillis();     // Catch: Throwable -> L5
        String r13 = NetworkParams.F(r11, r10.F(), new Object[]{r10.r()});     // Catch: Throwable -> L5
        if (r10.y() == null) goto L7;
        RetrofitMetrics r14 = r10.y();     // Catch: Throwable -> L5
        r14.B = SystemClock.uptimeMillis() - r12;     // Catch: Throwable -> L5
    L7:
        g6.b.a r15 = r10.J();     // Catch: Throwable -> L5
        r15.c(r13);     // Catch: Throwable -> L5
        return r15.a();
    L5:
        th = move-exception;
        th.printStackTrace();
        return r10;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public f intercept(Interceptor.Chain r10) {
        RetrofitMetrics r11 = r10.metrics();
        long r12 = SystemClock.uptimeMillis();
        g6.b r13 = a(r10.request());
        if (r11 == null) goto L6;
        r11.f7917x.put("RequestVerifyInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r12));
    L6:
        return r10.proceed(r13);
    }
}
