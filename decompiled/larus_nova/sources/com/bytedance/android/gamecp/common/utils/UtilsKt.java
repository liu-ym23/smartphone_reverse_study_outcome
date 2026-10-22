package com.bytedance.android.gamecp.common.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class UtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f57195a = null;

    static {
        f57195a = LazyKt.lazy(UtilsKt$JS_SAFE_ELEMENT_ADAPTER$2.INSTANCE);
    }

    public static final Object a(Object r100) {
        if ((r100 instanceof JSONObject) == false) goto L7;
        Object r101 = new ReadonlyJSONObjectMap((JSONObject) r100);
    L13:
        return r101;
    L7:
        if ((r100 instanceof JSONArray) == false) goto L10;
        r101 = new u0((JSONArray) r100);
        goto L13
    L10:
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == false) goto L14;
        return null;
    L14:
        return r100;
    }

    public static final Object b(JsonElement r100) {
        if ((r100 instanceof JsonNull) == false) goto L6;
        return null;
    L6:
        if ((r100 instanceof JsonObject) == false) goto L10;
        JsonObject r101 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r101, "$this$toMap");
        Object r102 = new GsonMap(r101);
    L29:
        return r102;
    L10:
        if ((r100 instanceof JsonArray) == false) goto L13;
        JsonArray r103 = (JsonArray) r100;
        Intrinsics.checkNotNullParameter(r103, "$this$toList");
        r102 = new GsonList(r103);
        goto L29
    L13:
        if ((r100 instanceof JsonPrimitive) == false) goto L27;
        JsonPrimitive r104 = (JsonPrimitive) r100;
        if (r104.isNumber() == false) goto L18;
        return r104.getAsNumber();
    L18:
        if (r104.isString() == false) goto L21;
        return r104.getAsString();
    L21:
        if (r104.isBoolean() == false) goto L25;
        return Boolean.valueOf(r104.getAsBoolean());
    L25:
        throw new IllegalStateException("Unknown JsonPrimitive type: " + JsonPrimitive.class.getCanonicalName());
    L27:
        throw new IllegalStateException("Unknown JsonElement type: " + r100.getClass().getCanonicalName());
    }

    public static final boolean c(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static final void d(JsonArray r100) {
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L36;
        JsonElement r103 = r100.get(r102);
        if (r103 == null) goto L33;
        if (r103.isJsonObject() == false) goto L11;
        e(r103.getAsJsonObject());
        goto L33
    L11:
        if (r103.isJsonArray() == false) goto L14;
        d(r103.getAsJsonArray());
        goto L33
    L14:
        if (r103.isJsonPrimitive() == false) goto L35;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        Object r105 = Result.m9449constructorimpl(Long.valueOf(r103.getAsLong()));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r105) == false) goto L22;
        r105 = null;
    L22:
        Long r106 = (Long) r105;
        if (r106 == null) goto L33;
        long r107 = r106.longValue();
        if (r107 < Integer.MAX_VALUE) goto L27;
    L30:
        boolean r108 = true;
    L31:
        if (r108 == false) goto L33;
        r100.set(r102, new JsonPrimitive(String.valueOf(r107)));
        goto L33
    L27:
        if (r107 <= Integer.MIN_VALUE) goto L30;
        r108 = false;
    L17:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L35:
        throw new RuntimeException("Unknown type of json: " + r103);
    L33:
        r102 = r102 + 1;
        goto L3
    }

    public static final void e(JsonObject r100) {
        Iterator r101 = SequencesKt.filter(CollectionsKt.asSequence(r100.entrySet()), UtilsKt$memberNumbersToString$1.INSTANCE).iterator();
    L4:
        if (r101.hasNext() == false) goto L24;
        Map.Entry r102 = (Map.Entry) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Long.valueOf(((JsonElement) r102.getValue()).getAsLong()));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        r104 = null;
    L13:
        Long r105 = (Long) r104;
        if (r105 == null) goto L4;
        long r106 = r105.longValue();
        if (r106 < Integer.MAX_VALUE) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L4;
        r102.setValue(new JsonPrimitive(String.valueOf(r106)));
        goto L4
    L18:
        if (r106 <= Integer.MIN_VALUE) goto L21;
        r107 = false;
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final void f(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$removeParent");
        Function1<ViewGroup, Unit> r101 = new UtilsKt$removeParent$1(r100);
        Intrinsics.checkNotNullParameter(r100, "$this$withParent");
        Intrinsics.checkNotNullParameter(r101, JSEventListener.ACTION_RESOLVE);
        ViewParent r102 = r100.getParent();
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102 instanceof ViewGroup) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L12;
        r101.invoke((ViewGroup) r102);
        return;
    }
}
