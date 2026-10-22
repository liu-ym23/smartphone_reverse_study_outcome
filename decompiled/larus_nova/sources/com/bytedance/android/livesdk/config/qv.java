package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class qv extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qv f121085a = null;

    static {
        f121085a = new qv();
    }

    public qv() {
        Boolean r100 = Boolean.TRUE;
        super("live_feed_drawer_enable", "抽屉入口更多直播是否展示", r100, r100);
    }
}
