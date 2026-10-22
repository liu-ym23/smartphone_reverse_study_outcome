package com.obric.autoaction.presentation.doubao;

import com.obric.autogui.common.api.configs.AutoActionConfigs;

/* JADX INFO: compiled from: SettingsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f24896a = null;

    static {
        f24896a = new k();
    }

    private k() {
    }

    public final boolean a() {
        return AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.common.enable_share", false);
    }
}
