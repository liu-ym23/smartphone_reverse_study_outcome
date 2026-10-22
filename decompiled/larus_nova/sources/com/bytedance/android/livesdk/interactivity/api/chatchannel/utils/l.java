package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.base.exception.ApiServerException;

/* JADX INFO: loaded from: classes9.dex */
public final class l {
    public static final String a(Throwable r100) {
        if (r100 != null) goto L5;
        return "unknown";
    L5:
        if ((r100 instanceof ApiServerException) == false) goto L8;
        StringBuilder r101 = new StringBuilder("api error, code is ");
        ApiServerException r102 = (ApiServerException) r100;
        r101.append(r102.getErrorCode());
        r101.append(", prompts is ");
        r101.append(r102.getPrompt());
        return r101.toString();
    L8:
        return "message is " + r100.getMessage();
    }
}
