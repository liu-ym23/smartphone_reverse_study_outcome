package com.bytedance.android.ec.hybrid.list.util;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonNull;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class k {
    public static final JSONObject b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toJSONObject");
        return tv5.a.a(ECHybridGsonUtil.a(), r100);
    L6:
        return new JSONObject();
    }

    public static final JSONObject c(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (com.bytedance.forest.utils.h.a(r100) == true) goto L5;
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return null;
    L5:
        return new JSONObject(r100);
    L8:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static final String d(Object r100) {
        return ECHybridGsonUtil.a().toJson(r100);
    L5:
        return GsonProtectorUtils.toJson(ECHybridGsonUtil.a(), JsonNull.INSTANCE);
    }

    public static final void a(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putJSONString");
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L20;
        JSONObject r103 = c(r101);
        if (r103 == null) goto L21;
        Iterator<String> r104 = r103.keys();
    L16:
        if (r104.hasNext() == false) goto L22;
        String r105 = r104.next();
        r100.put(r105, r103.opt(r105));
        goto L16
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r102 = false;
        goto L8
    }
}
