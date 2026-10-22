package com.bytedance.android.live.performance.api;

import android.app.Activity;
import android.app.Dialog;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import vr0.a;

/* JADX INFO: loaded from: classes46.dex */
public interface IPerfToolsService extends IService {
    public static final List<String> baseAudienceInfo = null;
    public static final List<String> baseBroadcastInfo = null;

    void addClientInfoKey(JSONObject r100);

    void addLiveCoreInfoKey(JSONObject r100);

    void addPerformanceData(String r100, double r101);

    void clearDynamicData();

    void clearSceneInfo();

    void dismiss();

    int getCurrentEntrance();

    int getCurrentPerformanceType();

    List<a> getDataForEntrance(int r100);

    List<Double> getDataForPerformanceEntrance(int r100);

    String getNormalInfo(String r100);

    String getPerformanceChartTitle(int r100);

    void initAndShowDebugTool(boolean r100);

    boolean isContentVisible();

    boolean isNormalViewVisible();

    boolean isPerformanceViewVisible();

    void removeClientInfo(JSONObject r100);

    void removeSceneInfo(String r100);

    IPerfToolsService setActivity(Activity r100);

    void setData(String r100, String r101);

    void setDialog(Dialog r100, boolean r101);

    void setSceneInfo(String r100, Map<String, String> r101);

    void updateNormalInfo(a r100);

    void updatePerformanceChart(double r100);

    void verifyEntranceNormalData();

    static {
        baseBroadcastInfo = Arrays.asList(new String[]{"data_current_room_id", "data_push_stream_encode_type", "data_push_stream_resolution", "data_push_client_bitrate", "data_push_client_fps", "data_push_client_max_bitrate", "data_filter_used", "data_makeup_used", "data_makeup_ids", "data_beauty_used", "data_beauty_ids", "data_small_beauty_used", "data_small_beauty_ids", "data_sticker_used", "data_sticker_ids", "data_gesture_used", "data_gesture_ids"});
        baseAudienceInfo = Arrays.asList(new String[]{"data_current_room_id", "data_play_url", "data_push_client_bitrate", "data_push_client_fps", "data_pull_stream_resolution", "data_pull_stream_bitrate", "data_pull_stream_fps", "data_pull_stream_codec_type", "data_live_room_enter_source", "data_stream_type", "data_enter_room_cost", "data_enter_room_split_cost", "data_end_to_end_delay", "surface_render_enabled", "data_sharpen_used", IPerformanceManager.PlayerClient.super_resolution_enabled, IPerformanceManager.PlayerClient.texture_render_enabled, "data_current_room_watched", "resolution_key", "isvPass", "resolution_strategy", "default_resolution", "local_resolution_memory", "decode_way", "isvPass", "sr_used", "roi_sr_used", "sr_multi_scale_support", "sr_scale_type_default", "sr_scale_type_current"});
    }
}
