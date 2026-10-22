package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class u {
    public static final Map<String, String> b(JSONObject r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        if (r100 == null) goto L11;
        Iterator<String> r103 = r100.keys();     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
    L8:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();     // Catch: Throwable -> L14
        r101.put(r104, r100.optString(r104));     // Catch: Throwable -> L14
        goto L8
    L10:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L14
    L16:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L19;
        ECExceptionMonitor.e(r107);
    L19:
        return r101;
    L11:
        r105 = null;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public static final String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        JSONObject r103 = new JSONObject();
    L10:
        r103.put(r101, r102);
        return r103.toString();
    L4:
        if (com.bytedance.android.shopping.extensions.k.c(r100) == false) goto L6;
        r103 = new JSONObject(r100);     // Catch: Exception -> L8
    L12:
        goto L10
    L6:
        r103 = new JSONObject();     // Catch: Exception -> L8
        goto L12
    }
}
