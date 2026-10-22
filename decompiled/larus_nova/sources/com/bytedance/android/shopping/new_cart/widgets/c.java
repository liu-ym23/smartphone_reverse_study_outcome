package com.bytedance.android.shopping.new_cart.widgets;

import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECCartErrorView f179469a;

    public c(ECCartErrorView r100) {
        this.f179469a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CartLinkedScrollViewV2 r100 = this.f179469a.f179446d;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.setOuterHeight(r100.getHeight());     // Catch: Throwable -> L7
    L5:
        this.f179469a.setVisibility(8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
