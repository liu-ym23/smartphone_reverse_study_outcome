package com.bytedance.android.livesdk.uicomponent;

import com.bytedance.android.livehostapi.platform.IHostAction;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public class DouyinThemeManager {
    public DouyinThemeManager() {
    }

    public static boolean isDouyinLight() {
        return ((IHostAction) k.f(IHostAction.class)).isLightMode();
    L4:
        return false;
    }
}
