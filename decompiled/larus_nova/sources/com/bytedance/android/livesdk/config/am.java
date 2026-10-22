package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.PreloadCompData;

/* JADX INFO: loaded from: classes8.dex */
public final class am extends SSettingKey<PreloadCompData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final am f119803a = null;

    static {
        f119803a = new am();
    }

    public am() {
        super("live_comp_preload_config", "组件预加载配置", new PreloadCompData(), new PreloadCompData(), true);
    }
}
