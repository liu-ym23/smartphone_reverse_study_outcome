package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class pa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.ugc.live.sdk.message.wrsc.data.a f63605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wa f63606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallContext f63607c;

    public pa(com.ss.ugc.live.sdk.message.wrsc.data.a r100, wa r101, CallContext r102) {
        this.f63605a = r100;
        this.f63606b = r101;
        this.f63607c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        wa.j(this.f63606b, this.f63605a, this.f63607c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
