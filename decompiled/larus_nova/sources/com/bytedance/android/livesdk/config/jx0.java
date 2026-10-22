package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class jx0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jx0 f120559a = null;

    static {
        f120559a = new jx0();
    }

    public jx0() {
        Boolean r100 = Boolean.TRUE;
        super("live_virtual_live_jsb_manager_set_fix", "虚拟直播jsbManager异常设置修复", r100, r100, false);
    }
}
