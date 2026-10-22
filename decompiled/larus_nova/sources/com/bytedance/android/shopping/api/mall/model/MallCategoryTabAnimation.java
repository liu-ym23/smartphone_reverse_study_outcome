package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0018\u0010\u000e¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAnimation;", "", "animationType", "", "carouselTimes", "lightLottie", "", "darkLottie", "rateSeconds", "", "rateTimes", "priority", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAnimationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCarouselTimes", "getDarkLottie", "()Ljava/lang/String;", "getLightLottie", "getPriority", "getRateSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRateTimes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAnimation;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallCategoryTabAnimation {

    @SerializedName("animation_type")
    private final Integer animationType;

    @SerializedName("carousel_times")
    private final Integer carouselTimes;

    @SerializedName("dark_lottie")
    private final String darkLottie;

    @SerializedName("light_lottie")
    private final String lightLottie;

    @SerializedName("priority")
    private final Integer priority;

    @SerializedName("rate_seconds")
    private final Long rateSeconds;

    @SerializedName("rate_times")
    private final Integer rateTimes;

    public MallCategoryTabAnimation() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MallCategoryTabAnimation copy$default(MallCategoryTabAnimation r100, Integer r101, Integer r102, String r103, String r104, Long r110, Integer r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.animationType;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.carouselTimes;
    L8:
        Integer r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.lightLottie;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.darkLottie;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.rateSeconds;
    L17:
        Long r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.rateTimes;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.priority;
    L23:
        Integer r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Integer component1() {
        return this.animationType;
    }

    public final Integer component2() {
        return this.carouselTimes;
    }

    public final String component3() {
        return this.lightLottie;
    }

    public final String component4() {
        return this.darkLottie;
    }

    public final Long component5() {
        return this.rateSeconds;
    }

    public final Integer component6() {
        return this.rateTimes;
    }

    public final Integer component7() {
        return this.priority;
    }

    public final MallCategoryTabAnimation copy(Integer r110, Integer r111, String r112, String r113, Long r114, Integer r115, Integer r116) {
        return new MallCategoryTabAnimation(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MallCategoryTabAnimation) == false) goto L20;
        MallCategoryTabAnimation r101 = (MallCategoryTabAnimation) r100;
        if (Intrinsics.areEqual(this.animationType, r101.animationType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.carouselTimes, r101.carouselTimes) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lightLottie, r101.lightLottie) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.darkLottie, r101.darkLottie) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.rateSeconds, r101.rateSeconds) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.rateTimes, r101.rateTimes) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.priority, r101.priority) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.animationType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.carouselTimes;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lightLottie;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.darkLottie;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.rateSeconds;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.rateTimes;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.priority;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "MallCategoryTabAnimation(animationType=" + this.animationType + ", carouselTimes=" + this.carouselTimes + ", lightLottie=" + this.lightLottie + ", darkLottie=" + this.darkLottie + ", rateSeconds=" + this.rateSeconds + ", rateTimes=" + this.rateTimes + ", priority=" + this.priority + ")";
    }

    public final Integer getAnimationType() {
        return this.animationType;
    }

    public final Integer getCarouselTimes() {
        return this.carouselTimes;
    }

    public final String getDarkLottie() {
        return this.darkLottie;
    }

    public final String getLightLottie() {
        return this.lightLottie;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Long getRateSeconds() {
        return this.rateSeconds;
    }

    public final Integer getRateTimes() {
        return this.rateTimes;
    }

    public MallCategoryTabAnimation(Integer r100, Integer r101, String r102, String r103, Long r104, Integer r105, Integer r106) {
        this.animationType = r100;
        this.carouselTimes = r101;
        this.lightLottie = r102;
        this.darkLottie = r103;
        this.rateSeconds = r104;
        this.rateTimes = r105;
        this.priority = r106;
    }

    public /* synthetic */ MallCategoryTabAnimation(Integer r100, Integer r101, String r102, String r110, Long r111, Integer r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Integer r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Integer r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Long r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
