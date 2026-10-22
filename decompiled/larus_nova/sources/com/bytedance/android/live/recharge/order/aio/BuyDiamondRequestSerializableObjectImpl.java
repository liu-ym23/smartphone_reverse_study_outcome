package com.bytedance.android.live.recharge.order.aio;

import com.bytedance.android.live.recharge.deal.aio.b;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import tw0.g;
import tw0.i;
import tw0.j;
import tw0.k;
import tw0.l;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b/\u00100R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/bytedance/android/live/recharge/order/aio/BuyDiamondRequestSerializableObjectImpl;", "Ltw0/g;", "", "dealId", "J", "B8", "()J", "setDealId", "(J)V", "customPrice", "getCustomPrice", "setCustomPrice", "Lcom/bytedance/android/live/recharge/deal/aio/b;", "deal", "Lcom/bytedance/android/live/recharge/deal/aio/b;", "o", "()Lcom/bytedance/android/live/recharge/deal/aio/b;", "setDeal", "(Lcom/bytedance/android/live/recharge/deal/aio/b;)V", "Ltw0/k;", "oneStepPayOptions", "Ltw0/k;", "b9", "()Ltw0/k;", "setOneStepPayOptions", "(Ltw0/k;)V", "Ltw0/l;", "couponOption", "Ltw0/l;", "c5", "()Ltw0/l;", "setCouponOption", "(Ltw0/l;)V", "Ltw0/i;", "commonOrderOption", "Ltw0/i;", "v6", "()Ltw0/i;", "setCommonOrderOption", "(Ltw0/i;)V", "Ltw0/j;", "noPasswordOrderOption", "Ltw0/j;", "Z2", "()Ltw0/j;", "setNoPasswordOrderOption", "(Ltw0/j;)V", "<init>", "()V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BuyDiamondRequestSerializableObjectImpl implements g {

    @SerializedName("common_order_option")
    private i commonOrderOption;

    @SerializedName("recharge_coupon_option")
    private l couponOption;

    @SerializedName("custom_price")
    private long customPrice;

    @SerializedName("deal")
    private b deal;

    @SerializedName("deal_id")
    private long dealId;

    @SerializedName("no_password_order_option")
    private j noPasswordOrderOption;

    @SerializedName("one_step_pay_option")
    private k oneStepPayOptions;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/order/aio/BuyDiamondRequestSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(BuyDiamondRequestSerializableObjectImpl.class);
        }
    }

    public BuyDiamondRequestSerializableObjectImpl() {
    }

    @Override // tw0.g
    public final long B8() {
        return this.dealId;
    }

    @Override // tw0.g
    public final j Z2() {
        return this.noPasswordOrderOption;
    }

    @Override // tw0.g
    public final k b9() {
        return this.oneStepPayOptions;
    }

    @Override // tw0.g
    public final l c5() {
        return this.couponOption;
    }

    @Override // tw0.g
    public final long getCustomPrice() {
        return this.customPrice;
    }

    @Override // tw0.g
    public final b o() {
        return this.deal;
    }

    @Override // tw0.g
    public final i v6() {
        return this.commonOrderOption;
    }
}
