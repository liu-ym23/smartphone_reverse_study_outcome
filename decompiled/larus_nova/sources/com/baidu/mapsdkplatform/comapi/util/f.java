package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f32324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f32325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f32326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<e> f32327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e f32328e;

    public static f b() {
        if (f32324a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f32324a != null) goto L9;
        f32324a = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f32324a;
    }

    private f() {
        this.f32325b = false;
        this.f32326c = true;
        this.f32327d = new ArrayList();
        this.f32328e = null;
    }

    public e a() {
        return this.f32328e;
    }

    public e a(Context r100) {
        String r101 = r100.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.length() <= 0) goto L17;
        Iterator<e> r102 = this.f32327d.iterator();
    L8:
        if (r102.hasNext() == false) goto L18;
        e r103 = r102.next();
        if (r103.c().equals(r101) == false) goto L8;
        return r103;
    L18:
        return null;
    L17:
        return null;
    }

    public void b(Context r100) {
        if (this.f32325b == true) goto L60;
        if (r100 == null) goto L62;
        this.f32325b = true;
        this.f32326c = false;     // Catch: Exception -> L9
        this.f32328e = new e(r100);     // Catch: Exception -> L9
        this.f32327d.clear();     // Catch: Exception -> L9
        this.f32327d.add(this.f32328e);     // Catch: Exception -> L9
    L46:
    L37:
        e = move-exception;
        e.printStackTrace();
    L48:
    L43:
        e = move-exception;
        e.printStackTrace();
        return;
    L40:
        if (this.f32328e != null) goto L61;
        this.f32326c = false;     // Catch: Exception -> L43
        this.f32328e = new e(r100);     // Catch: Exception -> L43
        this.f32327d.clear();     // Catch: Exception -> L43
        this.f32327d.add(this.f32328e);     // Catch: Exception -> L43
        return;
    L61:
        return;
    L12:
        if (this.f32327d.size() <= 0) goto L48;
        Iterator<e> r101 = this.f32327d.iterator();     // Catch: Exception -> L37
        e r102 = null;
        int r103 = 0;
    L15:
        if (r101.hasNext() == false) goto L19;
        e r104 = r101.next();     // Catch: Exception -> L37
        if (new PolarisFileWrapper(r104.a()).exists() == false) goto L15;
        r103 = r103 + 1;     // Catch: Exception -> L37
        r102 = r104;
        goto L15
    L19:
        if (r103 != 0) goto L28;
        e r105 = a(r100);     // Catch: Exception -> L37
        this.f32328e = r105;     // Catch: Exception -> L37
        if (r105 != null) goto L34;
        Iterator<e> r106 = this.f32327d.iterator();     // Catch: Exception -> L37
    L24:
        if (r106.hasNext() == false) goto L34;
        e r107 = r106.next();     // Catch: Exception -> L37
        if (a(r100, r107) == false) goto L24;
        this.f32328e = r107;     // Catch: Exception -> L37
    L34:
        if (this.f32328e != null) goto L48;
        this.f32328e = (e) ListProtector.get(this.f32327d, 0);     // Catch: Exception -> L37
        goto L48
    L28:
        if (r103 == 1) goto L30;
        this.f32328e = a(r100);     // Catch: Exception -> L37
        goto L34
    L30:
        if (a(r100, r102) == false) goto L34;
        this.f32328e = r102;     // Catch: Exception -> L37
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L46
    L62:
        return;
    }

    public boolean a(Context r100, e r101) {
        String r102 = r101.c();
        SharedPreferences.Editor r103 = r100.getSharedPreferences("map_pref", 0).edit();
        r103.putString("PREFFERED_SD_CARD", r102);
        return r103.commit();
    }
}
