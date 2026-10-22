package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public final class c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Vector<z5> f27141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f27143c;

    public final synchronized void b() {
        monitor-enter(this);
        this.f27141a.clear();     // Catch: Throwable -> L6
        this.f27143c = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public c6() {
        this.f27143c = 0;
        this.f27142b = 10;
        this.f27141a = new Vector();
    }

    public final Vector<z5> a() {
        return this.f27141a;
    }

    public c6(byte r100) {
        this.f27142b = 100;
        this.f27143c = 0;
        this.f27141a = new Vector();
    }

    public final synchronized void a(z5 r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r100.b()) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f27141a.add(r100);     // Catch: Throwable -> L10
        this.f27143c += r100.b().getBytes().length;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized boolean a(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L21;
        monitor-exit(this);
        return false;
    L21:
    L18:
        th = move-exception;
        throw th;
    L9:
        if (this.f27141a.size() < this.f27142b) goto L12;
        monitor-exit(this);
        return true;
    L12:
        int r101 = this.f27143c + r100.getBytes().length;
        monitor-exit(this);
        if (r101 <= 10000) goto L17;
        return true;
    L17:
        return false;
    }
}
