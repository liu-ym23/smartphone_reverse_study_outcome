package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/i;", "", "", "tabType", "Ljava/lang/Integer;", "getTabType", "()Ljava/lang/Integer;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "pullShowMsg", "getPullShowMsg", "releaseShowMsg", "getReleaseShowMsg", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("name")
    private final String name;

    @SerializedName("pullShowMsg")
    private final String pullShowMsg;

    @SerializedName("releaseShowMsg")
    private final String releaseShowMsg;

    @SerializedName("tab_type")
    private final Integer tabType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.tabType, r101.tabType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pullShowMsg, r101.pullShowMsg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.releaseShowMsg, r101.releaseShowMsg) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.tabType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.pullShowMsg;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.releaseShowMsg;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "TabDTO(tabType=" + this.tabType + ", name=" + this.name + ", pullShowMsg=" + this.pullShowMsg + ", releaseShowMsg=" + this.releaseShowMsg + ")";
    }

    public i() {
        this.tabType = null;
        this.name = null;
        this.pullShowMsg = null;
        this.releaseShowMsg = null;
    }
}
