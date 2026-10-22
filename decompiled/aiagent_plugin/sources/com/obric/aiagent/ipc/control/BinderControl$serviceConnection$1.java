package com.obric.aiagent.ipc.control;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.obric.aiagent.ipc.utils.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o;
import d.x;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: BinderControl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderControl$serviceConnection$1 implements ServiceConnection {
    final /* synthetic */ a this$0;

    BinderControl$serviceConnection$1(a r1) {
        this.this$0 = r1;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r6, IBinder r7) {
        final IBinder r8 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r7, IBinder.class, "com.obric.aiagent.plugin");
        final a r9 = this.this$0;
        monitor-enter(r9);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (a.f(r9) == true) goto L9;
        h.f18670a.a("IPCControl", "onServiceConnected: ignore, not bound");     // Catch: Throwable -> L31
        monitor-exit(r9);
        return;
    L9:
        if (r8 != null) goto L13;
        h.f18670a.a("IPCControl", "onServiceConnected: service is null");     // Catch: Throwable -> L31
        monitor-exit(r9);
        return;
    L13:
        h.f18670a.a("IPCControl", "onServiceConnected: " + a.c(r9) + ", this=" + r9);     // Catch: Throwable -> L31
        ca r0 = a.g(r9);     // Catch: Throwable -> L31
        if (r0 == null) goto L16;
        ca.a.a(r0, null, 1, null);     // Catch: Throwable -> L31
    L16:
        a.a(r9, null);     // Catch: Throwable -> L31
        a.h(r9);     // Catch: Throwable -> L31
        n.a r1 = n.f38560a;     // Catch: Throwable -> L19
        BinderControl$serviceConnection$1 r5 = (BinderControl$serviceConnection$1) ZeusTransformUtils.preCheckCast(this, BinderControl$serviceConnection$1.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        IBinder.DeathRecipient r10 = new BinderControl$serviceConnection$1$onServiceConnected$1$1$dr$1(r9, r8);     // Catch: Throwable -> L19
        r8.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r10, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L19
        a.a(r9, (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r10, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        a.b(r9, r8);     // Catch: Throwable -> L19
        a.a(r9, false);     // Catch: Throwable -> L19
        a.b(r9, true);     // Catch: Throwable -> L19
        h.f18670a.a("IPCControl", "onReady: " + a.c(r9) + ",callback = " + a.d(r9) + ", instance = " + a.a(r9));     // Catch: Throwable -> L19
        Object r11 = n.f(x.f38692a);     // Catch: Throwable -> L19
    L21:
        Throwable r12 = n.c(r11);     // Catch: Throwable -> L31
        if (r12 == null) goto L26;
        h.f18670a.a("IPCControl", "onReady fail " + d.a.a(r12), r12);     // Catch: Throwable -> L31
        a.e(r9);     // Catch: Throwable -> L31
        a.b(r9, null);     // Catch: Throwable -> L31
        a.b(r9, 3);     // Catch: Throwable -> L31
        monitor-exit(r9);
        return;
    L26:
        c.a r13 = a.d(r9);     // Catch: Throwable -> L31
        if (r13 == null) goto L29;
        r13.a(r8);     // Catch: Throwable -> L31
        x r14 = x.f38692a;     // Catch: Throwable -> L31
    L29:
        monitor-exit(r9);
        return;
    L19:
        th = move-exception;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L31
        r11 = n.f(o.a(th));     // Catch: Throwable -> L31
        goto L21
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r6) {
        a r7 = this.this$0;
        monitor-enter(r7);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (a.f(r7) == true) goto L9;
        h.f18670a.a("IPCControl", "onServiceDisconnected: ignore, not bound");     // Catch: Throwable -> L24
        monitor-exit(r7);
        return;
    L9:
        h.f18670a.a("IPCControl", "onServiceDisconnected: " + a.c(r7) + ", this=" + r7);     // Catch: Throwable -> L24
        ca r0 = a.g(r7);     // Catch: Throwable -> L24
        if (r0 == null) goto L12;
        ca.a.a(r0, null, 1, null);     // Catch: Throwable -> L24
    L12:
        a.a(r7, null);     // Catch: Throwable -> L24
        a.h(r7);     // Catch: Throwable -> L24
        a.b(r7, null);     // Catch: Throwable -> L24
        a.e(r7);     // Catch: Throwable -> L24
        a.a(r7, false);     // Catch: Throwable -> L24
        c.a r1 = a.d(r7);     // Catch: Throwable -> L24
        if (r1 == null) goto L16;
        r1.a();     // Catch: Throwable -> L24
    L16:
        if (a.d(r7) != null) goto L18;
    L20:
        h.f18670a.a("IPCControl", "onServiceDisconnected: callback replaced, not rebind, this=" + this + ", callback=" + a.d(r7) + ",currentCallback=" + r1);     // Catch: Throwable -> L24
    L21:
        x r5 = x.f38692a;     // Catch: Throwable -> L24
        monitor-exit(r7);
        return;
    L18:
        if (a.d(r7) != r1) goto L20;
        a.b(r7, 2);     // Catch: Throwable -> L24
        goto L21
    }
}
