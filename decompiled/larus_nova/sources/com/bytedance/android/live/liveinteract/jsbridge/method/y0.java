package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class y0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tlc.d f74267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b1 f74268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f74269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CallContext f74270d;

    public y0(tlc.d r100, b1 r101, String r102, CallContext r103) {
        this.f74267a = r100;
        this.f74268b = r101;
        this.f74269c = r102;
        this.f74270d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b1.j(this.f74268b, this.f74267a, this.f74269c, this.f74270d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
