package com.bytedance.android.live.recharge.platform.business.model.exchange;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/exchange/e;", "Lcom/bytedance/android/live/base/model/Extra;", "", "source", "Ljava/lang/String;", "rebateMessage", "Lcom/bytedance/android/live/recharge/platform/business/model/exchange/b;", "exchangeMarketData", "Lcom/bytedance/android/live/recharge/platform/business/model/exchange/b;", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e extends Extra implements h {

    @SerializedName("marketing_data")
    public b exchangeMarketData;

    @SerializedName("rebate_message")
    public String rebateMessage;

    @SerializedName("source")
    public String source;

    public e() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.recharge.platform.business.model.exchange.b, java.lang.Object] */
    public e(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.source = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.rebateMessage = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.exchangeMarketData = f.a(r100, b.class);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
