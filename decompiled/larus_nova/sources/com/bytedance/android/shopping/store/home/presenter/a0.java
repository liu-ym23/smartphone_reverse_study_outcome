package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.home.entity.CartCtrlInfo;
import com.bytedance.android.shopping.store.home.entity.ECShopCartInfo;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopFloatCartEntryPresenterV2.d f184111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECShopCartInfo f184112b;

    public a0(ECShopFloatCartEntryPresenterV2.d r100, ECShopCartInfo r101) {
        this.f184111a = r100;
        this.f184112b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopFloatCartEntryPresenterV2 r100 = this.f184111a.f183935a;     // Catch: Throwable -> L8
        r100.f183930u = AnimationStatus.RUNNING;     // Catch: Throwable -> L8
        CartCtrlInfo r101 = this.f184112b.getCartCtrlInfo();     // Catch: Throwable -> L8
        View r102 = r100.y();     // Catch: Throwable -> L8
        c0 r103 = new c0(r100, r101);     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        Integer r104 = r101.getLatencySeconds();     // Catch: Throwable -> L8
    L6:
        r102.postDelayed(r103, com.bytedance.android.shopping.extensions.c.a(r104, 1000));     // Catch: Throwable -> L8
        return;
    L5:
        r104 = null;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
