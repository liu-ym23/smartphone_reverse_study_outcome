package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f119991a = null;

    static {
        f119991a = new d();
    }

    public d() {
        Boolean r100 = Boolean.TRUE;
        super("anchor_game_commerce_both_existed_replace_dialog", "小手柄和购物车共存主播侧的切换弹窗逻辑开关", r100, r100);
    }
}
