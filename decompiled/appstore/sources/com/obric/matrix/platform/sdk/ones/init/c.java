package com.obric.matrix.platform.sdk.ones.init;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11924a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList f11925b = null;

    static {
        f11924a = new c();
        f11925b = new CopyOnWriteArrayList();
    }

    public c() {
    }

    public final List a() {
        return f11925b;
    }

    public final void b(String r10) {
        if (r10 != null) goto L5;
    L18:
        f11925b.clear();
        return;
    L5:
        if (r10.length() == 0) goto L18;
        JSONObject r11 = new JSONObject(r10);     // Catch: Exception -> L12
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L12
        if (r11.has("crash_portrait") == false) goto L14;
        JSONArray r13 = r11.getJSONArray("crash_portrait");     // Catch: Exception -> L12
        int r14 = r13.length();     // Catch: Exception -> L12
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L14;
        JSONObject r16 = r13.getJSONObject(r15);     // Catch: Exception -> L12
        u5.c r17 = new u5.c();     // Catch: Exception -> L12
        r17.f24870a = r16.optString("process_name");     // Catch: Exception -> L12
        r17.f24871b = r16.optString("clazz_name");     // Catch: Exception -> L12
        r17.f24872c = r16.optString("method_name");     // Catch: Exception -> L12
        r17.f24873d = r16.optString("thread_name");     // Catch: Exception -> L12
        r17.f24874e = r16.optString("app_version");     // Catch: Exception -> L12
        r17.f24875f = r16.optInt("update_version");     // Catch: Exception -> L12
        r17.f24876g = r16.optString("detail_message");     // Catch: Exception -> L12
        r17.f24877h = r16.optString("throwable_class_name");     // Catch: Exception -> L12
        r17.f24878i = r16.optInt("osVersion");     // Catch: Exception -> L12
        r12.add(r17);     // Catch: Exception -> L12
        r15 = r15 + 1;     // Catch: Exception -> L12
    L14:
        CopyOnWriteArrayList r18 = f11925b;     // Catch: Exception -> L12
        r18.clear();     // Catch: Exception -> L12
        r18.addAll(r12);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.e("CrashProvider", "Failed to refresh crash portrait json " + r10, e);
        f11925b.clear();
    }
}
