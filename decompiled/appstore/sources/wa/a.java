package wa;

import com.bytedanceos.common.privacy.PrivacyUtils;
import kotlin.jvm.internal.q;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Interceptor {
    public a() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) {
        q.g(r10, "chain");
        if (((Boolean) PrivacyUtils.f9901a.j().getValue()).booleanValue() == true) goto L6;
        Response r11 = new Response.Builder().p(r10.request()).m(Protocol.HTTP_1_1).g(403).j("Request blocked by interceptor due to privacy policy not being agreed").b(ResponseBody.create(MediaType.c(HTTP.PLAIN_TEXT_TYPE), "Request was discarded")).c();
        q.f(r11, "build(...)");
        return r11;
    L6:
        Response r12 = r10.proceed(r10.request());
        q.f(r12, "proceed(...)");
        return r12;
    }
}
