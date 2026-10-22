package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import com.bytedance.android.shopping.store.tabkit.mixframe.MixFrameViewModel;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements gqa.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECTabKitMixRefreshPresenter f186816a;

    public f(ECTabKitMixRefreshPresenter r100) {
        this.f186816a = r100;
    }

    @Override // gqa.d
    public final void d2(h r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        final ECTabKitMixRefreshPresenter r101 = this.f186816a;
        ((MixFrameViewModel) r101.f186808f.getValue()).setRefresh(true);
        ((MixFrameViewModel) r101.f186808f.getValue()).setCursor(0);
        ((MixFrameViewModel) r101.f186808f.getValue()).initFetch(true, new ECTabKitMixRefreshPresenter$refresh$1(r101));
    }
}
