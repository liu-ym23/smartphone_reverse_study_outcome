package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;

/* JADX INFO: loaded from: classes9.dex */
public final class y1 implements ILoginCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f142250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f142251b;

    @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
    public final void onCancel(Throwable r100) {
        if (this.f142250a == false) goto L5;
        this.f142251b.finishWithResult(new z1.b(2));
        return;
    L5:
        this.f142251b.finishWithFailure(r100);
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
    public final void onSuccess(IBaseUser r100) {
        if (this.f142250a == false) goto L5;
        this.f142251b.finishWithResult(new z1.b(1));
        return;
    L5:
        this.f142251b.finishWithSuccess();
    }

    public y1(z1 r100, boolean r101) {
        this.f142251b = r100;
        this.f142250a = r101;
    }
}
