package com.bytedance.android.livesdk.gift.platform.format.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.recharge.IRechargeService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f132286a = null;

    static {
        f132286a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IBaseUser r101 = (IBaseUser) r100;
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync("gift_panel");
    }
}
