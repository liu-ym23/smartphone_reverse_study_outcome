package com.bytedance.android.live.effect.avadjust;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/AvAdjustViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "tabs", "Landroidx/lifecycle/MutableLiveData;", "getTabs", "()Landroidx/lifecycle/MutableLiveData;", "", "Lk90/a;", "lensData$delegate", "Lkotlin/Lazy;", "getLensData", "lensData", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AvAdjustViewModel extends ViewModel {
    private final Lazy lensData$delegate;
    private final MutableLiveData<Object> tabs;

    public final MutableLiveData<List<k90.a>> getLensData() {
        return (MutableLiveData) this.lensData$delegate.getValue();
    }

    public AvAdjustViewModel() {
        this.tabs = new MutableLiveData(null);
        this.lensData$delegate = LazyKt.lazy(AvAdjustViewModel$lensData$2.INSTANCE);
    }

    public final MutableLiveData<Object> getTabs() {
        return this.tabs;
    }
}
