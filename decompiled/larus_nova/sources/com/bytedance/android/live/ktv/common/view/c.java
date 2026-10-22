package com.bytedance.android.live.ktv.common.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContinuousSurfaceAdapterView f70808a;

    public c(ContinuousSurfaceAdapterView r100) {
        this.f70808a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContinuousSurfaceAdapterView r100 = this.f70808a;     // Catch: Throwable -> L6
        if (r100.f70710a == true) goto L9;
        ContinuousSurfaceAdapterView.a(r100);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
