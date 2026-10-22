package com.bytedance.retrofit2.intercept;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.RetrofitMetrics;
import f6.f;
import g6.b;

/* JADX INFO: loaded from: classes.dex */
public interface Interceptor {

    public interface Chain {
        Call call();

        RetrofitMetrics metrics();

        f proceed(b r10) throws Exception;

        b request();
    }

    f intercept(Chain r10) throws Exception;
}
