package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdk.config.l21;

/* JADX INFO: loaded from: classes45.dex */
public final class j0 extends SSettingKey<l21> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f65328a = null;

    static {
        f65328a = new j0();
    }

    public j0() {
        super("live_descriptor_load_config", "组件加载策略配置", new l21(), new l21(), true);
    }
}
