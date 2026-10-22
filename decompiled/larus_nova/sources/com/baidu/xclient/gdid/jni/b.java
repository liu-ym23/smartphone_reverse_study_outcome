package com.baidu.xclient.gdid.jni;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.xclient.gdid.e;
import com.baidu.xclient.gdid.j.d;
import com.tencent.connect.common.Constants;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f33643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f33644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f33645c;

    public b(Context r100) {
        this.f33645c = r100;
        this.f33644b = c.a(r100);
    }

    public static b a(Context r100) {
        if (f33643a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f33643a != null) goto L9;
        f33643a = new b(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f33643a;
    }

    public String a() {
        JSONObject r100 = new JSONObject(e.e().k());     // Catch: Throwable -> L8
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L8
        a(r101);     // Catch: Throwable -> L8
        a(r101, r100);     // Catch: Throwable -> L8
        b(r101, r100);     // Catch: Throwable -> L8
        a(this.f33645c, r101, r100);     // Catch: Throwable -> L8
        c(r101, r100);     // Catch: Throwable -> L8
        a(this.f33645c, r101, true);     // Catch: Throwable -> L8
        a(this.f33645c, r101, false);     // Catch: Throwable -> L8
        a(r101, true);     // Catch: Throwable -> L8
        a(r101, false);     // Catch: Throwable -> L8
        byte[] r102 = this.f33644b.a(r101.toString().getBytes());     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        return "";
    L6:
        return Base64.encodeToString(r102, 10);
    L8:
        th = move-exception;
        d.a(th);
        return "";
    }

    public final JSONObject a(Context r110, JSONObject r111, int r112, int r113) {
        JSONObject r100 = new JSONObject();
        Iterator<String> r101 = r111.keys();     // Catch: Throwable -> L23
        int r102 = 1;
    L4:
        if (r101.hasNext() == false) goto L25;
        String r103 = r101.next();     // Catch: Throwable -> L23
        if (r102 < r112) goto L8;
        if (r102 >= (r112 + r113)) goto L25;
        r102 = r102 + 1;     // Catch: Throwable -> L23
        String r104 = r111.optString(r103);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r104) == true) goto L4;
        PackageInfo r105 = com.baidu.mshield.b.e.c.a(r110, r104, 0);     // Catch: Throwable -> L23
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L23
        if (r105 == null) goto L19;
        r106.put("0", 0);     // Catch: Throwable -> L23
        r106.put("1", r105.versionName);     // Catch: Throwable -> L23
        r106.put("2", r105.firstInstallTime);     // Catch: Throwable -> L23
        r106.put("3", r105.lastUpdateTime);     // Catch: Throwable -> L23
    L21:
        r100.put(r103, r106);     // Catch: Throwable -> L23
        goto L4
    L19:
        r106.put("0", -1);     // Catch: Throwable -> L23
        r106.put("1", "");     // Catch: Throwable -> L23
        r106.put("2", 0);     // Catch: Throwable -> L23
        r106.put("3", 0);     // Catch: Throwable -> L23
        goto L21
    L8:
        r102 = r102 + 1;     // Catch: Throwable -> L23
    L25:
        return r100;
    L23:
        th = move-exception;
        d.a(th);
        goto L25
    }

    public final JSONObject a(JSONObject r100, int r101, int r102) {
        JSONObject r103 = new JSONObject();
        Iterator<String> r104 = r100.keys();     // Catch: Throwable -> L17
        int r105 = 1;
    L4:
        if (r104.hasNext() == false) goto L19;
        String r106 = r104.next();     // Catch: Throwable -> L17
        if (r105 < r101) goto L8;
        if (r105 >= (r101 + r102)) goto L19;
        r105 = r105 + 1;     // Catch: Throwable -> L17
        String r107 = r100.optString(r106);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r107) == true) goto L4;
        r103.put(r106, new JSONObject(this.f33644b.a(r107)));     // Catch: Throwable -> L17
        goto L4
    L8:
        r105 = r105 + 1;     // Catch: Throwable -> L17
    L19:
        return r103;
    L17:
        th = move-exception;
        d.a(th);
        goto L19
    }

    public final void a(Context r100, JSONObject r110, JSONObject r111) {
        int r101 = r111.optInt("4", 0);     // Catch: Throwable -> L11
        if (a.a(this.f33645c, r111, "1", 0, 1, r101) == false) goto L8;
        PackageInfo r102 = com.baidu.mshield.b.e.c.a(r100, com.baidu.xclient.gdid.d.a().a(r100), 0);     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
        r110.put(String.valueOf(20), r102.firstInstallTime);     // Catch: Throwable -> L11
    L9:
        a(r110, 52, this.f33644b.d());     // Catch: Throwable -> L11
        r110.put(String.valueOf(54), this.f33644b.c());     // Catch: Throwable -> L11
        a(r110, 58, this.f33644b.b());     // Catch: Throwable -> L11
        String[] r103 = a.a(this.f33644b.b("/proc/cpuinfo"));     // Catch: Throwable -> L11
        a(r110, 60, r103[0]);     // Catch: Throwable -> L11
        a(r110, 61, r103[1]);     // Catch: Throwable -> L11
        r110.put(String.valueOf(62), d.c());     // Catch: Throwable -> L11
        return;
    L8:
        r110.put(String.valueOf(20), 0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        d.a(th);
    }

    public final void a(Context r110, JSONObject r111, boolean r112) {
        JSONObject r100 = new JSONObject(e.e().k());     // Catch: Throwable -> L27
        int r101 = 20;
        if (r112 == false) goto L5;
        String r102 = r100.optString(Constants.VIA_SHARE_TYPE_MINI_PROGRAM);     // Catch: Throwable -> L27
        int r103 = r100.optInt("x", 20);     // Catch: Throwable -> L27
        String r104 = r102;
        int r105 = e.e().A();     // Catch: Throwable -> L27
        int r106 = 22;
    L6:
        if (r103 > 20) goto L10;
        if (r103 == 0) goto L10;
        r101 = r103;
    L10:
        int r107 = r100.optInt("4", 0);     // Catch: Throwable -> L27
        if (a.a(this.f33645c, r100, "", 0, 1, r107) == true) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r104) == true) goto L17;
        r104 = this.f33644b.d(r104);     // Catch: Throwable -> L27
    L17:
        if (TextUtils.isEmpty(r104) == false) goto L19;
        r111.put(String.valueOf(r106), new JSONObject());     // Catch: Throwable -> L27
        return;
    L19:
        JSONObject r108 = new JSONObject(r104);     // Catch: Throwable -> L27
        int r109 = r108.length();     // Catch: Throwable -> L27
        Pair<Integer, Integer> r113 = a.a(r105, r109, r101);     // Catch: Throwable -> L27
        int r114 = ((Integer) r113.first).intValue();     // Catch: Throwable -> L27
        int r115 = ((Integer) r113.second).intValue();     // Catch: Throwable -> L27
        JSONObject r116 = a(r110, r108, r114, r115);     // Catch: Throwable -> L27
        r111.put(String.valueOf(r106), r116);     // Catch: Throwable -> L27
        int r117 = r114 + r115;     // Catch: Throwable -> L27
        if (r117 > r109) goto L23;
        r109 = r117;
    L23:
        if (r112 == false) goto L25;
        e.e().h(r109);     // Catch: Throwable -> L27
        return;
    L25:
        e.e().g(r109);     // Catch: Throwable -> L27
        return;
    L5:
        String r118 = e.e().r();     // Catch: Throwable -> L27
        r103 = r100.optInt("y", 20);     // Catch: Throwable -> L27
        r104 = r118;
        r105 = e.e().z();     // Catch: Throwable -> L27
        r106 = 21;
    L27:
        th = move-exception;
        d.a(th);
    }

    public final void a(JSONObject r100) {
        a(r100, 3, this.f33644b.f());     // Catch: Throwable -> L4
        a(r100, 4, com.baidu.xclient.gdid.d.a().c("mod"));     // Catch: Throwable -> L4
        a(r100, 5, this.f33644b.k());     // Catch: Throwable -> L4
        a(r100, 6, this.f33644b.j());     // Catch: Throwable -> L4
        a(r100, 7, this.f33644b.i());     // Catch: Throwable -> L4
        a(r100, 8, this.f33644b.h());     // Catch: Throwable -> L4
        a(r100, 9, this.f33644b.g());     // Catch: Throwable -> L4
        a(r100, 50, this.f33644b.c("ro.build.fingerprint"));     // Catch: Throwable -> L4
        a(r100, 53, com.baidu.xclient.gdid.d.a().c("arv"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.a(th);
    }

    public final void a(JSONObject r100, int r101, String r102) {
        String r103 = String.valueOf(r101);     // Catch: Throwable -> L7
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r100.put(r103, r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        d.a(th);
    }

    public final void a(JSONObject r100, JSONObject r110) {
        int r101 = r110.optInt("4", 0);     // Catch: Throwable -> L15
        if (a.a(this.f33645c, r110, "2", 0, 1, r101) == false) goto L12;
        String r111 = Environment.getExternalStorageDirectory().getAbsolutePath();     // Catch: Throwable -> L15
        String[] r112 = this.f33644b.e(r111).split("\\|");     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r112[0]) == false) goto L7;
        r100.put(String.valueOf(10), 0);     // Catch: Throwable -> L15
    L9:
        if (TextUtils.isEmpty(r112[1]) == true) goto L13;
        r100.put(String.valueOf(11), Long.valueOf(r112[1]));     // Catch: Throwable -> L15
        return;
    L13:
        r100.put(String.valueOf(11), 0);     // Catch: Throwable -> L15
        return;
    L7:
        r100.put(String.valueOf(10), Long.valueOf(r112[0]));     // Catch: Throwable -> L15
        goto L9
    L12:
        r100.put(String.valueOf(10), 0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        d.a(th);
    }

    public final void a(JSONObject r100, boolean r110) {
        JSONObject r101 = new JSONObject(e.e().k());     // Catch: Throwable -> L26
        int r102 = r101.optInt("4", 0);     // Catch: Throwable -> L26
        int r103 = 20;
        if (r110 == false) goto L5;
        boolean r104 = a.a(this.f33645c, r101, "", 0, 1, r102);     // Catch: Throwable -> L26
        String r105 = r101.optString(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);     // Catch: Throwable -> L26
        int r106 = r101.optInt("u", 20);     // Catch: Throwable -> L26
        int r107 = e.e().b();     // Catch: Throwable -> L26
        int r108 = 59;
    L6:
        if (r106 > 20) goto L10;
        if (r106 == 0) goto L10;
        r103 = r106;
    L10:
        if (r104 == true) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r105) == true) goto L16;
        r105 = this.f33644b.d(r105);     // Catch: Throwable -> L26
    L16:
        if (TextUtils.isEmpty(r105) == false) goto L18;
        r100.put(String.valueOf(r108), new JSONObject());     // Catch: Throwable -> L26
        return;
    L18:
        JSONObject r109 = new JSONObject(r105);     // Catch: Throwable -> L26
        int r111 = r109.length();     // Catch: Throwable -> L26
        Pair<Integer, Integer> r112 = a.a(r107, r111, r103);     // Catch: Throwable -> L26
        int r113 = ((Integer) r112.first).intValue();     // Catch: Throwable -> L26
        int r114 = ((Integer) r112.second).intValue();     // Catch: Throwable -> L26
        JSONObject r115 = a(r109, r113, r114);     // Catch: Throwable -> L26
        r100.put(String.valueOf(r108), r115);     // Catch: Throwable -> L26
        int r116 = r113 + r114;     // Catch: Throwable -> L26
        if (r116 > r111) goto L22;
        r111 = r116;
    L22:
        if (r110 == false) goto L24;
        e.e().j(r111);     // Catch: Throwable -> L26
        return;
    L24:
        e.e().i(r111);     // Catch: Throwable -> L26
        return;
    L5:
        r104 = a.a(this.f33645c, r101, "", 0, 1, r102);     // Catch: Throwable -> L26
        r105 = e.e().s();     // Catch: Throwable -> L26
        r106 = r101.optInt(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, 20);     // Catch: Throwable -> L26
        r107 = e.e().a();     // Catch: Throwable -> L26
        r108 = 56;
    L26:
        th = move-exception;
        d.a(th);
    }

    public final void b(JSONObject r100, JSONObject r110) {
        int r101 = r110.optInt("4", 0);     // Catch: Throwable -> L15
        if (a.a(this.f33645c, r110, "2", 0, 1, r101) == false) goto L12;
        String r111 = Environment.getDataDirectory().getAbsolutePath();     // Catch: Throwable -> L15
        String[] r112 = this.f33644b.e(r111).split("\\|");     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r112[0]) == false) goto L7;
        r100.put(String.valueOf(12), 0);     // Catch: Throwable -> L15
    L9:
        if (TextUtils.isEmpty(r112[1]) == true) goto L13;
        r100.put(String.valueOf(13), Long.valueOf(r112[1]));     // Catch: Throwable -> L15
        return;
    L13:
        r100.put(String.valueOf(13), 0);     // Catch: Throwable -> L15
        return;
    L7:
        r100.put(String.valueOf(12), Long.valueOf(r112[0]));     // Catch: Throwable -> L15
        goto L9
    L12:
        r100.put(String.valueOf(12), 0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        d.a(th);
    }

    public final void c(JSONObject r100, JSONObject r110) {
        int r101 = r110.optInt("4", 0);     // Catch: Throwable -> L14
        if (a.a(this.f33645c, r110, "s", 1, 1, r101) == true) goto L5;
        return;
    L5:
        String r111 = com.baidu.xclient.gdid.d.a().c("sl");     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r111) == false) goto L10;
        r100.put(String.valueOf(57), 0);     // Catch: Throwable -> L14
        return;
    L10:
        if (TextUtils.isEmpty(r111) == true) goto L12;
        long r102 = com.baidu.mshield.b.f.c.a(r111);     // Catch: Throwable -> L14
        r100.put(String.valueOf(57), r102);     // Catch: Throwable -> L14
        return;
    L12:
        r100.put(String.valueOf(57), 0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        d.a(th);
    }
}
