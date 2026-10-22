package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class x2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x2 f65453a = null;

    static {
        f65453a = new x2();
    }

    public x2() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_layout_config_update_region", "布局配置文件更新时同步更新MultiLinkRegionUtils里的配置文件", r100, r100);
    }
}
