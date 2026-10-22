package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import com.larus.apm.impl.protector.RunnableProtector;
import kk.d;

/* JADX INFO: loaded from: classes13.dex */
public final class MallDeliveryMonitor$MallDeliveryLifecycleCallback$unregisterRunnable$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MallDeliveryMonitor.MallDeliveryLifecycleCallback f170383a;

    public MallDeliveryMonitor$MallDeliveryLifecycleCallback$unregisterRunnable$1(MallDeliveryMonitor.MallDeliveryLifecycleCallback r100) {
        this.f170383a = r100;
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
