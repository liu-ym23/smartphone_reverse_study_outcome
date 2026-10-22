package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class g0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowLazyStatusView f188530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f188531b;

    public g0(WindowLazyStatusView r100, View r101) {
        this.f188530a = r100;
        this.f188531b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        WindowLoadStatus r101 = (WindowLoadStatus) r100;
        if (r101 == null) goto L18;
        int r102 = d0.f188510a[r101.ordinal()];
        if (r102 != 1) goto L8;
        this.f188530a.b(com.bytedance.android.ec.window.base.status.c.d.f49705a);
        return;
    L8:
        if (r102 != 2) goto L10;
        this.f188530a.a();
        this.f188531b.setVisibility(8);
        return;
    L10:
        if (r102 != 3) goto L19;
        this.f188530a.b(com.bytedance.android.ec.window.base.status.c.C0852c.f49704a);
        return;
    L19:
        return;
    }
}
