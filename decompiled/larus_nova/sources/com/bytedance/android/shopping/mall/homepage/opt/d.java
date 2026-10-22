package com.bytedance.android.shopping.mall.homepage.opt;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MallDrainageOpt f178242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECHybridListEngine f178243b;

    public d(MallDrainageOpt r100, ECHybridListEngine r101) {
        this.f178242a = r100;
        this.f178243b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f178242a.a(this.f178243b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
