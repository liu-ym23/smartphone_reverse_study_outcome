package com.bytedance.android.ec.core.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f45730a;

    public static Gson c() {
        if (f45730a != null) goto L6;
        f45730a = new Gson();
    L6:
        return f45730a;
    }

    public static String d(Object r100) {
        return GsonProtectorUtils.toJson(c(), r100);
    }

    public static <T> T a(JsonObject r100, Class<T> r101) {
        return (T) c().fromJson(r100, r101);
    L4:
        return null;
    }

    public static <T> T b(String r100, Class<T> r101) {
        return (T) c().fromJson(r100, r101);
    L4:
        return null;
    }

    public static <T> List<T> e(String r100, Class<T[]> r101) {
        Object[] r102 = (Object[]) c().fromJson(r100, r101);     // Catch: Throwable -> L8
        if (r102 != null) goto L7;
        return new ArrayList();
    L7:
        return new ArrayList(Arrays.asList(r102));
    L9:
        return new ArrayList();
    }
}
