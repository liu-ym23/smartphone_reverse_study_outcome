package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes28.dex */
public class p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static p5 f27837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, String> f27838b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f27839c;

    static {
        f27838b = new ConcurrentHashMap();
        f27839c = false;
    }

    private p5(Context r100) {
        if (f27839c == false) goto L5;
        return;
    L5:
        monitor-enter(p5.class);
        f27838b.clear();     // Catch: Throwable -> L13
        a(r100);     // Catch: Exception -> L9 Throwable -> L13
        f27839c = true;     // Catch: Exception -> L9 Throwable -> L13
    L11:
        monitor-exit(p5.class);     // Catch: Throwable -> L13
        return;
    L9:
        e = move-exception;
        t6.a(e, "DynamicHostManager", "Init error)");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private static void a(Context r100) {
        if (r100 != null) goto L33;
        return;
    L33:
    L30:
        e = move-exception;
        t6.a(e, "DynamicHostManager", "preloadConfigData error)");
        return;
    L6:
        if (l5.e() == true) goto L8;
        String r101 = "Localizable/servers/Localizable.url";
    L35:
        InputStream r102 = r100.getAssets().open(r101);     // Catch: Exception -> L14
        byte[] r103 = new byte[r102.available()];     // Catch: Exception -> L14
        r102.read(r103);     // Catch: Exception -> L14
        String r104 = new String(r103, "UTF-8");     // Catch: Exception -> L14
    L16:
        String[] r105 = r104.split("\";");     // Catch: Exception -> L30
        int r106 = r105.length;     // Catch: Exception -> L30
        int r107 = 0;
    L17:
        if (r107 >= r106) goto L29;
        String r108 = r105[r107];     // Catch: Exception -> L30
        if (r108.length() <= 0) goto L28;
        int r109 = r108.indexOf("\"");     // Catch: Exception -> L30
        int r110 = r108.indexOf("\"=\"");     // Catch: Exception -> L30
        if (r109 < 0) goto L28;
        if (r110 < 0) goto L28;
        String r111 = r108.substring(r109 + 1, r110);     // Catch: Exception -> L30
        String r112 = r108.substring(r110 + 3);     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r111) == true) goto L28;
        if (TextUtils.isEmpty(r112) == true) goto L28;
        f27838b.put(Integer.valueOf(CastIntegerProtector.parseInt(r111)), r112);     // Catch: Exception -> L30
    L28:
        r107 = r107 + 1;
        goto L17
    L29:
        return;
    L14:
        e = move-exception;
        t6.a(e, "DynamicHostManager", "readAssetsFile error)");     // Catch: Exception -> L30
        r104 = null;
        goto L16
    L8:
        if (l5.d() == false) goto L10;
        r101 = "Localizable/servers/oversea/de/Localizable.url";
        goto L35
    L10:
        r101 = "Localizable/servers/oversea/Localizable.url";
        goto L35
    }

    public static p5 b(Context r100) {
        if (f27837a != null) goto L6;
        f27837a = new p5(r100);
    L6:
        return f27837a;
    }

    public String a(int r100) {
        ConcurrentHashMap<Integer, String> r101 = f27838b;
        if (r101.isEmpty() == false) goto L7;
        return null;
    L7:
        return r101.get(Integer.valueOf(r100));
    }
}
