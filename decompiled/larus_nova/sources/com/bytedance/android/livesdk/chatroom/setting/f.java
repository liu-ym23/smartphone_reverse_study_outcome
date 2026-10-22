package com.bytedance.android.livesdk.chatroom.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f111524a = null;

    static {
        f111524a = new f();
    }

    public f() {
        Boolean r100 = Boolean.FALSE;
        super("live_setting_by_lazy_opt", "是否开启settings读取by lazy + 缓存优化", r100, r100);
    }
}
