package com.bytedance.android.livesdkapi.service;

import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.performance.IPerformanceCacheData;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdkapi.service.IPerformanceManager")
public interface IPerformanceManager extends IService, IMiddleWarePerformanceManager {
    public static final String CPU_RATE_FOR_MODULE = "cpu_rate_for_module";
    public static final String CPU_RATE_FOR_MODULE_AVAILABLE = "cpu_rate_for_module_available";
    public static final String CPU_TIME_APP_ON_MODULE_START = "cpu_time_app_on_module_start";
    public static final String CPU_TIME_APP_ON_MODULE_STOP = "cpu_time_app_on_module_stop";
    public static final String CPU_TIME_SYS_ON_MODULE_START = "cpu_time_sys_on_module_start";
    public static final String CPU_TIME_SYS_ON_MODULE_STOP = "cpu_time_sys_on_module_stop";
    public static final String MODULE_ANCHOR_AUDIENCE_GAME = "anchor_audience_interaction";
    public static final String MODULE_ANCHOR_CAST = "anchor_cast";
    public static final String MODULE_AUDIENCE_CAST = "audience_cast";
    public static final String MODULE_AUDIO_ANIMATED_BG = "audio_animated_bg";
    public static final String MODULE_BARRAGE = "barrage";
    public static final String MODULE_BLINK = "blink";
    public static final String MODULE_DRAWING_BOARD = "drawing_board";
    public static final String MODULE_DRESS_USERCARD = "dress_usercard";
    public static final String MODULE_EFFECT_GAME = "effect_game";
    public static final String MODULE_ENTER_ROOM = "live_enter_room";
    public static final String MODULE_FACE_STICKER = "face_sticker";
    public static final String MODULE_FRIEND_ROOM_ANCHOR = "friend_room_anchor";
    public static final String MODULE_FRIEND_ROOM_GUEST = "friend_room_guest";
    public static final String MODULE_FRIEND_ROOM_KTV = "friend_room_ktv";
    public static final String MODULE_FRIEND_ROOM_WATCH = "friend_room_watch";
    public static final String MODULE_GIFT_EFFECT = "gift_effect";
    public static final String MODULE_GIFT_LYNX = "gift_lynx";
    public static final String MODULE_GIFT_MP4 = "gift_mp4";
    public static final String MODULE_GIFT_PANEL = "gift_panel";
    public static final String MODULE_GIFT_STICKER = "gift_sticker";
    public static final String MODULE_INTERACT_PLUGIN = "interact_plugin";
    public static final String MODULE_KTV = "ktv";
    public static final String MODULE_LINK_MIC = "link_mic";
    public static final String MODULE_LINK_MIC_GAME = "link_mic_game";
    public static final String MODULE_LINK_MIC_MEDIA = "link_mic_media";
    public static final String MODULE_LIVE_FIRST_DURATION = "live_first_duration";
    public static final String MODULE_LIVE_GAME_PLATFORM = "game_platform";
    public static final String MODULE_LIVE_OPEN_PLATFORM_TOOLBAR_ENTRANCE = "open_platform_toolbar_entrance";
    public static final String MODULE_LIVE_OPEN_PLATFORM_XPLAY = "open_platform_xplay";
    public static final String MODULE_LIVE_SECOND_DURATION = "live_second_duration";
    public static final String MODULE_LIVE_THIRD_DURATION = "live_third_duration";
    public static final String MODULE_MULTI_AUDIO_KTV = "multi_audio_ktv";
    public static final String MODULE_OPEN_ASSET = "open_asset";
    public static final String MODULE_RESTART = "restart";
    public static final String MODULE_REVLINK_ING_PANEL = "revlink_ing_panel";
    public static final String MODULE_REVLINK_INVITE_PANEL = "revlink_invite_panel";
    public static final String MODULE_REVLINK_MAIN_PANEL = "revlink_main_panel";
    public static final String MODULE_STABLE_MODE = "live_stable_mode";
    public static final String MODULE_STICKER = "sticker";
    public static final String MODULE_STREAM = "stream";
    public static final String MODULE_STREAMER_RECORD = "streamer_record";
    public static final String MODULE_USER_ENTER = "user_enter";
    public static final String SCENE_ASR_PREDICT = "asr_predict";
    public static final String SCENE_CLICK_BEAUTY = "beauty";
    public static final String SCENE_CLICK_CAMERA = "camera";
    public static final String SCENE_CLICK_CATEGORY_TAG = "tag";
    public static final String SCENE_CLICK_DOU_PLUS = "dou_plus";
    public static final String SCENE_CLICK_HASH_TAG = "challenge";
    public static final String SCENE_CLICK_STICKER = "sticker";
    public static final String SCENE_CLOSE_ANCHOR_LIVE_ROOM = "close_anchor_live_room";
    public static final String SCENE_CREATE_FRIEND_ROOM = "create_friend_room";
    public static final String SCENE_CREATE_LIVE = "create_live";
    public static final String SCENE_CREATE_LIVE_PREVIEW = "create_live_preview";
    public static final String SCENE_ENTER_FRIEND_ROOM = "enter_friend_room";
    public static final String SCENE_FEED_DRAWER_SLIDE = "feed_drawer_slide";
    public static final String SCENE_FRIEND_ROOM_DIGG = "friend_room_digg";
    public static final String SCENE_FRIEND_ROOM_EMOJI = "friend_room_emoji";
    public static final String SCENE_FRIEND_ROOM_SWITCH_VIDEO = "friend_room_switch_video";
    public static final String SCENE_GIFT_PANEL = "gift_panel_open";
    public static final String SCENE_LIVE_ENTER_ROOM_ALL_WIDGET_LOAD_FPS = "live_enter_room_all_widget_load_fps";
    public static final String SCENE_LIVE_ENTER_ROOM_P0_WIDGET_LOAD_FPS = "live_enter_room_P0_widget_load_fps";
    public static final String SCENE_LIVE_ENTER_ROOM_P1_WIDGET_LOAD_FPS = "live_enter_room_P1_widget_load_fps";
    public static final String SCENE_LIVE_ENTER_ROOM_P2_WIDGET_LOAD_FPS = "live_enter_room_P2_widget_load_fps";
    public static final String SCENE_LIVE_GAME_PLATFORM = "live_gameplatform";
    public static final String SCENE_LIVE_LONG_TIME_WATCH_FPS = "live_long_time_watch_fps";
    public static final String SCENE_LIVE_PK = "live_pk";
    public static final String SCENE_PUSH_STREAM_SUCCESS = "push_stream_success";
    public static final String SCENE_RANK_SLIDE = "rank_slide";
    public static final String SCENE_RESIDENT = "resident";
    public static final String SCENE_REVLINK_GIFT_HIDE = "revlink_gift_hide";
    public static final String SCENE_REVLINK_GIFT_SHOW = "revlink_gift_show";
    public static final String SCENE_REVLINK_ING_PANEL_OPEN = "revlink_ing_panel_open";
    public static final String SCENE_REVLINK_INVITE_PANEL_OPEN = "revlink_invite_panel_open";
    public static final String SCENE_REVLINK_MAIN_PANEL = "revlink_main_panel_open";
    public static final String SCENE_SHOW_BARRAGE = "show_barrage";
    public static final String SCENE_SHOW_DIGG = "show_digg";
    public static final String SCENE_SHOW_EFFECT_GIFT = "show_effect_gift";
    public static final String SCENE_SHOW_STICKER_GIFT = "show_sticker_gift";
    public static final String SCENE_SHOW_VIDEO_GIFT = "show_video_gift";
    public static final String SCENE_START_BROADCAST_LOAD_END = "broadcast_load_end";
    public static final String SCENE_UPLOAD_COVER_TAG = "upload_cover";

