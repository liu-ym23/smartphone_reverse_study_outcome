package com.amap.api.col.jmsl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;

/* renamed from: com.amap.api.col.jmsl.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1530a implements H1 {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1552f1 f16505a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16506b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16507c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16508d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16509e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16510f = false;

    /* renamed from: com.amap.api.col.jmsl.a$a, reason: collision with other inner class name */
    public class HandlerC0203a extends Handler {
        public HandlerC0203a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                InterfaceC1552f1 unused = C1530a.this.f16505a;
            }
        }
    }

    public C1530a(InterfaceC1552f1 interfaceC1552f1) {
        new HandlerC0203a(Looper.getMainLooper());
        this.f16505a = interfaceC1552f1;
    }

    @Override // com.amap.api.col.jmsl.H1
    public void a(boolean z10) {
    }

    @Override // com.amap.api.col.jmsl.H1
    public void b(boolean z10) throws RemoteException {
        this.f16510f = z10;
        this.f16505a.l().m(z10);
    }

    @Override // com.amap.api.col.jmsl.H1
    public void c(boolean z10) throws RemoteException {
        this.f16506b = z10;
        this.f16505a.l().v(this.f16506b);
    }

    @Override // com.amap.api.col.jmsl.H1
    public boolean e() throws RemoteException {
        return this.f16508d;
    }

    @Override // com.amap.api.col.jmsl.H1
    public boolean g() throws RemoteException {
        return this.f16509e;
    }

    @Override // com.amap.api.col.jmsl.H1
    public void i(boolean z10) throws RemoteException {
        this.f16508d = z10;
        this.f16505a.l().x(this.f16508d);
    }

    @Override // com.amap.api.col.jmsl.H1
    public void j(boolean z10) throws RemoteException {
        this.f16509e = z10;
        this.f16505a.l().z(z10);
    }

    @Override // com.amap.api.col.jmsl.H1
    public void k(boolean z10) throws RemoteException {
        this.f16506b = z10;
        this.f16505a.l().v(this.f16506b);
        this.f16508d = z10;
        this.f16505a.l().x(this.f16508d);
        this.f16509e = z10;
        this.f16505a.l().z(z10);
        this.f16507c = z10;
        this.f16505a.l().w(z10);
    }

    @Override // com.amap.api.col.jmsl.H1
    public void l(boolean z10) throws RemoteException {
        this.f16507c = z10;
        this.f16505a.l().w(z10);
    }

    @Override // com.amap.api.col.jmsl.H1
    public boolean a() throws RemoteException {
        return this.f16507c;
    }

    @Override // com.amap.api.col.jmsl.H1
    public boolean b() throws RemoteException {
        return this.f16506b;
    }

    @Override // com.amap.api.col.jmsl.H1
    public boolean c() throws RemoteException {
        return this.f16510f;
    }
}
