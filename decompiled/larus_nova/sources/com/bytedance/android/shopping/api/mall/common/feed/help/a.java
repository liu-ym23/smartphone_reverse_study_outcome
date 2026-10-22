package com.bytedance.android.shopping.api.mall.common.feed.help;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECMallCommonImpressionReportHelper f170256a;

    public a(ECMallCommonImpressionReportHelper r100) {
        this.f170256a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECMallCommonImpressionReportHelper.a(this.f170256a, true, false, null, 6);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
