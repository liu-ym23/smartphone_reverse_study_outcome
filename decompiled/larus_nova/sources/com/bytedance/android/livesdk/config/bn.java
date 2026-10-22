package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class bn extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bn f119885a = null;

    static {
        f119885a = new bn();
    }

    public bn() {
        Boolean r100 = Boolean.FALSE;
        super("live_detail_enable_multi_player", "混滑场景多播放器", r100, r100, new String[]{"true:支持多播放器", "false:不支持多播放器"});
    }
}
