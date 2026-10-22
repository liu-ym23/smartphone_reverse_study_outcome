package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000bHÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\rHÆ\u0003Jk\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\rHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\nHÖ\u0001R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\r8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinPriceUIConfig;", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/AbsECLiveSkinBaseUIConfig;", "yuanTagFontSize", "", "integerFontSize", "decimalFontSize", "prefixFontSize", "suffixFontSize", "color", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinColors;", "radius", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinRadius;", "(IIIIILjava/util/List;Ljava/util/List;)V", "getColor", "()Ljava/util/List;", "getDecimalFontSize", "()I", "getIntegerFontSize", "getPrefixFontSize", "getRadius", "getSuffixFontSize", "getYuanTagFontSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinPriceUIConfig extends AbsECLiveSkinBaseUIConfig {

    @SerializedName("color")
    private final List<String> color;

    @SerializedName("decimal_font_size")
    private final int decimalFontSize;

    @SerializedName("integer_font_size")
    private final int integerFontSize;

    @SerializedName("prefix_font_size")
    private final int prefixFontSize;

    @SerializedName("radius")
    private final List<Integer> radius;

    @SerializedName("suffix_font_size")
    private final int suffixFontSize;

    @SerializedName("dollar_tag_font_size")
    private final int yuanTagFontSize;

    public ECLiveSkinPriceUIConfig() {
        this(0, 0, 0, 0, 0, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinPriceUIConfig copy$default(ECLiveSkinPriceUIConfig r100, int r101, int r102, int r103, int r104, int r110, List r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.yuanTagFontSize;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.integerFontSize;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.decimalFontSize;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.prefixFontSize;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.suffixFontSize;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.color;
    L20:
        List r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.getRadius();
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.yuanTagFontSize;
    }

    public final int component2() {
        return this.integerFontSize;
    }

    public final int component3() {
        return this.decimalFontSize;
    }

    public final int component4() {
        return this.prefixFontSize;
    }

    public final int component5() {
        return this.suffixFontSize;
    }

    public final List<String> component6() {
        return this.color;
    }

    public final List<Integer> component7() {
        return getRadius();
    }

    public final ECLiveSkinPriceUIConfig copy(int r110, int r111, int r112, int r113, int r114, List<String> r115, List<Integer> r116) {
        return new ECLiveSkinPriceUIConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECLiveSkinPriceUIConfig) == false) goto L20;
        ECLiveSkinPriceUIConfig r101 = (ECLiveSkinPriceUIConfig) r100;
        if (this.yuanTagFontSize == r101.yuanTagFontSize) goto L8;
        return false;
    L8:
        if (this.integerFontSize == r101.integerFontSize) goto L10;
        return false;
    L10:
        if (this.decimalFontSize == r101.decimalFontSize) goto L12;
        return false;
    L12:
        if (this.prefixFontSize == r101.prefixFontSize) goto L14;
        return false;
    L14:
        if (this.suffixFontSize == r101.suffixFontSize) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getRadius(), r101.getRadius()) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r100 = ((((((((this.yuanTagFontSize * 31) + this.integerFontSize) * 31) + this.decimalFontSize) * 31) + this.prefixFontSize) * 31) + this.suffixFontSize) * 31;
        List<String> r101 = this.color;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        List<Integer> r105 = getRadius();
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "ECLiveSkinPriceUIConfig(yuanTagFontSize=" + this.yuanTagFontSize + ", integerFontSize=" + this.integerFontSize + ", decimalFontSize=" + this.decimalFontSize + ", prefixFontSize=" + this.prefixFontSize + ", suffixFontSize=" + this.suffixFontSize + ", color=" + this.color + ", radius=" + getRadius() + ")";
    }

    public final List<String> getColor() {
        return this.color;
    }

    public final int getDecimalFontSize() {
        return this.decimalFontSize;
    }

    public final int getIntegerFontSize() {
        return this.integerFontSize;
    }

    public final int getPrefixFontSize() {
        return this.prefixFontSize;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig
    public List<Integer> getRadius() {
        return this.radius;
    }

    public final int getSuffixFontSize() {
        return this.suffixFontSize;
    }

    public final int getYuanTagFontSize() {
        return this.yuanTagFontSize;
    }

    public ECLiveSkinPriceUIConfig(int r100, int r101, int r102, int r103, int r104, List<String> r105, List<Integer> r106) {
        this.yuanTagFontSize = r100;
        this.integerFontSize = r101;
        this.decimalFontSize = r102;
        this.prefixFontSize = r103;
        this.suffixFontSize = r104;
        this.color = r105;
        this.radius = r106;
    }

    public /* synthetic */ ECLiveSkinPriceUIConfig(int r100, int r101, int r102, int r103, int r110, List r111, List r112, int r113, DefaultConstructorMarker r114) {
        int r104 = 0;
        if ((r113 & 1) == 0) goto L5;
        int r115 = 0;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r113 & 8) == 0) goto L17;
        int r107 = 0;
    L19:
        if ((r113 & 16) != 0) goto L23;
        r104 = r110;
    L23:
        if ((r113 & 32) == 0) goto L25;
        List r108 = null;
    L27:
        if ((r113 & 64) == 0) goto L29;
        List r116 = null;
    L30:
        this(r115, r105, r106, r107, r104, r108, r116);
        return;
    L29:
        r116 = r112;
        goto L30
    L25:
        r108 = r111;
        goto L27
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
        r115 = r100;
        goto L7
    }
}
