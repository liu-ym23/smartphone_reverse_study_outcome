package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class d8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d8 f121936a = null;

    static {
        f121936a = new d8();
    }

    public d8() {
        Boolean r100 = Boolean.TRUE;
        super("live_use_pk_feed_view_fix", "PK预览流跳动修复", r100, r100);
    }
}
