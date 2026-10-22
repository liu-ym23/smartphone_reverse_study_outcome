package com.obric.cae.libs.multipath;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class CaeMultipathClient {
    public static volatile CaeMultipathClient e;
    public ICaeMultipathManager a;
    public HandlerThread b;
    public a c;
    public boolean d;

    public class a extends Handler {
        public final /* synthetic */ CaeMultipathClient a;

        public a(CaeMultipathClient r1, Looper r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            int r4 = r3.what;
            boolean r0 = true;
            if (r4 != 1) goto L5;
            CaeMultipathClient.a(this.a);
            return;
        L5:
            if (r4 != 2) goto L17;
            CaeMultipathClient r5 = this.a;
            if (r5.a != null) goto L11;
            r0 = false;
        L11:
            if (r0 == true) goto L15;
            CaeMultipathClient.a(r5);
            return;
        L15:
            return;
        }
    }

    public CaeMultipathClient() {
        this.d = false;
        a();
        this.c.sendEmptyMessage(1);
    }

    public static CaeMultipathClient getInstance() {
        if (e != null) goto L16;
        monitor-enter(CaeMultipathClient.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L11;
        e = new CaeMultipathClient();     // Catch: Throwable -> L9
    L11:
        monitor-exit(CaeMultipathClient.class);     // Catch: Throwable -> L9
    L16:
        return e;
    }

    public final void a() {
        HandlerThread r0 = new HandlerThread("CaeMultipathConnectThread");
        this.b = r0;
        r0.start();
        this.c = new a(this, this.b.getLooper());
    }

    public String getLatestNetworkTruth() {
        ICaeMultipathManager r0 = this.a;
        if (r0 == null) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L15;
        Log.e("CaeMultipathClient", "Service not connected");
        return null;
    L15:
        return r0.getLatestNetworkTruth();
    L12:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to get latest network truth", e);
        return null;
    L5:
        r1 = false;
        goto L7
    }

    public boolean reportAssistantFailure() {
        ICaeMultipathManager r0 = this.a;
        if (r0 == null) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L15;
        Log.e("CaeMultipathClient", "Service not connected");
        return false;
    L15:
        r0.reportAssistantFailure();     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to report assistant failure", e);
        return false;
    L5:
        r3 = false;
        goto L7
    }

    public boolean reportAssistantOperateApps(int[] r6) {
        ICaeMultipathManager r0 = this.a;
        if (r0 == null) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L15;
        Log.e("CaeMultipathClient", "Service not connected");
        return false;
    L15:
        r0.reportAssistantOperateApps(r6);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to report assistant operate apps", e);
        return false;
    L5:
        r3 = false;
        goto L7
    }

    public static void a(CaeMultipathClient r10) {
        if (r10.d == false) goto L5;
        Log.d("CaeMultipathClient", "Already connecting, skipping");
        return;
    L5:
        r10.d = true;
        IBinder r6 = ServiceManager.getService("cae_multipath");     // Catch: Throwable -> L10 Exception -> L12
        if (r6 != null) goto L33;
        Log.e("CaeMultipathClient", "Failed to get cae_multipath service binder");     // Catch: Throwable -> L10 Exception -> L12
        r10.c.removeMessages(2);     // Catch: Throwable -> L10 Exception -> L12
        r10.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L10 Exception -> L12
    L29:
        r10.d = false;
        return;
    L33:
        int r8 = ICaeMultipathManager.Stub.TRANSACTION_startMultipath;     // Catch: Throwable -> L10 Exception -> L18
        ICaeMultipathManager r0 = (ICaeMultipathManager) ICaeMultipathManager.Stub.class.getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r6});     // Catch: Throwable -> L10 Exception -> L18
        r10.a = r0;     // Catch: Throwable -> L10 Exception -> L18
        if (r0 != null) goto L36;
        Log.e("CaeMultipathClient", "Failed to create service interface");     // Catch: Throwable -> L10 Exception -> L18
        r10.c.removeMessages(2);     // Catch: Throwable -> L10 Exception -> L18
        r10.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L10 Exception -> L18
        goto L29
    L36:
        r6.linkToDeath(new com.obric.cae.libs.multipath.a(r10), 0);     // Catch: Throwable -> L10 Exception -> L12 RemoteException -> L22
    L24:
        Log.d("CaeMultipathClient", "Connected to cae_multipath service");     // Catch: Throwable -> L10 Exception -> L12
        r10.d = false;
        return;
    L22:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to link to death", e);     // Catch: Throwable -> L10 Exception -> L12
    L18:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to get Stub class or asInterface method", e);     // Catch: Throwable -> L10 Exception -> L12
        r10.c.removeMessages(2);     // Catch: Throwable -> L10 Exception -> L12
        r10.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to connect to cae_multipath service", e);     // Catch: Throwable -> L10
        r10.c.removeMessages(2);     // Catch: Throwable -> L10
        r10.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r10.d = false;
        throw th;
    }
}
