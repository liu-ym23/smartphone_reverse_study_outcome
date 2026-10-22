package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.common.utility.Logger;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DomainPreConnect.a f44875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f44876b;

    public o(DomainPreConnect.a r100, long r101) {
        this.f44875a = r100;
        this.f44876b = r101;
    }

    public final void a() {
        Logger.d("ImageDomainPreConnectConfig", "onPost");
        DomainPreConnect r100 = DomainPreConnect.f44729c;
        DomainPreConnect.a r101 = this.f44875a;
        long r102 = this.f44876b;
        r100.getClass();
        if (r101.f44730a == r102) goto L5;
        return;
    L5:
        if (r101.f44731b == true) goto L8;
        return;
    L8:
        if ((System.nanoTime() - r101.f44732c) > r101.f44734e) goto L21;
        r101.f44731b = false;
        return;
    L21:
        TTNetInit.preconnectUrl(r101.f44733d);     // Catch: Throwable -> L12
        Logger.d("ImageDomainPreConnectConfig", "preConnectUrl " + r101.f44733d);     // Catch: Throwable -> L12
    L14:
        r101.f44732c = System.nanoTime();
        r101.f44731b = false;
        return;
    L12:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "url " + r101.f44733d);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r101.f44732c = System.nanoTime();
        r101.f44731b = false;
        throw th;
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
}
