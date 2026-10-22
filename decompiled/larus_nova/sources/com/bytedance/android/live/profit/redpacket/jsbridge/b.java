package com.bytedance.android.live.profit.redpacket.jsbridge;

import com.bytedance.android.live.browser.jsbridge.base.RedEnvelopeUpdateResultModel;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f88639a;

    public b(d r100) {
        this.f88639a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        d r102 = this.f88639a;
        RedEnvelopeUpdateResultModel r103 = new RedEnvelopeUpdateResultModel();
        r103.a(RedEnvelopeUpdateResultModel.Code.Success);
        r103.b(0);
        Unit r104 = Unit.INSTANCE;
        r102.finishWithResult(r103);
    }
}
