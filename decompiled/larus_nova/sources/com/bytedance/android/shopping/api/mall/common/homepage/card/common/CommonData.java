package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import androidx.compose.ui.spatial.RectListKt;
import androidx.core.provider.FontsContractCompat;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001:\u000f\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData;", "", "()V", "Ad", "CardCommon", "CoinData", "ElementStyle", "Extra", "Impression", "InstantRecommendData", "MarketingData", "PriceCommon", "PriceContent", "Product", "Store", "UrlStruct", "User", "WindVaneEventData", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonData {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Ad;", "", "id", "", "showAdTag", "", "RowData", "", "RawData", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getRawData", "()Ljava/lang/String;", "getRowData", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowAdTag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Ad;", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Ad {

        @SerializedName(EventConstant.Key.RAW_DATA)
        private final String RawData;

        @SerializedName("row_data")
        private final String RowData;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private final Integer f170280id;

        @SerializedName("show_ad_tag")
        private final Boolean showAdTag;

        public Ad() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Ad copy$default(Ad r100, Integer r101, Boolean r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.f170280id;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.showAdTag;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.RowData;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.RawData;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final Integer component1() {
            return this.f170280id;
        }

        public final Boolean component2() {
            return this.showAdTag;
        }

        public final String component3() {
            return this.RowData;
        }

        public final String component4() {
            return this.RawData;
        }

        public final Ad copy(Integer r100, Boolean r101, String r102, String r103) {
            return new Ad(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Ad) == false) goto L14;
            Ad r101 = (Ad) r100;
            if (Intrinsics.areEqual(this.f170280id, r101.f170280id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.showAdTag, r101.showAdTag) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.RowData, r101.RowData) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.RawData, r101.RawData) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            Integer r100 = this.f170280id;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.showAdTag;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.RowData;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.RawData;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
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
            return "Ad(id=" + this.f170280id + ", showAdTag=" + this.showAdTag + ", RowData=" + this.RowData + ", RawData=" + this.RawData + ")";
        }

        public final Integer getId() {
            return this.f170280id;
        }

        public final String getRawData() {
            return this.RawData;
        }

        public final String getRowData() {
            return this.RowData;
        }

        public final Boolean getShowAdTag() {
            return this.showAdTag;
        }

        public Ad(Integer r100, Boolean r101, String r102, String r103) {
            this.f170280id = r100;
            this.showAdTag = r101;
            this.RowData = r102;
            this.RawData = r103;
        }

        public /* synthetic */ Ad(Integer r100, Boolean r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;", "", "resourceId", "", "(Ljava/lang/String;)V", "getResourceId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CardCommon {

        @SerializedName("resource_id")
        private final String resourceId;

        /* JADX WARN: Multi-variable type inference failed */
        public CardCommon() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CardCommon copy$default(CardCommon r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.resourceId;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.resourceId;
        }

        public final CardCommon copy(String r100) {
            return new CardCommon(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof CardCommon) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.resourceId, ((CardCommon) r100).resourceId) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.resourceId;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "CardCommon(resourceId=" + this.resourceId + ")";
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public CardCommon(String r100) {
            this.resourceId = r100;
        }

        public /* synthetic */ CardCommon(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "", "coinLynxSchema", "", "coinLynxHeight", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCoinLynxHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCoinLynxSchema", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CoinData {

        @SerializedName("coin_lynx_height")
        private final Integer coinLynxHeight;

        @SerializedName("coin_lynx_schema")
        private final String coinLynxSchema;

        /* JADX WARN: Multi-variable type inference failed */
        public CoinData() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CoinData copy$default(CoinData r100, String r101, Integer r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.coinLynxSchema;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.coinLynxHeight;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.coinLynxSchema;
        }

        public final Integer component2() {
            return this.coinLynxHeight;
        }

        public final CoinData copy(String r100, Integer r101) {
            return new CoinData(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof CoinData) == false) goto L10;
            CoinData r101 = (CoinData) r100;
            if (Intrinsics.areEqual(this.coinLynxSchema, r101.coinLynxSchema) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.coinLynxHeight, r101.coinLynxHeight) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.coinLynxSchema;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.coinLynxHeight;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "CoinData(coinLynxSchema=" + this.coinLynxSchema + ", coinLynxHeight=" + this.coinLynxHeight + ")";
        }

        public final Integer getCoinLynxHeight() {
            return this.coinLynxHeight;
        }

        public final String getCoinLynxSchema() {
            return this.coinLynxSchema;
        }

        public CoinData(String r100, Integer r101) {
            this.coinLynxSchema = r100;
            this.coinLynxHeight = r101;
        }

        public /* synthetic */ CoinData(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\bQ\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0005{|}~\u007fBõ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u0019¢\u0006\u0002\u0010*J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010;J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010^\u001a\u00020\u0019HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0002\u00105J\t\u0010m\u001a\u00020\u0019HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jþ\u0002\u0010t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u0019HÆ\u0001¢\u0006\u0002\u0010uJ\u0013\u0010v\u001a\u00020\u00192\b\u0010w\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010x\u001a\u00020(HÖ\u0001J\t\u0010y\u001a\u00020zHÖ\u0001R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0018\u0010 \u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u001a\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0016\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010,R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010,R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010/R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010,R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010,R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010/R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0018\u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010,R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010>R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010,R\u0016\u0010)\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00108R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010/R\u0018\u0010%\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010,R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010/R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010>¨\u0006\u0080\u0001"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "", "infoLayout", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;", "avatarLayout", "userTextStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;", "logoLayout", "logoTextLayout", "logoTextStyle", "hotLayout", "hotTextStyle", "arriveTimeIconLayout", "arriveTimeTextStyle", "arriveTimeTextLayout", "videoTitleLayout", "videoTitleStyle", "maskStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;", "height", "", "hotIconStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;", "viewStyle", "darkModeEnable", "", "redPacketLayout", "price", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;", "liveHeaderStateStyle", "liveHeaderEnterIconLayout", "coinLayout", "coinStyle", "coinIconLayout", "playerMaskStyle", "playerLayout", "feedbackLayout", "videoLikeStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;", "colorfulCardStyle", "", "removeShadow", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;Ljava/lang/Double;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;ZLcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;Ljava/lang/Integer;Z)V", "getArriveTimeIconLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;", "getArriveTimeTextLayout", "getArriveTimeTextStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;", "getAvatarLayout", "getCoinIconLayout", "getCoinLayout", "getCoinStyle", "getColorfulCardStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDarkModeEnable", "()Z", "getFeedbackLayout", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHotIconStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;", "getHotLayout", "getHotTextStyle", "getInfoLayout", "getLiveHeaderEnterIconLayout", "getLiveHeaderStateStyle", "getLogoLayout", "getLogoTextLayout", "getLogoTextStyle", "getMaskStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;", "getPlayerLayout", "getPlayerMaskStyle", "getPrice", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;", "getRedPacketLayout", "getRemoveShadow", "getUserTextStyle", "getVideoLikeStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;", "getVideoTitleLayout", "getVideoTitleStyle", "getViewStyle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;Ljava/lang/Double;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;ZLcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;Ljava/lang/Integer;Z)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "equals", "other", "hashCode", "toString", "", "CommonColorStyle", "CusTextStyle", "LayoutStyle", "MaskStyle", "VideoLikeStyle", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementStyle {

        @SerializedName("arrive_time_icon_layout")
        private final LayoutStyle arriveTimeIconLayout;

        @SerializedName("arrive_time_text_layout")
        private final LayoutStyle arriveTimeTextLayout;

        @SerializedName("arrive_time_text_style")
        private final CusTextStyle arriveTimeTextStyle;

        @SerializedName("avatar_layout")
        private final LayoutStyle avatarLayout;

        @SerializedName("coin_icon_layout")
        private final LayoutStyle coinIconLayout;

        @SerializedName("coin_layout")
        private final LayoutStyle coinLayout;

        @SerializedName("coin_style")
        private final CusTextStyle coinStyle;

        @SerializedName("colorful_card_style")
        private final Integer colorfulCardStyle;

        @SerializedName("dark_mode_enable")
        private final boolean darkModeEnable;

        @SerializedName("feed_back_button_layout")
        private final LayoutStyle feedbackLayout;

        @SerializedName("height")
        private final Double height;

        @SerializedName("hot_icon_style")
        private final CommonColorStyle hotIconStyle;

        @SerializedName("hot_icon_layout")
        private final LayoutStyle hotLayout;

        @SerializedName("hot_text_style")
        private final CusTextStyle hotTextStyle;

        @SerializedName("info_layout")
        private final LayoutStyle infoLayout;

        @SerializedName("live_header_enter_icon_layout")
        private final LayoutStyle liveHeaderEnterIconLayout;

        @SerializedName("live_header_state_style")
        private final CusTextStyle liveHeaderStateStyle;

        @SerializedName("logo_icon_layout")
        private final LayoutStyle logoLayout;

        @SerializedName("logo_text_layout")
        private final LayoutStyle logoTextLayout;

        @SerializedName("logo_text_style")
        private final CusTextStyle logoTextStyle;

        @SerializedName("mask_style")
        private final MaskStyle maskStyle;

        @SerializedName("player_layout")
        private final LayoutStyle playerLayout;

        @SerializedName("player_mask_style")
        private final CommonColorStyle playerMaskStyle;

        @SerializedName("price")
        private final PriceContent price;

        @SerializedName("red_packet_layout")
        private final LayoutStyle redPacketLayout;

        @SerializedName("remove_shadow")
        private final boolean removeShadow;

        @SerializedName("user_text_style")
        private final CusTextStyle userTextStyle;

        @SerializedName("video_like_info")
        private final VideoLikeStyle videoLikeStyle;

        @SerializedName("video_title_layout")
        private final LayoutStyle videoTitleLayout;

        @SerializedName("video_title_style")
        private final CusTextStyle videoTitleStyle;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_VIEW_STYLE)
        private final CommonColorStyle viewStyle;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CommonColorStyle;", "", "color", "", "colorDark", "colorLight", "colorFrom", "colorTo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getColorDark", "getColorFrom", "getColorLight", "getColorTo", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class CommonColorStyle {

            @SerializedName("color")
            private final String color;

            @SerializedName("color_dark")
            private final String colorDark;

            @SerializedName("color_from")
            private final String colorFrom;

            @SerializedName("color_light")
            private final String colorLight;

            @SerializedName("color_to")
            private final String colorTo;

            public CommonColorStyle() {
                this(null, null, null, null, null, 31, null);
            }

            public static /* synthetic */ CommonColorStyle copy$default(CommonColorStyle r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
                if ((r106 & 1) == 0) goto L6;
                r101 = r100.color;
            L6:
                if ((r106 & 2) == 0) goto L8;
                r102 = r100.colorDark;
            L8:
                String r111 = r102;
                if ((r106 & 4) == 0) goto L11;
                r103 = r100.colorLight;
            L11:
                String r107 = r103;
                if ((r106 & 8) == 0) goto L14;
                r104 = r100.colorFrom;
            L14:
                String r108 = r104;
                if ((r106 & 16) == 0) goto L17;
                r105 = r100.colorTo;
            L17:
                String r109 = r101;
                return r100.copy(r109, r111, r107, r108, r105);
            }

            public final String component1() {
                return this.color;
            }

            public final String component2() {
                return this.colorDark;
            }

            public final String component3() {
                return this.colorLight;
            }

            public final String component4() {
                return this.colorFrom;
            }

            public final String component5() {
                return this.colorTo;
            }

            public final CommonColorStyle copy(String r100, String r101, String r110, String r111, String r112) {
                return new CommonColorStyle(r100, r101, r110, r111, r112);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof CommonColorStyle) == false) goto L16;
                CommonColorStyle r101 = (CommonColorStyle) r100;
                if (Intrinsics.areEqual(this.color, r101.color) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.colorDark, r101.colorDark) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.colorLight, r101.colorLight) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.colorFrom, r101.colorFrom) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.colorTo, r101.colorTo) == true) goto L25;
                return false;
            L25:
                return true;
            L16:
                return false;
            }

            public int hashCode() {
                String r100 = this.color;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.colorDark;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                String r107 = this.colorLight;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                String r110 = this.colorFrom;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                String r113 = this.colorTo;
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
                return "CommonColorStyle(color=" + this.color + ", colorDark=" + this.colorDark + ", colorLight=" + this.colorLight + ", colorFrom=" + this.colorFrom + ", colorTo=" + this.colorTo + ")";
            }

            public final String getColor() {
                return this.color;
            }

            public final String getColorDark() {
                return this.colorDark;
            }

            public final String getColorFrom() {
                return this.colorFrom;
            }

            public final String getColorLight() {
                return this.colorLight;
            }

            public final String getColorTo() {
                return this.colorTo;
            }

            public CommonColorStyle(String r100, String r101, String r102, String r103, String r104) {
                this.color = r100;
                this.colorDark = r101;
                this.colorLight = r102;
                this.colorFrom = r103;
                this.colorTo = r104;
            }

            public /* synthetic */ CommonColorStyle(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
                if ((r110 & 1) == 0) goto L5;
                String r112 = null;
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;", "", "color", "", "fontSize", "", "fontWeight", "colorDark", "backgroundColor", "backgroundColorTo", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getBackgroundColorTo", "getColor", "getColorDark", "getFontSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFontWeight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$CusTextStyle;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class CusTextStyle {

            @SerializedName("background_color")
            private final String backgroundColor;

            @SerializedName("background_color_to")
            private final String backgroundColorTo;

            @SerializedName("color")
            private final String color;

            @SerializedName("color_dark")
            private final String colorDark;

            @SerializedName("font_size")
            private final Integer fontSize;

            @SerializedName(FontsContractCompat.Columns.WEIGHT)
            private final Integer fontWeight;

            public CusTextStyle() {
                this(null, null, null, null, null, null, 63, null);
            }

            public static /* synthetic */ CusTextStyle copy$default(CusTextStyle r100, String r101, Integer r102, Integer r103, String r104, String r105, String r110, int r111, Object r112) {
                if ((r111 & 1) == 0) goto L6;
                r101 = r100.color;
            L6:
                if ((r111 & 2) == 0) goto L8;
                r102 = r100.fontSize;
            L8:
                Integer r113 = r102;
                if ((r111 & 4) == 0) goto L11;
                r103 = r100.fontWeight;
            L11:
                Integer r106 = r103;
                if ((r111 & 8) == 0) goto L14;
                r104 = r100.colorDark;
            L14:
                String r107 = r104;
                if ((r111 & 16) == 0) goto L17;
                r105 = r100.backgroundColor;
            L17:
                String r108 = r105;
                if ((r111 & 32) == 0) goto L20;
                r110 = r100.backgroundColorTo;
            L20:
                String r109 = r101;
                return r100.copy(r109, r113, r106, r107, r108, r110);
            }

            public final String component1() {
                return this.color;
            }

            public final Integer component2() {
                return this.fontSize;
            }

            public final Integer component3() {
                return this.fontWeight;
            }

            public final String component4() {
                return this.colorDark;
            }

            public final String component5() {
                return this.backgroundColor;
            }

            public final String component6() {
                return this.backgroundColorTo;
            }

            public final CusTextStyle copy(String r100, Integer r110, Integer r111, String r112, String r113, String r114) {
                return new CusTextStyle(r100, r110, r111, r112, r113, r114);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof CusTextStyle) == false) goto L18;
                CusTextStyle r101 = (CusTextStyle) r100;
                if (Intrinsics.areEqual(this.color, r101.color) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.colorDark, r101.colorDark) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.backgroundColorTo, r101.backgroundColorTo) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public int hashCode() {
                String r100 = this.color;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                Integer r104 = this.fontSize;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Integer r107 = this.fontWeight;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                String r110 = this.colorDark;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                String r113 = this.backgroundColor;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                String r116 = this.backgroundColorTo;
                if (r116 == null) goto L26;
                r101 = r116.hashCode();
            L26:
                return r115 + r101;
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
                return "CusTextStyle(color=" + this.color + ", fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", colorDark=" + this.colorDark + ", backgroundColor=" + this.backgroundColor + ", backgroundColorTo=" + this.backgroundColorTo + ")";
            }

            public final String getBackgroundColor() {
                return this.backgroundColor;
            }

            public final String getBackgroundColorTo() {
                return this.backgroundColorTo;
            }

            public final String getColor() {
                return this.color;
            }

            public final String getColorDark() {
                return this.colorDark;
            }

            public final Integer getFontSize() {
                return this.fontSize;
            }

            public final Integer getFontWeight() {
                return this.fontWeight;
            }

            public CusTextStyle(String r100, Integer r101, Integer r102, String r103, String r104, String r105) {
                this.color = r100;
                this.fontSize = r101;
                this.fontWeight = r102;
                this.colorDark = r103;
                this.backgroundColor = r104;
                this.backgroundColorTo = r105;
            }

            public /* synthetic */ CusTextStyle(String r100, Integer r101, Integer r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
                if ((r112 & 1) == 0) goto L5;
                String r114 = null;
            L7:
                if ((r112 & 2) == 0) goto L9;
                Integer r104 = null;
            L11:
                if ((r112 & 4) == 0) goto L13;
                Integer r105 = null;
            L15:
                if ((r112 & 8) == 0) goto L17;
                String r106 = null;
            L19:
                if ((r112 & 16) == 0) goto L21;
                String r107 = null;
            L23:
                if ((r112 & 32) == 0) goto L25;
                String r115 = null;
            L26:
                this(r114, r104, r105, r106, r107, r115);
                return;
            L25:
                r115 = r111;
                goto L26
            L21:
                r107 = r110;
                goto L23
            L17:
                r106 = r103;
                goto L19
            L13:
                r105 = r102;
                goto L15
            L9:
                r104 = r101;
                goto L11
            L5:
                r114 = r100;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;", "", "top", "", "bottom", "left", "right", "width", "height", "radius", "url", "", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getBottom", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeight", "getLeft", "getRadius", "getRight", "getTop", "getUrl", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$LayoutStyle;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class LayoutStyle {

            @SerializedName("bottom")
            private final Double bottom;

            @SerializedName("height")
            private final Double height;

            @SerializedName("left")
            private final Double left;

            @SerializedName("radius")
            private final Double radius;

            @SerializedName("right")
            private final Double right;

            @SerializedName("top")
            private final Double top;

            @SerializedName("url")
            private final String url;

            @SerializedName("width")
            private final Double width;

            public LayoutStyle() {
                this(null, null, null, null, null, null, null, null, 255, null);
            }

            public static /* synthetic */ LayoutStyle copy$default(LayoutStyle r100, Double r110, Double r111, Double r112, Double r113, Double r114, Double r115, Double r116, String r117, int r118, Object r119) {
                if ((r118 & 1) == 0) goto L5;
                Double r101 = r100.top;
            L7:
                if ((r118 & 2) == 0) goto L9;
                Double r102 = r100.bottom;
            L11:
                if ((r118 & 4) == 0) goto L13;
                Double r103 = r100.left;
            L15:
                if ((r118 & 8) == 0) goto L17;
                Double r104 = r100.right;
            L19:
                if ((r118 & 16) == 0) goto L21;
                Double r105 = r100.width;
            L23:
                if ((r118 & 32) == 0) goto L25;
                Double r106 = r100.height;
            L27:
                if ((r118 & 64) == 0) goto L29;
                Double r107 = r100.radius;
            L31:
                if ((r118 & 128) == 0) goto L33;
                String r108 = r100.url;
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

            public final Double component1() {
                return this.top;
            }

            public final Double component2() {
                return this.bottom;
            }

            public final Double component3() {
                return this.left;
            }

            public final Double component4() {
                return this.right;
            }

            public final Double component5() {
                return this.width;
            }

            public final Double component6() {
                return this.height;
            }

            public final Double component7() {
                return this.radius;
            }

            public final String component8() {
                return this.url;
            }

            public final LayoutStyle copy(Double r110, Double r111, Double r112, Double r113, Double r114, Double r115, Double r116, String r117) {
                return new LayoutStyle(r110, r111, r112, r113, r114, r115, r116, r117);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof LayoutStyle) == false) goto L22;
                LayoutStyle r101 = (LayoutStyle) r100;
                if (Intrinsics.areEqual(this.top, r101.top) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.bottom, r101.bottom) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.left, r101.left) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.right, r101.right) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.width, r101.width) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.height, r101.height) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.url, r101.url) == true) goto L34;
                return false;
            L34:
                return true;
            L22:
                return false;
            }

            public int hashCode() {
                Double r100 = this.top;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                Double r104 = this.bottom;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Double r107 = this.left;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                Double r110 = this.right;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                Double r113 = this.width;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                Double r116 = this.height;
                if (r116 == null) goto L25;
                int r117 = r116.hashCode();
            L26:
                int r118 = (r115 + r117) * 31;
                Double r119 = this.radius;
                if (r119 == null) goto L29;
                int r120 = r119.hashCode();
            L30:
                int r121 = (r118 + r120) * 31;
                String r122 = this.url;
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
                return "LayoutStyle(top=" + this.top + ", bottom=" + this.bottom + ", left=" + this.left + ", right=" + this.right + ", width=" + this.width + ", height=" + this.height + ", radius=" + this.radius + ", url=" + this.url + ")";
            }

            public final Double getBottom() {
                return this.bottom;
            }

            public final Double getHeight() {
                return this.height;
            }

            public final Double getLeft() {
                return this.left;
            }

            public final Double getRadius() {
                return this.radius;
            }

            public final Double getRight() {
                return this.right;
            }

            public final Double getTop() {
                return this.top;
            }

            public final String getUrl() {
                return this.url;
            }

            public final Double getWidth() {
                return this.width;
            }

            public LayoutStyle(Double r100, Double r101, Double r102, Double r103, Double r104, Double r105, Double r106, String r107) {
                this.top = r100;
                this.bottom = r101;
                this.left = r102;
                this.right = r103;
                this.width = r104;
                this.height = r105;
                this.radius = r106;
                this.url = r107;
            }

            public /* synthetic */ LayoutStyle(Double r110, Double r111, Double r112, Double r113, Double r114, Double r115, Double r116, String r117, int r118, DefaultConstructorMarker r119) {
                String r100 = null;
                if ((r118 & 1) == 0) goto L5;
                Double r101 = null;
            L7:
                if ((r118 & 2) == 0) goto L9;
                Double r102 = null;
            L11:
                if ((r118 & 4) == 0) goto L13;
                Double r103 = null;
            L15:
                if ((r118 & 8) == 0) goto L17;
                Double r104 = null;
            L19:
                if ((r118 & 16) == 0) goto L21;
                Double r105 = null;
            L23:
                if ((r118 & 32) == 0) goto L25;
                Double r106 = null;
            L27:
                if ((r118 & 64) == 0) goto L29;
                Double r107 = null;
            L31:
                if ((r118 & 128) != 0) goto L34;
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;", "", "height", "", "colorFrom", "", "colorTo", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "getColorFrom", "()Ljava/lang/String;", "getColorTo", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "copy", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$MaskStyle;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class MaskStyle {

            @SerializedName("color_from")
            private final String colorFrom;

            @SerializedName("color_to")
            private final String colorTo;

            @SerializedName("height")
            private final Double height;

            public MaskStyle() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ MaskStyle copy$default(MaskStyle r100, Double r101, String r102, String r103, int r104, Object r105) {
                if ((r104 & 1) == 0) goto L6;
                r101 = r100.height;
            L6:
                if ((r104 & 2) == 0) goto L9;
                r102 = r100.colorFrom;
            L9:
                if ((r104 & 4) == 0) goto L12;
                r103 = r100.colorTo;
            L12:
                return r100.copy(r101, r102, r103);
            }

            public final Double component1() {
                return this.height;
            }

            public final String component2() {
                return this.colorFrom;
            }

            public final String component3() {
                return this.colorTo;
            }

            public final MaskStyle copy(Double r100, String r101, String r102) {
                return new MaskStyle(r100, r101, r102);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof MaskStyle) == false) goto L12;
                MaskStyle r101 = (MaskStyle) r100;
                if (Intrinsics.areEqual(this.height, r101.height) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.colorFrom, r101.colorFrom) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.colorTo, r101.colorTo) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public int hashCode() {
                Double r100 = this.height;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.colorFrom;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                String r107 = this.colorTo;
                if (r107 == null) goto L14;
                r101 = r107.hashCode();
            L14:
                return r106 + r101;
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "MaskStyle(height=" + this.height + ", colorFrom=" + this.colorFrom + ", colorTo=" + this.colorTo + ")";
            }

            public final String getColorFrom() {
                return this.colorFrom;
            }

            public final String getColorTo() {
                return this.colorTo;
            }

            public final Double getHeight() {
                return this.height;
            }

            public MaskStyle(Double r100, String r101, String r102) {
                this.height = r100;
                this.colorFrom = r101;
                this.colorTo = r102;
            }

            public /* synthetic */ MaskStyle(Double r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
                if ((r103 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r101 = null;
            L9:
                if ((r103 & 4) == 0) goto L11;
                r102 = null;
            L11:
                this(r100, r101, r102);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;", "", "icon", "", "text", "(Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class VideoLikeStyle {

            @SerializedName("icon")
            private final String icon;

            @SerializedName("text")
            private final String text;

            /* JADX WARN: Multi-variable type inference failed */
            public VideoLikeStyle() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ VideoLikeStyle copy$default(VideoLikeStyle r100, String r101, String r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.icon;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.text;
            L9:
                return r100.copy(r101, r102);
            }

            public final String component1() {
                return this.icon;
            }

            public final String component2() {
                return this.text;
            }

            public final VideoLikeStyle copy(String r100, String r101) {
                return new VideoLikeStyle(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof VideoLikeStyle) == false) goto L10;
                VideoLikeStyle r101 = (VideoLikeStyle) r100;
                if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.text, r101.text) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                String r100 = this.icon;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.text;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "VideoLikeStyle(icon=" + this.icon + ", text=" + this.text + ")";
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getText() {
                return this.text;
            }

            public VideoLikeStyle(String r100, String r101) {
                this.icon = r100;
                this.text = r101;
            }

            public /* synthetic */ VideoLikeStyle(String r100, String r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        public ElementStyle() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, false, Integer.MAX_VALUE, null);
        }

        public static /* synthetic */ ElementStyle copy$default(ElementStyle r110, LayoutStyle r111, LayoutStyle r112, CusTextStyle r210, LayoutStyle r211, LayoutStyle r212, CusTextStyle r213, LayoutStyle r214, CusTextStyle r215, LayoutStyle r216, CusTextStyle r217, LayoutStyle r218, LayoutStyle r219, CusTextStyle r310, MaskStyle r311, Double r312, CommonColorStyle r313, CommonColorStyle r314, boolean r315, LayoutStyle r316, PriceContent r317, CusTextStyle r318, LayoutStyle r319, LayoutStyle r410, CusTextStyle r411, LayoutStyle r412, CommonColorStyle r413, LayoutStyle r414, LayoutStyle r415, VideoLikeStyle r416, Integer r417, boolean r418, int r419, Object r510) {
            if ((r419 & 1) == 0) goto L5;
            LayoutStyle r100 = r110.infoLayout;
        L7:
            if ((r419 & 2) == 0) goto L9;
            LayoutStyle r101 = r110.avatarLayout;
        L11:
            if ((r419 & 4) == 0) goto L13;
            CusTextStyle r102 = r110.userTextStyle;
        L15:
            if ((r419 & 8) == 0) goto L17;
            LayoutStyle r103 = r110.logoLayout;
        L19:
            if ((r419 & 16) == 0) goto L21;
            LayoutStyle r104 = r110.logoTextLayout;
        L23:
            if ((r419 & 32) == 0) goto L25;
            CusTextStyle r105 = r110.logoTextStyle;
        L27:
            if ((r419 & 64) == 0) goto L29;
            LayoutStyle r106 = r110.hotLayout;
        L31:
            if ((r419 & 128) == 0) goto L33;
            CusTextStyle r107 = r110.hotTextStyle;
        L35:
            if ((r419 & 256) == 0) goto L37;
            LayoutStyle r113 = r110.arriveTimeIconLayout;
        L39:
            if ((r419 & 512) == 0) goto L41;
            CusTextStyle r114 = r110.arriveTimeTextStyle;
        L43:
            if ((r419 & 1024) == 0) goto L45;
            LayoutStyle r115 = r110.arriveTimeTextLayout;
        L47:
            if ((r419 & 2048) == 0) goto L49;
            LayoutStyle r116 = r110.videoTitleLayout;
        L51:
            if ((r419 & 4096) == 0) goto L53;
            CusTextStyle r117 = r110.videoTitleStyle;
        L55:
            if ((r419 & 8192) == 0) goto L57;
            MaskStyle r118 = r110.maskStyle;
        L58:
            MaskStyle r320 = r118;
            if ((r419 & 16384) == 0) goto L61;
            Double r119 = r110.height;
        L62:
            Double r321 = r119;
            if ((r419 & 32768) == 0) goto L65;
            CommonColorStyle r120 = r110.hotIconStyle;
        L66:
            CommonColorStyle r322 = r120;
            if ((r419 & 65536) == 0) goto L69;
            CommonColorStyle r121 = r110.viewStyle;
        L70:
            CommonColorStyle r323 = r121;
            if ((r419 & 131072) == 0) goto L73;
            boolean r122 = r110.darkModeEnable;
        L74:
            boolean r324 = r122;
            if ((r419 & 262144) == 0) goto L77;
            LayoutStyle r123 = r110.redPacketLayout;
        L78:
            LayoutStyle r325 = r123;
            if ((r419 & 524288) == 0) goto L81;
            PriceContent r124 = r110.price;
        L82:
            PriceContent r326 = r124;
            if ((r419 & 1048576) == 0) goto L85;
            CusTextStyle r125 = r110.liveHeaderStateStyle;
        L86:
            CusTextStyle r327 = r125;
            if ((r419 & 2097152) == 0) goto L89;
            LayoutStyle r126 = r110.liveHeaderEnterIconLayout;
        L90:
            LayoutStyle r328 = r126;
            if ((r419 & 4194304) == 0) goto L93;
            LayoutStyle r127 = r110.coinLayout;
        L94:
            LayoutStyle r420 = r127;
            if ((r419 & 8388608) == 0) goto L97;
            CusTextStyle r128 = r110.coinStyle;
        L98:
            CusTextStyle r421 = r128;
            if ((r419 & 16777216) == 0) goto L101;
            LayoutStyle r129 = r110.coinIconLayout;
        L102:
            LayoutStyle r422 = r129;
            if ((r419 & 33554432) == 0) goto L105;
            CommonColorStyle r130 = r110.playerMaskStyle;
        L106:
            CommonColorStyle r423 = r130;
            if ((r419 & 67108864) == 0) goto L109;
            LayoutStyle r131 = r110.playerLayout;
        L110:
            LayoutStyle r424 = r131;
            if ((r419 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
            LayoutStyle r132 = r110.feedbackLayout;
        L114:
            LayoutStyle r425 = r132;
            if ((r419 & 268435456) == 0) goto L117;
            VideoLikeStyle r133 = r110.videoLikeStyle;
        L118:
            VideoLikeStyle r426 = r133;
            if ((r419 & 536870912) == 0) goto L121;
            Integer r134 = r110.colorfulCardStyle;
        L123:
            if ((r419 & 1073741824) == 0) goto L125;
            boolean r108 = r110.removeShadow;
        L127:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r134, r108);
        L125:
            r108 = r418;
            goto L127
        L121:
            r134 = r417;
            goto L123
        L117:
            r133 = r416;
            goto L118
        L113:
            r132 = r415;
            goto L114
        L109:
            r131 = r414;
            goto L110
        L105:
            r130 = r413;
            goto L106
        L101:
            r129 = r412;
            goto L102
        L97:
            r128 = r411;
            goto L98
        L93:
            r127 = r410;
            goto L94
        L89:
            r126 = r319;
            goto L90
        L85:
            r125 = r318;
            goto L86
        L81:
            r124 = r317;
            goto L82
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

        public final LayoutStyle component1() {
            return this.infoLayout;
        }

        public final CusTextStyle component10() {
            return this.arriveTimeTextStyle;
        }

        public final LayoutStyle component11() {
            return this.arriveTimeTextLayout;
        }

        public final LayoutStyle component12() {
            return this.videoTitleLayout;
        }

        public final CusTextStyle component13() {
            return this.videoTitleStyle;
        }

        public final MaskStyle component14() {
            return this.maskStyle;
        }

        public final Double component15() {
            return this.height;
        }

        public final CommonColorStyle component16() {
            return this.hotIconStyle;
        }

        public final CommonColorStyle component17() {
            return this.viewStyle;
        }

        public final boolean component18() {
            return this.darkModeEnable;
        }

        public final LayoutStyle component19() {
            return this.redPacketLayout;
        }

        public final LayoutStyle component2() {
            return this.avatarLayout;
        }

        public final PriceContent component20() {
            return this.price;
        }

        public final CusTextStyle component21() {
            return this.liveHeaderStateStyle;
        }

        public final LayoutStyle component22() {
            return this.liveHeaderEnterIconLayout;
        }

        public final LayoutStyle component23() {
            return this.coinLayout;
        }

        public final CusTextStyle component24() {
            return this.coinStyle;
        }

        public final LayoutStyle component25() {
            return this.coinIconLayout;
        }

        public final CommonColorStyle component26() {
            return this.playerMaskStyle;
        }

        public final LayoutStyle component27() {
            return this.playerLayout;
        }

        public final LayoutStyle component28() {
            return this.feedbackLayout;
        }

        public final VideoLikeStyle component29() {
            return this.videoLikeStyle;
        }

        public final CusTextStyle component3() {
            return this.userTextStyle;
        }

        public final Integer component30() {
            return this.colorfulCardStyle;
        }

        public final boolean component31() {
            return this.removeShadow;
        }

        public final LayoutStyle component4() {
            return this.logoLayout;
        }

        public final LayoutStyle component5() {
            return this.logoTextLayout;
        }

        public final CusTextStyle component6() {
            return this.logoTextStyle;
        }

        public final LayoutStyle component7() {
            return this.hotLayout;
        }

        public final CusTextStyle component8() {
            return this.hotTextStyle;
        }

        public final LayoutStyle component9() {
            return this.arriveTimeIconLayout;
        }

        public final ElementStyle copy(LayoutStyle r310, LayoutStyle r311, CusTextStyle r312, LayoutStyle r313, LayoutStyle r314, CusTextStyle r315, LayoutStyle r410, CusTextStyle r411, LayoutStyle r412, CusTextStyle r413, LayoutStyle r414, LayoutStyle r415, CusTextStyle r416, MaskStyle r417, Double r418, CommonColorStyle r419, CommonColorStyle r510, boolean r511, LayoutStyle r512, PriceContent r513, CusTextStyle r514, LayoutStyle r515, LayoutStyle r516, CusTextStyle r517, LayoutStyle r518, CommonColorStyle r519, LayoutStyle r610, LayoutStyle r611, VideoLikeStyle r612, Integer r613, boolean r614) {
            return new ElementStyle(r310, r311, r312, r313, r314, r315, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ElementStyle) == false) goto L68;
            ElementStyle r101 = (ElementStyle) r100;
            if (Intrinsics.areEqual(this.infoLayout, r101.infoLayout) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.avatarLayout, r101.avatarLayout) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.userTextStyle, r101.userTextStyle) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.logoLayout, r101.logoLayout) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.logoTextLayout, r101.logoTextLayout) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.logoTextStyle, r101.logoTextStyle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.hotLayout, r101.hotLayout) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.hotTextStyle, r101.hotTextStyle) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.arriveTimeIconLayout, r101.arriveTimeIconLayout) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.arriveTimeTextStyle, r101.arriveTimeTextStyle) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.arriveTimeTextLayout, r101.arriveTimeTextLayout) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.videoTitleLayout, r101.videoTitleLayout) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.videoTitleStyle, r101.videoTitleStyle) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.maskStyle, r101.maskStyle) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.height, r101.height) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.hotIconStyle, r101.hotIconStyle) == true) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.viewStyle, r101.viewStyle) == true) goto L40;
            return false;
        L40:
            if (this.darkModeEnable == r101.darkModeEnable) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.redPacketLayout, r101.redPacketLayout) == true) goto L44;
            return false;
        L44:
            if (Intrinsics.areEqual(this.price, r101.price) == true) goto L46;
            return false;
        L46:
            if (Intrinsics.areEqual(this.liveHeaderStateStyle, r101.liveHeaderStateStyle) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.liveHeaderEnterIconLayout, r101.liveHeaderEnterIconLayout) == true) goto L50;
            return false;
        L50:
            if (Intrinsics.areEqual(this.coinLayout, r101.coinLayout) == true) goto L52;
            return false;
        L52:
            if (Intrinsics.areEqual(this.coinStyle, r101.coinStyle) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.coinIconLayout, r101.coinIconLayout) == true) goto L56;
            return false;
        L56:
            if (Intrinsics.areEqual(this.playerMaskStyle, r101.playerMaskStyle) == true) goto L58;
            return false;
        L58:
            if (Intrinsics.areEqual(this.playerLayout, r101.playerLayout) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.feedbackLayout, r101.feedbackLayout) == true) goto L62;
            return false;
        L62:
            if (Intrinsics.areEqual(this.videoLikeStyle, r101.videoLikeStyle) == true) goto L64;
            return false;
        L64:
            if (Intrinsics.areEqual(this.colorfulCardStyle, r101.colorfulCardStyle) == true) goto L66;
            return false;
        L66:
            if (this.removeShadow == r101.removeShadow) goto L103;
            return false;
        L103:
            return true;
        L68:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v36, types: [int] */
        /* JADX WARN: Type inference failed for: r0v62, types: [int] */
        /* JADX WARN: Type inference failed for: r2v112 */
        /* JADX WARN: Type inference failed for: r2v49, types: [int] */
        /* JADX WARN: Type inference failed for: r2v95 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            LayoutStyle r100 = this.infoLayout;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            LayoutStyle r104 = this.avatarLayout;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            CusTextStyle r107 = this.userTextStyle;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            LayoutStyle r110 = this.logoLayout;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            LayoutStyle r113 = this.logoTextLayout;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            CusTextStyle r116 = this.logoTextStyle;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            LayoutStyle r119 = this.hotLayout;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            CusTextStyle r122 = this.hotTextStyle;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            LayoutStyle r125 = this.arriveTimeIconLayout;
            if (r125 == null) goto L37;
            int r126 = r125.hashCode();
        L38:
            int r127 = (r124 + r126) * 31;
            CusTextStyle r128 = this.arriveTimeTextStyle;
            if (r128 == null) goto L41;
            int r129 = r128.hashCode();
        L42:
            int r130 = (r127 + r129) * 31;
            LayoutStyle r131 = this.arriveTimeTextLayout;
            if (r131 == null) goto L45;
            int r132 = r131.hashCode();
        L46:
            int r133 = (r130 + r132) * 31;
            LayoutStyle r134 = this.videoTitleLayout;
            if (r134 == null) goto L49;
            int r135 = r134.hashCode();
        L50:
            int r136 = (r133 + r135) * 31;
            CusTextStyle r137 = this.videoTitleStyle;
            if (r137 == null) goto L53;
            int r138 = r137.hashCode();
        L54:
            int r139 = (r136 + r138) * 31;
            MaskStyle r140 = this.maskStyle;
            if (r140 == null) goto L57;
            int r141 = r140.hashCode();
        L58:
            int r142 = (r139 + r141) * 31;
            Double r143 = this.height;
            if (r143 == null) goto L61;
            int r144 = r143.hashCode();
        L62:
            int r145 = (r142 + r144) * 31;
            CommonColorStyle r146 = this.hotIconStyle;
            if (r146 == null) goto L65;
            int r147 = r146.hashCode();
        L66:
            int r148 = (r145 + r147) * 31;
            CommonColorStyle r149 = this.viewStyle;
            if (r149 == null) goto L69;
            int r150 = r149.hashCode();
        L70:
            int r151 = (r148 + r150) * 31;
            boolean r152 = this.darkModeEnable;
            ?? r153 = 1;
            ?? r154 = r152;
            if (r152 == false) goto L73;
            r154 = 1;
        L73:
            int r155 = (r151 + r154) * 31;
            LayoutStyle r156 = this.redPacketLayout;
            if (r156 == null) goto L76;
            int r157 = r156.hashCode();
        L77:
            int r158 = (r155 + r157) * 31;
            PriceContent r159 = this.price;
            if (r159 == null) goto L80;
            int r160 = r159.hashCode();
        L81:
            int r161 = (r158 + r160) * 31;
            CusTextStyle r162 = this.liveHeaderStateStyle;
            if (r162 == null) goto L84;
            int r163 = r162.hashCode();
        L85:
            int r164 = (r161 + r163) * 31;
            LayoutStyle r165 = this.liveHeaderEnterIconLayout;
            if (r165 == null) goto L88;
            int r166 = r165.hashCode();
        L89:
            int r167 = (r164 + r166) * 31;
            LayoutStyle r168 = this.coinLayout;
            if (r168 == null) goto L92;
            int r169 = r168.hashCode();
        L93:
            int r170 = (r167 + r169) * 31;
            CusTextStyle r171 = this.coinStyle;
            if (r171 == null) goto L96;
            int r172 = r171.hashCode();
        L97:
            int r173 = (r170 + r172) * 31;
            LayoutStyle r174 = this.coinIconLayout;
            if (r174 == null) goto L100;
            int r175 = r174.hashCode();
        L101:
            int r176 = (r173 + r175) * 31;
            CommonColorStyle r177 = this.playerMaskStyle;
            if (r177 == null) goto L104;
            int r178 = r177.hashCode();
        L105:
            int r179 = (r176 + r178) * 31;
            LayoutStyle r180 = this.playerLayout;
            if (r180 == null) goto L108;
            int r181 = r180.hashCode();
        L109:
            int r182 = (r179 + r181) * 31;
            LayoutStyle r183 = this.feedbackLayout;
            if (r183 == null) goto L112;
            int r184 = r183.hashCode();
        L113:
            int r185 = (r182 + r184) * 31;
            VideoLikeStyle r186 = this.videoLikeStyle;
            if (r186 == null) goto L116;
            int r187 = r186.hashCode();
        L117:
            int r188 = (r185 + r187) * 31;
            Integer r189 = this.colorfulCardStyle;
            if (r189 == null) goto L120;
            r101 = r189.hashCode();
        L120:
            int r190 = (r188 + r101) * 31;
            boolean r191 = this.removeShadow;
            if (r191 == true) goto L125;
            r153 = r191;
        L125:
            return r190 + r153;
        L116:
            r187 = 0;
            goto L117
        L112:
            r184 = 0;
            goto L113
        L108:
            r181 = 0;
            goto L109
        L104:
            r178 = 0;
            goto L105
        L100:
            r175 = 0;
            goto L101
        L96:
            r172 = 0;
            goto L97
        L92:
            r169 = 0;
            goto L93
        L88:
            r166 = 0;
            goto L89
        L84:
            r163 = 0;
            goto L85
        L80:
            r160 = 0;
            goto L81
        L76:
            r157 = 0;
            goto L77
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
            return "ElementStyle(infoLayout=" + this.infoLayout + ", avatarLayout=" + this.avatarLayout + ", userTextStyle=" + this.userTextStyle + ", logoLayout=" + this.logoLayout + ", logoTextLayout=" + this.logoTextLayout + ", logoTextStyle=" + this.logoTextStyle + ", hotLayout=" + this.hotLayout + ", hotTextStyle=" + this.hotTextStyle + ", arriveTimeIconLayout=" + this.arriveTimeIconLayout + ", arriveTimeTextStyle=" + this.arriveTimeTextStyle + ", arriveTimeTextLayout=" + this.arriveTimeTextLayout + ", videoTitleLayout=" + this.videoTitleLayout + ", videoTitleStyle=" + this.videoTitleStyle + ", maskStyle=" + this.maskStyle + ", height=" + this.height + ", hotIconStyle=" + this.hotIconStyle + ", viewStyle=" + this.viewStyle + ", darkModeEnable=" + this.darkModeEnable + ", redPacketLayout=" + this.redPacketLayout + ", price=" + this.price + ", liveHeaderStateStyle=" + this.liveHeaderStateStyle + ", liveHeaderEnterIconLayout=" + this.liveHeaderEnterIconLayout + ", coinLayout=" + this.coinLayout + ", coinStyle=" + this.coinStyle + ", coinIconLayout=" + this.coinIconLayout + ", playerMaskStyle=" + this.playerMaskStyle + ", playerLayout=" + this.playerLayout + ", feedbackLayout=" + this.feedbackLayout + ", videoLikeStyle=" + this.videoLikeStyle + ", colorfulCardStyle=" + this.colorfulCardStyle + ", removeShadow=" + this.removeShadow + ")";
        }

        public final LayoutStyle getArriveTimeIconLayout() {
            return this.arriveTimeIconLayout;
        }

        public final LayoutStyle getArriveTimeTextLayout() {
            return this.arriveTimeTextLayout;
        }

        public final CusTextStyle getArriveTimeTextStyle() {
            return this.arriveTimeTextStyle;
        }

        public final LayoutStyle getAvatarLayout() {
            return this.avatarLayout;
        }

        public final LayoutStyle getCoinIconLayout() {
            return this.coinIconLayout;
        }

        public final LayoutStyle getCoinLayout() {
            return this.coinLayout;
        }

        public final CusTextStyle getCoinStyle() {
            return this.coinStyle;
        }

        public final Integer getColorfulCardStyle() {
            return this.colorfulCardStyle;
        }

        public final boolean getDarkModeEnable() {
            return this.darkModeEnable;
        }

        public final LayoutStyle getFeedbackLayout() {
            return this.feedbackLayout;
        }

        public final Double getHeight() {
            return this.height;
        }

        public final CommonColorStyle getHotIconStyle() {
            return this.hotIconStyle;
        }

        public final LayoutStyle getHotLayout() {
            return this.hotLayout;
        }

        public final CusTextStyle getHotTextStyle() {
            return this.hotTextStyle;
        }

        public final LayoutStyle getInfoLayout() {
            return this.infoLayout;
        }

        public final LayoutStyle getLiveHeaderEnterIconLayout() {
            return this.liveHeaderEnterIconLayout;
        }

        public final CusTextStyle getLiveHeaderStateStyle() {
            return this.liveHeaderStateStyle;
        }

        public final LayoutStyle getLogoLayout() {
            return this.logoLayout;
        }

        public final LayoutStyle getLogoTextLayout() {
            return this.logoTextLayout;
        }

        public final CusTextStyle getLogoTextStyle() {
            return this.logoTextStyle;
        }

        public final MaskStyle getMaskStyle() {
            return this.maskStyle;
        }

        public final LayoutStyle getPlayerLayout() {
            return this.playerLayout;
        }

        public final CommonColorStyle getPlayerMaskStyle() {
            return this.playerMaskStyle;
        }

        public final PriceContent getPrice() {
            return this.price;
        }

        public final LayoutStyle getRedPacketLayout() {
            return this.redPacketLayout;
        }

        public final boolean getRemoveShadow() {
            return this.removeShadow;
        }

        public final CusTextStyle getUserTextStyle() {
            return this.userTextStyle;
        }

        public final VideoLikeStyle getVideoLikeStyle() {
            return this.videoLikeStyle;
        }

        public final LayoutStyle getVideoTitleLayout() {
            return this.videoTitleLayout;
        }

        public final CusTextStyle getVideoTitleStyle() {
            return this.videoTitleStyle;
        }

        public final CommonColorStyle getViewStyle() {
            return this.viewStyle;
        }

        public ElementStyle(LayoutStyle r100, LayoutStyle r101, CusTextStyle r102, LayoutStyle r103, LayoutStyle r104, CusTextStyle r105, LayoutStyle r106, CusTextStyle r110, LayoutStyle r111, CusTextStyle r112, LayoutStyle r113, LayoutStyle r114, CusTextStyle r115, MaskStyle r116, Double r117, CommonColorStyle r118, CommonColorStyle r119, boolean r210, LayoutStyle r211, PriceContent r212, CusTextStyle r213, LayoutStyle r214, LayoutStyle r215, CusTextStyle r216, LayoutStyle r217, CommonColorStyle r218, LayoutStyle r219, LayoutStyle r310, VideoLikeStyle r311, Integer r312, boolean r313) {
            this.infoLayout = r100;
            this.avatarLayout = r101;
            this.userTextStyle = r102;
            this.logoLayout = r103;
            this.logoTextLayout = r104;
            this.logoTextStyle = r105;
            this.hotLayout = r106;
            this.hotTextStyle = r110;
            this.arriveTimeIconLayout = r111;
            this.arriveTimeTextStyle = r112;
            this.arriveTimeTextLayout = r113;
            this.videoTitleLayout = r114;
            this.videoTitleStyle = r115;
            this.maskStyle = r116;
            this.height = r117;
            this.hotIconStyle = r118;
            this.viewStyle = r119;
            this.darkModeEnable = r210;
            this.redPacketLayout = r211;
            this.price = r212;
            this.liveHeaderStateStyle = r213;
            this.liveHeaderEnterIconLayout = r214;
            this.coinLayout = r215;
            this.coinStyle = r216;
            this.coinIconLayout = r217;
            this.playerMaskStyle = r218;
            this.playerLayout = r219;
            this.feedbackLayout = r310;
            this.videoLikeStyle = r311;
            this.colorfulCardStyle = r312;
            this.removeShadow = r313;
        }

        public /* synthetic */ ElementStyle(LayoutStyle r310, LayoutStyle r311, CusTextStyle r312, LayoutStyle r313, LayoutStyle r314, CusTextStyle r315, LayoutStyle r410, CusTextStyle r411, LayoutStyle r412, CusTextStyle r413, LayoutStyle r414, LayoutStyle r415, CusTextStyle r416, MaskStyle r417, Double r418, CommonColorStyle r419, CommonColorStyle r510, boolean r511, LayoutStyle r512, PriceContent r513, CusTextStyle r514, LayoutStyle r515, LayoutStyle r516, CusTextStyle r517, LayoutStyle r518, CommonColorStyle r519, LayoutStyle r610, LayoutStyle r611, VideoLikeStyle r612, Integer r613, boolean r614, int r615, DefaultConstructorMarker r616) {
            if ((r615 & 1) == 0) goto L5;
            LayoutStyle r100 = null;
        L7:
            if ((r615 & 2) == 0) goto L9;
            LayoutStyle r101 = null;
        L11:
            if ((r615 & 4) == 0) goto L13;
            CusTextStyle r102 = null;
        L15:
            if ((r615 & 8) == 0) goto L17;
            LayoutStyle r103 = null;
        L19:
            if ((r615 & 16) == 0) goto L21;
            LayoutStyle r104 = null;
        L23:
            if ((r615 & 32) == 0) goto L25;
            CusTextStyle r105 = null;
        L27:
            if ((r615 & 64) == 0) goto L29;
            LayoutStyle r106 = null;
        L31:
            if ((r615 & 128) == 0) goto L33;
            CusTextStyle r107 = null;
        L35:
            if ((r615 & 256) == 0) goto L37;
            LayoutStyle r110 = null;
        L39:
            if ((r615 & 512) == 0) goto L41;
            CusTextStyle r111 = null;
        L43:
            if ((r615 & 1024) == 0) goto L45;
            LayoutStyle r112 = null;
        L47:
            if ((r615 & 2048) == 0) goto L49;
            LayoutStyle r113 = null;
        L51:
            if ((r615 & 4096) == 0) goto L53;
            CusTextStyle r114 = null;
        L55:
            if ((r615 & 8192) == 0) goto L57;
            MaskStyle r115 = null;
        L59:
            if ((r615 & 16384) == 0) goto L61;
            Double r108 = null;
        L63:
            if ((r615 & 32768) == 0) goto L65;
            CommonColorStyle r116 = null;
        L67:
            if ((r615 & 65536) == 0) goto L69;
            CommonColorStyle r117 = null;
        L70:
            boolean r118 = false;
            if ((r615 & 131072) == 0) goto L73;
            boolean r119 = false;
        L75:
            if ((r615 & 262144) == 0) goto L77;
            LayoutStyle r210 = null;
        L79:
            if ((r615 & 524288) == 0) goto L81;
            PriceContent r211 = null;
        L83:
            if ((r615 & 1048576) == 0) goto L85;
            CusTextStyle r212 = null;
        L87:
            if ((r615 & 2097152) == 0) goto L89;
            LayoutStyle r213 = null;
        L91:
            if ((r615 & 4194304) == 0) goto L93;
            LayoutStyle r214 = null;
        L95:
            if ((r615 & 8388608) == 0) goto L97;
            CusTextStyle r215 = null;
        L99:
            if ((r615 & 16777216) == 0) goto L101;
            LayoutStyle r216 = null;
        L103:
            if ((r615 & 33554432) == 0) goto L105;
            CommonColorStyle r217 = null;
        L107:
            if ((r615 & 67108864) == 0) goto L109;
            LayoutStyle r218 = null;
        L111:
            if ((r615 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
            LayoutStyle r219 = null;
        L115:
            if ((r615 & 268435456) == 0) goto L117;
            VideoLikeStyle r316 = null;
        L119:
            if ((r615 & 536870912) == 0) goto L121;
            Integer r317 = null;
        L123:
            if ((r615 & 1073741824) != 0) goto L126;
            r118 = r614;
        L126:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r316, r317, r118);
            return;
        L121:
            r317 = r613;
            goto L123
        L117:
            r316 = r612;
            goto L119
        L113:
            r219 = r611;
            goto L115
        L109:
            r218 = r610;
            goto L111
        L105:
            r217 = r519;
            goto L107
        L101:
            r216 = r518;
            goto L103
        L97:
            r215 = r517;
            goto L99
        L93:
            r214 = r516;
            goto L95
        L89:
            r213 = r515;
            goto L91
        L85:
            r212 = r514;
            goto L87
        L81:
            r211 = r513;
            goto L83
        L77:
            r210 = r512;
            goto L79
        L73:
            r119 = r511;
            goto L75
        L69:
            r117 = r510;
            goto L70
        L65:
            r116 = r419;
            goto L67
        L61:
            r108 = r418;
            goto L63
        L57:
            r115 = r417;
            goto L59
        L53:
            r114 = r416;
            goto L55
        L49:
            r113 = r415;
            goto L51
        L45:
            r112 = r414;
            goto L47
        L41:
            r111 = r413;
            goto L43
        L37:
            r110 = r412;
            goto L39
        L33:
            r107 = r411;
            goto L35
        L29:
            r106 = r410;
            goto L31
        L25:
            r105 = r315;
            goto L27
        L21:
            r104 = r314;
            goto L23
        L17:
            r103 = r313;
            goto L19
        L13:
            r102 = r312;
            goto L15
        L9:
            r101 = r311;
            goto L11
        L5:
            r100 = r310;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bHÆ\u0003JL\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0004\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "", "recommendInfo", "", "isLifeCard", "", "address", "bcm", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;)V", "getAddress", "()Ljava/lang/String;", "getBcm", "()Ljava/util/Map;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRecommendInfo", "setRecommendInfo", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Extra {

        @SerializedName("address")
        private final String address;

        @SerializedName("bcm")
        private final Map<String, Object> bcm;

        @SerializedName("is_life_card")
        private final Boolean isLifeCard;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
        private String recommendInfo;

        public Extra() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Extra copy$default(Extra r100, String r101, Boolean r102, String r103, Map r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.recommendInfo;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.isLifeCard;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.address;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.bcm;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.recommendInfo;
        }

        public final Boolean component2() {
            return this.isLifeCard;
        }

        public final String component3() {
            return this.address;
        }

        public final Map<String, Object> component4() {
            return this.bcm;
        }

        public final Extra copy(String r100, Boolean r101, String r102, Map<String, ? extends Object> r103) {
            return new Extra(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Extra) == false) goto L14;
            Extra r101 = (Extra) r100;
            if (Intrinsics.areEqual(this.recommendInfo, r101.recommendInfo) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.isLifeCard, r101.isLifeCard) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.address, r101.address) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.bcm, r101.bcm) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r100 = this.recommendInfo;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.isLifeCard;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.address;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Map<String, Object> r110 = this.bcm;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
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
            return "Extra(recommendInfo=" + this.recommendInfo + ", isLifeCard=" + this.isLifeCard + ", address=" + this.address + ", bcm=" + this.bcm + ")";
        }

        public final String getAddress() {
            return this.address;
        }

        public final Map<String, Object> getBcm() {
            return this.bcm;
        }

        public final String getRecommendInfo() {
            return this.recommendInfo;
        }

        public final Boolean isLifeCard() {
            return this.isLifeCard;
        }

        public final void setRecommendInfo(String r100) {
            this.recommendInfo = r100;
        }

        public Extra(String r100, Boolean r101, String r102, Map<String, ? extends Object> r103) {
            this.recommendInfo = r100;
            this.isLifeCard = r101;
            this.address = r102;
            this.bcm = r103;
        }

        public /* synthetic */ Extra(String r100, Boolean r101, String r102, Map r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = Boolean.FALSE;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "", "id", "", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Impression {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private final String f170281id;

        @SerializedName("type")
        private final Integer type;

        /* JADX WARN: Multi-variable type inference failed */
        public Impression() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Impression copy$default(Impression r100, String r101, Integer r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f170281id;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.type;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.f170281id;
        }

        public final Integer component2() {
            return this.type;
        }

        public final Impression copy(String r100, Integer r101) {
            return new Impression(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Impression) == false) goto L10;
            Impression r101 = (Impression) r100;
            if (Intrinsics.areEqual(this.f170281id, r101.f170281id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.f170281id;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.type;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "Impression(id=" + this.f170281id + ", type=" + this.type + ")";
        }

        public final String getId() {
            return this.f170281id;
        }

        public final Integer getType() {
            return this.type;
        }

        public Impression(String r100, Integer r101) {
            this.f170281id = r100;
            this.type = r101;
        }

        public /* synthetic */ Impression(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$InstantRecommendData;", "", "lynxData", "", "lynxSchema", "appendMargin", "", "appendHeight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAppendHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAppendMargin", "getLynxData", "()Ljava/lang/String;", "getLynxSchema", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$InstantRecommendData;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InstantRecommendData {

        @SerializedName("append_height")
        private final Integer appendHeight;

        @SerializedName("append_margin")
        private final Integer appendMargin;

        @SerializedName("lynx_data")
        private final String lynxData;

        @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
        private final String lynxSchema;

        public InstantRecommendData() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ InstantRecommendData copy$default(InstantRecommendData r100, String r101, String r102, Integer r103, Integer r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.lynxData;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.lynxSchema;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.appendMargin;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.appendHeight;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.lynxData;
        }

        public final String component2() {
            return this.lynxSchema;
        }

        public final Integer component3() {
            return this.appendMargin;
        }

        public final Integer component4() {
            return this.appendHeight;
        }

        public final InstantRecommendData copy(String r100, String r101, Integer r102, Integer r103) {
            return new InstantRecommendData(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof InstantRecommendData) == false) goto L14;
            InstantRecommendData r101 = (InstantRecommendData) r100;
            if (Intrinsics.areEqual(this.lynxData, r101.lynxData) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.lynxSchema, r101.lynxSchema) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.appendMargin, r101.appendMargin) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.appendHeight, r101.appendHeight) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r100 = this.lynxData;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.lynxSchema;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.appendMargin;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.appendHeight;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
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
            return "InstantRecommendData(lynxData=" + this.lynxData + ", lynxSchema=" + this.lynxSchema + ", appendMargin=" + this.appendMargin + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Integer getAppendHeight() {
            return this.appendHeight;
        }

        public final Integer getAppendMargin() {
            return this.appendMargin;
        }

        public final String getLynxData() {
            return this.lynxData;
        }

        public final String getLynxSchema() {
            return this.lynxSchema;
        }

        public InstantRecommendData(String r100, String r101, Integer r102, Integer r103) {
            this.lynxData = r100;
            this.lynxSchema = r101;
            this.appendMargin = r102;
            this.appendHeight = r103;
        }

        public /* synthetic */ InstantRecommendData(String r100, String r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "", "returnRewardPrefix", "", "returnReward", "returnRewardUnit", "isNewUser", "transMeta", "returnRewardIcon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "getReturnReward", "getReturnRewardIcon", "getReturnRewardPrefix", "getReturnRewardUnit", "getTransMeta", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MarketingData {

        @SerializedName("is_new_user")
        private final String isNewUser;

        @SerializedName("return_reward")
        private final String returnReward;

        @SerializedName("return_reward_icon")
        private final String returnRewardIcon;

        @SerializedName("return_reward_prefix")
        private final String returnRewardPrefix;

        @SerializedName("return_reward_unit")
        private final String returnRewardUnit;

        @SerializedName("trans_meta")
        private final String transMeta;

        public MarketingData() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ MarketingData copy$default(MarketingData r100, String r101, String r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.returnRewardPrefix;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.returnReward;
        L8:
            String r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.returnRewardUnit;
        L11:
            String r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.isNewUser;
        L14:
            String r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.transMeta;
        L17:
            String r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.returnRewardIcon;
        L20:
            String r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final String component1() {
            return this.returnRewardPrefix;
        }

        public final String component2() {
            return this.returnReward;
        }

        public final String component3() {
            return this.returnRewardUnit;
        }

        public final String component4() {
            return this.isNewUser;
        }

        public final String component5() {
            return this.transMeta;
        }

        public final String component6() {
            return this.returnRewardIcon;
        }

        public final MarketingData copy(String r100, String r110, String r111, String r112, String r113, String r114) {
            return new MarketingData(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof MarketingData) == false) goto L18;
            MarketingData r101 = (MarketingData) r100;
            if (Intrinsics.areEqual(this.returnRewardPrefix, r101.returnRewardPrefix) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.returnReward, r101.returnReward) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.returnRewardUnit, r101.returnRewardUnit) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isNewUser, r101.isNewUser) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.transMeta, r101.transMeta) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.returnRewardIcon, r101.returnRewardIcon) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            String r100 = this.returnRewardPrefix;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.returnReward;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.returnRewardUnit;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.isNewUser;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.transMeta;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.returnRewardIcon;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
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
            return "MarketingData(returnRewardPrefix=" + this.returnRewardPrefix + ", returnReward=" + this.returnReward + ", returnRewardUnit=" + this.returnRewardUnit + ", isNewUser=" + this.isNewUser + ", transMeta=" + this.transMeta + ", returnRewardIcon=" + this.returnRewardIcon + ")";
        }

        public final String getReturnReward() {
            return this.returnReward;
        }

        public final String getReturnRewardIcon() {
            return this.returnRewardIcon;
        }

        public final String getReturnRewardPrefix() {
            return this.returnRewardPrefix;
        }

        public final String getReturnRewardUnit() {
            return this.returnRewardUnit;
        }

        public final String getTransMeta() {
            return this.transMeta;
        }

        public final String isNewUser() {
            return this.isNewUser;
        }

        public MarketingData(String r100, String r101, String r102, String r103, String r104, String r105) {
            this.returnRewardPrefix = r100;
            this.returnReward = r101;
            this.returnRewardUnit = r102;
            this.isNewUser = r103;
            this.transMeta = r104;
            this.returnRewardIcon = r105;
        }

        public /* synthetic */ MarketingData(String r100, String r101, String r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            String r114 = null;
        L7:
            if ((r112 & 2) == 0) goto L9;
            String r104 = null;
        L11:
            if ((r112 & 4) == 0) goto L13;
            String r105 = null;
        L15:
            if ((r112 & 8) == 0) goto L17;
            String r106 = null;
        L19:
            if ((r112 & 16) == 0) goto L21;
            String r107 = null;
        L23:
            if ((r112 & 32) == 0) goto L25;
            String r115 = null;
        L26:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L25:
            r115 = r111;
            goto L26
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L13:
            r105 = r102;
            goto L15
        L9:
            r104 = r101;
            goto L11
        L5:
            r114 = r100;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceCommon;", "Ljava/io/Serializable;", "price", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;", "priceAbove", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "priceLabel", "salesCount", "showTags", "", "styleEnum", "", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getPrice", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;", "getPriceAbove", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "getPriceLabel", "getSalesCount", "getShowTags", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStyleEnum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class PriceCommon implements Serializable {

        @SerializedName("price")
        private final PriceContent price;

        @SerializedName("price_above")
        private final TextBaseUIParams priceAbove;

        @SerializedName("price_label")
        private final TextBaseUIParams priceLabel;

        @SerializedName("sales_count")
        private final TextBaseUIParams salesCount;

        @SerializedName("show_tags")
        private final Boolean showTags;

        @SerializedName("style_enum")
        private final Integer styleEnum;

        public PriceCommon() {
            this(null, null, null, null, null, null, 63, null);
        }

        public final PriceContent getPrice() {
            return this.price;
        }

        public final TextBaseUIParams getPriceAbove() {
            return this.priceAbove;
        }

        public final TextBaseUIParams getPriceLabel() {
            return this.priceLabel;
        }

        public final TextBaseUIParams getSalesCount() {
            return this.salesCount;
        }

        public final Boolean getShowTags() {
            return this.showTags;
        }

        public final Integer getStyleEnum() {
            return this.styleEnum;
        }

        public PriceCommon(PriceContent r100, TextBaseUIParams r101, TextBaseUIParams r102, TextBaseUIParams r103, Boolean r104, Integer r105) {
            this.price = r100;
            this.priceAbove = r101;
            this.priceLabel = r102;
            this.salesCount = r103;
            this.showTags = r104;
            this.styleEnum = r105;
        }

        public /* synthetic */ PriceCommon(PriceContent r100, TextBaseUIParams r101, TextBaseUIParams r102, TextBaseUIParams r103, Boolean r110, Integer r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            PriceContent r114 = null;
        L7:
            if ((r112 & 2) == 0) goto L9;
            TextBaseUIParams r104 = null;
        L11:
            if ((r112 & 4) == 0) goto L13;
            TextBaseUIParams r105 = null;
        L15:
            if ((r112 & 8) == 0) goto L17;
            TextBaseUIParams r106 = null;
        L19:
            if ((r112 & 16) == 0) goto L21;
            Boolean r107 = null;
        L23:
            if ((r112 & 32) == 0) goto L25;
            Integer r115 = null;
        L26:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L25:
            r115 = r111;
            goto L26
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L13:
            r105 = r102;
            goto L15
        L9:
            r104 = r101;
            goto L11
        L5:
            r114 = r100;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$PriceContent;", "", "symbol", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "integers", "decimal", Scraps.INNER_UNIT, "style", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;)V", "getDecimal", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/TextBaseUIParams;", "getIntegers", "getStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ProductStyle;", "getSymbol", "getUnit", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PriceContent {

        @SerializedName("decimals")
        private final TextBaseUIParams decimal;

        @SerializedName("integers")
        private final TextBaseUIParams integers;

        @SerializedName("client_style")
        private final ProductStyle style;

        @SerializedName("symbol")
        private final TextBaseUIParams symbol;

        @SerializedName(Scraps.INNER_UNIT)
        private final TextBaseUIParams unit;

        public PriceContent() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ PriceContent copy$default(PriceContent r100, TextBaseUIParams r101, TextBaseUIParams r102, TextBaseUIParams r103, TextBaseUIParams r104, ProductStyle r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.symbol;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.integers;
        L8:
            TextBaseUIParams r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.decimal;
        L11:
            TextBaseUIParams r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.unit;
        L14:
            TextBaseUIParams r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.style;
        L17:
            TextBaseUIParams r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final TextBaseUIParams component1() {
            return this.symbol;
        }

        public final TextBaseUIParams component2() {
            return this.integers;
        }

        public final TextBaseUIParams component3() {
            return this.decimal;
        }

        public final TextBaseUIParams component4() {
            return this.unit;
        }

        public final ProductStyle component5() {
            return this.style;
        }

        public final PriceContent copy(TextBaseUIParams r100, TextBaseUIParams r101, TextBaseUIParams r110, TextBaseUIParams r111, ProductStyle r112) {
            return new PriceContent(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof PriceContent) == false) goto L16;
            PriceContent r101 = (PriceContent) r100;
            if (Intrinsics.areEqual(this.symbol, r101.symbol) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.integers, r101.integers) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.decimal, r101.decimal) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.unit, r101.unit) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.style, r101.style) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            TextBaseUIParams r100 = this.symbol;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            TextBaseUIParams r104 = this.integers;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            TextBaseUIParams r107 = this.decimal;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            TextBaseUIParams r110 = this.unit;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            ProductStyle r113 = this.style;
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
            return "PriceContent(symbol=" + this.symbol + ", integers=" + this.integers + ", decimal=" + this.decimal + ", unit=" + this.unit + ", style=" + this.style + ")";
        }

        public final TextBaseUIParams getDecimal() {
            return this.decimal;
        }

        public final TextBaseUIParams getIntegers() {
            return this.integers;
        }

        public final ProductStyle getStyle() {
            return this.style;
        }

        public final TextBaseUIParams getSymbol() {
            return this.symbol;
        }

        public final TextBaseUIParams getUnit() {
            return this.unit;
        }

        public PriceContent(TextBaseUIParams r100, TextBaseUIParams r101, TextBaseUIParams r102, TextBaseUIParams r103, ProductStyle r104) {
            this.symbol = r100;
            this.integers = r101;
            this.decimal = r102;
            this.unit = r103;
            this.style = r104;
        }

        public /* synthetic */ PriceContent(TextBaseUIParams r100, TextBaseUIParams r101, TextBaseUIParams r102, TextBaseUIParams r103, ProductStyle r104, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L5;
            TextBaseUIParams r112 = null;
        L7:
            if ((r110 & 2) == 0) goto L9;
            TextBaseUIParams r105 = null;
        L11:
            if ((r110 & 4) == 0) goto L13;
            TextBaseUIParams r106 = null;
        L15:
            if ((r110 & 8) == 0) goto L17;
            TextBaseUIParams r107 = null;
        L19:
            if ((r110 & 16) == 0) goto L21;
            ProductStyle r113 = null;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001:\trstuvwxyzBÍ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\u0012\b\u0002\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010)J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010W\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010[\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0013\u0010`\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010(HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010+J\u0013\u0010f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÖ\u0002\u0010k\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0012\b\u0002\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(HÆ\u0001¢\u0006\u0002\u0010lJ\u0013\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010p\u001a\u00020\bHÖ\u0001J\t\u0010q\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u001a\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b/\u0010+R \u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0018\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010;R\u0018\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010;R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010;R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010;R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\bK\u0010+R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010;R\u0018\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u00101R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010;¨\u0006{"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "", "productId", "", "cover", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "title", SalesInfoStruct.SALES, "", PromotionProductPrivilegesStruct.TAGS, "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$TagItem;", "price", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;", "kolId", "secKolId", "promotionId", "commodityType", "recommendInfo", "productActivity", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;", "recReason", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;", "bizKind", "productIcon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;", "iconName", "extra", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;", "campaginSales", "campaginStock", "coverLong", "coverRecommend", "platformTextActivity", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$MarketingFloors;", "coupons", "shopInfo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;", "link", "decorationParam", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$MarketingFloors;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;)V", "getBizKind", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCampaginSales", "getCampaginStock", "getCommodityType", "getCoupons", "()Ljava/util/List;", "getCover", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "getCoverLong", "getCoverRecommend", "getDecorationParam", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;", "getIconName", "()Ljava/lang/String;", "getKolId", "getLink", "getPlatformTextActivity", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$MarketingFloors;", "getPrice", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;", "getProductActivity", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;", "getProductIcon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;", "getProductId", "getPromotionId", "getRecReason", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;", "getRecommendInfo", "getSales", "getSecKolId", "getShopInfo", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;", "getTags", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$MarketingFloors;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "equals", "", "other", "hashCode", "toString", "DecorationParam", "Extra", "MarketingFloors", "Price", "ProductActivity", "ProductIcon", "RecReason", "ShopInfo", "TagItem", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Product {

        @SerializedName("biz_kind")
        private final Integer bizKind;

        @SerializedName("campagin_sales")
        private final Integer campaginSales;

        @SerializedName("campagin_stock")
        private final Integer campaginStock;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE)
        private final Integer commodityType;

        @SerializedName("coupons")
        private final List<Object> coupons;

        @SerializedName("cover")
        private final UrlStruct cover;

        @SerializedName("cover_long")
        private final UrlStruct coverLong;

        @SerializedName("cover_recommend")
        private final UrlStruct coverRecommend;

        @SerializedName("decoration_param")
        private final DecorationParam decorationParam;

        @SerializedName("extra")
        private final Extra extra;

        @SerializedName("icon_name")
        private final String iconName;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_KOL_ID)
        private final String kolId;

        @SerializedName("link")
        private final String link;

        @SerializedName("platform_text_activity")
        private final MarketingFloors platformTextActivity;

        @SerializedName("price")
        private final Price price;

        @SerializedName("product_activity")
        private final ProductActivity productActivity;

        @SerializedName("product_icon")
        private final ProductIcon productIcon;

        @SerializedName("product_id")
        private final String productId;

        @SerializedName("promotion_id")
        private final String promotionId;

        @SerializedName("rec_reason")
        private final RecReason recReason;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
        private final String recommendInfo;

        @SerializedName(SalesInfoStruct.SALES)
        private final Integer sales;

        @SerializedName("sec_kol_id")
        private final String secKolId;

        @SerializedName("shop_info")
        private final ShopInfo shopInfo;

        @SerializedName(PromotionProductPrivilegesStruct.TAGS)
        private final List<TagItem> tags;

        @SerializedName("title")
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;", "", "showBorder", "", "tagText", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getShowBorder", "()Ljava/lang/Boolean;", "setShowBorder", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTagText", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$DecorationParam;", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class DecorationParam {

            @SerializedName("show_border")
            private Boolean showBorder;

            @SerializedName("tag_text")
            private final String tagText;

            /* JADX WARN: Multi-variable type inference failed */
            public DecorationParam() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ DecorationParam copy$default(DecorationParam r100, Boolean r101, String r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.showBorder;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.tagText;
            L9:
                return r100.copy(r101, r102);
            }

            public final Boolean component1() {
                return this.showBorder;
            }

            public final String component2() {
                return this.tagText;
            }

            public final DecorationParam copy(Boolean r100, String r101) {
                return new DecorationParam(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof DecorationParam) == false) goto L10;
                DecorationParam r101 = (DecorationParam) r100;
                if (Intrinsics.areEqual(this.showBorder, r101.showBorder) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.tagText, r101.tagText) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                Boolean r100 = this.showBorder;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.tagText;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "DecorationParam(showBorder=" + this.showBorder + ", tagText=" + this.tagText + ")";
            }

            public final Boolean getShowBorder() {
                return this.showBorder;
            }

            public final String getTagText() {
                return this.tagText;
            }

            public final void setShowBorder(Boolean r100) {
                this.showBorder = r100;
            }

            public DecorationParam(Boolean r100, String r101) {
                this.showBorder = r100;
                this.tagText = r101;
            }

            public /* synthetic */ DecorationParam(Boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\tHÆ\u0003J^\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;", "", "insuranceCommodityFlag", "", "similarLink", "", "coverIsWhiteBg", "isLiveCurrentProduct", "isSmartCoverlong", "", "titleType", "isCoverInPool", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Z)V", "getCoverIsWhiteBg", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInsuranceCommodityFlag", "()Z", "()Ljava/lang/String;", "getSimilarLink", "getTitleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Z)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Extra;", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Extra {

            @SerializedName("cover_is_white_bg")
            private final Integer coverIsWhiteBg;

            @SerializedName("insurance_commodity_flag")
            private final Integer insuranceCommodityFlag;

            @SerializedName("is_cover_in_pool")
            private final boolean isCoverInPool;

            @SerializedName("is_live_current_product")
            private final String isLiveCurrentProduct;

            @SerializedName("is_smart_coverlong")
            private final boolean isSmartCoverlong;

            @SerializedName("similar_link")
            private final String similarLink;

            @SerializedName("title_type")
            private final Integer titleType;

            public Extra() {
                this(null, null, null, null, false, null, false, 127, null);
            }

            public static /* synthetic */ Extra copy$default(Extra r100, Integer r101, String r102, Integer r103, String r104, boolean r110, Integer r111, boolean r112, int r113, Object r114) {
                if ((r113 & 1) == 0) goto L6;
                r101 = r100.insuranceCommodityFlag;
            L6:
                if ((r113 & 2) == 0) goto L8;
                r102 = r100.similarLink;
            L8:
                String r115 = r102;
                if ((r113 & 4) == 0) goto L11;
                r103 = r100.coverIsWhiteBg;
            L11:
                Integer r105 = r103;
                if ((r113 & 8) == 0) goto L14;
                r104 = r100.isLiveCurrentProduct;
            L14:
                String r106 = r104;
                if ((r113 & 16) == 0) goto L17;
                r110 = r100.isSmartCoverlong;
            L17:
                boolean r107 = r110;
                if ((r113 & 32) == 0) goto L20;
                r111 = r100.titleType;
            L20:
                Integer r108 = r111;
                if ((r113 & 64) == 0) goto L23;
                r112 = r100.isCoverInPool;
            L23:
                Integer r109 = r101;
                return r100.copy(r109, r115, r105, r106, r107, r108, r112);
            }

            public final Integer component1() {
                return this.insuranceCommodityFlag;
            }

            public final String component2() {
                return this.similarLink;
            }

            public final Integer component3() {
                return this.coverIsWhiteBg;
            }

            public final String component4() {
                return this.isLiveCurrentProduct;
            }

            public final boolean component5() {
                return this.isSmartCoverlong;
            }

            public final Integer component6() {
                return this.titleType;
            }

            public final boolean component7() {
                return this.isCoverInPool;
            }

            public final Extra copy(Integer r110, String r111, Integer r112, String r113, boolean r114, Integer r115, boolean r116) {
                return new Extra(r110, r111, r112, r113, r114, r115, r116);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Extra) == false) goto L20;
                Extra r101 = (Extra) r100;
                if (Intrinsics.areEqual(this.insuranceCommodityFlag, r101.insuranceCommodityFlag) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.similarLink, r101.similarLink) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.coverIsWhiteBg, r101.coverIsWhiteBg) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.isLiveCurrentProduct, r101.isLiveCurrentProduct) == true) goto L14;
                return false;
            L14:
                if (this.isSmartCoverlong == r101.isSmartCoverlong) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.titleType, r101.titleType) == true) goto L18;
                return false;
            L18:
                if (this.isCoverInPool == r101.isCoverInPool) goto L31;
                return false;
            L31:
                return true;
            L20:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r2v10, types: [int] */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                Integer r100 = this.insuranceCommodityFlag;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.similarLink;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Integer r107 = this.coverIsWhiteBg;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                String r110 = this.isLiveCurrentProduct;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                boolean r113 = this.isSmartCoverlong;
                ?? r114 = 1;
                ?? r115 = r113;
                if (r113 == false) goto L21;
                r115 = 1;
            L21:
                int r116 = (r112 + r115) * 31;
                Integer r117 = this.titleType;
                if (r117 == null) goto L24;
                r101 = r117.hashCode();
            L24:
                int r118 = (r116 + r101) * 31;
                boolean r119 = this.isCoverInPool;
                if (r119 == true) goto L29;
                r114 = r119;
            L29:
                return r118 + r114;
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
                return "Extra(insuranceCommodityFlag=" + this.insuranceCommodityFlag + ", similarLink=" + this.similarLink + ", coverIsWhiteBg=" + this.coverIsWhiteBg + ", isLiveCurrentProduct=" + this.isLiveCurrentProduct + ", isSmartCoverlong=" + this.isSmartCoverlong + ", titleType=" + this.titleType + ", isCoverInPool=" + this.isCoverInPool + ")";
            }

            public final Integer getCoverIsWhiteBg() {
                return this.coverIsWhiteBg;
            }

            public final Integer getInsuranceCommodityFlag() {
                return this.insuranceCommodityFlag;
            }

            public final String getSimilarLink() {
                return this.similarLink;
            }

            public final Integer getTitleType() {
                return this.titleType;
            }

            public final boolean isCoverInPool() {
                return this.isCoverInPool;
            }

            public final String isLiveCurrentProduct() {
                return this.isLiveCurrentProduct;
            }

            public final boolean isSmartCoverlong() {
                return this.isSmartCoverlong;
            }

            public Extra(Integer r100, String r101, Integer r102, String r103, boolean r104, Integer r105, boolean r106) {
                this.insuranceCommodityFlag = r100;
                this.similarLink = r101;
                this.coverIsWhiteBg = r102;
                this.isLiveCurrentProduct = r103;
                this.isSmartCoverlong = r104;
                this.titleType = r105;
                this.isCoverInPool = r106;
            }

            public /* synthetic */ Extra(Integer r100, String r101, Integer r102, String r103, boolean r110, Integer r111, boolean r112, int r113, DefaultConstructorMarker r114) {
                Integer r104 = null;
                if ((r113 & 1) == 0) goto L5;
                Integer r115 = null;
            L7:
                if ((r113 & 2) == 0) goto L9;
                String r105 = null;
            L11:
                if ((r113 & 4) == 0) goto L13;
                Integer r106 = null;
            L15:
                if ((r113 & 8) == 0) goto L17;
                String r107 = null;
            L19:
                if ((r113 & 16) == 0) goto L21;
                boolean r108 = false;
            L23:
                if ((r113 & 32) != 0) goto L27;
                r104 = r111;
            L27:
                if ((r113 & 64) == 0) goto L29;
                boolean r116 = false;
            L30:
                this(r115, r105, r106, r107, r108, r104, r116);
                return;
            L29:
                r116 = r112;
                goto L30
            L21:
                r108 = r110;
                goto L23
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
                r115 = r100;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$MarketingFloors;", "", "title", "", "icon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;)V", "getIcon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class MarketingFloors {

            @SerializedName("icon")
            private final UrlStruct icon;

            @SerializedName("title")
            private final String title;

            /* JADX WARN: Multi-variable type inference failed */
            public MarketingFloors() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ MarketingFloors copy$default(MarketingFloors r100, String r101, UrlStruct r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.title;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.icon;
            L9:
                return r100.copy(r101, r102);
            }

            public final String component1() {
                return this.title;
            }

            public final UrlStruct component2() {
                return this.icon;
            }

            public final MarketingFloors copy(String r100, UrlStruct r101) {
                return new MarketingFloors(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof MarketingFloors) == false) goto L10;
                MarketingFloors r101 = (MarketingFloors) r100;
                if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                String r100 = this.title;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                UrlStruct r104 = this.icon;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "MarketingFloors(title=" + this.title + ", icon=" + this.icon + ")";
            }

            public final UrlStruct getIcon() {
                return this.icon;
            }

            public final String getTitle() {
                return this.title;
            }

            public MarketingFloors(String r100, UrlStruct r101) {
                this.title = r100;
                this.icon = r101;
            }

            public /* synthetic */ MarketingFloors(String r100, UrlStruct r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;", "", "minPrice", "", "maxPrice", "marketPrice", "typeText", "", "type", "hotSaleSkuId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getHotSaleSkuId", "()Ljava/lang/String;", "getMarketPrice", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxPrice", "getMinPrice", "getType", "getTypeText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$Price;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Price {

            @SerializedName("hot_sale_sku_id")
            private final String hotSaleSkuId;

            @SerializedName("market_price")
            private final Integer marketPrice;

            @SerializedName("max_price")
            private final Integer maxPrice;

            @SerializedName("min_price")
            private final Integer minPrice;

            @SerializedName("type")
            private final Integer type;

            @SerializedName("type_text")
            private final String typeText;

            public Price() {
                this(null, null, null, null, null, null, 63, null);
            }

            public static /* synthetic */ Price copy$default(Price r100, Integer r101, Integer r102, Integer r103, String r104, Integer r105, String r110, int r111, Object r112) {
                if ((r111 & 1) == 0) goto L6;
                r101 = r100.minPrice;
            L6:
                if ((r111 & 2) == 0) goto L8;
                r102 = r100.maxPrice;
            L8:
                Integer r113 = r102;
                if ((r111 & 4) == 0) goto L11;
                r103 = r100.marketPrice;
            L11:
                Integer r106 = r103;
                if ((r111 & 8) == 0) goto L14;
                r104 = r100.typeText;
            L14:
                String r107 = r104;
                if ((r111 & 16) == 0) goto L17;
                r105 = r100.type;
            L17:
                Integer r108 = r105;
                if ((r111 & 32) == 0) goto L20;
                r110 = r100.hotSaleSkuId;
            L20:
                Integer r109 = r101;
                return r100.copy(r109, r113, r106, r107, r108, r110);
            }

            public final Integer component1() {
                return this.minPrice;
            }

            public final Integer component2() {
                return this.maxPrice;
            }

            public final Integer component3() {
                return this.marketPrice;
            }

            public final String component4() {
                return this.typeText;
            }

            public final Integer component5() {
                return this.type;
            }

            public final String component6() {
                return this.hotSaleSkuId;
            }

            public final Price copy(Integer r100, Integer r110, Integer r111, String r112, Integer r113, String r114) {
                return new Price(r100, r110, r111, r112, r113, r114);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Price) == false) goto L18;
                Price r101 = (Price) r100;
                if (Intrinsics.areEqual(this.minPrice, r101.minPrice) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.maxPrice, r101.maxPrice) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.marketPrice, r101.marketPrice) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.typeText, r101.typeText) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.type, r101.type) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.hotSaleSkuId, r101.hotSaleSkuId) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public int hashCode() {
                Integer r100 = this.minPrice;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                Integer r104 = this.maxPrice;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Integer r107 = this.marketPrice;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                String r110 = this.typeText;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                Integer r113 = this.type;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                String r116 = this.hotSaleSkuId;
                if (r116 == null) goto L26;
                r101 = r116.hashCode();
            L26:
                return r115 + r101;
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
                return "Price(minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", marketPrice=" + this.marketPrice + ", typeText=" + this.typeText + ", type=" + this.type + ", hotSaleSkuId=" + this.hotSaleSkuId + ")";
            }

            public final String getHotSaleSkuId() {
                return this.hotSaleSkuId;
            }

            public final Integer getMarketPrice() {
                return this.marketPrice;
            }

            public final Integer getMaxPrice() {
                return this.maxPrice;
            }

            public final Integer getMinPrice() {
                return this.minPrice;
            }

            public final Integer getType() {
                return this.type;
            }

            public final String getTypeText() {
                return this.typeText;
            }

            public Price(Integer r100, Integer r101, Integer r102, String r103, Integer r104, String r105) {
                this.minPrice = r100;
                this.maxPrice = r101;
                this.marketPrice = r102;
                this.typeText = r103;
                this.type = r104;
                this.hotSaleSkuId = r105;
            }

            public /* synthetic */ Price(Integer r100, Integer r101, Integer r102, String r103, Integer r110, String r111, int r112, DefaultConstructorMarker r113) {
                if ((r112 & 1) == 0) goto L5;
                Integer r114 = null;
            L7:
                if ((r112 & 2) == 0) goto L9;
                Integer r104 = null;
            L11:
                if ((r112 & 4) == 0) goto L13;
                Integer r105 = null;
            L15:
                if ((r112 & 8) == 0) goto L17;
                String r106 = null;
            L19:
                if ((r112 & 16) == 0) goto L21;
                Integer r107 = null;
            L23:
                if ((r112 & 32) == 0) goto L25;
                String r115 = null;
            L26:
                this(r114, r104, r105, r106, r107, r115);
                return;
            L25:
                r115 = r111;
                goto L26
            L21:
                r107 = r110;
                goto L23
            L17:
                r106 = r103;
                goto L19
            L13:
                r105 = r102;
                goto L15
            L9:
                r104 = r101;
                goto L11
            L5:
                r114 = r100;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;", "", "activityType", "", "activityConfData", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getActivityConfData", "()Ljava/lang/String;", "getActivityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity;", "equals", "", "other", "hashCode", "toString", "ProductActivityInfoData", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ProductActivity {

            @SerializedName("activity_conf_data")
            private final String activityConfData;

            @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_TYPE)
            private final Integer activityType;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002CDBÑ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÕ\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006E"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData;", "", "productActivityType", "", "title", "subTitle", "styleType", "styleData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$StyleData;", "feLogo", "innerShopUrl", "innerInsertType", "innerInsertObj", "link", "resourceId", "sellingPointsInfo", "innerTopicInfo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$InnerTopicInfo;", "topicTag", "innerType", "blockName", "sceneId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$StyleData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$InnerTopicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBlockName", "()Ljava/lang/String;", "getFeLogo", "getInnerInsertObj", "getInnerInsertType", "getInnerShopUrl", "getInnerTopicInfo", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$InnerTopicInfo;", "getInnerType", "getLink", "getProductActivityType", "getResourceId", "getSceneId", "getSellingPointsInfo", "getStyleData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$StyleData;", "getStyleType", "getSubTitle", "getTitle", "getTopicTag", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "InnerTopicInfo", "StyleData", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
            public static final class ProductActivityInfoData {

                @SerializedName("block_name")
                private final String blockName;

                @SerializedName("fe_logo")
                private final String feLogo;

                @SerializedName("inner_insert_obj")
                private final String innerInsertObj;

                @SerializedName("inner_insert_type")
                private final String innerInsertType;

                @SerializedName("inner_shop_url")
                private final String innerShopUrl;

                @SerializedName("inner_topic_info")
                private final InnerTopicInfo innerTopicInfo;

                @SerializedName("inner_type")
                private final String innerType;

                @SerializedName("link")
                private final String link;

                @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE)
                private final String productActivityType;

                @SerializedName("resource_id")
                private final String resourceId;

                @SerializedName("scene_id")
                private final String sceneId;

                @SerializedName("selling_points_info")
                private final String sellingPointsInfo;

                @SerializedName("style_data")
                private final StyleData styleData;

                @SerializedName(MapMonitorConst.STYLE_TYPE)
                private final String styleType;

                @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
                private final String subTitle;

                @SerializedName("title")
                private final String title;

                @SerializedName("topic_tag")
                private final String topicTag;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$InnerTopicInfo;", "", "topicId", "", "topicText", "schemaType", "labelType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLabelType", "()Ljava/lang/String;", "getSchemaType", "getTopicId", "getTopicText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
                public static final class InnerTopicInfo {

                    @SerializedName("label_type")
                    private final String labelType;

                    @SerializedName("schema_type")
                    private final String schemaType;

                    @SerializedName("topic_id")
                    private final String topicId;

                    @SerializedName("topic_text")
                    private final String topicText;

                    public InnerTopicInfo() {
                        this(null, null, null, null, 15, null);
                    }

                    public static /* synthetic */ InnerTopicInfo copy$default(InnerTopicInfo r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
                        if ((r105 & 1) == 0) goto L6;
                        r101 = r100.topicId;
                    L6:
                        if ((r105 & 2) == 0) goto L9;
                        r102 = r100.topicText;
                    L9:
                        if ((r105 & 4) == 0) goto L12;
                        r103 = r100.schemaType;
                    L12:
                        if ((r105 & 8) == 0) goto L15;
                        r104 = r100.labelType;
                    L15:
                        return r100.copy(r101, r102, r103, r104);
                    }

                    public final String component1() {
                        return this.topicId;
                    }

                    public final String component2() {
                        return this.topicText;
                    }

                    public final String component3() {
                        return this.schemaType;
                    }

                    public final String component4() {
                        return this.labelType;
                    }

                    public final InnerTopicInfo copy(String r100, String r101, String r102, String r103) {
                        return new InnerTopicInfo(r100, r101, r102, r103);
                    }

                    public boolean equals(Object r100) {
                        if (this != r100) goto L4;
                        return true;
                    L4:
                        if ((r100 instanceof InnerTopicInfo) == false) goto L14;
                        InnerTopicInfo r101 = (InnerTopicInfo) r100;
                        if (Intrinsics.areEqual(this.topicId, r101.topicId) == true) goto L8;
                        return false;
                    L8:
                        if (Intrinsics.areEqual(this.topicText, r101.topicText) == true) goto L10;
                        return false;
                    L10:
                        if (Intrinsics.areEqual(this.schemaType, r101.schemaType) == true) goto L12;
                        return false;
                    L12:
                        if (Intrinsics.areEqual(this.labelType, r101.labelType) == true) goto L22;
                        return false;
                    L22:
                        return true;
                    L14:
                        return false;
                    }

                    public int hashCode() {
                        String r100 = this.topicId;
                        int r101 = 0;
                        if (r100 == null) goto L5;
                        int r102 = r100.hashCode();
                    L6:
                        int r103 = r102 * 31;
                        String r104 = this.topicText;
                        if (r104 == null) goto L9;
                        int r105 = r104.hashCode();
                    L10:
                        int r106 = (r103 + r105) * 31;
                        String r107 = this.schemaType;
                        if (r107 == null) goto L13;
                        int r108 = r107.hashCode();
                    L14:
                        int r109 = (r106 + r108) * 31;
                        String r110 = this.labelType;
                        if (r110 == null) goto L18;
                        r101 = r110.hashCode();
                    L18:
                        return r109 + r101;
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
                        return "InnerTopicInfo(topicId=" + this.topicId + ", topicText=" + this.topicText + ", schemaType=" + this.schemaType + ", labelType=" + this.labelType + ")";
                    }

                    public final String getLabelType() {
                        return this.labelType;
                    }

                    public final String getSchemaType() {
                        return this.schemaType;
                    }

                    public final String getTopicId() {
                        return this.topicId;
                    }

                    public final String getTopicText() {
                        return this.topicText;
                    }

                    public InnerTopicInfo(String r100, String r101, String r102, String r103) {
                        this.topicId = r100;
                        this.topicText = r101;
                        this.schemaType = r102;
                        this.labelType = r103;
                    }

                    public /* synthetic */ InnerTopicInfo(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
                        if ((r104 & 1) == 0) goto L6;
                        r100 = null;
                    L6:
                        if ((r104 & 2) == 0) goto L9;
                        r101 = null;
                    L9:
                        if ((r104 & 4) == 0) goto L12;
                        r102 = null;
                    L12:
                        if ((r104 & 8) == 0) goto L14;
                        r103 = null;
                    L14:
                        this(r100, r101, r102, r103);
                    }
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductActivity$ProductActivityInfoData$StyleData;", "", "feBgurl", "", "feFontColor", "feLogoDefault", "innerBgurl", "innerFontColor", "topicBgurl", "feTopicBgurl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeBgurl", "()Ljava/lang/String;", "getFeFontColor", "getFeLogoDefault", "getFeTopicBgurl", "getInnerBgurl", "getInnerFontColor", "getTopicBgurl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
                public static final class StyleData {

                    @SerializedName("fe_bgurl")
                    private final String feBgurl;

                    @SerializedName("fe_font_color")
                    private final String feFontColor;

                    @SerializedName("fe_logo_default")
                    private final String feLogoDefault;

                    @SerializedName("fe_topic_bgurl")
                    private final String feTopicBgurl;

                    @SerializedName("inner_bgurl")
                    private final String innerBgurl;

                    @SerializedName("inner_font_color")
                    private final String innerFontColor;

                    @SerializedName("topic_bgurl")
                    private final String topicBgurl;

                    public StyleData() {
                        this(null, null, null, null, null, null, null, 127, null);
                    }

                    public static /* synthetic */ StyleData copy$default(StyleData r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
                        if ((r113 & 1) == 0) goto L6;
                        r101 = r100.feBgurl;
                    L6:
                        if ((r113 & 2) == 0) goto L8;
                        r102 = r100.feFontColor;
                    L8:
                        String r115 = r102;
                        if ((r113 & 4) == 0) goto L11;
                        r103 = r100.feLogoDefault;
                    L11:
                        String r105 = r103;
                        if ((r113 & 8) == 0) goto L14;
                        r104 = r100.innerBgurl;
                    L14:
                        String r106 = r104;
                        if ((r113 & 16) == 0) goto L17;
                        r110 = r100.innerFontColor;
                    L17:
                        String r107 = r110;
                        if ((r113 & 32) == 0) goto L20;
                        r111 = r100.topicBgurl;
                    L20:
                        String r108 = r111;
                        if ((r113 & 64) == 0) goto L23;
                        r112 = r100.feTopicBgurl;
                    L23:
                        String r109 = r101;
                        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
                    }

                    public final String component1() {
                        return this.feBgurl;
                    }

                    public final String component2() {
                        return this.feFontColor;
                    }

                    public final String component3() {
                        return this.feLogoDefault;
                    }

                    public final String component4() {
                        return this.innerBgurl;
                    }

                    public final String component5() {
                        return this.innerFontColor;
                    }

                    public final String component6() {
                        return this.topicBgurl;
                    }

                    public final String component7() {
                        return this.feTopicBgurl;
                    }

                    public final StyleData copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116) {
                        return new StyleData(r110, r111, r112, r113, r114, r115, r116);
                    }

                    public boolean equals(Object r100) {
                        if (this != r100) goto L4;
                        return true;
                    L4:
                        if ((r100 instanceof StyleData) == false) goto L20;
                        StyleData r101 = (StyleData) r100;
                        if (Intrinsics.areEqual(this.feBgurl, r101.feBgurl) == true) goto L8;
                        return false;
                    L8:
                        if (Intrinsics.areEqual(this.feFontColor, r101.feFontColor) == true) goto L10;
                        return false;
                    L10:
                        if (Intrinsics.areEqual(this.feLogoDefault, r101.feLogoDefault) == true) goto L12;
                        return false;
                    L12:
                        if (Intrinsics.areEqual(this.innerBgurl, r101.innerBgurl) == true) goto L14;
                        return false;
                    L14:
                        if (Intrinsics.areEqual(this.innerFontColor, r101.innerFontColor) == true) goto L16;
                        return false;
                    L16:
                        if (Intrinsics.areEqual(this.topicBgurl, r101.topicBgurl) == true) goto L18;
                        return false;
                    L18:
                        if (Intrinsics.areEqual(this.feTopicBgurl, r101.feTopicBgurl) == true) goto L31;
                        return false;
                    L31:
                        return true;
                    L20:
                        return false;
                    }

                    public int hashCode() {
                        String r100 = this.feBgurl;
                        int r101 = 0;
                        if (r100 == null) goto L5;
                        int r102 = r100.hashCode();
                    L6:
                        int r103 = r102 * 31;
                        String r104 = this.feFontColor;
                        if (r104 == null) goto L9;
                        int r105 = r104.hashCode();
                    L10:
                        int r106 = (r103 + r105) * 31;
                        String r107 = this.feLogoDefault;
                        if (r107 == null) goto L13;
                        int r108 = r107.hashCode();
                    L14:
                        int r109 = (r106 + r108) * 31;
                        String r110 = this.innerBgurl;
                        if (r110 == null) goto L17;
                        int r111 = r110.hashCode();
                    L18:
                        int r112 = (r109 + r111) * 31;
                        String r113 = this.innerFontColor;
                        if (r113 == null) goto L21;
                        int r114 = r113.hashCode();
                    L22:
                        int r115 = (r112 + r114) * 31;
                        String r116 = this.topicBgurl;
                        if (r116 == null) goto L25;
                        int r117 = r116.hashCode();
                    L26:
                        int r118 = (r115 + r117) * 31;
                        String r119 = this.feTopicBgurl;
                        if (r119 == null) goto L30;
                        r101 = r119.hashCode();
                    L30:
                        return r118 + r101;
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
                        return "StyleData(feBgurl=" + this.feBgurl + ", feFontColor=" + this.feFontColor + ", feLogoDefault=" + this.feLogoDefault + ", innerBgurl=" + this.innerBgurl + ", innerFontColor=" + this.innerFontColor + ", topicBgurl=" + this.topicBgurl + ", feTopicBgurl=" + this.feTopicBgurl + ")";
                    }

                    public final String getFeBgurl() {
                        return this.feBgurl;
                    }

                    public final String getFeFontColor() {
                        return this.feFontColor;
                    }

                    public final String getFeLogoDefault() {
                        return this.feLogoDefault;
                    }

                    public final String getFeTopicBgurl() {
                        return this.feTopicBgurl;
                    }

                    public final String getInnerBgurl() {
                        return this.innerBgurl;
                    }

                    public final String getInnerFontColor() {
                        return this.innerFontColor;
                    }

                    public final String getTopicBgurl() {
                        return this.topicBgurl;
                    }

                    public StyleData(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
                        this.feBgurl = r100;
                        this.feFontColor = r101;
                        this.feLogoDefault = r102;
                        this.innerBgurl = r103;
                        this.innerFontColor = r104;
                        this.topicBgurl = r105;
                        this.feTopicBgurl = r106;
                    }

                    public /* synthetic */ StyleData(String r100, String r101, String r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
                        if ((r114 & 1) == 0) goto L5;
                        String r116 = null;
                    L7:
                        if ((r114 & 2) == 0) goto L9;
                        String r103 = null;
                    L11:
                        if ((r114 & 4) == 0) goto L13;
                        String r104 = null;
                    L15:
                        if ((r114 & 8) == 0) goto L17;
                        String r105 = null;
                    L19:
                        if ((r114 & 16) == 0) goto L21;
                        String r106 = null;
                    L23:
                        if ((r114 & 32) == 0) goto L25;
                        String r107 = null;
                    L27:
                        if ((r114 & 64) == 0) goto L29;
                        String r117 = null;
                    L30:
                        this(r116, r103, r104, r105, r106, r107, r117);
                        return;
                    L29:
                        r117 = r113;
                        goto L30
                    L25:
                        r107 = r112;
                        goto L27
                    L21:
                        r106 = r111;
                        goto L23
                    L17:
                        r105 = r110;
                        goto L19
                    L13:
                        r104 = r102;
                        goto L15
                    L9:
                        r103 = r101;
                        goto L11
                    L5:
                        r116 = r100;
                        goto L7
                    }
                }

                public ProductActivityInfoData() {
                    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
                }

                public static /* synthetic */ ProductActivityInfoData copy$default(ProductActivityInfoData r110, String r111, String r112, String r210, String r211, StyleData r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, InnerTopicInfo r310, String r311, String r312, String r313, String r314, int r315, Object r316) {
                    if ((r315 & 1) == 0) goto L5;
                    String r100 = r110.productActivityType;
                L7:
                    if ((r315 & 2) == 0) goto L9;
                    String r101 = r110.title;
                L11:
                    if ((r315 & 4) == 0) goto L13;
                    String r102 = r110.subTitle;
                L15:
                    if ((r315 & 8) == 0) goto L17;
                    String r103 = r110.styleType;
                L19:
                    if ((r315 & 16) == 0) goto L21;
                    StyleData r104 = r110.styleData;
                L23:
                    if ((r315 & 32) == 0) goto L25;
                    String r105 = r110.feLogo;
                L27:
                    if ((r315 & 64) == 0) goto L29;
                    String r106 = r110.innerShopUrl;
                L31:
                    if ((r315 & 128) == 0) goto L33;
                    String r107 = r110.innerInsertType;
                L35:
                    if ((r315 & 256) == 0) goto L37;
                    String r113 = r110.innerInsertObj;
                L39:
                    if ((r315 & 512) == 0) goto L41;
                    String r114 = r110.link;
                L43:
                    if ((r315 & 1024) == 0) goto L45;
                    String r115 = r110.resourceId;
                L47:
                    if ((r315 & 2048) == 0) goto L49;
                    String r116 = r110.sellingPointsInfo;
                L51:
                    if ((r315 & 4096) == 0) goto L53;
                    InnerTopicInfo r117 = r110.innerTopicInfo;
                L55:
                    if ((r315 & 8192) == 0) goto L57;
                    String r118 = r110.topicTag;
                L58:
                    String r317 = r118;
                    if ((r315 & 16384) == 0) goto L61;
                    String r119 = r110.innerType;
                L62:
                    String r318 = r119;
                    if ((r315 & 32768) == 0) goto L65;
                    String r120 = r110.blockName;
                L67:
                    if ((r315 & 65536) == 0) goto L69;
                    String r108 = r110.sceneId;
                L71:
                    return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
                L69:
                    r108 = r314;
                    goto L71
                L65:
                    r120 = r313;
                    goto L67
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

                public final String component1() {
                    return this.productActivityType;
                }

                public final String component10() {
                    return this.link;
                }

                public final String component11() {
                    return this.resourceId;
                }

                public final String component12() {
                    return this.sellingPointsInfo;
                }

                public final InnerTopicInfo component13() {
                    return this.innerTopicInfo;
                }

                public final String component14() {
                    return this.topicTag;
                }

                public final String component15() {
                    return this.innerType;
                }

                public final String component16() {
                    return this.blockName;
                }

                public final String component17() {
                    return this.sceneId;
                }

                public final String component2() {
                    return this.title;
                }

                public final String component3() {
                    return this.subTitle;
                }

                public final String component4() {
                    return this.styleType;
                }

                public final StyleData component5() {
                    return this.styleData;
                }

                public final String component6() {
                    return this.feLogo;
                }

                public final String component7() {
                    return this.innerShopUrl;
                }

                public final String component8() {
                    return this.innerInsertType;
                }

                public final String component9() {
                    return this.innerInsertObj;
                }

                public final ProductActivityInfoData copy(String r210, String r211, String r212, String r213, StyleData r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, InnerTopicInfo r312, String r313, String r314, String r315, String r316) {
                    return new ProductActivityInfoData(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
                }

                public boolean equals(Object r100) {
                    if (this != r100) goto L4;
                    return true;
                L4:
                    if ((r100 instanceof ProductActivityInfoData) == false) goto L40;
                    ProductActivityInfoData r101 = (ProductActivityInfoData) r100;
                    if (Intrinsics.areEqual(this.productActivityType, r101.productActivityType) == true) goto L8;
                    return false;
                L8:
                    if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
                    return false;
                L10:
                    if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L12;
                    return false;
                L12:
                    if (Intrinsics.areEqual(this.styleType, r101.styleType) == true) goto L14;
                    return false;
                L14:
                    if (Intrinsics.areEqual(this.styleData, r101.styleData) == true) goto L16;
                    return false;
                L16:
                    if (Intrinsics.areEqual(this.feLogo, r101.feLogo) == true) goto L18;
                    return false;
                L18:
                    if (Intrinsics.areEqual(this.innerShopUrl, r101.innerShopUrl) == true) goto L20;
                    return false;
                L20:
                    if (Intrinsics.areEqual(this.innerInsertType, r101.innerInsertType) == true) goto L22;
                    return false;
                L22:
                    if (Intrinsics.areEqual(this.innerInsertObj, r101.innerInsertObj) == true) goto L24;
                    return false;
                L24:
                    if (Intrinsics.areEqual(this.link, r101.link) == true) goto L26;
                    return false;
                L26:
                    if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L28;
                    return false;
                L28:
                    if (Intrinsics.areEqual(this.sellingPointsInfo, r101.sellingPointsInfo) == true) goto L30;
                    return false;
                L30:
                    if (Intrinsics.areEqual(this.innerTopicInfo, r101.innerTopicInfo) == true) goto L32;
                    return false;
                L32:
                    if (Intrinsics.areEqual(this.topicTag, r101.topicTag) == true) goto L34;
                    return false;
                L34:
                    if (Intrinsics.areEqual(this.innerType, r101.innerType) == true) goto L36;
                    return false;
                L36:
                    if (Intrinsics.areEqual(this.blockName, r101.blockName) == true) goto L38;
                    return false;
                L38:
                    if (Intrinsics.areEqual(this.sceneId, r101.sceneId) == true) goto L61;
                    return false;
                L61:
                    return true;
                L40:
                    return false;
                }

                public int hashCode() {
                    String r100 = this.productActivityType;
                    int r101 = 0;
                    if (r100 == null) goto L5;
                    int r102 = r100.hashCode();
                L6:
                    int r103 = r102 * 31;
                    String r104 = this.title;
                    if (r104 == null) goto L9;
                    int r105 = r104.hashCode();
                L10:
                    int r106 = (r103 + r105) * 31;
                    String r107 = this.subTitle;
                    if (r107 == null) goto L13;
                    int r108 = r107.hashCode();
                L14:
                    int r109 = (r106 + r108) * 31;
                    String r110 = this.styleType;
                    if (r110 == null) goto L17;
                    int r111 = r110.hashCode();
                L18:
                    int r112 = (r109 + r111) * 31;
                    StyleData r113 = this.styleData;
                    if (r113 == null) goto L21;
                    int r114 = r113.hashCode();
                L22:
                    int r115 = (r112 + r114) * 31;
                    String r116 = this.feLogo;
                    if (r116 == null) goto L25;
                    int r117 = r116.hashCode();
                L26:
                    int r118 = (r115 + r117) * 31;
                    String r119 = this.innerShopUrl;
                    if (r119 == null) goto L29;
                    int r120 = r119.hashCode();
                L30:
                    int r121 = (r118 + r120) * 31;
                    String r122 = this.innerInsertType;
                    if (r122 == null) goto L33;
                    int r123 = r122.hashCode();
                L34:
                    int r124 = (r121 + r123) * 31;
                    String r125 = this.innerInsertObj;
                    if (r125 == null) goto L37;
                    int r126 = r125.hashCode();
                L38:
                    int r127 = (r124 + r126) * 31;
                    String r128 = this.link;
                    if (r128 == null) goto L41;
                    int r129 = r128.hashCode();
                L42:
                    int r130 = (r127 + r129) * 31;
                    String r131 = this.resourceId;
                    if (r131 == null) goto L45;
                    int r132 = r131.hashCode();
                L46:
                    int r133 = (r130 + r132) * 31;
                    String r134 = this.sellingPointsInfo;
                    if (r134 == null) goto L49;
                    int r135 = r134.hashCode();
                L50:
                    int r136 = (r133 + r135) * 31;
                    InnerTopicInfo r137 = this.innerTopicInfo;
                    if (r137 == null) goto L53;
                    int r138 = r137.hashCode();
                L54:
                    int r139 = (r136 + r138) * 31;
                    String r140 = this.topicTag;
                    if (r140 == null) goto L57;
                    int r141 = r140.hashCode();
                L58:
                    int r142 = (r139 + r141) * 31;
                    String r143 = this.innerType;
                    if (r143 == null) goto L61;
                    int r144 = r143.hashCode();
                L62:
                    int r145 = (r142 + r144) * 31;
                    String r146 = this.blockName;
                    if (r146 == null) goto L65;
                    int r147 = r146.hashCode();
                L66:
                    int r148 = (r145 + r147) * 31;
                    String r149 = this.sceneId;
                    if (r149 == null) goto L70;
                    r101 = r149.hashCode();
                L70:
                    return r148 + r101;
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
                    return "ProductActivityInfoData(productActivityType=" + this.productActivityType + ", title=" + this.title + ", subTitle=" + this.subTitle + ", styleType=" + this.styleType + ", styleData=" + this.styleData + ", feLogo=" + this.feLogo + ", innerShopUrl=" + this.innerShopUrl + ", innerInsertType=" + this.innerInsertType + ", innerInsertObj=" + this.innerInsertObj + ", link=" + this.link + ", resourceId=" + this.resourceId + ", sellingPointsInfo=" + this.sellingPointsInfo + ", innerTopicInfo=" + this.innerTopicInfo + ", topicTag=" + this.topicTag + ", innerType=" + this.innerType + ", blockName=" + this.blockName + ", sceneId=" + this.sceneId + ")";
                }

                public final String getBlockName() {
                    return this.blockName;
                }

                public final String getFeLogo() {
                    return this.feLogo;
                }

                public final String getInnerInsertObj() {
                    return this.innerInsertObj;
                }

                public final String getInnerInsertType() {
                    return this.innerInsertType;
                }

                public final String getInnerShopUrl() {
                    return this.innerShopUrl;
                }

                public final InnerTopicInfo getInnerTopicInfo() {
                    return this.innerTopicInfo;
                }

                public final String getInnerType() {
                    return this.innerType;
                }

                public final String getLink() {
                    return this.link;
                }

                public final String getProductActivityType() {
                    return this.productActivityType;
                }

                public final String getResourceId() {
                    return this.resourceId;
                }

                public final String getSceneId() {
                    return this.sceneId;
                }

                public final String getSellingPointsInfo() {
                    return this.sellingPointsInfo;
                }

                public final StyleData getStyleData() {
                    return this.styleData;
                }

                public final String getStyleType() {
                    return this.styleType;
                }

                public final String getSubTitle() {
                    return this.subTitle;
                }

                public final String getTitle() {
                    return this.title;
                }

                public final String getTopicTag() {
                    return this.topicTag;
                }

                public ProductActivityInfoData(String r100, String r101, String r102, String r103, StyleData r104, String r105, String r106, String r110, String r111, String r112, String r113, String r114, InnerTopicInfo r115, String r116, String r117, String r118, String r119) {
                    this.productActivityType = r100;
                    this.title = r101;
                    this.subTitle = r102;
                    this.styleType = r103;
                    this.styleData = r104;
                    this.feLogo = r105;
                    this.innerShopUrl = r106;
                    this.innerInsertType = r110;
                    this.innerInsertObj = r111;
                    this.link = r112;
                    this.resourceId = r113;
                    this.sellingPointsInfo = r114;
                    this.innerTopicInfo = r115;
                    this.topicTag = r116;
                    this.innerType = r117;
                    this.blockName = r118;
                    this.sceneId = r119;
                }

                public /* synthetic */ ProductActivityInfoData(String r110, String r210, String r211, String r212, StyleData r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, InnerTopicInfo r311, String r312, String r313, String r314, String r315, int r316, DefaultConstructorMarker r317) {
                    if ((r316 & 1) == 0) goto L5;
                    String r100 = null;
                L7:
                    if ((r316 & 2) == 0) goto L9;
                    String r101 = null;
                L11:
                    if ((r316 & 4) == 0) goto L13;
                    String r102 = null;
                L15:
                    if ((r316 & 8) == 0) goto L17;
                    String r103 = null;
                L19:
                    if ((r316 & 16) == 0) goto L21;
                    StyleData r104 = null;
                L23:
                    if ((r316 & 32) == 0) goto L25;
                    String r105 = null;
                L27:
                    if ((r316 & 64) == 0) goto L29;
                    String r106 = null;
                L31:
                    if ((r316 & 128) == 0) goto L33;
                    String r107 = null;
                L35:
                    if ((r316 & 256) == 0) goto L37;
                    String r111 = null;
                L39:
                    if ((r316 & 512) == 0) goto L41;
                    String r112 = null;
                L43:
                    if ((r316 & 1024) == 0) goto L45;
                    String r113 = null;
                L47:
                    if ((r316 & 2048) == 0) goto L49;
                    String r114 = null;
                L51:
                    if ((r316 & 4096) == 0) goto L53;
                    InnerTopicInfo r115 = null;
                L55:
                    if ((r316 & 8192) == 0) goto L57;
                    String r116 = null;
                L59:
                    if ((r316 & 16384) == 0) goto L61;
                    String r108 = null;
                L63:
                    if ((r316 & 32768) == 0) goto L65;
                    String r117 = null;
                L67:
                    if ((r316 & 65536) == 0) goto L69;
                    String r109 = null;
                L70:
                    this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115, r116, r108, r117, r109);
                    return;
                L69:
                    r109 = r315;
                    goto L70
                L65:
                    r117 = r314;
                    goto L67
                L61:
                    r108 = r313;
                    goto L63
                L57:
                    r116 = r312;
                    goto L59
                L53:
                    r115 = r311;
                    goto L55
                L49:
                    r114 = r310;
                    goto L51
                L45:
                    r113 = r219;
                    goto L47
                L41:
                    r112 = r218;
                    goto L43
                L37:
                    r111 = r217;
                    goto L39
                L33:
                    r107 = r216;
                    goto L35
                L29:
                    r106 = r215;
                    goto L31
                L25:
                    r105 = r214;
                    goto L27
                L21:
                    r104 = r213;
                    goto L23
                L17:
                    r103 = r212;
                    goto L19
                L13:
                    r102 = r211;
                    goto L15
                L9:
                    r101 = r210;
                    goto L11
                L5:
                    r100 = r110;
                    goto L7
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public ProductActivity() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ ProductActivity copy$default(ProductActivity r100, Integer r101, String r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.activityType;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.activityConfData;
            L9:
                return r100.copy(r101, r102);
            }

            public final Integer component1() {
                return this.activityType;
            }

            public final String component2() {
                return this.activityConfData;
            }

            public final ProductActivity copy(Integer r100, String r101) {
                return new ProductActivity(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof ProductActivity) == false) goto L10;
                ProductActivity r101 = (ProductActivity) r100;
                if (Intrinsics.areEqual(this.activityType, r101.activityType) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.activityConfData, r101.activityConfData) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                Integer r100 = this.activityType;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.activityConfData;
                if (r104 == null) goto L10;
                r101 = r104.hashCode();
            L10:
                return r103 + r101;
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "ProductActivity(activityType=" + this.activityType + ", activityConfData=" + this.activityConfData + ")";
            }

            public final String getActivityConfData() {
                return this.activityConfData;
            }

            public final Integer getActivityType() {
                return this.activityType;
            }

            public ProductActivity(Integer r100, String r101) {
                this.activityType = r100;
                this.activityConfData = r101;
            }

            public /* synthetic */ ProductActivity(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ProductIcon;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ProductIcon {

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName(ScoreTags.STAR_URL_LIST)
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public ProductIcon() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ProductIcon copy$default(ProductIcon r100, String r101, List r102, Integer r103, Integer r104, int r105, Object r106) {
                if ((r105 & 1) == 0) goto L6;
                r101 = r100.uri;
            L6:
                if ((r105 & 2) == 0) goto L9;
                r102 = r100.urlList;
            L9:
                if ((r105 & 4) == 0) goto L12;
                r103 = r100.width;
            L12:
                if ((r105 & 8) == 0) goto L15;
                r104 = r100.height;
            L15:
                return r100.copy(r101, r102, r103, r104);
            }

            public final String component1() {
                return this.uri;
            }

            public final List<String> component2() {
                return this.urlList;
            }

            public final Integer component3() {
                return this.width;
            }

            public final Integer component4() {
                return this.height;
            }

            public final ProductIcon copy(String r100, List<String> r101, Integer r102, Integer r103) {
                return new ProductIcon(r100, r101, r102, r103);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof ProductIcon) == false) goto L14;
                ProductIcon r101 = (ProductIcon) r100;
                if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r101.height) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public int hashCode() {
                String r100 = this.uri;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                List<String> r104 = this.urlList;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Integer r107 = this.width;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                Integer r110 = this.height;
                if (r110 == null) goto L18;
                r101 = r110.hashCode();
            L18:
                return r109 + r101;
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
                return "ProductIcon(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public ProductIcon(String r100, List<String> r101, Integer r102, Integer r103) {
                this.uri = r100;
                this.urlList = r101;
                this.width = r102;
                this.height = r103;
            }

            public /* synthetic */ ProductIcon(String r100, List r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
                if ((r104 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r104 & 2) == 0) goto L9;
                r101 = null;
            L9:
                if ((r104 & 4) == 0) goto L12;
                r102 = null;
            L12:
                if ((r104 & 8) == 0) goto L14;
                r103 = null;
            L14:
                this(r100, r101, r102, r103);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0001'BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010$\u001a\u00020\u0005J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;", "", "type", "", "content", "", "cover", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;", "rankId", "typeName", "sellingPointsInfo", "link", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getCover", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;", "getLink", "getRankId", "getSellingPointsInfo", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTypeName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason;", "equals", "", "other", "getReasonTypeString", "hashCode", "toString", "Cover", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class RecReason {

            @SerializedName("content")
            private final String content;

            @SerializedName("cover")
            private final Cover cover;

            @SerializedName("link")
            private final String link;

            @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RANK_ID)
            private final String rankId;

            @SerializedName("selling_points_info")
            private final String sellingPointsInfo;

            @SerializedName("type")
            private final Integer type;

            @SerializedName("type_name")
            private final String typeName;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$RecReason$Cover;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
            public static final class Cover {

                @SerializedName("height")
                private final Integer height;

                @SerializedName("uri")
                private final String uri;

                @SerializedName(ScoreTags.STAR_URL_LIST)
                private final List<String> urlList;

                @SerializedName("width")
                private final Integer width;

                public Cover() {
                    this(null, null, null, null, 15, null);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Cover copy$default(Cover r100, String r101, List r102, Integer r103, Integer r104, int r105, Object r106) {
                    if ((r105 & 1) == 0) goto L6;
                    r101 = r100.uri;
                L6:
                    if ((r105 & 2) == 0) goto L9;
                    r102 = r100.urlList;
                L9:
                    if ((r105 & 4) == 0) goto L12;
                    r103 = r100.width;
                L12:
                    if ((r105 & 8) == 0) goto L15;
                    r104 = r100.height;
                L15:
                    return r100.copy(r101, r102, r103, r104);
                }

                public final String component1() {
                    return this.uri;
                }

                public final List<String> component2() {
                    return this.urlList;
                }

                public final Integer component3() {
                    return this.width;
                }

                public final Integer component4() {
                    return this.height;
                }

                public final Cover copy(String r100, List<String> r101, Integer r102, Integer r103) {
                    return new Cover(r100, r101, r102, r103);
                }

                public boolean equals(Object r100) {
                    if (this != r100) goto L4;
                    return true;
                L4:
                    if ((r100 instanceof Cover) == false) goto L14;
                    Cover r101 = (Cover) r100;
                    if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
                    return false;
                L8:
                    if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L10;
                    return false;
                L10:
                    if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
                    return false;
                L12:
                    if (Intrinsics.areEqual(this.height, r101.height) == true) goto L22;
                    return false;
                L22:
                    return true;
                L14:
                    return false;
                }

                public int hashCode() {
                    String r100 = this.uri;
                    int r101 = 0;
                    if (r100 == null) goto L5;
                    int r102 = r100.hashCode();
                L6:
                    int r103 = r102 * 31;
                    List<String> r104 = this.urlList;
                    if (r104 == null) goto L9;
                    int r105 = r104.hashCode();
                L10:
                    int r106 = (r103 + r105) * 31;
                    Integer r107 = this.width;
                    if (r107 == null) goto L13;
                    int r108 = r107.hashCode();
                L14:
                    int r109 = (r106 + r108) * 31;
                    Integer r110 = this.height;
                    if (r110 == null) goto L18;
                    r101 = r110.hashCode();
                L18:
                    return r109 + r101;
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
                    return "Cover(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
                }

                public final Integer getHeight() {
                    return this.height;
                }

                public final String getUri() {
                    return this.uri;
                }

                public final List<String> getUrlList() {
                    return this.urlList;
                }

                public final Integer getWidth() {
                    return this.width;
                }

                public Cover(String r100, List<String> r101, Integer r102, Integer r103) {
                    this.uri = r100;
                    this.urlList = r101;
                    this.width = r102;
                    this.height = r103;
                }

                public /* synthetic */ Cover(String r100, List r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
                    if ((r104 & 1) == 0) goto L6;
                    r100 = null;
                L6:
                    if ((r104 & 2) == 0) goto L9;
                    r101 = null;
                L9:
                    if ((r104 & 4) == 0) goto L12;
                    r102 = null;
                L12:
                    if ((r104 & 8) == 0) goto L14;
                    r103 = null;
                L14:
                    this(r100, r101, r102, r103);
                }
            }

            public RecReason() {
                this(null, null, null, null, null, null, null, 127, null);
            }

            public static /* synthetic */ RecReason copy$default(RecReason r100, Integer r101, String r102, Cover r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
                if ((r113 & 1) == 0) goto L6;
                r101 = r100.type;
            L6:
                if ((r113 & 2) == 0) goto L8;
                r102 = r100.content;
            L8:
                String r115 = r102;
                if ((r113 & 4) == 0) goto L11;
                r103 = r100.cover;
            L11:
                Cover r105 = r103;
                if ((r113 & 8) == 0) goto L14;
                r104 = r100.rankId;
            L14:
                String r106 = r104;
                if ((r113 & 16) == 0) goto L17;
                r110 = r100.typeName;
            L17:
                String r107 = r110;
                if ((r113 & 32) == 0) goto L20;
                r111 = r100.sellingPointsInfo;
            L20:
                String r108 = r111;
                if ((r113 & 64) == 0) goto L23;
                r112 = r100.link;
            L23:
                Integer r109 = r101;
                return r100.copy(r109, r115, r105, r106, r107, r108, r112);
            }

            public final Integer component1() {
                return this.type;
            }

            public final String component2() {
                return this.content;
            }

            public final Cover component3() {
                return this.cover;
            }

            public final String component4() {
                return this.rankId;
            }

            public final String component5() {
                return this.typeName;
            }

            public final String component6() {
                return this.sellingPointsInfo;
            }

            public final String component7() {
                return this.link;
            }

            public final RecReason copy(Integer r110, String r111, Cover r112, String r113, String r114, String r115, String r116) {
                return new RecReason(r110, r111, r112, r113, r114, r115, r116);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof RecReason) == false) goto L20;
                RecReason r101 = (RecReason) r100;
                if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.content, r101.content) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.rankId, r101.rankId) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.typeName, r101.typeName) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.sellingPointsInfo, r101.sellingPointsInfo) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.link, r101.link) == true) goto L31;
                return false;
            L31:
                return true;
            L20:
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
                Cover r107 = this.cover;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                String r110 = this.rankId;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                String r113 = this.typeName;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                String r116 = this.sellingPointsInfo;
                if (r116 == null) goto L25;
                int r117 = r116.hashCode();
            L26:
                int r118 = (r115 + r117) * 31;
                String r119 = this.link;
                if (r119 == null) goto L30;
                r101 = r119.hashCode();
            L30:
                return r118 + r101;
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
                return "RecReason(type=" + this.type + ", content=" + this.content + ", cover=" + this.cover + ", rankId=" + this.rankId + ", typeName=" + this.typeName + ", sellingPointsInfo=" + this.sellingPointsInfo + ", link=" + this.link + ")";
            }

            public final String getReasonTypeString() {
                Integer r100 = this.type;
                if (r100 != null) goto L6;
            L8:
                if (r100 != null) goto L11;
            L13:
                if (r100 != null) goto L16;
            L18:
                if (r100 != null) goto L21;
            L23:
                return "";
            L21:
                if (r100.intValue() != 4) goto L23;
                return "product_ranking";
            L16:
                if (r100.intValue() != 2) goto L18;
                return "good_comment_rate";
            L11:
                if (r100.intValue() != 1) goto L13;
                return "history";
            L6:
                if (r100.intValue() != 3) goto L8;
                return "follow_recommend";
            }

            public final String getContent() {
                return this.content;
            }

            public final Cover getCover() {
                return this.cover;
            }

            public final String getLink() {
                return this.link;
            }

            public final String getRankId() {
                return this.rankId;
            }

            public final String getSellingPointsInfo() {
                return this.sellingPointsInfo;
            }

            public final Integer getType() {
                return this.type;
            }

            public final String getTypeName() {
                return this.typeName;
            }

            public RecReason(Integer r100, String r101, Cover r102, String r103, String r104, String r105, String r106) {
                this.type = r100;
                this.content = r101;
                this.cover = r102;
                this.rankId = r103;
                this.typeName = r104;
                this.sellingPointsInfo = r105;
                this.link = r106;
            }

            public /* synthetic */ RecReason(Integer r100, String r101, Cover r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
                if ((r114 & 1) == 0) goto L5;
                Integer r116 = null;
            L7:
                if ((r114 & 2) == 0) goto L9;
                String r103 = null;
            L11:
                if ((r114 & 4) == 0) goto L13;
                Cover r104 = null;
            L15:
                if ((r114 & 8) == 0) goto L17;
                String r105 = null;
            L19:
                if ((r114 & 16) == 0) goto L21;
                String r106 = null;
            L23:
                if ((r114 & 32) == 0) goto L25;
                String r107 = null;
            L27:
                if ((r114 & 64) == 0) goto L29;
                String r117 = null;
            L30:
                this(r116, r103, r104, r105, r106, r107, r117);
                return;
            L29:
                r117 = r113;
                goto L30
            L25:
                r107 = r112;
                goto L27
            L21:
                r106 = r111;
                goto L23
            L17:
                r105 = r110;
                goto L19
            L13:
                r104 = r102;
                goto L15
            L9:
                r103 = r101;
                goto L11
            L5:
                r116 = r100;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;", "", "id", "", "name", "", "link", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLink", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$ShopInfo;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ShopInfo {

            /* JADX INFO: renamed from: id, reason: collision with root package name */
            @SerializedName("id")
            private final Integer f170282id;

            @SerializedName("link")
            private final String link;

            @SerializedName("name")
            private final String name;

            public ShopInfo() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ ShopInfo copy$default(ShopInfo r100, Integer r101, String r102, String r103, int r104, Object r105) {
                if ((r104 & 1) == 0) goto L6;
                r101 = r100.f170282id;
            L6:
                if ((r104 & 2) == 0) goto L9;
                r102 = r100.name;
            L9:
                if ((r104 & 4) == 0) goto L12;
                r103 = r100.link;
            L12:
                return r100.copy(r101, r102, r103);
            }

            public final Integer component1() {
                return this.f170282id;
            }

            public final String component2() {
                return this.name;
            }

            public final String component3() {
                return this.link;
            }

            public final ShopInfo copy(Integer r100, String r101, String r102) {
                return new ShopInfo(r100, r101, r102);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof ShopInfo) == false) goto L12;
                ShopInfo r101 = (ShopInfo) r100;
                if (Intrinsics.areEqual(this.f170282id, r101.f170282id) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.link, r101.link) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public int hashCode() {
                Integer r100 = this.f170282id;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                String r104 = this.name;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                String r107 = this.link;
                if (r107 == null) goto L14;
                r101 = r107.hashCode();
            L14:
                return r106 + r101;
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "ShopInfo(id=" + this.f170282id + ", name=" + this.name + ", link=" + this.link + ")";
            }

            public final Integer getId() {
                return this.f170282id;
            }

            public final String getLink() {
                return this.link;
            }

            public final String getName() {
                return this.name;
            }

            public ShopInfo(Integer r100, String r101, String r102) {
                this.f170282id = r100;
                this.name = r101;
                this.link = r102;
            }

            public /* synthetic */ ShopInfo(Integer r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
                if ((r103 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r101 = null;
            L9:
                if ((r103 & 4) == 0) goto L11;
                r102 = null;
            L11:
                this(r100, r101, r102);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$TagItem;", "", "type", "", "content", "", "extra", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getExtra", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product$TagItem;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class TagItem {

            @SerializedName("content")
            private final String content;

            @SerializedName("extra")
            private final String extra;

            @SerializedName("type")
            private final Integer type;

            public TagItem() {
                this(null, null, null, 7, null);
            }

            public static /* synthetic */ TagItem copy$default(TagItem r100, Integer r101, String r102, String r103, int r104, Object r105) {
                if ((r104 & 1) == 0) goto L6;
                r101 = r100.type;
            L6:
                if ((r104 & 2) == 0) goto L9;
                r102 = r100.content;
            L9:
                if ((r104 & 4) == 0) goto L12;
                r103 = r100.extra;
            L12:
                return r100.copy(r101, r102, r103);
            }

            public final Integer component1() {
                return this.type;
            }

            public final String component2() {
                return this.content;
            }

            public final String component3() {
                return this.extra;
            }

            public final TagItem copy(Integer r100, String r101, String r102) {
                return new TagItem(r100, r101, r102);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof TagItem) == false) goto L12;
                TagItem r101 = (TagItem) r100;
                if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.content, r101.content) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
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
                String r107 = this.extra;
                if (r107 == null) goto L14;
                r101 = r107.hashCode();
            L14:
                return r106 + r101;
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public String toString() {
                return "TagItem(type=" + this.type + ", content=" + this.content + ", extra=" + this.extra + ")";
            }

            public final String getContent() {
                return this.content;
            }

            public final String getExtra() {
                return this.extra;
            }

            public final Integer getType() {
                return this.type;
            }

            public TagItem(Integer r100, String r101, String r102) {
                this.type = r100;
                this.content = r101;
                this.extra = r102;
            }

            public /* synthetic */ TagItem(Integer r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
                if ((r103 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r101 = null;
            L9:
                if ((r103 & 4) == 0) goto L11;
                r102 = null;
            L11:
                this(r100, r101, r102);
            }
        }

        public Product() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, RectListKt.Lower26Bits, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Product copy$default(Product r110, String r111, UrlStruct r112, String r210, Integer r211, List r212, Price r213, String r214, String r215, String r216, Integer r217, String r218, ProductActivity r219, RecReason r310, Integer r311, ProductIcon r312, String r313, Extra r314, Integer r315, Integer r316, UrlStruct r317, UrlStruct r318, MarketingFloors r319, List r410, ShopInfo r411, String r412, DecorationParam r413, int r414, Object r415) {
            if ((r414 & 1) == 0) goto L5;
            String r100 = r110.productId;
        L7:
            if ((r414 & 2) == 0) goto L9;
            UrlStruct r101 = r110.cover;
        L11:
            if ((r414 & 4) == 0) goto L13;
            String r102 = r110.title;
        L15:
            if ((r414 & 8) == 0) goto L17;
            Integer r103 = r110.sales;
        L19:
            if ((r414 & 16) == 0) goto L21;
            List r104 = r110.tags;
        L23:
            if ((r414 & 32) == 0) goto L25;
            Price r105 = r110.price;
        L27:
            if ((r414 & 64) == 0) goto L29;
            String r106 = r110.kolId;
        L31:
            if ((r414 & 128) == 0) goto L33;
            String r107 = r110.secKolId;
        L35:
            if ((r414 & 256) == 0) goto L37;
            String r113 = r110.promotionId;
        L39:
            if ((r414 & 512) == 0) goto L41;
            Integer r114 = r110.commodityType;
        L43:
            if ((r414 & 1024) == 0) goto L45;
            String r115 = r110.recommendInfo;
        L47:
            if ((r414 & 2048) == 0) goto L49;
            ProductActivity r116 = r110.productActivity;
        L51:
            if ((r414 & 4096) == 0) goto L53;
            RecReason r117 = r110.recReason;
        L55:
            if ((r414 & 8192) == 0) goto L57;
            Integer r118 = r110.bizKind;
        L58:
            Integer r320 = r118;
            if ((r414 & 16384) == 0) goto L61;
            ProductIcon r119 = r110.productIcon;
        L62:
            ProductIcon r321 = r119;
            if ((r414 & 32768) == 0) goto L65;
            String r120 = r110.iconName;
        L66:
            String r322 = r120;
            if ((r414 & 65536) == 0) goto L69;
            Extra r121 = r110.extra;
        L70:
            Extra r323 = r121;
            if ((r414 & 131072) == 0) goto L73;
            Integer r122 = r110.campaginSales;
        L74:
            Integer r324 = r122;
            if ((r414 & 262144) == 0) goto L77;
            Integer r123 = r110.campaginStock;
        L78:
            Integer r325 = r123;
            if ((r414 & 524288) == 0) goto L81;
            UrlStruct r124 = r110.coverLong;
        L82:
            UrlStruct r326 = r124;
            if ((r414 & 1048576) == 0) goto L85;
            UrlStruct r125 = r110.coverRecommend;
        L86:
            UrlStruct r327 = r125;
            if ((r414 & 2097152) == 0) goto L89;
            MarketingFloors r126 = r110.platformTextActivity;
        L90:
            MarketingFloors r328 = r126;
            if ((r414 & 4194304) == 0) goto L93;
            List r127 = r110.coupons;
        L94:
            List r416 = r127;
            if ((r414 & 8388608) == 0) goto L97;
            ShopInfo r128 = r110.shopInfo;
        L98:
            ShopInfo r417 = r128;
            if ((r414 & 16777216) == 0) goto L101;
            String r129 = r110.link;
        L103:
            if ((r414 & 33554432) == 0) goto L105;
            DecorationParam r108 = r110.decorationParam;
        L107:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r416, r417, r129, r108);
        L105:
            r108 = r413;
            goto L107
        L101:
            r129 = r412;
            goto L103
        L97:
            r128 = r411;
            goto L98
        L93:
            r127 = r410;
            goto L94
        L89:
            r126 = r319;
            goto L90
        L85:
            r125 = r318;
            goto L86
        L81:
            r124 = r317;
            goto L82
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

        public final String component1() {
            return this.productId;
        }

        public final Integer component10() {
            return this.commodityType;
        }

        public final String component11() {
            return this.recommendInfo;
        }

        public final ProductActivity component12() {
            return this.productActivity;
        }

        public final RecReason component13() {
            return this.recReason;
        }

        public final Integer component14() {
            return this.bizKind;
        }

        public final ProductIcon component15() {
            return this.productIcon;
        }

        public final String component16() {
            return this.iconName;
        }

        public final Extra component17() {
            return this.extra;
        }

        public final Integer component18() {
            return this.campaginSales;
        }

        public final Integer component19() {
            return this.campaginStock;
        }

        public final UrlStruct component2() {
            return this.cover;
        }

        public final UrlStruct component20() {
            return this.coverLong;
        }

        public final UrlStruct component21() {
            return this.coverRecommend;
        }

        public final MarketingFloors component22() {
            return this.platformTextActivity;
        }

        public final List<Object> component23() {
            return this.coupons;
        }

        public final ShopInfo component24() {
            return this.shopInfo;
        }

        public final String component25() {
            return this.link;
        }

        public final DecorationParam component26() {
            return this.decorationParam;
        }

        public final String component3() {
            return this.title;
        }

        public final Integer component4() {
            return this.sales;
        }

        public final List<TagItem> component5() {
            return this.tags;
        }

        public final Price component6() {
            return this.price;
        }

        public final String component7() {
            return this.kolId;
        }

        public final String component8() {
            return this.secKolId;
        }

        public final String component9() {
            return this.promotionId;
        }

        public final Product copy(String r210, UrlStruct r310, String r311, Integer r312, List<TagItem> r313, Price r314, String r315, String r316, String r317, Integer r318, String r319, ProductActivity r410, RecReason r411, Integer r412, ProductIcon r413, String r414, Extra r415, Integer r416, Integer r417, UrlStruct r418, UrlStruct r419, MarketingFloors r510, List<? extends Object> r511, ShopInfo r512, String r513, DecorationParam r514) {
            return new Product(r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Product) == false) goto L58;
            Product r101 = (Product) r100;
            if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sales, r101.sales) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.price, r101.price) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.kolId, r101.kolId) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.secKolId, r101.secKolId) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.commodityType, r101.commodityType) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.recommendInfo, r101.recommendInfo) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.productActivity, r101.productActivity) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.recReason, r101.recReason) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.bizKind, r101.bizKind) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.productIcon, r101.productIcon) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.iconName, r101.iconName) == true) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.campaginSales, r101.campaginSales) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.campaginStock, r101.campaginStock) == true) goto L44;
            return false;
        L44:
            if (Intrinsics.areEqual(this.coverLong, r101.coverLong) == true) goto L46;
            return false;
        L46:
            if (Intrinsics.areEqual(this.coverRecommend, r101.coverRecommend) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.platformTextActivity, r101.platformTextActivity) == true) goto L50;
            return false;
        L50:
            if (Intrinsics.areEqual(this.coupons, r101.coupons) == true) goto L52;
            return false;
        L52:
            if (Intrinsics.areEqual(this.shopInfo, r101.shopInfo) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.link, r101.link) == true) goto L56;
            return false;
        L56:
            if (Intrinsics.areEqual(this.decorationParam, r101.decorationParam) == true) goto L88;
            return false;
        L88:
            return true;
        L58:
            return false;
        }

        public int hashCode() {
            String r100 = this.productId;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            UrlStruct r104 = this.cover;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.title;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.sales;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            List<TagItem> r113 = this.tags;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            Price r116 = this.price;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.kolId;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.secKolId;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.promotionId;
            if (r125 == null) goto L37;
            int r126 = r125.hashCode();
        L38:
            int r127 = (r124 + r126) * 31;
            Integer r128 = this.commodityType;
            if (r128 == null) goto L41;
            int r129 = r128.hashCode();
        L42:
            int r130 = (r127 + r129) * 31;
            String r131 = this.recommendInfo;
            if (r131 == null) goto L45;
            int r132 = r131.hashCode();
        L46:
            int r133 = (r130 + r132) * 31;
            ProductActivity r134 = this.productActivity;
            if (r134 == null) goto L49;
            int r135 = r134.hashCode();
        L50:
            int r136 = (r133 + r135) * 31;
            RecReason r137 = this.recReason;
            if (r137 == null) goto L53;
            int r138 = r137.hashCode();
        L54:
            int r139 = (r136 + r138) * 31;
            Integer r140 = this.bizKind;
            if (r140 == null) goto L57;
            int r141 = r140.hashCode();
        L58:
            int r142 = (r139 + r141) * 31;
            ProductIcon r143 = this.productIcon;
            if (r143 == null) goto L61;
            int r144 = r143.hashCode();
        L62:
            int r145 = (r142 + r144) * 31;
            String r146 = this.iconName;
            if (r146 == null) goto L65;
            int r147 = r146.hashCode();
        L66:
            int r148 = (r145 + r147) * 31;
            Extra r149 = this.extra;
            if (r149 == null) goto L69;
            int r150 = r149.hashCode();
        L70:
            int r151 = (r148 + r150) * 31;
            Integer r152 = this.campaginSales;
            if (r152 == null) goto L73;
            int r153 = r152.hashCode();
        L74:
            int r154 = (r151 + r153) * 31;
            Integer r155 = this.campaginStock;
            if (r155 == null) goto L77;
            int r156 = r155.hashCode();
        L78:
            int r157 = (r154 + r156) * 31;
            UrlStruct r158 = this.coverLong;
            if (r158 == null) goto L81;
            int r159 = r158.hashCode();
        L82:
            int r160 = (r157 + r159) * 31;
            UrlStruct r161 = this.coverRecommend;
            if (r161 == null) goto L85;
            int r162 = r161.hashCode();
        L86:
            int r163 = (r160 + r162) * 31;
            MarketingFloors r164 = this.platformTextActivity;
            if (r164 == null) goto L89;
            int r165 = r164.hashCode();
        L90:
            int r166 = (r163 + r165) * 31;
            List<Object> r167 = this.coupons;
            if (r167 == null) goto L93;
            int r168 = r167.hashCode();
        L94:
            int r169 = (r166 + r168) * 31;
            ShopInfo r170 = this.shopInfo;
            if (r170 == null) goto L97;
            int r171 = r170.hashCode();
        L98:
            int r172 = (r169 + r171) * 31;
            String r173 = this.link;
            if (r173 == null) goto L101;
            int r174 = r173.hashCode();
        L102:
            int r175 = (r172 + r174) * 31;
            DecorationParam r176 = this.decorationParam;
            if (r176 == null) goto L106;
            r101 = r176.hashCode();
        L106:
            return r175 + r101;
        L101:
            r174 = 0;
            goto L102
        L97:
            r171 = 0;
            goto L98
        L93:
            r168 = 0;
            goto L94
        L89:
            r165 = 0;
            goto L90
        L85:
            r162 = 0;
            goto L86
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
            return "Product(productId=" + this.productId + ", cover=" + this.cover + ", title=" + this.title + ", sales=" + this.sales + ", tags=" + this.tags + ", price=" + this.price + ", kolId=" + this.kolId + ", secKolId=" + this.secKolId + ", promotionId=" + this.promotionId + ", commodityType=" + this.commodityType + ", recommendInfo=" + this.recommendInfo + ", productActivity=" + this.productActivity + ", recReason=" + this.recReason + ", bizKind=" + this.bizKind + ", productIcon=" + this.productIcon + ", iconName=" + this.iconName + ", extra=" + this.extra + ", campaginSales=" + this.campaginSales + ", campaginStock=" + this.campaginStock + ", coverLong=" + this.coverLong + ", coverRecommend=" + this.coverRecommend + ", platformTextActivity=" + this.platformTextActivity + ", coupons=" + this.coupons + ", shopInfo=" + this.shopInfo + ", link=" + this.link + ", decorationParam=" + this.decorationParam + ")";
        }

        public final Integer getBizKind() {
            return this.bizKind;
        }

        public final Integer getCampaginSales() {
            return this.campaginSales;
        }

        public final Integer getCampaginStock() {
            return this.campaginStock;
        }

        public final Integer getCommodityType() {
            return this.commodityType;
        }

        public final List<Object> getCoupons() {
            return this.coupons;
        }

        public final UrlStruct getCover() {
            return this.cover;
        }

        public final UrlStruct getCoverLong() {
            return this.coverLong;
        }

        public final UrlStruct getCoverRecommend() {
            return this.coverRecommend;
        }

        public final DecorationParam getDecorationParam() {
            return this.decorationParam;
        }

        public final Extra getExtra() {
            return this.extra;
        }

        public final String getIconName() {
            return this.iconName;
        }

        public final String getKolId() {
            return this.kolId;
        }

        public final String getLink() {
            return this.link;
        }

        public final MarketingFloors getPlatformTextActivity() {
            return this.platformTextActivity;
        }

        public final Price getPrice() {
            return this.price;
        }

        public final ProductActivity getProductActivity() {
            return this.productActivity;
        }

        public final ProductIcon getProductIcon() {
            return this.productIcon;
        }

        public final String getProductId() {
            return this.productId;
        }

        public final String getPromotionId() {
            return this.promotionId;
        }

        public final RecReason getRecReason() {
            return this.recReason;
        }

        public final String getRecommendInfo() {
            return this.recommendInfo;
        }

        public final Integer getSales() {
            return this.sales;
        }

        public final String getSecKolId() {
            return this.secKolId;
        }

        public final ShopInfo getShopInfo() {
            return this.shopInfo;
        }

        public final List<TagItem> getTags() {
            return this.tags;
        }

        public final String getTitle() {
            return this.title;
        }

        public Product(String r100, UrlStruct r101, String r102, Integer r103, List<TagItem> r104, Price r105, String r106, String r110, String r111, Integer r112, String r113, ProductActivity r114, RecReason r115, Integer r116, ProductIcon r117, String r118, Extra r119, Integer r210, Integer r211, UrlStruct r212, UrlStruct r213, MarketingFloors r214, List<? extends Object> r215, ShopInfo r216, String r217, DecorationParam r218) {
            this.productId = r100;
            this.cover = r101;
            this.title = r102;
            this.sales = r103;
            this.tags = r104;
            this.price = r105;
            this.kolId = r106;
            this.secKolId = r110;
            this.promotionId = r111;
            this.commodityType = r112;
            this.recommendInfo = r113;
            this.productActivity = r114;
            this.recReason = r115;
            this.bizKind = r116;
            this.productIcon = r117;
            this.iconName = r118;
            this.extra = r119;
            this.campaginSales = r210;
            this.campaginStock = r211;
            this.coverLong = r212;
            this.coverRecommend = r213;
            this.platformTextActivity = r214;
            this.coupons = r215;
            this.shopInfo = r216;
            this.link = r217;
            this.decorationParam = r218;
        }

        public /* synthetic */ Product(String r210, UrlStruct r211, String r310, Integer r311, List r312, Price r313, String r314, String r315, String r316, Integer r317, String r318, ProductActivity r319, RecReason r410, Integer r411, ProductIcon r412, String r413, Extra r414, Integer r415, Integer r416, UrlStruct r417, UrlStruct r418, MarketingFloors r419, List r510, ShopInfo r511, String r512, DecorationParam r513, int r514, DefaultConstructorMarker r515) {
            if ((r514 & 1) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r514 & 2) == 0) goto L9;
            UrlStruct r101 = null;
        L11:
            if ((r514 & 4) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r514 & 8) == 0) goto L17;
            Integer r103 = null;
        L19:
            if ((r514 & 16) == 0) goto L21;
            List r104 = null;
        L23:
            if ((r514 & 32) == 0) goto L25;
            Price r105 = null;
        L27:
            if ((r514 & 64) == 0) goto L29;
            String r106 = null;
        L31:
            if ((r514 & 128) == 0) goto L33;
            String r107 = null;
        L35:
            if ((r514 & 256) == 0) goto L37;
            String r110 = null;
        L39:
            if ((r514 & 512) == 0) goto L41;
            Integer r111 = null;
        L43:
            if ((r514 & 1024) == 0) goto L45;
            String r112 = null;
        L47:
            if ((r514 & 2048) == 0) goto L49;
            ProductActivity r113 = null;
        L51:
            if ((r514 & 4096) == 0) goto L53;
            RecReason r114 = null;
        L55:
            if ((r514 & 8192) == 0) goto L57;
            Integer r115 = null;
        L59:
            if ((r514 & 16384) == 0) goto L61;
            ProductIcon r108 = null;
        L63:
            if ((r514 & 32768) == 0) goto L65;
            String r116 = null;
        L67:
            if ((r514 & 65536) == 0) goto L69;
            Extra r117 = null;
        L71:
            if ((r514 & 131072) == 0) goto L73;
            Integer r118 = null;
        L75:
            if ((r514 & 262144) == 0) goto L77;
            Integer r119 = null;
        L79:
            if ((r514 & 524288) == 0) goto L81;
            UrlStruct r212 = null;
        L83:
            if ((r514 & 1048576) == 0) goto L85;
            UrlStruct r213 = null;
        L87:
            if ((r514 & 2097152) == 0) goto L89;
            MarketingFloors r214 = null;
        L91:
            if ((r514 & 4194304) == 0) goto L93;
            List r215 = null;
        L95:
            if ((r514 & 8388608) == 0) goto L97;
            ShopInfo r216 = null;
        L99:
            if ((r514 & 16777216) == 0) goto L101;
            String r217 = null;
        L103:
            if ((r514 & 33554432) == 0) goto L105;
            DecorationParam r109 = null;
        L106:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r212, r213, r214, r215, r216, r217, r109);
            return;
        L105:
            r109 = r513;
            goto L106
        L101:
            r217 = r512;
            goto L103
        L97:
            r216 = r511;
            goto L99
        L93:
            r215 = r510;
            goto L95
        L89:
            r214 = r419;
            goto L91
        L85:
            r213 = r418;
            goto L87
        L81:
            r212 = r417;
            goto L83
        L77:
            r119 = r416;
            goto L79
        L73:
            r118 = r415;
            goto L75
        L69:
            r117 = r414;
            goto L71
        L65:
            r116 = r413;
            goto L67
        L61:
            r108 = r412;
            goto L63
        L57:
            r115 = r411;
            goto L59
        L53:
            r114 = r410;
            goto L55
        L49:
            r113 = r319;
            goto L51
        L45:
            r112 = r318;
            goto L47
        L41:
            r111 = r317;
            goto L43
        L37:
            r110 = r316;
            goto L39
        L33:
            r107 = r315;
            goto L35
        L29:
            r106 = r314;
            goto L31
        L25:
            r105 = r313;
            goto L27
        L21:
            r104 = r312;
            goto L23
        L17:
            r103 = r311;
            goto L19
        L13:
            r102 = r310;
            goto L15
        L9:
            r101 = r211;
            goto L11
        L5:
            r100 = r210;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Store;", "", "distancePoint", "", "(Ljava/lang/String;)V", "getDistancePoint", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Store {

        @SerializedName("distance_point")
        private final String distancePoint;

        /* JADX WARN: Multi-variable type inference failed */
        public Store() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Store copy$default(Store r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.distancePoint;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.distancePoint;
        }

        public final Store copy(String r100) {
            return new Store(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Store) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.distancePoint, ((Store) r100).distancePoint) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.distancePoint;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "Store(distancePoint=" + this.distancePoint + ")";
        }

        public final String getDistancePoint() {
            return this.distancePoint;
        }

        public Store(String r100) {
            this.distancePoint = r100;
        }

        public /* synthetic */ Store(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJD\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$UrlStruct;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UrlStruct {

        @SerializedName("height")
        private final Integer height;

        @SerializedName("uri")
        private final String uri;

        @SerializedName(ScoreTags.STAR_URL_LIST)
        private final List<String> urlList;

        @SerializedName("width")
        private final Integer width;

        public UrlStruct() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UrlStruct copy$default(UrlStruct r100, String r101, List r102, Integer r103, Integer r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.uri;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.urlList;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.width;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.height;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.uri;
        }

        public final List<String> component2() {
            return this.urlList;
        }

        public final Integer component3() {
            return this.width;
        }

        public final Integer component4() {
            return this.height;
        }

        public final UrlStruct copy(String r100, List<String> r101, Integer r102, Integer r103) {
            return new UrlStruct(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof UrlStruct) == false) goto L14;
            UrlStruct r101 = (UrlStruct) r100;
            if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.height, r101.height) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r100 = this.uri;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.urlList;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.width;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.height;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
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
            return "UrlStruct(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final String getUri() {
            return this.uri;
        }

        public final List<String> getUrlList() {
            return this.urlList;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public UrlStruct(String r100, List<String> r101, Integer r102, Integer r103) {
            this.uri = r100;
            this.urlList = r101;
            this.width = r102;
            this.height = r103;
        }

        public /* synthetic */ UrlStruct(String r100, List r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001$BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0007\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\t\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "", "id", "", "avatar", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;", InstantPlayContext.NICKNAME, "isFollowed", "", "isLive", "roomId", "secId", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;", "getId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNickname", "getRoomId", "getSecId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "equals", "other", "hashCode", "", "toString", "Avatar", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class User {

        @SerializedName("avatar")
        private final Avatar avatar;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private final String f170283id;

        @SerializedName("is_followed")
        private final Boolean isFollowed;

        @SerializedName("is_live")
        private final Boolean isLive;

        @SerializedName(InstantPlayContext.NICKNAME)
        private final String nickname;

        @SerializedName("room_id")
        private final String roomId;

        @SerializedName("sec_id")
        private final String secId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User$Avatar;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Avatar {

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName(ScoreTags.STAR_URL_LIST)
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public Avatar() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Avatar copy$default(Avatar r100, String r101, List r102, Integer r103, Integer r104, int r105, Object r106) {
                if ((r105 & 1) == 0) goto L6;
                r101 = r100.uri;
            L6:
                if ((r105 & 2) == 0) goto L9;
                r102 = r100.urlList;
            L9:
                if ((r105 & 4) == 0) goto L12;
                r103 = r100.width;
            L12:
                if ((r105 & 8) == 0) goto L15;
                r104 = r100.height;
            L15:
                return r100.copy(r101, r102, r103, r104);
            }

            public final String component1() {
                return this.uri;
            }

            public final List<String> component2() {
                return this.urlList;
            }

            public final Integer component3() {
                return this.width;
            }

            public final Integer component4() {
                return this.height;
            }

            public final Avatar copy(String r100, List<String> r101, Integer r102, Integer r103) {
                return new Avatar(r100, r101, r102, r103);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Avatar) == false) goto L14;
                Avatar r101 = (Avatar) r100;
                if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r101.height) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public int hashCode() {
                String r100 = this.uri;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                List<String> r104 = this.urlList;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                Integer r107 = this.width;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                Integer r110 = this.height;
                if (r110 == null) goto L18;
                r101 = r110.hashCode();
            L18:
                return r109 + r101;
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
                return "Avatar(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public Avatar(String r100, List<String> r101, Integer r102, Integer r103) {
                this.uri = r100;
                this.urlList = r101;
                this.width = r102;
                this.height = r103;
            }

            public /* synthetic */ Avatar(String r100, List r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
                if ((r104 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r104 & 2) == 0) goto L9;
                r101 = null;
            L9:
                if ((r104 & 4) == 0) goto L12;
                r102 = null;
            L12:
                if ((r104 & 8) == 0) goto L14;
                r103 = null;
            L14:
                this(r100, r101, r102, r103);
            }
        }

        public User() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ User copy$default(User r100, String r101, Avatar r102, String r103, Boolean r104, Boolean r110, String r111, String r112, int r113, Object r114) {
            if ((r113 & 1) == 0) goto L6;
            r101 = r100.f170283id;
        L6:
            if ((r113 & 2) == 0) goto L8;
            r102 = r100.avatar;
        L8:
            Avatar r115 = r102;
            if ((r113 & 4) == 0) goto L11;
            r103 = r100.nickname;
        L11:
            String r105 = r103;
            if ((r113 & 8) == 0) goto L14;
            r104 = r100.isFollowed;
        L14:
            Boolean r106 = r104;
            if ((r113 & 16) == 0) goto L17;
            r110 = r100.isLive;
        L17:
            Boolean r107 = r110;
            if ((r113 & 32) == 0) goto L20;
            r111 = r100.roomId;
        L20:
            String r108 = r111;
            if ((r113 & 64) == 0) goto L23;
            r112 = r100.secId;
        L23:
            String r109 = r101;
            return r100.copy(r109, r115, r105, r106, r107, r108, r112);
        }

        public final String component1() {
            return this.f170283id;
        }

        public final Avatar component2() {
            return this.avatar;
        }

        public final String component3() {
            return this.nickname;
        }

        public final Boolean component4() {
            return this.isFollowed;
        }

        public final Boolean component5() {
            return this.isLive;
        }

        public final String component6() {
            return this.roomId;
        }

        public final String component7() {
            return this.secId;
        }

        public final User copy(String r110, Avatar r111, String r112, Boolean r113, Boolean r114, String r115, String r116) {
            return new User(r110, r111, r112, r113, r114, r115, r116);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof User) == false) goto L20;
            User r101 = (User) r100;
            if (Intrinsics.areEqual(this.f170283id, r101.f170283id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.nickname, r101.nickname) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isFollowed, r101.isFollowed) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.isLive, r101.isLive) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.secId, r101.secId) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            String r100 = this.f170283id;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Avatar r104 = this.avatar;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.nickname;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Boolean r110 = this.isFollowed;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Boolean r113 = this.isLive;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.roomId;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.secId;
            if (r119 == null) goto L30;
            r101 = r119.hashCode();
        L30:
            return r118 + r101;
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
            return "User(id=" + this.f170283id + ", avatar=" + this.avatar + ", nickname=" + this.nickname + ", isFollowed=" + this.isFollowed + ", isLive=" + this.isLive + ", roomId=" + this.roomId + ", secId=" + this.secId + ")";
        }

        public final Avatar getAvatar() {
            return this.avatar;
        }

        public final String getId() {
            return this.f170283id;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final String getRoomId() {
            return this.roomId;
        }

        public final String getSecId() {
            return this.secId;
        }

        public final Boolean isFollowed() {
            return this.isFollowed;
        }

        public final Boolean isLive() {
            return this.isLive;
        }

        public User(String r100, Avatar r101, String r102, Boolean r103, Boolean r104, String r105, String r106) {
            this.f170283id = r100;
            this.avatar = r101;
            this.nickname = r102;
            this.isFollowed = r103;
            this.isLive = r104;
            this.roomId = r105;
            this.secId = r106;
        }

        public /* synthetic */ User(String r100, Avatar r101, String r102, Boolean r110, Boolean r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
            if ((r114 & 1) == 0) goto L5;
            String r116 = null;
        L7:
            if ((r114 & 2) == 0) goto L9;
            Avatar r103 = null;
        L11:
            if ((r114 & 4) == 0) goto L13;
            String r104 = null;
        L15:
            if ((r114 & 8) == 0) goto L17;
            Boolean r105 = null;
        L19:
            if ((r114 & 16) == 0) goto L21;
            Boolean r106 = null;
        L23:
            if ((r114 & 32) == 0) goto L25;
            String r107 = null;
        L27:
            if ((r114 & 64) == 0) goto L29;
            String r117 = null;
        L30:
            this(r116, r103, r104, r105, r106, r107, r117);
            return;
        L29:
            r117 = r113;
            goto L30
        L25:
            r107 = r112;
            goto L27
        L21:
            r106 = r111;
            goto L23
        L17:
            r105 = r110;
            goto L19
        L13:
            r104 = r102;
            goto L15
        L9:
            r103 = r101;
            goto L11
        L5:
            r116 = r100;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "", "windVaneLynxData", "", "windVaneSchema", "appendMargin", "", "appendHeight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAppendHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAppendMargin", "getWindVaneLynxData", "()Ljava/lang/String;", "getWindVaneSchema", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WindVaneEventData {

        @SerializedName("append_height")
        private final Integer appendHeight;

        @SerializedName("append_margin")
        private final Integer appendMargin;

        @SerializedName("lynx_data")
        private final String windVaneLynxData;

        @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
        private final String windVaneSchema;

        public WindVaneEventData() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ WindVaneEventData copy$default(WindVaneEventData r100, String r101, String r102, Integer r103, Integer r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.windVaneLynxData;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.windVaneSchema;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.appendMargin;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.appendHeight;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.windVaneLynxData;
        }

        public final String component2() {
            return this.windVaneSchema;
        }

        public final Integer component3() {
            return this.appendMargin;
        }

        public final Integer component4() {
            return this.appendHeight;
        }

        public final WindVaneEventData copy(String r100, String r101, Integer r102, Integer r103) {
            return new WindVaneEventData(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof WindVaneEventData) == false) goto L14;
            WindVaneEventData r101 = (WindVaneEventData) r100;
            if (Intrinsics.areEqual(this.windVaneLynxData, r101.windVaneLynxData) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.windVaneSchema, r101.windVaneSchema) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.appendMargin, r101.appendMargin) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.appendHeight, r101.appendHeight) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r100 = this.windVaneLynxData;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.windVaneSchema;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.appendMargin;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.appendHeight;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
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
            return "WindVaneEventData(windVaneLynxData=" + this.windVaneLynxData + ", windVaneSchema=" + this.windVaneSchema + ", appendMargin=" + this.appendMargin + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Integer getAppendHeight() {
            return this.appendHeight;
        }

        public final Integer getAppendMargin() {
            return this.appendMargin;
        }

        public final String getWindVaneLynxData() {
            return this.windVaneLynxData;
        }

        public final String getWindVaneSchema() {
            return this.windVaneSchema;
        }

        public WindVaneEventData(String r100, String r101, Integer r102, Integer r103) {
            this.windVaneLynxData = r100;
            this.windVaneSchema = r101;
            this.appendMargin = r102;
            this.appendHeight = r103;
        }

        public /* synthetic */ WindVaneEventData(String r100, String r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    public CommonData() {
    }
}
