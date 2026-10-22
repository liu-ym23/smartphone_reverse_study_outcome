package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0001CBw\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b@\u0010AJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u0002HÆ\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0080\u0001\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001f\u001a\u00020\u001eHÖ\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010$\u001a\u0004\b.\u0010&\"\u0004\b/\u0010(R$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010)\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b2\u0010+R$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b8\u0010&R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010$\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010;\u001a\u0004\b<\u0010\u000eR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010=\u001a\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECAuctionInfo;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "component5", "Lcom/bytedance/android/ec/model/response/ECAuctionCurrentUserInfo;", "component6", "component7", "component8", "component9", "()Ljava/lang/Long;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component10", "price", "priceLabel", "status", "buttonLabel", "jumpUrl", "currentUserInfo", "auctionId", "endTime", "bizId", "statusIcon", "copy", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/ECAuctionCurrentUserInfo;JJLjava/lang/Long;Lcom/bytedance/android/ec/model/ECUrlModel;)Lcom/bytedance/android/ec/model/response/ECAuctionInfo;", "toString", "", "hashCode", "", "other", "", "equals", "J", "getPrice", "()J", "setPrice", "(J)V", "Ljava/lang/String;", "getPriceLabel", "()Ljava/lang/String;", "setPriceLabel", "(Ljava/lang/String;)V", "getStatus", "setStatus", "getButtonLabel", "setButtonLabel", "getJumpUrl", "Lcom/bytedance/android/ec/model/response/ECAuctionCurrentUserInfo;", "getCurrentUserInfo", "()Lcom/bytedance/android/ec/model/response/ECAuctionCurrentUserInfo;", "setCurrentUserInfo", "(Lcom/bytedance/android/ec/model/response/ECAuctionCurrentUserInfo;)V", "getAuctionId", "getEndTime", "setEndTime", "Ljava/lang/Long;", "getBizId", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getStatusIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "<init>", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/ECAuctionCurrentUserInfo;JJLjava/lang/Long;Lcom/bytedance/android/ec/model/ECUrlModel;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAuctionInfo implements Serializable {
    public static final long BIZ_ID_AUCTION_V2 = 2;
    public static final a Companion = null;
    public static final long STATUS_CANCEL = 5;
    public static final long STATUS_FINISH = 4;
    public static final long STATUS_ONGOING = 2;
    public static final long STATUS_PREPARE = 1;
    public static final long STATUS_PRE_END = 6;
    public static final long STATUS_SUCCESS = 3;

    @SerializedName("auction_id")
    private final long auctionId;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    private final Long bizId;

    @SerializedName("button_label")
    private String buttonLabel;

    @SerializedName("current_user_info")
    private ECAuctionCurrentUserInfo currentUserInfo;

    @SerializedName("end_time")
    private long endTime;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("price")
    private long price;

    @SerializedName("price_label")
    private String priceLabel;

    @SerializedName("status")
    private long status;

    @SerializedName("status_icon")
    private final ECUrlModel statusIcon;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECAuctionInfo() {
        this(0, null, 0, null, null, null, 0, 0, null, null, 1023, null);
    }

    public static /* synthetic */ ECAuctionInfo copy$default(ECAuctionInfo r110, long r111, String r112, long r113, String r210, String r211, ECAuctionCurrentUserInfo r212, long r213, long r214, Long r215, ECUrlModel r216, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        long r100 = r110.price;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.priceLabel;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r102 = r110.status;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r110.buttonLabel;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.jumpUrl;
    L23:
        if ((r310 & 32) == 0) goto L25;
        ECAuctionCurrentUserInfo r105 = r110.currentUserInfo;
    L27:
        if ((r310 & 64) == 0) goto L29;
        long r114 = r110.auctionId;
    L31:
        if ((r310 & 128) == 0) goto L33;
        long r115 = r110.endTime;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Long r116 = r110.bizId;
    L39:
        if ((r310 & 512) == 0) goto L41;
        ECUrlModel r106 = r110.statusIcon;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r114, r115, r116, r106);
    L41:
        r106 = r216;
        goto L43
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
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

    public final long component1() {
        return this.price;
    }

    public final ECUrlModel component10() {
        return this.statusIcon;
    }

    public final String component2() {
        return this.priceLabel;
    }

    public final long component3() {
        return this.status;
    }

    public final String component4() {
        return this.buttonLabel;
    }

    public final String component5() {
        return this.jumpUrl;
    }

    public final ECAuctionCurrentUserInfo component6() {
        return this.currentUserInfo;
    }

    public final long component7() {
        return this.auctionId;
    }

    public final long component8() {
        return this.endTime;
    }

    public final Long component9() {
        return this.bizId;
    }

    public final ECAuctionInfo copy(long r110, String r111, long r210, String r211, String r212, ECAuctionCurrentUserInfo r213, long r214, long r215, Long r216, ECUrlModel r310) {
        return new ECAuctionInfo(r110, r111, r210, r211, r212, r213, r214, r215, r216, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAuctionInfo) == false) goto L26;
        ECAuctionInfo r101 = (ECAuctionInfo) r100;
        if (this.price == r101.price) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.priceLabel, r101.priceLabel) == true) goto L10;
        return false;
    L10:
        if (this.status == r101.status) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buttonLabel, r101.buttonLabel) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.currentUserInfo, r101.currentUserInfo) == true) goto L18;
        return false;
    L18:
        if (this.auctionId == r101.auctionId) goto L20;
        return false;
    L20:
        if (this.endTime == r101.endTime) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.statusIcon, r101.statusIcon) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        long r100 = this.price;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.priceLabel;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        long r105 = this.status;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.buttonLabel;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.jumpUrl;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        ECAuctionCurrentUserInfo r113 = this.currentUserInfo;
        if (r113 == null) goto L17;
        int r114 = r113.hashCode();
    L18:
        long r115 = this.auctionId;
        int r116 = (((r112 + r114) * 31) + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.endTime;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        Long r119 = this.bizId;
        if (r119 == null) goto L21;
        int r120 = r119.hashCode();
    L22:
        int r121 = (r118 + r120) * 31;
        ECUrlModel r122 = this.statusIcon;
        if (r122 == null) goto L26;
        r103 = r122.hashCode();
    L26:
        return r121 + r103;
    L21:
        r120 = 0;
        goto L22
    L17:
        r114 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "ECAuctionInfo(price=" + this.price + ", priceLabel=" + this.priceLabel + ", status=" + this.status + ", buttonLabel=" + this.buttonLabel + ", jumpUrl=" + this.jumpUrl + ", currentUserInfo=" + this.currentUserInfo + ", auctionId=" + this.auctionId + ", endTime=" + this.endTime + ", bizId=" + this.bizId + ", statusIcon=" + this.statusIcon + ")";
    }

    public final long getAuctionId() {
        return this.auctionId;
    }

    public final Long getBizId() {
        return this.bizId;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final ECAuctionCurrentUserInfo getCurrentUserInfo() {
        return this.currentUserInfo;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final long getPrice() {
        return this.price;
    }

    public final String getPriceLabel() {
        return this.priceLabel;
    }

    public final long getStatus() {
        return this.status;
    }

    public final ECUrlModel getStatusIcon() {
        return this.statusIcon;
    }

    public final void setButtonLabel(String r100) {
        this.buttonLabel = r100;
    }

    public final void setCurrentUserInfo(ECAuctionCurrentUserInfo r100) {
        this.currentUserInfo = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setPrice(long r100) {
        this.price = r100;
    }

    public final void setPriceLabel(String r100) {
        this.priceLabel = r100;
    }

    public final void setStatus(long r100) {
        this.status = r100;
    }

    public ECAuctionInfo(long r100, String r101, long r102, String r103, String r104, ECAuctionCurrentUserInfo r105, long r106, long r110, Long r111, ECUrlModel r112) {
        this.price = r100;
        this.priceLabel = r101;
        this.status = r102;
        this.buttonLabel = r103;
        this.jumpUrl = r104;
        this.currentUserInfo = r105;
        this.auctionId = r106;
        this.endTime = r110;
        this.bizId = r111;
        this.statusIcon = r112;
    }

    public /* synthetic */ ECAuctionInfo(long r110, String r111, long r112, String r210, String r211, ECAuctionCurrentUserInfo r212, long r213, long r214, Long r215, ECUrlModel r216, int r310, DefaultConstructorMarker r311) {
        long r100 = 0;
        if ((r310 & 1) == 0) goto L5;
        long r101 = 0;
    L6:
        ECUrlModel r102 = null;
        if ((r310 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r104 = 0;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r113 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        ECAuctionCurrentUserInfo r114 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        long r115 = 0;
    L31:
        if ((r310 & 128) != 0) goto L35;
        r100 = r214;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Long r116 = null;
    L39:
        if ((r310 & 512) != 0) goto L42;
        r102 = r216;
    L42:
        this(r101, r103, r104, r105, r113, r114, r115, r100, r116, r102);
        return;
    L37:
        r116 = r215;
        goto L39
    L29:
        r115 = r213;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r113 = r211;
        goto L23
    L17:
        r105 = r210;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
