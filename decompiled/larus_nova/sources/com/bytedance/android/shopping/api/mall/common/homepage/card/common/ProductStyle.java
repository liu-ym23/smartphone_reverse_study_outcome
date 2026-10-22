package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import androidx.core.provider.FontsContractCompat;
import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.TextureRenderKeys;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b9\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010F\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010M\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010O\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0090\u0002\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010WHÖ\u0003J\t\u0010X\u001a\u00020\tHÖ\u0001J\t\u0010Y\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b+\u0010\u001eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b,\u0010\u001eR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b-\u0010\u001eR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b.\u0010\u001eR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b/\u0010\u001eR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b0\u0010\u001eR\"\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b1\u0010)\"\u0004\b2\u00103R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b4\u0010\u001eR\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b5\u0010\u001eR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b6\u0010\u001eR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b7\u0010\u001eR\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b<\u0010\u001e¨\u0006Z"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "Ljava/io/Serializable;", "width", "", "height", "color", "", "fontSize", "fontWeight", "", "lineHeight", "fontFamily", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "marginLeft", "marginTop", "marginRight", "marginBottom", "ellipsize", "maxLine", "shape", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/Shape;", "backGround", "aspectRatio", "radius", "", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/Shape;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;)V", "getAspectRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBackGround", "()Ljava/lang/String;", "setBackGround", "(Ljava/lang/String;)V", "getColor", "getEllipsize", "getFontFamily", "getFontSize", "getFontWeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getLineHeight", "getMarginBottom", "getMarginLeft", "getMarginRight", "getMarginTop", "getMaxLine", "setMaxLine", "(Ljava/lang/Integer;)V", "getPaddingBottom", "getPaddingLeft", "getPaddingRight", "getPaddingTop", "getRadius", "()Ljava/util/List;", "getShape", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/Shape;", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/Shape;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "equals", "", "other", "", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductStyle implements Serializable {

    @SerializedName(TextureRenderKeys.KEY_IS_ASPECT_RATIO)
    private final Float aspectRatio;

    @SerializedName("background_color")
    private String backGround;
    private final String color;

    @SerializedName("ellipsize")
    private final String ellipsize;

    @SerializedName("font_family")
    private final String fontFamily;

    @SerializedName("font_size")
    private final Float fontSize;

    @SerializedName(FontsContractCompat.Columns.WEIGHT)
    private final Integer fontWeight;
    private final Float height;

    @SerializedName("line_height")
    private final Float lineHeight;

    @SerializedName("margin_bottom")
    private final Float marginBottom;

    @SerializedName("margin_left")
    private final Float marginLeft;

    @SerializedName("margin_right")
    private final Float marginRight;

    @SerializedName("margin_top")
    private final Float marginTop;

    @SerializedName("max_line")
    private Integer maxLine;

    @SerializedName("padding_bottom")
    private final Float paddingBottom;

    @SerializedName("padding_left")
    private final Float paddingLeft;

    @SerializedName("padding_right")
    private final Float paddingRight;

    @SerializedName("padding_top")
    private final Float paddingTop;

    @SerializedName("radius")
    private final List<Float> radius;

    @SerializedName("shape")
    private final Shape shape;
    private final Float width;

    public ProductStyle() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductStyle copy$default(ProductStyle r110, Float r111, Float r112, String r210, Float r211, Integer r212, Float r213, String r214, Float r215, Float r216, Float r217, Float r218, Float r219, Float r310, Float r311, Float r312, String r313, Integer r314, Shape r315, String r316, Float r317, List r318, int r319, Object r410) {
        if ((r319 & 1) == 0) goto L5;
        Float r100 = r110.width;
    L7:
        if ((r319 & 2) == 0) goto L9;
        Float r101 = r110.height;
    L11:
        if ((r319 & 4) == 0) goto L13;
        String r102 = r110.color;
    L15:
        if ((r319 & 8) == 0) goto L17;
        Float r103 = r110.fontSize;
    L19:
        if ((r319 & 16) == 0) goto L21;
        Integer r104 = r110.fontWeight;
    L23:
        if ((r319 & 32) == 0) goto L25;
        Float r105 = r110.lineHeight;
    L27:
        if ((r319 & 64) == 0) goto L29;
        String r106 = r110.fontFamily;
    L31:
        if ((r319 & 128) == 0) goto L33;
        Float r107 = r110.paddingLeft;
    L35:
        if ((r319 & 256) == 0) goto L37;
        Float r113 = r110.paddingRight;
    L39:
        if ((r319 & 512) == 0) goto L41;
        Float r114 = r110.paddingTop;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        Float r115 = r110.paddingBottom;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        Float r116 = r110.marginLeft;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        Float r117 = r110.marginTop;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        Float r118 = r110.marginRight;
    L58:
        Float r320 = r118;
        if ((r319 & 16384) == 0) goto L61;
        Float r119 = r110.marginBottom;
    L62:
        Float r321 = r119;
        if ((r319 & 32768) == 0) goto L65;
        String r120 = r110.ellipsize;
    L66:
        String r322 = r120;
        if ((r319 & 65536) == 0) goto L69;
        Integer r121 = r110.maxLine;
    L70:
        Integer r323 = r121;
        if ((r319 & 131072) == 0) goto L73;
        Shape r122 = r110.shape;
    L74:
        Shape r324 = r122;
        if ((r319 & 262144) == 0) goto L77;
        String r123 = r110.backGround;
    L78:
        String r325 = r123;
        if ((r319 & 524288) == 0) goto L81;
        Float r124 = r110.aspectRatio;
    L83:
        if ((r319 & 1048576) == 0) goto L85;
        List r108 = r110.radius;
    L87:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r124, r108);
    L85:
        r108 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Float component1() {
        return this.width;
    }

    public final Float component10() {
        return this.paddingTop;
    }

    public final Float component11() {
        return this.paddingBottom;
    }

    public final Float component12() {
        return this.marginLeft;
    }

    public final Float component13() {
        return this.marginTop;
    }

    public final Float component14() {
        return this.marginRight;
    }

    public final Float component15() {
        return this.marginBottom;
    }

    public final String component16() {
        return this.ellipsize;
    }

    public final Integer component17() {
        return this.maxLine;
    }

    public final Shape component18() {
        return this.shape;
    }

    public final String component19() {
        return this.backGround;
    }

    public final Float component2() {
        return this.height;
    }

    public final Float component20() {
        return this.aspectRatio;
    }

    public final List<Float> component21() {
        return this.radius;
    }

    public final String component3() {
        return this.color;
    }

    public final Float component4() {
        return this.fontSize;
    }

    public final Integer component5() {
        return this.fontWeight;
    }

    public final Float component6() {
        return this.lineHeight;
    }

    public final String component7() {
        return this.fontFamily;
    }

    public final Float component8() {
        return this.paddingLeft;
    }

    public final Float component9() {
        return this.paddingRight;
    }

    public final ProductStyle copy(Float r210, Float r211, String r212, Float r213, Integer r214, Float r215, String r310, Float r311, Float r312, Float r313, Float r314, Float r315, Float r316, Float r317, Float r318, String r319, Integer r410, Shape r411, String r412, Float r413, List<Float> r414) {
        return new ProductStyle(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductStyle) == false) goto L48;
        ProductStyle r101 = (ProductStyle) r100;
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.lineHeight, r101.lineHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fontFamily, r101.fontFamily) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.paddingLeft, r101.paddingLeft) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.paddingRight, r101.paddingRight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.paddingTop, r101.paddingTop) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.paddingBottom, r101.paddingBottom) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.marginLeft, r101.marginLeft) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.marginTop, r101.marginTop) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.marginRight, r101.marginRight) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.marginBottom, r101.marginBottom) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ellipsize, r101.ellipsize) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.maxLine, r101.maxLine) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.shape, r101.shape) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.backGround, r101.backGround) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.aspectRatio, r101.aspectRatio) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    public int hashCode() {
        Float r100 = this.width;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Float r104 = this.height;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.color;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.fontSize;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.fontWeight;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.lineHeight;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.fontFamily;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.paddingLeft;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Float r125 = this.paddingRight;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Float r128 = this.paddingTop;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Float r131 = this.paddingBottom;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Float r134 = this.marginLeft;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Float r137 = this.marginTop;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Float r140 = this.marginRight;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Float r143 = this.marginBottom;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.ellipsize;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.maxLine;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        Shape r152 = this.shape;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.backGround;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        Float r158 = this.aspectRatio;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        List<Float> r161 = this.radius;
        if (r161 == null) goto L86;
        r101 = r161.hashCode();
    L86:
        return r160 + r101;
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
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
        return "ProductStyle(width=" + this.width + ", height=" + this.height + ", color=" + this.color + ", fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", lineHeight=" + this.lineHeight + ", fontFamily=" + this.fontFamily + ", paddingLeft=" + this.paddingLeft + ", paddingRight=" + this.paddingRight + ", paddingTop=" + this.paddingTop + ", paddingBottom=" + this.paddingBottom + ", marginLeft=" + this.marginLeft + ", marginTop=" + this.marginTop + ", marginRight=" + this.marginRight + ", marginBottom=" + this.marginBottom + ", ellipsize=" + this.ellipsize + ", maxLine=" + this.maxLine + ", shape=" + this.shape + ", backGround=" + this.backGround + ", aspectRatio=" + this.aspectRatio + ", radius=" + this.radius + ")";
    }

    public final Float getAspectRatio() {
        return this.aspectRatio;
    }

    public final String getBackGround() {
        return this.backGround;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getEllipsize() {
        return this.ellipsize;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final Float getFontSize() {
        return this.fontSize;
    }

    public final Integer getFontWeight() {
        return this.fontWeight;
    }

    public final Float getHeight() {
        return this.height;
    }

    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public final Float getMarginBottom() {
        return this.marginBottom;
    }

    public final Float getMarginLeft() {
        return this.marginLeft;
    }

    public final Float getMarginRight() {
        return this.marginRight;
    }

    public final Float getMarginTop() {
        return this.marginTop;
    }

    public final Integer getMaxLine() {
        return this.maxLine;
    }

    public final Float getPaddingBottom() {
        return this.paddingBottom;
    }

    public final Float getPaddingLeft() {
        return this.paddingLeft;
    }

    public final Float getPaddingRight() {
        return this.paddingRight;
    }

    public final Float getPaddingTop() {
        return this.paddingTop;
    }

    public final List<Float> getRadius() {
        return this.radius;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final Float getWidth() {
        return this.width;
    }

    public final void setBackGround(String r100) {
        this.backGround = r100;
    }

    public final void setMaxLine(Integer r100) {
        this.maxLine = r100;
    }

    public ProductStyle(Float r100, Float r101, String r102, Float r103, Integer r104, Float r105, String r106, Float r110, Float r111, Float r112, Float r113, Float r114, Float r115, Float r116, Float r117, String r118, Integer r119, Shape r210, String r211, Float r212, List<Float> r213) {
        this.width = r100;
        this.height = r101;
        this.color = r102;
        this.fontSize = r103;
        this.fontWeight = r104;
        this.lineHeight = r105;
        this.fontFamily = r106;
        this.paddingLeft = r110;
        this.paddingRight = r111;
        this.paddingTop = r112;
        this.paddingBottom = r113;
        this.marginLeft = r114;
        this.marginTop = r115;
        this.marginRight = r116;
        this.marginBottom = r117;
        this.ellipsize = r118;
        this.maxLine = r119;
        this.shape = r210;
        this.backGround = r211;
        this.aspectRatio = r212;
        this.radius = r213;
    }

    public /* synthetic */ ProductStyle(Float r210, Float r211, String r212, Float r213, Integer r214, Float r215, String r216, Float r310, Float r311, Float r312, Float r313, Float r314, Float r315, Float r316, Float r317, String r318, Integer r319, Shape r410, String r411, Float r412, List r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        Float r100 = null;
    L7:
        if ((r414 & 2) == 0) goto L9;
        Float r101 = null;
    L11:
        if ((r414 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r414 & 8) == 0) goto L17;
        Float r103 = null;
    L19:
        if ((r414 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r414 & 32) == 0) goto L25;
        Float r105 = null;
    L27:
        if ((r414 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r414 & 128) == 0) goto L33;
        Float r107 = null;
    L35:
        if ((r414 & 256) == 0) goto L37;
        Float r110 = null;
    L39:
        if ((r414 & 512) == 0) goto L41;
        Float r111 = null;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        Float r112 = null;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        Float r113 = null;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        Float r114 = null;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        Float r115 = null;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        Float r108 = null;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        Integer r117 = null;
    L71:
        if ((r414 & 131072) == 0) goto L73;
        Shape r118 = null;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r414 & 524288) == 0) goto L81;
        Float r217 = null;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        List r109 = null;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r217, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L81:
        r217 = r412;
        goto L83
    L77:
        r119 = r411;
        goto L79
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r115 = r316;
        goto L59
    L53:
        r114 = r315;
        goto L55
    L49:
        r113 = r314;
        goto L51
    L45:
        r112 = r313;
        goto L47
    L41:
        r111 = r312;
        goto L43
    L37:
        r110 = r311;
        goto L39
    L33:
        r107 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
