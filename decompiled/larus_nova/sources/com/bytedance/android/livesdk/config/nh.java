package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class nh extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nh f120832a = null;

    static {
        f120832a = new nh();
    }

    public nh() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_new_link_no_pause_when_jump", "跳厅不pause直播间", r100, r100);
    }
}
