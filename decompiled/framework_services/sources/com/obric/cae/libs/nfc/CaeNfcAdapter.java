package com.obric.cae.libs.nfc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.utils.LogUtil;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class CaeNfcAdapter {
    public static final Object d = null;
    public static Method e;
    public static CaeNfcAdapter f;
    public volatile ICaeNfcAdapter a;
    public volatile CaeNfcOmapiExecutor b;
    public volatile CaeNfcEventManager c;

    public class a implements IBinder.DeathRecipient {
        public final /* synthetic */ CaeNfcAdapter a;

        public a(CaeNfcAdapter r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("NFC:CaeNfcAdapter", "cae_nfc service is dead!");
            this.a.a = null;
            this.a.b = null;
            this.a.c = null;
            this.a.c();
        }
    }

    public static /* synthetic */ void $r8$lambda$wLUD9m1JvxLtD5D5_KmSKePFeg0(CaeNfcAdapter r0) {
        r0.b();
    }

    static {
        d = new Object();
    }

    public CaeNfcAdapter(Context r3) {
        r3.getApplicationContext();
        this.a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L5
    L8:
        if (this.a == null) goto L10;
        d();
        return;
    L10:
        c();
        return;
    L5:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "Get service failed: " + e);
        goto L8
    }

    public static IBinder a() throws Exception {
        Object r0 = d;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (e != null) goto L9;
        e = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class});     // Catch: Throwable -> L7
    L9:
        Method r1 = e;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return (IBinder) r1.invoke(null, new Object[]{CaeNfcConstants.SERVICE_NAME_NFC});
    L14:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "getService denied: " + e);
        return null;
    }

    private /* synthetic */ void b() {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L12;
        this.a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L9
        if (this.a == null) goto L11;
        d();     // Catch: Exception -> L9
        LogUtil.d("NFC:CaeNfcAdapter", "Get service success after retry");     // Catch: Exception -> L9
        return;
    L11:
        r0 = r0 + 1;
        SystemClock.sleep(300);
    L9:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "Retry get service failed: " + e);
        goto L11
    L12:
        LogUtil.e("NFC:CaeNfcAdapter", "Retry get service failed after 10 times");
    }

    public static CaeNfcAdapter getDefaultAdapter(Context r2) {
        if (r2 == null) goto L16;
        monitor-enter(CaeNfcAdapter.class);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (f != null) goto L10;
        f = new CaeNfcAdapter(r2);     // Catch: Throwable -> L8
    L10:
        monitor-exit(CaeNfcAdapter.class);     // Catch: Throwable -> L8
        return f;
    L16:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void c() {
        new Thread(new CaeNfcAdapter$$ExternalSyntheticLambda0(this)).start();
    }

    public final void d() {
        this.a.asBinder().linkToDeath(new a(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("linkToDeath failed: ", e, "NFC:CaeNfcAdapter");
    }

    public CaeNfcEventManager getEventManager() {
        if (this.c == null) goto L7;
        return this.c;
    L7:
        if (this.a == null) goto L29;
    L28:
        ICaeNfcEventManager r0 = this.a.getEventManager();     // Catch: RemoteException -> L22
        if (r0 != null) goto L24;
        LogUtil.e("NFC:CaeNfcAdapter", "getEventManager: service is null");     // Catch: RemoteException -> L22
        return null;
    L24:
        this.c = new CaeNfcEventManager(r0);     // Catch: RemoteException -> L22
        return this.c;
    L22:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcAdapter");
        return null;
    L29:
        this.a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L12
        if (this.a == null) goto L14;
        d();     // Catch: Exception -> L12
        boolean r1 = true;
    L15:
        if (r1 == true) goto L28;
        LogUtil.e("NFC:CaeNfcAdapter", "getEventManager: mICaeNfcAdapter is null");
        return null;
    L14:
        c();
        r1 = false;
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "ensureService failed: " + e);
        goto L14
    }

    public CaeNfcOmapiExecutor getOmapiExecutor() {
        if (this.b == null) goto L7;
        return this.b;
    L7:
        if (this.a == null) goto L29;
    L28:
        ICaeNfcOmapiExecutor r0 = this.a.getOmapiExecutor();     // Catch: RemoteException -> L22
        if (r0 != null) goto L24;
        LogUtil.e("NFC:CaeNfcAdapter", "getOmapiExecutor: service is null");     // Catch: RemoteException -> L22
        return null;
    L24:
        this.b = new CaeNfcOmapiExecutor(r0);     // Catch: RemoteException -> L22
        return this.b;
    L22:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcAdapter");
        return null;
    L29:
        this.a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L12
        if (this.a == null) goto L14;
        d();     // Catch: Exception -> L12
        boolean r1 = true;
    L15:
        if (r1 == true) goto L28;
        LogUtil.e("NFC:CaeNfcAdapter", "getOmapiExecutor: mICaeNfcAdapter is null");
        return null;
    L14:
        c();
        r1 = false;
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "ensureService failed: " + e);
        goto L14
    }
}
