package com.android.ttcjpaysdk.base.utils;

import android.view.View;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayExtentSizeUtils {
    public CJPayExtentSizeUtils() {
    }

    public static void expendTouchArea(final View r100, final int[] r101) {
        if (r100 == null) goto L12;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayExtentSizeUtils#run", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayExtentSizeUtils#run", e);
        e.printStackTrace();
        return;
    L4:
        if (r101.length != 4) goto L13;
        final View r102 = (View) r100.getParent();     // Catch: Exception -> L7
        r102.post(new AnonymousClass1(r100, r101, r102));     // Catch: Exception -> L7
        return;
    L13:
        return;
    }
}
