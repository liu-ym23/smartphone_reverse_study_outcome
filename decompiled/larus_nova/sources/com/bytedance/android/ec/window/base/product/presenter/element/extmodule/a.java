package com.bytedance.android.ec.window.base.product.presenter.element.extmodule;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowProductExtModuleElementPresenter f49382a;

    public a(ECWindowProductExtModuleElementPresenter r100) {
        this.f49382a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f49382a.o0(R.id.store_product_card_source_wrapper, true);     // Catch: Throwable -> L4
        int r101 = this.f49382a.p0(true);     // Catch: Throwable -> L4
        this.f49382a.t0(r100 + r101);     // Catch: Throwable -> L4
        this.f49382a.s0(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
