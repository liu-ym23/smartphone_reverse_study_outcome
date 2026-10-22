package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class n2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n2 f65365a = null;

    static {
        f65365a = new n2();
    }

    public n2() {
        Boolean r100 = Boolean.FALSE;
        super("live_media_session_config", "直播媒体会话配置", r100, r100, true);
    }
}
