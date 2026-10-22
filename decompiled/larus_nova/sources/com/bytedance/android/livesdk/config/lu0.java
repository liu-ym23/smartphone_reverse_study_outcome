package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class lu0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lu0 f120709a = null;

    static {
        f120709a = new lu0();
    }

    public lu0() {
        Boolean r100 = Boolean.TRUE;
        super("live_talk_room_support_admin_operate", "聊天室是否允许管理员操作连麦用户", r100, r100);
    }
}
