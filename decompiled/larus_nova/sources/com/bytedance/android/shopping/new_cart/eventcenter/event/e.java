package com.bytedance.android.shopping.new_cart.eventcenter.event;

import com.bytedance.android.shopping.new_cart.components.CartBodyComponent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CartBodyComponent f179057a;

    public e(CartBodyComponent r100) {
        this.f179057a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f179057a.s();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
