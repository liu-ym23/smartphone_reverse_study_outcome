package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.ss.android.http.legacy.client.HttpResponseException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class h {
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
        Intrinsics.checkNotNullParameter(r100, "$this$prompt");
        if ((r100 instanceof CustomApiServerException) == false) goto L10;
        CustomApiServerException r101 = (CustomApiServerException) r100;
        String r102 = r101.getPrompt();
        if (r102 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r102)) == true) goto L9;
        return null;
    L9:
        return r101.getPrompt();
    L10:
        return null;
    }
}
