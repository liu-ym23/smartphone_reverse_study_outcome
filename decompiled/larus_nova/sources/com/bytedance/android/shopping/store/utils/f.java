package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.core.utils.z1;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class f {
    public static final String b(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJSONString");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100).toString());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final Map<String, Object> c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toMap");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(z1.k(new JSONObject(r100)));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (Map) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final void a(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePutAll");
        if (r101 != null) goto L14;
        return;
    L14:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Iterator<String> r103 = r101.keys();     // Catch: Throwable -> L11
    L7:
        if (r103.hasNext() == false) goto L9;
        String r104 = r103.next();     // Catch: Throwable -> L11
        r100.putOpt(r104, r101.opt(r104));     // Catch: Throwable -> L11
        goto L7
    L9:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
