package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class ak0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ak0 f119800a = null;

    static {
        f119800a = new ak0();
    }

    public ak0() {
        Boolean r100 = Boolean.FALSE;
        super("live_preview_video_core_path_merge_single", "单页面下开播页音画链路合并", r100, r100);
    }
}
