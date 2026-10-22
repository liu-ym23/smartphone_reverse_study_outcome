package com.bytedance.android.livesdk.livecommerce.promotion.cardV2;

import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f150569a = null;

    static {
        f150569a = new d();
    }

    public d() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = ECSdk.f48106a;     // Catch: Throwable -> L8
        IECUserTrackerService r101 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);     // Catch: Throwable -> L8
        if (r101 == null) goto L11;
        of.a r102 = r101.getMarketingService();     // Catch: Throwable -> L8
        if (r102 == null) goto L15;
        r102.a("live_visit_product_in_room", PostActionType.DO, "live");     // Catch: Throwable -> L8
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
