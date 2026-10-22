package com.bytedance.android.livesdk.interactivity.barrage.carnival;

import com.bytedance.android.livesdk.interactivity.api.barrage.data.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DanmakuCarnivalManager f133925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f133926b;

    public b(DanmakuCarnivalManager r100, j r101) {
        this.f133925a = r100;
        this.f133926b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f133925a.p(this.f133926b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
