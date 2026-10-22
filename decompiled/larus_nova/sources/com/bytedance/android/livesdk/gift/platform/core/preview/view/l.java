package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UgcGiftSaleDialog f131099a;

    public l(UgcGiftSaleDialog r100) {
        this.f131099a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.gift.platform.core.preview.j.f131002c.setValue(null, com.bytedance.android.livesdk.gift.platform.core.preview.j.f131000a[1], Boolean.FALSE);
        final View r101 = this.f131099a.f131060t;
        if (r101 == null) goto L6;
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{r101.getHeight(), 0});
        r102.setDuration(500);
        r102.addUpdateListener(new k(r101));
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.c(r102, new UgcGiftSaleDialog$$special$$inlined$apply$lambda$5(r101));
        r102.start();
        return;
    }
}
