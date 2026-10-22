package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothCallbackExporter;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter;
import com.obric.cae.libs.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class CaeBluetoothDeviceManager {
    public static volatile CaeBluetoothDeviceManager g;
    public final Context a;
    public ICaeBluetoothExporter b;
    public final ArrayList c;
    public final ArrayList d;
    public final a e;
    public final b f;

    public interface CaeBluetoothServiceListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public class a implements IBinder.DeathRecipient {
        public final /* synthetic */ CaeBluetoothDeviceManager a;

        public a(CaeBluetoothDeviceManager r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeBluetoothDeviceManager", "binderDied: CAE service crashed. Attempting to reconnect...");
            CaeBluetoothDeviceManager r0 = this.a;
            if (r0.b == null) goto L5;
            r0.b = null;
        L5:
            ArrayList r1 = r0.c;
            monitor-enter(r1);
            Iterator r2 = this.a.c.iterator();     // Catch: Throwable -> L11
        L9:
            if (r2.hasNext() == false) goto L13;
            ((CaeBluetoothServiceListener) r2.next()).onServiceDisconnected();     // Catch: Throwable -> L11
            goto L9
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L11
            this.a.bindService();
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public class b implements ServiceConnection {
        public final /* synthetic */ CaeBluetoothDeviceManager a;

        public b(CaeBluetoothDeviceManager r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r3, IBinder r4) {
            LogUtil.d("CaeBluetoothDeviceManager", "onServiceConnected: " + r3);
            this.a.b = ICaeBluetoothExporter.Stub.asInterface(r4);
            r4.linkToDeath(this.a.e, 0);     // Catch: RemoteException -> L5
        L7:
            ArrayList r5 = this.a.c;
            monitor-enter(r5);
            Iterator r6 = this.a.c.iterator();     // Catch: Throwable -> L13
        L11:
            if (r6.hasNext() == false) goto L15;
            ((CaeBluetoothServiceListener) r6.next()).onServiceConnected();     // Catch: Throwable -> L13
            goto L11
        L15:
            monitor-exit(r5);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        L5:
            e = move-exception;
            com.obric.cae.libs.bluetooth.a.a("linkToDeath failed: ", e, "CaeBluetoothDeviceManager");
            goto L7
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            LogUtil.d("CaeBluetoothDeviceManager", "onServiceDisconnected: " + r3);
            ICaeBluetoothExporter r4 = CaeBluetoothDeviceManager.a(this.a);
            if (r4 != null) goto L5;
        L10:
            CaeBluetoothDeviceManager.b(this.a);
            ArrayList r5 = CaeBluetoothDeviceManager.e(this.a);
            monitor-enter(r5);
            CaeBluetoothDeviceManager.e(this.a).clear();     // Catch: Throwable -> L26
            monitor-exit(r5);     // Catch: Throwable -> L26
            ArrayList r0 = CaeBluetoothDeviceManager.c(this.a);
            monitor-enter(r0);
            Iterator r6 = CaeBluetoothDeviceManager.c(this.a).iterator();     // Catch: Throwable -> L20
        L18:
            if (r6.hasNext() == false) goto L22;
            ((CaeBluetoothServiceListener) r6.next()).onServiceDisconnected();     // Catch: Throwable -> L20
            goto L18
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        L26:
            th = move-exception;
            throw th;
        L5:
            if (r4.asBinder().isBinderAlive() == false) goto L10;
            r4.asBinder().unlinkToDeath(CaeBluetoothDeviceManager.d(this.a), 0);     // Catch: NoSuchElementException -> L8
        L8:
            e = move-exception;
            LogUtil.w("CaeBluetoothDeviceManager", "Death link does not exist: " + e);
            goto L10
        }
    }

    public CaeBluetoothDeviceManager(Context r2) {
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new a(this);
        this.f = new b(this);
        this.a = r2.getApplicationContext();
    }

    public static /* synthetic */ ICaeBluetoothExporter a(CaeBluetoothDeviceManager r0) {
        return r0.b;
    }

    public static /* synthetic */ void b(CaeBluetoothDeviceManager r1) {
        r1.b = null;
    }

    public static /* synthetic */ ArrayList c(CaeBluetoothDeviceManager r0) {
        return r0.c;
    }

    public static /* synthetic */ a d(CaeBluetoothDeviceManager r0) {
        return r0.e;
    }

    public static /* synthetic */ ArrayList e(CaeBluetoothDeviceManager r0) {
        return r0.d;
    }

    public static CaeBluetoothDeviceManager getInstance(Context r2) {
        if (g != null) goto L16;
        monitor-enter(CaeBluetoothDeviceManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L11;
        g = new CaeBluetoothDeviceManager(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(CaeBluetoothDeviceManager.class);     // Catch: Throwable -> L9
    L16:
        return g;
    }

    public void addServiceListener(CaeBluetoothServiceListener r3) {
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
        LogUtil.d("CaeBluetoothDeviceManager", "Service is already connected.");     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return true;
    L11:
        LogUtil.d("CaeBluetoothDeviceManager", "Binding cae bluetooth service...");     // Catch: Throwable -> L9
        Intent r6 = new Intent();     // Catch: Throwable -> L9 Exception -> L18 SecurityException -> L20
        r6.setComponent(new ComponentName("com.obric.cae", "com.obric.cae.smartBluetooth.SmartBluetoothService"));     // Catch: Throwable -> L9 Exception -> L18 SecurityException -> L20
        r6.setAction("com.obric.cae.libs.bluetooth.ICaeBluetoothExporter");     // Catch: Throwable -> L9 Exception -> L18 SecurityException -> L20
        if (this.a.bindService(r6, this.f, 1) == true) goto L23;
        LogUtil.e("CaeBluetoothDeviceManager", "Fail to bind to: " + r6);     // Catch: Throwable -> L9 Exception -> L18 SecurityException -> L20
        monitor-exit(r3);     // Catch: Throwable -> L9
        return false;
    L23:
        monitor-exit(r3);     // Catch: Throwable -> L9
        return true;
    L20:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Fail to bind to: " + e);     // Catch: Throwable -> L9
        return false;
    L18:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Exception: " + e);     // Catch: Throwable -> L9
        return false;
    }

    public boolean disableBle() {
        if (this.b != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "disableBle: Service is not connected");
        return false;
    L11:
        LogUtil.d("CaeBluetoothDeviceManager", "disableBle: Requesting BLE-only mode off");     // Catch: RemoteException -> L6
        return this.b.disableBle();
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return false;
    }

    public boolean enableBle() {
        if (this.b != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "enableBle: Service is not connected");
        return false;
    L11:
        LogUtil.d("CaeBluetoothDeviceManager", "enableBle: Requesting BLE-only mode");     // Catch: RemoteException -> L6
        return this.b.enableBle();
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return false;
    }

    public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r4) {
        ICaeBluetoothExporter r0 = this.b;
        if (r0 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "getDeviceType: Service is not connected");
    L10:
        return new BtDeviceInfoExtEvent(r4, 0);
    L11:
        return r0.getDeviceType(r4);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        goto L10
    }

    public int getProductId(BluetoothDevice r3) {
        ICaeBluetoothExporter r0 = this.b;
        if (r0 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "getProductId: Service is not connected");
        return 0;
    L11:
        return r0.getProductId(r3);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return 0;
    }

    public boolean isAbsoluteVolumeSupported(BluetoothDevice r3) {
        ICaeBluetoothExporter r0 = this.b;
        if (r0 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "isAbsoluteVolumeSupported: Service is not connected");
        return false;
    L11:
        return r0.isAbsoluteVolumeSupported(r3);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return false;
    }

    public void registerEventCallback(ICaeBluetoothCallbackExporter r5) {
        if (r5 == null) goto L22;
        ArrayList r1 = this.d;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.d.contains(r5) == true) goto L17;
        this.d.add(r5);     // Catch: Throwable -> L12
        ICaeBluetoothExporter r2 = this.b;     // Catch: Throwable -> L12
        if (r2 != null) goto L23;
        LogUtil.w("CaeBluetoothDeviceManager", "registerEventCallback: Service is not connected");     // Catch: Throwable -> L12
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L23:
        r2.registerEventCallback(r5);     // Catch: Throwable -> L12 RemoteException -> L14
    L14:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "RemoteException: " + e);     // Catch: Throwable -> L12
        goto L18
    L17:
        LogUtil.d("CaeBluetoothDeviceManager", "registerEventCallback: Callback already registered, ignoring.");     // Catch: Throwable -> L12
        goto L18
    }

    public void removeServiceListener(CaeBluetoothServiceListener r3) {
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
        LogUtil.d("CaeBluetoothDeviceManager", "Unbinding cae bluetooth service...");     // Catch: Throwable -> L9
        this.a.unbindService(this.f);     // Catch: Throwable -> L9 Exception -> L11
    L13:
        this.b = null;     // Catch: Throwable -> L9
        goto L14
    L11:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Exception during unbind: " + e);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L9
    }

    public void unregisterEventCallback(ICaeBluetoothCallbackExporter r3) {
        if (r3 == null) goto L11;
        ArrayList r0 = this.d;
        monitor-enter(r0);
        this.d.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        ICaeBluetoothExporter r1 = this.b;
        if (r1 != null) goto L21;
        LogUtil.w("CaeBluetoothDeviceManager", "unregisterEventCallback: Service is not connected");
        return;
    L21:
        r1.unregisterEventCallback(r3);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
    }
}
