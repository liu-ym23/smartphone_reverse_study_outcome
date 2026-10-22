package com.obric.appstore.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonUtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f11055a = null;

    static {
        f11055a = new Gson();
    }

    public static final void a(JSONArray r10, Function1 r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "action");
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        JSONObject r14 = r10.getJSONObject(r13);
        kotlin.jvm.internal.q.f(r14, "getJSONObject(...)");
        r11.invoke(r14);
        r13 = r13 + 1;
        goto L3
    }

    public static final Gson b() {
        return f11055a;
    }

    public static final List c(JSONArray r10, final Function1 r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "transform");
        final ArrayList r12 = new ArrayList();
        a(r10, new JsonUtilsKt$map$1(r12, r11));
        return r12;
    }

    public static final JSONObject d(JsonElement r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.isJsonObject() == true) goto L7;
        return null;
    L7:
        return new JSONObject(r10.toString());
    }
}
