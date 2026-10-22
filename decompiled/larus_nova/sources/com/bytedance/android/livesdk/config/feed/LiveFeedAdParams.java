package com.bytedance.android.livesdk.config.feed;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/config/feed/LiveFeedAdParams;", "", "adId", "", "creativeId", "logExtra", "liveSDKInfoExtra", "ecpm", "", "couponApiParams", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Lcom/google/gson/JsonObject;)V", "getAdId", "()Ljava/lang/String;", "getCouponApiParams", "()Lcom/google/gson/JsonObject;", "getCreativeId", "getEcpm", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLiveSDKInfoExtra", "getLogExtra", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Lcom/google/gson/JsonObject;)Lcom/bytedance/android/livesdk/config/feed/LiveFeedAdParams;", "equals", "", "other", "hashCode", "", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedAdParams {

    @SerializedName("ad_id")
    private final String adId;

    @SerializedName("coupon_api_params")
    private final JsonObject couponApiParams;

    @SerializedName("creative_id")
    private final String creativeId;

    @SerializedName("ecpm")
    private final Double ecpm;

    @SerializedName("live_sdk_info_extra")
    private final String liveSDKInfoExtra;

    @SerializedName("log_extra")
    private final String logExtra;

    public LiveFeedAdParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ LiveFeedAdParams copy$default(LiveFeedAdParams r100, String r101, String r102, String r103, String r104, Double r105, JsonObject r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.adId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.creativeId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.logExtra;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.liveSDKInfoExtra;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.ecpm;
    L17:
        Double r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.couponApiParams;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.adId;
    }

    public final String component2() {
        return this.creativeId;
    }

    public final String component3() {
        return this.logExtra;
    }

    public final String component4() {
        return this.liveSDKInfoExtra;
    }

    public final Double component5() {
        return this.ecpm;
    }

    public final JsonObject component6() {
        return this.couponApiParams;
    }

    public final LiveFeedAdParams copy(String r100, String r110, String r111, String r112, Double r113, JsonObject r114) {
        return new LiveFeedAdParams(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveFeedAdParams) == false) goto L18;
        LiveFeedAdParams r101 = (LiveFeedAdParams) r100;
        if (Intrinsics.areEqual(this.adId, r101.adId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.creativeId, r101.creativeId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveSDKInfoExtra, r101.liveSDKInfoExtra) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ecpm, r101.ecpm) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.couponApiParams, r101.couponApiParams) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.adId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.creativeId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.logExtra;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.liveSDKInfoExtra;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.ecpm;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        JsonObject r116 = this.couponApiParams;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "LiveFeedAdParams(adId=" + this.adId + ", creativeId=" + this.creativeId + ", logExtra=" + this.logExtra + ", liveSDKInfoExtra=" + this.liveSDKInfoExtra + ", ecpm=" + this.ecpm + ", couponApiParams=" + this.couponApiParams + ")";
    }

    public final String getAdId() {
        return this.adId;
    }

    public final JsonObject getCouponApiParams() {
        return this.couponApiParams;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final Double getEcpm() {
        return this.ecpm;
    }

    public final String getLiveSDKInfoExtra() {
        return this.liveSDKInfoExtra;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public LiveFeedAdParams(String r100, String r101, String r102, String r103, Double r104, JsonObject r105) {
        this.adId = r100;
        this.creativeId = r101;
        this.logExtra = r102;
        this.liveSDKInfoExtra = r103;
        this.ecpm = r104;
        this.couponApiParams = r105;
    }

    public /* synthetic */ LiveFeedAdParams(String r100, String r101, String r102, String r103, Double r104, JsonObject r110, int r111, DefaultConstructorMarker r112) {
        String r105 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = "";
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = "";
    L15:
        if ((r111 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r111 & 16) == 0) goto L21;
        Double r108 = null;
    L23:
        if ((r111 & 32) == 0) goto L25;
        JsonObject r114 = null;
    L26:
        this(r113, r106, r107, r105, r108, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L21:
        r108 = r104;
        goto L23
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
