package com.bytedance.android.gamecp.host_api.util.gson;

import com.bytedance.android.annie.util.BooleanTypeAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: classes44.dex */
public class GsonHelper {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final GsonBuilder f57433a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Gson f57434b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Gson f57435c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final JsonParser f57436d = null;

        static {
            GsonBuilder r100 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Boolean.class, new BooleanTypeAdapter()).registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter());
            f57433a = r100;
            f57434b = r100.create();
            f57435c = new Gson();
            f57436d = new JsonParser();
        }
    }

    public GsonHelper() {
    }

    public static Gson get() {
        return a.f57434b;
    }
}
