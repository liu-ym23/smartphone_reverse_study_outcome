package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class lb0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lb0 f120666a = null;

    static {
        f120666a = new lb0();
    }

    public lb0() {
        Boolean r100 = Boolean.TRUE;
        super("live_multilink_miniappcommonmessage_fix", "多人场景嘉宾云启动消息去重", r100, r100);
    }
}
