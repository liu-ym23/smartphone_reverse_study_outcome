package com.bytedance.android.shopping.store.aggregate.classification;

import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShopClassificationFilterPresenter f183385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECTabLayout f183386b;

    public b(ShopClassificationFilterPresenter r100, ECTabLayout r101) {
        this.f183385a = r100;
        this.f183386b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f183386b.selectTabWithoutAnimation(this.f183385a.f183375k);     // Catch: Throwable -> L4
        ShopClassificationFilterPresenter.D(this.f183385a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
