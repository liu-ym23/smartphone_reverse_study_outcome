package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import com.larus.apm.impl.protector.RunnableProtector;
import kk.d;

/* JADX INFO: loaded from: classes13.dex */
public final class MallDeliveryLifecycleGeneralCallback$unregisterRunnable$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MallDeliveryLifecycleGeneralCallback f170343a;

    public MallDeliveryLifecycleGeneralCallback$unregisterRunnable$1(MallDeliveryLifecycleGeneralCallback r100) {
        this.f170343a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.c(new AnonymousClass1(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
