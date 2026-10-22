package com.bytedance.android.live.effect.base;

import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BeautifyAdjustPercentBar f66993a;

    public c(BeautifyAdjustPercentBar r100) {
        this.f66993a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AdjustPercentBar r101 = BeautifyAdjustPercentBar.R5(this.f66993a);
        if (r101 == null) goto L8;
        int r102 = r101.getPercent();
        AdjustPercentBar r103 = BeautifyAdjustPercentBar.R5(this.f66993a);
        if (r103 == null) goto L9;
        r103.setCurrentProgress(r102 - 1);
        return;
    L9:
        return;
    }
}
