package com.bytedance.android.shopping.store.home.presenter.preview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes14.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopPreviewBottomInfoPresenter f184354a;

    public k(ECShopPreviewBottomInfoPresenter r100) {
        this.f184354a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        this.f184354a.k0((String) r101.getFirst(), ((Boolean) r101.getSecond()).booleanValue());
    }
}
