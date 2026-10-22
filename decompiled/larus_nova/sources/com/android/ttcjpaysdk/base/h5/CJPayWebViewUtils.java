package com.android.ttcjpaysdk.base.h5;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayWebViewUtils {
    private CJPayWebViewUtils() {
        Context r100 = CJPayHostInfo.applicationContext;
        if (r100 == null) goto L6;
        CookieSyncManager.createInstance(r100);
        return;
    }

    public static Map<String, String> getHeaderParams(Context r100, String r101) {
        return CJPayBasicUtils.getHeaderParams(r100, r101, true);
    }
}
