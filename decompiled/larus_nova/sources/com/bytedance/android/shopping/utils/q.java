package com.bytedance.android.shopping.utils;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class q {
    public static final HashMap<String, Object> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$asMap");
        HashMap<String, Object> r101 = new HashMap();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(com.bytedance.commerce.base.json.b.a(r100));     // Catch: Throwable -> L5
    L7:
        JSONObject r104 = new JSONObject();
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = r104;
    L10:
        JSONObject r105 = (JSONObject) r103;
        Iterator<String> r106 = r105.keys();
    L12:
        if (r106.hasNext() == false) goto L19;
        String r107 = r106.next();
        Object r108 = r105.get(r107);
        if ((r108 instanceof JSONArray) == true) goto L12;
        if ((r108 instanceof JSONObject) == true) goto L12;
        r101.put(r107, r108);
        goto L12
    L19:
        return r101;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
