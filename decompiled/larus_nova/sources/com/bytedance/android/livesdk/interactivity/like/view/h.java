package com.bytedance.android.livesdk.interactivity.like.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomDiggTabCountView f137941a;

    public h(CustomDiggTabCountView r100) {
        this.f137941a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f137941a.f137795i.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
