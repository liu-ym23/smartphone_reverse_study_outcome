package com.bytedance.android.livesdkapi.depend.model.live.pay;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b2\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0019\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010 \u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\t\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR$\u0010(\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\t\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R$\u0010,\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\t\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R$\u00100\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\t\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013R$\u00104\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\t\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013R$\u00108\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b7\u0010\t\u001a\u0004\b5\u0010\u0011\"\u0004\b6\u0010\u0013R$\u0010<\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b;\u0010\t\u001a\u0004\b9\u0010\u0011\"\u0004\b:\u0010\u0013R\"\u0010@\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b?\u0010\t\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001eR\"\u0010D\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bC\u0010\t\u001a\u0004\bA\u0010\u001c\"\u0004\bB\u0010\u001eR$\u0010H\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bG\u0010\t\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u0010\u0013R$\u0010L\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bK\u0010\t\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010\u0013R6\u0010T\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010Mj\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`N8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bS\u0010\t\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010[\u001a\u0004\u0018\u00010U8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bZ\u0010\t\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010b\u001a\u0004\u0018\u00010\\8&@&X§\u000e¢\u0006\u0012\u0012\u0004\ba\u0010\t\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`RB\u0010j\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\\\u0018\u00010cj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\\\u0018\u0001`d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bi\u0010\t\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR6\u0010o\u001a\u0016\u0012\u0004\u0012\u00020k\u0018\u00010Mj\n\u0012\u0004\u0012\u00020k\u0018\u0001`N8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bn\u0010\t\u001a\u0004\bl\u0010P\"\u0004\bm\u0010RR\"\u0010s\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\br\u0010\t\u001a\u0004\bp\u0010\u0005\"\u0004\bq\u0010\u0007R$\u0010w\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bv\u0010\t\u001a\u0004\bt\u0010\u0011\"\u0004\bu\u0010\u0013R\"\u0010{\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bz\u0010\t\u001a\u0004\bx\u0010\u001c\"\u0004\by\u0010\u001e¨\u0006|"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ITicketData;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ITicketDataEx;", "", "getTicketId", "()J", "setTicketId", "(J)V", "getTicketId$annotations", "()V", "ticketId", "getOwnerId", "setOwnerId", "getOwnerId$annotations", "ownerId", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "getTitle$annotations", "title", "getPrice", "setPrice", "getPrice$annotations", "price", "", "getStatus", "()I", "setStatus", "(I)V", "getStatus$annotations", "status", "getSellStatus", "setSellStatus", "getSellStatus$annotations", "sellStatus", "getReleaseTime", "setReleaseTime", "getReleaseTime$annotations", "releaseTime", "getTicketPanelJumpUrl", "setTicketPanelJumpUrl", "getTicketPanelJumpUrl$annotations", "ticketPanelJumpUrl", "getPrepayCashierJumpUrl", "setPrepayCashierJumpUrl", "getPrepayCashierJumpUrl$annotations", "prepayCashierJumpUrl", "getTicketPanelJumpUrlV2", "setTicketPanelJumpUrlV2", "getTicketPanelJumpUrlV2$annotations", "ticketPanelJumpUrlV2", "getTicketPanelJumpUrlV3", "setTicketPanelJumpUrlV3", "getTicketPanelJumpUrlV3$annotations", "ticketPanelJumpUrlV3", "getTicketExplanationCardUrl", "setTicketExplanationCardUrl", "getTicketExplanationCardUrl$annotations", "ticketExplanationCardUrl", "getTicketExplanationCardStatus", "setTicketExplanationCardStatus", "getTicketExplanationCardStatus$annotations", "ticketExplanationCardStatus", "getTicketExplanationCardLastDuration", "setTicketExplanationCardLastDuration", "getTicketExplanationCardLastDuration$annotations", "ticketExplanationCardLastDuration", "getPaidConversionJumpUrl", "setPaidConversionJumpUrl", "getPaidConversionJumpUrl$annotations", "paidConversionJumpUrl", "getExtra", "setExtra", "getExtra$annotations", "extra", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getTags$annotations", PromotionProductPrivilegesStruct.TAGS, "Lpy/k;", "getCover", "()Lpy/k;", "setCover", "(Lpy/k;)V", "getCover$annotations", "cover", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/IPaidLivePriceInfoV2;", "getFinalPriceInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/pay/IPaidLivePriceInfoV2;", "setFinalPriceInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/pay/IPaidLivePriceInfoV2;)V", "getFinalPriceInfo$annotations", "finalPriceInfo", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getPriceMap", "()Ljava/util/Map;", "setPriceMap", "(Ljava/util/Map;)V", "getPriceMap$annotations", "priceMap", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ITicketSkuDetail;", "getSkuDetails", "setSkuDetails", "getSkuDetails$annotations", "skuDetails", "getParentTicketSessionId", "setParentTicketSessionId", "getParentTicketSessionId$annotations", "parentTicketSessionId", "getParentTicketSessionIdStr", "setParentTicketSessionIdStr", "getParentTicketSessionIdStr$annotations", "parentTicketSessionIdStr", "getTicketCategory", "setTicketCategory", "getTicketCategory$annotations", "ticketCategory", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ITicketData extends c<ITicketData>, ITicketDataEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "cover")
        public static /* synthetic */ void getCover$annotations() {
        }

        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @FieldName(name = "final_price_info")
        public static /* synthetic */ void getFinalPriceInfo$annotations() {
        }

        @FieldName(name = "ticket_anchor_id")
        public static /* synthetic */ void getOwnerId$annotations() {
        }

        @FieldName(name = "paid_conversion_jump_url")
        public static /* synthetic */ void getPaidConversionJumpUrl$annotations() {
        }

        @FieldName(name = "parent_ticket_session_id")
        public static /* synthetic */ void getParentTicketSessionId$annotations() {
        }

        @FieldName(name = "parent_ticket_session_id_str")
        public static /* synthetic */ void getParentTicketSessionIdStr$annotations() {
        }

        @FieldName(name = "prepay_cashier_jump_url")
        public static /* synthetic */ void getPrepayCashierJumpUrl$annotations() {
        }

        @FieldName(name = "price")
        public static /* synthetic */ void getPrice$annotations() {
        }

        @FieldName(name = a.KEY_PRICE_INFO)
        public static /* synthetic */ void getPriceMap$annotations() {
        }

        @FieldName(name = "release_time")
        public static /* synthetic */ void getReleaseTime$annotations() {
        }

        @FieldName(name = "sell_status")
        public static /* synthetic */ void getSellStatus$annotations() {
        }

        @FieldName(name = "sku_details")
        public static /* synthetic */ void getSkuDetails$annotations() {
        }

        @FieldName(name = "status")
        public static /* synthetic */ void getStatus$annotations() {
        }

        @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
        public static /* synthetic */ void getTags$annotations() {
        }

        @FieldName(name = "ticket_category")
        public static /* synthetic */ void getTicketCategory$annotations() {
        }

        @FieldName(name = "last_duration")
        public static /* synthetic */ void getTicketExplanationCardLastDuration$annotations() {
        }

        @FieldName(name = "ticket_explanation_card_status")
        public static /* synthetic */ void getTicketExplanationCardStatus$annotations() {
        }

        @FieldName(name = "ticket_explanation_card_jump_url")
        public static /* synthetic */ void getTicketExplanationCardUrl$annotations() {
        }

        @FieldName(name = "ticket_session_id")
        public static /* synthetic */ void getTicketId$annotations() {
        }

        @FieldName(name = "ticket_panel_jump_url")
        public static /* synthetic */ void getTicketPanelJumpUrl$annotations() {
        }

        @FieldName(name = "ticket_panel_six_jump_url")
        public static /* synthetic */ void getTicketPanelJumpUrlV2$annotations() {
        }

        @FieldName(name = "ticket_panel_nine_jump_url")
        public static /* synthetic */ void getTicketPanelJumpUrlV3$annotations() {
        }

        @FieldName(name = "title")
        public static /* synthetic */ void getTitle$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "cover")
    k getCover();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "final_price_info")
    IPaidLivePriceInfoV2 getFinalPriceInfo();

    @FieldName(name = "ticket_anchor_id")
    long getOwnerId();

    @FieldName(name = "paid_conversion_jump_url")
    String getPaidConversionJumpUrl();

    @FieldName(name = "parent_ticket_session_id")
    long getParentTicketSessionId();

    @FieldName(name = "parent_ticket_session_id_str")
    String getParentTicketSessionIdStr();

    @FieldName(name = "prepay_cashier_jump_url")
    String getPrepayCashierJumpUrl();

    @FieldName(name = "price")
    String getPrice();

    @FieldName(name = a.KEY_PRICE_INFO)
    Map<Long, IPaidLivePriceInfoV2> getPriceMap();

    @FieldName(name = "release_time")
    String getReleaseTime();

    @FieldName(name = "sell_status")
    int getSellStatus();

    @FieldName(name = "sku_details")
    List<ITicketSkuDetail> getSkuDetails();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<String> getTags();

    @FieldName(name = "ticket_category")
    int getTicketCategory();

    @FieldName(name = "last_duration")
    int getTicketExplanationCardLastDuration();

    @FieldName(name = "ticket_explanation_card_status")
    int getTicketExplanationCardStatus();

    @FieldName(name = "ticket_explanation_card_jump_url")
    String getTicketExplanationCardUrl();

    @FieldName(name = "ticket_session_id")
    long getTicketId();

    @FieldName(name = "ticket_panel_jump_url")
    String getTicketPanelJumpUrl();

    @FieldName(name = "ticket_panel_six_jump_url")
    String getTicketPanelJumpUrlV2();

    @FieldName(name = "ticket_panel_nine_jump_url")
    String getTicketPanelJumpUrlV3();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "cover#setter")
    void setCover(k r100);

    @FieldName(name = "extra#setter")
    void setExtra(String r100);

    @FieldName(name = "final_price_info#setter")
    void setFinalPriceInfo(IPaidLivePriceInfoV2 r100);

    @FieldName(name = "ticket_anchor_id#setter")
    void setOwnerId(long r100);

    @FieldName(name = "paid_conversion_jump_url#setter")
    void setPaidConversionJumpUrl(String r100);

    @FieldName(name = "parent_ticket_session_id#setter")
    void setParentTicketSessionId(long r100);

    @FieldName(name = "parent_ticket_session_id_str#setter")
    void setParentTicketSessionIdStr(String r100);

    @FieldName(name = "prepay_cashier_jump_url#setter")
    void setPrepayCashierJumpUrl(String r100);

    @FieldName(name = "price#setter")
    void setPrice(String r100);

    @FieldName(name = "price_info#setter")
    void setPriceMap(Map<Long, ? extends IPaidLivePriceInfoV2> r100);

    @FieldName(name = "release_time#setter")
    void setReleaseTime(String r100);

    @FieldName(name = "sell_status#setter")
    void setSellStatus(int r100);

    @FieldName(name = "sku_details#setter")
    void setSkuDetails(List<? extends ITicketSkuDetail> r100);

    @FieldName(name = "status#setter")
    void setStatus(int r100);

    @FieldName(name = "tags#setter")
    void setTags(List<String> r100);

    @FieldName(name = "ticket_category#setter")
    void setTicketCategory(int r100);

    @FieldName(name = "last_duration#setter")
    void setTicketExplanationCardLastDuration(int r100);

    @FieldName(name = "ticket_explanation_card_status#setter")
    void setTicketExplanationCardStatus(int r100);

    @FieldName(name = "ticket_explanation_card_jump_url#setter")
    void setTicketExplanationCardUrl(String r100);

    @FieldName(name = "ticket_session_id#setter")
    void setTicketId(long r100);

    @FieldName(name = "ticket_panel_jump_url#setter")
    void setTicketPanelJumpUrl(String r100);

    @FieldName(name = "ticket_panel_six_jump_url#setter")
    void setTicketPanelJumpUrlV2(String r100);

    @FieldName(name = "ticket_panel_nine_jump_url#setter")
    void setTicketPanelJumpUrlV3(String r100);

    @FieldName(name = "title#setter")
    void setTitle(String r100);
}
