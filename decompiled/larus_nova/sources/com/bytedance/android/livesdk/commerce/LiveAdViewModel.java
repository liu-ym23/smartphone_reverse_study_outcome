package com.bytedance.android.livesdk.commerce;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/LiveAdViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "mobData", "Landroidx/lifecycle/MutableLiveData;", "", "getMobData", "()Landroidx/lifecycle/MutableLiveData;", "mobData$delegate", "Lkotlin/Lazy;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAdViewModel extends ViewModel {
    private final Lazy mobData$delegate;

    public final MutableLiveData<String> getMobData() {
        return (MutableLiveData) this.mobData$delegate.getValue();
    }

    public LiveAdViewModel() {
        this.mobData$delegate = LazyKt.lazy(LiveAdViewModel$mobData$2.INSTANCE);
    }
}
