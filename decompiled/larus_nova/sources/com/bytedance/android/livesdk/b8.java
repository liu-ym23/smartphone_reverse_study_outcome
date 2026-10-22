package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.LiveTeaDynamicConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class b8 extends SettingKey<LiveTeaDynamicConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b8 f104237a = null;

    static {
        f104237a = new b8();
    }

    public b8() {
        super("live_track_clip_config", "直播埋点上报拦截", new LiveTeaDynamicConfig(), new LiveTeaDynamicConfig(), true);
    }
}
