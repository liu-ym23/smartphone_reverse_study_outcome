package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopAnimationPresenter.b f184143a;

    public e(ECShopAnimationPresenter.b r100) {
        this.f184143a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        View r100 = (View) this.f184143a.f183870c.element;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.setVisibility(8);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
