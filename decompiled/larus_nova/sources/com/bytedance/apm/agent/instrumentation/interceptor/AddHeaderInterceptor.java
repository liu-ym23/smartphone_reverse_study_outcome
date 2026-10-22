package com.bytedance.apm.agent.instrumentation.interceptor;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import is3.d;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes14.dex */
public class AddHeaderInterceptor implements Interceptor {
    public static final String X_TT_TRACE_LOG = "x-tt-trace-log";

    public AddHeaderInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r100) throws IOException {
        Request r101 = r100.request();
        Request.Builder r102 = r101.newBuilder();
        if (TextUtils.isEmpty(r101.header(X_TT_TRACE_LOG)) == false) goto L17;
        d r103 = d.a.f495609a;
        if (r103.f495604q == false) goto L17;
        if (r103.j() == false) goto L12;
        if (r103.f495595h == false) goto L12;
        r102.addHeader(X_TT_TRACE_LOG, HiAnalyticsConstant.KeyAndValue.NUMBER_01);
    L12:
        if (r103.f495594g != 1) goto L17;
        if (r103.f495595h == false) goto L17;
        r102.addHeader(X_TT_TRACE_LOG, "02");
    L17:
        return r100.proceed(r102.build());
    }
}
