package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class a2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f102993a = null;

    static {
        f102993a = new a2();
    }

    public a2() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_layout_inner_optimize", "播放器布局内流宽高优化", r100, r100);
    }
}
