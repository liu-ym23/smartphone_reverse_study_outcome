package com.bytedance.android.gamecp.business.floatwindow;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import ss.c;
import ss.e;

/* JADX INFO: loaded from: classes44.dex */
public class FloatWindowLifecycle extends BroadcastReceiver implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f53163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class[] f53164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f53165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f53166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f53167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f53168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f53169g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatWindowLifecycle f53170a;

        @Override // java.lang.Runnable
        public final void run() {
            FloatWindowLifecycle r100 = this.f53170a;     // Catch: Throwable -> L6
            if (r100.f53168f != 0) goto L9;
            r100.f53169g = true;     // Catch: Throwable -> L6
            ((e.a) r100.f53165c).a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(FloatWindowLifecycle r100) {
            this.f53170a = r100;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        this.f53168f--;
        this.f53166d.postDelayed(new a(this), 300);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        boolean r101 = true;
        this.f53168f++;
        Class[] r102 = this.f53164b;
        if (r102 == null) goto L12;
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        if (r102[r104].isInstance(r100) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        r101 = this.f53163a;
        goto L12
    L11:
        r101 = true ^ this.f53163a;
    L12:
        if (r101 == false) goto L14;
        this.f53165c.getClass();
    L16:
        if (this.f53169g == false) goto L21;
        this.f53169g = false;
        return;
    L21:
        return;
    L14:
        this.f53165c.getClass();
        goto L16
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        this.f53167e++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        int r101 = this.f53167e - 1;
        this.f53167e = r101;
        if (r101 != 0) goto L6;
        ((e.a) this.f53165c).a();
        return;
    }

    public FloatWindowLifecycle(Context r110, e.a r111) {
        this.f53163a = true;
        this.f53164b = null;
        this.f53165c = r111;
        this.f53166d = new Handler();
        ((Application) r110).registerActivityLifecycleCallbacks(this);
        IntentFilter r112 = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L34:
    L28:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L33;
        ReceiverRegisterCrashOptimizer.registerReceiver(this, r112);
        return;
    L33:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L19;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r112) == false) goto L19;
        int r100 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(this, r112, 0, null, null, 2, r110).result;     // Catch: Exception -> L28
        if (r100 != 1) goto L12;
        r110.registerReceiver(this, r112);     // Catch: Exception -> L28
        return;
    L12:
        if (r100 != 2) goto L14;
        new Intent();     // Catch: Exception -> L28
        return;
    L14:
        if (r100 == 3) goto L35;
        r110.registerReceiver(this, r112);     // Catch: Exception -> L28
        return;
    L35:
        return;
    L19:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L22;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L28
        r110.registerReceiver(this, r112, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L28
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L24;
    L26:
        r110.registerReceiver(this, r112);     // Catch: Exception -> L28
        return;
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r112) == false) goto L26;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L28
        ContextCompat.registerReceiver(r110, this, r112, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L28
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        String r102 = r101.getAction();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") == true) goto L7;
        return;
    L7:
        if ("homekey".equals(r101.getStringExtra("reason")) == false) goto L12;
        ((e.a) this.f53165c).a();
        return;
    }
}
