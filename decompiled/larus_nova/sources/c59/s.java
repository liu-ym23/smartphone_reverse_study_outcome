package c59;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f22521a = null;

    static {
        f22521a = LazyKt.lazy(new r());
    }

    public static String d(Object r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return ((Gson) f22521a.getValue()).toJson(r100);
    L7:
        e = move-exception;
        g49.d.c("DslGsonUtil", "toJson Exception: parse " + r100.getClass().getSimpleName() + " failed", e);
        return null;
    }

    public static Object a(String r100, TypeToken r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r100 != null) goto L14;
        return null;
    L14:
    L17:
        return ((Gson) f22521a.getValue()).fromJson(r100, r101.getType());
    L9:
        e = move-exception;
        g49.d.c("DslGsonUtil", "fromJson JsonSyntaxException: parse " + r101.getType() + " failed", e);
        return null;
    L7:
        e = move-exception;
        g49.d.c("DslGsonUtil", "fromJson Exception: parse " + r101.getType() + " failed", e);
        return null;
    }

    public static Object b(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r100 != null) goto L14;
        return null;
    L14:
    L17:
        return ((Gson) f22521a.getValue()).fromJson(r100, r101);
    L9:
        e = move-exception;
        g49.d.c("DslGsonUtil", "fromJson JsonSyntaxException: parse " + r101.getSimpleName() + " failed", e);
        return null;
    L7:
        e = move-exception;
        g49.d.c("DslGsonUtil", "fromJson Exception: parse " + r101.getSimpleName() + " failed", e);
        return null;
    }

    public static Object c(Object r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r100 != null) goto L14;
        return null;
    L14:
        Lazy r102 = f22521a;     // Catch: Exception -> L7 JsonSyntaxException -> L9
    L17:
        return ((Gson) r102.getValue()).fromJson(((Gson) r102.getValue()).toJsonTree(r100), r101);
    L9:
        e = move-exception;
        g49.d.c("DslGsonUtil", "parseToTargetClass JsonSyntaxException: parse " + r101.getSimpleName() + " failed", e);
        return null;
    L7:
        e = move-exception;
        g49.d.c("DslGsonUtil", "parseToTargetClass Exception: parse " + r101.getSimpleName() + " failed", e);
        return null;
    }
}
