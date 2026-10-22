package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class w3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w3 f65446a = null;

    static {
        f65446a = new w3();
    }

    public w3() {
        Boolean r100 = Boolean.TRUE;
        super("live_play_together_end_page_opt", "适用于一起玩场景下的关播页优化的端上兜底总开关", r100, r100);
    }
}
