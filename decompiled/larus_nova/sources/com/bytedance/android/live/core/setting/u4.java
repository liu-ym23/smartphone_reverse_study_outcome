package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class u4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u4 f65424a = null;

    static {
        f65424a = new u4();
    }

    public u4() {
        Boolean r100 = Boolean.FALSE;
        super("live_room_indicator_enable_dialog", "右上角通用指示器是否支持点击出弹窗", r100, r100);
    }
}
