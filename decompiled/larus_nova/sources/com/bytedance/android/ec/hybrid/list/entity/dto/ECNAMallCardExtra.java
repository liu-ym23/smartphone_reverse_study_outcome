package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\nR\u0018\u0010.\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0018\u00100\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\nR\u0018\u00102\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\nR \u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\n\"\u0004\b6\u0010\fR$\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0007R\u0018\u00109\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\nR\u0018\u0010;\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\nR\u0018\u0010=\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\nR \u0010?\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\n\"\u0004\bA\u0010\fR.\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0007\"\u0004\bF\u0010G¨\u0006H"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECNAMallCardExtra;", "Ljava/io/Serializable;", "()V", "bcmData", "", "", "getBcmData", "()Ljava/util/Map;", "cardAnimationType", "getCardAnimationType", "()Ljava/lang/String;", "setCardAnimationType", "(Ljava/lang/String;)V", "cardBusinessType", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/CardBusinessType;", "getCardBusinessType", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/CardBusinessType;", "cardTag", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECItemCardTag;", "getCardTag", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECItemCardTag;", "setCardTag", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECItemCardTag;)V", "chipViewConfig", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ChipViewConfig;", "getChipViewConfig", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ChipViewConfig;", "setChipViewConfig", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ChipViewConfig;)V", "grayEnable", "", "getGrayEnable", "()Ljava/lang/Boolean;", "setGrayEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "idlePreloadConfig", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ImagePreloadConfig;", "getIdlePreloadConfig", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ImagePreloadConfig;", "imageConfig", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ImageConfig;", "getImageConfig", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ImageConfig;", "interactiveControl", "getInteractiveControl", "preloadConfig", "getPreloadConfig", "preloadConfigs", "getPreloadConfigs", "productIds", "getProductIds", "recommendInfo", "getRecommendInfo", "setRecommendInfo", "schemaMap", "getSchemaMap", "sliceActions", "getSliceActions", "sliceItemExtra", "getSliceItemExtra", "sliceItemStates", "getSliceItemStates", "sliceItemType", "getSliceItemType", "setSliceItemType", "trackParams", "", "", "getTrackParams", "setTrackParams", "(Ljava/util/Map;)V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNAMallCardExtra implements Serializable {

    @SerializedName("bcm_data")
    private final Map<String, String> bcmData;

    @SerializedName("card_animation_type")
    private String cardAnimationType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private final CardBusinessType cardBusinessType;

    @SerializedName("card_tag")
    private ECItemCardTag cardTag;

    @SerializedName("chip_view")
    private ChipViewConfig chipViewConfig;

    @SerializedName("gray_enable")
    private Boolean grayEnable;

    @SerializedName("idle_preload_image")
    private final ImagePreloadConfig idlePreloadConfig;

    @SerializedName("image_config")
    private final ImageConfig imageConfig;

    @SerializedName("interactive_control")
    private final String interactiveControl;

    @SerializedName("preload_image")
    private final ImagePreloadConfig preloadConfig;

    @SerializedName("preload_images")
    private final String preloadConfigs;

    @SerializedName("product_ids")
    private final String productIds;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private String recommendInfo;

    @SerializedName("schema_map")
    private final Map<String, String> schemaMap;

    @SerializedName("slice_item_actions")
    private final String sliceActions;

    @SerializedName("slice_item_extra")
    private final String sliceItemExtra;

    @SerializedName("slice_item_states")
    private final String sliceItemStates;

    @SerializedName("slice_item_type")
    private String sliceItemType;

    @SerializedName("track_params")
    private Map<String, Object> trackParams;

    public ECNAMallCardExtra() {
    }

    public final Map<String, String> getBcmData() {
        return this.bcmData;
    }

    public final String getCardAnimationType() {
        return this.cardAnimationType;
    }

    public final CardBusinessType getCardBusinessType() {
        return this.cardBusinessType;
    }

    public final ECItemCardTag getCardTag() {
        return this.cardTag;
    }

    public final ChipViewConfig getChipViewConfig() {
        return this.chipViewConfig;
    }

    public final Boolean getGrayEnable() {
        return this.grayEnable;
    }

    public final ImagePreloadConfig getIdlePreloadConfig() {
        return this.idlePreloadConfig;
    }

    public final ImageConfig getImageConfig() {
        return this.imageConfig;
    }

    public final String getInteractiveControl() {
        return this.interactiveControl;
    }

    public final ImagePreloadConfig getPreloadConfig() {
        return this.preloadConfig;
    }

    public final String getPreloadConfigs() {
        return this.preloadConfigs;
    }

    public final String getProductIds() {
        return this.productIds;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final Map<String, String> getSchemaMap() {
        return this.schemaMap;
    }

    public final String getSliceActions() {
        return this.sliceActions;
    }

    public final String getSliceItemExtra() {
        return this.sliceItemExtra;
    }

    public final String getSliceItemStates() {
        return this.sliceItemStates;
    }

    public final String getSliceItemType() {
        return this.sliceItemType;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public final void setCardAnimationType(String r100) {
        this.cardAnimationType = r100;
    }

    public final void setCardTag(ECItemCardTag r100) {
        this.cardTag = r100;
    }

    public final void setChipViewConfig(ChipViewConfig r100) {
        this.chipViewConfig = r100;
    }

    public final void setGrayEnable(Boolean r100) {
        this.grayEnable = r100;
    }

    public final void setRecommendInfo(String r100) {
        this.recommendInfo = r100;
    }

    public final void setSliceItemType(String r100) {
        this.sliceItemType = r100;
    }

    public final void setTrackParams(Map<String, Object> r100) {
        this.trackParams = r100;
    }
}
