package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.live.feature.config.LivePostClientSequenceConfig;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;
import com.bytedance.android.livesdkapi.model.LivePlayerSmoothEnterRoomConfig;
import com.bytedance.android.livesdkapi.model.LivePreviewWormholePredictConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class e81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<LiveFeatureConfig> f120095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SettingKey<CommunityFoldFixConfig> f120096b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SettingKey<Boolean> f120097c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SettingKey<Boolean> f120098d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SettingKey<Integer> f120099e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SettingKey<Integer> f120100f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j40.e f120101g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final SettingKey<LivePostClientSequenceConfig> f120102h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final SettingKey<LivePreviewWormholePredictConfig> f120103i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final SettingKey<Boolean> f120104j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final SettingKey<Boolean> f120105k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final SettingKey<Integer> f120106l = null;

    static {
        new SettingKey("a_test", "测试", null, String.class, true, false, false);
        f120095a = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_FEATURE_CONFIG;
        f120096b = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_COMMUNITY_FOLD_FIX_CONFIG;
        f120097c = LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE;
        f120098d = LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE_SWITCHER;
        f120099e = LiveInfraSettingKeys.TOOLBAR_ITEM_SORT_SEQ_LIST;
        f120100f = LiveInfraSettingKeys.LIVE_ANIMATOR_DEGRADE_FPS_OPT;
        f120101g = j40.e.f497187a;
        f120102h = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_POST_CLIENT_SEQUENCE_CONFIG;
        f120103i = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_AI_PREVIEW_WORMHOLE_CONFIG;
        SettingKey<LivePlayerSmoothEnterRoomConfig> r100 = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_PLAYER_SMOOTH_ENTER_ROOM;
        f120104j = LiveInfraSettingKeys.LIVE_VIDEO_TALK_ROOM_INTERACT_MORE_BUTTON_FOLD;
        f120105k = LiveInfraSettingKeys.LIVE_TOOLBAR_MIN_SLOT;
        f120106l = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_STRATEGY_FAST_SCROLL_RECG_ROOM_COUNT;
    }
}
