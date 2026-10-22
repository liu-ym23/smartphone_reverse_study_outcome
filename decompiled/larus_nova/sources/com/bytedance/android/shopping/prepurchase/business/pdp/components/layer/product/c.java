package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseInfoServiceSnapshotTransitionController f181709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f181710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f181711c;

    public c(BaseInfoServiceSnapshotTransitionController r100, int r101, boolean r102) {
        this.f181709a = r100;
        this.f181710b = r101;
        this.f181711c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f181710b;     // Catch: Throwable -> L8
        BaseInfoServiceSnapshotTransitionController r101 = this.f181709a;     // Catch: Throwable -> L8
        if (r100 == r101.f181604h) goto L5;
        return;
    L5:
        if (r101.f181605i == true) goto L15;
        r101.i(this.f181711c);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
