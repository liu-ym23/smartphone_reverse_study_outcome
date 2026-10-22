package at2;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16216a = null;

    static {
        f16216a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<Object> intercept(Interceptor.Chain r100) {
        String r101 = c.f16218a;
        String r102 = c.f16218a;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L22;
        Request r105 = r100.request();
        ArrayList r106 = new ArrayList();
        String r107 = c.f16219b;
        if (r107 != null) goto L13;
    L14:
        r103 = true;
    L16:
        if (r103 == true) goto L18;
        r106.add(new Header("X-Webcast-Tag", "s1:" + c.f16218a + ",s2:" + c.f16219b));
    L19:
        r106.addAll(r105.getHeaders());
        return r100.proceed(r105.newBuilder().headers(r106).build());
    L18:
        r106.add(new Header("X-Webcast-Tag", "s1:" + c.f16218a));
        goto L19
    L13:
        if (r107.length() != 0) goto L16;
    L22:
        return r100.proceed(r100.request());
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
