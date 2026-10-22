package com.bytedance.android.live.wallet;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNamePasswordCallback;
import com.bytedance.android.live.wallet.caijing.g;
import com.bytedance.android.live.wallet.platform.business.verify.k;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements TTCJPayRealNamePasswordCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f102658a;

    public b(k r100) {
        this.f102658a = r100;
    }

    @Override // com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNamePasswordCallback
    public final void onSetPasswordResult(TTCJPayRealNamePasswordCallback.PasswordResult r100) {
        if (r100 == null) goto L19;
        int r101 = a.f102657b[r100.ordinal()];
        if (r101 != 1) goto L7;
        g r102 = this.f102658a;
        if (r102 == null) goto L18;
        r102.onSuccess();
        return;
    L18:
        return;
    L7:
        if (r101 != 2) goto L20;
        g r103 = this.f102658a;
        if (r103 == null) goto L16;
        r103.onCancel();
        return;
    L16:
        return;
    L20:
        return;
    }
}
