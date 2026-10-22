package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.AbstractC1662c;
import com.google.android.gms.common.internal.AbstractC1665f;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Collections;
import java.util.Set;

/* renamed from: com.google.android.gms.common.api.internal.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ServiceConnectionC1645k implements a.f, ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final String f19630a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19631b;

    /* renamed from: c, reason: collision with root package name */
    public final ComponentName f19632c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f19633d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC1639e f19634e;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f19635f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC1646l f19636g;

    /* renamed from: h, reason: collision with root package name */
    public IBinder f19637h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f19638i;

    /* renamed from: j, reason: collision with root package name */
    public String f19639j;

    /* renamed from: k, reason: collision with root package name */
    public String f19640k;

    @Override // com.google.android.gms.common.api.a.f
    public final void a(String str) {
        q();
        this.f19639j = str;
        disconnect();
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean b() {
        q();
        return this.f19638i;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final String c() {
        String str = this.f19630a;
        if (str != null) {
            return str;
        }
        C1669j.k(this.f19632c);
        return this.f19632c.getPackageName();
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void d(AbstractC1662c.InterfaceC0227c interfaceC0227c) {
        q();
        String.valueOf(this.f19637h);
        if (j()) {
            try {
                a("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f19632c;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f19630a).setAction(this.f19631b);
            }
            boolean zBindService = this.f19633d.bindService(intent, this, AbstractC1665f.a());
            this.f19638i = zBindService;
            if (!zBindService) {
                this.f19637h = null;
                this.f19636g.onConnectionFailed(new ConnectionResult(16));
            }
            String.valueOf(this.f19637h);
        } catch (SecurityException e10) {
            this.f19638i = false;
            this.f19637h = null;
            throw e10;
        }
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void disconnect() {
        q();
        String.valueOf(this.f19637h);
        try {
            this.f19633d.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f19638i = false;
        this.f19637h = null;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean e() {
        return false;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean f() {
        return false;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final Set<Scope> g() {
        return Collections.EMPTY_SET;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void h(IAccountAccessor iAccountAccessor, Set<Scope> set) {
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void i(AbstractC1662c.e eVar) {
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean j() {
        q();
        return this.f19637h != null;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final int l() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final Feature[] m() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.api.a.f
    public final String n() {
        return this.f19639j;
    }

    public final /* synthetic */ void o(IBinder iBinder) {
        this.f19638i = false;
        this.f19637h = iBinder;
        String.valueOf(iBinder);
        this.f19634e.onConnected(new Bundle());
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        this.f19635f.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.X
            @Override // java.lang.Runnable
            public final void run() {
                this.f19581a.o(iBinder);
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f19635f.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.W
            @Override // java.lang.Runnable
            public final void run() {
                this.f19580a.zab();
            }
        });
    }

    public final void p(String str) {
        this.f19640k = str;
    }

    public final void q() {
        if (Thread.currentThread() != this.f19635f.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    public final /* synthetic */ void zab() {
        this.f19638i = false;
        this.f19637h = null;
        this.f19634e.onConnectionSuspended(1);
    }
}
