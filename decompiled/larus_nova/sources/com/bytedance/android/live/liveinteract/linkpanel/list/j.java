package com.bytedance.android.live.liveinteract.linkpanel.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FriendsItemBinder.ViewHolder f74956a;

    public j(FriendsItemBinder.ViewHolder r100) {
        this.f74956a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74956a.f74883e.setVisibility(8);     // Catch: Throwable -> L4
        this.f74956a.f74882d.setVisibility(0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
