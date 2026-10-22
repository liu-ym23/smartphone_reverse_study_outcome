package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAmbient;", "Ljava/io/Serializable;", "backGround", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "title", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "slogan", "shading", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;)V", "getBackGround", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getShading", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getSlogan", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAmbient implements Serializable {

    @SerializedName("background")
    private final Background backGround;

    @SerializedName("douship_shading")
    private final ImageModel shading;

    @SerializedName("douship_slogan")
    private final TextWithOneIconElement slogan;

    @SerializedName("douship_title")
    private final TextWithOneIconElement title;

    public AnchorV4ShopAmbient() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AnchorV4ShopAmbient copy$default(AnchorV4ShopAmbient r100, Background r101, TextWithOneIconElement r102, TextWithOneIconElement r103, ImageModel r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.backGround;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.title;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.slogan;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.shading;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Background component1() {
        return this.backGround;
    }

    public final TextWithOneIconElement component2() {
        return this.title;
    }

    public final TextWithOneIconElement component3() {
        return this.slogan;
    }

    public final ImageModel component4() {
        return this.shading;
    }

    public final AnchorV4ShopAmbient copy(Background r100, TextWithOneIconElement r101, TextWithOneIconElement r102, ImageModel r103) {
        return new AnchorV4ShopAmbient(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4ShopAmbient) == false) goto L14;
        AnchorV4ShopAmbient r101 = (AnchorV4ShopAmbient) r100;
        if (Intrinsics.areEqual(this.backGround, r101.backGround) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.slogan, r101.slogan) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shading, r101.shading) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Background r100 = this.backGround;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TextWithOneIconElement r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TextWithOneIconElement r107 = this.slogan;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ImageModel r110 = this.shading;
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
        return "AnchorV4ShopAmbient(backGround=" + this.backGround + ", title=" + this.title + ", slogan=" + this.slogan + ", shading=" + this.shading + ")";
    }

    public final Background getBackGround() {
        return this.backGround;
    }

    public final ImageModel getShading() {
        return this.shading;
    }

    public final TextWithOneIconElement getSlogan() {
        return this.slogan;
    }

    public final TextWithOneIconElement getTitle() {
        return this.title;
    }

    public AnchorV4ShopAmbient(Background r100, TextWithOneIconElement r101, TextWithOneIconElement r102, ImageModel r103) {
        this.backGround = r100;
        this.title = r101;
        this.slogan = r102;
        this.shading = r103;
    }

    public /* synthetic */ AnchorV4ShopAmbient(Background r100, TextWithOneIconElement r101, TextWithOneIconElement r102, ImageModel r103, int r104, DefaultConstructorMarker r105) {
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
