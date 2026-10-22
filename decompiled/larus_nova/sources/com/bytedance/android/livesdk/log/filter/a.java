package com.bytedance.android.livesdk.log.filter;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a<T> implements o<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f153291b;

    @Override // com.bytedance.android.livesdk.log.filter.o
    public void setData(T r100) {
    }

    public a() {
        this.f153291b = Collections.synchronizedMap(new HashMap());
    }

    private static boolean H() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final Map<String, String> getMap() {
        return this.f153291b;
    }

    public final void I(Map<String, String> r100) {
        if (r100 == null) goto L19;
        Map<String, String> r101 = this.f153291b;
        monitor-enter(r101);
        Iterator<Map.Entry<String, String>> r102 = this.f153291b.entrySet().iterator();     // Catch: Throwable -> L16
    L7:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r102.next();     // Catch: Throwable -> L16
        String r104 = r103.getKey();     // Catch: Throwable -> L16
        String r105 = r103.getValue();     // Catch: Throwable -> L16
        String r106 = r100.get(r104);     // Catch: Throwable -> L16
        if (r100.containsKey(r104) == false) goto L13;
        if (r106 == null) goto L13;
        if (r106.isEmpty() == false) goto L7;
    L13:
        r100.put(r104, r105);     // Catch: Throwable -> L16
        goto L7
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public void a(Map<String, String> r100) {
        if (com.bytedance.android.livesdk.log.u.j() == true) goto L8;
        if (H() == true) goto L8;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L8:
        if (com.bytedance.android.livesdk.d0.f121928a.getValue().booleanValue() == false) goto L10;
        I(r100);
        return;
    L10:
        if (r100 == null) goto L14;
        r100.putAll(this.f153291b);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void putAll(Map<String, String> r100) {
        if (com.bytedance.android.livesdk.log.u.j() == false) goto L5;
    L7:
        this.f153291b.putAll(r100);
        return;
    L5:
        if (H() == true) goto L7;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
        goto L7
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void remove(String r100) {
        this.f153291b.remove(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void c(String r100, String r101) {
        if (com.bytedance.android.livesdk.log.u.j() == false) goto L5;
    L7:
        this.f153291b.put(r100, r101);
        return;
    L5:
        if (H() == true) goto L7;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
        goto L7
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public void u(Map<String, String> r100, T r101) {
        if (com.bytedance.android.livesdk.log.u.j() == true) goto L8;
        if (H() == true) goto L8;
        ww2.a.a("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L8:
        if (com.bytedance.android.livesdk.d0.f121928a.getValue().booleanValue() == false) goto L10;
        I(r100);
        return;
    L10:
        if (r100 == null) goto L14;
        r100.putAll(this.f153291b);
        return;
    }
}
