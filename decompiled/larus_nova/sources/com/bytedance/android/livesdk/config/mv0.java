package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveUgcPlatformHostInvitationConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class mv0 extends SSettingKey<LiveUgcPlatformHostInvitationConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mv0 f120786a = null;

    static {
        mv0 r100 = new mv0();
        f120786a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public mv0() {
        super("live_ugc_platform_host_invitation_config", LiveUgcPlatformHostInvitationConfig.class, "多人ugc互动玩法嘉宾启动平台托管配置", new LiveUgcPlatformHostInvitationConfig(), new LiveUgcPlatformHostInvitationConfig());
    }
}
