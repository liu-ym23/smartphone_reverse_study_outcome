package com.bytedance.android.window.shop.home.presenter;

import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class u<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowCroppedStyleRootPresenter f188636a;

    public u(ECWindowCroppedStyleRootPresenter r100) {
        this.f188636a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        uq3.a r101 = (uq3.a) r100;
        ECWindowCroppedStyleRootPresenter r102 = this.f188636a;
        int r103 = ECWindowCroppedStyleRootPresenter.f188285s;
        r102.w().b(R.id.ec_shop_info_area_container_wrapper).g(0);
        this.f188636a.w().b(R.id.ec_shop_info_area_container_wrapper).f().setOnClickListener(null);
    }
}
