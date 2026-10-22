package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class b0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowCroppedStyleRootPresenterV2 f188497a;

    public b0(ECWindowCroppedStyleRootPresenterV2 r100) {
        this.f188497a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        uq3.a r101 = (uq3.a) r100;
        ECWindowCroppedStyleRootPresenterV2 r102 = this.f188497a;
        int r103 = ECWindowCroppedStyleRootPresenterV2.f188295r;
        ((View) r102.f188300q.getValue()).setVisibility(0);
    }
}
