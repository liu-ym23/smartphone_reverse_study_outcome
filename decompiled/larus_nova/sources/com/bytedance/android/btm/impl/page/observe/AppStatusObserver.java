package com.bytedance.android.btm.impl.page.observe;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.btm.impl.util.d;
import com.bytedance.android.btm.impl.util.f;
import gd.a;
import gd.b;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class AppStatusObserver implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<a> f42369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f42370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f<Activity> f42371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f42372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile int f42373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<Long, Long> f42374f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AppStatusObserver f42375g = null;

    public AppStatusObserver() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    static {
        f42375g = new AppStatusObserver();
        f42369a = new LinkedHashSet();
        f42373e = -1;
        f42374f = Collections.synchronizedMap(new AppStatusObserver$switchTimeMap$1());
    }

    @Override // gd.b
    public final Activity getTopActivity() {
        f<Activity> r100 = f42371c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // gd.b
    public final Set<Activity> i() {
        return new LinkedHashSet();
    }

    @Override // gd.b
    public final boolean isAppBackground() {
        if (f42373e != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        if (f42370b != 0) goto L5;
        f42370b = r100.hashCode();
    L5:
        f42371c = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        f42373e = 1;
        int r101 = f42370b;
        f42370b = r100.hashCode();
        f42371c = new f(r100);
        if (r101 != 0) goto L17;
        f42373e = 1;
        f42372d = System.currentTimeMillis();
        Map<Long, Long> r102 = f42374f;
        monitor-enter(r102);
        d r103 = d.f42499a;     // Catch: Throwable -> L14
        Map.Entry r104 = d.a(r102);     // Catch: Throwable -> L14
        if (r104 == null) goto L9;
        Object r105 = r104.getKey();     // Catch: Throwable -> L14
        Long r106 = (Long) r105;
        r102.put(r106, Long.valueOf(f42372d));     // Catch: Throwable -> L14
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L9:
        monitor-exit(r102);
        Iterator<T> r108 = f42369a.iterator();
    L12:
        if (r108.hasNext() == false) goto L21;
        ((a) r108.next()).a(r100);
        goto L12
    L21:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        if (r100.hashCode() != f42370b) goto L8;
        f42370b = 0;
        f42373e = 0;
        long r101 = System.currentTimeMillis();
        f42374f.put(Long.valueOf(r101), 0L);
        Iterator<T> r102 = f42369a.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((a) r102.next()).b(r100);
        goto L6
    L10:
        return;
    }

    @Override // gd.b
    public final void q(a r100) {
        if (r100 == null) goto L5;
        f42369a.add(r100);
        return;
    }

    @Override // gd.b
    public final ConcurrentHashMap<Long, Long> l(long r110, long r111) {
        ConcurrentHashMap<Long, Long> r100 = new ConcurrentHashMap();
        Map<Long, Long> r101 = f42374f;
        monitor-enter(r101);
        Iterator<Map.Entry<Long, Long>> r102 = r101.entrySet().iterator();     // Catch: Throwable -> L17
    L6:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<Long, Long> r103 = r102.next();     // Catch: Throwable -> L17
        if (r103.getKey().longValue() <= r110) goto L6;
        if (r103.getKey().longValue() >= r111) goto L6;
        if (r103.getValue().longValue() <= 0) goto L6;
        r100.put(r103.getKey(), r103.getValue());     // Catch: Throwable -> L17
        goto L6
    L14:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r101);
        return r100;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        SystemClock.elapsedRealtime();
    }
}
