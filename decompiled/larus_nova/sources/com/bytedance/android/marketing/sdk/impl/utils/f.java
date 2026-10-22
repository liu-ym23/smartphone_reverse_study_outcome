package com.bytedance.android.marketing.sdk.impl.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f162817a = null;

    static {
        f162817a = new Gson();
    }

    public static Map b(JSONObject r100) {
        if (r100 == null) goto L4;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();     // Catch: JSONException -> L13
        if (r103 == null) goto L12;
        String r104 = r103;     // Catch: JSONException -> L13
        r101.put(r104, r100.get(r104));     // Catch: JSONException -> L13
        goto L7
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: JSONException -> L13
    L14:
        return MapsKt.emptyMap();
    L15:
        return r101;
    L4:
        return MapsKt.emptyMap();
    }

    public static String d(Object r100) {
        if ((r100 instanceof String) == false) goto L7;
        return (String) r100;
    L7:
        if ((r100 instanceof JSONObject) == false) goto L11;
        return r100.toString();
    L11:
        if ((r100 instanceof Map) == false) goto L17;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        return new JSONObject((Map) r100).toString();
    L14:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L17:
        return GsonProtectorUtils.toJson(f162817a, r100);
    }

    public static Object a(String r100, Class r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(f162817a.fromJson(r100, r101));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L12;
        return null;
    L12:
        return r103;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void c(JSONObject r100, JSONObject r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$merge");
        if (r101 == null) goto L11;
        Iterator<String> r103 = r101.keys();
    L6:
        if (r103.hasNext() == false) goto L18;
        String r104 = r103.next();
        if (r100.has(r104) == false) goto L10;
        if (r102 == false) goto L6;
    L10:
        r100.put(r104, r101.get(r104));
        goto L6
    L18:
        return;
    }
}
