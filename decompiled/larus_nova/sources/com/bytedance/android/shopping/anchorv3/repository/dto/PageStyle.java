package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b8\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\bS\u0010TJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR$\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R$\u0010)\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\b\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010\fR$\u0010,\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010!\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R$\u0010/\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010!\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R$\u00102\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010!\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R$\u00105\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\b\u001a\u0004\b6\u0010\n\"\u0004\b7\u0010\fR$\u00108\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\b\u001a\u0004\b9\u0010\n\"\u0004\b:\u0010\fR$\u0010;\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\b\u001a\u0004\b<\u0010\n\"\u0004\b=\u0010\fR$\u0010>\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\b\u001a\u0004\b?\u0010\n\"\u0004\b@\u0010\fR\"\u0010A\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010G\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010B\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR\"\u0010J\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010B\u001a\u0004\bK\u0010D\"\u0004\bL\u0010FR\"\u0010M\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010B\u001a\u0004\bN\u0010D\"\u0004\bO\u0010FR\"\u0010P\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010B\u001a\u0004\bQ\u0010D\"\u0004\bR\u0010F¨\u0006W"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/PageStyle;", "Ljava/io/Serializable;", "", "isGuessULikeShowSearchPdt", "searchCardWithPicture", "searchCardWithHashTag", "", "cardShadow", "Ljava/lang/Integer;", "getCardShadow", "()Ljava/lang/Integer;", "setCardShadow", "(Ljava/lang/Integer;)V", "bgHighLight", "getBgHighLight", "setBgHighLight", "slideStyle", "getSlideStyle", "setSlideStyle", "headerMallDisplay", "getHeaderMallDisplay", "setHeaderMallDisplay", "headerSearchDisplay", "getHeaderSearchDisplay", "setHeaderSearchDisplay", "headerCartDisplay", "getHeaderCartDisplay", "setHeaderCartDisplay", "headerCouponDisplay", "getHeaderCouponDisplay", "setHeaderCouponDisplay", "", "headerCouponSchema", "Ljava/lang/String;", "getHeaderCouponSchema", "()Ljava/lang/String;", "setHeaderCouponSchema", "(Ljava/lang/String;)V", "headerCouponHalfScreenSchema", "getHeaderCouponHalfScreenSchema", "setHeaderCouponHalfScreenSchema", "commentStyle", "getCommentStyle", "setCommentStyle", "feedDesc", "getFeedDesc", "setFeedDesc", "feedNoProductDesc", "getFeedNoProductDesc", "setFeedNoProductDesc", "feedShowAllDesc", "getFeedShowAllDesc", "setFeedShowAllDesc", "sameProductStyle", "getSameProductStyle", "setSameProductStyle", "sameProductSwitch", "getSameProductSwitch", "setSameProductSwitch", "authorCommissionSwitch", "getAuthorCommissionSwitch", "setAuthorCommissionSwitch", "showCount", "getShowCount", "setShowCount", "searchPdtSwitch", "I", "getSearchPdtSwitch", "()I", "setSearchPdtSwitch", "(I)V", "searchPdtStyle", "getSearchPdtStyle", "setSearchPdtStyle", "searchResourceStyle", "getSearchResourceStyle", "setSearchResourceStyle", "searchCardFreq", "getSearchCardFreq", "setSearchCardFreq", "windowEntryPriority", "getWindowEntryPriority", "setWindowEntryPriority", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageStyle implements Serializable {
    public static final int ALL_CARD_SHOW_SAME_ENTRANCE = 3;
    public static final a Companion = null;
    public static final int GUESSSULIKE_CARD_SHOW_SAME_ENTRANCE = 2;
    public static final int MAIN_CARD_SHOW_SAME_ENTRANCE = 1;

    @SerializedName("author_commission_switch")
    private Integer authorCommissionSwitch;

    @SerializedName("bg_high_light")
    private Integer bgHighLight;

    @SerializedName("card_shadow")
    private Integer cardShadow;

    @SerializedName("comment_style")
    private Integer commentStyle;

    @SerializedName("feed_desc")
    private String feedDesc;

    @SerializedName("feed_no_product_desc")
    private String feedNoProductDesc;

    @SerializedName("feed_show_all_desc")
    private String feedShowAllDesc;

    @SerializedName("header_cart_display")
    private Integer headerCartDisplay;

    @SerializedName("header_coupon_display")
    private Integer headerCouponDisplay;

    @SerializedName("header_coupon_half_screen_schema")
    private String headerCouponHalfScreenSchema;

    @SerializedName("header_coupon_schema")
    private String headerCouponSchema;

    @SerializedName("header_mall_display")
    private Integer headerMallDisplay;

    @SerializedName("header_search_display")
    private Integer headerSearchDisplay;

    @SerializedName("same_product_style")
    private Integer sameProductStyle;

    @SerializedName("same_product_switch")
    private Integer sameProductSwitch;

    @SerializedName("search_card_freq")
    private int searchCardFreq;

    @SerializedName("search_pdt_style")
    private int searchPdtStyle;

    @SerializedName("search_pdt_switch")
    private int searchPdtSwitch;

    @SerializedName("search_resource_style")
    private int searchResourceStyle;

    @SerializedName("show_count")
    private Integer showCount;

    @SerializedName("slide_style")
    private Integer slideStyle;

    @SerializedName("window_entry_priority")
    private int windowEntryPriority;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isGuessULikeShowSearchPdt() {
        if (this.searchPdtSwitch <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean searchCardWithHashTag() {
        if (this.searchResourceStyle != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean searchCardWithPicture() {
        if (this.searchResourceStyle == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public PageStyle() {
        this.searchCardFreq = -1;
        this.windowEntryPriority = -1;
    }

    public final Integer getAuthorCommissionSwitch() {
        return this.authorCommissionSwitch;
    }

    public final Integer getBgHighLight() {
        return this.bgHighLight;
    }

    public final Integer getCardShadow() {
        return this.cardShadow;
    }

    public final Integer getCommentStyle() {
        return this.commentStyle;
    }

    public final String getFeedDesc() {
        return this.feedDesc;
    }

    public final String getFeedNoProductDesc() {
        return this.feedNoProductDesc;
    }

    public final String getFeedShowAllDesc() {
        return this.feedShowAllDesc;
    }

    public final Integer getHeaderCartDisplay() {
        return this.headerCartDisplay;
    }

    public final Integer getHeaderCouponDisplay() {
        return this.headerCouponDisplay;
    }

    public final String getHeaderCouponHalfScreenSchema() {
        return this.headerCouponHalfScreenSchema;
    }

    public final String getHeaderCouponSchema() {
        return this.headerCouponSchema;
    }

    public final Integer getHeaderMallDisplay() {
        return this.headerMallDisplay;
    }

    public final Integer getHeaderSearchDisplay() {
        return this.headerSearchDisplay;
    }

    public final Integer getSameProductStyle() {
        return this.sameProductStyle;
    }

    public final Integer getSameProductSwitch() {
        return this.sameProductSwitch;
    }

    public final int getSearchCardFreq() {
        return this.searchCardFreq;
    }

    public final int getSearchPdtStyle() {
        return this.searchPdtStyle;
    }

    public final int getSearchPdtSwitch() {
        return this.searchPdtSwitch;
    }

    public final int getSearchResourceStyle() {
        return this.searchResourceStyle;
    }

    public final Integer getShowCount() {
        return this.showCount;
    }

    public final Integer getSlideStyle() {
        return this.slideStyle;
    }

    public final int getWindowEntryPriority() {
        return this.windowEntryPriority;
    }

    public final void setAuthorCommissionSwitch(Integer r100) {
        this.authorCommissionSwitch = r100;
    }

    public final void setBgHighLight(Integer r100) {
        this.bgHighLight = r100;
    }

    public final void setCardShadow(Integer r100) {
        this.cardShadow = r100;
    }

    public final void setCommentStyle(Integer r100) {
        this.commentStyle = r100;
    }

    public final void setFeedDesc(String r100) {
        this.feedDesc = r100;
    }

    public final void setFeedNoProductDesc(String r100) {
        this.feedNoProductDesc = r100;
    }

    public final void setFeedShowAllDesc(String r100) {
        this.feedShowAllDesc = r100;
    }

    public final void setHeaderCartDisplay(Integer r100) {
        this.headerCartDisplay = r100;
    }

    public final void setHeaderCouponDisplay(Integer r100) {
        this.headerCouponDisplay = r100;
    }

    public final void setHeaderCouponHalfScreenSchema(String r100) {
        this.headerCouponHalfScreenSchema = r100;
    }

    public final void setHeaderCouponSchema(String r100) {
        this.headerCouponSchema = r100;
    }

    public final void setHeaderMallDisplay(Integer r100) {
        this.headerMallDisplay = r100;
    }

    public final void setHeaderSearchDisplay(Integer r100) {
        this.headerSearchDisplay = r100;
    }

    public final void setSameProductStyle(Integer r100) {
        this.sameProductStyle = r100;
    }

    public final void setSameProductSwitch(Integer r100) {
        this.sameProductSwitch = r100;
    }

    public final void setSearchCardFreq(int r100) {
        this.searchCardFreq = r100;
    }

    public final void setSearchPdtStyle(int r100) {
        this.searchPdtStyle = r100;
    }

    public final void setSearchPdtSwitch(int r100) {
        this.searchPdtSwitch = r100;
    }

    public final void setSearchResourceStyle(int r100) {
        this.searchResourceStyle = r100;
    }

    public final void setShowCount(Integer r100) {
        this.showCount = r100;
    }

    public final void setSlideStyle(Integer r100) {
        this.slideStyle = r100;
    }

    public final void setWindowEntryPriority(int r100) {
        this.windowEntryPriority = r100;
    }
}
