package com.obric.autogui.common.api.app;

import android.view.WindowManager;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.system.IAutoActionSystemApi;
import d.h.b.o;

/* JADX INFO: compiled from: AOWindowingTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOWindowingTools {
    public static final AOWindowingTools INSTANCE = null;
    private static final String TAG = "AOWindowingTools";

    static {
        INSTANCE = new AOWindowingTools();
    }

    private AOWindowingTools() {
    }

    public final void setTrustedOverlay(WindowManager.LayoutParams r2) {
        o.e(r2, AutoTestConstant.PARAM);
        IAutoActionSystemApi r1 = AOPlatformTools.INSTANCE.system();
        if (r1.isSupported() == true) goto L6;
        Loog.INSTANCE.e(TAG, "`setTrustedOverlay` not supported on this Platform.");
        return;
    L6:
        r1.setTrustedOverlay(r2);
    }
}
