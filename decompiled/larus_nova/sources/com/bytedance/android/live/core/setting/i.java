package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class i extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f65319a = null;

    static {
        f65319a = new i();
    }

    public i() {
        Boolean r100 = Boolean.FALSE;
        super("link_pull_stream_enable", "连麦期间是否允许拉流", r100, r100);
    }
}
