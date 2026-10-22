package com.bytedance.android.live.recharge.order.aio;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import tw0.i;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R0\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR0\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/recharge/order/aio/CommonOrderOptionSerializableObjectImpl;", "Ltw0/i;", "", "", "eventProperties", "Ljava/util/Map;", "J8", "()Ljava/util/Map;", "setEventProperties", "(Ljava/util/Map;)V", "diamondBuyQueries", "G0", "setDiamondBuyQueries", "diamondBuyExtra", "I4", "setDiamondBuyExtra", "bizExtra", "getBizExtra", "setBizExtra", "<init>", "()V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonOrderOptionSerializableObjectImpl implements i {

    @SerializedName("diamond_buy_biz_extra")
    private Map<String, String> bizExtra;

    @SerializedName("diamond_buy_extra")
    private Map<String, String> diamondBuyExtra;

    @SerializedName("diamond_buy_queries")
    private Map<String, String> diamondBuyQueries;

    @SerializedName("event_properties")
    private Map<String, String> eventProperties;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/order/aio/CommonOrderOptionSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(CommonOrderOptionSerializableObjectImpl.class);
        }
    }

    public CommonOrderOptionSerializableObjectImpl() {
    }

    @Override // tw0.i
    public final Map<String, String> G0() {
        return this.diamondBuyQueries;
    }

    @Override // tw0.i
    public final Map<String, String> I4() {
        return this.diamondBuyExtra;
    }

    @Override // tw0.i
    public final Map<String, String> J8() {
        return this.eventProperties;
    }

    @Override // tw0.i
    public final Map<String, String> getBizExtra() {
        return this.bizExtra;
    }
}
