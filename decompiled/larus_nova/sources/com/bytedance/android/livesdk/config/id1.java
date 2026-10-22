package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class id1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final id1 f120443a = null;

    static {
        f120443a = new id1();
    }

    public id1() {
        Boolean r100 = Boolean.TRUE;
        super("paused_live_forbid_auto_play", "暂停状态的直播切后台/前台不自动拉流", r100, r100);
    }
}
