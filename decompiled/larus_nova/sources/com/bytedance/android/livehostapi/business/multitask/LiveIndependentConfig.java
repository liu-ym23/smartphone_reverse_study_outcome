package com.bytedance.android.livehostapi.business.multitask;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livehostapi/business/multitask/LiveIndependentConfig;", "", "()V", "abortList", "", "", "getAbortList", "()Ljava/util/List;", "allowingList", "getAllowingList", "canOpenPackage", "", "getCanOpenPackage", "()Z", "delayTime", "", "getDelayTime", "()I", "style", "getStyle", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveIndependentConfig {

    @SerializedName("abort_list")
    private final List<String> abortList;

    @SerializedName("allowing_list")
    private final List<String> allowingList;

    @SerializedName("can_open_package")
    private final boolean canOpenPackage;

    @SerializedName("delay_time")
    private final int delayTime;

    @SerializedName("style")
    private final int style;

    public LiveIndependentConfig() {
        this.delayTime = 150;
        this.abortList = CollectionsKt.emptyList();
        this.allowingList = CollectionsKt.emptyList();
        this.canOpenPackage = true;
    }

    public final List<String> getAbortList() {
        return this.abortList;
    }

    public final List<String> getAllowingList() {
        return this.allowingList;
    }

    public final boolean getCanOpenPackage() {
        return this.canOpenPackage;
    }

    public final int getDelayTime() {
        return this.delayTime;
    }

    public final int getStyle() {
        return this.style;
    }
}
