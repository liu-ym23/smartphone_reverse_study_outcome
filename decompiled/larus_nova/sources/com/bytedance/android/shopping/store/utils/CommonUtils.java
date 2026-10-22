package com.bytedance.android.shopping.store.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class CommonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f186901a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f186902a;

        public a(Function0 r100) {
            this.f186902a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f186902a.invoke();     // Catch: Throwable -> L4
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
        public final /* synthetic */ Function0 f186903a;

        public b(Function0 r100) {
            this.f186903a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f186903a.invoke();     // Catch: Throwable -> L4
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
        public final /* synthetic */ Function0 f186904a;

        public c(Function0 r100) {
            this.f186904a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f186904a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f186901a = new Handler(Looper.getMainLooper());
    }

    public static Activity a() {
        IHybridHostService r100 = com.bytedance.android.ec.hybrid.a.h();
        if (r100 == null) goto L7;
        yj.i r101 = r100.getIHybridHostAppInfo();
        if (r101 == null) goto L7;
        return r101.a();
    L7:
        return null;
    }

    public static boolean b() {
        return Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
    }

    public static void d(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (b() == false) goto L5;
        r100.invoke();
        return;
    L5:
        f186901a.postAtFrontOfQueue(new c(r100));
    }

    public static void c(boolean r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        if (b() == false) goto L5;
        r101.invoke();
        return;
    L5:
        if (r100 == false) goto L7;
        f186901a.postAtFrontOfQueue(new a(r101));
        return;
    L7:
        f186901a.post(new b(r101));
    }

    public static void e(boolean r100, final Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        c(r100, new CommonUtils$safeRunOnMainThread$1(r101));
    }
}
