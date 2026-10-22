package com.bytedance.android.annie.param;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f39698a = 0;

    static {
    }

    public static void a(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (j.f39705b.b() == true) goto L6;
        r100.invoke();
        return;
    }

    public static Map b(Object r100) {
        if (r100 == null) goto L11;
        if ((r100 instanceof k) == false) goto L11;
        JsonElement r101 = new Gson().toJsonTree(r100);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Throwable -> L8
        return UtilsKt.i((JsonObject) r101);
    L9:
        return new LinkedHashMap();
    L11:
        return new LinkedHashMap();
    }
}
