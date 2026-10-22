package com.bytedance.bdinstall;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: InstallWaitingLock.java */
/* JADX INFO: loaded from: classes.dex */
class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f6139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f6140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f6141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal<Boolean> f6142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f6143e;
    private volatile boolean f;

    aq() {
        this.f6139a = new Object();
        this.f6140b = false;
        this.f6141c = new AtomicBoolean(false);
        this.f6142d = new ThreadLocal();
        this.f6143e = false;
        this.f = false;
    }

    void a(boolean r1) {
        if (r1 == false) goto L4;
        this.f6142d.set(Boolean.valueOf(r1));
        return;
    L4:
        this.f6142d.remove();
    }

    void b(boolean r1) {
        this.f = r1;
        if (r1 == false) goto L5;
        this.f6142d.set(Boolean.valueOf(r1));
        return;
    L5:
        this.f6142d.remove();
        this.f6143e = true;
        t.a("tryWaitingForInstallFinishWithOldWay finish because request finished");
    }
}
