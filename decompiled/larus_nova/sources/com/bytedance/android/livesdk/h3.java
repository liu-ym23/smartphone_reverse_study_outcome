package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class h3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h3 f132625a = null;

    static {
        f132625a = new h3();
    }

    public h3() {
        Boolean r100 = Boolean.TRUE;
        super("live_top_margin_fix_enable", "顶部距离适配", r100, r100);
    }
}
