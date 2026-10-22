package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003JW\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0007HÖ\u0001R \u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionPreSale;", "Ljava/io/Serializable;", "deliveryTime", "", "serverTime", "endTime", "endTimeText", "", "deliveryInfoPrefix", "deliveryInfo", "buttonPrefix", "(JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonPrefix", "()Ljava/lang/String;", "setButtonPrefix", "(Ljava/lang/String;)V", "getDeliveryInfo", "setDeliveryInfo", "getDeliveryInfoPrefix", "setDeliveryInfoPrefix", "getDeliveryTime", "()J", "setDeliveryTime", "(J)V", "getEndTime", "setEndTime", "getEndTimeText", "setEndTimeText", "getServerTime", "setServerTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionPreSale implements Serializable {

    @SerializedName("button_prefix")
    private String buttonPrefix;

    @SerializedName("delivery_info")
    private String deliveryInfo;

    @SerializedName("delivery_info_prefix")
    private String deliveryInfoPrefix;

    @SerializedName("delivery_time")
    private long deliveryTime;

    @SerializedName("end_time")
    private long endTime;

    @SerializedName("end_time_text")
    private String endTimeText;

    @SerializedName("server_time")
    private long serverTime;

    public PromotionPreSale() {
        this(0, 0, 0, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PromotionPreSale copy$default(PromotionPreSale r110, long r111, long r112, long r113, String r114, String r115, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        long r100 = r110.deliveryTime;
    L7:
        if ((r212 & 2) == 0) goto L9;
        long r101 = r110.serverTime;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.endTime;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.endTimeText;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.deliveryInfoPrefix;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.deliveryInfo;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r116 = r110.buttonPrefix;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r116);
    L29:
        r116 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
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

    public final long component1() {
        return this.deliveryTime;
    }

    public final long component2() {
        return this.serverTime;
    }

    public final long component3() {
        return this.endTime;
    }

    public final String component4() {
        return this.endTimeText;
    }

    public final String component5() {
        return this.deliveryInfoPrefix;
    }

    public final String component6() {
        return this.deliveryInfo;
    }

    public final String component7() {
        return this.buttonPrefix;
    }

    public final PromotionPreSale copy(long r110, long r111, long r112, String r113, String r210, String r211, String r212) {
        return new PromotionPreSale(r110, r111, r112, r113, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionPreSale) == false) goto L20;
        PromotionPreSale r101 = (PromotionPreSale) r100;
        if (this.deliveryTime == r101.deliveryTime) goto L8;
        return false;
    L8:
        if (this.serverTime == r101.serverTime) goto L10;
        return false;
    L10:
        if (this.endTime == r101.endTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTimeText, r101.endTimeText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.deliveryInfoPrefix, r101.deliveryInfoPrefix) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.deliveryInfo, r101.deliveryInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.buttonPrefix, r101.buttonPrefix) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        long r100 = this.deliveryTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.serverTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.endTime;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.endTimeText;
        int r107 = 0;
        if (r106 == null) goto L5;
        int r108 = r106.hashCode();
    L6:
        int r109 = (r105 + r108) * 31;
        String r110 = this.deliveryInfoPrefix;
        if (r110 == null) goto L9;
        int r111 = r110.hashCode();
    L10:
        int r112 = (r109 + r111) * 31;
        String r113 = this.deliveryInfo;
        if (r113 == null) goto L13;
        int r114 = r113.hashCode();
    L14:
        int r115 = (r112 + r114) * 31;
        String r116 = this.buttonPrefix;
        if (r116 == null) goto L18;
        r107 = r116.hashCode();
    L18:
        return r115 + r107;
    L13:
        r114 = 0;
        goto L14
    L9:
        r111 = 0;
        goto L10
    L5:
        r108 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionPreSale(deliveryTime=" + this.deliveryTime + ", serverTime=" + this.serverTime + ", endTime=" + this.endTime + ", endTimeText=" + this.endTimeText + ", deliveryInfoPrefix=" + this.deliveryInfoPrefix + ", deliveryInfo=" + this.deliveryInfo + ", buttonPrefix=" + this.buttonPrefix + ")";
    }

    public final String getButtonPrefix() {
        return this.buttonPrefix;
    }

    public final String getDeliveryInfo() {
        return this.deliveryInfo;
    }

    public final String getDeliveryInfoPrefix() {
        return this.deliveryInfoPrefix;
    }

    public final long getDeliveryTime() {
        return this.deliveryTime;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getEndTimeText() {
        return this.endTimeText;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final void setButtonPrefix(String r100) {
        this.buttonPrefix = r100;
    }

    public final void setDeliveryInfo(String r100) {
        this.deliveryInfo = r100;
    }

    public final void setDeliveryInfoPrefix(String r100) {
        this.deliveryInfoPrefix = r100;
    }

    public final void setDeliveryTime(long r100) {
        this.deliveryTime = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setEndTimeText(String r100) {
        this.endTimeText = r100;
    }

    public final void setServerTime(long r100) {
        this.serverTime = r100;
    }

    public PromotionPreSale(long r100, long r101, long r102, String r103, String r104, String r105, String r110) {
        this.deliveryTime = r100;
        this.serverTime = r101;
        this.endTime = r102;
        this.endTimeText = r103;
        this.deliveryInfoPrefix = r104;
        this.deliveryInfo = r105;
        this.buttonPrefix = r110;
    }

    public /* synthetic */ PromotionPreSale(long r110, long r111, long r112, String r113, String r114, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        long r100 = 0;
        if ((r212 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r212 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r212 & 4) != 0) goto L14;
        r100 = r112;
    L14:
        String r103 = "";
        if ((r212 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r212 & 64) != 0) goto L30;
        r103 = r211;
    L30:
        this(r101, r102, r100, r104, r105, r106, r103);
        return;
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
