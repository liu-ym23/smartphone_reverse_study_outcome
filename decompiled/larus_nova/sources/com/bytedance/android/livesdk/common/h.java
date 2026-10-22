package com.bytedance.android.livesdk.common;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class h {
    public static boolean a() {
        if (LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE_SWITCHER.getValue().booleanValue() == false) goto L7;
        return true;
    }

    public static String b(i r100) {
        View r101 = r100.getContentView();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r100.nq() == true) goto L7;
        return null;
    L7:
        if (r101.getVisibility() != 8) goto L9;
        return null;
    L9:
        if (r101.getVisibility() == 4) goto L16;
        r101.setVisibility(8);
        r100.qo(Boolean.TRUE);
        ALogger.i("CleanScreenManager", r100.nc() + " GONE");
        return r100.nc();
    L16:
        return null;
    }

    public static String c(i r100) {
        View r101 = r100.getContentView();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r100.nq() == true) goto L7;
        return null;
    L7:
        if (r100.uk().booleanValue() == false) goto L13;
        r101.setVisibility(0);
        r100.qo(Boolean.FALSE);
        ALogger.i("CleanScreenManager", r100.nc() + " SHOW");
        return r100.nc();
    L13:
        return null;
    }
}
