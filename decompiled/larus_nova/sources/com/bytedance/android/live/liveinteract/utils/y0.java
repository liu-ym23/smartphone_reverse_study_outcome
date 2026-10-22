package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.utils.f2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class y0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f78840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f78841b;

    public y0(String r100, String r101) {
        this.f78840a = r100;
        this.f78841b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f2.c("type " + this.f78840a + " 进房首帧：\n " + this.f78841b, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
