package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.server.IServerBroker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: MatrixBinderManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static final String TAG = "MatrixBinderManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f33701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IBinder f33702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static IServerBroker f33703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f33704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f33705e;
    private static Handler f;
    private static boolean g;
    private static Runnable h;
    private static final Set<e> i = null;
    private static final CopyOnWriteArraySet<b> j = null;
    private static boolean k;
    private static final MatrixBinderManager$serviceConnection$1 l = null;
    private static final Runnable m = null;

    /* JADX INFO: renamed from: lambda$GU0sG44pNGg-emdKoctp-XEwexs, reason: not valid java name */
    public static /* synthetic */ void m950lambda$GU0sG44pNGgemdKoctpXEwexs() {
        i();
    }

    public static /* synthetic */ void lambda$h93eYnztVauFmvwIHATRPBFP0nw() {
        h();
    }

    private d() {
    }

    public static final /* synthetic */ void a(d r0, boolean r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ Runnable g() {
        return m;
    }

    public final void a(IBinder r2) {
        f33702b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
    }

    public final void a(IServerBroker r2) {
        f33703c = (IServerBroker) ZeusTransformUtils.wrapperContextForParams(r2, IServerBroker.class, "com.obric.aiagent.plugin");
    }

    public final IServerBroker a() {
        com.obric.matrix.platform.sdk.ones.b.f33630a.c();
        return f33703c;
    }

    public final long b() {
        return f33704d;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixBinderManager$serviceConnection$1] */
    static {
        f33701a = new d();
        f33705e = WsConstants.EXIT_DELAY_TIME;
        f = new Handler(Looper.getMainLooper());
        h = $$Lambda$d$h93eYnztVauFmvwIHATRPBFP0nw.INSTANCE;
        i = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        j = new CopyOnWriteArraySet();
        l = new MatrixBinderManager$serviceConnection$1();
        m = $$Lambda$d$GU0sG44pNGgemdKoctpXEwexs.INSTANCE;
    }

    public final Handler c() {
        return f;
    }

    public final void a(boolean r1) {
        g = r1;
    }

    public final boolean d() {
        return g;
    }

    private static final void h() {
        d r0 = f33701a;
        g = false;
        a(r0, null, 1, null);
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "called reConnectRunnable", null, 4, null);
        f33704d = f33705e;
    }

    public final CopyOnWriteArraySet<b> e() {
        return j;
    }

    public static /* synthetic */ void a(d r1, e r2, int r3, Object r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.a(r5);
    }

    public final synchronized void a(e r9) {
        monitor-enter(this);
        e r10 = (e) ZeusTransformUtils.wrapperContextForParams(r9, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "start connect binder isbinding " + g, null, 4, null);     // Catch: Throwable -> L32
        com.obric.matrix.platform.sdk.ones.b.f33630a.c();     // Catch: Throwable -> L32
        b(r10);     // Catch: Exception -> L35 Throwable -> L32
        if (g == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (a() == null) goto L21;
        IBinder r11 = f33702b;     // Catch: Exception -> L35 Throwable -> L32
        if (r11 == null) goto L21;
        if (r11 != null) goto L14;
    L16:
        boolean r12 = false;
    L17:
        if (r12 == false) goto L21;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "binder alive , don't need rebind", null, 4, null);     // Catch: Exception -> L35 Throwable -> L32
        b(true);     // Catch: Exception -> L35 Throwable -> L32
        monitor-exit(this);
        return;
    L14:
        if (r11.isBinderAlive() != true) goto L16;
        r12 = true;
    L21:
        g = true;     // Catch: Exception -> L35 Throwable -> L32
        Intent r13 = new Intent();     // Catch: Exception -> L35 Throwable -> L32
        r13.setComponent(new ComponentName("com.obric.matrix", "com.obric.matrix.server.MatrixServer"));     // Catch: Exception -> L35 Throwable -> L32
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.b.f33630a.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L35 Throwable -> L32
        if (r4 == null) goto L24;
        Boolean r14 = Boolean.valueOf(ZeusTransformUtils.bindService(r4, r13, (ServiceConnection) ZeusTransformUtils.preCheckCast(l, ServiceConnection.class, "com.obric.aiagent.plugin"), 1, "com.obric.aiagent.plugin"));     // Catch: Exception -> L35 Throwable -> L32
    L25:
        com.obric.matrix.platform.sdk.ones.internal.a.a.f33679a.a(r14);     // Catch: Exception -> L35 Throwable -> L32
        if (o.a(r14, true) == true) goto L28;
        com.obric.matrix.platform.sdk.ones.internal.b.b.e(TAG, "CallBinder call reConnect bind result = " + r14, null, 4, null);     // Catch: Exception -> L35 Throwable -> L32
        Handler r1 = f;     // Catch: Exception -> L35 Throwable -> L32
        Runnable r5 = m;     // Catch: Exception -> L35 Throwable -> L32
        r1.removeCallbacks(r5);     // Catch: Exception -> L35 Throwable -> L32
        f.postDelayed(r5, f33704d);     // Catch: Exception -> L35 Throwable -> L32
        b(false);     // Catch: Exception -> L35 Throwable -> L32
    L29:
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "initBinder: bindResult = " + r14, null, 4, null);     // Catch: Exception -> L35 Throwable -> L32
        goto L30
    L28:
        Handler r0 = f;     // Catch: Exception -> L35 Throwable -> L32
        Runnable r2 = m;     // Catch: Exception -> L35 Throwable -> L32
        r0.removeCallbacks(r2);     // Catch: Exception -> L35 Throwable -> L32
        f.postDelayed(r2, f33705e);     // Catch: Exception -> L35 Throwable -> L32
        goto L29
    L24:
        r14 = null;
    L30:
        monitor-exit(this);
        return;
    L32:
        th = move-exception;
        throw th;
    }

    private static final void i() {
        StringBuilder r0 = new StringBuilder().append("CallBinder post delay in handler bind = ");
        d r1 = f33701a;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, r0.append(r1.a()).append(", isBinding = ").append(g).toString(), null, 4, null);
        if (r1.a() != null) goto L6;
        g = false;
        h.run();
        return;
    }

    private final synchronized void b(e r3) {
        monitor-enter(this);
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r4 == null) goto L6;
        i.add(r4);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final synchronized void b(boolean r6) {
        monitor-enter(this);
        StringBuilder r1 = new StringBuilder().append("onConnectCallbackResult isconnected ").append(r6).append(' ');     // Catch: Throwable -> L10
        Set<e> r2 = i;     // Catch: Throwable -> L10
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, r1.append(r2.size()).toString(), null, 4, null);     // Catch: Throwable -> L10
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        ((e) ZeusTransformUtils.preCheckCast(r0.next(), e.class, "com.obric.aiagent.plugin")).a(r6);     // Catch: Throwable -> L10
        goto L5
    L7:
        i.clear();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void f() {
        if (a() == null) goto L12;
        IBinder r0 = f33702b;
        if (r0 == null) goto L12;
        boolean r2 = false;
        if (r0 != null) goto L9;
    L11:
        if (r2 == true) goto L12;
        return;
    L9:
        if (r0.isBinderAlive() == true) goto L11;
        r2 = true;
    L12:
        a(this, null, 1, null);
    }

    public final synchronized void b(IServerBroker r3) {
        monitor-enter(this);
        o.e((IServerBroker) ZeusTransformUtils.wrapperContextForParams(r3, IServerBroker.class, "com.obric.aiagent.plugin"), "binder");     // Catch: Throwable -> L8
        if (k == true) goto L6;
        k = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(ComponentName r2) {
        monitor-enter(this);
        o.e(r2, "name");     // Catch: Throwable -> L6
        k = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
