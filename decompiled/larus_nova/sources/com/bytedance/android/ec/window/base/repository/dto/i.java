package com.bytedance.android.ec.window.base.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/i;", "", "", "pickId", "I", "getPickId", "()I", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "isCurrent", "Z", "()Z", "setCurrent", "(Z)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "normalIconUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getNormalIconUrl", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "selectedIconUrl", "getSelectedIconUrl", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("is_current")
    private boolean isCurrent;

    @SerializedName("name")
    private final String name;

    @SerializedName("normal_icon_url")
    private final ECUrlModel normalIconUrl;

    @SerializedName("pick_id")
    private final int pickId;

    @SerializedName("selected_icon_url")
    private final ECUrlModel selectedIconUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L16;
        i r101 = (i) r100;
        if (this.pickId == r101.pickId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (this.isCurrent == r101.isCurrent) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.normalIconUrl, r101.normalIconUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.selectedIconUrl, r101.selectedIconUrl) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        int r100 = this.pickId * 31;
        String r101 = this.name;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.isCurrent;
        ?? r106 = r105;
        if (r105 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r104 + r106) * 31;
        ECUrlModel r108 = this.normalIconUrl;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        ECUrlModel r111 = this.selectedIconUrl;
        if (r111 == null) goto L17;
        r102 = r111.hashCode();
    L17:
        return r110 + r102;
    L12:
        r109 = 0;
        goto L13
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "PickType(pickId=" + this.pickId + ", name=" + this.name + ", isCurrent=" + this.isCurrent + ", normalIconUrl=" + this.normalIconUrl + ", selectedIconUrl=" + this.selectedIconUrl + ")";
    }

    public i() {
        this.pickId = 0;
        this.name = null;
        this.isCurrent = false;
        this.normalIconUrl = null;
        this.selectedIconUrl = null;
    }
}
