package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f169718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f169719b;

    public t(w r100, int r101) {
        this.f169718a = r100;
        this.f169719b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f169718a.getHeadAbility().TB(this.f169719b, false);
    }
}
