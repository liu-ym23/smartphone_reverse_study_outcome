package com.bytedanceos.common.networkv2.rest.intercepter;

import com.bytedanceos.common.networkv2.params.NetParamFactory;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class CommonInterceptor implements Interceptor {
    public CommonInterceptor() {
    }

    private static String getValueEncoded(String r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        String r11 = r10.replace("\n", "");
        int r12 = r11.length();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L18;
        char r14 = r11.charAt(r13);
        if (r14 > 31) goto L10;
    L19:
        return URLEncoder.encode(r11, "UTF-8");
    L15:
        e = move-exception;
        e.printStackTrace();
        return "";
    L10:
        if (r14 >= 127) goto L19;
        r13 = r13 + 1;
        goto L6
    L18:
        return r11;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) throws IOException {
        Request.a r11 = r10.request().h();
        r11.a("Connection", "keep-alive");
        Map r12 = NetParamFactory.instance().getHeaderParams();
        if (r12 == null) goto L11;
        if (r12.size() <= 0) goto L11;
        Iterator r13 = r12.keySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L11;
        String r14 = (String) r13.next();
        r11.a(r14, getValueEncoded((String) r12.get(r14)));
    L11:
        return r10.proceed(r11.b());
    }
}
