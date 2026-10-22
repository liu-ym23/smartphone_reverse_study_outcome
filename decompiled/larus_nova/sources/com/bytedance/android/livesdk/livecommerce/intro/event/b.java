package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IntroCardEventCenter f148242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f148243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.btm.api.model.d f148244c;

    public b(IntroCardEventCenter r100, String r101, com.bytedance.android.btm.api.model.d r102) {
        this.f148242a = r100;
        this.f148243b = r101;
        this.f148244c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.common.api.jump.model.g r100 = IntroCardEventCenter.c(this.f148242a);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        IntroCardEventCenter r101 = this.f148242a;     // Catch: Throwable -> L6
        v r102 = new v("livesdk_show_auction_hot_sale", r100);     // Catch: Throwable -> L6
        r102.c("atmosphere_type", this.f148243b);     // Catch: Throwable -> L6
        r101.d(r102, this.f148244c.f42022a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
