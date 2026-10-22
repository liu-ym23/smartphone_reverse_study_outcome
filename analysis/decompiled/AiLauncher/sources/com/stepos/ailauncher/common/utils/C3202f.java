package com.stepos.ailauncher.common.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3202f;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R,\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\"\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/common/utils/f;", "", "<init>", "()V", "Landroid/app/Application;", "app", "LY8/t;", "f", "(Landroid/app/Application;)V", "Ljava/util/concurrent/atomic/AtomicInteger;", "resumedCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/ArrayDeque;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", RobotInfo.STATUS_STARTED, "Ljava/util/ArrayDeque;", "Lkotlin/Function0;", "extraLookup", "Lp9/a;", "getExtraLookup", "()Lp9/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lp9/a;)V", "c", "()Landroid/app/Activity;", "topActivity", "", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "topActivityClassName", "", "e", "()Z", "isForeground", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.common.utils.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3202f {
    private static volatile InterfaceC5063a<? extends Activity> extraLookup;
    public static final C3202f INSTANCE = new C3202f();
    private static final AtomicInteger resumedCount = new AtomicInteger(0);
    private static final ArrayDeque<WeakReference<Activity>> started = new ArrayDeque<>();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"com/stepos/ailauncher/common/utils/f$a", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.utils.f$a */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final boolean e(Activity activity, WeakReference weakReference) {
            return weakReference.get() == null || weakReference.get() == activity;
        }

        public static final int f(int i10) {
            return C5685n.f(i10 - 1, 0);
        }

        public static final boolean g(Activity activity, WeakReference weakReference) {
            return weakReference.get() == null || weakReference.get() == activity;
        }

        public static final boolean h(Activity activity, WeakReference weakReference) {
            return weakReference.get() == null || weakReference.get() == activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(final Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            synchronized (C3202f.started) {
                Z8.A.J(C3202f.started, new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.utils.e
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(C3202f.a.e(activity, (WeakReference) obj));
                    }
                });
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            C3202f.resumedCount.updateAndGet(new IntUnaryOperator() { // from class: com.stepos.ailauncher.common.utils.c
                @Override // java.util.function.IntUnaryOperator
                public final int applyAsInt(int i10) {
                    return C3202f.a.f(i10);
                }
            });
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            C3202f.resumedCount.incrementAndGet();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(final Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            synchronized (C3202f.started) {
                Z8.A.J(C3202f.started, new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.utils.d
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(C3202f.a.g(activity, (WeakReference) obj));
                    }
                });
                C3202f.started.addLast(new WeakReference(activity));
                Y8.t tVar = Y8.t.f7040a;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(final Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            synchronized (C3202f.started) {
                Z8.A.J(C3202f.started, new InterfaceC5074l() { // from class: com.stepos.ailauncher.common.utils.b
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(C3202f.a.h(activity, (WeakReference) obj));
                    }
                });
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        r0 = Y8.t.f7040a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        r3 = com.stepos.ailauncher.common.utils.C3202f.extraLookup;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r3 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        r3 = r3.invoke();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r3 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        if (r3.isFinishing() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        if (r3.isDestroyed() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.app.Activity c() {
        /*
            r3 = this;
            java.util.ArrayDeque<java.lang.ref.WeakReference<android.app.Activity>> r3 = com.stepos.ailauncher.common.utils.C3202f.started
            monitor-enter(r3)
        L3:
            java.util.ArrayDeque<java.lang.ref.WeakReference<android.app.Activity>> r0 = com.stepos.ailauncher.common.utils.C3202f.started     // Catch: java.lang.Throwable -> L28
            boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> L28
            if (r1 != 0) goto L2e
            java.lang.Object r1 = Z8.F.B0(r0)     // Catch: java.lang.Throwable -> L28
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch: java.lang.Throwable -> L28
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L28
            android.app.Activity r1 = (android.app.Activity) r1     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L2a
            boolean r2 = r1.isFinishing()     // Catch: java.lang.Throwable -> L28
            if (r2 != 0) goto L2a
            boolean r2 = r1.isDestroyed()     // Catch: java.lang.Throwable -> L28
            if (r2 == 0) goto L26
            goto L2a
        L26:
            monitor-exit(r3)
            return r1
        L28:
            r0 = move-exception
            goto L4d
        L2a:
            r0.removeLast()     // Catch: java.lang.Throwable -> L28
            goto L3
        L2e:
            Y8.t r0 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L28
            monitor-exit(r3)
            p9.a<? extends android.app.Activity> r3 = com.stepos.ailauncher.common.utils.C3202f.extraLookup
            r0 = 0
            if (r3 == 0) goto L4c
            java.lang.Object r3 = r3.invoke()
            android.app.Activity r3 = (android.app.Activity) r3
            if (r3 == 0) goto L4c
            boolean r1 = r3.isFinishing()
            if (r1 != 0) goto L4c
            boolean r1 = r3.isDestroyed()
            if (r1 == 0) goto L4b
            goto L4c
        L4b:
            return r3
        L4c:
            return r0
        L4d:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.common.utils.C3202f.c():android.app.Activity");
    }

    public final String d() {
        Activity activityC = c();
        if (activityC != null) {
            return activityC.getClass().getName();
        }
        return null;
    }

    public final boolean e() {
        return resumedCount.get() > 0;
    }

    public final void f(Application app) {
        kotlin.jvm.internal.p.i(app, "app");
        app.registerActivityLifecycleCallbacks(new a());
    }

    public final void g(InterfaceC5063a<? extends Activity> interfaceC5063a) {
        extraLookup = interfaceC5063a;
    }
}
