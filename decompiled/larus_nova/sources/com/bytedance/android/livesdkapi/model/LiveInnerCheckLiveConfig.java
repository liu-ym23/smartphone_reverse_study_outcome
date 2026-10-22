package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R&\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001e\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001e\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001e\u0010.\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\b¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveInnerCheckLiveConfig;", "", "()V", "changeRequest", "", "getChangeRequest", "()Z", "setChangeRequest", "(Z)V", "enterFromLimit", "getEnterFromLimit", "setEnterFromLimit", "highValueHotUpdateEnable", "getHighValueHotUpdateEnable", "setHighValueHotUpdateEnable", "hotUpdateEnable", "getHotUpdateEnable", "setHotUpdateEnable", "hotUpdateInterval", "", "getHotUpdateInterval", "()I", "setHotUpdateInterval", "(I)V", "hotUpdateType", "getHotUpdateType", "setHotUpdateType", "liveEntranceList", "", "", "getLiveEntranceList", "()Ljava/util/List;", "setLiveEntranceList", "(Ljava/util/List;)V", "pushCheckEnable", "getPushCheckEnable", "setPushCheckEnable", "removeOptimize", "getRemoveOptimize", "setRemoveOptimize", "reportUseBytelink", "getReportUseBytelink", "setReportUseBytelink", "reportV2", "getReportV2", "setReportV2", "useBytelink", "getUseBytelink", "setUseBytelink", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveInnerCheckLiveConfig {

    @SerializedName("change_request")
    private boolean changeRequest;

    @SerializedName("enter_from_limit")
    private boolean enterFromLimit;

    @SerializedName("high_value_hot_update_enable")
    private boolean highValueHotUpdateEnable;

    @SerializedName("hot_update_enable")
    private boolean hotUpdateEnable;

    @SerializedName("hot_update_interval")
    private int hotUpdateInterval;

    @SerializedName("hot_update_type")
    private int hotUpdateType;

    @SerializedName("live_entrance_list")
    private List<String> liveEntranceList;

    @SerializedName("push_check_enable")
    private boolean pushCheckEnable;

    @SerializedName("remove_optimize")
    private boolean removeOptimize;

    @SerializedName("report_use_bytelink")
    private boolean reportUseBytelink;

    @SerializedName("report_v2")
    private boolean reportV2;

    @SerializedName("use_bytelink")
    private boolean useBytelink;

    public LiveInnerCheckLiveConfig() {
        this.hotUpdateType = -1;
        this.hotUpdateInterval = 30;
        this.enterFromLimit = true;
        this.liveEntranceList = CollectionsKt.emptyList();
    }

    public final boolean getChangeRequest() {
        return this.changeRequest;
    }

    public final boolean getEnterFromLimit() {
        return this.enterFromLimit;
    }

    public final boolean getHighValueHotUpdateEnable() {
        return this.highValueHotUpdateEnable;
    }

    public final boolean getHotUpdateEnable() {
        return this.hotUpdateEnable;
    }

    public final int getHotUpdateInterval() {
        return this.hotUpdateInterval;
    }

    public final int getHotUpdateType() {
        return this.hotUpdateType;
    }

    public final List<String> getLiveEntranceList() {
        return this.liveEntranceList;
    }

    public final boolean getPushCheckEnable() {
        return this.pushCheckEnable;
    }

    public final boolean getRemoveOptimize() {
        return this.removeOptimize;
    }

    public final boolean getReportUseBytelink() {
        return this.reportUseBytelink;
    }

    public final boolean getReportV2() {
        return this.reportV2;
    }

    public final boolean getUseBytelink() {
        return this.useBytelink;
    }

    public final void setChangeRequest(boolean r100) {
        this.changeRequest = r100;
    }

    public final void setEnterFromLimit(boolean r100) {
        this.enterFromLimit = r100;
    }

    public final void setHighValueHotUpdateEnable(boolean r100) {
        this.highValueHotUpdateEnable = r100;
    }

    public final void setHotUpdateEnable(boolean r100) {
        this.hotUpdateEnable = r100;
    }

    public final void setHotUpdateInterval(int r100) {
        this.hotUpdateInterval = r100;
    }

    public final void setHotUpdateType(int r100) {
        this.hotUpdateType = r100;
    }

    public final void setLiveEntranceList(List<String> r100) {
        this.liveEntranceList = r100;
    }

    public final void setPushCheckEnable(boolean r100) {
        this.pushCheckEnable = r100;
    }

    public final void setRemoveOptimize(boolean r100) {
        this.removeOptimize = r100;
    }

    public final void setReportUseBytelink(boolean r100) {
        this.reportUseBytelink = r100;
    }

    public final void setReportV2(boolean r100) {
        this.reportV2 = r100;
    }

    public final void setUseBytelink(boolean r100) {
        this.useBytelink = r100;
    }
}
