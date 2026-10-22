package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class x4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x4 f162537a = null;

    static {
        f162537a = new x4();
    }

    public x4() {
        Boolean r100 = Boolean.TRUE;
        super("enable_annieX_interactive_container", "是否启用互动组件使用annieX容器", r100, r100);
    }
}
