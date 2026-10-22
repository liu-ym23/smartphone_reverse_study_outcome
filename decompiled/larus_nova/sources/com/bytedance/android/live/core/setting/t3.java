package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: classes45.dex */
public final class t3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t3 f65415a = null;

    static {
        f65415a = new t3();
    }

    public t3() {
        Boolean r100 = Boolean.FALSE;
        super("live_player_enable_stream_type_fix", "直播间内流修复传入播放器的streamtype不准的问题", r100, r100, false);
    }
}
