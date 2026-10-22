package com.bytedance.android.annie.api.data.subscribe;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f38409a = null;

    static {
        f38409a = new Gson();
    }

    public static JsonElement b(Object r100) {
        return GsonProtectorUtils.toJsonTree(f38409a, r100);
    }

    public static String c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "any");
        return GsonProtectorUtils.toJson(f38409a, r100);
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonStr");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return GsonProtectorUtils.fromJson(f38409a, r100, r101);
    }
}
