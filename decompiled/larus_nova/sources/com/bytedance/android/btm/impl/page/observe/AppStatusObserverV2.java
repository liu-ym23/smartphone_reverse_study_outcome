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
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AppStatusObserverV2 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<Activity> f42376a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Activity, Object> f42377b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static f<Activity> f42378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WeakHashMap<Activity, Object> f42379d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f42380e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final WeakHashMap<a, Object> f42381f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f42382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f42383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<Long, Long> f42384i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AppStatusObserverV2 f42385j = null;

    public AppStatusObserverV2() {
    }

    @Override // gd.b
    public final synchronized Activity getTopActivity() {
        monitor-enter(this);
        f<Activity> r100 = f42378c;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        Activity r101 = r100.get();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = null;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    static {
        f42385j = new AppStatusObserverV2();
        f42376a = new LinkedList();
        f42377b = new WeakHashMap();
        f42379d = new WeakHashMap();
        f42380e = new Object();
        f42381f = new WeakHashMap();
        f42384i = Collections.synchronizedMap(new AppStatusObserverV2$switchTimeMap$1());
    }

    @Override // gd.b
    public final Set<Activity> i() {
        return f42379d.keySet();
    }

    @Override // gd.b
    public final boolean isAppBackground() {
        Boolean r100 = f42382g;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        LinkedList<Activity> r101 = f42376a;
        r101.remove(r100);
        r101.size();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        f42378c = null;
        f42379d.remove(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        f42378c = new f(r100);
        f42379d.put(r100, f42380e);
        Boolean r101 = f42382g;
        if (r101 != null) goto L8;
        f42382g = Boolean.FALSE;
        f42383h = System.currentTimeMillis();
        d r102 = d.f42499a;
        Map<Long, Long> r103 = f42384i;
        Map.Entry r104 = d.a(r103);
        if (r104 == null) goto L18;
        Object r105 = r104.getKey();
        Long r106 = (Long) r105;
        r103.put(r106, Long.valueOf(f42383h));
        return;
    L18:
        return;
    L8:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L21;
        f42382g = Boolean.FALSE;
        f42383h = System.currentTimeMillis();
        d r107 = d.f42499a;
        Map<Long, Long> r108 = f42384i;
        Map.Entry r109 = d.a(r108);
        if (r109 == null) goto L12;
        Object r110 = r109.getKey();
        Long r111 = (Long) r110;
        r108.put(r111, Long.valueOf(f42383h));
    L12:
        WeakHashMap<a, Object> r112 = f42381f;
        if (r112.isEmpty() == true) goto L22;
        Iterator<a> r113 = r112.keySet().iterator();
    L16:
        if (r113.hasNext() == false) goto L23;
        r113.next().a(r100);
        goto L16
    L23:
        return;
    L22:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        f42377b.put(r100, f42380e);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        WeakHashMap<Activity, Object> r101 = f42377b;
        r101.remove(r100);
        if (Intrinsics.areEqual(f42382g, Boolean.FALSE) == true) goto L5;
        return;
    L5:
        if (r101.isEmpty() == false) goto L14;
        f42382g = Boolean.TRUE;
        long r102 = System.currentTimeMillis();
        f42384i.put(Long.valueOf(r102), 0L);
        WeakHashMap<a, Object> r103 = f42381f;
        if (r103.isEmpty() == true) goto L15;
        Iterator<a> r104 = r103.keySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L16;
        r104.next().b(r100);
        goto L10
    L16:
        return;
    L15:
        return;
    }

    @Override // gd.b
    public final void q(a r100) {
        if (r100 == null) goto L7;
        WeakHashMap<a, Object> r101 = f42381f;
        if (r101.containsKey(r100) == true) goto L8;
        r101.put(r100, f42380e);
        return;
    L8:
        return;
    }

    @Override // gd.b
    public final ConcurrentHashMap<Long, Long> l(long r100, long r110) {
        ConcurrentHashMap<Long, Long> r101 = new ConcurrentHashMap();
        Iterator<Map.Entry<Long, Long>> r102 = f42384i.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<Long, Long> r103 = r102.next();
        if (r103.getKey().longValue() <= r100) goto L4;
        if (r103.getKey().longValue() >= r110) goto L4;
        if (r103.getValue().longValue() <= 0) goto L4;
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L12:
        return r101;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        LinkedList<Activity> r102 = f42376a;
        r102.remove(r100);
        r102.add(r100);
        SystemClock.elapsedRealtime();
    }
}
