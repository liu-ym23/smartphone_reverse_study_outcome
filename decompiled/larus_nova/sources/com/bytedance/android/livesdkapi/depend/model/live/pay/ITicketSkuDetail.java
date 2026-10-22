package com.bytedance.android.livesdkapi.depend.model.live.pay;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u0006R$\u0010&\u001a\u0004\u0018\u00010 8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\b\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010*\u001a\u0004\u0018\u00010 8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010.\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\b\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ITicketSkuDetail;", "Lvh7/c;", "", "getTicketType", "()I", "setTicketType", "(I)V", "getTicketType$annotations", "()V", "ticketType", "", "getTicketName", "()Ljava/lang/String;", "setTicketName", "(Ljava/lang/String;)V", "getTicketName$annotations", "ticketName", "", "getStartSellTime", "()J", "setStartSellTime", "(J)V", "getStartSellTime$annotations", "startSellTime", "getClosingSellTime", "setClosingSellTime", "getClosingSellTime$annotations", "closingSellTime", "getSellStatus", "setSellStatus", "getSellStatus$annotations", "sellStatus", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/IPaidLivePriceInfoV2;", "getPriceInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/pay/IPaidLivePriceInfoV2;", "setPriceInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/pay/IPaidLivePriceInfoV2;)V", "getPriceInfo$annotations", "priceInfo", "getDouPriceInfo", "setDouPriceInfo", "getDouPriceInfo$annotations", "douPriceInfo", "getSkuId", "setSkuId", "getSkuId$annotations", "skuId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ITicketSkuDetail extends c<ITicketSkuDetail> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "closing_sell_time")
        public static /* synthetic */ void getClosingSellTime$annotations() {
        }

        @FieldName(name = "dou_price_info")
        public static /* synthetic */ void getDouPriceInfo$annotations() {
        }

        @FieldName(name = a.KEY_PRICE_INFO)
        public static /* synthetic */ void getPriceInfo$annotations() {
        }

        @FieldName(name = "sell_status")
        public static /* synthetic */ void getSellStatus$annotations() {
        }

        @FieldName(name = a.KEY_SKU_ID)
        public static /* synthetic */ void getSkuId$annotations() {
        }

        @FieldName(name = "start_sell_time")
        public static /* synthetic */ void getStartSellTime$annotations() {
        }

        @FieldName(name = "ticket_name")
        public static /* synthetic */ void getTicketName$annotations() {
        }

        @FieldName(name = "ticket_type")
        public static /* synthetic */ void getTicketType$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "closing_sell_time")
    long getClosingSellTime();

    @FieldName(name = "dou_price_info")
    IPaidLivePriceInfoV2 getDouPriceInfo();

    @FieldName(name = a.KEY_PRICE_INFO)
    IPaidLivePriceInfoV2 getPriceInfo();

    @FieldName(name = "sell_status")
    int getSellStatus();

    @FieldName(name = a.KEY_SKU_ID)
    long getSkuId();

    @FieldName(name = "start_sell_time")
    long getStartSellTime();

    @FieldName(name = "ticket_name")
    String getTicketName();

    @FieldName(name = "ticket_type")
    int getTicketType();

    @FieldName(name = "closing_sell_time#setter")
    void setClosingSellTime(long r100);

    @FieldName(name = "dou_price_info#setter")
    void setDouPriceInfo(IPaidLivePriceInfoV2 r100);

    @FieldName(name = "price_info#setter")
    void setPriceInfo(IPaidLivePriceInfoV2 r100);

    @FieldName(name = "sell_status#setter")
    void setSellStatus(int r100);

    @FieldName(name = "sku_id#setter")
    void setSkuId(long r100);

    @FieldName(name = "start_sell_time#setter")
    void setStartSellTime(long r100);

    @FieldName(name = "ticket_name#setter")
    void setTicketName(String r100);

    @FieldName(name = "ticket_type#setter")
    void setTicketType(int r100);
}
