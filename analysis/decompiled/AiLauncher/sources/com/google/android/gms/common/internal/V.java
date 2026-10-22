package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class V implements ServiceConnection, Z {

    /* renamed from: a, reason: collision with root package name */
    public final Map f19754a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f19755b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19756c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f19757d;

    /* renamed from: e, reason: collision with root package name */
    public final U f19758e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f19759f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Y f19760g;

    public V(Y y10, U u10) {
        this.f19760g = y10;
        this.f19758e = u10;
    }

    public final int a() {
        return this.f19755b;
    }

    public final ComponentName b() {
        return this.f19759f;
    }

    public final IBinder c() {
        return this.f19757d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f19754a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        this.f19755b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (s2.j.i()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            Y y10 = this.f19760g;
            boolean zC = y10.f19766j.c(y10.f19763g, str, this.f19758e.b(y10.f19763g), this, 4225, executor);
            this.f19756c = zC;
            if (zC) {
                this.f19760g.f19764h.sendMessageDelayed(this.f19760g.f19764h.obtainMessage(1, this.f19758e), this.f19760g.f19768l);
            } else {
                this.f19755b = 2;
                try {
                    Y y11 = this.f19760g;
                    y11.f19766j.b(y11.f19763g, this);
                } catch (IllegalArgumentException unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        } catch (Throwable th) {
            StrictMode.setVmPolicy(vmPolicy);
            throw th;
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f19754a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f19760g.f19764h.removeMessages(1, this.f19758e);
        Y y10 = this.f19760g;
        y10.f19766j.b(y10.f19763g, this);
        this.f19756c = false;
        this.f19755b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f19754a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f19754a.isEmpty();
    }

    public final boolean j() {
        return this.f19756c;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f19760g.f19762f) {
            try {
                this.f19760g.f19764h.removeMessages(1, this.f19758e);
                this.f19757d = iBinder;
                this.f19759f = componentName;
                Iterator it = this.f19754a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f19755b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f19760g.f19762f) {
            try {
                this.f19760g.f19764h.removeMessages(1, this.f19758e);
                this.f19757d = null;
                this.f19759f = componentName;
                Iterator it = this.f19754a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f19755b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
