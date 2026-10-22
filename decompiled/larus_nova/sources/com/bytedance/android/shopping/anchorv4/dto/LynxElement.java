package com.bytedance.android.shopping.anchorv4.dto;

import com.bytedance.android.shopping.anchorv4.dto.adapter.JsonToStringAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B±\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0016Jº\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u00108\u001a\u00020\rHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b%\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001b¨\u0006:"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/LynxElement;", "Ljava/io/Serializable;", "schema", "", "megaData", "queryData", "", "", "width", "Lcom/bytedance/android/shopping/anchorv4/dto/ComponentSize;", "height", "lynxId", "bottomMargin", "", "leftMargin", "rightMargin", "location", "topMargin", "config", "Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/dto/ComponentSize;Lcom/bytedance/android/shopping/anchorv4/dto/ComponentSize;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;)V", "getBottomMargin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;", "getHeight", "()Lcom/bytedance/android/shopping/anchorv4/dto/ComponentSize;", "getLeftMargin", "getLocation", "()Ljava/util/Map;", "getLynxId", "()Ljava/lang/String;", "getMegaData", "getQueryData", "getRightMargin", "getSchema", "getTopMargin", "getWidth", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/dto/ComponentSize;Lcom/bytedance/android/shopping/anchorv4/dto/ComponentSize;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;)Lcom/bytedance/android/shopping/anchorv4/dto/LynxElement;", "equals", "", "other", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxElement implements Serializable {

    @SerializedName("bottom_margin")
    private final Integer bottomMargin;

    @SerializedName("config")
    private final ConfigModel config;

    @SerializedName("height")
    private final ComponentSize height;

    @SerializedName("left_margin")
    private final Integer leftMargin;

    @SerializedName("location")
    private final Map<String, Object> location;

    @SerializedName("lynx_id")
    private final String lynxId;

    @SerializedName("mega_data")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String megaData;

    @SerializedName("query_data")
    private final Map<String, Object> queryData;

    @SerializedName("right_margin")
    private final Integer rightMargin;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("top_margin")
    private final Integer topMargin;

    @SerializedName("width")
    private final ComponentSize width;

    public LynxElement() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxElement copy$default(LynxElement r110, String r111, String r112, Map r113, ComponentSize r114, ComponentSize r115, String r116, Integer r210, Integer r211, Integer r212, Map r213, Integer r214, ConfigModel r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.schema;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.megaData;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Map r102 = r110.queryData;
    L15:
        if ((r216 & 8) == 0) goto L17;
        ComponentSize r103 = r110.width;
    L19:
        if ((r216 & 16) == 0) goto L21;
        ComponentSize r104 = r110.height;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.lynxId;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Integer r106 = r110.bottomMargin;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Integer r107 = r110.leftMargin;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Integer r117 = r110.rightMargin;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Map r118 = r110.location;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        Integer r119 = r110.topMargin;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        ConfigModel r108 = r110.config;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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
        return this.schema;
    }

    public final Map<String, Object> component10() {
        return this.location;
    }

    public final Integer component11() {
        return this.topMargin;
    }

    public final ConfigModel component12() {
        return this.config;
    }

    public final String component2() {
        return this.megaData;
    }

    public final Map<String, Object> component3() {
        return this.queryData;
    }

    public final ComponentSize component4() {
        return this.width;
    }

    public final ComponentSize component5() {
        return this.height;
    }

    public final String component6() {
        return this.lynxId;
    }

    public final Integer component7() {
        return this.bottomMargin;
    }

    public final Integer component8() {
        return this.leftMargin;
    }

    public final Integer component9() {
        return this.rightMargin;
    }

    public final LynxElement copy(String r110, String r111, Map<String, ? extends Object> r112, ComponentSize r113, ComponentSize r114, String r210, Integer r211, Integer r212, Integer r213, Map<String, ? extends Object> r214, Integer r215, ConfigModel r216) {
        return new LynxElement(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LynxElement) == false) goto L30;
        LynxElement r101 = (LynxElement) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.megaData, r101.megaData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.queryData, r101.queryData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.lynxId, r101.lynxId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bottomMargin, r101.bottomMargin) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.leftMargin, r101.leftMargin) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.rightMargin, r101.rightMargin) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.location, r101.location) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.topMargin, r101.topMargin) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.megaData;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.queryData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ComponentSize r110 = this.width;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ComponentSize r113 = this.height;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.lynxId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.bottomMargin;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.leftMargin;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.rightMargin;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, Object> r128 = this.location;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.topMargin;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        ConfigModel r134 = this.config;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
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
        return "LynxElement(schema=" + this.schema + ", megaData=" + this.megaData + ", queryData=" + this.queryData + ", width=" + this.width + ", height=" + this.height + ", lynxId=" + this.lynxId + ", bottomMargin=" + this.bottomMargin + ", leftMargin=" + this.leftMargin + ", rightMargin=" + this.rightMargin + ", location=" + this.location + ", topMargin=" + this.topMargin + ", config=" + this.config + ")";
    }

    public final Integer getBottomMargin() {
        return this.bottomMargin;
    }

    public final ConfigModel getConfig() {
        return this.config;
    }

    public final ComponentSize getHeight() {
        return this.height;
    }

    public final Integer getLeftMargin() {
        return this.leftMargin;
    }

    public final Map<String, Object> getLocation() {
        return this.location;
    }

    public final String getLynxId() {
        return this.lynxId;
    }

    public final String getMegaData() {
        return this.megaData;
    }

    public final Map<String, Object> getQueryData() {
        return this.queryData;
    }

    public final Integer getRightMargin() {
        return this.rightMargin;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Integer getTopMargin() {
        return this.topMargin;
    }

    public final ComponentSize getWidth() {
        return this.width;
    }

    public LynxElement(String r100, String r101, Map<String, ? extends Object> r102, ComponentSize r103, ComponentSize r104, String r105, Integer r106, Integer r107, Integer r108, Map<String, ? extends Object> r110, Integer r111, ConfigModel r112) {
        this.schema = r100;
        this.megaData = r101;
        this.queryData = r102;
        this.width = r103;
        this.height = r104;
        this.lynxId = r105;
        this.bottomMargin = r106;
        this.leftMargin = r107;
        this.rightMargin = r108;
        this.location = r110;
        this.topMargin = r111;
        this.config = r112;
    }

    public /* synthetic */ LynxElement(String r110, String r111, Map r112, ComponentSize r113, ComponentSize r114, String r115, Integer r210, Integer r211, Integer r212, Map r213, Integer r214, ConfigModel r215, int r216, DefaultConstructorMarker r217) {
        ConfigModel r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Map r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        ComponentSize r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        ComponentSize r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Integer r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Map r117 = null;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        Integer r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
