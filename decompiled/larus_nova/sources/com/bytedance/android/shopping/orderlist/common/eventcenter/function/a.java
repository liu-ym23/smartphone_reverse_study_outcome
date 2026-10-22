package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.orderlist.common.controller.h f179780a;

    public a(com.bytedance.android.shopping.orderlist.common.controller.h r100) {
        this.f179780a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f179780a.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
