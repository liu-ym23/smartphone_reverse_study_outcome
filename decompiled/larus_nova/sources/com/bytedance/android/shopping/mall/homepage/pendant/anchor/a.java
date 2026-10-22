package com.bytedance.android.shopping.mall.homepage.pendant.anchor;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorPendant f178356a;

    public a(AnchorPendant r100) {
        this.f178356a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnchorPendant r100 = this.f178356a;     // Catch: Throwable -> L4
        Lazy r101 = AnchorPendant.f178318u;     // Catch: Throwable -> L4
        r100.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
