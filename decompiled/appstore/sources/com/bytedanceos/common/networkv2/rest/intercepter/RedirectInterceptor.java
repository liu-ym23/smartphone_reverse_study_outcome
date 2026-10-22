package com.bytedanceos.common.networkv2.rest.intercepter;

import com.bytedanceos.common.toolbox.c;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class RedirectInterceptor implements Interceptor {
    private ArrayList<Integer> mCodeList;

    public RedirectInterceptor() {
        ArrayList<Integer> r10 = new ArrayList();
        this.mCodeList = r10;
        r10.add(301);
        this.mCodeList.add(302);
        this.mCodeList.add(303);
        this.mCodeList.add(307);
    }

    public void addCode(int r10) {
        this.mCodeList.add(Integer.valueOf(r10));
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) throws IOException {
        Request r11 = r10.request();
        Response r12 = r10.proceed(r11);
        if (c.a(this.mCodeList) == true) goto L9;
        if (r12 != null) goto L6;
        return r12;
    L6:
        if (this.mCodeList.contains(Integer.valueOf(r12.d())) == true) goto L8;
        return r12;
    L8:
        return r10.proceed(r11.h().k(r12.r().k()).b());
    L9:
        return r12;
    }
}
