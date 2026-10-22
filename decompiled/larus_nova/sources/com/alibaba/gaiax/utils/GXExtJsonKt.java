package com.alibaba.gaiax.utils;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0004\u001a \u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00060\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"sArrayPattern", "Ljava/util/regex/Pattern;", "firstOrNull", "", "Lorg/json/JSONArray;", "forEach", "", "action", "Lkotlin/Function1;", "safeParseToJson", "Lorg/json/JSONObject;", "", "GaiaX"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class GXExtJsonKt {
    private static Pattern sArrayPattern;

    public static final /* synthetic */ Pattern access$getSArrayPattern$p() {
        return sArrayPattern;
    }

    public static final /* synthetic */ void access$setSArrayPattern$p(Pattern r100) {
        sArrayPattern = r100;
    }

    public static final Object firstOrNull(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() > 0) goto L9;
        return null;
    L9:
        return r100.opt(0);
    L11:
        return null;
    }

    public static final JSONObject safeParseToJson(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new JSONObject(r100);
    L5:
        e = move-exception;
        e.getMessage();
        return new JSONObject();
    }

    public static final void forEach(JSONArray r100, Function1<Object, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(r100.opt(r103));
        r103 = r103 + 1;
        goto L3
    }
}
