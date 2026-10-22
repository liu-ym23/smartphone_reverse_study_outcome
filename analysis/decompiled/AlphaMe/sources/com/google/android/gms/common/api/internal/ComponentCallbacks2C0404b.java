package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import g1.HandlerC0575c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.api.internal.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ComponentCallbacks2C0404b implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e, reason: collision with root package name */
    public static final ComponentCallbacks2C0404b f9632e = new ComponentCallbacks2C0404b();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f9633a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f9634b = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f9635c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f9636d = false;

    public final void a(boolean z4) {
        synchronized (f9632e) {
            try {
                Iterator it = this.f9635c.iterator();
                while (it.hasNext()) {
                    HandlerC0575c handlerC0575c = ((o) it.next()).f9662a.f9653m;
                    handlerC0575c.sendMessage(handlerC0575c.obtainMessage(1, Boolean.valueOf(z4)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean zCompareAndSet = this.f9633a.compareAndSet(true, false);
        this.f9634b.set(true);
        if (zCompareAndSet) {
            a(false);
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
        boolean zCompareAndSet = this.f9633a.compareAndSet(true, false);
        this.f9634b.set(true);
        if (zCompareAndSet) {
            a(false);
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
    public final void onTrimMemory(int i4) {
        if (i4 == 20 && this.f9633a.compareAndSet(false, true)) {
            this.f9634b.set(true);
            a(true);
        }
    }
}
