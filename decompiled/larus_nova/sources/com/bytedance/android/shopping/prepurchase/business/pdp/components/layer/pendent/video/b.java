package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f181527a;

    public b(c.a r100) {
        this.f181527a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f181527a.f181532a.f181531d.f181515i.a(false, "pause");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
