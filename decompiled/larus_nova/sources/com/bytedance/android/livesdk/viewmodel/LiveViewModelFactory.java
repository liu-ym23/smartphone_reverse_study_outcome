package com.bytedance.android.livesdk.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.livesdk.live.data.RoomStatsViewModel;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes11.dex */
public class LiveViewModelFactory implements ViewModelProvider.Factory {
    public LiveViewModelFactory() {
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
        return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T create(Class<T> r100) {
        if (r100.isAssignableFrom(RoomStatsViewModel.class) == false) goto L7;
        return new RoomStatsViewModel();
    L7:
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
