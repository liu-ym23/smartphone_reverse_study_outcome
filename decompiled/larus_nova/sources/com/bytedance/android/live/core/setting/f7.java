package com.bytedance.android.live.core.setting;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f65299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f65300b;

    public static SharedPreferences a() {
        if (f65299a != null) goto L10;
        if (c7.getContext() != null) goto L8;
        d7.a("getLocalSettingExtrasSharedPreferences - context is null", new Exception("getLocalSettingExtrasSharedPreferences - context is null"));
        return null;
    L8:
        f65299a = c7.getContext().getSharedPreferences("ttlive_setting_extra", 0);
    L10:
        return f65299a;
    }

    @JvmStatic
    public static final Map<String, String> b() {
        HashMap r100 = new HashMap();
        SharedPreferences r101 = a();
        if (r101 == null) goto L9;
        String r102 = r101.getString("dolphin_extra", "");
        if (r102 == null) goto L9;
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r100.put("dolphin_extra", r102);
        e7.a("get setting dolphin extra: ".concat(r102));
    L9:
        r100.put("dolphin_incr", "1");
        return r100;
    }

    @JvmStatic
    public static final void c() {
        Intrinsics.checkNotNullParameter("v2", "version");
        f65300b = System.currentTimeMillis();
        e7.a("set setting sdk version: v2");
    }

    static {
    }

    @JvmStatic
    public static final void d(JsonObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.has("dolphin_extra") == false) goto L15;
        String r101 = r100.get("dolphin_extra").getAsString();
        SharedPreferences r102 = a();
        if (r102 == null) goto L12;
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L12;
        SharedPreferences.Editor r104 = r103.putString("dolphin_extra", r101);
        if (r104 == null) goto L12;
        r104.apply();
    L12:
        e7.a("update dolphin extra: " + r101);
        return;
    }
}
