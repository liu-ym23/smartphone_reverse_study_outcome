package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.CycleActivityView41;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CycleActivityView41 f177812a;

    public c(CycleActivityView41 r100) {
        this.f177812a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.b r100 = this.f177812a.f177672j;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.cancel();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
