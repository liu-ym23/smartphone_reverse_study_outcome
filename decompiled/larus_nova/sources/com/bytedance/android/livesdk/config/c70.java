package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.DefaultVoiceLiveThemeResource;

/* JADX INFO: loaded from: classes8.dex */
public final class c70 extends SettingKey<DefaultVoiceLiveThemeResource> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c70 f119926a = null;

    static {
        f119926a = new c70();
    }

    public c70() {
        super("live_local_default_audio_theme", "语音直播默认背景资源", DefaultVoiceLiveThemeResource.localRes(), DefaultVoiceLiveThemeResource.localRes());
    }
}
