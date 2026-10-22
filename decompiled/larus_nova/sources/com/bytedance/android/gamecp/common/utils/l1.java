package com.bytedance.android.gamecp.common.utils;

import com.bytedance.android.gamecp.base.network.exception.ApiException;
import com.bytedance.android.gamecp.base.network.exception.CustomApiServerException;
import com.bytedance.android.gamecp.base.network.exception.NetworkErrorException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l1 {
    public static final int a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$errorCode");
        if ((r100 instanceof CustomApiServerException) == false) goto L6;
        return ((CustomApiServerException) r100).getErrorCode();
    L6:
        if ((r100 instanceof HttpResponseException) == false) goto L9;
        return ((HttpResponseException) r100).getStatusCode();
    L9:
        if ((r100 instanceof ApiException) == false) goto L12;
        return ((ApiException) r100).getErrorCode();
    L12:
        if ((r100 instanceof NetworkErrorException) == true) goto L19;
        return -1;
    L19:
        return ((NetworkErrorException) r100).statusCode;
    }

    public static final String b(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$errorMsg");
        String r101 = r100.getMessage();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return r100.toString();
    L12:
        return r100.getMessage();
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final String c(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$prompt");
        if ((r100 instanceof CustomApiServerException) == true) goto L7;
        return null;
    L7:
        return ((CustomApiServerException) r100).getPrompt();
    }
}
