package q7;

import com.bytedanceos.appstore.buss.network.factory.NetBodyFactory;
import com.bytedanceos.common.networkv2.params.NetKey;
import kotlin.jvm.internal.q;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Interceptor {
    public c() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) {
        q.g(r10, "chain");
        Request r11 = r10.request();
        Request.a r12 = r11.h();
        RequestBody r13 = r11.a();
        String r14 = r11.g();
        HttpUrl.Builder r15 = r11.k().p();
        r7.a r16 = r7.a.f23768a;
        HttpUrl r17 = r15.b("source", String.valueOf(r16.k())).b("udid", r16.m()).b(NetKey.MODEL, r16.g()).b("app_version", "100003070").b("_timestamp", r16.l()).b("_nonce", r16.h()).b("app_id", r16.b()).c();
        if (q.b(r14, "POST") == true) goto L5;
    L9:
        Response r18 = r10.proceed(r12.k(r17).b());
        q.f(r18, "proceed(...)");
        return r18;
    L5:
        if ((r13 instanceof okhttp3.g) == true) goto L9;
        if ((r13 instanceof h) == true) goto L9;
        r12.g(NetBodyFactory.f8806a.a(r13));
        goto L9
    }
}
