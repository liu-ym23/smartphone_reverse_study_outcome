package com.bytedance.applog.priority;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: EventPriorityItem.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f5946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f5947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f5949e;
    Map<String, List<Set<String>>> f;
    Map<String, List<Map<String, Object>>> g;
    String h;
    String i;
    String[] j;
    boolean k;
    com.bytedance.applog.m.a l;

    public b() {
        this.j = null;
        this.k = false;
    }

    public int a() {
        return this.f5945a;
    }

    public int b() {
        return this.f5946b;
    }

    public long c() {
        return this.f5949e;
    }

    public com.bytedance.applog.m.a d() {
        return this.l;
    }

    public String[] a(String[] r9, String r10) {
        if (TextUtils.isEmpty(this.h) == false) goto L8;
        if (TextUtils.isEmpty(this.i) == false) goto L8;
        return null;
    L8:
        if (this.j != null) goto L32;
        this.j = new String[r9.length];
        int r2 = 0;
    L11:
        if (r2 >= r9.length) goto L32;
        int r3 = r9[r2].indexOf(r10);
        if (r3 <= 0) goto L29;
        String r4 = r9[r2].substring(0, r3);
        String r5 = r9[r2].substring(r3);
        if (TextUtils.isEmpty(this.h) == true) goto L22;
        if (this.h.startsWith("https://") == false) goto L22;
        if (this.h.endsWith("/") == true) goto L22;
        r4 = this.h;
    L22:
        if (TextUtils.isEmpty(this.i) == false) goto L24;
    L28:
        this.j[r2] = r4 + r5;
    L30:
        r2 = r2 + 1;
        goto L11
    L24:
        if (this.i.startsWith("/") == false) goto L28;
        if (this.i.endsWith("/") == false) goto L28;
        r5 = this.i;
        goto L28
    L29:
        this.j[r2] = r9[r2];
    L32:
        if (this.k == false) goto L34;
        return null;
    L34:
        String[] r8 = this.j;
        if (r8 != null) goto L37;
    L39:
        return null;
    L37:
        if (r8.length <= 0) goto L39;
        return r8;
    }

    public void a(int r1) {
        this.k = com.bytedance.applog.k.a.b(r1);
    }

    public boolean e() {
        if (this.f5945a != (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
