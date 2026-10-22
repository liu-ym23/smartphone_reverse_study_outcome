package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010(\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009a\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0012HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017¨\u00068"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/ProductFormat;", "Ljava/io/Serializable;", "name", "", "message", "", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/AttrItem;", "logo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "picUrls", PerfLog.PARAM_KEY_CONTEXT_ID, "type", "pageTitle", "certificationIcon", "certificationUrl", "newDesign", "", "maxLines", "", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getCertificationIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getCertificationUrl", "()Ljava/lang/String;", "getContext", "getLogo", "getMaxLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/util/List;", "getName", "getNewDesign", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPageTitle", "getPicUrls", "getType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv3/repository/dto/ProductFormat;", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFormat implements Serializable {

    @SerializedName("certification_icon")
    private final ECUrlModel certificationIcon;

    @SerializedName("certification_url")
    private final String certificationUrl;

    @SerializedName(PerfLog.PARAM_KEY_CONTEXT_ID)
    private final String context;

    @SerializedName("logo")
    private final ECUrlModel logo;

    @SerializedName("max_lines")
    private final Integer maxLines;

    @SerializedName("message")
    private final List<AttrItem> message;

    @SerializedName("name")
    private final String name;

    @SerializedName("new_design")
    private final Boolean newDesign;

    @SerializedName("page_title")
    private final String pageTitle;

    @SerializedName("pic_urls")
    private final List<ECUrlModel> picUrls;

    @SerializedName("type")
    private final String type;

    public ProductFormat() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductFormat copy$default(ProductFormat r110, String r111, List r112, ECUrlModel r113, List r114, String r115, String r116, String r117, ECUrlModel r210, String r211, Boolean r212, Integer r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.name;
    L7:
        if ((r214 & 2) == 0) goto L9;
        List r101 = r110.message;
    L11:
        if ((r214 & 4) == 0) goto L13;
        ECUrlModel r102 = r110.logo;
    L15:
        if ((r214 & 8) == 0) goto L17;
        List r103 = r110.picUrls;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.context;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.type;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.pageTitle;
    L31:
        if ((r214 & 128) == 0) goto L33;
        ECUrlModel r107 = r110.certificationIcon;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.certificationUrl;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Boolean r119 = r110.newDesign;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Integer r108 = r110.maxLines;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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
        return this.name;
    }

    public final Boolean component10() {
        return this.newDesign;
    }

    public final Integer component11() {
        return this.maxLines;
    }

    public final List<AttrItem> component2() {
        return this.message;
    }

    public final ECUrlModel component3() {
        return this.logo;
    }

    public final List<ECUrlModel> component4() {
        return this.picUrls;
    }

    public final String component5() {
        return this.context;
    }

    public final String component6() {
        return this.type;
    }

    public final String component7() {
        return this.pageTitle;
    }

    public final ECUrlModel component8() {
        return this.certificationIcon;
    }

    public final String component9() {
        return this.certificationUrl;
    }

    public final ProductFormat copy(String r110, List<AttrItem> r111, ECUrlModel r112, List<? extends ECUrlModel> r113, String r114, String r115, String r210, ECUrlModel r211, String r212, Boolean r213, Integer r214) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "message");
        return new ProductFormat(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductFormat) == false) goto L28;
        ProductFormat r101 = (ProductFormat) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.logo, r101.logo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picUrls, r101.picUrls) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pageTitle, r101.pageTitle) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.certificationIcon, r101.certificationIcon) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.certificationUrl, r101.certificationUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.newDesign, r101.newDesign) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.maxLines, r101.maxLines) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<AttrItem> r104 = this.message;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.logo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<ECUrlModel> r110 = this.picUrls;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.context;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.type;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.pageTitle;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ECUrlModel r122 = this.certificationIcon;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.certificationUrl;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.newDesign;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.maxLines;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
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
        return "ProductFormat(name=" + this.name + ", message=" + this.message + ", logo=" + this.logo + ", picUrls=" + this.picUrls + ", context=" + this.context + ", type=" + this.type + ", pageTitle=" + this.pageTitle + ", certificationIcon=" + this.certificationIcon + ", certificationUrl=" + this.certificationUrl + ", newDesign=" + this.newDesign + ", maxLines=" + this.maxLines + ")";
    }

    public final ECUrlModel getCertificationIcon() {
        return this.certificationIcon;
    }

    public final String getCertificationUrl() {
        return this.certificationUrl;
    }

    public final String getContext() {
        return this.context;
    }

    public final ECUrlModel getLogo() {
        return this.logo;
    }

    public final Integer getMaxLines() {
        return this.maxLines;
    }

    public final List<AttrItem> getMessage() {
        return this.message;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getNewDesign() {
        return this.newDesign;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final List<ECUrlModel> getPicUrls() {
        return this.picUrls;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProductFormat(String r100, List<AttrItem> r101, ECUrlModel r102, List<? extends ECUrlModel> r103, String r104, String r105, String r106, ECUrlModel r107, String r110, Boolean r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.name = r100;
        this.message = r101;
        this.logo = r102;
        this.picUrls = r103;
        this.context = r104;
        this.type = r105;
        this.pageTitle = r106;
        this.certificationIcon = r107;
        this.certificationUrl = r110;
        this.newDesign = r111;
        this.maxLines = r112;
    }

    public /* synthetic */ ProductFormat(String r110, List r111, ECUrlModel r112, List r113, String r114, String r115, String r116, ECUrlModel r210, String r211, Boolean r212, Integer r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r214 & 2) == 0) goto L9;
        List r101 = CollectionsKt.emptyList();
    L10:
        Integer r102 = null;
        if ((r214 & 4) == 0) goto L13;
        ECUrlModel r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        ECUrlModel r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Boolean r118 = Boolean.FALSE;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r102 = r213;
    L46:
        this(r100, r101, r103, r104, r105, r106, r107, r108, r117, r118, r102);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
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
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
