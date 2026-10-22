package b74;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Application.ActivityLifecycleCallbacks {
    public d() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        boolean r101 = e.f17947a;
        a r102 = e.f17949c;
        if (r102 != null) goto L5;
    L8:
        long r103 = SystemClock.elapsedRealtime();
        if ((r103 - e.f17948b) >= 800) goto L11;
        return;
    L11:
        e.f17948b = r103;
        com.bytedance.badger.e.f("CompensationManager", "onCompensate# onResume, start compensate...");
        Object r104 = e.f17950d;
        monitor-enter(r104);
        a r105 = e.f17949c;     // Catch: Throwable -> L30
        if (r105 != null) goto L16;
    L28:
        monitor-exit(r104);
        return;
    L16:
        if (r105.f17938a == false) goto L19;
        String r106 = "CompensationManager";
        String r107 = "executeCompensate## has finished,return";
    L21:
        com.bytedance.badger.e.f(r106, r107);     // Catch: Throwable -> L30
        goto L28
    L19:
        if (r105.f17939b == false) goto L22;
        r106 = "CompensationManager";
        r107 = "executeCompensate## compensate in process...return";
        goto L21
    L22:
        r105.f17939b = true;     // Catch: Throwable -> L30
        monitor-exit(r104);
        e.f17951e.a(new c(r105));     // Catch: Exception -> L26
        return;
    L26:
        e = move-exception;
        com.bytedance.badger.e.c("CompensationManager", "attemptCompensationIfNeeded# execute error", e);
        return;
    L30:
        th = move-exception;
        throw th;
    L5:
        if (r102.f17938a != true) goto L8;
        com.bytedance.badger.e.f("CompensationManager", "onCompensate# no need compensate!");
    }
}
