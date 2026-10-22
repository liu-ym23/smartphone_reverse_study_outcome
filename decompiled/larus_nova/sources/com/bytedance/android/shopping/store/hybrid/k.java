package com.bytedance.android.shopping.store.hybrid;

import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f184875a = 0;

    public k() {
    }

    public static JSONObject a() {
        return b(0, "key 不能为空", null);
    }

    static {
    }

    public static JSONObject b(int r100, String r101, Map r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L9
        r104.put("code", r100);     // Catch: Throwable -> L9
        if (r101 == null) goto L5;
        r104.put("msg", r101);     // Catch: Throwable -> L9
    L5:
        if (r102 == null) goto L7;
        r104.put("data", new JSONObject(r102));     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == false) goto L15;
        r105 = null;
    L15:
        return (JSONObject) r105;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
