package com.obric.cae.libs.nfc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.utils.LogUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class CaeNfcAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f31754d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f31755e;
    public static CaeNfcAdapter f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ICaeNfcAdapter f31756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile CaeNfcOmapiExecutor f31757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile CaeNfcEventManager f31758c;

    public class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeNfcAdapter f31759a;

        public a(CaeNfcAdapter r1) {
            this.f31759a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("NFC:CaeNfcAdapter", "cae_nfc service is dead!");
            this.f31759a.f31756a = null;
            this.f31759a.f31757b = null;
            this.f31759a.f31758c = null;
            this.f31759a.c();
        }
    }

    static {
        f31754d = new Object();
    }

    public CaeNfcAdapter(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        this.f31756a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L5
    L8:
        if (this.f31756a == null) goto L10;
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

    public static IBinder a() {
        Object r0 = f31754d;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f31755e != null) goto L7;
        f31755e = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.aiagent.plugin").getMethod("getService", new Class[]{String.class});     // Catch: Throwable -> L15
    L7:
        Method r1 = f31755e;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return (IBinder) ZeusTransformUtils.preCheckCast(r1.invoke(null, new Object[]{CaeNfcConstants.SERVICE_NAME_NFC}), IBinder.class, "com.obric.aiagent.plugin");
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "getService denied: " + e);
        return null;
    }

    private /* synthetic */ void b() {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L12;
        this.f31756a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L9
        if (this.f31756a == null) goto L11;
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
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        monitor-enter(CaeNfcAdapter.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new CaeNfcAdapter(r3);     // Catch: Throwable -> L12
    L9:
        monitor-exit(CaeNfcAdapter.class);     // Catch: Throwable -> L12
        return f;
    L16:
        throw new IllegalArgumentException("context cannot be null");
    }

    public static /* synthetic */ void lambda$VMNy7vP8dh5tbJJ2QPjaQfTfgvg(CaeNfcAdapter r0) {
        r0.b();
    }

    public final void c() {
        new Thread(new $$Lambda$CaeNfcAdapter$VMNy7vP8dh5tbJJ2QPjaQfTfgvg(this)).start();
    }

    public final void d() {
        this.f31756a.asBinder().linkToDeath(new a(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.nfc.a.a("linkToDeath failed: ", e, "NFC:CaeNfcAdapter");
    }

    public CaeNfcEventManager getEventManager() {
        if (this.f31758c == null) goto L7;
        return this.f31758c;
    L7:
        if (this.f31756a == null) goto L28;
    L27:
        ICaeNfcEventManager r0 = this.f31756a.getEventManager();     // Catch: RemoteException -> L24
        if (r0 != null) goto L22;
        LogUtil.e("NFC:CaeNfcAdapter", "getEventManager: service is null");     // Catch: RemoteException -> L24
        return null;
    L22:
        this.f31758c = new CaeNfcEventManager(r0);     // Catch: RemoteException -> L24
        return this.f31758c;
    L24:
        e = move-exception;
        com.obric.cae.libs.nfc.a.a("RemoteException: ", e, "NFC:CaeNfcAdapter");
        return null;
    L28:
        this.f31756a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L12
        if (this.f31756a == null) goto L14;
        d();     // Catch: Exception -> L12
        boolean r1 = true;
    L15:
        if (r1 == true) goto L27;
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
        if (this.f31757b == null) goto L7;
        return this.f31757b;
    L7:
        if (this.f31756a == null) goto L28;
    L27:
        ICaeNfcOmapiExecutor r0 = this.f31756a.getOmapiExecutor();     // Catch: RemoteException -> L24
        if (r0 != null) goto L22;
        LogUtil.e("NFC:CaeNfcAdapter", "getOmapiExecutor: service is null");     // Catch: RemoteException -> L24
        return null;
    L22:
        this.f31757b = new CaeNfcOmapiExecutor(r0);     // Catch: RemoteException -> L24
        return this.f31757b;
    L24:
        e = move-exception;
        com.obric.cae.libs.nfc.a.a("RemoteException: ", e, "NFC:CaeNfcAdapter");
        return null;
    L28:
        this.f31756a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L12
        if (this.f31756a == null) goto L14;
        d();     // Catch: Exception -> L12
        boolean r1 = true;
    L15:
        if (r1 == true) goto L27;
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
