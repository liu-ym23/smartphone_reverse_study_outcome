package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f13609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f13610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f13611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0279b f13612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private C0279b f13613e;

    /* JADX INFO: compiled from: SnackbarManager.java */
    interface a {
        void a();

        void a(int r1);
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SnackbarManager.java */
    private static class C0279b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<a> f13614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f13615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f13616c;

        boolean a(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L5;
        L7:
            return false;
        L5:
            if (this.f13614a.get() != r4) goto L7;
            return true;
        }
    }

    static b a() {
        if (f13609a != null) goto L6;
        f13609a = new b();
    L6:
        return f13609a;
    }

    private b() {
        this.f13610b = new Object();
        this.f13611c = new Handler(Looper.getMainLooper(), new SnackbarManager$1(this));
    }

    public void a(a r3, int r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        Object r0 = this.f13610b;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f(r5) == false) goto L8;
        a(this.f13612d, r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L8:
        if (g(r5) == false) goto L10;
        a(this.f13613e, r4);     // Catch: Throwable -> L12
        goto L10
    }

    public void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        Object r0 = this.f13610b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f(r4) == false) goto L9;
        this.f13612d = null;     // Catch: Throwable -> L11
        if (this.f13613e == null) goto L9;
        b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void b(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        Object r0 = this.f13610b;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f(r4) == false) goto L7;
        b(this.f13612d);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void c(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        Object r0 = this.f13610b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f(r4) == true) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.f13612d.f13616c == true) goto L9;
        this.f13612d.f13616c = true;     // Catch: Throwable -> L11
        this.f13611c.removeCallbacksAndMessages(this.f13612d);     // Catch: Throwable -> L11
        goto L9
    }

    public void d(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        Object r0 = this.f13610b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f(r4) == true) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.f13612d.f13616c == false) goto L9;
        this.f13612d.f13616c = false;     // Catch: Throwable -> L11
        b(this.f13612d);     // Catch: Throwable -> L11
        goto L9
    }

    public boolean e(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        Object r0 = this.f13610b;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f(r4) == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (g(r4) == true) goto L10;
        r2 = false;
        goto L11
    }

    private void b() {
        C0279b r0 = this.f13613e;
        if (r0 == null) goto L9;
        this.f13612d = r0;
        this.f13613e = null;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.f13614a.get(), a.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        r1.a();
        return;
    L7:
        this.f13612d = null;
        return;
    }

    private boolean a(C0279b r4, int r5) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(r4.f13614a.get(), a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        this.f13611c.removeCallbacksAndMessages(r4);
        r0.a(r5);
        return true;
    L6:
        return false;
    }

    private boolean f(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        C0279b r2 = this.f13612d;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.a(r4) == false) goto L7;
        return true;
    }

    private boolean g(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        C0279b r2 = this.f13613e;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.a(r4) == false) goto L7;
        return true;
    }

    private void b(C0279b r4) {
        if (r4.f13615b != (-2)) goto L5;
        return;
    L5:
        int r0 = 2750;
        if (r4.f13615b <= 0) goto L9;
        r0 = r4.f13615b;
    L11:
        this.f13611c.removeCallbacksAndMessages(r4);
        Handler r3 = this.f13611c;
        r3.sendMessageDelayed(Message.obtain(r3, 0, r4), r0);
        return;
    L9:
        if (r4.f13615b != (-1)) goto L11;
        r0 = 1500;
        goto L11
    }

    void a(C0279b r3) {
        Object r0 = this.f13610b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f13612d != r3) goto L7;
    L8:
        a(r3, 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.f13613e != r3) goto L9;
        goto L8
    }
}
