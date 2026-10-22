package com.bytedance.android.shopping.deepfeed.data.repo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJÂ\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020\u00032\b\u0010D\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010E\u001a\u00020\bHÖ\u0001J\t\u0010F\u001a\u00020#HÖ\u0001R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016R&\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b)\u0010\u001aR\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b*\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b.\u0010\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b/\u0010\u001aR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b0\u0010\u001aR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b1\u0010\u0016¨\u0006G"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;", "Ljava/io/Serializable;", "styleOpt", "", "styleOptV2", "reduceHeight", "changeButtonColor", "notFullScreenCount", "", "slideToastFreqCount", "slideToastFreqCycle", "", "slideToastFreqVersion", "enterProductAutoSlide", "changeImageSlogan", "videoWithImage", "aiRecommendPosition", "aiRecommendAnim", "deepFeedUseSlc", "keepAiWord", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAiRecommendAnim", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAiRecommendPosition", "getChangeButtonColor", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getChangeImageSlogan", "getDeepFeedUseSlc", "getEnterProductAutoSlide", "getKeepAiWord", "getNotFullScreenCount", "originMap", "", "", "", "getOriginMap", "()Ljava/util/Map;", "setOriginMap", "(Ljava/util/Map;)V", "getReduceHeight", "getSlideToastFreqCount", "getSlideToastFreqCycle", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSlideToastFreqVersion", "getStyleOpt", "getStyleOptV2", "getVideoWithImage", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;", "equals", "other", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedAbValues implements Serializable {

    @SerializedName("ai_recommend_animation")
    private final Integer aiRecommendAnim;

    @SerializedName("ai_recommend_position")
    private final Integer aiRecommendPosition;

    @SerializedName("change_button_color")
    private final Boolean changeButtonColor;

    @SerializedName("change_image_slogan")
    private final Boolean changeImageSlogan;

    @SerializedName("deep_feed_slice")
    private final Integer deepFeedUseSlc;

    @SerializedName("enter_product_auto_slide")
    private final Boolean enterProductAutoSlide;

    @SerializedName("keep_ai_word")
    private final Boolean keepAiWord;

    @SerializedName("not_full_screen_cell_count")
    private final Integer notFullScreenCount;
    private Map<String, ? extends Object> originMap;

    @SerializedName("reduce_height")
    private final Boolean reduceHeight;

    @SerializedName("slide_toast_freq_count")
    private final Integer slideToastFreqCount;

    @SerializedName("slide_toast_freq_cycle")
    private final Double slideToastFreqCycle;

    @SerializedName("slide_toast_freq_version")
    private final Integer slideToastFreqVersion;

    @SerializedName("style_optimize")
    private final Boolean styleOpt;

    @SerializedName("style_optimize_v2")
    private final Boolean styleOptV2;

    @SerializedName("video_with_images")
    private final Integer videoWithImage;

    public DeepFeedAbValues() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public static /* synthetic */ DeepFeedAbValues copy$default(DeepFeedAbValues r110, Boolean r111, Boolean r112, Boolean r113, Boolean r210, Integer r211, Integer r212, Double r213, Integer r214, Boolean r215, Boolean r216, Integer r217, Integer r218, Integer r219, Integer r310, Boolean r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        Boolean r100 = r110.styleOpt;
    L7:
        if ((r312 & 2) == 0) goto L9;
        Boolean r101 = r110.styleOptV2;
    L11:
        if ((r312 & 4) == 0) goto L13;
        Boolean r102 = r110.reduceHeight;
    L15:
        if ((r312 & 8) == 0) goto L17;
        Boolean r103 = r110.changeButtonColor;
    L19:
        if ((r312 & 16) == 0) goto L21;
        Integer r104 = r110.notFullScreenCount;
    L23:
        if ((r312 & 32) == 0) goto L25;
        Integer r105 = r110.slideToastFreqCount;
    L27:
        if ((r312 & 64) == 0) goto L29;
        Double r106 = r110.slideToastFreqCycle;
    L31:
        if ((r312 & 128) == 0) goto L33;
        Integer r107 = r110.slideToastFreqVersion;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Boolean r114 = r110.enterProductAutoSlide;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Boolean r115 = r110.changeImageSlogan;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        Integer r116 = r110.videoWithImage;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Integer r117 = r110.aiRecommendPosition;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        Integer r118 = r110.aiRecommendAnim;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        Integer r119 = r110.deepFeedUseSlc;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        Boolean r108 = r110.keepAiWord;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Boolean component1() {
        return this.styleOpt;
    }

    public final Boolean component10() {
        return this.changeImageSlogan;
    }

    public final Integer component11() {
        return this.videoWithImage;
    }

    public final Integer component12() {
        return this.aiRecommendPosition;
    }

    public final Integer component13() {
        return this.aiRecommendAnim;
    }

    public final Integer component14() {
        return this.deepFeedUseSlc;
    }

    public final Boolean component15() {
        return this.keepAiWord;
    }

    public final Boolean component2() {
        return this.styleOptV2;
    }

    public final Boolean component3() {
        return this.reduceHeight;
    }

    public final Boolean component4() {
        return this.changeButtonColor;
    }

    public final Integer component5() {
        return this.notFullScreenCount;
    }

    public final Integer component6() {
        return this.slideToastFreqCount;
    }

    public final Double component7() {
        return this.slideToastFreqCycle;
    }

    public final Integer component8() {
        return this.slideToastFreqVersion;
    }

    public final Boolean component9() {
        return this.enterProductAutoSlide;
    }

    public final DeepFeedAbValues copy(Boolean r110, Boolean r111, Boolean r210, Boolean r211, Integer r212, Integer r213, Double r214, Integer r215, Boolean r216, Boolean r217, Integer r218, Integer r219, Integer r310, Integer r311, Boolean r312) {
        return new DeepFeedAbValues(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DeepFeedAbValues) == false) goto L36;
        DeepFeedAbValues r101 = (DeepFeedAbValues) r100;
        if (Intrinsics.areEqual(this.styleOpt, r101.styleOpt) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.styleOptV2, r101.styleOptV2) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.reduceHeight, r101.reduceHeight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.changeButtonColor, r101.changeButtonColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.notFullScreenCount, r101.notFullScreenCount) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.slideToastFreqCount, r101.slideToastFreqCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.slideToastFreqCycle, r101.slideToastFreqCycle) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.slideToastFreqVersion, r101.slideToastFreqVersion) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.enterProductAutoSlide, r101.enterProductAutoSlide) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.changeImageSlogan, r101.changeImageSlogan) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.videoWithImage, r101.videoWithImage) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.aiRecommendPosition, r101.aiRecommendPosition) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.aiRecommendAnim, r101.aiRecommendAnim) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.deepFeedUseSlc, r101.deepFeedUseSlc) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.keepAiWord, r101.keepAiWord) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public int hashCode() {
        Boolean r100 = this.styleOpt;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.styleOptV2;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.reduceHeight;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.changeButtonColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.notFullScreenCount;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.slideToastFreqCount;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Double r119 = this.slideToastFreqCycle;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.slideToastFreqVersion;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.enterProductAutoSlide;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.changeImageSlogan;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.videoWithImage;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.aiRecommendPosition;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.aiRecommendAnim;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.deepFeedUseSlc;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Boolean r143 = this.keepAiWord;
        if (r143 == null) goto L62;
        r101 = r143.hashCode();
    L62:
        return r142 + r101;
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DeepFeedAbValues(styleOpt=" + this.styleOpt + ", styleOptV2=" + this.styleOptV2 + ", reduceHeight=" + this.reduceHeight + ", changeButtonColor=" + this.changeButtonColor + ", notFullScreenCount=" + this.notFullScreenCount + ", slideToastFreqCount=" + this.slideToastFreqCount + ", slideToastFreqCycle=" + this.slideToastFreqCycle + ", slideToastFreqVersion=" + this.slideToastFreqVersion + ", enterProductAutoSlide=" + this.enterProductAutoSlide + ", changeImageSlogan=" + this.changeImageSlogan + ", videoWithImage=" + this.videoWithImage + ", aiRecommendPosition=" + this.aiRecommendPosition + ", aiRecommendAnim=" + this.aiRecommendAnim + ", deepFeedUseSlc=" + this.deepFeedUseSlc + ", keepAiWord=" + this.keepAiWord + ")";
    }

    public final Integer getAiRecommendAnim() {
        return this.aiRecommendAnim;
    }

    public final Integer getAiRecommendPosition() {
        return this.aiRecommendPosition;
    }

    public final Boolean getChangeButtonColor() {
        return this.changeButtonColor;
    }

    public final Boolean getChangeImageSlogan() {
        return this.changeImageSlogan;
    }

    public final Integer getDeepFeedUseSlc() {
        return this.deepFeedUseSlc;
    }

    public final Boolean getEnterProductAutoSlide() {
        return this.enterProductAutoSlide;
    }

    public final Boolean getKeepAiWord() {
        return this.keepAiWord;
    }

    public final Integer getNotFullScreenCount() {
        return this.notFullScreenCount;
    }

    public final Map<String, Object> getOriginMap() {
        return this.originMap;
    }

    public final Boolean getReduceHeight() {
        return this.reduceHeight;
    }

    public final Integer getSlideToastFreqCount() {
        return this.slideToastFreqCount;
    }

    public final Double getSlideToastFreqCycle() {
        return this.slideToastFreqCycle;
    }

    public final Integer getSlideToastFreqVersion() {
        return this.slideToastFreqVersion;
    }

    public final Boolean getStyleOpt() {
        return this.styleOpt;
    }

    public final Boolean getStyleOptV2() {
        return this.styleOptV2;
    }

    public final Integer getVideoWithImage() {
        return this.videoWithImage;
    }

    public final void setOriginMap(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originMap = r100;
    }

    public DeepFeedAbValues(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Integer r104, Integer r105, Double r106, Integer r107, Boolean r108, Boolean r110, Integer r111, Integer r112, Integer r113, Integer r114, Boolean r115) {
        this.styleOpt = r100;
        this.styleOptV2 = r101;
        this.reduceHeight = r102;
        this.changeButtonColor = r103;
        this.notFullScreenCount = r104;
        this.slideToastFreqCount = r105;
        this.slideToastFreqCycle = r106;
        this.slideToastFreqVersion = r107;
        this.enterProductAutoSlide = r108;
        this.changeImageSlogan = r110;
        this.videoWithImage = r111;
        this.aiRecommendPosition = r112;
        this.aiRecommendAnim = r113;
        this.deepFeedUseSlc = r114;
        this.keepAiWord = r115;
        this.originMap = MapsKt.emptyMap();
    }

    public /* synthetic */ DeepFeedAbValues(Boolean r110, Boolean r111, Boolean r112, Boolean r210, Integer r211, Integer r212, Double r213, Integer r214, Boolean r215, Boolean r216, Integer r217, Integer r218, Integer r219, Integer r310, Boolean r311, int r312, DefaultConstructorMarker r313) {
        Boolean r100 = null;
        if ((r312 & 1) == 0) goto L5;
        Boolean r101 = null;
    L7:
        if ((r312 & 2) == 0) goto L9;
        Boolean r102 = null;
    L11:
        if ((r312 & 4) == 0) goto L13;
        Boolean r103 = Boolean.FALSE;
    L15:
        if ((r312 & 8) == 0) goto L17;
        Boolean r104 = null;
    L19:
        if ((r312 & 16) == 0) goto L21;
        Integer r105 = 3;
    L23:
        if ((r312 & 32) == 0) goto L25;
        Integer r106 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        Double r107 = Double.valueOf(-1.0d);
    L31:
        if ((r312 & 128) == 0) goto L33;
        Integer r108 = 0;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Boolean r113 = Boolean.FALSE;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Boolean r114 = null;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        Integer r115 = null;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Integer r116 = null;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        Integer r117 = null;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        Integer r118 = null;
    L59:
        if ((r312 & 16384) != 0) goto L62;
        r100 = r311;
    L62:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r118, r100);
        return;
    L57:
        r118 = r310;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L49:
        r116 = r218;
        goto L51
    L45:
        r115 = r217;
        goto L47
    L41:
        r114 = r216;
        goto L43
    L37:
        r113 = r215;
        goto L39
    L33:
        r108 = r214;
        goto L35
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
