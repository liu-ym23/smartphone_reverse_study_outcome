package com.obric.olog;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.UserManager;
import android.util.Log;
import com.bytedanceos.common.toolbox.ServerElements;
import fa.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class OLog extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f12199a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f12200b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f12201c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile int f12202d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f12203e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f12204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f12205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Context f12206h;

    static {
    }

    public OLog() {
    }

    public static void a(int r10, String r11, String r12) {
        if (r10 > 2) goto L6;
        fa.a.u(r11, r12);
    L15:
        b();
        return;
    L6:
        if (r10 != 3) goto L9;
        fa.a.h(r11, r12);
        goto L15
    L9:
        if (r10 != 4) goto L12;
        fa.a.m(r11, r12);
        goto L15
    L12:
        if (r10 != 5) goto L14;
        fa.a.v(r11, r12);
        goto L15
    L14:
        fa.a.i(r11, r12);
        goto L15
    }

    public static void b() {
        f12205g++;
        Log.d("obric_log_statistic", "Alogout dada: " + (System.currentTimeMillis() - f12204f));
        if ((System.currentTimeMillis() - f12204f) < 60000) goto L6;
        Log.d("obric_log_statistic", "Alogout in a minutes: " + f12205g);
        l(f12205g);
        f12204f = System.currentTimeMillis();
        f12205g = 0;
        return;
    }

    public static boolean c(int r10) {
        if (r10 < f12202d) goto L5;
        return true;
    L5:
        return false;
    }

    public static void d(String r10, String r11) {
        if (f12203e == true) goto L6;
        i();
    L6:
        if (f12201c == false) goto L11;
        if (c(3) == false) goto L11;
        k(3, r10, r11);
    L11:
        if (f12200b == false) goto L14;
        a(3, r10, r11);
        return;
    }

    public static void e(String r10, String r11) {
        if (f12203e == true) goto L6;
        i();
    L6:
        if (f12201c == false) goto L11;
        if (c(6) == false) goto L11;
        Log.e(r10, r11);
    L11:
        if (f12200b == false) goto L14;
        fa.a.i(r10, r11);
        b();
        return;
    }

    public static void f(String r10, String r11) {
        if (f12203e == true) goto L6;
        i();
    L6:
        if (f12201c == false) goto L11;
        if (c(4) == false) goto L11;
        k(4, r10, r11);
    L11:
        if (f12200b == false) goto L14;
        a(4, r10, r11);
        return;
    }

    public static void g(a r10) {
        f12199a = r10.f();
        f12200b = r10.g();
        f12202d = r10.b();
        f12206h = r10.a();
        UserManager r11 = (UserManager) r10.a().getSystemService("user");
        if (r11 != null) goto L43;
    L9:
        SharedPreferences r12 = r10.a().createDeviceProtectedStorageContext().getSharedPreferences("olog_config", 0);     // Catch: IllegalStateException -> L7
    L42:
    L13:
        if (r12 != null) goto L20;
        if (f12200b == false) goto L17;
        h(r10);
    L17:
        f12203e = true;
        return;
    L20:
        if (r12.contains("report") == false) goto L23;
        f12199a = r12.getBoolean("report", false);
    L23:
        if (r12.contains("save_to_disk") == false) goto L26;
        f12200b = r12.getBoolean("save_to_disk", true);
    L26:
        if (r12.contains("output_to_logd") == false) goto L29;
        f12201c = r12.getBoolean("output_to_logd", false);
    L29:
        if (r12.contains("log_level") == false) goto L32;
        f12202d = r12.getInt("log_level", 3);
        r10.i(f12202d);
    L32:
        if (r12.contains("max_dir_size") == false) goto L35;
        r10.l(r12.getInt("max_dir_size", r10.e()));
    L35:
        if (r12.contains("log_expired_days") == false) goto L38;
        r10.k(r12.getInt("log_expired_days", r10.d()));
    L38:
        if (f12200b == false) goto L40;
        h(r10);
    L40:
        f12203e = true;
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L13
    L43:
        if (r11.isUserUnlocked() == false) goto L9;
        r12 = r10.a().getSharedPreferences("olog_config", 0);     // Catch: IllegalStateException -> L7
        goto L42
    }

    public static boolean h(a r10) {
        return fa.a.n(new b.C0251b(r10.a()).h(true).c(false).b(false).d(r10.b()).e(r10.c()).g(r10.e()).f(r10.d()).a());
    }

    public static void i() {
        g(new a.b(f12206h).a());
    }

    public static boolean j() {
        return f12203e;
    }

    public static void k(int r10, String r11, String r12) {
        if (r10 > 2) goto L6;
        Log.v(r11, r12);
        return;
    L6:
        if (r10 != 3) goto L9;
        Log.d(r11, r12);
        return;
    L9:
        if (r10 != 4) goto L12;
        Log.i(r11, r12);
        return;
    L12:
        if (r10 != 5) goto L14;
        Log.w(r11, r12);
        return;
    L14:
        Log.e(r11, r12);
    }

    public static void l(long r10) {
        if (f12206h != null) goto L5;
        return;
    L5:
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L9
        r12.put("packageName", f12206h.getPackageName());     // Catch: Exception -> L9
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L9
        r13.put("mainLogNumLines", r10);     // Catch: Exception -> L9
        r11.put("category", r12);     // Catch: Exception -> L9
        r11.put("metrics", r13);     // Catch: Exception -> L9
        r11.put("client_timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        r11.put("log_type", "flexible");     // Catch: Exception -> L9
        r11.put("event_name", "appLogFileLines");     // Catch: Exception -> L9
    L7:
        Intent r14 = new Intent("com.slardaros.metricevent.action");
        r14.putExtra(ServerElements.CODE, 0);
        r14.putExtra("event_name", "appLogFileLines");
        r14.putExtra("json_string", r11.toString());
        f12206h.sendBroadcast(r14, "com.slardaros.METRIC_EVENT_PERMISSION");
    }

    public static void m(int r10) {
        f12202d = r10;
        fa.a.f(r10);
    }

    public static void n(boolean r10) {
        f12201c = r10;
        SharedPreferences r11 = f12206h.getSharedPreferences("olog_config", 0);
        if (r11.contains("output_to_logd") == false) goto L6;
        f12201c = r11.getBoolean("output_to_logd", false);
        return;
    }

    public static void o(boolean r10) {
        f12199a = r10;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f12206h = getContext();
        f12204f = System.currentTimeMillis();
        f12205g = 0;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        return 0;
    }
}
