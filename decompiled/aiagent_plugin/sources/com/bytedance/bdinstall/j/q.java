package com.bytedance.bdinstall.j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.al;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ay;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SensitiveUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final r<String> f6330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final r<String[]> f6331b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final r<JSONArray> f6332c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final r<String> f6333d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final r<String> f6334e = null;
    private static final r<JSONArray> f = null;
    private static final r<String> g = null;

    static /* synthetic */ String j(Context r2, an r3) {
        return k((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    private static String k(Context r2, an r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r3 == null) goto L9;
        if (r3.V() == true) goto L9;
    L12:
        return ay.a(String.valueOf(r3.a())).b(r4, r3);
    L9:
        if (h.a(r4) == true) goto L12;
        return null;
    }

    static {
        f6330a = new AnonymousClass1();
        f6331b = new AnonymousClass2();
        f6332c = new AnonymousClass3();
        f6333d = new AnonymousClass4();
        f6334e = new AnonymousClass5();
        f = new AnonymousClass6();
        g = new AnonymousClass7();
    }

    public static String a(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (String) ZeusTransformUtils.preCheckCast(f6330a.c(new Object[]{r6, r5}), String.class, "com.obric.aiagent.plugin");
    }

    public static String[] b(Context r2, an r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L20;
        if (p.E() == true) goto L20;
        if (r3 == null) goto L10;
        if (r3.V() == true) goto L10;
    L12:
        al r1 = ay.a(String.valueOf(r3.a()));
        if (r1 == null) goto L18;
        String[] r5 = r1.d(r4, r3);
        if (r5 == null) goto L18;
        return r5;
    L18:
        return new String[0];
    L10:
        if (h.a(r4) == true) goto L12;
    L20:
        return new String[0];
    }

    public static String[] c(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (String[]) ZeusTransformUtils.preCheckCast(f6331b.c(new Object[]{r6, r5}), String[].class, "com.obric.aiagent.plugin");
    }

    public static JSONArray d(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (JSONArray) ZeusTransformUtils.preCheckCast(f6332c.c(new Object[]{r6, r5}), JSONArray.class, "com.obric.aiagent.plugin");
    }

    public static JSONArray e(Context r10, an r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        JSONArray r4 = new JSONArray();
        if (r11 == null) goto L7;
        if (r11.V() == true) goto L7;
    L78:
    L66:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, SecurityException.class) == false) goto L70;
        com.bytedance.bdinstall.t.c("读取imei没有权限");
    L71:
        return r4;
    L70:
        th.printStackTrace();
        goto L71
    L11:
        String r9 = null;
        if (Build.VERSION.SDK_INT >= 26) goto L72;
        al r13 = ay.a(String.valueOf(r11.a()));     // Catch: Throwable -> L66
        if (r13 != null) goto L59;
        String r0 = null;
    L60:
        r4.put(a(r0, 0, SensitiveType.UNKNOWN));     // Catch: Throwable -> L66
        if (r13 == null) goto L64;
        r9 = r13.a(r12, 1);     // Catch: Throwable -> L66
    L64:
        r4.put(a(r9, 1, SensitiveType.UNKNOWN));     // Catch: Throwable -> L66
        goto L71
    L59:
        r0 = r13.a(r12, 0);     // Catch: Throwable -> L66
        goto L60
    L72:
        al r1 = ay.a(String.valueOf(r11.a()));     // Catch: Exception -> L19 Throwable -> L66
        if (r1 == null) goto L16;
        String r2 = r1.a(r12, 0, r11);     // Catch: Exception -> L19 Throwable -> L66
    L17:
        r4.put(a(r2, 0, SensitiveType.MEID));     // Catch: Exception -> L19 Throwable -> L66
    L74:
        al r3 = ay.a(String.valueOf(r11.a()));     // Catch: Exception -> L30 Throwable -> L66
        if (r3 == null) goto L27;
        String r5 = r3.a(r12, 1, r11);     // Catch: Exception -> L30 Throwable -> L66
    L28:
        r4.put(a(r5, 1, SensitiveType.MEID));     // Catch: Exception -> L30 Throwable -> L66
    L76:
        al r6 = ay.a(String.valueOf(r11.a()));     // Catch: Exception -> L41 Throwable -> L66
        if (r6 == null) goto L38;
        String r7 = r6.b(r12, 0, r11);     // Catch: Exception -> L41 Throwable -> L66
    L39:
        r4.put(a(r7, 0, SensitiveType.IMEI));     // Catch: Exception -> L41 Throwable -> L66
    L79:
        al r8 = ay.a(String.valueOf(r11.a()));     // Catch: Exception -> L51 Throwable -> L66
        if (r8 == null) goto L49;
        r9 = r8.b(r12, 1, r11);     // Catch: Exception -> L51 Throwable -> L66
    L49:
        r4.put(a(r9, 1, SensitiveType.IMEI));     // Catch: Exception -> L51 Throwable -> L66
    L51:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SecurityException.class) == false) goto L55;
        com.bytedance.bdinstall.t.c("读取imei没有权限");     // Catch: Throwable -> L66
        goto L71
    L55:
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L71
    L38:
        r7 = null;
    L41:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SecurityException.class) == false) goto L45;
        com.bytedance.bdinstall.t.c("读取imei没有权限");     // Catch: Throwable -> L66
        goto L79
    L45:
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L79
    L27:
        r5 = null;
    L30:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SecurityException.class) == false) goto L34;
        com.bytedance.bdinstall.t.c("读取imei没有权限");     // Catch: Throwable -> L66
        goto L76
    L34:
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L76
    L16:
        r2 = null;
    L19:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SecurityException.class) == false) goto L23;
        com.bytedance.bdinstall.t.c("读取imei没有权限");     // Catch: Throwable -> L66
        goto L74
    L23:
        e.printStackTrace();     // Catch: Throwable -> L66
    L7:
        if (h.a(r12) == true) goto L78;
        return new JSONArray();
    }

    private static JSONObject a(String r2, int r3, String r4) {
        JSONObject r0 = new JSONObject();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r0.put(DbHelper.COL_ID, r2);
        r0.put("slot_index", r3);
        r0.put("type", r4);
    L5:
        return r0;
    }

    public static String f(Context r3, an r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L16;
        if (r5.getApplicationInfo().targetSdkVersion < 26) goto L16;
        if (r4 == null) goto L13;
        if (r4.V() == false) goto L16;
    L13:
        if (h.a(r5) == true) goto L16;
        return null;
    L16:
        return ay.a(String.valueOf(r4.a())).c(r5, r4);
    }

    public static String g(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5.X() == true) goto L5;
        return null;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(f6333d.c(new Object[]{r6, r5}), String.class, "com.obric.aiagent.plugin");
    }

    public static String h(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (String) ZeusTransformUtils.preCheckCast(f6334e.c(new Object[]{r6, String.valueOf(r5.a()), r5}), String.class, "com.obric.aiagent.plugin");
    }

    public static JSONArray i(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        return (JSONArray) ZeusTransformUtils.preCheckCast(f.c(new Object[]{r6, String.valueOf(r5.a()), r5}), JSONArray.class, "com.obric.aiagent.plugin");
    }

    public static String a(an r0) {
        return r0.aa().h();
    }

    public static String b(an r0) {
        return r0.aa().g();
    }

    public static String c(an r0) {
        return r0.aa().i();
    }

    public static String d(an r0) {
        return r0.aa().j();
    }

    public static String e(an r3) {
        return (String) ZeusTransformUtils.preCheckCast(g.c(new Object[]{r3}), String.class, "com.obric.aiagent.plugin");
    }
}
