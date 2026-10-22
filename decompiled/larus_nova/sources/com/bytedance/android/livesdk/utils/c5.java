package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.ss.android.http.legacy.client.HttpResponseException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c5 {
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
}
