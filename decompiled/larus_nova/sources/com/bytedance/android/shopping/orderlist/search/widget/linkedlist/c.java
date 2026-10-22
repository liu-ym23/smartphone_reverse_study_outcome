package com.bytedance.android.shopping.orderlist.search.widget.linkedlist;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f180622a;

    public c(View r100) {
        this.f180622a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f180622a.getHeight() != 0) goto L9;
        wg.a.d(this.f180622a, 1);     // Catch: Throwable -> L6
        return;
    }
}
