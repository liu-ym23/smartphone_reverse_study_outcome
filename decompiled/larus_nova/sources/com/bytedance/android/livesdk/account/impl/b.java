package com.bytedance.android.livesdk.account.impl;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements ILoginCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f103003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f103004b;

    @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
    public final void onCancel(Throwable r100) {
        if (r100 == null) goto L4;
        this.f103004b.invoke(r100);
        return;
    L4:
        this.f103004b.invoke(new IllegalStateException("host provide access token failed without reason, please check!"));
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback
    public final void onSuccess(IBaseUser r100) {
        this.f103003a.invoke();
    }

    public b(Function0 r100, Function1 r101) {
        this.f103003a = r100;
        this.f103004b = r101;
    }
}
