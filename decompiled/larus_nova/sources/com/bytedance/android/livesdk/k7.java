package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class k7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k7 f142268a = null;

    static {
        f142268a = new k7();
    }

    public k7() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_show_combined_text_message", "公屏是否可以展示组合消息", r100, r100);
    }
}
