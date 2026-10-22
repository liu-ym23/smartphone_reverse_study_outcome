package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class na implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tlc.d f63569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wa f63570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f63571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CallContext f63572d;

    public na(tlc.d r100, wa r101, String r102, CallContext r103) {
        this.f63569a = r100;
        this.f63570b = r101;
        this.f63571c = r102;
        this.f63572d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        wa.k(this.f63570b, this.f63569a, this.f63571c, this.f63572d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
