package com.bytedance.android.livesdk.rank.setting.participate;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/rank/setting/participate/ParticipateSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "title", "Landroidx/lifecycle/MutableLiveData;", "getTitle", "()Landroidx/lifecycle/MutableLiveData;", "subtitle", "getSubtitle", "", "Lcom/bytedance/android/livesdk/rank/setting/participate/g;", "settingItems", "getSettingItems", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParticipateSettingViewModel extends ViewModel {
    private final MutableLiveData<List<g>> settingItems;
    private final MutableLiveData<String> subtitle;
    private final MutableLiveData<String> title;

    public ParticipateSettingViewModel() {
        MutableLiveData<String> r100 = new MutableLiveData();
        this.title = r100;
        MutableLiveData<String> r101 = new MutableLiveData();
        this.subtitle = r101;
        MutableLiveData<List<g>> r102 = new MutableLiveData();
        this.settingItems = r102;
        r100.setValue("");
        r101.setValue("");
        r102.setValue(CollectionsKt.emptyList());
    }

    public final MutableLiveData<List<g>> getSettingItems() {
        return this.settingItems;
    }

    public final MutableLiveData<String> getSubtitle() {
        return this.subtitle;
    }

    public final MutableLiveData<String> getTitle() {
        return this.title;
    }
}
