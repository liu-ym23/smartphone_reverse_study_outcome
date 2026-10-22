package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.utils.f2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f78846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f78847b;

    public z0(String r100, Map r101) {
        this.f78846a = r100;
        this.f78847b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f2.c("type " + this.f78846a + " 进房首帧：\n " + this.f78847b, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
