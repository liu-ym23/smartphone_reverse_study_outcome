package com.bytedance.crash.dumper;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BytestConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f7407a;
    private static volatile boolean j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f7408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f7409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f7411e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final String i;

    private static c c() {
        if (f7407a != null) goto L6;
        f7407a = new c();
    L6:
        return f7407a;
    }

    c() {
        JSONObject r0 = d();
        this.f7408b = r0;
        if (r0.length() == 0) goto L5;
        this.f7411e = true;
        this.f7409c = r0.optJSONObject("slardar_filter");
    L6:
        JSONObject r1 = this.f7409c;
        if (r1 == null) goto L9;
        this.g = "true".equals(r1.optString("gwp_asan_switch"));
        this.f = "true".equals(this.f7409c.optString("core_dump_switch"));
        this.h = "true".equals(this.f7409c.optString("is_all_exception_collected"));
        com.bytedance.crash.config.h.a(true);
    L10:
        String r2 = r0.optString("bytrace_id_prefix");
        if (TextUtils.isEmpty(r2) == false) goto L13;
        r2 = UUID.randomUUID() + "-" + Process.myPid();
    L13:
        this.i = r2;
        return;
    L9:
        this.g = false;
        this.f = false;
        this.h = false;
        goto L10
    L5:
        this.f7411e = false;
        this.f7409c = null;
        goto L6
    }

    public static String a() {
        return c().i;
    }

    private JSONObject d() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r0 == null) goto L10;
        ContentResolver r1 = r0.getContentResolver();     // Catch: Throwable -> L11
        if (Build.VERSION.SDK_INT < 17) goto L10;
        this.f7410d = Settings.Global.getString(r1, "bytest_automation_info");     // Catch: Throwable -> L11
        return new JSONObject(this.f7410d);
    L10:
        return new JSONObject();
    }

    public static void a(File r2) {
        if (j == false) goto L5;
        return;
    L5:
        j = true;
        String r0 = c().f7410d;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        return;
    L9:
        com.bytedance.crash.o.j.a(r2, r0, false);     // Catch: Throwable -> L11
        return;
    }

    public static boolean b() {
        return c().h;
    }

    public static void a(JSONObject r2) {
        JSONObject r0 = c().f7409c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() == 0) goto L9;
        com.bytedance.crash.o.l.b(r2, r0);
        return;
    }

    public static void a(JSONObject r4, JSONObject r5) {
        if (r4 != null) goto L17;
        return;
    L17:
        Iterator<String> r0 = r4.keys();     // Catch: Exception -> L16
    L6:
        if (r0.hasNext() == false) goto L27;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16
        if ("slardar_filter".equals(r1) == true) goto L6;
        Object r2 = r4.opt(r1);     // Catch: Exception -> L16
        if (r2 == null) goto L6;
        r5.put(r1, r2);     // Catch: JSONException -> L15 Exception -> L16
    L27:
        return;
    }

    public static JSONObject a(File r5, JSONObject r6) {
        if (r5.isFile() == false) goto L22;
        if (r5.exists() == false) goto L22;
        JSONObject r2 = new JSONObject(com.bytedance.crash.o.j.d(r5));     // Catch: Exception -> L23
        JSONObject r7 = r2.optJSONObject("slardar_filter");     // Catch: Exception -> L23
        JSONObject r3 = r6.optJSONObject("filters");     // Catch: Exception -> L23
        if (r3 != null) goto L12;
        r3 = new JSONObject();     // Catch: Exception -> L23
        r6.put("filters", r3);     // Catch: Exception -> L23
    L12:
        if (r7 != null) goto L14;
    L20:
        r3.put("coredump_bytest", false);     // Catch: Exception -> L23
    L21:
        return r2;
    L14:
        if (r7.length() == 0) goto L20;
        if ("true".equals(r7.optString("core_dump_switch")) == false) goto L19;
        r3.put("coredump_bytest", true);     // Catch: Exception -> L23
    L19:
        com.bytedance.crash.o.l.b(r3, r7);     // Catch: Exception -> L23
    L22:
        return null;
    }
}
