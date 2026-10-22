package com.bytedance.android.livesdk.livecommerce.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: classes10.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153098a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Gson f153099a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Gson f153100b = null;

        static {
            f153099a = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            f153100b = new Gson();
            new JsonParser();
        }
    }

    static {
    }
}
