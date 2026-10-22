package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.shopping.anchorv4.data.FindSameSource;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b+\u0010,J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0005J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0003JH\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0018\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u0005R$\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/IFindSameGoodsResponseWrapperDTO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/d;", "", "getStatusCodeInt", "()Ljava/lang/Integer;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/e;", "getPageStruct", "", "Lcom/bytedance/android/shopping/anchorv4/dto/business/SameGoodsItem;", "getFeedStruct", "Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;", "getSourceType", "component1", "component2", "component3", "component4", "page", "feed", "statusCode", "source", "copy", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/e;Ljava/util/List;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;)Lcom/bytedance/android/shopping/anchorv4/dto/business/IFindSameGoodsResponseWrapperDTO;", "", "toString", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/shopping/anchorv4/dto/business/e;", "getPage", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/e;", "Ljava/util/List;", "getFeed", "()Ljava/util/List;", "Ljava/lang/Integer;", "getStatusCode", "Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;", "getSource", "()Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;", "setSource", "(Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;)V", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/e;Ljava/util/List;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IFindSameGoodsResponseWrapperDTO implements Serializable, d {

    @SerializedName("feed")
    private final List<SameGoodsItem> feed;

    @SerializedName("page")
    private final e page;

    @SerializedName("source")
    private FindSameSource source;

    @SerializedName("status_code")
    private final Integer statusCode;

    public IFindSameGoodsResponseWrapperDTO() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IFindSameGoodsResponseWrapperDTO copy$default(IFindSameGoodsResponseWrapperDTO r100, e r101, List r102, Integer r103, FindSameSource r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.page;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.feed;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.statusCode;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.source;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final e component1() {
        return this.page;
    }

    public final List<SameGoodsItem> component2() {
        return this.feed;
    }

    public final Integer component3() {
        return this.statusCode;
    }

    public final FindSameSource component4() {
        return this.source;
    }

    public final IFindSameGoodsResponseWrapperDTO copy(e r100, List<SameGoodsItem> r101, Integer r102, FindSameSource r103) {
        return new IFindSameGoodsResponseWrapperDTO(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IFindSameGoodsResponseWrapperDTO) == false) goto L14;
        IFindSameGoodsResponseWrapperDTO r101 = (IFindSameGoodsResponseWrapperDTO) r100;
        if (Intrinsics.areEqual(this.page, r101.page) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.feed, r101.feed) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.d
    public List<PicSearchGoodsData> getBusinessDataStruct() {
        return null;
    }

    public int hashCode() {
        e r100 = this.page;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<SameGoodsItem> r104 = this.feed;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.statusCode;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        FindSameSource r110 = this.source;
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
        return "IFindSameGoodsResponseWrapperDTO(page=" + this.page + ", feed=" + this.feed + ", statusCode=" + this.statusCode + ", source=" + this.source + ")";
    }

    public final List<SameGoodsItem> getFeed() {
        return this.feed;
    }

    @Override // com.bytedance.android.shopping.anchorv4.dto.business.d
    public List<SameGoodsItem> getFeedStruct() {
        return this.feed;
    }

    public final e getPage() {
        return this.page;
    }

    public e getPageStruct() {
        return this.page;
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

    public IFindSameGoodsResponseWrapperDTO(e r100, List<SameGoodsItem> r101, Integer r102, FindSameSource r103) {
        this.page = r100;
        this.feed = r101;
        this.statusCode = r102;
        this.source = r103;
    }

    public /* synthetic */ IFindSameGoodsResponseWrapperDTO(e r100, List r101, Integer r102, FindSameSource r103, int r104, DefaultConstructorMarker r105) {
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
