package com.bytedance.android.ec.core.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45720a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Gson f45721a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Gson f45722b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final JsonParser f45723c = null;

        static {
            f45721a = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter()).registerTypeAdapter(JSONObject.class, new JSONObjectAdapter()).registerTypeAdapter(JSONArray.class, new JSONArrayAdapter()).create();
            f45722b = new Gson();
            f45723c = new JsonParser();
        }
    }

    static {
    }
}
