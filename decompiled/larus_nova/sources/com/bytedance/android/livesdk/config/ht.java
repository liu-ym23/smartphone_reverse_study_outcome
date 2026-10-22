package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ht extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ht f120402a = null;

    static {
        f120402a = new ht();
    }

    public ht() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_talk_room_pre_load", "是否开启聊天室界面预加载", r100, r100);
    }
}
