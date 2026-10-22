package com.bytedance.android.shopping.store.mall.follows.basic;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseFollowStorePlayControlPresenter.b f185603a;

    public g(BaseFollowStorePlayControlPresenter.b r100) {
        this.f185603a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseFollowStorePlayControlPresenter r100 = this.f185603a.f185570a;     // Catch: Throwable -> L4
        int r101 = BaseFollowStorePlayControlPresenter.f185558q;     // Catch: Throwable -> L4
        r100.j0(false, true, true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
