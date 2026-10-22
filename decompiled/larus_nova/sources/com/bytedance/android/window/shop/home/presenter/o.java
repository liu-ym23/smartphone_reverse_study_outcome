package com.bytedance.android.window.shop.home.presenter;

import android.widget.FrameLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class o<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowCroppedStyleBackGroundPresenter f188577a;

    public o(ECWindowCroppedStyleBackGroundPresenter r100) {
        this.f188577a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Float r101 = (Float) r100;
        if (r101.floatValue() > 0) goto L5;
        this.f188577a.b0().setVisibility(8);
        this.f188577a.b0().setAlpha(0.0f);
        ((FrameLayout) this.f188577a.f188284n.getValue()).setAlpha(1.0f);
        return;
    L5:
        float r102 = 1;
        if (r101.floatValue() < r102) goto L8;
        this.f188577a.b0().setVisibility(0);
        this.f188577a.b0().setAlpha(1.0f);
        return;
    L8:
        this.f188577a.b0().setVisibility(0);
        this.f188577a.b0().setAlpha(r101.floatValue());
        ((FrameLayout) this.f188577a.f188284n.getValue()).setAlpha(r102 - r101.floatValue());
    }
}