    public interface Battery {
        public static final String battery_current = "battery_current";
        public static final String battery_health = "battery_health";
        public static final String battery_level = "battery_level";
        public static final String battery_scale = "battery_scale";
        public static final String battery_state_android = "battery_state_android";
        public static final String battery_voltage = "battery_voltage";
    }

    public interface CPU {
        public static final String cpu_rate = "cpu_rate";
        public static final String cpu_speed = "cpu_speed";
        public static final String main_cpu_rate = "main_cpu_rate";
        public static final String render_cpu_rate = "render_cpu_rate";
    }

    public interface Effect {
        public static final int EFFECT_PARAMS_MAX_LENGTH = 1024;
        public static final String effect_params = "effect_params";
        public static final String effect_process_texture_time = "effect_process_texture_time";
        public static final String effect_provider_id = "effect_provide";
        public static final String effect_pure_algorithm_time = "effect_pure_algorithm_time";
        public static final String effect_pure_render_time = "effect_pure_render_time";
        public static final String effect_wait_algorithm_time = "effect_wait_algorithm_time";
    }

    public interface GPU {
        public static final String gpu_usage = "gpu_usage";
    }

    public interface Game {
        public static final String game_render_fps = "game_render_fps";
    }

    public interface MEM {
        public static final String mem_device_available = "mem_device_available";
        public static final String mem_device_mem_Low = "mem_device_mem_Low";
        public static final String mem_device_threshold = "mem_device_threshold";
        public static final String mem_device_total = "mem_device_total";
        public static final String mem_gc_count = "mem_gc_count";
        public static final String mem_gc_count_block = "mem_gc_count_block";
        public static final String mem_gc_count_block_new_per_second = "mem_gc_count_block_new_per_second";
        public static final String mem_gc_count_new_per_second = "mem_gc_count_new_per_second";
        public static final String mem_gc_stat_no = "mem_gc_stat_no";
        public static final String mem_gc_time = "mem_gc_time";
        public static final String mem_gc_time_block = "mem_gc_time_block";
        public static final String mem_gc_time_block_new_per_second = "mem_gc_time_block_new_per_second";
        public static final String mem_gc_time_new_per_second = "mem_gc_time_new_per_second";
        public static final String mem_gc_time_pause_per_second = "mem_gc_time_pause_per_second";
        public static final String mem_gc_time_wait_per_second = "mem_gc_time_wait_per_second";
        public static final String mem_java_free = "mem_java_free";
        public static final String mem_java_lave = "mem_java_lave";
        public static final String mem_java_max = "mem_java_max";
        public static final String mem_java_total = "mem_java_total";
        public static final String mem_java_used = "mem_java_used";
        public static final String mem_java_used_percentage = "mem_java_used_percentage";
        public static final String mem_kBytes_allocated_per_second = "mem_kBytes_allocated_per_second";
        public static final String mem_kBytes_freed_per_second = "mem_kBytes_freed_per_second";
        public static final String mem_major_faults_per_second = "mem_major_faults_per_second";
        public static final String mem_minor_faults_per_second = "mem_minor_faults_per_second";
        public static final String mem_native_lave = "mem_native_lave";
        public static final String mem_pss_dalvik = "mem_pss_dalvik";
        public static final String mem_pss_native = "mem_pss_native";
        public static final String mem_pss_total = "mem_pss_total";
        public static final String mem_sum_code = "mem_sum_code";
        public static final String mem_sum_graphics = "mem_sum_graphics";
        public static final String mem_sum_java = "mem_sum_java";
        public static final String mem_sum_native = "mem_sum_native";
        public static final String mem_sum_other = "mem_sum_other";
        public static final String mem_sum_stack = "mem_sum_stack";
        public static final String mem_sum_system = "mem_sum_system";
        public static final String mem_trim_level = "mem_trim_level";
        public static final String mem_vmsize = "mem_vmsize";
    }

