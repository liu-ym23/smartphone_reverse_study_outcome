package com.bytedance.android.anya;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MVIRecyclerViewAdapter f41753a;

    public w(MVIRecyclerViewAdapter r100) {
        this.f41753a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f41753a.notifyDataSetChanged();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
