package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CameraPositionCreator implements Parcelable.Creator<CameraPosition> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CameraPosition createFromParcel(Parcel parcel) {
        float f10 = parcel.readFloat();
        float f11 = parcel.readFloat();
        float f12 = parcel.readFloat();
        return new CameraPosition(new LatLng(f11, f12), parcel.readFloat(), parcel.readFloat(), f10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CameraPosition[] newArray(int i10) {
        return new CameraPosition[i10];
    }
}