    public @interface Module {
    }

    public interface Net {
        public static final String net_quality = "net_quality";
    }

    public interface PYTHIA {
        public static final String CURRENT_PYTHIA_SCROE = "current_pythia_scroe";
        public static final String STABLE_PYTHIA_SCROE = "stable_pythia_scroe";
    }

    public interface Params {
        public static final String action_type = "action_type";
        public static final String anchor_id = "anchor_id";
        public static final String draw_room_count = "draw_room_count";
        public static final String enter_from_merge = "enter_from_merge";
        public static final String enter_method = "enter_method";
        public static final String hotroom_type = "hotroom_type";
        public static final String is_anchor = "is_anchor";
        public static final String is_avatar_anim_running = "is_avatar_anim_running";
        public static final String is_live = "is_live";
        public static final String is_portrait = "is_portrait";
        public static final String is_top_anchor = "is_top_anchor";
        public static final String landscape_scene = "landscape_scene";
        public static final String live_os_version = "live_os_version";
        public static final String live_sdk_version = "live_sdk_version";
        public static final String modules = "modules";
        public static final String monitor_trigger = "monitor_trigger";
        public static final String multi_infos = "multi_infos";
        public static final String room_audience_count = "room_audience_count";
        public static final String room_id = "room_id";
        public static final String room_stay_duration = "room_stay_duration";
        public static final String room_type = "room_type";
        public static final String user_type = "user_type";
    }

