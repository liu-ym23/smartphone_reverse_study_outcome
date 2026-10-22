package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f127302a;

    public i(m r100) {
        this.f127302a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final PayGrade r101 = (PayGrade) r100;
        this.f127302a.g("profitPayGrade_" + r101, new GiftProfitDataStore$initPayGradeObservable$$inlined$let$lambda$1$1(this, r101));
    }
}
