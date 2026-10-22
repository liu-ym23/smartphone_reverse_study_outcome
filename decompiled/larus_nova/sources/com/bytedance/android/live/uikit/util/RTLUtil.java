package com.bytedance.android.live.uikit.util;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public class RTLUtil {
    public static final String ARABIA_LANG = "ar";

    public RTLUtil() {
    }

    public static boolean isAppRTL(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getResources().getConfiguration().locale.getLanguage().equals(ARABIA_LANG) == false) goto L8;
    L9:
        return true;
    L8:
        if (r100.getResources().getConfiguration().getLayoutDirection() == 1) goto L9;
        return false;
    }
}
