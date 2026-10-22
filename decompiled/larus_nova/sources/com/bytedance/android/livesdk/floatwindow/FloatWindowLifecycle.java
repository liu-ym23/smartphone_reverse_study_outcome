package com.bytedance.android.livesdk.floatwindow;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import rx1.d;
import rx1.g;

/* JADX INFO: loaded from: classes8.dex */
public class FloatWindowLifecycle extends BroadcastReceiver implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f125278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class[] f125279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f125280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f125281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f125282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f125283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f125284g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatWindowLifecycle f125285a;

        @Override // java.lang.Runnable
        public final void run() {
            FloatWindowLifecycle r100 = this.f125285a;     // Catch: Throwable -> L6
            if (r100.f125283f != 0) goto L9;
            r100.f125284g = true;     // Catch: Throwable -> L6
            ((g.a) r100.f125280c).a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(FloatWindowLifecycle r100) {
            this.f125285a = r100;
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
        this.f125283f--;
        this.f125281d.postDelayed(new a(this), 300);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        boolean r101 = true;
        this.f125283f++;
        Class[] r102 = this.f125279b;
        if (r102 == null) goto L12;
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        if (r102[r104].isInstance(r100) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        r101 = this.f125278a;
        goto L12
    L11:
        r101 = true ^ this.f125278a;
    L12:
        if (r101 == false) goto L14;
        this.f125280c.getClass();
    L16:
        if (this.f125284g == false) goto L21;
        this.f125284g = false;
        return;
    L21:
        return;
    L14:
        this.f125280c.getClass();
        goto L16
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        this.f125282e++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        int r101 = this.f125282e - 1;
        this.f125282e = r101;
        if (r101 != 0) goto L6;
        ((g.a) this.f125280c).a();
        return;
    }

    public FloatWindowLifecycle(Context r110, g.a r111) {
        this.f125278a = true;
        this.f125279b = null;
        this.f125280c = r111;
        this.f125281d = new Handler();
        ((Application) r110).registerActivityLifecycleCallbacks(this);
        if (Build.VERSION.SDK_INT < 34) goto L34;
        IntentFilter r112 = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L33;
        ReceiverRegisterCrashOptimizer.registerReceiver(this, r112, 4);
        return;
    L33:
        throw e;
    L9:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r112) == false) goto L20;
        int r100 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(this, r112, 4, null, null, 3, r110).result;     // Catch: Exception -> L29
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L67;
        r110.registerReceiver(this, r112, 4);     // Catch: Exception -> L29
    L67:
        return;
    L17:
        new Intent();     // Catch: Exception -> L29
        goto L67
    L18:
        r110.registerReceiver(this, r112, 4);     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r110.registerReceiver(this, r112, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L67
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r110.registerReceiver(this, r112, 4);     // Catch: Exception -> L29
        goto L67
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r112) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        ContextCompat.registerReceiver(r110, this, r112, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L29
        goto L67
    L34:
        IntentFilter r113 = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L65;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L65:
    L58:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L63;
        ReceiverRegisterCrashOptimizer.registerReceiver(this, r113);
        return;
    L63:
        throw e;
    L38:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L49;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r113) == false) goto L49;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(this, r113, 0, null, null, 2, r110).result;     // Catch: Exception -> L58
        if (r101 == 1) goto L47;
        if (r101 == 2) goto L46;
        if (r101 == 3) goto L64;
        r110.registerReceiver(this, r113);     // Catch: Exception -> L58
    L64:
        return;
    L46:
        new Intent();     // Catch: Exception -> L58
        goto L64
    L47:
        r110.registerReceiver(this, r113);     // Catch: Exception -> L58
    L49:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L52;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L58
        r110.registerReceiver(this, r113, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L58
        goto L64
    L52:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L54;
    L56:
        r110.registerReceiver(this, r113);     // Catch: Exception -> L58
        goto L64
    L54:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r113) == false) goto L56;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L58
        ContextCompat.registerReceiver(r110, this, r113, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L58
        goto L64
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
        ((g.a) this.f125280c).a();
        return;
    }
}
