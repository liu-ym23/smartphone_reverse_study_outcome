package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0TJ\u0006\u0010U\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R,\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR2\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010!j\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R2\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010!j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R2\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010!j\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001e\u00100\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R \u00103\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u00108\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u001e\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\tR\u001e\u0010>\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0007\"\u0004\b@\u0010\tR\u001e\u0010A\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0016\"\u0004\bC\u0010\u0018R\u001e\u0010D\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0007\"\u0004\bF\u0010\tR\u001e\u0010G\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0007\"\u0004\bI\u0010\tR&\u0010J\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010!j\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\tR\u001c\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010O8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010P\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0007\"\u0004\bR\u0010\t¨\u0006V"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LivePreviewWormholePredictConfig;", "", "()V", "activelyPredictEnable", "", "allTabPredictEnable", "getAllTabPredictEnable", "()Z", "setAllTabPredictEnable", "(Z)V", "bottomType", "", "getBottomType", "()I", "setBottomType", "(I)V", "calculatePreAwemeFeatureEnable", "getCalculatePreAwemeFeatureEnable", "setCalculatePreAwemeFeatureEnable", "enterDelay", "", "getEnterDelay", "()J", "setEnterDelay", "(J)V", "extraParams", "", "", "getExtraParams", "()Ljava/util/Map;", "setExtraParams", "(Ljava/util/Map;)V", "featureNameList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFeatureNameList", "()Ljava/util/ArrayList;", "setFeatureNameList", "(Ljava/util/ArrayList;)V", "featureValueList", "getFeatureValueList", "setFeatureValueList", "feedGroupFeatureList", "getFeedGroupFeatureList", "setFeedGroupFeatureList", "insertFeatureMapEnable", "getInsertFeatureMapEnable", "setInsertFeatureMapEnable", "maxWaitDuration", "getMaxWaitDuration", "setMaxWaitDuration", "packageVersion", "getPackageVersion", "()Ljava/lang/String;", "setPackageVersion", "(Ljava/lang/String;)V", "peakBusinessName", "getPeakBusinessName", "setPeakBusinessName", "preCollectFeatureEnable", "getPreCollectFeatureEnable", "setPreCollectFeatureEnable", "predictInMain", "getPredictInMain", "setPredictInMain", "predictInterval", "getPredictInterval", "setPredictInterval", "reportEnable", "getReportEnable", "setReportEnable", "resultCheckOptEnable", "getResultCheckOptEnable", "setResultCheckOptEnable", "runEventList", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "supportEnterFromMergeList", "", "timeEqualLimitEnable", "getTimeEqualLimitEnable", "setTimeEqualLimitEnable", "getmSupportEnterFromMergeList", "", "isEnable", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LivePreviewWormholePredictConfig {

    @SerializedName("predict_actively_enable")
    private boolean activelyPredictEnable;

    @SerializedName("all_tab_predict_enable")
    private boolean allTabPredictEnable;

    @SerializedName("bottom_type")
    private int bottomType;

    @SerializedName("calculate_pre_aweme_feature_enable")
    private boolean calculatePreAwemeFeatureEnable;

    @SerializedName("enter_delay")
    private long enterDelay;

    @SerializedName("extra_params")
    private Map<String, ? extends Object> extraParams;

    @SerializedName("feed_feature_name_list")
    private ArrayList<String> featureNameList;

    @SerializedName("feed_feature_default_value_list")
    private ArrayList<Object> featureValueList;

    @SerializedName("feed_group_feature_list")
    private ArrayList<String> feedGroupFeatureList;

    @SerializedName("insert_feature_map_enable")
    private boolean insertFeatureMapEnable;

    @SerializedName("max_wait_predict_duration")
    private long maxWaitDuration;

    @SerializedName("package_version")
    private String packageVersion;

    @SerializedName("peak_business_name")
    private String peakBusinessName;

    @SerializedName("pre_collect_feature_enable")
    private boolean preCollectFeatureEnable;

    @SerializedName("main_thread_predict_enable")
    private boolean predictInMain;

    @SerializedName("predict_interval")
    private long predictInterval;

    @SerializedName("report_enable")
    private boolean reportEnable;

    @SerializedName("result_check_opt_enable")
    private boolean resultCheckOptEnable;

    @SerializedName("run_event_list")
    public ArrayList<String> runEventList;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    @SerializedName("support_enter_from_merge_list")
    private List<String> supportEnterFromMergeList;

    @SerializedName("time_equal_limit_enable")
    private boolean timeEqualLimitEnable;

    public final List<String> getmSupportEnterFromMergeList() {
        List<String> r100 = this.supportEnterFromMergeList;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.arrayListOf(new String[]{UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT});
    }

    public final boolean isEnable() {
        if (this.activelyPredictEnable == true) goto L11;
        ArrayList<String> r100 = this.runEventList;
        if (r100 != null) goto L7;
    L9:
        return false;
    L7:
        if ((!r100.isEmpty()) != true) goto L9;
        return true;
    L11:
        return true;
    }

    public LivePreviewWormholePredictConfig() {
        this.predictInMain = true;
        this.maxWaitDuration = 3000;
        this.reportEnable = true;
        this.predictInterval = 5000;
        this.insertFeatureMapEnable = true;
        this.runEventList = new ArrayList();
        this.featureNameList = new ArrayList();
        this.featureValueList = new ArrayList();
        this.feedGroupFeatureList = new ArrayList();
        this.extraParams = MapsKt.emptyMap();
        this.preCollectFeatureEnable = true;
        this.calculatePreAwemeFeatureEnable = true;
        this.enterDelay = 300;
        this.supportEnterFromMergeList = CollectionsKt.arrayListOf(new String[]{UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT});
    }

    public final boolean getAllTabPredictEnable() {
        return this.allTabPredictEnable;
    }

    public final int getBottomType() {
        return this.bottomType;
    }

    public final boolean getCalculatePreAwemeFeatureEnable() {
        return this.calculatePreAwemeFeatureEnable;
    }

    public final long getEnterDelay() {
        return this.enterDelay;
    }

    public final Map<String, Object> getExtraParams() {
        return this.extraParams;
    }

    public final ArrayList<String> getFeatureNameList() {
        return this.featureNameList;
    }

    public final ArrayList<Object> getFeatureValueList() {
        return this.featureValueList;
    }

    public final ArrayList<String> getFeedGroupFeatureList() {
        return this.feedGroupFeatureList;
    }

    public final boolean getInsertFeatureMapEnable() {
        return this.insertFeatureMapEnable;
    }

    public final long getMaxWaitDuration() {
        return this.maxWaitDuration;
    }

    public final String getPackageVersion() {
        return this.packageVersion;
    }

    public final String getPeakBusinessName() {
        return this.peakBusinessName;
    }

    public final boolean getPreCollectFeatureEnable() {
        return this.preCollectFeatureEnable;
    }

    public final boolean getPredictInMain() {
        return this.predictInMain;
    }

    public final long getPredictInterval() {
        return this.predictInterval;
    }

    public final boolean getReportEnable() {
        return this.reportEnable;
    }

    public final boolean getResultCheckOptEnable() {
        return this.resultCheckOptEnable;
    }

    public final boolean getShowToastEnable() {
        return this.showToastEnable;
    }

    public final boolean getTimeEqualLimitEnable() {
        return this.timeEqualLimitEnable;
    }

    public final void setAllTabPredictEnable(boolean r100) {
        this.allTabPredictEnable = r100;
    }

    public final void setBottomType(int r100) {
        this.bottomType = r100;
    }

    public final void setCalculatePreAwemeFeatureEnable(boolean r100) {
        this.calculatePreAwemeFeatureEnable = r100;
    }

    public final void setEnterDelay(long r100) {
        this.enterDelay = r100;
    }

    public final void setExtraParams(Map<String, ? extends Object> r100) {
        this.extraParams = r100;
    }

    public final void setFeatureNameList(ArrayList<String> r100) {
        this.featureNameList = r100;
    }

    public final void setFeatureValueList(ArrayList<Object> r100) {
        this.featureValueList = r100;
    }

    public final void setFeedGroupFeatureList(ArrayList<String> r100) {
        this.feedGroupFeatureList = r100;
    }

    public final void setInsertFeatureMapEnable(boolean r100) {
        this.insertFeatureMapEnable = r100;
    }

    public final void setMaxWaitDuration(long r100) {
        this.maxWaitDuration = r100;
    }

    public final void setPackageVersion(String r100) {
        this.packageVersion = r100;
    }

    public final void setPeakBusinessName(String r100) {
        this.peakBusinessName = r100;
    }

    public final void setPreCollectFeatureEnable(boolean r100) {
        this.preCollectFeatureEnable = r100;
    }

    public final void setPredictInMain(boolean r100) {
        this.predictInMain = r100;
    }

    public final void setPredictInterval(long r100) {
        this.predictInterval = r100;
    }

    public final void setReportEnable(boolean r100) {
        this.reportEnable = r100;
    }

    public final void setResultCheckOptEnable(boolean r100) {
        this.resultCheckOptEnable = r100;
    }

    public final void setShowToastEnable(boolean r100) {
        this.showToastEnable = r100;
    }

    public final void setTimeEqualLimitEnable(boolean r100) {
        this.timeEqualLimitEnable = r100;
    }
}
