package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class y2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y2 f65461a = null;

    static {
        f65461a = new y2();
    }

    public y2() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_layout_config_update_surface_view_location", "布局配置文件更新时同步更新语音聊天室surfaceview位置", r100, r100);
    }
}
