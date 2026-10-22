package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerHistoryItemViewHolder f123983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f123984b;

    public s(DrawerHistoryItemViewHolder r100, Ref.IntRef r101) {
        this.f123983a = r100;
        this.f123984b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f123983a.f123875c.notifyItemRangeRemoved(this.f123984b.element, 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
