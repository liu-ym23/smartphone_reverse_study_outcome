package com.bytedance.android.annie.service.data;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataProviderService.ImitateRedisEngine f39867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39868b;

    public a(DataProviderService.ImitateRedisEngine r100, String r101) {
        this.f39867a = r100;
        this.f39868b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39867a.f39860b.decrementAndGet();     // Catch: Throwable -> L6
        AtomicInteger r100 = this.f39867a.f39859a.get(this.f39868b);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.decrementAndGet();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
