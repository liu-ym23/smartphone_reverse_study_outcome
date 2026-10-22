package com.bytedance.android.livesdk.performance.aapleasure;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/performance/aapleasure/AtomicAbilityLabel;", "", "", "label", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "Default", "live_resource_brightness_service", "live_resource_trace_report", "live_resource_preview_behavior", "live_resource_preview_guide_anim", "live_resource_preview_extend_area_anim", "live_resource_preview_bottom_extend_anim", "live_resource_preview_hot_comment_anim", "live_resource_performance_behavior", "live_resource_report_logger_behavior", "live_resource_alogger_behavior", "live_resource_user_behavior_monitor_behavior", "live_resource_hour_rank_anim", "live_resource_move_sampling_behavior", "live_resource_multilink_radio_base_degrade", "live_resource_multilink_video_link_enable", "live_resource_multilink_toolbar_degrade", "live_resource_multilink_sei_consume", "live_resource_multilink_dynamic_bg", "live_resource_multilink_video_effect", "live_resource_multilink_base_degrade", "live_resource_multilink_battle_base_degrade", "live_resource_multilink_extreme_degrade", "live_resource_multilink_ktv_base", "live_resource_multilink_ktv_preview_song", "live_resource_anniex_monitor", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AtomicAbilityLabel extends Enum<AtomicAbilityLabel> {
    public static final AtomicAbilityLabel Default = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicAbilityLabel[] f154409a = null;
    public static final AtomicAbilityLabel live_resource_alogger_behavior = null;
    public static final AtomicAbilityLabel live_resource_anniex_monitor = null;
    public static final AtomicAbilityLabel live_resource_brightness_service = null;
    public static final AtomicAbilityLabel live_resource_hour_rank_anim = null;
    public static final AtomicAbilityLabel live_resource_move_sampling_behavior = null;
    public static final AtomicAbilityLabel live_resource_multilink_base_degrade = null;
    public static final AtomicAbilityLabel live_resource_multilink_battle_base_degrade = null;
    public static final AtomicAbilityLabel live_resource_multilink_dynamic_bg = null;
    public static final AtomicAbilityLabel live_resource_multilink_extreme_degrade = null;
    public static final AtomicAbilityLabel live_resource_multilink_ktv_base = null;
    public static final AtomicAbilityLabel live_resource_multilink_ktv_preview_song = null;
    public static final AtomicAbilityLabel live_resource_multilink_radio_base_degrade = null;
    public static final AtomicAbilityLabel live_resource_multilink_sei_consume = null;
    public static final AtomicAbilityLabel live_resource_multilink_toolbar_degrade = null;
    public static final AtomicAbilityLabel live_resource_multilink_video_effect = null;
    public static final AtomicAbilityLabel live_resource_multilink_video_link_enable = null;
    public static final AtomicAbilityLabel live_resource_performance_behavior = null;
    public static final AtomicAbilityLabel live_resource_preview_behavior = null;
    public static final AtomicAbilityLabel live_resource_preview_bottom_extend_anim = null;
    public static final AtomicAbilityLabel live_resource_preview_extend_area_anim = null;
    public static final AtomicAbilityLabel live_resource_preview_guide_anim = null;
    public static final AtomicAbilityLabel live_resource_preview_hot_comment_anim = null;
    public static final AtomicAbilityLabel live_resource_report_logger_behavior = null;
    public static final AtomicAbilityLabel live_resource_trace_report = null;
    public static final AtomicAbilityLabel live_resource_user_behavior_monitor_behavior = null;
    private final String label;

    public static AtomicAbilityLabel valueOf(String r100) {
        return (AtomicAbilityLabel) r27.a.a(AtomicAbilityLabel.class, r100);
    }

    public static AtomicAbilityLabel[] values() {
        return (AtomicAbilityLabel[]) f154409a.clone();
    }

    static {
        AtomicAbilityLabel r100 = new AtomicAbilityLabel("Default", 0, "Default");
        Default = r100;
        AtomicAbilityLabel r101 = new AtomicAbilityLabel("live_resource_brightness_service", 1, "live_resource_brightness_service");
        live_resource_brightness_service = r101;
        AtomicAbilityLabel r102 = new AtomicAbilityLabel("live_resource_trace_report", 2, "live_resource_trace_report");
        live_resource_trace_report = r102;
        AtomicAbilityLabel r103 = new AtomicAbilityLabel("live_resource_preview_behavior", 3, "live_resource_preview_behavior");
        live_resource_preview_behavior = r103;
        AtomicAbilityLabel r104 = new AtomicAbilityLabel("live_resource_preview_guide_anim", 4, "live_resource_preview_guide_anim");
        live_resource_preview_guide_anim = r104;
        AtomicAbilityLabel r105 = new AtomicAbilityLabel("live_resource_preview_extend_area_anim", 5, "live_resource_preview_extend_area_anim");
        live_resource_preview_extend_area_anim = r105;
        AtomicAbilityLabel r106 = new AtomicAbilityLabel("live_resource_preview_bottom_extend_anim", 6, "live_resource_preview_bottom_extend_anim");
        live_resource_preview_bottom_extend_anim = r106;
        AtomicAbilityLabel r107 = new AtomicAbilityLabel("live_resource_preview_hot_comment_anim", 7, "live_resource_preview_hot_comment_anim");
        live_resource_preview_hot_comment_anim = r107;
        AtomicAbilityLabel r108 = new AtomicAbilityLabel("live_resource_performance_behavior", 8, "live_resource_performance_behavior");
        live_resource_performance_behavior = r108;
        AtomicAbilityLabel r109 = new AtomicAbilityLabel("live_resource_report_logger_behavior", 9, "live_resource_report_logger_behavior");
        live_resource_report_logger_behavior = r109;
        AtomicAbilityLabel r110 = new AtomicAbilityLabel("live_resource_alogger_behavior", 10, "live_resource_alogger_behavior");
        live_resource_alogger_behavior = r110;
        AtomicAbilityLabel r111 = new AtomicAbilityLabel("live_resource_user_behavior_monitor_behavior", 11, "live_resource_user_behavior_monitor_behavior");
        live_resource_user_behavior_monitor_behavior = r111;
        AtomicAbilityLabel r112 = new AtomicAbilityLabel("live_resource_hour_rank_anim", 12, "live_resource_hour_rank_anim");
        live_resource_hour_rank_anim = r112;
        AtomicAbilityLabel r113 = new AtomicAbilityLabel("live_resource_move_sampling_behavior", 13, "live_resource_move_sampling_behavior");
        live_resource_move_sampling_behavior = r113;
        AtomicAbilityLabel r114 = new AtomicAbilityLabel("live_resource_multilink_radio_base_degrade", 14, "live_resource_multilink_radio_base_degrade");
        live_resource_multilink_radio_base_degrade = r114;
        AtomicAbilityLabel r115 = new AtomicAbilityLabel("live_resource_multilink_video_link_enable", 15, "live_resource_multilink_video_link_enable");
        live_resource_multilink_video_link_enable = r115;
        AtomicAbilityLabel r116 = new AtomicAbilityLabel("live_resource_multilink_toolbar_degrade", 16, "live_resource_multilink_toolbar_degrade");
        live_resource_multilink_toolbar_degrade = r116;
        AtomicAbilityLabel r117 = new AtomicAbilityLabel("live_resource_multilink_sei_consume", 17, "live_resource_multilink_sei_consume");
        live_resource_multilink_sei_consume = r117;
        AtomicAbilityLabel r118 = new AtomicAbilityLabel("live_resource_multilink_dynamic_bg", 18, "live_resource_multilink_dynamic_bg");
        live_resource_multilink_dynamic_bg = r118;
        AtomicAbilityLabel r119 = new AtomicAbilityLabel("live_resource_multilink_video_effect", 19, "live_resource_multilink_video_effect");
        live_resource_multilink_video_effect = r119;
        AtomicAbilityLabel r120 = new AtomicAbilityLabel("live_resource_multilink_base_degrade", 20, "live_resource_multilink_base_degrade");
        live_resource_multilink_base_degrade = r120;
        AtomicAbilityLabel r121 = new AtomicAbilityLabel("live_resource_multilink_battle_base_degrade", 21, "live_resource_multilink_battle_base_degrade");
        live_resource_multilink_battle_base_degrade = r121;
        AtomicAbilityLabel r122 = new AtomicAbilityLabel("live_resource_multilink_extreme_degrade", 22, "live_resource_multilink_extreme_degrade");
        live_resource_multilink_extreme_degrade = r122;
        AtomicAbilityLabel r123 = new AtomicAbilityLabel("live_resource_multilink_ktv_base", 23, "live_resource_multilink_ktv_base");
        live_resource_multilink_ktv_base = r123;
        AtomicAbilityLabel r124 = new AtomicAbilityLabel("live_resource_multilink_ktv_preview_song", 24, "live_resource_multilink_ktv_preview_song");
        live_resource_multilink_ktv_preview_song = r124;
        AtomicAbilityLabel r125 = new AtomicAbilityLabel("live_resource_anniex_monitor", 25, "live_resource_anniex_monitor");
        live_resource_anniex_monitor = r125;
        f154409a = new AtomicAbilityLabel[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
    }

    public final String getLabel() {
        return this.label;
    }

    public AtomicAbilityLabel(String r100, int r101, String r102) {
        super(r100, r101);
        this.label = r102;
    }
}
