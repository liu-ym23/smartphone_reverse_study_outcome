package com.obric.cae.libs.bluetooth;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter;
import com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter;
import com.obric.cae.libs.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CaeDcfScanManager {
    public static volatile CaeDcfScanManager g;
    public final Context a;
    public ICaeDcfScanExporter b;
    public final ArrayList c;
    public final ArrayList d;
    public final a e;
    public final b f;

    public interface CaeDcfScanServiceListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public class a implements IBinder.DeathRecipient {
        public final /* synthetic */ CaeDcfScanManager a;

        public a(CaeDcfScanManager r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeDcfScanManager", "binderDied: CAE service crashed. Attempting to reconnect...");
            if (CaeDcfScanManager.a(this.a) == null) goto L5;
            CaeDcfScanManager.a(this.a).asBinder().unlinkToDeath(CaeDcfScanManager.c(this.a), 0);
            CaeDcfScanManager.b(this.a);
        L5:
            ArrayList r0 = CaeDcfScanManager.d(this.a);
            monitor-enter(r0);
            Iterator r1 = CaeDcfScanManager.d(this.a).iterator();     // Catch: Throwable -> L11
        L9:
            if (r1.hasNext() == false) goto L13;
            ((CaeDcfScanServiceListener) r1.next()).onServiceDisconnected();     // Catch: Throwable -> L11
            goto L9
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.a.bindService();
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public class b implements ServiceConnection {
        public final /* synthetic */ CaeDcfScanManager a;

        public b(CaeDcfScanManager r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r5, IBinder r6) {
            LogUtil.d("CaeDcfScanManager", "onServiceConnected: " + r5);
            this.a.b = ICaeDcfScanExporter.Stub.asInterface(r6);
            r6.linkToDeath(this.a.e, 0);     // Catch: RemoteException -> L5
        L7:
            ArrayList r7 = this.a.d;
            monitor-enter(r7);
            Iterator r8 = this.a.d.iterator();     // Catch: Throwable -> L15
        L11:
            if (r8.hasNext() == false) goto L19;
            this.a.b.registerDcfScanCallback((ICaeDcfScanCallbackExporter) r8.next());     // Catch: Throwable -> L15 RemoteException -> L17
        L17:
            e = move-exception;
            LogUtil.e("CaeDcfScanManager", "re-register callback failed: " + e);     // Catch: Throwable -> L15
            goto L11
        L19:
            monitor-exit(r7);     // Catch: Throwable -> L15
            ArrayList r9 = this.a.c;
            monitor-enter(r9);
            Iterator r10 = this.a.c.iterator();     // Catch: Throwable -> L26
        L24:
            if (r10.hasNext() == false) goto L28;
            ((CaeDcfScanServiceListener) r10.next()).onServiceConnected();     // Catch: Throwable -> L26
            goto L24
        L28:
            monitor-exit(r9);     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            throw th;
        L15:
            th = move-exception;
            throw th;
        L5:
            e = move-exception;
            com.obric.cae.libs.bluetooth.a.a("linkToDeath failed: ", e, "CaeDcfScanManager");
            goto L7
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            LogUtil.d("CaeDcfScanManager", "onServiceDisconnected: " + r3);
            if (CaeDcfScanManager.a(this.a) == null) goto L5;
            CaeDcfScanManager.a(this.a).asBinder().unlinkToDeath(CaeDcfScanManager.c(this.a), 0);
        L5:
            CaeDcfScanManager.b(this.a);
            ArrayList r4 = CaeDcfScanManager.d(this.a);
            monitor-enter(r4);
            Iterator r0 = CaeDcfScanManager.d(this.a).iterator();     // Catch: Throwable -> L11
        L9:
            if (r0.hasNext() == false) goto L13;
            ((CaeDcfScanServiceListener) r0.next()).onServiceDisconnected();     // Catch: Throwable -> L11
            goto L9
        L13:
            monitor-exit(r4);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public CaeDcfScanManager(Context r2) {
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new a(this);
        this.f = new b(this);
        this.a = r2.getApplicationContext();
    }

    public static /* synthetic */ ICaeDcfScanExporter a(CaeDcfScanManager r0) {
        return r0.b;
    }

    public static /* synthetic */ void b(CaeDcfScanManager r1) {
        r1.b = null;
    }

    public static /* synthetic */ a c(CaeDcfScanManager r0) {
        return r0.e;
    }

    public static /* synthetic */ ArrayList d(CaeDcfScanManager r0) {
        return r0.c;
    }

    public static CaeDcfScanManager getInstance(Context r2) {
        if (g != null) goto L16;
        monitor-enter(CaeDcfScanManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L11;
        g = new CaeDcfScanManager(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(CaeDcfScanManager.class);     // Catch: Throwable -> L9
    L16:
        return g;
    }

    public void addServiceListener(CaeDcfScanServiceListener r3) {
        if (r3 == null) goto L16;
        ArrayList r0 = this.c;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.c.contains(r3) == true) goto L10;
        this.c.add(r3);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (this.b == null) goto L19;
        r3.onServiceConnected();
        return;
    L19:
        return;
    }

    public boolean bindService() {
        b r3 = this.f;
        monitor-enter(r3);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.b == null) goto L11;
        LogUtil.d("CaeDcfScanManager", "Service is already connected.");     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return true;
    L11:
        LogUtil.d("CaeDcfScanManager", "Binding cae dcf scan service...");     // Catch: Throwable -> L9
        Intent r6 = new Intent();     // Catch: Throwable -> L9 Exception -> L18 SecurityException -> L20
        r6.setComponent(new ComponentName("com.obric.cae", "com.obric.cae.smartBluetooth.dcf.CaeDcfScanService"));     // Catch: Throwable -> L9 Exception -> L18 SecurityException -> L20
        r6.setAction(ICaeDcfScanExporter.DESCRIPTOR);     // Catch: Throwable -> L9 Exception -> L18 SecurityException -> L20
        if (this.a.bindService(r6, this.f, 1) == true) goto L23;
        LogUtil.e("CaeDcfScanManager", "Fail to bind to: " + r6);     // Catch: Throwable -> L9 Exception -> L18 SecurityException -> L20
        monitor-exit(r3);     // Catch: Throwable -> L9
        return false;
    L23:
        monitor-exit(r3);     // Catch: Throwable -> L9
        return true;
    L20:
        e = move-exception;
        LogUtil.e("CaeDcfScanManager", "Fail to bind to: " + e);     // Catch: Throwable -> L9
        return false;
    L18:
        e = move-exception;
        LogUtil.e("CaeDcfScanManager", "Exception: " + e);     // Catch: Throwable -> L9
        return false;
    }

    public boolean isDcfScanSupported() {
        ICaeDcfScanExporter r0 = this.b;
        if (r0 != null) goto L11;
        LogUtil.w("CaeDcfScanManager", "isDcfScanSupported: Service is not connected");
        return false;
    L11:
        return r0.isDcfScanSupported();
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeDcfScanManager");
        return false;
    }

    public void registerDcfScanCallback(ICaeDcfScanCallbackExporter r5) {
        if (r5 == null) goto L22;
        ArrayList r1 = this.d;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.d.contains(r5) == true) goto L17;
        this.d.add(r5);     // Catch: Throwable -> L12
        ICaeDcfScanExporter r2 = this.b;     // Catch: Throwable -> L12
        if (r2 != null) goto L23;
        LogUtil.w("CaeDcfScanManager", "registerDcfScanCallback: Service is not connected");     // Catch: Throwable -> L12
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L23:
        r2.registerDcfScanCallback(r5);     // Catch: Throwable -> L12 RemoteException -> L14
    L14:
        e = move-exception;
        LogUtil.e("CaeDcfScanManager", "RemoteException: " + e);     // Catch: Throwable -> L12
        goto L18
    L17:
        LogUtil.d("CaeDcfScanManager", "registerDcfScanCallback: Callback already registered, ignoring.");     // Catch: Throwable -> L12
        goto L18
    }

    public void removeServiceListener(CaeDcfScanServiceListener r3) {
        if (r3 == null) goto L11;
        ArrayList r0 = this.c;
        monitor-enter(r0);
        this.c.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unbindService() {
        b r1 = this.f;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.b == null) goto L14;
        LogUtil.d("CaeDcfScanManager", "Unbinding cae dcf scan service...");     // Catch: Throwable -> L9
        this.a.unbindService(this.f);     // Catch: Throwable -> L9 Exception -> L11
    L13:
        this.b = null;     // Catch: Throwable -> L9
        goto L14
    L11:
        e = move-exception;
        LogUtil.e("CaeDcfScanManager", "Exception during unbind: " + e);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L9
    }

    public void unregisterDcfScanCallback(ICaeDcfScanCallbackExporter r3) {
        if (r3 == null) goto L11;
        ArrayList r0 = this.d;
        monitor-enter(r0);
        this.d.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        ICaeDcfScanExporter r1 = this.b;
        if (r1 != null) goto L21;
        LogUtil.w("CaeDcfScanManager", "unregisterDcfScanCallback: Service is not connected");
        return;
    L21:
        r1.unregisterDcfScanCallback(r3);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeDcfScanManager");
    }
}
