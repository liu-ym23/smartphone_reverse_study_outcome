package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\fHÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/AnchorV4LogisticsAndCouponDisplay;", "Ljava/io/Serializable;", "serviceDetail", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/ServiceComponent;", "guaranteeHeader", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "background", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "space", "", GXTemplateKey.FLEXBOX_PADDING, "Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "(Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;ILcom/bytedance/android/shopping/anchorv4/dto/base/Padding;)V", "getBackground", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getGuaranteeHeader", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "getPadding", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "getServiceDetail", "()Ljava/util/List;", "getSpace", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4LogisticsAndCouponDisplay implements Serializable {

    @SerializedName("service_background")
    private final Background background;

    @SerializedName("guarantee_header")
    private final LongContentLabelComponent guaranteeHeader;

    @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
    private final Padding padding;

    @SerializedName("service_detail")
    private final List<ServiceComponent> serviceDetail;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    @SerializedName("space")
    private final int f169951space;

    public AnchorV4LogisticsAndCouponDisplay() {
        this(null, null, null, 0, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4LogisticsAndCouponDisplay copy$default(AnchorV4LogisticsAndCouponDisplay r100, List r101, LongContentLabelComponent r102, Background r103, int r104, Padding r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.serviceDetail;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.guaranteeHeader;
    L8:
        LongContentLabelComponent r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.background;
    L11:
        Background r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.f169951space;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.padding;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<ServiceComponent> component1() {
        return this.serviceDetail;
    }

    public final LongContentLabelComponent component2() {
        return this.guaranteeHeader;
    }

    public final Background component3() {
        return this.background;
    }

    public final int component4() {
        return this.f169951space;
    }

    public final Padding component5() {
        return this.padding;
    }

    public final AnchorV4LogisticsAndCouponDisplay copy(List<ServiceComponent> r100, LongContentLabelComponent r101, Background r110, int r111, Padding r112) {
        return new AnchorV4LogisticsAndCouponDisplay(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4LogisticsAndCouponDisplay) == false) goto L16;
        AnchorV4LogisticsAndCouponDisplay r101 = (AnchorV4LogisticsAndCouponDisplay) r100;
        if (Intrinsics.areEqual(this.serviceDetail, r101.serviceDetail) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.guaranteeHeader, r101.guaranteeHeader) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L12;
        return false;
    L12:
        if (this.f169951space == r101.f169951space) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<ServiceComponent> r100 = this.serviceDetail;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LongContentLabelComponent r104 = this.guaranteeHeader;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Background r107 = this.background;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f169951space) * 31;
        Padding r110 = this.padding;
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
        return "AnchorV4LogisticsAndCouponDisplay(serviceDetail=" + this.serviceDetail + ", guaranteeHeader=" + this.guaranteeHeader + ", background=" + this.background + ", space=" + this.f169951space + ", padding=" + this.padding + ")";
    }

    public final Background getBackground() {
        return this.background;
    }

    public final LongContentLabelComponent getGuaranteeHeader() {
        return this.guaranteeHeader;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final List<ServiceComponent> getServiceDetail() {
        return this.serviceDetail;
    }

    public final int getSpace() {
        return this.f169951space;
    }

    public AnchorV4LogisticsAndCouponDisplay(List<ServiceComponent> r100, LongContentLabelComponent r101, Background r102, int r103, Padding r104) {
        this.serviceDetail = r100;
        this.guaranteeHeader = r101;
        this.background = r102;
        this.f169951space = r103;
        this.padding = r104;
    }

    public /* synthetic */ AnchorV4LogisticsAndCouponDisplay(List r100, LongContentLabelComponent r101, Background r102, int r103, Padding r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        List r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        LongContentLabelComponent r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Background r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        int r107 = 0;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Padding r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
