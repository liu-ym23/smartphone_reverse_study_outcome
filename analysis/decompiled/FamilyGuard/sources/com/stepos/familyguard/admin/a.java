package com.stepos.familyguard.admin;

import N1.h;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import h2.RunnableC0749a;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f14726g = {0, 300, 1000, 3000};

    /* renamed from: h, reason: collision with root package name */
    private static volatile a f14727h;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f14730c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f14731d;

    /* renamed from: e, reason: collision with root package name */
    private int f14732e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f14733f = new RunnableC0749a(this);

    /* renamed from: a, reason: collision with root package name */
    private final DevicePolicyManager f14728a = (DevicePolicyManager) P1.a.a().getSystemService("device_policy");

    /* renamed from: b, reason: collision with root package name */
    private final ComponentName f14729b = new ComponentName(P1.a.a(), (Class<?>) AdminReceiver.class);

    private a() {
        this.f14731d = false;
        this.f14731d = c();
        HandlerThread handlerThread = new HandlerThread("AdminController");
        handlerThread.start();
        this.f14730c = new Handler(handlerThread.getLooper());
    }

    public static a b() {
        if (f14727h == null) {
            synchronized (a.class) {
                try {
                    if (f14727h == null) {
                        f14727h = new a();
                    }
                } finally {
                }
            }
        }
        return f14727h;
    }

    private void g() {
        if (c()) {
            R1.a.e("AdminController", "removeActiveAdmin() called");
            try {
                DevicePolicyManager devicePolicyManager = this.f14728a;
                if (devicePolicyManager == null || this.f14729b == null) {
                    return;
                }
                h.b(devicePolicyManager).a("removeActiveAdmin", ComponentName.class).a(this.f14728a, this.f14729b);
            } catch (Exception e6) {
                R1.a.c("AdminController", "removeActiveAdmin failed", e6);
            }
        }
    }

    private void h() {
        if (this.f14731d) {
            if (c()) {
                R1.a.e("AdminController", "setAdminActive already active");
                return;
            }
            R1.a.e("AdminController", "setAdminActive() called, retry = " + this.f14732e);
            try {
                DevicePolicyManager devicePolicyManager = this.f14728a;
                if (devicePolicyManager != null && this.f14729b != null) {
                    h.b(devicePolicyManager).a("setActiveAdmin", ComponentName.class, Boolean.TYPE).a(this.f14728a, this.f14729b, Boolean.TRUE);
                }
            } catch (Exception e6) {
                R1.a.c("AdminController", "setAdminActive failed", e6);
            }
            if (c()) {
                R1.a.e("AdminController", "setAdminActive success");
                return;
            }
            int i5 = this.f14732e;
            int[] iArr = f14726g;
            if (i5 >= iArr.length - 1) {
                R1.a.b("AdminController", "setAdminActive failed after retries");
                return;
            }
            int i6 = i5 + 1;
            this.f14732e = i6;
            int i7 = iArr[i6];
            R1.a.l("AdminController", "setAdminActive retry in " + i7 + "ms");
            this.f14730c.postDelayed(this.f14733f, (long) i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f14731d) {
            h();
        } else {
            this.f14730c.removeCallbacks(this.f14733f);
            g();
        }
    }

    public boolean c() {
        ComponentName componentName;
        DevicePolicyManager devicePolicyManager = this.f14728a;
        return (devicePolicyManager == null || (componentName = this.f14729b) == null || !devicePolicyManager.isAdminActive(componentName)) ? false : true;
    }

    CharSequence d(Intent intent) {
        return null;
    }

    void e(Intent intent) {
        R1.a.a("AdminController", "onDisabled() called with: intent = [" + intent + "]");
        this.f14730c.postDelayed(new RunnableC0749a(this), 200L);
    }

    void f(Intent intent) {
        R1.a.a("AdminController", "onEnabled() called with: intent = [" + intent + "]");
    }

    public void i(boolean z5) {
        R1.a.e("AdminController", "setIsActive isActive = " + z5);
        this.f14730c.removeCallbacks(this.f14733f);
        this.f14731d = z5;
        this.f14732e = 0;
        this.f14730c.post(new RunnableC0749a(this));
    }
}
