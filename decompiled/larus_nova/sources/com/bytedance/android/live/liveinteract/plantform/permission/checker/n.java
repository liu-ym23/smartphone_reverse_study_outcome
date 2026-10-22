package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n extends com.bytedance.android.livesdk.user.h<IBaseUser> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f77387a;

    @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
    public final void onComplete() {
        qh0.d<rh0.a> r100 = this.f77387a.f77388a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r100.onResult(null);
    }

    public n(o r100) {
        this.f77387a = r100;
    }

    @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        super.onError(r100);
        qh0.d<rh0.a> r101 = this.f77387a.f77388a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        qh0.f.g r102 = this.f77387a.f77389b;
        r101.b(new BaseCheckException(r102.f532908c, r102.f532907b, BaseCheckException.CheckType.Login, "login failed, message: " + r100.getMessage(), r100));
    }
}
