package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.TokenInfo;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;

/* JADX INFO: loaded from: classes45.dex */
public final class o2 implements TokenRefreshCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p2 f63585a;

    public o2(p2 r100) {
        this.f63585a = r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.TokenRefreshCallback
    public final void onFailed(Throwable r100) {
        this.f63585a.finishWithResult(new p2.b(2));
    }

    @Override // com.bytedance.android.livehostapi.platform.TokenRefreshCallback
    public final void onSuccess(TokenInfo r100) {
        this.f63585a.finishWithResult(new p2.b(1));
    }
}
