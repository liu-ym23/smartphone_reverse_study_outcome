package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ks extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ks f120625a = null;

    static {
        f120625a = new ks();
    }

    public ks() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_multi_video_talk_sync", "MultiLinkVideoTalkRoomGuestWidget同步加载方式", r100, r100);
    }
}
