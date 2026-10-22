package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0015Jv\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u000eHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/ProductFormat;", "Ljava/io/Serializable;", "name", "", "message", "", "Lcom/bytedance/android/shopping/feed/repository/dto/AttrItem;", "logo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "picUrls", PerfLog.PARAM_KEY_CONTEXT_ID, "type", "pageTitle", "maxLines", "", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContext", "()Ljava/lang/String;", "getLogo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getMaxLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/util/List;", "getName", "getPageTitle", "getPicUrls", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/feed/repository/dto/ProductFormat;", "equals", "", "other", "", "hashCode", "toString", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFormat implements Serializable {

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

    @SerializedName("page_title")
    private final String pageTitle;

    @SerializedName("pic_urls")
    private final List<ECUrlModel> picUrls;

    @SerializedName("type")
    private final String type;

    public ProductFormat() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductFormat copy$default(ProductFormat r100, String r110, List r111, ECUrlModel r112, List r113, String r114, String r115, String r116, Integer r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.name;
    L7:
        if ((r118 & 2) == 0) goto L9;
        List r102 = r100.message;
    L11:
        if ((r118 & 4) == 0) goto L13;
        ECUrlModel r103 = r100.logo;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = r100.picUrls;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.context;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.type;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.pageTitle;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Integer r108 = r100.maxLines;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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

    public final String component1() {
        return this.name;
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

    public final Integer component8() {
        return this.maxLines;
    }

    public final ProductFormat copy(String r110, List<AttrItem> r111, ECUrlModel r112, List<? extends ECUrlModel> r113, String r114, String r115, String r116, Integer r117) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "message");
        return new ProductFormat(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductFormat) == false) goto L22;
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
        if (Intrinsics.areEqual(this.maxLines, r101.maxLines) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
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
        Integer r122 = this.maxLines;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
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
        return "ProductFormat(name=" + this.name + ", message=" + this.message + ", logo=" + this.logo + ", picUrls=" + this.picUrls + ", context=" + this.context + ", type=" + this.type + ", pageTitle=" + this.pageTitle + ", maxLines=" + this.maxLines + ")";
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
    public ProductFormat(String r100, List<AttrItem> r101, ECUrlModel r102, List<? extends ECUrlModel> r103, String r104, String r105, String r106, Integer r107) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.name = r100;
        this.message = r101;
        this.logo = r102;
        this.picUrls = r103;
        this.context = r104;
        this.type = r105;
        this.pageTitle = r106;
        this.maxLines = r107;
    }

    public /* synthetic */ ProductFormat(String r110, List r111, ECUrlModel r112, List r113, String r114, String r115, String r116, Integer r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        List r101 = CollectionsKt.emptyList();
    L10:
        Integer r102 = null;
        if ((r118 & 4) == 0) goto L13;
        ECUrlModel r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r102 = r117;
    L34:
        this(r100, r101, r103, r104, r105, r106, r107, r102);
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
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
