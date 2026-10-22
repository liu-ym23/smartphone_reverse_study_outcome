package com.obric.cae.libs.networkRtt;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.utils.LogUtil;

/* JADX INFO: loaded from: classes3.dex */
public class CaeNetworkRttManager {
    public static CaeNetworkRttManager b;
    public volatile ICaeNetworkRtt a;

    public class a implements IBinder.DeathRecipient {
        public final /* synthetic */ CaeNetworkRttManager a;

        public a(CaeNetworkRttManager r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeNetworkRttManager", "rtt query service is dead!");
            this.a.a = null;
            this.a.a();
        }
    }

    public class b extends Thread {
        public final /* synthetic */ CaeNetworkRttManager a;

        public b(CaeNetworkRttManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int r2 = 0;
        L4:
            if (r2 >= 50) goto L15;
            SystemClock.sleep(100);
            this.a.a = ICaeNetworkRtt.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_network_rtt"}));     // Catch: Exception -> L8
        L11:
            if (this.a.a != null) goto L12;
            r2 = r2 + 1;
            goto L4
        L12:
            this.a.b();
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeNetworkRttManager", "Get service failed", e);
            goto L11
        L15:
            LogUtil.e("CaeNetworkRttManager", "get rtt query service failed after retries");
        }
    }

    public CaeNetworkRttManager(Context r5) {
        this.a = ICaeNetworkRtt.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_network_rtt"}));     // Catch: Exception -> L5
    L8:
        if (this.a == null) goto L10;
        b();
        return;
    L10:
        a();
        return;
    L5:
        e = move-exception;
        LogUtil.e("CaeNetworkRttManager", "Get service failed", e);
        goto L8
    }

    public static CaeNetworkRttManager getInstance(Context r2) {
        if (r2 == null) goto L16;
        monitor-enter(CaeNetworkRttManager.class);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (b != null) goto L10;
        b = new CaeNetworkRttManager(r2);     // Catch: Throwable -> L8
    L10:
        monitor-exit(CaeNetworkRttManager.class);     // Catch: Throwable -> L8
        return b;
    L16:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        new b(this).start();
    }

    public final void b() {
        this.a.asBinder().linkToDeath(new a(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        LogUtil.e("CaeNetworkRttManager", "linkToDeath failed", e);
    }

    public int getGameRttbyUid(int r4) {
        ICaeNetworkRtt r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("CaeNetworkRttManager", "getGameRttbyUid: service is null");
        return -1;
    L11:
        return r0.getGameRttbyUid(r4);
    L8:
        e = move-exception;
        LogUtil.e("CaeNetworkRttManager", "getGameRttbyUid failed", e);
        return -1;
    }

    public int getRttByUid(int r4) {
        ICaeNetworkRtt r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("CaeNetworkRttManager", "getRttByUid: service is null");
        return -1;
    L11:
        return r0.getRttByUid(r4);
    L8:
        e = move-exception;
        LogUtil.e("CaeNetworkRttManager", "getRttByUid failed", e);
        return -1;
    }

    public boolean isServiceAvailable() {
        if (this.a == null) goto L5;
        return true;
    L5:
        return false;
    }
}
