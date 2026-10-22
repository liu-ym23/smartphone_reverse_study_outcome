package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.CloudGroupLiveDeviceScoreConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class il extends SSettingKey<CloudGroupLiveDeviceScoreConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final il f120462a = null;

    static {
        f120462a = new il();
    }

    public il() {
        super("live_cloud_collaborate_settings", "云团播主播设备机型准入", new CloudGroupLiveDeviceScoreConfig(), new CloudGroupLiveDeviceScoreConfig());
    }
}
