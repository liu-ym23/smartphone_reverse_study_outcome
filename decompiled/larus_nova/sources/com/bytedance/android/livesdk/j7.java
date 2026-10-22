package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class j7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j7 f142020a = null;

    static {
        f142020a = new j7();
    }

    public j7() {
        Boolean r100 = Boolean.FALSE;
        super("live_public_screen_request_adjust_post_enable", "公屏高度&宽度计算时机优化", r100, r100);
    }
}
