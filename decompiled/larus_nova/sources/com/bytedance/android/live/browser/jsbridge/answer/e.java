package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tlc.d f62929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f62930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f62931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f62932d;

    public e(tlc.d r100, h r101, String r102, IBDXBridgeContext r103) {
        this.f62929a = r100;
        this.f62930b = r101;
        this.f62931c = r102;
        this.f62932d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.a(this.f62930b, this.f62929a, this.f62931c, this.f62932d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
