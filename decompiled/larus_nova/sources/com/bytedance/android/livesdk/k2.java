package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.g71;

/* JADX INFO: loaded from: classes7.dex */
public final class k2 extends SettingKey<g71> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k2 f142263a = null;

    static {
        f142263a = new k2();
    }

    public k2() {
        super("live_preview_merge_config", "预览流外显组件点击进房交互层透明度", new g71(), new g71());
    }
}
