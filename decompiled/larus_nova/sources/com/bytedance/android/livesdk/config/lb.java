package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lb extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lb f120665a = null;

    static {
        f120665a = new lb();
    }

    public lb() {
        Boolean r100 = Boolean.FALSE;
        super("live_anchor_enable_chat_group_live", "群直播需求开关", r100, r100, true);
    }
}
