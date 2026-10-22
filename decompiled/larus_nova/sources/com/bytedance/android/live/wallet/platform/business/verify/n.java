package com.bytedance.android.live.wallet.platform.business.verify;

import android.view.View;
import com.bytedance.android.live.wallet.platform.jsbridge.methods.AuthToFinanceMethod;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f102741a;

    public n(j r100) {
        this.f102741a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        i r101 = this.f102741a.f102734a;
        if (r101 == null) goto L5;
        r101.uB();
    L5:
        com.bytedance.android.live.wallet.d.a r102 = this.f102741a.f102735b;
        if (r102 == null) goto L9;
        AuthToFinanceMethod.j(((com.bytedance.android.live.wallet.platform.jsbridge.methods.d) r102).f102754a, false);
        return;
    }
}
