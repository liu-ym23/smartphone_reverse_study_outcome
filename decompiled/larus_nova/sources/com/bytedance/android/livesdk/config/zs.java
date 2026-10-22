package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class zs extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zs f121788a = null;

    static {
        f121788a = new zs();
    }

    public zs() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_server_merge_stream", "个播场景小玩法是否启用服务端合流", r100, r100, true);
    }
}
