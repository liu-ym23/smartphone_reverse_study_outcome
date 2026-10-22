package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class i1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i1 f132635a = null;

    static {
        f132635a = new i1();
    }

    public i1() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_vs_media_play_area", "媒体节目融合是否UI对齐(播控区域、toolbar等)", r100, r100);
    }
}
