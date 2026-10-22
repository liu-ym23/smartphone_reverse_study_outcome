package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class j10 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j10 f120494a = null;

    static {
        f120494a = new j10();
    }

    public j10() {
        Boolean r100 = Boolean.FALSE;
        super("live_inner_end_preview_backup", "刷空使用预览流直播间兜底", r100, r100);
    }
}
