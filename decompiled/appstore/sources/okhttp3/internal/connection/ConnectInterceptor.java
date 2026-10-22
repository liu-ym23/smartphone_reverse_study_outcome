package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectInterceptor implements Interceptor {
    public final OkHttpClient client;

    public ConnectInterceptor(OkHttpClient r10) {
        this.client = r10;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) throws IOException {
        RealInterceptorChain r11 = (RealInterceptorChain) r10;
        Request r12 = r11.request();
        StreamAllocation r13 = r11.streamAllocation();
        return r11.proceed(r12, r13, r13.newStream(this.client, r10, !r12.g().equals("GET")), r13.connection());
    }
}
