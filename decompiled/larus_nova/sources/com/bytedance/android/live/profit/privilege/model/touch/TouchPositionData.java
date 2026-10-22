package com.bytedance.android.live.profit.privilege.model.touch;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/TouchPositionData;", "", "touchPositionsStr", "", "needShowTopDetail", "", "privilegeEntranceInfo", "Lcom/bytedance/android/live/profit/privilege/model/touch/PrivilegeEntranceInfo;", "(Ljava/lang/String;ZLcom/bytedance/android/live/profit/privilege/model/touch/PrivilegeEntranceInfo;)V", "getNeedShowTopDetail", "()Z", "getPrivilegeEntranceInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/PrivilegeEntranceInfo;", "getTouchPositionsStr", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TouchPositionData {
    private final boolean needShowTopDetail;
    private final PrivilegeEntranceInfo privilegeEntranceInfo;
    private final String touchPositionsStr;

    public TouchPositionData() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ TouchPositionData copy$default(TouchPositionData r100, String r101, boolean r102, PrivilegeEntranceInfo r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.touchPositionsStr;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.needShowTopDetail;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.privilegeEntranceInfo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.touchPositionsStr;
    }

    public final boolean component2() {
        return this.needShowTopDetail;
    }

    public final PrivilegeEntranceInfo component3() {
        return this.privilegeEntranceInfo;
    }

    public final TouchPositionData copy(String r100, boolean r101, PrivilegeEntranceInfo r102) {
        return new TouchPositionData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TouchPositionData) == false) goto L12;
        TouchPositionData r101 = (TouchPositionData) r100;
        if (Intrinsics.areEqual(this.touchPositionsStr, r101.touchPositionsStr) == true) goto L8;
        return false;
    L8:
        if (this.needShowTopDetail == r101.needShowTopDetail) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.privilegeEntranceInfo, r101.privilegeEntranceInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        String r100 = this.touchPositionsStr;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.needShowTopDetail;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        PrivilegeEntranceInfo r107 = this.privilegeEntranceInfo;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TouchPositionData(touchPositionsStr=" + this.touchPositionsStr + ", needShowTopDetail=" + this.needShowTopDetail + ", privilegeEntranceInfo=" + this.privilegeEntranceInfo + ")";
    }

    public final boolean getNeedShowTopDetail() {
        return this.needShowTopDetail;
    }

    public final PrivilegeEntranceInfo getPrivilegeEntranceInfo() {
        return this.privilegeEntranceInfo;
    }

    public final String getTouchPositionsStr() {
        return this.touchPositionsStr;
    }

    public TouchPositionData(String r100, boolean r101, PrivilegeEntranceInfo r102) {
        this.touchPositionsStr = r100;
        this.needShowTopDetail = r101;
        this.privilegeEntranceInfo = r102;
    }

    public /* synthetic */ TouchPositionData(String r100, boolean r101, PrivilegeEntranceInfo r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
