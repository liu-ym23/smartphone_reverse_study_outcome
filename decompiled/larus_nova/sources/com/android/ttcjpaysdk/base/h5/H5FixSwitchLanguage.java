package com.android.ttcjpaysdk.base.h5;

import android.os.Build;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;

/* JADX INFO: loaded from: classes28.dex */
public class H5FixSwitchLanguage {
    private static boolean isDo;

    public H5FixSwitchLanguage() {
    }

    public static void doFix() {
        if ("en".equals(CJPayHostInfo.languageTypeStr) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 24) goto L9;
        return;
    L9:
        if (isDo == false) goto L19;
        return;
    L19:
    L16:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("H5FixSwitchLanguage#WebView", e);
        CJBasicCommonUtils.logCatch("CJCatch", "H5FixSwitchLanguage#WebView", e);
        return;
    L12:
        if (CJPayHostInfo.applicationContext == null) goto L14;
        new WebView(CJPayHostInfo.applicationContext).destroy();     // Catch: Exception -> L16
    L14:
        isDo = true;     // Catch: Exception -> L16
    }
}
