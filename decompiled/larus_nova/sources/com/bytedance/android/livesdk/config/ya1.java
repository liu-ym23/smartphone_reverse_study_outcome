package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.feed.tabviewmodel.MultiTabContainerConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ya1 extends SSettingKey<MultiTabContainerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ya1 f121671a = null;

    static {
        f121671a = new ya1();
    }

    public ya1() {
        super("livesdk_multi_tab_container_config", "多tab容器配置", new MultiTabContainerConfig(), new MultiTabContainerConfig());
    }
}
