package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.legou.NewerOneOff;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u00039:;B\u008f\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rHÆ\u0003J\u0093\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u000bHÖ\u0001R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006<"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData;", "", "toolList", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ToolList;", "searchCart", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "channelCards", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;", "middleArea", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$MiddleArea;", "bffEcomSceneId", "", "activityListECPerf", "", "tooListECPerf", "btmData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "cycleActivityList", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "newerOneOff", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/legou/NewerOneOff;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ToolList;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$MiddleArea;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/legou/NewerOneOff;)V", "getActivityListECPerf", "()Ljava/util/List;", "getBffEcomSceneId", "()Ljava/lang/String;", "getBtmData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "getChannelCards", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;", "getCycleActivityList", "getMiddleArea", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$MiddleArea;", "getNewerOneOff", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/legou/NewerOneOff;", "getSearchCart", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "getTooListECPerf", "getToolList", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ToolList;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "ChannelCards", "MiddleArea", "ToolList", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderCardData {

    @SerializedName("activity_list_ec_perf")
    private final List<String> activityListECPerf;

    @SerializedName("bff_ecom_scene_id")
    private final String bffEcomSceneId;

    @SerializedName("btm_data")
    private final BtmData btmData;

    @SerializedName("channel_cards")
    private final ChannelCards channelCards;

    @SerializedName("cycle_activity")
    private final List<ChannelVO> cycleActivityList;

    @SerializedName("middle_area")
    private final MiddleArea middleArea;

    @SerializedName("newer_one_off")
    private final NewerOneOff newerOneOff;

    @SerializedName("search_cart")
    private final ToolVO searchCart;

    @SerializedName("tool_list_ec_perf")
    private final List<String> tooListECPerf;

    @SerializedName("tool_list")
    private final ToolList toolList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\f\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR(\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;", "", "data", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "btmData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "(Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;)V", "getBtmData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChannelCards {

        @SerializedName("btm")
        private final BtmData btmData;

        @SerializedName("cards")
        private final List<List<ChannelVO>> data;

        /* JADX WARN: Multi-variable type inference failed */
        public ChannelCards() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelCards copy$default(ChannelCards r100, List r101, BtmData r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.btmData;
        L9:
            return r100.copy(r101, r102);
        }

        public final List<List<ChannelVO>> component1() {
            return this.data;
        }

        public final BtmData component2() {
            return this.btmData;
        }

        public final ChannelCards copy(List<? extends List<ChannelVO>> r100, BtmData r101) {
            return new ChannelCards(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ChannelCards) == false) goto L10;
            ChannelCards r101 = (ChannelCards) r100;
            if (Intrinsics.areEqual(this.data, r101.data) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.btmData, r101.btmData) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            List<List<ChannelVO>> r100 = this.data;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            BtmData r104 = this.btmData;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "ChannelCards(data=" + this.data + ", btmData=" + this.btmData + ")";
        }

        public final BtmData getBtmData() {
            return this.btmData;
        }

        public final List<List<ChannelVO>> getData() {
            return this.data;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ChannelCards(List<? extends List<ChannelVO>> r100, BtmData r101) {
            this.data = r100;
            this.btmData = r101;
        }

        public /* synthetic */ ChannelCards(List r100, BtmData r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$MiddleArea;", "", "activityList", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;)V", "getActivityList", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ChannelCards;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MiddleArea {

        @SerializedName("activity_list")
        private final ChannelCards activityList;

        /* JADX WARN: Multi-variable type inference failed */
        public MiddleArea() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ MiddleArea copy$default(MiddleArea r100, ChannelCards r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.activityList;
        L6:
            return r100.copy(r101);
        }

        public final ChannelCards component1() {
            return this.activityList;
        }

        public final MiddleArea copy(ChannelCards r100) {
            return new MiddleArea(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof MiddleArea) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.activityList, ((MiddleArea) r100).activityList) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            ChannelCards r100 = this.activityList;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "MiddleArea(activityList=" + this.activityList + ")";
        }

        public final ChannelCards getActivityList() {
            return this.activityList;
        }

        public MiddleArea(ChannelCards r100) {
            this.activityList = r100;
        }

        public /* synthetic */ MiddleArea(ChannelCards r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/HeaderCardData$ToolList;", "", "data", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ToolList {

        @SerializedName("data")
        private final List<ToolVO> data;

        /* JADX WARN: Multi-variable type inference failed */
        public ToolList() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ToolList copy$default(ToolList r100, List r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            return r100.copy(r101);
        }

        public final List<ToolVO> component1() {
            return this.data;
        }

        public final ToolList copy(List<ToolVO> r100) {
            return new ToolList(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ToolList) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.data, ((ToolList) r100).data) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            List<ToolVO> r100 = this.data;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "ToolList(data=" + this.data + ")";
        }

        public final List<ToolVO> getData() {
            return this.data;
        }

        public ToolList(List<ToolVO> r100) {
            this.data = r100;
        }

        public /* synthetic */ ToolList(List r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    public HeaderCardData() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderCardData copy$default(HeaderCardData r110, ToolList r111, ToolVO r112, ChannelCards r113, MiddleArea r114, String r115, List r116, List r117, BtmData r118, List r210, NewerOneOff r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        ToolList r100 = r110.toolList;
    L7:
        if ((r212 & 2) == 0) goto L9;
        ToolVO r101 = r110.searchCart;
    L11:
        if ((r212 & 4) == 0) goto L13;
        ChannelCards r102 = r110.channelCards;
    L15:
        if ((r212 & 8) == 0) goto L17;
        MiddleArea r103 = r110.middleArea;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.bffEcomSceneId;
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r105 = r110.activityListECPerf;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r106 = r110.tooListECPerf;
    L31:
        if ((r212 & 128) == 0) goto L33;
        BtmData r107 = r110.btmData;
    L35:
        if ((r212 & 256) == 0) goto L37;
        List r119 = r110.cycleActivityList;
    L39:
        if ((r212 & 512) == 0) goto L41;
        NewerOneOff r108 = r110.newerOneOff;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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

    public final ToolList component1() {
        return this.toolList;
    }

    public final NewerOneOff component10() {
        return this.newerOneOff;
    }

    public final ToolVO component2() {
        return this.searchCart;
    }

    public final ChannelCards component3() {
        return this.channelCards;
    }

    public final MiddleArea component4() {
        return this.middleArea;
    }

    public final String component5() {
        return this.bffEcomSceneId;
    }

    public final List<String> component6() {
        return this.activityListECPerf;
    }

    public final List<String> component7() {
        return this.tooListECPerf;
    }

    public final BtmData component8() {
        return this.btmData;
    }

    public final List<ChannelVO> component9() {
        return this.cycleActivityList;
    }

    public final HeaderCardData copy(ToolList r110, ToolVO r111, ChannelCards r112, MiddleArea r113, String r114, List<String> r115, List<String> r116, BtmData r210, List<ChannelVO> r211, NewerOneOff r212) {
        return new HeaderCardData(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeaderCardData) == false) goto L26;
        HeaderCardData r101 = (HeaderCardData) r100;
        if (Intrinsics.areEqual(this.toolList, r101.toolList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.searchCart, r101.searchCart) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.channelCards, r101.channelCards) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.middleArea, r101.middleArea) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bffEcomSceneId, r101.bffEcomSceneId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.activityListECPerf, r101.activityListECPerf) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tooListECPerf, r101.tooListECPerf) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.btmData, r101.btmData) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.cycleActivityList, r101.cycleActivityList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.newerOneOff, r101.newerOneOff) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        ToolList r100 = this.toolList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ToolVO r104 = this.searchCart;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ChannelCards r107 = this.channelCards;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        MiddleArea r110 = this.middleArea;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.bffEcomSceneId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.activityListECPerf;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.tooListECPerf;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        BtmData r122 = this.btmData;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<ChannelVO> r125 = this.cycleActivityList;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        NewerOneOff r128 = this.newerOneOff;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
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
        return "HeaderCardData(toolList=" + this.toolList + ", searchCart=" + this.searchCart + ", channelCards=" + this.channelCards + ", middleArea=" + this.middleArea + ", bffEcomSceneId=" + this.bffEcomSceneId + ", activityListECPerf=" + this.activityListECPerf + ", tooListECPerf=" + this.tooListECPerf + ", btmData=" + this.btmData + ", cycleActivityList=" + this.cycleActivityList + ", newerOneOff=" + this.newerOneOff + ")";
    }

    public final List<String> getActivityListECPerf() {
        return this.activityListECPerf;
    }

    public final String getBffEcomSceneId() {
        return this.bffEcomSceneId;
    }

    public final BtmData getBtmData() {
        return this.btmData;
    }

    public final ChannelCards getChannelCards() {
        return this.channelCards;
    }

    public final List<ChannelVO> getCycleActivityList() {
        return this.cycleActivityList;
    }

    public final MiddleArea getMiddleArea() {
        return this.middleArea;
    }

    public final NewerOneOff getNewerOneOff() {
        return this.newerOneOff;
    }

    public final ToolVO getSearchCart() {
        return this.searchCart;
    }

    public final List<String> getTooListECPerf() {
        return this.tooListECPerf;
    }

    public final ToolList getToolList() {
        return this.toolList;
    }

    public HeaderCardData(ToolList r100, ToolVO r101, ChannelCards r102, MiddleArea r103, String r104, List<String> r105, List<String> r106, BtmData r107, List<ChannelVO> r108, NewerOneOff r110) {
        this.toolList = r100;
        this.searchCart = r101;
        this.channelCards = r102;
        this.middleArea = r103;
        this.bffEcomSceneId = r104;
        this.activityListECPerf = r105;
        this.tooListECPerf = r106;
        this.btmData = r107;
        this.cycleActivityList = r108;
        this.newerOneOff = r110;
    }

    public /* synthetic */ HeaderCardData(ToolList r110, ToolVO r111, ChannelCards r112, MiddleArea r113, String r114, List r115, List r116, BtmData r117, List r210, NewerOneOff r211, int r212, DefaultConstructorMarker r213) {
        NewerOneOff r100 = null;
        if ((r212 & 1) == 0) goto L5;
        ToolList r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        ToolVO r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        ChannelCards r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        MiddleArea r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        BtmData r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        List r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
