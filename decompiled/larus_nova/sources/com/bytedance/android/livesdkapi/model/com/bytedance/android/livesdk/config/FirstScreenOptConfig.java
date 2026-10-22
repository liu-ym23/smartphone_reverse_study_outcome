package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001e\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/FirstScreenOptConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "isFilterMulti", "setFilterMulti", "loadComponentOpt", "getLoadComponentOpt", "setLoadComponentOpt", "record_widget", "getRecord_widget", "setRecord_widget", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FirstScreenOptConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("is_filter_multi")
    private boolean isFilterMulti;

    @SerializedName("load_component_opt")
    private boolean loadComponentOpt;

    @SerializedName("record_widget")
    private boolean record_widget;

    public FirstScreenOptConfig() {
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getLoadComponentOpt() {
        return this.loadComponentOpt;
    }

    public final boolean getRecord_widget() {
        return this.record_widget;
    }

    public final boolean isFilterMulti() {
        return this.isFilterMulti;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setFilterMulti(boolean r100) {
        this.isFilterMulti = r100;
    }

    public final void setLoadComponentOpt(boolean r100) {
        this.loadComponentOpt = r100;
    }

    public final void setRecord_widget(boolean r100) {
        this.record_widget = r100;
    }
}
