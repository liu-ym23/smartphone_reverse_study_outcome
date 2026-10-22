package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class lz extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lz f120718a = null;

    static {
        f120718a = new lz();
    }

    public lz() {
        Boolean r100 = Boolean.TRUE;
        super("live_group_enable_room_change_logger", "导播合演使用换房方案", r100, r100);
    }
}
