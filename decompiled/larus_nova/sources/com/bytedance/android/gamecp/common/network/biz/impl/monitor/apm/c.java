package com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm;

import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes44.dex */
public final class c<I, D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f56670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<D> f56671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<I, D> f56672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public D f56673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f56674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f56675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.b f56676g;

    public interface a<D> {
        boolean accept(D r100);
    }

    public interface b<Input, O> {
        O a(Input r100, O r101);
    }

    public final void a(I r100) {
        if (this.f56676g != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f56676g != null) goto L8;
        this.f56676g = new com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.b(this, this.f56675f.getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L13:
        if (r100 == null) goto L20;
        com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm.b r101 = this.f56676g;
        if (r101 == null) goto L21;
        Message r102 = Message.obtain(r101);
        r102.what = 2;
        r102.obj = r100;
        r102.sendToTarget();
        return;
    L21:
        return;
    }

    public c(long r100, a<D> r101, b<I, D> r102) {
        this.f56674e = new AtomicBoolean(false);
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2("BufferHandler");
        this.f56675f = r103;
        this.f56670a = r100;
        this.f56671b = r101;
        this.f56672c = r102;
        ThreadMethodProxy.start(r103);
    }
}
