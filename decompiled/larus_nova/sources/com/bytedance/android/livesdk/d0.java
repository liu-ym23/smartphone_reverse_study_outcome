package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class d0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f121928a = null;

    static {
        f121928a = new d0();
    }

    public d0() {
        Boolean r100 = Boolean.TRUE;
        super("live_common_event_params_fix_switch", "直播公参覆盖业务传递参数修复", r100, r100);
    }
}
