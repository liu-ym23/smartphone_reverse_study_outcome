package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R2\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveAiPreviewAutoEnterPredictConfig;", "", "()V", "abParams", "", "", "getAbParams", "()Ljava/util/Map;", "setAbParams", "(Ljava/util/Map;)V", "enterFromList", "", "getEnterFromList", "()Ljava/util/List;", "setEnterFromList", "(Ljava/util/List;)V", "exitGroupEnable", "", "getExitGroupEnable", "()Z", "setExitGroupEnable", "(Z)V", "feedFeatureList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFeedFeatureList", "()Ljava/util/ArrayList;", "setFeedFeatureList", "(Ljava/util/ArrayList;)V", "limitTimeList", "", "getLimitTimeList", "setLimitTimeList", "maxWaitDuration", "", "getMaxWaitDuration", "()J", "setMaxWaitDuration", "(J)V", "predictType", "getPredictType", "()I", "setPredictType", "(I)V", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAiPreviewAutoEnterPredictConfig {

    @SerializedName(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS)
    private Map<String, ? extends Object> abParams;

    @SerializedName("enter_from_list")
    private List<String> enterFromList;

    @SerializedName("exit_group_enable")
    private boolean exitGroupEnable;

    @SerializedName("aweme_feed_feature")
    private ArrayList<String> feedFeatureList;

    @SerializedName("limit_time_list")
    private List<Integer> limitTimeList;

    @SerializedName("max_wait_duration")
    private long maxWaitDuration;

    @SerializedName("predict_type")
    private int predictType;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    public LiveAiPreviewAutoEnterPredictConfig() {
        this.feedFeatureList = new ArrayList();
        this.maxWaitDuration = 2000;
        this.exitGroupEnable = true;
    }

    public final Map<String, Object> getAbParams() {
        return this.abParams;
    }

    public final List<String> getEnterFromList() {
        return this.enterFromList;
    }

    public final boolean getExitGroupEnable() {
        return this.exitGroupEnable;
    }

    public final ArrayList<String> getFeedFeatureList() {
        return this.feedFeatureList;
    }

    public final List<Integer> getLimitTimeList() {
        return this.limitTimeList;
    }

    public final long getMaxWaitDuration() {
        return this.maxWaitDuration;
    }

    public final int getPredictType() {
        return this.predictType;
    }

    public final boolean getShowToastEnable() {
        return this.showToastEnable;
    }

    public final void setAbParams(Map<String, ? extends Object> r100) {
        this.abParams = r100;
    }

    public final void setEnterFromList(List<String> r100) {
        this.enterFromList = r100;
    }

    public final void setExitGroupEnable(boolean r100) {
        this.exitGroupEnable = r100;
    }

    public final void setFeedFeatureList(ArrayList<String> r100) {
        this.feedFeatureList = r100;
    }

    public final void setLimitTimeList(List<Integer> r100) {
        this.limitTimeList = r100;
    }

    public final void setMaxWaitDuration(long r100) {
        this.maxWaitDuration = r100;
    }

    public final void setPredictType(int r100) {
        this.predictType = r100;
    }

    public final void setShowToastEnable(boolean r100) {
        this.showToastEnable = r100;
    }
}
