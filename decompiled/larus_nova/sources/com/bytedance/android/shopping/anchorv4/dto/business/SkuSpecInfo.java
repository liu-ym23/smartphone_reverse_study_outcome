package com.bytedance.android.shopping.anchorv4.dto.business;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/SkuSpecInfo;", "Ljava/io/Serializable;", "specDefault", "", "specIds", "", "specNames", "selectSpecId", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getSelectSpecId", "()Ljava/lang/String;", "getSpecDefault", "getSpecIds", "()Ljava/util/List;", "getSpecNames", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuSpecInfo implements Serializable {

    @SerializedName("select_spec_id")
    private final String selectSpecId;

    @SerializedName("spec_default_name")
    private final String specDefault;

    @SerializedName("spec_ids")
    private final List<String> specIds;

    @SerializedName("spec_names")
    private final List<String> specNames;

    public SkuSpecInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuSpecInfo copy$default(SkuSpecInfo r100, String r101, List r102, List r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.specDefault;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.specIds;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.specNames;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.selectSpecId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.specDefault;
    }

    public final List<String> component2() {
        return this.specIds;
    }

    public final List<String> component3() {
        return this.specNames;
    }

    public final String component4() {
        return this.selectSpecId;
    }

    public final SkuSpecInfo copy(String r100, List<String> r101, List<String> r102, String r103) {
        return new SkuSpecInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuSpecInfo) == false) goto L14;
        SkuSpecInfo r101 = (SkuSpecInfo) r100;
        if (Intrinsics.areEqual(this.specDefault, r101.specDefault) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.specIds, r101.specIds) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.specNames, r101.specNames) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectSpecId, r101.selectSpecId) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.specDefault;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.specIds;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.specNames;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.selectSpecId;
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

    public String toString() {
        return "SkuSpecInfo(specDefault=" + this.specDefault + ", specIds=" + this.specIds + ", specNames=" + this.specNames + ", selectSpecId=" + this.selectSpecId + ")";
    }

    public final String getSelectSpecId() {
        return this.selectSpecId;
    }

    public final String getSpecDefault() {
        return this.specDefault;
    }

    public final List<String> getSpecIds() {
        return this.specIds;
    }

    public final List<String> getSpecNames() {
        return this.specNames;
    }

    public SkuSpecInfo(String r100, List<String> r101, List<String> r102, String r103) {
        this.specDefault = r100;
        this.specIds = r101;
        this.specNames = r102;
        this.selectSpecId = r103;
    }

    public /* synthetic */ SkuSpecInfo(String r100, List r101, List r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
