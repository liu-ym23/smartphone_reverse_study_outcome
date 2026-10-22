package com.alipay.sdk.m.g0;

import android.content.Context;
import com.alipay.sdk.m.d0.d;
import com.alipay.sdk.m.f0.c;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;

/* JADX INFO: loaded from: classes28.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f25316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.alipay.sdk.m.d0.a f25317b;

    public b() {
    }

    public static a a(Context r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (f25316a != null) goto L9;
        f25317b = d.a(r100, r101);
        f25316a = new b();
    L9:
        return f25316a;
    }

    @Override // com.alipay.sdk.m.g0.a
    public c a(com.alipay.sdk.m.f0.d r100) {
        DataReportRequest r101 = com.alipay.sdk.m.f0.b.a(r100);
        return com.alipay.sdk.m.f0.b.a(f25317b.a(r101));
    }

    @Override // com.alipay.sdk.m.g0.a
    public boolean logCollect(String r100) {
        return f25317b.logCollect(r100);
    }
}
