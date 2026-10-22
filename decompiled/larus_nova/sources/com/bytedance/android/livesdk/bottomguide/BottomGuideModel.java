package com.bytedance.android.livesdk.bottomguide;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/bottomguide/BottomGuideModel;", "Landroidx/lifecycle/ViewModel;", "()V", "countTime", "Landroidx/lifecycle/MutableLiveData;", "", "getCountTime", "()Landroidx/lifecycle/MutableLiveData;", "guideBar", "Lcom/bytedance/android/livesdk/bottomguide/GuideBarResponseItem;", "getGuideBar", "showing", "", "getShowing", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class BottomGuideModel extends ViewModel {
    private final MutableLiveData<Long> countTime;
    private final MutableLiveData<GuideBarResponseItem> guideBar;
    private final MutableLiveData<Boolean> showing;

    public BottomGuideModel() {
        this.showing = new MutableLiveData();
        this.countTime = new MutableLiveData();
        this.guideBar = new MutableLiveData();
    }

    public final MutableLiveData<Long> getCountTime() {
        return this.countTime;
    }

    public final MutableLiveData<GuideBarResponseItem> getGuideBar() {
        return this.guideBar;
    }

    public final MutableLiveData<Boolean> getShowing() {
        return this.showing;
    }
}
