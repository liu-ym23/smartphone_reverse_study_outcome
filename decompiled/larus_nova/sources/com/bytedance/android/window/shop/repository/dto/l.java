package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/l;", "", "", "authorName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "avatarMedium", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "windowSchema", "d", "", "followStatus", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("name")
    private final String authorName;

    @SerializedName("avatar")
    private final ECUrlModel avatarMedium;

    @SerializedName("follow_status")
    private final Integer followStatus;

    @SerializedName("schema")
    private final String windowSchema;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L14;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.authorName, r101.authorName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatarMedium, r101.avatarMedium) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.windowSchema, r101.windowSchema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.authorName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.avatarMedium;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.windowSchema;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.followStatus;
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
        return "WindowAuthorInfoDTO(authorName=" + this.authorName + ", avatarMedium=" + this.avatarMedium + ", windowSchema=" + this.windowSchema + ", followStatus=" + this.followStatus + ")";
    }

    public l() {
        this.authorName = null;
        this.avatarMedium = null;
        this.windowSchema = null;
        this.followStatus = null;
    }

    public final String a() {
        return this.authorName;
    }

    public final ECUrlModel b() {
        return this.avatarMedium;
    }

    public final Integer c() {
        return this.followStatus;
    }

    public final String d() {
        return this.windowSchema;
    }
}
