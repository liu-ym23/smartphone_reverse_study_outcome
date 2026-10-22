package com.byted.cast.common.utils;

import com.byted.cast.common.Logger;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class GsonUtils {
    private static final Gson gson = null;
    private static Gson mExclusionStrategyGson;

    public GsonUtils() {
    }

    static {
        gson = new Gson();
    }

    public static boolean shouldCreateExclusionStrategyGson() {
        if (mExclusionStrategyGson != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void createExclusionStrategyGson(List<String> r100) {
        if (mExclusionStrategyGson != null) goto L6;
        CustomExclusionStrategy r101 = new CustomExclusionStrategy();
        r101.addAll(r100);
        mExclusionStrategyGson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy[]{r101}).create();
        return;
    }

    public static String toJsonExclusionIgnoreException(Object r100) {
        Gson r101 = mExclusionStrategyGson;     // Catch: Throwable -> L8
        if (r101 == null) goto L7;
        return r101.toJson(r100);
    L7:
        return gson.toJson(r100);
    L8:
        th = move-exception;
        Logger.e(th.getLocalizedMessage());
        return null;
    }

    public static String toJsonIgnoreException(Object r100) {
        return gson.toJson(r100);
    L4:
        th = move-exception;
        Logger.e(th.getLocalizedMessage());
        return null;
    }

    public static <T> T fromJsonIgnoreException(String r100, Class<T> r101) {
        return (T) gson.fromJson(r100, r101);
    L4:
        th = move-exception;
        Logger.e(th.getLocalizedMessage());
        return null;
    }

    public static <T> T fromJsonIgnoreException(String r100, Type r101) {
        return (T) gson.fromJson(r100, r101);
    L4:
        th = move-exception;
        Logger.e(th.getLocalizedMessage());
        return null;
    }
}
