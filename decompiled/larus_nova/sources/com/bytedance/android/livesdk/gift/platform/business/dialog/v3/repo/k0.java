package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UserLogin;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class k0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f128361a;

    public k0(n0 r100) {
        this.f128361a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ds2.d r101 = (ds2.d) r100;
        this.f128361a.f128390d.a(new UserLogin());
    }
}
