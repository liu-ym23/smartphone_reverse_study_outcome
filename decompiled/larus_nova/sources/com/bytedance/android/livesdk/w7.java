package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class w7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w7 f160656a = null;

    static {
        f160656a = new w7();
    }

    public w7() {
        Boolean r100 = Boolean.TRUE;
        super("live_suffix_can_show_all_message", "消息后缀扩大展示范围", r100, r100);
    }
}
