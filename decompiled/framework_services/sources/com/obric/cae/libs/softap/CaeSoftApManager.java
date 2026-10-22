package com.obric.cae.libs.softap;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.obric.cae.libs.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class CaeSoftApManager {
    public static final long SOFTAP_CAPABILITY_160MHZ = 2;
    public static final long SOFTAP_CAPABILITY_BASIC = 1;
    public static final long SOFTAP_CAPABILITY_HIDDEN_SSID = 128;
    public static final long SOFTAP_CAPABILITY_METERED = 256;
    public static final long SOFTAP_CAPABILITY_SECURITY_OPEN = 8;
    public static final long SOFTAP_CAPABILITY_SECURITY_WPA2_PSK = 16;
    public static final long SOFTAP_CAPABILITY_SECURITY_WPA2_WPA3_TRANSITION = 64;
    public static final long SOFTAP_CAPABILITY_SECURITY_WPA3_SAE = 32;
    public static final long SOFTAP_CAPABILITY_TX_POWER_CONTROL = 4;
    public static final int SOFTAP_INTERFACE_VERSION_1 = 1;
    public static final int SOFTAP_INTERFACE_VERSION_UNSUPPORTED = 0;
    public static volatile CaeSoftApManager k;
    public final Context a;
    public final AtomicReference<ICaeSoftApManager> b;
    public final Object c;
    public final Handler d;
    public final ExecutorService e;
    public final ArrayList<c> f;
    public final LinkedHashSet<ICaeSoftApCallback> g;
    public final a h;
    public boolean i;
    public boolean j;

    public class a implements ServiceConnection {
        public final /* synthetic */ CaeSoftApManager a;

        /* JADX INFO: renamed from: $r8$lambda$ijBd15jbqE9K-KG8JslseKHxuVk, reason: not valid java name */
        public static /* synthetic */ void m10577$r8$lambda$ijBd15jbqE9KKG8JslseKHxuVk(a r0, ICaeSoftApManager r1, ArrayList r2) {
            r0.a(r1, r2);
        }

        public a(CaeSoftApManager r1) {
            this.a = r1;
        }

        private void a(ICaeSoftApManager r6, ArrayList r7) {
            CaeSoftApManager r0 = this.a;
            Object r1 = r0.c;
            monitor-enter(r1);
            ArrayList r2 = new ArrayList(r0.g);     // Catch: Throwable -> L21
            monitor-exit(r1);     // Catch: Throwable -> L21
            Iterator r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L16;
            ICaeSoftApCallback r4 = (ICaeSoftApCallback) r3.next();
            if (r0.b(r4) == false) goto L8;
            r6.registerCallback(r4);     // Catch: RemoteException -> L14
        L14:
            e = move-exception;
            com.obric.cae.libs.bluetooth.a.a("registerCallback on connect failed: ", e, "CaeSoftApManager");
            goto L8
        L16:
            Iterator r8 = r7.iterator();
        L18:
            if (r8.hasNext() == false) goto L20;
            c r5 = (c) r8.next();
            this.a.a(r6, r5);
            goto L18
        L20:
            return;
        L21:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r4, IBinder r5) {
            final ICaeSoftApManager r6 = ICaeSoftApManager.Stub.asInterface(r5);
            Object r0 = CaeSoftApManager.a(this.a);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (CaeSoftApManager.b(this.a) == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            CaeSoftApManager.c(this.a).set(r6);     // Catch: Throwable -> L8
            CaeSoftApManager.d(this.a);     // Catch: Throwable -> L8
            final ArrayList r1 = new ArrayList(CaeSoftApManager.e(this.a));     // Catch: Throwable -> L8
            CaeSoftApManager.e(this.a).clear();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            LogUtil.i("CaeSoftApManager", "onServiceConnected: " + r4 + ", pending=" + r1.size());
            CaeSoftApManager.f(this.a).execute(new CaeSoftApManager$a$$ExternalSyntheticLambda0(this, r6, r1));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r4) {
            Object r0 = this.a.c;
            monitor-enter(r0);
            this.a.b.set(null);     // Catch: Throwable -> L8
            this.a.i = false;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            LogUtil.e("CaeSoftApManager", "onServiceDisconnected: " + r4);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public interface b {
        void a(int r1);
    }

    public static final class c {
        public final String a;
        public final e b;
        public final AtomicBoolean c;
        public final d d;
        public Runnable e;

        public c(String r3, e r4, d r5) {
            this.c = new AtomicBoolean(false);
            this.a = r3;
            this.b = r4;
            this.d = r5;
        }

        public static c a(String r2, e r3, final CaeSoftApRequestCallback r4) {
            return new c(r2, r3, new CaeSoftApManager$c$$ExternalSyntheticLambda1(r4));
        }

        public static /* synthetic */ void a(CaeSoftApRequestCallback r0, int r1, String r2) {
            if (r0 == null) goto L5;
            r0.onError(r1, r2);
            return;
        }

        public static c a(e r2, final CaeSoftApStatusResultCallback r3) {
            return new c("getStatus", r2, new CaeSoftApManager$c$$ExternalSyntheticLambda0(r3));
        }

        public static /* synthetic */ void a(CaeSoftApStatusResultCallback r0, int r1, String r2) {
            if (r0 == null) goto L5;
            r0.onError(r1, r2);
            return;
        }
    }

    public interface d {
        void onError(int r1, String r2);
    }

    public interface e {
        void a(ICaeSoftApManager r1) throws RemoteException;
    }

    public static /* synthetic */ void $r8$lambda$9BpgpY6urf9mXpX0guH1RAkC2uA(CaeSoftApManager r0, CaeSoftApRequestCallback r1, String r2, int r3) {
        r0.b(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$9CFsUQhjKhOKHJUI2wYHq2jbG6o(CaeSoftApManager r0, CaeSoftApRequestCallback r1, String r2, int r3) {
        r0.a(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$E4qrQNc-5-fLtKaXD7ZKJC9ARPU, reason: not valid java name */
    public static /* synthetic */ void m10574$r8$lambda$E4qrQNc5fLtKaXD7ZKJC9ARPU(CaeSoftApManager r0, CaeSoftApStatusResultCallback r1, String r2, int r3) {
        r0.b(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$HJ7Tth7sTaYnUMnRbvZG3aXniYA(CaeSoftApManager r0, ICaeSoftApCallback r1) {
        r0.d(r1);
    }

    public static /* synthetic */ void $r8$lambda$MPhZKao29rHgTAFEm4DV2IGSACI(CaeSoftApManager r0) {
        r0.e();
    }

    public static /* synthetic */ void $r8$lambda$NLwWiJogYjeNu1ETa4sQ38Izg58(CaeSoftApManager r0, c r1, int r2) {
        r0.b(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Prp7A_ieO3HtIsxTypDoiJO3fVM(CaeSoftApManager r0, ICaeSoftApCallback r1, CaeSoftApConfig r2, CaeSoftApRequestCallback r3, boolean r4, ICaeSoftApManager r5) {
        r0.a(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$QvkU6par48iz5d-EwMkRezRKaIU, reason: not valid java name */
    public static /* synthetic */ void m10575$r8$lambda$QvkU6par48iz5dEwMkRezRKaIU(CaeSoftApManager r0, String r1, ICaeSoftApManager r2, e r3, CaeSoftApRequestCallback r4) {
        r0.b(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$b8dmMWnm2Wp_CTBp4Xr7X0cM3VY(CaeSoftApManager r0, CaeSoftApStatusResultCallback r1, String r2, int r3) {
        r0.a(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$hDK9GVZbnsF3MfUzWZapdwDLa8o(CaeSoftApManager r0, c r1) {
        r0.b(r1);
    }

    public static /* synthetic */ void $r8$lambda$qKR28Q1tS_6_psVlW3hnRA6EhWY(CaeSoftApManager r0, CaeSoftApStatusResultCallback r1, ICaeSoftApManager r2) {
        r0.a(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$rOLD_z3Yi10THuEYQyeJi1VtJLU(CaeSoftApManager r0, String r1, ICaeSoftApManager r2, e r3, CaeSoftApStatusResultCallback r4) {
        r0.b(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$rqYuQwZdoQ1QZHpFz2IL1CeWN1c(CaeSoftApManager r0, CaeSoftApRequestCallback r1, ICaeSoftApManager r2) {
        r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$s4ETirfT6SS28-KKzVbWNxqzpjU, reason: not valid java name */
    public static /* synthetic */ void m10576$r8$lambda$s4ETirfT6SS28KKzVbWNxqzpjU(CaeSoftApManager r0, String r1, ICaeSoftApManager r2, e r3, CaeSoftApStatusResultCallback r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$tuUdF3gLfRa9rm22nBuYMHjIP5U(CaeSoftApManager r0, ICaeSoftApCallback r1) {
        r0.c(r1);
    }

    public static /* synthetic */ void $r8$lambda$zoPN743FtIs696gW0cAfZAgk5aA(CaeSoftApManager r0, String r1, ICaeSoftApManager r2, e r3, CaeSoftApRequestCallback r4) {
        r0.a(r1, r2, r3, r4);
    }

    public CaeSoftApManager(Context r3) {
        this.b = new AtomicReference();
        this.c = new Object();
        this.d = new Handler(Looper.getMainLooper());
        this.e = Executors.newSingleThreadExecutor(new CaeSoftApManager$$ExternalSyntheticLambda15());
        this.f = new ArrayList();
        this.g = new LinkedHashSet();
        this.h = new a(this);
        this.a = r3.getApplicationContext();
    }

    public static /* synthetic */ boolean b(CaeSoftApManager r0) {
        return r0.j;
    }

    public static /* synthetic */ void d(CaeSoftApManager r1) {
        r1.i = false;
    }

    public static /* synthetic */ ArrayList e(CaeSoftApManager r0) {
        return r0.f;
    }

    public static /* synthetic */ ExecutorService f(CaeSoftApManager r0) {
        return r0.e;
    }

    public static CaeSoftApManager getInstance(Context r2) {
        if (r2 == null) goto L19;
        if (k != null) goto L17;
        monitor-enter(CaeSoftApManager.class);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (k != null) goto L12;
        k = new CaeSoftApManager(r2);     // Catch: Throwable -> L10
    L12:
        monitor-exit(CaeSoftApManager.class);     // Catch: Throwable -> L10
    L17:
        return k;
    L19:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a(final e r8, final CaeSoftApStatusResultCallback r9) {
        final String r2 = "getStatus";
        final ICaeSoftApManager r3 = this.b.get();
        if (r3 == null) goto L6;
        this.e.execute(new CaeSoftApManager$$ExternalSyntheticLambda22(this, r2, r3, r8, r9));
        return;
    L6:
        c r10 = c.a(r8, r9);
        Object r11 = this.c;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.j == false) goto L15;
        b(r9, -10, "manager released");     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L15:
        final ICaeSoftApManager r4 = this.b.get();     // Catch: Throwable -> L13
        if (r4 == null) goto L20;
        this.e.execute(new CaeSoftApManager$$ExternalSyntheticLambda23(this, r2, r4, r8, r9));     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L20:
        a(r10);     // Catch: Throwable -> L13
        b();     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
    }

    public final void c() {
        Object r1 = this.c;
        monitor-enter(r1);
        ArrayList r2 = new ArrayList(this.f);     // Catch: Throwable -> L11
        this.f.clear();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        a((c) r3.next(), -8, "bindService returned false");
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public long getSoftApCapabilityBits() {
        ICaeSoftApManager r0 = d();
        if (r0 != null) goto L21;
        return 0;
    L21:
        return r0.getSoftApCapabilityBits();
    L10:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("getSoftApCapabilityBits RemoteException: ", e, "CaeSoftApManager");
        monitor-enter(this.c);
        this.b.compareAndSet(r0, null);     // Catch: Throwable -> L16
        return 0;
    L16:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        LogUtil.e("CaeSoftApManager", "getSoftApCapabilityBits failed: " + e);
        return 0;
    }

    public int getSoftApInterfaceVersion() {
        ICaeSoftApManager r0 = d();
        if (r0 != null) goto L21;
        return 0;
    L21:
        return r0.getSoftApInterfaceVersion();
    L10:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("getSoftApInterfaceVersion RemoteException: ", e, "CaeSoftApManager");
        monitor-enter(this.c);
        this.b.compareAndSet(r0, null);     // Catch: Throwable -> L16
        return 0;
    L16:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        LogUtil.e("CaeSoftApManager", "getSoftApInterfaceVersion failed: " + e);
        return 0;
    }

    public void getStatus(final CaeSoftApStatusResultCallback r2) {
        a(new CaeSoftApManager$$ExternalSyntheticLambda1(this, r2), r2);
    }

    public boolean isReady() {
        if (this.b.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void registerCallback(final ICaeSoftApCallback r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Object r0 = this.c;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.j == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L13:
        if (this.g.add(r3) == true) goto L15;
    L17:
        boolean r1 = false;
    L18:
        b();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (r1 == false) goto L26;
        this.e.execute(new CaeSoftApManager$$ExternalSyntheticLambda3(this, r3));
        return;
    L26:
        return;
    L15:
        if (this.b.get() == null) goto L17;
        r1 = true;
        goto L18
    }

    public void release() {
        Object r0 = this.c;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.j == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.j = true;     // Catch: Throwable -> L8
        this.i = false;     // Catch: Throwable -> L8
        ArrayList r1 = new ArrayList(this.f);     // Catch: Throwable -> L8
        this.f.clear();     // Catch: Throwable -> L8
        this.g.clear();     // Catch: Throwable -> L8
        this.b.set(null);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Iterator r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        a((c) r2.next(), -10, "manager released");
        goto L14
    L16:
        this.d.post(new CaeSoftApManager$$ExternalSyntheticLambda18(this));
        this.e.shutdownNow();
        monitor-enter(CaeSoftApManager.class);
    L21:
        th = move-exception;
        throw th;
    L19:
        if (k != this) goto L23;
        k = null;     // Catch: Throwable -> L21
    L23:
        monitor-exit(CaeSoftApManager.class);     // Catch: Throwable -> L21
    }

    public void startSoftAp(final CaeSoftApConfig r8, final ICaeSoftApCallback r9, final CaeSoftApRequestCallback r10) {
        if (r8 != null) goto L5;
        b(r10, -3, "config is null");
        return;
    L5:
        if (r9 != null) goto L7;
    L10:
        boolean r0 = false;
    L9:
        final boolean r6 = r0;
        a("startSoftAp", new CaeSoftApManager$$ExternalSyntheticLambda8(this, r9, r8, r10, r6), r10);
        return;
    L7:
        if (a(r9) == false) goto L10;
        r0 = true;
        goto L9
    }

    public void stopSoftAp(final CaeSoftApRequestCallback r3) {
        a("stopSoftAp", new CaeSoftApManager$$ExternalSyntheticLambda20(this, r3), r3);
    }

    public void unregisterCallback(final ICaeSoftApCallback r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Object r0 = this.c;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.j == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        this.g.remove(r3);     // Catch: Throwable -> L10
        if (this.b.get() == null) goto L15;
        boolean r1 = true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (r1 == false) goto L23;
        this.e.execute(new CaeSoftApManager$$ExternalSyntheticLambda6(this, r3));
        return;
    L23:
        return;
    L15:
        r1 = false;
        goto L16
    }

    public void warmUp() {
        Object r0 = this.c;
        monitor-enter(r0);
        b();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void b(final String r2, ICaeSoftApManager r3, e r4, final CaeSoftApRequestCallback r5) {
        a(r2, r3, r4, new CaeSoftApManager$$ExternalSyntheticLambda13(this, r5, r2));
    }

    private /* synthetic */ void e() {
        this.a.unbindService(this.h);     // Catch: Throwable -> L4
        return;
    }

    public final ICaeSoftApManager d() {
        ICaeSoftApManager r0 = this.b.get();
        if (r0 == null) goto L5;
        return r0;
    L5:
        Object r1 = this.c;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.j == true) goto L12;
        b();     // Catch: Throwable -> L10
    L12:
        ICaeSoftApManager r2 = this.b.get();     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r2;
    }

    private /* synthetic */ void b(CaeSoftApRequestCallback r2, String r3, int r4) {
        b(r2, r4, r3 + " request failed");
    }

    private /* synthetic */ void b(final String r2, ICaeSoftApManager r3, e r4, final CaeSoftApStatusResultCallback r5) {
        a(r2, r3, r4, new CaeSoftApManager$$ExternalSyntheticLambda0(this, r5, r2));
    }

    private /* synthetic */ void b(CaeSoftApStatusResultCallback r2, String r3, int r4) {
        b(r2, r4, r3 + " request failed");
    }

    public final void b() {
        if (this.j == false) goto L5;
        return;
    L5:
        if (this.b.get() == null) goto L7;
        return;
    L7:
        if (this.i == true) goto L13;
        this.i = true;
        this.d.post(new CaeSoftApManager$$ExternalSyntheticLambda9(this));
        return;
    }

    private /* synthetic */ void b(c r3) {
        Object r0 = this.c;
        monitor-enter(r0);
        boolean r1 = this.f.remove(r3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == false) goto L14;
        a(r3, -9, r3.a + " connect timeout");
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void d(ICaeSoftApCallback r3) {
        ICaeSoftApManager r0 = this.b.get();
        if (r0 == null) goto L12;
        r0.unregisterCallback(r3);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("unregisterCallback RemoteException: ", e, "CaeSoftApManager");
        return;
    }

    private /* synthetic */ void b(final c r3, final int r4) {
        this.d.post(new CaeSoftApManager$$ExternalSyntheticLambda7(r3, r4));
    }

    public final boolean b(ICaeSoftApCallback r3) {
        Object r0 = this.c;
        monitor-enter(r0);
        boolean r4 = this.g.contains(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(final CaeSoftApRequestCallback r3, final int r4, final String r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.d.post(new CaeSoftApManager$$ExternalSyntheticLambda16(r3, r4, r5));
    }

    public final void b(final CaeSoftApStatusResultCallback r3, final CaeSoftApStatus r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.d.post(new CaeSoftApManager$$ExternalSyntheticLambda19(r3, r4));
    }

    public final void b(final CaeSoftApStatusResultCallback r3, final int r4, final String r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.d.post(new CaeSoftApManager$$ExternalSyntheticLambda2(r3, r4, r5));
    }

    public static void b(c r0, int r1, String r2) {
        r0.d.onError(r1, r2);
    }

    public static /* synthetic */ Object a(CaeSoftApManager r0) {
        return r0.c;
    }

    public static /* synthetic */ Thread a(Runnable r2) {
        return new Thread(r2, "cae-softap-client");
    }

    private void a(ICaeSoftApCallback r2, CaeSoftApConfig r3, CaeSoftApRequestCallback r4, boolean r5, ICaeSoftApManager r6) throws RemoteException {
        if (r2 != null) goto L4;
    L6:
        ICaeSoftApCallback r0 = null;
    L7:
        int r7 = r6.startSoftAp(r3, r0);
        if (r7 != 0) goto L10;
        a(r4);
        return;
    L10:
        if (r5 == false) goto L19;
        Object r8 = this.c;
        monitor-enter(r8);
        this.g.remove(r2);     // Catch: Throwable -> L16
        monitor-exit(r8);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        b(r4, r7, "startSoftAp returned " + r7);
        return;
    L4:
        if (b(r2) == false) goto L6;
        r0 = r2;
        goto L7
    }

    private /* synthetic */ void a(CaeSoftApRequestCallback r3, ICaeSoftApManager r4) throws RemoteException {
        int r5 = r4.stopSoftAp();
        if (r5 != 0) goto L5;
        a(r3);
        return;
    L5:
        b(r3, r5, "stopSoftAp returned " + r5);
    }

    private /* synthetic */ void a(CaeSoftApStatusResultCallback r1, ICaeSoftApManager r2) throws RemoteException {
        b(r1, r2.getStatus());
    }

    public final void a(final String r9, final e r10, final CaeSoftApRequestCallback r11) {
        final ICaeSoftApManager r4 = this.b.get();
        if (r4 == null) goto L6;
        this.e.execute(new CaeSoftApManager$$ExternalSyntheticLambda11(this, r9, r4, r10, r11));
        return;
    L6:
        c r12 = c.a(r9, r10, r11);
        Object r13 = this.c;
        monitor-enter(r13);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.j == false) goto L15;
        b(r11, -10, "manager released");     // Catch: Throwable -> L13
        monitor-exit(r13);     // Catch: Throwable -> L13
        return;
    L15:
        final ICaeSoftApManager r14 = this.b.get();     // Catch: Throwable -> L13
        if (r14 == null) goto L20;
        this.e.execute(new CaeSoftApManager$$ExternalSyntheticLambda12(this, r9, r14, r10, r11));     // Catch: Throwable -> L13
        monitor-exit(r13);     // Catch: Throwable -> L13
        return;
    L20:
        a(r12);     // Catch: Throwable -> L13
        b();     // Catch: Throwable -> L13
        monitor-exit(r13);     // Catch: Throwable -> L13
    }

    private /* synthetic */ void a(CaeSoftApRequestCallback r2, String r3, int r4) {
        b(r2, r4, r3 + " request failed");
    }

    private /* synthetic */ void a(final String r2, ICaeSoftApManager r3, e r4, final CaeSoftApRequestCallback r5) {
        a(r2, r3, r4, new CaeSoftApManager$$ExternalSyntheticLambda17(this, r5, r2));
    }

    private /* synthetic */ void a(final String r2, ICaeSoftApManager r3, e r4, final CaeSoftApStatusResultCallback r5) {
        a(r2, r3, r4, new CaeSoftApManager$$ExternalSyntheticLambda10(this, r5, r2));
    }

    private /* synthetic */ void a(CaeSoftApStatusResultCallback r2, String r3, int r4) {
        b(r2, r4, r3 + " request failed");
    }

    public final void a() {
        if (this.j == false) goto L5;
        return;
    L5:
        if (this.b.get() != null) goto L28;
        Intent r0 = new Intent(ICaeSoftApManager.DESCRIPTOR);
        r0.setPackage("com.obric.cae");
        boolean r1 = this.a.bindService(r0, this.h, 1);     // Catch: Throwable -> L10
    L12:
        if (r1 == true) goto L21;
        LogUtil.e("CaeSoftApManager", "bindService returned false, action=com.obric.cae.libs.softap.ICaeSoftApManager");
        c();
        Object r2 = this.c;
        monitor-enter(r2);
        this.i = false;     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        return;
    L10:
        th = move-exception;
        LogUtil.e("CaeSoftApManager", "bindService failed: " + th);
        r1 = false;
        goto L12
    }

    public final void a(final c r4) {
        this.f.add(r4);
        Runnable r0 = new CaeSoftApManager$$ExternalSyntheticLambda14(this, r4);
        r4.e = r0;
        this.d.postDelayed(r0, BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS);
    }

    public static /* synthetic */ AtomicReference c(CaeSoftApManager r0) {
        return r0.b;
    }

    private void c(ICaeSoftApCallback r3) {
        ICaeSoftApManager r0 = this.b.get();
        if (r0 == null) goto L12;
        r0.registerCallback(r3);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("registerCallback RemoteException: ", e, "CaeSoftApManager");
        return;
    }

    public final void a(final c r4, final int r5, final String r6) {
        if (r4.c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Runnable r0 = r4.e;
        if (r0 == null) goto L8;
        this.d.removeCallbacks(r0);
    L8:
        this.d.post(new CaeSoftApManager$$ExternalSyntheticLambda21(r4, r5, r6));
    }

    public final void a(ICaeSoftApManager r4, final c r5) {
        if (r5.c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Runnable r0 = r5.e;
        if (r0 == null) goto L8;
        this.d.removeCallbacks(r0);
    L8:
        a(r5.a, r4, r5.b, new CaeSoftApManager$$ExternalSyntheticLambda4(this, r5));
    }

    public static void a(c r2, int r3) {
        r2.d.onError(r3, r2.a + " request failed");
    }

    public final void a(String r4, ICaeSoftApManager r5, e r6, b r7) {
        r6.a(r5);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        monitor-enter(this.c);
        this.b.compareAndSet(r5, null);     // Catch: Throwable -> L11
        LogUtil.e("CaeSoftApManager", r4 + " RemoteException: " + e);
        r7.a(-10);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean a(ICaeSoftApCallback r3) {
        Object r0 = this.c;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.j == false) goto L7;
    L11:
        boolean r4 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L7:
        if (this.g.add(r3) == false) goto L11;
        r4 = true;
        goto L12
    }

    public final void a(final CaeSoftApRequestCallback r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.d.post(new CaeSoftApManager$$ExternalSyntheticLambda5(r3));
    }

    public static /* synthetic */ void a(CaeSoftApRequestCallback r0, int r1, String r2) {
        r0.onError(r1, r2);
    }

    public static /* synthetic */ void a(CaeSoftApStatusResultCallback r0, CaeSoftApStatus r1) {
        r0.onSuccess(r1);
    }

    public static /* synthetic */ void a(CaeSoftApStatusResultCallback r0, int r1, String r2) {
        r0.onError(r1, r2);
    }
}
