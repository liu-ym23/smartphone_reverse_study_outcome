package com.bytedance.android.shopping.buynow.yata.abilities;

import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pa3.a f171293a;

    public h(pa3.a r100) {
        this.f171293a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        pa3.a r100 = this.f171293a;     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        BuyNowFirstScreenMonitor r101 = r100.f528357a;     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        r101.a(BuyNowFirstScreenNode.CACHE_RENDER_END, System.currentTimeMillis());     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
