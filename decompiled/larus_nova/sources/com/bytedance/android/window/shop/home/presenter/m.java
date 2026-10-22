package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class m<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowCroppedStyleAnimationPresenter.a f188568a;

    public m(ECWindowCroppedStyleAnimationPresenter.a r100) {
        this.f188568a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Float r101 = (Float) r100;
        if (r101.floatValue() > 0) goto L6;
        ECWindowCroppedStyleAnimationPresenter r102 = this.f188568a.f188281a;
        int r103 = ECWindowCroppedStyleAnimationPresenter.B;
        r102.c0().setVisibility(4);
        r102.c0().setAlpha(0.0f);
        ((View) r102.f188274t.getValue()).setTranslationY(-r102.f188279y);
        r102.d0().setTranslationY(-r102.f188279y);
        r102.a0(0.0f);
        return;
    L6:
        if (r101.floatValue() < 0.99d) goto L8;
        ECWindowCroppedStyleAnimationPresenter r104 = this.f188568a.f188281a;
        int r105 = ECWindowCroppedStyleAnimationPresenter.B;
        ExtensionsKt.gone(r104.b0());
        r104.c0().setAlpha(1.0f);
        ((View) r104.f188274t.getValue()).setTranslationY(0.0f);
        r104.d0().setTranslationY(0.0f);
        r104.A = true;
        return;
    L8:
        ECWindowCroppedStyleAnimationPresenter r106 = this.f188568a.f188281a;
        float r107 = r101.floatValue();
        int r108 = ECWindowCroppedStyleAnimationPresenter.B;
        r106.a0(r107);
    }
}
