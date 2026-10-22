package com.bytedance.android.live;

import android.text.TextUtils;
import com.bytedance.android.live.gson.BooleanTypeAdapter;
import com.bytedance.android.live.gson.LynxPassthroughSaasAdapter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class GsonHelper {
    private static Map<Class<?>, Map<String, String>> fieldNameMapping;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final GsonBuilder f58513a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Gson f58514b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Gson f58515c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Gson f58516d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final JsonParser f58517e = null;

        static {
            GsonBuilder r100 = new GsonBuilder();
            FieldNamingPolicy r101 = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
            GsonBuilder r102 = r100.setFieldNamingPolicy(r101).registerTypeAdapter(Boolean.class, new BooleanTypeAdapter());
            Class r103 = Boolean.TYPE;
            GsonBuilder r104 = r102.registerTypeAdapter(r103, new BooleanTypeAdapter());
            f58513a = r104;
            int r105 = LynxPassthroughSaasAdapter.f69011a;
            GsonBuilder r106 = new GsonBuilder().setFieldNamingPolicy(r101).registerTypeAdapter(Boolean.class, new BooleanTypeAdapter()).registerTypeAdapter(r103, new BooleanTypeAdapter());
            Intrinsics.checkNotNullParameter(r106, "gsonBuilder");
            r106.setExclusionStrategies(new ExclusionStrategy[]{new com.bytedance.android.live.gson.a()}).registerTypeHierarchyAdapter(ja0.a.class, new LynxPassthroughSaasAdapter());
            f58514b = r106.create();
            f58515c = r104.create();
            f58516d = new Gson();
            f58517e = new JsonParser();
        }
    }

    public GsonHelper() {
    }

    static {
        fieldNameMapping = new HashMap();
        registerFieldNameMapping(Object.class, "user_infos", "open_user_infos");
        registerFieldNameMapping(Object.class, "anchor_info_map", "open_anchor_info_map");
        registerFieldNameMapping(Object.class, "anchor_effect_map", "open_anchor_effect_map");
        registerFieldNameMapping(Object.class, "mic_dress_info", "open_mic_dress_info");
        registerFieldNameMapping(Object.class, "user_id_to_score", "user_open_id_to_score");
        registerFieldNameMapping(Object.class, "user_armies_map", "open_user_armies_map");
        registerFieldNameMapping(Object.class, "grade_changes", "open_grade_changes");
    }

    public static GsonBuilder builder() {
        return a.f58513a;
    }

    public static Gson get() {
        return a.f58515c;
    }

    public static Gson getDefault() {
        return a.f58516d;
    }

    public static Gson getLynxWorkaround() {
        return a.f58514b;
    }

    public static JsonParser parser() {
        return a.f58517e;
    }

    private static String shadowOverrideFieldIdlName(String r100) {
        return "_" + r100;
    }

    public static <T> List<T> fromJsonArray(String r100, Class<T> r101) {
        ArrayList r102 = new ArrayList();
        if (TextUtils.isEmpty(r100) == true) goto L8;
        Iterator<JsonElement> r103 = GsonProtectorUtils.parse(parser(), r100).getAsJsonArray().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        JsonElement r104 = r103.next();
        r102.add(GsonProtectorUtils.fromJson(getDefault(), r104, r101));
    L8:
        return r102;
    }

    public static String mappingFieldName(Class<?> r100, String r101) {
        Map<String, String> r102 = fieldNameMapping.get(r100);
        if (r102 != null) goto L5;
        r102 = fieldNameMapping.get(Object.class);
    L5:
        if (r102 != null) goto L8;
        return r101;
    L8:
        if (r102.keySet().contains(r101) == false) goto L12;
        return r102.get(r101);
    L12:
        if (r102.values().contains(r101) == true) goto L14;
        return r101;
    L14:
        return shadowOverrideFieldIdlName(r101);
    }

    public static void registerTypeAdapter(Type r100, Object r101) {
        a.f58513a.registerTypeAdapter(r100, r101);
    }

    public static synchronized void registerFieldNameMapping(Class<?> r100, String r101, String r102) {
        monitor-enter(GsonHelper.class);
        Map<Class<?>, Map<String, String>> r103 = fieldNameMapping;     // Catch: Throwable -> L14
        if (r100 == null) goto L7;
        Class<?> r104 = r100;
    L8:
        Map<String, String> r105 = r103.get(r104);     // Catch: Throwable -> L14
        if (r105 != null) goto L11;
        r105 = new HashMap();     // Catch: Throwable -> L14
    L11:
        r105.put(r102, r101);     // Catch: Throwable -> L14
        fieldNameMapping.put(r100, r105);     // Catch: Throwable -> L14
        monitor-exit(GsonHelper.class);
        return;
    L7:
        r104 = Object.class;
    L14:
        th = move-exception;
        throw th;
    }
}
