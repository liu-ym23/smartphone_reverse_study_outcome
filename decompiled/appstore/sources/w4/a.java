package w4;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.intercept.Interceptor;
import f6.f;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Interceptor {
    public a() {
    }

    public g6.b a(g6.b r10) {
        if (NetworkParams.j() == true) goto L5;
    L9:
        if (r10 != null) goto L11;
        return r10;
    L11:
        long r11 = SystemClock.uptimeMillis();
        String r12 = r10.D();
        if ((r10.s() instanceof o4.a) == false) goto L14;
        String r13 = NetworkParams.d(r12, (o4.a) r10.s());
    L16:
        if (r10.y() == null) goto L19;
        RetrofitMetrics r14 = r10.y();
        r14.f7919z = SystemClock.uptimeMillis() - r11;
    L19:
        if (r10.D().startsWith("https:") == true) goto L21;
    L23:
        long r15 = SystemClock.uptimeMillis();
        if (r10.F() == false) goto L27;
        p4.b.b().a();
        r13 = c(r13);
    L27:
        if (r10.y() == null) goto L29;
        RetrofitMetrics r16 = r10.y();
        r16.A = SystemClock.uptimeMillis() - r15;
    L29:
        g6.b.a r17 = r10.J();
        r17.c(r13);
        return r17.a();
    L21:
        if (r13.startsWith("http:") == false) goto L23;
        URL r18 = new URL(r13);     // Catch: Throwable -> L31
        NetworkParams.r(r18.getHost(), r18.getPath(), true);     // Catch: Throwable -> L31
        goto L23
    L14:
        r13 = NetworkParams.c(r12);
        goto L16
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L9;
        throw new IOException("You must not send request on main thread");
    }

    public void b(g6.b r10, f r11) {
    }

    public final String c(String r10) {
        return NetworkParams.a(r10, true);
    L5:
        th = move-exception;
        th.printStackTrace();
        return r10;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public f intercept(Interceptor.Chain r10) {
        long r11 = SystemClock.uptimeMillis();
        g6.b r12 = r10.request();
        URL r13 = new URL(r12.D());     // Catch: MalformedURLException -> L13
        if (r13.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L6;
        NetworkParams.r(r13.getHost(), r13.getPath(), false);     // Catch: MalformedURLException -> L13
    L6:
        g6.b r14 = a(r12);
        if (r14.y() == null) goto L9;
        r14.y().f7917x.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r11));
    L9:
        f r15 = r10.proceed(r14);
        long r16 = SystemClock.uptimeMillis();
        b(r14, r15);
        if (r14.y() == null) goto L12;
        r14.y().f7918y.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r16));
    L12:
        return r15;
    }
}
