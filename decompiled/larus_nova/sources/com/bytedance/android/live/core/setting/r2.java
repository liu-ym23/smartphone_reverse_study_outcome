package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class r2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r2 f65398a = null;

    static {
        f65398a = new r2();
    }

    public r2() {
        Boolean r100 = Boolean.FALSE;
        super("live_multi_link_anchor_skip_sync_when_attach", "SaaS主播续播跳过syncRoomStats", r100, r100);
    }
}
