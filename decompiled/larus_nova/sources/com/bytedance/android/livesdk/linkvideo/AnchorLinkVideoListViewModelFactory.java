package com.bytedance.android.livesdk.linkvideo;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/AnchorLinkVideoListViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLinkVideoListViewModelFactory implements ViewModelProvider.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f147110a;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    public AnchorLinkVideoListViewModelFactory() {
        this.f147110a = 0;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        return new AnchorLinkVideoListViewModel(this.f147110a);
    }
}
