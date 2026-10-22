package okhttp3.internal.connection;

import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: loaded from: classes5.dex */
public final class ConnectInterceptor implements Interceptor {
    public final OkHttpClient client;

    public ConnectInterceptor(OkHttpClient r1) {
        this.client = r1;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r6) throws IOException {
        RealInterceptorChain r0 = (RealInterceptorChain) r6;
        Request r1 = r0.request();
        StreamAllocation r2 = r0.streamAllocation();
        return r0.proceed(r1, r2, r2.newStream(this.client, r6, !r1.method().equals(HttpMethodContrants.GET)), r2.connection());
    }
}
