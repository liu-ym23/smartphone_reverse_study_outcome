package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nt0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nt0 f120859a = null;

    static {
        f120859a = new nt0();
    }

    public nt0() {
        Boolean r100 = Boolean.TRUE;
        super("live_streamer_end_page_preload", "关播页使用新链接启用preload", r100, r100);
    }
}
