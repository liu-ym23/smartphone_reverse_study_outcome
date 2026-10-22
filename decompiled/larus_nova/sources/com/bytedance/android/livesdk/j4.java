package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class j4 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j4 f142017a = null;

    static {
        f142017a = new j4();
    }

    public j4() {
        super("live_anchor_preset_template_size_limit", "美颜预设模板数量上限", 20, 20);
    }
}
