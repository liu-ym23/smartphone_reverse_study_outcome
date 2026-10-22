package com.bytedance.android.ec.window.base.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/n;", "", "", "", "Lcom/bytedance/android/ec/window/base/repository/dto/o;", "businessInfo", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "", "Lcom/bytedance/android/ec/window/base/repository/dto/l;", "renderInfo", "Ljava/util/List;", "b", "()Ljava/util/List;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("business_info")
    private final Map<String, o> businessInfo;

    @SerializedName("render_info")
    private final List<l> renderInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L10;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.businessInfo, r101.businessInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.renderInfo, r101.renderInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Map<String, o> r100 = this.businessInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<l> r104 = this.renderInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SelectInfo(businessInfo=" + this.businessInfo + ", renderInfo=" + this.renderInfo + ")";
    }

    public final Map<String, o> a() {
        return this.businessInfo;
    }

    public final List<l> b() {
        return this.renderInfo;
    }
}
