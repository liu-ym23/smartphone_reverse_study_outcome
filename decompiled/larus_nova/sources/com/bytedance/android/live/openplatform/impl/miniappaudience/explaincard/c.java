package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.larus.apm.impl.protector.RunnableProtector;
import jc1.k;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceExplainCardWidget f84876a;

    public c(AudienceExplainCardWidget r100) {
        this.f84876a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f84876a.getClass();     // Catch: Throwable -> L4
        ((IOpenPlatformAudienceService) k.n(IOpenPlatformAudienceService.class)).reportExplainCardShown("normal");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
