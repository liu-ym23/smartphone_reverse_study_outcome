package com.bytedance.android.window.shop.home.presenter;

import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class a0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowCroppedStyleRootPresenterV2 f188489a;

    public a0(ECWindowCroppedStyleRootPresenterV2 r100) {
        this.f188489a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        uq3.a r101 = (uq3.a) r100;
        ECWindowCroppedStyleRootPresenterV2 r102 = this.f188489a;
        int r103 = ECWindowCroppedStyleRootPresenterV2.f188295r;
        r102.w().b(R.id.ec_shop_info_area_container_wrapper).g(0);
    }
}
