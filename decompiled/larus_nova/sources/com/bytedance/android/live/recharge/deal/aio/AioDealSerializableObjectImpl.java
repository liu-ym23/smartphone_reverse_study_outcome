package com.bytedance.android.live.recharge.deal.aio;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b-\u0010.R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/aio/AioDealSerializableObjectImpl;", "Lcom/bytedance/android/live/recharge/deal/aio/b;", "", "dealId", "J", "getDealId", "()J", "a7", "(J)V", "", "price", "I", "getPrice", "()I", "O8", "(I)V", "diamondCount", "getDiamondCount", "setDiamondCount", "discountPrice", "getDiscountPrice", "v1", "exchangePrice", "getExchangePrice", "J5", "givingCount", "getGivingCount", "C1", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "describeType", "getDescribeType", "x6", "", "objToken", "Ljava/util/Map;", "getObjToken", "()Ljava/util/Map;", "P6", "(Ljava/util/Map;)V", "<init>", "()V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AioDealSerializableObjectImpl implements b {

    @SerializedName("deal_id")
    private long dealId;

    @SerializedName("describe_type")
    private int describeType;

    @SerializedName("description")
    private String description;

    @SerializedName("diamond_count")
    private int diamondCount;

    @SerializedName("discount_price")
    private int discountPrice;

    @SerializedName("exchange_price")
    private int exchangePrice;

    @SerializedName("giving_count")
    private int givingCount;

    @SerializedName("_obj_token")
    private Map<String, String> objToken;

    @SerializedName("price")
    private int price;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/deal/aio/AioDealSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AioDealSerializableObjectImpl.class);
        }
    }

    public AioDealSerializableObjectImpl() {
    }

    @Override // ix0.d
    public final Map<String, String> getObjToken() {
        return this.objToken;
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.b
    public final void C1(int r100) {
        this.givingCount = r100;
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.b
    public final void J5(int r100) {
        this.exchangePrice = r100;
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.b
    public final void O8(int r100) {
        this.price = r100;
    }

    @Override // ix0.d
    public final void P6(Map<String, String> r100) {
        this.objToken = r100;
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.b
    public final void a7(long r100) {
        this.dealId = r100;
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.b
    public final void setDescription(String r100) {
        this.description = r100;
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.b
    public final void setDiamondCount(int r100) {
        this.diamondCount = r100;
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.b
    public final void v1(int r100) {
        this.discountPrice = r100;
    }

    @Override // com.bytedance.android.live.recharge.deal.aio.b
    public final void x6(int r100) {
        this.describeType = r100;
    }
}
