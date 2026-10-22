package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f119910a = null;

    static {
        f119910a = new c();
    }

    public c() {
        Boolean r100 = Boolean.TRUE;
        super("anchor_game_commerce_both_existed", "小手柄和购物车共存主播侧开关", r100, r100);
    }
}
