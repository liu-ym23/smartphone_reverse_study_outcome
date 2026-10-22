package com.ss.android.common.applog.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.common.applog.TeaThread;
import com.ss.android.common.applog.ad;
import com.ss.android.common.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TaskPresenter.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final String TAG = "TaskPresenter";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile c f37213e;
    private static volatile a n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f37214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f37215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f37217d;
    private d f;
    private Handler g;
    private Context h;
    private b i;
    private final List<d> j;
    private boolean k;
    private final Runnable l;
    private final Runnable m;

    static /* synthetic */ long a(c r0, long r1) {
        r0.f37217d = r1;
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
        r0.f37216c = r1;
        return r1;
    }

    static /* synthetic */ boolean b(c r0) {
        return r0.f37216c;
    }

    static /* synthetic */ boolean b(c r0, boolean r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ boolean c(c r0) {
        return r0.f37215b;
    }

    static /* synthetic */ boolean c(c r0, boolean r1) {
        r0.f37215b = r1;
        return r1;
    }

    static /* synthetic */ b d(c r0) {
        return r0.i;
    }

    static /* synthetic */ boolean d(c r0, boolean r1) {
        r0.f37214a = r1;
        return r1;
    }

    static /* synthetic */ void e(c r0) {
        r0.e();
    }

    static /* synthetic */ Runnable f(c r0) {
        return r0.m;
    }

    static /* synthetic */ Runnable g(c r0) {
        return r0.l;
    }

    static /* synthetic */ void h(c r0) {
        r0.g();
    }

    static /* synthetic */ boolean i(c r0) {
        return r0.f37214a;
    }

    static /* synthetic */ long j(c r2) {
        return r2.f37217d;
    }

    static /* synthetic */ List k(c r0) {
        return r0.j;
    }

    static /* synthetic */ void l(c r0) {
        r0.f();
    }

    static /* synthetic */ boolean m(c r0) {
        return r0.k;
    }

    private Handler c() {
        final Looper r1 = TeaThread.getInst().getLooper();
        return new TaskPresenter$1(this, r1);
    }

    private Handler d() {
        if (this.g != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.g != null) goto L8;
        this.g = c();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.g;
    }

    private void e() {
        a r0 = n;
        if (r0 == null) goto L11;
        boolean r1 = r0.a();
        if (this.f37215b == r1) goto L12;
        f.a.b("tryCorrectTaskState newIsTaskRunning : " + r1);
        if (r1 == false) goto L9;
        b();
        return;
    L9:
        a();
        return;
    L12:
        return;
    }

    private c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        this.f37214a = false;
        this.f37215b = false;
        this.f37216c = true;
        this.f37217d = ad.a();
        this.j = new ArrayList();
        this.k = false;
        this.l = new AnonymousClass2(this);
        this.m = new AnonymousClass3(this);
        this.h = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.i = new b(r6);
    }

    public static c a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (f37213e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f37213e != null) goto L9;
        f37213e = new c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f37213e;
    }

    public void a(final long r3, final String r5) {
        TeaThread.getInst().ensureTeaThread(new AnonymousClass1(this, r3, r5));
    }

    public void a() {
        final long r0 = ad.a();
        TeaThread.getInst().ensureTeaThread(new AnonymousClass4(this, r0));
    }

    private void f() {
        this.f37214a = false;
        this.j.clear();
        this.k = false;
    }

    public void b(final long r3, final String r5) {
        TeaThread.getInst().ensureTeaThread(new AnonymousClass5(this, r3, r5));
    }

    private void a(String r3) {
        Handler r2 = d();
        r2.removeMessages(1);
        r2.sendMessageDelayed(Message.obtain(r2, 1, r3), 5000);
    }

    private void g() {
        d().removeMessages(1);
    }

    public void b() {
        final long r0 = ad.a();
        TeaThread.getInst().ensureTeaThread(new AnonymousClass6(this, r0));
    }
}
