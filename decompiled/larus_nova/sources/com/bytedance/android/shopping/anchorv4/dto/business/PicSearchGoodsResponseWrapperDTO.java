package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.shopping.anchorv4.data.FindSameSource;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010%J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0013\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\u0005J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J<\u0010\u0011\u001a\u00020\u00002\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003R$\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchGoodsResponseWrapperDTO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/d;", "", "getStatusCodeInt", "()Ljava/lang/Integer;", "", "Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchGoodsData;", "getBusinessDataStruct", "Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;", "getSourceType", "component1", "component2", "component3", "businessData", "statusCode", "source", "copy", "(Ljava/util/List;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;)Lcom/bytedance/android/shopping/anchorv4/dto/business/PicSearchGoodsResponseWrapperDTO;", "", "toString", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getBusinessData", "()Ljava/util/List;", "Ljava/lang/Integer;", "getStatusCode", "Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;", "getSource", "()Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;", "setSource", "(Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;)V", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PicSearchGoodsResponseWrapperDTO implements Serializable, d {

    @SerializedName("business_data")
    private final List<PicSearchGoodsData> businessData;

    @SerializedName("source")
    private FindSameSource source;

    @SerializedName("status_code")
    private final Integer statusCode;

    public PicSearchGoodsResponseWrapperDTO() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PicSearchGoodsResponseWrapperDTO copy$default(PicSearchGoodsResponseWrapperDTO r100, List r101, Integer r102, FindSameSource r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.businessData;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.statusCode;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.source;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<PicSearchGoodsData> component1() {
        return this.businessData;
    }

    public final Integer component2() {
        return this.statusCode;
    }

    public final FindSameSource component3() {
        return this.source;
    }

    public final PicSearchGoodsResponseWrapperDTO copy(List<PicSearchGoodsData> r100, Integer r101, FindSameSource r102) {
        return new PicSearchGoodsResponseWrapperDTO(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PicSearchGoodsResponseWrapperDTO) == false) goto L12;
        PicSearchGoodsResponseWrapperDTO r101 = (PicSearchGoodsResponseWrapperDTO) r100;
        if (Intrinsics.areEqual(this.businessData, r101.businessData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.d
    public List<SameGoodsItem> getFeedStruct() {
        return null;
    }

    public e getPageStruct() {
        return null;
    }

    public int hashCode() {
        List<PicSearchGoodsData> r100 = this.businessData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.statusCode;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        FindSameSource r107 = this.source;
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

    public String toString() {
        return "PicSearchGoodsResponseWrapperDTO(businessData=" + this.businessData + ", statusCode=" + this.statusCode + ", source=" + this.source + ")";
    }

    public final List<PicSearchGoodsData> getBusinessData() {
        return this.businessData;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.d
    public List<PicSearchGoodsData> getBusinessDataStruct() {
        return this.businessData;
    }

    public final FindSameSource getSource() {
        return this.source;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.d
    public FindSameSource getSourceType() {
        return this.source;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.d
    public Integer getStatusCodeInt() {
        return this.statusCode;
    }

    public final void setSource(FindSameSource r100) {
        this.source = r100;
    }

    public PicSearchGoodsResponseWrapperDTO(List<PicSearchGoodsData> r100, Integer r101, FindSameSource r102) {
        this.businessData = r100;
        this.statusCode = r101;
        this.source = r102;
    }

    public /* synthetic */ PicSearchGoodsResponseWrapperDTO(List r100, Integer r101, FindSameSource r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
