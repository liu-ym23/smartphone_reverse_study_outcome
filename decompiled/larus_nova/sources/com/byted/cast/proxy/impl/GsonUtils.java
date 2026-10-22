package com.byted.cast.proxy.impl;

import com.google.gson.Gson;

/* JADX INFO: loaded from: classes39.dex */
public class GsonUtils {
    private static final Gson gson = null;

    public GsonUtils() {
    }

    static {
        gson = new Gson();
    }

    public static String toJsonIgnoreException(Object r100) {
        return gson.toJson(r100);
    L4:
        return null;
    }

    public static <T> T fromJsonIgnoreException(String r100, Class<T> r101) {
        return (T) gson.fromJson(r100, r101);
    L4:
        return null;
    }
}
