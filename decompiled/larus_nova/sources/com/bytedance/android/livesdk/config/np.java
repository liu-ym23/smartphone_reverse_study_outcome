package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveDrawDragPlayConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class np extends SSettingKey<LiveDrawDragPlayConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final np f120850a = null;

    static {
        f120850a = new np();
    }

    public np() {
        super("live_draw_drag_play_config", "直播内流拖拽期间画面播放优化", new LiveDrawDragPlayConfig(), new LiveDrawDragPlayConfig());
    }
}
