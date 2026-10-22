package com.bytedance.android.live.wallet.platform.business.verify;

import com.bytedance.android.live.wallet.platform.jsbridge.methods.AuthToFinanceMethod;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements com.bytedance.android.live.wallet.caijing.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f102736a;

    @Override // com.bytedance.android.live.wallet.caijing.g
    public final void onCancel() {
        com.bytedance.android.live.wallet.d.a r100 = this.f102736a.f102737a.f102735b;
        if (r100 == null) goto L6;
        AuthToFinanceMethod.j(((com.bytedance.android.live.wallet.platform.jsbridge.methods.d) r100).f102754a, false);
        return;
    }

    @Override // com.bytedance.android.live.wallet.caijing.g
    public final void onSuccess() {
        com.bytedance.android.live.wallet.d.a r100 = this.f102736a.f102737a.f102735b;
        if (r100 == null) goto L6;
        AuthToFinanceMethod.j(((com.bytedance.android.live.wallet.platform.jsbridge.methods.d) r100).f102754a, true);
        return;
    }

    public k(l r100) {
        this.f102736a = r100;
    }
}
