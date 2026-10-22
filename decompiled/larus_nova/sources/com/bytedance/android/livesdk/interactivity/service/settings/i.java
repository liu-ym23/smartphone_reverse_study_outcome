package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f140997a = null;

    static {
        f140997a = new i();
    }

    public i() {
        Boolean r100 = Boolean.TRUE;
        super("live_text_decoder_use_correct_config", "文本Decoder使用正确的解析config", r100, r100);
    }
}
