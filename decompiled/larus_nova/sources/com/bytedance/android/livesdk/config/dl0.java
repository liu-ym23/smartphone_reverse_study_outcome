package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class dl0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dl0 f120047a = null;

    static {
        f120047a = new dl0();
    }

    public dl0() {
        Boolean r100 = Boolean.FALSE;
        super("live_ps_use_backend_top_message", "公屏使用backend下发置顶消息", r100, r100);
    }
}
