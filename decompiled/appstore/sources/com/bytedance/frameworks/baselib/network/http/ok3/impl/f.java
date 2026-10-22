package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class f implements Interceptor {
    public f() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) {
        Request r11 = r10.request();
        Map r12 = NetworkParams.G(r11.k().toString(), r11.e().i());
        if (r12 == null) goto L5;
        Request.a r13 = new Request.a();
        r13.k(r11.k());
        r13.f(r11.g(), r11.a());
        r13.i(r11.j());
        Headers.Builder r14 = r11.e().f();
        Iterator r15 = r12.entrySet().iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.a((String) r16.getKey(), (String) r16.getValue());
        goto L8
    L10:
        r13.e(r14.d());
        return r10.proceed(r13.b());
    L5:
        return r10.proceed(r11);
    }
}
