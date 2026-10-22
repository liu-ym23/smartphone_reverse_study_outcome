package com.bytedance.android.livesdk.interactivity.square.common;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseModelListScrollManager f141138a;

    public d(BaseModelListScrollManager r100) {
        this.f141138a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseModelListScrollManager r100 = this.f141138a;     // Catch: Throwable -> L4
        r100.d(r100.f141114b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
