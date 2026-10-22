package com.bytedance.crash.o;

import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeTools.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static o f7670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap<String, String> f7671b;

    public o() {
    }

    public static o a() {
        if (f7670a != null) goto L15;
        monitor-enter(o.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7670a != null) goto L9;
        f7670a = new o();     // Catch: Throwable -> L11
    L9:
        monitor-exit(o.class);     // Catch: Throwable -> L11
    L15:
        return f7670a;
    }

    static {
        f7671b = new HashMap();
    }

    public String a(String r3) {
        String r2 = (String) ZeusTransformUtils.preCheckCast(f7671b.get(r3), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r2) == false) goto L6;
        String r4 = b(a().c(r3));
        f7671b.put(r3, r4);
        return r4;
    L6:
        return r2;
    }

    public static String b(String r4) {
        StringBuilder r0 = new StringBuilder();
        if (r4 == null) goto L5;
        if (r4.length() >= 16) goto L9;
        r0.append(r4);     // Catch: Throwable -> L14
    L15:
        goto L13
    L9:
        r0.append(r4.charAt(6));     // Catch: Throwable -> L14
        r0.append(r4.charAt(7));     // Catch: Throwable -> L14
        r0.append(r4.charAt(4));     // Catch: Throwable -> L14
        r0.append(r4.charAt(5));     // Catch: Throwable -> L14
        r0.append(r4.charAt(2));     // Catch: Throwable -> L14
        r0.append(r4.charAt(3));     // Catch: Throwable -> L14
        r0.append(r4.charAt(0));     // Catch: Throwable -> L14
        r0.append(r4.charAt(1));     // Catch: Throwable -> L14
        r0.append(r4.charAt(10));     // Catch: Throwable -> L14
        r0.append(r4.charAt(11));     // Catch: Throwable -> L14
        r0.append(r4.charAt(8));     // Catch: Throwable -> L14
        r0.append(r4.charAt(9));     // Catch: Throwable -> L14
        r0.append(r4.charAt(14));     // Catch: Throwable -> L14
        r0.append(r4.charAt(15));     // Catch: Throwable -> L14
        r0.append(r4.charAt(12));     // Catch: Throwable -> L14
        r0.append(r4.charAt(13));     // Catch: Throwable -> L14
        if (r4.length() < 32) goto L15;
        r0.append(r4, 16, 32);     // Catch: Throwable -> L14
        r0.append('0');     // Catch: Throwable -> L14
    L13:
        return r0.toString().toUpperCase();
    L5:
        return r0.toString();
    }

    private static String[] e(String r9) {
        String[] r10 = r9.split("\\s+");
        String[] r0 = {"", ""};
        if (r10.length < 4) goto L27;
        int r1 = r10.length;
        String r5 = null;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L14;
        String r7 = r10[r4];
        if (r7.startsWith("/") == false) goto L12;
        if (r7.endsWith(".so") == false) goto L12;
        r5 = r7;
    L12:
        r4 = r4 + 1;
        goto L6
    L14:
        if (TextUtils.isEmpty(r5) == false) goto L17;
        return null;
    L17:
        if (r5.endsWith(".so") == false) goto L27;
        if (r5.contains("/system/lib") == true) goto L27;
        int r11 = r5.lastIndexOf(47);
        if (r11 == (-1)) goto L27;
        int r12 = r11 + 1;
        String r2 = r5.substring(r12);
        if (r2.contains(".apk!") == false) goto L25;
        r2 = r2.substring(r2.indexOf(".apk!") + 5);
    L25:
        String r13 = r5.substring(0, r12) + r2;
        r0[0] = r2;
        r0[1] = r13;
        return r0;
    L27:
        return null;
    }

    public String c(String r1) {
        return NativeBridge.j(r1);
    L4:
        return null;
    }

    public JSONArray d(String r9) {
        JSONArray r8 = new JSONArray();
        HashSet r0 = new HashSet();
        String[] r10 = r9.split("\n");
        int r1 = r10.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L13;
        String[] r4 = e(r10[r3]);
        if (r4 == null) goto L12;
        String r5 = a().a(r4[1]);
        if (TextUtils.isEmpty(r5) == true) goto L12;
        if (r0.contains(r4[0]) == true) goto L12;
        r0.add(r4[0]);
        JSONObject r6 = new JSONObject();
        l.a(r6, "lib_name", r4[0]);
        l.a(r6, "lib_uuid", r5);
        r8.put(r6);
    L12:
        r3 = r3 + 1;
        goto L3
    L13:
        return r8;
    }
}
