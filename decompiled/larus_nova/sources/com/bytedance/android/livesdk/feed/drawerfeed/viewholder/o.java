package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerHistoryItemViewHolder f123979a;

    public o(DrawerHistoryItemViewHolder r100) {
        this.f123979a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f123979a.f123875c.notifyDataSetChanged();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
