package com.bytedance.android.live.liveinteract.awemeplay.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/viewmodel/LiveVideoCommentSelectPanelVideoListViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectPanelVideoListViewModelFactory implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71630a;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    public LiveVideoCommentSelectPanelVideoListViewModelFactory(int r100) {
        this.f71630a = r100;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        return new LiveVideoCommentSelectPanelVideoListViewModel(this.f71630a);
    }
}
