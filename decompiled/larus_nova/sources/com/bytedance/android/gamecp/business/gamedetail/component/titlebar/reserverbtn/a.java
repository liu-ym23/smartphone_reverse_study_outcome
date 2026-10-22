package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.reserverbtn;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/reserverbtn/a;", "", "", "supportReservePlatform", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "reserveStatus", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "giftNum", "getGiftNum", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("gift_num")
    private final Long giftNum;

    @SerializedName("reserved_status")
    private final Long reserveStatus;

    @SerializedName("support_reserve_platforms")
    private final Long supportReservePlatform;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.supportReservePlatform, r101.supportReservePlatform) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.reserveStatus, r101.reserveStatus) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.giftNum, r101.giftNum) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.supportReservePlatform;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.reserveStatus;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.giftNum;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TitleReserveButtonData(supportReservePlatform=" + this.supportReservePlatform + ", reserveStatus=" + this.reserveStatus + ", giftNum=" + this.giftNum + ")";
    }

    public a() {
        this.supportReservePlatform = 0L;
        this.reserveStatus = null;
        this.giftNum = null;
    }

    public final Long a() {
        return this.reserveStatus;
    }

    public final Long b() {
        return this.supportReservePlatform;
    }
}
