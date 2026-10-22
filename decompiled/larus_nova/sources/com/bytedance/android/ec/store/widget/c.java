package com.bytedance.android.ec.store.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f48996a;

    public c(RecyclerView r100) {
        this.f48996a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f48996a.scrollBy(0, -1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
