package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class j6 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j6 f142019a = null;

    static {
        f142019a = new j6();
    }

    public j6() {
        super("live_message_duplicate_buffer_size", "消息缓冲区大小", 512, 512);
    }
}
