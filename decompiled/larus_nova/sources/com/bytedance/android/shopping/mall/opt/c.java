package com.bytedance.android.shopping.mall.opt;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/mall/opt/c;", "", "", "preExposureTime", "Ljava/lang/Long;", "getPreExposureTime", "()Ljava/lang/Long;", "", "", "unExposureItemType", "Ljava/util/List;", "getUnExposureItemType", "()Ljava/util/List;", "unExposureId", "getUnExposureId", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("page_name")
    private final String pageName;

    @SerializedName("pre_resume_time")
    private final Long preExposureTime;

    @SerializedName("unexposed_id")
    private final List<String> unExposureId;

    @SerializedName("unexposed_item_type")
    private final List<String> unExposureItemType;

    public c() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.preExposureTime, r101.preExposureTime) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.unExposureItemType, r101.unExposureItemType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.unExposureId, r101.unExposureId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.preExposureTime;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.unExposureItemType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.unExposureId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.pageName;
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
        return "GulExposureForPitaya(preExposureTime=" + this.preExposureTime + ", unExposureItemType=" + this.unExposureItemType + ", unExposureId=" + this.unExposureId + ", pageName=" + this.pageName + ")";
    }

    public c(Long r100, List<String> r101, List<String> r102, String r103) {
        this.preExposureTime = r100;
        this.unExposureItemType = r101;
        this.unExposureId = r102;
        this.pageName = r103;
    }
}
