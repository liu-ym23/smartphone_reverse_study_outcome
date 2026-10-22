package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.tabkit.mixframe.MixFrameViewModel;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECTabKitMixFrameStatusPresenter f186815a;

    public e(ECTabKitMixFrameStatusPresenter r100) {
        this.f186815a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MixFrameViewModel.initFetch$default((MixFrameViewModel) this.f186815a.f186804f.getValue(), false, ECTabKitMixFrameStatusPresenter$initStatusView$1$2$1.INSTANCE, 1, null);
    }
}
