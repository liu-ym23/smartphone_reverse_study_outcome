package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f127339a;

    public x(y r100) {
        this.f127339a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final PayGrade r101 = (PayGrade) r100;
        this.f127339a.g("userInfoPayGrade_" + r101, new GiftUserInfoDataStore$bindObservables$$inlined$let$lambda$1$1(this, r101));
    }
}
