package com.bytedance.android.window.shop.widget;

import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowTypeSeparatedAdapter f190133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECLynxCardEvent f190134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.f f190135c;

    public y(WindowTypeSeparatedAdapter r100, ECLynxCardEvent r101, com.bytedance.android.window.shop.repository.tab.entity.f r102) {
        this.f190133a = r100;
        this.f190134b = r101;
        this.f190135c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j r100 = this.f190133a.f189958n.get(this.f190134b);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        com.bytedance.android.window.shop.repository.tab.entity.f r101 = this.f190135c;     // Catch: Throwable -> L6
        WindowTypeSeparatedAdapter r102 = this.f190133a;     // Catch: Throwable -> L6
        r100.a(r101, r102.f189952h, r102);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
