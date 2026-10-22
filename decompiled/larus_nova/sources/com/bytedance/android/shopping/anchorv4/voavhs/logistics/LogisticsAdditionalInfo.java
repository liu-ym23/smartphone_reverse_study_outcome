package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\fHÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/LogisticsAdditionalInfo;", "Ljava/io/Serializable;", "qualityEmphasize", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/QualityEmphasizeElement;", "brand", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/BrandIllustrationElement;", "delivery", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/DeliveryDetailElement;", GXTemplateKey.FLEXBOX_PADDING, "Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "space", "", "(Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/BrandIllustrationElement;Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/DeliveryDetailElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;I)V", "getBrand", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/BrandIllustrationElement;", "getDelivery", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/DeliveryDetailElement;", "getPadding", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "getQualityEmphasize", "()Ljava/util/List;", "getSpace", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LogisticsAdditionalInfo implements Serializable {

    @SerializedName("brand")
    private final BrandIllustrationElement brand;

    @SerializedName("delivery")
    private final DeliveryDetailElement delivery;

    @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
    private final Padding padding;

    @SerializedName("quality_emphasize")
    private final List<QualityEmphasizeElement> qualityEmphasize;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    @SerializedName("space")
    private final int f169977space;

    public LogisticsAdditionalInfo() {
        this(null, null, null, null, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LogisticsAdditionalInfo copy$default(LogisticsAdditionalInfo r100, List r101, BrandIllustrationElement r102, DeliveryDetailElement r103, Padding r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.qualityEmphasize;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.brand;
    L8:
        BrandIllustrationElement r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.delivery;
    L11:
        DeliveryDetailElement r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.padding;
    L14:
        Padding r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.f169977space;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<QualityEmphasizeElement> component1() {
        return this.qualityEmphasize;
    }

    public final BrandIllustrationElement component2() {
        return this.brand;
    }

    public final DeliveryDetailElement component3() {
        return this.delivery;
    }

    public final Padding component4() {
        return this.padding;
    }

    public final int component5() {
        return this.f169977space;
    }

    public final LogisticsAdditionalInfo copy(List<QualityEmphasizeElement> r100, BrandIllustrationElement r101, DeliveryDetailElement r110, Padding r111, int r112) {
        return new LogisticsAdditionalInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LogisticsAdditionalInfo) == false) goto L16;
        LogisticsAdditionalInfo r101 = (LogisticsAdditionalInfo) r100;
        if (Intrinsics.areEqual(this.qualityEmphasize, r101.qualityEmphasize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.brand, r101.brand) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.delivery, r101.delivery) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L14;
        return false;
    L14:
        if (this.f169977space == r101.f169977space) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<QualityEmphasizeElement> r100 = this.qualityEmphasize;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        BrandIllustrationElement r104 = this.brand;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        DeliveryDetailElement r107 = this.delivery;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Padding r110 = this.padding;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return ((r109 + r101) * 31) + this.f169977space;
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
        return "LogisticsAdditionalInfo(qualityEmphasize=" + this.qualityEmphasize + ", brand=" + this.brand + ", delivery=" + this.delivery + ", padding=" + this.padding + ", space=" + this.f169977space + ")";
    }

    public final BrandIllustrationElement getBrand() {
        return this.brand;
    }

    public final DeliveryDetailElement getDelivery() {
        return this.delivery;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final List<QualityEmphasizeElement> getQualityEmphasize() {
        return this.qualityEmphasize;
    }

    public final int getSpace() {
        return this.f169977space;
    }

    public LogisticsAdditionalInfo(List<QualityEmphasizeElement> r100, BrandIllustrationElement r101, DeliveryDetailElement r102, Padding r103, int r104) {
        this.qualityEmphasize = r100;
        this.brand = r101;
        this.delivery = r102;
        this.padding = r103;
        this.f169977space = r104;
    }

    public /* synthetic */ LogisticsAdditionalInfo(List r100, BrandIllustrationElement r101, DeliveryDetailElement r102, Padding r103, int r104, int r105, DefaultConstructorMarker r110) {
        Padding r106 = null;
        if ((r105 & 1) == 0) goto L5;
        List r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        BrandIllustrationElement r107 = null;
    L11:
        if ((r105 & 4) == 0) goto L13;
        DeliveryDetailElement r108 = null;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        int r109 = 0;
    L22:
        this(r111, r107, r108, r106, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
