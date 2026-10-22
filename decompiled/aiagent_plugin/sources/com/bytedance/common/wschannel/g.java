package com.bytedance.common.wschannel;

import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.message.PushThreadHandlerManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SocketHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f6956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakHandler f6957b;

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    public static g a() {
        if (f6956a != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6956a != null) goto L9;
        f6956a = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f6956a;
    }

    private g() {
        if (f6957b != null) goto L10;
        f6957b = PushThreadHandlerManager.inst().getHandler();     // Catch: Throwable -> L6
        return;
    L6:
        HandlerThread r0 = new HandlerThread("WsHT");
        r0.start();
        f6957b = new WeakHandler(r0.getLooper(), this);
        return;
    }

    public WeakHandler b() {
        return f6957b;
    }

    public void a(Runnable r3) {
        a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), 0);
    }

    public void a(Runnable r3, long r4) {
        Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r4 > 0) goto L5;
        f6957b.post(r2);
        return;
    L5:
        f6957b.postDelayed(r2, r4);
    }
}
