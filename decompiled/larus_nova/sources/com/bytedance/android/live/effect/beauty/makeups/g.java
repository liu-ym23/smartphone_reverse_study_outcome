package com.bytedance.android.live.effect.beauty.makeups;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f67353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.c f67354b;

    public g(List r100, a.c r101) {
        this.f67353a = r100;
        this.f67354b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.c r100 = this.f67354b;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onSuccess(this.f67353a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
