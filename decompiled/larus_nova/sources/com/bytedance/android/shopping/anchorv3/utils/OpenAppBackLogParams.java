package com.bytedance.android.shopping.anchorv3.utils;

import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008b\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00060"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/utils/OpenAppBackLogParams;", "Ljava/io/Serializable;", DyPayConstant.KEY_START_TIME, "", "creativeId", "", "logExtra", "adExtraData", "groupIdExtra", "sourcePage", "authorId", "groupId", "commodityId", "productId", "commodityType", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdExtraData", "()Ljava/lang/String;", "getAuthorId", "getCommodityId", "getCommodityType", "getCreativeId", "getGroupId", "getGroupIdExtra", "getLogExtra", "getProductId", "getSourcePage", "getStartTime", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAppBackLogParams implements Serializable {
    private final String adExtraData;
    private final String authorId;
    private final String commodityId;
    private final String commodityType;
    private final String creativeId;
    private final String groupId;
    private final String groupIdExtra;
    private final String logExtra;
    private final String productId;
    private final String sourcePage;
    private final long startTime;

    public static /* synthetic */ OpenAppBackLogParams copy$default(OpenAppBackLogParams r110, long r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214, String r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        long r100 = r110.startTime;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.creativeId;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.logExtra;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.adExtraData;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.groupIdExtra;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.sourcePage;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.authorId;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r116 = r110.groupId;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.commodityId;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.productId;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        String r107 = r110.commodityType;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r116, r117, r118, r107);
    L45:
        r107 = r215;
        goto L47
    L41:
        r118 = r214;
        goto L43
    L37:
        r117 = r213;
        goto L39
    L33:
        r116 = r212;
        goto L35
    L29:
        r106 = r211;
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
        return this.startTime;
    }

    public final String component10() {
        return this.productId;
    }

    public final String component11() {
        return this.commodityType;
    }

    public final String component2() {
        return this.creativeId;
    }

    public final String component3() {
        return this.logExtra;
    }

    public final String component4() {
        return this.adExtraData;
    }

    public final String component5() {
        return this.groupIdExtra;
    }

    public final String component6() {
        return this.sourcePage;
    }

    public final String component7() {
        return this.authorId;
    }

    public final String component8() {
        return this.groupId;
    }

    public final String component9() {
        return this.commodityId;
    }

    public final OpenAppBackLogParams copy(long r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216) {
        return new OpenAppBackLogParams(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OpenAppBackLogParams) == false) goto L28;
        OpenAppBackLogParams r101 = (OpenAppBackLogParams) r100;
        if (this.startTime == r101.startTime) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.creativeId, r101.creativeId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.adExtraData, r101.adExtraData) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.groupIdExtra, r101.groupIdExtra) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.commodityId, r101.commodityId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.commodityType, r101.commodityType) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        long r100 = this.startTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.creativeId;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.logExtra;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.adExtraData;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.groupIdExtra;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.sourcePage;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.authorId;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.groupId;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        String r124 = this.commodityId;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.productId;
        if (r127 == null) goto L37;
        int r128 = r127.hashCode();
    L38:
        int r129 = (r126 + r128) * 31;
        String r130 = this.commodityType;
        if (r130 == null) goto L42;
        r103 = r130.hashCode();
    L42:
        return r129 + r103;
    L37:
        r128 = 0;
        goto L38
    L33:
        r125 = 0;
        goto L34
    L29:
        r122 = 0;
        goto L30
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "OpenAppBackLogParams(startTime=" + this.startTime + ", creativeId=" + this.creativeId + ", logExtra=" + this.logExtra + ", adExtraData=" + this.adExtraData + ", groupIdExtra=" + this.groupIdExtra + ", sourcePage=" + this.sourcePage + ", authorId=" + this.authorId + ", groupId=" + this.groupId + ", commodityId=" + this.commodityId + ", productId=" + this.productId + ", commodityType=" + this.commodityType + ")";
    }

    public final String getAdExtraData() {
        return this.adExtraData;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getCommodityId() {
        return this.commodityId;
    }

    public final String getCommodityType() {
        return this.commodityType;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getGroupIdExtra() {
        return this.groupIdExtra;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public OpenAppBackLogParams(long r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112) {
        this.startTime = r100;
        this.creativeId = r101;
        this.logExtra = r102;
        this.adExtraData = r103;
        this.groupIdExtra = r104;
        this.sourcePage = r105;
        this.authorId = r106;
        this.groupId = r107;
        this.commodityId = r110;
        this.productId = r111;
        this.commodityType = r112;
    }
}
