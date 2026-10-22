package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/model/response/CarouselDetailInfo;", "Ljava/io/Serializable;", "type", "", "detailInfo", "Lcom/bytedance/android/ec/model/response/ECFloatWindowDetailInfo;", "eventParams", "", "", "(Ljava/lang/Integer;Lcom/bytedance/android/ec/model/response/ECFloatWindowDetailInfo;Ljava/util/Map;)V", "getDetailInfo", "()Lcom/bytedance/android/ec/model/response/ECFloatWindowDetailInfo;", "getEventParams", "()Ljava/util/Map;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Lcom/bytedance/android/ec/model/response/ECFloatWindowDetailInfo;Ljava/util/Map;)Lcom/bytedance/android/ec/model/response/CarouselDetailInfo;", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CarouselDetailInfo implements Serializable {

    @SerializedName("detail_info")
    private final ECFloatWindowDetailInfo detailInfo;

    @SerializedName("event_param")
    private final Map<String, String> eventParams;

    @SerializedName("type")
    private final Integer type;

    public CarouselDetailInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CarouselDetailInfo copy$default(CarouselDetailInfo r100, Integer r101, ECFloatWindowDetailInfo r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.detailInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.eventParams;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.type;
    }

    public final ECFloatWindowDetailInfo component2() {
        return this.detailInfo;
    }

    public final Map<String, String> component3() {
        return this.eventParams;
    }

    public final CarouselDetailInfo copy(Integer r100, ECFloatWindowDetailInfo r101, Map<String, String> r102) {
        return new CarouselDetailInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CarouselDetailInfo) == false) goto L12;
        CarouselDetailInfo r101 = (CarouselDetailInfo) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.detailInfo, r101.detailInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L19;
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
        ECFloatWindowDetailInfo r104 = this.detailInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.eventParams;
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
        return "CarouselDetailInfo(type=" + this.type + ", detailInfo=" + this.detailInfo + ", eventParams=" + this.eventParams + ")";
    }

    public final ECFloatWindowDetailInfo getDetailInfo() {
        return this.detailInfo;
    }

    public final Map<String, String> getEventParams() {
        return this.eventParams;
    }

    public final Integer getType() {
        return this.type;
    }

    public CarouselDetailInfo(Integer r100, ECFloatWindowDetailInfo r101, Map<String, String> r102) {
        this.type = r100;
        this.detailInfo = r101;
        this.eventParams = r102;
    }

    public /* synthetic */ CarouselDetailInfo(Integer r100, ECFloatWindowDetailInfo r101, Map r102, int r103, DefaultConstructorMarker r104) {
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
