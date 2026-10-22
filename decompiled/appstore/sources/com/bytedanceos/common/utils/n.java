package com.bytedanceos.common.utils;

import android.content.Context;
import com.bytedanceos.common.toolbox.ServerElements;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n implements ServerElements {
    public static AppStoreCommonError a(Context r10, Throwable r11, String r12) {
        AppStoreCommonError r13 = new AppStoreCommonError();
        if (r11 == null) goto L20;
        r13.setErrorCode(k.b(r11));
        r13.setErrorMsg(k.d(r10, r11));
    L18:
        return r13;
    L20:
        JSONObject r14 = new JSONObject(r12);     // Catch: Exception -> L8
        if (r14.isNull(ServerElements.ERRNO) == true) goto L11;
        int r15 = r14.optInt(ServerElements.ERRNO);     // Catch: Exception -> L8
        r13.setErrorCode(r15);     // Catch: Exception -> L8
        r13.setErrorMsg(k.c(r10, r15));     // Catch: Exception -> L8
    L19:
        goto L18
    L11:
        if (r14.isNull(ServerElements.HEAD) == true) goto L19;
        JSONObject r16 = r14.optJSONObject(ServerElements.HEAD);     // Catch: Exception -> L8
        int r17 = r16.optInt(ServerElements.CODE);     // Catch: Exception -> L8
        r13.setErrorCode(r17);     // Catch: Exception -> L8
        if (k.a(r17) == false) goto L15;
        r13.setErrorMsg(k.c(r10, r17));     // Catch: Exception -> L8
        goto L19
    L15:
        r13.setErrorMsg(r16.optString("message"));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }
}
