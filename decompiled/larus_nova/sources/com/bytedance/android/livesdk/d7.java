package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class d7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d7 f121935a = null;

    static {
        f121935a = new d7();
    }

    public d7() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_change_anim_opt", "公屏change动画优化开关", r100, r100);
    }
}
