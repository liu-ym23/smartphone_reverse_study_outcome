package com.bytedance.android.livesdk.config.ai;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010:\u001a\u00020\nR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u0016\u0010\u001b\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001e\u0010&\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR\u001e\u0010)\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\u001e\u0010,\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001e\u0010/\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000eR\u0016\u00102\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\fR\u001e\u00104\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR\u001e\u00107\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\f\"\u0004\b9\u0010\u000e¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/config/ai/LiveAIConfig;", "", "()V", "aid", "", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "appLogRunEventEnable", "", "getAppLogRunEventEnable", "()Z", "setAppLogRunEventEnable", "(Z)V", "disableMonitorInferBusinessList", "", "getDisableMonitorInferBusinessList", "()Ljava/util/List;", "setDisableMonitorInferBusinessList", "(Ljava/util/List;)V", "enable", "getEnable", "setEnable", "enableBroadcastPreviewListener", "getEnableBroadcastPreviewListener", "setEnableBroadcastPreviewListener", "enableInitPitaya", "getEnableInitPitaya", "engineVersion", "", "getEngineVersion", "()I", "setEngineVersion", "(I)V", "initType", "getInitType", "setInitType", "logEnable", "getLogEnable", "setLogEnable", "logFilterEnable", "getLogFilterEnable", "setLogFilterEnable", "putFeatureMapEnable", "getPutFeatureMapEnable", "setPutFeatureMapEnable", "rechargeSelectEnable", "getRechargeSelectEnable", "setRechargeSelectEnable", "showTestDebugViewEnable", "getShowTestDebugViewEnable", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "updateFeatureMapEnable", "getUpdateFeatureMapEnable", "setUpdateFeatureMapEnable", "isMiniEngineEnable", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAIConfig {

    @SerializedName("live_aid")
    private String aid;

    @SerializedName("applog_run_event_enable")
    private boolean appLogRunEventEnable;

    @SerializedName("disable_monitor_infer_business_list")
    private List<String> disableMonitorInferBusinessList;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_broadcast_preview_listener")
    private boolean enableBroadcastPreviewListener;

    @SerializedName("enable_init_pitaya")
    private final boolean enableInitPitaya;

    @SerializedName("engine_version")
    private int engineVersion;

    @SerializedName("init_type")
    private int initType;

    @SerializedName("log_enable")
    private boolean logEnable;

    @SerializedName("log_filter_enable")
    private boolean logFilterEnable;

    @SerializedName("put_feature_map_enable")
    private boolean putFeatureMapEnable;

    @SerializedName("recharge_select_enable")
    private boolean rechargeSelectEnable;

    @SerializedName("show_test_debug_view_enable")
    private final boolean showTestDebugViewEnable;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    @SerializedName("update_feature_map_enable")
    private boolean updateFeatureMapEnable;

    public final boolean isMiniEngineEnable() {
        if (this.engineVersion != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public LiveAIConfig() {
        this.enableBroadcastPreviewListener = true;
        this.logEnable = true;
        this.initType = 2;
        this.logFilterEnable = true;
        this.appLogRunEventEnable = true;
        this.aid = "359495";
        this.putFeatureMapEnable = true;
        this.disableMonitorInferBusinessList = CollectionsKt.listOf("aweme_live_feature_manager");
    }

    public final String getAid() {
        return this.aid;
    }

    public final boolean getAppLogRunEventEnable() {
        return this.appLogRunEventEnable;
    }

    public final List<String> getDisableMonitorInferBusinessList() {
        return this.disableMonitorInferBusinessList;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableBroadcastPreviewListener() {
        return this.enableBroadcastPreviewListener;
    }

    public final boolean getEnableInitPitaya() {
        return this.enableInitPitaya;
    }

    public final int getEngineVersion() {
        return this.engineVersion;
    }

    public final int getInitType() {
        return this.initType;
    }

    public final boolean getLogEnable() {
        return this.logEnable;
    }

    public final boolean getLogFilterEnable() {
        return this.logFilterEnable;
    }

    public final boolean getPutFeatureMapEnable() {
        return this.putFeatureMapEnable;
    }

    public final boolean getRechargeSelectEnable() {
        return this.rechargeSelectEnable;
    }

    public final boolean getShowTestDebugViewEnable() {
        return this.showTestDebugViewEnable;
    }

    public final boolean getShowToastEnable() {
        return this.showToastEnable;
    }

    public final boolean getUpdateFeatureMapEnable() {
        return this.updateFeatureMapEnable;
    }

    public final void setAid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.aid = r100;
    }

    public final void setAppLogRunEventEnable(boolean r100) {
        this.appLogRunEventEnable = r100;
    }

    public final void setDisableMonitorInferBusinessList(List<String> r100) {
        this.disableMonitorInferBusinessList = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableBroadcastPreviewListener(boolean r100) {
        this.enableBroadcastPreviewListener = r100;
    }

    public final void setEngineVersion(int r100) {
        this.engineVersion = r100;
    }

    public final void setInitType(int r100) {
        this.initType = r100;
    }

    public final void setLogEnable(boolean r100) {
        this.logEnable = r100;
    }

    public final void setLogFilterEnable(boolean r100) {
        this.logFilterEnable = r100;
    }

    public final void setPutFeatureMapEnable(boolean r100) {
        this.putFeatureMapEnable = r100;
    }

    public final void setRechargeSelectEnable(boolean r100) {
        this.rechargeSelectEnable = r100;
    }

    public final void setShowToastEnable(boolean r100) {
        this.showToastEnable = r100;
    }

    public final void setUpdateFeatureMapEnable(boolean r100) {
        this.updateFeatureMapEnable = r100;
    }
}
