package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class y3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y3 f65462a = null;

    static {
        f65462a = new y3();
    }

    public y3() {
        Boolean r100 = Boolean.TRUE;
        super("live_play_together_widget_hide_opt", "适用于一起玩场景下的直播间容器精简的端上兜底总开关", r100, r100);
    }
}
