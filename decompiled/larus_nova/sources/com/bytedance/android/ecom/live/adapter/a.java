package com.bytedance.android.ecom.live.adapter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.common.utility.collection.WeakContainer;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<Activity> f51165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f51166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedList<Activity> f51167c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WeakContainer<Activity> f51168d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final WeakContainer<b> f51169e = null;

    /* JADX INFO: renamed from: com.bytedance.android.ecom.live.adapter.a$a, reason: collision with other inner class name */
    public static class C0870a implements Application.ActivityLifecycleCallbacks {
        public C0870a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            monitor-enter(a.class);
            a.f51165a.remove(r100);     // Catch: Throwable -> L7
            monitor-exit(a.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            monitor-enter(a.class);
            a.f51167c.remove(r100);     // Catch: Throwable -> L7
            monitor-exit(a.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            monitor-enter(a.class);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (a.f51166b == false) goto L14;
            a.f51166b = false;     // Catch: Throwable -> L19
            WeakContainer<b> r101 = a.f51169e;     // Catch: Throwable -> L19
            if (r101.isEmpty() == true) goto L14;
            Iterator<b> r102 = r101.iterator();     // Catch: Throwable -> L19
        L10:
            if (r102.hasNext() == false) goto L14;
            b r103 = r102.next();     // Catch: Throwable -> L19
            if (r103 == null) goto L10;
            r103.onAppForeground();     // Catch: Throwable -> L19
        L14:
            LinkedList<Activity> r104 = a.f51167c;     // Catch: Throwable -> L19
            r104.remove(r100);     // Catch: Throwable -> L19
            r104.add(r100);     // Catch: Throwable -> L19
            monitor-exit(a.class);     // Catch: Throwable -> L19
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            monitor-enter(a.class);
            a.f51168d.add(r100);     // Catch: Throwable -> L7
            monitor-exit(a.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            monitor-enter(a.class);
            WeakContainer<Activity> r101 = a.f51168d;     // Catch: Throwable -> L18
            r101.remove(r100);     // Catch: Throwable -> L18
            if (a.f51166b == false) goto L7;
        L16:
            monitor-exit(a.class);     // Catch: Throwable -> L18
            return;
        L7:
            if (r101.isEmpty() == false) goto L16;
            a.f51166b = true;     // Catch: Throwable -> L18
            WeakContainer<b> r102 = a.f51169e;     // Catch: Throwable -> L18
            if (r102.isEmpty() == true) goto L16;
            Iterator<b> r103 = r102.iterator();     // Catch: Throwable -> L18
        L12:
            if (r103.hasNext() == false) goto L16;
            b r104 = r103.next();     // Catch: Throwable -> L18
            if (r104 == null) goto L12;
            r104.onAppBackground();     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            monitor-enter(a.class);
            LinkedList<Activity> r102 = a.f51165a;     // Catch: Throwable -> L7
            r102.remove(r100);     // Catch: Throwable -> L7
            r102.add(r100);     // Catch: Throwable -> L7
            monitor-exit(a.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public interface b {
        void onAppBackground();

        void onAppForeground();
    }

    static {
        f51165a = new LinkedList();
        f51166b = true;
        f51167c = new LinkedList();
        f51168d = new WeakContainer();
        f51169e = new WeakContainer();
    }

    public a() {
    }
}
