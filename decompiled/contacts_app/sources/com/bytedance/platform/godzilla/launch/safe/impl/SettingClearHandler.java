package com.bytedance.platform.godzilla.launch.safe.impl;

import android.content.Context;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.launch.safe.api.CrashHandler;

/* JADX INFO: loaded from: classes2.dex */
public class SettingClearHandler extends CrashHandler {
    private SettingClear mSettingClear;

    public interface SettingClear {
        boolean clear();
    }

    @Override // com.bytedance.platform.godzilla.launch.safe.api.CrashHandler
    public String getInfo() {
        return "SettingClearHandler";
    }

    public SettingClearHandler(SettingClear r2) {
        super("SettingClearHandler");
        this.mSettingClear = r2;
    }

    @Override // com.bytedance.platform.godzilla.launch.safe.api.CrashHandler
    public void handle(Context r2) {
        if (this.mSettingClear == null) goto L6;
        Logger.e("LaunchSafePlugin", getName() + "method is called.");
        this.mSettingClear.clear();
        return;
    }
}
