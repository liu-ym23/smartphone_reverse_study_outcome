package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class kb extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kb f120587a = null;

    static {
        f120587a = new kb();
    }

    public kb() {
        super("live_anchor_enable_announcement_highlight", "主播开启直播预告推送能力", Boolean.FALSE, Boolean.TRUE);
    }
}
