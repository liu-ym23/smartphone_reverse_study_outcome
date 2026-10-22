package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001.Bq\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b+\u0010,J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003Js\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00072\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010(R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b)\u0010(R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b*\u0010\u001f¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphereData;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "", "component5", "", "component6", "component7", "component8", "img", "num", "bgColor", "borderColor", "leftMargin", "bgColors", "borderColors", "topImg", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getImg", "()Ljava/lang/String;", "getNum", "getBgColor", "getBorderColor", "J", "getLeftMargin", "()J", "Ljava/util/List;", "getBgColors", "()Ljava/util/List;", "getBorderColors", "getTopImg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAuctionAtmosphereData implements Serializable {
    public static final a Companion = null;

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("bg_colors")
    private final List<String> bgColors;

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("border_colors")
    private final List<String> borderColors;

    @SerializedName("img")
    private final String img;

    @SerializedName("left_margin")
    private final long leftMargin;

    @SerializedName("num")
    private final String num;

    @SerializedName("top_img")
    private final String topImg;

    public static final class a {
        public a() {
        }

        public static ECHotAtmosphere a(ECAuctionAtmosphereData r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "$this$convertToHotAtmosphere");
            ECHotAtmosphere r102 = new ECHotAtmosphere();
            r102.img = r100.getImg();
            r102.type = 100;
            r102.uiType = 1;
            if (r101 != null) goto L5;
            r101 = r100.getNum();
        L5:
            r102.num = r101;
            r102.bgColor = r100.getBgColor();
            r102.borderColor = r100.getBorderColor();
            r102.leftMargin = (int) r100.getLeftMargin();
            r102.bgColors = r100.getBgColors();
            r102.borderColors = r100.getBorderColors();
            r102.topImg = r100.getTopImg();
            return r102;
        }
    }

    static {
        Companion = new a();
    }

    public ECAuctionAtmosphereData() {
        this(null, null, null, null, 0, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECAuctionAtmosphereData copy$default(ECAuctionAtmosphereData r110, String r111, String r112, String r113, String r114, long r115, List r116, List r117, String r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.img;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.num;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.bgColor;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.borderColor;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r104 = r110.leftMargin;
    L23:
        if ((r210 & 32) == 0) goto L25;
        List r105 = r110.bgColors;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r106 = r110.borderColors;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.topImg;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.img;
    }

    public final String component2() {
        return this.num;
    }

    public final String component3() {
        return this.bgColor;
    }

    public final String component4() {
        return this.borderColor;
    }

    public final long component5() {
        return this.leftMargin;
    }

    public final List<String> component6() {
        return this.bgColors;
    }

    public final List<String> component7() {
        return this.borderColors;
    }

    public final String component8() {
        return this.topImg;
    }

    public final ECAuctionAtmosphereData copy(String r110, String r111, String r112, String r113, long r114, List<String> r115, List<String> r116, String r210) {
        return new ECAuctionAtmosphereData(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAuctionAtmosphereData) == false) goto L22;
        ECAuctionAtmosphereData r101 = (ECAuctionAtmosphereData) r100;
        if (Intrinsics.areEqual(this.img, r101.img) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.num, r101.num) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L14;
        return false;
    L14:
        if (this.leftMargin == r101.leftMargin) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bgColors, r101.bgColors) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.borderColors, r101.borderColors) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.topImg, r101.topImg) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        String r100 = this.img;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.num;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bgColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.borderColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.leftMargin;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        List<String> r115 = this.bgColors;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        List<String> r118 = this.borderColors;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.topImg;
        if (r121 == null) goto L30;
        r101 = r121.hashCode();
    L30:
        return r120 + r101;
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
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
        return "ECAuctionAtmosphereData(img=" + this.img + ", num=" + this.num + ", bgColor=" + this.bgColor + ", borderColor=" + this.borderColor + ", leftMargin=" + this.leftMargin + ", bgColors=" + this.bgColors + ", borderColors=" + this.borderColors + ", topImg=" + this.topImg + ")";
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final List<String> getBgColors() {
        return this.bgColors;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final List<String> getBorderColors() {
        return this.borderColors;
    }

    public final String getImg() {
        return this.img;
    }

    public final long getLeftMargin() {
        return this.leftMargin;
    }

    public final String getNum() {
        return this.num;
    }

    public final String getTopImg() {
        return this.topImg;
    }

    public ECAuctionAtmosphereData(String r100, String r101, String r102, String r103, long r104, List<String> r105, List<String> r106, String r107) {
        this.img = r100;
        this.num = r101;
        this.bgColor = r102;
        this.borderColor = r103;
        this.leftMargin = r104;
        this.bgColors = r105;
        this.borderColors = r106;
        this.topImg = r107;
    }

    public /* synthetic */ ECAuctionAtmosphereData(String r110, String r111, String r112, String r113, long r114, List r115, List r116, String r117, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r105 = 0;
    L23:
        if ((r210 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r210 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
