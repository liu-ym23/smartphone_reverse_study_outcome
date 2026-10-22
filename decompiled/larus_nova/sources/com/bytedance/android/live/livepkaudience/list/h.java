package com.bytedance.android.live.livepkaudience.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkFriendsItemBinder.ViewHolder f82095a;

    public h(PkFriendsItemBinder.ViewHolder r100) {
        this.f82095a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f82095a.f82035e.setVisibility(8);     // Catch: Throwable -> L4
        this.f82095a.f82034d.setVisibility(0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
