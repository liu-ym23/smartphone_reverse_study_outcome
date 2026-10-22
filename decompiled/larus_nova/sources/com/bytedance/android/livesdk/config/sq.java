package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class sq extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sq f121245a = null;

    static {
        f121245a = new sq();
    }

    public sq() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_anchor_toolbar_backup_req", "主播侧toolbar兜底逻辑", r100, r100);
    }
}
