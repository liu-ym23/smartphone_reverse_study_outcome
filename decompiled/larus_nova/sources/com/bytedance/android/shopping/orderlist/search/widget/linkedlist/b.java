package com.bytedance.android.shopping.orderlist.search.widget.linkedlist;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f180621a;

    public b(View r100) {
        this.f180621a = r100;
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
        if (this.f180621a.getHeight() != 0) goto L9;
        wg.a.d(this.f180621a, 1);     // Catch: Throwable -> L6
        return;
    }
}
