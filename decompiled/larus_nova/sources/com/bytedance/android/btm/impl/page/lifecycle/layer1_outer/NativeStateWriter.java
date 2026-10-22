package com.bytedance.android.btm.impl.page.lifecycle.layer1_outer;

import android.os.SystemClock;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.c;
import com.bytedance.android.btm.impl.util.f;

/* JADX INFO: loaded from: classes43.dex */
public final class NativeStateWriter {
    static {
    }

    public static void b(Object r100) {
        String r101 = BtmPageRecorder.f42212a;
        PageInfoStack r102 = BtmPageRecorder.k(r100);
        if (r102 == null) goto L5;
        r102.setNativeState(BtmPageLifecycle.State.CREATED);
        a("onCreated", r100);
    L5:
        c r103 = BtmPageRecorder.h(r100);
        if (r103 == null) goto L9;
        r103.f42334b = BtmPageLifecycle.State.CREATED;
        return;
    }

    public static void c(Object r100) {
        String r101 = BtmPageRecorder.f42212a;
        PageInfoStack r102 = BtmPageRecorder.k(r100);
        if (r102 == null) goto L5;
        r102.setNativeState(BtmPageLifecycle.State.DESTROYED);
        a("onDestroyed", r100);
    L5:
        if (r100 == null) goto L9;
        BtmPageRecorder.f42217f.remove(new f(r100));
        return;
    }

    public static void d(Object r100) {
        String r101 = BtmPageRecorder.f42212a;
        PageInfoStack r102 = BtmPageRecorder.k(r100);
        if (r102 == null) goto L5;
        r102.setNativeState(BtmPageLifecycle.State.PAUSED);
        a("onPaused", r100);
    L5:
        c r103 = BtmPageRecorder.h(r100);
        if (r103 == null) goto L9;
        r103.f42334b = BtmPageLifecycle.State.PAUSED;
        r103.f42333a = 0;
        return;
    }

    public static void e(Object r100) {
        String r101 = BtmPageRecorder.f42212a;
        PageInfoStack r102 = BtmPageRecorder.k(r100);
        if (r102 == null) goto L5;
        r102.setNativeState(BtmPageLifecycle.State.RESUMED);
        a("onResumed", r100);
    L5:
        c r103 = BtmPageRecorder.h(r100);
        if (r103 == null) goto L9;
        r103.f42334b = BtmPageLifecycle.State.RESUMED;
        r103.f42333a = SystemClock.elapsedRealtime();
        return;
    }

    public static void a(String r100, Object r101) {
        final String r102 = r101.getClass().getCanonicalName();
        ALogger.e(ALogger.f41996d, "NativeStateWriter_".concat(r100), new NativeStateWriter$log$1(r102));
    }
}
