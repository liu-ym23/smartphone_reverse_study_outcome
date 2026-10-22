package com.bytedance.android.window.shop.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes14.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowCroppedStyleAnimationPresenter f188555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f188556b;

    public k(ECWindowCroppedStyleAnimationPresenter r100, float r101) {
        this.f188555a = r100;
        this.f188556b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f188555a.b0().setY(this.f188556b + ((Integer) r100).intValue());
    }
}
