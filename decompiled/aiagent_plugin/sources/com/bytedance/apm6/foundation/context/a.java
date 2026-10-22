package com.bytedance.apm6.foundation.context;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.g.e;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApmContext.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm6.util.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f5335a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f5336b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f5337c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f5338d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f5339e = -1;
    private static String f = null;
    private static int g = -1;
    private static String h = null;
    private static String i = null;
    private static long j = -1;
    private static long k = 0;
    private static int l = -1;
    private static JSONObject m = null;
    private static Map<String, String> n = null;
    private static long o = -1;
    private static e p;

    static {
    }

    public a() {
    }

    public static void a(b r2) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        f5335a = r3;
        com.bytedance.apm6.util.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        throw new IllegalArgumentException("apmAdapter cannot be null!");
    }

    public static void a(e r2) {
        p = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
    }

    public static e a() {
        return p;
    }

    public static b b() {
        return f5335a;
    }

    public static void a(long r0) {
        k = r0;
    }

    public static void b(long r0) {
        j = r0;
    }

    public static long c() {
        if (j >= 0) goto L6;
        j = System.currentTimeMillis();
    L6:
        return j;
    }

    public static long d() {
        if (k > 0) goto L6;
        k = System.currentTimeMillis();
    L6:
        return k;
    }

    public static boolean e() {
        if (f5337c != null) goto L24;
        monitor-enter(a.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (f5337c != null) goto L18;
        String r1 = f();     // Catch: Throwable -> L20
        boolean r2 = false;
        if (r1 != null) goto L11;
    L13:
        if (r1 != null) goto L15;
    L17:
        f5337c = Boolean.valueOf(r2);     // Catch: Throwable -> L20
        goto L18
    L15:
        if (r1.equals(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName()) == false) goto L17;
        r2 = true;
        goto L17
    L11:
        if (r1.contains(":") == false) goto L13;
        f5337c = false;     // Catch: Throwable -> L20
    L18:
        monitor-exit(a.class);     // Catch: Throwable -> L20
    L24:
        return f5337c.booleanValue();
    }

    public static String f() {
        if (f5336b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5336b != null) goto L9;
        f5336b = f5335a.f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5336b;
    }

    public static int g() {
        return f5335a.b();
    }

    public static String h() {
        if (f5338d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5338d != null) goto L9;
        f5338d = f5335a.g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5338d;
    }

    public static int i() {
        if (f5339e != (-1)) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5339e != (-1)) goto L9;
        f5339e = f5335a.h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5339e;
    }

    public static String j() {
        if (TextUtils.isEmpty(f) == false) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f) == false) goto L9;
        f = f5335a.i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public static int k() {
        if (g != (-1)) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != (-1)) goto L9;
        g = f5335a.j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public static String l() {
        if (TextUtils.isEmpty(h) == false) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(h) == false) goto L9;
        h = f5335a.k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return h;
    }

    public static String m() {
        if (TextUtils.isEmpty(i) == false) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(i) == false) goto L9;
        i = f5335a.l();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return i;
    }

    public static String n() {
        if (l != (-1)) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (l != (-1)) goto L9;
        l = f5335a.m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return String.valueOf(l);
    }

    public static JSONObject o() {
        if (m != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (m != null) goto L9;
        m = f5335a.p();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return m;
    }

    public static String p() {
        return f5335a.c();
    }

    public static String q() {
        return f5335a.e();
    }

    public static long r() {
        return f5335a.d();
    }

    public static void c(long r0) {
        o = r0;
    }

    public static long s() {
        return o;
    }

    public static Map<String, String> t() {
        if (n != null) goto L5;
        HashMap r0 = new HashMap();
        n = r0;
        r0.put(WsConstants.KEY_APP_ID, String.valueOf(g()));
        n.put(RomInfo.KEY_OS_TYPE, "Android");
        n.put("device_platform", "android");
        n.put(RomInfo.KEY_ROM_OS_API, Build.VERSION.SDK_INT + "");
        n.put("update_version_code", String.valueOf(i()));
        n.put("version_code", l());
        n.put("channel", h());
        n.put(HardwareInfo.KEY_HW_VENDOR_MODEL, Build.MODEL);
        n.put(HardwareInfo.KEY_HW_VENDOR_BRAND, Build.BRAND);
    L5:
        n.put("device_id", p());
        if (u() == false) goto L20;
        n.put("_log_level", "debug");
    L20:
        Map<String, String> r1 = b().r();     // Catch: Throwable -> L19
        if (r1 == null) goto L18;
        if (r1.size() <= 0) goto L18;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();     // Catch: Throwable -> L19
    L14:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        n.put((String) r3.getKey(), (String) r3.getValue());     // Catch: Throwable -> L19
    L18:
        return n;
    }

    public static c a(String r3, Map<String, String> r4, byte[] r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        return ((IHttpService) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(IHttpService.class), IHttpService.class, "com.obric.aiagent.plugin")).doPost(r3, r5, r6);
    }
}
