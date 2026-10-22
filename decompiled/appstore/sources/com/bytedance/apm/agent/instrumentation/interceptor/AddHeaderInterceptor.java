package com.bytedance.apm.agent.instrumentation.interceptor;

import android.text.TextUtils;
import com.bytedanceos.common.ad.common.AdConstant;
import java.io.IOException;
import l1.b;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class AddHeaderInterceptor implements Interceptor {
    public static final String X_TT_TRACE_LOG = "x-tt-trace-log";

    public AddHeaderInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) throws IOException {
        Request r11 = r10.request();
        Request.a r12 = r11.h();
        if (TextUtils.isEmpty(r11.c(X_TT_TRACE_LOG)) == false) goto L17;
        if (b.t().F() == false) goto L17;
        if (b.t().A() == false) goto L12;
        if (b.t().B() == false) goto L12;
        r12.a(X_TT_TRACE_LOG, AdConstant.OperatorCode.CHINA_UNICOM);
    L12:
        if (b.t().u() != 1) goto L17;
        if (b.t().B() == false) goto L17;
        r12.a(X_TT_TRACE_LOG, "02");
    L17:
        return r10.proceed(r12.b());
    }
}
