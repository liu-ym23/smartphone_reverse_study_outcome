package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements q83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f150407a;

    public b(a r100) {
        this.f150407a = r100;
    }

    @Override // q83.a
    public final boolean onTick(long r100) {
        ECUIPromotion r101 = this.f150407a.f150398a;
        if (r101 == null) goto L12;
        ECUICampaign r102 = r101.getCampaign();
        if (r102 != null) goto L7;
        return false;
    L7:
        if (r102.isCampaignNotStarted() == false) goto L9;
    L10:
        a r103 = this.f150407a;
        r103.d(r102, r100, r103.f150402e);
        return true;
    L9:
        if (r102.inCampaignTime() == true) goto L10;
        return false;
    L12:
        return false;
    }
}
