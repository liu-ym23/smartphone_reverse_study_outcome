package com.bytedance.frameworks.baselib.network.http.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f7532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7539h;

    public d(int r10) {
        if (r10 <= 0) goto L7;
        this.f7534c = r10;
        this.f7532a = Collections.synchronizedMap(new LinkedHashMap(0, 0.75f, true));
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public Object a(Object r10) {
        return null;
    }

    public void b(Object r10, Object r11) {
    }

    public final synchronized void c() {
        monitor-enter(this);
        k(-1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized Object d(Object r10) {
        monitor-enter(this);
        if (r10 == null) goto L17;
        Object r11 = this.f7532a.get(r10);     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        this.f7538g++;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r11;
    L11:
        this.f7539h++;     // Catch: Throwable -> L9
        Object r12 = a(r10);     // Catch: Throwable -> L9
        if (r12 == null) goto L14;
        this.f7536e++;     // Catch: Throwable -> L9
        this.f7533b += h(r10, r12);     // Catch: Throwable -> L9
        this.f7532a.put(r10, r12);     // Catch: Throwable -> L9
        k(this.f7534c);     // Catch: Throwable -> L9
    L14:
        monitor-exit(this);
        return r12;
    L17:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized Map e() {
        monitor-enter(this);
        Map r10 = this.f7532a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Object f(Object r10, Object r11) {
        monitor-enter(this);
        if (r10 == null) goto L14;
        if (r11 == null) goto L14;
        this.f7535d++;     // Catch: Throwable -> L8
        this.f7533b += h(r10, r11);     // Catch: Throwable -> L8
        Object r12 = this.f7532a.put(r10, r11);     // Catch: Throwable -> L8
        if (r12 == null) goto L10;
        this.f7533b -= h(r10, r12);     // Catch: Throwable -> L8
    L10:
        k(this.f7534c);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r12;
    L14:
        throw new NullPointerException("key == null || value == null");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized Object g(Object r10) {
        monitor-enter(this);
        if (r10 == null) goto L13;
        Object r11 = this.f7532a.remove(r10);     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        this.f7533b -= h(r10, r11);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);
        return r11;
    L13:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public final int h(Object r10, Object r11) {
        int r12 = j(r10, r11);
        if (r12 < 0) goto L6;
        return r12;
    L6:
        throw new IllegalStateException("Negative size: " + r10 + "=" + r11);
    }

    public final synchronized int i() {
        monitor-enter(this);
        int r10 = this.f7533b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public int j(Object r10, Object r11) {
        return 1;
    }

    public final void k(int r10) {
    L3:
        if (this.f7533b <= r10) goto L11;
        if (this.f7532a.isEmpty() == true) goto L11;
        Map.Entry r11 = (Map.Entry) this.f7532a.entrySet().iterator().next();
        if (r11 == null) goto L11;
        Object r12 = r11.getKey();
        Object r13 = r11.getValue();
        this.f7532a.remove(r12);
        this.f7533b -= h(r12, r13);
        this.f7537f++;
        b(r12, r13);
    L11:
        if (this.f7533b < 0) goto L18;
        if (this.f7532a.isEmpty() == true) goto L15;
        return;
    L15:
        if (this.f7533b != 0) goto L18;
        return;
    L18:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r10 = this.f7538g;     // Catch: Throwable -> L6
        int r11 = this.f7539h + r10;     // Catch: Throwable -> L6
        if (r11 == 0) goto L8;
        int r12 = (r10 * 100) / r11;     // Catch: Throwable -> L6
    L9:
        String r13 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f7534c), Integer.valueOf(this.f7538g), Integer.valueOf(this.f7539h), Integer.valueOf(r12)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L8:
        r12 = 0;
    L6:
        th = move-exception;
        throw th;
    }
}
