package com.bytedance.android.shopping.new_cart.components;

import android.view.View;
import android.view.ViewStub;
import com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f178823a;

    public c(d r100) {
        this.f178823a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r100 = this.f178823a;     // Catch: Throwable -> L12
        ViewStub r101 = r100.f178826d;     // Catch: Throwable -> L12
        View r102 = null;
        if (r101 == null) goto L5;
        View r103 = r101.inflate();     // Catch: Throwable -> L12
    L7:
        if ((r103 instanceof ECCartErrorView) == false) goto L10;
        r102 = r103;
    L10:
        r100.f178824b = (ECCartErrorView) r102;     // Catch: Throwable -> L12
        return;
    L5:
        r103 = null;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    }
}
