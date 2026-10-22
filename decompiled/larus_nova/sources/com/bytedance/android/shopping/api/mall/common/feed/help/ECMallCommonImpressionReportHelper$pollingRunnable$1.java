package com.bytedance.android.shopping.api.mall.common.feed.help;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallCommonImpressionReportHelper$pollingRunnable$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECMallCommonImpressionReportHelper f170247a;

    @Override // java.lang.Runnable
    public final void run() {
        ECMallCommonImpressionReportHelper r100 = this.f170247a;     // Catch: Throwable -> L7
        if (r100.f170239g == true) goto L10;
        ECMallCommonImpressionReportHelper.a(r100, false, false, new ECMallCommonImpressionReportHelper$pollingRunnable$1$run$1(this), 2);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public ECMallCommonImpressionReportHelper$pollingRunnable$1(ECMallCommonImpressionReportHelper r100) {
        this.f170247a = r100;
    }
}
