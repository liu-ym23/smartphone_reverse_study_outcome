package com.bytedance.android.shopping.api.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b6\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0002\u0010\u0014J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J²\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\b\u0010B\u001a\u0004\u0018\u00010\bJ\t\u0010C\u001a\u00020\u0006HÖ\u0001J\t\u0010D\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001a\"\u0004\b(\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b,\u0010$R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0018¨\u0006E"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;", "Ljava/io/Serializable;", "mainPicScale", "", "category", "", "", "mainPicUrl", "", "mainPic11Url", "mainPic34Url", "guidePic34Url", "mainPic34Count", "isAbMatch", "halPdpOptimizeStyle", "insertPicUrl", "insertPicScale", "insertPicUri", "halfPdpHeadScaleParam", "halPdpHeadSpace", "(Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/Float;Ljava/lang/String;FI)V", "getCategory", "()Ljava/util/List;", "getGuidePic34Url", "()Ljava/lang/String;", "getHalPdpHeadSpace", "()I", "setHalPdpHeadSpace", "(I)V", "getHalPdpOptimizeStyle", "setHalPdpOptimizeStyle", "getHalfPdpHeadScaleParam", "()F", "setHalfPdpHeadScaleParam", "(F)V", "getInsertPicScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getInsertPicUri", "getInsertPicUrl", "setAbMatch", "getMainPic11Url", "getMainPic34Count", "getMainPic34Url", "getMainPicScale", "getMainPicUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/Float;Ljava/lang/String;FI)Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;", "equals", "", "other", "", "getPreferMainPicUrl", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class WireFrameSchemaInfo implements Serializable {

    @SerializedName("category")
    private final List<Integer> category;

    @SerializedName("guide_pic_34_url")
    private final String guidePic34Url;

    @SerializedName("half_head_space")
    private int halPdpHeadSpace;

    @SerializedName("half_pdp_optimize_style")
    private int halPdpOptimizeStyle;

    @SerializedName("half_head_scale")
    private float halfPdpHeadScaleParam;

    @SerializedName("insert_pic_scale")
    private final Float insertPicScale;

    @SerializedName("insert_pic_uri")
    private final String insertPicUri;

    @SerializedName("insert_pic_url")
    private final String insertPicUrl;

    @SerializedName("is_ab_match")
    private int isAbMatch;

    @SerializedName("main_pic_11_url")
    private final String mainPic11Url;

    @SerializedName("main_pic_34_count")
    private final int mainPic34Count;

    @SerializedName("main_pic_34_url")
    private final String mainPic34Url;

    @SerializedName("main_pic_scale")
    private final Float mainPicScale;

    @SerializedName("main_pic_url")
    private final String mainPicUrl;

    public WireFrameSchemaInfo() {
        this(null, null, null, null, null, null, 0, 0, 0, null, null, null, 0.0f, 0, 16383, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WireFrameSchemaInfo copy$default(WireFrameSchemaInfo r110, Float r111, List r112, String r113, String r114, String r210, String r211, int r212, int r213, int r214, String r215, Float r216, String r217, float r218, int r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        Float r100 = r110.mainPicScale;
    L7:
        if ((r310 & 2) == 0) goto L9;
        List r101 = r110.category;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.mainPicUrl;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r110.mainPic11Url;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.mainPic34Url;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.guidePic34Url;
    L27:
        if ((r310 & 64) == 0) goto L29;
        int r106 = r110.mainPic34Count;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r107 = r110.isAbMatch;
    L35:
        if ((r310 & 256) == 0) goto L37;
        int r115 = r110.halPdpOptimizeStyle;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r116 = r110.insertPicUrl;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Float r117 = r110.insertPicScale;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r118 = r110.insertPicUri;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        float r119 = r110.halfPdpHeadScaleParam;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        int r108 = r110.halPdpHeadSpace;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public final Float component1() {
        return this.mainPicScale;
    }

    public final String component10() {
        return this.insertPicUrl;
    }

    public final Float component11() {
        return this.insertPicScale;
    }

    public final String component12() {
        return this.insertPicUri;
    }

    public final float component13() {
        return this.halfPdpHeadScaleParam;
    }

    public final int component14() {
        return this.halPdpHeadSpace;
    }

    public final List<Integer> component2() {
        return this.category;
    }

    public final String component3() {
        return this.mainPicUrl;
    }

    public final String component4() {
        return this.mainPic11Url;
    }

    public final String component5() {
        return this.mainPic34Url;
    }

    public final String component6() {
        return this.guidePic34Url;
    }

    public final int component7() {
        return this.mainPic34Count;
    }

    public final int component8() {
        return this.isAbMatch;
    }

    public final int component9() {
        return this.halPdpOptimizeStyle;
    }

    public final WireFrameSchemaInfo copy(Float r110, List<Integer> r111, String r112, String r210, String r211, String r212, int r213, int r214, int r215, String r216, Float r217, String r218, float r219, int r310) {
        return new WireFrameSchemaInfo(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WireFrameSchemaInfo) == false) goto L34;
        WireFrameSchemaInfo r101 = (WireFrameSchemaInfo) r100;
        if (Intrinsics.areEqual(this.mainPicScale, r101.mainPicScale) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.category, r101.category) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mainPicUrl, r101.mainPicUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mainPic11Url, r101.mainPic11Url) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.mainPic34Url, r101.mainPic34Url) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.guidePic34Url, r101.guidePic34Url) == true) goto L18;
        return false;
    L18:
        if (this.mainPic34Count == r101.mainPic34Count) goto L20;
        return false;
    L20:
        if (this.isAbMatch == r101.isAbMatch) goto L22;
        return false;
    L22:
        if (this.halPdpOptimizeStyle == r101.halPdpOptimizeStyle) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.insertPicUrl, r101.insertPicUrl) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.insertPicScale, r101.insertPicScale) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.insertPicUri, r101.insertPicUri) == true) goto L30;
        return false;
    L30:
        if (Float.compare(this.halfPdpHeadScaleParam, r101.halfPdpHeadScaleParam) == 0) goto L32;
        return false;
    L32:
        if (this.halPdpHeadSpace == r101.halPdpHeadSpace) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public int hashCode() {
        Float r100 = this.mainPicScale;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.category;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.mainPicUrl;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mainPic11Url;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.mainPic34Url;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.guidePic34Url;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (((((((r115 + r117) * 31) + this.mainPic34Count) * 31) + this.isAbMatch) * 31) + this.halPdpOptimizeStyle) * 31;
        String r119 = this.insertPicUrl;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.insertPicScale;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.insertPicUri;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return ((((r124 + r101) * 31) + Float.floatToIntBits(this.halfPdpHeadScaleParam)) * 31) + this.halPdpHeadSpace;
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
        return "WireFrameSchemaInfo(mainPicScale=" + this.mainPicScale + ", category=" + this.category + ", mainPicUrl=" + this.mainPicUrl + ", mainPic11Url=" + this.mainPic11Url + ", mainPic34Url=" + this.mainPic34Url + ", guidePic34Url=" + this.guidePic34Url + ", mainPic34Count=" + this.mainPic34Count + ", isAbMatch=" + this.isAbMatch + ", halPdpOptimizeStyle=" + this.halPdpOptimizeStyle + ", insertPicUrl=" + this.insertPicUrl + ", insertPicScale=" + this.insertPicScale + ", insertPicUri=" + this.insertPicUri + ", halfPdpHeadScaleParam=" + this.halfPdpHeadScaleParam + ", halPdpHeadSpace=" + this.halPdpHeadSpace + ")";
    }

    public final String getPreferMainPicUrl() {
        String r100 = this.mainPic11Url;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.mainPicUrl;
    }

    public final List<Integer> getCategory() {
        return this.category;
    }

    public final String getGuidePic34Url() {
        return this.guidePic34Url;
    }

    public final int getHalPdpHeadSpace() {
        return this.halPdpHeadSpace;
    }

    public final int getHalPdpOptimizeStyle() {
        return this.halPdpOptimizeStyle;
    }

    public final float getHalfPdpHeadScaleParam() {
        return this.halfPdpHeadScaleParam;
    }

    public final Float getInsertPicScale() {
        return this.insertPicScale;
    }

    public final String getInsertPicUri() {
        return this.insertPicUri;
    }

    public final String getInsertPicUrl() {
        return this.insertPicUrl;
    }

    public final String getMainPic11Url() {
        return this.mainPic11Url;
    }

    public final int getMainPic34Count() {
        return this.mainPic34Count;
    }

    public final String getMainPic34Url() {
        return this.mainPic34Url;
    }

    public final Float getMainPicScale() {
        return this.mainPicScale;
    }

    public final String getMainPicUrl() {
        return this.mainPicUrl;
    }

    public final int isAbMatch() {
        return this.isAbMatch;
    }

    public final void setAbMatch(int r100) {
        this.isAbMatch = r100;
    }

    public final void setHalPdpHeadSpace(int r100) {
        this.halPdpHeadSpace = r100;
    }

    public final void setHalPdpOptimizeStyle(int r100) {
        this.halPdpOptimizeStyle = r100;
    }

    public final void setHalfPdpHeadScaleParam(float r100) {
        this.halfPdpHeadScaleParam = r100;
    }

    public WireFrameSchemaInfo(Float r100, List<Integer> r101, String r102, String r103, String r104, String r105, int r106, int r107, int r108, String r110, Float r111, String r112, float r113, int r114) {
        this.mainPicScale = r100;
        this.category = r101;
        this.mainPicUrl = r102;
        this.mainPic11Url = r103;
        this.mainPic34Url = r104;
        this.guidePic34Url = r105;
        this.mainPic34Count = r106;
        this.isAbMatch = r107;
        this.halPdpOptimizeStyle = r108;
        this.insertPicUrl = r110;
        this.insertPicScale = r111;
        this.insertPicUri = r112;
        this.halfPdpHeadScaleParam = r113;
        this.halPdpHeadSpace = r114;
    }

    public /* synthetic */ WireFrameSchemaInfo(Float r110, List r111, String r112, String r113, String r210, String r211, int r212, int r213, int r214, String r215, Float r216, String r217, float r218, int r219, int r310, DefaultConstructorMarker r311) {
        String r100 = null;
        if ((r310 & 1) == 0) goto L5;
        Float r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r106 = null;
    L26:
        int r107 = 0;
        if ((r310 & 64) == 0) goto L29;
        int r108 = 0;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r114 = 0;
    L35:
        if ((r310 & 256) == 0) goto L37;
        int r115 = 0;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Float r117 = null;
    L47:
        if ((r310 & 2048) != 0) goto L51;
        r100 = r217;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        float r118 = 0.0f;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r107 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r108, r114, r115, r116, r117, r100, r118, r107);
        return;
    L53:
        r118 = r218;
        goto L55
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r114 = r213;
        goto L35
    L29:
        r108 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L26
    L21:
        r105 = r210;
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
