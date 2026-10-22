package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements q83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f150462a;

    public f(e r100) {
        this.f150462a = r100;
    }

    @Override // q83.a
    public final boolean onTick(long r100) {
        ECUIPromotion r101 = this.f150462a.f150459a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        ECUICampaign r102 = r101.getCampaign();
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.inCampaignTime() == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L16;
        this.f150462a.c(r100, r102.endTime);
        return true;
    L16:
        return false;
    }
}
