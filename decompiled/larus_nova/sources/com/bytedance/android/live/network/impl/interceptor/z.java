package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.livesdk.config.mc0;
import com.bytedance.android.livesdk.model.NetworkApmSetting;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class z implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public eo0.b f83913a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f83914a = null;

        static {
            NetworkApmSetting r100 = mc0.f120744a.getValue();
            f83914a = new z();
        }
    }

    public z() {
        List<String> r100 = y50.h.f566213a;
        this.f83913a = new eo0.b();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        System.currentTimeMillis();
        SsResponse r102 = r100.proceed(r101);     // Catch: Exception -> L5
        System.currentTimeMillis();     // Catch: Exception -> L5
        this.f83913a.getClass();     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        System.currentTimeMillis();
        this.f83913a.getClass();
        throw e;
    }
}
