package com.bytedance.android.ec.model.live;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/live/j;", "", "", "price", "J", "f", "()J", "fontSize", "d", "", "color", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", CommodityText.BOLD, "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "maxWidth", "e", "decimalFontSize", "c", "symbolFontSize", ce.f26391f, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName(CommodityText.BOLD)
    private final boolean bold;

    @SerializedName("color")
    private final String color;

    @SerializedName("decimal_font_size")
    private final long decimalFontSize;

    @SerializedName("font_size")
    private final long fontSize;

    @SerializedName(TextureRenderKeys.KEY_IS_MAX_WIDTH)
    private final long maxWidth;

    @SerializedName("price")
    private final long price;

    @SerializedName("symbol_font_size")
    private final long symbolFontSize;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L20;
        j r101 = (j) r100;
        if (this.price == r101.price) goto L8;
        return false;
    L8:
        if (this.fontSize == r101.fontSize) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L12;
        return false;
    L12:
        if (this.bold == r101.bold) goto L14;
        return false;
    L14:
        if (this.maxWidth == r101.maxWidth) goto L16;
        return false;
    L16:
        if (this.decimalFontSize == r101.decimalFontSize) goto L18;
        return false;
    L18:
        if (this.symbolFontSize == r101.symbolFontSize) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        long r100 = this.price;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.fontSize;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.color;
        if (r104 == null) goto L5;
        int r105 = r104.hashCode();
    L6:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.bold;
        ?? r108 = r107;
        if (r107 == false) goto L9;
        r108 = 1;
    L9:
        long r109 = this.maxWidth;
        int r110 = (((r106 + r108) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.decimalFontSize;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.symbolFontSize;
        return r112 + ((int) (r113 ^ (r113 >>> 32)));
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "ECElementPrice(price=" + this.price + ", fontSize=" + this.fontSize + ", color=" + this.color + ", bold=" + this.bold + ", maxWidth=" + this.maxWidth + ", decimalFontSize=" + this.decimalFontSize + ", symbolFontSize=" + this.symbolFontSize + ")";
    }

    public j() {
        this.price = 0;
        this.fontSize = 0;
        this.color = null;
        this.bold = false;
        this.maxWidth = 0;
        this.decimalFontSize = 0;
        this.symbolFontSize = 0;
    }

    public final boolean a() {
        return this.bold;
    }

    public final String b() {
        return this.color;
    }

    public final long c() {
        return this.decimalFontSize;
    }

    public final long d() {
        return this.fontSize;
    }

    public final long e() {
        return this.maxWidth;
    }

    public final long f() {
        return this.price;
    }

    public final long g() {
        return this.symbolFontSize;
    }
}
