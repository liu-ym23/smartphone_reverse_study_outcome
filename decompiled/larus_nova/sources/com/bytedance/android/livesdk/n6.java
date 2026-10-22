package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class n6 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n6 f153998a = null;

    static {
        f153998a = new n6();
    }

    public n6() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_dynamic_fallback_fix_enable", "多人连线动态化服务已存在时返回兜底组件", r100, r100);
    }
}
