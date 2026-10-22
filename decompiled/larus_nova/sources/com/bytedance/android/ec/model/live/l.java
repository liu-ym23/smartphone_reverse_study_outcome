package com.bytedance.android.ec.model.live;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R\u001c\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000fR\u001c\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b&\u0010\u000f¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/model/live/l;", "", "", "text", "Ljava/lang/String;", ce.f26395j, "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "color", "b", "", "size", "Ljava/lang/Integer;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/Integer;", "", CommodityText.BOLD, "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "f", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "maxWidth", "J", "h", "()J", "ellipsis", "c", "fontFamilyType", "d", "fontWeight", "e", "maxLine", ce.f26391f, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName(CommodityText.BOLD)
    private final boolean bold;

    @SerializedName("color")
    private final String color;

    @SerializedName("ellipsis")
    private final boolean ellipsis;

    @SerializedName("font_type")
    private final Integer fontFamilyType;

    @SerializedName("weight")
    private final Integer fontWeight;

    @SerializedName("background")
    private final ECUrlModel image;

    @SerializedName("max_line")
    private final Integer maxLine;

    @SerializedName(TextureRenderKeys.KEY_IS_MAX_WIDTH)
    private final long maxWidth;

    @SerializedName("size")
    private final Integer size;

    @SerializedName("text")
    private String text;

    public l() {
        this(null, null, null, false, null, 0, false, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L26;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L12;
        return false;
    L12:
        if (this.bold == r101.bold) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L16;
        return false;
    L16:
        if (this.maxWidth == r101.maxWidth) goto L18;
        return false;
    L18:
        if (this.ellipsis == r101.ellipsis) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.fontFamilyType, r101.fontFamilyType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maxLine, r101.maxLine) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.color;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.size;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.bold;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        ECUrlModel r114 = this.image;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        long r116 = this.maxWidth;
        int r117 = (((r113 + r115) * 31) + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        boolean r118 = this.ellipsis;
        if (r118 == true) goto L25;
        r111 = r118;
    L25:
        int r119 = (r117 + r111) * 31;
        Integer r120 = this.fontFamilyType;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        Integer r123 = this.fontWeight;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        Integer r126 = this.maxLine;
        if (r126 == null) goto L37;
        r101 = r126.hashCode();
    L37:
        return r125 + r101;
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L20:
        r115 = 0;
        goto L21
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

    public final String toString() {
        return "ECElementText(text=" + this.text + ", color=" + this.color + ", size=" + this.size + ", bold=" + this.bold + ", image=" + this.image + ", maxWidth=" + this.maxWidth + ", ellipsis=" + this.ellipsis + ", fontFamilyType=" + this.fontFamilyType + ", fontWeight=" + this.fontWeight + ", maxLine=" + this.maxLine + ")";
    }

    public final boolean a() {
        return this.bold;
    }

    public final String b() {
        return this.color;
    }

    public final boolean c() {
        return this.ellipsis;
    }

    public final Integer d() {
        return this.fontFamilyType;
    }

    public final Integer e() {
        return this.fontWeight;
    }

    public final ECUrlModel f() {
        return this.image;
    }

    public final Integer g() {
        return this.maxLine;
    }

    public final long h() {
        return this.maxWidth;
    }

    public final Integer i() {
        return this.size;
    }

    public final String j() {
        return this.text;
    }

    public l(String r100, String r101, Integer r102, boolean r103, ECUrlModel r104, long r105, boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = false;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r105 = 0;
    L21:
        if ((r111 & 64) == 0) goto L23;
        r110 = false;
    L23:
        this.text = r100;
        this.color = r101;
        this.size = r102;
        this.bold = r103;
        this.image = r104;
        this.maxWidth = r105;
        this.ellipsis = r110;
        this.fontFamilyType = null;
        this.fontWeight = null;
        this.maxLine = null;
    }
}
