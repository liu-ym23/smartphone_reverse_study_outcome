package com.bytedance.android.window.shop.home;

import android.app.Activity;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.p;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f188191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f188192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f188193c;

    public g(String r100, String r101, String r102) {
        this.f188191a = r100;
        this.f188192b = r101;
        this.f188193c = r102;
    }

    public final void a() {
        Activity r100 = ECAppInfoService.f48114e.getCurrentActivity();
        m0 r101 = new m0(this.f188191a);
        r101.b("author_id", this.f188192b);
        r101.b("sec_author_id", this.f188193c);
        String r102 = r101.c();
        p.f48130a.openSchema(r100, r102);
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
