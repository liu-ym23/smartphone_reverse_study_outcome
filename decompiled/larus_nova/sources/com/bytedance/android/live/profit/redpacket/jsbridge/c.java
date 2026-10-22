package com.bytedance.android.live.profit.redpacket.jsbridge;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.browser.jsbridge.base.RedEnvelopeUpdateResultModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f88640a;

    public c(d r100) {
        this.f88640a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        d r102 = this.f88640a;
        RedEnvelopeUpdateResultModel r103 = new RedEnvelopeUpdateResultModel();
        if ((r101 instanceof ApiServerException) == false) goto L5;
        r103.b(Integer.valueOf(((ApiServerException) r101).getErrorCode()));
    L5:
        r103.a(RedEnvelopeUpdateResultModel.Code.Failed);
        Unit r104 = Unit.INSTANCE;
        r102.finishWithResult(r103);
    }
}
