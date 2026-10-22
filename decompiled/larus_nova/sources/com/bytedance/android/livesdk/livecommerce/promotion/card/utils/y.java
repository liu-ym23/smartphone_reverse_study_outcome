package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromotionListEventActionImplV2 f150379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150380b;

    public y(PromotionListEventActionImplV2 r100, com.bytedance.android.ec.common.api.jump.model.g r101) {
        this.f150379a = r100;
        this.f150380b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f150379a.o(this.f150380b, "sub_to_cart");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
