package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class l4 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l4 f146988a = null;

    static {
        f146988a = new l4();
    }

    public l4() {
        Boolean r100 = Boolean.TRUE;
        super("live_audience_default_open_camera", "嘉宾默认视频连线和展示美颜面板开关", r100, r100);
    }
}
