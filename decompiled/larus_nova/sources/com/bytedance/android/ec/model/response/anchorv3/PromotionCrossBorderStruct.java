package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0003!\"#B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014¨\u0006$"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct;", "Ljava/io/Serializable;", "", "customsClearType", "Ljava/lang/Integer;", "getCustomsClearType", "()Ljava/lang/Integer;", "Lcom/bytedance/android/ec/model/response/anchorv3/CountryItemStruct;", "brandCountry", "Lcom/bytedance/android/ec/model/response/anchorv3/CountryItemStruct;", "getBrandCountry", "()Lcom/bytedance/android/ec/model/response/anchorv3/CountryItemStruct;", "sourceCountry", "getSourceCountry", "priceHasTax", "getPriceHasTax", "", "taxText", "Ljava/lang/String;", "getTaxText", "()Ljava/lang/String;", "wareHouseName", "getWareHouseName", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct$TaxDescribeStruct;", "taxDescribe", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct$TaxDescribeStruct;", "getTaxDescribe", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct$TaxDescribeStruct;", "originPlaceText", "getOriginPlaceText", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "TaxDescItemStruct", "TaxDescribeStruct", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionCrossBorderStruct implements Serializable {
    public static final String CLEAR_BBC_TYPE = "BBC";
    public static final String CLEAR_BC_TYPE = "BC";
    public static final String CLEAR_CC_TYPE = "CC";
    public static final int CLEAR_TYPE_BBC = 1;
    public static final int CLEAR_TYPE_BC = 2;
    public static final int CLEAR_TYPE_CC = 3;
    public static final a Companion = null;
    public static final int PRICE_HAS_TAX = 1;
    public static final int PRICE_NOT_HAS_TAX = 2;

    @SerializedName("brand_country")
    private final CountryItemStruct brandCountry;

    @SerializedName("customs_clear_type")
    private final Integer customsClearType;

    @SerializedName("origin_place_text")
    private final String originPlaceText;

    @SerializedName("price_has_tax")
    private final Integer priceHasTax;

    @SerializedName("source_country")
    private final CountryItemStruct sourceCountry;

    @SerializedName("tax_describe")
    private final TaxDescribeStruct taxDescribe;

    @SerializedName("tax_text")
    private final String taxText;

    @SerializedName("warehouse_name")
    private final String wareHouseName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct$TaxDescItemStruct;", "Ljava/io/Serializable;", "type", "", "content", "", "url", "urlContent", "title", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getTitle", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "getUrlContent", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct$TaxDescItemStruct;", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class TaxDescItemStruct implements Serializable {

        @SerializedName("content")
        private final String content;

        @SerializedName("title")
        private final String title;

        @SerializedName("type")
        private final Integer type;

        @SerializedName("url")
        private final String url;

        @SerializedName("url_content")
        private final String urlContent;

        public TaxDescItemStruct() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ TaxDescItemStruct copy$default(TaxDescItemStruct r100, Integer r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.type;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.content;
        L8:
            String r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.url;
        L11:
            String r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.urlContent;
        L14:
            String r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.title;
        L17:
            Integer r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final Integer component1() {
            return this.type;
        }

        public final String component2() {
            return this.content;
        }

        public final String component3() {
            return this.url;
        }

        public final String component4() {
            return this.urlContent;
        }

        public final String component5() {
            return this.title;
        }

        public final TaxDescItemStruct copy(Integer r100, String r101, String r110, String r111, String r112) {
            return new TaxDescItemStruct(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof TaxDescItemStruct) == false) goto L16;
            TaxDescItemStruct r101 = (TaxDescItemStruct) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.urlContent, r101.urlContent) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            Integer r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.content;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.url;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.urlContent;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.title;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
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
            return "TaxDescItemStruct(type=" + this.type + ", content=" + this.content + ", url=" + this.url + ", urlContent=" + this.urlContent + ", title=" + this.title + ")";
        }

        public final String getContent() {
            return this.content;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Integer getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getUrlContent() {
            return this.urlContent;
        }

        public TaxDescItemStruct(Integer r100, String r101, String r102, String r103, String r104) {
            this.type = r100;
            this.content = r101;
            this.url = r102;
            this.urlContent = r103;
            this.title = r104;
        }

        public /* synthetic */ TaxDescItemStruct(Integer r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L5;
            Integer r112 = null;
        L7:
            if ((r110 & 2) == 0) goto L9;
            String r105 = null;
        L11:
            if ((r110 & 4) == 0) goto L13;
            String r106 = null;
        L15:
            if ((r110 & 8) == 0) goto L17;
            String r107 = null;
        L19:
            if ((r110 & 16) == 0) goto L21;
            String r113 = null;
        L22:
            this(r112, r105, r106, r107, r113);
            return;
        L21:
            r113 = r104;
            goto L22
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
            r112 = r100;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct$TaxDescribeStruct;", "Ljava/io/Serializable;", "()V", "describe", "", "getDescribe", "()Ljava/lang/String;", "has_tax_text", "getHas_tax_text", "taxDescItems", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct$TaxDescItemStruct;", "getTaxDescItems", "()Ljava/util/List;", "title", "getTitle", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class TaxDescribeStruct implements Serializable {

        @SerializedName("describe")
        private final String describe;

        @SerializedName("has_tax_text")
        private final String has_tax_text;

        @SerializedName("tax_desc_item")
        private final List<TaxDescItemStruct> taxDescItems;

        @SerializedName("title")
        private final String title;

        public TaxDescribeStruct() {
        }

        public final String getDescribe() {
            return this.describe;
        }

        public final String getHas_tax_text() {
            return this.has_tax_text;
        }

        public final List<TaxDescItemStruct> getTaxDescItems() {
            return this.taxDescItems;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionCrossBorderStruct() {
    }

    public final CountryItemStruct getBrandCountry() {
        return this.brandCountry;
    }

    public final Integer getCustomsClearType() {
        return this.customsClearType;
    }

    public final String getOriginPlaceText() {
        return this.originPlaceText;
    }

    public final Integer getPriceHasTax() {
        return this.priceHasTax;
    }

    public final CountryItemStruct getSourceCountry() {
        return this.sourceCountry;
    }

    public final TaxDescribeStruct getTaxDescribe() {
        return this.taxDescribe;
    }

    public final String getTaxText() {
        return this.taxText;
    }

    public final String getWareHouseName() {
        return this.wareHouseName;
    }
}
