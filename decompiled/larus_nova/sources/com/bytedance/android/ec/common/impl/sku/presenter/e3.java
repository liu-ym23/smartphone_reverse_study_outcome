package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.core.sku.CommonMarqueeView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class e3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3 f43208a;

    public e3(f3 r100) {
        this.f43208a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommonMarqueeView r100 = this.f43208a.f43222g;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.requestLayout();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
