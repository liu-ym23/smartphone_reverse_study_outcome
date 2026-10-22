package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/SelectPoiInfo;", "Ljava/io/Serializable;", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "distance", "", "getDistance", "()Ljava/lang/Long;", "Ljava/lang/Long;", "distanceDesc", "getDistanceDesc", "poiId", "getPoiId", "poiName", "getPoiName", "poiPhone", "getPoiPhone", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectPoiInfo implements Serializable {

    @SerializedName("address")
    private final String address;

    @SerializedName("distance")
    private final Long distance;

    @SerializedName("distance_desc")
    private final String distanceDesc;

    @SerializedName("poi_id")
    private final String poiId;

    @SerializedName("poi_name")
    private final String poiName;

    @SerializedName("poi_phone")
    private final String poiPhone;

    public SelectPoiInfo() {
    }

    public final String getAddress() {
        return this.address;
    }

    public final Long getDistance() {
        return this.distance;
    }

    public final String getDistanceDesc() {
        return this.distanceDesc;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final String getPoiPhone() {
        return this.poiPhone;
    }
}
