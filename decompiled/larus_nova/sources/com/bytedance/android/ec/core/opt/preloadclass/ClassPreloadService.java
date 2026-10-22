package com.bytedance.android.ec.core.opt.preloadclass;

import android.os.Handler;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.plugin.e;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import s83.g;

/* JADX INFO: loaded from: classes43.dex */
public final class ClassPreloadService implements com.bytedance.android.ec.sdk.plugin.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f45275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45276b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClassPreloadService f45277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f45278b;

        public a(ClassPreloadService r100, int r101) {
            this.f45277a = r100;
            this.f45278b = r101;
        }

        public final void a() {
            dm.a.b r100 = dm.a.f469202a;
            this.f45277a.getClass();
            dm.a.a("ClassPreloadService").i("realPreload: 阶段" + this.f45278b + " 开始 " + this.f45277a.getClass().getClassLoader());
            long r101 = System.currentTimeMillis();
            this.f45277a.getClass();     // Catch: Exception -> L5
            dm.a.a("ClassPreloadService").i("realPreload: 阶段" + this.f45278b + " class数量0 耗时" + (System.currentTimeMillis() - r101));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            dm.a.b r102 = dm.a.f469202a;
            this.f45277a.getClass();
            dm.a.a("ClassPreloadService").b("realPreload: " + this.f45278b + ' ' + e.getMessage(), null);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClassPreloadService f45279a;

        public b(ClassPreloadService r100) {
            this.f45279a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ClassPreloadService.c(this.f45279a, 2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClassPreloadService f45280a;

        public c(ClassPreloadService r100) {
            this.f45280a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ClassPreloadService.c(this.f45280a, 1);     // Catch: Throwable -> L6
            this.f45280a.getClass();     // Catch: Throwable -> L6
            if (ClassPreloadService.e() != 1) goto L9;
            ClassPreloadService.c(this.f45280a, 2);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClassPreloadService f45281a;

        public d(ClassPreloadService r100) {
            this.f45281a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ClassPreloadService.c(this.f45281a, 2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static int e() {
        int r100 = ECSdk.f48106a;
        g r101 = (g) ECSdk.a(g.class);
        if (r101 == null) goto L7;
        s83.a r102 = r101.q();
        if (r102 == null) goto L7;
        return r102.c();
    L7:
        return 0;
    }

    @Override // com.bytedance.android.ec.sdk.plugin.c
    public final void a() {
        dm.a.a("ClassPreloadService").i("preloadClassOnScene: 实验value " + e());
        if (d() == true) goto L7;
        dm.a.a("ClassPreloadService").i("preloadOnClodLaunch: plugin not ready");
        return;
    L7:
        if (e() != 3) goto L10;
        ((Handler) this.f45275a.getValue()).postDelayed(new b(this), 3000);
        return;
    }

    @Override // com.bytedance.android.ec.sdk.plugin.c
    public final synchronized void b() {
        monitor-enter(this);
        dm.a.a("ClassPreloadService").i("preloadOnClodLaunch: 实验value " + e());     // Catch: Throwable -> L17
        if (d() == true) goto L10;
        dm.a.a("ClassPreloadService").i("preloadOnClodLaunch: plugin not ready");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        if (e() == 0) goto L13;
        ((Handler) this.f45275a.getValue()).postDelayed(new c(this), 5000);     // Catch: Throwable -> L17
    L13:
        if (e() != 2) goto L15;
        ((Handler) this.f45275a.getValue()).postDelayed(new d(this), 15000);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public ClassPreloadService() {
        this.f45275a = LazyKt.lazy(ClassPreloadService$handler$2.INSTANCE);
    }

    public static boolean d() {
        if (e.a() == false) goto L16;
        boolean r100 = ECServiceManager.f42805a;
        hj.c r101 = (hj.c) ECServiceManager.b(hj.c.class);
        if (r101 != null) goto L7;
        boolean r102 = false;
    L8:
        if (r102 == false) goto L17;
        hj.c r103 = (hj.c) ECServiceManager.b(hj.c.class);
        if (r103 != null) goto L12;
        boolean r104 = false;
    L13:
        if (r104 == false) goto L18;
        return true;
    L18:
        return false;
    L12:
        r104 = r103.c();
        goto L13
    L17:
        return false;
    L7:
        r102 = r101.b();
        goto L8
    L16:
        return false;
    }

    public final synchronized void f(int r100) {
        monitor-enter(this);
        this.f45276b |= r100;     // Catch: Throwable -> L6
        ThreadPlus.submitRunnable(new a(this, r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static final void c(ClassPreloadService r100, int r101) {
        monitor-enter(r100);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (d() == true) goto L9;
        dm.a.a("ClassPreloadService").i("preloadOnClodLaunch: plugin not ready");     // Catch: Throwable -> L32
        monitor-exit(r100);
        return;
    L9:
        dm.a.a("ClassPreloadService").i("tryPreload: 实验value " + e());     // Catch: Throwable -> L32
        boolean r102 = false;
        if (r101 != 1) goto L18;
        if ((r100.f45276b & 1) <= 0) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L18;
        r100.f(1);     // Catch: Throwable -> L32
        goto L18
    L14:
        r103 = false;
    L18:
        if (r101 != 2) goto L30;
        int r104 = r100.f45276b;     // Catch: Throwable -> L32
        if ((r104 & 2) <= 0) goto L22;
        boolean r105 = true;
    L23:
        if (r105 == true) goto L30;
        if ((r104 & 1) <= 0) goto L27;
        r102 = true;
    L27:
        if (r102 == true) goto L29;
        ((Handler) r100.f45275a.getValue()).removeCallbacksAndMessages(null);     // Catch: Throwable -> L32
        r100.f(1);     // Catch: Throwable -> L32
        ((Handler) r100.f45275a.getValue()).postDelayed(new com.bytedance.android.ec.core.opt.preloadclass.a(r100), 2000);     // Catch: Throwable -> L32
        goto L30
    L29:
        r100.f(2);     // Catch: Throwable -> L32
        goto L30
    L22:
        r105 = false;
    L30:
        monitor-exit(r100);
    }
}
