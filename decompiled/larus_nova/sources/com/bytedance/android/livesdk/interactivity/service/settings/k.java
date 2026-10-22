package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class k extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f140999a = null;

    static {
        f140999a = new k();
    }

    public k() {
        Boolean r100 = Boolean.TRUE;
        super("live_uplink_with_bytelink", "直播上行使用ByteLink", r100, r100);
    }
}
