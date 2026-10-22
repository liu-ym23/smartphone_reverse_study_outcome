package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.RankInfoList;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class h21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<Boolean> f120333a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SettingKey<Boolean> f120334b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SettingKey<w0> f120335c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SettingKey<Boolean> f120336d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f120337e = null;

    static {
        f120333a = LiveInfraSettingKeys.LIVE_SHARE_IN_TOOLBAR;
        SettingKey<Boolean> r100 = j40.a4.f497168a;
        SettingKey<Boolean> r101 = j40.a4.f497168a;
        SettingKey<Boolean> r102 = j40.a4.f497168a;
        f120334b = LiveInfraSettingKeys.FIX_TOOLBAR_MANAGER_LEAK_CONTEXT;
        f120335c = LiveInfraSettingKeys.LIVE_BROADCAST_PAUSE_NEW_STYLE;
        SettingKey<Boolean> r103 = j40.a4.f497168a;
        SettingKey<Boolean> r104 = j40.a4.f497168a;
        SettingKey<Boolean> r105 = j40.a4.f497168a;
        f120336d = LiveInfraSettingKeys.LIVE_VALUE_ANIM_CAN_FALLBACK_TO_FRAME;
        SettingKey<RankInfoList> r106 = LiveInfraSettingKeys.LIVE_RANK_INFO_LIST;
        f120337e = CollectionsKt.listOf(new String[]{"type", "start_enter_room", "start_request_feed", "end_request_feed", "start_request_room", "end_request_room", "start_setup", "end_setup", "room_container_build", "play_container_build", "play_container_end", "start_pull_stream", PortraitEngine.LABEL_FIRST_FRAME, "playing", "stream_start", "stream_sdk_dns_analysis_end", "end_p0_widget_load", "duration_param_build", "duration_feed_request", "duration_start_page", "duration_page_init", "duration_room_container_build", "duration_play_container_build", "duration_wait_playing"});
    }
}
