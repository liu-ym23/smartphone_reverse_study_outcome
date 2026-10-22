package com.bytedance.android.shopping.anchorv3.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165314a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Gson f165315a = null;

        static {
            f165315a = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Boolean.TYPE, new BooleanTypeAdapter()).registerTypeAdapter(JSONObject.class, new JSONObjectAdapter()).registerTypeAdapter(JSONArray.class, new JSONArrayAdapter()).create();
        }
    }

    static {
    }
}
