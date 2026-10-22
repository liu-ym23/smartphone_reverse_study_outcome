package com.android.ttcjpaysdk.base.utils;

import android.util.Log;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0003"}, d2 = {"asErrorMessage", "", "", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJBasicCommonUtilsKt {
    public static final /* synthetic */ String access$asErrorMessage(Throwable r100) {
        return asErrorMessage(r100);
    }

    private static final String asErrorMessage(Throwable r100) {
        if (r100 == null) goto L4;
        String r101 = Log.getStackTraceString(r100);
    L5:
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    L4:
        r101 = null;
        goto L5
    }
}