    public interface PlayerClient {
        public static final String p2p_play_enabled = "p2p_play_enabled";
        public static final String player_audio_decoder_rms_db = "audio_decoder_rms_db";
        public static final String player_audio_render_rms_db = "audio_render_rms_db";
        public static final String player_client_associate_page = "player_client_associate_page";
        public static final String player_client_biz_domain = "player_client_biz_domain";
        public static final String player_client_can_share = "player_client_can_share";
        public static final String player_client_count = "player_client_count";
        public static final String player_client_play_url = "player_client_play_url";
        public static final String player_client_playing_count = "player_client_playing_count";
        public static final String player_client_pulling_stream_count = "player_client_pulling_stream_count";
        public static final String player_client_resolution = "player_client_resolution";
        public static final String player_client_state = "player_client_state";
        public static final String player_client_stream_size = "player_client_stream_size";
        public static final String player_client_vr_fov = "player_client_vr_fov";
        public static final String sharpen_enabled = "sharpen_enabled";
        public static final String super_resolution_enabled = "super_resolution_enabled";
        public static final String system_music_changed = "volume_change_value";
        public static final String system_music_current_volume = "volume_level";
        public static final String system_music_max_volume = "volume_max_level";
        public static final String texture_render_enabled = "texture_render_enabled";
    }

    public @interface Scene {
    }

    public interface Stall {
        public static final String fps = "fps";
        public static final String has_stall = "has_stall";
        public static final String stall_drop_frame = "stall_drop_frame";
        public static final String stall_monitor_duration = "stall_monitor_duration";
        public static final String stall_ui_count = "stall_ui_count";
        public static final String stall_ui_duration = "stall_ui_duration";
        public static final String stall_ui_minor_rate = "stall_ui_minor_rate";
        public static final String stall_ui_moderate_rate = "stall_ui_moderate_rate";
        public static final String stall_ui_rate = "stall_ui_rate";
        public static final String stall_ui_rate_new = "stall_ui_rate_new";
        public static final String stall_ui_serious_rate = "stall_ui_serious_rate";
        public static final String stall_ui_slight_rate = "stall_ui_slight_rate";
        public static final String stall_video_count = "stall_video_count";
        public static final String stall_video_duration = "stall_video_duration";
        public static final String stall_video_origin_info = "stall_video_origin_info";
        public static final String stall_video_rate = "stall_video_rate";
        public static final String stall_video_ui_rate = "stall_video_ui_rate";
    }

    public interface Stream {
        public static final String stream_cdn_ip = "stream_cdn_ip";
        public static final String stream_cdn_play_url = "stream_cdn_play_url";
        public static final String stream_host = "stream_host";
        public static final String stream_in_cap_fps = "stream_in_cap_fps";
        public static final String stream_preview_fps = "stream_preview_fps";
        public static final String stream_real_fps = "stream_real_fps";
        public static final String stream_resolution = "resolution";
        public static final String stream_surface_render = "stream_surface_render";
    }

    public interface Temperature {
        public static final String temperature_android = "temperature_android";
    }

    void addNetworkObserver(INetworkChangeListener r100);

    IPerformanceCacheData createPerformanceCacheData();

    void forceStopLoadStallMonitor(long r100, boolean r101);

    int getBatteryChange();

    double getBatteryCurrent();

    int getBatteryLevel();

    double getCpuRate();

    double getCpuSpeed();

    int getCurrentMusicVolume();

    long getDeviceAvailable();

    long getDeviceThreshold();

    long getDeviceTotal();

    double getEffectProcessTextureTime();

    double getEffectPureAlgorithmTime();

    double getEffectPureRenderTime();

    double getEffectWaitAlgorithmTime();

    float getFps();

