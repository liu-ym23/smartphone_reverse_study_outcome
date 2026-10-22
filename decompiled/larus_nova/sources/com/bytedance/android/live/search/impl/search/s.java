package com.bytedance.android.live.search.impl.search;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSearchResultFragment f100785a;

    public s(LiveSearchResultFragment r100) {
        this.f100785a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = com.bytedance.android.live.search.impl.search.helper.a.f100772a;     // Catch: Throwable -> L4
        com.bytedance.android.live.search.impl.search.helper.a.b(this.f100785a.f100632g);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
