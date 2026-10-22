package com.bytedance.android.livesdk.dynamicstrategy.impl;

import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.g f123054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KVData f123055b;

    public b(a.g r100, KVData r101) {
        this.f123054a = r100;
        this.f123055b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KVData r100 = this.f123055b;     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        Object r101 = r100.getData();     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        this.f123054a.update(r101);     // Catch: Throwable -> L8
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
