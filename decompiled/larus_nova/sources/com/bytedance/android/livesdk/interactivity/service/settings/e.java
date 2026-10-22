package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f140993a = null;

    static {
        f140993a = new e();
    }

    public e() {
        super("live_public_screen_anim_frames_per_second", "公屏AnimFrame优化-动画帧率", 20, 20);
    }
}
