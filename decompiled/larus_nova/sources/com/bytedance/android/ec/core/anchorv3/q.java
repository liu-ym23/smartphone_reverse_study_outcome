package com.bytedance.android.ec.core.anchorv3;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes43.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f43818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f43819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f43820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f43821d;

    public static final class a {
    }

    static {
    }

    public q() {
        this(3);
    }

    public abstract void c();

    public final void a() {
        if (this.f43820c == false) goto L5;
        return;
    L5:
        if (b() == true) goto L11;
        c();
        this.f43820c = true;
        CountDownLatch r100 = this.f43818a;
        if (r100 == null) goto L12;
        r100.countDown();
        return;
    L12:
        return;
    }

    public boolean b() {
        return this.f43819b;
    }

    public q(int r100) {
        this.f43821d = r100;
        if (r100 != (-1)) goto L5;
        CountDownLatch r101 = new CountDownLatch(1);
    L6:
        this.f43818a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }
}
