package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveBackupSeiSettingConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class y extends SSettingKey<LiveBackupSeiSettingConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f162543a = null;

    static {
        f162543a = new y();
    }

    public y() {
        super("live_backup_sei_setting_config", "备份SEI框架开关配置", new LiveBackupSeiSettingConfig(), new LiveBackupSeiSettingConfig());
    }
}
