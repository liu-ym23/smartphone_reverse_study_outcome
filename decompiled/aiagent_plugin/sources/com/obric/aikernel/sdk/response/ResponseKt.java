package com.obric.aikernel.sdk.response;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ResponseKt {
    public static final <T> Response<T> ok(Response<T> r3, q<? super Boolean, ? super T, ? super JSONObject, x> r4) {
        q r5 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        o.e(r5, "block");
        if (r3.getErrorCode() != 0) goto L5;
    L6:
        r5.invoke(Boolean.valueOf(r3.isFinish()), r3.getData(), r3.getExtra());
    L7:
        return r3;
    L5:
        if (r3.getErrorCode() != 1) goto L7;
        goto L6
    }

    public static final <T> Response<T> fail(Response<T> r3, q<? super Integer, ? super String, ? super JSONObject, x> r4) {
        q r5 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        o.e(r5, "block");
        if (r3.getErrorCode() != 0) goto L5;
    L10:
        return r3;
    L5:
        if (r3.getErrorCode() == 1) goto L10;
        Integer r0 = Integer.valueOf(r3.getErrorCode());
        String r1 = r3.getErrorInfo();
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r5.invoke(r0, r1, r3.getExtra());
        goto L10
    }
}
