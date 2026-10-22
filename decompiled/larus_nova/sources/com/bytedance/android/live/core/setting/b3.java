package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.MultiLinkPreviewPointConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class b3 extends SSettingKey<MultiLinkPreviewPointConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b3 f65218a = null;

    static {
        f65218a = new b3();
    }

    public b3() {
        super("live_multi_link_preview_point_config", "多人预览流促开播&促连线锚点配置", new MultiLinkPreviewPointConfig(), new MultiLinkPreviewPointConfig());
    }
}
