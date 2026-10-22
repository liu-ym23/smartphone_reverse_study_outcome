package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 ?2\u00020\u0001:\u0001@B{\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b=\u0010>J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u008b\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\b2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\t\u0010!\u001a\u00020\u0002HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001J\u0013\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b*\u0010)R\u001a\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b.\u0010)R\u001a\u0010\u0018\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\b3\u00104R\u001a\u0010\u001a\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b5\u0010-R\u001a\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b6\u0010-R\u001a\u0010\u001c\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b7\u00101R\u001a\u0010\u001d\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b8\u0010-R\u001a\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b9\u0010-R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010:\u001a\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/AuctionInfoStruct;", "Ljava/io/Serializable;", "", "component1", "component2", "", "component3", "component4", "", "component5", "", "Lcom/bytedance/android/ec/model/response/anchorv3/AuctionUserOrderInfoStruct;", "component6", "component7", "component8", "component9", "component10", "component11", "Lcom/bytedance/android/ec/model/response/anchorv3/Price;", "component12", "auctionId", "campaignId", "maxPrice", "headerPrice", "status", "auctionUsers", "auctionUserOrderNum", "startingPrice", "auctionType", "endTime", "serverTime", "price", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getAuctionId", "()Ljava/lang/String;", "getCampaignId", "J", "getMaxPrice", "()J", "getHeaderPrice", "I", "getStatus", "()I", "Ljava/util/List;", "getAuctionUsers", "()Ljava/util/List;", "getAuctionUserOrderNum", "getStartingPrice", "getAuctionType", "getEndTime", "getServerTime", "Lcom/bytedance/android/ec/model/response/anchorv3/Price;", "getPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/Price;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/util/List;JJIJJLcom/bytedance/android/ec/model/response/anchorv3/Price;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class AuctionInfoStruct implements Serializable {
    public static final a Companion = null;
    public static final int STATUS_BOUGHT_IN = 4;
    public static final int STATUS_DEAL = 3;
    public static final int STATUS_FAILED = 7;
    public static final int STATUS_ON_AUCTION = 2;
    public static final int STATUS_PREVIEW = 1;

    @SerializedName("auction_id")
    private final String auctionId;

    @SerializedName("auction_type")
    private final int auctionType;

    @SerializedName("auction_user_order_num")
    private final long auctionUserOrderNum;

    @SerializedName("auction_users")
    private final List<AuctionUserOrderInfoStruct> auctionUsers;

    @SerializedName("campaign_id")
    private final String campaignId;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("header_price")
    private final String headerPrice;

    @SerializedName("max_price")
    private final long maxPrice;

    @SerializedName("price")
    private final Price price;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName("starting_price")
    private final long startingPrice;

    @SerializedName("status")
    private final int status;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuctionInfoStruct copy$default(AuctionInfoStruct r110, String r111, String r112, long r113, String r210, int r211, List r212, long r213, long r214, int r215, long r216, long r310, Price r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.auctionId;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.campaignId;
    L11:
        if ((r312 & 4) == 0) goto L13;
        long r102 = r110.maxPrice;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r103 = r110.headerPrice;
    L19:
        if ((r312 & 16) == 0) goto L21;
        int r104 = r110.status;
    L23:
        if ((r312 & 32) == 0) goto L25;
        List r105 = r110.auctionUsers;
    L27:
        if ((r312 & 64) == 0) goto L29;
        long r106 = r110.auctionUserOrderNum;
    L31:
        if ((r312 & 128) == 0) goto L33;
        long r114 = r110.startingPrice;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r115 = r110.auctionType;
    L39:
        if ((r312 & 512) == 0) goto L41;
        long r116 = r110.endTime;
    L42:
        long r217 = r116;
        if ((r312 & 1024) == 0) goto L45;
        long r117 = r110.serverTime;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Price r107 = r110.price;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r114, r115, r217, r117, r107);
    L49:
        r107 = r311;
        goto L51
    L45:
        r117 = r310;
        goto L47
    L41:
        r116 = r216;
        goto L42
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
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

    public final String component1() {
        return this.auctionId;
    }

    public final long component10() {
        return this.endTime;
    }

    public final long component11() {
        return this.serverTime;
    }

    public final Price component12() {
        return this.price;
    }

    public final String component2() {
        return this.campaignId;
    }

    public final long component3() {
        return this.maxPrice;
    }

    public final String component4() {
        return this.headerPrice;
    }

    public final int component5() {
        return this.status;
    }

    public final List<AuctionUserOrderInfoStruct> component6() {
        return this.auctionUsers;
    }

    public final long component7() {
        return this.auctionUserOrderNum;
    }

    public final long component8() {
        return this.startingPrice;
    }

    public final int component9() {
        return this.auctionType;
    }

    public final AuctionInfoStruct copy(String r210, String r211, long r212, String r213, int r214, List<AuctionUserOrderInfoStruct> r215, long r216, long r310, int r311, long r312, long r313, Price r314) {
        Intrinsics.checkNotNullParameter(r210, "auctionId");
        Intrinsics.checkNotNullParameter(r211, "campaignId");
        Intrinsics.checkNotNullParameter(r213, "headerPrice");
        return new AuctionInfoStruct(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AuctionInfoStruct) == false) goto L30;
        AuctionInfoStruct r101 = (AuctionInfoStruct) r100;
        if (Intrinsics.areEqual(this.auctionId, r101.auctionId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.campaignId, r101.campaignId) == true) goto L10;
        return false;
    L10:
        if (this.maxPrice == r101.maxPrice) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.headerPrice, r101.headerPrice) == true) goto L14;
        return false;
    L14:
        if (this.status == r101.status) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.auctionUsers, r101.auctionUsers) == true) goto L18;
        return false;
    L18:
        if (this.auctionUserOrderNum == r101.auctionUserOrderNum) goto L20;
        return false;
    L20:
        if (this.startingPrice == r101.startingPrice) goto L22;
        return false;
    L22:
        if (this.auctionType == r101.auctionType) goto L24;
        return false;
    L24:
        if (this.endTime == r101.endTime) goto L26;
        return false;
    L26:
        if (this.serverTime == r101.serverTime) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        String r100 = this.auctionId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.campaignId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.maxPrice;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.headerPrice;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (((r108 + r110) * 31) + this.status) * 31;
        List<AuctionUserOrderInfoStruct> r112 = this.auctionUsers;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        long r115 = this.auctionUserOrderNum;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.startingPrice;
        int r118 = (((r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31) + this.auctionType) * 31;
        long r119 = this.endTime;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.serverTime;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        Price r123 = this.price;
        if (r123 == null) goto L22;
        r101 = r123.hashCode();
    L22:
        return r122 + r101;
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AuctionInfoStruct(auctionId=" + this.auctionId + ", campaignId=" + this.campaignId + ", maxPrice=" + this.maxPrice + ", headerPrice=" + this.headerPrice + ", status=" + this.status + ", auctionUsers=" + this.auctionUsers + ", auctionUserOrderNum=" + this.auctionUserOrderNum + ", startingPrice=" + this.startingPrice + ", auctionType=" + this.auctionType + ", endTime=" + this.endTime + ", serverTime=" + this.serverTime + ", price=" + this.price + ")";
    }

    public final String getAuctionId() {
        return this.auctionId;
    }

    public final int getAuctionType() {
        return this.auctionType;
    }

    public final long getAuctionUserOrderNum() {
        return this.auctionUserOrderNum;
    }

    public final List<AuctionUserOrderInfoStruct> getAuctionUsers() {
        return this.auctionUsers;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getHeaderPrice() {
        return this.headerPrice;
    }

    public final long getMaxPrice() {
        return this.maxPrice;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final long getStartingPrice() {
        return this.startingPrice;
    }

    public final int getStatus() {
        return this.status;
    }

    public AuctionInfoStruct(String r100, String r101, long r102, String r110, int r111, List<AuctionUserOrderInfoStruct> r112, long r113, long r114, int r115, long r116, long r210, Price r211) {
        Intrinsics.checkNotNullParameter(r100, "auctionId");
        Intrinsics.checkNotNullParameter(r101, "campaignId");
        Intrinsics.checkNotNullParameter(r110, "headerPrice");
        this.auctionId = r100;
        this.campaignId = r101;
        this.maxPrice = r102;
        this.headerPrice = r110;
        this.status = r111;
        this.auctionUsers = r112;
        this.auctionUserOrderNum = r113;
        this.startingPrice = r114;
        this.auctionType = r115;
        this.endTime = r116;
        this.serverTime = r210;
        this.price = r211;
    }

    public /* synthetic */ AuctionInfoStruct(String r210, String r211, long r212, String r213, int r214, List r215, long r216, long r310, int r311, long r312, long r313, Price r314, int r315, DefaultConstructorMarker r410) {
        if ((r315 & 32) == 0) goto L5;
        List r110 = null;
    L7:
        if ((r315 & 256) == 0) goto L9;
        int r111 = 0;
    L11:
        if ((r315 & 512) == 0) goto L13;
        long r112 = 0;
    L15:
        if ((r315 & 1024) == 0) goto L17;
        long r113 = 0;
    L19:
        if ((r315 & 2048) == 0) goto L21;
        Price r217 = null;
    L22:
        this(r210, r211, r212, r213, r214, r110, r216, r310, r111, r112, r113, r217);
        return;
    L21:
        r217 = r314;
        goto L22
    L17:
        r113 = r313;
        goto L19
    L13:
        r112 = r312;
        goto L15
    L9:
        r111 = r311;
        goto L11
    L5:
        r110 = r215;
        goto L7
    }
}
