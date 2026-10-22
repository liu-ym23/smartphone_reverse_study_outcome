package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.alibaba.gaiax.render.view.GXViewKey;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0013HÖ\u0001J\u0006\u0010#\u001a\u00020\u001fJ\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;", "Ljava/io/Serializable;", "fontSize", "", "textColor", "", "fontWeight", "fontShadow", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontShadow;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontShadow;)V", "getFontShadow", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontShadow;", "getFontSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFontWeight", "getTextColor", "()Ljava/lang/String;", "textColorInt", "", "getTextColorInt", "()Ljava/lang/Integer;", "textColorInt$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontShadow;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;", "equals", "", "other", "", "hashCode", "isBoldStyle", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FontStyle implements Serializable {

    @SerializedName(GXViewKey.VIEW_TYPE_SHADOW_LAYOUT)
    private final FontShadow fontShadow;

    @SerializedName("size")
    private final Long fontSize;

    @SerializedName("weight")
    private final Long fontWeight;

    @SerializedName("color")
    private final String textColor;
    private final Lazy textColorInt$delegate;

    public FontStyle() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FontStyle copy$default(FontStyle r100, Long r101, String r102, Long r103, FontShadow r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.fontSize;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.textColor;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.fontWeight;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.fontShadow;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Long component1() {
        return this.fontSize;
    }

    public final String component2() {
        return this.textColor;
    }

    public final Long component3() {
        return this.fontWeight;
    }

    public final FontShadow component4() {
        return this.fontShadow;
    }

    public final FontStyle copy(Long r100, String r101, Long r102, FontShadow r103) {
        return new FontStyle(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FontStyle) == false) goto L14;
        FontStyle r101 = (FontStyle) r100;
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontShadow, r101.fontShadow) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final Integer getTextColorInt() {
        return (Integer) this.textColorInt$delegate.getValue();
    }

    public int hashCode() {
        Long r100 = this.fontSize;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.textColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.fontWeight;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        FontShadow r110 = this.fontShadow;
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
        return "FontStyle(fontSize=" + this.fontSize + ", textColor=" + this.textColor + ", fontWeight=" + this.fontWeight + ", fontShadow=" + this.fontShadow + ")";
    }

    public final boolean isBoldStyle() {
        Long r100 = this.fontWeight;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.longValue() < 500) goto L7;
        return true;
    }

    public final FontShadow getFontShadow() {
        return this.fontShadow;
    }

    public final Long getFontSize() {
        return this.fontSize;
    }

    public final Long getFontWeight() {
        return this.fontWeight;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public FontStyle(Long r100, String r101, Long r102, FontShadow r103) {
        this.fontSize = r100;
        this.textColor = r101;
        this.fontWeight = r102;
        this.fontShadow = r103;
        this.textColorInt$delegate = LazyKt.lazy(new FontStyle$textColorInt$2(this));
    }

    public /* synthetic */ FontStyle(Long r100, String r101, Long r102, FontShadow r103, int r104, DefaultConstructorMarker r105) {
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
