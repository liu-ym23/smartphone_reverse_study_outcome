package com.alipay.sdk.m.r0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes28.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f25748e = "OpenDeviceId library";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f25749f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alipay.sdk.m.q0.a f25751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ServiceConnection f25752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0492b f25753d;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f25754a;

        public a(b r100) {
            this.f25754a = r100;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
            b.a(this.f25754a, null);
            b.a(this.f25754a, "Service onServiceDisconnected");
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName r100, IBinder r101) {
            monitor-enter(this);
            b.a(this.f25754a, com.alipay.sdk.m.q0.a.AbstractBinderC0490a.a(r101));     // Catch: Throwable -> L9
            if (b.a(this.f25754a) == null) goto L6;
            b.a(this.f25754a).a("Deviceid Service Connected", this.f25754a);     // Catch: Throwable -> L9
        L6:
            b.a(this.f25754a, "Service onServiceConnected");     // Catch: Throwable -> L9
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.r0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0492b<T> {
        void a(T r100, b r101);
    }

    private void a(String r100) {
    }

    private void b(String r100) {
    }

    public boolean e() {
    L7:
        a("isSupport error, RemoteException!");
        return false;
    L4:
        if (this.f25751b == null) goto L11;
        b("Device support opendeviceid");     // Catch: RemoteException -> L7
        return this.f25751b.c();
    L11:
        return false;
    }

    public String a() {
        Context r100 = this.f25750a;
        if (r100 == null) goto L21;
        String r101 = r100.getPackageName();
        b("liufeng, getAAID package：" + r101);
        if (r101 != null) goto L7;
    L19:
        b("input package is null!");
        return null;
    L7:
        if (r101.equals("") == true) goto L19;
        com.alipay.sdk.m.q0.a r102 = this.f25751b;     // Catch: RemoteException -> L18
        if (r102 == null) goto L25;
        String r103 = r102.a(r101);     // Catch: RemoteException -> L18
        if (r103 == null) goto L15;
        if ("".equals(r103) == true) goto L15;
        return r103;
    L15:
        if (this.f25751b.c(r101) == false) goto L27;
        return this.f25751b.a(r101);
    L27:
        return r103;
    L25:
        return null;
    L18:
        a("getAAID error, RemoteException!");
        return null;
    L21:
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public String b() {
        if (this.f25750a != null) goto L14;
        a("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    L14:
        com.alipay.sdk.m.q0.a r100 = this.f25751b;     // Catch: RemoteException -> L8
        if (r100 == null) goto L16;
        return r100.a();
    L16:
        return null;
    L8:
        e = move-exception;
        a("getOAID error, RemoteException!");
        e.printStackTrace();
        return null;
    }

    public String c() {
        if (this.f25750a != null) goto L16;
        a("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    L16:
        com.alipay.sdk.m.q0.a r100 = this.f25751b;     // Catch: Exception -> L8 RemoteException -> L10
        if (r100 == null) goto L18;
        return r100.b();
    L18:
        return null;
    L10:
        e = move-exception;
        a("getUDID error, RemoteException!");
        e.printStackTrace();
        return null;
    L8:
        e = move-exception;
        a("getUDID error, Exception!");
        e.printStackTrace();
        return null;
    }

    public String d() {
        Context r100 = this.f25750a;
        if (r100 == null) goto L17;
        String r101 = r100.getPackageName();
        b("liufeng, getVAID package：" + r101);
        if (r101 != null) goto L7;
    L14:
        b("input package is null!");
        return null;
    L7:
        if (r101.equals("") == true) goto L14;
        com.alipay.sdk.m.q0.a r102 = this.f25751b;     // Catch: RemoteException -> L12
        if (r102 == null) goto L21;
        return r102.b(r101);
    L21:
        return null;
    L12:
        e = move-exception;
        a("getVAID error, RemoteException!");
        e.printStackTrace();
        return null;
    L17:
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void f() {
        this.f25750a.unbindService(this.f25752c);     // Catch: IllegalArgumentException -> L4
        b("unBind Service successful");     // Catch: IllegalArgumentException -> L4
    L5:
        this.f25751b = null;
        return;
    L4:
        a("unBind Service exception");
        goto L5
    }

    public b() {
        this.f25750a = null;
        this.f25753d = null;
    }

    public static /* synthetic */ InterfaceC0492b a(b r100) {
        return r100.f25753d;
    }

    public void a(boolean r100) {
        f25749f = r100;
    }

    public int a(Context r100, InterfaceC0492b<String> r101) {
        if (r100 == null) goto L10;
        this.f25750a = r100;
        this.f25753d = r101;
        this.f25752c = new a(this);
        Intent r102 = new Intent();
        r102.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f25750a.bindService(r102, this.f25752c, 1) == false) goto L7;
        b("bindService Successful!");
        return 1;
    L7:
        b("bindService Failed!");
        return -1;
    L10:
        throw new NullPointerException("Context can not be null.");
    }

    public static /* synthetic */ void a(b r100, String r101) {
        r100.b(r101);
    }

    public static /* synthetic */ com.alipay.sdk.m.q0.a a(b r100, com.alipay.sdk.m.q0.a r101) {
        r100.f25751b = r101;
        return r101;
    }
}
