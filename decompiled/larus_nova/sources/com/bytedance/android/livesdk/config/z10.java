package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class z10 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z10 f121731a = null;

    static {
        f121731a = new z10();
    }

    public z10() {
        Boolean r100 = Boolean.FALSE;
        super("live_inner_reach_end_backup", "刷空使用直播缓存池兜底", r100, r100);
    }
}
