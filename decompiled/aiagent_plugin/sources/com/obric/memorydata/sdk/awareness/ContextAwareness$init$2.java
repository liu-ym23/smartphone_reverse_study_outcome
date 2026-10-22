package com.obric.memorydata.sdk.awareness;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: ContextAwareness.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ContextAwareness$init$2 implements ServiceConnection {
    public static /* synthetic */ boolean lambda$XxFQd_f4bACMWibMN8J0lFzpLcA(IBinder r0, IBinder.DeathRecipient r1) {
        return onServiceConnected$lambda$3$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$tMetOW5T8trzAg-tiOmk9SW84Q0, reason: not valid java name */
    public static /* synthetic */ void m951lambda$tMetOW5T8trzAgtiOmk9SW84Q0(ContextAwareness$init$2 r0, IBinder r1) {
        onServiceConnected$lambda$0(r0, r1);
    }

    ContextAwareness$init$2() {
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r6, IBinder r7) {
        final IBinder r8 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r7, IBinder.class, "com.obric.aiagent.plugin");
        o.e(r6, "className");
        o.e(r8, "binder");
        final IBinder.DeathRecipient r9 = new $$Lambda$ContextAwareness$init$2$tMetOW5T8trzAgtiOmk9SW84Q0(this, r8);
        a r0 = a.f33811a;
        monitor-enter(r0);
    L35:
        th = move-exception;
        throw th;
    L5:
        if (this == a.c()) goto L7;
        boolean r1 = false;
    L9:
        monitor-exit(r0);
        if (r1 == true) goto L38;
        return;
    L38:
        r8.linkToDeath(r9, 0);     // Catch: RemoteException -> L32
        a r2 = a.f33811a;
        monitor-enter(r2);
    L29:
        th = move-exception;
        throw th;
    L16:
        if (this == a.c()) goto L18;
    L26:
        com.obric.memorydata.sdk.c.a(new $$Lambda$ContextAwareness$init$2$XxFQd_f4bACMWibMN8J0lFzpLcA(r8, r9));     // Catch: Throwable -> L29
        monitor-exit(r2);
        return;
    L18:
        if (r8 != a.d()) goto L26;
        if (r9 != a.e()) goto L26;
        a r5 = a.f33811a;     // Catch: Throwable -> L29
        a.a(IContextAwarenessService.Stub.asInterface(r8));     // Catch: Throwable -> L29
        List r10 = a.b(a.f33811a);     // Catch: Throwable -> L29
        monitor-exit(r2);
        com.obric.memorydata.sdk.a.d.f33797a.b("ContextAwareness", "ContextAwarenessService connected");
        a.a(a.f33811a, r10, 0, "ContextAwarenessService connected");
        a.a(a.f33811a);
        return;
    L32:
        e = move-exception;
        com.obric.memorydata.sdk.a.d.f33797a.a("ContextAwareness", "linkToDeath failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        a.a(a.f33811a, (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.aiagent.plugin"), r8);
        return;
    L7:
        a r3 = a.f33811a;     // Catch: Throwable -> L35
        a.a(r8);     // Catch: Throwable -> L35
        a r4 = a.f33811a;     // Catch: Throwable -> L35
        a.a(r9);     // Catch: Throwable -> L35
        r1 = true;
        goto L9
    }

    private static final void onServiceConnected$lambda$0(ContextAwareness$init$2 r8, IBinder r9) {
        IBinder r10 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r9, IBinder.class, "com.obric.aiagent.plugin");
        com.obric.memorydata.sdk.a.d.a(com.obric.memorydata.sdk.a.d.f33797a, "ContextAwareness", "ContextAwarenessService died", null, 4, null);
        a.a(a.f33811a, (ServiceConnection) ZeusTransformUtils.preCheckCast(r8, ServiceConnection.class, "com.obric.aiagent.plugin"), r10);
    }

    private static final boolean onServiceConnected$lambda$3$lambda$2(IBinder r2, IBinder.DeathRecipient r3) {
        return ((IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin")).unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r4) {
        o.e(r4, "comp");
        a r0 = a.f33811a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this == a.c()) goto L8;
        monitor-exit(r0);
        return;
    L8:
        a r3 = a.f33811a;     // Catch: Throwable -> L12
        a.a(null);     // Catch: Throwable -> L12
        x r5 = x.f38692a;     // Catch: Throwable -> L12
        monitor-exit(r0);
        com.obric.memorydata.sdk.a.d.f33797a.b("ContextAwareness", "ContextAwarenessService disconnected " + r4);
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r4) {
        com.obric.memorydata.sdk.a.d.f33797a.b("ContextAwareness", "ContextAwarenessService binding died " + r4);
        a.a(a.f33811a, (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.aiagent.plugin"), null, 2, null);
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r4) {
        com.obric.memorydata.sdk.a.d.f33797a.c("ContextAwareness", "ContextAwarenessService onNullBinding " + r4);
        a.a(a.f33811a, (ServiceConnection) ZeusTransformUtils.preCheckCast(this, ServiceConnection.class, "com.obric.aiagent.plugin"), null, 2, null);
    }
}
