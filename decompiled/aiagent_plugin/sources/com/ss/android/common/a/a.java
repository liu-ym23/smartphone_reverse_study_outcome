package com.ss.android.common.a;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.ar;
import com.ss.android.common.applog.c;
import com.ss.android.common.applog.y;
import com.ss.android.common.applog.z;
import com.ss.android.common.util.e;
import com.ss.android.deviceregister.base.f;
import com.ss.android.deviceregister.base.v;
import com.ss.android.deviceregister.g;
import com.ss.android.deviceregister.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: compiled from: ActiveUser.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String TAG = "ActiveUser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f37096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f37097b;

    /* JADX INFO: renamed from: com.ss.android.common.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActiveUser.java */
    public static class C1014a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f37098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f37099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f37100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f37101d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String[] f37102e;
        private long f;

        public C1014a(Context r3, String[] r4, boolean r5, boolean r6, b r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
            this.f37101d = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
            this.f37102e = r4;
            this.f37098a = r5;
            this.f = System.currentTimeMillis();
            this.f37099b = r9;
            this.f37100c = r6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (a.b() > 0) goto L5;
            a.a(this.f);
        L5:
            boolean r0 = a.b(this.f37101d, this.f37102e, this.f37098a, this.f37100c);
            b r6 = this.f37099b;
            if (r6 == null) goto L8;
            r6.a(r0);
        L8:
            if (r0 == false) goto L13;
            System.currentTimeMillis();
            if (a.b() <= 0) goto L14;
            a.a(0);
            return;
        L14:
            return;
        }
    }

    /* JADX INFO: compiled from: ActiveUser.java */
    public interface b {
        void a(boolean r1);
    }

    static /* synthetic */ long a(long r0) {
        f37096a = r0;
        return r0;
    }

    static /* synthetic */ boolean a() {
        return f37097b;
    }

    static /* synthetic */ boolean a(boolean r0) {
        f37097b = r0;
        return r0;
    }

    static /* synthetic */ long b() {
        return f37096a;
    }

    static /* synthetic */ boolean b(Context r2, String[] r3, boolean r4, boolean r5) {
        return c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    }

    private static boolean c(Context r8, String[] r9, boolean r10, boolean r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        boolean r2 = g.f();     // Catch: Exception -> L51
        StringBuilder r3 = new StringBuilder();     // Catch: Exception -> L51
        if (r10 == true) goto L20;
        if (r2 == true) goto L20;
        Pair<String, Boolean> r13 = j.a(r12);     // Catch: Exception -> L37
        if (r13 == null) goto L20;
        if (r13.second != null) goto L12;
    L14:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L18;
        String r5 = "1";
    L19:
        a(r3, "gaid_limited", r5, true);     // Catch: Exception -> L37
        a(r3, "google_aid", (String) ZeusTransformUtils.preCheckCast(r13.first, String.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L37
        goto L20
    L18:
        r5 = "0";
        goto L19
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13.second, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L14;
        r4 = true;
    L37:
        e = move-exception;
        e.d("ActiveUser prepare app_alert param exception: " + e);     // Catch: Exception -> L51
    L39:
        LinkedHashMap r14 = new LinkedHashMap();     // Catch: Exception -> L51
        y.a(r14, true, ar.f6144a);     // Catch: Exception -> L51
        int r15 = r9.length;     // Catch: Exception -> L51
        int r1 = 0;
    L40:
        if (r1 >= r15) goto L53;
        StringBuilder r6 = new StringBuilder(r9[r1]);     // Catch: Exception -> L51
        r6.append(r3.toString());     // Catch: Exception -> L51
        y.a(r6, r14);     // Catch: Exception -> L51
        String r7 = a(r6.toString(), "req_id", g.n());     // Catch: Exception -> L51
        e.c("request : " + r7);     // Catch: Exception -> L51
        HashMap r16 = new HashMap();     // Catch: Exception -> L51
        com.ss.android.common.util.b.a(r16, r11);     // Catch: Exception -> L51
        String r17 = com.bytedance.common.utility.g.a().a(z.a(r7), r16, null);     // Catch: Throwable -> L49
        e.b("NetworkClient.getDefault().get response:" + r17);     // Catch: Throwable -> L49
        if (com.bytedance.common.utility.j.a(r17) == false) goto L45;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Throwable -> L49
    L50:
        r1 = r1 + 1;
        goto L40
    L45:
        if ("success".equals(new JSONObject(r17).optString("message")) == false) goto L50;
        return true;
    L49:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.L);     // Catch: Exception -> L51
    L53:
        return false;
    L20:
        float r18 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;     // Catch: Exception -> L37
        if (r18 >= (-12.0f)) goto L24;
        r18 = -12.0f;
    L24:
        if (r18 <= 12.0f) goto L26;
        r18 = 12.0f;
    L26:
        a(r3, "timezone", r18 + "", false);     // Catch: Exception -> L37
        com.bytedance.bdinstall.c.b r19 = g.g();     // Catch: Exception -> L37
        if (r19 == null) goto L29;
        a(r3, "app_trait", r19.a(r12), true);     // Catch: Exception -> L37
    L29:
        String r110 = v.a();     // Catch: Exception -> L37
        if (TextUtils.isEmpty(r110) == true) goto L32;
        a(r3, "package", r110, true);     // Catch: Exception -> L37
        a(r3, "real_package_name", r12.getPackageName(), true);     // Catch: Exception -> L37
    L32:
        a(r3, "carrier", com.ss.android.deviceregister.c.c.e(r12), true);     // Catch: Exception -> L37
        a(r3, "mcc_mnc", com.ss.android.deviceregister.c.c.d(r12), true);     // Catch: Exception -> L37
        a(r3, "sim_region", com.ss.android.deviceregister.c.c.f(r12), true);     // Catch: Exception -> L37
        a(r3, "custom_bt", String.valueOf(c()), true);     // Catch: Exception -> L37
        if (v.f() == false) goto L35;
        f.a(r12, r3);     // Catch: Exception -> L37
    L35:
        a(r3, "app_version_minor", com.ss.android.common.applog.a.D(), true);     // Catch: Exception -> L37
    L51:
        e = move-exception;
        e.d("ActiveUser NetworkClient.getDefault().get exception:" + e);
        goto L53
    }

    private static long c() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private static String a(String r1, String r2, String r3) {
    L7:
        th = move-exception;
        th.printStackTrace();
        return r1;
    L3:
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r1;
    L5:
        return Uri.parse(r1).buildUpon().appendQueryParameter(r2, r3).build().toString();
    }

    private static void a(StringBuilder r2, String r3, String r4, boolean r5) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return;
    L9:
        if (r2.toString().indexOf(63) >= 0) goto L11;
        r2.append("?");
    L12:
        StringBuilder r6 = r2.append(r3).append("=");
        if (r5 == false) goto L15;
        r4 = Uri.encode(r4);
    L15:
        r6.append(r4);
        return;
    L11:
        r2.append("&");
        goto L12
    }

    public static void a(Context r6, String[] r7, boolean r8, boolean r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (r9 == true) goto L5;
    L7:
        new C1014a(r1, r7, r8, !f37097b, new AnonymousClass1()).start();
        return;
    L5:
        if (f37097b == false) goto L7;
    }
}
