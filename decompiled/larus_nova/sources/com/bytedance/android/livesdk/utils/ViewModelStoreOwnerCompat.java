package com.bytedance.android.livesdk.utils;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Landroidx/lifecycle/ViewModelStoreOwner;", "live-utils_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ViewModelStoreOwnerCompat extends ViewModelStoreOwner {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ViewModelStore $default$getViewModelStore(ViewModelStoreOwnerCompat r100) {
            return r100.tf();
        }
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    ViewModelStore getViewModelStore();

    ViewModelStore tf();
}
