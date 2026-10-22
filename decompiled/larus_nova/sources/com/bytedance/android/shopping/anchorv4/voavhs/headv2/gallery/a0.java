package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f169276a;

    public a0(t r100) {
        this.f169276a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f169276a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
