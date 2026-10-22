package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class CloudItemDetail extends CloudItem {
    public static final Parcelable.Creator<CloudItemDetail> CREATOR = null;

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public CloudItemDetail(Parcel r100) {
        super(r100);
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
    }

    public CloudItemDetail(String r100, LatLonPoint r101, String r102, String r103) {
        super(r100, r101, r102, r103);
    }
}