    float getFpsInMin();

    float getFrameIntervalMillis();

    double getGpuUsed();

    long getGraphics();

    long getJavaHeapFree();

    long getJavaHeapLeave();

    long getJavaHeapSum();

    long getJavaHeapTotal();

    int getMaxMusicVolume();

    String getModule();

    Set<String> getModulesInfo();

    long getNativeHeapLeave();

    long getNativeHeapSum();

    int getNetQuality();

    long getPoorNet();

    long getPssDalvik();

    long getPssTotal();

    String getScene();

    double getStreamRealFps();

    double getStreamRenderFps();

    float getTemperature();

    float getUIStallDuration();

    float getUIStallRate();

    double getVideoCaptureFps();

    boolean isDeviceMemLow();

    void monitorPerformance(String r100);

    void onAudioStall(Long r100);

    void onCommerceLoaded(long r100, String r101);

    void onContinueShowStart(long r100, String r101);

    void onDirectShowStart(long r100, String r101);

    void onEffectiveConnectionTypeChanged(int r100);

    void onEnterFullScreenClean();

    void onEnterPlay();

    void onEnterRoom(Bundle r100);

    void onExitPlay();

    void onExitRoom();

    void onExperienceSceneChange(String r100, int r101);

    void onFastGiftLoaded(long r100, String r101);

    void onFirstFrameReady(long r100, String r101);

    void onGiftLoaded(long r100, String r101);

    void onInitRoomStart(long r100, String r101);

    void onLeaveFullScreenClean();

    void onModuleStart(String r100, Map<String, String> r101);

    void onModuleStop(String r100);

    void onMultiModuleStart(String r100, int r101);

    void onMultiModuleStart(String r100, String r101);

    void onMultiModuleStart(String r100, JSONArray r101);

    void onMultiModuleStart(String r100, JSONObject r101);

    void onMultiModuleStop(String r100);

    void onOtherWidgetLoadStart(long r100, String r101);

    void onP0WidgetLoadStart(long r100, String r101);

    void onP0WidgetLoaded(long r100, String r101);

    void onP1WidgetLoadStart(long r100, String r101);

    void onP1WidgetLoaded(long r100, String r101);

    void onP2WidgetLoadStart(long r100, String r101);

    void onP2WidgetLoaded(long r100, String r101);

    void onPacketLossComputed(int r100, double r101, double r102, double r103, double r104);

    void onPartShowStart(long r100, String r101);

    void onRTTOrThroughputEstimatesComputed(int r100, int r101, int r102);

    void onRoomFragmentCreated(long r100, String r101);

    void onStreamNetStall(Long r100);

    void onStreamNetStallEnd();

    void onStreamNetStallStart();

    void onTTNetDetectResult(String r100);

    void onVideoRenderStall(Long r100);

    void onWidgetLoaded(long r100, String r101);

    void release(int r100);

    void releaseFpsMonitor(String r100);

    void releaseVideoPlayer();

    void removeNetworkObserver(INetworkChangeListener r100);

    void reportMemoryWhenEnterLivePage(Fragment r100, boolean r101);

    void sendLog(long r100, String r101);

    void setEffectInfo(double r100, double r101, double r102, double r103, String r104);

    void setIsAnchor(boolean r100);

    void setIsLive(boolean r100);

    void setIsMultiProcess(int r100);

    void setIsRestartBroadcast(boolean r100);

    void setPushStreamInfo(double r100, double r101, double r102);

    void setStreamType(int r100);

    void setStreamType(ILiveMode r100);

    void startLoadStallMonitor(long r100);

    void startMkStallMonitor(long r100);

    void startMkStallMonitorForAnchor(long r100, boolean r101);

    void startMonitorFps(String r100);

    void startMonitorFps(String r100, Window r101);

    void startOpenLiveMonitor(String r100);

    void startPushStreamMonitor(String r100);

    void startTimerMonitor(int r100);

    void stopMkStallMonitor(long r100, String r101, String r102, boolean r103, Function0<Unit> r104);

    void stopMkStallMonitorAnchor(long r100, String r101, String r102, String r103);

    void stopMonitorFps(String r100, IStallCallback r101);

    void stopTimerMonitor(int r100);
}
