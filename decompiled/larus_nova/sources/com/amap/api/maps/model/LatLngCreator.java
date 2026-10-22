package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class LatLngCreator implements Parcelable.Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    public LatLngCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLng createFromParcel(Parcel r100) {
        double r101 = r100.readDouble();
        return new LatLng(r100.readDouble(), r101);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ LatLng[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ LatLng createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLng[] newArray(int r100) {
        return new LatLng[r100];
    }
}
