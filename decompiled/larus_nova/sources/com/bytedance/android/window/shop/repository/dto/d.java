package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Type, JsonDeserializer<?>> f189421a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f189422b = null;

    static {
        Map<Type, JsonDeserializer<?>> r100 = MapsKt.mapOf(new Pair[]{TuplesKt.to(n0.class, new GsonDeserializer.WrapperJsonDeserializer()), TuplesKt.to(q0.class, new GsonDeserializer.WrapperJsonDeserializer()), TuplesKt.to(o0.class, new GsonDeserializer.WrapperJsonDeserializer())});
        f189421a = r100;
        GsonBuilder r101 = new GsonBuilder();
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.registerTypeAdapter((Type) r103.getKey(), (JsonDeserializer) r103.getValue());
        goto L4
    L6:
        f189422b = r101.create();
    }

    public static final <T> T a(JsonElement r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "classOfT");
        return (T) GsonProtectorUtils.fromJson(f189422b, r100, r101);
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }
}
