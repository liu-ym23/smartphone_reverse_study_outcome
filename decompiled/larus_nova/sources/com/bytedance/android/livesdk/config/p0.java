package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.BroadcastRecordTipConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class p0 extends SSettingKey<BroadcastRecordTipConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f120945a = null;

    static {
        f120945a = new p0();
    }

    public p0() {
        super("broadcast_record_tip_config", "主播侧录屏引导配置", new BroadcastRecordTipConfig(), new BroadcastRecordTipConfig());
    }
}
