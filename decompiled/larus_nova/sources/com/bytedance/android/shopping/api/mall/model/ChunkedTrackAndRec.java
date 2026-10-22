package com.bytedance.android.shopping.api.mall.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECTrackDataDTO;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/ChunkedTrackAndRec;", "", "id", "", "recommendInfo", "trackData", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECTrackDataDTO;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECTrackDataDTO;)V", "getId", "()Ljava/lang/String;", "getRecommendInfo", "getTrackData", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECTrackDataDTO;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChunkedTrackAndRec {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f170569id;

    @SerializedName(a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;

    @SerializedName("track_data")
    private final ECTrackDataDTO trackData;

    public ChunkedTrackAndRec() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ChunkedTrackAndRec copy$default(ChunkedTrackAndRec r100, String r101, String r102, ECTrackDataDTO r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f170569id;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.recommendInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.trackData;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.f170569id;
    }

    public final String component2() {
        return this.recommendInfo;
    }

    public final ECTrackDataDTO component3() {
        return this.trackData;
    }

    public final ChunkedTrackAndRec copy(String r100, String r101, ECTrackDataDTO r102) {
        return new ChunkedTrackAndRec(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ChunkedTrackAndRec) == false) goto L12;
        ChunkedTrackAndRec r101 = (ChunkedTrackAndRec) r100;
        if (Intrinsics.areEqual(this.f170569id, r101.f170569id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.recommendInfo, r101.recommendInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.trackData, r101.trackData) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.f170569id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.recommendInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECTrackDataDTO r107 = this.trackData;
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
        return "ChunkedTrackAndRec(id=" + this.f170569id + ", recommendInfo=" + this.recommendInfo + ", trackData=" + this.trackData + ")";
    }

    public final String getId() {
        return this.f170569id;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final ECTrackDataDTO getTrackData() {
        return this.trackData;
    }

    public ChunkedTrackAndRec(String r100, String r101, ECTrackDataDTO r102) {
        this.f170569id = r100;
        this.recommendInfo = r101;
        this.trackData = r102;
    }

    public /* synthetic */ ChunkedTrackAndRec(String r100, String r101, ECTrackDataDTO r102, int r103, DefaultConstructorMarker r104) {
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
