package com.blankj.utilcode.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f2202a = new ConcurrentHashMap();

    public static Object a(String str, Class cls) {
        ConcurrentHashMap concurrentHashMap = f2202a;
        Gson gson = (Gson) concurrentHashMap.get("delegateGson");
        if (gson == null) {
            Gson gsonCreate = (Gson) concurrentHashMap.get("defaultGson");
            if (gsonCreate == null) {
                gsonCreate = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
                concurrentHashMap.put("defaultGson", gsonCreate);
            }
            gson = gsonCreate;
        }
        return gson.fromJson(str, cls);
    }
}
