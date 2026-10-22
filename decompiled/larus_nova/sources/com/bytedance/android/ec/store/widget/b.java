package com.bytedance.android.ec.store.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f48995a;

    public b(RecyclerView r100) {
        this.f48995a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f48995a.scrollBy(0, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
