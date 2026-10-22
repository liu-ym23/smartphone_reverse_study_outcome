package com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/b;", "", "", "totalReservedNum", "Ljava/lang/Long;", "getTotalReservedNum", "()Ljava/lang/Long;", "", "showReservedTotal", "Ljava/lang/Boolean;", "getShowReservedTotal", "()Ljava/lang/Boolean;", "supportPlatform", "getSupportPlatform", "", "Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/a$a;", "reserveNoticeList", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/g;", "officialAccountInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/g;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/g;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("official_account_info")
    private final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.g officialAccountInfo;

    @SerializedName("notice_list")
    private final List<a.C0891a> reserveNoticeList;

    @SerializedName("show_reserved_total")
    private final Boolean showReservedTotal;

    @SerializedName("support_platforms")
    private final Long supportPlatform;

    @SerializedName("reserved_total_by_game")
    private final Long totalReservedNum;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.totalReservedNum, r101.totalReservedNum) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showReservedTotal, r101.showReservedTotal) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.supportPlatform, r101.supportPlatform) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reserveNoticeList, r101.reserveNoticeList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.officialAccountInfo, r101.officialAccountInfo) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.totalReservedNum;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.showReservedTotal;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.supportPlatform;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<a.C0891a> r110 = this.reserveNoticeList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.g r113 = this.officialAccountInfo;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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

    public final String toString() {
        return "GameOrderBasicInfoDataV3(totalReservedNum=" + this.totalReservedNum + ", showReservedTotal=" + this.showReservedTotal + ", supportPlatform=" + this.supportPlatform + ", reserveNoticeList=" + this.reserveNoticeList + ", officialAccountInfo=" + this.officialAccountInfo + ")";
    }

    public b() {
        Boolean r100 = Boolean.FALSE;
        this.totalReservedNum = null;
        this.showReservedTotal = r100;
        this.supportPlatform = 0L;
        this.reserveNoticeList = null;
        this.officialAccountInfo = null;
    }

    public final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.g a() {
        return this.officialAccountInfo;
    }

    public final List<a.C0891a> b() {
        return this.reserveNoticeList;
    }
}
