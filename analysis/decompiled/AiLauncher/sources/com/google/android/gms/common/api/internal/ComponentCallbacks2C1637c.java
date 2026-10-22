package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.api.internal.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ComponentCallbacks2C1637c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e, reason: collision with root package name */
    public static final ComponentCallbacks2C1637c f19595e = new ComponentCallbacks2C1637c();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f19596a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f19597b = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f19598c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f19599d = false;

    /* renamed from: com.google.android.gms.common.api.internal.c$a */
    public interface a {
        void a(boolean z10);
    }

    public static ComponentCallbacks2C1637c b() {
        return f19595e;
    }

    public static void c(Application application) {
        ComponentCallbacks2C1637c componentCallbacks2C1637c = f19595e;
        synchronized (componentCallbacks2C1637c) {
            try {
                if (!componentCallbacks2C1637c.f19599d) {
                    application.registerActivityLifecycleCallbacks(componentCallbacks2C1637c);
                    application.registerComponentCallbacks(componentCallbacks2C1637c);
                    componentCallbacks2C1637c.f19599d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(a aVar) {
        synchronized (f19595e) {
            this.f19598c.add(aVar);
        }
    }

    public boolean d() {
        return this.f19596a.get();
    }

    @TargetApi(16)
    public boolean e(boolean z10) {
        if (!this.f19597b.get()) {
            if (!s2.j.a()) {
                return z10;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f19597b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f19596a.set(true);
            }
        }
        return d();
    }

    public final void f(boolean z10) {
        synchronized (f19595e) {
            try {
                Iterator it = this.f19598c.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(z10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f19597b;
        boolean zCompareAndSet = this.f19596a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f19597b;
        boolean zCompareAndSet = this.f19596a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        if (i10 == 20 && this.f19596a.compareAndSet(false, true)) {
            this.f19597b.set(true);
            f(true);
        }
    }
}
