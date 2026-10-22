package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/QualityEmphasizeElement;", "Ljava/io/Serializable;", "backgroundImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "title", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", SocialConstants.PARAM_APP_DESC, "radius", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", GXTemplateKey.FLEXBOX_PADDING, "Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "(Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;)V", "getBackgroundImg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getDesc", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getPadding", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "getRadius", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QualityEmphasizeElement implements Serializable {

    @SerializedName("background_img")
    private final ECUrlModel backgroundImg;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final TextElement desc;

    @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
    private final Padding padding;

    @SerializedName("radius")
    private final Radius radius;

    @SerializedName("title")
    private final TextElement title;

    public QualityEmphasizeElement() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ QualityEmphasizeElement copy$default(QualityEmphasizeElement r100, ECUrlModel r101, TextElement r102, TextElement r103, Radius r104, Padding r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.backgroundImg;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.title;
    L8:
        TextElement r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.desc;
    L11:
        TextElement r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.radius;
    L14:
        Radius r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.padding;
    L17:
        ECUrlModel r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final ECUrlModel component1() {
        return this.backgroundImg;
    }

    public final TextElement component2() {
        return this.title;
    }

    public final TextElement component3() {
        return this.desc;
    }

    public final Radius component4() {
        return this.radius;
    }

    public final Padding component5() {
        return this.padding;
    }

    public final QualityEmphasizeElement copy(ECUrlModel r100, TextElement r101, TextElement r110, Radius r111, Padding r112) {
        return new QualityEmphasizeElement(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof QualityEmphasizeElement) == false) goto L16;
        QualityEmphasizeElement r101 = (QualityEmphasizeElement) r100;
        if (Intrinsics.areEqual(this.backgroundImg, r101.backgroundImg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L14;
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
        ECUrlModel r100 = this.backgroundImg;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TextElement r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TextElement r107 = this.desc;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Radius r110 = this.radius;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Padding r113 = this.padding;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "QualityEmphasizeElement(backgroundImg=" + this.backgroundImg + ", title=" + this.title + ", desc=" + this.desc + ", radius=" + this.radius + ", padding=" + this.padding + ")";
    }

    public final ECUrlModel getBackgroundImg() {
        return this.backgroundImg;
    }

    public final TextElement getDesc() {
        return this.desc;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final Radius getRadius() {
        return this.radius;
    }

    public final TextElement getTitle() {
        return this.title;
    }

    public QualityEmphasizeElement(ECUrlModel r100, TextElement r101, TextElement r102, Radius r103, Padding r104) {
        this.backgroundImg = r100;
        this.title = r101;
        this.desc = r102;
        this.radius = r103;
        this.padding = r104;
    }

    public /* synthetic */ QualityEmphasizeElement(ECUrlModel r100, TextElement r101, TextElement r102, Radius r103, Padding r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        ECUrlModel r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        TextElement r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        TextElement r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Radius r107 = null;
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
