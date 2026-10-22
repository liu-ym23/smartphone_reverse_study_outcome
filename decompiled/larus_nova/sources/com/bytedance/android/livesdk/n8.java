package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class n8 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n8 f154000a = null;

    static {
        f154000a = new n8();
    }

    public n8() {
        super("multi_anchor_cross_channel_backup_timer_duration", "多人主播连线兜底超时", 8, 8);
    }
}
