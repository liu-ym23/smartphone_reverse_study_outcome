package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR,\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R,\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R,\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R,\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R,\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveShuffleSequenceConfig;", "", "()V", "disableResetFeatureMap", "", "getDisableResetFeatureMap", "()Z", "setDisableResetFeatureMap", "(Z)V", "enable", "getEnable", "setEnable", "enableFixLivePreviewTimeSum", "getEnableFixLivePreviewTimeSum", "setEnableFixLivePreviewTimeSum", "enableUploadLiveRevenueFeature", "getEnableUploadLiveRevenueFeature", "setEnableUploadLiveRevenueFeature", "featureManagerFeaturesMap", "", "", "getFeatureManagerFeaturesMap", "()Ljava/util/Map;", "setFeatureManagerFeaturesMap", "(Ljava/util/Map;)V", "liveFeatureManagerFeaturesMap", "getLiveFeatureManagerFeaturesMap", "setLiveFeatureManagerFeaturesMap", "liveFeatureMap", "getLiveFeatureMap", "setLiveFeatureMap", "liveRecommendInfosMap", "getLiveRecommendInfosMap", "setLiveRecommendInfosMap", "liveRevenueFeaturesMap", "getLiveRevenueFeaturesMap", "setLiveRevenueFeaturesMap", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveShuffleSequenceConfig {

    @SerializedName("disable_reset_feature_map")
    private boolean disableResetFeatureMap;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("live_preview_time_sum_fix_enable")
    private boolean enableFixLivePreviewTimeSum;

    @SerializedName("live_revenue_feature_upload_enable")
    private boolean enableUploadLiveRevenueFeature;

    @SerializedName("feature_manager_features_map")
    private Map<String, String> featureManagerFeaturesMap;

    @SerializedName("live_feature_manager_features_map")
    private Map<String, String> liveFeatureManagerFeaturesMap;

    @SerializedName("live_features_map")
    private Map<String, Boolean> liveFeatureMap;

    @SerializedName("live_recommend_info_features_map")
    private Map<String, Boolean> liveRecommendInfosMap;

    @SerializedName("live_revenue_features_map")
    private Map<String, Boolean> liveRevenueFeaturesMap;

    public LiveShuffleSequenceConfig() {
        this.enable = true;
        Boolean r100 = Boolean.TRUE;
        this.liveFeatureMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("live_preview_time_sum", r100), TuplesKt.to("live_first_inner_time_sum", r100), TuplesKt.to("live_inner_time_sum", r100), TuplesKt.to("live_dislike", r100), TuplesKt.to("live_user_report", r100), TuplesKt.to("live_follow", r100), TuplesKt.to("live_gift_diamond", r100), TuplesKt.to("live_draw_to_next", r100), TuplesKt.to(IPerformanceManager.Params.room_type, r100), TuplesKt.to("live_index_in_session", r100), TuplesKt.to("refer_page", r100), TuplesKt.to("live_time_gap", r100), TuplesKt.to("live_duration", r100), TuplesKt.to("live_window_stay_duration", r100), TuplesKt.to("live_show_time", r100), TuplesKt.to("live_preview_enter_duration", r100), TuplesKt.to("live_preview_is_no_stream", r100), TuplesKt.to("live_inner_first_room_is_no_stream", r100), TuplesKt.to("live_inner_first_room_duration", r100), TuplesKt.to("live_download_speed", r100)});
        this.liveRecommendInfosMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("live_content_his_cluster_5k", r100), TuplesKt.to("live_content_his_cluster_20w", r100), TuplesKt.to("live_content_cluster_500", r100), TuplesKt.to("live_content_cluster_5w", r100), TuplesKt.to("live_content_cluster_2k", r100), TuplesKt.to("live_content_abslot0", r100), TuplesKt.to("live_content_abslot2", r100), TuplesKt.to("live_content_abslot1", r100)});
        this.enableUploadLiveRevenueFeature = true;
        this.liveRevenueFeaturesMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("r_diamond_balance", r100), TuplesKt.to("r_livesdk_contribution_ranklist_show_cnt", r100), TuplesKt.to("r_livesdk_enter_personal_detail_cnt", r100), TuplesKt.to("r_livesdk_fans_club_entrance_click_cnt", r100), TuplesKt.to("r_livesdk_follow_cnt", r100), TuplesKt.to("r_livesdk_gift_buff_click_cnt", r100), TuplesKt.to("r_livesdk_gift_combo_click_cnt", r100), TuplesKt.to("r_livesdk_gift_effect_show_cnt", r100), TuplesKt.to("r_livesdk_gift_panel_scroll_cnt", r100), TuplesKt.to("r_livesdk_gift_preview_cnt", r100), TuplesKt.to("r_livesdk_gift_show_cnt", r100), TuplesKt.to("r_livesdk_gift_tray_click_cnt", r100), TuplesKt.to("r_livesdk_like_cnt", r100), TuplesKt.to("r_livesdk_live_click_user_cnt", r100), TuplesKt.to("r_livesdk_live_rank_show_cnt", r100), TuplesKt.to("r_livesdk_recharge_click_cnt", r100), TuplesKt.to("r_livesdk_recharge_page_pay_click_cnt", r100), TuplesKt.to("r_livesdk_recharge_pay_cnt", r100), TuplesKt.to("r_livesdk_recharge_show_cnt", r100), TuplesKt.to("r_livesdk_recharge_success_avg_money", r100), TuplesKt.to("r_livesdk_recharge_success_cnt", r100), TuplesKt.to("r_livesdk_recharge_success_sum_money", r100), TuplesKt.to("r_livesdk_send_gift_avg_money", r100), TuplesKt.to("r_livesdk_send_gift_cnt", r100), TuplesKt.to("r_livesdk_send_gift_sum_money", r100), TuplesKt.to("r_livesdk_shortcut_gift_click_cnt", r100), TuplesKt.to("r_livesdk_task_banner_click_cnt", r100), TuplesKt.to("is_have_revenue_action", r100)});
        this.liveFeatureManagerFeaturesMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("live_index_in_session", "live_index_in_session"), TuplesKt.to("refer_page", "homepage_hot_refer_page")});
        this.featureManagerFeaturesMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("live_index_in_session", "live_index_in_session"), TuplesKt.to("refer_page", "homepage_hot_refer_page")});
    }

    public final boolean getDisableResetFeatureMap() {
        return this.disableResetFeatureMap;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableFixLivePreviewTimeSum() {
        return this.enableFixLivePreviewTimeSum;
    }

    public final boolean getEnableUploadLiveRevenueFeature() {
        return this.enableUploadLiveRevenueFeature;
    }

    public final Map<String, String> getFeatureManagerFeaturesMap() {
        return this.featureManagerFeaturesMap;
    }

    public final Map<String, String> getLiveFeatureManagerFeaturesMap() {
        return this.liveFeatureManagerFeaturesMap;
    }

    public final Map<String, Boolean> getLiveFeatureMap() {
        return this.liveFeatureMap;
    }

    public final Map<String, Boolean> getLiveRecommendInfosMap() {
        return this.liveRecommendInfosMap;
    }

    public final Map<String, Boolean> getLiveRevenueFeaturesMap() {
        return this.liveRevenueFeaturesMap;
    }

    public final void setDisableResetFeatureMap(boolean r100) {
        this.disableResetFeatureMap = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableFixLivePreviewTimeSum(boolean r100) {
        this.enableFixLivePreviewTimeSum = r100;
    }

    public final void setEnableUploadLiveRevenueFeature(boolean r100) {
        this.enableUploadLiveRevenueFeature = r100;
    }

    public final void setFeatureManagerFeaturesMap(Map<String, String> r100) {
        this.featureManagerFeaturesMap = r100;
    }

    public final void setLiveFeatureManagerFeaturesMap(Map<String, String> r100) {
        this.liveFeatureManagerFeaturesMap = r100;
    }

    public final void setLiveFeatureMap(Map<String, Boolean> r100) {
        this.liveFeatureMap = r100;
    }

    public final void setLiveRecommendInfosMap(Map<String, Boolean> r100) {
        this.liveRecommendInfosMap = r100;
    }

    public final void setLiveRevenueFeaturesMap(Map<String, Boolean> r100) {
        this.liveRevenueFeaturesMap = r100;
    }
}
