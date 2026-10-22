package com.bytedance.android.ec.common.impl.sku;

import com.bytedance.android.ec.common.impl.sku.repository.dto.PromotionAutoApplyCouponResponse;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromotionAutoApplyCouponResponse f43108a;

    public p(PromotionAutoApplyCouponResponse r100) {
        this.f43108a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f43108a.getToast();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        com.bytedance.android.ec.sdk.helper.i.f48124a.e(ECAppInfoService.f48114e.getApplicationContext(), r100, false, false);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
