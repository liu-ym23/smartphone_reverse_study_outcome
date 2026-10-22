package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f127303a;

    public j(m r100) {
        this.f127303a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final TouchPositionData r101 = (TouchPositionData) r100;
        this.f127303a.g("touchPosition", new GiftProfitDataStore$initTouchPositionResponseSubscribe$$inlined$let$lambda$1$1(this, r101));
    }
}
