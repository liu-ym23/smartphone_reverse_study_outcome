package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JP\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "Ljava/io/Serializable;", "title", "", "icon", "width", "", "height", "images", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()Ljava/lang/String;", "getImages", "()Ljava/util/List;", "getTitle", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/android/ec/common/impl/sku/model/SpecChartStruct;", "equals", "", "other", "", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecChartStruct implements Serializable {

    @SerializedName("height")
    private final Integer height;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("images")
    private final List<ECUrlModel> images;

    @SerializedName("text")
    private final String title;

    @SerializedName("width")
    private final Integer width;

    public SpecChartStruct() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpecChartStruct copy$default(SpecChartStruct r100, String r101, String r102, Integer r103, Integer r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.icon;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.width;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.height;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.images;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.icon;
    }

    public final Integer component3() {
        return this.width;
    }

    public final Integer component4() {
        return this.height;
    }

    public final List<ECUrlModel> component5() {
        return this.images;
    }

    public final SpecChartStruct copy(String r100, String r101, Integer r110, Integer r111, List<? extends ECUrlModel> r112) {
        return new SpecChartStruct(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SpecChartStruct) == false) goto L16;
        SpecChartStruct r101 = (SpecChartStruct) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.title;
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
        Integer r107 = this.width;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.height;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<ECUrlModel> r113 = this.images;
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
        return "SpecChartStruct(title=" + this.title + ", icon=" + this.icon + ", width=" + this.width + ", height=" + this.height + ", images=" + this.images + ")";
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final List<ECUrlModel> getImages() {
        return this.images;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpecChartStruct(String r100, String r101, Integer r102, Integer r103, List<? extends ECUrlModel> r104) {
        this.title = r100;
        this.icon = r101;
        this.width = r102;
        this.height = r103;
        this.images = r104;
    }

    public /* synthetic */ SpecChartStruct(String r100, String r101, Integer r102, Integer r103, List r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Integer r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        List r113 = null;
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
