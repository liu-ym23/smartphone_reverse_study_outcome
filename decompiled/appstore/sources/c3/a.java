package c3;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks, ActivityLifecycleService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f6036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f6040f;

    public a() {
        this.f6035a = new ArrayList();
        this.f6037c = null;
        Application r10 = r3.a.b();
        r10.unregisterActivityLifecycleCallbacks(this);
        r10.registerActivityLifecycleCallbacks(this);
    }

    public final Object[] a() {
        ArrayList r10 = this.f6035a;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f6035a.size() <= 0) goto L9;
        Object[] r11 = this.f6035a.toArray();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L7
        if (r11 == null) goto L13;
        return r11;
    L13:
        return new Object[0];
    L9:
        r11 = null;
        goto L10
    }

    public final void b(Activity r10) {
        Object[] r11 = a();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifecycleObserver) r11[r13]).onBackground(r10);
        r13 = r13 + 1;
        goto L3
    }

    public final void c(Activity r10) {
        Object[] r11 = a();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifecycleObserver) r11[r13]).onFront(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public String getTopActivityClassName() {
        WeakReference r10 = this.f6036b;
        if (r10 != null) goto L5;
        return "";
    L5:
        Activity r11 = (Activity) r10.get();
        if (r11 == null) goto L11;
        String r12 = this.f6037c;
        if (r12 == null) goto L10;
        return r12;
    L10:
        return r11.getClass().getCanonicalName();
    L11:
        return "";
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public boolean isForeground() {
        return this.f6040f;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
        Object[] r12 = a();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        ((IActivityLifecycleObserver) r12[r14]).onActivityCreated(r10);
        r14 = r14 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        Object[] r11 = a();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifecycleObserver) r11[r13]).onActivityPause(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        this.f6036b = new WeakReference(r10);
        this.f6037c = null;
        Object[] r11 = a();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifecycleObserver) r11[r13]).onActivityResume(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
        Object[] r11 = a();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        ((IActivityLifecycleObserver) r11[r13]).onActivityStarted(r10);
        r13 = r13 + 1;
        goto L3
    L6:
        if (this.f6038d == false) goto L9;
        this.f6038d = false;
        return;
    L9:
        int r14 = this.f6039e + 1;
        this.f6039e = r14;
        if (r14 != 1) goto L14;
        this.f6040f = true;
        c(r10);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
        if (r10.isChangingConfigurations() == false) goto L6;
        this.f6038d = true;
        return;
    L6:
        int r11 = this.f6039e - 1;
        this.f6039e = r11;
        if (r11 != 0) goto L10;
        this.f6040f = false;
        b(r10);
        return;
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public void register(IActivityLifecycleObserver r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList r11 = this.f6035a;
        monitor-enter(r11);
        this.f6035a.add(r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public void unregister(IActivityLifecycleObserver r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList r11 = this.f6035a;
        monitor-enter(r11);
        this.f6035a.remove(r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
