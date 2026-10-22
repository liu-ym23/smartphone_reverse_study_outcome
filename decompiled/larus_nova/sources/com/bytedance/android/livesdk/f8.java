package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.LiveVisionFrameDegradeConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class f8 extends SettingKey<LiveVisionFrameDegradeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f8 f123406a = null;

    static {
        f123406a = new f8();
    }

    public f8() {
        super("live_ui_upgrade", "直播间视觉框架降级配置", new LiveVisionFrameDegradeConfig(), new LiveVisionFrameDegradeConfig());
    }
}
