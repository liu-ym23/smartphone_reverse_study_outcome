package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\t\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;", "Ljava/io/Serializable;", "specLocation", "", "sizeComponent", "Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "hasSizeComponent", "", "isFillUserClothesSize", "isSupportClothesSizeRecommend", "recommendClothesSize", "", "linkSchema", "abTest", "recommendText", "(Ljava/lang/Integer;Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAbTest", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasSizeComponent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLinkSchema", "()Ljava/lang/String;", "getRecommendClothesSize", "getRecommendText", "getSizeComponent", "()Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "getSpecLocation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;", "equals", "other", "", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClothesSizeAssistantStruct implements Serializable {

    @SerializedName(BaseHttpRequestInfo.KEY_ABTEST)
    private final Integer abTest;

    @SerializedName("has_size_component")
    private final Boolean hasSizeComponent;

    @SerializedName("is_fill_user_clothes_size")
    private final Boolean isFillUserClothesSize;

    @SerializedName("is_support_clothes_size_recommend")
    private final Boolean isSupportClothesSizeRecommend;

    @SerializedName("link_schema")
    private final String linkSchema;

    @SerializedName("recommend_clothes_size")
    private final String recommendClothesSize;

    @SerializedName("recommend_text")
    private final String recommendText;

    @SerializedName("size_component")
    private final SpecChartStruct sizeComponent;

    @SerializedName("spec_location")
    private final Integer specLocation;

    public ClothesSizeAssistantStruct() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ ClothesSizeAssistantStruct copy$default(ClothesSizeAssistantStruct r110, Integer r111, SpecChartStruct r112, Boolean r113, Boolean r114, Boolean r115, String r116, String r117, Integer r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Integer r100 = r110.specLocation;
    L7:
        if ((r210 & 2) == 0) goto L9;
        SpecChartStruct r101 = r110.sizeComponent;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Boolean r102 = r110.hasSizeComponent;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Boolean r103 = r110.isFillUserClothesSize;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Boolean r104 = r110.isSupportClothesSizeRecommend;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.recommendClothesSize;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.linkSchema;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r107 = r110.abTest;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.recommendText;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
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

    public final Integer component1() {
        return this.specLocation;
    }

    public final SpecChartStruct component2() {
        return this.sizeComponent;
    }

    public final Boolean component3() {
        return this.hasSizeComponent;
    }

    public final Boolean component4() {
        return this.isFillUserClothesSize;
    }

    public final Boolean component5() {
        return this.isSupportClothesSizeRecommend;
    }

    public final String component6() {
        return this.recommendClothesSize;
    }

    public final String component7() {
        return this.linkSchema;
    }

    public final Integer component8() {
        return this.abTest;
    }

    public final String component9() {
        return this.recommendText;
    }

    public final ClothesSizeAssistantStruct copy(Integer r110, SpecChartStruct r111, Boolean r112, Boolean r113, Boolean r114, String r115, String r116, Integer r117, String r210) {
        return new ClothesSizeAssistantStruct(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ClothesSizeAssistantStruct) == false) goto L24;
        ClothesSizeAssistantStruct r101 = (ClothesSizeAssistantStruct) r100;
        if (Intrinsics.areEqual(this.specLocation, r101.specLocation) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sizeComponent, r101.sizeComponent) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.hasSizeComponent, r101.hasSizeComponent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isFillUserClothesSize, r101.isFillUserClothesSize) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isSupportClothesSizeRecommend, r101.isSupportClothesSizeRecommend) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.recommendClothesSize, r101.recommendClothesSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.linkSchema, r101.linkSchema) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.abTest, r101.abTest) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.recommendText, r101.recommendText) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.specLocation;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        SpecChartStruct r104 = this.sizeComponent;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.hasSizeComponent;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isFillUserClothesSize;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isSupportClothesSizeRecommend;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.recommendClothesSize;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.linkSchema;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.abTest;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.recommendText;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
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
        return "ClothesSizeAssistantStruct(specLocation=" + this.specLocation + ", sizeComponent=" + this.sizeComponent + ", hasSizeComponent=" + this.hasSizeComponent + ", isFillUserClothesSize=" + this.isFillUserClothesSize + ", isSupportClothesSizeRecommend=" + this.isSupportClothesSizeRecommend + ", recommendClothesSize=" + this.recommendClothesSize + ", linkSchema=" + this.linkSchema + ", abTest=" + this.abTest + ", recommendText=" + this.recommendText + ")";
    }

    public final Integer getAbTest() {
        return this.abTest;
    }

    public final Boolean getHasSizeComponent() {
        return this.hasSizeComponent;
    }

    public final String getLinkSchema() {
        return this.linkSchema;
    }

    public final String getRecommendClothesSize() {
        return this.recommendClothesSize;
    }

    public final String getRecommendText() {
        return this.recommendText;
    }

    public final SpecChartStruct getSizeComponent() {
        return this.sizeComponent;
    }

    public final Integer getSpecLocation() {
        return this.specLocation;
    }

    public final Boolean isFillUserClothesSize() {
        return this.isFillUserClothesSize;
    }

    public final Boolean isSupportClothesSizeRecommend() {
        return this.isSupportClothesSizeRecommend;
    }

    public ClothesSizeAssistantStruct(Integer r100, SpecChartStruct r101, Boolean r102, Boolean r103, Boolean r104, String r105, String r106, Integer r107, String r108) {
        this.specLocation = r100;
        this.sizeComponent = r101;
        this.hasSizeComponent = r102;
        this.isFillUserClothesSize = r103;
        this.isSupportClothesSizeRecommend = r104;
        this.recommendClothesSize = r105;
        this.linkSchema = r106;
        this.abTest = r107;
        this.recommendText = r108;
    }

    public /* synthetic */ ClothesSizeAssistantStruct(Integer r110, SpecChartStruct r111, Boolean r112, Boolean r113, Boolean r114, String r115, String r116, Integer r117, String r118, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        SpecChartStruct r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Boolean r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Boolean r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Boolean r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
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
