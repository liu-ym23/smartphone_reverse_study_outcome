package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class u1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowLazyStatusView f188639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f188640b;

    public u1(WindowLazyStatusView r100, View r101) {
        this.f188639a = r100;
        this.f188640b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        WindowLoadStatus r101 = (WindowLoadStatus) r100;
        if (r101 == null) goto L18;
        int r102 = r1.f188625a[r101.ordinal()];
        if (r102 != 1) goto L8;
        this.f188639a.b(com.bytedance.android.ec.window.base.status.c.d.f49705a);
        return;
    L8:
        if (r102 != 2) goto L10;
        this.f188639a.a();
        this.f188640b.setVisibility(8);
        return;
    L10:
        if (r102 != 3) goto L19;
        this.f188639a.b(com.bytedance.android.ec.window.base.status.c.C0852c.f49704a);
        return;
    L19:
        return;
    }
}
