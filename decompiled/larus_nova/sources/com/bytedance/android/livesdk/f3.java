package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.SwitchResolutionDialogConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class f3 extends SettingKey<SwitchResolutionDialogConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f3 f123401a = null;

    static {
        f123401a = new f3();
    }

    public f3() {
        super("live_switch_resolution_dialog_config", "清晰度切换弹窗配置", new SwitchResolutionDialogConfig(), new SwitchResolutionDialogConfig());
    }
}
