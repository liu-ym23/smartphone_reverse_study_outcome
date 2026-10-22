package com.bytedance.android.live.recharge.deal.aio;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/aio/a;", "", "", "id", "J", "getId", "()J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(J)V", "priceMin", "getPriceMin", "c", "priceMax", "getPriceMax", "b", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.deal.CustomDeal")
public final class a {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f89696id;

    @SerializedName("price_max")
    private long priceMax;

    @SerializedName("price_min")
    private long priceMin;

    public a() {
    }

    public final void a(long r100) {
        this.f89696id = r100;
    }

    public final void b(long r100) {
        this.priceMax = r100;
    }

    public final void c(long r100) {
        this.priceMin = r100;
    }
}
