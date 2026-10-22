package com.bytedance.android.livesdk.livecommerce.utils;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/utils/ECLiveDegradeConfig;", "Ljava/io/Serializable;", "()V", "enableHotAtmosphereDegrade", "", "getEnableHotAtmosphereDegrade", "()Ljava/lang/Integer;", "setEnableHotAtmosphereDegrade", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "enableLiveMarketingShortTouch", "getEnableLiveMarketingShortTouch", "setEnableLiveMarketingShortTouch", "enablePromotionListCardExplainingAnimDegrade", "getEnablePromotionListCardExplainingAnimDegrade", "setEnablePromotionListCardExplainingAnimDegrade", "enablePromotionListCardSalePointDegrade", "getEnablePromotionListCardSalePointDegrade", "setEnablePromotionListCardSalePointDegrade", "enablePromotionListInteractionMsgDegrade", "getEnablePromotionListInteractionMsgDegrade", "setEnablePromotionListInteractionMsgDegrade", "enablePromotionListLoadingDegrade", "getEnablePromotionListLoadingDegrade", "setEnablePromotionListLoadingDegrade", "enableShoppingCardAnimationDegrade", "getEnableShoppingCardAnimationDegrade", "setEnableShoppingCardAnimationDegrade", "enableShoppingCardBottomAnimDegrade", "getEnableShoppingCardBottomAnimDegrade", "setEnableShoppingCardBottomAnimDegrade", "liveListFlingMaxVelocity", "getLiveListFlingMaxVelocity", "setLiveListFlingMaxVelocity", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveDegradeConfig implements Serializable {

    @SerializedName("hot_atmosphere_degrade")
    private Integer enableHotAtmosphereDegrade;

    @SerializedName("live_marketing_short_touch")
    private Integer enableLiveMarketingShortTouch;

    @SerializedName("promotion_list_card_explaining_anim_degrade")
    private Integer enablePromotionListCardExplainingAnimDegrade;

    @SerializedName("promotion_list_card_sale_point_degrade")
    private Integer enablePromotionListCardSalePointDegrade;

    @SerializedName("promotion_list_interaction_msg_degrade")
    private Integer enablePromotionListInteractionMsgDegrade;

    @SerializedName("promotion_list_loading_degrade")
    private Integer enablePromotionListLoadingDegrade;

    @SerializedName("shopping_card_animation_degrade")
    private Integer enableShoppingCardAnimationDegrade;

    @SerializedName("shopping_card_bottom_anim_degrade")
    private Integer enableShoppingCardBottomAnimDegrade;

    @SerializedName("promotion_list_fling_max_velocity")
    private Integer liveListFlingMaxVelocity;

    public ECLiveDegradeConfig() {
    }

    public final Integer getEnableHotAtmosphereDegrade() {
        return this.enableHotAtmosphereDegrade;
    }

    public final Integer getEnableLiveMarketingShortTouch() {
        return this.enableLiveMarketingShortTouch;
    }

    public final Integer getEnablePromotionListCardExplainingAnimDegrade() {
        return this.enablePromotionListCardExplainingAnimDegrade;
    }

    public final Integer getEnablePromotionListCardSalePointDegrade() {
        return this.enablePromotionListCardSalePointDegrade;
    }

    public final Integer getEnablePromotionListInteractionMsgDegrade() {
        return this.enablePromotionListInteractionMsgDegrade;
    }

    public final Integer getEnablePromotionListLoadingDegrade() {
        return this.enablePromotionListLoadingDegrade;
    }

    public final Integer getEnableShoppingCardAnimationDegrade() {
        return this.enableShoppingCardAnimationDegrade;
    }

    public final Integer getEnableShoppingCardBottomAnimDegrade() {
        return this.enableShoppingCardBottomAnimDegrade;
    }

    public final Integer getLiveListFlingMaxVelocity() {
        return this.liveListFlingMaxVelocity;
    }

    public final void setEnableHotAtmosphereDegrade(Integer r100) {
        this.enableHotAtmosphereDegrade = r100;
    }

    public final void setEnableLiveMarketingShortTouch(Integer r100) {
        this.enableLiveMarketingShortTouch = r100;
    }

    public final void setEnablePromotionListCardExplainingAnimDegrade(Integer r100) {
        this.enablePromotionListCardExplainingAnimDegrade = r100;
    }

    public final void setEnablePromotionListCardSalePointDegrade(Integer r100) {
        this.enablePromotionListCardSalePointDegrade = r100;
    }

    public final void setEnablePromotionListInteractionMsgDegrade(Integer r100) {
        this.enablePromotionListInteractionMsgDegrade = r100;
    }

    public final void setEnablePromotionListLoadingDegrade(Integer r100) {
        this.enablePromotionListLoadingDegrade = r100;
    }

    public final void setEnableShoppingCardAnimationDegrade(Integer r100) {
        this.enableShoppingCardAnimationDegrade = r100;
    }

    public final void setEnableShoppingCardBottomAnimDegrade(Integer r100) {
        this.enableShoppingCardBottomAnimDegrade = r100;
    }

    public final void setLiveListFlingMaxVelocity(Integer r100) {
        this.liveListFlingMaxVelocity = r100;
    }
}
