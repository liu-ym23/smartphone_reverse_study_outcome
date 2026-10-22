package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class l2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l2 f146986a = null;

    static {
        f146986a = new l2();
    }

    public l2() {
        super("live_preview_view_holder_mem_leak_fix", "直播feed泄漏修改", Boolean.FALSE, Boolean.TRUE);
    }
}
