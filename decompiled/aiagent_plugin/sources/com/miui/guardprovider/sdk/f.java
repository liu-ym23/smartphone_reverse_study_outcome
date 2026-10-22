package com.miui.guardprovider.sdk;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ICancellationSignal;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.miui.guardprovider.aidl.IVirusScanServer;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: VirusScanManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile IVirusScanServer f13928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f13929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f13930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f13931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f13932e;
    private final ServiceConnection f;

    static /* synthetic */ IVirusScanServer a(f r2, IVirusScanServer r3) {
        IVirusScanServer r4 = (IVirusScanServer) ZeusTransformUtils.wrapperContextForParams(r3, IVirusScanServer.class, "com.obric.aiagent.plugin");
        r2.f13928a = r4;
        return r4;
    }

    static /* synthetic */ Object a(f r0) {
        return r0.f13931d;
    }

    static /* synthetic */ boolean a(f r0, boolean r1) {
        r0.f13929b = r1;
        return r1;
    }

    static /* synthetic */ boolean b(f r0, boolean r1) {
        r0.f13930c = r1;
        return r1;
    }

    public f(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f13931d = new Object();
        this.f = new VirusScanManager$1(this);
        Objects.requireNonNull(r4);
        this.f13932e = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    public boolean a() {
        return a.a(this.f13932e);
    }

    public void b() {
        Object r0 = this.f13931d;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f13929b == false) goto L7;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L7:
        if (this.f13930c == true) goto L16;
        if (ZeusTransformUtils.bindService(this.f13932e, com.miui.guardprovider.b.f13912a, this.f, 1, "com.obric.aiagent.plugin") == false) goto L15;
        this.f13930c = true;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L15:
        throw new UnsupportedOperationException("Unsupported service.");     // Catch: Throwable -> L18
    }

    public boolean c() {
        return a(0);
    }

    public boolean a(long r2) {
        b();
        Object r0 = this.f13931d;
        monitor-enter(r0);
        b(r2);     // Catch: Throwable -> L7
        boolean r1 = this.f13929b;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void b(long r8) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L25;
        if (r8 <= 0) goto L7;
        long r3 = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(r8);
    L8:
        Thread r9 = Thread.currentThread();
    L10:
        if (this.f13930c == false) goto L36;
        if (this.f13929b == true) goto L37;
        if (r9.isInterrupted() == true) goto L38;
        if (r8 <= 0) goto L20;
        long r5 = TimeUnit.NANOSECONDS.toMillis(r3 - System.nanoTime());     // Catch: InterruptedException -> L22
        if (r5 <= 0) goto L18;
        this.f13931d.wait(r5);     // Catch: InterruptedException -> L22
        goto L10
    L18:
        return;
    L22:
        r9.interrupt();
        return;
    L20:
        this.f13931d.wait();     // Catch: InterruptedException -> L22
        goto L10
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L7:
        r3 = 0;
        goto L8
    L25:
        throw new IllegalStateException("waitForBindingLocked must not be called on main thread");
    }

    public void d() {
        Object r0 = this.f13931d;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f13929b == false) goto L7;
    L8:
        ZeusTransformUtils.unbindService(this.f13932e, this.f, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        this.f13929b = false;     // Catch: Throwable -> L11
        this.f13930c = false;     // Catch: Throwable -> L11
        this.f13931d.notifyAll();     // Catch: Throwable -> L11
        this.f13928a = null;     // Catch: Throwable -> L11
        a("AntivirusManagerV2", "unbind");     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.f13930c == false) goto L9;
        goto L8
    }

    public void a(List<String> r3, Executor r4, CancellationSignal r5, b r6, d r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r8);
        if (r8.isEmpty() == true) goto L19;
        Objects.requireNonNull(r9);
        Objects.requireNonNull(r10);
        if (r5 == null) goto L7;
        r5.throwIfCanceled();
    L7:
        VirusScanStateTransport r11 = VirusScanStateTransport.createTransport(r9, r10, r5);
        IVirusScanServer r2 = e();
        if (r6 == null) goto L10;
        Bundle r12 = r6.b();     // Catch: RemoteException -> L15
    L11:
        ICancellationSignal r13 = r2.startScanWithPackageNames(r8, r11, r12);     // Catch: RemoteException -> L15
        if (r5 == null) goto L22;
        com.miui.guardprovider.a.a(r5, r13);
        return;
    L22:
        return;
    L10:
        r12 = b.a();     // Catch: RemoteException -> L15
    L15:
        e = move-exception;
        throw new RuntimeException(e);
    L19:
        throw new IllegalArgumentException("packageNames is empty.");
    }

    public void update(Executor r3, CancellationSignal r4, e r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r6);
        Objects.requireNonNull(r7);
        if (r4 == null) goto L5;
        r4.throwIfCanceled();
    L5:
        UpdateStateTransport r0 = new UpdateStateTransport(r6, r7, r4);
        ICancellationSignal r2 = e().update(r0);     // Catch: RemoteException -> L10
        if (r4 == null) goto L15;
        com.miui.guardprovider.a.a(r4, r2);
        return;
    L15:
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private IVirusScanServer e() {
        IVirusScanServer r1 = this.f13928a;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("You have lost the connection.Perhaps you should call prepare first.");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
