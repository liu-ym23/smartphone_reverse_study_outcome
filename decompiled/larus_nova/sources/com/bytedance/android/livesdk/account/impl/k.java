package com.bytedance.android.livesdk.account.impl;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements ILoginCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j.c f103046a;

    public k(j.c r100) {
        this.f103046a = r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
    public final void onCancel(Throwable r100) {
        TokenRefreshCallback r101 = this.f103046a.f103039c;
        if (r101 == null) goto L6;
        r101.onFailed(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
    public final void onSuccess(IBaseUser r100) {
        j.c r101 = this.f103046a;
        r101.f103037a.c(r101.f103039c, null);
    }
}
