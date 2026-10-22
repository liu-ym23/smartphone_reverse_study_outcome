package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR2\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/bytedance/android/ec/model/response/ProductSelectPoiInfo;", "Ljava/io/Serializable;", "poiInfo", "", "equals", "", "poiId", "Ljava/lang/String;", "getPoiId", "()Ljava/lang/String;", "setPoiId", "(Ljava/lang/String;)V", "poiName", "getPoiName", "setPoiName", "", "distance", "Ljava/lang/Double;", "getDistance", "()Ljava/lang/Double;", "setDistance", "(Ljava/lang/Double;)V", "distanceDesc", "getDistanceDesc", "setDistanceDesc", "address", "getAddress", "setAddress", "poiPhone", "getPoiPhone", "setPoiPhone", "", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/Map;", "getParamsObj", "()Ljava/util/Map;", "setParamsObj", "(Ljava/util/Map;)V", "paramsObj", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ProductSelectPoiInfo implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Map<String, ? extends Object> f47914a;

    @SerializedName("address")
    private String address;

    @SerializedName("distance")
    private Double distance;

    @SerializedName("distance_desc")
    private String distanceDesc;

    @SerializedName("poi_id")
    private String poiId;

    @SerializedName("poi_name")
    private String poiName;

    @SerializedName("poi_phone")
    private String poiPhone;

    public ProductSelectPoiInfo() {
    }

    public final String getAddress() {
        return this.address;
    }

    public final Double getDistance() {
        return this.distance;
    }

    public final String getDistanceDesc() {
        return this.distanceDesc;
    }

    public final Map<String, Object> getParamsObj() {
        return this.f47914a;
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

    public final boolean equals(ProductSelectPoiInfo r100) {
        String r101 = this.poiId;
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.poiId;
    L7:
        if (Intrinsics.areEqual(r101, r103) == false) goto L20;
        String r104 = this.poiName;
        if (r100 == null) goto L11;
        String r105 = r100.poiName;
    L13:
        if (Intrinsics.areEqual(r104, r105) == false) goto L20;
        String r106 = this.distanceDesc;
        if (r100 == null) goto L18;
        r102 = r100.distanceDesc;
    L18:
        if (Intrinsics.areEqual(r106, r102) == false) goto L20;
        return true;
    L11:
        r105 = null;
    L20:
        return false;
    L5:
        r103 = null;
        goto L7
    }

    public final void setAddress(String r100) {
        this.address = r100;
    }

    public final void setDistance(Double r100) {
        this.distance = r100;
    }

    public final void setDistanceDesc(String r100) {
        this.distanceDesc = r100;
    }

    public final void setParamsObj(Map<String, ? extends Object> r100) {
        this.f47914a = r100;
    }

    public final void setPoiId(String r100) {
        this.poiId = r100;
    }

    public final void setPoiName(String r100) {
        this.poiName = r100;
    }

    public final void setPoiPhone(String r100) {
        this.poiPhone = r100;
    }
}
