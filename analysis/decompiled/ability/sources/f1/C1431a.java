package f1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import g1.AbstractC1451a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import m1.b;

/* renamed from: f1.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1431a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4433a = new ArrayList();
    public WeakReference b;
    public boolean c;
    public int d;
    public volatile boolean e;

    public C1431a() {
        Application application = AbstractC1451a.b;
        application.unregisterActivityLifecycleCallbacks(this);
        application.registerActivityLifecycleCallbacks(this);
    }

    public final Object[] a() {
        Object[] array;
        synchronized (this.f4433a) {
            try {
                array = this.f4433a.size() > 0 ? this.f4433a.toArray() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return array == null ? new Object[0] : array;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        for (Object obj : a()) {
            ((b) obj).getClass();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        for (Object obj : a()) {
            ((b) obj).getClass();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.b = new WeakReference(activity);
        for (Object obj : a()) {
            ((b) obj).getClass();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        for (Object obj : a()) {
            ((b) obj).getClass();
        }
        if (this.c) {
            this.c = false;
            return;
        }
        int i = this.d + 1;
        this.d = i;
        if (i == 1) {
            this.e = true;
            for (Object obj2 : a()) {
                ((b) obj2).c();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.c = true;
            return;
        }
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            this.e = false;
            for (Object obj : a()) {
                ((b) obj).b();
            }
        }
    }
}
