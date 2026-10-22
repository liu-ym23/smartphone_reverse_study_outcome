package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class uy extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uy f121409a = null;

    static {
        f121409a = new uy();
    }

    public uy() {
        Boolean r100 = Boolean.TRUE;
        super("live_gift_close_anchor_block_switch", "主播关闭送礼功能后拦截玩法入口点击", r100, r100);
    }
}
