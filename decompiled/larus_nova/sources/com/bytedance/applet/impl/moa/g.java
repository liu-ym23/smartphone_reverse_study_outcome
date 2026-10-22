package com.bytedance.applet.impl.moa;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class g {
    public static final JSONObject b(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        return (JSONObject) r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final Object c(Object r100) {
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == false) goto L6;
        return null;
    L6:
        if ((r100 instanceof JSONObject) == false) goto L9;
        return d((JSONObject) r100);
    L9:
        if ((r100 instanceof JSONArray) == false) goto L18;
        JSONArray r101 = (JSONArray) r100;
        List r102 = CollectionsKt.createListBuilder(r101.length());
        int r103 = r101.length();
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L14;
        r102.add(c(r101.opt(r104)));
        r104 = r104 + 1;
        goto L11
    L14:
        return CollectionsKt.build(r102);
    L18:
        return r100;
    }

    public static final Map<String, Object> d(JSONObject r100) {
        Map r101 = MapsKt.createMapBuilder();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();
        Intrinsics.checkNotNull(r103);
        r101.put(r103, c(r100.opt(r103)));
        goto L4
    L7:
        return MapsKt.build(r101);
    }

    public static final String a(JSONObject r100, String r101) {
        Object r102 = r100.opt(r101);
        if ((r102 instanceof String) == false) goto L5;
        String r103 = (String) r102;
    L6:
        if (r103 == null) goto L16;
        String r104 = StringsKt.trim(r103).toString();
        if (r104 != null) goto L10;
        return null;
    L10:
        if (r104.length() <= 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L15;
        return null;
    L15:
        return r104;
    L12:
        r105 = false;
        goto L13
    L16:
        return null;
    L5:
        r103 = null;
        goto L6
    }
}
