package com.bytedance.applog.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.applog.store.DbStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: TaskPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f6005a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f6007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6009e;
    private d f;
    private Handler g;
    private final b h;
    private final List<d> i;
    private boolean j;
    private volatile a k;
    private final com.bytedance.applog.c l;
    private final Runnable m;
    private final Runnable n;

    static /* synthetic */ long a(c r0, long r1) {
        r0.f6009e = r1;
        return r1;
    }

    static /* synthetic */ d a(c r0) {
        return r0.f;
    }

    static /* synthetic */ d a(c r0, d r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ void a(c r0, String r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean a(c r0, boolean r1) {
        r0.j = r1;
        return r1;
    }

    static /* synthetic */ boolean b(c r0) {
        return r0.f6008d;
    }

    static /* synthetic */ boolean b(c r0, boolean r1) {
        r0.f6007c = r1;
        return r1;
    }

    static /* synthetic */ List c() {
        return f6005a;
    }

    static /* synthetic */ boolean c(c r0) {
        return r0.f6007c;
    }

    static /* synthetic */ boolean c(c r0, boolean r1) {
        r0.f6006b = r1;
        return r1;
    }

    static /* synthetic */ b d(c r0) {
        return r0.h;
    }

    static /* synthetic */ boolean d(c r0, boolean r1) {
        r0.f6008d = r1;
        return r1;
    }

    static /* synthetic */ void e(c r0) {
        r0.f();
    }

    static /* synthetic */ com.bytedance.applog.c f(c r0) {
        return r0.l;
    }

    static /* synthetic */ boolean g(c r0) {
        return r0.j;
    }

    static /* synthetic */ List h(c r0) {
        return r0.i;
    }

    static /* synthetic */ Runnable i(c r0) {
        return r0.m;
    }

    static /* synthetic */ void j(c r0) {
        r0.h();
    }

    static /* synthetic */ Runnable k(c r0) {
        return r0.n;
    }

    static /* synthetic */ boolean l(c r0) {
        return r0.f6006b;
    }

    static /* synthetic */ long m(c r2) {
        return r2.f6009e;
    }

    static /* synthetic */ void n(c r0) {
        r0.g();
    }

    static {
        f6005a = Collections.singletonList("TaskPresenter");
    }

    private Handler d() {
        final Looper r1 = TeaThread.getInst().getLooper();
        return new TaskPresenter$1(this, r1);
    }

    private Handler e() {
        if (this.g != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.g != null) goto L8;
        this.g = d();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.g;
    }

    private void f() {
        a r0 = this.k;
        if (r0 == null) goto L11;
        boolean r1 = r0.a();
        if (this.f6007c == r1) goto L12;
        this.l.Z().a(f6005a, "[Task] tryCorrectTaskState newIsTaskRunning : " + r1, new Object[0]);
        if (r1 == false) goto L9;
        a();
        return;
    L9:
        b();
        return;
    L12:
        return;
    }

    public c(com.bytedance.applog.c r4, DbStore r5, com.bytedance.applog.j.c r6) {
        this.f6006b = false;
        this.f6007c = false;
        this.f6008d = true;
        this.f6009e = System.currentTimeMillis();
        this.i = new ArrayList();
        this.j = false;
        this.m = new AnonymousClass1(this);
        this.n = new AnonymousClass2(this);
        this.l = r4;
        this.h = new b(r4, r5, r6);
    }

    private void g() {
        this.f6006b = false;
        this.i.clear();
        this.j = false;
    }

    private void a(String r3) {
        Handler r2 = e();
        r2.removeMessages(1);
        r2.sendMessageDelayed(Message.obtain(r2, 1, r3), 5000);
    }

    private void h() {
        e().removeMessages(1);
    }

    public void a() {
        final long r0 = System.currentTimeMillis();
        TeaThread.getInst().ensureTeaThread(new AnonymousClass3(this, r0));
    }

    public void b() {
        final long r0 = System.currentTimeMillis();
        TeaThread.getInst().ensureTeaThread(new AnonymousClass4(this, r0));
    }

    public void a(final long r3, final String r5) {
        TeaThread.getInst().ensureTeaThread(new AnonymousClass5(this, r3, r5));
    }

    public void b(final long r3, final String r5) {
        TeaThread.getInst().ensureTeaThread(new AnonymousClass6(this, r3, r5));
    }
}
