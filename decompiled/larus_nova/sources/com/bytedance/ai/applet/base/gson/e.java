package com.bytedance.ai.applet.base.gson;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f34515a = null;

    static {
        f34515a = LazyKt.lazy(new d());
    }

    public static String c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return GsonProtectorUtils.toJson(c.a(), r100);
    }

    public static JsonObject d(Object r100) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(r100, "value");
        return GsonProtectorUtils.toJsonTree(c.a(), r100).getAsJsonObject();
    }

    public static Object a(String r100, Class r101) throws JsonSyntaxException {
        return GsonProtectorUtils.fromJson(c.a(), r100, r101);
    }

    public static Object b(String r100, Type r101) throws JsonSyntaxException {
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        return GsonProtectorUtils.fromJson(c.a(), r100, r101);
    }
}
