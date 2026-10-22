package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionCountResponse;
import sg2.z;
import vi2.v0;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements v0<ECPromotionCountResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f152807a;

    public d(StartLivePromotionButton.c r100) {
        this.f152807a = r100;
    }

    @Override // vi2.v0
    public final void onError(Throwable r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getMessage();
    L5:
        ECExceptionMonitor.c(String.valueOf(r101));
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // vi2.v0
    public final void onSuccess(ECPromotionCountResponse r100) {
        ECPromotionCountResponse r101 = r100;
        z r102 = this.f152807a;
        if (r102 == null) goto L9;
        if (r101 == null) goto L6;
        int r103 = (int) r101.getCount();
    L7:
        r102.a(r103);
        return;
    L6:
        r103 = 0;
        goto L7
    }
}
