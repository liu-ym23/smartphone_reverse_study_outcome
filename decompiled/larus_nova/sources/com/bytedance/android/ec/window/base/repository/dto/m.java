package com.bytedance.android.ec.window.base.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/m;", "", "", "resultType", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "", "level", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/window/base/repository/dto/n;", "selectInfo", "Lcom/bytedance/android/ec/window/base/repository/dto/n;", "d", "()Lcom/bytedance/android/ec/window/base/repository/dto/n;", "Lcom/bytedance/android/ec/window/base/repository/dto/c;", "dynamicPatch", "Lcom/bytedance/android/ec/window/base/repository/dto/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/window/base/repository/dto/c;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("dynamic_patch")
    private final c dynamicPatch;

    @SerializedName("level")
    private final String level;

    @SerializedName("result_type")
    private final Long resultType;

    @SerializedName("select_info")
    private final n selectInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L14;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.resultType, r101.resultType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.level, r101.level) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.selectInfo, r101.selectInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dynamicPatch, r101.dynamicPatch) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.resultType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.level;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        n r107 = this.selectInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.dynamicPatch;
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
        return "SearchMixItem(resultType=" + this.resultType + ", level=" + this.level + ", selectInfo=" + this.selectInfo + ", dynamicPatch=" + this.dynamicPatch + ")";
    }

    public final c a() {
        return this.dynamicPatch;
    }

    public final String b() {
        return this.level;
    }

    public final Long c() {
        return this.resultType;
    }

    public final n d() {
        return this.selectInfo;
    }
}
