package com.bytedance.android.live.feature.config;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdp.appbase.settings.SettingsConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010C\u001a\u00020\nJ\u0006\u0010D\u001a\u00020\nR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001e\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR,\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR,\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR,\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR2\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040+\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR,\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001e\u00101\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR\u001e\u00104\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\u001e\u00107\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001e\u0010:\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\f\"\u0004\b<\u0010\u000eR\u001e\u0010=\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\f\"\u0004\b?\u0010\u000eR\u001e\u0010@\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\f\"\u0004\bB\u0010\u000e¨\u0006E"}, d2 = {"Lcom/bytedance/android/live/feature/config/LivePostClientSequenceConfig;", "", "()V", "cacheFeaturesEnableType", "", "getCacheFeaturesEnableType", "()I", "setCacheFeaturesEnableType", "(I)V", "changeReportFormEnable", "", "getChangeReportFormEnable", "()Z", "setChangeReportFormEnable", "(Z)V", "enableSendLogAsync", "getEnableSendLogAsync", "enterAnchorIdOptEnable", "getEnterAnchorIdOptEnable", "setEnterAnchorIdOptEnable", "featureManagerSingleFeatureMap", "", "", "getFeatureManagerSingleFeatureMap", "()Ljava/util/Map;", "setFeatureManagerSingleFeatureMap", "(Ljava/util/Map;)V", "feedNameToIndexMap", "getFeedNameToIndexMap", "setFeedNameToIndexMap", "feedRequestEnable", "getFeedRequestEnable", "setFeedRequestEnable", "feedSingleFeatureToIndexMap", "getFeedSingleFeatureToIndexMap", "setFeedSingleFeatureToIndexMap", "limitTimeInSec", "getLimitTimeInSec", "setLimitTimeInSec", "livePlayBeginEnable", "getLivePlayBeginEnable", "setLivePlayBeginEnable", "liveRecommendInfoFeatureMap", "", "getLiveRecommendInfoFeatureMap", "setLiveRecommendInfoFeatureMap", "liveSingleFeatureMap", "getLiveSingleFeatureMap", "setLiveSingleFeatureMap", "logEnable", "getLogEnable", "setLogEnable", "postEnable", "getPostEnable", "setPostEnable", "size", "getSize", "setSize", "submitRequestEnable", "getSubmitRequestEnable", "setSubmitRequestEnable", "submitRequestEnableV2", "getSubmitRequestEnableV2", "setSubmitRequestEnableV2", "submitRequestEnableV3", "getSubmitRequestEnableV3", "setSubmitRequestEnableV3", "feedRequestPostEnable", "isEnable", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePostClientSequenceConfig {

    @SerializedName("cache_features_enable_type")
    private int cacheFeaturesEnableType;

    @SerializedName("enable_change_report_form")
    private boolean changeReportFormEnable;

    @SerializedName("enable_send_log_async")
    private final boolean enableSendLogAsync;

    @SerializedName("enter_anchor_id_opt_enable")
    private boolean enterAnchorIdOptEnable;

    @SerializedName("feature_manager_single_feature_map")
    private Map<String, String> featureManagerSingleFeatureMap;

    @SerializedName("feature_name_to_index_map")
    private Map<String, String> feedNameToIndexMap;

    @SerializedName("enable_feed_feats_report")
    private boolean feedRequestEnable;

    @SerializedName("feed_single_feature_map")
    private Map<String, String> feedSingleFeatureToIndexMap;

    @SerializedName("feats_time_limit")
    private int limitTimeInSec;

    @SerializedName("live_play_begin_enable")
    private boolean livePlayBeginEnable;

    @SerializedName("live_recommend_info_features_map")
    private Map<String, ? extends List<Integer>> liveRecommendInfoFeatureMap;

    @SerializedName("live_single_feature_map")
    private Map<String, Boolean> liveSingleFeatureMap;

    @SerializedName("log_enable")
    private boolean logEnable;

    @SerializedName("feed_feats_report_method")
    private int postEnable;

    @SerializedName("feats_count")
    private int size;

    @SerializedName("enable_submit_feature_report")
    private boolean submitRequestEnable;

    @SerializedName("enable_submit_feature_report_v2")
    private boolean submitRequestEnableV2;

    @SerializedName("enable_submit_feature_report_v3")
    private boolean submitRequestEnableV3;

    public final boolean feedRequestPostEnable() {
        if (this.postEnable == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isEnable() {
        if (this.feedRequestEnable == false) goto L5;
    L8:
        return true;
    L5:
        if (this.submitRequestEnable == true) goto L8;
        return false;
    }

    public LivePostClientSequenceConfig() {
        this.feedRequestEnable = true;
        this.postEnable = 1;
        this.size = 50;
        this.limitTimeInSec = 300;
        this.submitRequestEnable = true;
        this.submitRequestEnableV2 = true;
        this.submitRequestEnableV3 = true;
        Boolean r100 = Boolean.TRUE;
        this.liveSingleFeatureMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("draw_room_id", r100), TuplesKt.to(SettingsConstants.SETTINGS_UPDATE_FROM, r100), TuplesKt.to(a.KEY_ENTER_SOURCE, r100)});
        this.feedSingleFeatureToIndexMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("cl_ai_har_rct", "28"), TuplesKt.to("cl_ai_ohr_rct", "29"), TuplesKt.to("cl_ai_ohr_habit", BDLocationException.ERROR_SDK_NO_PERMISSION), TuplesKt.to("is_low_power_mode", "42"), TuplesKt.to("font_app_setting", "43"), TuplesKt.to("overall_score", BDLocationException.ERROR_BYTE_DISABLE_USE_WIFI), TuplesKt.to("app_launch_score", "45"), TuplesKt.to("network_speed", BDLocationException.ERROR_BYTE_NO_FINE_LOCATION_PERMISSION), TuplesKt.to("is_mute", "47"), TuplesKt.to("cur_volume", BDLocationException.ERROR_BYTE_NO_CHANGE_WIFI_STATE_PERMISSION), TuplesKt.to("headphones", "49"), TuplesKt.to("feed_index_in_session", "50"), TuplesKt.to("daily_session_index", "51"), TuplesKt.to("live_index_in_session", BDLocationException.ERROR_NO_BYTE_IMPL), TuplesKt.to("refer_page", "53")});
        this.liveRecommendInfoFeatureMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("live_content_abslot0", CollectionsKt.listOf(new Integer[]{1, 2})), TuplesKt.to("live_content_abslot1", CollectionsKt.listOf(new Integer[]{1, 2})), TuplesKt.to("live_content_abslot2", CollectionsKt.listOf(new Integer[]{1, 2})), TuplesKt.to("live_content_cluster_500", CollectionsKt.listOf(new Integer[]{1, 2})), TuplesKt.to("live_content_cluster_2k", CollectionsKt.listOf(new Integer[]{1, 2})), TuplesKt.to("live_content_cluster_5w", CollectionsKt.listOf(new Integer[]{1, 2})), TuplesKt.to("live_content_his_cluster_5k", CollectionsKt.listOf(new Integer[]{1, 2})), TuplesKt.to("live_content_his_cluster_20w", CollectionsKt.listOf(new Integer[]{1, 2})), TuplesKt.to("feed_draw_client_targets_rec_info", CollectionsKt.listOf(new Integer[]{1, 2}))});
        this.logEnable = true;
        this.enableSendLogAsync = true;
    }

    public final int getCacheFeaturesEnableType() {
        return this.cacheFeaturesEnableType;
    }

    public final boolean getChangeReportFormEnable() {
        return this.changeReportFormEnable;
    }

    public final boolean getEnableSendLogAsync() {
        return this.enableSendLogAsync;
    }

    public final boolean getEnterAnchorIdOptEnable() {
        return this.enterAnchorIdOptEnable;
    }

    public final Map<String, String> getFeatureManagerSingleFeatureMap() {
        return this.featureManagerSingleFeatureMap;
    }

    public final Map<String, String> getFeedNameToIndexMap() {
        return this.feedNameToIndexMap;
    }

    public final boolean getFeedRequestEnable() {
        return this.feedRequestEnable;
    }

    public final Map<String, String> getFeedSingleFeatureToIndexMap() {
        return this.feedSingleFeatureToIndexMap;
    }

    public final int getLimitTimeInSec() {
        return this.limitTimeInSec;
    }

    public final boolean getLivePlayBeginEnable() {
        return this.livePlayBeginEnable;
    }

    public final Map<String, List<Integer>> getLiveRecommendInfoFeatureMap() {
        return this.liveRecommendInfoFeatureMap;
    }

    public final Map<String, Boolean> getLiveSingleFeatureMap() {
        return this.liveSingleFeatureMap;
    }

    public final boolean getLogEnable() {
        return this.logEnable;
    }

    public final int getPostEnable() {
        return this.postEnable;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean getSubmitRequestEnable() {
        return this.submitRequestEnable;
    }

    public final boolean getSubmitRequestEnableV2() {
        return this.submitRequestEnableV2;
    }

    public final boolean getSubmitRequestEnableV3() {
        return this.submitRequestEnableV3;
    }

    public final void setCacheFeaturesEnableType(int r100) {
        this.cacheFeaturesEnableType = r100;
    }

    public final void setChangeReportFormEnable(boolean r100) {
        this.changeReportFormEnable = r100;
    }

    public final void setEnterAnchorIdOptEnable(boolean r100) {
        this.enterAnchorIdOptEnable = r100;
    }

    public final void setFeatureManagerSingleFeatureMap(Map<String, String> r100) {
        this.featureManagerSingleFeatureMap = r100;
    }

    public final void setFeedNameToIndexMap(Map<String, String> r100) {
        this.feedNameToIndexMap = r100;
    }

    public final void setFeedRequestEnable(boolean r100) {
        this.feedRequestEnable = r100;
    }

    public final void setFeedSingleFeatureToIndexMap(Map<String, String> r100) {
        this.feedSingleFeatureToIndexMap = r100;
    }

    public final void setLimitTimeInSec(int r100) {
        this.limitTimeInSec = r100;
    }

    public final void setLivePlayBeginEnable(boolean r100) {
        this.livePlayBeginEnable = r100;
    }

    public final void setLiveRecommendInfoFeatureMap(Map<String, ? extends List<Integer>> r100) {
        this.liveRecommendInfoFeatureMap = r100;
    }

    public final void setLiveSingleFeatureMap(Map<String, Boolean> r100) {
        this.liveSingleFeatureMap = r100;
    }

    public final void setLogEnable(boolean r100) {
        this.logEnable = r100;
    }

    public final void setPostEnable(int r100) {
        this.postEnable = r100;
    }

    public final void setSize(int r100) {
        this.size = r100;
    }

    public final void setSubmitRequestEnable(boolean r100) {
        this.submitRequestEnable = r100;
    }

    public final void setSubmitRequestEnableV2(boolean r100) {
        this.submitRequestEnableV2 = r100;
    }

    public final void setSubmitRequestEnableV3(boolean r100) {
        this.submitRequestEnableV3 = r100;
    }
}
