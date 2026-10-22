package com.bytedance.android.shopping.anchorv4.components;

import android.view.View;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f166124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DragRelativeLayout f166125b;

    public r(w r100, DragRelativeLayout r101) {
        this.f166124a = r100;
        this.f166125b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f166124a.requestLayout();     // Catch: Throwable -> L4
        this.f166125b.setEnableKeepLayout(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
