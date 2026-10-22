package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/m;", "", "", "Lcom/bytedance/android/window/shop/repository/dto/r;", "labelInfos", "Ljava/util/List;", "b", "()Ljava/util/List;", "hybridLabelInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "schema", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("hybrid_labels")
    private final List<r> hybridLabelInfo;

    @SerializedName("infos")
    private final List<r> labelInfos;

    @SerializedName("scheme")
    private final String schema;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L12;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.labelInfos, r101.labelInfos) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hybridLabelInfo, r101.hybridLabelInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<r> r100 = this.labelInfos;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<r> r104 = this.hybridLabelInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.schema;
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
        return "WindowAuthorManagerInfoDTO(labelInfos=" + this.labelInfos + ", hybridLabelInfo=" + this.hybridLabelInfo + ", schema=" + this.schema + ")";
    }

    public m() {
        this.labelInfos = null;
        this.hybridLabelInfo = null;
        this.schema = null;
    }

    public final List<r> a() {
        return this.hybridLabelInfo;
    }

    public final List<r> b() {
        return this.labelInfos;
    }

    public final String c() {
        return this.schema;
    }
}
