package com.bytedance.android.livesdk.widget;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/widget/GuidePageModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuidePageModelFactory extends ViewModelProvider.NewInstanceFactory {
    public GuidePageModelFactory() {
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        return new LiveGuidePageViewModel();
    }
}
