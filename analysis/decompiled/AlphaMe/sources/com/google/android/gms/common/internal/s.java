package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import d1.C0535a;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class s implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f9837a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f9838b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9839c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f9840d;

    /* renamed from: e, reason: collision with root package name */
    public final r f9841e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f9842f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ u f9843g;

    public s(u uVar, r rVar) {
        this.f9843g = uVar;
        this.f9841e = rVar;
    }

    public final void a(String str) {
        this.f9838b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        try {
            u uVar = this.f9843g;
            C0535a c0535a = uVar.f9854d;
            Context context = uVar.f9852b;
            boolean zB = c0535a.b(context, str, this.f9841e.a(context), this, this.f9841e.f9835c);
            this.f9839c = zB;
            if (zB) {
                this.f9843g.f9853c.sendMessageDelayed(this.f9843g.f9853c.obtainMessage(1, this.f9841e), this.f9843g.f9856f);
            } else {
                this.f9838b = 2;
                try {
                    u uVar2 = this.f9843g;
                    uVar2.f9854d.a(uVar2.f9852b, this);
                } catch (IllegalArgumentException unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        } catch (Throwable th) {
            StrictMode.setVmPolicy(vmPolicy);
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f9843g.f9851a) {
            try {
                this.f9843g.f9853c.removeMessages(1, this.f9841e);
                this.f9840d = iBinder;
                this.f9842f = componentName;
                Iterator it = this.f9837a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f9838b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f9843g.f9851a) {
            try {
                this.f9843g.f9853c.removeMessages(1, this.f9841e);
                this.f9840d = null;
                this.f9842f = componentName;
                Iterator it = this.f9837a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f9838b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
