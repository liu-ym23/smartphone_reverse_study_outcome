package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class CameraPositionCreator implements Parcelable.Creator<CameraPosition> {
    public CameraPositionCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CameraPosition createFromParcel(Parcel r100) {
        float r101 = r100.readFloat();
        float r102 = r100.readFloat();
        float r103 = r100.readFloat();
        float r104 = r100.readFloat();
        return new CameraPosition(new LatLng(r102, r103), r100.readFloat(), r104, r101);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ CameraPosition[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ CameraPosition createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CameraPosition[] newArray(int r100) {
        return new CameraPosition[r100];
    }
}
