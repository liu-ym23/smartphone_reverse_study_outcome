package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001e\u0010 \u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LivePreviewPredictConfig;", "", "()V", "abParams", "", "", "getAbParams", "()Ljava/util/Map;", "setAbParams", "(Ljava/util/Map;)V", "compareThresholds", "", "", "getCompareThresholds", "()Ljava/util/List;", "setCompareThresholds", "(Ljava/util/List;)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "maxExecuteDuration", "", "getMaxExecuteDuration", "()J", "setMaxExecuteDuration", "(J)V", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "syncEnable", SystemAppletMethod.METHOD_GET_SYNC_ENABLE, "setSyncEnable", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LivePreviewPredictConfig {

    @SerializedName(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS)
    private Map<String, ? extends Object> abParams;

    @SerializedName("compare_thresholds")
    private List<Integer> compareThresholds;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("max_execute_duration")
    private long maxExecuteDuration;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    @SerializedName("sync_enable")
    private boolean syncEnable;

    public LivePreviewPredictConfig() {
        this.syncEnable = true;
        this.maxExecuteDuration = 3000;
    }

    public final Map<String, Object> getAbParams() {
        return this.abParams;
    }

    public final List<Integer> getCompareThresholds() {
        return this.compareThresholds;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final long getMaxExecuteDuration() {
        return this.maxExecuteDuration;
    }

    public final boolean getShowToastEnable() {
        return this.showToastEnable;
    }

    public final boolean getSyncEnable() {
        return this.syncEnable;
    }

    public final void setAbParams(Map<String, ? extends Object> r100) {
        this.abParams = r100;
    }

    public final void setCompareThresholds(List<Integer> r100) {
        this.compareThresholds = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setMaxExecuteDuration(long r100) {
        this.maxExecuteDuration = r100;
    }

    public final void setShowToastEnable(boolean r100) {
        this.showToastEnable = r100;
    }

    public final void setSyncEnable(boolean r100) {
        this.syncEnable = r100;
    }
}
