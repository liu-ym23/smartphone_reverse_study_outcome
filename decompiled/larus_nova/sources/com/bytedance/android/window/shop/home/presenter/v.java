package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class v<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowCroppedStyleRootPresenter f188641a;

    public v(ECWindowCroppedStyleRootPresenter r100) {
        this.f188641a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        uq3.a r101 = (uq3.a) r100;
        ECWindowCroppedStyleRootPresenter r102 = this.f188641a;
        int r103 = ECWindowCroppedStyleRootPresenter.f188285s;
        ((View) r102.f188291r.getValue()).setVisibility(0);
    }
}
