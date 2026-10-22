package com.bytedance.android.annie.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GsonBuilder f40057a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f40058b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Gson f40059c = null;

    static {
        GsonBuilder r100 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Boolean.class, new BooleanTypeAdapter()).registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter());
        f40057a = r100;
        f40058b = r100.create();
        f40059c = new Gson();
        new JsonParser();
    }
}
