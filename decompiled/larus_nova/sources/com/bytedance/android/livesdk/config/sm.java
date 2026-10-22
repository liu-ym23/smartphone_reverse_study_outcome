package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class sm extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sm f121238a = null;

    static {
        f121238a = new sm();
    }

    public sm() {
        Boolean r100 = Boolean.TRUE;
        super("live_danmu_game_height_bugfix", "danmu 高度调整端上兜底开关 ", r100, r100);
    }
}
