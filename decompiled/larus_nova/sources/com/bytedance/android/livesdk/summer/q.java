package com.bytedance.android.livesdk.summer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.summer.ISummerTask;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes11.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ISummerTask f158486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f158487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f158488c;

    public final void a() {
        if (this.f158486a != null) goto L5;
        return;
    L5:
        ALogger.i("BDLog", "summer task process: " + this.f158486a.toString() + "; in " + ThreadMethodProxy.currentThread().getName());
        if (this.f158488c.f158490b.contains(Integer.valueOf(this.f158487b)) == false) goto L8;
        this.f158486a.cancelTask();
        this.f158488c.f158490b.remove(Integer.valueOf(this.f158487b));
    L8:
        this.f158486a.processTask();
        this.f158486a.releaseTask();
        this.f158488c.f158489a.remove(Integer.valueOf(this.f158487b));
        ALogger.i("BDLog", "summer sync task end: " + this.f158486a.toString());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q(r r100, ISummerTask r101, int r102) {
        this.f158488c = r100;
        this.f158486a = r101;
        this.f158487b = r102;
    }
}
