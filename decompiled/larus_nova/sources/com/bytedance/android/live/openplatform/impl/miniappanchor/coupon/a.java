package com.bytedance.android.live.openplatform.impl.miniappanchor.coupon;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorCouponContextService f84334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Disposable f84335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f84336c;

    public a(AnchorCouponContextService r100, Disposable r101, int r102) {
        this.f84334a = r100;
        this.f84335b = r101;
        this.f84336c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f84335b.dispose();
        this.f84334a.f84333a.put(Integer.valueOf(this.f84336c), null);
    }
}
