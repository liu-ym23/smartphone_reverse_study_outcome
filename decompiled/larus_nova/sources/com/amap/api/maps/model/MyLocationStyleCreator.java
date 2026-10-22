package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class MyLocationStyleCreator implements Parcelable.Creator<MyLocationStyle> {
    public MyLocationStyleCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MyLocationStyle createFromParcel(Parcel r100) {
        MyLocationStyle r101 = new MyLocationStyle();
        r101.myLocationIcon((BitmapDescriptor) r100.readParcelable(BitmapDescriptor.class.getClassLoader()));
        r101.anchor(r100.readFloat(), r100.readFloat());
        r101.radiusFillColor(r100.readInt());
        r101.strokeColor(r100.readInt());
        r101.strokeWidth(r100.readFloat());
        r101.myLocationType(r100.readInt());
        r101.interval(r100.readLong());
        r101.setZIndex(r100.readInt());
        boolean[] r102 = new boolean[1];
        r100.readBooleanArray(r102);
        r101.showMyLocation(r102[0]);
        return r101;
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ MyLocationStyle[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ MyLocationStyle createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MyLocationStyle[] newArray(int r100) {
        return new MyLocationStyle[r100];
    }
}
