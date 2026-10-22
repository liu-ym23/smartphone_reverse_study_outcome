package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class o3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f27729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile o3 f27730d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Hashtable<String, String> f27731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f27732b;

    public static void a() {
        if (f27730d != null) goto L5;
    L19:
        f27729c = false;
        return;
    L5:
        if (f27730d.f27731a != null) goto L7;
    L18:
        f27730d = null;
        goto L19
    L7:
        if (f27730d.f27731a.size() <= 0) goto L18;
        Hashtable<String, String> r100 = f27730d.f27731a;
        monitor-enter(r100);
        f27730d.d();     // Catch: Throwable -> L15
        if (f27730d.f27732b == null) goto L13;
        f27730d.f27732b.clear();     // Catch: Throwable -> L15
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public static o3 b() {
        if (f27730d != null) goto L15;
        monitor-enter(o3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f27730d != null) goto L9;
        f27730d = new o3();     // Catch: Throwable -> L11
    L9:
        monitor-exit(o3.class);     // Catch: Throwable -> L11
    L15:
        return f27730d;
    }

    private void d() {
        if (f27729c == true) goto L7;
        this.f27731a.clear();
        return;
    L7:
        if (this.f27731a == null) goto L30;
        StringBuffer r100 = new StringBuffer();
        int r101 = this.f27731a.size();
        if (r101 <= 0) goto L23;
        r100.append("[");
        Iterator<String> r102 = this.f27731a.values().iterator();
        int r103 = 0;
    L12:
        if (r102.hasNext() == false) goto L16;
        r103 = r103 + 1;
        r100.append(r102.next());
        if (r103 >= r101) goto L12;
        r100.append(",");
        goto L12
    L16:
        r100.append("]");
        String r104 = r100.toString();
        if (TextUtils.isEmpty(r104) == true) goto L23;
        WeakReference<Context> r105 = this.f27732b;
        if (r105 == null) goto L23;
        if (r105.get() == null) goto L23;
        f8.a(r104, this.f27732b.get());
    L23:
        this.f27731a.clear();
        return;
    }

    private o3() {
        this.f27731a = new Hashtable();
        this.f27732b = null;
    }

    public static boolean c() {
        return f27729c;
    }

    public void a(Context r100) {
        if (r100 == null) goto L5;
        this.f27732b = new WeakReference(r100);
        return;
    }

    public static void a(boolean r100) {
        f27729c = r100;
    }

    public void a(LatLng r100, String r101, String r102) {
        if (f27729c == true) goto L6;
        this.f27731a.clear();
        return;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L38;
        StringBuffer r103 = new StringBuffer("{\"lon\":");
        r103.append(r100.longitude);
        r103.append(",\"lat\":");
        r103.append(r100.latitude);
        r103.append(",\"title\":\"");
        r103.append(r101);
        r103.append("\",\"snippet\":\"");
        if (TextUtils.isEmpty(r102) == false) goto L12;
        r102 = "";
    L12:
        r103.append(r102);
        r103.append("\"}");
        String r104 = r103.toString();
        if (r104 == null) goto L39;
        Hashtable<String, String> r105 = this.f27731a;
        if (r105 == null) goto L40;
        monitor-enter(r105);
        String r106 = t5.c(r104);     // Catch: Throwable -> L32
        Hashtable<String, String> r107 = this.f27731a;     // Catch: Throwable -> L32
        if (r107 != null) goto L20;
    L22:
        Hashtable<String, String> r108 = this.f27731a;     // Catch: Throwable -> L32
        if (r108 != null) goto L25;
    L27:
        boolean r109 = false;
    L28:
        if (r109 == false) goto L30;
        d();     // Catch: Throwable -> L32
    L30:
        monitor-exit(r105);     // Catch: Throwable -> L32
        return;
    L25:
        if (r108.size() <= 20) goto L27;
        r109 = true;
        goto L28
    L20:
        if (r107.contains(r106) == true) goto L22;
        this.f27731a.put(r106, r104);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L40:
        return;
    L39:
        return;
    }
}
