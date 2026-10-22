package com.bytedance.reparo.c;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.reparo.core.b.j;
import com.bytedance.reparo.core.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppMonitorService.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "AppMonitorService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f9104a = -1;

    /* JADX INFO: renamed from: com.bytedance.reparo.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppMonitorService.java */
    public static class C0207a {

        /* JADX INFO: renamed from: com.bytedance.reparo.c.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AppMonitorService.java */
        static class C0208a {
            static int a(Throwable r3) {
                if (r3 != null) goto L6;
                return 12000;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, com.bytedance.reparo.core.b.c.class) == true) goto L8;
            L15:
                return 12000;
            L8:
                if (((com.bytedance.reparo.core.b.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.reparo.core.b.c.class, "com.obric.aiagent.plugin")).a() != 1) goto L12;
                return 12001;
            L12:
                if (ZeusTransformUtils.instanceOf(r3.getCause(), SocketTimeoutException.class) == false) goto L15;
                return 12006;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.reparo.c.a$a$b */
        /* JADX INFO: compiled from: AppMonitorService.java */
        static class b {
            public static int a(com.bytedance.reparo.core.b.d r2) {
                if (r2 != null) goto L6;
                return 12000;
            L6:
                if (ZeusTransformUtils.instanceOf(r2, com.bytedance.reparo.core.b.e.class) == true) goto L8;
            L11:
                return 12000;
            L8:
                if (r2.a() != 1) goto L11;
                return 12007;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.reparo.c.a$a$c */
        /* JADX INFO: compiled from: AppMonitorService.java */
        static class c {
            static int a(com.bytedance.reparo.core.b.d r2) {
                if (r2 != null) goto L6;
                return 22000;
            L6:
                if (ZeusTransformUtils.instanceOf(r2, com.bytedance.reparo.core.b.f.class) == true) goto L8;
            L19:
                return 22000;
            L8:
                if (ZeusTransformUtils.instanceOf(r2, com.bytedance.reparo.core.b.a.class) == false) goto L12;
                return 22008;
            L12:
                if (ZeusTransformUtils.instanceOf(r2, j.class) == false) goto L19;
                if (r2.a() != 300) goto L17;
                return 22009;
            L17:
                return 22010;
            }
        }
    }

    static {
    }

    private static com.bytedance.framwork.core.sdkmonitor.h b() {
        return g.c();
    }

    public static void a() {
        a(false, -1);
    }

    private static void a(boolean r1, int r2) {
        b(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        e.a(TAG, "report local patch list failed. ", th);
    }

    private static void b(boolean r8, int r9) {
        if (m.a().h() == false) goto L20;
        Iterator<com.bytedance.reparo.core.g.h> r0 = m.a().d().keySet().iterator();
        JSONArray r1 = new JSONArray();
    L6:
        if (r0.hasNext() == false) goto L8;
        com.bytedance.reparo.core.g.h r2 = (com.bytedance.reparo.core.g.h) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.reparo.core.g.h.class, "com.obric.aiagent.plugin");
        JSONObject r3 = new JSONObject();
        r3.putOpt("better_name", r2.n());
        r3.putOpt("version_code", r2.m());
        r1.put(r3);
        goto L6
    L8:
        JSONObject r4 = new JSONObject();
        long r5 = System.currentTimeMillis();
        r4.putOpt(DBHelper.COL_TIME, Long.valueOf(r5));
        r4.putOpt("betters", r1);
        if (r8 == false) goto L15;
        if (f9104a != (-1)) goto L13;
        f9104a = r5;
    L13:
        r4.putOpt("last_report_list_time", Long.valueOf(f9104a));
        f9104a = r5;
    L15:
        if (r9 == (-1)) goto L17;
        r4.putOpt("status", Integer.valueOf(r9));
    L17:
        b().a("bd_better_monitor", r4);
        return;
    }

    static void a(com.bytedance.reparo.core.a.a.a r3) {
        String r0 = r3.a();
        r0.hashCode();
        byte r2 = -1;
        switch(r0.hashCode()) {
            case -638342497: goto L14;
            case 1275480701: goto L10;
            case 1890919588: goto L6;
            default: goto L17;
        };
    L17:
        switch(r2) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            default: goto L25;
        };
    L19:
        c(r3);
        return;
    L20:
        d(r3);
        return;
    L21:
        b(r3);
        return;
    L25:
        return;
    L6:
        if (r0.equals("patch_install") == false) goto L17;
        r2 = 2;
        goto L17
    L10:
        if (r0.equals("patch_load") == false) goto L17;
        r2 = 1;
        goto L17
    L14:
        if (r0.equals("patch_download") == false) goto L17;
        r2 = 0;
        goto L17
    }

    private static void b(com.bytedance.reparo.core.a.a.a r6) {
        if (r6.k() == false) goto L5;
        a(true, 11000);
    L5:
        long r2 = System.currentTimeMillis();
        JSONObject r0 = new JSONObject();
        HashMap<String, Object> r4 = r6.m();     // Catch: JSONException -> L14
        r0.putOpt(DBHelper.COL_TIME, Long.valueOf(r2));     // Catch: JSONException -> L14
        r0.putOpt("better_name", r4.get("patch_id"));     // Catch: JSONException -> L14
        r0.putOpt("version_code", r4.get("patch_version"));     // Catch: JSONException -> L14
        if (r6.k() == false) goto L12;
        r0.putOpt("status", 11000);     // Catch: JSONException -> L14
        long r1 = r6.h();     // Catch: JSONException -> L14
        if (r1 == (-1)) goto L18;
        r0.putOpt("duration", Long.valueOf(r1));     // Catch: JSONException -> L14
    L18:
    L16:
        b().a("bd_better_monitor", r0);
        return;
    L12:
        r0.putOpt("status", Integer.valueOf(C0207a.C0208a.a(r6.c())));     // Catch: JSONException -> L14
        r0.putOpt("error_msg", r6.i());     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private static void c(com.bytedance.reparo.core.a.a.a r5) {
        if (r5.k() == false) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        JSONObject r2 = new JSONObject();
        HashMap<String, Object> r3 = r5.m();     // Catch: JSONException -> L8
        r5.j();     // Catch: JSONException -> L8
        r5.n();     // Catch: JSONException -> L8
        r2.putOpt(DBHelper.COL_TIME, Long.valueOf(r0));     // Catch: JSONException -> L8
        r2.putOpt("better_name", r3.get("patch_id"));     // Catch: JSONException -> L8
        r2.putOpt("version_code", r3.get("patch_version"));     // Catch: JSONException -> L8
        r2.putOpt("status", Integer.valueOf(C0207a.b.a(r5.c())));     // Catch: JSONException -> L8
        r2.putOpt("error_msg", r5.i());     // Catch: JSONException -> L8
    L10:
        b().a("bd_better_monitor", r2);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private static void d(com.bytedance.reparo.core.a.a.a r5) {
        JSONObject r0 = new JSONObject();
        HashMap<String, Object> r1 = r5.m();     // Catch: JSONException -> L12
        r0.putOpt(DBHelper.COL_TIME, Long.valueOf(System.currentTimeMillis()));     // Catch: JSONException -> L12
        r0.putOpt("better_name", r1.get("patch_id"));     // Catch: JSONException -> L12
        r0.putOpt("version_code", r1.get("patch_version"));     // Catch: JSONException -> L12
        if (r5.k() == true) goto L7;
        r0.putOpt("status", Integer.valueOf(C0207a.c.a(r5.c())));     // Catch: JSONException -> L12
        r0.putOpt("error_msg", r5.i());     // Catch: JSONException -> L12
    L16:
    L14:
        b().a("bd_better_monitor", r0);
        return;
    L7:
        r0.putOpt("status", 21000);     // Catch: JSONException -> L12
        long r2 = r5.h();     // Catch: JSONException -> L12
        if (r2 == (-1)) goto L16;
        r0.putOpt("duration", Long.valueOf(r2));     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
