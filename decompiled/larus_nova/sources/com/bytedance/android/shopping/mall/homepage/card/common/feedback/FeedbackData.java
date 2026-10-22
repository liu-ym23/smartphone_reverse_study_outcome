package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData;", "", "negFeedbackStyles", "Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackStyles;", "successMsg", "", "(Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackStyles;Ljava/lang/String;)V", "getNegFeedbackStyles", "()Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackStyles;", "getSuccessMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Item", "NegFeedbackElement", "NegFeedbackStyles", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackData {

    @SerializedName("neg_feedback_styles")
    private final NegFeedbackStyles negFeedbackStyles;

    @SerializedName("success_msg")
    private final String successMsg;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$Item;", "", "text", "", "icon", "type", "", "abbr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAbbr", "()Ljava/lang/String;", "getIcon", "getText", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$Item;", "equals", "", "other", "hashCode", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Item {

        @SerializedName("abbr")
        private final String abbr;

        @SerializedName("icon")
        private final String icon;

        @SerializedName("text")
        private final String text;

        @SerializedName("type")
        private final Integer type;

        public Item() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Item copy$default(Item r100, String r101, String r102, Integer r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.text;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.icon;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.type;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.abbr;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.icon;
        }

        public final Integer component3() {
            return this.type;
        }

        public final String component4() {
            return this.abbr;
        }

        public final Item copy(String r100, String r101, Integer r102, String r103) {
            return new Item(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Item) == false) goto L14;
            Item r101 = (Item) r100;
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.abbr, r101.abbr) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            String r100 = this.text;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.icon;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.type;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.abbr;
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
            return "Item(text=" + this.text + ", icon=" + this.icon + ", type=" + this.type + ", abbr=" + this.abbr + ")";
        }

        public final String getAbbr() {
            return this.abbr;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getText() {
            return this.text;
        }

        public final Integer getType() {
            return this.type;
        }

        public Item(String r100, String r101, Integer r102, String r103) {
            this.text = r100;
            this.icon = r101;
            this.type = r102;
            this.abbr = r103;
        }

        public /* synthetic */ Item(String r100, String r101, Integer r102, String r103, int r104, DefaultConstructorMarker r105) {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u000f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;", "", "items", "", "Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$Item;", "firstPageLimit", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getFirstPageLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;", "equals", "", "other", "hashCode", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NegFeedbackElement {

        @SerializedName("first_page_limit")
        private final Integer firstPageLimit;

        @SerializedName("items")
        private final List<Item> items;

        /* JADX WARN: Multi-variable type inference failed */
        public NegFeedbackElement() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NegFeedbackElement copy$default(NegFeedbackElement r100, List r101, Integer r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.items;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.firstPageLimit;
        L9:
            return r100.copy(r101, r102);
        }

        public final List<Item> component1() {
            return this.items;
        }

        public final Integer component2() {
            return this.firstPageLimit;
        }

        public final NegFeedbackElement copy(List<Item> r100, Integer r101) {
            return new NegFeedbackElement(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof NegFeedbackElement) == false) goto L10;
            NegFeedbackElement r101 = (NegFeedbackElement) r100;
            if (Intrinsics.areEqual(this.items, r101.items) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.firstPageLimit, r101.firstPageLimit) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            List<Item> r100 = this.items;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.firstPageLimit;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "NegFeedbackElement(items=" + this.items + ", firstPageLimit=" + this.firstPageLimit + ")";
        }

        public final Integer getFirstPageLimit() {
            return this.firstPageLimit;
        }

        public final List<Item> getItems() {
            return this.items;
        }

        public NegFeedbackElement(List<Item> r100, Integer r101) {
            this.items = r100;
            this.firstPageLimit = r101;
        }

        public /* synthetic */ NegFeedbackElement(List r100, Integer r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackStyles;", "", "type1", "Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;", "type2", "type4", "type7", "(Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;)V", "getType1", "()Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData$NegFeedbackElement;", "getType2", "getType4", "getType7", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NegFeedbackStyles {

        @SerializedName("1")
        private final NegFeedbackElement type1;

        @SerializedName("2")
        private final NegFeedbackElement type2;

        @SerializedName("4")
        private final NegFeedbackElement type4;

        @SerializedName("7")
        private final NegFeedbackElement type7;

        public NegFeedbackStyles() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ NegFeedbackStyles copy$default(NegFeedbackStyles r100, NegFeedbackElement r101, NegFeedbackElement r102, NegFeedbackElement r103, NegFeedbackElement r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.type1;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.type2;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.type4;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.type7;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final NegFeedbackElement component1() {
            return this.type1;
        }

        public final NegFeedbackElement component2() {
            return this.type2;
        }

        public final NegFeedbackElement component3() {
            return this.type4;
        }

        public final NegFeedbackElement component4() {
            return this.type7;
        }

        public final NegFeedbackStyles copy(NegFeedbackElement r100, NegFeedbackElement r101, NegFeedbackElement r102, NegFeedbackElement r103) {
            return new NegFeedbackStyles(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof NegFeedbackStyles) == false) goto L14;
            NegFeedbackStyles r101 = (NegFeedbackStyles) r100;
            if (Intrinsics.areEqual(this.type1, r101.type1) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.type2, r101.type2) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.type4, r101.type4) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type7, r101.type7) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            NegFeedbackElement r100 = this.type1;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            NegFeedbackElement r104 = this.type2;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            NegFeedbackElement r107 = this.type4;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            NegFeedbackElement r110 = this.type7;
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
            return "NegFeedbackStyles(type1=" + this.type1 + ", type2=" + this.type2 + ", type4=" + this.type4 + ", type7=" + this.type7 + ")";
        }

        public final NegFeedbackElement getType1() {
            return this.type1;
        }

        public final NegFeedbackElement getType2() {
            return this.type2;
        }

        public final NegFeedbackElement getType4() {
            return this.type4;
        }

        public final NegFeedbackElement getType7() {
            return this.type7;
        }

        public NegFeedbackStyles(NegFeedbackElement r100, NegFeedbackElement r101, NegFeedbackElement r102, NegFeedbackElement r103) {
            this.type1 = r100;
            this.type2 = r101;
            this.type4 = r102;
            this.type7 = r103;
        }

        public /* synthetic */ NegFeedbackStyles(NegFeedbackElement r100, NegFeedbackElement r101, NegFeedbackElement r102, NegFeedbackElement r103, int r104, DefaultConstructorMarker r105) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FeedbackData copy$default(FeedbackData r100, NegFeedbackStyles r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.negFeedbackStyles;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.successMsg;
    L9:
        return r100.copy(r101, r102);
    }

    public final NegFeedbackStyles component1() {
        return this.negFeedbackStyles;
    }

    public final String component2() {
        return this.successMsg;
    }

    public final FeedbackData copy(NegFeedbackStyles r100, String r101) {
        return new FeedbackData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FeedbackData) == false) goto L10;
        FeedbackData r101 = (FeedbackData) r100;
        if (Intrinsics.areEqual(this.negFeedbackStyles, r101.negFeedbackStyles) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.successMsg, r101.successMsg) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        NegFeedbackStyles r100 = this.negFeedbackStyles;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.successMsg;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FeedbackData(negFeedbackStyles=" + this.negFeedbackStyles + ", successMsg=" + this.successMsg + ")";
    }

    public final NegFeedbackStyles getNegFeedbackStyles() {
        return this.negFeedbackStyles;
    }

    public final String getSuccessMsg() {
        return this.successMsg;
    }

    public FeedbackData(NegFeedbackStyles r100, String r101) {
        this.negFeedbackStyles = r100;
        this.successMsg = r101;
    }

    public /* synthetic */ FeedbackData(NegFeedbackStyles r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
