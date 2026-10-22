package com.obric.autoaction.e;

import com.obric.autogui.common.api.configs.AutoActionConfigs;

/* JADX INFO: compiled from: SettingsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f24684a = null;

    static {
        f24684a = new e();
    }

    private e() {
    }

    public final boolean a() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_share", false);
    }
}
