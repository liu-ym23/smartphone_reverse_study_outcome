package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f171218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f171219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f171220c;

    public l(int r100, boolean r101, boolean r102) {
        this.f171218a = r100;
        this.f171219b = r101;
        this.f171220c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.sdk.helper.i.f48124a.e(ECAppInfoService.f48114e.getApplicationContext(), com.bytedance.android.shopping.extensions.j.c(this.f171218a), this.f171219b, this.f171220c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
