package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0015B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/action/Impression;", "", "componentId", "", "impressionList", "", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/action/Impression$ImpressionItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getComponentId", "()Ljava/lang/String;", "getImpressionList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ImpressionItem", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Impression {

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("impression_list")
    private final List<ImpressionItem> impressionList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/action/Impression$ImpressionItem;", "", "id", "", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/action/Impression$ImpressionItem;", "equals", "", "other", "hashCode", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ImpressionItem {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private final String f177588id;

        @SerializedName("type")
        private final Integer type;

        /* JADX WARN: Multi-variable type inference failed */
        public ImpressionItem() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ImpressionItem copy$default(ImpressionItem r100, String r101, Integer r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f177588id;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.type;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.f177588id;
        }

        public final Integer component2() {
            return this.type;
        }

        public final ImpressionItem copy(String r100, Integer r101) {
            return new ImpressionItem(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ImpressionItem) == false) goto L10;
            ImpressionItem r101 = (ImpressionItem) r100;
            if (Intrinsics.areEqual(this.f177588id, r101.f177588id) == true) goto L8;
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
            String r100 = this.f177588id;
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
            return "ImpressionItem(id=" + this.f177588id + ", type=" + this.type + ")";
        }

        public final String getId() {
            return this.f177588id;
        }

        public final Integer getType() {
            return this.type;
        }

        public ImpressionItem(String r100, Integer r101) {
            this.f177588id = r100;
            this.type = r101;
        }

        public /* synthetic */ ImpressionItem(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Impression() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Impression copy$default(Impression r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.componentId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.impressionList;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.componentId;
    }

    public final List<ImpressionItem> component2() {
        return this.impressionList;
    }

    public final Impression copy(String r100, List<ImpressionItem> r101) {
        return new Impression(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Impression) == false) goto L10;
        Impression r101 = (Impression) r100;
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.impressionList, r101.impressionList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.componentId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<ImpressionItem> r104 = this.impressionList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "Impression(componentId=" + this.componentId + ", impressionList=" + this.impressionList + ")";
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final List<ImpressionItem> getImpressionList() {
        return this.impressionList;
    }

    public Impression(String r100, List<ImpressionItem> r101) {
        this.componentId = r100;
        this.impressionList = r101;
    }

    public /* synthetic */ Impression(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
