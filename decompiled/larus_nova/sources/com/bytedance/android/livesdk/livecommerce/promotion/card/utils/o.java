package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromotionListEventActionImpl f150343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f150344b;

    public o(PromotionListEventActionImpl r100, com.bytedance.android.ec.common.api.jump.model.g r101) {
        this.f150343a = r100;
        this.f150344b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f150343a.l(this.f150344b, "sub_to_cart");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
