package com.bytedance.watson.assist.b.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import com.bytedance.watson.assist.a.c;
import com.bytedance.watson.assist.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BatteryInfoManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PowerManager f11824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BatteryManager f11825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11826e;
    private int f;
    private int g;
    private float h;
    private long i;

    public a(Context r3, c r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin"));
        this.f11826e = false;
        this.f = -1;
        this.g = 0;
        this.h = 0.0f;
        this.i = 0;
        this.f11824c = (PowerManager) ZeusTransformUtils.preCheckCast(this.f11822a.getSystemService("power"), PowerManager.class, "com.obric.aiagent.plugin");
        this.f11825d = (BatteryManager) ZeusTransformUtils.preCheckCast(this.f11822a.getSystemService("batterymanager"), BatteryManager.class, "com.obric.aiagent.plugin");
    }

    public boolean b() {
        g();
        return this.f11826e;
    }

    public int c() {
        return f();
    }

    private int f() {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        PowerManager r2 = this.f11824c;
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.isPowerSaveMode() ? 1 : 0;
    L8:
        return -1;
    }

    public int d() {
        g();
        return this.g;
    }

    public float e() {
        g();
        return this.h;
    }

    private synchronized void g() {
        monitor-enter(this);
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L23
        long r2 = this.i;     // Catch: Throwable -> L23
        if (r2 != 0) goto L6;
    L7:
        this.i = r0;     // Catch: Throwable -> L23
        Intent r1 = ZeusTransformUtils.registerReceiver(this.f11822a, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r1 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        int r3 = r1.getIntExtra("status", -1);     // Catch: Throwable -> L23
        this.f = r3;     // Catch: Throwable -> L23
        if (r3 != 2) goto L14;
    L19:
        boolean r4 = true;
    L20:
        this.f11826e = r4;     // Catch: Throwable -> L23
        this.g = r1.getIntExtra("level", 0);     // Catch: Throwable -> L23
        this.h = r1.getIntExtra("temperature", 0) / 10.0f;     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L14:
        if (r3 == 5) goto L16;
    L18:
        r4 = false;
        goto L20
    L16:
        if (h() == false) goto L18;
    L6:
        if ((r0 - r2) < 5000) goto L21;
    L23:
        th = move-exception;
        throw th;
    }

    private boolean h() {
        if (Build.VERSION.SDK_INT < 23) goto L8;
        BatteryManager r2 = this.f11825d;
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isCharging();
    L8:
        return false;
    }
}
