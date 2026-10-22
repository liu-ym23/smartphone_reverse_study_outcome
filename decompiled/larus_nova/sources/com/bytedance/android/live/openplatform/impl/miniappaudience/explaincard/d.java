package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.bytedance.android.live.core.utils.s;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceExplainCardWidget f84877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f84878b;

    public d(AudienceExplainCardWidget r100, AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1.AnonymousClass1 r101) {
        this.f84877a = r100;
        this.f84878b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f84877a.t(this.f84878b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
