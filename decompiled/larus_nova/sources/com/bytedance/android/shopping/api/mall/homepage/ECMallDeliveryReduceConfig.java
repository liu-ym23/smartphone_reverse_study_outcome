package com.bytedance.android.shopping.api.mall.homepage;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b&\u0018\u00002\u00020\u0001:\u0001TB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010R\u001a\u0004\u0018\u00010/2\u0006\u0010S\u001a\u00020\rR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001e\u0010!\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R,\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020/\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR\u001e\u00107\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\u001e\u0010:\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010'\"\u0004\b<\u0010)R\u001e\u0010=\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001b\"\u0004\b?\u0010\u001dR\u001e\u0010@\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR\u001e\u0010C\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001e\u0010F\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010'\"\u0004\bH\u0010)R\u001e\u0010I\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001e\u0010L\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010'\"\u0004\bN\u0010)R\u001e\u0010O\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\b¨\u0006U"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig;", "Ljava/io/Serializable;", "()V", "cardCount", "", "getCardCount", "()I", "setCardCount", "(I)V", "cardCountLarge", "getCardCountLarge", "setCardCountLarge", "cardCoverPlaceholder", "", "getCardCoverPlaceholder", "()Ljava/lang/String;", "setCardCoverPlaceholder", "(Ljava/lang/String;)V", "cardCoverPlaceholderRatio", "", "getCardCoverPlaceholderRatio", "()F", "setCardCoverPlaceholderRatio", "(F)V", "cardRadius", "", "getCardRadius", "()D", "setCardRadius", "(D)V", "cardTitlePlaceholder", "getCardTitlePlaceholder", "setCardTitlePlaceholder", "cardTitlePlaceholderRatio", "getCardTitlePlaceholderRatio", "setCardTitlePlaceholderRatio", "forbidExitAnimation", "", "getForbidExitAnimation", "()Z", "setForbidExitAnimation", "(Z)V", "forceLayoutEnable", "getForceLayoutEnable", "setForceLayoutEnable", "headerPlaceholderMap", "", "Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig$Placeholder;", "getHeaderPlaceholderMap", "()Ljava/util/Map;", "setHeaderPlaceholderMap", "(Ljava/util/Map;)V", "itemGap", "getItemGap", "setItemGap", "itemGapLarge", "getItemGapLarge", "setItemGapLarge", "jumpAfterImageLoaded", "getJumpAfterImageLoaded", "setJumpAfterImageLoaded", "marginHorizontal", "getMarginHorizontal", "setMarginHorizontal", "marginHorizontalLarge", "getMarginHorizontalLarge", "setMarginHorizontalLarge", "maxDelayJumpDuration", "getMaxDelayJumpDuration", "setMaxDelayJumpDuration", "modifyExposureEventParamsEnable", "getModifyExposureEventParamsEnable", "setModifyExposureEventParamsEnable", "renderFirstScreenWaitingTimeout", "getRenderFirstScreenWaitingTimeout", "setRenderFirstScreenWaitingTimeout", "reportFirstCardOnly", "getReportFirstCardOnly", "setReportFirstCardOnly", "targetDuration", "getTargetDuration", "setTargetDuration", "findHeaderPlaceholder", "headerPlaceholderType", "Placeholder", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallDeliveryReduceConfig implements Serializable {

    @SerializedName("card_count")
    private int cardCount;

    @SerializedName("card_count_large")
    private int cardCountLarge;

    @SerializedName("card_cover_placeholder")
    private String cardCoverPlaceholder;

    @SerializedName("card_cover_placeholder_ratio")
    private float cardCoverPlaceholderRatio;

    @SerializedName("card_radius")
    private double cardRadius;

    @SerializedName("card_title_placeholder")
    private String cardTitlePlaceholder;

    @SerializedName("card_title_placeholder_ratio")
    private float cardTitlePlaceholderRatio;

    @SerializedName("forbid_exit_animation")
    private boolean forbidExitAnimation;

    @SerializedName("force_layout_enable")
    private boolean forceLayoutEnable;

    @SerializedName("header_placeholder_map")
    private Map<String, Placeholder> headerPlaceholderMap;

    @SerializedName("item_gap")
    private double itemGap;

    @SerializedName("item_gap_large")
    private double itemGapLarge;

    @SerializedName("jump_after_image_loaded")
    private boolean jumpAfterImageLoaded;

    @SerializedName("margin_horizontal")
    private double marginHorizontal;

    @SerializedName("margin_horizontal_large")
    private double marginHorizontalLarge;

    @SerializedName("max_delay_jump_duration")
    private int maxDelayJumpDuration;

    @SerializedName("modify_exposure_event_params_enable")
    private boolean modifyExposureEventParamsEnable;

    @SerializedName("render_first_screen_waiting_timeout")
    private int renderFirstScreenWaitingTimeout;

    @SerializedName("report_first_card_only")
    private boolean reportFirstCardOnly;

    @SerializedName("target_duration")
    private int targetDuration;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u0015J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig$Placeholder;", "Ljava/io/Serializable;", "url", "", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "(Ljava/lang/String;Ljava/lang/Float;)V", "getRatio", "()Ljava/lang/Float;", "setRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Float;)Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig$Placeholder;", "equals", "", "other", "", "hashCode", "", "isValid", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Placeholder implements Serializable {

        @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
        private Float ratio;

        @SerializedName("url")
        private String url;

        /* JADX WARN: Multi-variable type inference failed */
        public Placeholder() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Placeholder copy$default(Placeholder r100, String r101, Float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.url;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.ratio;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.url;
        }

        public final Float component2() {
            return this.ratio;
        }

        public final Placeholder copy(String r100, Float r101) {
            return new Placeholder(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Placeholder) == false) goto L10;
            Placeholder r101 = (Placeholder) r100;
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.ratio, r101.ratio) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.url;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Float r104 = this.ratio;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "Placeholder(url=" + this.url + ", ratio=" + this.ratio + ")";
        }

        public final boolean isValid() {
            String r100 = this.url;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == true) goto L18;
            Float r102 = this.ratio;
            if (r102 == null) goto L18;
            if (r102 == null) goto L14;
            float r103 = r102.floatValue();
        L16:
            if (r103 <= 0) goto L18;
            return true;
        L14:
            r103 = -1.0f;
        L18:
            return false;
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }

        public final Float getRatio() {
            return this.ratio;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setRatio(Float r100) {
            this.ratio = r100;
        }

        public final void setUrl(String r100) {
            this.url = r100;
        }

        public Placeholder(String r100, Float r101) {
            this.url = r100;
            this.ratio = r101;
        }

        public /* synthetic */ Placeholder(String r100, Float r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    public ECMallDeliveryReduceConfig() {
        this.cardCoverPlaceholderRatio = 1.0f;
        this.cardTitlePlaceholderRatio = 2.368f;
        this.marginHorizontal = 5.0d;
        this.marginHorizontalLarge = 12.0d;
        this.itemGap = 5.0d;
        this.itemGapLarge = 8.0d;
        this.cardRadius = 8.0d;
        this.cardCount = 4;
        this.cardCountLarge = 9;
        this.jumpAfterImageLoaded = true;
        this.renderFirstScreenWaitingTimeout = 3000;
        this.targetDuration = -1;
        this.maxDelayJumpDuration = 100;
        this.forceLayoutEnable = true;
        this.reportFirstCardOnly = true;
        this.modifyExposureEventParamsEnable = true;
        this.forbidExitAnimation = true;
    }

    public final int getCardCount() {
        return this.cardCount;
    }

    public final int getCardCountLarge() {
        return this.cardCountLarge;
    }

    public final String getCardCoverPlaceholder() {
        return this.cardCoverPlaceholder;
    }

    public final float getCardCoverPlaceholderRatio() {
        return this.cardCoverPlaceholderRatio;
    }

    public final double getCardRadius() {
        return this.cardRadius;
    }

    public final String getCardTitlePlaceholder() {
        return this.cardTitlePlaceholder;
    }

    public final float getCardTitlePlaceholderRatio() {
        return this.cardTitlePlaceholderRatio;
    }

    public final boolean getForbidExitAnimation() {
        return this.forbidExitAnimation;
    }

    public final boolean getForceLayoutEnable() {
        return this.forceLayoutEnable;
    }

    public final Map<String, Placeholder> getHeaderPlaceholderMap() {
        return this.headerPlaceholderMap;
    }

    public final double getItemGap() {
        return this.itemGap;
    }

    public final double getItemGapLarge() {
        return this.itemGapLarge;
    }

    public final boolean getJumpAfterImageLoaded() {
        return this.jumpAfterImageLoaded;
    }

    public final double getMarginHorizontal() {
        return this.marginHorizontal;
    }

    public final double getMarginHorizontalLarge() {
        return this.marginHorizontalLarge;
    }

    public final int getMaxDelayJumpDuration() {
        return this.maxDelayJumpDuration;
    }

    public final boolean getModifyExposureEventParamsEnable() {
        return this.modifyExposureEventParamsEnable;
    }

    public final int getRenderFirstScreenWaitingTimeout() {
        return this.renderFirstScreenWaitingTimeout;
    }

    public final boolean getReportFirstCardOnly() {
        return this.reportFirstCardOnly;
    }

    public final int getTargetDuration() {
        return this.targetDuration;
    }

    public final Placeholder findHeaderPlaceholder(String r100) {
        Intrinsics.checkNotNullParameter(r100, "headerPlaceholderType");
        Map<String, Placeholder> r101 = this.headerPlaceholderMap;
        if (r101 == null) goto L10;
        Placeholder r102 = r101.get(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.isValid() == true) goto L9;
        return null;
    L9:
        return r102;
    L10:
        return null;
    }

    public final void setCardCount(int r100) {
        this.cardCount = r100;
    }

    public final void setCardCountLarge(int r100) {
        this.cardCountLarge = r100;
    }

    public final void setCardCoverPlaceholder(String r100) {
        this.cardCoverPlaceholder = r100;
    }

    public final void setCardCoverPlaceholderRatio(float r100) {
        this.cardCoverPlaceholderRatio = r100;
    }

    public final void setCardRadius(double r100) {
        this.cardRadius = r100;
    }

    public final void setCardTitlePlaceholder(String r100) {
        this.cardTitlePlaceholder = r100;
    }

    public final void setCardTitlePlaceholderRatio(float r100) {
        this.cardTitlePlaceholderRatio = r100;
    }

    public final void setForbidExitAnimation(boolean r100) {
        this.forbidExitAnimation = r100;
    }

    public final void setForceLayoutEnable(boolean r100) {
        this.forceLayoutEnable = r100;
    }

    public final void setHeaderPlaceholderMap(Map<String, Placeholder> r100) {
        this.headerPlaceholderMap = r100;
    }

    public final void setItemGap(double r100) {
        this.itemGap = r100;
    }

    public final void setItemGapLarge(double r100) {
        this.itemGapLarge = r100;
    }

    public final void setJumpAfterImageLoaded(boolean r100) {
        this.jumpAfterImageLoaded = r100;
    }

    public final void setMarginHorizontal(double r100) {
        this.marginHorizontal = r100;
    }

    public final void setMarginHorizontalLarge(double r100) {
        this.marginHorizontalLarge = r100;
    }

    public final void setMaxDelayJumpDuration(int r100) {
        this.maxDelayJumpDuration = r100;
    }

    public final void setModifyExposureEventParamsEnable(boolean r100) {
        this.modifyExposureEventParamsEnable = r100;
    }

    public final void setRenderFirstScreenWaitingTimeout(int r100) {
        this.renderFirstScreenWaitingTimeout = r100;
    }

    public final void setReportFirstCardOnly(boolean r100) {
        this.reportFirstCardOnly = r100;
    }

    public final void setTargetDuration(int r100) {
        this.targetDuration = r100;
    }
}
