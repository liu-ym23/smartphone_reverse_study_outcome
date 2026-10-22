package com.bytedance.vmsdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SettingsManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "VmSdkSettingsManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f11733c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f11734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f11735b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, Object> f11736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, Object> f11737e;
    private Context f;

    public a() {
        this.f11734a = null;
        this.f11735b = 0;
        this.f11736d = null;
        this.f11737e = new HashMap();
        this.f = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
    }

    public static a a() {
        if (f11733c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11733c != null) goto L9;
        f11733c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f11733c;
    }

    public boolean a(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return false;
    L5:
        Object r4 = null;
        r4 = this.f11737e.getOrDefault(r9, null);     // Catch: Throwable -> L13
        if (r4 != null) goto L16;
        r4 = new com.bytedance.dataplatform.c.a(r9, "".getClass(), "").a(true);     // Catch: Throwable -> L13
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        this.f11737e.put(r9, r4);     // Catch: Throwable -> L13
    L16:
        if (r4 != null) goto L18;
    L19:
        HashMap<String, Object> r8 = this.f11736d;
        if (r8 != null) goto L43;
        return false;
    L43:
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r8.get("vmsdk_common"), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        if (r10 == null) goto L36;
        Object r11 = r10.get(r9);     // Catch: Throwable -> L34
        b(TAG, "getSettingsFromCache success, key: " + r9 + " , value: " + r11);     // Catch: Throwable -> L34
        if (r11 == null) goto L36;
        if ("all".equalsIgnoreCase(r11.toString()) == false) goto L29;
    L32:
        boolean r12 = true;     // Catch: Throwable -> L34
    L33:
        r4 = r12;
        goto L36
    L29:
        if ("true".equalsIgnoreCase(r11.toString()) == true) goto L32;
        r12 = false;     // Catch: Throwable -> L34
    L36:
        if (r4 != null) goto L38;
    L42:
        return false;
    L38:
        if (r4.equals("") == true) goto L42;
        return "true".equalsIgnoreCase(r4.toString());
    L34:
        th = move-exception;
        a(TAG, "getSettingsFromCache error " + th.toString());
        goto L36
    L18:
        if (r4.equals("") == false) goto L36;
    L13:
        th = move-exception;
        a(TAG, "experiment may not be initialized,failed to get experimentValue: " + th);
        goto L16
    }

    public int b() {
        Integer r3 = 0;
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(new com.bytedance.dataplatform.c.a("VMSDK", r3.getClass(), r3).a(true), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L5
    L7:
        if (r4 != 0) goto L24;
        HashMap<String, Object> r7 = this.f11736d;
        if (r7 != null) goto L22;
        return 0;
    L22:
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(r7.get("vmsdk_common"), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r8 == null) goto L25;
        Object r9 = r8.get("VMSDK");     // Catch: Throwable -> L17
        b(TAG, "getSettingsFlag success, key: VMSDK , value: " + r9);     // Catch: Throwable -> L17
        if (r9 == null) goto L26;
        return ((Integer) ZeusTransformUtils.preCheckCast(r9, Integer.class, "com.obric.aiagent.plugin")).intValue();
    L26:
        return r4;
    L25:
        return r4;
    L17:
        th = move-exception;
        a(TAG, "getSettingsFlag error " + th.toString());
        return r4;
    L24:
        return r4;
    L5:
        th = move-exception;
        a(TAG, "experiment may not be initialized,failed to get experimentValue: " + th);
        r4 = 0;
        goto L7
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
