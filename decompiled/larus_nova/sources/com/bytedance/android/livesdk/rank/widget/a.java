package com.bytedance.android.livesdk.rank.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zy0.b f157040a;

    public a(zy0.b r100) {
        this.f157040a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zy0.b r100 = this.f157040a;     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        xy0.a<?> r101 = r100.g();     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        r101.load();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
