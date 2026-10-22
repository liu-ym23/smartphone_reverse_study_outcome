package com.bytedance.android.gamecp.common.track.filter;

import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends a<zu.e> {
    public final String b() {
        Map<String, String> r100 = this.f56801a;
        if (r100 == null) goto L6;
        String r101 = r100.get("enter_method");
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final String c() {
        Object r100 = "";
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        Map<String, String> r102 = this.f56801a;     // Catch: Throwable -> L13
        if (r102 == null) goto L7;
        String r103 = r102.get("traffic_extra");     // Catch: Throwable -> L13
        if (r103 == null) goto L7;
    L8:
        String r104 = new JSONObject(r103).optString("is_other_channel");     // Catch: Throwable -> L13
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r105) == true) goto L20;
        r100 = r105;
    L20:
        return (String) r100;
    L7:
        r103 = "";
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public e() {
    }
}
