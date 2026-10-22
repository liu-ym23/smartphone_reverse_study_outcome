package com.android.ttcjpaysdk.verify.utils;

import android.content.Context;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;

/* JADX INFO: loaded from: classes39.dex */
public class DyVerifyStringHelper {
    public DyVerifyStringHelper() {
    }

    public static String getStringSafely(Context r100, int r101, Object... r102) {
        return r100.getResources().getString(r101, r102);
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyStringHelper#getStringSafely", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyStringHelper#getStringSafely", e);
        return "";
    }
}
