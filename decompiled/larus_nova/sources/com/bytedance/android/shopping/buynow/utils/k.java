package com.bytedance.android.shopping.buynow.utils;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f171215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f171216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f171217c;

    public k(String r100, boolean r101, boolean r102) {
        this.f171215a = r100;
        this.f171216b = r101;
        this.f171217c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.sdk.helper.i r100 = com.bytedance.android.ec.sdk.helper.i.f48124a;     // Catch: Throwable -> L7
        Context r101 = ECAppInfoService.f48114e.getApplicationContext();     // Catch: Throwable -> L7
        String r102 = this.f171215a;     // Catch: Throwable -> L7
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r100.e(r101, r102, this.f171216b, this.f171217c);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
