package com.apm.lite;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.apm.lite.j.i;
import com.apm.lite.k.k;
import com.apm.lite.k.u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r1.m;

/* JADX INFO: loaded from: classes39.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, MonitorCrash> f29907b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MonitorCrash f29908a;

    static {
        f29907b = new ConcurrentHashMap();
    }

    public static String f(String r100) {
        if (f29907b == null) goto L8;
        MonitorCrash r101 = f29907b.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.mConfig.f29883b;
    L8:
        return null;
    }

    public final String e() {
        return this.f29908a.mConfig.f29882a;
    }

    public d(MonitorCrash r100) {
        this.f29908a = r100;
        k1.b.f501332a.add(this);
        p1.b.a();
        m.a().a(new i());
    }

    public final JSONArray b(String[] r110) {
        if (this.f29908a.config().f29887f != null) goto L8;
        JSONArray r100 = new JSONArray();
        int r111 = r110.length;
        JSONObject r101 = new JSONObject();
        r101.put("start", 0);     // Catch: Throwable -> L39
        r101.put("end", r111);     // Catch: Throwable -> L39
    L7:
        return r100.put(r101);
    L8:
        String[] r102 = this.f29908a.mConfig.f29887f;
        StackTraceElement r103 = u.f30016a;
        u.a r104 = new u.a();
        JSONArray r105 = new JSONArray();
        int r106 = 0;
    L10:
        if (r106 >= r110.length) goto L21;
        if (r104.f30017a != (-1)) goto L17;
        if (u.k(r110[r106], r102) == false) goto L19;
        r104.f30017a = r106;
        r104.f30018b = r106;
    L19:
        r106 = r106 + 1;
        goto L10
    L17:
        if (u.k(r110[r106], r102) == true) goto L19;
        r104.f30018b = r106;
        r105.put(r104.a());
        r104 = new u.a();
        goto L19
    L21:
        if (r104.f30017a == (-1)) goto L46;
        r104.f30018b = r110.length;
        r105.put(r104.a());
    L46:
        if (k.c(r105) == false) goto L38;
        if (this.f29908a.mConfig.f29891j == false) goto L38;
        String r107 = String.valueOf(s1.c.c().f540091j);     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r107) == true) goto L38;
        String[] r108 = this.f29908a.mConfig.f29887f;     // Catch: Throwable -> L41
        int r109 = r108.length;     // Catch: Throwable -> L41
        int r112 = 0;
    L30:
        if (r112 >= r109) goto L38;
        if (r107.contains(r108[r112]) == true) goto L33;
        r112 = r112 + 1;
        goto L30
    L33:
        JSONArray r113 = new JSONArray();     // Catch: Throwable -> L41
        int r114 = r110.length;     // Catch: Throwable -> L41
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L41
        r115.put("start", 0);     // Catch: Throwable -> L40
        r115.put("end", r114);     // Catch: Throwable -> L40
    L35:
        return r113.put(r115);
    L38:
        return r105;
    }

    public final JSONObject d(boolean r100) {
        JSONObject r101 = new JSONObject();
        if (this.f29908a.mConfig.f29887f != null) goto L15;
        Context r102 = e.f29909a;     // Catch: Throwable -> L14
        PackageInfo r103 = r102.getPackageManager().getPackageInfo(r102.getPackageName(), 128);     // Catch: Throwable -> L14
        if (r103 == null) goto L15;
        MonitorCrash.Config r104 = this.f29908a.mConfig;     // Catch: Throwable -> L14
        if (r104.f29885d != (-1)) goto L11;
        r104.f29885d = r103.versionCode;     // Catch: Throwable -> L14
    L11:
        if (r104.f29886e != null) goto L15;
        r104.f29886e = r103.versionName;     // Catch: Throwable -> L14
    L15:
        JSONArray r105 = null;
        if (TextUtils.isEmpty(this.f29908a.mConfig.getDeviceId()) == false) goto L18;
    L19:
        MonitorCrash r106 = this.f29908a;
        if (r106.mAppLog == null) goto L42;
        r106.mConfig.setDeviceId(null, false);
    L42:
        r101.put("aid", String.valueOf(this.f29908a.mConfig.f29882a));     // Catch: JSONException -> L41
        if (r100 == true) goto L25;
    L27:
        r101.put("update_version_code", this.f29908a.mConfig.f29885d);     // Catch: JSONException -> L41
        r101.put("version_code", this.f29908a.mConfig.f29885d);     // Catch: JSONException -> L41
        r101.put("app_version", this.f29908a.mConfig.f29886e);     // Catch: JSONException -> L41
        r101.put("channel", this.f29908a.mConfig.f29884c);     // Catch: JSONException -> L41
        String[] r107 = this.f29908a.mConfig.f29887f;     // Catch: JSONException -> L41
        if (r107 != null) goto L30;
        JSONArray r108 = null;
    L33:
        r101.put("package", r108);     // Catch: JSONException -> L41
        r101.put("device_id", this.f29908a.mConfig.getDeviceId());     // Catch: JSONException -> L41
        r101.put("user_id", this.f29908a.mConfig.getUID());     // Catch: JSONException -> L41
        r101.put("os", "Android");     // Catch: JSONException -> L41
        String[] r109 = this.f29908a.mConfig.f29888g;     // Catch: JSONException -> L41
        if (r109 == null) goto L39;
        r105 = new JSONArray();     // Catch: JSONException -> L41
        int r110 = r109.length;     // Catch: JSONException -> L41
        int r111 = 0;
    L37:
        if (r111 >= r110) goto L39;
        r105.put(r109[r111]);     // Catch: JSONException -> L41
        r111 = r111 + 1;     // Catch: JSONException -> L41
    L39:
        r101.put("so_list", r105);     // Catch: JSONException -> L41
        r101.put("single_upload", 0);     // Catch: JSONException -> L41
        goto L40
    L30:
        r108 = new JSONArray();     // Catch: JSONException -> L41
        int r112 = r107.length;     // Catch: JSONException -> L41
        int r113 = 0;
    L31:
        if (r113 >= r112) goto L33;
        r108.put(r107[r113]);     // Catch: JSONException -> L41
        r113 = r113 + 1;     // Catch: JSONException -> L41
        goto L31
    L25:
        if (TextUtils.isEmpty(this.f29908a.mConfig.f29883b) == true) goto L27;
        r101.put("x-auth-token", this.f29908a.mConfig.f29883b);     // Catch: JSONException -> L41
    L40:
        return r101;
    L18:
        if ("0".equals(this.f29908a.mConfig.getDeviceId()) == false) goto L42;
        goto L19
    }

    public final JSONArray a(StackTraceElement[] r100, Throwable r101) {
        String[] r102 = this.f29908a.mConfig.f29887f;
        int r103 = 0;
        if (r102 != null) goto L8;
        JSONArray r104 = new JSONArray();
        int r105 = r100.length;
        JSONObject r106 = new JSONObject();
        r106.put("start", 0);     // Catch: Throwable -> L29
        r106.put("end", r105);     // Catch: Throwable -> L29
    L7:
        return r104.put(r106);
    L8:
        if (r101 == null) goto L27;
        if (r100 == null) goto L37;
        StackTraceElement r107 = u.f30016a;
        u.a r108 = new u.a();
        JSONArray r109 = new JSONArray();
    L13:
        if (r103 >= r100.length) goto L24;
        if (r108.f30017a != (-1)) goto L20;
        if (u.k(r100[r103].getClassName(), r102) == false) goto L22;
        r108.f30017a = r103;
        r108.f30018b = r103;
    L22:
        r103 = r103 + 1;
        goto L13
    L20:
        if (u.k(r100[r103].getClassName(), r102) == true) goto L22;
        r108.f30018b = r103;
        r109.put(r108.a());
        r108 = new u.a();
        goto L22
    L24:
        if (r108.f30017a == (-1)) goto L26;
        r108.f30018b = r100.length;
        r109.put(r108.a());
    L26:
        return r109;
    L37:
        return null;
    L27:
        return null;
    }

    public final JSONObject c(CrashType r100, JSONArray r101) {
        JSONObject r102 = new JSONObject();
        r102.put("header", d(false));     // Catch: Throwable -> L15
        if (r100 == null) goto L13;
        AttachUserData r103 = this.f29908a.mCustomData;     // Catch: Throwable -> L15
        if (r103 == null) goto L11;
        Map<? extends String, ? extends String> r104 = r103.getUserData(r100);     // Catch: Throwable -> L15
        if (r104 == null) goto L11;
        JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L15
    L12:
        r102.put("custom", r105);     // Catch: Throwable -> L15
        r102.put("filters", new JSONObject(this.f29908a.mTagMap));     // Catch: Throwable -> L15
    L11:
        r105 = null;
    L13:
        r102.put("line_num", r101);     // Catch: Throwable -> L15
    L14:
        return r102;
    }
}
