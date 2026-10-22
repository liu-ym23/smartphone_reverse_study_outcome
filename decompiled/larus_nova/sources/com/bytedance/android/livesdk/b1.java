package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class b1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b1 f104230a = null;

    static {
        f104230a = new b1();
    }

    public b1() {
        Boolean r100 = Boolean.FALSE;
        super("live_left_up_block_poi_update_enable", "左上角屏蔽更新poi标签的消息", r100, r100);
    }
}
